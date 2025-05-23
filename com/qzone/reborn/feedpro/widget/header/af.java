package com.qzone.reborn.feedpro.widget.header;

import android.app.Activity;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qzone.reborn.route.QZonePublishMoodInitBean;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\tH\u0014J\b\u0010\u000b\u001a\u00020\u0002H\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/header/af;", "Lcom/qzone/reborn/feedpro/widget/header/d;", "", "p", "", "pickMediaFirst", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "o", "", "k", "onInit", "Landroidx/constraintlayout/widget/ConstraintLayout;", "f", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mMoodContainer", tl.h.F, "mSignInContainer", "Landroid/view/View;", "containerView", "<init>", "(Landroid/view/View;)V", "i", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class af extends d {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ConstraintLayout mMoodContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ConstraintLayout mSignInContainer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/feedpro/widget/header/af$b", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "view", "", NodeProps.ON_CLICK, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            af.this.q(false);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/feedpro/widget/header/af$c", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "view", "", NodeProps.ON_CLICK, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            af.this.r();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(View containerView) {
        super(containerView);
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.mrj);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026yout>(R.id.qzone_cl_mood)");
        this.mMoodContainer = (ConstraintLayout) findViewById;
        View findViewById2 = containerView.findViewById(R.id.mrk);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026yout>(R.id.qzone_cl_sign)");
        this.mSignInContainer = (ConstraintLayout) findViewById2;
    }

    private final void p() {
        this.mMoodContainer.setOnClickListener(new b());
        this.mSignInContainer.setOnClickListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(boolean pickMediaFirst) {
        QLog.i("QzoneMoodListProHeaderElement", 1, "launchPublishPage pickMediaFirst=" + pickMediaFirst);
        if (pickMediaFirst && com.qzone.reborn.util.l.f59550a.U(i(), null)) {
            return;
        }
        eo.c.f396879a.b();
        QZonePublishMoodInitBean qZonePublishMoodInitBean = new QZonePublishMoodInitBean(System.currentTimeMillis());
        qZonePublishMoodInitBean.t0(0);
        Boolean bool = Boolean.FALSE;
        qZonePublishMoodInitBean.R0(bool);
        qZonePublishMoodInitBean.C0("3");
        qZonePublishMoodInitBean.O0(22);
        qZonePublishMoodInitBean.G0(Boolean.TRUE);
        qZonePublishMoodInitBean.v0(bool);
        qZonePublishMoodInitBean.o0(Boolean.valueOf(pickMediaFirst));
        ho.i.w().c(i(), qZonePublishMoodInitBean);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedpro.widget.header.d
    public String k() {
        return "QzoneMoodListProHeaderElement";
    }

    @Override // com.qzone.reborn.feedpro.widget.header.c
    public void onInit() {
        com.qzone.reborn.feedpro.utils.aa aaVar = com.qzone.reborn.feedpro.utils.aa.f54263a;
        com.qzone.reborn.feedpro.utils.aa.g(aaVar, this.mMoodContainer, h().getContext(), 0, false, 6, null);
        com.qzone.reborn.feedpro.utils.aa.g(aaVar, this.mSignInContainer, h().getContext(), 0, false, 6, null);
        p();
        o();
    }

    private final void o() {
        Map<String, Object> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.QZONE_PUBLISH_ID, eo.c.f396879a.c()));
        fo.b l3 = new fo.b().l(mutableMapOf);
        fo.c.o(this.mMoodContainer, "em_qz_write_talk", l3);
        fo.c.o(this.mSignInContainer, "em_qz_sign_in", l3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        QLog.i("QzoneMoodListProHeaderElement", 1, "launchSignInPage");
        ho.g w3 = ho.i.w();
        Activity hostActivity = i();
        Intrinsics.checkNotNullExpressionValue(hostActivity, "hostActivity");
        w3.f(hostActivity);
    }
}
