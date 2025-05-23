package com.tencent.state.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.Window;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.databinding.VasSquareLoadingDialogBinding;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0006\u0010\f\u001a\u00020\nR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/state/view/SquareLoadingDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "canTouchOutSide", "", "(Landroid/content/Context;Z)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareLoadingDialogBinding;", "dismiss", "", "initWindow", "showSafely", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareLoadingDialog extends Dialog {
    private static final String TAG = "SquareLoadingDialog";
    private final VasSquareLoadingDialogBinding binding;
    private final boolean canTouchOutSide;

    public /* synthetic */ SquareLoadingDialog(Context context, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? true : z16);
    }

    private final void initWindow() {
        setCanceledOnTouchOutside(this.canTouchOutSide);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        String stackTraceToString;
        try {
            super.dismiss();
        } catch (Exception e16) {
            SquareLogger squareLog = SquareBaseKt.getSquareLog();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("loading dismiss exception ");
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            sb5.append(stackTraceToString);
            squareLog.w(TAG, sb5.toString());
        }
    }

    public final void showSafely() {
        String stackTraceToString;
        try {
            super.show();
        } catch (Exception e16) {
            SquareLogger squareLog = SquareBaseKt.getSquareLog();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("loading show exception ");
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            sb5.append(stackTraceToString);
            squareLog.w(TAG, sb5.toString());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareLoadingDialog(Context context, boolean z16) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.canTouchOutSide = z16;
        VasSquareLoadingDialogBinding inflate = VasSquareLoadingDialogBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareLoadingDialogBi\u2026utInflater.from(context))");
        this.binding = inflate;
        setContentView(inflate.getRoot());
        initWindow();
    }
}
