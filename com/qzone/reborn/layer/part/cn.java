package com.qzone.reborn.layer.part;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.peak.PeakConstants;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/layer/part/cn;", "Lcom/qzone/reborn/layer/part/ap;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "Q9", "T9", "R9", "P9", "O9", "onInitView", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class cn extends ap {
    private final void O9() {
        Intent intent = getActivity().getIntent();
        intent.putExtra(PeakConstants.KEY_SHOW_TYPE, 0);
        getActivity().setResult(2, intent);
        getActivity().finish();
        LpReportInfo_pf00064.allReport(586, 47, 4);
    }

    private final void P9() {
        getActivity().setResult(3);
        getActivity().finish();
    }

    private final void Q9(View rootView) {
        View view = new View(getContext());
        view.setBackground(ContextCompat.getDrawable(view.getContext(), R.drawable.awi));
        view.setClickable(false);
        view.setEnabled(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.qzone.reborn.util.r.f59560a.e(60));
        layoutParams.gravity = 80;
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) rootView).addView(view, layoutParams);
    }

    private final void R9(View rootView) {
        TextView textView = new TextView(rootView.getContext());
        textView.setText(HardCodeUtil.qqStr(R.string.w_4));
        textView.setTextSize(16.0f);
        textView.setTextColor(textView.getResources().getColorStateList(R.color.f158017al3));
        textView.setGravity(16);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.layer.part.cl
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                cn.S9(cn.this, view);
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 8388693;
        com.qzone.reborn.util.r rVar = com.qzone.reborn.util.r.f59560a;
        layoutParams.setMarginEnd(rVar.e(16));
        layoutParams.bottomMargin = rVar.e(25);
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) rootView).addView(textView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(cn this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.O9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void T9(View rootView) {
        TextView textView = new TextView(rootView.getContext());
        textView.setText(HardCodeUtil.qqStr(R.string.w_7));
        textView.setTextSize(16.0f);
        textView.setTextColor(textView.getResources().getColorStateList(R.color.f158017al3));
        textView.setGravity(16);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.layer.part.cm
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                cn.U9(cn.this, view);
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 8388691;
        com.qzone.reborn.util.r rVar = com.qzone.reborn.util.r.f59560a;
        layoutParams.setMarginStart(rVar.e(16));
        layoutParams.bottomMargin = rVar.e(25);
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) rootView).addView(textView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(cn this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.P9();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        if (rootView != null) {
            Q9(rootView);
            T9(rootView);
            R9(rootView);
        }
    }
}
