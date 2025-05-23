package com.tencent.mobileqq.guildhelper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.qui.quisecnavbar.b;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.home.chats.troophelper.TroopHelperFragment;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.guild.api.IGuildChannelLoadApi;
import com.tencent.mobileqq.guild.api.IGuildHelperApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guildhelper.GuildHelperFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.pad.d;
import com.tencent.mobileqq.pad.f;
import com.tencent.mobileqq.pad.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.chats.api.IChatsViewModelCreator;
import com.tencent.qqnt.chats.api.b;
import com.tencent.qqnt.chats.core.report.DTReportThreadHelper;
import com.tencent.qqnt.chats.core.ui.ChatsListVB;
import com.tencent.qqnt.chats.core.uievent.a;
import com.tencent.qqnt.chats.core.userintent.b;
import com.tencent.qqnt.chats.utils.ChatsColorCache;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\t*\u0001+\u0018\u0000 12\u00020\u00012\u00020\u00022\u00020\u0003:\u00012B\u0007\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J&\u0010\u0011\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\b\u0010\u001c\u001a\u00020\u0014H\u0016J\b\u0010\u001d\u001a\u00020\u0014H\u0016R\"\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/guildhelper/GuildHelperFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Lcom/tencent/mobileqq/pad/f;", "Lcom/tencent/mobileqq/pad/d;", "Landroid/view/View;", HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW, "", "initTitleBar", "", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "doOnCreateView", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "", "useQUISecNavBar", "needImmersive", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onPostThemeChanged", "onBackEvent", "qOnBackPressed", "qOnNewIntent", "shouldDispatchActivityResult", "shouldDispatchPostThemeChanged", "Lcom/tencent/qqnt/chats/core/mvi/a;", "Lcom/tencent/qqnt/chats/core/uistate/b;", "Lcom/tencent/qqnt/chats/core/userintent/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/chats/core/mvi/a;", "mChatsVM", "Lcom/tencent/qqnt/chats/biz/guildhelper/a;", "D", "Lcom/tencent/qqnt/chats/biz/guildhelper/a;", "mChatsVB", "E", "Z", "mIsSpiltView", "com/tencent/mobileqq/guildhelper/GuildHelperFragment$b", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guildhelper/GuildHelperFragment$b;", "mRightIcon", "<init>", "()V", "G", "a", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class GuildHelperFragment extends QIphoneTitleBarFragment implements f, d {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> mChatsVM;

    /* renamed from: D, reason: from kotlin metadata */
    private com.tencent.qqnt.chats.biz.guildhelper.a mChatsVB;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mIsSpiltView;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final b mRightIcon = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guildhelper/GuildHelperFragment$a;", "", "Landroid/content/Context;", "context", "", "a", "", TroopHelperFragment.KEY_IS_SPLIT_VIEW, "Ljava/lang/String;", "TAG", "<init>", "()V", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guildhelper.GuildHelperFragment$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Logger.f235387a.d().i("GuildHelperFragment", 1, "GuildHelper Performance click item");
            com.tencent.mobileqq.guild.report.b.g("msg_tab_list_pindaohelper", "GuildHelperFragment");
            if (AppSetting.t(context)) {
                com.tencent.mobileqq.pad.b h16 = new com.tencent.mobileqq.pad.b().e(false).g(false).h(LaunchMode.standard);
                Bundle bundle = new Bundle();
                bundle.putBoolean(TroopHelperFragment.KEY_IS_SPLIT_VIEW, true);
                i.e(context, bundle, GuildHelperFragment.class, h16.a());
                return;
            }
            QPublicFragmentActivity.start(context, new Intent(), GuildHelperFragment.class);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\n\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/guildhelper/GuildHelperFragment$b", "Lcom/tencent/biz/qui/quisecnavbar/b;", "", "b", "Landroid/view/View;", "view", "", "a", "", "getDrawable", "()I", "drawable", "d", "drawableInTransparent", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b implements com.tencent.biz.qui.quisecnavbar.b {
        b() {
        }

        @Override // com.tencent.biz.qui.quisecnavbar.b
        public void a(@Nullable View view) {
            if (view != null) {
                IGuildHelperApi iGuildHelperApi = (IGuildHelperApi) QRoute.api(IGuildHelperApi.class);
                Context context = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "view.context");
                iGuildHelperApi.openGuildMeFragment(context);
            }
        }

        @Override // com.tencent.biz.qui.quisecnavbar.b
        @NotNull
        public String b() {
            String qqStr = HardCodeUtil.qqStr(R.string.fr5);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(com.tencent.mobile\u2026.R.string.qq_search_more)");
            return qqStr;
        }

        @Override // com.tencent.biz.qui.quisecnavbar.b
        public boolean c() {
            return b.a.a(this);
        }

        @Override // com.tencent.biz.qui.quisecnavbar.b
        public int d() {
            return R.drawable.qui_chat_settings;
        }

        @Override // com.tencent.biz.qui.quisecnavbar.b
        public int getDrawable() {
            return R.drawable.qui_chat_settings;
        }
    }

    private final View createView() {
        View findViewById = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.evx);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewById(R.id.drag_area)");
        DragFrameLayout dragFrameLayout = (DragFrameLayout) findViewById;
        final RecyclerView chatsList = (RecyclerView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.tug);
        Intrinsics.checkNotNullExpressionValue(chatsList, "createView$lambda$3");
        Intrinsics.checkNotNullExpressionValue(OneShotPreDrawListener.add(chatsList, new Runnable() { // from class: com.tencent.mobileqq.guildhelper.GuildHelperFragment$createView$lambda$3$$inlined$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                Logger.f235387a.d().i("GuildHelperFragment", 1, "GuildHelper Performance pre draw");
            }
        }), "OneShotPreDrawListener.add(this) { action(this) }");
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar = this.mChatsVM;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar = null;
        }
        com.tencent.qqnt.chats.biz.guildhelper.a aVar2 = new com.tencent.qqnt.chats.biz.guildhelper.a(aVar, new com.tencent.qqnt.chats.biz.guildhelper.b());
        this.mChatsVB = aVar2;
        Intrinsics.checkNotNullExpressionValue(chatsList, "chatsList");
        View findViewById2 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.evx);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewById(R.id.drag_area)");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        aVar2.d0(new ChatsListVB.b(chatsList, (QUIBadgeDragLayout) findViewById2, null, requireContext, null, null, null, null, 240, null));
        com.tencent.qqnt.chats.biz.guildhelper.a aVar3 = this.mChatsVB;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
            aVar3 = null;
        }
        View view = new View(getContext());
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, 0));
        Unit unit = Unit.INSTANCE;
        aVar3.p0(-1, view);
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar4 = this.mChatsVM;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar4 = null;
        }
        com.tencent.qqnt.chats.biz.guildhelper.a aVar5 = this.mChatsVB;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
            aVar5 = null;
        }
        aVar4.d(aVar5);
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar6 = this.mChatsVM;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar6 = null;
        }
        aVar6.o(b.c.f355083a);
        return dragFrameLayout;
    }

    private final void initTitleBar() {
        setTitle(requireActivity().getString(R.string.f146560ui));
        this.quiSecNavBar.setBaseClickListener(BaseAction.ACTION_LEFT_BUTTON, new View.OnClickListener() { // from class: com.tencent.mobileqq.guildhelper.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildHelperFragment.rh(GuildHelperFragment.this, view);
            }
        });
        this.quiSecNavBar.d(this.mRightIcon);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rh(GuildHelperFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mIsSpiltView) {
            FragmentActivity activity = this$0.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        } else {
            this$0.onBackEvent();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initTitleBar();
        createView();
        super.doOnCreateView(inflater, container, savedInstanceState);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.e_6;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        FragmentManager supportFragmentManager;
        if (this.mIsSpiltView) {
            FragmentActivity activity = getActivity();
            if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
                supportFragmentManager.popBackStack();
                return true;
            }
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Logger.f235387a.d().i("GuildHelperFragment", 1, "GuildHelper Performance on create");
        ChatsColorCache.f355526a.r();
        super.onCreate(savedInstanceState);
        boolean z16 = false;
        requireActivity().getWindow().getDecorView().setBackgroundColor(0);
        IChatsViewModelCreator iChatsViewModelCreator = (IChatsViewModelCreator) QRoute.api(IChatsViewModelCreator.class);
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        this.mChatsVM = (com.tencent.qqnt.chats.core.mvi.a) iChatsViewModelCreator.createGuildViewModel(lifecycleScope, requireContext);
        Bundle arguments = getArguments();
        if (arguments != null) {
            z16 = arguments.getBoolean(TroopHelperFragment.KEY_IS_SPLIT_VIEW);
        }
        this.mIsSpiltView = z16;
        ((IGuildChannelLoadApi) QRoute.api(IGuildChannelLoadApi.class)).initChannelUpdateManager(MobileQQ.sMobileQQ.peekAppRuntime());
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        ChatsColorCache.f355526a.r();
        super.onDestroy();
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar = this.mChatsVM;
        com.tencent.qqnt.chats.biz.guildhelper.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar = null;
        }
        aVar.o(b.d.f355084a);
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar3 = this.mChatsVM;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar3 = null;
        }
        com.tencent.qqnt.chats.biz.guildhelper.a aVar4 = this.mChatsVB;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
        } else {
            aVar2 = aVar4;
        }
        aVar3.m(aVar2);
        ((IGuildChannelLoadApi) QRoute.api(IGuildChannelLoadApi.class)).notifyGuildHelperDestroy();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar = this.mChatsVM;
        com.tencent.qqnt.chats.biz.guildhelper.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar = null;
        }
        aVar.o(b.h.f355088a);
        com.tencent.qqnt.chats.biz.guildhelper.a aVar3 = this.mChatsVB;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
        } else {
            aVar2 = aVar3;
        }
        com.tencent.qqnt.chats.api.b v3 = aVar2.v();
        if (v3 != null) {
            RelativeLayout titleRoot = this.titleRoot;
            Intrinsics.checkNotNullExpressionValue(titleRoot, "titleRoot");
            v3.u(titleRoot);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        com.tencent.qqnt.chats.biz.guildhelper.a aVar = this.mChatsVB;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
            aVar = null;
        }
        aVar.b(a.i.f355014a);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar = this.mChatsVM;
        com.tencent.qqnt.chats.biz.guildhelper.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar = null;
        }
        aVar.o(b.i.f355089a);
        com.tencent.qqnt.chats.biz.guildhelper.a aVar3 = this.mChatsVB;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
        } else {
            aVar2 = aVar3;
        }
        com.tencent.qqnt.chats.api.b v3 = aVar2.v();
        if (v3 != null) {
            RelativeLayout titleRoot = this.titleRoot;
            Intrinsics.checkNotNullExpressionValue(titleRoot, "titleRoot");
            b.C9561b.a(v3, titleRoot, "", 1, null, 8, null);
        }
        DTReportThreadHelper.f354858a.a("GuildHelperFragment+report_em", new Function0<Unit>() { // from class: com.tencent.mobileqq.guildhelper.GuildHelperFragment$onResume$1
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
                GuildHelperFragment.b bVar;
                GuildHelperFragment guildHelperFragment = GuildHelperFragment.this;
                QUISecNavBar qUISecNavBar = guildHelperFragment.quiSecNavBar;
                bVar = guildHelperFragment.mRightIcon;
                View h16 = qUISecNavBar.h(bVar);
                if (h16 != null) {
                    VideoReport.setElementId(h16, "em_sgrp_more_action");
                    VideoReport.setElementClickPolicy(h16, ClickPolicy.REPORT_ALL);
                    VideoReport.setElementExposePolicy(h16, ExposurePolicy.REPORT_NONE);
                    VideoReport.reportEvent("imp", h16, null);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.pad.f
    public boolean qOnBackPressed() {
        return onBackEvent();
    }

    @Override // com.tencent.mobileqq.pad.d
    public boolean shouldDispatchActivityResult() {
        return false;
    }

    @Override // com.tencent.mobileqq.pad.d
    public boolean shouldDispatchPostThemeChanged() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        return true;
    }

    @Override // com.tencent.mobileqq.pad.f
    public void qOnNewIntent() {
    }
}
