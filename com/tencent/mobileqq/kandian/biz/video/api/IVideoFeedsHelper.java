package com.tencent.mobileqq.kandian.biz.video.api;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.luggage.wxa.yf.e;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import m62.c;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J.\u0010\u0012\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0006H&J\u001a\u0010\u0017\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0015H&J\u0012\u0010\u0018\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH&J\u0012\u0010\u0019\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH&J$\u0010\u001c\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000eH&J$\u0010\u001d\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000eH&J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001a\u001a\u00020\bH&J\u001c\u0010!\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010 \u001a\u0004\u0018\u00010\u001fH&J\u0012\u0010#\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\"\u001a\u00020\u0015H&J\b\u0010$\u001a\u00020\bH&J\u001c\u0010)\u001a\u0004\u0018\u00010(2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010'\u001a\u00020\bH&J\u0014\u0010+\u001a\u0004\u0018\u00010*2\b\u0010\r\u001a\u0004\u0018\u00010\fH&J$\u0010/\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010.\u001a\u00020\bH&J.\u00101\u001a\u0004\u0018\u00010*2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010-\u001a\u0004\u0018\u00010,2\u0006\u00100\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\bH&J3\u00106\u001a\f\u0012\u0006\u0012\u0004\u0018\u000105\u0018\u0001042\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\bH&\u00a2\u0006\u0004\b6\u00107J\u0012\u00108\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u00109\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH&J\u0012\u0010:\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH&J\"\u0010<\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010;\u001a\u00020\b2\u0006\u0010'\u001a\u00020\bH&J\u001a\u0010=\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010;\u001a\u00020\bH&J\u0012\u0010>\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH&J\u0012\u0010?\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH&J\u0018\u0010C\u001a\u00020\n2\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020\u0006H&J*\u0010E\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010'\u001a\u00020\b2\u0006\u0010;\u001a\u00020\b2\u0006\u0010D\u001a\u00020\bH&J2\u0010E\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010;\u001a\u00020\b2\u0006\u0010'\u001a\u00020\b2\u0006\u0010F\u001a\u00020\b2\u0006\u0010D\u001a\u00020\bH&J\u0012\u0010I\u001a\u00020\b2\b\u0010H\u001a\u0004\u0018\u00010GH&J\u001c\u0010L\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010K\u001a\u0004\u0018\u00010JH&J\u001a\u0010N\u001a\u00020\n2\b\u0010H\u001a\u0004\u0018\u00010G2\u0006\u0010M\u001a\u00020\bH&J\u001c\u0010P\u001a\u00020\n2\b\u0010-\u001a\u0004\u0018\u00010,2\b\u0010O\u001a\u0004\u0018\u00010\u0013H&J\u0012\u0010Q\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH&J\u0014\u0010S\u001a\u0004\u0018\u00010\u000e2\b\u0010R\u001a\u0004\u0018\u00010\u000eH&\u00a8\u0006T"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoFeedsHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "", "isLazyLoad", "", IProfileCardConst.KEY_FROM_TYPE, "", "openVideoFeedsPlayActivity", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "vid", "url", "isH265", "openVideoFeedsPlayActivityForDebug", "Landroid/widget/TextView;", "textView", "", "timeMS", "setTimeTextForTextView", e.NAME, "hideBottomUIMenuImmersived", "count", RemoteHandleConst.PARAM_DEFAULT_VALUE, "commonSetCountToTextView", "commonSetCountToTextViewAsync", "commonCountToString", "Landroid/content/Intent;", "intent", "isIntentAvailable", "byteSize", "fileSizeToString", "getMainFeedsKingCardAutoPlayConfig", "Landroid/view/View;", "view", "duration", "Landroid/animation/Animator;", "performViewSlideUpAnim", "", "getScreenSize", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoInfo;", QCircleScheme.AttrDetail.VIDEO_INFO, "bottomOffset", "computeXYaxis", OpenHippyInfo.EXTRA_KEY_IS_FULL_SCREEN, "getLogoMarginSize", "videoWidth", "videoHeight", "", "", "calculateVideoAreaHeight", "(Landroid/app/Activity;II)[Ljava/lang/Object;", "isSystemAutoRotateOpen", "hideBottomUIMenu", "isPlayFeedsActivity", "visibility", "changeVisibilityWithAlphaAnimation", "changeVisibilityWithObjectAnimator", "isFullScreenDisplay", "calculateCommentViewGroupHeight", "Lm62/c;", "videoHolder", "needShow", "setFollowTextVisibility", "targetHeight", "performViewSlideDownAnimator", "delay", "Lmqq/app/AppRuntime;", "app", "getTodayShowCountForSoftAd", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UrlJumpInfo;", "jumpInfo", "resolveUrlJumpInfo", "newValue", "updateTodayShowCountForSoftAd", "titleTextView", "setRichTitle", "isVideoFeedsPlayActivity", "originUrl", "modifyVideoUrlForKingCard", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IVideoFeedsHelper extends QRouteApi {
    int calculateCommentViewGroupHeight(@Nullable Activity activity);

    @Nullable
    Object[] calculateVideoAreaHeight(@Nullable Activity activity, int videoWidth, int videoHeight);

    void changeVisibilityWithAlphaAnimation(@Nullable View view, int visibility, int duration);

    void changeVisibilityWithObjectAnimator(@Nullable View view, int visibility);

    @Nullable
    String commonCountToString(int count);

    void commonSetCountToTextView(@Nullable TextView textView, int count, @Nullable String defaultValue);

    void commonSetCountToTextViewAsync(@Nullable TextView textView, int count, @Nullable String defaultValue);

    int computeXYaxis(@Nullable Activity activity, @Nullable VideoInfo videoInfo, int bottomOffset);

    @Nullable
    String fileSizeToString(long byteSize);

    @Nullable
    int[] getLogoMarginSize(@Nullable Activity activity, @Nullable VideoInfo videoInfo, boolean isFullScreen, int bottomOffset);

    int getMainFeedsKingCardAutoPlayConfig();

    @Nullable
    int[] getScreenSize(@Nullable Activity activity);

    int getTodayShowCountForSoftAd(@Nullable AppRuntime app);

    void hideBottomUIMenu(@Nullable Activity activity);

    void hideBottomUIMenuImmersived(@Nullable Activity activity);

    void hideNavigationBar(@Nullable Activity activity);

    boolean isFullScreenDisplay(@Nullable Activity activity);

    boolean isIntentAvailable(@Nullable Context context, @Nullable Intent intent);

    boolean isPlayFeedsActivity(@Nullable Activity activity);

    boolean isSystemAutoRotateOpen(@Nullable Context context);

    boolean isVideoFeedsPlayActivity(@Nullable Activity activity);

    @Nullable
    String modifyVideoUrlForKingCard(@Nullable String originUrl);

    void openVideoFeedsPlayActivity(@Nullable Context context, @Nullable Bundle bundle, boolean isLazyLoad, int fromType);

    void openVideoFeedsPlayActivityForDebug(@Nullable Activity activity, @Nullable String vid, @Nullable String url, boolean isH265);

    void performViewSlideDownAnimator(@Nullable View view, int duration, int visibility, int targetHeight);

    void performViewSlideDownAnimator(@Nullable View view, int visibility, int duration, int delay, int targetHeight);

    @Nullable
    Animator performViewSlideUpAnim(@Nullable View view, int duration);

    void resolveUrlJumpInfo(@Nullable Context context, @Nullable UrlJumpInfo jumpInfo);

    void setFollowTextVisibility(@NotNull c videoHolder, boolean needShow);

    void setRichTitle(@Nullable VideoInfo videoInfo, @Nullable TextView titleTextView);

    void setTimeTextForTextView(@Nullable TextView textView, long timeMS);

    void updateTodayShowCountForSoftAd(@Nullable AppRuntime app, int newValue);
}
