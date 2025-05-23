package com.tencent.smtt.sdk;

import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TbsHandlerThread extends BaseHandlerThread {

    /* renamed from: a, reason: collision with root package name */
    private static TbsHandlerThread f369121a;

    public TbsHandlerThread(String str) {
        super(str);
    }

    public static synchronized TbsHandlerThread getInstance() {
        TbsHandlerThread tbsHandlerThread;
        synchronized (TbsHandlerThread.class) {
            if (f369121a == null) {
                TbsHandlerThread tbsHandlerThread2 = new TbsHandlerThread("TbsHandlerThread");
                f369121a = tbsHandlerThread2;
                tbsHandlerThread2.start();
            }
            tbsHandlerThread = f369121a;
        }
        return tbsHandlerThread;
    }
}
