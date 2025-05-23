package com.tencent.mobileqq.activity.contact.addcontact;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class h extends ReportDialog {
    static IPatchRedirector $redirector_;
    private View C;
    private String D;

    public h(Context context) {
        super(context, R.style.f173741jd);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.b4k, (ViewGroup) null);
        Window window = getWindow();
        window.setContentView(inflate);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -2;
        attributes.height = -2;
        attributes.gravity = 48;
        attributes.y += getContext().getResources().getDimensionPixelOffset(R.dimen.b1u);
        window.setAttributes(attributes);
        if (!TextUtils.isEmpty(this.D) && (textView = (TextView) inflate.findViewById(R.id.f18)) != null) {
            textView.setText(this.D);
        }
        this.C = inflate;
        setCanceledOnTouchOutside(false);
    }

    public h(Context context, String str) {
        super(context, R.style.f173741jd);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.D = str;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) str);
        }
    }
}
