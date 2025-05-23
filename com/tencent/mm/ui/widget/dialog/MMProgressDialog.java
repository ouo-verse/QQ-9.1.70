package com.tencent.mm.ui.widget.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;

/* loaded from: classes9.dex */
public class MMProgressDialog extends MMSafeProgressDialog {
    public static final int STYLE_DARK_OUTSIDE_BG = 2;
    public static final int STYLE_SIMPLE_BLACK = 0;
    public static final int STYLE_WITH_BG = 1;
    public static final int SYTLE_TRANSPARENT_BG = 3;

    /* renamed from: a, reason: collision with root package name */
    public TextView f153136a;

    /* renamed from: b, reason: collision with root package name */
    public ProgressBar f153137b;

    /* renamed from: c, reason: collision with root package name */
    public View f153138c;

    /* renamed from: d, reason: collision with root package name */
    public int f153139d;

    /* renamed from: e, reason: collision with root package name */
    public Builder f153140e;

    /* loaded from: classes9.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public MMProgressDialog f153141a;

        /* renamed from: b, reason: collision with root package name */
        public Context f153142b;

        /* renamed from: c, reason: collision with root package name */
        public CharSequence f153143c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f153144d;

        /* renamed from: e, reason: collision with root package name */
        public int f153145e;

        /* renamed from: f, reason: collision with root package name */
        public int f153146f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f153147g;

        /* renamed from: h, reason: collision with root package name */
        public Notifier f153148h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f153149i;

        /* renamed from: j, reason: collision with root package name */
        public DialogInterface.OnDismissListener f153150j;

        /* renamed from: k, reason: collision with root package name */
        public DialogInterface.OnCancelListener f153151k;

        /* renamed from: l, reason: collision with root package name */
        public DialogInterface.OnShowListener f153152l;

        /* renamed from: m, reason: collision with root package name */
        public DialogInterface.OnKeyListener f153153m;

        /* loaded from: classes9.dex */
        public interface Notifier {
            void onDismiss();

            void onShow();

            void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener);

            void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener);

            void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener);

            void setOnShowListener(DialogInterface.OnShowListener onShowListener);
        }

        public Builder(Context context) {
            this.f153148h = null;
            this.f153149i = false;
            this.f153150j = null;
            this.f153151k = null;
            this.f153152l = null;
            this.f153153m = null;
            this.f153142b = context;
        }

        public MMProgressDialog create() {
            MMProgressDialog mMProgressDialog = new MMProgressDialog(this.f153142b, this.f153146f, this.f153145e);
            mMProgressDialog.setMessage(this.f153143c);
            mMProgressDialog.setCancelable(this.f153144d);
            mMProgressDialog.setOnCancelListener(this.f153151k);
            mMProgressDialog.setCanceledOnTouchOutside(false);
            mMProgressDialog.setBuilder(this);
            this.f153141a = mMProgressDialog;
            return mMProgressDialog;
        }

        public Context getContext() {
            return this.f153142b;
        }

        public int getCusTheme() {
            return this.f153146f;
        }

        public CharSequence getMsg() {
            return this.f153143c;
        }

        public DialogInterface.OnCancelListener getOnCancelListener() {
            return this.f153151k;
        }

        public DialogInterface.OnDismissListener getOnDismissListener() {
            return this.f153150j;
        }

        public DialogInterface.OnKeyListener getOnKeyListener() {
            return this.f153153m;
        }

        public DialogInterface.OnShowListener getOnShowListener() {
            return this.f153152l;
        }

        public int getStyle() {
            return this.f153145e;
        }

        public boolean isCancelAble() {
            return this.f153144d;
        }

        public boolean isCanceledOnTouchOutside() {
            return this.f153147g;
        }

        public boolean isDismissed() {
            return this.f153149i;
        }

        public Builder setCancelAble(boolean z16) {
            this.f153144d = z16;
            return this;
        }

        public Builder setCanceledOnTouchOutside(boolean z16) {
            this.f153147g = z16;
            return this;
        }

        public void setContext(Context context) {
            this.f153142b = context;
        }

        public Builder setCusTheme(int i3) {
            this.f153146f = i3;
            return this;
        }

        public Builder setMsg(CharSequence charSequence) {
            this.f153143c = charSequence;
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.f153151k = onCancelListener;
            return this;
        }

        public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.f153150j = onDismissListener;
        }

        public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            this.f153153m = onKeyListener;
        }

        public void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
            this.f153152l = onShowListener;
        }

        public void setOnStateChangeListener(Notifier notifier) {
            this.f153148h = notifier;
        }

        public Builder setStyle(int i3) {
            this.f153145e = i3;
            return this;
        }

        public void show() {
            if (a(this.f153142b)) {
                if (this.f153141a == null) {
                    this.f153141a = create();
                }
                this.f153141a.show();
                return;
            }
            com.tencent.luggage.wxa.lo.a.a(this);
            Intent intent = new Intent(this.f153142b, (Class<?>) com.tencent.luggage.wxa.lo.a.class);
            intent.setFlags(335544320);
            intent.putExtra("dialog_scene", 4);
            Context context = this.f153142b;
            com.tencent.luggage.wxa.fa.b.a(context, intent);
            context.startActivity(intent);
        }

        public final boolean a(Context context) {
            if (context instanceof Activity) {
                return true;
            }
            if (context instanceof ContextWrapper) {
                return a(((ContextWrapper) context).getBaseContext());
            }
            return false;
        }

        public Builder(Context context, Builder builder) {
            this.f153148h = null;
            this.f153149i = false;
            this.f153150j = null;
            this.f153151k = null;
            this.f153152l = null;
            this.f153153m = null;
            this.f153142b = context;
            builder.f153142b = context;
            builder.f153143c = this.f153143c;
            builder.f153144d = this.f153144d;
            builder.f153145e = this.f153145e;
            builder.f153146f = this.f153146f;
            builder.f153151k = null;
        }
    }

    public MMProgressDialog(Context context, int i3, int i16) {
        super(context, i3);
        this.f153139d = i16;
        d();
    }

    public static MMProgressDialog getProgressDialog(Context context, CharSequence charSequence, boolean z16, int i3, DialogInterface.OnCancelListener onCancelListener) {
        return getProgressDialog(context, charSequence, z16, i3, -1, onCancelListener);
    }

    public static MMProgressDialog show(Context context, CharSequence charSequence, boolean z16, int i3, DialogInterface.OnCancelListener onCancelListener) {
        return show(context, charSequence, z16, i3, -1, onCancelListener);
    }

    public final void d() {
        int i3 = this.f153139d;
        int i16 = R.layout.fks;
        if (i3 != 0 && i3 == 1) {
            i16 = R.layout.fkt;
        }
        View inflate = View.inflate(getContext(), i16, null);
        this.f153138c = inflate;
        this.f153136a = (TextView) inflate.findViewById(R.id.zcn);
        this.f153137b = (ProgressBar) this.f153138c.findViewById(R.id.zcm);
        setCanceledOnTouchOutside(true);
    }

    @Override // com.tencent.mm.ui.widget.dialog.MMSafeProgressDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            e();
            super.dismiss();
        } catch (Exception unused) {
        }
    }

    public final void e() {
        Builder builder = this.f153140e;
        if (builder != null && builder.f153148h != null && this.f153140e.f153141a != this) {
            this.f153140e.f153148h.onDismiss();
        }
        Builder builder2 = this.f153140e;
        if (builder2 != null) {
            builder2.f153149i = true;
        }
    }

    public final void f() {
        Builder builder = this.f153140e;
        if (builder != null && builder.f153148h != null && this.f153140e.f153141a != this) {
            this.f153140e.f153148h.onShow();
        }
        Builder builder2 = this.f153140e;
        if (builder2 != null) {
            builder2.f153149i = false;
        }
    }

    public Builder getBuilder() {
        return this.f153140e;
    }

    public void hideProgress() {
        ProgressBar progressBar = this.f153137b;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    @Override // android.app.ProgressDialog, android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.f153138c, new LinearLayout.LayoutParams(-1, -1));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -2;
        attributes.height = -2;
        if (this.f153139d == 2) {
            getWindow().addFlags(2);
            attributes.dimAmount = 0.65f;
        }
        onWindowAttributesChanged(attributes);
    }

    public void setBuilder(Builder builder) {
        this.f153140e = builder;
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z16) {
        super.setCancelable(z16);
        setCanceledOnTouchOutside(z16);
    }

    @Override // android.app.ProgressDialog, android.app.AlertDialog
    public void setMessage(CharSequence charSequence) {
        this.f153136a.setText(charSequence);
    }

    @Override // android.app.Dialog
    public void setOnCancelListener(@Nullable DialogInterface.OnCancelListener onCancelListener) {
        super.setOnCancelListener(onCancelListener);
        Builder builder = this.f153140e;
        if (builder != null && builder.f153141a != this) {
            this.f153140e.setOnCancelListener(onCancelListener);
            if (this.f153140e.f153148h != null) {
                this.f153140e.f153148h.setOnCancelListener(onCancelListener);
            }
        }
    }

    @Override // android.app.Dialog
    public void setOnDismissListener(@Nullable DialogInterface.OnDismissListener onDismissListener) {
        super.setOnDismissListener(onDismissListener);
        Builder builder = this.f153140e;
        if (builder != null && builder.f153141a != this) {
            this.f153140e.setOnDismissListener(onDismissListener);
            if (this.f153140e.f153148h != null) {
                this.f153140e.f153148h.setOnDismissListener(onDismissListener);
            }
        }
    }

    @Override // android.app.Dialog
    public void setOnKeyListener(@Nullable DialogInterface.OnKeyListener onKeyListener) {
        super.setOnKeyListener(onKeyListener);
        Builder builder = this.f153140e;
        if (builder != null && builder.f153141a != this) {
            this.f153140e.setOnKeyListener(onKeyListener);
            if (this.f153140e.f153148h != null) {
                this.f153140e.f153148h.setOnKeyListener(onKeyListener);
            }
        }
    }

    @Override // android.app.Dialog
    public void setOnShowListener(@Nullable DialogInterface.OnShowListener onShowListener) {
        super.setOnShowListener(onShowListener);
        Builder builder = this.f153140e;
        if (builder != null && builder.f153141a != this) {
            this.f153140e.setOnShowListener(onShowListener);
            if (this.f153140e.f153148h != null) {
                this.f153140e.f153148h.setOnShowListener(onShowListener);
            }
        }
    }

    public static MMProgressDialog getProgressDialog(Context context, CharSequence charSequence, boolean z16, int i3, int i16, DialogInterface.OnCancelListener onCancelListener) {
        if (i16 <= 0) {
            i16 = R.style.ayj;
            if (i3 != 0 && i3 != 1 && i3 != 2) {
                i16 = R.style.ayl;
            }
        }
        Builder builder = new Builder(context);
        builder.setMsg(charSequence).setStyle(i3).setCusTheme(i16).setCancelAble(z16).setOnCancelListener(onCancelListener).setCanceledOnTouchOutside(false);
        return builder.create();
    }

    public static MMProgressDialog show(Context context, CharSequence charSequence, boolean z16, int i3, int i16, DialogInterface.OnCancelListener onCancelListener) {
        MMProgressDialog progressDialog = getProgressDialog(context, charSequence, z16, i3, i16, onCancelListener);
        progressDialog.getBuilder().show();
        return progressDialog;
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            f();
            super.show();
        } catch (Exception unused) {
        }
    }
}
