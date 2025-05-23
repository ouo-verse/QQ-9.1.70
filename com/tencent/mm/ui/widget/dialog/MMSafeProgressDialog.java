package com.tencent.mm.ui.widget.dialog;

import android.app.ProgressDialog;
import android.content.Context;

/* loaded from: classes9.dex */
public class MMSafeProgressDialog extends ProgressDialog {
    public MMSafeProgressDialog(Context context) {
        super(context);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
        }
    }

    public MMSafeProgressDialog(Context context, int i3) {
        super(context, i3);
    }
}
