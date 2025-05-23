package com.tencent.mobileqq.leba.list;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.heytap.databaseengine.apiv3.data.Element;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.leba.business.LebaPluginProxy;
import com.tencent.mobileqq.leba.core.BasePluginDataManager;
import com.tencent.mobileqq.leba.entity.n;
import com.tencent.mobileqq.leba.list.LebaPluginListAdapter;
import com.tencent.mobileqq.leba.view.OverScrollHeaderView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.resconfig.MainResourceConfig;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.LebaOverScrollRecyclerView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
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
import tl.h;

@Metadata(d1 = {"\u0000\u0099\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001<\u0018\u0000 T2\u00020\u00012\u00020\u0002:\u0001UB\u0011\b\u0016\u0012\u0006\u0010L\u001a\u00020K\u00a2\u0006\u0004\bM\u0010NB\u0019\b\u0016\u0012\u0006\u0010L\u001a\u00020K\u0012\u0006\u0010P\u001a\u00020O\u00a2\u0006\u0004\bM\u0010QB!\b\u0016\u0012\u0006\u0010L\u001a\u00020K\u0012\u0006\u0010P\u001a\u00020O\u0012\u0006\u0010R\u001a\u00020\u0005\u00a2\u0006\u0004\bM\u0010SJ$\u0010\n\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0014J\b\u0010\f\u001a\u00020\tH\u0014J\u0006\u0010\r\u001a\u00020\tJ\u0006\u0010\u000e\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0005H\u0015J\u0006\u0010\u0015\u001a\u00020\tJ\b\u0010\u0016\u001a\u00020\tH\u0007J\u0006\u0010\u0017\u001a\u00020\tJ\u0006\u0010\u0018\u001a\u00020\tJ\u0006\u0010\u0019\u001a\u00020\tJ\u0006\u0010\u001a\u001a\u00020\tJ\u000e\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001bJ(\u0010\"\u001a\u00020\t2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eH\u0016J\u0010\u0010$\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0005H\u0016R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010;\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010:R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010F\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010J\u001a\u00020G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010I\u00a8\u0006V"}, d2 = {"Lcom/tencent/mobileqq/leba/list/LebaPluginListView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mobileqq/leba/core/BasePluginDataManager$d;", "Landroid/view/View;", "child", "", "index", "Landroid/view/ViewGroup$LayoutParams;", "params", "", "addView", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "tabChange", ReportConstant.COSTREPORT_PREFIX, "changedView", "visibility", "onVisibilityChanged", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "r", "o", "k", "t", "p", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "listener", "l", "", "Lcom/tencent/mobileqq/leba/entity/n;", "pluginDataList", "morePluginList", "Ef", "direction", "canScrollVertically", "Lcom/tencent/mobileqq/leba/business/LebaPluginProxy;", "d", "Lcom/tencent/mobileqq/leba/business/LebaPluginProxy;", "pluginProxy", "Landroid/support/v7/widget/RecyclerView;", "e", "Landroid/support/v7/widget/RecyclerView;", "pluginRecyclerView", "Lcom/tencent/mobileqq/leba/view/OverScrollHeaderView;", "f", "Lcom/tencent/mobileqq/leba/view/OverScrollHeaderView;", "overScrollHeaderView", "Lcom/tencent/mobileqq/leba/core/BasePluginDataManager;", h.F, "Lcom/tencent/mobileqq/leba/core/BasePluginDataManager;", "basePluginDataManager", "Lcom/tencent/mobileqq/leba/list/LebaPluginListAdapter;", "i", "Lcom/tencent/mobileqq/leba/list/LebaPluginListAdapter;", "pluginListAdapter", "Lcom/tencent/mobileqq/leba/list/a;", "Lcom/tencent/mobileqq/leba/list/a;", "headerAndFooterWrapper", "com/tencent/mobileqq/leba/list/LebaPluginListView$controller$1", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/leba/list/LebaPluginListView$controller$1;", "controller", "Lcom/tencent/mobileqq/leba/business/f;", "D", "Lcom/tencent/mobileqq/leba/business/f;", "mBizProxy", "E", "Z", "isFirstReport", "Lcom/tencent/mobileqq/leba/view/e;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/leba/view/e;", "monitor", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "G", "c", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LebaPluginListView extends RelativeLayout implements BasePluginDataManager.d {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LebaPluginListView$controller$1 controller;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.leba.business.f mBizProxy;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isFirstReport;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.leba.view.e monitor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LebaPluginProxy pluginProxy;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView pluginRecyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final OverScrollHeaderView overScrollHeaderView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BasePluginDataManager basePluginDataManager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LebaPluginListAdapter pluginListAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.leba.list.a headerAndFooterWrapper;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/leba/list/LebaPluginListView$a", "Lcom/tencent/mobileqq/leba/list/LebaPluginListAdapter$b;", "", "position", "", "P0", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements LebaPluginListAdapter.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LebaPluginListView.this);
            }
        }

        @Override // com.tencent.mobileqq.leba.list.LebaPluginListAdapter.b
        public void P0(int position) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, position);
                return;
            }
            int t16 = position + LebaPluginListView.this.headerAndFooterWrapper.t();
            if (t16 >= 0 && t16 < LebaPluginListView.this.pluginListAdapter.getItemCount()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                LebaPluginListView.this.pluginListAdapter.notifyItemChanged(t16, 0);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/leba/list/LebaPluginListView$b", "Lcom/tencent/mobileqq/widget/LebaOverScrollRecyclerView$a;", "", Element.ELEMENT_NAME_DISTANCE, "", "a", "top", "b", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements LebaOverScrollRecyclerView.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LebaPluginListView.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.LebaOverScrollRecyclerView.a
        public void a(float distance) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Float.valueOf(distance));
            } else {
                LebaPluginListView.this.overScrollHeaderView.setMove(distance);
            }
        }

        @Override // com.tencent.mobileqq.widget.LebaOverScrollRecyclerView.a
        public void b(float top) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Float.valueOf(top));
            } else {
                LebaPluginListView.this.overScrollHeaderView.setInitTop(top);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/leba/list/LebaPluginListView$c;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.leba.list.LebaPluginListView$c, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18503);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.tencent.mobileqq.leba.list.LebaPluginListView$controller$1] */
    public LebaPluginListView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        LebaPluginProxy lebaPluginProxy = new LebaPluginProxy();
        this.pluginProxy = lebaPluginProxy;
        this.basePluginDataManager = com.tencent.mobileqq.leba.core.b.b(1);
        LebaPluginListAdapter lebaPluginListAdapter = new LebaPluginListAdapter(lebaPluginProxy);
        this.pluginListAdapter = lebaPluginListAdapter;
        com.tencent.mobileqq.leba.list.a aVar = new com.tencent.mobileqq.leba.list.a(lebaPluginListAdapter);
        this.headerAndFooterWrapper = aVar;
        this.controller = new com.tencent.mobileqq.leba.widget.a() { // from class: com.tencent.mobileqq.leba.list.LebaPluginListView$controller$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LebaPluginListView.this);
                }
            }

            @Override // com.tencent.mobileqq.leba.widget.a
            @SuppressLint({"NotifyDataSetChanged"})
            public void a(long resId) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, resId);
                    return;
                }
                QLog.d("LebaPluginListView", 2, "notifyPluginViewRefresh resId=" + resId + " ");
                final LebaPluginListView lebaPluginListView = LebaPluginListView.this;
                if (com.tencent.mobileqq.leba.util.a.f240763a.a()) {
                    lebaPluginListView.pluginListAdapter.notifyDataSetChanged();
                } else {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.leba.list.LebaPluginListView$controller$1$notifyPluginViewRefresh$$inlined$runOnMainThread$1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) LebaPluginListView.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                LebaPluginListView.this.pluginListAdapter.notifyDataSetChanged();
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
                return 1;
            }

            @Override // com.tencent.mobileqq.leba.widget.a
            public void c(@Nullable n pluginViewItem) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) pluginViewItem);
                } else {
                    LebaPluginListView.this.pluginListAdapter.x(pluginViewItem);
                }
            }
        };
        com.tencent.mobileqq.leba.business.f fVar = new com.tencent.mobileqq.leba.business.f();
        this.mBizProxy = fVar;
        this.isFirstReport = true;
        com.tencent.mobileqq.leba.view.e eVar = new com.tencent.mobileqq.leba.view.e();
        this.monitor = eVar;
        eVar.c();
        lebaPluginListAdapter.C(new a());
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.avx, (ViewGroup) this, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "layoutInflater.inflate(c\u2026or_entries2, this, false)");
        aVar.addHeaderView(inflate);
        com.tencent.mobileqq.leba.controller.list.a.a(inflate);
        fVar.a();
        fVar.b(inflate);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        OverScrollHeaderView overScrollHeaderView = new OverScrollHeaderView(context2);
        MainResourceConfig g16 = MainResourceConfig.INSTANCE.g();
        Context context3 = overScrollHeaderView.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        overScrollHeaderView.setBackground(g16.l(context3));
        this.overScrollHeaderView = overScrollHeaderView;
        addView(overScrollHeaderView, -1, -1);
        LebaOverScrollRecyclerView lebaOverScrollRecyclerView = new LebaOverScrollRecyclerView(getContext());
        lebaOverScrollRecyclerView.setLayoutManager(new LinearLayoutManager(lebaOverScrollRecyclerView.getContext()));
        lebaOverScrollRecyclerView.setAdapter(aVar);
        lebaOverScrollRecyclerView.setOverScrollHeader(new b());
        this.pluginRecyclerView = lebaOverScrollRecyclerView;
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        recycledViewPool.setMaxRecycledViews(0, 24);
        lebaOverScrollRecyclerView.setRecycledViewPool(recycledViewPool);
        addView(lebaOverScrollRecyclerView, -1, -1);
    }

    @Override // com.tencent.mobileqq.leba.core.BasePluginDataManager.d
    public void Ef(@Nullable List<? extends n> pluginDataList, @Nullable List<? extends n> morePluginList) {
        final List<? extends n> list = pluginDataList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) list, (Object) morePluginList);
            return;
        }
        this.monitor.e();
        if (com.tencent.mobileqq.leba.util.a.f240763a.a()) {
            this.monitor.f();
            LebaPluginListAdapter lebaPluginListAdapter = this.pluginListAdapter;
            if (list == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            lebaPluginListAdapter.D(list);
            if (this.isFirstReport) {
                this.isFirstReport = false;
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(peekAppRuntime.getAccount(), "actLebaShowTime", true, SystemClock.uptimeMillis() - this.monitor.a(), 0L, null, null);
                return;
            }
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable(list) { // from class: com.tencent.mobileqq.leba.list.LebaPluginListView$onPluginDataChanged$$inlined$runOnMainThread$1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ List f240632d;

            {
                this.f240632d = list;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LebaPluginListView.this, (Object) list);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                LebaPluginListView.this.monitor.f();
                LebaPluginListAdapter lebaPluginListAdapter2 = LebaPluginListView.this.pluginListAdapter;
                List<? extends n> list2 = this.f240632d;
                if (list2 == null) {
                    list2 = CollectionsKt__CollectionsKt.emptyList();
                }
                lebaPluginListAdapter2.D(list2);
                if (LebaPluginListView.this.isFirstReport) {
                    LebaPluginListView.this.isFirstReport = false;
                    AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(peekAppRuntime2.getAccount(), "actLebaShowTime", true, SystemClock.uptimeMillis() - LebaPluginListView.this.monitor.a(), 0L, null, null);
                }
            }
        });
    }

    @Override // android.view.ViewGroup
    public void addView(@Nullable View child, int index, @Nullable ViewGroup.LayoutParams params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, child, Integer.valueOf(index), params);
        } else if ((child instanceof OverScrollHeaderView) || Intrinsics.areEqual(child, this.pluginRecyclerView)) {
            super.addView(child, index, params);
        }
    }

    @Override // android.view.View
    public boolean canScrollVertically(int direction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, direction)).booleanValue();
        }
        return this.pluginRecyclerView.canScrollVertically(direction);
    }

    public final void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            this.pluginProxy.b();
        }
    }

    public final void l(@NotNull RecyclerView.OnScrollListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.pluginRecyclerView.addOnScrollListener(listener);
        }
    }

    public final void m() {
        List<? extends n> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (com.tencent.mobileqq.leba.util.a.f240763a.a()) {
            this.mBizProxy.c();
            this.pluginProxy.l();
            LebaPluginListAdapter lebaPluginListAdapter = this.pluginListAdapter;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            lebaPluginListAdapter.D(emptyList);
            BasePluginDataManager.k(this.basePluginDataManager, 5, null, 2, null);
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.leba.list.LebaPluginListView$onAccountChanged$$inlined$runOnMainThread$1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LebaPluginListView.this);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                List<? extends n> emptyList2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                LebaPluginListView.this.mBizProxy.c();
                LebaPluginListView.this.pluginProxy.l();
                LebaPluginListAdapter lebaPluginListAdapter2 = LebaPluginListView.this.pluginListAdapter;
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                lebaPluginListAdapter2.D(emptyList2);
                BasePluginDataManager.k(LebaPluginListView.this.basePluginDataManager, 5, null, 2, null);
            }
        });
    }

    public final void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.pluginProxy.m();
        }
    }

    public final void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        this.basePluginDataManager.o();
        this.pluginProxy.n();
        QLog.d("LebaPluginListView", 4, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("leba_list_view_ondestory_memory_leak_fix", true)) {
            try {
                this.pluginRecyclerView.removeAllViews();
                removeAllViews();
            } catch (Exception e16) {
                QLog.e("LebaPluginListView", 1, "onDetachedFromWindow exception:", e16);
            }
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
        QLog.d("LebaPluginListView", 4, "onAttachedToWindow ");
        this.monitor.b();
        this.basePluginDataManager.s(this);
        this.basePluginDataManager.n();
        if (this.basePluginDataManager.f().isEmpty()) {
            BasePluginDataManager.k(this.basePluginDataManager, 0, null, 2, null);
        }
        this.pluginProxy.e(this.controller);
        this.monitor.g();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        QLog.d("LebaPluginListView", 2, "onDetachedFromWindow ");
        this.basePluginDataManager.p();
        this.basePluginDataManager.t(this);
        this.pluginProxy.x();
        this.monitor.d();
        com.tencent.mobileqq.leba.utils.f.a(getContext());
    }

    @Override // android.view.View
    @SuppressLint({"NotifyDataSetChanged"})
    protected void onVisibilityChanged(@NotNull View changedView, int visibility) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) changedView, visibility);
            return;
        }
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        QLog.d("LebaPluginListView", 2, "onVisibilityChanged " + changedView + " " + visibility + "  ");
        if (visibility == 0 && com.tencent.mobileqq.leba.core.e.f240372e > 0) {
            this.basePluginDataManager.j(3, "refreshFlag: " + com.tencent.mobileqq.leba.core.e.f240372e);
            com.tencent.mobileqq.leba.core.e.f240372e = 0;
        }
    }

    public final void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            this.pluginProxy.o();
        }
    }

    public final void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.pluginProxy.p();
            this.pluginListAdapter.B();
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (com.tencent.mobileqq.leba.util.a.f240763a.a()) {
            this.mBizProxy.h();
            OverScrollHeaderView overScrollHeaderView = this.overScrollHeaderView;
            MainResourceConfig g16 = MainResourceConfig.INSTANCE.g();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            overScrollHeaderView.setBackground(g16.l(context));
            try {
                this.pluginRecyclerView.getRecycledViewPool().clear();
            } catch (Exception unused) {
            }
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.leba.list.LebaPluginListView$onPostThemeChanged$$inlined$runOnMainThread$1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LebaPluginListView.this);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    LebaPluginListView.this.mBizProxy.h();
                    OverScrollHeaderView overScrollHeaderView2 = LebaPluginListView.this.overScrollHeaderView;
                    MainResourceConfig g17 = MainResourceConfig.INSTANCE.g();
                    Context context2 = LebaPluginListView.this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    overScrollHeaderView2.setBackground(g17.l(context2));
                    try {
                        LebaPluginListView.this.pluginRecyclerView.getRecycledViewPool().clear();
                    } catch (Exception unused2) {
                    }
                }
            });
        }
        BasePluginDataManager.k(this.basePluginDataManager, 4, null, 2, null);
    }

    public final void s(boolean tabChange) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, tabChange);
            return;
        }
        this.mBizProxy.i(tabChange);
        this.basePluginDataManager.q(tabChange, 1);
        this.pluginProxy.r(tabChange, 1);
    }

    public final void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            this.pluginProxy.s();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.tencent.mobileqq.leba.list.LebaPluginListView$controller$1] */
    public LebaPluginListView(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attrs);
            return;
        }
        LebaPluginProxy lebaPluginProxy = new LebaPluginProxy();
        this.pluginProxy = lebaPluginProxy;
        this.basePluginDataManager = com.tencent.mobileqq.leba.core.b.b(1);
        LebaPluginListAdapter lebaPluginListAdapter = new LebaPluginListAdapter(lebaPluginProxy);
        this.pluginListAdapter = lebaPluginListAdapter;
        com.tencent.mobileqq.leba.list.a aVar = new com.tencent.mobileqq.leba.list.a(lebaPluginListAdapter);
        this.headerAndFooterWrapper = aVar;
        this.controller = new com.tencent.mobileqq.leba.widget.a() { // from class: com.tencent.mobileqq.leba.list.LebaPluginListView$controller$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LebaPluginListView.this);
                }
            }

            @Override // com.tencent.mobileqq.leba.widget.a
            @SuppressLint({"NotifyDataSetChanged"})
            public void a(long resId) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, resId);
                    return;
                }
                QLog.d("LebaPluginListView", 2, "notifyPluginViewRefresh resId=" + resId + " ");
                final LebaPluginListView lebaPluginListView = LebaPluginListView.this;
                if (com.tencent.mobileqq.leba.util.a.f240763a.a()) {
                    lebaPluginListView.pluginListAdapter.notifyDataSetChanged();
                } else {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.leba.list.LebaPluginListView$controller$1$notifyPluginViewRefresh$$inlined$runOnMainThread$1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) LebaPluginListView.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                LebaPluginListView.this.pluginListAdapter.notifyDataSetChanged();
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
                return 1;
            }

            @Override // com.tencent.mobileqq.leba.widget.a
            public void c(@Nullable n pluginViewItem) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) pluginViewItem);
                } else {
                    LebaPluginListView.this.pluginListAdapter.x(pluginViewItem);
                }
            }
        };
        com.tencent.mobileqq.leba.business.f fVar = new com.tencent.mobileqq.leba.business.f();
        this.mBizProxy = fVar;
        this.isFirstReport = true;
        com.tencent.mobileqq.leba.view.e eVar = new com.tencent.mobileqq.leba.view.e();
        this.monitor = eVar;
        eVar.c();
        lebaPluginListAdapter.C(new a());
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.avx, (ViewGroup) this, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "layoutInflater.inflate(c\u2026or_entries2, this, false)");
        aVar.addHeaderView(inflate);
        com.tencent.mobileqq.leba.controller.list.a.a(inflate);
        fVar.a();
        fVar.b(inflate);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        OverScrollHeaderView overScrollHeaderView = new OverScrollHeaderView(context2);
        MainResourceConfig g16 = MainResourceConfig.INSTANCE.g();
        Context context3 = overScrollHeaderView.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        overScrollHeaderView.setBackground(g16.l(context3));
        this.overScrollHeaderView = overScrollHeaderView;
        addView(overScrollHeaderView, -1, -1);
        LebaOverScrollRecyclerView lebaOverScrollRecyclerView = new LebaOverScrollRecyclerView(getContext());
        lebaOverScrollRecyclerView.setLayoutManager(new LinearLayoutManager(lebaOverScrollRecyclerView.getContext()));
        lebaOverScrollRecyclerView.setAdapter(aVar);
        lebaOverScrollRecyclerView.setOverScrollHeader(new b());
        this.pluginRecyclerView = lebaOverScrollRecyclerView;
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        recycledViewPool.setMaxRecycledViews(0, 24);
        lebaOverScrollRecyclerView.setRecycledViewPool(recycledViewPool);
        addView(lebaOverScrollRecyclerView, -1, -1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r9v1, types: [com.tencent.mobileqq.leba.list.LebaPluginListView$controller$1] */
    public LebaPluginListView(@NotNull Context context, @NotNull AttributeSet attrs, int i3) {
        super(context, attrs, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attrs, Integer.valueOf(i3));
            return;
        }
        LebaPluginProxy lebaPluginProxy = new LebaPluginProxy();
        this.pluginProxy = lebaPluginProxy;
        this.basePluginDataManager = com.tencent.mobileqq.leba.core.b.b(1);
        LebaPluginListAdapter lebaPluginListAdapter = new LebaPluginListAdapter(lebaPluginProxy);
        this.pluginListAdapter = lebaPluginListAdapter;
        com.tencent.mobileqq.leba.list.a aVar = new com.tencent.mobileqq.leba.list.a(lebaPluginListAdapter);
        this.headerAndFooterWrapper = aVar;
        this.controller = new com.tencent.mobileqq.leba.widget.a() { // from class: com.tencent.mobileqq.leba.list.LebaPluginListView$controller$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LebaPluginListView.this);
                }
            }

            @Override // com.tencent.mobileqq.leba.widget.a
            @SuppressLint({"NotifyDataSetChanged"})
            public void a(long resId) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, resId);
                    return;
                }
                QLog.d("LebaPluginListView", 2, "notifyPluginViewRefresh resId=" + resId + " ");
                final LebaPluginListView lebaPluginListView = LebaPluginListView.this;
                if (com.tencent.mobileqq.leba.util.a.f240763a.a()) {
                    lebaPluginListView.pluginListAdapter.notifyDataSetChanged();
                } else {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.leba.list.LebaPluginListView$controller$1$notifyPluginViewRefresh$$inlined$runOnMainThread$1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) LebaPluginListView.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                LebaPluginListView.this.pluginListAdapter.notifyDataSetChanged();
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
                return 1;
            }

            @Override // com.tencent.mobileqq.leba.widget.a
            public void c(@Nullable n pluginViewItem) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) pluginViewItem);
                } else {
                    LebaPluginListView.this.pluginListAdapter.x(pluginViewItem);
                }
            }
        };
        com.tencent.mobileqq.leba.business.f fVar = new com.tencent.mobileqq.leba.business.f();
        this.mBizProxy = fVar;
        this.isFirstReport = true;
        com.tencent.mobileqq.leba.view.e eVar = new com.tencent.mobileqq.leba.view.e();
        this.monitor = eVar;
        eVar.c();
        lebaPluginListAdapter.C(new a());
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.avx, (ViewGroup) this, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "layoutInflater.inflate(c\u2026or_entries2, this, false)");
        aVar.addHeaderView(inflate);
        com.tencent.mobileqq.leba.controller.list.a.a(inflate);
        fVar.a();
        fVar.b(inflate);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        OverScrollHeaderView overScrollHeaderView = new OverScrollHeaderView(context2);
        MainResourceConfig g16 = MainResourceConfig.INSTANCE.g();
        Context context3 = overScrollHeaderView.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        overScrollHeaderView.setBackground(g16.l(context3));
        this.overScrollHeaderView = overScrollHeaderView;
        addView(overScrollHeaderView, -1, -1);
        LebaOverScrollRecyclerView lebaOverScrollRecyclerView = new LebaOverScrollRecyclerView(getContext());
        lebaOverScrollRecyclerView.setLayoutManager(new LinearLayoutManager(lebaOverScrollRecyclerView.getContext()));
        lebaOverScrollRecyclerView.setAdapter(aVar);
        lebaOverScrollRecyclerView.setOverScrollHeader(new b());
        this.pluginRecyclerView = lebaOverScrollRecyclerView;
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        recycledViewPool.setMaxRecycledViews(0, 24);
        lebaOverScrollRecyclerView.setRecycledViewPool(recycledViewPool);
        addView(lebaOverScrollRecyclerView, -1, -1);
    }
}
