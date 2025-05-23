package com.tencent.robot.aio.stopgeneratingbutton;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.robot.aio.stopgeneratingbutton.RobotStopGenerateUIState;
import com.tencent.robot.aio.stopgeneratingbutton.a;
import hn2.p;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001c\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0003H\u0016R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/robot/aio/stopgeneratingbutton/d;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/robot/aio/stopgeneratingbutton/a;", "Lcom/tencent/robot/aio/stopgeneratingbutton/RobotStopGenerateUIState;", "", "g1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/mvi/api/help/b;", "reuseParam", "onReuseView", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "state", "d1", "Lhn2/p;", "d", "Lhn2/p;", "stopButton", "<init>", "()V", "e", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d extends com.tencent.aio.base.mvvm.a<a, RobotStopGenerateUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private p stopButton;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(a.C9769a.f367365d);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f1(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                view.setAlpha(1.0f);
                return false;
            }
            return false;
        }
        view.setAlpha(0.7f);
        return false;
    }

    private final void g1() {
        Drawable o16 = ie0.a.f().o(getMContext(), R.drawable.qui_record_stop, R.color.qui_common_icon_primary, 1000);
        p pVar = this.stopButton;
        p pVar2 = null;
        if (pVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stopButton");
            pVar = null;
        }
        pVar.f405403b.setImageDrawable(o16);
        p pVar3 = this.stopButton;
        if (pVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stopButton");
            pVar3 = null;
        }
        pVar3.f405405d.setBackgroundResource(R.drawable.lj_);
        p pVar4 = this.stopButton;
        if (pVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stopButton");
        } else {
            pVar2 = pVar4;
        }
        pVar2.f405404c.setTextColor(ie0.a.f().g(getMContext(), R.color.qui_common_text_primary, 1000));
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    public BaseVM<a, RobotStopGenerateUIState, com.tencent.aio.api.runtime.a> createVM() {
        return new RobotStopGenerateVM();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull RobotStopGenerateUIState state) {
        int i3;
        Intrinsics.checkNotNullParameter(state, "state");
        p pVar = null;
        if (state instanceof RobotStopGenerateUIState.ButtonVisible) {
            p pVar2 = this.stopButton;
            if (pVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stopButton");
            } else {
                pVar = pVar2;
            }
            FrameLayout root = pVar.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "stopButton.root");
            if (((RobotStopGenerateUIState.ButtonVisible) state).getCom.tencent.mtt.hippy.dom.node.NodeProps.VISIBLE java.lang.String()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            root.setVisibility(i3);
            return;
        }
        if (state instanceof RobotStopGenerateUIState.ButtonBottomMargin) {
            p pVar3 = this.stopButton;
            if (pVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stopButton");
                pVar3 = null;
            }
            ViewGroup.LayoutParams layoutParams = pVar3.getRoot().getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.bottomMargin = ((RobotStopGenerateUIState.ButtonBottomMargin) state).getBottomMargin();
            p pVar4 = this.stopButton;
            if (pVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stopButton");
            } else {
                pVar = pVar4;
            }
            pVar.getRoot().setLayoutParams(layoutParams2);
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        p g16 = p.g(LayoutInflater.from(getMContext()), createViewParams.b(), false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026ViewParams.parent, false)");
        this.stopButton = g16;
        p pVar = null;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stopButton");
            g16 = null;
        }
        g16.f405405d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.aio.stopgeneratingbutton.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.e1(d.this, view);
            }
        });
        p pVar2 = this.stopButton;
        if (pVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stopButton");
            pVar2 = null;
        }
        pVar2.f405405d.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.robot.aio.stopgeneratingbutton.c
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean f16;
                f16 = d.f1(view, motionEvent);
                return f16;
            }
        });
        g1();
        FrameLayout.LayoutParams a16 = com.tencent.aio.base.tool.b.f69219a.a(createViewParams.a(), -1, -2);
        a16.gravity = 80;
        p pVar3 = this.stopButton;
        if (pVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stopButton");
            pVar3 = null;
        }
        pVar3.getRoot().setLayoutParams(a16);
        p pVar4 = this.stopButton;
        if (pVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stopButton");
            pVar4 = null;
        }
        FrameLayout root = pVar4.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "stopButton.root");
        root.setVisibility(8);
        p pVar5 = this.stopButton;
        if (pVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stopButton");
        } else {
            pVar = pVar5;
        }
        FrameLayout root2 = pVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "stopButton.root");
        return root2;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onReuseView(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
        super.onReuseView(reuseParam);
        p pVar = this.stopButton;
        if (pVar != null) {
            if (pVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stopButton");
                pVar = null;
            }
            FrameLayout root = pVar.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "stopButton.root");
            root.setVisibility(8);
            g1();
        }
    }
}
