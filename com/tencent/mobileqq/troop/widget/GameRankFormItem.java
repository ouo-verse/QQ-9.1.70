package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.o;

/* compiled from: P */
/* loaded from: classes19.dex */
public class GameRankFormItem extends FormSimpleItem {
    static IPatchRedirector $redirector_;

    /* renamed from: b0, reason: collision with root package name */
    public int f302333b0;

    public GameRankFormItem(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.FormSimpleItem
    public void i() {
        int i3;
        int i16;
        int i17;
        int intrinsicWidth;
        int i18;
        int i19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.M == null) {
            return;
        }
        a();
        TextView textView = this.L;
        if (textView != null) {
            textView.setMaxWidth(this.W);
        }
        if (this.f302333b0 > 0) {
            if (this.f315672m == null) {
                this.f315672m = "";
            }
            this.M.setVisibility(0);
            int i26 = this.f302333b0;
            if (i26 >= 4) {
                this.M.setText(((Object) this.f315672m) + String.valueOf(this.f302333b0));
            } else if (i26 > 0) {
                Resources resources = getResources();
                int i27 = this.f302333b0;
                if (i27 == 1) {
                    i17 = R.drawable.e3y;
                } else if (i27 == 2) {
                    i17 = R.drawable.e3z;
                } else {
                    i17 = R.drawable.f161542e40;
                }
                Drawable drawable = resources.getDrawable(i17);
                CharSequence charSequence = this.f315672m;
                TextPaint paint = this.M.getPaint();
                int i28 = this.T;
                Drawable drawable2 = this.C;
                if (drawable2 == null) {
                    intrinsicWidth = 0;
                } else {
                    intrinsicWidth = drawable2.getIntrinsicWidth();
                }
                int i29 = i28 - intrinsicWidth;
                if (this.G) {
                    i18 = this.H.getIntrinsicWidth();
                } else {
                    i18 = 0;
                }
                this.M.setText(TextUtils.ellipsize(charSequence, paint, (i29 - i18) - drawable.getIntrinsicWidth(), TextUtils.TruncateAt.END));
                this.M.g(drawable, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight()).i();
            }
            this.M.setTextColor(o.a(getResources(), this.F));
            this.M.setContentDescription(((Object) this.f315672m) + String.valueOf(this.f302333b0));
            this.M.setMaxWidth(this.T);
            Drawable drawable3 = this.C;
            if (drawable3 != null && this.G) {
                if (this.D > 0 && this.E > 0) {
                    Drawable drawable4 = this.H;
                    drawable4.setBounds(0, 0, drawable4.getIntrinsicWidth(), this.H.getIntrinsicHeight());
                    this.C.setBounds(0, 0, this.D, this.E);
                    this.M.setCompoundDrawables(this.C, null, this.H, null);
                } else {
                    this.M.setCompoundDrawablesWithIntrinsicBounds(drawable3, (Drawable) null, this.H, (Drawable) null);
                }
                this.M.setCompoundDrawablePadding(8);
                return;
            }
            if (drawable3 != null && !this.G) {
                int i36 = this.D;
                if (i36 > 0 && (i19 = this.E) > 0) {
                    drawable3.setBounds(0, 0, i36, i19);
                    this.M.setCompoundDrawables(this.C, null, null, null);
                } else {
                    this.M.setCompoundDrawablesWithIntrinsicBounds(drawable3, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                this.M.setCompoundDrawablePadding(8);
                return;
            }
            if (drawable3 == null && this.G) {
                this.M.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.H, (Drawable) null);
                this.M.setCompoundDrawablePadding(8);
                return;
            } else {
                if (drawable3 == null && !this.G) {
                    this.M.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.M.setCompoundDrawablePadding(0);
                    return;
                }
                return;
            }
        }
        this.M.setText("");
        Drawable drawable5 = this.C;
        if (drawable5 != null && this.G) {
            this.M.setVisibility(0);
            int i37 = this.D;
            if (i37 > 0 && (i16 = this.E) > 0) {
                this.C.setBounds(0, 0, i37, i16);
                Drawable drawable6 = this.H;
                drawable6.setBounds(0, 0, drawable6.getIntrinsicWidth(), this.H.getIntrinsicHeight());
                this.M.setCompoundDrawables(this.C, null, this.H, null);
            } else {
                this.M.setCompoundDrawablesWithIntrinsicBounds(this.C, (Drawable) null, this.H, (Drawable) null);
            }
            this.M.setCompoundDrawablePadding(8);
            return;
        }
        if (drawable5 != null && !this.G) {
            this.M.setVisibility(0);
            int i38 = this.D;
            if (i38 > 0 && (i3 = this.E) > 0) {
                this.C.setBounds(0, 0, i38, i3);
                this.M.setCompoundDrawables(this.C, null, null, null);
            } else {
                this.M.setCompoundDrawablesWithIntrinsicBounds(this.C, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.M.setCompoundDrawablePadding(0);
            return;
        }
        if (drawable5 == null && this.G) {
            this.M.setVisibility(0);
            this.M.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.H, (Drawable) null);
            this.M.setCompoundDrawablePadding(0);
        } else if (drawable5 == null && !this.G) {
            this.M.setVisibility(8);
        }
    }
}
