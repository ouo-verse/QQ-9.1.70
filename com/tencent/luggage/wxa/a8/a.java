package com.tencent.luggage.wxa.a8;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.luggage.wxa.uk.h0;
import com.tencent.luggage.wxa.xd.g;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    private static final String TAG = "MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons";

    @NonNull
    private final com.tencent.luggage.wxa.xd.t mEventFactory;

    @NonNull
    private final com.tencent.luggage.wxa.k8.a mPluginHandler;

    @Nullable
    private WeakReference<com.tencent.luggage.wxa.kj.v> mPageViewRef = null;
    protected boolean mIsNeedNotify = false;
    protected boolean mIsAutoRotationEnabled = false;
    private boolean mIsOrientationChangedListening = false;
    private com.tencent.luggage.wxa.xj.j mOrientationObserver = null;
    private g.c mOnDestroyListener = null;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.a8.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C5990a implements com.tencent.luggage.wxa.xj.j {
        public C5990a() {
        }

        @Override // com.tencent.luggage.wxa.xj.j
        public void a(h0.a aVar) {
            com.tencent.luggage.wxa.tn.w.a(a.TAG, "onOrientationChanged, orientation: " + aVar);
            if (!a.this.isInForeground()) {
                com.tencent.luggage.wxa.tn.w.d(a.TAG, "onOrientationChanged, not in foreground");
                return;
            }
            a aVar2 = a.this;
            if (aVar2.mIsNeedNotify && aVar2.mIsAutoRotationEnabled) {
                if (aVar2.mPageViewRef == null) {
                    com.tencent.luggage.wxa.tn.w.f(a.TAG, "onOrientationChanged, mPageViewRef is null");
                    return;
                }
                com.tencent.luggage.wxa.kj.v vVar = (com.tencent.luggage.wxa.kj.v) a.this.mPageViewRef.get();
                if (vVar == null) {
                    com.tencent.luggage.wxa.tn.w.f(a.TAG, "onOrientationChanged, thePageView is null");
                    return;
                }
                com.tencent.luggage.wxa.wj.c n06 = vVar.getRuntime().n0();
                if (n06 != null && n06.shouldInLargeScreenCompatMode()) {
                    com.tencent.luggage.wxa.tn.w.d(a.TAG, "onOrientationChanged: disable autoRotationEnabled for pad compat mode");
                    return;
                } else {
                    a.this.mEventFactory.createAppBrandOnVideoOrientationChanged().a(vVar, a.this.mPluginHandler.getId(), aVar);
                    return;
                }
            }
            com.tencent.luggage.wxa.tn.w.a(a.TAG, "onOrientationChanged, mIsNeedNotify: " + a.this.mIsNeedNotify + ", mIsAutoRotationEnabled: " + a.this.mIsAutoRotationEnabled);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements g.c {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.xd.g.c
        public void onDestroy() {
            com.tencent.luggage.wxa.tn.w.a(a.TAG, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
            if (a.this.mPageViewRef == null) {
                com.tencent.luggage.wxa.tn.w.f(a.TAG, "onDestroy, mPageViewRef is null");
                return;
            }
            com.tencent.luggage.wxa.kj.v vVar = (com.tencent.luggage.wxa.kj.v) a.this.mPageViewRef.get();
            if (vVar == null) {
                com.tencent.luggage.wxa.tn.w.f(a.TAG, "onDestroy, thePageView is null");
                return;
            }
            Activity a06 = vVar.a0();
            if (a06 == null) {
                com.tencent.luggage.wxa.tn.w.f(a.TAG, "onDestroy, null == activity");
            } else {
                com.tencent.luggage.wxa.xj.i.a(a06).b(a.this.mOrientationObserver);
                vVar.b(a.this.mOnDestroyListener);
            }
        }
    }

    public a(com.tencent.luggage.wxa.k8.a aVar, com.tencent.luggage.wxa.xd.t tVar) {
        this.mPluginHandler = aVar;
        this.mEventFactory = tVar;
    }

    public final void a(com.tencent.luggage.wxa.kj.v vVar) {
        if (this.mIsOrientationChangedListening) {
            return;
        }
        if (this.mOrientationObserver == null) {
            this.mOrientationObserver = new C5990a();
            this.mOnDestroyListener = new b();
        }
        Activity a06 = vVar.a0();
        if (a06 == null) {
            com.tencent.luggage.wxa.tn.w.f(TAG, "listenOrientationChanged, null == activity");
            return;
        }
        com.tencent.luggage.wxa.xj.i.a(a06).a(this.mOrientationObserver);
        vVar.a(this.mOnDestroyListener);
        this.mIsOrientationChangedListening = true;
    }

    public abstract void handleJsApi(String str, com.tencent.luggage.wxa.z7.c cVar);

    public abstract boolean isInForeground();

    public void setPageView(com.tencent.luggage.wxa.z7.c cVar) {
        com.tencent.luggage.wxa.kj.v vVar;
        if (this.mPageViewRef != null) {
            return;
        }
        com.tencent.luggage.wxa.xd.d e16 = cVar.e();
        if (!(e16 instanceof com.tencent.luggage.wxa.kj.v)) {
            com.tencent.luggage.wxa.tn.w.f(TAG, "setPageView, component(" + e16 + ") is not AppBrandPageView");
            if (!(e16 instanceof com.tencent.luggage.wxa.ic.l)) {
                com.tencent.luggage.wxa.tn.w.f(TAG, "setPageView, component(" + e16 + ") is not AppBrandService");
                return;
            }
            vVar = ((com.tencent.luggage.wxa.ic.l) e16).J();
        } else {
            vVar = (com.tencent.luggage.wxa.kj.v) e16;
        }
        a(vVar);
        this.mPageViewRef = new WeakReference<>(vVar);
    }
}
