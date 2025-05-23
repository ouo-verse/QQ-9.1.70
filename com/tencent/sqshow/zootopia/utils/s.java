package com.tencent.sqshow.zootopia.utils;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ$\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/sqshow/zootopia/utils/s;", "", "", "threadName", "", "priority", "Landroid/os/Handler$Callback;", "callback", "Landroid/os/Handler;", "a", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public static final s f373299a = new s();

    s() {
    }

    public final Handler a(String threadName, int priority, Handler.Callback callback) {
        try {
            HandlerThread handlerThread = new HandlerThread(threadName, priority);
            handlerThread.start();
            QLog.d("ThreadHandler", 1, "createNewThreadHandler success name:" + threadName + " priority:" + priority);
            return new Handler(handlerThread.getLooper(), callback);
        } catch (OutOfMemoryError e16) {
            QLog.d("ThreadHandler", 1, "createNewThreadHandler error:" + e16.getMessage() + ", priority:" + priority);
            return null;
        }
    }
}
