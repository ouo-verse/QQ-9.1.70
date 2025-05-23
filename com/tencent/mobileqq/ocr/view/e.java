package com.tencent.mobileqq.ocr.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class e extends ReportDialog {
    static IPatchRedirector $redirector_;
    private Context C;
    private TDCircleProgressView D;
    private LayoutInflater E;
    private View F;
    private TextView G;
    private TextView H;
    private View I;

    public e(Context context) {
        super(context, R.style.qZoneInputDialog);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            init(context);
        }
    }

    private void init(Context context) {
        this.C = context;
        LayoutInflater from = LayoutInflater.from(context);
        this.E = from;
        this.F = from.inflate(R.layout.c9o, (ViewGroup) null);
        setCancelable(false);
        TDCircleProgressView tDCircleProgressView = (TDCircleProgressView) this.F.findViewById(R.id.lcy);
        this.D = tDCircleProgressView;
        tDCircleProgressView.setCurrent(0);
        this.G = (TextView) this.F.findViewById(R.id.k6s);
        this.I = this.F.findViewById(R.id.kmm);
        this.H = (TextView) this.F.findViewById(R.id.f167033k60);
    }

    public void N(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) charSequence);
        } else {
            this.G.setText(charSequence);
        }
    }

    public void O(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) onClickListener);
        } else if (onClickListener != null) {
            this.H.setOnClickListener(onClickListener);
        }
    }

    public void P(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        this.H.setVisibility(i3);
        this.I.setVisibility(i3);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        Window window = getWindow();
        window.setContentView(this.F);
        if (this.H.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        float f16 = this.C.getResources().getDisplayMetrics().density;
        attributes.width = (int) ((320.0f * f16) + 0.5f);
        if (!z16) {
            attributes.height = (int) ((f16 * 145.0f) + 0.5f);
        } else {
            attributes.height = (int) ((f16 * 200.0f) + 0.5f);
        }
        window.setAttributes(attributes);
        setCanceledOnTouchOutside(false);
    }

    public void setProgress(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.D.setCurrent(i3);
        }
    }
}
