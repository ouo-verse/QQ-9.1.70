package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ct extends QQCustomDialog {
    private int C;
    com.tencent.mobileqq.utils.dialogutils.a D;

    public ct(Context context, int i3) {
        super(context, i3);
        this.C = R.layout.custom_dialog_list_item;
    }

    public void N(int i3) {
        this.C = i3;
    }

    public void O(com.tencent.mobileqq.utils.dialogutils.a aVar, DialogInterface.OnClickListener onClickListener) {
        if (aVar == null) {
            return;
        }
        this.D = aVar;
        String[] strArr = new String[aVar.h()];
        for (int i3 = 0; i3 < aVar.h(); i3++) {
            strArr[i3] = aVar.f(i3).c();
        }
        setItems(strArr, onClickListener);
        String e16 = aVar.e();
        if (e16 != null) {
            setTitle(e16);
        }
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog
    protected int customWhichToCallBack(int i3) {
        com.tencent.mobileqq.utils.dialogutils.b f16 = this.D.f(i3);
        if (f16 != null) {
            return f16.b();
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog
    protected int getDialogListItemLayout() {
        return this.C;
    }
}
