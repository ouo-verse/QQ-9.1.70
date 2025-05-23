package com.tencent.widget;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class a extends ReportDialog {
    static IPatchRedirector $redirector_;
    private final boolean C;

    public a(@NonNull Context context, int i3, boolean z16) {
        super(context, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            this.C = z16;
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else if (this.C) {
            super.onBackPressed();
        }
    }
}
