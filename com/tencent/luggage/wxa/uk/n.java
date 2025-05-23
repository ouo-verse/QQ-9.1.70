package com.tencent.luggage.wxa.uk;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog;
import com.tencent.mm.ui.widget.dialog.WeUIProgresssDialog;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class n {
    public static ProgressDialog a(Context context, CharSequence charSequence, boolean z16, DialogInterface.OnCancelListener onCancelListener) {
        return WeUIProgresssDialog.show(context, charSequence, z16, onCancelListener);
    }

    public static MMAlertDialog a(Context context, String str, String str2, DialogInterface.OnClickListener onClickListener) {
        MMAlertDialog create = new MMAlertDialog.Builder(context).setTitle(str).setPositiveBtnText(str2).setPositiveBtnListener(onClickListener).create();
        create.show();
        return create;
    }

    public static MMAlertDialog a(Context context, String str, String str2, boolean z16, DialogInterface.OnClickListener onClickListener) {
        MMAlertDialog create = new MMAlertDialog.Builder(context).setTitle(str2).setMsg(str).setPositiveBtnText(R.string.f1640324q).setPositiveBtnListener(onClickListener).setCancelable(z16).create();
        create.show();
        return create;
    }
}
