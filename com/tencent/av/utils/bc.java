package com.tencent.av.utils;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.widget.ActionSheet;

/* compiled from: P */
/* loaded from: classes3.dex */
public class bc extends ActionSheet {
    public static boolean D = false;
    boolean C;

    protected bc(Context context, boolean z16, boolean z17) {
        super(context, z16, z17, true);
        this.C = false;
    }

    public static bc n0(Context context) {
        return o0(context, false);
    }

    public static bc o0(Context context, boolean z16) {
        bc bcVar = new bc(context, false, false);
        if (z16) {
            bcVar.getWindow().setWindowAnimations(R.style.MenuDialogAnimation);
        }
        return bcVar;
    }

    public static boolean p0() {
        return D;
    }

    @Override // com.tencent.widget.ActionSheet, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        D = false;
        this.C = false;
        super.dismiss();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        if (this.C) {
            D = false;
            this.C = false;
        }
        super.onDetachedFromWindow();
    }

    @Override // com.tencent.widget.ActionSheet, com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog, android.app.Dialog
    public void onStop() {
        if (this.C) {
            D = false;
            this.C = false;
        }
        super.onStop();
    }

    @Override // com.tencent.widget.ActionSheet, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        if (D) {
            return;
        }
        D = true;
        this.C = true;
        super.show();
    }
}
