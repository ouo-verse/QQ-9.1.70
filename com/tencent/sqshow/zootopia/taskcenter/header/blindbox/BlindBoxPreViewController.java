package com.tencent.sqshow.zootopia.taskcenter.header.blindbox;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cc4.b;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zplan.api.IZplanCacheApi;
import com.tencent.mobileqq.zplan.api.ZplanCacheComponentType;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.data.ZootopiaTaskBlindBoxData;
import com.tencent.sqshow.zootopia.utils.f;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.utils.v;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import com.tencent.state.report.SquareReportConst;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import n74.dd;
import tl.h;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 U2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001VB\u000f\u0012\u0006\u0010 \u001a\u00020\u001b\u00a2\u0006\u0004\bS\u0010TJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u001a\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0012H\u0016J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010$\u001a\u00020\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010#R\u001b\u0010'\u001a\u00020\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010!\u001a\u0004\b&\u0010#R\u001b\u0010)\u001a\u00020\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010!\u001a\u0004\b(\u0010#R\u001b\u0010+\u001a\u00020\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010!\u001a\u0004\b*\u0010#R\u001a\u00100\u001a\u00020,8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0013\u0010-\u001a\u0004\b.\u0010/R\u001a\u00104\u001a\u00020\t8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u0010#R\u001a\u00107\u001a\u00020\t8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b5\u00102\u001a\u0004\b6\u0010#R\u001a\u0010:\u001a\u00020\t8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b8\u00102\u001a\u0004\b9\u0010#R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010E\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010H\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010GR\u0014\u0010K\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010JR\u0018\u0010N\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010Q\u00a8\u0006W"}, d2 = {"Lcom/tencent/sqshow/zootopia/taskcenter/header/blindbox/BlindBoxPreViewController;", "Lcc4/b;", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/sqshow/zootopia/data/s;", "", "e", "data", h.F, DomainData.DOMAIN_NAME, "", "status", ReportConstant.COSTREPORT_PREFIX, "o", "Landroid/view/View;", "getView", "Lcc4/b$b;", "listener", "b", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "c", "result", "p", "error", "message", "onResultFailure", "r", "Landroid/content/Context;", "d", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lkotlin/Lazy;", "i", "()I", "DP_19", "f", "k", "DP_30", "l", "DP_34", "j", "DP_2", "", "J", "getNUM_1000", "()J", "NUM_1000", BdhLogUtil.LogTag.Tag_Conn, "I", "getSIZE_2", "SIZE_2", "D", "getSIZE_3", "SIZE_3", "E", "getSIZE_4", "SIZE_4", "Ldc4/a;", UserInfo.SEX_FEMALE, "Ldc4/a;", "repository", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "G", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "reportHelper", "H", "Lcc4/b$b;", "dismissListener", "Landroid/view/LayoutInflater;", "Landroid/view/LayoutInflater;", "layoutInflater", "Ln74/dd;", "Ln74/dd;", "binding", "K", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/animation/RotateAnimation;", "L", "Landroid/view/animation/RotateAnimation;", "rotateAnimation", "<init>", "(Landroid/content/Context;)V", "M", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class BlindBoxPreViewController implements cc4.b, e<ZootopiaTaskBlindBoxData> {

    /* renamed from: C, reason: from kotlin metadata */
    private final int SIZE_2;

    /* renamed from: D, reason: from kotlin metadata */
    private final int SIZE_3;

    /* renamed from: E, reason: from kotlin metadata */
    private final int SIZE_4;

    /* renamed from: F, reason: from kotlin metadata */
    private final dc4.a repository;

    /* renamed from: G, reason: from kotlin metadata */
    private final ZplanViewReportHelper reportHelper;

    /* renamed from: H, reason: from kotlin metadata */
    private b.InterfaceC0182b dismissListener;

    /* renamed from: I, reason: from kotlin metadata */
    private final LayoutInflater layoutInflater;

    /* renamed from: J, reason: from kotlin metadata */
    private final dd binding;

    /* renamed from: K, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: L, reason: from kotlin metadata */
    private RotateAnimation rotateAnimation;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy DP_19;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy DP_30;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy DP_34;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy DP_2;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final long NUM_1000;

    public BlindBoxPreViewController(Context context) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.sqshow.zootopia.taskcenter.header.blindbox.BlindBoxPreViewController$DP_19$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(i.a(24.0f));
            }
        });
        this.DP_19 = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.sqshow.zootopia.taskcenter.header.blindbox.BlindBoxPreViewController$DP_30$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(i.a(51.0f));
            }
        });
        this.DP_30 = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.sqshow.zootopia.taskcenter.header.blindbox.BlindBoxPreViewController$DP_34$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(i.a(34.0f));
            }
        });
        this.DP_34 = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.sqshow.zootopia.taskcenter.header.blindbox.BlindBoxPreViewController$DP_2$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(i.a(2.0f));
            }
        });
        this.DP_2 = lazy4;
        this.NUM_1000 = 1000L;
        this.SIZE_2 = 2;
        this.SIZE_3 = 3;
        this.SIZE_4 = 4;
        this.repository = new dc4.b(ZootopiaSource.INSTANCE.g());
        this.reportHelper = new ZplanViewReportHelper();
        LayoutInflater from = LayoutInflater.from(context);
        Intrinsics.checkNotNullExpressionValue(from, "from(context)");
        this.layoutInflater = from;
        dd g16 = dd.g(from);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(layoutInflater)");
        this.binding = g16;
    }

    private final void e() {
        Map<String, Object> mutableMapOf;
        ZplanViewReportHelper zplanViewReportHelper = this.reportHelper;
        Context context = this.context;
        RelativeLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, m()));
        zplanViewReportHelper.a(context, root, "pg_zplan_daily_task", mutableMapOf);
        ZplanViewReportHelper zplanViewReportHelper2 = this.reportHelper;
        ImageView imageView = this.binding.f419220k;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.closeIcon");
        zplanViewReportHelper2.g(imageView, "em_zplan_award_check_btn", (r16 & 4) != 0 ? null : new LinkedHashMap(), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        this.binding.f419222m.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.taskcenter.header.blindbox.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BlindBoxPreViewController.f(BlindBoxPreViewController.this, view);
            }
        });
        this.binding.f419220k.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.taskcenter.header.blindbox.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BlindBoxPreViewController.g(BlindBoxPreViewController.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(BlindBoxPreViewController this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.s(1);
        this$0.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(BlindBoxPreViewController this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZplanViewReportHelper zplanViewReportHelper = this$0.reportHelper;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        zplanViewReportHelper.e(it, "em_zplan_award_check_btn", new LinkedHashMap());
        b.InterfaceC0182b interfaceC0182b = this$0.dismissListener;
        if (interfaceC0182b != null) {
            Intrinsics.checkNotNull(interfaceC0182b);
            interfaceC0182b.dismiss();
        }
    }

    private final void h(ZootopiaTaskBlindBoxData data) {
        n(data);
        GridView gridView = this.binding.f419225p;
        Intrinsics.checkNotNullExpressionValue(gridView, "binding.rewardList");
        ViewGroup.LayoutParams layoutParams = gridView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (data.l().size() % this.SIZE_4 == 0) {
            layoutParams2.leftMargin = k();
            layoutParams2.rightMargin = k();
            gridView.setNumColumns(this.SIZE_2);
            gridView.setHorizontalSpacing(l());
        } else if (data.l().size() > this.SIZE_4) {
            gridView.setNumColumns(this.SIZE_3);
            layoutParams2.leftMargin = i();
            layoutParams2.rightMargin = i();
            gridView.setHorizontalSpacing(j());
        }
        gridView.setLayoutParams(layoutParams2);
        a aVar = new a(this.context);
        gridView.setAdapter((ListAdapter) aVar);
        aVar.setData(data.l());
    }

    private final void n(ZootopiaTaskBlindBoxData data) {
        String str;
        TextView textView = this.binding.f419211b;
        Resources resources = this.context.getResources();
        if (resources != null) {
            f fVar = f.f373268a;
            str = resources.getString(R.string.xvo, fVar.a(data.getBlindBoxStartTime() * 1000, "yyyy/MM/dd"), fVar.a(data.getBlindBoxEndTime() * 1000, "yyyy/MM/dd"));
        } else {
            str = null;
        }
        textView.setText(str);
        this.binding.f419214e.setText(data.getRuleDesc());
    }

    private final void o() {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.rotateAnimation = rotateAnimation;
        Intrinsics.checkNotNull(rotateAnimation);
        rotateAnimation.setRepeatCount(-1);
        RotateAnimation rotateAnimation2 = this.rotateAnimation;
        Intrinsics.checkNotNull(rotateAnimation2);
        rotateAnimation2.setDuration(this.NUM_1000);
        RotateAnimation rotateAnimation3 = this.rotateAnimation;
        Intrinsics.checkNotNull(rotateAnimation3);
        rotateAnimation3.setInterpolator(new LinearInterpolator());
        this.binding.f419224o.setAnimation(this.rotateAnimation);
    }

    private final void s(int status) {
        dd ddVar = this.binding;
        if (status == 1) {
            QLog.d("BlindBoxPreViewController", 1, "show loading view");
            ddVar.f419224o.setVisibility(0);
            ddVar.f419222m.setVisibility(4);
            ddVar.f419225p.setVisibility(4);
            ddVar.f419211b.setVisibility(4);
            ddVar.f419215f.setVisibility(4);
            ddVar.f419214e.setVisibility(4);
            ddVar.f419216g.setVisibility(4);
            ddVar.f419217h.setVisibility(4);
            o();
            RotateAnimation rotateAnimation = this.rotateAnimation;
            if (rotateAnimation != null) {
                rotateAnimation.start();
                return;
            }
            return;
        }
        if (status == 2 || status == 3) {
            QLog.d("BlindBoxPreViewController", 1, "empty or null, show error view");
            ddVar.f419224o.setVisibility(4);
            ddVar.f419222m.setVisibility(0);
            ddVar.f419225p.setVisibility(4);
            ddVar.f419211b.setVisibility(4);
            ddVar.f419215f.setVisibility(4);
            ddVar.f419214e.setVisibility(4);
            ddVar.f419216g.setVisibility(4);
            RotateAnimation rotateAnimation2 = this.rotateAnimation;
            if (rotateAnimation2 != null) {
                rotateAnimation2.cancel();
                return;
            }
            return;
        }
        if (status != 4) {
            return;
        }
        ddVar.f419222m.setVisibility(4);
        ddVar.f419225p.setVisibility(0);
        ddVar.f419211b.setVisibility(0);
        ddVar.f419215f.setVisibility(4);
        ddVar.f419214e.setVisibility(0);
        ddVar.f419216g.setVisibility(0);
        QLog.d("BlindBoxPreViewController", 1, "hide loading view");
        RotateAnimation rotateAnimation3 = this.rotateAnimation;
        if (rotateAnimation3 != null) {
            rotateAnimation3.cancel();
        }
        ddVar.f419224o.setVisibility(8);
    }

    @Override // cc4.b
    public void b(b.InterfaceC0182b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.dismissListener = listener;
    }

    @Override // cc4.b
    public void c() {
        this.repository.h(this);
    }

    @Override // cc4.b
    public View getView() {
        if (this.rootView == null) {
            this.rootView = this.binding.getRoot();
            s(1);
            e();
        }
        View view = this.rootView;
        Intrinsics.checkNotNull(view);
        return view;
    }

    public final int i() {
        return ((Number) this.DP_19.getValue()).intValue();
    }

    public final int j() {
        return ((Number) this.DP_2.getValue()).intValue();
    }

    public final int k() {
        return ((Number) this.DP_30.getValue()).intValue();
    }

    public final int l() {
        return ((Number) this.DP_34.getValue()).intValue();
    }

    public String m() {
        Object cache = ((IZplanCacheApi) QRoute.api(IZplanCacheApi.class)).getCache("task_panel_external", ZplanCacheComponentType.PARENT_PAGE_HANDLER);
        String str = cache instanceof String ? (String) cache : null;
        return str == null ? "" : str;
    }

    @Override // cc4.b
    public void onDetachedFromWindow() {
        b.a.a(this);
    }

    @Override // cc4.b
    public void onDismiss() {
        b.a.b(this);
    }

    @Override // com.tencent.mobileqq.zootopia.api.e
    public void onResultFailure(int error, String message) {
        QLog.d("BlindBoxPreViewController", 1, "onResultFailure, error:" + error + ", message" + message);
        v vVar = v.f373305a;
        String string = this.context.getResources().getString(R.string.xvv);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026ystem_network_error_tips)");
        String b16 = vVar.b(error, message, string);
        if (b16 != null) {
            QQToast.makeText(this.context, 0, b16, 0).show();
        }
        q();
        s(2);
    }

    @Override // com.tencent.mobileqq.zootopia.api.e
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onResultSuccess(ZootopiaTaskBlindBoxData result) {
        Intrinsics.checkNotNullParameter(result, "result");
        q();
        r(result);
        QLog.d("BlindBoxPreViewController", 1, "onResultSuccess, result:" + result);
    }

    public void q() {
        b.a.c(this);
    }

    public final void r(ZootopiaTaskBlindBoxData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.binding.f419217h.setVisibility(0);
        t74.f fVar = t74.f.f435541a;
        ZPlanMediaView zPlanMediaView = this.binding.f419217h;
        Intrinsics.checkNotNullExpressionValue(zPlanMediaView, "binding.blindBoxTipsPag");
        fVar.e(zPlanMediaView, "https://zplan-image-1300343094.cos.ap-nanjing.myqcloud.com/task_engine/blind_preview_box.png");
        s(4);
        h(data);
    }
}
