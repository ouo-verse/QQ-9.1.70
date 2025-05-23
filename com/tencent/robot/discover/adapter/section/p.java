package com.tencent.robot.discover.adapter.section;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.report.MiniAppSearchDtReportHelper;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.robot.discover.fragment.RobotCategoryFragment;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J*\u0010\u000f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/robot/discover/adapter/section/p;", "Lcom/tencent/robot/discover/adapter/section/e;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "Lk34/a;", "data", "", "position", "", "", "payload", "t", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "mTitleText", "f", "mMore", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class p extends e {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView mTitleText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mMore;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(p this$0, k34.a aVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity p16 = this$0.p();
        if (p16 != null) {
            k34.g gVar = (k34.g) aVar;
            RobotCategoryFragment.INSTANCE.a(p16, gVar.getTroopUin(), String.valueOf(gVar.getCategoryId()), gVar.getCategoryName());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.f775844r);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.robot_title_text)");
        this.mTitleText = (TextView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.f770643c);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewById(R.id.robot_more)");
        this.mMore = (TextView) findViewById2;
        Drawable drawable = this.mRootView.getContext().getResources().getDrawable(R.drawable.qui_chevron_right_icon_secondary_01);
        Intrinsics.checkNotNullExpressionValue(drawable, "mRootView.context.resour\u2026_right_icon_secondary_01)");
        int dimensionPixelSize = this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.c9y);
        drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        TextView textView = this.mMore;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMore");
            textView = null;
        }
        textView.setCompoundDrawables(null, null, drawable, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable final k34.a data, int position, @Nullable List<Object> payload) {
        Map<String, ? extends Object> mapOf;
        if (data instanceof k34.g) {
            TextView textView = this.mTitleText;
            TextView textView2 = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleText");
                textView = null;
            }
            k34.g gVar = (k34.g) data;
            textView.setText(gVar.getCategoryName());
            TextView textView3 = this.mMore;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMore");
                textView3 = null;
            }
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.discover.adapter.section.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    p.u(p.this, data, view);
                }
            });
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(MiniAppSearchDtReportHelper.DT_ELEMENT_CLASSIFICATION_NAME, gVar.getCategoryName()));
            TextView textView4 = this.mMore;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMore");
                textView4 = null;
            }
            q(textView4, "em_more_result_button", mapOf);
            TextView textView5 = this.mMore;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMore");
            } else {
                textView2 = textView5;
            }
            VideoReport.setElementEndExposePolicy(textView2, EndExposurePolicy.REPORT_ALL);
        }
    }
}
