package eu3;

import android.content.Context;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.smtt.sdk.QbSdk;

/* compiled from: P */
/* loaded from: classes23.dex */
public class b implements j {
    private static final String TAG = "Mini-QbSdkInitializer";

    @Override // eu3.j
    public void initX5(Context context, int i3) {
        if (!QbSdk.isTbsCoreInited()) {
            Object obj = new Object();
            QbSdk.initX5Environment(context, new a(obj));
            try {
                synchronized (obj) {
                    LockMethodProxy.wait(obj);
                }
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class a implements QbSdk.PreInitCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f397150a;

        a(Object obj) {
            this.f397150a = obj;
        }

        @Override // com.tencent.smtt.sdk.QbSdk.PreInitCallback
        public void onCoreInitFinished() {
            synchronized (this.f397150a) {
                this.f397150a.notifyAll();
            }
        }

        @Override // com.tencent.smtt.sdk.QbSdk.PreInitCallback
        public void onViewInitFinished(boolean z16) {
        }
    }
}
