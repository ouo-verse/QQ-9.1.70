package com.tencent.mobileqq.util;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class t {
    public static Dialog a(Context context, int i3, int i16, int i17, int i18, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        String string = context.getResources().getString(i3);
        String string2 = context.getResources().getString(i16);
        String string3 = context.getResources().getString(i17);
        String string4 = context.getResources().getString(i18);
        ReportDialog reportDialog = new ReportDialog(context, R.style.qZoneInputDialog);
        reportDialog.setContentView(R.layout.custom_dialog);
        TextView textView = (TextView) reportDialog.findViewById(R.id.dialogTitle);
        if (textView != null) {
            textView.setText(string);
            textView.setContentDescription(string);
        }
        TextView textView2 = (TextView) reportDialog.findViewById(R.id.dialogText);
        if (textView2 != null) {
            textView2.setText(string2);
            textView2.setContentDescription(string2);
        }
        TextView textView3 = (TextView) reportDialog.findViewById(R.id.dialogLeftBtn);
        if (textView3 != null) {
            textView3.setText(string3);
            textView3.setContentDescription(string3);
            if (onClickListener != null) {
                textView3.setOnClickListener(onClickListener);
            }
        }
        TextView textView4 = (TextView) reportDialog.findViewById(R.id.dialogRightBtn);
        if (textView4 != null) {
            textView4.setText(string4);
            textView4.setContentDescription(string4);
            if (onClickListener2 != null) {
                textView4.setOnClickListener(onClickListener2);
            }
        }
        return reportDialog;
    }

    public static Dialog b(Context context, String str, String str2, DialogInterface.OnDismissListener onDismissListener) {
        ReportDialog reportDialog = new ReportDialog(context, R.style.qZoneInputDialog);
        reportDialog.setContentView(R.layout.custom_dialog);
        TextView textView = (TextView) reportDialog.findViewById(R.id.dialogTitle);
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = (TextView) reportDialog.findViewById(R.id.dialogText);
        if (textView2 != null) {
            textView2.setText(str2);
        }
        TextView textView3 = (TextView) reportDialog.findViewById(R.id.dialogLeftBtn);
        if (textView3 != null) {
            textView3.setText(R.string.f170604vb);
        }
        TextView textView4 = (TextView) reportDialog.findViewById(R.id.dialogRightBtn);
        if (textView4 != null) {
            textView4.setText(R.string.button_back);
        }
        reportDialog.setOnDismissListener(onDismissListener);
        return reportDialog;
    }

    public static Dialog c(Context context, int i3) {
        ReportDialog reportDialog = new ReportDialog(context, i3);
        Window window = reportDialog.getWindow();
        if (window != null) {
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                window.addFlags(67108864);
            }
            ImmersiveUtils.clearCoverForStatus(window, true);
        }
        return reportDialog;
    }
}
