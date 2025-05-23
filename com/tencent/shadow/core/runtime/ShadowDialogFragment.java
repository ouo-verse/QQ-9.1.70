package com.tencent.shadow.core.runtime;

import android.content.DialogInterface;
import android.os.Bundle;

/* compiled from: P */
/* loaded from: classes25.dex */
public class ShadowDialogFragment extends ShadowFragment {
    private ContainerDialogFragment getContainerDialogFragment() {
        return (ContainerDialogFragment) this.mContainerFragment;
    }

    public void dismiss() {
        getContainerDialogFragment().dismiss();
    }

    public void dismissAllowingStateLoss() {
        getContainerDialogFragment().dismissAllowingStateLoss();
    }

    public ShadowDialog getDialog() {
        return (ShadowDialog) getContainerDialogFragment().getDialog();
    }

    public boolean getShowsDialog() {
        return getContainerDialogFragment().getShowsDialog();
    }

    public int getTheme() {
        return getContainerDialogFragment().getTheme();
    }

    public ShadowDialog onCreateDialog(Bundle bundle) {
        return new ShadowDialog(getActivity(), getTheme());
    }

    public void onDismiss(DialogInterface dialogInterface) {
        getContainerDialogFragment().superOnDismiss(dialogInterface);
    }

    public void setCancelable(boolean z16) {
        if (this.mIsAppCreateFragment) {
            getContainerDialogFragment().setCancelable(z16);
        }
    }

    public void setShowsDialog(boolean z16) {
        getContainerDialogFragment().setShowsDialog(z16);
    }

    public void setStyle(int i3, int i16) {
        if (this.mIsAppCreateFragment) {
            getContainerDialogFragment().setStyle(i3, i16);
        }
    }

    public void show(PluginFragmentManager pluginFragmentManager, String str) {
        getContainerDialogFragment().show(pluginFragmentManager.mBase, str);
    }

    public void onCancel(DialogInterface dialogInterface) {
    }
}
