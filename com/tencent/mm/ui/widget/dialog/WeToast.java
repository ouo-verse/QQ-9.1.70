package com.tencent.mm.ui.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.lo.n;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes9.dex */
public class WeToast extends Dialog {
    public static final int STYLE_ICON = 1;
    public static final int STYLE_LOADING = 2;
    public static final int STYLE_TEXT = 0;
    public static final int TOAST_DURING = 3000;

    /* renamed from: a, reason: collision with root package name */
    public Builder f153161a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f153162b;

    /* renamed from: c, reason: collision with root package name */
    public WeImageView f153163c;

    /* renamed from: d, reason: collision with root package name */
    public ProgressBar f153164d;

    /* renamed from: e, reason: collision with root package name */
    public View f153165e;

    /* renamed from: f, reason: collision with root package name */
    public int f153166f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f153167g;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public WeToast f153168a;

        /* renamed from: b, reason: collision with root package name */
        public Context f153169b;

        /* renamed from: c, reason: collision with root package name */
        public CharSequence f153170c;

        /* renamed from: d, reason: collision with root package name */
        public int f153171d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f153172e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f153173f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f153174g = false;

        /* renamed from: h, reason: collision with root package name */
        public int f153175h = R.style.ajl;

        /* renamed from: i, reason: collision with root package name */
        public int f153176i = 0;

        /* renamed from: j, reason: collision with root package name */
        public int f153177j = 3000;

        /* renamed from: k, reason: collision with root package name */
        public DialogInterface.OnCancelListener f153178k = null;

        /* renamed from: l, reason: collision with root package name */
        public DialogInterface.OnDismissListener f153179l = null;

        public Builder(Context context) {
            this.f153169b = context;
        }

        public Builder block(boolean z16) {
            this.f153174g = z16;
            return this;
        }

        public Builder cancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.f153178k = onCancelListener;
            return this;
        }

        public Builder cancelable(boolean z16) {
            this.f153173f = z16;
            return this;
        }

        public WeToast create() {
            WeToast weToast = new WeToast(this.f153169b, this.f153175h, this.f153176i, this.f153174g);
            weToast.setMessage(this.f153170c);
            weToast.setIcon(this.f153171d);
            weToast.setCancelable(this.f153173f);
            weToast.setCanceledOnTouchOutside(false);
            weToast.setOnCancelListener(this.f153178k);
            weToast.setOnDismissListener(this.f153179l);
            weToast.setBuilder(this);
            this.f153168a = weToast;
            return weToast;
        }

        public Builder dismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.f153179l = onDismissListener;
            return this;
        }

        public DialogInterface.OnCancelListener getOnCancelListener() {
            return this.f153178k;
        }

        public DialogInterface.OnDismissListener getOnDismissListener() {
            return this.f153179l;
        }

        public int getStyle() {
            return this.f153176i;
        }

        public Builder icon(int i3) {
            this.f153171d = i3;
            if (i3 > 0) {
                this.f153176i = 1;
            }
            return this;
        }

        public Builder loading(boolean z16) {
            this.f153172e = z16;
            if (z16) {
                this.f153176i = 2;
            }
            return this;
        }

        public void postDelayedDismiss() {
            Context context = this.f153169b;
            if ((context instanceof Activity) && !((Activity) context).isFinishing() && !((Activity) this.f153169b).isDestroyed()) {
                int i3 = this.f153176i;
                if (i3 == 0 || i3 == 1) {
                    new Handler().postDelayed(new Runnable() { // from class: com.tencent.mm.ui.widget.dialog.WeToast.Builder.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if ((Builder.this.f153169b instanceof Activity) && (((Activity) Builder.this.f153169b).getWindow() == null || ((Activity) Builder.this.f153169b).isFinishing() || ((Activity) Builder.this.f153169b).isDestroyed())) {
                                return;
                            }
                            try {
                                if (Builder.this.f153168a != null && Builder.this.f153168a.isShowing()) {
                                    Builder.this.f153168a.dismiss();
                                }
                            } catch (IllegalArgumentException e16) {
                                n.b("MicroMsg.WeToast", "IllegalArgumentException %s", e16);
                            } catch (Exception e17) {
                                n.b("MicroMsg.WeToast", "Exception %s", e17);
                            }
                        }
                    }, this.f153177j);
                }
            }
        }

        public void setContext(Context context) {
            this.f153169b = context;
        }

        public WeToast show() {
            Context context = this.f153169b;
            if ((context instanceof Activity) && !((Activity) context).isFinishing() && !((Activity) this.f153169b).isDestroyed()) {
                if (this.f153168a == null) {
                    this.f153168a = create();
                }
                this.f153168a.show();
                int i3 = this.f153176i;
                if (i3 == 0 || i3 == 1) {
                    new Handler().postDelayed(new Runnable() { // from class: com.tencent.mm.ui.widget.dialog.WeToast.Builder.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if ((Builder.this.f153169b instanceof Activity) && (((Activity) Builder.this.f153169b).getWindow() == null || ((Activity) Builder.this.f153169b).isFinishing() || ((Activity) Builder.this.f153169b).isDestroyed())) {
                                return;
                            }
                            try {
                                if (Builder.this.f153168a != null && Builder.this.f153168a.isShowing()) {
                                    Builder.this.f153168a.dismiss();
                                }
                            } catch (IllegalArgumentException e16) {
                                n.b("MicroMsg.WeToast", "IllegalArgumentException %s", e16);
                            } catch (Exception e17) {
                                n.b("MicroMsg.WeToast", "Exception %s", e17);
                            }
                        }
                    }, this.f153177j);
                }
                return this.f153168a;
            }
            com.tencent.luggage.wxa.lo.a.a(this);
            Intent intent = new Intent(this.f153169b, (Class<?>) com.tencent.luggage.wxa.lo.a.class);
            intent.setFlags(335544320);
            intent.putExtra("dialog_scene", 5);
            Context context2 = this.f153169b;
            com.tencent.luggage.wxa.fa.b.a(context2, intent);
            context2.startActivity(intent);
            return null;
        }

        public Builder text(CharSequence charSequence) {
            this.f153170c = charSequence;
            return this;
        }

        public WeToast update() {
            WeToast weToast = this.f153168a;
            if (weToast != null) {
                weToast.setMessage(this.f153170c);
                weToast.setIcon(this.f153171d);
                weToast.setCancelable(this.f153173f);
                weToast.setCanceledOnTouchOutside(false);
                weToast.setOnCancelListener(this.f153178k);
                weToast.setOnDismissListener(this.f153179l);
                weToast.setBuilder(this);
                weToast.a(this.f153176i);
                weToast.e();
                this.f153168a = weToast;
                postDelayedDismiss();
            }
            return weToast;
        }

        public Builder text(int i3) {
            this.f153170c = this.f153169b.getText(i3);
            return this;
        }
    }

    public WeToast(@NonNull Context context) {
        super(context);
        d();
    }

    public static Builder build(Context context) {
        return new Builder(context);
    }

    public final void d() {
        int i3;
        int i16 = this.f153166f;
        if (i16 != 1 && i16 != 2) {
            i3 = R.layout.i46;
        } else {
            i3 = R.layout.f169182i45;
        }
        View inflate = View.inflate(getContext(), i3, null);
        this.f153165e = inflate;
        this.f153162b = (TextView) inflate.findViewById(R.id.jsg);
        this.f153163c = (WeImageView) this.f153165e.findViewById(R.id.f99185p4);
        this.f153164d = (ProgressBar) this.f153165e.findViewById(R.id.f99205p6);
        int i17 = this.f153166f;
        if (i17 == 1) {
            this.f153163c.setVisibility(0);
            this.f153164d.setVisibility(8);
        } else if (i17 == 2) {
            this.f153163c.setVisibility(8);
            this.f153164d.setVisibility(0);
        }
        setCanceledOnTouchOutside(true);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (isShowing()) {
            super.dismiss();
        }
    }

    public final void e() {
        int i3 = this.f153166f;
        if (i3 == 1) {
            this.f153163c.setVisibility(0);
            this.f153164d.setVisibility(8);
        } else if (i3 == 2) {
            this.f153163c.setVisibility(8);
            this.f153164d.setVisibility(0);
        }
    }

    public Builder getBuilder() {
        return this.f153161a;
    }

    public View getContentView() {
        return this.f153165e;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.f153165e, new LinearLayout.LayoutParams(-1, -1));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -2;
        attributes.height = -2;
        if (this.f153166f != 2 && !this.f153167g) {
            attributes.flags = attributes.flags | 8 | 16;
        }
        onWindowAttributesChanged(attributes);
    }

    public void setBuilder(Builder builder) {
        this.f153161a = builder;
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z16) {
        super.setCancelable(z16);
        setCanceledOnTouchOutside(z16);
    }

    public void setIcon(int i3) {
        WeImageView weImageView = this.f153163c;
        if (weImageView != null) {
            weImageView.setImageResource(i3);
        }
    }

    public void setMessage(CharSequence charSequence) {
        TextView textView = this.f153162b;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // android.app.Dialog
    public void setOnCancelListener(@Nullable DialogInterface.OnCancelListener onCancelListener) {
        super.setOnCancelListener(onCancelListener);
    }

    @Override // android.app.Dialog
    public void setOnDismissListener(@Nullable DialogInterface.OnDismissListener onDismissListener) {
        super.setOnDismissListener(onDismissListener);
    }

    public WeToast(@NonNull Context context, int i3, int i16, boolean z16) {
        super(context, i3);
        this.f153166f = i16;
        this.f153167g = z16;
        d();
    }

    public final void a(int i3) {
        this.f153166f = i3;
    }

    public WeToast(@NonNull Context context, boolean z16, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        super(context, z16, onCancelListener);
        d();
    }
}
