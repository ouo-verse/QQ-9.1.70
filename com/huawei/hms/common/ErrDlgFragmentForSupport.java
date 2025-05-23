package com.huawei.hms.common;

import android.app.Dialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import com.huawei.hms.common.internal.Preconditions;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportDialogFragment;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ErrDlgFragmentForSupport extends ReportDialogFragment {

    /* renamed from: a, reason: collision with root package name */
    private Dialog f36781a = null;

    /* renamed from: b, reason: collision with root package name */
    private DialogInterface.OnCancelListener f36782b = null;

    public static ErrDlgFragmentForSupport newInstance(Dialog dialog) {
        return newInstance(dialog, null);
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f36782b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportDialogFragment, android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f36781a == null) {
            setShowsDialog(false);
        }
        return this.f36781a;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        Preconditions.checkNotNull(fragmentManager, "FragmentManager cannot be null!");
        super.show(fragmentManager, str);
    }

    public static ErrDlgFragmentForSupport newInstance(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        Preconditions.checkNotNull(dialog, "Dialog cannot be null!");
        ErrDlgFragmentForSupport errDlgFragmentForSupport = new ErrDlgFragmentForSupport();
        errDlgFragmentForSupport.f36781a = dialog;
        dialog.setOnCancelListener(null);
        errDlgFragmentForSupport.f36781a.setOnDismissListener(null);
        errDlgFragmentForSupport.f36782b = onCancelListener;
        return errDlgFragmentForSupport;
    }
}
