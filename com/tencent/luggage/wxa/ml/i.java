package com.tencent.luggage.wxa.ml;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.luggage.wxa.ml.m;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.mm.ui.widget.dialog.WeUIProgresssDialog;
import com.tencent.mm.ui.widget.loading.MMProgressLoading;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i extends WeUIProgresssDialog implements m, m.a {

    /* renamed from: e, reason: collision with root package name */
    public DialogInterface.OnShowListener f134714e;

    /* renamed from: f, reason: collision with root package name */
    public DialogInterface.OnDismissListener f134715f;

    /* renamed from: g, reason: collision with root package name */
    public DialogInterface.OnCancelListener f134716g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f134717h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f134718i;

    /* renamed from: j, reason: collision with root package name */
    public r f134719j;

    /* renamed from: k, reason: collision with root package name */
    public View f134720k;

    /* renamed from: l, reason: collision with root package name */
    public TextView f134721l;

    /* renamed from: m, reason: collision with root package name */
    public MMProgressLoading f134722m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f134723a;

        public a(int i3) {
            this.f134723a = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.setProgress(this.f134723a);
        }
    }

    public i(Context context) {
        super(context, R.style.ayj);
        this.f134718i = true;
        try {
            onCreate(null);
        } catch (Exception unused) {
        }
        setContentView(R.layout.i8g);
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public boolean a() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void b(int i3) {
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public boolean c() {
        return this.f134718i;
    }

    @Override // com.tencent.mm.ui.widget.dialog.WeUIProgresssDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        r rVar = this.f134719j;
        if (rVar != null) {
            rVar.b(this);
            e();
        }
    }

    public void e() {
        DialogInterface.OnDismissListener onDismissListener = this.f134715f;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(this);
        }
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public View getContentView() {
        return this.f134720k;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public int getPosition() {
        return 1;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void onCancel() {
        DialogInterface.OnCancelListener onCancelListener = this.f134716g;
        if (onCancelListener != null) {
            onCancelListener.onCancel(this);
        }
    }

    @Override // com.tencent.mm.ui.widget.dialog.WeUIProgresssDialog, android.app.Dialog, com.tencent.luggage.wxa.ml.m.a
    public void setCancelable(boolean z16) {
        super.setCancelable(z16);
        this.f134718i = z16;
    }

    @Override // android.app.Dialog, com.tencent.luggage.wxa.ml.m.a
    public void setCanceledOnTouchOutside(boolean z16) {
        super.setCanceledOnTouchOutside(z16);
        this.f134717h = z16;
    }

    @Override // android.app.Dialog
    public void setContentView(int i3) {
        setContentView(LayoutInflater.from(getContext()).inflate(i3, (ViewGroup) null));
    }

    @Override // com.tencent.mm.ui.widget.dialog.WeUIProgresssDialog, android.app.ProgressDialog, android.app.AlertDialog
    public void setMessage(CharSequence charSequence) {
        this.f134721l.setText(charSequence);
    }

    @Override // android.app.Dialog, com.tencent.luggage.wxa.ml.m.a
    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        super.setOnCancelListener(onCancelListener);
        this.f134716g = onCancelListener;
    }

    @Override // android.app.Dialog
    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        super.setOnDismissListener(onDismissListener);
        this.f134715f = onDismissListener;
    }

    @Override // android.app.Dialog
    public void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        super.setOnShowListener(onShowListener);
        this.f134714e = onShowListener;
    }

    @Override // android.app.ProgressDialog
    public void setProgress(int i3) {
        if (!c0.b()) {
            this.f134720k.post(new a(i3));
            return;
        }
        if (this.f134722m == null) {
            MMProgressLoading mMProgressLoading = (MMProgressLoading) this.f134720k.findViewById(R.id.f125637ml);
            this.f134722m = mMProgressLoading;
            mMProgressLoading.setVisibility(0);
            this.f134720k.findViewById(R.id.f125617mj).setVisibility(8);
        }
        this.f134722m.setProgress(i3);
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void a(r rVar) {
        DialogInterface.OnShowListener onShowListener = this.f134714e;
        if (onShowListener != null) {
            onShowListener.onShow(this);
        }
        this.f134719j = rVar;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public boolean b() {
        return this.f134717h;
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        this.f134720k = view;
        this.f134721l = (TextView) view.findViewById(R.id.f125627mk);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        if (layoutParams != null) {
            view.setLayoutParams(layoutParams);
        }
        setContentView(view);
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void onShown() {
    }

    @Override // com.tencent.mm.ui.widget.dialog.WeUIProgresssDialog, android.app.Dialog
    public void show() {
    }
}
