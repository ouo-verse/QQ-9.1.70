package com.tenpay.api;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.widget.EditText;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.view.WalletProgressDialog;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QWalletUtils {
    private static final String TAG = "QWalletUtils";

    public static StateListDrawable getStateListDrawable(int i3, int i16) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, new ColorDrawable(i16));
        stateListDrawable.addState(new int[0], new ColorDrawable(i3));
        return stateListDrawable;
    }

    public static void hideSysKeyBorad(EditText editText) {
        if (editText == null) {
            return;
        }
        try {
            try {
                Method method = EditText.class.getMethod("setShowSoftInputOnFocus", Boolean.TYPE);
                method.setAccessible(true);
                method.invoke(editText, Boolean.FALSE);
            } catch (NoSuchMethodException unused) {
                Method method2 = EditText.class.getMethod("setSoftInputShownOnFocus", Boolean.TYPE);
                method2.setAccessible(true);
                method2.invoke(editText, Boolean.FALSE);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "", e16);
            }
        } catch (Exception e17) {
            editText.setInputType(0);
            QLog.e(TAG, 1, "", e17);
        }
    }

    public static Dialog showQQPayLoading(Context context) {
        return new WalletProgressDialog(context);
    }
}
