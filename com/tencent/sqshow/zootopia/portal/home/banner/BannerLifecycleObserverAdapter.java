package com.tencent.sqshow.zootopia.portal.home.banner;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u001b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0002H\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/sqshow/zootopia/portal/home/banner/BannerLifecycleObserverAdapter;", "Landroidx/lifecycle/LifecycleObserver;", "", "onStart", DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/sqshow/zootopia/portal/home/banner/b;", "d", "Lcom/tencent/sqshow/zootopia/portal/home/banner/b;", "mObserver", "Landroidx/lifecycle/LifecycleOwner;", "e", "Landroidx/lifecycle/LifecycleOwner;", "mLifecycleOwner", "<init>", "(Lcom/tencent/sqshow/zootopia/portal/home/banner/b;Landroidx/lifecycle/LifecycleOwner;)V", "f", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class BannerLifecycleObserverAdapter implements LifecycleObserver {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private b mObserver;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LifecycleOwner mLifecycleOwner;

    public BannerLifecycleObserverAdapter(b bVar, LifecycleOwner lifecycleOwner) {
        this.mObserver = bVar;
        this.mLifecycleOwner = lifecycleOwner;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        QLog.i("BannerLifecycleObserverAdapter", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        b bVar = this.mObserver;
        if (bVar != null) {
            bVar.onDestroy(this.mLifecycleOwner);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onStart() {
        QLog.i("BannerLifecycleObserverAdapter", 1, "onStart");
        b bVar = this.mObserver;
        if (bVar != null) {
            bVar.onStart(this.mLifecycleOwner);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        QLog.i("BannerLifecycleObserverAdapter", 1, DKHippyEvent.EVENT_STOP);
        b bVar = this.mObserver;
        if (bVar != null) {
            bVar.onStop(this.mLifecycleOwner);
        }
    }
}
