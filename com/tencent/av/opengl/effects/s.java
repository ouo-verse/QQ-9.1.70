package com.tencent.av.opengl.effects;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class s extends v {
    protected Handler D;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<s> f74041a;

        a(Looper looper, s sVar) {
            super(looper);
            this.f74041a = new WeakReference<>(sVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            s sVar = this.f74041a.get();
            if (sVar != null) {
                sVar.j(message);
            }
        }
    }

    public s() {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("OffscreenGLThread" + ((int) (Math.random() * 100.0d)));
        baseHandlerThread.start();
        this.D = new a(baseHandlerThread.getLooper(), this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.opengl.effects.v
    public void h() {
        super.h();
        Process.setThreadPriority(0);
        AVCoreLog.i("GLContextThread", "init:");
    }

    protected abstract void j(Message message);

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
        super.i();
        this.D.getLooper().quit();
    }
}
