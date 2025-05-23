package com.tencent.mobileqq.vas.adv.qzone.logic;

import android.app.Activity;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\u0006H&J\b\u0010\f\u001a\u00020\u0006H&J\b\u0010\r\u001a\u00020\u0006H&J\b\u0010\u000e\u001a\u00020\u0006H&J\b\u0010\u0010\u001a\u00020\u000fH&J\u0018\u0010\u0014\u001a\u00020\u00062\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H&\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/qzone/logic/IAlbumRecommendAdvController;", "", "Landroid/view/View;", "getView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "setOutActivity", "Lcom/tencent/mobileqq/vas/adv/common/data/AlumBasicData;", "advData", "initAndRenderData", "hideAdView", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "isAdClosed", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/vas/adv/qzone/logic/a;", "adReportEventListenerRef", "setAdReportEventListener", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public interface IAlbumRecommendAdvController {
    @NotNull
    View getView();

    void hideAdView();

    void initAndRenderData(@NotNull AlumBasicData advData);

    boolean isAdClosed();

    void onDestroy();

    void onPause();

    void onResume();

    void setAdReportEventListener(@Nullable WeakReference<a> adReportEventListenerRef);

    void setOutActivity(@NotNull Activity activity);
}
