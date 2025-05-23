package com.tenpay.view;

import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tenpay.api.QFuncApi;
import com.tenpay.util.Utils;

/* loaded from: classes27.dex */
public class WalletProgressDialog extends ReportDialog {
    private static final String TAG = "WalletProgressDialog";
    private int height;
    private LinearLayout loading_bg;
    private Context mContext;
    protected ImageView mPointerView;

    public WalletProgressDialog(Context context) {
        super(context, R.style.f174222az0);
        init(context);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
            this.height = 0;
            QLog.d(TAG, 2, "dismiss");
        } catch (Exception e16) {
            QLog.e(TAG, 1, "error msg in qqpay-api module: ", e16);
        }
    }

    protected void init(Context context) {
        Window window;
        this.mContext = context;
        if (QFuncApi.isSupporImmersive() == 1 && (window = getWindow()) != null) {
            if (!QFuncApi.isEMUI3_1()) {
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(0);
                window.getDecorView().setSystemUiVisibility(256);
            } else {
                window.addFlags(4194304);
            }
        }
        setContentView(R.layout.adr);
        Window window2 = getWindow();
        window2.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window2.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        window2.setAttributes(attributes);
        this.loading_bg = (LinearLayout) findViewById(R.id.ef9);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.efs);
        TextView textView = (TextView) findViewById(R.id.jep);
        ImageView imageView = (ImageView) findViewById(R.id.ggp);
        this.mPointerView = (ImageView) findViewById(R.id.gez);
        if (this.height == 0) {
            this.loading_bg.setBackgroundColor(0);
            imageView.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.e0j));
            int color = this.mContext.getResources().getColor(R.color.f157696x1);
            this.mPointerView.setBackgroundColor(color);
            textView.setTextColor(color);
            linearLayout.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.qb_tenpay_wallet_loading_bg));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.loading_bg.getLayoutParams();
            layoutParams.height = Utils.getScreenHeight(context);
            this.loading_bg.setLayoutParams(layoutParams);
        } else {
            this.loading_bg.setBackgroundColor(-1);
            imageView.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.qb_tenpay_wallet_logo));
            int color2 = this.mContext.getResources().getColor(R.color.f157670wa);
            this.mPointerView.setBackgroundColor(color2);
            textView.setTextColor(color2);
            linearLayout.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.f161526a54));
            ((RelativeLayout) findViewById(R.id.iev)).setBackgroundColor(0);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.loading_bg.getLayoutParams();
            layoutParams2.height = this.height;
            this.loading_bg.setLayoutParams(layoutParams2);
        }
        setCancelable(false);
        setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.tenpay.view.WalletProgressDialog.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
                if (i3 == 84 && keyEvent.getRepeatCount() == 0) {
                    return true;
                }
                return false;
            }
        });
    }

    public void setHeight(int i3) {
        this.height = i3;
        init(this.mContext);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        super.show();
        QLog.d(TAG, 2, "show, context=" + getContext());
        startAnimation();
    }

    public void startAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, -1.0f, 2, 1.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation.setDuration(800L);
        translateAnimation.setRepeatCount(-1);
        this.mPointerView.startAnimation(translateAnimation);
    }
}
