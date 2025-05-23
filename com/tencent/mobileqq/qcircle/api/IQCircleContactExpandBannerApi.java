package com.tencent.mobileqq.qcircle.api;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import cooperation.vip.tianshu.TianShuMMKVConstant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\r\u001a\u00020\u0007H&J\b\u0010\u000e\u001a\u00020\u0007H&J\b\u0010\u000f\u001a\u00020\u0007H&J\b\u0010\u0010\u001a\u00020\u0007H&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/IQCircleContactExpandBannerApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW, "Landroid/view/View;", "context", "Landroid/content/Context;", "initView", "", "parentView", "Landroid/view/ViewGroup;", TianShuMMKVConstant.LicenseInfoKey.CAN_SHOW, "", "isEnable", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onPostThemeChanged", HippyScrollViewEventHelper.EVENT_TYPE_REFRESH, "onResume", "qcircle-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes16.dex */
public interface IQCircleContactExpandBannerApi extends QRouteApi {
    @Nullable
    View createView(@NotNull Context context);

    void initView(@Nullable ViewGroup parentView, boolean canShow);

    boolean isEnable();

    void onDestroy();

    void onPostThemeChanged();

    void onRefresh();

    void onResume();
}
