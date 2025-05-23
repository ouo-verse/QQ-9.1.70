package com.huawei.hms.common;

import android.app.Dialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import com.huawei.hms.common.internal.Preconditions;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportDialogFragment;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ErrorDialogFragment extends ReportDialogFragment {

    /* renamed from: a, reason: collision with root package name */
    private Dialog f36783a = null;

    /* renamed from: b, reason: collision with root package name */
    private DialogInterface.OnCancelListener f36784b = null;

    public static ErrorDialogFragment newInstance(Dialog dialog) {
        return newInstance(dialog, null);
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f36784b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportDialogFragment, android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f36783a == null) {
            setShowsDialog(false);
        }
        return this.f36783a;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        Preconditions.checkNotNull(fragmentManager, "FragmentManager cannot be null!");
        super.show(fragmentManager, str);
    }

    public static ErrorDialogFragment newInstance(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        Preconditions.checkNotNull(dialog, "Dialog cannot be null!");
        ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
        errorDialogFragment.f36783a = dialog;
        dialog.setOnCancelListener(null);
        errorDialogFragment.f36783a.setOnDismissListener(null);
        if (onCancelListener != null) {
            errorDialogFragment.f36784b = onCancelListener;
        }
        return errorDialogFragment;
    }
}
