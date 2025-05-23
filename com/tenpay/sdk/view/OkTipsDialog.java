package com.tenpay.sdk.view;

import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes27.dex */
public class OkTipsDialog extends ReportDialog {
    private TimerTask mTimerTask;
    protected TextView mTips;

    public OkTipsDialog(Context context) {
        super(context);
        this.mTimerTask = new TimerTask() { // from class: com.tenpay.sdk.view.OkTipsDialog.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                OkTipsDialog.this.dismiss();
            }
        };
        init(context);
    }

    protected void init(Context context) {
        setContentView(R.layout.ads);
        Window window = getWindow();
        if (window != null) {
            window.setLayout(-1, -2);
        }
        this.mTips = (TextView) findViewById(R.id.ghn);
        setCancelable(false);
        setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.tenpay.sdk.view.OkTipsDialog.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
                if (i3 == 84 && keyEvent.getRepeatCount() == 0) {
                    return true;
                }
                return false;
            }
        });
    }

    public void setMessage(String str) {
        this.mTips.setText(str);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        if (isShowing()) {
            return;
        }
        super.show();
        new BaseTimer().schedule(this.mTimerTask, 1000L);
    }

    public OkTipsDialog(Context context, int i3) {
        super(context, i3);
        this.mTimerTask = new TimerTask() { // from class: com.tenpay.sdk.view.OkTipsDialog.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                OkTipsDialog.this.dismiss();
            }
        };
        init(context);
    }
}
