package com.tencent.mobileqq.kandian.biz.video.api.impl;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.luggage.wxa.yf.e;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m62.c;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bT\u0010UJ,\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J.\u0010\u0012\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u001a\u0010\u0017\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0012\u0010\u0018\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0019\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\u001c\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000eH\u0016J$\u0010\u001d\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001a\u001a\u00020\bH\u0016J\u001c\u0010!\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010#\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\"\u001a\u00020\u0015H\u0016J\b\u0010$\u001a\u00020\bH\u0016J\u001c\u0010)\u001a\u0004\u0018\u00010(2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010'\u001a\u00020\bH\u0016J\u0014\u0010+\u001a\u0004\u0018\u00010*2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J$\u0010/\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010.\u001a\u00020\bH\u0016J.\u00101\u001a\u0004\u0018\u00010*2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010-\u001a\u0004\u0018\u00010,2\u0006\u00100\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\bH\u0016J3\u00106\u001a\f\u0012\u0006\u0012\u0004\u0018\u000105\u0018\u0001042\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b6\u00107J\u0012\u00108\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u00109\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010:\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\"\u0010<\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010;\u001a\u00020\b2\u0006\u0010'\u001a\u00020\bH\u0016J\u001a\u0010=\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010;\u001a\u00020\bH\u0016J\u0012\u0010>\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010?\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010C\u001a\u00020\n2\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020\u0006H\u0016J*\u0010E\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010'\u001a\u00020\b2\u0006\u0010;\u001a\u00020\b2\u0006\u0010D\u001a\u00020\bH\u0016J2\u0010E\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010;\u001a\u00020\b2\u0006\u0010'\u001a\u00020\b2\u0006\u0010F\u001a\u00020\b2\u0006\u0010D\u001a\u00020\bH\u0016J\u0012\u0010I\u001a\u00020\b2\b\u0010H\u001a\u0004\u0018\u00010GH\u0016J\u001c\u0010L\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010K\u001a\u0004\u0018\u00010JH\u0016J\u001a\u0010N\u001a\u00020\n2\b\u0010H\u001a\u0004\u0018\u00010G2\u0006\u0010M\u001a\u00020\bH\u0016J\u001c\u0010P\u001a\u00020\n2\b\u0010-\u001a\u0004\u0018\u00010,2\b\u0010O\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010Q\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0014\u0010S\u001a\u0004\u0018\u00010\u000e2\b\u0010R\u001a\u0004\u0018\u00010\u000eH\u0016\u00a8\u0006V"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/api/impl/VideoFeedsHelperImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoFeedsHelper;", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "", "isLazyLoad", "", IProfileCardConst.KEY_FROM_TYPE, "", "openVideoFeedsPlayActivity", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "vid", "url", "isH265", "openVideoFeedsPlayActivityForDebug", "Landroid/widget/TextView;", "textView", "", "timeMS", "setTimeTextForTextView", e.NAME, "hideBottomUIMenuImmersived", "count", RemoteHandleConst.PARAM_DEFAULT_VALUE, "commonSetCountToTextView", "commonSetCountToTextViewAsync", "commonCountToString", "Landroid/content/Intent;", "intent", "isIntentAvailable", "byteSize", "fileSizeToString", "getMainFeedsKingCardAutoPlayConfig", "Landroid/view/View;", "view", "duration", "Landroid/animation/Animator;", "performViewSlideUpAnim", "", "getScreenSize", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoInfo;", QCircleScheme.AttrDetail.VIDEO_INFO, "bottomOffset", "computeXYaxis", OpenHippyInfo.EXTRA_KEY_IS_FULL_SCREEN, "getLogoMarginSize", "videoWidth", "videoHeight", "", "", "calculateVideoAreaHeight", "(Landroid/app/Activity;II)[Ljava/lang/Object;", "isSystemAutoRotateOpen", "hideBottomUIMenu", "isPlayFeedsActivity", "visibility", "changeVisibilityWithAlphaAnimation", "changeVisibilityWithObjectAnimator", "isFullScreenDisplay", "calculateCommentViewGroupHeight", "Lm62/c;", "videoHolder", "needShow", "setFollowTextVisibility", "targetHeight", "performViewSlideDownAnimator", "delay", "Lmqq/app/AppRuntime;", "app", "getTodayShowCountForSoftAd", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UrlJumpInfo;", "jumpInfo", "resolveUrlJumpInfo", "newValue", "updateTodayShowCountForSoftAd", "titleTextView", "setRichTitle", "isVideoFeedsPlayActivity", "originUrl", "modifyVideoUrlForKingCard", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class VideoFeedsHelperImpl implements IVideoFeedsHelper {
    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper
    public int calculateCommentViewGroupHeight(Activity activity) {
        return 0;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper
    public Object[] calculateVideoAreaHeight(Activity activity, int videoWidth, int videoHeight) {
        return null;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper
    public String commonCountToString(int count) {
        return null;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper
    public int computeXYaxis(Activity activity, VideoInfo videoInfo, int bottomOffset) {
        return 0;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper
    public String fileSizeToString(long byteSize) {
        return null;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper
    public int[] getLogoMarginSize(Activity activity, VideoInfo videoInfo, boolean isFullScreen, int bottomOffset) {
        return null;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper
    public int getMainFeedsKingCardAutoPlayConfig() {
        return 0;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper
    public int[] getScreenSize(Activity activity) {
        return null;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper
    public int getTodayShowCountForSoftAd(AppRuntime app) {
        return 0;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper
    public boolean isFullScreenDisplay(Activity activity) {
        return false;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper
    public boolean isIntentAvailable(Context context, Intent intent) {
        return false;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper
    public boolean isPlayFeedsActivity(Activity activity) {
        return false;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper
    public boolean isSystemAutoRotateOpen(Context context) {
        return false;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper
    public boolean isVideoFeedsPlayActivity(Activity activity) {
        return false;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper
    public String modifyVideoUrlForKingCard(String originUrl) {
        return null;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper
    public void performViewSlideDownAnimator(View view, int duration, int visibility, int targetHeight) {
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper
    public Animator performViewSlideUpAnim(View view, int duration) {
        return null;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper
    public void setFollowTextVisibility(c videoHolder, boolean needShow) {
        Intrinsics.checkNotNullParameter(videoHolder, "videoHolder");
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper
    public void performViewSlideDownAnimator(View view, int visibility, int duration, int delay, int targetHeight) {
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper
    public void hideBottomUIMenu(Activity activity) {
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper
    public void hideBottomUIMenuImmersived(Activity activity) {
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper
    public void hideNavigationBar(Activity activity) {
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper
    public void changeVisibilityWithObjectAnimator(View view, int visibility) {
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper
    public void resolveUrlJumpInfo(Context context, UrlJumpInfo jumpInfo) {
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper
    public void setRichTitle(VideoInfo videoInfo, TextView titleTextView) {
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper
    public void setTimeTextForTextView(TextView textView, long timeMS) {
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper
    public void updateTodayShowCountForSoftAd(AppRuntime app, int newValue) {
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper
    public void changeVisibilityWithAlphaAnimation(View view, int visibility, int duration) {
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper
    public void commonSetCountToTextView(TextView textView, int count, String defaultValue) {
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper
    public void commonSetCountToTextViewAsync(TextView textView, int count, String defaultValue) {
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper
    public void openVideoFeedsPlayActivity(Context context, Bundle bundle, boolean isLazyLoad, int fromType) {
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper
    public void openVideoFeedsPlayActivityForDebug(Activity activity, String vid, String url, boolean isH265) {
    }
}
