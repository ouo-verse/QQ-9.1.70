package com.tencent.mobileqq.zplan.minixwconnected;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.zplan.minihome.MapMode;
import com.tencent.mobileqq.zplan.minixwconnected.controller.MiniHomeConnectedController;
import com.tencent.mobileqq.zplan.minixwconnected.report.ZPlanMiniHomeConnectReporter;
import com.tencent.qphone.base.util.QLog;
import fi3.bi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ZPlanMiniHomeConnectedFragment$updateToBigMap$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ View $btn;
    final /* synthetic */ MapMode $mapMode;
    final /* synthetic */ ZPlanMiniHomeConnectedFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanMiniHomeConnectedFragment$updateToBigMap$1(ZPlanMiniHomeConnectedFragment zPlanMiniHomeConnectedFragment, View view, MapMode mapMode) {
        super(0);
        this.this$0 = zPlanMiniHomeConnectedFragment;
        this.$btn = view;
        this.$mapMode = mapMode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ZPlanMiniHomeConnectedFragment this$0, View it) {
        MiniHomeConnectedController miniHomeConnectedController;
        ZPlanMiniHomeConnectReporter U;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.wi();
        miniHomeConnectedController = this$0.controller;
        if (miniHomeConnectedController == null || (U = miniHomeConnectedController.U()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        ZPlanMiniHomeConnectReporter.f(U, it, "em_zplan_random_visit", "dt_clck", null, false, false, 40, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(ZPlanMiniHomeConnectedFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.Uh(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(ZPlanMiniHomeConnectedFragment this$0, View it) {
        MiniHomeConnectedController miniHomeConnectedController;
        MiniHomeConnectedController miniHomeConnectedController2;
        ZPlanMiniHomeConnectReporter U;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        miniHomeConnectedController = this$0.controller;
        if (miniHomeConnectedController != null && (U = miniHomeConnectedController.U()) != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            ZPlanMiniHomeConnectReporter.f(U, it, "em_zplan_plant_flowers_en", "dt_clck", null, false, false, 40, null);
        }
        miniHomeConnectedController2 = this$0.controller;
        if (miniHomeConnectedController2 != null) {
            miniHomeConnectedController2.E();
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a8, code lost:
    
        r0 = r0.controller;
     */
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invoke2() {
        bi Xh;
        View view;
        bi Xh2;
        View view2;
        View view3;
        bi Xh3;
        bi Xh4;
        MiniHomeConnectedController miniHomeConnectedController;
        ZPlanMiniHomeConnectReporter U;
        bi Xh5;
        View view4;
        Xh = this.this$0.Xh();
        Xh.f399103f.setVisibility(0);
        view = this.this$0.globalFunctionBtn;
        if (view == null) {
            this.this$0.globalFunctionBtn = this.$btn;
            view4 = this.this$0.globalFunctionBtn;
            if (view4 != null) {
                final ZPlanMiniHomeConnectedFragment zPlanMiniHomeConnectedFragment = this.this$0;
                RelativeLayout relativeLayout = view4 instanceof RelativeLayout ? (RelativeLayout) view4 : null;
                if (relativeLayout != null) {
                    ((RelativeLayout) relativeLayout.findViewWithTag("strangerVisitIcon")).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minixwconnected.j
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view5) {
                            ZPlanMiniHomeConnectedFragment$updateToBigMap$1.d(ZPlanMiniHomeConnectedFragment.this, view5);
                        }
                    });
                    RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.findViewWithTag("neighborIcon");
                    if (relativeLayout2 != null) {
                        relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minixwconnected.k
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view5) {
                                ZPlanMiniHomeConnectedFragment$updateToBigMap$1.e(ZPlanMiniHomeConnectedFragment.this, view5);
                            }
                        });
                    }
                    RelativeLayout relativeLayout3 = (RelativeLayout) relativeLayout.findViewWithTag("plantingIcon");
                    if (relativeLayout3 != null) {
                        relativeLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minixwconnected.l
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view5) {
                                ZPlanMiniHomeConnectedFragment$updateToBigMap$1.f(ZPlanMiniHomeConnectedFragment.this, view5);
                            }
                        });
                    }
                }
            }
        }
        Xh2 = this.this$0.Xh();
        Xh2.f399099b.removeAllViews();
        view2 = this.this$0.coupleActionPanel;
        if (view2 != null) {
            ZPlanMiniHomeConnectedFragment zPlanMiniHomeConnectedFragment2 = this.this$0;
            Xh5 = zPlanMiniHomeConnectedFragment2.Xh();
            Xh5.getRoot().removeView(view2);
            zPlanMiniHomeConnectedFragment2.coupleActionPanel = null;
        }
        this.this$0.ci();
        view3 = this.this$0.globalFunctionBtn;
        if (view3 != null) {
            ZPlanMiniHomeConnectedFragment zPlanMiniHomeConnectedFragment3 = this.this$0;
            MapMode mapMode = this.$mapMode;
            Xh4 = zPlanMiniHomeConnectedFragment3.Xh();
            Xh4.f399099b.addView(view3);
            if (mapMode == MapMode.GLOBAL && miniHomeConnectedController != null && (U = miniHomeConnectedController.U()) != null) {
                ZPlanMiniHomeConnectReporter.f(U, view3, "em_zplan_plant_flowers_en", "dt_imp", null, false, false, 40, null);
            }
        }
        QLog.i("ZPlanMiniHomeConnectedFragment", 1, "updateToBigMap, show title.");
        Xh3 = this.this$0.Xh();
        TextView textView = Xh3.f399106i;
        textView.setText("\u8da3\u90bb");
        textView.setVisibility(0);
    }
}
