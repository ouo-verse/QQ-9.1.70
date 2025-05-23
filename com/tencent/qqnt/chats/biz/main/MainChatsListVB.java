package com.tencent.qqnt.chats.biz.main;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qqnt.widget.smartrefreshlayout.layout.constant.RefreshState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.util.d;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.view.LIAAnimView;
import com.tencent.qqnt.chats.api.IChatsUtil;
import com.tencent.qqnt.chats.biz.guild.GuildLayoutManager;
import com.tencent.qqnt.chats.biz.guildhelper.GuildFolderGuideHelper;
import com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemBinding;
import com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemHolder;
import com.tencent.qqnt.chats.core.anim.ChatListGuildItemAnimator;
import com.tencent.qqnt.chats.core.bizEvent.ChatBizEventManager;
import com.tencent.qqnt.chats.core.ui.ChatsListVB;
import com.tencent.qqnt.chats.core.ui.listener.c;
import com.tencent.qqnt.chats.core.ui.o;
import com.tencent.qqnt.chats.core.ui.third.e;
import com.tencent.qqnt.chats.core.ui.third.p013const.ThirdViewEnum;
import com.tencent.qqnt.chats.core.uievent.a;
import com.tencent.qqnt.chats.core.uistate.a;
import com.tencent.qqnt.chats.main.api.IMainChatEarManager;
import com.tencent.qqnt.chats.view.RollingTextView;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q3.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u00012\u00020\u0002:\u0001-B#\u0012\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%\u0012\u0006\u0010*\u001a\u00020)\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u000e\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\u0012R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001b\u0010 \u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006."}, d2 = {"Lcom/tencent/qqnt/chats/biz/main/MainChatsListVB;", "Lcom/tencent/qqnt/chats/core/ui/ChatsListVB;", "", "", "F0", "E0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/qqnt/chats/core/ui/ChatsListVB$b;", "params", "d0", "e0", "Lcom/tencent/qqnt/chats/core/uievent/b;", "uiEvent", "b", "Lcom/tencent/qqnt/chats/core/uistate/a$b;", "uiState", "r", "", "W", ViewStickEventHelper.IS_SHOW, "C0", "G0", "Landroidx/constraintlayout/widget/ConstraintLayout;", "a0", "Landroidx/constraintlayout/widget/ConstraintLayout;", "thirdContainerView", "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;", "b0", "Lkotlin/Lazy;", "D0", "()Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;", "guildItemAnimator", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/view/LIAAnimView;", "c0", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/view/LIAAnimView;", "lightInterActionView", "Lcom/tencent/qqnt/chats/core/mvi/a;", "Lcom/tencent/qqnt/chats/core/uistate/b;", "Lcom/tencent/qqnt/chats/core/userintent/b;", "mViewModel", "Lcom/tencent/qqnt/chats/core/data/a;", "mBuilder", "<init>", "(Lcom/tencent/qqnt/chats/core/mvi/a;Lcom/tencent/qqnt/chats/core/data/a;)V", "a", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class MainChatsListVB extends ChatsListVB {
    static IPatchRedirector $redirector_;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ConstraintLayout thirdContainerView;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy guildItemAnimator;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LIAAnimView lightInterActionView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/biz/main/MainChatsListVB$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.biz.main.MainChatsListVB$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/chats/biz/main/MainChatsListVB$b", "Lcom/tencent/qqnt/chats/core/ui/listener/c;", "Lq3/f;", "refreshLayout", "Lcom/qqnt/widget/smartrefreshlayout/layout/constant/RefreshState;", "oldState", "newState", "", "d", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b extends c {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes24.dex */
        public /* synthetic */ class a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f354321a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35161);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 1)) {
                    redirector.redirect((short) 1);
                    return;
                }
                int[] iArr = new int[RefreshState.values().length];
                try {
                    iArr[RefreshState.TwoLevel.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[RefreshState.None.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f354321a = iArr;
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainChatsListVB.this);
            }
        }

        @Override // r3.i
        public void d(@NotNull f refreshLayout, @NotNull RefreshState oldState, @NotNull RefreshState newState) {
            e G;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, refreshLayout, oldState, newState);
                return;
            }
            Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
            Intrinsics.checkNotNullParameter(oldState, "oldState");
            Intrinsics.checkNotNullParameter(newState, "newState");
            int i3 = a.f354321a[newState.ordinal()];
            if (i3 == 1) {
                e G2 = MainChatsListVB.this.G();
                if (G2 != null) {
                    G2.x(false);
                    return;
                }
                return;
            }
            if (i3 == 2 && (G = MainChatsListVB.this.G()) != null) {
                G.x(true);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37509);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainChatsListVB(@NotNull com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> mViewModel, @NotNull com.tencent.qqnt.chats.core.data.a mBuilder) {
        super(mViewModel, mBuilder);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mViewModel, "mViewModel");
        Intrinsics.checkNotNullParameter(mBuilder, "mBuilder");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<ChatListGuildItemAnimator>() { // from class: com.tencent.qqnt.chats.biz.main.MainChatsListVB$guildItemAnimator$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final ChatListGuildItemAnimator invoke() {
                    return new ChatListGuildItemAnimator();
                }
            });
            this.guildItemAnimator = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mViewModel, (Object) mBuilder);
        }
    }

    private final RecyclerView.ItemAnimator D0() {
        return (RecyclerView.ItemAnimator) this.guildItemAnimator.getValue();
    }

    private final void E0() {
        GuildFolderGuideHelper.f354289a.k(C());
    }

    private final void F0() {
        final WeakReference weakReference = new WeakReference(G());
        final IMainChatEarManager iMainChatEarManager = (IMainChatEarManager) QRoute.api(IMainChatEarManager.class);
        iMainChatEarManager.setOnLittleEarChangeCallback(new Function1<List<? extends RecentContactInfo>, Unit>(weakReference, iMainChatEarManager) { // from class: com.tencent.qqnt.chats.biz.main.MainChatsListVB$initLittleEar$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ WeakReference<e> $thirdContainerRef;
            final /* synthetic */ IMainChatEarManager $this_apply;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$thirdContainerRef = weakReference;
                this.$this_apply = iMainChatEarManager;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) weakReference, (Object) iMainChatEarManager);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends RecentContactInfo> list) {
                invoke2((List<RecentContactInfo>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable List<RecentContactInfo> list) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    d.c(new Function0<Unit>(this.$thirdContainerRef, list, this.$this_apply) { // from class: com.tencent.qqnt.chats.biz.main.MainChatsListVB$initLittleEar$1$1.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ List<RecentContactInfo> $it;
                        final /* synthetic */ WeakReference<e> $thirdContainerRef;
                        final /* synthetic */ IMainChatEarManager $this_apply;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$thirdContainerRef = r8;
                            this.$it = list;
                            this.$this_apply = r10;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, r8, list, r10);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            e eVar = this.$thirdContainerRef.get();
                            if (eVar != null) {
                                List<RecentContactInfo> list2 = this.$it;
                                IMainChatEarManager iMainChatEarManager2 = this.$this_apply;
                                List<RecentContactInfo> list3 = list2;
                                if (list3 == null || list3.isEmpty()) {
                                    eVar.u(ThirdViewEnum.LITTLE_EAR);
                                } else {
                                    eVar.e(iMainChatEarManager2.buildLittleParam());
                                }
                            }
                        }
                    });
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                }
            }
        });
        ((IMainChatEarManager) QRoute.api(IMainChatEarManager.class)).fetchEarChatList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List H0(MainChatsListVB this$0) {
        RecentContactItemHolder recentContactItemHolder;
        RecentContactItemBinding y16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ArrayList arrayList = new ArrayList();
        RecyclerView.LayoutManager layoutManager = this$0.D().getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        int findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
        int findLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
        if (findFirstCompletelyVisibleItemPosition != -1 && findLastCompletelyVisibleItemPosition != -1 && findFirstCompletelyVisibleItemPosition <= findLastCompletelyVisibleItemPosition) {
            while (true) {
                RecyclerView.ViewHolder findViewHolderForAdapterPosition = this$0.D().findViewHolderForAdapterPosition(findFirstCompletelyVisibleItemPosition);
                RollingTextView rollingTextView = null;
                if (findViewHolderForAdapterPosition instanceof RecentContactItemHolder) {
                    recentContactItemHolder = (RecentContactItemHolder) findViewHolderForAdapterPosition;
                } else {
                    recentContactItemHolder = null;
                }
                if (recentContactItemHolder != null && (y16 = recentContactItemHolder.y()) != null) {
                    rollingTextView = y16.o();
                }
                if (rollingTextView != null && rollingTextView.isShown() && rollingTextView.getDragType() != -1) {
                    arrayList.add(rollingTextView);
                }
                if (findFirstCompletelyVisibleItemPosition == findLastCompletelyVisibleItemPosition) {
                    break;
                }
                findFirstCompletelyVisibleItemPosition++;
            }
        }
        return arrayList;
    }

    public final void C0(boolean isShow) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, isShow);
            return;
        }
        e G = G();
        if (G != null) {
            G.g(isShow);
        }
    }

    public final boolean G0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        o H = H();
        if (H == null || !H.b()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.chats.core.ui.ChatsListVB
    public boolean W() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return !GuildLayoutManager.f354256a.r();
    }

    @Override // com.tencent.qqnt.chats.core.ui.ChatsListVB, com.tencent.qqnt.chats.core.mvi.BaseFakeVB
    public void b(@NotNull com.tencent.qqnt.chats.core.uievent.b uiEvent) {
        com.tencent.qqnt.chats.core.uievent.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) uiEvent);
            return;
        }
        Intrinsics.checkNotNullParameter(uiEvent, "uiEvent");
        if (uiEvent instanceof a.p) {
            if (((IChatsUtil) QRoute.api(IChatsUtil.class)).getUnreadCountByListType(1) > 0) {
                bVar = a.n.f355021a;
            } else {
                bVar = a.o.f355022a;
            }
            super.b(bVar);
            return;
        }
        if (uiEvent instanceof a.f) {
            QLog.i(z(), 1, "EnableListAnim for MainChatsListVB");
            if (GuildLayoutManager.f354256a.y()) {
                super.b(new a.j(D0()));
                return;
            } else {
                super.b(uiEvent);
                return;
            }
        }
        if (uiEvent instanceof a.u) {
            com.tencent.qqnt.chats.biz.main.helper.a.f354330a.c((a.u) uiEvent, this.lightInterActionView);
        } else if (uiEvent instanceof a.t) {
            GuildFolderGuideHelper.u(GuildFolderGuideHelper.f354289a, null, 1, null);
        } else {
            super.b(uiEvent);
        }
    }

    @Override // com.tencent.qqnt.chats.core.ui.ChatsListVB
    public void d0(@NotNull ChatsListVB.b params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        this.thirdContainerView = params.h();
        super.d0(new ChatsListVB.b(params.a(), params.c(), params.h(), params.b(), params.g(), params.f(), params.e(), params.d()));
        this.lightInterActionView = params.e();
        f f16 = params.f();
        if (f16 != null) {
            f16.c(new b());
        }
        params.c().addDragViewProviderByGroup(C().getString(R.string.c76), new QUIBadgeDragLayout.IDragViewProvider() { // from class: com.tencent.qqnt.chats.biz.main.b
            @Override // com.tencent.mobileqq.quibadge.QUIBadgeDragLayout.IDragViewProvider
            public final List onGetVisibleDragView() {
                List H0;
                H0 = MainChatsListVB.H0(MainChatsListVB.this);
                return H0;
            }
        }, true);
        F0();
        E0();
        RecyclerView.LayoutManager layoutManager = params.a().getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        ((LinearLayoutManager) layoutManager).setInitialPrefetchItemCount(10);
    }

    @Override // com.tencent.qqnt.chats.core.ui.ChatsListVB
    public void e0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.e0();
        LIAAnimView lIAAnimView = this.lightInterActionView;
        if (lIAAnimView != null) {
            lIAAnimView.k();
        }
        ChatBizEventManager.INSTANCE.a().f();
        ((IMainChatEarManager) QRoute.api(IMainChatEarManager.class)).setNextCallback(null);
        ((IMainChatEarManager) QRoute.api(IMainChatEarManager.class)).setOnLittleEarChangeCallback(null);
        ((IChatsUtil) QRoute.api(IChatsUtil.class)).resetChatsNtFilter();
    }

    @Override // com.tencent.qqnt.chats.core.ui.ChatsListVB
    public void r(@NotNull a.b uiState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) uiState);
        } else {
            Intrinsics.checkNotNullParameter(uiState, "uiState");
            GuildFolderGuideHelper.f354289a.d(uiState);
        }
    }

    @Override // com.tencent.qqnt.chats.core.ui.ChatsListVB
    @NotNull
    public String z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "MainChatsListVB";
    }
}
