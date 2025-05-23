package com.tencent.sqshow.zootopia.taskcenter;

import ac4.a;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.c;
import com.tencent.mobileqq.zplan.api.IZplanCacheApi;
import com.tencent.mobileqq.zplan.api.ZplanCacheComponentType;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.sqshow.fragment.ZootopiaBaseFragment;
import com.tencent.sqshow.zootopia.ZootopiaTransparentActivity;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.portal.shimmer.ShimmerLinearLayout;
import com.tencent.sqshow.zootopia.taskcenter.TaskHalfScreenPanelFragment;
import com.tencent.sqshow.zootopia.taskcenter.common.CurrencyUpdateEvent;
import com.tencent.sqshow.zootopia.taskcenter.common.TaskHalfScreenFloatingView;
import com.tencent.sqshow.zootopia.taskcenter.header.DailyTitleBarHeaderView;
import com.tencent.sqshow.zootopia.taskcenter.tasklist.TaskListAdapter;
import com.tencent.sqshow.zootopia.taskcenter.tasklist.TaskListController;
import com.tencent.sqshow.zootopia.utils.ag;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.sqshow.zootopia.widget.reddot.ZPlanRedDotManager;
import com.tencent.state.report.SquareReportConst;
import db4.a;
import dc4.g;
import dc4.h;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import n74.de;
import n74.dg;

@Metadata(d1 = {"\u0000\u00b0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 d2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001eB\u0007\u00a2\u0006\u0004\bb\u0010cJ\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0014J&\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u001a\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\b\u0010\u001f\u001a\u00020\u0006H\u0016J\b\u0010 \u001a\u00020\u0006H\u0016J\b\u0010!\u001a\u00020\u0006H\u0016J\b\u0010\"\u001a\u00020\u0006H\u0016J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#H\u0016J\b\u0010&\u001a\u00020\u0006H\u0016J\b\u0010'\u001a\u00020\u0006H\u0016J\u0010\u0010*\u001a\u00020\u00062\u0006\u0010)\u001a\u00020(H\u0016J\u0012\u0010-\u001a\u00020\u00192\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\b\u0010.\u001a\u00020\u0006H\u0016J\b\u0010/\u001a\u00020\u0006H\u0016R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R$\u0010E\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010M\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010Y\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010]\u001a\u00020Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010`\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010_\u00a8\u0006f"}, d2 = {"Lcom/tencent/sqshow/zootopia/taskcenter/TaskHalfScreenPanelFragment;", "Lcom/tencent/sqshow/fragment/ZootopiaBaseFragment;", "Ldb4/a;", "Lk84/a;", "Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$p;", "Lcom/tencent/mobileqq/zootopia/api/c;", "", "initView", "Qh", "initViewModel", "", "", "", "Mh", "sourceId", "Lh", "getSubSource", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "", "onBackPressedEvent", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onShowTotalStart", "onShowTotal", "onShowDefaultStart", "onShowDefault", "onShowMinStart", "onShowMin", "", "status", "I4", "ne", "onResume", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Landroid/view/KeyEvent;", "event", "J5", "Eh", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/common/app/AppInterface;", "N", "Lcom/tencent/common/app/AppInterface;", "app", "Ldc4/h;", "P", "Ldc4/h;", "viewModel", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/view/LayoutInflater;", "Landroidx/recyclerview/widget/RecyclerView;", BdhLogUtil.LogTag.Tag_Req, "Landroidx/recyclerview/widget/RecyclerView;", "panelRecyclerView", "Lcom/tencent/sqshow/zootopia/taskcenter/header/DailyTitleBarHeaderView;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/sqshow/zootopia/taskcenter/header/DailyTitleBarHeaderView;", "getHeaderView", "()Lcom/tencent/sqshow/zootopia/taskcenter/header/DailyTitleBarHeaderView;", "setHeaderView", "(Lcom/tencent/sqshow/zootopia/taskcenter/header/DailyTitleBarHeaderView;)V", "headerView", "Lcom/tencent/sqshow/zootopia/taskcenter/tasklist/TaskListAdapter;", "T", "Lcom/tencent/sqshow/zootopia/taskcenter/tasklist/TaskListAdapter;", "getAdapter", "()Lcom/tencent/sqshow/zootopia/taskcenter/tasklist/TaskListAdapter;", "setAdapter", "(Lcom/tencent/sqshow/zootopia/taskcenter/tasklist/TaskListAdapter;)V", "adapter", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "U", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "qusHalfScreenFloatingView", "Ln74/de;", "V", "Ln74/de;", "panelBinding", "Ln74/dg;", "W", "Ln74/dg;", "containerLayoutBinding", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "X", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "reportHelper", "Y", "Z", "isFirstLoad", "isFirstShowTotal", "<init>", "()V", "a0", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class TaskHalfScreenPanelFragment extends ZootopiaBaseFragment implements a, k84.a, QUSBaseHalfScreenFloatingView.p, c {

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: N, reason: from kotlin metadata */
    private AppInterface app;

    /* renamed from: P, reason: from kotlin metadata */
    private h viewModel;

    /* renamed from: Q, reason: from kotlin metadata */
    private LayoutInflater inflater;

    /* renamed from: R, reason: from kotlin metadata */
    private RecyclerView panelRecyclerView;

    /* renamed from: S, reason: from kotlin metadata */
    private DailyTitleBarHeaderView headerView;

    /* renamed from: T, reason: from kotlin metadata */
    private TaskListAdapter adapter;

    /* renamed from: U, reason: from kotlin metadata */
    private QUSHalfScreenFloatingView qusHalfScreenFloatingView;

    /* renamed from: V, reason: from kotlin metadata */
    private de panelBinding;

    /* renamed from: W, reason: from kotlin metadata */
    private dg containerLayoutBinding;

    /* renamed from: X, reason: from kotlin metadata */
    private final ZplanViewReportHelper reportHelper = new ZplanViewReportHelper();

    /* renamed from: Y, reason: from kotlin metadata */
    private boolean isFirstLoad = true;

    /* renamed from: Z, reason: from kotlin metadata */
    private boolean isFirstShowTotal = true;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/sqshow/zootopia/taskcenter/TaskHalfScreenPanelFragment$a;", "", "Landroid/os/Bundle;", "arguments", "", "b", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "fromSource", "bundle", "", "a", "", "TAG", "Ljava/lang/String;", "TASK_PANEL_EXTERNAL", "TASK_PANEL_HANDLER", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.taskcenter.TaskHalfScreenPanelFragment$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, ZootopiaSource fromSource, Bundle bundle) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fromSource, "fromSource");
            boolean z16 = context instanceof Activity;
            if (z16) {
                ((Activity) context).overridePendingTransition(0, 0);
            }
            ZootopiaTransparentActivity.INSTANCE.a(context, TaskHalfScreenPanelFragment.class, fromSource, bundle);
            if (b(bundle) && z16) {
                ((Activity) context).overridePendingTransition(0, 0);
            }
        }

        Companion() {
        }

        private final boolean b(Bundle arguments) {
            if (arguments != null) {
                return arguments.getBoolean("transitionAnimation", false);
            }
            return false;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0017\u00a8\u0006\u0004"}, d2 = {"com/tencent/sqshow/zootopia/taskcenter/TaskHalfScreenPanelFragment$b", "Lac4/a$b;", "Landroid/view/View;", "createContentView", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements a.b {
        b() {
        }

        @Override // ac4.a.b
        public View createContentView() {
            dg dgVar = TaskHalfScreenPanelFragment.this.containerLayoutBinding;
            Intrinsics.checkNotNull(dgVar);
            FrameLayout root = dgVar.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "containerLayoutBinding!!.root");
            return root;
        }
    }

    private final void Lh(String sourceId) {
        de deVar = this.panelBinding;
        if (deVar != null) {
            VideoReport.setPageReportPolicy(deVar.getRoot(), PageReportPolicy.REPORT_NONE);
            ZplanViewReportHelper zplanViewReportHelper = this.reportHelper;
            RelativeLayout root = deVar.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "it.root");
            zplanViewReportHelper.a(this, root, "pg_zplan_daily_task", Mh());
            VideoReport.reportPgIn(deVar.getRoot());
            ZplanViewReportHelper zplanViewReportHelper2 = this.reportHelper;
            RelativeLayout root2 = deVar.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "it.root");
            zplanViewReportHelper2.g(root2, "pg_zplan_daily_task", (r16 & 4) != 0 ? null : Mh(), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(TaskHalfScreenPanelFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(TaskHalfScreenPanelFragment this$0, View view) {
        ShimmerLinearLayout shimmerLinearLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I4(1);
        dg dgVar = this$0.containerLayoutBinding;
        if (dgVar != null && (shimmerLinearLayout = dgVar.f419243b) != null) {
            shimmerLinearLayout.c();
        }
        this$0.Qh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(TaskHalfScreenPanelFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QUSHalfScreenTaskPanel", 1, "onKeyDown, finish activity");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void Qh() {
        h hVar = this.viewModel;
        if (hVar != null) {
            hVar.P1();
        }
    }

    private final void initView() {
        dg dgVar;
        RelativeLayout relativeLayout;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = null;
        this.app = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        ((IZplanCacheApi) QRoute.api(IZplanCacheApi.class)).saveCache("task_panel_handler", ZplanCacheComponentType.PARENT_PAGE_HANDLER, this);
        LayoutInflater layoutInflater = this.inflater;
        de g16 = layoutInflater != null ? de.g(layoutInflater) : null;
        this.panelBinding = g16;
        Intrinsics.checkNotNull(g16);
        TaskHalfScreenFloatingView taskHalfScreenFloatingView = g16.f419227b;
        Intrinsics.checkNotNullExpressionValue(taskHalfScreenFloatingView, "panelBinding!!.qusFloatingHalfScreen");
        this.qusHalfScreenFloatingView = taskHalfScreenFloatingView;
        if (taskHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qusHalfScreenFloatingView");
            taskHalfScreenFloatingView = null;
        }
        taskHalfScreenFloatingView.j(this);
        LayoutInflater layoutInflater2 = this.inflater;
        if (layoutInflater2 != null) {
            de deVar = this.panelBinding;
            dgVar = dg.g(layoutInflater2, deVar != null ? deVar.getRoot() : null, false);
        } else {
            dgVar = null;
        }
        this.containerLayoutBinding = dgVar;
        RecyclerView recyclerView = dgVar != null ? dgVar.f419244c : null;
        this.panelRecyclerView = recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = this.qusHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qusHalfScreenFloatingView");
            qUSHalfScreenFloatingView2 = null;
        }
        Context context = getContext();
        qUSHalfScreenFloatingView2.setQUSDragFloatController(context != null ? new ac4.a(context, this.panelRecyclerView, new b()) : null);
        DailyTitleBarHeaderView dailyTitleBarHeaderView = new DailyTitleBarHeaderView(getContext(), ah.b(Ch()));
        this.headerView = dailyTitleBarHeaderView;
        Intrinsics.checkNotNull(dailyTitleBarHeaderView);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView3 = this.qusHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qusHalfScreenFloatingView");
            qUSHalfScreenFloatingView3 = null;
        }
        dailyTitleBarHeaderView.setHalfScreenView(qUSHalfScreenFloatingView3);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView4 = this.qusHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qusHalfScreenFloatingView");
            qUSHalfScreenFloatingView4 = null;
        }
        qUSHalfScreenFloatingView4.setHeaderView(this.headerView);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView5 = this.qusHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qusHalfScreenFloatingView");
        } else {
            qUSHalfScreenFloatingView = qUSHalfScreenFloatingView5;
        }
        qUSHalfScreenFloatingView.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: ac4.b
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                TaskHalfScreenPanelFragment.Nh(TaskHalfScreenPanelFragment.this);
            }
        });
        dg dgVar2 = this.containerLayoutBinding;
        if (dgVar2 != null && (relativeLayout = dgVar2.f419245d) != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: ac4.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TaskHalfScreenPanelFragment.Oh(TaskHalfScreenPanelFragment.this, view);
                }
            });
        }
        I4(1);
    }

    private final void initViewModel() {
        AppInterface appInterface = this.app;
        if (appInterface == null) {
            return;
        }
        ViewModel viewModel = new ViewModelProvider(this, new h.b(appInterface, ZootopiaSource.INSTANCE.g())).get(h.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026temViewModel::class.java]");
        h hVar = (h) viewModel;
        this.viewModel = hVar;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        g gVar = new g(this, activity, hVar, this);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.qusHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qusHalfScreenFloatingView");
            qUSHalfScreenFloatingView = null;
        }
        this.adapter = gVar.n(this.panelRecyclerView, new TaskListController(activity, hVar, qUSHalfScreenFloatingView, ah.b(Ch())));
        gVar.k(this.headerView);
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment
    public void Eh() {
        de deVar = this.panelBinding;
        if (deVar != null) {
            ZplanViewReportHelper zplanViewReportHelper = this.reportHelper;
            RelativeLayout root = deVar.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "it.root");
            zplanViewReportHelper.a(this, root, "pg_zplan_daily_task", Mh());
            VideoReport.reportPgOut(deVar.getRoot());
        }
        super.Eh();
        QLog.d("QUSHalfScreenTaskPanel", 1, "onActivityFinish, clearCache");
        ((IZplanCacheApi) QRoute.api(IZplanCacheApi.class)).clearCache("task_panel_handler");
        ((IZplanCacheApi) QRoute.api(IZplanCacheApi.class)).clearCache("task_panel_external");
    }

    @Override // db4.a
    public void I4(int status) {
        QLog.i("QUSHalfScreenTaskPanel", 1, "updateCardListStatus status = " + status);
        dg dgVar = this.containerLayoutBinding;
        if (dgVar != null) {
            if (status == 1) {
                dgVar.f419243b.setVisibility(0);
                dgVar.f419245d.setVisibility(8);
                dgVar.f419244c.setVisibility(8);
                DailyTitleBarHeaderView dailyTitleBarHeaderView = this.headerView;
                if (dailyTitleBarHeaderView != null) {
                    dailyTitleBarHeaderView.g();
                    return;
                }
                return;
            }
            if (status == 2 || status == 3) {
                dgVar.f419245d.setVisibility(0);
                dgVar.f419243b.setVisibility(8);
                dgVar.f419244c.setVisibility(8);
                DailyTitleBarHeaderView dailyTitleBarHeaderView2 = this.headerView;
                if (dailyTitleBarHeaderView2 != null) {
                    dailyTitleBarHeaderView2.g();
                    return;
                }
                return;
            }
            if (status != 4) {
                QLog.i("QUSHalfScreenTaskPanel", 1, "updateCardListStatus else branch, status = " + status);
                return;
            }
            dgVar.f419244c.setVisibility(0);
            dgVar.f419243b.setVisibility(8);
            dgVar.f419245d.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment
    public String getSubSource() {
        return "";
    }

    @Override // com.tencent.mobileqq.zootopia.api.b
    public boolean onBackPressedEvent() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        RelativeLayout root;
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        QLog.i("QUSHalfScreenTaskPanel", 1, "onConfigurationChanged, requestLayout");
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.qusHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qusHalfScreenFloatingView");
            qUSHalfScreenFloatingView = null;
        }
        qUSHalfScreenFloatingView.L();
        de deVar = this.panelBinding;
        if (deVar != null && (root = deVar.getRoot()) != null) {
            root.requestLayout();
        }
        ne();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.inflater = inflater;
        this.panelBinding = de.g(inflater);
        String b16 = ah.b(Ch());
        ((IZplanCacheApi) QRoute.api(IZplanCacheApi.class)).saveCache("task_panel_external", ZplanCacheComponentType.PARENT_PAGE_HANDLER, b16);
        Lh(b16);
        initView();
        de deVar = this.panelBinding;
        Intrinsics.checkNotNull(deVar);
        return deVar.getRoot();
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Object cache = ((IZplanCacheApi) QRoute.api(IZplanCacheApi.class)).getCache("task_panel_handler", ZplanCacheComponentType.PARENT_PAGE_HANDLER);
        if (cache != null && Intrinsics.areEqual(cache, this)) {
            ((IZplanCacheApi) QRoute.api(IZplanCacheApi.class)).clearCache("task_panel_handler");
        }
        QLog.d("QUSHalfScreenTaskPanel", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.isFirstLoad) {
            QLog.i("QUSHalfScreenTaskPanel", 1, "onResume, request refresh task panel data, gold, portal redDot");
            Qh();
            SimpleEventBus.getInstance().dispatchEvent(new CurrencyUpdateEvent(false));
            ZPlanRedDotManager.f373437a.x();
        }
        this.isFirstLoad = false;
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initViewModel();
    }

    private final Map<String, Object> Mh() {
        Map<String, Object> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ah.b(Ch())));
        mutableMapOf.put("zplan_page_open_source", "avatar_character");
        mutableMapOf.put("zplan_gender", Integer.valueOf(com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.n().getIndex()));
        ZootopiaSource c16 = ag.f373258a.c(Ch());
        if ((c16 != null ? c16.getMainSource() : null) == Source.FetchSilver) {
            mutableMapOf.put("zplan_page_open_source", "pg_zplan_avatar_mall");
        }
        if ((c16 != null ? c16.getMainSource() : null) == Source.BuyButton) {
            mutableMapOf.put("zplan_page_open_source", "avatar_mall_shopping_bag");
        }
        return mutableMapOf;
    }

    @Override // k84.a
    public void ne() {
        QLog.i("QUSHalfScreenTaskPanel", 1, "refreshPageData, request refresh task panel data");
        Qh();
    }

    @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
    public void onShowDefault() {
        QLog.i("QUSHalfScreenTaskPanel", 1, "onShowDefault");
    }

    @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
    public void onShowDefaultStart() {
        QLog.i("QUSHalfScreenTaskPanel", 1, "onShowDefaultStart");
    }

    @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
    public void onShowMin() {
        QLog.i("QUSHalfScreenTaskPanel", 1, "onShowMin");
    }

    @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
    public void onShowMinStart() {
        QLog.i("QUSHalfScreenTaskPanel", 1, "onShowMinStart");
    }

    @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
    public void onShowTotal() {
        QLog.i("QUSHalfScreenTaskPanel", 1, "onShowTotal");
        if (this.isFirstShowTotal) {
            this.isFirstShowTotal = false;
            Qh();
        }
    }

    @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
    public void onShowTotalStart() {
        QLog.i("QUSHalfScreenTaskPanel", 1, "onShowTotalStart");
    }

    @Override // com.tencent.mobileqq.zootopia.api.c
    public boolean J5(KeyEvent event) {
        if (!(event != null && event.getKeyCode() == 4)) {
            return false;
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.qusHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qusHalfScreenFloatingView");
            qUSHalfScreenFloatingView = null;
        }
        qUSHalfScreenFloatingView.t();
        qUSHalfScreenFloatingView.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: ac4.d
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                TaskHalfScreenPanelFragment.Ph(TaskHalfScreenPanelFragment.this);
            }
        });
        return true;
    }
}
