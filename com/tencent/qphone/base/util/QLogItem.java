package com.tencent.qphone.base.util;

import android.os.Process;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QLogItem extends BaseQLogItem {
    private static int sMaxPoolSize;
    private static QLogItem sPool;
    private static int sPoolSize;
    private static final Object sPoolSync = new Object();
    private boolean inPool;
    private QLogItem next;

    static {
        int i3;
        if (QLog.isDevelopLevel()) {
            i3 = 512;
        } else if (QLog.isColorLevel()) {
            i3 = 256;
        } else {
            i3 = 128;
        }
        sMaxPoolSize = i3;
    }

    static QLogItem obtain() {
        synchronized (sPoolSync) {
            QLogItem qLogItem = sPool;
            if (qLogItem != null) {
                sPool = qLogItem.next;
                qLogItem.next = null;
                qLogItem.inPool = false;
                sPoolSize--;
                return qLogItem;
            }
            return new QLogItem();
        }
    }

    static void setMaxPoolSize(int i3) {
        sMaxPoolSize = i3;
    }

    @Override // com.tencent.qphone.base.util.BaseQLogItem
    public void recycle() {
        if (!this.inPool) {
            super.recycle();
            this.inPool = true;
            synchronized (sPoolSync) {
                int i3 = sPoolSize;
                if (i3 < sMaxPoolSize) {
                    this.next = sPool;
                    sPool = this;
                    sPoolSize = i3 + 1;
                }
            }
            return;
        }
        throw new IllegalArgumentException("This LogItem cannot be recycled because it already in pool");
    }

    public static QLogItem obtain(byte b16, long j3, byte b17, String str, String str2, Throwable th5) {
        QLogItem obtain = obtain();
        obtain.androidLogLevel = b16;
        obtain.logTime = j3;
        obtain.threadId = (short) Process.myTid();
        obtain.curJavaThreadId = (short) Thread.currentThread().getId();
        obtain.tag = str;
        obtain.level = b17;
        obtain.f344405msg = str2;
        obtain.trace = th5;
        return obtain;
    }

    public static QLogItem obtain(byte b16, long j3, byte b17, String str, Throwable th5) {
        QLogItem obtain = obtain();
        obtain.androidLogLevel = b16;
        obtain.logTime = j3;
        obtain.threadId = (short) Process.myTid();
        obtain.curJavaThreadId = (short) Thread.currentThread().getId();
        obtain.tag = str;
        obtain.level = b17;
        obtain.trace = th5;
        return obtain;
    }
}
