package com.tencent.mm.ui.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.lo.n;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.widget.snackbar.SnackBar;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes9.dex */
public class WeSnackBar extends Dialog {
    public static final int SNACKBAR_DURING = 2000;

    /* renamed from: a, reason: collision with root package name */
    public Builder f152735a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f152736b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f152737c;

    /* renamed from: d, reason: collision with root package name */
    public WeImageView f152738d;

    /* renamed from: e, reason: collision with root package name */
    public ProgressBar f152739e;

    /* renamed from: f, reason: collision with root package name */
    public View f152740f;

    /* renamed from: g, reason: collision with root package name */
    public ViewGroup f152741g;

    /* renamed from: h, reason: collision with root package name */
    public int f152742h;

    /* renamed from: i, reason: collision with root package name */
    public int f152743i;

    /* renamed from: j, reason: collision with root package name */
    public int f152744j;

    /* renamed from: k, reason: collision with root package name */
    public Context f152745k;

    /* renamed from: l, reason: collision with root package name */
    public SnackBar.OnVisibilityChangeListener f152746l;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class Action {

        /* renamed from: a, reason: collision with root package name */
        public CharSequence f152749a;

        /* renamed from: b, reason: collision with root package name */
        public SnackBar.OnMessageClickListener f152750b;

        public CharSequence getActionText() {
            return this.f152749a;
        }

        public SnackBar.OnMessageClickListener getOnActionClickListener() {
            return this.f152750b;
        }

        public void setActionText(CharSequence charSequence) {
            this.f152749a = charSequence;
        }

        public void setOnActionClickListener(SnackBar.OnMessageClickListener onMessageClickListener) {
            this.f152750b = onMessageClickListener;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class Builder {
        public static final int SHOW_STYLE_ACTION_AREA = 4;
        public static final int SHOW_STYLE_BLOCK = 8;
        public static final int SHOW_STYLE_ICON = 2;
        public static final int SHOW_STYLE_LOADING = 16;

        /* renamed from: b, reason: collision with root package name */
        public WeSnackBar f152752b;

        /* renamed from: c, reason: collision with root package name */
        public Context f152753c;

        /* renamed from: d, reason: collision with root package name */
        public CharSequence f152754d;

        /* renamed from: e, reason: collision with root package name */
        public int f152755e;

        /* renamed from: f, reason: collision with root package name */
        public int f152756f;

        /* renamed from: k, reason: collision with root package name */
        public SnackBar.OnVisibilityChangeListener f152761k;

        /* renamed from: a, reason: collision with root package name */
        public Action f152751a = new Action();

        /* renamed from: g, reason: collision with root package name */
        public int f152757g = R.style.ajl;

        /* renamed from: h, reason: collision with root package name */
        public int f152758h = 2000;

        /* renamed from: i, reason: collision with root package name */
        public DialogInterface.OnCancelListener f152759i = null;

        /* renamed from: j, reason: collision with root package name */
        public DialogInterface.OnDismissListener f152760j = null;

        /* renamed from: l, reason: collision with root package name */
        public int f152762l = 0;

        public Builder(Context context) {
            this.f152753c = context;
        }

        public Builder actionText(CharSequence charSequence) {
            this.f152751a.setActionText(charSequence);
            canShowAction(!TextUtils.isEmpty(charSequence));
            return this;
        }

        public Builder block(boolean z16) {
            if (z16) {
                this.f152762l |= 8;
            } else {
                this.f152762l &= -9;
            }
            return this;
        }

        public Builder canShowAction(boolean z16) {
            if (z16) {
                this.f152762l |= 4;
            } else {
                this.f152762l &= -5;
            }
            return this;
        }

        public Builder canShowIcon(boolean z16) {
            if (z16) {
                this.f152762l |= 2;
            } else {
                this.f152762l &= -3;
            }
            return this;
        }

        public Builder cancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.f152759i = onCancelListener;
            return this;
        }

        public WeSnackBar create() {
            WeSnackBar weSnackBar = new WeSnackBar(this.f152753c, this.f152757g, this.f152762l);
            this.f152752b = weSnackBar;
            update();
            return weSnackBar;
        }

        public Builder dismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.f152760j = onDismissListener;
            return this;
        }

        public DialogInterface.OnCancelListener getOnCancelListener() {
            return this.f152759i;
        }

        public DialogInterface.OnDismissListener getOnDismissListener() {
            return this.f152760j;
        }

        public Builder icon(int i3) {
            boolean z16;
            this.f152755e = i3;
            if (i3 > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            canShowIcon(z16);
            return this;
        }

        public Builder loading(boolean z16) {
            if (z16) {
                this.f152762l |= 16;
            } else {
                this.f152762l &= -17;
            }
            return this;
        }

        public Builder onActionClickListener(SnackBar.OnMessageClickListener onMessageClickListener) {
            this.f152751a.setOnActionClickListener(onMessageClickListener);
            return this;
        }

        public Builder onVisibilityChangeListener(SnackBar.OnVisibilityChangeListener onVisibilityChangeListener) {
            this.f152761k = onVisibilityChangeListener;
            return this;
        }

        public void setContext(Context context) {
            this.f152753c = context;
        }

        public Builder setMarginBottom(int i3) {
            this.f152756f = i3;
            return this;
        }

        public WeSnackBar show() {
            Context context = this.f152753c;
            if ((context instanceof Activity) && !((Activity) context).isFinishing() && !((Activity) this.f152753c).isDestroyed()) {
                if (this.f152752b == null) {
                    this.f152752b = create();
                }
                this.f152752b.show();
                a();
                return this.f152752b;
            }
            return null;
        }

        public Builder text(CharSequence charSequence) {
            this.f152754d = charSequence;
            return this;
        }

        public WeSnackBar update() {
            WeSnackBar weSnackBar = this.f152752b;
            if (weSnackBar != null) {
                weSnackBar.setShowStyleFlag(this.f152762l);
                weSnackBar.setMessage(this.f152754d);
                weSnackBar.setIcon(this.f152755e);
                weSnackBar.setCanceledOnTouchOutside(false);
                weSnackBar.setBuilder(this);
                weSnackBar.setAction(this.f152751a);
                weSnackBar.a(this.f152761k);
                weSnackBar.a(this.f152756f);
                weSnackBar.j();
                weSnackBar.i();
                a();
            }
            return weSnackBar;
        }

        public final void a() {
            if (this.f152752b.h()) {
                return;
            }
            new Handler().postDelayed(new Runnable() { // from class: com.tencent.mm.ui.widget.WeSnackBar.Builder.1
                @Override // java.lang.Runnable
                public void run() {
                    if ((Builder.this.f152753c instanceof Activity) && (((Activity) Builder.this.f152753c).getWindow() == null || ((Activity) Builder.this.f152753c).isFinishing() || ((Activity) Builder.this.f152753c).isDestroyed())) {
                        return;
                    }
                    try {
                        if (Builder.this.f152752b != null && Builder.this.f152752b.isShowing()) {
                            Builder.this.f152752b.dismiss();
                        }
                    } catch (Exception e16) {
                        n.b("MicroMsg.WeSnackBar", "Exception %s", e16);
                    }
                }
            }, this.f152758h);
        }
    }

    public WeSnackBar(@NonNull Context context, int i3, int i16) {
        super(context, i3);
        this.f152742h = 0;
        this.f152743i = getContext().getResources().getDimensionPixelSize(R.dimen.bht);
        this.f152744j = 0;
        this.f152742h = i16;
        this.f152745k = context;
        d();
    }

    public static Builder build(Context context) {
        return new Builder(context);
    }

    public final void d() {
        View inflate = View.inflate(getContext(), R.layout.f169181i44, null);
        this.f152740f = inflate;
        this.f152736b = (TextView) inflate.findViewById(R.id.f86674sa);
        this.f152737c = (TextView) this.f152740f.findViewById(R.id.f86644s8);
        this.f152738d = (WeImageView) this.f152740f.findViewById(R.id.f86654s9);
        this.f152741g = (ViewGroup) this.f152740f.findViewById(R.id.f86634s7);
        this.f152739e = (ProgressBar) this.f152740f.findViewById(R.id.f86664s_);
        j();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        SnackBar.OnVisibilityChangeListener onVisibilityChangeListener = this.f152746l;
        if (onVisibilityChangeListener != null) {
            onVisibilityChangeListener.onHide();
        }
    }

    public final boolean e() {
        if ((this.f152742h & 8) != 0) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        if ((this.f152742h & 4) != 0) {
            return true;
        }
        return false;
    }

    public final boolean g() {
        if ((this.f152742h & 2) != 0) {
            return true;
        }
        return false;
    }

    public Builder getBuilder() {
        return this.f152735a;
    }

    public View getContentView() {
        return this.f152740f;
    }

    public final boolean h() {
        if ((this.f152742h & 16) != 0) {
            return true;
        }
        return false;
    }

    public final void i() {
        Context context;
        View findViewById;
        try {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            if (!e()) {
                attributes.flags |= 8;
            } else {
                attributes.flags &= -9;
            }
            attributes.gravity = 80;
            if (this.f152744j == 0 && (context = this.f152745k) != null && (context instanceof Activity) && (findViewById = ((Activity) context).findViewById(R.id.tui)) != null) {
                this.f152744j = findViewById.getHeight() + this.f152743i;
            }
            if (this.f152744j == 0) {
                this.f152744j = this.f152743i;
            }
            attributes.y = this.f152744j;
            onWindowAttributesChanged(attributes);
            setCancelable(!e());
        } catch (Exception e16) {
            n.b("MicroMsg.WeSnackBar", "updateLayoutParams Exception %s", e16);
        }
    }

    public final void j() {
        if (g()) {
            this.f152738d.setVisibility(0);
        } else {
            this.f152738d.setVisibility(8);
        }
        if (h()) {
            this.f152739e.setVisibility(0);
        } else {
            this.f152739e.setVisibility(8);
        }
        if (f()) {
            this.f152741g.setVisibility(0);
        } else {
            this.f152741g.setVisibility(4);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.f152740f, new LinearLayout.LayoutParams(-1, -1));
        i();
        SnackBar.OnVisibilityChangeListener onVisibilityChangeListener = this.f152746l;
        if (onVisibilityChangeListener != null) {
            onVisibilityChangeListener.onShow();
        }
    }

    public void setAction(Action action) {
        if (action != null) {
            setActionText(action.getActionText());
            a(action.getOnActionClickListener());
        }
    }

    public void setActionText(CharSequence charSequence) {
        TextView textView;
        if (!TextUtils.isEmpty(charSequence) && f() && (textView = this.f152737c) != null) {
            textView.setText(charSequence);
        }
    }

    public void setBuilder(Builder builder) {
        this.f152735a = builder;
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z16) {
        super.setCancelable(z16);
        setCanceledOnTouchOutside(z16);
    }

    public void setIcon(int i3) {
        WeImageView weImageView = this.f152738d;
        if (weImageView != null) {
            weImageView.setImageResource(i3);
        }
    }

    public void setMessage(CharSequence charSequence) {
        TextView textView;
        if (!TextUtils.isEmpty(charSequence) && (textView = this.f152736b) != null) {
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

    public void setShowStyleFlag(int i3) {
        this.f152742h = i3;
    }

    public final void a(final SnackBar.OnMessageClickListener onMessageClickListener) {
        ViewGroup viewGroup = this.f152741g;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.WeSnackBar.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SnackBar.OnMessageClickListener onMessageClickListener2 = onMessageClickListener;
                    if (onMessageClickListener2 != null) {
                        onMessageClickListener2.onMessageClick();
                    }
                }
            });
        }
    }

    public final void a(SnackBar.OnVisibilityChangeListener onVisibilityChangeListener) {
        if (onVisibilityChangeListener != null) {
            this.f152746l = onVisibilityChangeListener;
        }
    }

    public final void a(int i3) {
        this.f152744j = i3;
    }
}
