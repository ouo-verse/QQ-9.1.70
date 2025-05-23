package com.tencent.mobileqq.qqlive.anchor.beauty.widget;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a extends ReportDialog {
    static IPatchRedirector $redirector_;
    private QQLiveLoadingView C;

    public a(@NonNull Context context) {
        super(context, R.style.au7);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.h_e);
        this.C = (QQLiveLoadingView) findViewById(R.id.t5t);
    }

    public void N(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) onClickListener);
        }
    }

    public void O(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.C.setProgress(i3);
        }
    }
}
