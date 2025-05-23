package com.tencent.mobileqq.guild.discoveryv2.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.Page;
import com.tencent.cache.api.PageHierarchy;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.be;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.config.GuildAISearchConfBean;
import com.tencent.mobileqq.guild.discoveryv2.parts.AISearchPart;
import com.tencent.mobileqq.guild.discoveryv2.parts.PreloadFeedPart;
import com.tencent.mobileqq.guild.discoveryv2.parts.TabsPart;
import com.tencent.mobileqq.guild.discoveryv2.parts.k;
import com.tencent.mobileqq.guild.discoveryv2.parts.l;
import com.tencent.mobileqq.guild.discoveryv2.widget.GuildViewPagerContainer;
import com.tencent.mobileqq.guild.home.parts.GuildOnIdlePreloadPart;
import com.tencent.mobileqq.guild.mainframe.GuildFragmentDelegateFrame;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statustitle.AfterAccountChanged;
import com.tencent.mobileqq.statustitle.BeforeAccountChanged;
import com.tencent.mobileqq.statustitle.OnConfigurationChanged;
import com.tencent.mobileqq.statustitle.OnPostThemeChanged;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.u;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.argus.node.ArgusTag;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@ArgusTag(testConfigKey = "Argus_Guild", testTags = {"AUTO_PRELOAD"})
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 L2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001MB\u0007\u00a2\u0006\u0004\bJ\u0010KJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0014J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\u001a\u0010 \u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0014J\u001a\u0010!\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010\"\u001a\u00020\u0005H\u0016J\b\u0010#\u001a\u00020\u0005H\u0014J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u001aH\u0016J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&H\u0016J\b\u0010)\u001a\u00020\u0005H\u0016J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u001cH\u0016J\u0010\u0010,\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u001aH\u0016J*\u00101\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u001c2\u0018\u00100\u001a\u0014\u0012\u0004\u0012\u00020\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001a0.j\u0002`/H\u0016J\n\u00103\u001a\u0004\u0018\u000102H\u0016J\u0010\u00105\u001a\u00020\u001c2\u0006\u00104\u001a\u00020\u001cH\u0016R\u0014\u00108\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u001b\u0010>\u001a\u0002098BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u001b\u0010F\u001a\u00020B8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bC\u0010;\u001a\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010H\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/fragment/DiscoveryMultiTabFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/mobileqq/guild/discoveryv2/fragment/c;", "Lcom/tencent/mobileqq/webview/swift/u;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "", "Ah", "Landroid/view/View;", "contentView", "Bh", "Ljf1/a;", "xh", "Lcom/tencent/mobileqq/guild/discoveryv2/widget/GuildViewPagerContainer;", "viewPagerContainer", "Landroid/view/View$OnLayoutChangeListener;", "vh", "yh", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/content/Intent;", "intent", "onNewIntent", "", "account", "onAccountChanged", "", "getContentLayoutId", "", "onBackEvent", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedBeforePartInit", "onViewCreatedAfterPartInit", "onResume", "onFragmentViewDestroyed", "height", "setTabHeight", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "gg", "isSwitchAccount", "md", "onPostThemeChanged", "isGuildTabSelected", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/guild/discoveryv2/fragment/RefreshResult;", "refreshResult", "q6", "Lcom/tencent/mobileqq/webview/swift/WebViewFragment;", "getCurrentWebViewFragment", NodeProps.VISIBLE, "setBottomBarVisibility", BdhLogUtil.LogTag.Tag_Conn, "Ljf1/a;", "tabLayoutUpdateListener", "Lcom/tencent/mobileqq/guild/discoveryv2/parts/TabsPart;", "D", "Lkotlin/Lazy;", "uh", "()Lcom/tencent/mobileqq/guild/discoveryv2/parts/TabsPart;", "tabsPart", "E", "I", "bottomHeight", "Lcom/tencent/mobileqq/guild/config/GuildAISearchConfBean;", UserInfo.SEX_FEMALE, "th", "()Lcom/tencent/mobileqq/guild/config/GuildAISearchConfBean;", "aiSearchConfig", "G", "Ljava/lang/String;", "prevAccount", "<init>", "()V", "H", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
@Page(business = Business.Guild, type = PageHierarchy.MainPage)
/* loaded from: classes13.dex */
public final class DiscoveryMultiTabFragment extends QPublicBaseFragment implements c, u, com.tencent.mobileqq.guild.base.repository.a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final jf1.a tabLayoutUpdateListener = xh();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy tabsPart;

    /* renamed from: E, reason: from kotlin metadata */
    private int bottomHeight;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy aiSearchConfig;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String prevAccount;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.discoveryv2.fragment.DiscoveryMultiTabFragment$1", f = "DiscoveryMultiTabFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.discoveryv2.fragment.DiscoveryMultiTabFragment$1, reason: invalid class name */
    /* loaded from: classes13.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AccountChangedNotifier.f214789d.a(DiscoveryMultiTabFragment.this);
                Lifecycle lifecycle = DiscoveryMultiTabFragment.this.getLifecycle();
                final DiscoveryMultiTabFragment discoveryMultiTabFragment = DiscoveryMultiTabFragment.this;
                lifecycle.addObserver(new LifecycleEventObserver() { // from class: com.tencent.mobileqq.guild.discoveryv2.fragment.DiscoveryMultiTabFragment.1.1
                    @Override // androidx.lifecycle.LifecycleEventObserver
                    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
                        Intrinsics.checkNotNullParameter(source, "source");
                        Intrinsics.checkNotNullParameter(event, "event");
                        if (event == Lifecycle.Event.ON_DESTROY) {
                            AccountChangedNotifier.f214789d.d(DiscoveryMultiTabFragment.this);
                        }
                    }
                });
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public DiscoveryMultiTabFragment() {
        Lazy lazy;
        Lazy lazy2;
        String str;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TabsPart>() { // from class: com.tencent.mobileqq.guild.discoveryv2.fragment.DiscoveryMultiTabFragment$tabsPart$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TabsPart invoke() {
                GuildAISearchConfBean th5;
                TabsPart tabsPart = new TabsPart();
                th5 = DiscoveryMultiTabFragment.this.th();
                tabsPart.ga(th5);
                return tabsPart;
            }
        });
        this.tabsPart = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<GuildAISearchConfBean>() { // from class: com.tencent.mobileqq.guild.discoveryv2.fragment.DiscoveryMultiTabFragment$aiSearchConfig$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildAISearchConfBean invoke() {
                GuildAISearchConfBean a16 = GuildAISearchConfBean.INSTANCE.a();
                Logger.f235387a.d().i("DiscoveryMultiTabFragment", 1, "aiSearch: " + a16.r());
                return a16;
            }
        });
        this.aiSearchConfig = lazy2;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        this.prevAccount = str == null ? "" : str;
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenCreated(new AnonymousClass1(null));
    }

    private final void Ah() {
        View view;
        ViewGroup.LayoutParams layoutParams;
        boolean z16;
        View fragmentContentView = getFragmentContentView();
        if (fragmentContentView != null) {
            view = fragmentContentView.findViewById(R.id.adk);
        } else {
            view = null;
        }
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        int i3 = 0;
        if (this.bottomHeight != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            i3 = 8;
        }
        view.setVisibility(i3);
        view.setAlpha(0.7f);
        view.getLayoutParams().height = this.bottomHeight;
        view.setLayoutParams(layoutParams);
    }

    private final void Bh(View contentView) {
        Activity activity;
        Context context = contentView.getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null) {
            VideoReport.addToDetectionWhitelist(activity);
        }
        VideoReport.setPageId(contentView, "pg_sgrp_discover_frame");
        VideoReport.setPageLinkEnable(contentView, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuildAISearchConfBean th() {
        return (GuildAISearchConfBean) this.aiSearchConfig.getValue();
    }

    private final TabsPart uh() {
        return (TabsPart) this.tabsPart.getValue();
    }

    private final View.OnLayoutChangeListener vh(final GuildViewPagerContainer viewPagerContainer) {
        return new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.fragment.a
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                DiscoveryMultiTabFragment.wh(GuildViewPagerContainer.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wh(GuildViewPagerContainer viewPagerContainer, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        boolean z16;
        Intrinsics.checkNotNullParameter(viewPagerContainer, "$viewPagerContainer");
        int i29 = i18 - i16;
        int i36 = i28 - i26;
        if (i29 != i36) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Logger.f235387a.d().i("DiscoveryMultiTabFragment", 1, "scrollView onLayoutChange height = " + i36 + " -> " + i29);
            ViewGroup.LayoutParams layoutParams = viewPagerContainer.getLayoutParams();
            layoutParams.height = i29 - ((int) cw.b(48));
            viewPagerContainer.setLayoutParams(layoutParams);
        }
    }

    private final jf1.a xh() {
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        return new jf1.a(new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.fragment.DiscoveryMultiTabFragment$newTabLayoutUpdateListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                int height = it.getHeight() - ((int) it.getTranslationY());
                Ref.IntRef intRef2 = Ref.IntRef.this;
                if (intRef2.element != height) {
                    intRef2.element = height;
                    this.setTabHeight(height);
                }
            }
        });
    }

    private final void yh() {
        final com.tencent.mobileqq.guild.mainframe.u uVar;
        be a16 = GuildFragmentDelegateFrame.INSTANCE.a(getContext());
        if (a16 instanceof com.tencent.mobileqq.guild.mainframe.u) {
            uVar = (com.tencent.mobileqq.guild.mainframe.u) a16;
        } else {
            uVar = null;
        }
        if (uVar != null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.fragment.b
                @Override // java.lang.Runnable
                public final void run() {
                    DiscoveryMultiTabFragment.zh(com.tencent.mobileqq.guild.mainframe.u.this);
                }
            });
            return;
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        bVar.a().add("Failed to restore main frame! frame is null!");
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("DiscoveryMultiTabFragment", 1, (String) it.next(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zh(com.tencent.mobileqq.guild.mainframe.u uVar) {
        uVar.restoreGuildTabFragment();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> listOfNotNull;
        Part[] partArr = new Part[7];
        partArr[0] = new k();
        AISearchPart aISearchPart = new AISearchPart();
        if (!th().r()) {
            aISearchPart = null;
        }
        partArr[1] = aISearchPart;
        partArr[2] = uh();
        partArr[3] = new com.tencent.mobileqq.guild.discoveryv2.parts.e();
        partArr[4] = l.INSTANCE.a();
        partArr[5] = new PreloadFeedPart();
        partArr[6] = new GuildOnIdlePreloadPart();
        listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) partArr);
        return listOfNotNull;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        if (th().r()) {
            return R.layout.el5;
        }
        return R.layout.el6;
    }

    @Override // com.tencent.mobileqq.webview.swift.u
    @Nullable
    public WebViewFragment getCurrentWebViewFragment() {
        return uh().T9();
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.c
    public void gg() {
        SimpleEventBus.getInstance().dispatchEvent(new BeforeAccountChanged(QPublicBaseFragment.TAG));
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.c
    public void md(boolean isSwitchAccount) {
        SimpleEventBus.getInstance().dispatchEvent(new AfterAccountChanged(QPublicBaseFragment.TAG, isSwitchAccount));
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        Logger logger = Logger.f235387a;
        logger.d().i("DiscoveryMultiTabFragment", 1, "onAccountChanged account=" + this.prevAccount + " -> " + account);
        if (!Intrinsics.areEqual(account, this.prevAccount)) {
            if (th().r() != GuildAISearchConfBean.INSTANCE.a().r()) {
                logger.d().i("DiscoveryMultiTabFragment", 1, "aiSearchConfig changed, reload fragment");
                yh();
            }
            this.prevAccount = account;
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "childFragmentManager.fragments");
        for (Fragment fragment : fragments) {
            if (fragment instanceof QPublicBaseFragment) {
                QPublicBaseFragment qPublicBaseFragment = (QPublicBaseFragment) fragment;
                if (qPublicBaseFragment.isResumed() && qPublicBaseFragment.onBackEvent()) {
                    return true;
                }
            }
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        SimpleEventBus.getInstance().dispatchEvent(new OnConfigurationChanged(newConfig));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onFragmentViewDestroyed() {
        super.onFragmentViewDestroyed();
        this.tabLayoutUpdateListener.b();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        getPartManager().onNewIntent(intent);
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.c
    public void onPostThemeChanged(int height) {
        Logger.f235387a.d().i("DiscoveryMultiTabFragment", 1, "onPostThemeChanged");
        SimpleEventBus.getInstance().dispatchEvent(new OnPostThemeChanged());
        com.tencent.mobileqq.guild.theme.c.a(getFragmentContentView());
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.tencent.mobileqq.guild.report.b.i("pg_sgrp_discover_scene", "TabMisc");
        VideoReport.setPageParams(requireView(), new PageParams(com.tencent.mobileqq.guild.report.b.d()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NotNull View contentView, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        Logger.f235387a.d().i("DiscoveryMultiTabFragment", 1, "onViewCreatedAfterPartInit");
        super.onViewCreatedAfterPartInit(contentView, savedInstanceState);
        uh1.a.f438959a.d("viewPage AfterPartInit");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(@NotNull View contentView, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        uh1.a.f438959a.d("viewPage BeforePartInit");
        Bh(contentView);
        Logger.f235387a.d().i("DiscoveryMultiTabFragment", 1, "onViewCreatedBeforePartInit");
        super.onViewCreatedBeforePartInit(contentView, savedInstanceState);
        Ah();
        View obtainTabWidget = ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).obtainTabWidget(getQBaseActivity());
        jf1.a aVar = this.tabLayoutUpdateListener;
        Intrinsics.checkNotNullExpressionValue(obtainTabWidget, "obtainTabWidget");
        aVar.a(obtainTabWidget);
        if (th().r()) {
            View findViewById = contentView.findViewById(R.id.x4v);
            Intrinsics.checkNotNullExpressionValue(findViewById, "contentView.findViewById\u2026uild_viewpager_container)");
            ((NestedScrollView) contentView.findViewById(R.id.w7_)).addOnLayoutChangeListener(vh((GuildViewPagerContainer) findViewById));
        }
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.c
    public void q6(boolean isGuildTabSelected, @NotNull Pair<Boolean, Integer> refreshResult) {
        Intrinsics.checkNotNullParameter(refreshResult, "refreshResult");
        Logger.f235387a.d().i("DiscoveryMultiTabFragment", 1, "onGuildTabClick isGuildTabSelected=" + isGuildTabSelected + ", " + refreshResult);
        uh().ea(isGuildTabSelected, refreshResult);
    }

    @Override // com.tencent.mobileqq.webview.swift.u
    public boolean setBottomBarVisibility(boolean visible) {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.c
    public void setTabHeight(int height) {
        Logger.f235387a.d().i("DiscoveryMultiTabFragment", 1, "setTabHeight height=" + height);
        if (this.bottomHeight == height) {
            return;
        }
        this.bottomHeight = height;
        Ah();
        uh().ia(height);
    }
}
