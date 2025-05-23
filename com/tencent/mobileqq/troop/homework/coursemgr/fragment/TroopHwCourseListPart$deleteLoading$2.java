package com.tencent.mobileqq.troop.homework.coursemgr.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.coursemgr.ui.TroopHwCourseFloatingView;
import com.tencent.util.LoadingUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n\u00a2\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/app/Dialog;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopHwCourseListPart$deleteLoading$2 extends Lambda implements Function0<Dialog> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ TroopHwCourseListPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopHwCourseListPart$deleteLoading$2(TroopHwCourseListPart troopHwCourseListPart) {
        super(0);
        this.this$0 = troopHwCourseListPart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopHwCourseListPart);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TroopHwCourseListPart this$0, DialogInterface dialogInterface) {
        TroopHwCourseFloatingView troopHwCourseFloatingView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        troopHwCourseFloatingView = this$0.floatingContainer;
        if (troopHwCourseFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingContainer");
            troopHwCourseFloatingView = null;
        }
        troopHwCourseFloatingView.T();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Dialog invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Dialog) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Dialog showLoadingDialog = LoadingUtil.showLoadingDialog(this.this$0.getContext(), this.this$0.getContext().getString(R.string.f23410792), true);
        final TroopHwCourseListPart troopHwCourseListPart = this.this$0;
        showLoadingDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.troop.homework.coursemgr.fragment.n
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                TroopHwCourseListPart$deleteLoading$2.b(TroopHwCourseListPart.this, dialogInterface);
            }
        });
        return showLoadingDialog;
    }
}
