package com.tencent.mobileqq.zplan.minixwconnected;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.zplan.utils.bb;
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
public final class ZPlanMiniHomeConnectedFragment$updateToSelfFocus$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ View $focusUI;
    final /* synthetic */ ZPlanMiniHomeConnectedFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanMiniHomeConnectedFragment$updateToSelfFocus$1(ZPlanMiniHomeConnectedFragment zPlanMiniHomeConnectedFragment, View view) {
        super(0);
        this.this$0 = zPlanMiniHomeConnectedFragment;
        this.$focusUI = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ZPlanMiniHomeConnectedFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ZPlanMiniHomeConnectedFragment", 1, "click titleText, try jumpToProfileCard.");
        String e16 = bb.f335811a.e();
        if (e16 != null) {
            this$0.ei(e16);
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        View view;
        bi Xh;
        bi Xh2;
        View view2;
        View view3;
        bi Xh3;
        bi Xh4;
        ImageView ai5;
        bi Xh5;
        ImageView ai6;
        ImageView ai7;
        bi Xh6;
        view = this.this$0.selfFocusUI;
        if (view == null) {
            this.this$0.selfFocusUI = this.$focusUI;
        }
        Xh = this.this$0.Xh();
        Xh.f399103f.setVisibility(8);
        Xh2 = this.this$0.Xh();
        Xh2.f399099b.removeAllViews();
        view2 = this.this$0.coupleActionPanel;
        if (view2 != null) {
            ZPlanMiniHomeConnectedFragment zPlanMiniHomeConnectedFragment = this.this$0;
            Xh6 = zPlanMiniHomeConnectedFragment.Xh();
            Xh6.getRoot().removeView(view2);
            zPlanMiniHomeConnectedFragment.coupleActionPanel = null;
        }
        view3 = this.this$0.selfFocusUI;
        if (view3 != null) {
            ZPlanMiniHomeConnectedFragment zPlanMiniHomeConnectedFragment2 = this.this$0;
            ViewParent parent = view3.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(view3);
            }
            Xh4 = zPlanMiniHomeConnectedFragment2.Xh();
            Xh4.f399099b.addView(view3);
            ai5 = zPlanMiniHomeConnectedFragment2.ai();
            ViewParent parent2 = ai5.getParent();
            ViewGroup viewGroup2 = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
            if (viewGroup2 != null) {
                ai7 = zPlanMiniHomeConnectedFragment2.ai();
                viewGroup2.removeView(ai7);
            }
            Xh5 = zPlanMiniHomeConnectedFragment2.Xh();
            RelativeLayout relativeLayout = Xh5.f399102e;
            ai6 = zPlanMiniHomeConnectedFragment2.ai();
            relativeLayout.addView(ai6);
        }
        QQAppInterface j3 = bb.f335811a.j();
        String F = j3 != null ? ac.F(j3, j3.getAccount()) : null;
        if (F == null) {
            F = "\u6211";
        }
        Xh3 = this.this$0.Xh();
        TextView textView = Xh3.f399106i;
        final ZPlanMiniHomeConnectedFragment zPlanMiniHomeConnectedFragment3 = this.this$0;
        textView.setText(w.b(F, "\u7684\u7a9d", 0, 4, null));
        textView.setVisibility(0);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minixwconnected.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                ZPlanMiniHomeConnectedFragment$updateToSelfFocus$1.b(ZPlanMiniHomeConnectedFragment.this, view4);
            }
        });
    }
}
