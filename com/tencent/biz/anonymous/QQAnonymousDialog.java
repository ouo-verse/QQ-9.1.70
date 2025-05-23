package com.tencent.biz.anonymous;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.al;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes2.dex */
public class QQAnonymousDialog extends ReportDialog {
    public View C;
    public ImageView D;
    public TextView E;
    public int F;
    public Context G;
    public LayoutInflater H;
    public Handler I;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i3;
            if (message.what == 291) {
                QQAnonymousDialog qQAnonymousDialog = QQAnonymousDialog.this;
                int i16 = qQAnonymousDialog.F;
                if (i16 != 0) {
                    if (i16 != 1) {
                        if (i16 != 2) {
                            if (i16 != 3) {
                                i3 = 0;
                            } else {
                                i3 = R.string.dp_;
                            }
                        } else {
                            i3 = R.string.dp9;
                        }
                    } else {
                        i3 = R.string.dp8;
                    }
                } else {
                    i3 = R.string.dp7;
                }
                qQAnonymousDialog.E.setText(qQAnonymousDialog.G.getResources().getString(i3));
                QQAnonymousDialog qQAnonymousDialog2 = QQAnonymousDialog.this;
                int i17 = qQAnonymousDialog2.F + 1;
                qQAnonymousDialog2.F = i17;
                if (i17 == 4) {
                    qQAnonymousDialog2.F = 0;
                }
                qQAnonymousDialog2.I.sendEmptyMessageDelayed(291, 1000L);
            }
            return false;
        }
    }

    public QQAnonymousDialog(Context context) {
        super(context, R.style.qZoneInputDialog);
        this.I = new Handler(new a());
        this.G = context;
        LayoutInflater from = LayoutInflater.from(context);
        this.H = from;
        View inflate = from.inflate(R.layout.ah_, (ViewGroup) null);
        this.C = inflate;
        this.E = (TextView) inflate.findViewById(R.id.efa);
        this.D = (ImageView) this.C.findViewById(R.id.efm);
    }

    public void N(int i3, String str) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    this.D.setImageResource(R.drawable.f161531e22);
                    this.E.setText(str);
                    if (AppSetting.f99565y) {
                        QQAppInterface.speak(str);
                        return;
                    }
                    return;
                }
                return;
            }
            this.F = 0;
            this.D.setImageResource(R.drawable.e27);
            this.E.setText(this.G.getResources().getString(R.string.dp_));
            return;
        }
        this.D.setImageResource(R.drawable.e28);
        this.E.setText(str);
        if (AppSetting.f99565y) {
            QQAppInterface.speak(str);
        }
    }

    public void O() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.D.getLayoutParams();
        layoutParams.width = (int) al.a(this.G, 44.0f);
        layoutParams.height = (int) al.a(this.G, 44.0f);
        super.show();
        this.C.postDelayed(new Runnable() { // from class: com.tencent.biz.anonymous.QQAnonymousDialog.2
            @Override // java.lang.Runnable
            public void run() {
                QQAnonymousDialog.this.cancel();
            }
        }, 1000L);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        window.setContentView(this.C);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -2;
        attributes.height = -2;
        attributes.gravity = 17;
        window.setAttributes(attributes);
        setCanceledOnTouchOutside(false);
    }
}
