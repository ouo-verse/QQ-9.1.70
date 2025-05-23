package com.tencent.midas.comm;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.animation.AlphaAnimation;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.pay.tool.APMidasCommMethod;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;

/* loaded from: classes9.dex */
public class APProgressDialog extends ReportProgressDialog {
    private Context context;
    private String loadingTxt;
    private TextView loading_txt;

    public APProgressDialog(Context context) {
        super(context);
        this.loadingTxt = "\u8bf7\u7a0d\u5019...";
        this.loading_txt = null;
        this.context = context;
    }

    @Override // android.app.ProgressDialog, android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(APMidasCommMethod.getLayoutId(this.context, "unipay_layout_loadding"));
        ProgressBar progressBar = (ProgressBar) findViewById(APMidasCommMethod.getId(this.context, "unipay_progress"));
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.2f);
        alphaAnimation.setDuration(600L);
        alphaAnimation.setRepeatCount(-1);
        alphaAnimation.setRepeatMode(2);
        progressBar.setAnimation(alphaAnimation);
        alphaAnimation.start();
        TextView textView = (TextView) findViewById(APMidasCommMethod.getId(this.context, "unipay_id_LoadingTxt"));
        this.loading_txt = textView;
        textView.setText(this.loadingTxt);
        setCancelable(false);
    }

    @Override // android.app.AlertDialog, android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            cancel();
            return false;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // android.app.ProgressDialog, android.app.AlertDialog
    public void setMessage(CharSequence charSequence) {
        super.setMessage(charSequence);
        this.loadingTxt = String.valueOf(charSequence);
    }
}
