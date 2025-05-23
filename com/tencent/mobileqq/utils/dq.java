package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes20.dex */
public class dq {
    public static QQCustomDialog a(Context context, int i3, String str, String str2, int i16, int i17, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(context, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.f167856jn);
        qQCustomDialog.setTitle(str);
        qQCustomDialog.setMessage(str2);
        qQCustomDialog.setNegativeButton(i16, onClickListener2);
        qQCustomDialog.setPositiveButton(i17, onClickListener);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        return qQCustomDialog;
    }
}
