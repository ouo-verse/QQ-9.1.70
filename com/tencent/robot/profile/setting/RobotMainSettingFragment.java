package com.tencent.robot.profile.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.robot.adelie.AdelieFragmentActivity;
import com.tencent.robot.profile.setting.b;
import com.tencent.robot.profile.setting.view.RobotSettingView;
import cooperation.qzone.QzoneIPCModule;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\t*\u00011\u0018\u0000 72\u00020\u0001:\u00018B\u0007\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0016\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\"\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0002H\u0016R\u001b\u0010\"\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00069"}, d2 = {"Lcom/tencent/robot/profile/setting/RobotMainSettingFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "initArguments", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initUI", "th", "", "getPageId", "", "", "rh", "", "needImmersive", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "onCreate", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", MosaicConstants$JsFunction.FUNC_ON_DESTROY, BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "sh", "()I", "topPadding", "Lcom/tencent/robot/profile/setting/view/RobotSettingView;", "D", "Lcom/tencent/robot/profile/setting/view/RobotSettingView;", "settingView", "Lcom/tencent/robot/profile/setting/c;", "E", "Lcom/tencent/robot/profile/setting/c;", "settingData", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "quiSecNavBar", "G", "Landroid/view/View;", "com/tencent/robot/profile/setting/RobotMainSettingFragment$b", "H", "Lcom/tencent/robot/profile/setting/RobotMainSettingFragment$b;", "profileListener", "<init>", "()V", "I", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotMainSettingFragment extends QPublicBaseFragment {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy topPadding;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private RobotSettingView settingView;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private RobotSettingData settingData;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private QUISecNavBar quiSecNavBar;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private View rootView;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final b profileListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/robot/profile/setting/RobotMainSettingFragment$a;", "", "Landroid/content/Context;", "context", "", "robotUin", "troopUin", "", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.profile.setting.RobotMainSettingFragment$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String robotUin, @NotNull String troopUin) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            AdelieFragmentActivity.INSTANCE.a(context, RobotSettingData.INSTANCE.a(robotUin, troopUin), RobotMainSettingFragment.class);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/profile/setting/RobotMainSettingFragment$b", "Lcom/tencent/robot/profile/setting/b$a;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "robotProfile", "", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements b.a {
        b() {
        }

        @Override // com.tencent.robot.profile.setting.b.a
        public void a(@Nullable GroupRobotProfile robotProfile) {
            if (robotProfile != null) {
                RobotMainSettingFragment robotMainSettingFragment = RobotMainSettingFragment.this;
                robotMainSettingFragment.settingData.j(robotProfile);
                RobotSettingView robotSettingView = robotMainSettingFragment.settingView;
                if (robotSettingView != null) {
                    robotSettingView.setData(robotMainSettingFragment.settingData);
                }
            }
        }
    }

    public RobotMainSettingFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.robot.profile.setting.RobotMainSettingFragment$topPadding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                Context requireContext = RobotMainSettingFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                return Integer.valueOf(com.tencent.biz.qui.quisecnavbar.e.b(requireContext));
            }
        });
        this.topPadding = lazy;
        this.settingData = new RobotSettingData(null, null, null, 7, null);
        this.profileListener = new b();
    }

    private final String getPageId() {
        if (this.settingData.g()) {
            return "pg_bas_group_chat_bot_setup";
        }
        return "pg_bas_robot_settings";
    }

    private final void initArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.settingData.i(arguments);
            GroupRobotProfile c16 = com.tencent.robot.profile.setting.b.f368096a.c();
            if (c16 != null) {
                this.settingData.j(c16);
            }
        }
    }

    private final void initUI(View rootView) {
        QUISecNavBar qUISecNavBar;
        QUISecNavBar qUISecNavBar2 = (QUISecNavBar) rootView.findViewById(R.id.jo9);
        this.quiSecNavBar = qUISecNavBar2;
        if (qUISecNavBar2 != null) {
            qUISecNavBar2.setBaseViewDescription(BaseAction.ACTION_LEFT_BUTTON, "\u8fd4\u56de");
        }
        QUISecNavBar qUISecNavBar3 = this.quiSecNavBar;
        if (qUISecNavBar3 != null) {
            qUISecNavBar3.S(this);
        }
        QUISecNavBar qUISecNavBar4 = this.quiSecNavBar;
        if (qUISecNavBar4 != null) {
            qUISecNavBar4.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>() { // from class: com.tencent.robot.profile.setting.RobotMainSettingFragment$initUI$1

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                /* loaded from: classes25.dex */
                public /* synthetic */ class a {

                    /* renamed from: a, reason: collision with root package name */
                    public static final /* synthetic */ int[] f368090a;

                    static {
                        int[] iArr = new int[BaseAction.values().length];
                        try {
                            iArr[BaseAction.ACTION_LEFT_BUTTON.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        f368090a = iArr;
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(View view, BaseAction baseAction) {
                    invoke2(view, baseAction);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View view, @NotNull BaseAction action) {
                    Context context;
                    Activity i3;
                    Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(action, "action");
                    if (a.f368090a[action.ordinal()] != 1 || (context = RobotMainSettingFragment.this.getContext()) == null || (i3 = KRCSSViewExtensionKt.i(context)) == null) {
                        return;
                    }
                    i3.finish();
                }
            });
        }
        QUISecNavBar qUISecNavBar5 = this.quiSecNavBar;
        if (qUISecNavBar5 != null) {
            qUISecNavBar5.setTitleBlurAlpha(0.0f);
        }
        th(rootView);
        RobotSettingView robotSettingView = this.settingView;
        if (robotSettingView != null && (qUISecNavBar = this.quiSecNavBar) != null) {
            QUISecNavBar.setBlur$default(qUISecNavBar, true, robotSettingView, 0, 4, null);
        }
        Context context = getContext();
        if (context != null) {
            QUISecNavBar qUISecNavBar6 = this.quiSecNavBar;
            if (qUISecNavBar6 != null) {
                qUISecNavBar6.setCenterText(context.getString(R.string.f223296fu));
            }
            if (QQTheme.isVasTheme()) {
                QUISecNavBar qUISecNavBar7 = this.quiSecNavBar;
                if (qUISecNavBar7 != null) {
                    QUISecNavBar.setBlur$default(qUISecNavBar7, false, null, 0, 4, null);
                }
                QUISecNavBar qUISecNavBar8 = this.quiSecNavBar;
                if (qUISecNavBar8 != null) {
                    qUISecNavBar8.setTitleAlpha(0.0f);
                }
                QUISecNavBar qUISecNavBar9 = this.quiSecNavBar;
                if (qUISecNavBar9 != null) {
                    qUISecNavBar9.setBackgroundColor(context.getColor(R.color.qui_common_bg_bottom_standard));
                }
            }
        }
    }

    private final Map<String, Object> rh() {
        Map<String, Object> mapOf;
        Map<String, Object> mapOf2;
        int i3 = 2;
        if (this.settingData.g()) {
            mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to("group_id", this.settingData.getTroopUin()), TuplesKt.to("agent_uin", this.settingData.getRobotUin()));
            return mapOf2;
        }
        Pair[] pairArr = new Pair[2];
        if (this.settingData.getProfile().isFriend) {
            i3 = 1;
        }
        pairArr[0] = TuplesKt.to("isfrd_tag", Integer.valueOf(i3));
        pairArr[1] = TuplesKt.to("agent_uin", this.settingData.getRobotUin());
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        return mapOf;
    }

    private final int sh() {
        return ((Number) this.topPadding.getValue()).intValue();
    }

    private final void th(View rootView) {
        Activity i3;
        RobotSettingView robotSettingView = (RobotSettingView) rootView.findViewById(R.id.f774244b);
        this.settingView = robotSettingView;
        if (robotSettingView != null) {
            robotSettingView.setPadding(0, sh(), 0, 0);
        }
        RobotSettingView robotSettingView2 = this.settingView;
        if (robotSettingView2 != null) {
            robotSettingView2.setData(this.settingData);
        }
        this.rootView = rootView;
        Context context = getContext();
        if (context != null && (i3 = KRCSSViewExtensionKt.i(context)) != null) {
            d.f368103a.b(i3, rootView, getPageId(), rh());
            VideoReport.reportEvent("dt_pgin", rootView, rh());
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Activity activity;
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1 && requestCode == 100 && data != null && data.getBooleanExtra("key_permissions_fragment_exit", false)) {
            Context context = getContext();
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (activity != null) {
                activity.finish();
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initArguments();
        com.tencent.robot.profile.setting.b.f368096a.a(this.profileListener);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View rootView = inflater.inflate(R.layout.hp5, container, false);
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        initUI(rootView);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, rootView);
        return rootView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.tencent.robot.profile.setting.b.f368096a.e(this.profileListener);
        VideoReport.reportEvent("dt_pgout", this.rootView, rh());
    }
}
