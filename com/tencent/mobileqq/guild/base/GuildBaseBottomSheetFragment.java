package com.tencent.mobileqq.guild.base;

import android.content.DialogInterface;
import androidx.annotation.NonNull;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildBaseBottomSheetFragment extends BottomSheetDialogFragment {
    private DialogInterface.OnDismissListener C;

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogInterface.OnDismissListener onDismissListener = this.C;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    public void ph(DialogInterface.OnDismissListener onDismissListener) {
        this.C = onDismissListener;
    }
}
