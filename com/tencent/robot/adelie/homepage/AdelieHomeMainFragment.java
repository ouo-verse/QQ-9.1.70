package com.tencent.robot.adelie.homepage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import com.google.android.material.tabs.TabLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.guild.nt.misc.api.IJumpApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.peak.api.IPeakHelperApi;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;
import com.tencent.robot.adelie.homepage.category.AdelieHomeCategoryFragment;
import com.tencent.robot.adelie.homepage.category.AdelieHomeCategoryKuiklyFragment;
import com.tencent.robot.adelie.homepage.guide.AdelieGuideAutoControllerImpl;
import com.tencent.robot.adelie.homepage.maintab.IconTextTab;
import com.tencent.robot.adelie.homepage.maintab.PlusIconTab;
import com.tencent.robot.adelie.homepage.maintab.TabType;
import com.tencent.robot.adelie.homepage.mine.AdelieHomeMineFragment;
import com.tencent.robot.adelie.homepage.mine.AdelieHomeMineKuiklyFragment;
import com.tencent.robot.adelie.reddot.AdelieRedDotManager;
import com.tencent.robot.qqmc.RobotQQMC;
import com.tencent.widget.PopupMenuDialog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\b*\u0002\u008b\u0001\u0018\u0000 \u0090\u00012\u00020\u0001:\u0002\u0091\u0001B\t\u00a2\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u001c\u0010\u0013\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0003J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\f\u0010\u0016\u001a\u00020\u0006*\u00020\u0015H\u0002J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0006H\u0002J\b\u0010\u001d\u001a\u00020\u0006H\u0002J\u0016\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u001eH\u0002J\b\u0010!\u001a\u00020 H\u0002J\n\u0010\"\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010#\u001a\u00020\u0017H\u0002J\b\u0010$\u001a\u00020\u0017H\u0002J\b\u0010%\u001a\u00020\u0017H\u0002J\b\u0010&\u001a\u00020\u0006H\u0002J\u0012\u0010)\u001a\u00020\u00062\b\u0010(\u001a\u0004\u0018\u00010'H\u0002J\u0012\u0010+\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020 H\u0002J\b\u0010,\u001a\u00020\u0006H\u0002J\b\u0010-\u001a\u00020\u0006H\u0002J\b\u0010.\u001a\u00020\u0006H\u0002J\b\u0010/\u001a\u00020 H\u0016J\b\u00101\u001a\u000200H\u0014J\u0012\u00104\u001a\u00020\u00062\b\u00103\u001a\u0004\u0018\u000102H\u0016J\b\u00105\u001a\u00020\u0006H\u0016J$\u00106\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u00103\u001a\u0004\u0018\u000102H\u0014J\b\u00107\u001a\u00020\u0006H\u0016J\b\u00108\u001a\u00020\u0006H\u0016J\b\u00109\u001a\u00020\u0006H\u0016J\b\u0010:\u001a\u00020 H\u0016J\u0010\u0010=\u001a\u00020\u00062\u0006\u0010<\u001a\u00020;H\u0016J\b\u0010>\u001a\u00020\u0006H\u0016J\b\u0010?\u001a\u00020 H\u0016J\b\u0010@\u001a\u00020 H\u0014J\b\u0010A\u001a\u00020 H\u0016J\b\u0010B\u001a\u00020 H\u0016J\b\u0010C\u001a\u00020 H\u0016J\b\u0010D\u001a\u00020 H\u0016R\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010K\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010M\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010JR\u0018\u0010O\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010JR\u0016\u0010R\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Y\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010\\\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010`\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010d\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010f\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010cR\u0018\u0010j\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010l\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010iR\u0018\u0010p\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010t\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010sR\u001b\u0010z\u001a\u00020u8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bv\u0010w\u001a\u0004\bx\u0010yR\u001b\u0010}\u001a\u00020u8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b{\u0010w\u001a\u0004\b|\u0010yR\u001c\u0010\u0080\u0001\u001a\u00020u8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b~\u0010w\u001a\u0004\b\u007f\u0010yR\u001c\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0018\u0010\u0086\u0001\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0085\u0001\u0010QR\u0018\u0010\u0088\u0001\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0087\u0001\u0010QR\u0016\u0010\u008a\u0001\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0089\u0001\u0010QR\u0017\u0010\u008d\u0001\u001a\u00030\u008b\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bQ\u0010\u008c\u0001\u00a8\u0006\u0092\u0001"}, d2 = {"Lcom/tencent/robot/adelie/homepage/AdelieHomeMainFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "", "ai", "Zh", "li", "Landroidx/fragment/app/Fragment;", "Kh", "Yh", "Landroid/content/Context;", "context", "Wh", "Lcom/tencent/robot/adelie/homepage/maintab/b;", "fromTab", "toTab", "Jh", "ki", "Lcom/google/android/material/tabs/TabLayout;", "ei", "Lcom/tencent/biz/qui/quisecnavbar/a;", "action", "", "elementId", "Th", "Vh", "Uh", "", "Oh", "", "di", "Sh", "Qh", "Rh", "Ph", "mi", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "gi", "playNextTime", "bi", WidgetCacheLunarData.JI, "oi", "ii", "isAllowLandscape", "", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "onPostThemeChanged", "doOnCreateView", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, DKHippyEvent.EVENT_STOP, "onBackEvent", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "useQUISecNavBar", OpenHippyInfo.EXTRA_KEY_IS_TRANSPARENT, "secNavBarNeedImmersive", "needImmersive", "needStatusTrans", "isWrapContent", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "gradientBg", "D", "Lcom/tencent/biz/qui/quisecnavbar/a;", "searchIcon", "E", "theMoreOrSettingIcon", UserInfo.SEX_FEMALE, "robotIcon", "G", "Z", "isMore", "Landroid/widget/LinearLayout;", "H", "Landroid/widget/LinearLayout;", "tabContainer", "I", "Lcom/google/android/material/tabs/TabLayout;", "tabLayout", "J", "Lcom/tencent/robot/adelie/homepage/maintab/b;", "lastSelectedTab", "Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;", "K", "Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;", "tabBlurView", "Lcom/tencent/robot/adelie/homepage/maintab/IconTextTab;", "L", "Lcom/tencent/robot/adelie/homepage/maintab/IconTextTab;", "mineIconTab", "M", "discoverIconTab", "Landroid/widget/TextView;", "N", "Landroid/widget/TextView;", "titleView", "P", "subTitleView", "Lcom/tencent/robot/adelie/homepage/guide/a;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/robot/adelie/homepage/guide/a;", "adelieGuideAutoController", "Lcom/tencent/widget/PopupMenuDialog;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/widget/PopupMenuDialog;", "morePopupMenuDialog", "Lcom/tencent/widget/PopupMenuDialog$MenuItem;", ExifInterface.LATITUDE_SOUTH, "Lkotlin/Lazy;", "Mh", "()Lcom/tencent/widget/PopupMenuDialog$MenuItem;", "MENU_ITEM_GUILD", "T", "Nh", "MENU_ITEM_SHARE", "U", "Lh", "MENU_ITEM_COMMUNITY", "Ly14/c;", "V", "Ly14/c;", "guideDialog", "W", "enableKuiklyMineFragment", "X", "enableKuiklyHomeFragment", "Y", "hasShownOldGuide", "com/tencent/robot/adelie/homepage/AdelieHomeMainFragment$kuiklyBroadcastReceiver$1", "Lcom/tencent/robot/adelie/homepage/AdelieHomeMainFragment$kuiklyBroadcastReceiver$1;", "kuiklyBroadcastReceiver", "<init>", "()V", "a0", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieHomeMainFragment extends QIphoneTitleBarFragment {

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b0, reason: collision with root package name */
    @NotNull
    private static final Lazy<String> f365920b0;

    /* renamed from: c0, reason: collision with root package name */
    @NotNull
    private static final Lazy<String> f365921c0;

    /* renamed from: d0, reason: collision with root package name */
    @NotNull
    private static final Lazy<String> f365922d0;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ImageView gradientBg;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private com.tencent.biz.qui.quisecnavbar.a searchIcon;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private com.tencent.biz.qui.quisecnavbar.a theMoreOrSettingIcon;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private com.tencent.biz.qui.quisecnavbar.a robotIcon;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isMore = true;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private LinearLayout tabContainer;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private TabLayout tabLayout;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private com.tencent.robot.adelie.homepage.maintab.b lastSelectedTab;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private QQBlurViewWrapper tabBlurView;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private IconTextTab mineIconTab;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private IconTextTab discoverIconTab;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private TextView titleView;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private TextView subTitleView;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private com.tencent.robot.adelie.homepage.guide.a adelieGuideAutoController;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private PopupMenuDialog morePopupMenuDialog;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final Lazy MENU_ITEM_GUILD;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final Lazy MENU_ITEM_SHARE;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Lazy MENU_ITEM_COMMUNITY;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private y14.c guideDialog;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean enableKuiklyMineFragment;

    /* renamed from: X, reason: from kotlin metadata */
    private boolean enableKuiklyHomeFragment;

    /* renamed from: Y, reason: from kotlin metadata */
    private final boolean hasShownOldGuide;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final AdelieHomeMainFragment$kuiklyBroadcastReceiver$1 kuiklyBroadcastReceiver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\r\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000fR\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000fR\u0014\u0010\u0017\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000fR\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u000fR\u0014\u0010\u0019\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u000fR\u0014\u0010\u001a\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u000f\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/robot/adelie/homepage/AdelieHomeMainFragment$a;", "", "", "SEARCH_URL$delegate", "Lkotlin/Lazy;", "d", "()Ljava/lang/String;", "SEARCH_URL", "SUB_TITLE_TEXT$delegate", "e", "SUB_TITLE_TEXT", "TITLE$delegate", "f", "TITLE", "BROADCAST_PARAM_SHOW_NEXT_TIME", "Ljava/lang/String;", "BROADCAST_SHOW_NATIVE_GUIDE", "DT_ELEMENT_BAS_SHARE_ICON", "DT_PARAM_SUPERIOR_SOURCE", "EV_BAS_AGENT_NOVICE_BOOT", "GRADIENT_BG_URL", "GRADIENT_NIGHT_BG_URL", "GUILD_JUMP_URL", "INTERRUPT_GUIDE_ANIMATION_EVENT", "KEY_GUIDE_SWITCH", "PAGE_CREATIVE_CENTER", "TAG", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.adelie.homepage.AdelieHomeMainFragment$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String d() {
            return (String) AdelieHomeMainFragment.f365920b0.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String e() {
            return (String) AdelieHomeMainFragment.f365921c0.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String f() {
            return (String) AdelieHomeMainFragment.f365922d0.getValue();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\r\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0010"}, d2 = {"com/tencent/robot/adelie/homepage/AdelieHomeMainFragment$b", "Lcom/tencent/biz/qui/quisecnavbar/a;", "", "c", "", "b", "Landroid/view/View;", "view", "", "a", "", "getDrawable", "()I", "drawable", "d", "drawableInTransparent", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends com.tencent.biz.qui.quisecnavbar.a {
        b() {
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        public void a(@Nullable View view) {
            Context context;
            if (AdelieHomeMainFragment.this.isMore) {
                u64.g gVar = u64.g.f438512a;
                AdelieHomeMainFragment adelieHomeMainFragment = AdelieHomeMainFragment.this;
                if (!gVar.g()) {
                    AdelieHomeMainFragment.ci(adelieHomeMainFragment, false, 1, null);
                    com.tencent.robot.adelie.homepage.guide.a aVar = adelieHomeMainFragment.adelieGuideAutoController;
                    if (aVar != null) {
                        aVar.a();
                    }
                    adelieHomeMainFragment.mi();
                    View h16 = adelieHomeMainFragment.quiSecNavBar.h(this);
                    if (h16 != null) {
                        VideoReport.reportEvent("clck", h16, null);
                        return;
                    }
                    return;
                }
                return;
            }
            u64.g gVar2 = u64.g.f438512a;
            AdelieHomeMainFragment adelieHomeMainFragment2 = AdelieHomeMainFragment.this;
            if (!gVar2.g() && (context = adelieHomeMainFragment2.getContext()) != null) {
                ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(context, com.tencent.robot.adelie.homepage.utils.n.f366680a.b("adelie_setting_page"));
                View h17 = adelieHomeMainFragment2.quiSecNavBar.h(this);
                if (h17 != null) {
                    VideoReport.reportEvent("clck", h17, null);
                }
            }
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        @NotNull
        public String b() {
            return "\u66f4\u591a\u64cd\u4f5c";
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        public boolean c() {
            return true;
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        public int d() {
            if (AdelieHomeMainFragment.this.isMore) {
                return R.drawable.qui_more_icon_allwhite_primary;
            }
            return R.drawable.qui_setting_icon_white;
        }

        @Override // com.tencent.biz.qui.quisecnavbar.b
        public int getDrawable() {
            if (AdelieHomeMainFragment.this.isMore) {
                return R.drawable.qui_more_icon_allwhite_primary;
            }
            return R.drawable.qui_setting_icon_white;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\r\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0010"}, d2 = {"com/tencent/robot/adelie/homepage/AdelieHomeMainFragment$c", "Lcom/tencent/biz/qui/quisecnavbar/a;", "", "c", "", "b", "Landroid/view/View;", "view", "", "a", "", "getDrawable", "()I", "drawable", "d", "drawableInTransparent", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c extends com.tencent.biz.qui.quisecnavbar.a {
        c() {
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        public void a(@Nullable View view) {
            u64.g gVar = u64.g.f438512a;
            AdelieHomeMainFragment adelieHomeMainFragment = AdelieHomeMainFragment.this;
            if (!gVar.g()) {
                AdelieHomeMainFragment.ci(adelieHomeMainFragment, false, 1, null);
                com.tencent.robot.adelie.homepage.guide.a aVar = adelieHomeMainFragment.adelieGuideAutoController;
                if (aVar != null) {
                    aVar.a();
                }
                Context it = adelieHomeMainFragment.getContext();
                if (it != null) {
                    com.tencent.robot.adelie.homepage.utils.n nVar = com.tencent.robot.adelie.homepage.utils.n.f366680a;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    nVar.f(it, AdelieHomeMainFragment.INSTANCE.d());
                    View h16 = adelieHomeMainFragment.quiSecNavBar.h(this);
                    if (h16 != null) {
                        VideoReport.reportEvent("clck", h16, null);
                    }
                }
            }
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        @NotNull
        public String b() {
            return "\u641c\u7d22";
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        public boolean c() {
            return true;
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        public int d() {
            return R.drawable.qui_search_icon_white;
        }

        @Override // com.tencent.biz.qui.quisecnavbar.b
        public int getDrawable() {
            return R.drawable.qui_search_icon_white;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\r\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0010"}, d2 = {"com/tencent/robot/adelie/homepage/AdelieHomeMainFragment$d", "Lcom/tencent/biz/qui/quisecnavbar/a;", "", "c", "", "b", "Landroid/view/View;", "view", "", "a", "", "getDrawable", "()I", "drawable", "d", "drawableInTransparent", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class d extends com.tencent.biz.qui.quisecnavbar.a {
        d() {
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        public void a(@Nullable View view) {
            Context it;
            u64.g gVar = u64.g.f438512a;
            AdelieHomeMainFragment adelieHomeMainFragment = AdelieHomeMainFragment.this;
            if (!gVar.g() && (it = adelieHomeMainFragment.getContext()) != null) {
                String jumpUrl = RobotQQMC.INSTANCE.getRobotAssistantUrl().getJumpUrl();
                com.tencent.robot.adelie.homepage.utils.n nVar = com.tencent.robot.adelie.homepage.utils.n.f366680a;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                nVar.f(it, jumpUrl);
                View h16 = adelieHomeMainFragment.quiSecNavBar.h(this);
                if (h16 != null) {
                    VideoReport.reportEvent("clck", h16, null);
                }
            }
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        @NotNull
        public String b() {
            return "\u521b\u4f5c\u5c0f\u52a9\u624b";
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        public boolean c() {
            return true;
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        public int d() {
            return R.drawable.qui_ai_assistant_icon_white;
        }

        @Override // com.tencent.biz.qui.quisecnavbar.b
        public int getDrawable() {
            return R.drawable.qui_ai_assistant_icon_white;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/robot/adelie/homepage/AdelieHomeMainFragment$e", "Lcom/google/android/material/tabs/TabLayout$d;", "Lcom/google/android/material/tabs/TabLayout$g;", "tab", "", "onTabSelected", "onTabReselected", "onTabUnselected", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class e implements TabLayout.d {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f365927e;

        e(Context context) {
            this.f365927e = context;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabReselected(@NotNull TabLayout.g tab) {
            com.tencent.robot.adelie.homepage.maintab.b bVar;
            Intrinsics.checkNotNullParameter(tab, "tab");
            QLog.i("AdelieHomeMainFragment", 1, "onTabReselected: " + com.tencent.robot.adelie.homepage.maintab.b.INSTANCE.a(tab));
            KeyEvent.Callback e16 = tab.e();
            if (e16 instanceof com.tencent.robot.adelie.homepage.maintab.b) {
                bVar = (com.tencent.robot.adelie.homepage.maintab.b) e16;
            } else {
                bVar = null;
            }
            if (bVar == null) {
                return;
            }
            AdelieHomeMainFragment adelieHomeMainFragment = AdelieHomeMainFragment.this;
            adelieHomeMainFragment.Jh(adelieHomeMainFragment.lastSelectedTab, bVar);
            com.tencent.robot.adelie.homepage.guide.a aVar = AdelieHomeMainFragment.this.adelieGuideAutoController;
            if (aVar != null) {
                aVar.a();
            }
            bVar.a(this.f365927e);
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabSelected(@NotNull TabLayout.g tab) {
            com.tencent.robot.adelie.homepage.maintab.b bVar;
            Intrinsics.checkNotNullParameter(tab, "tab");
            QLog.i("AdelieHomeMainFragment", 1, "onTabSelected: " + com.tencent.robot.adelie.homepage.maintab.b.INSTANCE.a(tab));
            KeyEvent.Callback e16 = tab.e();
            if (e16 instanceof com.tencent.robot.adelie.homepage.maintab.b) {
                bVar = (com.tencent.robot.adelie.homepage.maintab.b) e16;
            } else {
                bVar = null;
            }
            if (bVar == null) {
                return;
            }
            AdelieHomeMainFragment adelieHomeMainFragment = AdelieHomeMainFragment.this;
            adelieHomeMainFragment.Jh(adelieHomeMainFragment.lastSelectedTab, bVar);
            com.tencent.robot.adelie.homepage.guide.a aVar = AdelieHomeMainFragment.this.adelieGuideAutoController;
            if (aVar != null) {
                aVar.a();
            }
            bVar.a(this.f365927e);
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabUnselected(@NotNull TabLayout.g tab) {
            Intrinsics.checkNotNullParameter(tab, "tab");
        }
    }

    static {
        Lazy<String> lazy;
        Lazy<String> lazy2;
        Lazy<String> lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.robot.adelie.homepage.AdelieHomeMainFragment$Companion$SEARCH_URL$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return RobotQQMC.INSTANCE.getHomePageSearchConfig().getUrl();
            }
        });
        f365920b0 = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.robot.adelie.homepage.AdelieHomeMainFragment$Companion$SUB_TITLE_TEXT$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return RobotQQMC.INSTANCE.getHomePageSubTitleText().getSubText();
            }
        });
        f365921c0 = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.robot.adelie.homepage.AdelieHomeMainFragment$Companion$TITLE$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return RobotQQMC.INSTANCE.getHomePageSubTitleText().getTitle();
            }
        });
        f365922d0 = lazy3;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.tencent.robot.adelie.homepage.AdelieHomeMainFragment$kuiklyBroadcastReceiver$1] */
    public AdelieHomeMainFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<PopupMenuDialog.MenuItem>() { // from class: com.tencent.robot.adelie.homepage.AdelieHomeMainFragment$MENU_ITEM_GUILD$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PopupMenuDialog.MenuItem invoke() {
                PopupMenuDialog.MenuItem menuItem = new PopupMenuDialog.MenuItem();
                AdelieHomeMainFragment adelieHomeMainFragment = AdelieHomeMainFragment.this;
                menuItem.f384641id = R.string.f159041r9;
                menuItem.title = adelieHomeMainFragment.getString(R.string.f159041r9);
                menuItem.contentDescription = adelieHomeMainFragment.getString(R.string.f159041r9);
                menuItem.iconId = R.drawable.qui_channel;
                menuItem.titleColorRes = R.color.qui_common_text_primary;
                return menuItem;
            }
        });
        this.MENU_ITEM_GUILD = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<PopupMenuDialog.MenuItem>() { // from class: com.tencent.robot.adelie.homepage.AdelieHomeMainFragment$MENU_ITEM_SHARE$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PopupMenuDialog.MenuItem invoke() {
                PopupMenuDialog.MenuItem menuItem = new PopupMenuDialog.MenuItem();
                AdelieHomeMainFragment adelieHomeMainFragment = AdelieHomeMainFragment.this;
                menuItem.f384641id = R.string.f159051r_;
                menuItem.title = adelieHomeMainFragment.getString(R.string.f159051r_);
                menuItem.contentDescription = adelieHomeMainFragment.getString(R.string.f159051r_);
                menuItem.iconId = R.drawable.qui_share;
                menuItem.titleColorRes = R.color.qui_common_text_primary;
                return menuItem;
            }
        });
        this.MENU_ITEM_SHARE = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<PopupMenuDialog.MenuItem>() { // from class: com.tencent.robot.adelie.homepage.AdelieHomeMainFragment$MENU_ITEM_COMMUNITY$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PopupMenuDialog.MenuItem invoke() {
                PopupMenuDialog.MenuItem menuItem = new PopupMenuDialog.MenuItem();
                AdelieHomeMainFragment adelieHomeMainFragment = AdelieHomeMainFragment.this;
                menuItem.f384641id = R.string.f159031r8;
                menuItem.title = adelieHomeMainFragment.getString(R.string.f159031r8);
                menuItem.contentDescription = adelieHomeMainFragment.getString(R.string.f159031r8);
                menuItem.iconId = R.drawable.qui_files;
                menuItem.titleColorRes = R.color.qui_common_text_primary;
                return menuItem;
            }
        });
        this.MENU_ITEM_COMMUNITY = lazy3;
        RobotQQMC robotQQMC = RobotQQMC.INSTANCE;
        this.enableKuiklyMineFragment = true ^ robotQQMC.disableCreativeCenterNtCpmpose();
        this.enableKuiklyHomeFragment = robotQQMC.enableCategoryHomeNtCompose();
        this.hasShownOldGuide = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool("adelie_home_page_guide_switch", false);
        this.kuiklyBroadcastReceiver = new BroadcastReceiver() { // from class: com.tencent.robot.adelie.homepage.AdelieHomeMainFragment$kuiklyBroadcastReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                String str;
                if (intent != null) {
                    str = intent.getStringExtra(AdMetricTag.EVENT_NAME);
                } else {
                    str = null;
                }
                QLog.i("AdelieHomeMainFragment", 1, "kuiklyBroadcastReceiver onReceive " + str);
                if (Intrinsics.areEqual(str, "adelie_show_native_guide")) {
                    QLog.i("AdelieHomeMainFragment", 1, "kuiklyBroadcastReceiver showGuide");
                    com.tencent.robot.adelie.homepage.guide.a aVar = AdelieHomeMainFragment.this.adelieGuideAutoController;
                    if (aVar != null) {
                        aVar.c();
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CommitTransaction"})
    public final void Jh(com.tencent.robot.adelie.homepage.maintab.b fromTab, com.tencent.robot.adelie.homepage.maintab.b toTab) {
        Fragment fragment;
        if (toTab == null || Intrinsics.areEqual(fromTab, toTab)) {
            return;
        }
        if (!(toTab instanceof PlusIconTab)) {
            if (fromTab != null) {
                fromTab.setTabSelected(false);
            }
            toTab.setTabSelected(true);
            this.lastSelectedTab = toTab;
        }
        Fragment fragment2 = toTab.getFragment();
        if (fragment2 == null) {
            return;
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        FragmentTransaction beginTransaction = childFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "manager.beginTransaction()");
        if (fromTab != null) {
            fragment = childFragmentManager.findFragmentByTag(fromTab.getDesc());
        } else {
            fragment = null;
        }
        if (fragment != null) {
            beginTransaction.hide(fragment);
            fragment.onPause();
        }
        Fragment findFragmentByTag = childFragmentManager.findFragmentByTag(toTab.getDesc());
        if (findFragmentByTag == null) {
            beginTransaction.add(R.id.cks, fragment2, toTab.getDesc());
        } else {
            beginTransaction.show(findFragmentByTag);
            findFragmentByTag.onResume();
        }
        beginTransaction.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Fragment Kh() {
        String str;
        int i3;
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (str = intent.getStringExtra("source")) == null) {
            str = "1";
        }
        if (this.enableKuiklyHomeFragment) {
            AdelieHomeCategoryKuiklyFragment adelieHomeCategoryKuiklyFragment = new AdelieHomeCategoryKuiklyFragment();
            Bundle bundle = new Bundle();
            QUISecNavBar qUISecNavBar = this.quiSecNavBar;
            if (qUISecNavBar != null) {
                i3 = qUISecNavBar.getHeight();
            } else {
                i3 = 0;
            }
            bundle.putInt("navBarHeight", i3);
            bundle.putString("superiorSource", str);
            adelieHomeCategoryKuiklyFragment.setArguments(bundle);
            return adelieHomeCategoryKuiklyFragment;
        }
        return new AdelieHomeCategoryFragment();
    }

    private final PopupMenuDialog.MenuItem Lh() {
        return (PopupMenuDialog.MenuItem) this.MENU_ITEM_COMMUNITY.getValue();
    }

    private final PopupMenuDialog.MenuItem Mh() {
        return (PopupMenuDialog.MenuItem) this.MENU_ITEM_GUILD.getValue();
    }

    private final PopupMenuDialog.MenuItem Nh() {
        return (PopupMenuDialog.MenuItem) this.MENU_ITEM_SHARE.getValue();
    }

    private final Map<String, String> Oh() {
        String str;
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            str = intent.getStringExtra("source");
        } else {
            str = null;
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("superior_source", str);
        }
        return hashMap;
    }

    private final com.tencent.biz.qui.quisecnavbar.a Ph() {
        return new b();
    }

    private final com.tencent.biz.qui.quisecnavbar.a Qh() {
        return new c();
    }

    private final com.tencent.biz.qui.quisecnavbar.a Rh() {
        return new d();
    }

    private final com.tencent.robot.adelie.homepage.maintab.b Sh() {
        String str;
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            str = intent.getStringExtra("jumpPage");
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, "creative_center")) {
            return this.mineIconTab;
        }
        return this.discoverIconTab;
    }

    private final void Th(com.tencent.biz.qui.quisecnavbar.a action, String elementId) {
        View h16;
        QUISecNavBar qUISecNavBar = this.quiSecNavBar;
        if (qUISecNavBar != null && (h16 = qUISecNavBar.h(action)) != null) {
            com.tencent.robot.adelie.homepage.utils.h.b(com.tencent.robot.adelie.homepage.utils.h.f366661a, h16, elementId, null, null, null, null, null, 120, null);
            VideoReport.setLogicParent(h16, ((QIphoneTitleBarFragment) this).mContentView);
        }
    }

    private final void Uh() {
        FragmentActivity activity;
        if (this.enableKuiklyHomeFragment || (activity = getActivity()) == null || activity.getIntent() == null) {
            return;
        }
        VideoReport.setPageId(((QIphoneTitleBarFragment) this).mContentView, "pg_bas_agent_home_page_new");
        VideoReport.setPageReportPolicy(((QIphoneTitleBarFragment) this).mContentView, PageReportPolicy.REPORT_NONE);
        VideoReport.setPageParams(((QIphoneTitleBarFragment) this).mContentView, new PageParams(Oh()));
    }

    private final void Vh() {
        boolean z16;
        ImageView.ScaleType scaleType;
        String str;
        if (getActivity() == null) {
            return;
        }
        boolean z17 = false;
        if (this.gradientBg == null) {
            this.gradientBg = new ImageView(getActivity());
            if (je0.a.a(BaseApplication.getContext())) {
                str = "https://static-res.qq.com/static-res/adelie/home/home_page_bg_night.png";
            } else {
                str = "https://static-res.qq.com/static-res/adelie/home/home_page_bg.png";
            }
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
            ImageView imageView = this.gradientBg;
            if (imageView != null) {
                imageView.setImageDrawable(URLDrawable.getDrawable(str, obtain));
            }
            this.titleRoot.addView(this.gradientBg, 0, new RelativeLayout.LayoutParams(-1, -1));
        } else {
            this.titleRoot.setBackgroundResource(R.drawable.qui_common_bg_bottom_brand_bg);
        }
        DeviceType a16 = PadUtil.a(getContext());
        if (a16 != DeviceType.TABLET && a16 != DeviceType.FOLD) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (getResources().getConfiguration().orientation == 2) {
            z17 = true;
        }
        if (z17 && z16) {
            scaleType = ImageView.ScaleType.FIT_XY;
        } else {
            scaleType = ImageView.ScaleType.CENTER_CROP;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AdelieHomeMainFragment", 2, "initGradientBg isPad = " + z16 + ", isHorizontal = " + z17 + ", scaleType = " + scaleType + ", orientation = " + getResources().getConfiguration().orientation);
        }
        ImageView imageView2 = this.gradientBg;
        if (imageView2 != null) {
            imageView2.setScaleType(scaleType);
        }
    }

    private final void Wh(Context context) {
        LinearLayout linearLayout = (LinearLayout) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f917155x);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdelieHomeMainFragment.Xh(view);
            }
        });
        if (di()) {
            linearLayout.setVisibility(8);
            ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f917255y).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Yh() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        Wh(context);
        this.tabContainer = (LinearLayout) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f917155x);
        TabLayout tabLayout = (TabLayout) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.j_o);
        if (tabLayout == null) {
            return;
        }
        this.tabLayout = tabLayout;
        tabLayout.setTabRippleColor(null);
        View mContentView = ((QIphoneTitleBarFragment) this).mContentView;
        Intrinsics.checkNotNullExpressionValue(mContentView, "mContentView");
        IconTextTab iconTextTab = new IconTextTab(context, mContentView, R.drawable.qui_robot, TabType.DISCOVERY, new Function0<Fragment>() { // from class: com.tencent.robot.adelie.homepage.AdelieHomeMainFragment$initTabLayout$discoverTab$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Fragment invoke() {
                Fragment Kh;
                Kh = AdelieHomeMainFragment.this.Kh();
                return Kh;
            }
        }, new Function1<Fragment, Unit>() { // from class: com.tencent.robot.adelie.homepage.AdelieHomeMainFragment$initTabLayout$discoverTab$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Fragment fragment) {
                invoke2(fragment);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Fragment fragment) {
                com.tencent.biz.qui.quisecnavbar.a aVar;
                com.tencent.biz.qui.quisecnavbar.a aVar2;
                com.tencent.biz.qui.quisecnavbar.a aVar3;
                TextView textView;
                TextView textView2;
                String f16;
                QUISecNavBar qUISecNavBar;
                QUISecNavBar qUISecNavBar2;
                QUISecNavBar qUISecNavBar3;
                AdelieHomeMainFragment.this.isMore = true;
                QUISecNavBar qUISecNavBar4 = AdelieHomeMainFragment.this.quiSecNavBar;
                if (qUISecNavBar4 != null) {
                    qUISecNavBar4.setRightIconLayoutVisible(true);
                }
                aVar = AdelieHomeMainFragment.this.robotIcon;
                if (aVar != null && (qUISecNavBar3 = AdelieHomeMainFragment.this.quiSecNavBar) != null) {
                    qUISecNavBar3.setRightIconVisible(aVar, false);
                }
                aVar2 = AdelieHomeMainFragment.this.searchIcon;
                if (aVar2 != null && (qUISecNavBar2 = AdelieHomeMainFragment.this.quiSecNavBar) != null) {
                    qUISecNavBar2.setRightIconVisible(aVar2, true);
                }
                aVar3 = AdelieHomeMainFragment.this.theMoreOrSettingIcon;
                if (aVar3 != null && (qUISecNavBar = AdelieHomeMainFragment.this.quiSecNavBar) != null) {
                    qUISecNavBar.setRightIconRes(aVar3, R.drawable.qui_more_icon_allwhite_primary);
                }
                textView = AdelieHomeMainFragment.this.titleView;
                if (textView != null) {
                    f16 = AdelieHomeMainFragment.INSTANCE.f();
                    textView.setText(f16);
                }
                textView2 = AdelieHomeMainFragment.this.subTitleView;
                if (textView2 == null) {
                    return;
                }
                textView2.setVisibility(0);
            }
        });
        View mContentView2 = ((QIphoneTitleBarFragment) this).mContentView;
        Intrinsics.checkNotNullExpressionValue(mContentView2, "mContentView");
        IconTextTab iconTextTab2 = new IconTextTab(context, mContentView2, R.drawable.qui_creative_center, TabType.MINE, new Function0<Fragment>() { // from class: com.tencent.robot.adelie.homepage.AdelieHomeMainFragment$initTabLayout$mineTab$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Fragment invoke() {
                boolean z16;
                z16 = AdelieHomeMainFragment.this.enableKuiklyMineFragment;
                return z16 ? new AdelieHomeMineKuiklyFragment() : new AdelieHomeMineFragment();
            }
        }, new AdelieHomeMainFragment$initTabLayout$mineTab$2(this, context));
        LifecycleOwner hostLifecycleOwner = getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(hostLifecycleOwner, "hostLifecycleOwner");
        iconTextTab2.e(context, hostLifecycleOwner);
        tabLayout.g(tabLayout.J().p(iconTextTab));
        tabLayout.g(tabLayout.J().p(iconTextTab2));
        FontSettingManager.resetViewSize2Normal(context, this.tabContainer);
        ei(tabLayout);
        this.mineIconTab = iconTextTab2;
        this.discoverIconTab = iconTextTab;
        Jh(null, Sh());
        tabLayout.f(new e(context));
    }

    private final void Zh(LayoutInflater inflater, ViewGroup container) {
        boolean z16;
        View inflate = inflater.inflate(R.layout.dsf, container, false);
        this.titleView = (TextView) inflate.findViewById(R.id.title);
        Companion companion = INSTANCE;
        if (companion.e().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            TextView textView = (TextView) inflate.findViewById(R.id.f166931j64);
            this.subTitleView = textView;
            if (textView != null) {
                textView.setText(companion.e());
            }
        }
        int statusBarHeight = RFWImmersiveUtils.getStatusBarHeight();
        inflate.setPadding(0, statusBarHeight - c24.a.a(1), 0, 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.tencent.biz.qui.quisecnavbar.f.g() + statusBarHeight);
        layoutParams.addRule(10);
        this.titleRoot.addView(inflate, layoutParams);
    }

    private final void ai(LayoutInflater inflater, ViewGroup container) {
        QUISecNavBar qUISecNavBar;
        Context context = getContext();
        if (context == null) {
            return;
        }
        if (useQUISecNavBar() && (qUISecNavBar = this.quiSecNavBar) != null) {
            qUISecNavBar.setCenterText("");
            this.quiSecNavBar.setAutoAdaptTransparent(true);
            this.quiSecNavBar.setTitleAlpha(0.0f);
            this.searchIcon = Qh();
            this.theMoreOrSettingIcon = Ph();
            this.robotIcon = Rh();
            this.quiSecNavBar.setLeftIconWithCircle(true);
            this.quiSecNavBar.setLeftImageRes(R.drawable.qui_chevron_left_icon_allwhite_primary);
            com.tencent.biz.qui.quisecnavbar.a aVar = this.robotIcon;
            if (aVar != null) {
                QUISecNavBar qUISecNavBar2 = this.quiSecNavBar;
                if (qUISecNavBar2 != null) {
                    qUISecNavBar2.d(aVar);
                }
                Th(aVar, "em_bas_aide");
            }
            com.tencent.biz.qui.quisecnavbar.a aVar2 = this.searchIcon;
            if (aVar2 != null) {
                QUISecNavBar qUISecNavBar3 = this.quiSecNavBar;
                if (qUISecNavBar3 != null) {
                    qUISecNavBar3.d(aVar2);
                }
                Th(aVar2, "em_bas_agent_search");
            }
            com.tencent.biz.qui.quisecnavbar.a aVar3 = this.theMoreOrSettingIcon;
            if (aVar3 != null) {
                QUISecNavBar qUISecNavBar4 = this.quiSecNavBar;
                if (qUISecNavBar4 != null) {
                    qUISecNavBar4.d(aVar3);
                }
                Th(aVar3, "em_bas_agent_more");
                Th(aVar3, "em_bas_settings");
            }
        }
        Zh(inflater, container);
        this.titleRoot.setBackgroundResource(R.drawable.f160062j43);
        boolean enableHomePageBottomTab = RobotQQMC.INSTANCE.enableHomePageBottomTab();
        QLog.i("AdelieHomeMainFragment", 1, "initView, enableShowBottomTab:" + enableHomePageBottomTab);
        if (!enableHomePageBottomTab) {
            li();
        } else {
            Yh();
        }
        Vh();
        AdelieGuideAutoControllerImpl adelieGuideAutoControllerImpl = new AdelieGuideAutoControllerImpl(context, this.titleRoot);
        this.adelieGuideAutoController = adelieGuideAutoControllerImpl;
        adelieGuideAutoControllerImpl.b();
        ii();
    }

    private final void bi(boolean playNextTime) {
        String str;
        Context context = getContext();
        if (context != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("show_next_time", playNextTime);
            Unit unit = Unit.INSTANCE;
            com.tencent.kuikly.core.render.android.expand.module.l.e(context, "adelie_interrupt_guide_animation", jSONObject);
        }
        if (!playNextTime) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getCurrentUin();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_ADELIE);
            fromV2.remove("ADELIE_GUIDE_HAS_SHOWN_ANIMATION_" + str);
            fromV2.putString("ADELIE_GUIDE_HAS_SHOWN_ANIMATION_" + str, "true");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void ci(AdelieHomeMainFragment adelieHomeMainFragment, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        adelieHomeMainFragment.bi(z16);
    }

    private final boolean di() {
        String str;
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            str = intent.getStringExtra("jumpPage");
        } else {
            str = null;
        }
        return Intrinsics.areEqual(str, "creative_center");
    }

    private final void ei(TabLayout tabLayout) {
        if (tabLayout.C() <= 0) {
            return;
        }
        int screenWidth = (ViewUtils.getScreenWidth() / 8) - ViewUtils.dpToPx(15.0f);
        ViewGroup.LayoutParams layoutParams = tabLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.leftMargin = screenWidth;
        layoutParams2.rightMargin = screenWidth;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fi(AdelieHomeMainFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ii();
        RelativeLayout relativeLayout = this$0.titleRoot;
        if (relativeLayout != null) {
            relativeLayout.removeView(this$0.gradientBg);
            this$0.gradientBg = null;
            this$0.Vh();
        }
    }

    private final void gi(final Activity activity) {
        if (activity == null || ((IPeakHelperApi) QRoute.api(IPeakHelperApi.class)).isPeakAlive(activity)) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.homepage.b
            @Override // java.lang.Runnable
            public final void run() {
                AdelieHomeMainFragment.hi(activity);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hi(Activity activity) {
        ((IPeakHelperApi) QRoute.api(IPeakHelperApi.class)).preloadPeakProcess(activity);
    }

    private final void ii() {
        Context context = getContext();
        if (context != null) {
            LinearLayout linearLayout = (LinearLayout) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f917155x);
            if (linearLayout != null) {
                linearLayout.setBackground(context.getDrawable(R.drawable.qui_common_bg_bottom_light_bg));
            }
            View findViewById = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f917255y);
            if (findViewById != null) {
                findViewById.setBackground(context.getDrawable(R.drawable.qui_common_border_light_bg));
            }
            TextView textView = this.titleView;
            if (textView != null) {
                textView.setTextColor(context.getColor(R.color.qui_common_text_nav_secondary));
            }
            TextView textView2 = this.subTitleView;
            if (textView2 != null) {
                textView2.setTextColor(context.getColor(R.color.qui_common_text_secondary));
            }
        }
    }

    private final void ji() {
        try {
            QLog.i("AdelieHomeMainFragment", 1, "registerKuiklyBroadcast");
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tencent.mobileqq.ecommerce.broadcast.hr.notify");
            MobileQQ.sMobileQQ.registerReceiver(this.kuiklyBroadcastReceiver, intentFilter);
        } catch (Exception e16) {
            QLog.e("AdelieHomeMainFragment", 1, "registerKuiklyBroadcast registerReceiver fail.", e16);
        }
    }

    private final void ki() {
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "childFragmentManager.beginTransaction()");
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "childFragmentManager.fragments");
        Iterator<Fragment> it = fragments.iterator();
        while (it.hasNext()) {
            beginTransaction.remove(it.next());
        }
        beginTransaction.commitNowAllowingStateLoss();
    }

    private final void li() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        ((LinearLayout) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f917155x)).setVisibility(8);
        QQBlurViewWrapper qQBlurViewWrapper = (QQBlurViewWrapper) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.t97);
        if (qQBlurViewWrapper != null) {
            qQBlurViewWrapper.setVisibility(8);
        }
        View mContentView = ((QIphoneTitleBarFragment) this).mContentView;
        Intrinsics.checkNotNullExpressionValue(mContentView, "mContentView");
        Jh(null, new IconTextTab(context, mContentView, R.drawable.qui_robot, TabType.DISCOVERY, new Function0<Fragment>() { // from class: com.tencent.robot.adelie.homepage.AdelieHomeMainFragment$showDiscoverTabDirectly$discoverTab$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Fragment invoke() {
                Fragment Kh;
                Kh = AdelieHomeMainFragment.this.Kh();
                return Kh;
            }
        }, null, 32, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void mi() {
        Map mapOf;
        Map mapOf2;
        Map mapOf3;
        List mutableListOf;
        if (this.morePopupMenuDialog == null) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Mh());
            if (RobotQQMC.INSTANCE.enableAdelieHomePageShare()) {
                mutableListOf.add(Nh());
            }
            mutableListOf.add(Lh());
            if (getActivity() == null) {
                return;
            }
            PopupMenuDialog conversationPlusBuild = PopupMenuDialog.conversationPlusBuild(getActivity(), mutableListOf, new PopupMenuDialog.OnClickActionListener() { // from class: com.tencent.robot.adelie.homepage.c
                @Override // com.tencent.widget.PopupMenuDialog.OnClickActionListener
                public final void onClickAction(PopupMenuDialog.MenuItem menuItem) {
                    AdelieHomeMainFragment.ni(AdelieHomeMainFragment.this, menuItem);
                }
            }, null);
            ((RelativeLayout) conversationPlusBuild.getContentView().findViewById(R.id.ads)).setBackgroundDrawable(ie0.a.f().o(getContext(), R.drawable.f160061mi2, R.color.qui_common_bg_top_light, 1000));
            this.morePopupMenuDialog = conversationPlusBuild;
        }
        PopupMenuDialog popupMenuDialog = this.morePopupMenuDialog;
        if (popupMenuDialog != null) {
            QUISecNavBar qUISecNavBar = this.quiSecNavBar;
            popupMenuDialog.showAsDropDown(qUISecNavBar, (qUISecNavBar.getWidth() - getResources().getDimensionPixelSize(R.dimen.au6)) - c24.a.a(8), 0);
        }
        PopupMenuDialog popupMenuDialog2 = this.morePopupMenuDialog;
        if (popupMenuDialog2 != null) {
            VideoReport.setPageId(popupMenuDialog2.getContentView(), "pg_bas_agent_home_page_new");
            VideoReport.setPageParams(popupMenuDialog2.getContentView(), new PageParams(Oh()));
            View findViewById = popupMenuDialog2.getContentView().findViewById(R.id.content);
            if (findViewById != null) {
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<View>(com.t\u2026bileqq.qqui.R.id.content)");
                com.tencent.robot.adelie.homepage.utils.h.b(com.tencent.robot.adelie.homepage.utils.h.f366661a, findViewById, "em_bas_agent_more_panel", null, null, null, null, null, 120, null);
                VideoReport.reportEvent("imp", findViewById, null);
            }
            View findViewById2 = popupMenuDialog2.getContentView().findViewById(Mh().f384641id);
            if (findViewById2 != null) {
                Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<View>(MENU_ITEM_GUILD.id)");
                mapOf3 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("function_name", "1"));
                com.tencent.robot.adelie.homepage.utils.h.b(com.tencent.robot.adelie.homepage.utils.h.f366661a, findViewById2, "em_bas_agents_more_entry", mapOf3, null, null, null, null, 120, null);
                VideoReport.reportEvent("imp", findViewById2, mapOf3);
            }
            View findViewById3 = popupMenuDialog2.getContentView().findViewById(Nh().f384641id);
            if (findViewById3 != null) {
                Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<View>(MENU_ITEM_SHARE.id)");
                mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("function_name", "2"));
                com.tencent.robot.adelie.homepage.utils.h.b(com.tencent.robot.adelie.homepage.utils.h.f366661a, findViewById3, "em_bas_agents_more_entry", mapOf2, null, null, null, null, 120, null);
                VideoReport.reportEvent("imp", findViewById3, mapOf2);
            }
            View findViewById4 = popupMenuDialog2.getContentView().findViewById(Lh().f384641id);
            if (findViewById4 != null) {
                Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById<View>(MENU_ITEM_COMMUNITY.id)");
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("function_name", "3"));
                com.tencent.robot.adelie.homepage.utils.h.b(com.tencent.robot.adelie.homepage.utils.h.f366661a, findViewById4, "em_bas_agents_more_entry", mapOf, null, null, null, null, 120, null);
                VideoReport.reportEvent("imp", findViewById4, mapOf);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ni(AdelieHomeMainFragment this$0, PopupMenuDialog.MenuItem menuItem) {
        Integer num;
        Map mapOf;
        Map mapOf2;
        Map mapOf3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        if (menuItem != null) {
            num = Integer.valueOf(menuItem.f384641id);
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.string.f159041r9) {
            com.tencent.robot.adelie.homepage.utils.n.f366680a.f(activity, "mqqguild://guild/share?_wv=3&_wwv=128&appChannel=qqai_robot&inviteCode=221VgckLmZi&mainSourceId=qq_ai&subSourceId=robot");
            LinearLayout linearLayout = menuItem.itemView;
            mapOf3 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("function_name", "1"));
            VideoReport.reportEvent("clck", linearLayout, mapOf3);
            return;
        }
        if (num != null && num.intValue() == R.string.f159051r_) {
            ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
            param.context = activity;
            Intent intent = activity.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "activity.getIntent()");
            intent.putExtra("big_brother_source_key", "biz_src_qqagent");
            HashMap hashMap = new HashMap();
            hashMap.put("sub_biz_source", "agent_homepage");
            param.deReportParams = hashMap;
            new com.tencent.robot.adelie.homepage.share.b(activity, param, ((QIphoneTitleBarFragment) this$0).mContentView).show();
            LinearLayout linearLayout2 = menuItem.itemView;
            mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("function_name", "2"));
            VideoReport.reportEvent("clck", linearLayout2, mapOf2);
            return;
        }
        if (num != null && num.intValue() == R.string.f159031r8) {
            com.tencent.robot.adelie.homepage.utils.n.f366680a.f(activity, RobotQQMC.INSTANCE.getCommunityRuleEntrance().getEntrance());
            LinearLayout linearLayout3 = menuItem.itemView;
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("function_name", "3"));
            VideoReport.reportEvent("clck", linearLayout3, mapOf);
        }
    }

    private final void oi() {
        try {
            MobileQQ.sMobileQQ.unregisterReceiver(this.kuiklyBroadcastReceiver);
        } catch (Exception e16) {
            QLog.e("AdelieHomeMainFragment", 1, "unRegisterKuiklyBroadcast registerReceiver fail.", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        super.doOnCreateView(inflater, container, savedInstanceState);
        ai(inflater, container);
        Uh();
        g.f366352a.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.dsd;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean isAllowLandscape() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    protected boolean isTransparent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        bi(true);
        com.tencent.robot.adelie.homepage.guide.a aVar = this.adelieGuideAutoController;
        if (aVar != null) {
            aVar.a();
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Vh();
        y14.c cVar = this.guideDialog;
        if (cVar != null) {
            cVar.onConfigurationChanged(newConfig);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ji();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        ViewParent viewParent;
        ViewGroup viewGroup;
        super.onDestroy();
        AdelieUtils.f365929a.X();
        IconTextTab iconTextTab = this.mineIconTab;
        if (iconTextTab != null) {
            iconTextTab.c();
        }
        this.mineIconTab = null;
        QQBlurViewWrapper qQBlurViewWrapper = this.tabBlurView;
        if (qQBlurViewWrapper != null) {
            qQBlurViewWrapper.onDestroy();
        }
        this.tabBlurView = null;
        TabLayout tabLayout = this.tabLayout;
        if (tabLayout != null) {
            tabLayout.M();
        }
        TabLayout tabLayout2 = this.tabLayout;
        if (tabLayout2 != null) {
            viewParent = tabLayout2.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent instanceof ViewGroup) {
            viewGroup = (ViewGroup) viewParent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        this.tabLayout = null;
        this.lastSelectedTab = null;
        AdelieRedDotManager.f366808a.g();
        ki();
        com.tencent.robot.adelie.homepage.guide.a aVar = this.adelieGuideAutoController;
        if (aVar != null) {
            aVar.onDestroy();
        }
        g.f366352a.d();
        oi();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        QLog.i("AdelieHomeMainFragment", 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        super.onPause();
        QQBlurViewWrapper qQBlurViewWrapper = this.tabBlurView;
        if (qQBlurViewWrapper != null) {
            qQBlurViewWrapper.onPause();
        }
        VideoReport.reportPgOut(((QIphoneTitleBarFragment) this).mContentView);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.robot.adelie.homepage.a
            @Override // java.lang.Runnable
            public final void run() {
                AdelieHomeMainFragment.fi(AdelieHomeMainFragment.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QQBlurViewWrapper qQBlurViewWrapper = this.tabBlurView;
        if (qQBlurViewWrapper != null) {
            qQBlurViewWrapper.onResume();
        }
        gi(getActivity());
        VideoReport.reportPgIn(((QIphoneTitleBarFragment) this).mContentView, false);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        QLog.i("AdelieHomeMainFragment", 1, DKHippyEvent.EVENT_STOP);
        com.tencent.robot.adelie.homepage.guide.a aVar = this.adelieGuideAutoController;
        if (aVar != null) {
            aVar.a();
        }
        super.onStop();
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean secNavBarNeedImmersive() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        return true;
    }
}
