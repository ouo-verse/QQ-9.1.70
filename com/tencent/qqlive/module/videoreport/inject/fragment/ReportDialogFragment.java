package com.tencent.qqlive.module.videoreport.inject.fragment;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ReportDialogFragment extends DialogFragment {
    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        return new ReportDialog(getActivity(), getTheme());
    }
}
