package com.tenpay.proxy;

import android.content.Context;
import android.content.DialogInterface;
import android.view.animation.AnimationUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;

/* loaded from: classes27.dex */
public class QQProxyDialog extends QQCustomDialog {
    public QQProxyDialog(Context context) {
        super(context);
    }

    public void playShakeAnim(int i3) {
        if (this.text != null) {
            this.text.startAnimation(AnimationUtils.loadAnimation(getContext(), i3));
        }
    }

    protected QQProxyDialog(Context context, boolean z16, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z16, onCancelListener);
    }

    public QQProxyDialog(Context context, int i3) {
        super(context, i3);
    }
}
