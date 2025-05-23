package com.tencent.state.view;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.R;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.databinding.VasSquareEndInviteDialogBinding;
import com.tencent.state.utils.DrawableUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eBY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u00a2\u0006\u0002\u0010\u000fJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J$\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\b\u0010\u0018\u001a\u00020\u0013H\u0002J\u001a\u0010\u0019\u001a\u00020\u00132\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u001bJ\u001a\u0010\u001c\u001a\u00020\u00132\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u001bJ\b\u0010\u001d\u001a\u00020\u0013H\u0016R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/state/view/SquareEndInviteDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "isBanded", "", "messageResId", "", "checkResId", "confirmText", "reportEventCode", "", "extraReportParams", "", "", "(Landroid/content/Context;ZIIILjava/lang/String;Ljava/util/Map;)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareEndInviteDialogBinding;", "bindPickIcon", "", "getReportParams", "actionType", "clickParam", "initWindow", "setClick", "setNegativeCallback", "callback", "Lkotlin/Function1;", "setPositiveCallback", "show", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareEndInviteDialog extends Dialog {
    public static final int DIALOG_HEIGHT = 154;
    public static final int DIALOG_WIDTH = 296;
    private final VasSquareEndInviteDialogBinding binding;
    private final int checkResId;
    private final int confirmText;
    private final Map<String, Object> extraReportParams;
    private boolean isBanded;
    private final int messageResId;
    private final String reportEventCode;

    public /* synthetic */ SquareEndInviteDialog(Context context, boolean z16, int i3, int i16, int i17, String str, Map map, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i18 & 2) != 0 ? true : z16, (i18 & 4) != 0 ? R.string.xh_ : i3, (i18 & 8) != 0 ? R.string.xcz : i16, (i18 & 16) != 0 ? R.string.xha : i17, (i18 & 32) != 0 ? null : str, (i18 & 64) == 0 ? map : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bindPickIcon() {
        if (this.isBanded) {
            this.binding.selfUseIcon.setImageDrawable(DrawableUtil.INSTANCE.getDrawable(R.drawable.i_f));
        } else {
            this.binding.selfUseIcon.setImageDrawable(DrawableUtil.INSTANCE.getDrawable(R.drawable.i_e));
        }
    }

    private final void setClick() {
        this.binding.selfUseIcon.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.view.SquareEndInviteDialog$setClick$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                boolean z16;
                SquareEndInviteDialog squareEndInviteDialog = SquareEndInviteDialog.this;
                z16 = squareEndInviteDialog.isBanded;
                squareEndInviteDialog.isBanded = !z16;
                SquareEndInviteDialog.this.bindPickIcon();
            }
        });
    }

    public final void setNegativeCallback(final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.binding.ignore.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.view.SquareEndInviteDialog$setNegativeCallback$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                boolean z16;
                String str;
                IReporter reporter;
                Map<String, Object> reportParams;
                SquareEndInviteDialog.this.dismiss();
                Function1 function1 = callback;
                z16 = SquareEndInviteDialog.this.isBanded;
                function1.invoke(Boolean.valueOf(z16));
                str = SquareEndInviteDialog.this.reportEventCode;
                if (str == null || (reporter = Square.INSTANCE.getConfig().getReporter()) == null) {
                    return;
                }
                reportParams = SquareEndInviteDialog.this.getReportParams("click", 0);
                reporter.reportEvent(str, reportParams);
            }
        });
    }

    public final void setPositiveCallback(final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.binding.accept.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.view.SquareEndInviteDialog$setPositiveCallback$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                boolean z16;
                String str;
                IReporter reporter;
                Map<String, Object> reportParams;
                SquareEndInviteDialog.this.dismiss();
                Function1 function1 = callback;
                z16 = SquareEndInviteDialog.this.isBanded;
                function1.invoke(Boolean.valueOf(z16));
                str = SquareEndInviteDialog.this.reportEventCode;
                if (str == null || (reporter = Square.INSTANCE.getConfig().getReporter()) == null) {
                    return;
                }
                reportParams = SquareEndInviteDialog.this.getReportParams("click", 1);
                reporter.reportEvent(str, reportParams);
            }
        });
    }

    @Override // android.app.Dialog
    public void show() {
        IReporter reporter;
        super.show();
        String str = this.reportEventCode;
        if (str == null || (reporter = Square.INSTANCE.getConfig().getReporter()) == null) {
            return;
        }
        reporter.reportEvent(str, getReportParams("imp", 0));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareEndInviteDialog(Context context, boolean z16, int i3, int i16, int i17, String str, Map<String, Object> map) {
        super(context, R.style.f243250a);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isBanded = z16;
        this.messageResId = i3;
        this.checkResId = i16;
        this.confirmText = i17;
        this.reportEventCode = str;
        this.extraReportParams = map;
        VasSquareEndInviteDialogBinding inflate = VasSquareEndInviteDialogBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareEndInviteDialog\u2026utInflater.from(context))");
        this.binding = inflate;
        setContentView(inflate.getRoot());
        initWindow();
        bindPickIcon();
        setClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> getReportParams(String actionType, int clickParam) {
        Map<String, Object> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", actionType), TuplesKt.to(SquareReportConst.Key.KEY_END_POP_WINDOW_BTN, Integer.valueOf(clickParam)), TuplesKt.to(SquareReportConst.Key.KEY_IS_TICK, Integer.valueOf(this.isBanded ? 1 : 0)));
        Map<String, Object> map = this.extraReportParams;
        if (map != null) {
            mutableMapOf.putAll(map);
        }
        return mutableMapOf;
    }

    private final void initWindow() {
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
        }
        this.binding.title.setText(this.messageResId);
        this.binding.selfUseTip.setText(this.checkResId);
        this.binding.accept.setText(this.confirmText);
    }
}
