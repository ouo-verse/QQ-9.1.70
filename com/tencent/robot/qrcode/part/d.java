package com.tencent.robot.qrcode.part;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.robot.data.RobotInfo;
import com.tencent.robot.data.RobotShareState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0003J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0003J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0017R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0018\u001a\u00020\u00138\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/robot/qrcode/part/d;", "Lcom/tencent/biz/richframework/part/Part;", "", "E9", "C9", "Landroid/content/Context;", "context", "Landroid/widget/RelativeLayout;", "buttonPart", "G9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lw44/a;", "d", "Lw44/a;", "viewModel", "e", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnTouchListener;", "f", "Landroid/view/View$OnTouchListener;", "getButtonTouchListener", "()Landroid/view/View$OnTouchListener;", "buttonTouchListener", "<init>", "()V", tl.h.F, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private w44.a viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout buttonPart;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @SuppressLint({"ClickableViewAccessibility"})
    @NotNull
    private final View.OnTouchListener buttonTouchListener = new View.OnTouchListener() { // from class: com.tencent.robot.qrcode.part.b
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            boolean B9;
            B9 = d.B9(view, motionEvent);
            return B9;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean B9(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1 && action != 3) {
                return false;
            }
            view.setAlpha(1.0f);
            return false;
        }
        view.setAlpha(0.5f);
        return false;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void C9() {
        RelativeLayout relativeLayout = this.buttonPart;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buttonPart");
            relativeLayout = null;
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.findViewById(R.id.f646836w);
        relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.qrcode.part.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.D9(d.this, view);
            }
        });
        relativeLayout2.setOnTouchListener(this.buttonTouchListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.broadcastMessage("action_save_qr_code", "");
        EventCollector.getInstance().onViewClicked(view);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void E9() {
        RelativeLayout relativeLayout = this.buttonPart;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buttonPart");
            relativeLayout = null;
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.findViewById(R.id.f646936x);
        relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.qrcode.part.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.F9(d.this, view);
            }
        });
        relativeLayout2.setOnTouchListener(this.buttonTouchListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.broadcastMessage("action_show_share_sheet", "");
        EventCollector.getInstance().onViewClicked(view);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void G9(Context context, RelativeLayout buttonPart) {
        RobotShareState robotShareState;
        E9();
        C9();
        w44.a aVar = this.viewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            aVar = null;
        }
        RobotInfo robotInfo = aVar.getRobotInfo();
        if (robotInfo == null || (robotShareState = robotInfo.getShareState()) == null) {
            robotShareState = RobotShareState.NORMAL;
        }
        if (robotShareState == RobotShareState.BANNED) {
            buttonPart.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @SuppressLint({"ClickableViewAccessibility"})
    public void onInitView(@Nullable View rootView) {
        RelativeLayout relativeLayout;
        super.onInitView(rootView);
        w44.a aVar = (w44.a) getViewModel(w44.a.class);
        if (aVar == null) {
            return;
        }
        this.viewModel = aVar;
        RelativeLayout relativeLayout2 = null;
        if (rootView != null) {
            relativeLayout = (RelativeLayout) rootView.findViewById(R.id.tjx);
        } else {
            relativeLayout = null;
        }
        if (!(relativeLayout instanceof RelativeLayout)) {
            relativeLayout = null;
        }
        if (relativeLayout == null) {
            QLog.i("robot.qr.QRDisplayRobotTitlePart", 1, "card part is null");
            return;
        }
        this.buttonPart = relativeLayout;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        RelativeLayout relativeLayout3 = this.buttonPart;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buttonPart");
        } else {
            relativeLayout2 = relativeLayout3;
        }
        G9(context, relativeLayout2);
    }
}
