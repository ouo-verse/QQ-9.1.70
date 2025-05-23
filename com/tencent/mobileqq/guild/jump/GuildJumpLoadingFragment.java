package com.tencent.mobileqq.guild.jump;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;
import com.tencent.mobileqq.guild.jump.GuildJumpLoadingDialog;
import com.tencent.mobileqq.guild.jump.GuildJumpPageType;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ThreadUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 /2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00010B\u0007\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010\u001d\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001b0\u001aj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001b`\u001cH\u0016R\u0016\u0010 \u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/guild/jump/GuildJumpLoadingFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/guild/jump/GuildJumpLoadingEvent;", "", "finishActivity", "initView", "xh", "vh", "wh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/guild/component/animator/ScanningLightView;", "D", "Lcom/tencent/mobileqq/guild/component/animator/ScanningLightView;", "loadingView", "", "E", "I", "loadPageType", "", UserInfo.SEX_FEMALE, "Z", "hasResumeDisplayed", "<init>", "()V", "G", "Companion", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildJumpLoadingFragment extends QPublicBaseFragment implements SimpleEventReceiver<GuildJumpLoadingEvent> {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static long H;
    private static boolean I;

    /* renamed from: C */
    private View rootView;

    /* renamed from: D, reason: from kotlin metadata */
    private ScanningLightView loadingView;

    /* renamed from: E, reason: from kotlin metadata */
    private int loadPageType = 2;

    /* renamed from: F */
    private boolean hasResumeDisplayed;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\bR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/jump/GuildJumpLoadingFragment$Companion;", "", "Landroid/content/Context;", "context", "", "businessType", "", "supportsSplitMode", "", "b", "a", "", "TAG", "Ljava/lang/String;", "isClosed", "Z", "", "pageShowTime", "J", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void c(Companion companion, Context context, int i3, boolean z16, int i16, Object obj) {
            if ((i16 & 4) != 0) {
                z16 = true;
            }
            companion.b(context, i3, z16);
        }

        public final void a() {
            Logger.f235387a.d().d("Guild.jump.GuildJumpLoadingFragment", 1, "closeLoadingPage");
            long currentTimeMillis = System.currentTimeMillis() - GuildJumpLoadingFragment.H;
            GuildJumpLoadingFragment.I = true;
            if (currentTimeMillis < 100) {
                ThreadUtils.c(100 - currentTimeMillis, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.jump.GuildJumpLoadingFragment$Companion$closePage$2
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        SimpleEventBus.getInstance().dispatchEvent(new GuildJumpLoadingEvent());
                    }
                });
            } else {
                SimpleEventBus.getInstance().dispatchEvent(new GuildJumpLoadingEvent());
            }
        }

        public final void b(@NotNull Context context, int businessType, boolean supportsSplitMode) {
            FragmentActivity fragmentActivity;
            Intrinsics.checkNotNullParameter(context, "context");
            if (GuildJumpLoadingFragment.H != 0) {
                return;
            }
            GuildJumpPageType.Companion companion = GuildJumpPageType.INSTANCE;
            int a16 = companion.a(Integer.valueOf(businessType));
            if (a16 != 4) {
                GuildJumpLoadingFragment.I = false;
                GuildJumpLoadingFragment.H = System.currentTimeMillis();
                Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("loadingPageType", Integer.valueOf(a16)));
                if (supportsSplitMode) {
                    GuildSplitViewUtils guildSplitViewUtils = GuildSplitViewUtils.f235370a;
                    if (guildSplitViewUtils.D(context) && companion.b(a16)) {
                        Intent intent = new Intent();
                        intent.putExtras(bundleOf);
                        GuildSplitViewUtils.p(guildSplitViewUtils, context, intent, GuildJumpLoadingFragment.class, null, 8, null);
                        Logger.f235387a.d().d("Guild.jump.GuildJumpLoadingFragment", 1, "openJumpLoadingPage pageType: " + a16);
                        return;
                    }
                }
                Intent intent2 = new Intent();
                intent2.putExtras(bundleOf);
                if (!(context instanceof Activity)) {
                    intent2.addFlags(268435456);
                }
                QPublicFragmentActivity.start(context, intent2, GuildJumpLoadingFragment.class);
                Logger.f235387a.d().d("Guild.jump.GuildJumpLoadingFragment", 1, "openJumpLoadingPage pageType: " + a16);
                return;
            }
            GuildJumpLoadingDialog.Companion companion2 = GuildJumpLoadingDialog.INSTANCE;
            if (context instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context;
            } else {
                fragmentActivity = null;
            }
            companion2.a(fragmentActivity);
        }

        Companion() {
        }
    }

    private final void finishActivity() {
        H = 0L;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void initView() {
        int i3;
        View view = this.rootView;
        ScanningLightView scanningLightView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        View findViewById = view.findViewById(R.id.efs);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.loading_view)");
        this.loadingView = (ScanningLightView) findViewById;
        if (!GuildThemeManager.f235286a.b() && (i3 = this.loadPageType) != 7 && i3 != 9) {
            View view2 = this.rootView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                view2 = null;
            }
            view2.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
            ScanningLightView scanningLightView2 = this.loadingView;
            if (scanningLightView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            } else {
                scanningLightView = scanningLightView2;
            }
            scanningLightView.v(false);
        } else {
            View view3 = this.rootView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                view3 = null;
            }
            view3.setBackgroundColor(getResources().getColor(R.color.bqf));
            ScanningLightView scanningLightView3 = this.loadingView;
            if (scanningLightView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            } else {
                scanningLightView = scanningLightView3;
            }
            scanningLightView.v(true);
        }
        wh();
        xh();
    }

    private final void vh() {
        Logger.f235387a.d().d("Guild.jump.GuildJumpLoadingFragment", 1, "closeFragment isClosed=" + I + ", resumed=" + this.hasResumeDisplayed + ", finish " + this.loadPageType + " " + getActivity());
        if (!((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).isSplashActivityTop()) {
            finishActivity();
            return;
        }
        GuildSplitViewUtils guildSplitViewUtils = GuildSplitViewUtils.f235370a;
        if (guildSplitViewUtils.n(getActivity())) {
            GuildSplitViewUtils.u(guildSplitViewUtils, getActivity(), false, 2, null);
        }
    }

    private final void wh() {
        ImmersiveUtils.clearCoverForStatus(requireActivity().getWindow(), true);
        com.tencent.mobileqq.guild.base.extension.h.c(this);
        ImmersiveUtils.setStatusTextColor(true, requireActivity().getWindow());
    }

    private final void xh() {
        int i3 = this.loadPageType;
        int i16 = R.drawable.guild_feeds_home_loading;
        if (i3 != 2) {
            if (i3 != 9) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        if (i3 != 6) {
                            if (i3 != 7) {
                                if (i3 != 11) {
                                    if (i3 == 12) {
                                        i16 = R.drawable.guild_jump_loading_schedule_detail_page;
                                    }
                                } else {
                                    i16 = R.drawable.guild_jump_loading_feed_detail_page;
                                }
                            } else {
                                i16 = R.drawable.guild_jump_loading_video_page;
                            }
                        } else {
                            i16 = R.drawable.guild_jump_loading_feed_page;
                        }
                    } else {
                        i16 = R.drawable.guild_jump_loading_text_page;
                    }
                } else {
                    i16 = R.drawable.guild_jump_loading_join_guild_dialog;
                }
            } else {
                i16 = R.drawable.guild_jump_loading_media_page;
            }
        }
        ScanningLightView scanningLightView = this.loadingView;
        ScanningLightView scanningLightView2 = null;
        if (scanningLightView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            scanningLightView = null;
        }
        scanningLightView.setBackgroundResource(i16);
        if (this.loadPageType == 11) {
            View view = this.rootView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                view = null;
            }
            view.setFitsSystemWindows(true);
        }
        int i17 = this.loadPageType;
        if (i17 != 7 && i17 != 9) {
            ScanningLightView scanningLightView3 = this.loadingView;
            if (scanningLightView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            } else {
                scanningLightView2 = scanningLightView3;
            }
            scanningLightView2.setSkeletonColorRes(R.color.qui_common_fill_standard_primary);
            return;
        }
        int a16 = kotlin.g.a(getResources().getColor(R.color.f157145bq1), 40);
        int a17 = kotlin.g.a(getResources().getColor(R.color.qui_common_fill_light_tertiary), 10);
        ScanningLightView scanningLightView4 = this.loadingView;
        if (scanningLightView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            scanningLightView4 = null;
        }
        ScanningLightView.setSkeletonColor$default(scanningLightView4, a16, 0, 2, null);
        ScanningLightView scanningLightView5 = this.loadingView;
        if (scanningLightView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            scanningLightView5 = null;
        }
        ScanningLightView.setLightColor$default(scanningLightView5, a17, 0, 2, null);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<GuildJumpLoadingEvent>> getEventClass() {
        ArrayList<Class<GuildJumpLoadingEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildJumpLoadingEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity r36) {
        int i3;
        if (r36 == null) {
            return;
        }
        if (this.loadPageType == 9) {
            i3 = R.anim.f155071vn;
        } else {
            i3 = R.anim.f154619or;
        }
        r36.overridePendingTransition(i3, R.anim.f154442w);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup r36, @Nullable Bundle r46) {
        Intent intent;
        Bundle extras;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        SimpleEventBus.getInstance().registerReceiver(this);
        View inflate = inflater.inflate(R.layout.evn, r36, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026agment, container, false)");
        this.rootView = inflate;
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null && (extras = intent.getExtras()) != null) {
            this.loadPageType = extras.getInt("loadingPageType");
        }
        if (this.loadPageType == 0 && getArguments() != null) {
            this.loadPageType = requireArguments().getInt("loadingPageType");
        }
        Logger.f235387a.d().d("Guild.jump.GuildJumpLoadingFragment", 1, "onCreateView loadPageType: " + this.loadPageType);
        initView();
        if (I) {
            vh();
        }
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof GuildJumpLoadingEvent) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.jump.GuildJumpLoadingFragment", 2, "onReceiveEvent finish " + this.loadPageType + "  " + getActivity() + " ");
            }
            if (GuildSplitViewUtils.f235370a.n(getContext())) {
                return;
            }
            finishActivity();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (I || this.hasResumeDisplayed) {
            vh();
        }
        this.hasResumeDisplayed = true;
    }
}
