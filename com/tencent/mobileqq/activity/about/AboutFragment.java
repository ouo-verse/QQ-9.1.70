package com.tencent.mobileqq.activity.about;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quipolarlight.QUIPolarLightView;
import com.tencent.biz.qui.quipolarlight.a;
import com.tencent.biz.qui.quipolarlight.render.PolarImageRender;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.about.AboutFragment;
import com.tencent.mobileqq.activity.about.modelviewer.Direction;
import com.tencent.mobileqq.activity.about.modelviewer.o;
import com.tencent.mobileqq.activity.fixtool.FixToolFragment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.hermes.ISuperQQTaskApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.resconfig.MainResourceConfig;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;
import com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity;
import com.tencent.mobileqq.upgrade.activity.q;
import com.tencent.mobileqq.utils.dx;
import com.tencent.mobileqq.utils.u;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.zplan.lite.IZPlanFilamentSwitch;
import com.tencent.mobileqq.zplan.utils.ae;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.util.AbiUtil;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import protocol.KQQConfig.UpgradeInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 j2\u00020\u00012\u00020\u0002:\u0001kB\u0007\u00a2\u0006\u0004\bh\u0010iJ&\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0017J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\b\u0010\u001d\u001a\u00020\u0017H\u0016J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\tH\u0002J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\tH\u0002J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\tH\u0002J\b\u0010#\u001a\u00020\u000eH\u0002J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\tH\u0002J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\tH\u0002J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\tH\u0002J\u0010\u0010'\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\tH\u0002J\u0010\u0010(\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\tH\u0002J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\tH\u0002J\u0010\u0010*\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\tH\u0002J\u0010\u0010+\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\tH\u0002J\b\u0010,\u001a\u00020\u0017H\u0002J\f\u0010.\u001a\u0006\u0012\u0002\b\u00030-H\u0002J\f\u0010/\u001a\u0006\u0012\u0002\b\u00030-H\u0002J\u000e\u00100\u001a\b\u0012\u0002\b\u0003\u0018\u00010-H\u0002J\f\u00101\u001a\u0006\u0012\u0002\b\u00030-H\u0002J\u001e\u00105\u001a\u00020\u00132\u0014\u00104\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u000103\u0012\u0004\u0012\u00020\u001102H\u0002J\b\u00106\u001a\u00020\u0017H\u0002J\f\u00107\u001a\u0006\u0012\u0002\b\u00030-H\u0002J\f\u00108\u001a\u0006\u0012\u0002\b\u00030-H\u0002J\u0010\u00109\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\tH\u0002J.\u0010<\u001a\u00020\u00172\u000e\u0010;\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030:2\u0014\u00104\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u000103\u0012\u0004\u0012\u00020\u001102H\u0002R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010J\u001a\u00020E8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010GR\u0016\u0010M\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010O\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010LR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010V\u001a\u00020\u00118\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010X\u001a\u00020\u00118\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bW\u0010UR\u0014\u0010\\\u001a\u00020Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010`\u001a\u00020]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010d\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u001c\u0010g\u001a\b\u0012\u0002\b\u0003\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010f\u00a8\u0006l"}, d2 = {"Lcom/tencent/mobileqq/activity/about/AboutFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/view/View$OnClickListener;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "needStatusTrans", "needImmersive", "", "getCurrentUin", "", "getContentLayoutId", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "redTouch", "", "oi", "view", NodeProps.ON_CLICK, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initTitleBar", "root", "di", "Rh", "ii", "ai", "Vh", "fi", "ci", "bi", "Uh", "Xh", "ei", "pi", "Lcom/tencent/mobileqq/widget/listitem/a;", "Ih", "Lh", "gi", WidgetCacheLunarData.JI, "Lkotlin/Pair;", "Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;", "versionInfo", "Nh", "Oh", "Ph", "Jh", "Zh", "Lcom/tencent/mobileqq/widget/listitem/x;", DownloadInfo.spKey_Config, "mi", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "brandImageView", "Lcom/tencent/biz/qui/quipolarlight/QUIPolarLightView;", "D", "Lcom/tencent/biz/qui/quipolarlight/QUIPolarLightView;", "polarLight", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "privacyPolicy", UserInfo.SEX_FEMALE, "userAgreement", "G", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "userAgreementRedTouch", "H", "privacyPolicyRedTouch", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "I", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "titleBar", "J", "Ljava/lang/String;", "userAgreementUrl", "K", "privacyUrl", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "L", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "recyclerViewAdapter", "Lcom/tencent/mobileqq/activity/about/c;", "M", "Lcom/tencent/mobileqq/activity/about/c;", "viewModel", "Lcom/tencent/mobileqq/activity/about/modelviewer/b;", "N", "Lcom/tencent/mobileqq/activity/about/modelviewer/b;", "modelController", "P", "Lcom/tencent/mobileqq/widget/listitem/a;", "functionUpgradeItem", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class AboutFragment extends QPublicBaseFragment implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView brandImageView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private QUIPolarLightView polarLight;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView privacyPolicy;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView userAgreement;

    /* renamed from: G, reason: from kotlin metadata */
    private RedTouch userAgreementRedTouch;

    /* renamed from: H, reason: from kotlin metadata */
    private RedTouch privacyPolicyRedTouch;

    /* renamed from: I, reason: from kotlin metadata */
    private QUISecNavBar titleBar;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final String userAgreementUrl;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final String privacyUrl;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final QUIListItemAdapter recyclerViewAdapter;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final c viewModel;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.activity.about.modelviewer.b modelController;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.widget.listitem.a<?> functionUpgradeItem;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/activity/about/AboutFragment$a;", "", "", "FEEDBACK_URL", "Ljava/lang/String;", "HELP_URL", "INTRODUCTION_URL", "LIGHT_CHASER_URL", "OFFICIAL_URL", "REPORT_T_SHOW", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.about.AboutFragment$a, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/activity/about/AboutFragment$b", "Lcom/tencent/biz/qui/quisecnavbar/a;", "Landroid/view/View;", "view", "", "a", "", "getDrawable", "()I", "drawable", "d", "drawableInTransparent", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class b extends com.tencent.biz.qui.quisecnavbar.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AboutFragment.this);
            }
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        public void a(@Nullable View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
                return;
            }
            Context context = AboutFragment.this.getContext();
            if (context != null) {
                QPublicFragmentActivity.start(context, FixToolFragment.class);
            }
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        public int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return R.drawable.qui_profession;
        }

        @Override // com.tencent.biz.qui.quisecnavbar.b
        public int getDrawable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return R.drawable.qui_about_fix_tool_nav;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23227);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AboutFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.userAgreementUrl = AppConstants.URL.SERVICE_PROTOCOL;
        this.privacyUrl = AppConstants.URL.PRIVATE_PROTOCOL;
        this.recyclerViewAdapter = new QUIListItemAdapter(QUIListItemStyle.Card, false, false, 6, null);
        this.viewModel = new c();
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> Ih() {
        String string = getString(R.string.zph);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.current_version)");
        x xVar = new x(new x.b.C8996b(string, R.drawable.qui_qq), new x.c.g("", false, false, 6, null));
        x.c.g gVar = (x.c.g) xVar.O();
        String d16 = AppSetting.d();
        Intrinsics.checkNotNullExpressionValue(d16, "getAboutSubVersionName()");
        gVar.h(d16);
        ((x.c.g) xVar.O()).f(false);
        return xVar;
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> Jh() {
        String string = getString(R.string.b5c);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.feedback)");
        x xVar = new x(new x.b.C8996b(string, R.drawable.qui_feedback), new x.c.g("", true, false, 4, null));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.about.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AboutFragment.Kh(AboutFragment.this, view);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(AboutFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String c26 = this$0.viewModel.c2(1, "https://ti.qq.com/tucao/index.html?productId=36028");
        Intent intent = new Intent(this$0.getContext(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("portraitOnly", true);
        intent.putExtra("url", c26).putExtra("bFormatUrl", false);
        intent.putExtra("uin", this$0.getCurrentUin());
        intent.putExtra("reportMsfLog", true);
        this$0.startActivity(intent.putExtra("url", c26));
        ReportController.o(null, "CliOper", "", "", "0X8005742", "0X8005742", 0, 0, "", "", "", "");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> Lh() {
        com.tencent.mobileqq.widget.listitem.a<?> aVar = this.functionUpgradeItem;
        if (aVar != null) {
            Intrinsics.checkNotNull(aVar);
            return aVar;
        }
        String string = getString(R.string.ic5);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.version_upgrade)");
        final x xVar = new x(new x.b.C8996b(string, R.drawable.qui_arrowhead_up_circle), new x.c.d("", "", false, false, 12, null));
        xVar.T(AboutFragment$getFunctionUpgrade$1$1.INSTANCE);
        MutableLiveData<Pair<UpgradeDetailWrapper, String>> d26 = this.viewModel.d2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Pair<? extends UpgradeDetailWrapper, ? extends String>, Unit> function1 = new Function1<Pair<? extends UpgradeDetailWrapper, ? extends String>, Unit>(xVar) { // from class: com.tencent.mobileqq.activity.about.AboutFragment$getFunctionUpgrade$1$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ x<x.b.C8996b, x.c.d> $this_apply;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_apply = xVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AboutFragment.this, (Object) xVar);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends UpgradeDetailWrapper, ? extends String> pair) {
                invoke2((Pair<? extends UpgradeDetailWrapper, String>) pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<? extends UpgradeDetailWrapper, String> versionInfo) {
                QUIListItemAdapter qUIListItemAdapter;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) versionInfo);
                    return;
                }
                boolean j3 = com.tencent.mobileqq.upgrade.n.j();
                boolean z16 = ae.b(versionInfo.getSecond(), AppSetting.f99551k) > 0;
                QLog.d("AboutFragment", 1, "check grade, hasGrayUpgrade: " + j3 + ", hasLightUpgrade: " + z16);
                if (!j3 && !z16) {
                    x.c.d O = this.$this_apply.O();
                    String qqStr = HardCodeUtil.qqStr(R.string.j0g);
                    Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qqstr_aboutact_00121150)");
                    O.h(qqStr);
                    this.$this_apply.O().f(false);
                    this.$this_apply.x(null);
                } else {
                    this.$this_apply.O().f(true);
                    this.$this_apply.O().j("showImage");
                    x.c.d O2 = this.$this_apply.O();
                    String qqStr2 = HardCodeUtil.qqStr(R.string.j0h);
                    Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.qqstr_aboutact_dd3d0536)");
                    O2.h(qqStr2);
                    AboutFragment aboutFragment = AboutFragment.this;
                    x<x.b.C8996b, x.c.d> xVar2 = this.$this_apply;
                    Intrinsics.checkNotNullExpressionValue(versionInfo, "versionInfo");
                    aboutFragment.mi(xVar2, versionInfo);
                }
                qUIListItemAdapter = AboutFragment.this.recyclerViewAdapter;
                qUIListItemAdapter.l0(this.$this_apply);
            }
        };
        d26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.activity.about.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AboutFragment.Mh(Function1.this, obj);
            }
        });
        this.functionUpgradeItem = xVar;
        Intrinsics.checkNotNull(xVar);
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int Nh(Pair<? extends UpgradeDetailWrapper, String> versionInfo) {
        UpgradeInfo mUpgradeInfo;
        UpgradeDetailWrapper first = versionInfo.getFirst();
        if (first == null || (mUpgradeInfo = first.f306170d) == null) {
            return 0;
        }
        Intrinsics.checkNotNullExpressionValue(mUpgradeInfo, "mUpgradeInfo");
        return mUpgradeInfo.iUpgradeType;
    }

    private final void Oh() {
        String str;
        Intent intent = new Intent(getContext(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("uin", getCurrentUin());
        if (AbiUtil.isArm64Runtime(getContext())) {
            str = "?arch=arm64";
        } else {
            str = "?arch=arm32";
        }
        startActivity(intent.putExtra("url", "https://im.qq.com/mobileqq/touch/android" + str));
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> Ph() {
        String string = getString(R.string.bpd);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.help)");
        x xVar = new x(new x.b.C8996b(string, R.drawable.qui_question_mark_circle), new x.c.g("", true, false, 4, null));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.about.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AboutFragment.Qh(AboutFragment.this, view);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(AboutFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String c26 = this$0.viewModel.c2(2, "https://kf.qq.com/touch/scene_product.html?scene_id=kf180");
        Intent intent = new Intent(this$0.getContext(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("portraitOnly", true);
        intent.putExtra("url", c26).putExtra("bFormatUrl", false);
        intent.putExtra("uin", this$0.getCurrentUin());
        intent.putExtra("reportMsfLog", true);
        this$0.startActivity(intent.putExtra("url", c26));
        ReportController.o(null, "CliOper", "", "", "0X8005741", "0X8005741", 0, 0, "", "", "", "");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Rh(View root) {
        View findViewById = root.findViewById(R.id.tbi);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.brand_image)");
        ImageView imageView = (ImageView) findViewById;
        this.brandImageView = imageView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("brandImageView");
            imageView = null;
        }
        imageView.setVisibility(0);
        ImageView imageView3 = this.brandImageView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("brandImageView");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.about.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AboutFragment.Sh(AboutFragment.this, view);
            }
        });
        if (!ii()) {
            return;
        }
        View findViewById2 = root.findViewById(R.id.v4w);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.view.TextureView");
        final TextureView textureView = (TextureView) findViewById2;
        MutableLiveData<ByteBuffer> U1 = this.viewModel.U1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<ByteBuffer, Unit> function1 = new Function1<ByteBuffer, Unit>(textureView) { // from class: com.tencent.mobileqq.activity.about.AboutFragment$initBrandModel$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ TextureView $brandModel;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/activity/about/AboutFragment$initBrandModel$2$a", "Lcom/tencent/mobileqq/activity/about/modelviewer/o$b;", "", "c", "a", "Lcom/tencent/mobileqq/activity/about/modelviewer/Direction;", "direction", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes9.dex */
            public static final class a implements o.b {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ AboutFragment f177662a;

                a(AboutFragment aboutFragment) {
                    this.f177662a = aboutFragment;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) aboutFragment);
                    }
                }

                @Override // com.tencent.mobileqq.activity.about.modelviewer.o.b
                public void a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this);
                    } else {
                        QLog.d("AboutFragment", 2, "animationFinish callback!!!");
                        this.f177662a.pi();
                    }
                }

                @Override // com.tencent.mobileqq.activity.about.modelviewer.o.b
                public void b(@NotNull Direction direction) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, (Object) this, (Object) direction);
                    } else {
                        Intrinsics.checkNotNullParameter(direction, "direction");
                    }
                }

                @Override // com.tencent.mobileqq.activity.about.modelviewer.o.b
                public void c() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    View view = this.f177662a.getView();
                    if (view != null) {
                        view.performHapticFeedback(1, 2);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$brandModel = textureView;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AboutFragment.this, (Object) textureView);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ByteBuffer byteBuffer) {
                invoke2(byteBuffer);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ByteBuffer modelInfo) {
                com.tencent.mobileqq.activity.about.modelviewer.b bVar;
                ImageView imageView4;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) modelInfo);
                    return;
                }
                Context context = AboutFragment.this.getContext();
                if (context != null) {
                    AboutFragment aboutFragment = AboutFragment.this;
                    TextureView textureView2 = this.$brandModel;
                    long currentTimeMillis = System.currentTimeMillis();
                    aboutFragment.modelController = new com.tencent.mobileqq.activity.about.modelviewer.b(context);
                    bVar = aboutFragment.modelController;
                    if (bVar != null) {
                        QLog.d("AboutFragment", 1, "start init filament model");
                        bVar.e();
                        textureView2.setVisibility(0);
                        bVar.k(textureView2);
                        Intrinsics.checkNotNullExpressionValue(modelInfo, "modelInfo");
                        bVar.f(modelInfo);
                        bVar.i();
                        imageView4 = aboutFragment.brandImageView;
                        if (imageView4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("brandImageView");
                            imageView4 = null;
                        }
                        imageView4.setVisibility(8);
                        bVar.j(new a(aboutFragment));
                    }
                    QLog.i("AboutFragment", 1, "cost time:" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        };
        U1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.activity.about.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AboutFragment.Th(Function1.this, obj);
            }
        });
        this.viewModel.e2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(AboutFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.pi();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Uh(View root) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
        int i3 = calendar.get(1);
        if (QLog.isColorLevel()) {
            QLog.d("AboutFragment", 2, "initCopyRightShow year=" + i3);
        }
        View findViewById = root.findViewById(R.id.baa);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById<TextView>(R.id.copyright)");
        Resources resources = getResources();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        String string = resources.getString(R.string.f170319m5, sb5.toString());
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026 nowYear.toString() + \"\")");
        ((TextView) findViewById).setText(string);
    }

    private final void Vh(View root) {
        this.viewModel.X1();
        final b bVar = new b();
        QUISecNavBar qUISecNavBar = this.titleBar;
        if (qUISecNavBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            qUISecNavBar = null;
        }
        qUISecNavBar.d(bVar);
        qUISecNavBar.setRightIconVisible(bVar, false);
        MutableLiveData<Unit> W1 = this.viewModel.W1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Unit, Unit> function1 = new Function1<Unit, Unit>(bVar) { // from class: com.tencent.mobileqq.activity.about.AboutFragment$initFixToolView$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ AboutFragment.b $fixButton;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$fixButton = bVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AboutFragment.this, (Object) bVar);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Unit unit) {
                QUISecNavBar qUISecNavBar2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) unit);
                    return;
                }
                qUISecNavBar2 = AboutFragment.this.titleBar;
                if (qUISecNavBar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleBar");
                    qUISecNavBar2 = null;
                }
                qUISecNavBar2.setRightIconVisible(this.$fixButton, true);
            }
        };
        W1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.activity.about.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AboutFragment.Wh(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Xh(View root) {
        View findViewById = root.findViewById(R.id.f71713ow);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.record_num)");
        ((LinearLayout) findViewById).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.about.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AboutFragment.Yh(AboutFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(AboutFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.getContext(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("uin", this$0.getCurrentUin());
        this$0.startActivity(intent.putExtra("url", AppConstants.URL.IPC_RECORD_NUM));
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void ai(View root) {
        PolarImageRender polarImageRender;
        QUIPolarLightView qUIPolarLightView = (QUIPolarLightView) root.findViewById(R.id.f66363af);
        this.polarLight = qUIPolarLightView;
        if (qUIPolarLightView != null) {
            polarImageRender = qUIPolarLightView.getPolarLightRender();
        } else {
            polarImageRender = null;
        }
        if (polarImageRender != null) {
            polarImageRender.q(new a.b(0.6f, 0.5f, 0.4f, 0.5f, 0.0f));
        }
    }

    private final void bi(View root) {
        View findViewById = root.findViewById(R.id.f87514uk);
        View findViewById2 = root.findViewById(R.id.f27620gq);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById2;
        findViewById.setVisibility(0);
        textView.setVisibility(0);
        textView.setOnClickListener(this);
    }

    private final void ci(View root) {
        View findViewById = root.findViewById(R.id.fzg);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById;
        this.privacyPolicy = textView;
        RedTouch redTouch = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacyPolicy");
            textView = null;
        }
        textView.getPaint().getFlags();
        TextView textView2 = this.privacyPolicy;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacyPolicy");
            textView2 = null;
        }
        textView2.setOnClickListener(this);
        Context context = getContext();
        TextView textView3 = this.privacyPolicy;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacyPolicy");
            textView3 = null;
        }
        RedTouch applyTo = new RedTouch(context, textView3).setGravity(53).applyTo();
        Intrinsics.checkNotNullExpressionValue(applyTo, "RedTouch(context, privac\u2026or Gravity.TOP).applyTo()");
        this.privacyPolicyRedTouch = applyTo;
        if (PrivacyPolicyHelper.aboutPageNeedShowPrivacyPolicyRedPoint()) {
            RedTouch redTouch2 = this.privacyPolicyRedTouch;
            if (redTouch2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("privacyPolicyRedTouch");
            } else {
                redTouch = redTouch2;
            }
            oi(redTouch);
        }
    }

    private final void di(View root) {
        RelativeLayout relativeLayout = (RelativeLayout) root.findViewById(R.id.tbh);
        FontSettingManager.resetViewSize2Normal(getContext(), relativeLayout);
        relativeLayout.setVisibility(0);
        ((LinearLayout) root.findViewById(R.id.f61822z6)).setVisibility(0);
        Rh(root);
        ai(root);
    }

    private final void ei(View root) {
        View findViewById = root.findViewById(R.id.u8g);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView");
        ((QUISettingsRecyclerView) findViewById).setAdapter(this.recyclerViewAdapter);
        QUIListItemAdapter qUIListItemAdapter = this.recyclerViewAdapter;
        ArrayList arrayList = new ArrayList();
        arrayList.add(Ih());
        arrayList.add(Lh());
        com.tencent.mobileqq.widget.listitem.a<?> gi5 = gi();
        if (gi5 != null) {
            arrayList.add(gi5);
        }
        arrayList.add(ji());
        arrayList.add(Jh());
        arrayList.add(Ph());
        Object[] array = arrayList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        qUIListItemAdapter.t0(new Group("", "", (com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length)));
        Context context = getContext();
        if (context != null) {
            this.viewModel.b2(context);
        }
        this.viewModel.f2();
        this.recyclerViewAdapter.m0(Lh(), true);
    }

    private final void fi(View root) {
        View findViewById = root.findViewById(R.id.f167083kl0);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById;
        this.userAgreement = textView;
        RedTouch redTouch = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAgreement");
            textView = null;
        }
        textView.getPaint().getFlags();
        TextView textView2 = this.userAgreement;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAgreement");
            textView2 = null;
        }
        textView2.setOnClickListener(this);
        Context context = getContext();
        TextView textView3 = this.userAgreement;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAgreement");
            textView3 = null;
        }
        RedTouch applyTo = new RedTouch(context, textView3).setGravity(53).applyTo();
        Intrinsics.checkNotNullExpressionValue(applyTo, "RedTouch(context, userAg\u2026or Gravity.TOP).applyTo()");
        this.userAgreementRedTouch = applyTo;
        if (PrivacyPolicyHelper.needShowUserAgreementRedPoint()) {
            RedTouch redTouch2 = this.userAgreementRedTouch;
            if (redTouch2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userAgreementRedTouch");
            } else {
                redTouch = redTouch2;
            }
            oi(redTouch);
        }
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> gi() {
        String string = getString(R.string.b4v);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.feature_info)");
        x xVar = new x(new x.b.C8996b(string, R.drawable.qui_files), new x.c.g("", true, false, 4, null));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.about.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AboutFragment.hi(AboutFragment.this, view);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hi(AboutFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String c26 = this$0.viewModel.c2(0, "https://ti.qq.com/hybrid-h5/mqq/intro?");
        Intent intent = new Intent(this$0.getContext(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("portraitOnly", true);
        intent.putExtra("url", c26).putExtra("bFormatUrl", false);
        intent.putExtra("uin", this$0.getCurrentUin());
        intent.putExtra("reportMsfLog", true);
        this$0.startActivity(intent.putExtra("url", c26));
        ReportController.o(null, "CliOper", "", "", "0X8005744", "0X8005744", 0, 0, "", "", "", "");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean ii() {
        boolean enableZPlanFilamentBase = ((IZPlanFilamentSwitch) QRoute.api(IZPlanFilamentSwitch.class)).enableZPlanFilamentBase();
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("filament_about", false);
        QLog.d("AboutFragment", 1, "needShowFilament inZplanWhiteList: " + enableZPlanFilamentBase + " inUnitedConfigBlackList: " + isSwitchOn);
        if (!enableZPlanFilamentBase || isSwitchOn) {
            return false;
        }
        return true;
    }

    private final void initTitleBar(View rootView) {
        View findViewById = rootView.findViewById(R.id.jo9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.title_bar)");
        QUISecNavBar qUISecNavBar = (QUISecNavBar) findViewById;
        this.titleBar = qUISecNavBar;
        QUISecNavBar qUISecNavBar2 = null;
        if (qUISecNavBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            qUISecNavBar = null;
        }
        qUISecNavBar.S(this);
        QUISecNavBar qUISecNavBar3 = this.titleBar;
        if (qUISecNavBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            qUISecNavBar3 = null;
        }
        qUISecNavBar3.setAutoAdaptTransparent(true);
        QUISecNavBar qUISecNavBar4 = this.titleBar;
        if (qUISecNavBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            qUISecNavBar4 = null;
        }
        qUISecNavBar4.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>() { // from class: com.tencent.mobileqq.activity.about.AboutFragment$initTitleBar$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AboutFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, BaseAction baseAction) {
                invoke2(view, baseAction);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View view, @NotNull BaseAction action) {
                FragmentActivity activity;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) action);
                    return;
                }
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(action, "action");
                if (action != BaseAction.ACTION_LEFT_BUTTON || (activity = AboutFragment.this.getActivity()) == null) {
                    return;
                }
                activity.onBackPressed();
            }
        });
        QUISecNavBar qUISecNavBar5 = this.titleBar;
        if (qUISecNavBar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            qUISecNavBar5 = null;
        }
        qUISecNavBar5.setCenterText("");
        QUISecNavBar qUISecNavBar6 = this.titleBar;
        if (qUISecNavBar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            qUISecNavBar6 = null;
        }
        qUISecNavBar6.setLeftImageResInTransParent(R.drawable.qui_chevron_left);
        QUISecNavBar qUISecNavBar7 = this.titleBar;
        if (qUISecNavBar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        } else {
            qUISecNavBar2 = qUISecNavBar7;
        }
        qUISecNavBar2.setTitleAlpha(0.0f);
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> ji() {
        String string = getString(R.string.cm7);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.official_website)");
        final x xVar = new x(new x.b.C8996b(string, R.drawable.qui_at), new x.c.d("", "", true, false, 8, null));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.about.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AboutFragment.ki(AboutFragment.this, view);
            }
        });
        xVar.T(AboutFragment$officialWebsite$1$2.INSTANCE);
        MutableLiveData<Pair<UpgradeDetailWrapper, String>> d26 = this.viewModel.d2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Pair<? extends UpgradeDetailWrapper, ? extends String>, Unit> function1 = new Function1<Pair<? extends UpgradeDetailWrapper, ? extends String>, Unit>(xVar) { // from class: com.tencent.mobileqq.activity.about.AboutFragment$officialWebsite$1$3
            static IPatchRedirector $redirector_;
            final /* synthetic */ x<x.b.C8996b, x.c.d> $this_apply;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_apply = xVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AboutFragment.this, (Object) xVar);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends UpgradeDetailWrapper, ? extends String> pair) {
                invoke2((Pair<? extends UpgradeDetailWrapper, String>) pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<? extends UpgradeDetailWrapper, String> it) {
                int Nh;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                AboutFragment aboutFragment = AboutFragment.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                Nh = aboutFragment.Nh(it);
                if (Nh == 0 && ae.b(it.getSecond(), AppSetting.f99551k) > 0) {
                    x.c.d O = this.$this_apply.O();
                    String qqStr = HardCodeUtil.qqStr(R.string.j0h);
                    Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qqstr_aboutact_dd3d0536)");
                    O.h(qqStr);
                    this.$this_apply.O().j("showImage");
                    return;
                }
                this.$this_apply.O().h("");
                this.$this_apply.O().j("");
            }
        };
        d26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.activity.about.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AboutFragment.li(Function1.this, obj);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ki(AboutFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Oh();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ReportController.o((QQAppInterface) peekAppRuntime, "CliOper", "", "", "0X8005745", "0X8005745", 0, 0, "", "", "", "");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void li(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void mi(x<?, ?> config, final Pair<? extends UpgradeDetailWrapper, String> versionInfo) {
        config.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.about.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AboutFragment.ni(Pair.this, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ni(Pair versionInfo, AboutFragment this$0, View view) {
        boolean z16;
        boolean z17;
        UpgradeDetailWrapper.b bVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(versionInfo, "$versionInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean j3 = com.tencent.mobileqq.upgrade.n.j();
        int i3 = 1;
        if (ae.b((String) versionInfo.getSecond(), AppSetting.f99551k) > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!j3 && z16) {
            this$0.Oh();
        } else {
            int Nh = this$0.Nh(versionInfo);
            UpgradeDetailWrapper upgradeDetailWrapper = (UpgradeDetailWrapper) versionInfo.getFirst();
            if (upgradeDetailWrapper != null) {
                if (Nh == 3) {
                    boolean G = MyAppApi.G();
                    if (!G && (bVar = upgradeDetailWrapper.f306173h) != null && dx.e(bVar.f306179d)) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (G || z17) {
                        if (!dx.b()) {
                            i3 = 2;
                        }
                        q.f("0X8008FFB", i3);
                        Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) UpgradeActivity.class);
                        intent.putExtra("StrTitle", upgradeDetailWrapper.f306170d.strTitle);
                        intent.putExtra("StrNewTitle", upgradeDetailWrapper.f306170d.strNewTitle);
                        intent.putExtra("StrUpgradeDesc", upgradeDetailWrapper.f306170d.strUpgradeDesc);
                        String P = com.tencent.mobileqq.upgrade.m.P(upgradeDetailWrapper.f306170d.strProgressName);
                        if (!TextUtils.isEmpty(P)) {
                            intent.putExtra("StrVersion", P);
                        }
                        intent.putExtra("iUpgradeType", upgradeDetailWrapper.f306170d.iUpgradeType);
                        intent.putExtra("activity_type", 4096);
                        this$0.startActivity(intent);
                    }
                }
                String g16 = com.tencent.mobileqq.upgrade.k.g();
                Intrinsics.checkNotNullExpressionValue(g16, "getAppIdUpgradeTo()");
                q.c("0X8004DB2", g16);
                FragmentActivity activity = this$0.getActivity();
                if (activity != null) {
                    UpgradeDetailActivity.Y2(activity, com.tencent.mobileqq.upgrade.k.i().j(), false, false, true);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pi() {
        PolarImageRender polarLightRender;
        if (getContext() == null) {
            QLog.e("AboutFragment", 1, "startLightChaserView context is null");
            return;
        }
        if (u.a().b()) {
            QLog.d("AboutFragment", 1, "onClick too fast");
            return;
        }
        Intent intent = new Intent(getContext(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("fragmentStyle", 10);
        intent.putExtra("uin", getCurrentUin());
        QUIPolarLightView qUIPolarLightView = this.polarLight;
        if (qUIPolarLightView != null && (polarLightRender = qUIPolarLightView.getPolarLightRender()) != null) {
            intent.putExtra("polar_light_frame", polarLightRender.getFirstFrame());
        }
        startActivity(intent.putExtra("url", "https://ti.qq.com/light-chaser/lighter/index.html?_wv=131072&_fv=0&_cntclr=00000000&user_from=android"));
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(((ISuperQQTaskApi) QRoute.api(ISuperQQTaskApi.class)).getEasterEggPart());
            return arrayListOf;
        }
        return (List) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return R.layout.dps;
    }

    @NotNull
    public final String getCurrentUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
        Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        String currentAccountUin = ((QQAppInterface) runtime).getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "app.currentAccountUin");
        return currentAccountUin;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }

    public final void oi(@NotNull RedTouch redTouch) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) redTouch);
            return;
        }
        Intrinsics.checkNotNullParameter(redTouch, "redTouch");
        BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        BusinessInfoCheckUpdate.AppInfo appInfo = new BusinessInfoCheckUpdate.AppInfo();
        redTypeInfo.red_type.set(0);
        redTypeInfo.red_desc.set("");
        redTypeInfo.red_content.set("");
        appInfo.red_display_info.red_type_info.add(redTypeInfo);
        appInfo.iNewFlag.set(1);
        redTouch.parseRedTouch(redTypeInfo);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        Integer num;
        FragmentActivity activity;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
        } else {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
            RedTouch redTouch = null;
            if (view != null) {
                num = Integer.valueOf(view.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.f167083kl0) {
                Intent intent = new Intent(getContext(), (Class<?>) QQBrowserActivity.class);
                intent.putExtra("uin", getCurrentUin());
                startActivity(intent.putExtra("url", this.userAgreementUrl));
                ReportController.o(qQAppInterface, "CliOper", "", "", "0X8005746", "0X8005746", 0, 0, "", "", "", "");
                RedTouch redTouch2 = this.userAgreementRedTouch;
                if (redTouch2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("userAgreementRedTouch");
                } else {
                    redTouch = redTouch2;
                }
                redTouch.clearRedTouch();
                PrivacyPolicyHelper.setHasShownUserAgreementRedPoint();
            } else if (num != null && num.intValue() == R.id.fzg) {
                Intent intent2 = new Intent(getContext(), (Class<?>) QQBrowserActivity.class);
                intent2.putExtra("uin", getCurrentUin());
                intent2.putExtra("title", getResources().getString(R.string.d0e));
                startActivity(intent2.putExtra("url", this.privacyUrl));
                RedTouch redTouch3 = this.privacyPolicyRedTouch;
                if (redTouch3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("privacyPolicyRedTouch");
                } else {
                    redTouch = redTouch3;
                }
                redTouch.clearRedTouch();
                PrivacyPolicyHelper.setAboutPageHasShownPrivacyPolicyRedPoint();
            } else if (num != null && num.intValue() == R.id.f27620gq && (activity = getActivity()) != null) {
                Intent intent3 = new Intent();
                intent3.putExtra("url", AppConstants.URL.PRIVACY_SUNMMARY);
                intent3.putExtra("hide_more_button", true);
                RouteUtils.startActivity(activity, intent3, RouterConstants.UI_ROUTE_BROWSER);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @SuppressLint({"MissingInflatedId"})
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            rootView = (View) iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            if (AppSetting.o(getContext())) {
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.setRequestedOrientation(-1);
                }
            } else {
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    activity2.setRequestedOrientation(1);
                }
            }
            rootView = inflater.inflate(R.layout.dps, container, false);
            rootView.setBackground(MainResourceConfig.INSTANCE.c(getContext()));
            this.viewModel.addObserver();
            Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
            initTitleBar(rootView);
            di(rootView);
            Vh(rootView);
            ei(rootView);
            Zh(rootView);
            fi(rootView);
            ci(rootView);
            bi(rootView);
            Uh(rootView);
            Xh(rootView);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            ReportController.y((QQAppInterface) peekAppRuntime, "0X800C5B3");
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, rootView);
        return rootView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.onDestroy();
        this.viewModel.removeObserver();
        com.tencent.mobileqq.activity.about.modelviewer.b bVar = this.modelController;
        if (bVar != null) {
            bVar.g();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.onPause();
        com.tencent.mobileqq.activity.about.modelviewer.b bVar = this.modelController;
        if (bVar != null) {
            bVar.h();
        }
        QUIPolarLightView qUIPolarLightView = this.polarLight;
        if (qUIPolarLightView != null) {
            qUIPolarLightView.stopAnimation();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.onResume();
        com.tencent.mobileqq.activity.about.modelviewer.b bVar = this.modelController;
        if (bVar != null) {
            bVar.i();
        }
        QUIPolarLightView qUIPolarLightView = this.polarLight;
        if (qUIPolarLightView != null) {
            qUIPolarLightView.m();
        }
    }

    private final void Zh(View root) {
    }
}
