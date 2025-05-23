package com.tencent.sqshow.zootopia.guide;

import android.R;
import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.guide.detail.ZPlanDetailGuideView;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 02\u00020\u0001:\u0001\u0010B\u001f\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\u0006\u0010 \u001a\u00020\u001b\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016R\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR$\u0010'\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001b\u0010-\u001a\u00020(8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\u00a8\u00061"}, d2 = {"Lcom/tencent/sqshow/zootopia/guide/DetailGuideTask;", "Lcom/tencent/sqshow/zootopia/guide/h;", "", DomainData.DOMAIN_NAME, "k", "", "step", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/sqshow/zootopia/guide/detail/ZPlanDetailGuideView;", "i", "g", "", "show", "dismiss", "getId", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", tl.h.F, "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lpv4/f;", "b", "Lpv4/f;", "getNativeGuideStatus", "()Lpv4/f;", "nativeGuideStatus", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "c", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "getSourceCurrent", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "d", "Lcom/tencent/sqshow/zootopia/guide/detail/ZPlanDetailGuideView;", "getGuideView", "()Lcom/tencent/sqshow/zootopia/guide/detail/ZPlanDetailGuideView;", "setGuideView", "(Lcom/tencent/sqshow/zootopia/guide/detail/ZPlanDetailGuideView;)V", "guideView", "Landroid/widget/FrameLayout;", "e", "Lkotlin/Lazy;", "j", "()Landroid/widget/FrameLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Landroid/app/Activity;Lpv4/f;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "f", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class DetailGuideTask implements h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final pv4.f nativeGuideStatus;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource sourceCurrent;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ZPlanDetailGuideView guideView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy rootView;

    public DetailGuideTask(Activity activity, pv4.f nativeGuideStatus, ZootopiaSource sourceCurrent) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(nativeGuideStatus, "nativeGuideStatus");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        this.activity = activity;
        this.nativeGuideStatus = nativeGuideStatus;
        this.sourceCurrent = sourceCurrent;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.sqshow.zootopia.guide.DetailGuideTask$rootView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                View findViewById = DetailGuideTask.this.getActivity().getWindow().getDecorView().findViewById(R.id.content);
                Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.FrameLayout");
                return (FrameLayout) findViewById;
            }
        });
        this.rootView = lazy;
    }

    private final ZPlanDetailGuideView i() {
        if (this.guideView == null) {
            this.guideView = new ZPlanDetailGuideView(this.activity, null);
            j().addView(this.guideView);
        }
        ZPlanDetailGuideView zPlanDetailGuideView = this.guideView;
        Intrinsics.checkNotNull(zPlanDetailGuideView);
        return zPlanDetailGuideView;
    }

    private final void k() {
        QLog.d("DetailGuideTask", 1, "handleNext Step ");
        final View findViewById = this.activity.findViewById(com.tencent.mobileqq.R.id.f163312pg1);
        if (findViewById == null) {
            QLog.e("DetailGuideTask", 1, "targetView is null, show third guide View failed ");
            return;
        }
        g();
        ZPlanDetailGuideView i3 = i();
        String string = this.activity.getResources().getString(com.tencent.mobileqq.R.string.xpq);
        Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getSt\u2026_guide_detial_rank_tab_3)");
        i3.c(1, findViewById, string, "3/3", new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.guide.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetailGuideTask.l(findViewById, this, view);
            }
        }, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.guide.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetailGuideTask.m(DetailGuideTask.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(View view, DetailGuideTask this$0, View view2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(view2.getTag(), (Object) 1)) {
            view.performClick();
        }
        ZplanGuideManager.INSTANCE.a().b(7, this$0.nativeGuideStatus.f427598b, 3);
        QLog.d("DetailGuideTask", 1, "finish detail guide task");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(DetailGuideTask this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q(3);
    }

    private final void n() {
        QLog.d("DetailGuideTask", 1, "handleNext Step ");
        View findViewById = this.activity.findViewById(com.tencent.mobileqq.R.id.r78);
        if (findViewById == null) {
            QLog.e("DetailGuideTask", 1, "targetView is null, show second guide View failed ");
            return;
        }
        g();
        ZPlanDetailGuideView i3 = i();
        String string = this.activity.getResources().getString(com.tencent.mobileqq.R.string.xpp);
        Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getSt\u2026_guide_detial_rank_tab_2)");
        i3.c(2, findViewById, string, "2/3", new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.guide.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetailGuideTask.o(DetailGuideTask.this, view);
            }
        }, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.guide.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetailGuideTask.p(DetailGuideTask.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(DetailGuideTask this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(DetailGuideTask this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(View view, DetailGuideTask this$0, View view2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        view.performClick();
        this$0.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(DetailGuideTask this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q(1);
    }

    @Override // com.tencent.sqshow.zootopia.guide.h
    public void dismiss() {
        ZPlanDetailGuideView zPlanDetailGuideView = this.guideView;
        if (Intrinsics.areEqual(zPlanDetailGuideView != null ? zPlanDetailGuideView.getParent() : null, j())) {
            QLog.d("DetailGuideTask", 1, "disMiss guide view");
            j().removeView(this.guideView);
        }
    }

    @Override // com.tencent.sqshow.zootopia.guide.h
    public int getId() {
        return this.nativeGuideStatus.f427598b;
    }

    /* renamed from: h, reason: from getter */
    public final Activity getActivity() {
        return this.activity;
    }

    public final FrameLayout j() {
        return (FrameLayout) this.rootView.getValue();
    }

    @Override // com.tencent.sqshow.zootopia.guide.h
    public boolean show() {
        final View findViewById = this.activity.findViewById(com.tencent.mobileqq.R.id.r78);
        if (findViewById == null) {
            QLog.e("DetailGuideTask", 1, "targetView is null, show guide View failed ");
            return false;
        }
        QLog.d("DetailGuideTask", 1, "show detail guide task " + this.nativeGuideStatus);
        ZPlanDetailGuideView i3 = i();
        String string = this.activity.getResources().getString(com.tencent.mobileqq.R.string.xpo);
        Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getSt\u2026_guide_detial_rank_tab_1)");
        i3.c(0, findViewById, string, "1/3", new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.guide.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetailGuideTask.r(findViewById, this, view);
            }
        }, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.guide.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetailGuideTask.s(DetailGuideTask.this, view);
            }
        });
        if (i3.getParent() == null) {
            j().addView(i3);
        }
        return true;
    }

    private final void g() {
        QLog.i("DetailGuideTask", 1, "clearLastStepView");
        ZPlanDetailGuideView zPlanDetailGuideView = this.guideView;
        if (Intrinsics.areEqual(zPlanDetailGuideView != null ? zPlanDetailGuideView.getParent() : null, j())) {
            j().removeView(this.guideView);
            this.guideView = null;
        }
    }

    private final void q(int step) {
        QLog.d("DetailGuideTask", 1, "handle Skip Step ");
        q.f370741a.e(this.activity, this.nativeGuideStatus, 7, this.sourceCurrent, step).show();
    }
}
