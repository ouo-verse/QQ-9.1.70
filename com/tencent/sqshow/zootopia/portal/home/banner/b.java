package com.tencent.sqshow.zootopia.portal.home.banner;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/sqshow/zootopia/portal/home/banner/b;", "Landroidx/lifecycle/LifecycleObserver;", "Landroidx/lifecycle/LifecycleOwner;", "owner", "", DKHippyEvent.EVENT_STOP, "onStart", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public interface b extends LifecycleObserver {
    void onDestroy(LifecycleOwner owner);

    void onStart(LifecycleOwner owner);

    void onStop(LifecycleOwner owner);
}
