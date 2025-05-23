package com.tencent.qqmini.sdk.widget;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class MiniCustomDialog extends ReportDialog {
    private static final String TAG = "MiniCustomDialog";
    public static final int WHICH_NEGATIVE = 0;
    public static final int WHICH_POSITIVE = 1;
    protected LinearLayout bodyLayout;
    protected TextView countText;
    protected ImageView dialogImage;
    protected TextView lBtn;
    private final BrandColorManager mBrandColorManager;
    protected TextView rBtn;
    ViewGroup rootView;
    protected TextView text;
    protected TextView title;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private static class BrandColorManager {
        static final int INVALID_COLOR = 0;
        private static final String TAG = "BrandColorManager";
        private int color;
        private View dialogBrandColorView;

        BrandColorManager() {
            this.color = 0;
        }

        private void setBrandBorderColor() {
            View view = this.dialogBrandColorView;
            if (view != null && this.color != 0) {
                Drawable mutate = view.getBackground().mutate();
                if (mutate instanceof GradientDrawable) {
                    ((GradientDrawable) mutate).setColor(this.color);
                } else {
                    QMLog.w(TAG, "set band border-color fail");
                }
            }
        }

        void setDialogBrandColorView(View view) {
            this.dialogBrandColorView = view;
            setBrandBorderColor();
        }
    }

    @TargetApi(14)
    public MiniCustomDialog(Context context) {
        super(context);
        this.mBrandColorManager = new BrandColorManager();
        super.getWindow().setWindowAnimations(R.style.mini_sdk_CustomAnimationDialog);
        getWindow().setDimAmount(0.5f);
    }

    public MiniCustomDialog addView(View view, LinearLayout.LayoutParams layoutParams) {
        this.text.setVisibility(8);
        this.countText.setVisibility(8);
        this.bodyLayout.addView(view, layoutParams);
        return this;
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e16) {
            QMLog.e(TAG, "dismiss exception, e=", e16);
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

    public TextView getBtnLeft() {
        return this.lBtn;
    }

    public TextView getBtnight() {
        return this.rBtn;
    }

    public ImageView getDialogImage() {
        return this.dialogImage;
    }

    public TextView getMessageTextView() {
        return this.text;
    }

    public TextView getTitleTextView() {
        return this.title;
    }

    @Override // android.app.Dialog
    public void setContentView(int i3) {
        super.setContentView(i3);
        this.title = (TextView) findViewById(R.id.dialogTitle);
        this.text = (TextView) findViewById(R.id.dialogText);
        this.dialogImage = (ImageView) findViewById(R.id.dialogImage);
        this.countText = (TextView) findViewById(R.id.dialogCountText);
        this.lBtn = (TextView) findViewById(R.id.dialogLeftBtn);
        this.rBtn = (TextView) findViewById(R.id.dialogRightBtn);
        this.lBtn.setVisibility(8);
        this.rBtn.setVisibility(8);
        this.bodyLayout = (LinearLayout) findViewById(R.id.bodyLayout);
        this.rootView = (ViewGroup) findViewById(R.id.dialogRoot);
        this.mBrandColorManager.setDialogBrandColorView(findViewById(R.id.dialogBrandBorder));
    }

    public MiniCustomDialog setMessage(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.text.setText(charSequence);
            this.text.setContentDescription(charSequence);
            this.text.setVisibility(0);
        } else {
            this.text.setVisibility(8);
        }
        return this;
    }

    public MiniCustomDialog setNegativeButton(String str, final DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.lBtn.setVisibility(8);
            return this;
        }
        this.lBtn.setText(str);
        this.lBtn.setContentDescription(str + getContext().getString(R.string.mini_sdk_content_desc_button));
        this.lBtn.setVisibility(0);
        this.lBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.sdk.widget.MiniCustomDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                DialogInterface.OnClickListener onClickListener2 = onClickListener;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(MiniCustomDialog.this, 0);
                }
                try {
                    if (MiniCustomDialog.this.isShowing()) {
                        MiniCustomDialog.this.dismiss();
                    }
                } catch (Exception e16) {
                    QMLog.e(MiniCustomDialog.TAG, "lBtn click exception, e=", e16);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        return this;
    }

    public MiniCustomDialog setPositiveButton(String str, final DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.rBtn.setVisibility(8);
            return this;
        }
        this.rBtn.setText(str);
        this.rBtn.setContentDescription(str + getContext().getString(R.string.mini_sdk_content_desc_button));
        this.rBtn.setVisibility(0);
        this.rBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.sdk.widget.MiniCustomDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                DialogInterface.OnClickListener onClickListener2 = onClickListener;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(MiniCustomDialog.this, 1);
                }
                try {
                    if (MiniCustomDialog.this.isShowing()) {
                        MiniCustomDialog.this.dismiss();
                    }
                } catch (Exception e16) {
                    QMLog.e(MiniCustomDialog.TAG, "rBtn click exception, e=", e16);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        return this;
    }

    @Override // android.app.Dialog
    public void setTitle(int i3) {
        this.title.setText(i3);
        this.text.setContentDescription(getContext().getString(i3));
        this.title.setVisibility(0);
    }

    public void setTitleMutiLine() {
        this.title.setSingleLine(false);
    }

    public MiniCustomDialog setTitle(String str) {
        if (str != null) {
            this.title.setText(str);
            this.text.setContentDescription(str);
            this.title.setVisibility(0);
        } else {
            this.title.setVisibility(8);
        }
        return this;
    }

    @TargetApi(14)
    protected MiniCustomDialog(Context context, boolean z16, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z16, onCancelListener);
        this.mBrandColorManager = new BrandColorManager();
        super.getWindow().setWindowAnimations(R.style.mini_sdk_CustomAnimationDialog);
        getWindow().setDimAmount(0.5f);
    }

    public MiniCustomDialog setNegativeButton(String str, int i3, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.lBtn.setVisibility(8);
            return this;
        }
        this.lBtn.setTextColor(i3);
        return setNegativeButton(str, onClickListener);
    }

    public MiniCustomDialog setPositiveButton(String str, int i3, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.rBtn.setVisibility(8);
            return this;
        }
        this.rBtn.setTextColor(i3);
        return setPositiveButton(str, onClickListener);
    }

    @TargetApi(14)
    public MiniCustomDialog(Context context, int i3) {
        super(context, i3);
        this.mBrandColorManager = new BrandColorManager();
        super.getWindow().setWindowAnimations(R.style.mini_sdk_CustomAnimationDialog);
        getWindow().setDimAmount(0.5f);
    }

    public MiniCustomDialog setNegativeButton(int i3, final DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.lBtn.setVisibility(8);
            return this;
        }
        this.lBtn.setText(i3);
        this.lBtn.setContentDescription(getContext().getString(i3) + getContext().getString(R.string.mini_sdk_content_desc_button));
        this.lBtn.setVisibility(0);
        this.lBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.sdk.widget.MiniCustomDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                DialogInterface.OnClickListener onClickListener2 = onClickListener;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(MiniCustomDialog.this, 0);
                }
                try {
                    if (MiniCustomDialog.this.isShowing()) {
                        MiniCustomDialog.this.dismiss();
                    }
                } catch (Exception e16) {
                    QMLog.e(MiniCustomDialog.TAG, "lBtn click exception, e=", e16);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        return this;
    }

    public MiniCustomDialog setPositiveButton(int i3, final DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.rBtn.setVisibility(8);
            return this;
        }
        this.rBtn.setText(i3);
        this.rBtn.setContentDescription(getContext().getString(i3));
        this.rBtn.setVisibility(0);
        this.rBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.sdk.widget.MiniCustomDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                DialogInterface.OnClickListener onClickListener2 = onClickListener;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(MiniCustomDialog.this, 1);
                }
                try {
                    if (MiniCustomDialog.this.isShowing()) {
                        MiniCustomDialog.this.dismiss();
                    }
                } catch (Exception e16) {
                    QMLog.e(MiniCustomDialog.TAG, "rBtn click exception, e=", e16);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        return this;
    }
}
