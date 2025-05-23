package com.qq.e.tg;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class AbstractAD<T> {
    public String adType;

    /* renamed from: c, reason: collision with root package name */
    private T f40421c;

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f40419a = false;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f40420b = false;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface BasicADListener {
        void onNoAD(AdError adError);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final T a() {
        return this.f40421c;
    }

    protected abstract T a(Context context, POFactory pOFactory, String str, String str2);

    protected abstract void a(T t16);

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean b() {
        return this.f40419a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean c() {
        return this.f40420b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(final Context context, final String str, final String str2, final BasicADListener basicADListener) {
        this.f40420b = true;
        GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.tg.AbstractAD.1
            @Override // java.lang.Runnable
            public void run() {
                AbstractAD abstractAD;
                BasicADListener basicADListener2;
                int i3;
                if (GDTADManager.getInstance().initWith(context, str)) {
                    try {
                        final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory(AbstractAD.this.adType);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.tg.AbstractAD.1.1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    POFactory pOFactory2 = pOFactory;
                                    if (pOFactory2 != null) {
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        AbstractAD abstractAD2 = AbstractAD.this;
                                        abstractAD2.f40421c = abstractAD2.a(context, pOFactory2, str, str2);
                                        AbstractAD.a(AbstractAD.this, true);
                                        AbstractAD abstractAD3 = AbstractAD.this;
                                        abstractAD3.a((AbstractAD) abstractAD3.f40421c);
                                        return;
                                    }
                                    AbstractAD.a(AbstractAD.this, true);
                                    AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                    AbstractAD.this.a(basicADListener, AdErrorConvertor.ErrorCode.PLUGIN_INIT_ERROR);
                                } catch (Throwable th5) {
                                    GDTLogger.e("Exception while init Core", th5);
                                    GDTADManager.getInstance().getPM().autoRollbackPlugin(th5.toString());
                                    AbstractAD.a(AbstractAD.this, true);
                                    AnonymousClass1 anonymousClass13 = AnonymousClass1.this;
                                    AbstractAD.this.a(basicADListener, 2001);
                                }
                            }
                        });
                        return;
                    } catch (Throwable th5) {
                        GDTLogger.e("Exception while init plugin", th5);
                        abstractAD = AbstractAD.this;
                        basicADListener2 = basicADListener;
                        i3 = AdErrorConvertor.ErrorCode.PLUGIN_INIT_ERROR;
                    }
                } else {
                    GDTLogger.e("Fail to init ADManager");
                    abstractAD = AbstractAD.this;
                    basicADListener2 = basicADListener;
                    i3 = AdErrorConvertor.ErrorCode.AD_MANAGER_INIT_ERROR;
                }
                abstractAD.a(basicADListener2, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(BasicADListener basicADListener, int i3) {
        if (basicADListener != null) {
            basicADListener.onNoAD(AdErrorConvertor.formatErrorCode(i3));
        }
    }

    static /* synthetic */ boolean a(AbstractAD abstractAD, boolean z16) {
        abstractAD.f40419a = true;
        return true;
    }
}
