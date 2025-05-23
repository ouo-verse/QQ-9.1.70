package com.tencent.luggage.wxa.ml;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends MMAlertDialog implements m {
    public DialogInterface.OnShowListener X;
    public DialogInterface.OnDismissListener Y;
    public DialogInterface.OnCancelListener Z;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f134617a0;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f134618b0;

    /* renamed from: c0, reason: collision with root package name */
    public r f134619c0;

    /* renamed from: d0, reason: collision with root package name */
    public View f134620d0;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f134621e0;

    /* renamed from: f0, reason: collision with root package name */
    public CharSequence f134622f0;

    public b(Context context) {
        super(context, R.style.ayj);
        this.f134618b0 = true;
        this.f134621e0 = false;
        setContentView(super.getContentView());
        setCanceledOnTouchOutside(false);
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
        return this.f134618b0;
    }

    @Override // com.tencent.mm.ui.widget.dialog.MMAlertDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.f134621e0) {
            return;
        }
        this.f134621e0 = true;
        r rVar = this.f134619c0;
        if (rVar != null) {
            rVar.b(this);
            e();
        }
    }

    public void e() {
        DialogInterface.OnDismissListener onDismissListener = this.Y;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(this);
        }
    }

    @Override // com.tencent.mm.ui.widget.dialog.MMAlertDialog, com.tencent.luggage.wxa.ml.m
    public View getContentView() {
        View view = this.f134620d0;
        if (view != null) {
            return view;
        }
        return super.getContentView();
    }

    public int getPosition() {
        return 1;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void onCancel() {
        DialogInterface.OnCancelListener onCancelListener = this.Z;
        if (onCancelListener != null) {
            onCancelListener.onCancel(this);
        }
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void onShown() {
        View contentView = getContentView();
        if (contentView != null) {
            com.tencent.luggage.wxa.jl.a.a(contentView);
        }
    }

    @Override // com.tencent.mm.ui.widget.dialog.MMAlertDialog, android.app.Dialog
    public void setCancelable(boolean z16) {
        super.setCancelable(z16);
        this.f134618b0 = z16;
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z16) {
        super.setCanceledOnTouchOutside(z16);
        this.f134617a0 = z16;
    }

    @Override // android.app.Dialog
    public void setContentView(int i3) {
        setContentView(LayoutInflater.from(getContext()).inflate(i3, (ViewGroup) null));
    }

    @Override // com.tencent.mm.ui.widget.dialog.MMAlertDialog
    public void setMessage(CharSequence charSequence) {
        this.f134622f0 = charSequence;
        super.setMessage(charSequence);
    }

    @Override // android.app.Dialog
    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        super.setOnCancelListener(onCancelListener);
        this.Z = onCancelListener;
    }

    @Override // android.app.Dialog
    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        super.setOnDismissListener(onDismissListener);
        this.Y = onDismissListener;
    }

    @Override // android.app.Dialog
    public void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        super.setOnShowListener(onShowListener);
        this.X = onShowListener;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public void a(r rVar) {
        DialogInterface.OnShowListener onShowListener = this.X;
        if (onShowListener != null) {
            onShowListener.onShow(this);
        }
        this.f134619c0 = rVar;
    }

    @Override // com.tencent.luggage.wxa.ml.m
    public boolean b() {
        return this.f134617a0;
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        if (!(view instanceof a)) {
            view = new a(view.getContext(), view);
        }
        this.f134620d0 = view;
    }

    @Override // com.tencent.mm.ui.widget.dialog.MMAlertDialog
    public void setMessage(int i3) {
        String string = getContext().getResources().getString(i3);
        this.f134622f0 = string;
        super.setMessage(string);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        if (layoutParams != null) {
            view.setLayoutParams(layoutParams);
        }
        setContentView(view);
    }

    public b(Context context, int i3) {
        super(context, i3);
        this.f134618b0 = true;
        this.f134621e0 = false;
    }

    @Override // com.tencent.mm.ui.widget.dialog.MMAlertDialog, android.app.Dialog
    public void show() {
    }
}
