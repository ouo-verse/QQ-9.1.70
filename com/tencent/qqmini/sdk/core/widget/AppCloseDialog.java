package com.tencent.qqmini.sdk.core.widget;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.R;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AppCloseDialog extends ReportDialog {
    public static final int WHICH_CANCEL = 2;
    public static final int WHICH_NEGATIVE = 0;
    public static final int WHICH_POSITIVE = 1;
    protected LinearLayout bodyLayout;
    protected TextView lBtn;
    protected TextView rBtn;
    ViewGroup rootView;
    Object tag;
    protected TextView title;

    @TargetApi(14)
    public AppCloseDialog(Context context) {
        super(context);
        super.getWindow().setWindowAnimations(R.style.mini_sdk_CustomAnimationDialog);
        getWindow().setDimAmount(0.5f);
    }

    public AppCloseDialog addCenterView(View view, LinearLayout.LayoutParams layoutParams) {
        this.bodyLayout.addView(view, layoutParams);
        this.bodyLayout.setGravity(17);
        return this;
    }

    public AppCloseDialog addView(View view) {
        this.bodyLayout.addView(view, new LinearLayout.LayoutParams(-1, -2));
        return this;
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.getText().add(getContext().getString(R.string.mini_sdk_content_desc_dialog_hint));
        }
        super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Dialog.class.getName());
        return false;
    }

    public void setBodyLayoutNoMargin() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bodyLayout.getLayoutParams();
        layoutParams.setMargins(0, layoutParams.topMargin, 0, 0);
        this.bodyLayout.setLayoutParams(layoutParams);
    }

    public void setButtonTextBold() {
        this.lBtn.setTypeface(Typeface.DEFAULT, 1);
        this.rBtn.setTypeface(Typeface.DEFAULT, 1);
    }

    @Override // android.app.Dialog
    public void setContentView(int i3) {
        super.setContentView(i3);
        this.title = (TextView) findViewById(R.id.dialogTitle);
        this.lBtn = (TextView) findViewById(R.id.dialogLeftBtn);
        this.rBtn = (TextView) findViewById(R.id.dialogRightBtn);
        this.lBtn.setVisibility(8);
        this.rBtn.setVisibility(8);
        this.bodyLayout = (LinearLayout) findViewById(R.id.bodyLayout);
        this.rootView = (ViewGroup) findViewById(R.id.dialogRoot);
    }

    public AppCloseDialog setNegativeButton(String str, final DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.lBtn.setVisibility(8);
            return this;
        }
        this.lBtn.setText(str);
        this.lBtn.setContentDescription(str + getContext().getString(R.string.mini_sdk_content_desc_button));
        this.lBtn.setVisibility(0);
        this.lBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.sdk.core.widget.AppCloseDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                DialogInterface.OnClickListener onClickListener2 = onClickListener;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(AppCloseDialog.this, 0);
                } else {
                    try {
                        if (AppCloseDialog.this.isShowing()) {
                            AppCloseDialog.this.dismiss();
                        }
                    } catch (Exception unused) {
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        return this;
    }

    public AppCloseDialog setPositiveButton(String str, final DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.rBtn.setVisibility(8);
            return this;
        }
        this.rBtn.setText(str);
        this.rBtn.setContentDescription(str + getContext().getString(R.string.mini_sdk_content_desc_button));
        this.rBtn.setVisibility(0);
        this.rBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.sdk.core.widget.AppCloseDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                DialogInterface.OnClickListener onClickListener2 = onClickListener;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(AppCloseDialog.this, 1);
                } else {
                    try {
                        if (AppCloseDialog.this.isShowing()) {
                            AppCloseDialog.this.dismiss();
                        }
                    } catch (Exception unused) {
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        return this;
    }

    public void setTextSingleLine(boolean z16) {
        this.title.setSingleLine(z16);
    }

    public AppCloseDialog setTitle(String str) {
        if (str != null) {
            this.title.setText(str);
            this.title.setVisibility(0);
        } else {
            this.title.setVisibility(8);
        }
        return this;
    }

    public void setTitleHeight(int i3) {
        this.title.setHeight(i3);
    }

    public void setTitleTextBold() {
        this.title.setTypeface(Typeface.DEFAULT, 1);
    }

    public AppCloseDialog setView(View view) {
        this.bodyLayout.addView(view, new LinearLayout.LayoutParams(-1, -2));
        return this;
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        if (this.rBtn.getVisibility() != 8 && this.lBtn.getVisibility() != 8) {
            findViewById(R.id.btnDivider).setVisibility(0);
        }
        super.show();
    }

    public AppCloseDialog addView(View view, LinearLayout.LayoutParams layoutParams) {
        this.bodyLayout.addView(view, layoutParams);
        return this;
    }

    @TargetApi(14)
    protected AppCloseDialog(Context context, boolean z16, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z16, onCancelListener);
        super.getWindow().setWindowAnimations(R.style.mini_sdk_CustomAnimationDialog);
        getWindow().setDimAmount(0.5f);
    }

    public AppCloseDialog setNegativeButton(String str, int i3, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.lBtn.setVisibility(8);
            return this;
        }
        this.lBtn.setTextColor(i3);
        return setNegativeButton(str, onClickListener);
    }

    public AppCloseDialog setPositiveButton(String str, int i3, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.rBtn.setVisibility(8);
            return this;
        }
        this.rBtn.setTextColor(i3);
        return setPositiveButton(str, onClickListener);
    }

    @TargetApi(14)
    public AppCloseDialog(Context context, int i3) {
        super(context, i3);
        super.getWindow().setWindowAnimations(R.style.mini_sdk_CustomAnimationDialog);
        getWindow().setDimAmount(0.5f);
    }
}
