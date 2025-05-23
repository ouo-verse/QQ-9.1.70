package com.tencent.state.view;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mobileqq.R;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.databinding.VasSquareQzonePrivicyDialogBinding;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0014\u0010\f\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000eJ\b\u0010\u000f\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/state/view/SquareQZonePrivacyDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareQzonePrivicyDialogBinding;", "reporter", "Lcom/tencent/state/square/IReporter;", "initListeners", "", "initWindow", "setPositiveCallback", "callback", "Lkotlin/Function0;", "show", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareQZonePrivacyDialog extends Dialog {
    private static final int DIALOG_HEIGHT = 264;
    private static final int DIALOG_WIDTH = 286;
    private static final String TAG = "SquareQZonePrivacyDialog";
    private final VasSquareQzonePrivicyDialogBinding binding;
    private IReporter reporter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareQZonePrivacyDialog(Context context) {
        super(context, R.style.f243250a);
        Intrinsics.checkNotNullParameter(context, "context");
        VasSquareQzonePrivicyDialogBinding inflate = VasSquareQzonePrivicyDialogBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareQzonePrivicyDia\u2026utInflater.from(context))");
        this.binding = inflate;
        setContentView(inflate.getMRv());
        initWindow();
        initListeners();
    }

    private final void initListeners() {
        this.binding.ignore.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.view.SquareQZonePrivacyDialog$initListeners$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IReporter iReporter;
                Map<String, Object> mutableMapOf;
                SquareQZonePrivacyDialog.this.dismiss();
                iReporter = SquareQZonePrivacyDialog.this.reporter;
                if (iReporter != null) {
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "click"), TuplesKt.to("zplan_button_display_type", 0));
                    iReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_GUIDED_WINDOW, mutableMapOf);
                }
            }
        });
    }

    private final void initWindow() {
        WindowManager.LayoutParams attributes;
        WindowManager.LayoutParams attributes2;
        this.reporter = Square.INSTANCE.getConfig().getReporter();
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
        }
        Window window2 = getWindow();
        if (window2 != null && (attributes2 = window2.getAttributes()) != null) {
            attributes2.width = ViewExtensionsKt.dip(getContext(), 286);
        }
        Window window3 = getWindow();
        if (window3 == null || (attributes = window3.getAttributes()) == null) {
            return;
        }
        attributes.height = ViewExtensionsKt.dip(getContext(), 264);
    }

    public final void setPositiveCallback(final Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.binding.accept.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.view.SquareQZonePrivacyDialog$setPositiveCallback$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IReporter iReporter;
                Map<String, Object> mutableMapOf;
                SquareQZonePrivacyDialog.this.dismiss();
                callback.invoke();
                iReporter = SquareQZonePrivacyDialog.this.reporter;
                if (iReporter != null) {
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "click"), TuplesKt.to("zplan_button_display_type", 1));
                    iReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_GUIDED_WINDOW, mutableMapOf);
                }
            }
        });
    }

    @Override // android.app.Dialog
    public void show() {
        Map<String, Object> mutableMapOf;
        super.show();
        IReporter iReporter = this.reporter;
        if (iReporter != null) {
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "imp"));
            iReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_GUIDED_WINDOW, mutableMapOf);
        }
    }
}
