package com.tencent.mobileqq.springhb.prize;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqcommon.api.INetworkUtilApi;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.springhb.entry.model.GameCenterConfigData;
import com.tencent.mobileqq.springhb.pack.PackInfo;
import com.tencent.mobileqq.springhb.preload.SpringRes;
import com.tencent.mobileqq.springhb.prize.SpringPrizeView;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.Serializable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 }2\u00020\u00012\u00020\u0002:\u0001~B\u0007\u00a2\u0006\u0004\b{\u0010|J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\b\u0010\u0016\u001a\u00020\u0010H\u0002J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0002J\b\u0010\u001c\u001a\u00020\u0010H\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0016J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J&\u0010'\u001a\u0004\u0018\u00010\u00052\u0006\u0010\"\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\b\u0010*\u001a\u00020\u0007H\u0016J\b\u0010+\u001a\u00020\u0007H\u0016J\b\u0010,\u001a\u00020\u0007H\u0016J\b\u0010-\u001a\u00020\u0007H\u0016J\b\u0010.\u001a\u00020\u0007H\u0016J\u0012\u00101\u001a\u00020\u00072\b\u00100\u001a\u0004\u0018\u00010/H\u0016J\u0010\u00102\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u00103\u001a\u00020\u0010H\u0016J\u0010\u00105\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0010H\u0016J\b\u00106\u001a\u00020\u0007H\u0016J\b\u00107\u001a\u00020\u0007H\u0016J\b\u00108\u001a\u00020\u0007H\u0016J\b\u00109\u001a\u00020\u0007H\u0016J\u0018\u0010=\u001a\u00020\u00072\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020\u0003H\u0017R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010CR\u0016\u0010I\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010K\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010HR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010Q\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010W\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010TR\u0016\u0010Z\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010\\\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b[\u0010PR\u0016\u0010^\u001a\u00020R8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b]\u0010TR\u0018\u0010`\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010PR\u0018\u0010d\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0014\u0010h\u001a\u00020e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0014\u0010j\u001a\u00020e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bi\u0010gR\u0014\u0010l\u001a\u00020e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bk\u0010gR\u0016\u0010n\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010GR\u0014\u0010r\u001a\u00020o8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u001b\u0010w\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bs\u0010t\u001a\u0004\bu\u0010vR\u0014\u0010z\u001a\u00020\u00108BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bx\u0010y\u00a8\u0006\u007f"}, d2 = {"Lcom/tencent/mobileqq/springhb/prize/SpringPrizeFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "", "getCoverUrl", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "Oh", "Landroid/widget/ImageView;", "coverView", "Sh", "playBtn", "li", "pi", "qi", "", "mute", "ri", "oi", "info", "ci", "Mh", "hi", "", "startColor", "endColor", "Hh", "needStatusTrans", "needImmersive", "Landroid/content/Context;", "context", "onAttach", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onDetach", "onFinish", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "ki", "bi", "loop", WidgetCacheLunarData.JI, "playVideo", "pauseVideo", "Jh", "Kh", "", "scaleRatio", "from", "ii", "Lcom/tencent/mobileqq/springhb/pack/PackInfo;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/springhb/pack/PackInfo;", "packInfo", "D", "I", "sceneType", "E", "prizeType", UserInfo.SEX_FEMALE, "Landroid/view/ViewGroup;", "toolbar", "G", "prizeContainer", "Lcom/tencent/mobileqq/springhb/prize/SpringPrizeView;", "H", "Lcom/tencent/mobileqq/springhb/prize/SpringPrizeView;", "prizeView", "Landroid/widget/ImageView;", "remainSecondsBubble", "Landroid/widget/TextView;", "J", "Landroid/widget/TextView;", "remainSecondsTxt", "K", "remainSecondsBackTxt", "L", "Z", "isBubbleVisible", "M", "muteVideoImg", "N", "lotteryResultBtn", "P", "playVideoBtn", "Lcom/tencent/superplayer/api/ISuperPlayer;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/superplayer/api/ISuperPlayer;", "superPlayer", "Ljava/util/concurrent/atomic/AtomicBoolean;", BdhLogUtil.LogTag.Tag_Req, "Ljava/util/concurrent/atomic/AtomicBoolean;", "isVideoFullscreen", ExifInterface.LATITUDE_SOUTH, "isVideoPrepared", "T", "isPauseByLifecycle", "U", "initScaleRatio", "Landroid/graphics/drawable/ColorDrawable;", "V", "Landroid/graphics/drawable/ColorDrawable;", "loadingImg", "W", "Lkotlin/Lazy;", "Nh", "()Ljava/lang/String;", "rewardsPackageUrl", "Lh", "()Z", "canAutoPlayVideo", "<init>", "()V", "X", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SpringPrizeFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private PackInfo packInfo;

    /* renamed from: D, reason: from kotlin metadata */
    private int sceneType;

    /* renamed from: E, reason: from kotlin metadata */
    private int prizeType;

    /* renamed from: F, reason: from kotlin metadata */
    private ViewGroup toolbar;

    /* renamed from: G, reason: from kotlin metadata */
    private ViewGroup prizeContainer;

    /* renamed from: H, reason: from kotlin metadata */
    private SpringPrizeView prizeView;

    /* renamed from: I, reason: from kotlin metadata */
    private ImageView remainSecondsBubble;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView remainSecondsTxt;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private TextView remainSecondsBackTxt;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isBubbleVisible;

    /* renamed from: M, reason: from kotlin metadata */
    private ImageView muteVideoImg;

    /* renamed from: N, reason: from kotlin metadata */
    private TextView lotteryResultBtn;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private ImageView playVideoBtn;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private ISuperPlayer superPlayer;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final AtomicBoolean isVideoFullscreen;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final AtomicBoolean isVideoPrepared;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final AtomicBoolean isPauseByLifecycle;

    /* renamed from: U, reason: from kotlin metadata */
    private float initScaleRatio;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final ColorDrawable loadingImg;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final Lazy rewardsPackageUrl;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/springhb/prize/SpringPrizeFragment$a;", "", "", "EXTRA_FROM_SRC", "Ljava/lang/String;", "EXTRA_PACK_INFO", "EXTRA_PRIZE_TYPE", "EXTRA_SCENE_TYPE", "MMKV_KEY_LAST_MUTE_STATUS", "", "OTHER_CARD_BG_COLOR", "I", "SPRING_2022_HB_MMKV_PREFIX", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.springhb.prize.SpringPrizeFragment$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61259);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SpringPrizeFragment() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.sceneType = -1;
        this.prizeType = -1;
        this.isVideoFullscreen = new AtomicBoolean(false);
        this.isVideoPrepared = new AtomicBoolean(false);
        this.isPauseByLifecycle = new AtomicBoolean(false);
        this.initScaleRatio = 1.0f;
        this.loadingImg = new ColorDrawable(-8782);
        lazy = LazyKt__LazyJVMKt.lazy(SpringPrizeFragment$rewardsPackageUrl$2.INSTANCE);
        this.rewardsPackageUrl = lazy;
    }

    private final void Hh(int startColor, int endColor) {
        if (startColor == endColor) {
            ViewGroup viewGroup = this.toolbar;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toolbar");
                viewGroup = null;
            }
            viewGroup.setBackgroundColor(startColor);
            return;
        }
        ValueAnimator ofArgb = ValueAnimator.ofArgb(startColor, endColor);
        ofArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.springhb.prize.s
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SpringPrizeFragment.Ih(SpringPrizeFragment.this, valueAnimator);
            }
        });
        ofArgb.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ih(SpringPrizeFragment this$0, ValueAnimator valueAnimator) {
        Object obj;
        Integer num;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewGroup viewGroup = null;
        if (valueAnimator != null) {
            obj = valueAnimator.getAnimatedValue();
        } else {
            obj = null;
        }
        if (obj instanceof Integer) {
            num = (Integer) obj;
        } else {
            num = null;
        }
        if (num != null) {
            int intValue = num.intValue();
            QLog.d("SpringHb_SpringPrizeFragment", 1, "animateToolbarColor: middle color, " + intValue);
            ViewGroup viewGroup2 = this$0.toolbar;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toolbar");
            } else {
                viewGroup = viewGroup2;
            }
            viewGroup.setBackgroundColor(intValue);
        }
    }

    private final boolean Lh() {
        boolean isWifi = ((INetworkUtilApi) QRoute.api(INetworkUtilApi.class)).isWifi();
        PackInfo packInfo = this.packInfo;
        PackInfo packInfo2 = null;
        if (packInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("packInfo");
            packInfo = null;
        }
        String str = packInfo.businessVideo;
        Intrinsics.checkNotNullExpressionValue(str, "packInfo.businessVideo");
        boolean q16 = com.tencent.mobileqq.springhb.preload.s.b(str).q();
        PackInfo packInfo3 = this.packInfo;
        if (packInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("packInfo");
        } else {
            packInfo2 = packInfo3;
        }
        String str2 = packInfo2.businessVideo;
        Intrinsics.checkNotNullExpressionValue(str2, "packInfo.businessVideo");
        QLog.d("SpringHb_SpringPrizeFragment", 1, "canAutoPlayVideo, isWifi=" + isWifi + ", isPreloadFileExists=" + q16 + ", preloadPath=" + com.tencent.mobileqq.springhb.preload.s.b(str2).l());
        if (isWifi || q16) {
            return true;
        }
        return false;
    }

    private final boolean Mh() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_VAS)");
        boolean decodeBool = from.decodeBool("spring_festival_2022_hblast_mute_status", false);
        QLog.d("SpringHb_SpringPrizeFragment", 1, "getLastMuteStatus: is mute: " + decodeBool);
        return decodeBool;
    }

    private final String Nh() {
        Object value = this.rewardsPackageUrl.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-rewardsPackageUrl>(...)");
        return (String) value;
    }

    private final void Oh(View rootView) {
        Window window;
        View findViewById = rootView.findViewById(R.id.f87614uu);
        ViewGroup viewGroup = (ViewGroup) findViewById;
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.height += ImmersiveUtils.statusHeight;
        viewGroup.setLayoutParams(marginLayoutParams);
        SpringPrizeView springPrizeView = this.prizeView;
        ImageView imageView = null;
        if (springPrizeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prizeView");
            springPrizeView = null;
        }
        viewGroup.setBackgroundColor(springPrizeView.f());
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<Vi\u2026toolbarBgColor)\n        }");
        this.toolbar = viewGroup;
        rootView.findViewById(R.id.t2l).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.springhb.prize.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpringPrizeFragment.Ph(SpringPrizeFragment.this, view);
            }
        });
        rootView.findViewById(R.id.zkl).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.springhb.prize.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpringPrizeFragment.Qh(SpringPrizeFragment.this, view);
            }
        });
        View findViewById2 = rootView.findViewById(R.id.zkp);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.mute_video_img)");
        ImageView imageView2 = (ImageView) findViewById2;
        this.muteVideoImg = imageView2;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("muteVideoImg");
        } else {
            imageView = imageView2;
        }
        imageView.setVisibility(8);
        View findViewById3 = rootView.findViewById(R.id.f87584ur);
        TextView textView = (TextView) findViewById3;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.springhb.prize.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpringPrizeFragment.Rh(SpringPrizeFragment.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById<Te\u2026PackagePage() }\n        }");
        this.lotteryResultBtn = textView;
        oi();
        rootView.setBackgroundColor(-16777216);
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            ImmersiveUtils.setStatusTextColor(false, window);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(SpringPrizeFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SpringPrizeView springPrizeView = null;
        if (this$0.isVideoFullscreen.get()) {
            this$0.Kh();
        } else {
            SpringPrizeView springPrizeView2 = this$0.prizeView;
            if (springPrizeView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prizeView");
                springPrizeView2 = null;
            }
            springPrizeView2.k("navigate_bar");
            FragmentActivity activity = this$0.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
        SpringPrizeView springPrizeView3 = this$0.prizeView;
        if (springPrizeView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prizeView");
        } else {
            springPrizeView = springPrizeView3;
        }
        ad.h("backbutton", false, springPrizeView.a());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(SpringPrizeFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isVideoFullscreen.get()) {
            this$0.qi();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(SpringPrizeFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.pi();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void Sh(final View rootView, final ImageView coverView) {
        int i3;
        ISPlayerVideoView createPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(getContext());
        ISuperPlayer createMediaPlayer = SuperPlayerFactory.createMediaPlayer(getContext(), 117, createPlayerVideoView);
        createMediaPlayer.setXYaxis(2);
        createMediaPlayer.setOnVideoSizeChangedListener(new ISuperPlayer.OnVideoSizeChangedListener() { // from class: com.tencent.mobileqq.springhb.prize.w
            @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoSizeChangedListener
            public final void onVideoSizeChanged(ISuperPlayer iSuperPlayer, int i16, int i17) {
                SpringPrizeFragment.Th(SpringPrizeFragment.this, rootView, iSuperPlayer, i16, i17);
            }
        });
        createMediaPlayer.setOnVideoPreparedListener(new ISuperPlayer.OnVideoPreparedListener() { // from class: com.tencent.mobileqq.springhb.prize.x
            @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
            public final void onVideoPrepared(ISuperPlayer iSuperPlayer) {
                SpringPrizeFragment.Vh(SpringPrizeFragment.this, iSuperPlayer);
            }
        });
        createMediaPlayer.setOnInfoListener(new ISuperPlayer.OnInfoListener() { // from class: com.tencent.mobileqq.springhb.prize.y
            @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
            public final boolean onInfo(ISuperPlayer iSuperPlayer, int i16, long j3, long j16, Object obj) {
                boolean Wh;
                Wh = SpringPrizeFragment.Wh(SpringPrizeFragment.this, coverView, iSuperPlayer, i16, j3, j16, obj);
                return Wh;
            }
        });
        createMediaPlayer.setOnErrorListener(new ISuperPlayer.OnErrorListener() { // from class: com.tencent.mobileqq.springhb.prize.z
            @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
            public final boolean onError(ISuperPlayer iSuperPlayer, int i16, int i17, int i18, String str) {
                boolean Yh;
                Yh = SpringPrizeFragment.Yh(iSuperPlayer, i16, i17, i18, str);
                return Yh;
            }
        });
        PackInfo packInfo = this.packInfo;
        if (packInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("packInfo");
            packInfo = null;
        }
        String str = packInfo.businessVideo;
        Intrinsics.checkNotNullExpressionValue(str, "packInfo.businessVideo");
        SpringRes b16 = com.tencent.mobileqq.springhb.preload.s.b(str);
        createMediaPlayer.openMediaPlayer(getContext(), SuperPlayerFactory.createVideoInfoForUrl(b16.m(), 101, (String) null, b16.l()), 0L);
        this.superPlayer = createMediaPlayer;
        FrameLayout frameLayout = (FrameLayout) rootView.findViewById(R.id.f87624uv);
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.springhb.prize.aa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpringPrizeFragment.Zh(SpringPrizeFragment.this, view);
            }
        });
        Intrinsics.checkNotNull(createPlayerVideoView, "null cannot be cast to non-null type android.view.View");
        frameLayout.addView((View) createPlayerVideoView);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.f25740bn);
        imageView.setImageDrawable(SpringRes.j(com.tencent.mobileqq.springhb.preload.s.a("spring_detail_prize_video_play_btn.png"), null, null, 3, null));
        if (Lh()) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        imageView.setVisibility(i3);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.springhb.prize.ab
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpringPrizeFragment.ai(SpringPrizeFragment.this, view);
            }
        });
        this.playVideoBtn = imageView;
        ji(true);
        ki(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(final SpringPrizeFragment this$0, View rootView, ISuperPlayer iSuperPlayer, int i3, int i16) {
        float coerceAtLeast;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(rootView, "$rootView");
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((((ImmersiveUtils.getScreenHeight() + 195.0f) * i3) / i16) / ImmersiveUtils.getScreenWidth(), 1.0f);
        this$0.initScaleRatio = coerceAtLeast;
        rootView.post(new Runnable() { // from class: com.tencent.mobileqq.springhb.prize.t
            @Override // java.lang.Runnable
            public final void run() {
                SpringPrizeFragment.Uh(SpringPrizeFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(SpringPrizeFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ii(this$0.initScaleRatio, "init video");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(SpringPrizeFragment this$0, ISuperPlayer iSuperPlayer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isVideoPrepared.set(true);
        if (this$0.Lh()) {
            this$0.playVideo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Wh(SpringPrizeFragment this$0, final ImageView coverView, ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(coverView, "$coverView");
        QLog.d("SpringHb_SpringPrizeFragment", 1, "initVideoPlayer onInfo: what:" + i3 + "; extra:" + obj);
        if (i3 == 105 && (activity = this$0.getActivity()) != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.springhb.prize.r
                @Override // java.lang.Runnable
                public final void run() {
                    SpringPrizeFragment.Xh(coverView);
                }
            });
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xh(ImageView coverView) {
        Intrinsics.checkNotNullParameter(coverView, "$coverView");
        coverView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Yh(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
        QLog.d("SpringHb_SpringPrizeFragment", 1, "initVideoPlayer onError: module:" + i3 + "; errorType:" + i16 + "; errorCode:" + i17 + "; extraInfo:" + str);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh(SpringPrizeFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isVideoFullscreen.get()) {
            this$0.Kh();
        } else {
            this$0.Jh();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ai(SpringPrizeFragment this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isVideoPrepared.get()) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.li(it);
        } else {
            this$0.ci("\u89c6\u9891\u51c6\u5907\u4e2d...");
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void ci(String info) {
        QQToast.makeText(getContext(), info, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void di() {
        if (!QQVideoPlaySDKManager.isSDKReady()) {
            QQVideoPlaySDKManager.initSDKAsync(BaseApplication.getContext(), new SDKInitListener() { // from class: com.tencent.mobileqq.springhb.prize.ac
                @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
                public final void onSDKInited(boolean z16) {
                    SpringPrizeFragment.ei(z16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ei(boolean z16) {
        QLog.i("SpringHb_SpringPrizeFragment", 1, "video sdk init.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fi(SpringPrizeFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ad.f();
        SpringPrizeView springPrizeView = this$0.prizeView;
        if (springPrizeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prizeView");
            springPrizeView = null;
        }
        springPrizeView.k("swipe_floating");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final String getCoverUrl() {
        boolean z16;
        String url;
        boolean z17;
        PackInfo packInfo = this.packInfo;
        PackInfo packInfo2 = null;
        if (packInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("packInfo");
            packInfo = null;
        }
        String str = packInfo.businessVideo;
        boolean z18 = false;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            PackInfo packInfo3 = this.packInfo;
            if (packInfo3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("packInfo");
            } else {
                packInfo2 = packInfo3;
            }
            url = packInfo2.businessCover;
        } else {
            PackInfo packInfo4 = this.packInfo;
            if (packInfo4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("packInfo");
            } else {
                packInfo2 = packInfo4;
            }
            url = packInfo2.businessVideoCover;
        }
        if (url != null && url.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (!z17) {
            Intrinsics.checkNotNullExpressionValue(url, "url");
            return url;
        }
        GameCenterConfigData h16 = h.h();
        if (h16 != null) {
            String str2 = h16.fallbackWallpaperResUrl;
            if (str2 == null || str2.length() == 0) {
                z18 = true;
            }
            if (!z18) {
                String str3 = h16.fallbackWallpaperResUrl;
                Intrinsics.checkNotNullExpressionValue(str3, "config.fallbackWallpaperResUrl");
                return str3;
            }
            return "";
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gi(SpringPrizeFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = this$0.playVideoBtn;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    private final void hi(boolean mute) {
        QLog.d("SpringHb_SpringPrizeFragment", 1, "saveLastMuteStatus: is mute:" + mute);
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_VAS)");
        from.encodeBool("spring_festival_2022_hblast_mute_status", mute);
    }

    private final void li(final View playBtn) {
        DialogUtil.createCustomDialog(getContext(), 230, getString(R.string.bb9), getString(R.string.f170967bb4), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.springhb.prize.p
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                SpringPrizeFragment.mi(SpringPrizeFragment.this, playBtn, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.springhb.prize.q
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                SpringPrizeFragment.ni(dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mi(SpringPrizeFragment this$0, View playBtn, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(playBtn, "$playBtn");
        this$0.playVideo();
        playBtn.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ni(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final void oi() {
        boolean z16;
        if (Nh().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        TextView textView = null;
        if (z16) {
            PackInfo packInfo = this.packInfo;
            if (packInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("packInfo");
                packInfo = null;
            }
            if (packInfo.type == 1) {
                TextView textView2 = this.lotteryResultBtn;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("lotteryResultBtn");
                } else {
                    textView = textView2;
                }
                textView.setVisibility(0);
                return;
            }
        }
        TextView textView3 = this.lotteryResultBtn;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lotteryResultBtn");
        } else {
            textView = textView3;
        }
        textView.setVisibility(4);
    }

    private final void pi() {
        com.tencent.mobileqq.springhb.x.n(getActivity(), Nh());
    }

    private final void qi() {
        ki(!bi());
    }

    private final void ri(boolean mute) {
        String str;
        if (mute) {
            str = "spring_detail_video_mute_off.png";
        } else {
            str = "spring_detail_video_mute_on.png";
        }
        ImageView imageView = this.muteVideoImg;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("muteVideoImg");
            imageView = null;
        }
        imageView.setImageDrawable(SpringRes.j(com.tencent.mobileqq.springhb.preload.s.a(str), null, null, 3, null));
    }

    public void Jh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        if (this.isVideoFullscreen.compareAndSet(false, true)) {
            SpringPrizeView springPrizeView = this.prizeView;
            TextView textView = null;
            if (springPrizeView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prizeView");
                springPrizeView = null;
            }
            springPrizeView.m(300L);
            ViewGroup viewGroup = this.prizeContainer;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prizeContainer");
                viewGroup = null;
            }
            ViewPropertyAnimator animate = viewGroup.animate();
            ViewGroup viewGroup2 = this.prizeContainer;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prizeContainer");
                viewGroup2 = null;
            }
            animate.translationY(viewGroup2.getHeight()).start();
            ki(Mh());
            ImageView imageView = this.muteVideoImg;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("muteVideoImg");
                imageView = null;
            }
            imageView.setVisibility(0);
            TextView textView2 = this.lotteryResultBtn;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lotteryResultBtn");
                textView2 = null;
            }
            textView2.setVisibility(8);
            SpringPrizeView springPrizeView2 = this.prizeView;
            if (springPrizeView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prizeView");
                springPrizeView2 = null;
            }
            int f16 = springPrizeView2.f();
            SpringPrizeView springPrizeView3 = this.prizeView;
            if (springPrizeView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prizeView");
                springPrizeView3 = null;
            }
            Hh(f16, springPrizeView3.g());
            if (this.isBubbleVisible) {
                ImageView imageView2 = this.remainSecondsBubble;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("remainSecondsBubble");
                    imageView2 = null;
                }
                imageView2.setVisibility(4);
                TextView textView3 = this.remainSecondsTxt;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("remainSecondsTxt");
                } else {
                    textView = textView3;
                }
                textView.setVisibility(4);
                TextView textView4 = this.remainSecondsBackTxt;
                if (textView4 != null) {
                    textView4.setVisibility(4);
                }
            }
        }
    }

    public void Kh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        if (this.isVideoFullscreen.compareAndSet(true, false)) {
            SpringPrizeView springPrizeView = this.prizeView;
            TextView textView = null;
            if (springPrizeView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prizeView");
                springPrizeView = null;
            }
            springPrizeView.n(300L);
            ViewGroup viewGroup = this.prizeContainer;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prizeContainer");
                viewGroup = null;
            }
            viewGroup.setVisibility(0);
            ViewGroup viewGroup2 = this.prizeContainer;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prizeContainer");
                viewGroup2 = null;
            }
            viewGroup2.animate().translationY(0.0f).start();
            hi(bi());
            ki(true);
            ImageView imageView = this.muteVideoImg;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("muteVideoImg");
                imageView = null;
            }
            imageView.setVisibility(8);
            oi();
            SpringPrizeView springPrizeView2 = this.prizeView;
            if (springPrizeView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prizeView");
                springPrizeView2 = null;
            }
            int g16 = springPrizeView2.g();
            SpringPrizeView springPrizeView3 = this.prizeView;
            if (springPrizeView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prizeView");
                springPrizeView3 = null;
            }
            Hh(g16, springPrizeView3.f());
            if (this.isBubbleVisible) {
                ImageView imageView2 = this.remainSecondsBubble;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("remainSecondsBubble");
                    imageView2 = null;
                }
                imageView2.setVisibility(0);
                TextView textView2 = this.remainSecondsTxt;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("remainSecondsTxt");
                } else {
                    textView = textView2;
                }
                textView.setVisibility(0);
                TextView textView3 = this.remainSecondsBackTxt;
                if (textView3 != null) {
                    textView3.setVisibility(0);
                }
            }
        }
    }

    public boolean bi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            return iSuperPlayer.isOutputMute();
        }
        return false;
    }

    @MainThread
    public void ii(float scaleRatio, @NotNull String from) {
        ISPlayerVideoView videoView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Float.valueOf(scaleRatio), from);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null && (videoView = iSuperPlayer.getVideoView()) != null) {
            videoView.setScaleParam(scaleRatio);
            videoView.getRenderView().requestLayout();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) activity);
            return;
        }
        super.initWindowStyleAndAnimation(activity);
        if (activity != null) {
            activity.overridePendingTransition(R.anim.f154451a0, 0);
        }
    }

    public void ji(boolean loop) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, loop);
            return;
        }
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.setLoopback(loop);
        }
    }

    public void ki(boolean mute) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, mute);
            return;
        }
        QLog.d("SpringHb_SpringPrizeFragment", 1, "setMute: " + mute);
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.setOutputMute(mute);
        }
        ImageView imageView = this.muteVideoImg;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("muteVideoImg");
            imageView = null;
        }
        imageView.setSelected(mute);
        ri(mute);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Serializable serializable;
        PackInfo packInfo;
        int i3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.springhb.prize.v
            @Override // java.lang.Runnable
            public final void run() {
                SpringPrizeFragment.di();
            }
        });
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Intent intent = activity.getIntent();
            PackInfo packInfo2 = null;
            if (intent != null) {
                serializable = intent.getSerializableExtra("extra_pack_info");
            } else {
                serializable = null;
            }
            if (serializable instanceof PackInfo) {
                packInfo = (PackInfo) serializable;
            } else {
                packInfo = null;
            }
            if (packInfo == null) {
                QLog.d("SpringHb_SpringPrizeFragment", 1, "onAttach: no pack info passed to activity");
                packInfo = new PackInfo();
            }
            this.packInfo = packInfo;
            Intent intent2 = activity.getIntent();
            int i16 = -1;
            if (intent2 != null) {
                i3 = intent2.getIntExtra("extra_scene_type", -1);
            } else {
                i3 = -1;
            }
            this.sceneType = i3;
            Intent intent3 = activity.getIntent();
            if (intent3 == null || (str = intent3.getStringExtra("extra_from_src")) == null) {
                str = "";
            }
            Intrinsics.checkNotNullExpressionValue(str, "it.intent?.getStringExtra(EXTRA_FROM_SRC) ?: \"\"");
            PackInfo packInfo3 = this.packInfo;
            if (packInfo3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("packInfo");
                packInfo3 = null;
            }
            ad.e(packInfo3, this.sceneType);
            Intent intent4 = activity.getIntent();
            if (intent4 != null) {
                i16 = intent4.getIntExtra("extra_prize_type", -1);
            }
            this.prizeType = i16;
            SpringPrizeView.Companion companion = SpringPrizeView.INSTANCE;
            PackInfo packInfo4 = this.packInfo;
            if (packInfo4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("packInfo");
            } else {
                packInfo2 = packInfo4;
            }
            this.prizeView = companion.a(packInfo2.type, activity);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            inflate = (View) iPatchRedirector.redirect((short) 5, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            QLog.d("SpringHb_SpringPrizeFragment", 1, "onCreateView: ");
            inflate = inflater.inflate(R.layout.hqq, container, false);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onDestroy();
        SpringPrizeView springPrizeView = this.prizeView;
        if (springPrizeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prizeView");
            springPrizeView = null;
        }
        springPrizeView.j();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.onDetach();
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.release();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.onFinish();
        SpringPrizeView springPrizeView = this.prizeView;
        if (springPrizeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prizeView");
            springPrizeView = null;
        }
        springPrizeView.k("page_return");
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onPause();
        if (this.isPauseByLifecycle.compareAndSet(false, true)) {
            pauseVideo();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onResume();
        if (this.isPauseByLifecycle.compareAndSet(true, false) && Lh()) {
            playVideo();
        }
        SpringPrizeView springPrizeView = this.prizeView;
        if (springPrizeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prizeView");
            springPrizeView = null;
        }
        springPrizeView.l();
    }

    /* JADX WARN: Removed duplicated region for block: B:84:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Oh(view);
        String coverUrl = getCoverUrl();
        ImageView coverView = (ImageView) view.getRootView().findViewById(R.id.f87634uw);
        SpringRes b16 = com.tencent.mobileqq.springhb.preload.s.b(coverUrl);
        PackInfo packInfo = this.packInfo;
        TextView textView = null;
        if (packInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("packInfo");
            packInfo = null;
        }
        if (packInfo.type == 6) {
            ViewGroup.LayoutParams layoutParams = coverView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).width = ViewUtils.getScreenWidth();
            int screenHeight = ViewUtils.getScreenHeight() - ViewUtils.dpToPx(300.0f);
            ((ViewGroup.MarginLayoutParams) layoutParams2).height = screenHeight;
            if (screenHeight <= 0) {
                ((ViewGroup.MarginLayoutParams) layoutParams2).height = ViewUtils.getScreenHeight();
            }
            layoutParams2.topToTop = 0;
            layoutParams2.startToStart = 0;
            layoutParams2.endToEnd = 0;
            layoutParams2.bottomToBottom = -1;
            coverView.setLayoutParams(layoutParams2);
        }
        try {
            coverView.setImageDrawable(SpringRes.j(b16, null, null, 3, null));
        } catch (OutOfMemoryError e16) {
            QLog.e("SpringHb_SpringPrizeFragment", 1, "set cover background oom, ", e16);
            try {
                coverView.setImageDrawable(this.loadingImg);
            } catch (Throwable th5) {
                QLog.e("SpringHb_SpringPrizeFragment", 1, "set cover background error, ", th5);
            }
        }
        PackInfo packInfo2 = this.packInfo;
        if (packInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("packInfo");
            packInfo2 = null;
        }
        String str = packInfo2.businessVideo;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            try {
                Intrinsics.checkNotNullExpressionValue(coverView, "coverView");
                Sh(view, coverView);
            } catch (OutOfMemoryError e17) {
                QLog.e("SpringHb_SpringPrizeFragment", 1, "initVideoPlayer oom=", e17);
            }
        }
        View findViewById = view.findViewById(R.id.f87604ut);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById<FrameL\u2026d.spring_prize_container)");
        this.prizeContainer = (ViewGroup) findViewById;
        try {
            LayoutInflater from = LayoutInflater.from(getContext());
            SpringPrizeView springPrizeView = this.prizeView;
            if (springPrizeView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prizeView");
                springPrizeView = null;
            }
            View infoView = from.inflate(springPrizeView.d(), (ViewGroup) null);
            ViewGroup viewGroup = this.prizeContainer;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prizeContainer");
                viewGroup = null;
            }
            viewGroup.addView(infoView, new FrameLayout.LayoutParams(-1, -1, 17));
            SpringPrizeView springPrizeView2 = this.prizeView;
            if (springPrizeView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prizeView");
                springPrizeView2 = null;
            }
            PackInfo packInfo3 = this.packInfo;
            if (packInfo3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("packInfo");
                packInfo3 = null;
            }
            Intrinsics.checkNotNullExpressionValue(infoView, "infoView");
            springPrizeView2.p(packInfo3, infoView, view);
        } catch (OutOfMemoryError e18) {
            QLog.e("SpringHb_SpringPrizeFragment", 1, "onCreateView, create info view oom=", e18);
        }
        View findViewById2 = view.findViewById(R.id.f227204h);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById<ImageV\u2026>(R.id.pause_shua_bubble)");
        this.remainSecondsBubble = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R.id.f227304i);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById<TextView>(R.id.pause_shua_txt)");
        this.remainSecondsTxt = (TextView) findViewById3;
        if (this.sceneType == 2) {
            PackInfo packInfo4 = this.packInfo;
            if (packInfo4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("packInfo");
                packInfo4 = null;
            }
            if (packInfo4.remainSeconds > 0) {
                GameCenterConfigData h16 = h.h();
                if (h16 != null && !TextUtils.isEmpty(h16.remainTimeResUrl)) {
                    ImageView imageView = this.remainSecondsBubble;
                    if (imageView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("remainSecondsBubble");
                        imageView = null;
                    }
                    String str2 = h16.remainTimeResUrl;
                    Intrinsics.checkNotNullExpressionValue(str2, "gameConfigData.remainTimeResUrl");
                    imageView.setImageDrawable(SpringRes.j(com.tencent.mobileqq.springhb.preload.s.b(str2), null, null, 3, null));
                } else {
                    ImageView imageView2 = this.remainSecondsBubble;
                    if (imageView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("remainSecondsBubble");
                        imageView2 = null;
                    }
                    imageView2.setImageDrawable(SpringRes.j(com.tencent.mobileqq.springhb.preload.s.a("spring_detail_shua_pause_bubble_bg.png"), null, null, 3, null));
                }
                TextView textView2 = this.remainSecondsTxt;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("remainSecondsTxt");
                    textView2 = null;
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                Object[] objArr = new Object[1];
                PackInfo packInfo5 = this.packInfo;
                if (packInfo5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("packInfo");
                    packInfo5 = null;
                }
                objArr[0] = Integer.valueOf(packInfo5.remainSeconds);
                String format = String.format("\u5237\u4e00\u5237\u5df2\u6682\u505c\n\u8fd8\u5269%s\u79d2", Arrays.copyOf(objArr, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                textView2.setText(format);
                ImageView imageView3 = this.remainSecondsBubble;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("remainSecondsBubble");
                    imageView3 = null;
                }
                imageView3.setVisibility(0);
                TextView textView3 = this.remainSecondsTxt;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("remainSecondsTxt");
                    textView3 = null;
                }
                textView3.setVisibility(0);
                ImageView imageView4 = this.remainSecondsBubble;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("remainSecondsBubble");
                    imageView4 = null;
                }
                imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.springhb.prize.l
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        SpringPrizeFragment.fi(SpringPrizeFragment.this, view2);
                    }
                });
                this.isBubbleVisible = true;
                ImageView imageView5 = this.remainSecondsBubble;
                if (imageView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("remainSecondsBubble");
                    imageView5 = null;
                }
                com.tencent.mobileqq.springhb.x.p(imageView5);
                TextView textView4 = this.remainSecondsTxt;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("remainSecondsTxt");
                } else {
                    textView = textView4;
                }
                com.tencent.mobileqq.springhb.x.p(textView);
                ad.g();
                if (this.prizeType != 1) {
                    ((TextView) view.findViewById(R.id.f87584ur)).setText("\u67e5\u770b\u4f59\u989d");
                    return;
                }
                return;
            }
        }
        ImageView imageView6 = this.remainSecondsBubble;
        if (imageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("remainSecondsBubble");
            imageView6 = null;
        }
        imageView6.setVisibility(4);
        TextView textView5 = this.remainSecondsTxt;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("remainSecondsTxt");
        } else {
            textView = textView5;
        }
        textView.setVisibility(4);
        this.isBubbleVisible = false;
        if (this.prizeType != 1) {
        }
    }

    public void pauseVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.pause();
        }
    }

    public void playVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.springhb.prize.u
                @Override // java.lang.Runnable
                public final void run() {
                    SpringPrizeFragment.gi(SpringPrizeFragment.this);
                }
            });
        }
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.start();
        }
    }
}
