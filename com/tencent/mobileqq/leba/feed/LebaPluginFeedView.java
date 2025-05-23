package com.tencent.mobileqq.leba.feed;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.leba.business.LebaPluginProxy;
import com.tencent.mobileqq.leba.core.BasePluginDataManager;
import com.tencent.mobileqq.leba.entity.n;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001*\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00017B\u0011\b\u0016\u0012\u0006\u0010.\u001a\u00020-\u00a2\u0006\u0004\b/\u00100B\u0019\b\u0016\u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u00102\u001a\u000201\u00a2\u0006\u0004\b/\u00103B!\b\u0016\u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u00104\u001a\u00020\u0017\u00a2\u0006\u0004\b/\u00105J(\u0010\b\u001a\u00020\u00072\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0017J\b\u0010\t\u001a\u00020\u0007H\u0014J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u0007J\u0006\u0010\u0012\u001a\u00020\u0007J\u0006\u0010\u0013\u001a\u00020\u0007J\b\u0010\u0014\u001a\u00020\u0007H\u0014J\u0018\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0014R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001fR\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010%R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010(R\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010+\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/leba/feed/LebaPluginFeedView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mobileqq/leba/core/BasePluginDataManager$d;", "", "Lcom/tencent/mobileqq/leba/entity/n;", "pluginDataList", "morePluginDataList", "", "Ef", NodeProps.ON_ATTACHED_TO_WINDOW, "f", "k", "g", "i", "", "tabChange", "l", tl.h.F, "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, NodeProps.ON_DETACHED_FROM_WINDOW, "Landroid/view/View;", "changedView", "", "visibility", "onVisibilityChanged", "Landroid/support/v7/widget/RecyclerView;", "d", "Landroid/support/v7/widget/RecyclerView;", "pluginRecycleView", "Landroid/support/v7/widget/GridLayoutManager;", "Landroid/support/v7/widget/GridLayoutManager;", "pluginLayoutManager", "Lcom/tencent/mobileqq/leba/business/LebaPluginProxy;", "Lcom/tencent/mobileqq/leba/business/LebaPluginProxy;", "lebaPluginProxy", "Lcom/tencent/mobileqq/leba/feed/LebaPluginFeedAdapter;", "Lcom/tencent/mobileqq/leba/feed/LebaPluginFeedAdapter;", "pluginListAdapter", "Lcom/tencent/mobileqq/leba/core/BasePluginDataManager;", "Lcom/tencent/mobileqq/leba/core/BasePluginDataManager;", "basePluginDataManager", "com/tencent/mobileqq/leba/feed/LebaPluginFeedView$controller$1", "Lcom/tencent/mobileqq/leba/feed/LebaPluginFeedView$controller$1;", "controller", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BdhLogUtil.LogTag.Tag_Conn, "b", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LebaPluginFeedView extends RelativeLayout implements BasePluginDataManager.d {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView pluginRecycleView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GridLayoutManager pluginLayoutManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LebaPluginProxy lebaPluginProxy;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LebaPluginFeedAdapter pluginListAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BasePluginDataManager basePluginDataManager;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LebaPluginFeedView$controller$1 controller;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/leba/feed/LebaPluginFeedView$a", "Landroid/support/v7/widget/GridLayoutManager;", "Landroid/support/v7/widget/RecyclerView$LayoutParams;", "lp", "", "checkLayoutParams", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a extends GridLayoutManager {
        static IPatchRedirector $redirector_;

        a(Context context) {
            super(context, 5);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
        }

        @Override // android.support.v7.widget.GridLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
        public boolean checkLayoutParams(@NotNull RecyclerView.LayoutParams lp5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) lp5)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(lp5, "lp");
            ((ViewGroup.MarginLayoutParams) lp5).width = getWidth() / getSpanCount();
            return true;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/leba/feed/LebaPluginFeedView$b;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.leba.feed.LebaPluginFeedView$b, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18223);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.tencent.mobileqq.leba.feed.LebaPluginFeedView$controller$1] */
    public LebaPluginFeedView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        LebaPluginProxy lebaPluginProxy = new LebaPluginProxy();
        this.lebaPluginProxy = lebaPluginProxy;
        LebaPluginFeedAdapter lebaPluginFeedAdapter = new LebaPluginFeedAdapter(lebaPluginProxy);
        this.pluginListAdapter = lebaPluginFeedAdapter;
        this.basePluginDataManager = com.tencent.mobileqq.leba.core.b.b(2);
        this.controller = new com.tencent.mobileqq.leba.widget.a() { // from class: com.tencent.mobileqq.leba.feed.LebaPluginFeedView$controller$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LebaPluginFeedView.this);
                }
            }

            @Override // com.tencent.mobileqq.leba.widget.a
            @SuppressLint({"NotifyDataSetChanged"})
            public void a(long resId) {
                LebaPluginFeedAdapter lebaPluginFeedAdapter2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, resId);
                    return;
                }
                final LebaPluginFeedView lebaPluginFeedView = LebaPluginFeedView.this;
                if (com.tencent.mobileqq.leba.util.a.f240763a.a()) {
                    lebaPluginFeedAdapter2 = lebaPluginFeedView.pluginListAdapter;
                    lebaPluginFeedAdapter2.notifyDataSetChanged();
                } else {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.leba.feed.LebaPluginFeedView$controller$1$notifyPluginViewRefresh$$inlined$runOnMainThread$1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) LebaPluginFeedView.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            LebaPluginFeedAdapter lebaPluginFeedAdapter3;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                lebaPluginFeedAdapter3 = LebaPluginFeedView.this.pluginListAdapter;
                                lebaPluginFeedAdapter3.notifyDataSetChanged();
                            } else {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                }
            }

            @Override // com.tencent.mobileqq.leba.widget.a
            public int b() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    return ((Integer) iPatchRedirector2.redirect((short) 4, (Object) this)).intValue();
                }
                return 2;
            }

            @Override // com.tencent.mobileqq.leba.widget.a
            public void c(@Nullable n pluginViewItem) {
                LebaPluginFeedAdapter lebaPluginFeedAdapter2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    lebaPluginFeedAdapter2 = LebaPluginFeedView.this.pluginListAdapter;
                    lebaPluginFeedAdapter2.v(pluginViewItem);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) pluginViewItem);
                }
            }
        };
        a aVar = new a(getContext());
        this.pluginLayoutManager = aVar;
        RecyclerView recyclerView = new RecyclerView(getContext());
        recyclerView.setLayoutManager(aVar);
        recyclerView.setAdapter(lebaPluginFeedAdapter);
        this.pluginRecycleView = recyclerView;
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        recycledViewPool.setMaxRecycledViews(0, 10);
        recyclerView.setRecycledViewPool(recycledViewPool);
        addView(recyclerView);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.leba.feed.i
            @Override // java.lang.Runnable
            public final void run() {
                LebaPluginFeedView.c();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        boolean z16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            z16 = ((IZPlanApi) QRoute.api(IZPlanApi.class)).isQzoneEntranceEnabled(peekAppRuntime.getLongAccountUin());
        } else {
            z16 = false;
        }
        QLog.i("LebaPluginFeedView", 1, "report isZPlanSwitchOn: " + z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void j(List list, LebaPluginFeedView this$0) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (list != null) {
            i3 = list.size();
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            if (i3 > 5) {
                if (i3 <= 8) {
                    i3 = 4;
                } else {
                    i3 = 5;
                }
            }
            this$0.pluginLayoutManager.setSpanCount(i3);
        }
        LebaPluginFeedAdapter lebaPluginFeedAdapter = this$0.pluginListAdapter;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        lebaPluginFeedAdapter.A(list);
    }

    @Override // com.tencent.mobileqq.leba.core.BasePluginDataManager.d
    @SuppressLint({"NotifyDataSetChanged"})
    public void Ef(@Nullable final List<? extends n> pluginDataList, @Nullable List<? extends n> morePluginDataList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) pluginDataList, (Object) morePluginDataList);
        } else {
            post(new Runnable() { // from class: com.tencent.mobileqq.leba.feed.j
                @Override // java.lang.Runnable
                public final void run() {
                    LebaPluginFeedView.j(pluginDataList, this);
                }
            });
        }
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            this.lebaPluginProxy.b();
        }
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            BasePluginDataManager.k(this.basePluginDataManager, 5, null, 2, null);
        }
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.lebaPluginProxy.m();
        }
    }

    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.basePluginDataManager.o();
            this.lebaPluginProxy.n();
        }
    }

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.lebaPluginProxy.p();
            this.pluginListAdapter.z();
        }
    }

    public final void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            BasePluginDataManager.k(this.basePluginDataManager, 4, null, 2, null);
        }
    }

    public final void l(boolean tabChange) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, tabChange);
        } else {
            this.basePluginDataManager.q(tabChange, 2);
            this.lebaPluginProxy.r(tabChange, 2);
        }
    }

    public final void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            this.lebaPluginProxy.s();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onAttachedToWindow();
        QLog.d("LebaPluginFeedView", 4, "onAttachedToWindow ");
        this.basePluginDataManager.s(this);
        this.basePluginDataManager.n();
        if (this.basePluginDataManager.f().isEmpty()) {
            BasePluginDataManager.k(this.basePluginDataManager, 0, null, 2, null);
        }
        this.lebaPluginProxy.e(this.controller);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        QLog.i("LebaPluginFeedView", 4, NodeProps.ON_DETACHED_FROM_WINDOW);
        super.onDetachedFromWindow();
        this.basePluginDataManager.t(this);
        this.basePluginDataManager.p();
        this.lebaPluginProxy.x();
        com.tencent.mobileqq.leba.utils.f.a(getContext());
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NotNull View changedView, int visibility) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) changedView, visibility);
            return;
        }
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        QLog.d("LebaPluginFeedView", 4, "onVisibilityChanged " + changedView + " " + visibility + ", refreshFlag: " + com.tencent.mobileqq.leba.core.e.f240372e);
        if (visibility == 0 && com.tencent.mobileqq.leba.core.e.f240372e > 0) {
            this.basePluginDataManager.j(3, "refreshFlag: " + com.tencent.mobileqq.leba.core.e.f240372e);
            com.tencent.mobileqq.leba.core.e.f240372e = 0;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.tencent.mobileqq.leba.feed.LebaPluginFeedView$controller$1] */
    public LebaPluginFeedView(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attrs);
            return;
        }
        LebaPluginProxy lebaPluginProxy = new LebaPluginProxy();
        this.lebaPluginProxy = lebaPluginProxy;
        LebaPluginFeedAdapter lebaPluginFeedAdapter = new LebaPluginFeedAdapter(lebaPluginProxy);
        this.pluginListAdapter = lebaPluginFeedAdapter;
        this.basePluginDataManager = com.tencent.mobileqq.leba.core.b.b(2);
        this.controller = new com.tencent.mobileqq.leba.widget.a() { // from class: com.tencent.mobileqq.leba.feed.LebaPluginFeedView$controller$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LebaPluginFeedView.this);
                }
            }

            @Override // com.tencent.mobileqq.leba.widget.a
            @SuppressLint({"NotifyDataSetChanged"})
            public void a(long resId) {
                LebaPluginFeedAdapter lebaPluginFeedAdapter2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, resId);
                    return;
                }
                final LebaPluginFeedView lebaPluginFeedView = LebaPluginFeedView.this;
                if (com.tencent.mobileqq.leba.util.a.f240763a.a()) {
                    lebaPluginFeedAdapter2 = lebaPluginFeedView.pluginListAdapter;
                    lebaPluginFeedAdapter2.notifyDataSetChanged();
                } else {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.leba.feed.LebaPluginFeedView$controller$1$notifyPluginViewRefresh$$inlined$runOnMainThread$1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) LebaPluginFeedView.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            LebaPluginFeedAdapter lebaPluginFeedAdapter3;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                lebaPluginFeedAdapter3 = LebaPluginFeedView.this.pluginListAdapter;
                                lebaPluginFeedAdapter3.notifyDataSetChanged();
                            } else {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                }
            }

            @Override // com.tencent.mobileqq.leba.widget.a
            public int b() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    return ((Integer) iPatchRedirector2.redirect((short) 4, (Object) this)).intValue();
                }
                return 2;
            }

            @Override // com.tencent.mobileqq.leba.widget.a
            public void c(@Nullable n pluginViewItem) {
                LebaPluginFeedAdapter lebaPluginFeedAdapter2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    lebaPluginFeedAdapter2 = LebaPluginFeedView.this.pluginListAdapter;
                    lebaPluginFeedAdapter2.v(pluginViewItem);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) pluginViewItem);
                }
            }
        };
        a aVar = new a(getContext());
        this.pluginLayoutManager = aVar;
        RecyclerView recyclerView = new RecyclerView(getContext());
        recyclerView.setLayoutManager(aVar);
        recyclerView.setAdapter(lebaPluginFeedAdapter);
        this.pluginRecycleView = recyclerView;
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        recycledViewPool.setMaxRecycledViews(0, 10);
        recyclerView.setRecycledViewPool(recycledViewPool);
        addView(recyclerView);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.leba.feed.i
            @Override // java.lang.Runnable
            public final void run() {
                LebaPluginFeedView.c();
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r6v3, types: [com.tencent.mobileqq.leba.feed.LebaPluginFeedView$controller$1] */
    public LebaPluginFeedView(@NotNull Context context, @NotNull AttributeSet attrs, int i3) {
        super(context, attrs, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attrs, Integer.valueOf(i3));
            return;
        }
        LebaPluginProxy lebaPluginProxy = new LebaPluginProxy();
        this.lebaPluginProxy = lebaPluginProxy;
        LebaPluginFeedAdapter lebaPluginFeedAdapter = new LebaPluginFeedAdapter(lebaPluginProxy);
        this.pluginListAdapter = lebaPluginFeedAdapter;
        this.basePluginDataManager = com.tencent.mobileqq.leba.core.b.b(2);
        this.controller = new com.tencent.mobileqq.leba.widget.a() { // from class: com.tencent.mobileqq.leba.feed.LebaPluginFeedView$controller$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LebaPluginFeedView.this);
                }
            }

            @Override // com.tencent.mobileqq.leba.widget.a
            @SuppressLint({"NotifyDataSetChanged"})
            public void a(long resId) {
                LebaPluginFeedAdapter lebaPluginFeedAdapter2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, resId);
                    return;
                }
                final LebaPluginFeedView lebaPluginFeedView = LebaPluginFeedView.this;
                if (com.tencent.mobileqq.leba.util.a.f240763a.a()) {
                    lebaPluginFeedAdapter2 = lebaPluginFeedView.pluginListAdapter;
                    lebaPluginFeedAdapter2.notifyDataSetChanged();
                } else {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.leba.feed.LebaPluginFeedView$controller$1$notifyPluginViewRefresh$$inlined$runOnMainThread$1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) LebaPluginFeedView.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            LebaPluginFeedAdapter lebaPluginFeedAdapter3;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                lebaPluginFeedAdapter3 = LebaPluginFeedView.this.pluginListAdapter;
                                lebaPluginFeedAdapter3.notifyDataSetChanged();
                            } else {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                }
            }

            @Override // com.tencent.mobileqq.leba.widget.a
            public int b() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    return ((Integer) iPatchRedirector2.redirect((short) 4, (Object) this)).intValue();
                }
                return 2;
            }

            @Override // com.tencent.mobileqq.leba.widget.a
            public void c(@Nullable n pluginViewItem) {
                LebaPluginFeedAdapter lebaPluginFeedAdapter2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    lebaPluginFeedAdapter2 = LebaPluginFeedView.this.pluginListAdapter;
                    lebaPluginFeedAdapter2.v(pluginViewItem);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) pluginViewItem);
                }
            }
        };
        a aVar = new a(getContext());
        this.pluginLayoutManager = aVar;
        RecyclerView recyclerView = new RecyclerView(getContext());
        recyclerView.setLayoutManager(aVar);
        recyclerView.setAdapter(lebaPluginFeedAdapter);
        this.pluginRecycleView = recyclerView;
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        recycledViewPool.setMaxRecycledViews(0, 10);
        recyclerView.setRecycledViewPool(recycledViewPool);
        addView(recyclerView);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.leba.feed.i
            @Override // java.lang.Runnable
            public final void run() {
                LebaPluginFeedView.c();
            }
        });
    }
}
