package lm2;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements g {

    /* renamed from: a, reason: collision with root package name */
    Handler f415003a;

    /* renamed from: b, reason: collision with root package name */
    HandlerThread f415004b;

    public a() {
        a();
    }

    void a() {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("rich-psystem-thread");
        this.f415004b = baseHandlerThread;
        baseHandlerThread.start();
        this.f415003a = new Handler(this.f415004b.getLooper());
    }

    @Override // lm2.g
    public void post(Runnable runnable) {
        this.f415003a.post(runnable);
    }
}
