package com.tencent.qqnt.aio.assistedchat.panel.subpanel;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.assistedchat.panel.extend.PanelExtendRecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010H\u001a\u00020G\u00a2\u0006\u0004\bI\u0010JJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0004J\u0010\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\fJ\u0016\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fJ(\u0010\u0015\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u000f\u001a\u00020\f2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016R*\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR*\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR0\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010%\u001a\u0004\b \u0010&\"\u0004\b'\u0010(RF\u0010.\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u0004\u0018\u00010$2\u0014\u0010+\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u0004\u0018\u00010$8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010%\u001a\u0004\b,\u0010&\"\u0004\b-\u0010(R*\u0010\u0017\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u00168\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0018\u00106\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u00105R\"\u0010>\u001a\u0002078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010E\u00a8\u0006K"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/AssistedChatSubPanelView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/a;", "emptyData", "", "j", "l", "c", "Landroid/view/View;", "bottomBar", "b", tl.h.F, "", "forceLoading", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isRefresh", "hasMore", "d", "", "Lcom/tencent/qqnt/aio/assistedchat/model/c;", "recommendList", "setData", "", "subPanelId", "k", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "getRefreshListener", "()Lkotlin/jvm/functions/Function0;", "setRefreshListener", "(Lkotlin/jvm/functions/Function0;)V", "refreshListener", "e", "f", "setLoadMoreListener", "loadMoreListener", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "setItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "itemClickListener", "", "value", "getGuideClickListener", "setGuideClickListener", "guideClickListener", "i", "I", "getSubPanelId", "()I", "setSubPanelId", "(I)V", "Landroid/view/View;", "bottomLayout", "Lcom/tencent/qqnt/aio/assistedchat/panel/extend/PanelExtendRecyclerView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/aio/assistedchat/panel/extend/PanelExtendRecyclerView;", "g", "()Lcom/tencent/qqnt/aio/assistedchat/panel/extend/PanelExtendRecyclerView;", "setRecyclerView", "(Lcom/tencent/qqnt/aio/assistedchat/panel/extend/PanelExtendRecyclerView;)V", "recyclerView", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/AssistedChatSubPanelAdapter;", "D", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/AssistedChatSubPanelAdapter;", "panelAdapter", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/b;", "E", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/b;", "loadMoreAdapter", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AssistedChatSubPanelView extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private PanelExtendRecyclerView recyclerView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final AssistedChatSubPanelAdapter panelAdapter;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final b loadMoreAdapter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function0<Unit> refreshListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function0<Unit> loadMoreListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super com.tencent.qqnt.aio.assistedchat.model.c, Unit> itemClickListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super CharSequence, Unit> guideClickListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int subPanelId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View bottomLayout;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/aio/assistedchat/panel/subpanel/AssistedChatSubPanelView$a", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "", "onLoadMoreStart", "", "p0", "onLoadMoreEnd", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a implements ILoadMoreProvider$LoadMoreListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssistedChatSubPanelView.this);
            }
        }

        @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
        public void onLoadMoreEnd(boolean p06) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, p06);
            }
        }

        @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
        public void onLoadMoreStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Function0<Unit> f16 = AssistedChatSubPanelView.this.f();
            if (f16 != null) {
                f16.invoke();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssistedChatSubPanelView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.subPanelId = 1;
        PanelExtendRecyclerView panelExtendRecyclerView = new PanelExtendRecyclerView(context, null, 0, 6, null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        panelExtendRecyclerView.setLayoutParams(layoutParams);
        panelExtendRecyclerView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        panelExtendRecyclerView.setItemAnimator(null);
        this.recyclerView = panelExtendRecyclerView;
        AssistedChatSubPanelAdapter assistedChatSubPanelAdapter = new AssistedChatSubPanelAdapter();
        this.panelAdapter = assistedChatSubPanelAdapter;
        b bVar = new b();
        this.loadMoreAdapter = bVar;
        setOrientation(1);
        PanelExtendRecyclerView panelExtendRecyclerView2 = this.recyclerView;
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        assistedChatSubPanelAdapter.setHasStableIds(true);
        Unit unit = Unit.INSTANCE;
        bVar.setHasStableIds(true);
        panelExtendRecyclerView2.setAdapter(new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{assistedChatSubPanelAdapter, bVar}));
        addView(panelExtendRecyclerView2);
        bVar.registerLoadMoreListener(new a());
        assistedChatSubPanelAdapter.p0(new Function1<com.tencent.qqnt.aio.assistedchat.model.c, Unit>() { // from class: com.tencent.qqnt.aio.assistedchat.panel.subpanel.AssistedChatSubPanelView.3
            static IPatchRedirector $redirector_;

            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AssistedChatSubPanelView.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.aio.assistedchat.model.c cVar) {
                invoke2(cVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.qqnt.aio.assistedchat.model.c it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                Function1<com.tencent.qqnt.aio.assistedchat.model.c, Unit> e16 = AssistedChatSubPanelView.this.e();
                if (e16 != null) {
                    e16.invoke(it);
                }
            }
        });
        assistedChatSubPanelAdapter.q0(new Function0<Unit>() { // from class: com.tencent.qqnt.aio.assistedchat.panel.subpanel.AssistedChatSubPanelView.4
            static IPatchRedirector $redirector_;

            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AssistedChatSubPanelView.this);
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
                } else if (AppNetConnInfo.isNetSupport()) {
                    AssistedChatSubPanelView.this.m(true);
                }
            }
        });
    }

    private final void c() {
        b bVar = this.loadMoreAdapter;
        bVar.j0(false);
        bVar.setLoadState(false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(boolean z16, AssistedChatSubPanelView this$0) {
        RecyclerView.LayoutManager layoutManager;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16 && (layoutManager = this$0.recyclerView.getLayoutManager()) != null) {
            layoutManager.scrollToPosition(0);
        }
    }

    private final void j(com.tencent.qqnt.aio.assistedchat.panel.subpanel.a emptyData) {
        View view = this.bottomLayout;
        if (view != null) {
            view.setVisibility(8);
        }
        c();
        this.panelAdapter.s0(emptyData);
    }

    private final void l() {
        c();
        this.panelAdapter.v0();
    }

    public static /* synthetic */ void n(AssistedChatSubPanelView assistedChatSubPanelView, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        assistedChatSubPanelView.m(z16);
    }

    public static /* synthetic */ void setData$default(AssistedChatSubPanelView assistedChatSubPanelView, List list, boolean z16, com.tencent.qqnt.aio.assistedchat.panel.subpanel.a aVar, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            aVar = null;
        }
        assistedChatSubPanelView.setData(list, z16, aVar);
    }

    public final void b(@NotNull View bottomBar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) bottomBar);
            return;
        }
        Intrinsics.checkNotNullParameter(bottomBar, "bottomBar");
        h();
        addView(bottomBar);
        this.bottomLayout = bottomBar;
    }

    public final void d(boolean isRefresh, boolean hasMore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Boolean.valueOf(isRefresh), Boolean.valueOf(hasMore));
        } else {
            this.loadMoreAdapter.setLoadState(false, hasMore);
            this.loadMoreAdapter.setMaxAutoLoadMoreTimes(2);
        }
    }

    @Nullable
    public final Function1<com.tencent.qqnt.aio.assistedchat.model.c, Unit> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Function1) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.itemClickListener;
    }

    @Nullable
    public final Function0<Unit> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Function0) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.loadMoreListener;
    }

    @NotNull
    public final PanelExtendRecyclerView g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (PanelExtendRecyclerView) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.recyclerView;
    }

    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        View view = this.bottomLayout;
        if (view != null) {
            removeView(view);
            this.bottomLayout = null;
        }
    }

    public final void k(int subPanelId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, subPanelId);
            return;
        }
        View view = this.bottomLayout;
        if (view != null) {
            view.setVisibility(8);
        }
        c();
        this.panelAdapter.t0(subPanelId);
    }

    public final void m(boolean forceLoading) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, forceLoading);
            return;
        }
        if ((forceLoading || this.panelAdapter.m0()) && !this.panelAdapter.n0()) {
            l();
        }
        this.loadMoreAdapter.resetAutoLoadMoreTimes();
        Function0<Unit> function0 = this.refreshListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void setData(@NotNull List<com.tencent.qqnt.aio.assistedchat.model.c> recommendList, final boolean isRefresh, @Nullable com.tencent.qqnt.aio.assistedchat.panel.subpanel.a emptyData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, recommendList, Boolean.valueOf(isRefresh), emptyData);
            return;
        }
        Intrinsics.checkNotNullParameter(recommendList, "recommendList");
        if (recommendList.isEmpty()) {
            j(emptyData);
            return;
        }
        View view = this.bottomLayout;
        if (view != null) {
            view.setVisibility(0);
        }
        this.loadMoreAdapter.j0(!recommendList.isEmpty());
        this.panelAdapter.u0(recommendList, new Runnable() { // from class: com.tencent.qqnt.aio.assistedchat.panel.subpanel.m
            @Override // java.lang.Runnable
            public final void run() {
                AssistedChatSubPanelView.i(isRefresh, this);
            }
        });
    }

    public final void setGuideClickListener(@Nullable Function1<? super CharSequence, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) function1);
        } else {
            this.guideClickListener = function1;
            this.panelAdapter.o0(function1);
        }
    }

    public final void setItemClickListener(@Nullable Function1<? super com.tencent.qqnt.aio.assistedchat.model.c, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) function1);
        } else {
            this.itemClickListener = function1;
        }
    }

    public final void setLoadMoreListener(@Nullable Function0<Unit> function0) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) function0);
        } else {
            this.loadMoreListener = function0;
        }
    }

    public final void setRecyclerView(@NotNull PanelExtendRecyclerView panelExtendRecyclerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) panelExtendRecyclerView);
        } else {
            Intrinsics.checkNotNullParameter(panelExtendRecyclerView, "<set-?>");
            this.recyclerView = panelExtendRecyclerView;
        }
    }

    public final void setRefreshListener(@Nullable Function0<Unit> function0) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) function0);
        } else {
            this.refreshListener = function0;
        }
    }

    public final void setSubPanelId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.subPanelId = i3;
            this.panelAdapter.r0(Integer.valueOf(i3));
        }
    }
}
