package com.tencent.qui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.DialogUtil;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static Dialog a(Context context, int i3, String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        return DialogUtil.createCustomDialog(context, i3, str, str2, str3, str4, onClickListener2, onClickListener);
    }
}
