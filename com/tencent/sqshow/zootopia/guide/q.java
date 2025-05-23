package com.tencent.sqshow.zootopia.guide;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.guide.i;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.state.report.SquareReportConst;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004J0\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\fJ\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/sqshow/zootopia/guide/q;", "", "Landroid/view/View;", "view", "Lpv4/f;", "status", "Lcom/tencent/sqshow/zootopia/guide/h;", "j", "guideStatus", "k", "Landroid/content/Context;", "context", "", "sourceId", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "step", "Landroid/app/Dialog;", "e", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "l", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final q f370741a = new q();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/sqshow/zootopia/guide/q$a", "Lcom/tencent/sqshow/zootopia/guide/h;", "", "show", "", "dismiss", "", "getId", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ pv4.f f370742a;

        a(pv4.f fVar) {
            this.f370742a = fVar;
        }

        @Override // com.tencent.sqshow.zootopia.guide.h
        public void dismiss() {
            SimpleEventBus.getInstance().dispatchEvent(new ZplanGuideVisibilityChangedEvent(this.f370742a.f427598b, false));
            QLog.d("ZplanGuideUtils", 1, "dismiss " + this.f370742a);
        }

        @Override // com.tencent.sqshow.zootopia.guide.h
        public int getId() {
            return this.f370742a.f427598b;
        }

        @Override // com.tencent.sqshow.zootopia.guide.h
        public boolean show() {
            SimpleEventBus.getInstance().dispatchEvent(new ZplanGuideVisibilityChangedEvent(this.f370742a.f427598b, true));
            QLog.d("ZplanGuideUtils", 1, "show  " + this.f370742a);
            return true;
        }
    }

    q() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Dialog dialog, ZplanViewReportHelper reportHelper, TextView continueGuide, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(reportHelper, "$reportHelper");
        QLog.d("ZplanGuideUtils", 1, "continue guide");
        dialog.dismiss();
        Intrinsics.checkNotNullExpressionValue(continueGuide, "continueGuide");
        ZplanViewReportHelper.f(reportHelper, continueGuide, "em_zplan_continue", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(int i3, pv4.f guideStatus, int i16, ZplanViewReportHelper reportHelper, TextView skipCurrentGuide, Dialog dialog, View view) {
        Intrinsics.checkNotNullParameter(guideStatus, "$guideStatus");
        Intrinsics.checkNotNullParameter(reportHelper, "$reportHelper");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        QLog.d("ZplanGuideUtils", 1, " skip currentTask " + i3 + " " + guideStatus);
        i.a.c(ZplanGuideManager.INSTANCE.a(), i3, guideStatus.f427598b, i16, false, 8, null);
        Intrinsics.checkNotNullExpressionValue(skipCurrentGuide, "skipCurrentGuide");
        ZplanViewReportHelper.f(reportHelper, skipCurrentGuide, "em_zplan_skip_cur_guide", null, 4, null);
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(int i3, pv4.f guideStatus, int i16, ZplanViewReportHelper reportHelper, TextView skipAllGuide, Dialog dialog, View view) {
        Intrinsics.checkNotNullParameter(guideStatus, "$guideStatus");
        Intrinsics.checkNotNullParameter(reportHelper, "$reportHelper");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        QLog.d("ZplanGuideUtils", 1, "skip all guide task");
        ZplanGuideManager.INSTANCE.a().c(i3, guideStatus.f427598b, i16, true);
        Intrinsics.checkNotNullExpressionValue(skipAllGuide, "skipAllGuide");
        ZplanViewReportHelper.f(reportHelper, skipAllGuide, "em_zplan_skip_all_guide", null, 4, null);
        dialog.dismiss();
    }

    public final h j(View view, pv4.f status) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(status, "status");
        k kVar = new k(view, status, R.layout.dct, R.string.xpv);
        int c16 = kVar.c();
        int b16 = kVar.b();
        kVar.f(view.getWidth() - c16);
        kVar.g(((-view.getHeight()) - b16) - com.tencent.sqshow.zootopia.utils.i.b(4));
        QLog.d("ZplanGuideUtils", 1, " getSameStyleTask  " + c16 + " : :" + b16 + " " + view.getWidth() + ProgressTracer.SEPARATOR + view.getHeight());
        return kVar;
    }

    public final h k(pv4.f guideStatus) {
        Intrinsics.checkNotNullParameter(guideStatus, "guideStatus");
        return new a(guideStatus);
    }

    public final void l() {
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setLong(currentUin + "_zplan_create_role_guide_click_time", System.currentTimeMillis());
    }

    public final boolean m() {
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        IZPlanMMKVApi iZPlanMMKVApi = (IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(currentUin);
        sb5.append("_zplan_create_role_guide_click_time");
        return iZPlanMMKVApi.getLong(sb5.toString(), 0L) == 0;
    }

    public final Dialog e(Context context, final pv4.f guideStatus, final int sourceId, final ZootopiaSource sourceCurrent, final int step) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(guideStatus, "guideStatus");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        final Dialog dialog = new Dialog(context, R.style.qZoneInputDialog);
        dialog.setContentView(R.layout.dcq);
        final View findViewById = dialog.findViewById(R.id.pps);
        final TextView continueGuide = (TextView) dialog.findViewById(R.id.f163651r93);
        final TextView skipCurrentGuide = (TextView) dialog.findViewById(R.id.r8i);
        final TextView skipAllGuide = (TextView) dialog.findViewById(R.id.r8h);
        final ZplanViewReportHelper zplanViewReportHelper = new ZplanViewReportHelper();
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.sqshow.zootopia.guide.m
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                q.f(pv4.f.this, step, sourceCurrent, zplanViewReportHelper, dialog, findViewById, continueGuide, skipCurrentGuide, skipAllGuide, dialogInterface);
            }
        });
        Intrinsics.checkNotNullExpressionValue(continueGuide, "continueGuide");
        aa.d(continueGuide, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.guide.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q.g(dialog, zplanViewReportHelper, continueGuide, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(skipCurrentGuide, "skipCurrentGuide");
        aa.d(skipCurrentGuide, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.guide.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q.h(sourceId, guideStatus, step, zplanViewReportHelper, skipCurrentGuide, dialog, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(skipAllGuide, "skipAllGuide");
        aa.d(skipAllGuide, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.guide.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q.i(sourceId, guideStatus, step, zplanViewReportHelper, skipAllGuide, dialog, view);
            }
        });
        return dialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(pv4.f guideStatus, int i3, ZootopiaSource sourceCurrent, ZplanViewReportHelper reportHelper, Dialog dialog, View rootView, TextView continueGuide, TextView skipCurrentGuide, TextView skipAllGuide, DialogInterface dialogInterface) {
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(guideStatus, "$guideStatus");
        Intrinsics.checkNotNullParameter(sourceCurrent, "$sourceCurrent");
        Intrinsics.checkNotNullParameter(reportHelper, "$reportHelper");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_step_group", Integer.valueOf(guideStatus.f427598b)), TuplesKt.to("zplan_step_id", Integer.valueOf(i3)), TuplesKt.to(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ah.b(sourceCurrent)));
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        reportHelper.a(dialog, rootView, "pg_zplan_guide_exit", mutableMapOf);
        QLog.d("ZplanGuideUtils", 1, "dialog showed");
        Intrinsics.checkNotNullExpressionValue(continueGuide, "continueGuide");
        reportHelper.g(continueGuide, "em_zplan_continue", (r16 & 4) != 0 ? null : mutableMapOf, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        Intrinsics.checkNotNullExpressionValue(skipCurrentGuide, "skipCurrentGuide");
        reportHelper.g(skipCurrentGuide, "em_zplan_skip_cur_guide", (r16 & 4) != 0 ? null : mutableMapOf, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        Intrinsics.checkNotNullExpressionValue(skipAllGuide, "skipAllGuide");
        reportHelper.g(skipAllGuide, "em_zplan_skip_all_guide", (r16 & 4) != 0 ? null : mutableMapOf, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }
}
