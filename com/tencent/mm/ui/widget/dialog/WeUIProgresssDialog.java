package com.tencent.mm.ui.widget.dialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.luggage.wxa.lo.n;
import com.tencent.mobileqq.R;

/* loaded from: classes9.dex */
public class WeUIProgresssDialog extends ProgressDialog {

    /* renamed from: a, reason: collision with root package name */
    public Context f153182a;

    /* renamed from: b, reason: collision with root package name */
    public View f153183b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f153184c;

    /* renamed from: d, reason: collision with root package name */
    public ProgressBar f153185d;

    public WeUIProgresssDialog(Context context) {
        super(context);
        this.f153182a = context;
        d();
    }

    private void d() {
        View inflate = View.inflate(this.f153182a, R.layout.f169182i45, null);
        this.f153183b = inflate;
        this.f153184c = (TextView) inflate.findViewById(R.id.jsg);
        this.f153185d = (ProgressBar) this.f153183b.findViewById(R.id.f99205p6);
        setCanceledOnTouchOutside(true);
    }

    public static WeUIProgresssDialog getProgressDialog(Context context, CharSequence charSequence, boolean z16, DialogInterface.OnCancelListener onCancelListener) {
        WeUIProgresssDialog weUIProgresssDialog = new WeUIProgresssDialog(context, R.style.ajl);
        weUIProgresssDialog.setMessage(charSequence);
        weUIProgresssDialog.setCancelable(z16);
        weUIProgresssDialog.setOnCancelListener(onCancelListener);
        weUIProgresssDialog.setCanceledOnTouchOutside(z16);
        return weUIProgresssDialog;
    }

    public static WeUIProgresssDialog show(Context context, CharSequence charSequence, boolean z16, DialogInterface.OnCancelListener onCancelListener) {
        WeUIProgresssDialog progressDialog = getProgressDialog(context, charSequence, z16, onCancelListener);
        progressDialog.show();
        return progressDialog;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e16) {
            n.b("WeUI.WeUIProgresssDialog", "dismiss exception, e = " + e16.getMessage(), new Object[0]);
        }
    }

    public void hideProgress() {
        ProgressBar progressBar = this.f153185d;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    @Override // android.app.ProgressDialog, android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.f153183b, new LinearLayout.LayoutParams(-1, -1));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -2;
        attributes.height = -2;
        onWindowAttributesChanged(attributes);
    }

    @Override // android.app.Dialog, com.tencent.luggage.wxa.ml.m.a
    public void setCancelable(boolean z16) {
        super.setCancelable(z16);
        setCanceledOnTouchOutside(z16);
    }

    @Override // android.app.ProgressDialog, android.app.AlertDialog
    public void setMessage(CharSequence charSequence) {
        this.f153184c.setText(charSequence);
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
        } catch (Exception e16) {
            n.a("WeUI.WeUIProgresssDialog", e16, "", new Object[0]);
        }
    }

    public WeUIProgresssDialog(Context context, int i3) {
        super(context, i3);
        this.f153182a = context;
        d();
    }
}
