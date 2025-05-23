package com.tencent.mobileqq.teamwork;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d {
    public static void a(Context context, DialogInterface.OnClickListener onClickListener) {
        DialogUtil.createCustomDialog(context, context.getString(R.string.f230626zn), (String) null, context.getString(R.string.f230616zm), R.string.f170836zr2, R.string.f170838zr4, onClickListener, (DialogInterface.OnClickListener) null).show();
    }
}
