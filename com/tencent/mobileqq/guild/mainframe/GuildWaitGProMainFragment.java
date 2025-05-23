package com.tencent.mobileqq.guild.mainframe;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.be;
import com.tencent.mobileqq.guild.base.fragments.GProWaitLogicFragment;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.util.LoadingUtil;
import cooperation.qzone.QzoneIPCModule;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import mqq.app.Constants;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 L2\u00020\u0001:\u0001MB\u0007\u00a2\u0006\u0004\bJ\u0010KJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\"\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010!\u001a\u00020\u0004H\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016J\b\u0010#\u001a\u00020\u0004H\u0016J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0017H\u0016J\b\u0010&\u001a\u00020\u0017H\u0016J\b\u0010'\u001a\u00020\u0017H\u0016J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0017H\u0016J\u0012\u0010+\u001a\u00020\u00042\b\u0010*\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010.\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u0017H\u0016J\u0010\u00100\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u001aH\u0016J\u0010\u00101\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u001aH\u0016J\u001a\u00105\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00172\b\u00104\u001a\u0004\u0018\u000103H\u0016J\u001a\u00109\u001a\u00020\u00042\b\u00107\u001a\u0004\u0018\u0001062\u0006\u00108\u001a\u00020\u0017H\u0016R\u0018\u0010<\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010;R\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00040C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010I\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010H\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/GuildWaitGProMainFragment;", "Lcom/tencent/mobileqq/guild/mainframe/AbsGuildMainFragment;", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "Dh", "", "Eh", "Landroid/view/View;", "view", "onGuildTabClick", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "onDestroyView", "qh", "onStart", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, DKHippyEvent.EVENT_STOP, "xh", "", "tabChanged", "wh", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "th", "vh", "yh", "rh", "gg", "isSwitchAccount", "md", "uh", "ph", "isInMultiWindowMode", "onMultiWindowModeChanged", "extra", "handleJumpAction", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TYPE, "isPlayAnim", "guildCenterPanelInOrOut", "height", "onPostThemeChanged", "setTabHeight", "guildTab", "Lcom/tencent/mobileqq/guild/message/unread/api/IGuildUnreadCntService$b;", "tabUnreadCntInfo", "onTabChanged", "", "source", NodeProps.VISIBLE, "changeGuildFacadeVisible", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "loadingText", "E", "loadingView", "Lkotlinx/coroutines/CompletableDeferred;", UserInfo.SEX_FEMALE, "Lkotlinx/coroutines/CompletableDeferred;", "gproReadyDeferred", "G", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "serviceObserver", "<init>", "()V", "H", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildWaitGProMainFragment extends AbsGuildMainFragment {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static boolean I;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private View rootView;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView loadingText;

    /* renamed from: E, reason: from kotlin metadata */
    private View loadingView;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final CompletableDeferred<Unit> gproReadyDeferred = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final GPServiceObserver serviceObserver = Dh();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/GuildWaitGProMainFragment$a;", "", "", "a", "", "TAG", "Ljava/lang/String;", "isGproNotReady", "Z", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.mainframe.GuildWaitGProMainFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            com.tencent.mobileqq.guild.base.extension.r rVar = com.tencent.mobileqq.guild.base.extension.r.f214743a;
            IRuntimeService S0 = ch.S0(IGProSession.class, "");
            Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
            if (((IGProSession) S0).getGproStartCountDownLatch().getCount() <= 0 && !GuildWaitGProMainFragment.I) {
                return false;
            }
            return true;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/mainframe/GuildWaitGProMainFragment$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "onStartGProComplete", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onStartGProComplete() {
            Logger.f235387a.d().i("GuildWaitGProMainFragment", 1, "onStartGProComplete()");
            GuildWaitGProMainFragment.this.gproReadyDeferred.complete(Unit.INSTANCE);
        }
    }

    private final GPServiceObserver Dh() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Eh() {
        final u uVar;
        be a16 = GuildFragmentDelegateFrame.INSTANCE.a(getContext());
        if (a16 instanceof u) {
            uVar = (u) a16;
        } else {
            uVar = null;
        }
        if (uVar != null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.r
                @Override // java.lang.Runnable
                public final void run() {
                    GuildWaitGProMainFragment.Fh(u.this);
                }
            });
            return;
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        bVar.a().add("Failed to restore main frame! frame is null!");
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("GuildWaitGProMainFragment", 1, (String) it.next(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(u uVar) {
        uVar.restoreGuildTabFragment();
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        com.tencent.mobileqq.guild.base.extension.r rVar = com.tencent.mobileqq.guild.base.extension.r.f214743a;
        IRuntimeService S0 = ch.S0(IGProGlobalService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        ((IGProGlobalService) S0).addObserver(this.serviceObserver);
        View rootView = inflater.inflate(R.layout.f168097es4, container, false);
        View loadingDialogTipsRight = LoadingUtil.getLoadingDialogTipsRight(getActivity(), false);
        Intrinsics.checkNotNullExpressionValue(loadingDialogTipsRight, "getLoadingDialogTipsRight(activity, false)");
        this.loadingView = loadingDialogTipsRight;
        FrameLayout frameLayout = (FrameLayout) rootView.findViewById(R.id.ef_);
        View view = this.loadingView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            view = null;
        }
        frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
        View view3 = this.loadingView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
        } else {
            view2 = view3;
        }
        TextView textView = (TextView) view2.findViewById(R.id.yt9);
        if (textView == null) {
            View findViewById = rootView.findViewById(R.id.efo);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.loading_text)");
            textView = (TextView) findViewById;
        }
        this.loadingText = textView;
        rootView.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        this.rootView = rootView;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, rootView);
        return rootView;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        com.tencent.mobileqq.guild.base.extension.r rVar = com.tencent.mobileqq.guild.base.extension.r.f214743a;
        IRuntimeService S0 = ch.S0(IGProGlobalService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        ((IGProGlobalService) S0).deleteObserver(this.serviceObserver);
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Logger.f235387a.d().i("GuildWaitGProMainFragment", 1, "onPause()");
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Logger.f235387a.d().i("GuildWaitGProMainFragment", 1, "onResume()");
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Logger.f235387a.d().i("GuildWaitGProMainFragment", 1, "onStart()");
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Logger.f235387a.d().i("GuildWaitGProMainFragment", 1, "onStop()");
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

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void qh() {
        Logger.f235387a.d().i("GuildWaitGProMainFragment", 1, "notifyCreate()");
        GProWaitLogicFragment.Companion companion = GProWaitLogicFragment.INSTANCE;
        TextView textView = this.loadingText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingText");
            textView = null;
        }
        companion.a(this, textView, new GuildWaitGProMainFragment$notifyCreate$2(this, null), new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.mainframe.GuildWaitGProMainFragment$notifyCreate$3
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
                GuildWaitGProMainFragment.this.Eh();
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public boolean uh() {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void wh(boolean tabChanged) {
        Logger.f235387a.d().i("GuildWaitGProMainFragment", 1, "notifyStart()");
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void xh() {
        Logger.f235387a.d().i("GuildWaitGProMainFragment", 1, "notifyStart()");
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void gg() {
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void rh() {
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void yh() {
    }

    @Override // com.tencent.mobileqq.guild.mainframe.s
    public void handleJumpAction(@Nullable Bundle extra) {
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void md(boolean isSwitchAccount) {
    }

    @Override // com.tencent.mobileqq.guild.mainframe.s
    public void onGuildTabClick(@Nullable View view) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
    }

    @Override // com.tencent.mobileqq.guild.mainframe.s
    public void onPostThemeChanged(int height) {
    }

    @Override // com.tencent.mobileqq.guild.mainframe.s
    public void setTabHeight(int height) {
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void vh(boolean tabChanged) {
    }

    @Override // com.tencent.mobileqq.guild.mainframe.s
    public void changeGuildFacadeVisible(@Nullable String source, boolean visible) {
    }

    @Override // com.tencent.mobileqq.guild.mainframe.s
    public void guildCenterPanelInOrOut(int showType, boolean isPlayAnim) {
    }

    @Override // com.tencent.mobileqq.guild.mainframe.s
    public void onTabChanged(boolean guildTab, @Nullable IGuildUnreadCntService.b tabUnreadCntInfo) {
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void th(int requestCode, int resultCode, @Nullable Intent data) {
    }
}
