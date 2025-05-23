package com.tencent.mobileqq.zplan.aio;

import android.app.Activity;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QRouteFactory(singleton = false)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nH&J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0003H&J\b\u0010\u0013\u001a\u00020\u0003H&J\b\u0010\u0014\u001a\u00020\u0003H&J\b\u0010\u0015\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\u0003H&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0019H&J\b\u0010\u001c\u001a\u00020\u0003H&\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/IZPlanBadgeManager;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "hideEntrance", "", "init", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "conversationTitleBtnCtrl", "", "isEntranceShow", "", "onAccountChanged", "onBeforeAccountChanged", "onCreateView", "parentView", "Landroid/view/View;", "isFromBanner", MosaicConstants$JsFunction.FUNC_ON_DESTROY, MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onPostThemeChanged", "onResume", "refreshRedTouch", "resetVisibility", "setTitleEntranceImageAlpha", com.tencent.luggage.wxa.c8.c.f123400v, "", "setTitleEntranceImageColorFilter", "color", "updateVisibility", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanBadgeManager extends QRouteApi {
    void hideEntrance();

    void init(@NotNull Activity activity, @NotNull Object conversationTitleBtnCtrl);

    boolean isEntranceShow();

    void onAccountChanged();

    void onBeforeAccountChanged();

    void onCreateView(@NotNull View parentView, boolean isFromBanner);

    void onDestroy();

    void onPause();

    void onPostThemeChanged();

    void onResume();

    void refreshRedTouch();

    void resetVisibility();

    void setTitleEntranceImageAlpha(int alpha);

    void setTitleEntranceImageColorFilter(int color);

    void updateVisibility();
}
