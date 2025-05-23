package com.tencent.qqmini.sdk.core.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.core.widget.AppCloseDialog;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;

/* compiled from: P */
/* loaded from: classes23.dex */
public class DialogUtil {
    public static final int ALERT_DIALOG = 230;

    public static AppCloseDialog createAppCloseDialog(Context context) {
        AppCloseDialog appCloseDialog = new AppCloseDialog(context, R.style.mini_sdk_MiniAppInputDialog);
        if (appCloseDialog.getWindow() != null) {
            Window window = appCloseDialog.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams attributes = appCloseDialog.getWindow().getAttributes();
            window.setGravity(17);
            appCloseDialog.getWindow().setAttributes(attributes);
        }
        appCloseDialog.setContentView(R.layout.mini_sdk_app_close_dialog);
        appCloseDialog.setTitle((String) null);
        appCloseDialog.setNegativeButton(null, null);
        appCloseDialog.setPositiveButton(null, null);
        appCloseDialog.setBodyLayoutNoMargin();
        appCloseDialog.setCanceledOnTouchOutside(false);
        return appCloseDialog;
    }

    public static AppCloseDialog createCloseAlertDialog(Context context, int i3, String str, String str2, String str3, float f16, boolean z16, boolean z17, boolean z18, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AppCloseDialog appCloseDialog = new AppCloseDialog(context, i3);
        if (appCloseDialog.getWindow() != null) {
            Window window = appCloseDialog.getWindow();
            window.requestFeature(1);
            window.setBackgroundDrawableResource(17170445);
            window.setGravity(17);
        }
        appCloseDialog.setContentView(R.layout.mini_sdk_app_close_dialog);
        appCloseDialog.setTitle(str);
        appCloseDialog.setTextSingleLine(z16);
        appCloseDialog.setNegativeButton(str2, onClickListener);
        appCloseDialog.setPositiveButton(str3, onClickListener2);
        if (f16 > 0.0f) {
            appCloseDialog.setTitleHeight((int) ((f16 * context.getResources().getDisplayMetrics().density) + 0.5f));
        }
        if (z17) {
            appCloseDialog.setTitleTextBold();
        }
        if (z18) {
            appCloseDialog.setButtonTextBold();
        }
        appCloseDialog.setBodyLayoutNoMargin();
        appCloseDialog.setCancelable(false);
        return appCloseDialog;
    }

    public static MiniCustomDialog createCustomDialog(Context context, int i3) {
        return createCustomDialog(context, i3, (String) null, (String) null, R.string.mini_sdk_cancel, R.string.mini_sdk_ok, (DialogInterface.OnClickListener) null, (DialogInterface.OnClickListener) null);
    }

    public static MiniCustomDialog createCustomDialog(Context context, int i3, String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        return createCustomDialog(context, i3, str, str2, R.string.mini_sdk_cancel, R.string.mini_sdk_ok, onClickListener, onClickListener2);
    }

    public static MiniCustomDialog createCustomDialog(Context context, int i3, String str, String str2, int i16, int i17, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        MiniCustomDialog miniCustomDialog = new MiniCustomDialog(context, R.style.mini_sdk_MiniAppInputDialog);
        miniCustomDialog.setContentView(R.layout.mini_sdk_custom_dialog_temp);
        miniCustomDialog.setTitle(str);
        miniCustomDialog.setMessage(str2);
        miniCustomDialog.setNegativeButton(i16, onClickListener2);
        miniCustomDialog.setPositiveButton(i17, onClickListener);
        miniCustomDialog.setCanceledOnTouchOutside(false);
        return miniCustomDialog;
    }

    public static MiniCustomDialog createCustomDialog(Context context, int i3, String str, CharSequence charSequence, String str2, String str3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        MiniCustomDialog miniCustomDialog = new MiniCustomDialog(context, R.style.mini_sdk_MiniAppInputDialog);
        miniCustomDialog.setContentView(R.layout.mini_sdk_custom_dialog_temp);
        miniCustomDialog.setTitle(str);
        miniCustomDialog.setMessage(charSequence);
        miniCustomDialog.setNegativeButton(str2, onClickListener2);
        miniCustomDialog.setPositiveButton(str3, onClickListener);
        miniCustomDialog.setCanceledOnTouchOutside(false);
        return miniCustomDialog;
    }
}
