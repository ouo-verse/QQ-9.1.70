package com.tencent.mobileqq.vas.funcall;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@QRouteFactory(singleton = false)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vas/funcall/IVasFunCallKuikly;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "addFunCallVideo", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "peerUin", "", "fcId", "", "mute", "", "onConnected", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "vas-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"video"})
/* loaded from: classes20.dex */
public interface IVasFunCallKuikly extends QRouteApi {
    void addFunCallVideo(@NotNull Activity activity, @NotNull ViewGroup parent, @NotNull String peerUin, int fcId, boolean mute);

    void onConnected();

    void onDestroy();
}
