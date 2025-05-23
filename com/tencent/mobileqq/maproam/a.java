package com.tencent.mobileqq.maproam;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static ProgressDialog a(Context context, String str) {
        Drawable drawable = context.getResources().getDrawable(R.drawable.sc_publish_spinner_temp);
        ReportProgressDialog reportProgressDialog = new ReportProgressDialog(context, R.style.qZoneInputDialog);
        reportProgressDialog.show();
        reportProgressDialog.getWindow().setContentView(R.layout.account_wait);
        reportProgressDialog.setContentView(R.layout.account_wait);
        ((TextView) reportProgressDialog.findViewById(R.id.dialogText)).setText(str);
        ((ProgressBar) reportProgressDialog.findViewById(R.id.cib)).setIndeterminateDrawable(drawable);
        return reportProgressDialog;
    }
}
