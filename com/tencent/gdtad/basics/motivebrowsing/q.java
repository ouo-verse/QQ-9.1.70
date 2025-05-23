package com.tencent.gdtad.basics.motivebrowsing;

import android.content.Context;
import android.content.DialogInterface;
import android.view.WindowManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes6.dex */
public class q extends QQCustomDialog {
    private static int C;

    public q(@NotNull Context context, int i3) {
        super(context, i3);
    }

    private void N() {
        if (getRootView() != null && getRootView().getLayoutParams() != null) {
            if (getWindow() != null && getWindow().getAttributes() != null) {
                if (C != 0) {
                    return;
                }
                int i3 = getRootView().getLayoutParams().width;
                int dip2px = i3 - ViewUtils.dip2px(20.0f);
                QLog.d("GdtMotiveBrowsingRetainDialog", 1, "originWidth: " + i3 + ", adjustedWidth: " + dip2px);
                if (i3 == 0) {
                    return;
                }
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.height = dip2px;
                getWindow().setAttributes(attributes);
                float f16 = dip2px;
                float f17 = f16 / 2.0f;
                getRootView().setPivotX(f17);
                getRootView().setPivotY(f17);
                getRootView().setTranslationX(f16 / 3.0f);
                getRootView().setTranslationY(ViewUtils.dip2px(10.0f));
                getRootView().setScaleX(f16 / i3);
                getRootView().setRotation(-90.0f);
                return;
            }
            QLog.e("GdtMotiveBrowsingRetainDialog", 1, "show fail : getWindow() is null");
            return;
        }
        QLog.e("GdtMotiveBrowsingRetainDialog", 1, "show fail : getRootView() is null");
    }

    public static q O(Context context, int i3, CharSequence charSequence, String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        q qVar = new q(context, R.style.qZoneInputDialog);
        qVar.setContentView(R.layout.f167856jn);
        qVar.setTitle((String) null);
        qVar.setMessage(charSequence);
        qVar.setNegativeButton(str, onClickListener2);
        qVar.setPositiveButton(str2, onClickListener);
        qVar.setCanceledOnTouchOutside(false);
        C = i3;
        return qVar;
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        N();
        super.show();
    }
}
