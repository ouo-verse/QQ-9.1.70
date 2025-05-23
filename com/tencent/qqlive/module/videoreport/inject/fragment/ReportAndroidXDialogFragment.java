package com.tencent.qqlive.module.videoreport.inject.fragment;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ReportAndroidXDialogFragment extends DialogFragment {
    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        return new ReportDialog(getActivity(), getTheme());
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        AndroidXFragmentCollector.onDestroyView(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z16) {
        super.onHiddenChanged(z16);
        AndroidXFragmentCollector.onHiddenChanged(this, z16);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        AndroidXFragmentCollector.onPause(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AndroidXFragmentCollector.onResume(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z16) {
        super.setUserVisibleHint(z16);
        AndroidXFragmentCollector.setUserVisibleHint(this, z16);
    }
}
