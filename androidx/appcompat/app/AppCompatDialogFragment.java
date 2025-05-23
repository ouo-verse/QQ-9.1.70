package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment;

/* compiled from: P */
/* loaded from: classes.dex */
public class AppCompatDialogFragment extends ReportAndroidXDialogFragment {
    static IPatchRedirector $redirector_;

    public AppCompatDialogFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Dialog) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
        }
        return new AppCompatDialog(getContext(), getTheme());
    }

    @Override // androidx.fragment.app.DialogFragment
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setupDialog(@NonNull Dialog dialog, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) dialog, i3);
            return;
        }
        if (dialog instanceof AppCompatDialog) {
            AppCompatDialog appCompatDialog = (AppCompatDialog) dialog;
            if (i3 != 1 && i3 != 2) {
                if (i3 == 3) {
                    dialog.getWindow().addFlags(24);
                } else {
                    return;
                }
            }
            appCompatDialog.supportRequestWindowFeature(1);
            return;
        }
        super.setupDialog(dialog, i3);
    }
}
