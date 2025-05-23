package com.tencent.luggage.wxa.g6;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.mm.ui.widget.dialog.IConfirmDialog;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final MMAlertDialog f126469a;

    /* renamed from: b, reason: collision with root package name */
    public final e f126470b = new e();

    public d(MMAlertDialog mMAlertDialog) {
        this.f126469a = mMAlertDialog;
    }

    public d a(String str) {
        this.f126470b.f126489s = str;
        return this;
    }

    public d b(DialogInterface.OnClickListener onClickListener) {
        this.f126470b.B = onClickListener;
        return this;
    }

    public d c(String str) {
        this.f126470b.f126492v = str;
        return this;
    }

    public d d(String str) {
        this.f126470b.f126471a = str;
        return this;
    }

    public d a(DialogInterface.OnClickListener onClickListener) {
        this.f126470b.C = onClickListener;
        return this;
    }

    public d b(String str) {
        this.f126470b.f126493w = str;
        return this;
    }

    public d a(DialogInterface.OnCancelListener onCancelListener) {
        this.f126470b.D = onCancelListener;
        return this;
    }

    public d b(boolean z16) {
        this.f126469a.setCanceledOnTouchOutside(z16);
        return this;
    }

    public d a(boolean z16) {
        this.f126470b.f126494x = z16;
        return this;
    }

    public final void a(e eVar) {
        CharSequence charSequence = eVar.f126471a;
        if (charSequence != null && charSequence.length() > 0) {
            this.f126469a.setTitleGravity(eVar.M);
            this.f126469a.setTitle(eVar.f126471a);
        }
        CharSequence charSequence2 = eVar.f126472b;
        if (charSequence2 != null && charSequence2.length() > 0) {
            this.f126469a.setTitleDesc(eVar.f126472b);
        }
        int i3 = eVar.I;
        if (i3 != 0) {
            this.f126469a.setTitleColor(i3);
        }
        int i16 = eVar.J;
        if (i16 != 0) {
            this.f126469a.setTitleMaxLine(i16);
        }
        int i17 = eVar.K;
        if (i17 != 0) {
            this.f126469a.setMsgMaxLine(i17);
        }
        View view = eVar.F;
        if (view != null) {
            this.f126469a.setView(view);
        }
        View view2 = eVar.G;
        if (view2 != null) {
            this.f126469a.setCustomTitleView(view2);
        }
        View view3 = eVar.H;
        if (view3 != null) {
            this.f126469a.setIconTitleDetail(view3);
        }
        Drawable drawable = eVar.f126485o;
        if (drawable != null) {
            this.f126469a.setMsgIcon(drawable);
        }
        CharSequence charSequence3 = eVar.f126489s;
        if (charSequence3 != null && charSequence3.length() > 0) {
            this.f126469a.setMessage(eVar.f126489s);
        }
        this.f126469a.setMsgContentBg(eVar.f126496z);
        String str = eVar.f126488r;
        if (str != null) {
            this.f126469a.setMsgIcon(str);
            this.f126469a.setMsgIconVisibility(eVar.O);
        }
        if (!eVar.T && !eVar.U) {
            CharSequence charSequence4 = eVar.f126489s;
            if (charSequence4 != null && charSequence4.length() > 0) {
                this.f126469a.setMessage(eVar.f126489s);
            }
            CharSequence charSequence5 = eVar.f126490t;
            if (charSequence5 != null && charSequence5.length() > 0) {
                this.f126469a.setMsgSubTitle(eVar.f126490t);
            } else {
                this.f126469a.setMsgContentBg(false);
            }
            CharSequence charSequence6 = eVar.f126491u;
            if (charSequence6 != null && charSequence6.length() > 0) {
                this.f126469a.setMsgSubDesc(eVar.f126491u);
            }
            Bitmap bitmap = eVar.f126486p;
            if (bitmap != null) {
                this.f126469a.setMsgIcon(bitmap);
            }
        }
        if (eVar.T) {
            this.f126469a.setLeftIconStyle(eVar.f126486p, eVar.f126490t, eVar.f126491u);
        } else if (eVar.U) {
            this.f126469a.setRightIconStyle(eVar.f126486p, eVar.f126490t, eVar.f126491u);
        }
        String str2 = eVar.f126477g;
        if (str2 != null || eVar.f126478h != null) {
            this.f126469a.setIconTitle(str2, eVar.f126478h, Boolean.valueOf(eVar.f126479i), eVar.f126481k, eVar.f126482l, eVar.f126484n);
        }
        IConfirmDialog.IOnContentClick iOnContentClick = eVar.f126483m;
        if (iOnContentClick != null) {
            this.f126469a.setContentClick(iOnContentClick);
        }
        Bitmap bitmap2 = eVar.f126487q;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.f126469a.setDialogImage(eVar.f126487q, eVar.A, eVar.N);
        }
        CharSequence charSequence7 = eVar.f126473c;
        if (charSequence7 != null && charSequence7.length() > 0) {
            this.f126469a.setContentDescTv(eVar.f126473c);
            this.f126469a.setContentDescTvGravity(eVar.L);
        }
        CharSequence charSequence8 = eVar.f126474d;
        if (charSequence8 != null && charSequence8.length() > 0) {
            this.f126469a.setEditTextHint(eVar.f126474d);
        }
        CharSequence charSequence9 = eVar.f126475e;
        if (charSequence9 != null && charSequence9.length() > 0) {
            this.f126469a.setCheckBoxText(eVar.f126475e);
        }
        boolean z16 = eVar.f126476f;
        if (z16) {
            this.f126469a.hasEditText(z16);
        }
        CharSequence charSequence10 = eVar.f126492v;
        if (charSequence10 != null && charSequence10.length() > 0) {
            this.f126469a.setPositiveButton(eVar.f126492v, eVar.S, eVar.B);
        }
        CharSequence charSequence11 = eVar.f126493w;
        if (charSequence11 != null && charSequence11.length() > 0) {
            this.f126469a.setNegativeButton(eVar.f126493w, eVar.S, eVar.C);
        }
        int i18 = eVar.Q;
        if (i18 != 0) {
            this.f126469a.setPositiveButtonColor(i18);
        }
        int i19 = eVar.P;
        if (i19 != 0) {
            this.f126469a.setNegativeButtonColor(i19);
        }
        DialogInterface.OnCancelListener onCancelListener = eVar.D;
        if (onCancelListener != null) {
            this.f126469a.setOnCancelListener(onCancelListener);
        }
        DialogInterface.OnDismissListener onDismissListener = eVar.E;
        if (onDismissListener != null) {
            this.f126469a.setOnDismissListener(onDismissListener);
        }
        int i26 = eVar.R;
        if (i26 != 0) {
            this.f126469a.setBackground(i26);
        }
        this.f126469a.setCancelable(eVar.f126494x);
        this.f126469a.setCanBack(eVar.f126495y);
    }

    public void a() {
        a(this.f126470b);
        this.f126469a.show();
    }
}
