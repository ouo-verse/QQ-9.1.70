package com.tencent.sqshow.zootopia.portal.home;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.Metadata;
import pa4.a;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u001b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0002H\u0007J\b\u0010\u0006\u001a\u00020\u0002H\u0007J\b\u0010\u0007\u001a\u00020\u0002H\u0007R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/sqshow/zootopia/portal/home/ParadiseLifecycleAdapter;", "Landroidx/lifecycle/LifecycleObserver;", "", "onStart", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lpa4/a;", "d", "Lpa4/a;", "mObserver", "Landroidx/lifecycle/LifecycleOwner;", "e", "Landroidx/lifecycle/LifecycleOwner;", "mLifecycleOwner", "<init>", "(Lpa4/a;Landroidx/lifecycle/LifecycleOwner;)V", "f", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ParadiseLifecycleAdapter implements LifecycleObserver {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private a mObserver;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LifecycleOwner mLifecycleOwner;

    public ParadiseLifecycleAdapter(a aVar, LifecycleOwner lifecycleOwner) {
        this.mObserver = aVar;
        this.mLifecycleOwner = lifecycleOwner;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        QLog.i("ParadiseLifecycleAdapter", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        a aVar = this.mObserver;
        if (aVar != null) {
            aVar.onDestroy(this.mLifecycleOwner);
        }
        a aVar2 = this.mObserver;
        if (aVar2 == null || (lifecycleOwner = this.mLifecycleOwner) == null || (lifecycle = lifecycleOwner.getLifecycle()) == null) {
            return;
        }
        lifecycle.removeObserver(aVar2);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        QLog.i("ParadiseLifecycleAdapter", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        a aVar = this.mObserver;
        if (aVar != null) {
            aVar.onPause(this.mLifecycleOwner);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        QLog.i("ParadiseLifecycleAdapter", 1, DKHippyEvent.EVENT_STOP);
        a aVar = this.mObserver;
        if (aVar != null) {
            aVar.onResume(this.mLifecycleOwner);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onStart() {
        QLog.i("ParadiseLifecycleAdapter", 1, "onStart");
        a aVar = this.mObserver;
        if (aVar != null) {
            aVar.onStart(this.mLifecycleOwner);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        QLog.i("ParadiseLifecycleAdapter", 1, DKHippyEvent.EVENT_STOP);
        a aVar = this.mObserver;
        if (aVar != null) {
            aVar.onStop(this.mLifecycleOwner);
        }
    }
}
