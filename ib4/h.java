package ib4;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.recommend.main.dress.ui.ZplanChangeShowTypeEvent;
import com.tencent.sqshow.zootopia.recommend.main.dress.ui.ZplanDeleteWorkItemEvent;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import n74.bb;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J<\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\tH\u0002J,\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\tH\u0002J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0002J2\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u00042\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014H\u0002J2\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u00042\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014H\u0002J8\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\tJ\"\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lib4/h;", "", "Landroid/content/Context;", "context", "", "id", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TYPE, "pageId", "", "reportMap", "", "o", "map", "k", "j", "y", "Landroid/view/View;", "view", AdMetricTag.EVENT_NAME, "", "l", DomainData.DOMAIN_NAME, "u", ReportConstant.COSTREPORT_PREFIX, "Lfb4/a;", "b", "Lfb4/a;", "repository", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "c", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "dtViewReporter", "Lid3/d;", "d", "Lid3/d;", "dtReportHelper", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f407398a = new h();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final fb4.a repository = new fb4.a(ZootopiaSource.INSTANCE.g());

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final ZplanViewReportHelper dtViewReporter = new ZplanViewReportHelper();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final id3.d dtReportHelper = new id3.d(null, 1, null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"ib4/h$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Liw4/j;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements com.tencent.mobileqq.zootopia.api.e<iw4.j> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f407402d;

        a(String str) {
            this.f407402d = str;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(iw4.j result) {
            Intrinsics.checkNotNullParameter(result, "result");
            kb4.a.g(kb4.a.f411993a, this.f407402d, 4, null, null, 12, null);
            QLog.d("ZPlanCommonSettingHelper", 1, "request success " + result.f408900a);
            QQToast.makeText(BaseApplication.getContext(), 2, BaseApplication.getContext().getResources().getString(R.string.xnx), 0).show();
            SimpleEventBus.getInstance().dispatchEvent(new ZplanChangeShowTypeEvent(this.f407402d, result.f408900a));
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("ZPlanCommonSettingHelper", 1, "request failure " + error + ", message : " + message);
            h.f407398a.y();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"ib4/h$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Liw4/l;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<iw4.l> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f407403d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f407404e;

        b(String str, Map<String, Object> map) {
            this.f407403d = str;
            this.f407404e = map;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(iw4.l result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.d("ZPlanCommonSettingHelper", 1, "delete work Item success " + this.f407403d);
            SimpleEventBus.getInstance().dispatchEvent(new ZplanDeleteWorkItemEvent(this.f407403d));
            QQToast.makeText(BaseApplication.getContext(), 2, BaseApplication.getContext().getResources().getString(R.string.f169802xo4), 0).show();
            h.dtReportHelper.d("ev_zplan_outfit_delete_success", this.f407404e);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("ZPlanCommonSettingHelper", 1, "delete work Item fail " + error + " ," + message + " ");
            id3.d dVar = h.dtReportHelper;
            Map<String, Object> map = this.f407404e;
            map.put("zplan_error_code", Integer.valueOf(error));
            Unit unit = Unit.INSTANCE;
            dVar.d("ev_zplan_outfit_delete_fail", map);
            h.f407398a.y();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"ib4/h$c", "Lib4/a;", "Landroid/view/View;", "view", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TYPE, "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c implements ib4.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f407405a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ActionSheet f407406b;

        c(String str, ActionSheet actionSheet) {
            this.f407405a = str;
            this.f407406b = actionSheet;
        }

        @Override // ib4.a
        public void a(View view, int showType) {
            Intrinsics.checkNotNullParameter(view, "view");
            h.f407398a.j(this.f407405a, showType);
            this.f407406b.dismiss();
        }
    }

    h() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(String id5, int showType) {
        QLog.d("ZPlanCommonSettingHelper", 1, "request changed privacy id: " + id5 + " and showType " + showType);
        repository.l(id5, showType, new a(id5));
    }

    private final void k(String id5, int showType, Map<String, Object> map) {
        map.put("zplan_visible_range", Integer.valueOf(showType));
        repository.m(id5, new b(id5, map));
    }

    private final void o(Context context, final String id5, final int showType, final String pageId, final Map<String, Object> reportMap) {
        Resources resources = context.getResources();
        final QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 0, (String) null, resources.getString(R.string.xny), 0, 0, (DialogInterface.OnClickListener) null, (DialogInterface.OnClickListener) null);
        createCustomDialog.setNegativeButton(resources.getString(R.string.f169768xi0), new DialogInterface.OnClickListener() { // from class: ib4.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                h.p(QQCustomDialog.this, reportMap, dialogInterface, i3);
            }
        });
        createCustomDialog.setPositiveButton(resources.getString(R.string.xkd), new DialogInterface.OnClickListener() { // from class: ib4.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                h.q(id5, showType, reportMap, createCustomDialog, dialogInterface, i3);
            }
        });
        createCustomDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: ib4.g
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                h.r(QQCustomDialog.this, pageId, reportMap, dialogInterface);
            }
        });
        createCustomDialog.setCancelable(true);
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(QQCustomDialog qQCustomDialog, Map reportMap, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(reportMap, "$reportMap");
        f407398a.l(qQCustomDialog.getBtnLeft(), "em_zplan_delete_win_cancel", reportMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(String id5, int i3, Map reportMap, QQCustomDialog qQCustomDialog, DialogInterface dialogInterface, int i16) {
        Intrinsics.checkNotNullParameter(id5, "$id");
        Intrinsics.checkNotNullParameter(reportMap, "$reportMap");
        h hVar = f407398a;
        hVar.k(id5, i3, reportMap);
        hVar.l(qQCustomDialog.getBtnight(), "em_zplan_delete_win_confirm", reportMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(QQCustomDialog dialog, String pageId, Map reportMap, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(pageId, "$pageId");
        Intrinsics.checkNotNullParameter(reportMap, "$reportMap");
        ZplanViewReportHelper zplanViewReportHelper = dtViewReporter;
        Intrinsics.checkNotNullExpressionValue(dialog, "dialog");
        ViewGroup rootView = dialog.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "dialog.rootView");
        zplanViewReportHelper.a(dialog, rootView, pageId, reportMap);
        h hVar = f407398a;
        hVar.n(dialog.getBtnLeft(), "em_zplan_delete_win_cancel", reportMap);
        hVar.n(dialog.getBtnight(), "em_zplan_delete_win_confirm", reportMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(ActionSheet actionSheet, String pageId, Map reportMap, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        Intrinsics.checkNotNullParameter(pageId, "$pageId");
        Intrinsics.checkNotNullParameter(reportMap, "$reportMap");
        ZplanViewReportHelper zplanViewReportHelper = dtViewReporter;
        ViewGroup rootView = actionSheet.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "actionSheet.rootView");
        zplanViewReportHelper.a(actionSheet, rootView, pageId, reportMap);
        h hVar = f407398a;
        ActionSheet.ItemViewHolder itemViewById = actionSheet.getItemViewById(0);
        hVar.n(itemViewById != null ? itemViewById.titleTv : null, "em_zplan_privacy_visible", reportMap);
        ActionSheet.ItemViewHolder itemViewById2 = actionSheet.getItemViewById(1);
        hVar.n(itemViewById2 != null ? itemViewById2.titleTv : null, "em_zplan_delete", reportMap);
        hVar.n(actionSheet.mContentContainer.findViewById(R.id.action_sheet_btnCancel), "em_zplan_privacy_cancel", reportMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(Map reportMap, ActionSheet actionSheet, Context context, String id5, int i3, String pageId, View view, int i16) {
        Intrinsics.checkNotNullParameter(reportMap, "$reportMap");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        Intrinsics.checkNotNullParameter(id5, "$id");
        Intrinsics.checkNotNullParameter(pageId, "$pageId");
        if (i16 == 0) {
            h hVar = f407398a;
            hVar.l(view, "em_zplan_privacy_visible", reportMap);
            actionSheet.dismiss();
            hVar.s(context, id5, i3);
            return;
        }
        if (i16 != 1) {
            return;
        }
        h hVar2 = f407398a;
        hVar2.l(view, "em_zplan_delete", reportMap);
        actionSheet.dismiss();
        hVar2.o(context, id5, i3, pageId, reportMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(ActionSheet actionSheet, View view) {
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        m(f407398a, view, "em_zplan_privacy_cancel", null, 4, null);
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        QQToast.makeText(BaseApplication.getContext(), 1, BaseApplication.getContext().getResources().getString(!NetworkUtil.isNetworkAvailable(BaseApplication.getContext()) ? R.string.xtn : R.string.xtm), 0).show();
    }

    public final void s(Context context, String id5, int showType) {
        List listOf;
        Intrinsics.checkNotNullParameter(id5, "id");
        if (context == null) {
            return;
        }
        Dialog createDialog = ActionSheetHelper.createDialog(context, null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        ActionSheet actionSheet = (ActionSheet) createDialog;
        bb g16 = bb.g(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n            Lay\u2026r.from(context)\n        )");
        boolean z16 = showType == 1;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ZplanPrivacyData[]{new ZplanPrivacyData(R.drawable.igf, R.string.xsj, 1, z16), new ZplanPrivacyData(R.drawable.igg, R.string.xsk, 2, !z16)});
        actionSheet.setActionContentView(g16.getRoot(), null);
        RecyclerView recyclerView = g16.f418811d;
        recyclerView.setAdapter(new k(listOf, new c(id5, actionSheet)));
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        actionSheet.setCanceledOnTouchOutside(true);
        actionSheet.setCancelable(true);
        actionSheet.setOutsideDismissEnableCompat(true);
        actionSheet.show();
    }

    public final void u(final Context context, final String id5, final int showType, final Map<String, Object> reportMap) {
        String str;
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(reportMap, "reportMap");
        if (context == null) {
            return;
        }
        Dialog createDialog = ActionSheetHelper.createDialog(context, null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.addButton(R.string.xo6);
        actionSheet.addButton(R.string.f169801xo3);
        actionSheet.addCancelButton(R.string.f169798xo0);
        Object remove = reportMap.remove("dt_pgid");
        if (remove == null || (str = remove.toString()) == null) {
            str = "";
        }
        final String str2 = str;
        actionSheet.setOnShowListener(new DialogInterface.OnShowListener() { // from class: ib4.b
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                h.v(ActionSheet.this, str2, reportMap, dialogInterface);
            }
        });
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: ib4.c
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                h.w(reportMap, actionSheet, context, id5, showType, str2, view, i3);
            }
        });
        actionSheet.setOnBottomCancelListener(new View.OnClickListener() { // from class: ib4.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.x(ActionSheet.this, view);
            }
        });
        actionSheet.show();
    }

    private final void l(View view, String eventName, Map<String, ? extends Object> reportMap) {
        if (view == null) {
            return;
        }
        dtViewReporter.e(view, eventName, reportMap);
    }

    private final void n(View view, String eventName, Map<String, ? extends Object> reportMap) {
        if (view == null) {
            return;
        }
        dtViewReporter.g(view, eventName, (r16 & 4) != 0 ? null : reportMap, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void m(h hVar, View view, String str, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        hVar.l(view, str, map);
    }

    public static /* synthetic */ void t(h hVar, Context context, String str, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 1;
        }
        hVar.s(context, str, i3);
    }
}
