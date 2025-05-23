package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QQCustomDialogForMiniGame extends QQCustomDialog {
    public QQCustomDialogForMiniGame(Context context) {
        super(context);
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog
    public void setBodyLayoutNoMargin() {
        findViewById(R.id.biw).setVisibility(8);
        this.rootView.setPadding(0, 0, 0, 0);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bodyLayout.getLayoutParams();
        layoutParams.setMargins(0, 0, 0, 0);
        this.bodyLayout.setLayoutParams(layoutParams);
    }

    protected QQCustomDialogForMiniGame(Context context, boolean z16, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z16, onCancelListener);
    }

    public QQCustomDialogForMiniGame(Context context, int i3) {
        super(context, i3);
    }
}
