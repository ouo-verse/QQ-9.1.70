package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* compiled from: P */
/* loaded from: classes2.dex */
public class BottomSheetDialogFragment extends AppCompatDialogFragment {
    private boolean waitingForDismissAllowingStateLoss;

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissAfterAnimation() {
        if (this.waitingForDismissAllowingStateLoss) {
            super.dismissAllowingStateLoss();
        } else {
            super.dismiss();
        }
    }

    private void dismissWithAnimation(@NonNull BottomSheetBehavior<?> bottomSheetBehavior, boolean z16) {
        this.waitingForDismissAllowingStateLoss = z16;
        if (bottomSheetBehavior.getState() == 5) {
            dismissAfterAnimation();
            return;
        }
        if (getDialog() instanceof com.google.android.material.bottomsheet.a) {
            ((com.google.android.material.bottomsheet.a) getDialog()).removeDefaultCallback();
        }
        bottomSheetBehavior.addBottomSheetCallback(new b());
        bottomSheetBehavior.setState(5);
    }

    private boolean tryDismissWithAnimation(boolean z16) {
        Dialog dialog = getDialog();
        if (dialog instanceof com.google.android.material.bottomsheet.a) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialog;
            BottomSheetBehavior<FrameLayout> behavior = aVar.getBehavior();
            if (behavior.isHideable() && aVar.getDismissWithAnimation()) {
                dismissWithAnimation(behavior, z16);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        if (!tryDismissWithAnimation(false)) {
            super.dismiss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismissAllowingStateLoss() {
        if (!tryDismissWithAnimation(true)) {
            super.dismissAllowingStateLoss();
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        return new com.google.android.material.bottomsheet.a(getContext(), getTheme());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b extends BottomSheetBehavior.e {
        b() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NonNull View view, int i3) {
            if (i3 == 5) {
                BottomSheetDialogFragment.this.dismissAfterAnimation();
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NonNull View view, float f16) {
        }
    }
}
