package com.tencent.mobileqq.dating;

import android.app.Activity;
import android.content.DialogInterface;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

/* compiled from: P */
/* loaded from: classes10.dex */
class DatingUtil$1 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Activity f203362d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f203363e;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DatingUtil$1.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.f203362d, 230, (String) null, this.f203363e, 0, R.string.i5e, new a(), (DialogInterface.OnClickListener) null);
        if (createCustomDialog != null) {
            ((TextView) createCustomDialog.findViewById(R.id.bit)).setVisibility(8);
            TextView textView = (TextView) createCustomDialog.findViewById(R.id.dialogText);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            textView.setLayoutParams(layoutParams);
            textView.setMinHeight(x.c(this.f203362d, 35.0f));
            textView.setGravity(17);
            createCustomDialog.show();
        }
    }
}
