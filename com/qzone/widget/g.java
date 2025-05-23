package com.qzone.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private Dialog f60859a = null;

    /* renamed from: b, reason: collision with root package name */
    private ProgressBar f60860b = null;

    /* renamed from: c, reason: collision with root package name */
    private TextView f60861c = null;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f60862d = null;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements DialogInterface.OnKeyListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
            if (g.this.f60859a == null || !g.this.f60859a.isShowing()) {
                return false;
            }
            g.this.f60859a.dismiss();
            return true;
        }
    }

    public void b() {
        Dialog dialog = this.f60859a;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.f60859a.dismiss();
    }

    public void c(Context context, String str) {
        Dialog dialog = this.f60859a;
        if (dialog == null || !dialog.isShowing()) {
            if (this.f60859a == null) {
                ReportDialog reportDialog = new ReportDialog(context, R.style.f174269ui);
                this.f60859a = reportDialog;
                reportDialog.setContentView(R.layout.bqd);
                this.f60861c = (TextView) this.f60859a.findViewById(R.id.dialogText);
                this.f60862d = (ImageView) this.f60859a.findViewById(R.id.kja);
                this.f60860b = (ProgressBar) this.f60859a.findViewById(R.id.cib);
                this.f60859a.setCancelable(false);
                this.f60859a.setCanceledOnTouchOutside(false);
                this.f60859a.setOnKeyListener(new a());
                this.f60862d.setVisibility(8);
                this.f60860b.setVisibility(0);
            }
            this.f60861c.setText(str);
            Dialog dialog2 = this.f60859a;
            if (dialog2 != null) {
                try {
                    dialog2.show();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
    }
}
