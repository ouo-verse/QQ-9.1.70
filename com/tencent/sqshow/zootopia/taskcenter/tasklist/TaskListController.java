package com.tencent.sqshow.zootopia.taskcenter.tasklist;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.adv.web.RewardType;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.data.ZootopiaTaskItemData;
import com.tencent.sqshow.zootopia.utils.x;
import com.tencent.state.report.SquareReportConst;
import com.tencent.util.QQToastUtil;
import com.tencent.util.URLUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import t74.o;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 92\u00020\u0001:\u0003\u001a\u001e\"B)\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\b\u0010$\u001a\u0004\u0018\u00010!\u0012\u0006\u0010'\u001a\u00020\u0002\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eJ\u0016\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\fJ2\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\"\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0013j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001`\u0014J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\fR\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u0004\u0018\u00010!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R>\u0010.\u001a*\u0012&\u0012$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0013j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001`\u00140+0*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u00100R\u0014\u00104\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u00103R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u00103R\u0014\u00106\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u00103\u00a8\u0006:"}, d2 = {"Lcom/tencent/sqshow/zootopia/taskcenter/tasklist/TaskListController;", "", "", "schemeUrl", "", "r", "", DomainData.DOMAIN_NAME, "", "Lcom/tencent/sqshow/zootopia/data/v;", "listData", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "i", "Landroid/view/View;", "view", h.F, "position", "g", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "map", "p", "Lcom/tencent/sqshow/zootopia/taskcenter/tasklist/TaskListController$b;", "j", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Ldc4/h;", "b", "Ldc4/h;", "viewModel", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "c", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "qusHalfScreenFloatingView", "d", "Ljava/lang/String;", "sourceId", "e", "Ljava/util/List;", "", "Lkotlin/Lazy;", "f", "[Lkotlin/Lazy;", "listDataReportMaps", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "reportHelper", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "noCompleteDrawable", "receiveDrawable", "receivedDrawable", "<init>", "(Landroid/app/Activity;Ldc4/h;Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;Ljava/lang/String;)V", "k", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class TaskListController {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final dc4.h viewModel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final QUSHalfScreenFloatingView qusHalfScreenFloatingView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String sourceId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private List<ZootopiaTaskItemData> listData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Lazy<HashMap<String, Object>>[] listDataReportMaps;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private ZplanViewReportHelper reportHelper;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Drawable noCompleteDrawable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Drawable receiveDrawable;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final Drawable receivedDrawable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/taskcenter/tasklist/TaskListController$d", "Lt74/o$b;", "", "success", "", "b", "profitable", "c", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements o.b {
        d() {
        }

        @Override // t74.o.b
        public void a(boolean success) {
            QLog.i("TaskListController", 1, "onReportResult " + success);
            QQToastUtil.showQQToastInUiThread(2, TaskListController.this.activity.getString(R.string.xkn));
            TaskListController.this.viewModel.P1();
        }

        @Override // t74.o.b
        public void b(boolean success) {
            QLog.i("TaskListController", 1, "onRequestResult " + success);
            if (success) {
                return;
            }
            QQToastUtil.showQQToastInUiThread(0, TaskListController.this.activity.getString(R.string.xs_));
        }

        @Override // t74.o.b
        public void c(boolean profitable) {
            QLog.i("TaskListController", 1, "onShowResult " + profitable);
        }
    }

    public TaskListController(Activity activity, dc4.h viewModel, QUSHalfScreenFloatingView qUSHalfScreenFloatingView, String sourceId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(sourceId, "sourceId");
        this.activity = activity;
        this.viewModel = viewModel;
        this.qusHalfScreenFloatingView = qUSHalfScreenFloatingView;
        this.sourceId = sourceId;
        this.listData = new ArrayList();
        this.listDataReportMaps = new Lazy[0];
        this.reportHelper = new ZplanViewReportHelper();
        Drawable drawable = activity.getResources().getDrawable(R.drawable.h16);
        Intrinsics.checkNotNullExpressionValue(drawable, "activity.resources.getDr\u2026task_item_btn_receive_bg)");
        this.noCompleteDrawable = drawable;
        Drawable drawable2 = activity.getResources().getDrawable(R.drawable.f159856h15);
        Intrinsics.checkNotNullExpressionValue(drawable2, "activity.resources.getDr\u2026ia_task_item_btn_jump_bg)");
        this.receiveDrawable = drawable2;
        Drawable drawable3 = activity.getResources().getDrawable(R.drawable.h17);
        Intrinsics.checkNotNullExpressionValue(drawable3, "activity.resources.getDr\u2026ask_item_btn_received_bg)");
        this.receivedDrawable = drawable3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(TaskListController this$0, HashMap map, ZootopiaTaskItemData itemData, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(map, "$map");
        Intrinsics.checkNotNullParameter(itemData, "$itemData");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.p(it, map);
        String questJumpSchema = itemData.getQuestJumpSchema();
        if (questJumpSchema != null) {
            this$0.n(questJumpSchema);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(TaskListController this$0, HashMap map, ZootopiaTaskItemData itemData, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(map, "$map");
        Intrinsics.checkNotNullParameter(itemData, "$itemData");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.p(it, map);
        bc4.c.f28271a.b(this$0.activity, itemData.k(), 2, itemData.getQuestId());
    }

    private final void n(String schemeUrl) {
        if (!r(schemeUrl)) {
            ((ISchemeApi) QRoute.api(ISchemeApi.class)).launchScheme(this.activity, schemeUrl);
        }
        x xVar = x.f373307a;
        String b16 = xVar.b(xVar.a(schemeUrl, ISchemeApi.KEY_PAGE_DATA), "closeTaskPanelAfterJump", "0");
        QLog.i("TaskListController", 1, "handleJump, schemeStayValue: " + b16);
        if (Intrinsics.areEqual(b16, "1")) {
            QLog.i("TaskListController", 1, "handleJump, close task panel after jump");
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.sqshow.zootopia.taskcenter.tasklist.e
                @Override // java.lang.Runnable
                public final void run() {
                    TaskListController.o(TaskListController.this);
                }
            }, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(TaskListController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this$0.qusHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView != null) {
            qUSHalfScreenFloatingView.t();
        }
    }

    private final boolean r(String schemeUrl) {
        Map<String, String> argumentsFromURL = URLUtil.getArgumentsFromURL(schemeUrl);
        Intrinsics.checkNotNullExpressionValue(argumentsFromURL, "getArgumentsFromURL(schemeUrl)");
        if (!Intrinsics.areEqual(argumentsFromURL.get("is_native_ad"), "1")) {
            return false;
        }
        try {
            String str = argumentsFromURL.get(CGNonAgeReport.EVENT_TYPE);
            if (str == null) {
                return false;
            }
            int parseInt = Integer.parseInt(str);
            o oVar = new o();
            oVar.o(new d());
            Activity activity = this.activity;
            int value = RewardType.SUPER_SHOW.getValue();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uin", MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin());
            jSONObject.put(CGNonAgeReport.EVENT_TYPE, parseInt);
            Unit unit = Unit.INSTANCE;
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026ype)\n        }.toString()");
            o.m(oVar, activity, value, jSONObject2, 0, 8, null);
            return true;
        } catch (NumberFormatException e16) {
            QLog.e("TaskListController", 1, e16.toString());
            return false;
        }
    }

    public final void g(View view, int position) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setVisibility(0);
        this.reportHelper.g(view, "em_zplan_task_btn", (r16 & 4) != 0 ? null : this.listDataReportMaps[position].getValue(), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    public final void h(View view) {
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(view, "view");
        ZplanViewReportHelper zplanViewReportHelper = this.reportHelper;
        Activity activity = this.activity;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, this.sourceId));
        zplanViewReportHelper.a(activity, view, "pg_zplan_daily_task", mutableMapOf);
    }

    public final int i() {
        return this.listData.size();
    }

    public final TaskParams j(int position) {
        TaskViewParams taskViewParams;
        TaskViewParams taskViewParams2;
        final ZootopiaTaskItemData zootopiaTaskItemData = this.listData.get(position);
        final HashMap<String, Object> value = this.listDataReportMaps[position].getValue();
        int questStatus = zootopiaTaskItemData.getQuestStatus();
        if (questStatus == 0 || questStatus == 1 || questStatus == 2) {
            taskViewParams = new TaskViewParams(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.taskcenter.tasklist.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TaskListController.k(TaskListController.this, value, zootopiaTaskItemData, view);
                }
            }, this.receiveDrawable, 1.0f);
        } else {
            if (questStatus != 3) {
                taskViewParams2 = questStatus != 4 ? null : new TaskViewParams(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.taskcenter.tasklist.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TaskListController.m(view);
                    }
                }, this.receivedDrawable, 0.6f);
                return new TaskParams(zootopiaTaskItemData, taskViewParams2);
            }
            taskViewParams = new TaskViewParams(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.taskcenter.tasklist.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TaskListController.l(TaskListController.this, value, zootopiaTaskItemData, view);
                }
            }, this.noCompleteDrawable, 1.0f);
        }
        taskViewParams2 = taskViewParams;
        return new TaskParams(zootopiaTaskItemData, taskViewParams2);
    }

    public final void p(View view, HashMap<String, Object> map) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(map, "map");
        this.reportHelper.e(view, "em_zplan_task_btn", map);
    }

    public final void q(List<ZootopiaTaskItemData> listData) {
        int collectionSizeOrDefault;
        Lazy lazy;
        Intrinsics.checkNotNullParameter(listData, "listData");
        if (this.listData != listData) {
            this.listData = listData;
            List<ZootopiaTaskItemData> list = listData;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (final ZootopiaTaskItemData zootopiaTaskItemData : list) {
                lazy = LazyKt__LazyJVMKt.lazy(new Function0<HashMap<String, Object>>() { // from class: com.tencent.sqshow.zootopia.taskcenter.tasklist.TaskListController$setListData$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final HashMap<String, Object> invoke() {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        ZootopiaTaskItemData zootopiaTaskItemData2 = ZootopiaTaskItemData.this;
                        hashMap.put("zplan_task_status", Integer.valueOf(zootopiaTaskItemData2.getQuestStatus()));
                        hashMap.put(SquareReportConst.Key.KEY_ZPLAN_TASK_ID, Long.valueOf(zootopiaTaskItemData2.getQuestId()));
                        return hashMap;
                    }
                });
                arrayList.add(lazy);
            }
            Object[] array = arrayList.toArray(new Lazy[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            this.listDataReportMaps = (Lazy[]) array;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/sqshow/zootopia/taskcenter/tasklist/TaskListController$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/sqshow/zootopia/data/v;", "a", "Lcom/tencent/sqshow/zootopia/data/v;", "()Lcom/tencent/sqshow/zootopia/data/v;", "itemData", "Lcom/tencent/sqshow/zootopia/taskcenter/tasklist/TaskListController$c;", "b", "Lcom/tencent/sqshow/zootopia/taskcenter/tasklist/TaskListController$c;", "()Lcom/tencent/sqshow/zootopia/taskcenter/tasklist/TaskListController$c;", "taskViewParams", "<init>", "(Lcom/tencent/sqshow/zootopia/data/v;Lcom/tencent/sqshow/zootopia/taskcenter/tasklist/TaskListController$c;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.taskcenter.tasklist.TaskListController$b, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class TaskParams {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final ZootopiaTaskItemData itemData;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final TaskViewParams taskViewParams;

        public TaskParams(ZootopiaTaskItemData itemData, TaskViewParams taskViewParams) {
            Intrinsics.checkNotNullParameter(itemData, "itemData");
            this.itemData = itemData;
            this.taskViewParams = taskViewParams;
        }

        /* renamed from: a, reason: from getter */
        public final ZootopiaTaskItemData getItemData() {
            return this.itemData;
        }

        /* renamed from: b, reason: from getter */
        public final TaskViewParams getTaskViewParams() {
            return this.taskViewParams;
        }

        public int hashCode() {
            int hashCode = this.itemData.hashCode() * 31;
            TaskViewParams taskViewParams = this.taskViewParams;
            return hashCode + (taskViewParams == null ? 0 : taskViewParams.hashCode());
        }

        public String toString() {
            return "TaskParams(itemData=" + this.itemData + ", taskViewParams=" + this.taskViewParams + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TaskParams)) {
                return false;
            }
            TaskParams taskParams = (TaskParams) other;
            return Intrinsics.areEqual(this.itemData, taskParams.itemData) && Intrinsics.areEqual(this.taskViewParams, taskParams.taskViewParams);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\n\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/sqshow/zootopia/taskcenter/tasklist/TaskListController$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/view/View$OnClickListener;", "a", "Landroid/view/View$OnClickListener;", "c", "()Landroid/view/View$OnClickListener;", "clickListener", "Landroid/graphics/drawable/Drawable;", "b", "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", "backgroundDrawable", "", UserInfo.SEX_FEMALE, "()F", com.tencent.luggage.wxa.c8.c.f123400v, "<init>", "(Landroid/view/View$OnClickListener;Landroid/graphics/drawable/Drawable;F)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.taskcenter.tasklist.TaskListController$c, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class TaskViewParams {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final View.OnClickListener clickListener;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final Drawable backgroundDrawable;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final float alpha;

        public TaskViewParams(View.OnClickListener clickListener, Drawable backgroundDrawable, float f16) {
            Intrinsics.checkNotNullParameter(clickListener, "clickListener");
            Intrinsics.checkNotNullParameter(backgroundDrawable, "backgroundDrawable");
            this.clickListener = clickListener;
            this.backgroundDrawable = backgroundDrawable;
            this.alpha = f16;
        }

        /* renamed from: a, reason: from getter */
        public final float getAlpha() {
            return this.alpha;
        }

        /* renamed from: b, reason: from getter */
        public final Drawable getBackgroundDrawable() {
            return this.backgroundDrawable;
        }

        /* renamed from: c, reason: from getter */
        public final View.OnClickListener getClickListener() {
            return this.clickListener;
        }

        public int hashCode() {
            return (((this.clickListener.hashCode() * 31) + this.backgroundDrawable.hashCode()) * 31) + Float.floatToIntBits(this.alpha);
        }

        public String toString() {
            return "TaskViewParams(clickListener=" + this.clickListener + ", backgroundDrawable=" + this.backgroundDrawable + ", alpha=" + this.alpha + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TaskViewParams)) {
                return false;
            }
            TaskViewParams taskViewParams = (TaskViewParams) other;
            return Intrinsics.areEqual(this.clickListener, taskViewParams.clickListener) && Intrinsics.areEqual(this.backgroundDrawable, taskViewParams.backgroundDrawable) && Float.compare(this.alpha, taskViewParams.alpha) == 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(View view) {
        QQToastUtil.showQQToast(0, R.string.xvs);
    }
}
