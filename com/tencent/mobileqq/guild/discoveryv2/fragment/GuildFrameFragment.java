package com.tencent.mobileqq.guild.discoveryv2.fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.discoveryv2.jump.GuildDiscoveryMFJumpHelper;
import com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.guild.performance.report.y;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.TraceUtils;
import com.tencent.mobileqq.guild.util.at;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.util.cv;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.u;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.richframework.argus.node.ArgusTag;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppActivity;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@ArgusTag(testConfigKey = "Argus_Guild", testTags = {"AUTO_PRELOAD"})
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 a2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001bB\u0007\u00a2\u0006\u0004\b_\u0010`J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\"\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016J\b\u0010#\u001a\u00020\u0004H\u0016J\b\u0010$\u001a\u00020\u0004H\u0016J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u001bH\u0016J\b\u0010'\u001a\u00020\u001bH\u0016J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0016H\u0016J\b\u0010*\u001a\u00020\u001bH\u0016J\u0012\u0010,\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010/\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u001bH\u0016J\u0010\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0006H\u0016J\u0010\u00102\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0006H\u0016J\u001a\u00106\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u001b2\b\u00105\u001a\u0004\u0018\u000104H\u0016J\u0012\u00108\u001a\u00020\u00042\b\u00107\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010<\u001a\u00020\u00042\b\u0010:\u001a\u0004\u0018\u0001092\u0006\u0010;\u001a\u00020\u001bH\u0016J\u0012\u0010=\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010>\u001a\u00020\u0004H\u0016J\b\u0010?\u001a\u00020\u0004H\u0016J\u0010\u0010B\u001a\u00020\u001b2\u0006\u0010A\u001a\u00020@H\u0016J\n\u0010D\u001a\u0004\u0018\u00010CH\u0016J\u0010\u0010E\u001a\u00020\u001b2\u0006\u0010;\u001a\u00020\u001bH\u0016R\u0016\u0010H\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010K\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010^\u001a\u00020\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010]\u00a8\u0006c"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/fragment/GuildFrameFragment;", "Lcom/tencent/mobileqq/guild/mainframe/AbsGuildMainFragment;", "Landroid/os/Handler$Callback;", "Lcom/tencent/mobileqq/webview/swift/u;", "", "initView", "", "Bh", OcrConfig.CHINESE, "Ch", "Ah", "Dh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "th", "qh", "xh", "", "tabChanged", "wh", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "vh", "yh", "rh", "gg", "isSwitchAccount", "md", "uh", "intent", "sh", "ph", "extra", "handleJumpAction", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TYPE, "isPlayAnim", "guildCenterPanelInOrOut", "height", "onPostThemeChanged", "setTabHeight", "guildTab", "Lcom/tencent/mobileqq/guild/message/unread/api/IGuildUnreadCntService$b;", "tabUnreadCntInfo", "onTabChanged", "view", "onGuildTabClick", "", "source", NodeProps.VISIBLE, "changeGuildFacadeVisible", "onCreate", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/os/Message;", "msg", "handleMessage", "Lcom/tencent/mobileqq/webview/swift/WebViewFragment;", "getCurrentWebViewFragment", "setBottomBarVisibility", BdhLogUtil.LogTag.Tag_Conn, "I", "tabHeight", "D", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroidx/fragment/app/FragmentContainerView;", "E", "Landroidx/fragment/app/FragmentContainerView;", "fragmentContainer", "Lcom/tencent/mobileqq/guild/discoveryv2/fragment/c;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/discoveryv2/fragment/c;", "contentFragmentApi", "Lcom/tencent/mobileqq/guild/discoveryv2/fragment/DiscoveryMultiTabFragment;", "G", "Lcom/tencent/mobileqq/guild/discoveryv2/fragment/DiscoveryMultiTabFragment;", "contentFragment", "Lmi1/a;", "H", "Lmi1/a;", "mDragListener", "Landroid/os/Handler;", "Landroid/os/Handler;", "mainHandler", "<init>", "()V", "J", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFrameFragment extends AbsGuildMainFragment implements Handler.Callback, u {

    /* renamed from: D, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: E, reason: from kotlin metadata */
    private FragmentContainerView fragmentContainer;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private c contentFragmentApi;

    /* renamed from: C, reason: from kotlin metadata */
    private int tabHeight = Bh();

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private DiscoveryMultiTabFragment contentFragment = new DiscoveryMultiTabFragment();

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private mi1.a mDragListener = new mi1.a();

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Handler mainHandler = new Handler(Looper.getMainLooper(), this);

    public GuildFrameFragment() {
        uh1.a.f438959a.d("GuildFrame init");
        cv.c("GuildFrame init");
    }

    private final void Ah() {
        this.mainHandler.removeMessages(2);
        this.mainHandler.sendEmptyMessageDelayed(2, 1000L);
    }

    private final int Bh() {
        float f16;
        if (QQTheme.isCustomTheme("", false)) {
            f16 = 64.0f;
        } else {
            f16 = 54.0f;
        }
        return QQGuildUIUtil.f(f16);
    }

    private final void Ch() {
        DragFrameLayout dragFrameLayout;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            dragFrameLayout = (DragFrameLayout) activity.findViewById(tp1.a.a());
        } else {
            dragFrameLayout = null;
        }
        if (dragFrameLayout != null) {
            String str = com.tencent.mobileqq.activity.home.impl.b.f183056s;
            dragFrameLayout.removeOnDragModeChangeListenerByGroup(str, this.mDragListener);
            dragFrameLayout.removeDragViewProviderByGroup(str, this.mDragListener);
            dragFrameLayout.setOnDragListener((QUIBadgeDragLayout.OnDragListener) null);
        }
    }

    private final void Dh() {
        this.mainHandler.removeMessages(1);
        this.mainHandler.sendEmptyMessageDelayed(1, 100L);
    }

    private final void initView() {
        Bundle bundle;
        View view = this.rootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        View findViewById = view.findViewById(R.id.content);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.content)");
        this.fragmentContainer = (FragmentContainerView) findViewById;
        if (this.contentFragmentApi == null) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            FragmentTransaction beginTransaction = childFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
            DiscoveryMultiTabFragment discoveryMultiTabFragment = this.contentFragment;
            Bundle arguments = getArguments();
            if (arguments != null) {
                Intrinsics.checkNotNullExpressionValue(arguments, "arguments");
                bundle = qw1.b.u(arguments, Reporters.f231995a.b().newReportTask().setEventCode("guild_tab_page").setStageCode("stage_open").report(), null, 2, null);
            } else {
                bundle = null;
            }
            discoveryMultiTabFragment.setArguments(bundle);
            discoveryMultiTabFragment.setTabHeight(this.tabHeight);
            this.contentFragmentApi = discoveryMultiTabFragment;
            FragmentContainerView fragmentContainerView = this.fragmentContainer;
            if (fragmentContainerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
                fragmentContainerView = null;
            }
            beginTransaction.replace(fragmentContainerView.getId(), discoveryMultiTabFragment);
            beginTransaction.commitAllowingStateLoss();
        }
        TraceUtils traceUtils = TraceUtils.f235403a;
        View view3 = this.rootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            view2 = view3;
        }
        traceUtils.e(view2, "Guild.DiscoveryMain.Fragment.RootViewPreDraw", new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.fragment.GuildFrameFragment$initView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FragmentActivity activity = GuildFrameFragment.this.getActivity();
                if (activity != null) {
                    cv.a("GUILD");
                    uh1.a.f438959a.d("GuildFrame onPreDraw");
                    MobileQQ.sMobileQQ.onActivityFocusChanged((AppActivity) activity, true);
                }
                y.d("GuildDiscoveryMainFragment");
                uh1.a.f438959a.c();
            }
        });
    }

    private final void zh() {
        DragFrameLayout dragFrameLayout;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            dragFrameLayout = (DragFrameLayout) activity.findViewById(tp1.a.a());
        } else {
            dragFrameLayout = null;
        }
        if (dragFrameLayout != null) {
            String str = com.tencent.mobileqq.activity.home.impl.b.f183056s;
            dragFrameLayout.removeOnDragModeChangeListenerByGroup(str, this.mDragListener);
            dragFrameLayout.addOnDragModeChangeListenerByGroup(str, this.mDragListener, true);
            dragFrameLayout.addDragViewProviderByGroup(str, this.mDragListener, true);
            dragFrameLayout.setOnDragListener(this.mDragListener);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.u
    @Nullable
    public WebViewFragment getCurrentWebViewFragment() {
        DiscoveryMultiTabFragment discoveryMultiTabFragment = this.contentFragment;
        if (!(discoveryMultiTabFragment instanceof u)) {
            discoveryMultiTabFragment = null;
        }
        if (discoveryMultiTabFragment == null) {
            return null;
        }
        return discoveryMultiTabFragment.getCurrentWebViewFragment();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void gg() {
        c cVar = this.contentFragmentApi;
        if (cVar != null) {
            cVar.gg();
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.s
    public void handleJumpAction(@Nullable Bundle extra) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            GuildDiscoveryMFJumpHelper.b(activity, extra);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        int i3 = msg2.what;
        if (i3 != 1) {
            if (i3 != 2) {
                return false;
            }
            if (at.c()) {
                wp1.c.k();
            }
            return true;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            QUIImmersiveHelper.u(activity.getWindow(), true, false);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void md(boolean isSwitchAccount) {
        c cVar = this.contentFragmentApi;
        if (cVar != null) {
            cVar.md(isSwitchAccount);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        IGuildTempApi iGuildTempApi = (IGuildTempApi) QRoute.api(IGuildTempApi.class);
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        iGuildTempApi.adjustTab((QBaseActivity) activity);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        zh();
        Ah();
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        uh1.a aVar = uh1.a.f438959a;
        aVar.d("GuildFrame BeforeCreateView");
        View inflate = inflater.inflate(R.layout.f168058el0, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026agment, container, false)");
        this.rootView = inflate;
        initView();
        aVar.d("GuildFrame AfterCreateView");
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Ch();
        this.mainHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.s
    public void onGuildTabClick(@Nullable View view) {
        boolean isGuildTabSelected = ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isGuildTabSelected();
        Logger.f235387a.d().d("GuildDiscoveryMainFragment", 1, "onGuildTabClick with isGuildTabSelected:" + isGuildTabSelected);
        c cVar = this.contentFragmentApi;
        if (cVar != null) {
            cVar.q6(isGuildTabSelected, new Pair<>(Boolean.FALSE, null));
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        y.c();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.s
    public void onPostThemeChanged(int height) {
        c cVar = this.contentFragmentApi;
        if (cVar != null) {
            cVar.onPostThemeChanged(height);
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.s
    public void onTabChanged(boolean guildTab, @Nullable IGuildUnreadCntService.b tabUnreadCntInfo) {
        Logger.f235387a.d().d("GuildDiscoveryMainFragment", 1, "onTabChanged");
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public boolean ph() {
        Object m476constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(getParentFragmentManager());
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m482isFailureimpl(m476constructorimpl)) {
            m476constructorimpl = null;
        }
        if (m476constructorimpl != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.u
    public boolean setBottomBarVisibility(boolean visible) {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.s
    public void setTabHeight(int height) {
        if (this.tabHeight != height) {
            this.tabHeight = height;
            c cVar = this.contentFragmentApi;
            if (cVar != null) {
                cVar.setTabHeight(height);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void sh(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.contentFragment.onNewIntent(intent);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public boolean uh() {
        return this.contentFragment.onBackEvent();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void vh(boolean tabChanged) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("GuildDiscoveryMainFragment", "notifyPause " + hashCode());
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void wh(boolean tabChanged) {
        IGuildTempApi iGuildTempApi = (IGuildTempApi) QRoute.api(IGuildTempApi.class);
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        iGuildTempApi.adjustTab((QBaseActivity) activity);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("GuildDiscoveryMainFragment", "notifyResume " + hashCode());
        }
        Dh();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void qh() {
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void rh() {
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void xh() {
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void yh() {
    }

    @Override // com.tencent.mobileqq.guild.mainframe.s
    public void changeGuildFacadeVisible(@Nullable String source, boolean visible) {
    }

    @Override // com.tencent.mobileqq.guild.mainframe.s
    public void guildCenterPanelInOrOut(int showType, boolean isPlayAnim) {
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void th(int requestCode, int resultCode, @Nullable Intent data) {
    }
}
