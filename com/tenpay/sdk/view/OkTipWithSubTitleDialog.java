package com.tenpay.sdk.view;

import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes27.dex */
public class OkTipWithSubTitleDialog extends ReportDialog {
    protected TextView mSubTitle;
    private TimerTask mTimerTask;
    protected ImageView mTipIcon;
    protected TextView mTitle;

    public OkTipWithSubTitleDialog(Context context) {
        super(context);
        this.mTimerTask = new TimerTask() { // from class: com.tenpay.sdk.view.OkTipWithSubTitleDialog.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                OkTipWithSubTitleDialog.this.dismiss();
            }
        };
        init(context);
    }

    protected void init(Context context) {
        setContentView(R.layout.agc);
        getWindow().setLayout(-1, -2);
        this.mTitle = (TextView) findViewById(R.id.ghm);
        this.mSubTitle = (TextView) findViewById(R.id.ghl);
        this.mTipIcon = (ImageView) findViewById(R.id.ghk);
        setCancelable(false);
        setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.tenpay.sdk.view.OkTipWithSubTitleDialog.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
                if (i3 == 84 && keyEvent.getRepeatCount() == 0) {
                    return true;
                }
                return false;
            }
        });
    }

    public void setMessage(String str, String str2) {
        if (str != null && str2 != null) {
            this.mTitle.setText(str);
            this.mSubTitle.setText(str2);
        }
    }

    public void setTipIcon(int i3) {
        this.mTipIcon.setImageResource(i3);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        if (isShowing()) {
            return;
        }
        super.show();
        new BaseTimer().schedule(this.mTimerTask, 1000L);
    }

    public OkTipWithSubTitleDialog(Context context, int i3) {
        super(context, i3);
        this.mTimerTask = new TimerTask() { // from class: com.tenpay.sdk.view.OkTipWithSubTitleDialog.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                OkTipWithSubTitleDialog.this.dismiss();
            }
        };
        init(context);
    }
}
