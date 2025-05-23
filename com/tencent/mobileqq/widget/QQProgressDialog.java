package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.QQUITextToSpeechHelper;

/* loaded from: classes20.dex */
public class QQProgressDialog extends ReportDialog {
    private float C;
    private Context D;
    private LayoutInflater E;
    private View F;
    private TextView G;
    private ImageView H;
    private ImageView I;
    private Animatable J;
    private LinearLayout K;
    private int L;
    private int M;
    private int N;
    String P;
    private b Q;

    /* loaded from: classes20.dex */
    class a implements DialogInterface.OnKeyListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f316053d;

        a(boolean z16) {
            this.f316053d = z16;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
            if (i3 != 84 && i3 != 4) {
                return false;
            }
            return this.f316053d;
        }
    }

    /* loaded from: classes20.dex */
    public interface b {
        void onBackPressed();
    }

    public QQProgressDialog(Context context) {
        this(context, 0);
    }

    public void O(b bVar) {
        this.Q = bVar;
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
        } catch (Throwable th5) {
            sy3.a.a(this);
            throw th5;
        }
        sy3.a.a(this);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (TextUtils.isEmpty(this.P)) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        if (az.f316688b) {
            QQUITextToSpeechHelper.speak(this.P);
            return true;
        }
        return true;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        b bVar = this.Q;
        if (bVar != null) {
            bVar.onBackPressed();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        window.setContentView(this.F);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = this.N;
        attributes.gravity = this.M;
        attributes.y += this.L;
        window.setAttributes(attributes);
        setCanceledOnTouchOutside(false);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        this.I.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.widget.QQProgressDialog.1
            @Override // java.lang.Runnable
            public void run() {
                QQProgressDialog.this.J.start();
            }
        }, 50L);
        super.onStart();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog, android.app.Dialog
    protected void onStop() {
        if (this.J.isRunning()) {
            this.J.stop();
        }
        super.onStop();
    }

    public void setBackAndSearchFilter(boolean z16) {
        setOnKeyListener(new a(z16));
    }

    public void setHeightParams(int i3) {
        this.N = i3;
    }

    public void setMessage(String str) {
        this.G.setText(str);
    }

    public void setOffsetY(int i3) {
        this.L = i3;
    }

    public void setTipImageView(int i3) {
        ImageView imageView = this.H;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(0);
        this.H.setImageResource(i3);
    }

    public void showProgerss(boolean z16) {
        if (this.I == null) {
            return;
        }
        if (z16) {
            if (!this.J.isRunning()) {
                this.J.start();
            }
            this.I.setVisibility(0);
        } else {
            if (this.J.isRunning()) {
                this.J.stop();
            }
            this.I.setVisibility(8);
        }
    }

    public void showTipImageView(boolean z16) {
        ImageView imageView = this.H;
        if (imageView == null) {
            return;
        }
        if (z16) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    public QQProgressDialog(Context context, int i3) {
        this(context, i3, R.layout.qq_progress_dialog, 48);
    }

    public void setMessage(int i3) {
        this.G.setText(i3);
    }

    public QQProgressDialog(Context context, int i3, int i16, int i17) {
        super(context, R.style.qZoneInputDialog);
        this.H = null;
        this.I = null;
        this.L = 0;
        this.M = 48;
        this.N = -2;
        this.D = context;
        this.E = LayoutInflater.from(context);
        this.C = this.D.getResources().getDisplayMetrics().density;
        View inflate = this.E.inflate(i16, (ViewGroup) null);
        this.F = inflate;
        this.K = (LinearLayout) inflate.findViewById(R.id.lac);
        this.G = (TextView) this.F.findViewById(R.id.f18);
        this.L = i3;
        this.M = i17;
        this.H = (ImageView) this.F.findViewById(R.id.jnm);
        ImageView imageView = (ImageView) this.F.findViewById(R.id.jnn);
        this.I = imageView;
        this.J = (Animatable) imageView.getDrawable();
    }
}
