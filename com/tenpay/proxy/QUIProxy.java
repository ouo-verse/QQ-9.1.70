package com.tenpay.proxy;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import org.apache.httpcore.message.TokenParser;

/* loaded from: classes27.dex */
public class QUIProxy {
    public static final int ALERT_DIALOG = 230;
    public static final int ICON_DEFAULT = 0;
    public static final int ICON_ERROR = 1;
    public static final int ICON_NONE = -1;
    public static final int ICON_SUCCESS = 2;
    private static final String TAG = "QUIProxy";

    public static Dialog createCustomDialog(Context context, int i3, String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, i3, str, toDBC(str2), str3, str4, onClickListener, onClickListener2);
        createCustomDialog.setCancelable(false);
        createCustomDialog.setCanceledOnTouchOutside(false);
        try {
            createCustomDialog.show();
            return createCustomDialog;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
            return null;
        }
    }

    public static void createCustomDialogUrlWithoutAutoLink(Context context, int i3, String str, SpannableString spannableString, int i16, int i17, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog createCustomDialogUrlWithoutAutoLink = DialogUtil.createCustomDialogUrlWithoutAutoLink(context, i3, str, spannableString, i16, i17, onClickListener, onClickListener2);
        createCustomDialogUrlWithoutAutoLink.setCancelable(false);
        createCustomDialogUrlWithoutAutoLink.setCanceledOnTouchOutside(false);
        createCustomDialogUrlWithoutAutoLink.show();
    }

    public static QQProxyDialog createCustomDialogWithImage(Context context, int i3, int i16, int i17, int i18, String str, String str2, int i19, int i26, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQProxyDialog qQProxyDialog = new QQProxyDialog(context, i16);
        qQProxyDialog.setContentView(i3);
        ImageView imageView = (ImageView) qQProxyDialog.findViewById(i17);
        Drawable drawable = context.getResources().getDrawable(i18);
        if (drawable != null) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        imageView.setImageDrawable(drawable);
        qQProxyDialog.setTitle(str);
        if (!TextUtils.isEmpty(str2)) {
            qQProxyDialog.setMessage(str2);
        }
        qQProxyDialog.setNegativeButton(i19, onClickListener2);
        qQProxyDialog.setPositiveButton(i26, onClickListener);
        qQProxyDialog.setCancelable(false);
        qQProxyDialog.setCanceledOnTouchOutside(false);
        return qQProxyDialog;
    }

    public static Dialog createVerticalThreeBtnDialog(Context context, int i3, String str, CharSequence charSequence, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog createVerticalThreeBtnDialog = DialogUtil.createVerticalThreeBtnDialog(context, i3, str, charSequence, str2, str3, str4, onClickListener, onClickListener2);
        createVerticalThreeBtnDialog.setCancelable(false);
        createVerticalThreeBtnDialog.show();
        return createVerticalThreeBtnDialog;
    }

    public static Dialog showConfirm(Context context, String str, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            onClickListener = new DialogInterface.OnClickListener() { // from class: com.tenpay.proxy.QUIProxy.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                }
            };
        }
        return createCustomDialog(context, 230, null, str, null, HardCodeUtil.qqStr(R.string.ket), onClickListener, null);
    }

    public static Dialog showWaitingDialog(Context context, String str, int i3) {
        QQProgressDialog qQProgressDialog = new QQProgressDialog(context, context.getResources().getDimensionPixelSize(i3));
        qQProgressDialog.setMessage(str);
        qQProgressDialog.show();
        return qQProgressDialog;
    }

    public static String toDBC(String str) {
        if (!TextUtils.isEmpty(str)) {
            char[] charArray = str.toCharArray();
            for (int i3 = 0; i3 < charArray.length; i3++) {
                char c16 = charArray[i3];
                if (c16 == '\u3000') {
                    charArray[i3] = TokenParser.SP;
                } else if (c16 > '\uff00' && c16 < '\uff5f') {
                    charArray[i3] = (char) (c16 - '\ufee0');
                }
            }
            return new String(charArray);
        }
        return null;
    }

    public static QQCustomDialog createCustomDialogUrlWithoutAutoLink(Context context, int i3, int i16, String str, SpannableString spannableString, String str2, String str3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(context, i16);
        qQCustomDialog.setContentView(i3);
        qQCustomDialog.setTitle(str);
        qQCustomDialog.setMessageWithoutAutoLink(spannableString);
        qQCustomDialog.setNegativeButton(str2, onClickListener2);
        qQCustomDialog.setPositiveButton(str3, onClickListener);
        qQCustomDialog.setCancelable(false);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        qQCustomDialog.show();
        return qQCustomDialog;
    }

    public static void startNumAnimation(TextView textView, int i3, int i16, boolean z16, double d16, double d17, long j3) {
    }
}
