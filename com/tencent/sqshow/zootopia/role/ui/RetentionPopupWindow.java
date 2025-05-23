package com.tencent.sqshow.zootopia.role.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.utils.featureswitch.model.CreateRoleRetentionConfig;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 52\u00020\u0001:\u0001\rB=\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0013\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0014\u0010\b\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0014\u0010\t\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0014\u0010\n\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\u000b\u001a\u00020\u0002R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u001b\u0010(\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R#\u0010.\u001a\n **\u0004\u0018\u00010)0)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010%\u001a\u0004\b,\u0010-R#\u00103\u001a\n **\u0004\u0018\u00010/0/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u0010%\u001a\u0004\b1\u00102R#\u00106\u001a\n **\u0004\u0018\u00010/0/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u0010%\u001a\u0004\b5\u00102R\u001b\u0010:\u001a\u0002078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u0010%\u001a\u0004\b8\u00109\u00a8\u0006="}, d2 = {"Lcom/tencent/sqshow/zootopia/role/ui/RetentionPopupWindow;", "", "", "r", ReportConstant.COSTREPORT_PREFIX, "Landroid/view/View;", "", "elementId", "u", "v", "t", "w", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "b", "Landroid/view/View;", "logicParentView", "Lcom/tencent/sqshow/utils/featureswitch/model/b;", "c", "Lcom/tencent/sqshow/utils/featureswitch/model/b;", "retentionConfig", "Lkotlin/Function0;", "d", "Lkotlin/jvm/functions/Function0;", "closeWindowInvoker", "e", "randomCreateInvoker", "Landroid/content/DialogInterface$OnClickListener;", "f", "Landroid/content/DialogInterface$OnClickListener;", "closeWindowInvokerWrapper", "g", "randomCreateInvokerWrapper", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", tl.h.F, "Lkotlin/Lazy;", "o", "()Lcom/tencent/mobileqq/utils/QQCustomDialog;", "realDialogWindow", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "i", DomainData.DOMAIN_NAME, "()Landroid/view/ViewGroup;", "dialogRootView", "Landroid/widget/TextView;", "j", "l", "()Landroid/widget/TextView;", "dialogCloseView", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "dialogCreateView", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "p", "()Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "reporter", "<init>", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/sqshow/utils/featureswitch/model/b;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class RetentionPopupWindow {

    /* renamed from: m, reason: collision with root package name */
    private static final a f372780m = new a(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final View logicParentView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final CreateRoleRetentionConfig retentionConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Function0<Unit> closeWindowInvoker;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Function0<Unit> randomCreateInvoker;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final DialogInterface.OnClickListener closeWindowInvokerWrapper;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final DialogInterface.OnClickListener randomCreateInvokerWrapper;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy realDialogWindow;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy dialogRootView;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final Lazy dialogCloseView;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final Lazy dialogCreateView;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final Lazy reporter;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/sqshow/zootopia/role/ui/RetentionPopupWindow$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    public RetentionPopupWindow(Context context, View logicParentView, CreateRoleRetentionConfig retentionConfig, Function0<Unit> closeWindowInvoker, Function0<Unit> randomCreateInvoker) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(logicParentView, "logicParentView");
        Intrinsics.checkNotNullParameter(retentionConfig, "retentionConfig");
        Intrinsics.checkNotNullParameter(closeWindowInvoker, "closeWindowInvoker");
        Intrinsics.checkNotNullParameter(randomCreateInvoker, "randomCreateInvoker");
        this.context = context;
        this.logicParentView = logicParentView;
        this.retentionConfig = retentionConfig;
        this.closeWindowInvoker = closeWindowInvoker;
        this.randomCreateInvoker = randomCreateInvoker;
        this.closeWindowInvokerWrapper = new DialogInterface.OnClickListener() { // from class: com.tencent.sqshow.zootopia.role.ui.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                RetentionPopupWindow.k(RetentionPopupWindow.this, dialogInterface, i3);
            }
        };
        this.randomCreateInvokerWrapper = new DialogInterface.OnClickListener() { // from class: com.tencent.sqshow.zootopia.role.ui.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                RetentionPopupWindow.q(RetentionPopupWindow.this, dialogInterface, i3);
            }
        };
        lazy = LazyKt__LazyJVMKt.lazy(new RetentionPopupWindow$realDialogWindow$2(this));
        this.realDialogWindow = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ViewGroup>() { // from class: com.tencent.sqshow.zootopia.role.ui.RetentionPopupWindow$dialogRootView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewGroup invoke() {
                QQCustomDialog o16;
                o16 = RetentionPopupWindow.this.o();
                return o16.getRootView();
            }
        });
        this.dialogRootView = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.sqshow.zootopia.role.ui.RetentionPopupWindow$dialogCloseView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                QQCustomDialog o16;
                o16 = RetentionPopupWindow.this.o();
                return o16.getBtnLeft();
            }
        });
        this.dialogCloseView = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.sqshow.zootopia.role.ui.RetentionPopupWindow$dialogCreateView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                QQCustomDialog o16;
                o16 = RetentionPopupWindow.this.o();
                return o16.getBtnight();
            }
        });
        this.dialogCreateView = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<ZplanViewReportHelper>() { // from class: com.tencent.sqshow.zootopia.role.ui.RetentionPopupWindow$reporter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZplanViewReportHelper invoke() {
                ViewGroup n3;
                View view;
                ZplanViewReportHelper zplanViewReportHelper = new ZplanViewReportHelper();
                RetentionPopupWindow retentionPopupWindow = RetentionPopupWindow.this;
                n3 = retentionPopupWindow.n();
                view = retentionPopupWindow.logicParentView;
                VideoReport.setLogicParent(n3, view);
                return zplanViewReportHelper;
            }
        });
        this.reporter = lazy5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(RetentionPopupWindow this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView dialogCloseView = this$0.l();
        Intrinsics.checkNotNullExpressionValue(dialogCloseView, "dialogCloseView");
        this$0.t(dialogCloseView, "em_zplan_retention_pop_quit");
        this$0.closeWindowInvoker.invoke();
    }

    private final TextView l() {
        return (TextView) this.dialogCloseView.getValue();
    }

    private final TextView m() {
        return (TextView) this.dialogCreateView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewGroup n() {
        return (ViewGroup) this.dialogRootView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQCustomDialog o() {
        Object value = this.realDialogWindow.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-realDialogWindow>(...)");
        return (QQCustomDialog) value;
    }

    private final ZplanViewReportHelper p() {
        return (ZplanViewReportHelper) this.reporter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(RetentionPopupWindow this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView dialogCreateView = this$0.m();
        Intrinsics.checkNotNullExpressionValue(dialogCreateView, "dialogCreateView");
        this$0.t(dialogCreateView, "em_zplan_retention_pop_create");
        this$0.randomCreateInvoker.invoke();
    }

    private final void r() {
        QLog.i("RetentionPopupWindow", 1, "reportAllElementImp, " + this);
        ViewGroup dialogRootView = n();
        Intrinsics.checkNotNullExpressionValue(dialogRootView, "dialogRootView");
        u(dialogRootView, "em_zplan_retention_pop");
        TextView dialogCloseView = l();
        Intrinsics.checkNotNullExpressionValue(dialogCloseView, "dialogCloseView");
        u(dialogCloseView, "em_zplan_retention_pop_quit");
        TextView dialogCreateView = m();
        Intrinsics.checkNotNullExpressionValue(dialogCreateView, "dialogCreateView");
        u(dialogCreateView, "em_zplan_retention_pop_create");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s() {
        QLog.i("RetentionPopupWindow", 1, "reportAllElementImpEnd, " + this);
        ViewGroup dialogRootView = n();
        Intrinsics.checkNotNullExpressionValue(dialogRootView, "dialogRootView");
        v(dialogRootView, "em_zplan_retention_pop");
        TextView dialogCloseView = l();
        Intrinsics.checkNotNullExpressionValue(dialogCloseView, "dialogCloseView");
        v(dialogCloseView, "em_zplan_retention_pop_quit");
        TextView dialogCreateView = m();
        Intrinsics.checkNotNullExpressionValue(dialogCreateView, "dialogCreateView");
        v(dialogCreateView, "em_zplan_retention_pop_create");
    }

    private final void t(View view, String str) {
        Map<String, ? extends Object> emptyMap;
        QLog.i("RetentionPopupWindow", 1, "reportClick, elementId:" + str + ", " + view);
        ZplanViewReportHelper p16 = p();
        emptyMap = MapsKt__MapsKt.emptyMap();
        p16.e(view, str, emptyMap);
    }

    private final void u(View view, String str) {
        Map emptyMap;
        ZplanViewReportHelper p16 = p();
        emptyMap = MapsKt__MapsKt.emptyMap();
        p16.g(view, str, (r16 & 4) != 0 ? null : emptyMap, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    private final void v(View view, String str) {
        Map emptyMap;
        ZplanViewReportHelper p16 = p();
        emptyMap = MapsKt__MapsKt.emptyMap();
        ZplanViewReportHelper.j(p16, view, str, emptyMap, false, null, 16, null);
    }

    public final void w() {
        o().show();
        r();
    }

    public /* synthetic */ RetentionPopupWindow(Context context, View view, CreateRoleRetentionConfig createRoleRetentionConfig, Function0 function0, Function0 function02, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, view, (i3 & 4) != 0 ? ZPlanQQMC.INSTANCE.getCreateRoleRetentionConfig() : createRoleRetentionConfig, function0, function02);
    }
}
