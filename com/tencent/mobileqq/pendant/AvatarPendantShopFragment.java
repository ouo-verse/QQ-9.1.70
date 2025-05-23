package com.tencent.mobileqq.pendant;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.aelight.camera.download.AEResManagerConfigBean;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.avatar.api.IQQAvatarAigcMagicAvatarApi;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pad.SplitViewState;
import com.tencent.mobileqq.pad.m;
import com.tencent.mobileqq.pendant.AvatarPendantShopFragment$listener$2;
import com.tencent.mobileqq.pendant.receiver.AvatarPendantEventReceiver;
import com.tencent.mobileqq.pendant.view.PendantAvatarShopLayout;
import com.tencent.mobileqq.pendant.view.ShopHalfScreenFloatingView;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.ToggleProxy;
import com.tencent.mobileqq.vas.VasDynamicDrawableCache;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.base.VasQPublicBaseFragment;
import com.tencent.mobileqq.vas.inject.IAvatarPendantView;
import com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.ui.APNGDrawable;
import com.tencent.mobileqq.vas.ui.IDynamicDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.publish.api.IWinkDraft;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.mobileqq.winkpublish.api.ITaskListener;
import com.tencent.mobileqq.winkpublish.util.WinkCommonUtil;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.avatar.api.IZPlanEditAvatarApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.state.report.SquareReportConst;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzoneIPCModule;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u009c\u00012\u00020\u00012\u00020\u0002:\u0002\u009d\u0001B\t\u00a2\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0003J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0002J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0003J\b\u0010\u001a\u001a\u00020\u0005H\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0014J&\u0010#\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0017J\u001a\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u000e2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010&\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\b\u0010'\u001a\u00020\u0005H\u0016J\b\u0010(\u001a\u00020\u0005H\u0016J\b\u0010)\u001a\u00020\u0005H\u0016J\b\u0010*\u001a\u00020\u0005H\u0016J\"\u0010/\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u00172\b\u0010.\u001a\u0004\u0018\u00010-H\u0016J\u0012\u00101\u001a\u00020\u00052\b\u00100\u001a\u0004\u0018\u00010-H\u0016J\b\u00102\u001a\u00020\u0005H\u0016J\u0010\u00105\u001a\u00020\u00052\u0006\u00104\u001a\u000203H\u0016J\b\u00106\u001a\u00020\u0007H\u0016J\b\u00107\u001a\u00020\u0005H\u0016R\"\u0010?\u001a\u0002088\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010F\u001a\u00020\u001f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010N\u001a\u00020G8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010V\u001a\u00020O8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010^\u001a\u00020W8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\"\u0010b\u001a\u00020W8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b_\u0010Y\u001a\u0004\b`\u0010[\"\u0004\ba\u0010]R\"\u0010f\u001a\u00020W8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bc\u0010Y\u001a\u0004\bd\u0010[\"\u0004\be\u0010]R\"\u0010n\u001a\u00020g8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\"\u0010r\u001a\u00020g8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bo\u0010i\u001a\u0004\bp\u0010k\"\u0004\bq\u0010mR\"\u0010v\u001a\u00020\u001f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bs\u0010A\u001a\u0004\bt\u0010C\"\u0004\bu\u0010ER\"\u0010z\u001a\u00020g8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bw\u0010i\u001a\u0004\bx\u0010k\"\u0004\by\u0010mR#\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086.\u00a2\u0006\u0013\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R\u001b\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R!\u0010\u0089\u0001\u001a\u00030\u0084\u00018FX\u0086\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R$\u0010\u0090\u0001\u001a\n\u0012\u0005\u0012\u00030\u008b\u00010\u008a\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u008c\u0001\u0010\u008d\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R!\u0010\u0095\u0001\u001a\u00030\u0091\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0092\u0001\u0010\u0086\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001c\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0096\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001\u00a8\u0006\u009e\u0001"}, d2 = {"Lcom/tencent/mobileqq/pendant/AvatarPendantShopFragment;", "Lcom/tencent/mobileqq/vas/base/VasQPublicBaseFragment;", "Lcom/tencent/mobileqq/pad/f;", "Lmqq/app/AppRuntime;", "app", "", "ri", "", "isNight", "si", WidgetCacheLunarData.JI, "registerAvatarPublishListener", "unregisterAvatarPublishListener", "Dh", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Zh", "ci", "bi", "ai", "Rh", "", "type", "qi", "setStatusBarImmersive", "", "rh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onCreate", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onDestroyView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "intent", "onNewIntent", "onPostThemeChanged", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "qOnBackPressed", "qOnNewIntent", "Lcom/tencent/mobileqq/pendant/view/ShopHalfScreenFloatingView;", "E", "Lcom/tencent/mobileqq/pendant/view/ShopHalfScreenFloatingView;", "Fh", "()Lcom/tencent/mobileqq/pendant/view/ShopHalfScreenFloatingView;", "di", "(Lcom/tencent/mobileqq/pendant/view/ShopHalfScreenFloatingView;)V", "avatarShopListPopupWindow", UserInfo.SEX_FEMALE, "Landroid/view/ViewGroup;", "Jh", "()Landroid/view/ViewGroup;", "gi", "(Landroid/view/ViewGroup;)V", "pendantShopLayout", "Lcom/tencent/mobileqq/pendant/view/PendantAvatarShopLayout;", "G", "Lcom/tencent/mobileqq/pendant/view/PendantAvatarShopLayout;", "Kh", "()Lcom/tencent/mobileqq/pendant/view/PendantAvatarShopLayout;", "hi", "(Lcom/tencent/mobileqq/pendant/view/PendantAvatarShopLayout;)V", "pendantShopView", "Lcom/tencent/mobileqq/pendant/receiver/AvatarPendantEventReceiver;", "H", "Lcom/tencent/mobileqq/pendant/receiver/AvatarPendantEventReceiver;", "Nh", "()Lcom/tencent/mobileqq/pendant/receiver/AvatarPendantEventReceiver;", "li", "(Lcom/tencent/mobileqq/pendant/receiver/AvatarPendantEventReceiver;)V", "receiver", "Landroid/widget/Button;", "I", "Landroid/widget/Button;", "Lh", "()Landroid/widget/Button;", "ii", "(Landroid/widget/Button;)V", "personalAvatarBut", "J", "Mh", "ki", "qqShowAvatarBut", "K", "Ph", "oi", "splendidAvatarBut", "Landroid/widget/ImageView;", "L", "Landroid/widget/ImageView;", "Qh", "()Landroid/widget/ImageView;", "pi", "(Landroid/widget/ImageView;)V", "splendidExtendIcon", "M", "Oh", "ni", "splendidAvatarBanner", "N", "Gh", "ei", "layoutAvatarPendantParent", "P", "Hh", "fi", "layoutHeadBg", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "mi", "(Landroid/view/View;)V", BdhLogUtil.LogTag.Tag_Req, "Ljava/lang/String;", "reportZPlanEntranceRedDotItemId", "Lcom/tencent/mobileqq/vas/inject/IAvatarPendantView;", ExifInterface.LATITUDE_SOUTH, "Lkotlin/Lazy;", "Eh", "()Lcom/tencent/mobileqq/vas/inject/IAvatarPendantView;", "avatarPendantView", "", "Lcom/tencent/mobileqq/pendant/AdComponent;", "T", "[Lcom/tencent/mobileqq/pendant/AdComponent;", "getComponents", "()[Lcom/tencent/mobileqq/pendant/AdComponent;", "components", "Lcom/tencent/mobileqq/winkpublish/api/ITaskListener$Stub;", "U", "Ih", "()Lcom/tencent/mobileqq/winkpublish/api/ITaskListener$Stub;", "listener", "Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "V", "Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "winkPublishService", "<init>", "()V", "W", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class AvatarPendantShopFragment extends VasQPublicBaseFragment implements com.tencent.mobileqq.pad.f {
    static IPatchRedirector $redirector_;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: E, reason: from kotlin metadata */
    public ShopHalfScreenFloatingView avatarShopListPopupWindow;

    /* renamed from: F, reason: from kotlin metadata */
    public ViewGroup pendantShopLayout;

    /* renamed from: G, reason: from kotlin metadata */
    public PendantAvatarShopLayout pendantShopView;

    /* renamed from: H, reason: from kotlin metadata */
    public AvatarPendantEventReceiver receiver;

    /* renamed from: I, reason: from kotlin metadata */
    public Button personalAvatarBut;

    /* renamed from: J, reason: from kotlin metadata */
    public Button qqShowAvatarBut;

    /* renamed from: K, reason: from kotlin metadata */
    public Button splendidAvatarBut;

    /* renamed from: L, reason: from kotlin metadata */
    public ImageView splendidExtendIcon;

    /* renamed from: M, reason: from kotlin metadata */
    public ImageView splendidAvatarBanner;

    /* renamed from: N, reason: from kotlin metadata */
    public ViewGroup layoutAvatarPendantParent;

    /* renamed from: P, reason: from kotlin metadata */
    public ImageView layoutHeadBg;

    /* renamed from: Q, reason: from kotlin metadata */
    public View rootView;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private String reportZPlanEntranceRedDotItemId;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final Lazy avatarPendantView;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final AdComponent[] components;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Lazy listener;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private WinkPublishServiceProxy2 winkPublishService;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/pendant/AvatarPendantShopFragment$a;", "", "", "TAG", "Ljava/lang/String;", "", "ZPLAN_AVATAR_EDIT_REPORT_ACTION_ID_VAS_SHOP_CLICK", "I", "ZPLAN_AVATAR_EDIT_REPORT_ACTION_ID_VAS_SHOP_IMPL", "ZPLAN_AVATAR_EDIT_REPORT_AVATAR_ENTRANCE", "", "ZPLAN_EDIT_ENTRANCE_RED_DOT_TOP_MARGIN", UserInfo.SEX_FEMALE, "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.pendant.AvatarPendantShopFragment$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/pendant/AvatarPendantShopFragment$b", "Lcom/tencent/mobileqq/winkpublish/WinkPublishHelper2$Callback;", "Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "service", "", "onServiceConnected", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements WinkPublishHelper2.Callback {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AvatarPendantShopFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.winkpublish.WinkPublishHelper2.Callback
        public void onServiceConnected(@NotNull WinkPublishServiceProxy2 service) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) service);
                return;
            }
            Intrinsics.checkNotNullParameter(service, "service");
            QLog.d("AvatarPendantShopFragment", 1, "bind success :" + service);
            service.addTaskListener(AvatarPendantShopFragment.this.Ih());
            AvatarPendantShopFragment.this.winkPublishService = service;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24651);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 45)) {
            redirector.redirect((short) 45);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AvatarPendantShopFragment() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(AvatarPendantShopFragment$avatarPendantView$2.INSTANCE);
            this.avatarPendantView = lazy;
            this.components = new AdComponent[]{new AdComponent()};
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<AvatarPendantShopFragment$listener$2.a>() { // from class: com.tencent.mobileqq.pendant.AvatarPendantShopFragment$listener$2
                static IPatchRedirector $redirector_;

                @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/pendant/AvatarPendantShopFragment$listener$2$a", "Lcom/tencent/mobileqq/winkpublish/api/ITaskListener$Stub;", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "taskInfo", "", "onTaskChange", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
                /* loaded from: classes16.dex */
                public static final class a extends ITaskListener.Stub {
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ AvatarPendantShopFragment f257476d;

                    a(AvatarPendantShopFragment avatarPendantShopFragment) {
                        this.f257476d = avatarPendantShopFragment;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) avatarPendantShopFragment);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void v(TaskInfo taskInfo, String str, AvatarPendantShopFragment this$0) {
                        Intrinsics.checkNotNullParameter(taskInfo, "$taskInfo");
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        if (taskInfo.isSuccess()) {
                            QLog.d("AvatarPendantShopFragment", 1, "success:" + taskInfo);
                            ((IWinkDraft) QRoute.api(IWinkDraft.class)).delete(WinkCommonUtil.getCurrentAccountLong(), taskInfo.getMissionId());
                            QQToast.makeText(BaseApplication.getContext(), 2, com.dataline.util.j.d(BaseApplication.getContext().getString(R.string.f238917l2)), 1).show();
                            HashMap hashMap = new HashMap();
                            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_AVATAR_PREVIEW_SOURCE, str);
                            VideoReport.reportEvent(EventKey.ACT, this$0.getView(), hashMap);
                            return;
                        }
                        QQToast.makeText(BaseApplication.getContext(), R.string.hit, 1).show();
                    }

                    @Override // com.tencent.mobileqq.winkpublish.api.ITaskListener
                    public void onTaskChange(@NotNull final TaskInfo taskInfo) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) taskInfo);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
                        Bundle transParams = taskInfo.getTransParams();
                        final String str = null;
                        if (transParams != null) {
                            str = transParams.getString(WinkDaTongReportConstant.ElementParamKey.XSJ_AVATAR_PREVIEW_SOURCE, null);
                        }
                        QLog.d("AvatarPendantShopFragment", 1, "\u66f4\u65b0\u5934\u50cf\u5206\u4eab\u5c0f\u4e16\u754c\u56de\u8c03 :" + str);
                        if (str == null || !taskInfo.isFinish()) {
                            return;
                        }
                        QLog.d("AvatarPendantShopFragment", 1, "isFinish:" + taskInfo);
                        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                        final AvatarPendantShopFragment avatarPendantShopFragment = this.f257476d;
                        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.pendant.i
                            @Override // java.lang.Runnable
                            public final void run() {
                                AvatarPendantShopFragment$listener$2.a.v(TaskInfo.this, str, avatarPendantShopFragment);
                            }
                        });
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AvatarPendantShopFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new a(AvatarPendantShopFragment.this) : (a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.listener = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void Dh(boolean isNight) {
        int i3;
        int i16;
        int i17 = R.drawable.kxl;
        int i18 = R.drawable.kxn;
        if (isNight) {
            Ph().setBackgroundResource(R.drawable.kxl);
            Mh().setBackgroundResource(R.drawable.kxn);
            Lh().setBackgroundResource(R.drawable.kxn);
        }
        if (Ph().getVisibility() == 8) {
            if (Mh().getVisibility() == 8) {
                Button Lh = Lh();
                if (isNight) {
                    i16 = R.drawable.kxs;
                } else {
                    i16 = R.drawable.np8;
                }
                Lh.setBackgroundResource(i16);
                return;
            }
            Button Mh = Mh();
            if (!isNight) {
                i17 = R.drawable.np5;
            }
            Mh.setBackgroundResource(i17);
            Button Lh2 = Lh();
            if (!isNight) {
                i18 = R.drawable.kxm;
            }
            Lh2.setBackgroundResource(i18);
            Button Lh3 = Lh();
            if (isNight) {
                i3 = R.drawable.kxp;
            } else {
                i3 = R.drawable.np7;
            }
            Lh3.setBackgroundResource(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ITaskListener.Stub Ih() {
        return (ITaskListener.Stub) this.listener.getValue();
    }

    private final void Rh(boolean isNight) {
        String str;
        if (isNight) {
            str = "https://tianquan.gtimg.cn/uncategorized/arno/avatarstore_header_night_bg.png";
        } else {
            str = "https://tianquan.gtimg.cn/uncategorized/avatarstore-header-bg.png";
        }
        Hh().setBackgroundDrawable(URLDrawable.getDrawable(str, (URLDrawable.URLDrawableOptions) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(AvatarPendantShopFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.qi(ShopHalfScreenFloatingView.f257572y0);
        ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onHeadAvatarItemClick();
        Map<String, ?> elementParams = VideoReport.getElementParams(this$0.Lh());
        Intrinsics.checkNotNullExpressionValue(elementParams, "getElementParams(personalAvatarBut)");
        VideoReport.reportEvent("clck", this$0.Lh(), elementParams);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(AvatarPendantShopFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (com.tencent.mobileqq.pad.e.a() != SplitViewState.STATE_FLAT && (this$0.getActivity() instanceof QPublicFragmentActivity)) {
            QLog.i("AvatarPendantShopFragment", 1, "isPadOnAddFriendFinished QFragmentContainerManager.currentSplitViewState() == SplitViewState.STATE_FLAT is false");
            this$0.requireActivity().onBackPressed();
        } else {
            QLog.i("AvatarPendantShopFragment", 1, "isPadOnAddFriendFinished QFragmentContainerManager.currentSplitViewState() == SplitViewState.STATE_FLAT is true");
            this$0.requireActivity().onKeyDown(4, new KeyEvent(4, 4));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(AvatarPendantShopFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Eh().showSelfMenu();
        ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onMineIconClick();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(AvatarPendantShopFragment this$0, String bannerUrl, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bannerUrl, "$bannerUrl");
        IAvatarPendantView Eh = this$0.Eh();
        ToggleProxy toggleProxy = VasToggle.VAS_AVATAR_CONFIG;
        if (!Eh.handleMagicAvatarBannerClick(view, toggleProxy.getJson())) {
            String stringDataSet = toggleProxy.getStringDataSet("highEnergyJumpUrl", "");
            if (!Intrinsics.areEqual(stringDataSet, "") && this$0.getQBaseActivity() != null) {
                Intent intent = new Intent(this$0.getQBaseActivity(), (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", stringDataSet);
                this$0.getQBaseActivity().startActivity(intent);
                ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onHeadSplendidItem(102, bannerUrl);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wh(AvatarPendantShopFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Kh().E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xh(AvatarPendantShopFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Fh().V();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(AvatarPendantShopFragment this$0, View view, View view2) {
        EventCollector.getInstance().onViewClickedBefore(view2);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        if (com.tencent.relation.common.config.toggle.c.D.g(false)) {
            QRouteApi api = QRoute.api(IZPlanApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanApi::class.java)");
            QBaseActivity qBaseActivity = this$0.getQBaseActivity();
            Intrinsics.checkNotNullExpressionValue(qBaseActivity, "qBaseActivity");
            IZPlanApi.b.b((IZPlanApi) api, qBaseActivity, "2", null, 4, null);
            this$0.bi();
        } else {
            this$0.qi(ShopHalfScreenFloatingView.f257571x0);
        }
        ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onHeadQQShowItem(102);
        Map<String, ?> elementParams = VideoReport.getElementParams(this$0.Mh());
        Intrinsics.checkNotNullExpressionValue(elementParams, "getElementParams(qqShowAvatarBut)");
        VideoReport.reportEvent("clck", this$0.Mh(), elementParams);
        if (this$0.reportZPlanEntranceRedDotItemId != null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
            String str = this$0.reportZPlanEntranceRedDotItemId;
            Intrinsics.checkNotNull(str);
            iZPlanApi.reportAvatarEditEntranceRedDotData(peekAppRuntime, str, 102, 2);
            this$0.reportZPlanEntranceRedDotItemId = null;
            View findViewById = view.findViewById(R.id.f126797pq);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById<ImageView>(R.id.zplan_red_dot)");
            ((ImageView) findViewById).setVisibility(8);
        }
        EventCollector.getInstance().onViewClicked(view2);
    }

    private final void Zh(View rootView, Activity activity) {
        String str;
        VideoReport.addToDetectionWhitelist(activity);
        VideoReport.setPageId(rootView, "pg_user_avatar");
        HashMap hashMap = new HashMap();
        hashMap.put("pg_user_avatar_version", AEResManagerConfigBean.DEFAULT_VERSION);
        hashMap.put("user_avatar_type", "");
        if (Eh().isUserWearPendant()) {
            str = "1";
        } else {
            str = "2";
        }
        hashMap.put("pendant_is_visible", str);
        VideoReport.setPageParams(rootView, new PageParams(hashMap));
        VideoReport.setElementId(Eh().getHeadView(), "em_avatar");
        VideoReport.setElementId(Ph(), "em_splendid_avatar");
        VideoReport.setElementId(Mh(), "em_supper_avatar");
        VideoReport.setElementId(Lh(), "em_personal_avatar");
        VideoReport.reportEvent("pgin", rootView, hashMap);
        VideoReport.reportEvent("imp", Ph(), hashMap);
        VideoReport.reportEvent("imp", Mh(), hashMap);
        VideoReport.reportEvent("imp", Lh(), hashMap);
        VideoReport.reportEvent("imp", Eh().getHeadView(), hashMap);
    }

    private final void ai() {
        VideoReport.setElementId(Oh(), "em_bas_profile_test_mode_aigc_photo_btn");
        VideoReport.setPageId(Oh(), "pg_user_avatar");
    }

    private final void bi() {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put("zplan_avatar_edit_entrance", "2");
        hashMap.put("zplan_action_type", "click");
        VideoReport.reportEvent("ev_zplan_avatar_edit_entrance", hashMap);
    }

    private final void ci() {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put("zplan_avatar_edit_entrance", "2");
        hashMap.put("zplan_action_type", "imp");
        VideoReport.reportEvent("ev_zplan_avatar_edit_entrance", hashMap);
    }

    @SuppressLint({"WrongConstant"})
    private final void ji() {
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null) {
            qBaseActivity.setRequestedOrientation(1);
        }
    }

    @SuppressLint({"UseRequireInsteadOfGet"})
    private final void qi(int type) {
        if (!Fh().f257576v0) {
            Fh().T(this, Jh().getHeight());
        }
        Fh().W(type);
    }

    private final void registerAvatarPublishListener() {
        WinkPublishHelper2.INSTANCE.bindService(1, new b());
    }

    private final void ri(AppRuntime app) {
        boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(app, false, null);
        Dh(isNowThemeIsNight);
        Rh(isNowThemeIsNight);
        si(isNowThemeIsNight);
    }

    private final void setStatusBarImmersive() {
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            if (SystemBarActivityModule.getSystemBarComp(qBaseActivity) == null) {
                SystemBarActivityModule.setImmersiveStatus(qBaseActivity, 0);
                return;
            }
            SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusBarDrawable(null);
            SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusBarColor(0);
            SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusColor(0);
        }
    }

    private final void si(boolean isNight) {
        URLDrawable drawable = URLDrawable.getDrawable("https://tianquan.gtimg.cn/uncategorized/arno/qqvip_pendant_mall_zplan.png", (URLDrawable.URLDrawableOptions) null);
        URLDrawable drawable2 = URLDrawable.getDrawable("https://tianquan.gtimg.cn/uncategorized/arno/qqvip_pendant_mall_head.png", (URLDrawable.URLDrawableOptions) null);
        URLDrawable drawable3 = URLDrawable.getDrawable("https://tianquan.gtimg.cn/shoal/vaclient/350e32e1-45e4-4bb3-97ca-a534d0754d64.png", (URLDrawable.URLDrawableOptions) null);
        Drawable drawable4 = getRootView().getResources().getDrawable(R.drawable.qui_avatar);
        Drawable drawable5 = getRootView().getResources().getDrawable(R.drawable.myy);
        URLDrawable drawable6 = URLDrawable.getDrawable(VasToggle.VAS_AVATAR_CONFIG.getStringDataSet("highEnergyIcon", "https://tianquan.gtimg.cn/uncategorized/arno/splendidicon.png"), (URLDrawable.URLDrawableOptions) null);
        if (isNight) {
            getRootView().setBackgroundColor(-16777216);
            Mh().setTextColor(-1);
            Lh().setTextColor(-1);
            Ph().setTextColor(-1);
            drawable3.setColorFilter(Color.parseColor("#7affffff"), PorterDuff.Mode.SRC_IN);
            drawable4.setColorFilter(Color.parseColor("#7affffff"), PorterDuff.Mode.SRC_IN);
            drawable6.setColorFilter(Color.parseColor("#7affffff"), PorterDuff.Mode.SRC_IN);
            drawable.setColorFilter(Color.parseColor("#7affffff"), PorterDuff.Mode.SRC_IN);
            drawable2.setColorFilter(Color.parseColor("#7affffff"), PorterDuff.Mode.SRC_IN);
            drawable5.setColorFilter(Color.parseColor("#7affffff"), PorterDuff.Mode.SRC_IN);
        } else {
            drawable.clearColorFilter();
            drawable2.clearColorFilter();
            drawable6.clearColorFilter();
            drawable5.clearColorFilter();
            drawable3.clearColorFilter();
            drawable4.clearColorFilter();
        }
        drawable6.setBounds(new Rect(0, 0, ViewUtils.dip2px(16.0f), ViewUtils.dip2px(16.0f)));
        Ph().setCompoundDrawables(drawable6, null, null, null);
        drawable.setBounds(new Rect(0, 0, ViewUtils.dip2px(16.0f), ViewUtils.dip2px(16.0f)));
        Mh().setCompoundDrawables(drawable, null, null, null);
        drawable2.setBounds(new Rect(0, 0, ViewUtils.dip2px(16.0f), ViewUtils.dip2px(16.0f)));
        Lh().setCompoundDrawables(drawable2, null, null, null);
        drawable5.setBounds(new Rect(0, 0, ViewUtils.dip2px(16.0f), ViewUtils.dip2px(16.0f)));
        ((ImageView) getRootView().findViewById(R.id.f236406z)).setImageDrawable(drawable3);
        ((ImageView) getRootView().findViewById(R.id.f2366071)).setImageDrawable(drawable4);
    }

    private final void unregisterAvatarPublishListener() {
        WinkPublishServiceProxy2 winkPublishServiceProxy2 = this.winkPublishService;
        if (winkPublishServiceProxy2 != null) {
            winkPublishServiceProxy2.removeTaskListener(Ih());
        }
    }

    @NotNull
    public final IAvatarPendantView Eh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (IAvatarPendantView) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        Object value = this.avatarPendantView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-avatarPendantView>(...)");
        return (IAvatarPendantView) value;
    }

    @NotNull
    public final ShopHalfScreenFloatingView Fh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ShopHalfScreenFloatingView) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        ShopHalfScreenFloatingView shopHalfScreenFloatingView = this.avatarShopListPopupWindow;
        if (shopHalfScreenFloatingView != null) {
            return shopHalfScreenFloatingView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("avatarShopListPopupWindow");
        return null;
    }

    @NotNull
    public final ViewGroup Gh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (ViewGroup) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        ViewGroup viewGroup = this.layoutAvatarPendantParent;
        if (viewGroup != null) {
            return viewGroup;
        }
        Intrinsics.throwUninitializedPropertyAccessException("layoutAvatarPendantParent");
        return null;
    }

    @NotNull
    public final ImageView Hh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (ImageView) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        ImageView imageView = this.layoutHeadBg;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("layoutHeadBg");
        return null;
    }

    @NotNull
    public final ViewGroup Jh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ViewGroup) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        ViewGroup viewGroup = this.pendantShopLayout;
        if (viewGroup != null) {
            return viewGroup;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pendantShopLayout");
        return null;
    }

    @NotNull
    public final PendantAvatarShopLayout Kh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (PendantAvatarShopLayout) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        PendantAvatarShopLayout pendantAvatarShopLayout = this.pendantShopView;
        if (pendantAvatarShopLayout != null) {
            return pendantAvatarShopLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pendantShopView");
        return null;
    }

    @NotNull
    public final Button Lh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Button) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        Button button = this.personalAvatarBut;
        if (button != null) {
            return button;
        }
        Intrinsics.throwUninitializedPropertyAccessException("personalAvatarBut");
        return null;
    }

    @NotNull
    public final Button Mh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Button) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        Button button = this.qqShowAvatarBut;
        if (button != null) {
            return button;
        }
        Intrinsics.throwUninitializedPropertyAccessException("qqShowAvatarBut");
        return null;
    }

    @NotNull
    public final AvatarPendantEventReceiver Nh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (AvatarPendantEventReceiver) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        AvatarPendantEventReceiver avatarPendantEventReceiver = this.receiver;
        if (avatarPendantEventReceiver != null) {
            return avatarPendantEventReceiver;
        }
        Intrinsics.throwUninitializedPropertyAccessException("receiver");
        return null;
    }

    @NotNull
    public final ImageView Oh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (ImageView) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        ImageView imageView = this.splendidAvatarBanner;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("splendidAvatarBanner");
        return null;
    }

    @NotNull
    public final Button Ph() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Button) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        Button button = this.splendidAvatarBut;
        if (button != null) {
            return button;
        }
        Intrinsics.throwUninitializedPropertyAccessException("splendidAvatarBut");
        return null;
    }

    @NotNull
    public final ImageView Qh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (ImageView) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        ImageView imageView = this.splendidExtendIcon;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("splendidExtendIcon");
        return null;
    }

    public final void di(@NotNull ShopHalfScreenFloatingView shopHalfScreenFloatingView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) shopHalfScreenFloatingView);
        } else {
            Intrinsics.checkNotNullParameter(shopHalfScreenFloatingView, "<set-?>");
            this.avatarShopListPopupWindow = shopHalfScreenFloatingView;
        }
    }

    public final void ei(@NotNull ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) viewGroup);
        } else {
            Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
            this.layoutAvatarPendantParent = viewGroup;
        }
    }

    public final void fi(@NotNull ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) imageView);
        } else {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.layoutHeadBg = imageView;
        }
    }

    @NotNull
    public final View getRootView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (View) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        View view = this.rootView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        return null;
    }

    public final void gi(@NotNull ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) viewGroup);
        } else {
            Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
            this.pendantShopLayout = viewGroup;
        }
    }

    public final void hi(@NotNull PendantAvatarShopLayout pendantAvatarShopLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) pendantAvatarShopLayout);
        } else {
            Intrinsics.checkNotNullParameter(pendantAvatarShopLayout, "<set-?>");
            this.pendantShopView = pendantAvatarShopLayout;
        }
    }

    public final void ii(@NotNull Button button) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) button);
        } else {
            Intrinsics.checkNotNullParameter(button, "<set-?>");
            this.personalAvatarBut = button;
        }
    }

    public final void ki(@NotNull Button button) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) button);
        } else {
            Intrinsics.checkNotNullParameter(button, "<set-?>");
            this.qqShowAvatarBut = button;
        }
    }

    public final void li(@NotNull AvatarPendantEventReceiver avatarPendantEventReceiver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) avatarPendantEventReceiver);
        } else {
            Intrinsics.checkNotNullParameter(avatarPendantEventReceiver, "<set-?>");
            this.receiver = avatarPendantEventReceiver;
        }
    }

    public final void mi(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.rootView = view;
        }
    }

    public final void ni(@NotNull ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) imageView);
        } else {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.splendidAvatarBanner = imageView;
        }
    }

    public final void oi(@NotNull Button button) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) button);
        } else {
            Intrinsics.checkNotNullParameter(button, "<set-?>");
            this.splendidAvatarBut = button;
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
        } else {
            super.onActivityResult(requestCode, resultCode, data);
            Eh().doOnActivityResult(requestCode, resultCode, data);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) newConfig);
            return;
        }
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if (VasToggle.BUG_102297741.isEnable(true) && Fh() != null && Fh().getVisibility() == 0) {
            Fh().t();
        }
    }

    @Override // com.tencent.mobileqq.vas.base.VasQPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) savedInstanceState);
        } else {
            super.onCreate(savedInstanceState);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @TargetApi(14)
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            inflate = (View) iPatchRedirector.redirect((short) 31, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            inflate = inflater.inflate(R.layout.hha, container, false);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.vas.base.VasQPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this);
            return;
        }
        super.onDestroy();
        Eh().doOnDestroy();
        Nh().e();
    }

    @Override // com.tencent.mobileqq.vas.base.VasQPublicBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this);
        } else {
            unregisterAvatarPublishListener();
            super.onDestroyView();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(@Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) intent);
        } else {
            super.onNewIntent(intent);
            Eh().doOnNewIntent(intent);
        }
    }

    @Override // com.tencent.mobileqq.vas.base.VasQPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this);
        } else {
            super.onPause();
            Eh().doOnPause();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this);
            return;
        }
        super.onPostThemeChanged();
        setStatusBarImmersive();
        ri(MobileQQ.sMobileQQ.peekAppRuntime());
    }

    @Override // com.tencent.mobileqq.vas.base.VasQPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
            return;
        }
        super.onResume();
        Eh().doOnResume();
        Fh().S();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull final View view, @Nullable Bundle savedInstanceState) {
        boolean z16;
        int i3;
        final Drawable apngDrawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ji();
        setStatusBarImmersive();
        Eh().initView(getQBaseActivity());
        mi(view);
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.f2367072);
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) layoutParams).topMargin = ImmersiveUtils.getStatusBarHeight(view.getContext());
        viewGroup.findViewById(R.id.f236406z).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.pendant.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AvatarPendantShopFragment.Th(AvatarPendantShopFragment.this, view2);
            }
        });
        viewGroup.findViewById(R.id.f2366071).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.pendant.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AvatarPendantShopFragment.Uh(AvatarPendantShopFragment.this, view2);
            }
        });
        View findViewById = view.findViewById(R.id.kgl);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById<ViewGr\u2026>(R.id.ui_avatar_pendant)");
        ei((ViewGroup) findViewById);
        View findViewById2 = view.findViewById(R.id.kgw);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById<ImageV\u2026.id.ui_widget_display_bg)");
        fi((ImageView) findViewById2);
        Gh().addView(Eh().getHeadView(), new RelativeLayout.LayoutParams(-1, -1));
        View findViewById3 = view.findViewById(R.id.f66733bf);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById<ShopHa\u2026qus_floating_half_screen)");
        di((ShopHalfScreenFloatingView) findViewById3);
        View findViewById4 = view.findViewById(R.id.til);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById<Button>(R.id.but_splendid)");
        oi((Button) findViewById4);
        View findViewById5 = view.findViewById(R.id.xjh);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById<ImageView>(R.id.img_extend)");
        pi((ImageView) findViewById5);
        View findViewById6 = view.findViewById(R.id.f87434uc);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById<ImageV\u2026d.splendid_avatar_banner)");
        ni((ImageView) findViewById6);
        final ImageView Oh = Oh();
        ToggleProxy toggleProxy = VasToggle.VAS_AVATAR_CONFIG;
        final String stringDataSet = toggleProxy.getStringDataSet("highEnergyBannerUrl", "");
        if (stringDataSet == null) {
            stringDataSet = "";
        }
        String stringDataSet2 = toggleProxy.getStringDataSet("contentDescription", "");
        if (stringDataSet2 == null) {
            stringDataSet2 = "";
        }
        if (!TextUtils.isEmpty(stringDataSet2)) {
            Oh.setContentDescription(stringDataSet2);
        }
        QRouteApi api = QRoute.api(IQQAvatarAigcMagicAvatarApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQQAvatarAigcMagicAvatarApi::class.java)");
        IQQAvatarAigcMagicAvatarApi iQQAvatarAigcMagicAvatarApi = (IQQAvatarAigcMagicAvatarApi) api;
        boolean checkIsMagicAvatar = iQQAvatarAigcMagicAvatarApi.checkIsMagicAvatar(toggleProxy.getJson());
        if (checkIsMagicAvatar) {
            z16 = iQQAvatarAigcMagicAvatarApi.enableAigcMagicAvatar();
        } else {
            z16 = true;
        }
        if (!Intrinsics.areEqual(stringDataSet, "") && z16) {
            IVasApngFactory.Companion companion = IVasApngFactory.INSTANCE;
            if (companion.getENABLE_CACHE_DRAWABLE()) {
                apngDrawable = com.tencent.cachedrawable.dynamicdrawable.api.a.a().k(stringDataSet).l(VasDynamicDrawableCache.INSTANCE).a();
            } else {
                apngDrawable = companion.api().getApngDrawable("AvatarPendantShopFragment", stringDataSet);
            }
            final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>(apngDrawable, this, Oh) { // from class: com.tencent.mobileqq.pendant.AvatarPendantShopFragment$onViewCreated$2$reCalHeight$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Drawable $extendIconDrawable;
                final /* synthetic */ ImageView $this_with;
                final /* synthetic */ AvatarPendantShopFragment this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$extendIconDrawable = apngDrawable;
                    this.this$0 = this;
                    this.$this_with = Oh;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, apngDrawable, this, Oh);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i16) {
                    int screenWidth;
                    int dpToPx;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, i16);
                        return;
                    }
                    int intrinsicWidth = this.$extendIconDrawable.getIntrinsicWidth();
                    if (i16 == 0) {
                        i16 = this.$extendIconDrawable.getIntrinsicHeight();
                    }
                    if (intrinsicWidth == 0 || i16 == 0) {
                        return;
                    }
                    float f16 = i16 / intrinsicWidth;
                    if (f16 > 0.6f) {
                        f16 = 0.11f;
                    }
                    ViewGroup.LayoutParams layoutParams2 = this.this$0.Oh().getLayoutParams();
                    if (PadUtil.a(this.$this_with.getContext()) == DeviceType.FOLD) {
                        screenWidth = m.d();
                        dpToPx = ViewUtils.dpToPx(24.0f);
                    } else {
                        screenWidth = ViewUtils.getScreenWidth();
                        dpToPx = ViewUtils.dpToPx(24.0f);
                    }
                    layoutParams2.height = (int) ((screenWidth - dpToPx) * f16);
                }
            };
            function1.invoke(Integer.valueOf((int) (((ScreenUtil.getInstantScreenWidth(Oh.getContext()) - ViewUtils.dpToPx(24.0f)) / 48.0f) * 5)));
            if (companion.getENABLE_CACHE_DRAWABLE() && (apngDrawable instanceof FastDynamicDrawable)) {
                ((FastDynamicDrawable) apngDrawable).c0(new Function1<com.tencent.cachedrawable.dynamicdrawable.d, Unit>(function1, apngDrawable) { // from class: com.tencent.mobileqq.pendant.AvatarPendantShopFragment$onViewCreated$2$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Drawable $extendIconDrawable;
                    final /* synthetic */ Function1<Integer, Unit> $reCalHeight;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                        this.$reCalHeight = function1;
                        this.$extendIconDrawable = apngDrawable;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) function1, (Object) apngDrawable);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.cachedrawable.dynamicdrawable.d dVar) {
                        invoke2(dVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull com.tencent.cachedrawable.dynamicdrawable.d it) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        } else {
                            Intrinsics.checkNotNullParameter(it, "it");
                            this.$reCalHeight.invoke(Integer.valueOf(((FastDynamicDrawable) this.$extendIconDrawable).getIntrinsicHeight()));
                        }
                    }
                });
            } else {
                Intrinsics.checkNotNull(apngDrawable, "null cannot be cast to non-null type com.tencent.mobileqq.vas.ui.APNGDrawable");
                ((APNGDrawable) apngDrawable).setLoadedListener(new Function1<IDynamicDrawable, Unit>(function1, apngDrawable) { // from class: com.tencent.mobileqq.pendant.AvatarPendantShopFragment$onViewCreated$2$2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Drawable $extendIconDrawable;
                    final /* synthetic */ Function1<Integer, Unit> $reCalHeight;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                        this.$reCalHeight = function1;
                        this.$extendIconDrawable = apngDrawable;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) function1, (Object) apngDrawable);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(IDynamicDrawable iDynamicDrawable) {
                        invoke2(iDynamicDrawable);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull IDynamicDrawable it) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        } else {
                            Intrinsics.checkNotNullParameter(it, "it");
                            this.$reCalHeight.invoke(Integer.valueOf(((APNGDrawable) this.$extendIconDrawable).getHeight()));
                        }
                    }
                });
            }
            Oh.setImageDrawable(apngDrawable);
            Oh.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.pendant.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AvatarPendantShopFragment.Vh(AvatarPendantShopFragment.this, stringDataSet, view2);
                }
            });
            if (checkIsMagicAvatar) {
                ai();
            }
            ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onHeadSplendidItem(101, stringDataSet);
        } else {
            Oh().getLayoutParams().height = 0;
        }
        Eh().setAvatarChangeListener(new IAvatarPendantView.a() { // from class: com.tencent.mobileqq.pendant.e
            @Override // com.tencent.mobileqq.vas.inject.IAvatarPendantView.a
            public final void a() {
                AvatarPendantShopFragment.Wh(AvatarPendantShopFragment.this);
            }
        });
        Ph().setVisibility(8);
        View findViewById7 = view.findViewById(R.id.xjh);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById<ImageView>(R.id.img_extend)");
        pi((ImageView) findViewById7);
        ImageView Qh = Qh();
        String stringDataSet3 = toggleProxy.getStringDataSet("extendIcon", "");
        if (!Intrinsics.areEqual(stringDataSet3, "") && Ph().getVisibility() == 0) {
            Qh.setImageDrawable(URLDrawable.getDrawable(stringDataSet3, (URLDrawable.URLDrawableOptions) null));
            i3 = 0;
        } else {
            i3 = 8;
        }
        Qh.setVisibility(i3);
        View findViewById8 = view.findViewById(R.id.tii);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById<Button>(R.id.but_qq_show)");
        ki((Button) findViewById8);
        if (Eh().enableZplanAvatar()) {
            Mh().setVisibility(0);
            if (com.tencent.relation.common.config.toggle.c.D.g(false)) {
                ci();
            }
            Eh().setOnZplanAvatarUpdateListener(new IAvatarPendantView.OnZplanAvatarUpdateListener() { // from class: com.tencent.mobileqq.pendant.f
                @Override // com.tencent.mobileqq.vas.inject.IAvatarPendantView.OnZplanAvatarUpdateListener
                public final void onZplanAvatarUpdate() {
                    AvatarPendantShopFragment.Xh(AvatarPendantShopFragment.this);
                }
            });
            Mh().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.pendant.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AvatarPendantShopFragment.Yh(AvatarPendantShopFragment.this, view, view2);
                }
            });
            ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onHeadQQShowItem(101);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            View findViewById9 = view.findViewById(R.id.f126797pq);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById<ImageView>(R.id.zplan_red_dot)");
            ImageView imageView = (ImageView) findViewById9;
            imageView.setVisibility(8);
            ((IZPlanApi) QRoute.api(IZPlanApi.class)).requestAvatarEditEntranceRedDotData(new AvatarPendantShopFragment$onViewCreated$7(this, peekAppRuntime, view, imageView));
        } else {
            Mh().setVisibility(8);
        }
        View findViewById10 = view.findViewById(R.id.tih);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "view.findViewById<Button\u2026R.id.but_personal_avatar)");
        ii((Button) findViewById10);
        Lh().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.pendant.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AvatarPendantShopFragment.Sh(AvatarPendantShopFragment.this, view2);
            }
        });
        View findViewById11 = view.findViewById(R.id.f2365070);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "view.findViewById<ShopHa\u2026R.id.pendant_shop_layout)");
        gi((ViewGroup) findViewById11);
        hi(new PendantAvatarShopLayout(getContext()));
        Kh().f257526g = 4;
        Kh().y(this);
        Jh().addView(Kh().t());
        Kh().E();
        for (AdComponent adComponent : this.components) {
            adComponent.d((ViewGroup) view);
        }
        AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
        ri(peekAppRuntime2);
        li(new AvatarPendantEventReceiver());
        Nh().d(this);
        Nh().b();
        ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onShopFirstViewExpose();
        ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onShopHeadViewExpose();
        ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onPendantShopExpose();
        ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onPendantTabItemExpose(0);
        ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onPayBanner(101);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Zh(view, requireActivity);
        IRuntimeService runtimeService = peekAppRuntime2.getRuntimeService(IQQAvatarDataService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026ssConstant.MAIN\n        )");
        ((IQQAvatarDataService) runtimeService).getCustomFaceFilePath(1, peekAppRuntime2.getCurrentUin(), 0);
        IRuntimeService runtimeService2 = peekAppRuntime2.getRuntimeService(IProfileDataService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService2, "app.getRuntimeService(IP\u2026va, ProcessConstant.MAIN)");
        ((IProfileDataService) runtimeService2).getProfileCard(peekAppRuntime2.getCurrentUin(), false);
        ((IQQAvatarUtilApi) QRoute.api(IQQAvatarUtilApi.class)).getDefaultFaceDrawable(true);
        ((IZPlanEditAvatarApi) QRoute.api(IZPlanEditAvatarApi.class)).preRecordActionInMall(peekAppRuntime2);
        registerAvatarPublishListener();
    }

    public final void pi(@NotNull ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) imageView);
        } else {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.splendidExtendIcon = imageView;
        }
    }

    @Override // com.tencent.mobileqq.pad.f
    public boolean qOnBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Boolean) iPatchRedirector.redirect((short) 43, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.pad.f
    public void qOnNewIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this);
            return;
        }
        try {
            Bundle arguments = getArguments();
            if (arguments == null) {
                return;
            }
            onNewIntent(new Intent().putExtras(arguments));
        } catch (Exception e16) {
            QLog.e("AvatarPendantShopFragment", 1, "qOnNewIntent exception", e16);
        }
    }

    @Override // com.tencent.mobileqq.vas.base.VasQPublicBaseFragment
    @NotNull
    protected String rh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (String) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return "vase_avatar_pendant_shop";
    }
}
