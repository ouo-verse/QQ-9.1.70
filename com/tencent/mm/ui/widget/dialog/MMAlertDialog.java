package com.tencent.mm.ui.widget.dialog;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.luggage.wxa.lo.l;
import com.tencent.luggage.wxa.lo.n;
import com.tencent.luggage.wxa.lo.o;
import com.tencent.mm.ui.widget.dialog.IConfirmDialog;
import com.tencent.mm.ui.widget.edittext.PasterEditText;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes9.dex */
public class MMAlertDialog extends Dialog implements DialogInterface {
    public static final int NOT_SHOW_ICON = 3;
    public static final int SHOW_SIGHT_ICON = 1;
    public static final int SHOW_VIDEO_ICON = 2;
    public ImageView C;
    public ImageView D;
    public View E;
    public View F;
    public LinearLayout G;
    public ViewStub H;
    public LinearLayout I;
    public boolean J;
    public ViewGroup K;
    public LinearLayout L;
    public ViewGroup M;
    public View N;
    public boolean O;
    public boolean P;
    public Animation Q;
    public Animation R;
    public Animation S;
    public Animation T;
    public Builder.ITextSmileySpan U;
    public DialogInterface.OnDismissListener V;
    public IOnDialogDismissListener W;

    /* renamed from: a, reason: collision with root package name */
    public Context f152880a;

    /* renamed from: b, reason: collision with root package name */
    public LinearLayout f152881b;

    /* renamed from: c, reason: collision with root package name */
    public LinearLayout f152882c;

    /* renamed from: d, reason: collision with root package name */
    public Button f152883d;

    /* renamed from: e, reason: collision with root package name */
    public Button f152884e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f152885f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f152886g;

    /* renamed from: h, reason: collision with root package name */
    public TextView f152887h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f152888i;

    /* renamed from: j, reason: collision with root package name */
    public TextView f152889j;

    /* renamed from: k, reason: collision with root package name */
    public TextView f152890k;

    /* renamed from: l, reason: collision with root package name */
    public EditText f152891l;

    /* renamed from: m, reason: collision with root package name */
    public CheckBox f152892m;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public Context f152927a;

        /* renamed from: b, reason: collision with root package name */
        public AlertParams f152928b;

        /* renamed from: c, reason: collision with root package name */
        public MMAlertDialog f152929c;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public interface IEditTextExtend {
            void onEditTextExtend(EditText editText);
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public interface IIconAttach {
            void onIconAttach(ImageView imageView, String str);
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public interface IOnTitleClick {
            void onTitleClick(boolean z16);
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public interface ITextSmileySpan {
            CharSequence smileySpan(Context context, CharSequence charSequence, float f16);
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public interface ITitleAttach {
            void onTitleAttach(TextView textView);
        }

        public Builder(Context context) {
            this.f152927a = context;
            this.f152928b = new AlertParams();
        }

        public final Resources a() {
            return com.tencent.luggage.wxa.no.a.a(this.f152927a);
        }

        public MMAlertDialog create() {
            MMAlertDialog mMAlertDialog = new MMAlertDialog(this.f152927a, R.style.ayj);
            mMAlertDialog.apply(this.f152928b);
            this.f152929c = mMAlertDialog;
            IEditTextExtend iEditTextExtend = this.f152928b.f152851n;
            if (iEditTextExtend != null) {
                iEditTextExtend.onEditTextExtend(mMAlertDialog.getmEditText());
            }
            return mMAlertDialog;
        }

        public MMAlertDialog getAlert() {
            return this.f152929c;
        }

        public DialogInterface.OnCancelListener getCancelListener() {
            return this.f152928b.I;
        }

        public DialogInterface.OnDismissListener getDismissListener() {
            return this.f152928b.J;
        }

        public AlertParams getParams() {
            return this.f152928b;
        }

        public Builder hasEditText(boolean z16) {
            this.f152928b.f152841f = z16;
            return this;
        }

        public Builder hasMsgContentBg(boolean z16) {
            this.f152928b.E = z16;
            return this;
        }

        public Builder setAlertTitleHeadContentTopMargin(int i3) {
            this.f152928b.f152834b0 = i3;
            return this;
        }

        public Builder setBackground(int i3) {
            this.f152928b.Z = i3;
            return this;
        }

        public Builder setBottomBtnTopMargin(int i3) {
            this.f152928b.f152832a0 = i3;
            return this;
        }

        public Builder setBtnUpDown(boolean z16) {
            this.f152928b.f152847j = z16;
            return this;
        }

        public Builder setCanBack(boolean z16) {
            this.f152928b.D = z16;
            return this;
        }

        public Builder setCancelable(boolean z16) {
            this.f152928b.C = z16;
            return this;
        }

        public Builder setCenterImg(Bitmap bitmap, boolean z16, int i3) {
            AlertParams alertParams = this.f152928b;
            alertParams.f152856s = bitmap;
            alertParams.F = z16;
            alertParams.V = i3;
            return this;
        }

        public Builder setCheckBox(String str) {
            this.f152928b.f152839e = str;
            return this;
        }

        public Builder setContentClick(IConfirmDialog.IOnContentClick iOnContentClick) {
            this.f152928b.f152852o = iOnContentClick;
            return this;
        }

        public Builder setContentDescTv(String str) {
            this.f152928b.f152835c = str;
            return this;
        }

        public Builder setContentDescTvGravity(int i3) {
            this.f152928b.T = i3;
            return this;
        }

        public Builder setContext(Context context) {
            this.f152927a = context;
            return this;
        }

        public Builder setCustomTitle(View view) {
            this.f152928b.O = view;
            return this;
        }

        public Builder setDismissAfterClicked(boolean z16) {
            this.f152928b.f152836c0 = z16;
            return this;
        }

        public Builder setEditTextExtend(IEditTextExtend iEditTextExtend) {
            this.f152928b.f152851n = iEditTextExtend;
            return this;
        }

        public Builder setEditTextHint(String str) {
            this.f152928b.f152837d = str;
            return this;
        }

        public Builder setHideContentArea(boolean z16) {
            this.f152928b.f152844g0 = z16;
            return this;
        }

        @Deprecated
        public Builder setImageTitle(String str, CharSequence charSequence, Boolean bool, IOnTitleClick iOnTitleClick) {
            return setImageTitle(str, charSequence, bool, iOnTitleClick, null);
        }

        public Builder setLeftIconStyle(Bitmap bitmap, CharSequence charSequence, CharSequence charSequence2) {
            AlertParams alertParams = this.f152928b;
            alertParams.f152855r = bitmap;
            alertParams.f152859v = charSequence;
            alertParams.f152860w = charSequence2;
            alertParams.f152838d0 = true;
            return this;
        }

        public Builder setMsg(String str) {
            this.f152928b.f152858u = str;
            return this;
        }

        public Builder setMsgIcon(Drawable drawable) {
            this.f152928b.f152854q = drawable;
            return this;
        }

        public Builder setMsgIconVisivility(int i3) {
            this.f152928b.W = i3;
            return this;
        }

        public Builder setMsgMaxLine(int i3) {
            this.f152928b.S = i3;
            return this;
        }

        public Builder setMsgSubDesc(String str) {
            this.f152928b.f152860w = str;
            return this;
        }

        public Builder setMsgSubTitle(CharSequence charSequence) {
            this.f152928b.f152859v = charSequence;
            return this;
        }

        public Builder setMultiBtnListener(DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnClickListener onClickListener3) {
            AlertParams alertParams = this.f152928b;
            alertParams.K = onClickListener;
            alertParams.L = onClickListener2;
            alertParams.M = onClickListener3;
            return this;
        }

        public Builder setMultiBtnText(String str, String str2, String str3) {
            AlertParams alertParams = this.f152928b;
            alertParams.f152863z = str;
            alertParams.A = str2;
            alertParams.B = str3;
            return this;
        }

        public Builder setNegativeBtnColor(int i3) {
            this.f152928b.X = i3;
            return this;
        }

        public Builder setNegativeBtnListener(DialogInterface.OnClickListener onClickListener) {
            this.f152928b.H = onClickListener;
            return this;
        }

        public Builder setNegativeBtnText(String str) {
            this.f152928b.f152862y = str;
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.f152928b.I = onCancelListener;
            return this;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.f152928b.J = onDismissListener;
            return this;
        }

        public Builder setPositiveBtnColor(int i3) {
            this.f152928b.Y = i3;
            return this;
        }

        public Builder setPositiveBtnListener(DialogInterface.OnClickListener onClickListener) {
            this.f152928b.G = onClickListener;
            return this;
        }

        public Builder setPositiveBtnText(String str) {
            this.f152928b.f152861x = str;
            return this;
        }

        public Builder setRightIconStyle(Bitmap bitmap, CharSequence charSequence, CharSequence charSequence2) {
            AlertParams alertParams = this.f152928b;
            alertParams.f152855r = bitmap;
            alertParams.f152859v = charSequence;
            alertParams.f152860w = charSequence2;
            alertParams.f152840e0 = true;
            return this;
        }

        public Builder setTextSmileySpan(ITextSmileySpan iTextSmileySpan) {
            this.f152928b.f152853p = iTextSmileySpan;
            return this;
        }

        public Builder setTitle(String str) {
            this.f152928b.f152831a = str;
            return this;
        }

        public Builder setTitleAttachListener(ITitleAttach iTitleAttach) {
            this.f152928b.f152850m = iTitleAttach;
            return this;
        }

        public Builder setTitleColor(int i3) {
            this.f152928b.Q = i3;
            return this;
        }

        public Builder setTitleDesc(CharSequence charSequence) {
            this.f152928b.f152833b = charSequence;
            return this;
        }

        public Builder setTitleDetailView(View view) {
            this.f152928b.P = view;
            return this;
        }

        public Builder setTitleGravity(int i3) {
            this.f152928b.U = i3;
            return this;
        }

        public Builder setTitleMaxLine(int i3) {
            this.f152928b.R = i3;
            return this;
        }

        public Builder setView(View view) {
            this.f152928b.N = view;
            return this;
        }

        public void show() {
            create();
            MMAlertDialog mMAlertDialog = this.f152929c;
            if (mMAlertDialog != null) {
                mMAlertDialog.show();
            }
        }

        public Builder showAlwayDark(boolean z16) {
            this.f152928b.f152842f0 = z16;
            return this;
        }

        public Builder setImageTitle(String str, CharSequence charSequence, Boolean bool, IOnTitleClick iOnTitleClick, IIconAttach iIconAttach) {
            AlertParams alertParams = this.f152928b;
            alertParams.f152843g = str;
            alertParams.f152845h = charSequence;
            alertParams.f152846i = bool.booleanValue();
            AlertParams alertParams2 = this.f152928b;
            alertParams2.f152848k = iOnTitleClick;
            alertParams2.f152849l = iIconAttach;
            return this;
        }

        public Builder setMsg(int i3) {
            this.f152928b.f152858u = a().getString(i3);
            return this;
        }

        public Builder setMsgIcon(int i3) {
            this.f152928b.f152854q = this.f152927a.getResources().getDrawable(i3);
            return this;
        }

        public Builder setNegativeBtnText(int i3) {
            this.f152928b.f152862y = a().getString(i3);
            return this;
        }

        public Builder setPositiveBtnListener(boolean z16, DialogInterface.OnClickListener onClickListener) {
            AlertParams alertParams = this.f152928b;
            alertParams.G = onClickListener;
            alertParams.f152836c0 = z16;
            return this;
        }

        public Builder setPositiveBtnText(int i3) {
            this.f152928b.f152861x = a().getString(i3);
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.f152928b.f152831a = charSequence;
            return this;
        }

        public Builder setMsgIcon(Bitmap bitmap) {
            this.f152928b.f152855r = bitmap;
            return this;
        }

        public Builder setTitle(int i3) {
            this.f152928b.f152831a = a().getString(i3);
            return this;
        }

        public Builder(Context context, AlertParams alertParams) {
            this.f152927a = context;
            this.f152928b = alertParams;
        }

        public Builder setMsgIcon(String str) {
            this.f152928b.f152857t = str;
            return this;
        }

        public MMAlertDialog create(boolean z16) {
            MMAlertDialog mMAlertDialog = new MMAlertDialog(this.f152927a, R.style.ayj);
            mMAlertDialog.apply(this.f152928b);
            this.f152929c = mMAlertDialog;
            if (this.f152928b.f152858u.length() > 0) {
                this.f152929c.setMsgContentBold(z16);
            }
            IEditTextExtend iEditTextExtend = this.f152928b.f152851n;
            if (iEditTextExtend != null) {
                iEditTextExtend.onEditTextExtend(mMAlertDialog.getmEditText());
            }
            return mMAlertDialog;
        }
    }

    public MMAlertDialog(Context context) {
        super(context, R.style.ayj);
        this.O = false;
        this.P = false;
        this.f152880a = context;
        a(context);
    }

    public void apply(final AlertParams alertParams) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        View findViewById;
        CharSequence charSequence = alertParams.f152831a;
        if (charSequence != null && charSequence.length() > 0) {
            setTitleGravity(alertParams.U);
            setTitle(alertParams.f152831a);
        }
        CharSequence charSequence2 = alertParams.f152833b;
        if (charSequence2 != null && charSequence2.length() > 0) {
            setTitleDesc(alertParams.f152833b);
        }
        int i3 = alertParams.Q;
        if (i3 != 0) {
            setTitleColor(i3);
        }
        int i16 = alertParams.R;
        if (i16 != 0) {
            setTitleMaxLine(i16);
        }
        int i17 = alertParams.S;
        if (i17 != 0) {
            setMsgMaxLine(i17);
        }
        View view = alertParams.N;
        if (view != null) {
            setView(view);
        }
        View view2 = alertParams.O;
        if (view2 != null) {
            setCustomTitleView(view2);
        }
        View view3 = alertParams.P;
        if (view3 != null) {
            setIconTitleDetail(view3);
        }
        Drawable drawable = alertParams.f152854q;
        if (drawable != null) {
            setMsgIcon(drawable);
        }
        CharSequence charSequence3 = alertParams.f152858u;
        if (charSequence3 != null && charSequence3.length() > 0) {
            setMessage(alertParams.f152858u);
        }
        setMsgContentBg(alertParams.E);
        String str = alertParams.f152857t;
        if (str != null) {
            setMsgIcon(str);
            setMsgIconVisibility(alertParams.W);
        }
        if (!alertParams.f152838d0 && !alertParams.f152840e0) {
            CharSequence charSequence4 = alertParams.f152858u;
            if (charSequence4 != null && charSequence4.length() > 0) {
                setMessage(alertParams.f152858u);
            }
            CharSequence charSequence5 = alertParams.f152859v;
            if (charSequence5 != null && charSequence5.length() > 0) {
                setMsgSubTitle(alertParams.f152859v);
            } else {
                setMsgContentBg(false);
            }
            CharSequence charSequence6 = alertParams.f152860w;
            if (charSequence6 != null && charSequence6.length() > 0) {
                setMsgSubDesc(alertParams.f152860w);
            }
            Bitmap bitmap = alertParams.f152855r;
            if (bitmap != null) {
                setMsgIcon(bitmap);
            }
        }
        if (alertParams.f152838d0) {
            setLeftIconStyle(alertParams.f152855r, alertParams.f152859v, alertParams.f152860w);
        } else if (alertParams.f152840e0) {
            setRightIconStyle(alertParams.f152855r, alertParams.f152859v, alertParams.f152860w);
        }
        String str2 = alertParams.f152843g;
        if (str2 != null || alertParams.f152845h != null) {
            setIconTitle(str2, alertParams.f152845h, Boolean.valueOf(alertParams.f152846i), alertParams.f152848k, alertParams.f152849l, alertParams.f152850m);
        }
        IConfirmDialog.IOnContentClick iOnContentClick = alertParams.f152852o;
        if (iOnContentClick != null) {
            setContentClick(iOnContentClick);
        }
        Bitmap bitmap2 = alertParams.f152856s;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            setDialogImage(alertParams.f152856s, alertParams.F, alertParams.V);
        }
        CharSequence charSequence7 = alertParams.f152835c;
        if (charSequence7 != null && charSequence7.length() > 0) {
            setContentDescTv(alertParams.f152835c);
            this.O = true;
            setContentDescTvGravity(alertParams.T);
        }
        CharSequence charSequence8 = alertParams.f152837d;
        if (charSequence8 != null && charSequence8.length() > 0) {
            setEditTextHint(alertParams.f152837d);
        }
        CharSequence charSequence9 = alertParams.f152839e;
        if (charSequence9 != null && charSequence9.length() > 0) {
            setCheckBoxText(alertParams.f152839e);
        }
        boolean z16 = alertParams.f152841f;
        if (z16) {
            this.P = z16;
            hasEditText(z16);
        }
        CharSequence charSequence10 = alertParams.f152861x;
        if (charSequence10 != null && charSequence10.length() > 0) {
            c(alertParams);
        }
        CharSequence charSequence11 = alertParams.f152862y;
        if (charSequence11 != null && charSequence11.length() > 0) {
            b(alertParams);
        }
        int i18 = alertParams.Y;
        if (i18 != 0) {
            setPositiveButtonColor(i18);
        }
        int i19 = alertParams.X;
        if (i19 != 0) {
            setNegativeButtonColor(i19);
        }
        DialogInterface.OnCancelListener onCancelListener = alertParams.I;
        if (onCancelListener != null) {
            setOnCancelListener(onCancelListener);
        }
        DialogInterface.OnDismissListener onDismissListener = alertParams.J;
        if (onDismissListener != null) {
            a(onDismissListener);
            setOnDismissListener(alertParams.J);
        }
        Builder.ITextSmileySpan iTextSmileySpan = alertParams.f152853p;
        if (iTextSmileySpan != null) {
            a(iTextSmileySpan);
        }
        int i26 = alertParams.Z;
        if (i26 != 0) {
            setBackground(i26);
        }
        setCancelable(alertParams.C);
        boolean z17 = alertParams.C;
        this.J = z17;
        if (!z17) {
            setCanBack(alertParams.D);
        }
        if (alertParams.f152863z != null || alertParams.A != null || alertParams.B != null) {
            View inflate = View.inflate(this.f152880a, R.layout.e3t, null);
            Button button = (Button) inflate.findViewById(R.id.f166298zc3);
            Button button2 = (Button) inflate.findViewById(R.id.f166299zc4);
            Button button3 = (Button) inflate.findViewById(R.id.zc5);
            if (alertParams.f152863z != null) {
                button.setVisibility(0);
                button.setText(alertParams.f152863z);
                button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMAlertDialog.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view4) {
                        DialogInterface.OnClickListener onClickListener = alertParams.K;
                        if (onClickListener != null) {
                            onClickListener.onClick(MMAlertDialog.this, -1);
                        }
                        MMAlertDialog.this.dismiss();
                    }
                });
            }
            if (alertParams.A != null) {
                button2.setVisibility(0);
                button2.setText(alertParams.A);
                button2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMAlertDialog.13
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view4) {
                        DialogInterface.OnClickListener onClickListener = alertParams.L;
                        if (onClickListener != null) {
                            onClickListener.onClick(MMAlertDialog.this, -2);
                        }
                        MMAlertDialog.this.dismiss();
                    }
                });
            }
            if (alertParams.B != null) {
                button3.setVisibility(0);
                button3.setText(alertParams.B);
                button3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMAlertDialog.14
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view4) {
                        DialogInterface.OnClickListener onClickListener = alertParams.M;
                        if (onClickListener != null) {
                            onClickListener.onClick(MMAlertDialog.this, -3);
                        }
                        MMAlertDialog.this.dismiss();
                    }
                });
            }
            a(inflate, new LinearLayout.LayoutParams(-1, -1));
        }
        if (alertParams.f152847j) {
            View inflate2 = View.inflate(this.f152880a, R.layout.e3o, null);
            this.f152884e = (Button) inflate2.findViewById(R.id.zc7);
            this.f152883d = (Button) inflate2.findViewById(R.id.zce);
            int i27 = alertParams.Y;
            if (i27 != 0) {
                setPositiveButtonColor(i27);
            }
            int i28 = alertParams.X;
            if (i28 != 0) {
                setNegativeButtonColor(i28);
            }
            CharSequence charSequence12 = alertParams.f152861x;
            if (charSequence12 != null && charSequence12.length() > 0) {
                setPositiveButton(alertParams.f152861x, alertParams.f152836c0, alertParams.G);
            }
            CharSequence charSequence13 = alertParams.f152862y;
            if (charSequence13 != null && charSequence13.length() > 0) {
                setNegativeButton(alertParams.f152862y, alertParams.H);
            }
            a(inflate2, new LinearLayout.LayoutParams(-1, -1));
        }
        if (alertParams.f152842f0) {
            LinearLayout linearLayout3 = this.f152882c;
            if (linearLayout3 != null) {
                linearLayout3.setBackgroundResource(R.drawable.f160600jl1);
            }
            c(this.f152880a.getResources().getColor(R.color.anp));
            setNegativeButtonColor(this.f152880a.getResources().getColor(R.color.ann));
            ImageView imageView = this.D;
            if (imageView != null) {
                imageView.setBackgroundColor(this.f152880a.getResources().getColor(R.color.akk));
            }
            ViewGroup viewGroup = this.K;
            if (viewGroup != null) {
                viewGroup.setBackgroundResource(R.drawable.lvo);
            }
        }
        if (alertParams.f152844g0 && (findViewById = this.f152881b.findViewById(R.id.f98625nl)) != null) {
            findViewById.setVisibility(8);
        }
        if (alertParams.f152832a0 != Integer.MAX_VALUE && (linearLayout2 = (LinearLayout) this.f152881b.findViewById(R.id.f166297zc2)) != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout2.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.setMargins(layoutParams.leftMargin, alertParams.f152832a0, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.setMargins(0, alertParams.f152832a0, 0, 0);
            }
            linearLayout2.setLayoutParams(layoutParams);
        }
        if (alertParams.f152834b0 != Integer.MAX_VALUE && (linearLayout = (LinearLayout) this.f152881b.findViewById(R.id.zcg)) != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.setMargins(layoutParams2.leftMargin, alertParams.f152834b0, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            } else {
                layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams2.setMargins(0, alertParams.f152834b0, 0, 0);
            }
            linearLayout.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mm.ui.widget.dialog.MMAlertDialog.15
                @Override // java.lang.Runnable
                public void run() {
                    MMAlertDialog.this.dismiss();
                }
            });
            n.b("MicroMsg.MMAlertDialog", "dialog dismiss error!", new Object[0]);
            return;
        }
        try {
            Context context = this.f152880a;
            if (context != null && (context instanceof Activity)) {
                if (!((Activity) context).isFinishing()) {
                    super.dismiss();
                }
            } else {
                super.dismiss();
            }
        } catch (Exception e16) {
            n.b("MicroMsg.MMAlertDialog", "dismiss exception, e = " + e16.getMessage(), new Object[0]);
        }
        IOnDialogDismissListener iOnDialogDismissListener = this.W;
        if (iOnDialogDismissListener != null) {
            iOnDialogDismissListener.onDialogDismiss(this);
        }
    }

    public void editTextRequestFocus() {
        this.f152891l.requestFocus();
    }

    public Button getButton(int i3) {
        if (i3 != -2) {
            if (i3 != -1) {
                return null;
            }
            return this.f152883d;
        }
        return this.f152884e;
    }

    public Button getCancelBtn() {
        return this.f152884e;
    }

    public View getContentView() {
        return this.f152881b;
    }

    public DialogInterface.OnDismissListener getDialogDismissListener() {
        return this.V;
    }

    public int getEditTextPasterLen() {
        EditText editText = this.f152891l;
        if (editText instanceof PasterEditText) {
            return ((PasterEditText) editText).getPasterLen();
        }
        return 0;
    }

    public String getEditTextValue() {
        EditText editText = this.f152891l;
        if (editText == null) {
            return null;
        }
        return editText.getText().toString();
    }

    public ImageView getMsgIcon() {
        return this.C;
    }

    public Button getOKBtn() {
        return this.f152883d;
    }

    public CheckBox getmCheckBox() {
        return this.f152892m;
    }

    public EditText getmEditText() {
        return this.f152891l;
    }

    public void hasEditText(boolean z16) {
        if (z16) {
            this.f152891l.setVisibility(0);
        } else {
            this.f152891l.setVisibility(8);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.f152881b);
    }

    public void setBackground(int i3) {
        LinearLayout linearLayout = this.f152882c;
        if (linearLayout != null) {
            linearLayout.setBackgroundResource(i3);
        }
    }

    public void setButtonVisible(int i3, boolean z16) {
        if (i3 != -2) {
            if (i3 == -1) {
                if (z16) {
                    this.f152883d.setVisibility(0);
                    return;
                } else {
                    this.f152883d.setVisibility(8);
                    return;
                }
            }
            return;
        }
        if (z16) {
            this.f152884e.setVisibility(0);
        } else {
            this.f152884e.setVisibility(8);
        }
    }

    public void setCanBack(boolean z16) {
        super.setCancelable(z16);
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z16) {
        super.setCancelable(z16);
        this.J = z16;
        setCanceledOnTouchOutside(z16);
    }

    public void setCheckBoxText(CharSequence charSequence) {
        this.f152892m.setVisibility(0);
        this.f152892m.setText(charSequence);
    }

    public void setContentClick(final IConfirmDialog.IOnContentClick iOnContentClick) {
        LinearLayout linearLayout = this.I;
        if (linearLayout != null && linearLayout.getVisibility() == 0) {
            this.I.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMAlertDialog.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    IConfirmDialog.IOnContentClick iOnContentClick2 = iOnContentClick;
                    if (iOnContentClick2 != null) {
                        iOnContentClick2.onContentClick();
                    }
                }
            });
            return;
        }
        LinearLayout linearLayout2 = this.L;
        if (linearLayout2 != null) {
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMAlertDialog.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    IConfirmDialog.IOnContentClick iOnContentClick2 = iOnContentClick;
                    if (iOnContentClick2 != null) {
                        iOnContentClick2.onContentClick();
                    }
                }
            });
        }
    }

    public void setContentDescTv(CharSequence charSequence) {
        if (charSequence != null) {
            this.f152890k.setVisibility(0);
            this.f152890k.setText(charSequence);
        }
    }

    public void setContentDescTvGravity(int i3) {
        TextView textView = this.f152890k;
        if (textView != null) {
            textView.setGravity(i3);
        }
    }

    public void setCustomTitleView(View view) {
        LinearLayout linearLayout;
        this.G.setVisibility(0);
        this.H.setLayoutResource(R.layout.e3p);
        try {
            linearLayout = (LinearLayout) this.H.inflate();
        } catch (Exception unused) {
            this.H.setVisibility(0);
            linearLayout = null;
        }
        linearLayout.addView(view);
    }

    public void setDialogImage(Bitmap bitmap, boolean z16, int i3) {
        if (bitmap != null) {
            setMsgContentBg(false);
            this.I.setVisibility(0);
            this.I.setGravity(1);
            this.I.setPadding(0, 0, 0, 0);
            View inflate = View.inflate(this.f152880a, R.layout.e3s, null);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.zcb);
            if (z16) {
                bitmap = l.a(a(bitmap, imageView, bitmap.getWidth(), bitmap.getHeight()), true, o.a(this.f152880a, 3), false);
            }
            imageView.setImageBitmap(bitmap);
            ImageView imageView2 = (ImageView) inflate.findViewById(R.id.xit);
            if (i3 == 0) {
                imageView2.setVisibility(8);
            } else {
                imageView2.setVisibility(0);
                if (i3 == 1) {
                    imageView2.setImageResource(R.raw.f169464fg);
                } else if (i3 == 2) {
                    imageView2.setImageResource(R.raw.f169494g7);
                }
            }
            setView(inflate, -2);
        }
    }

    public void setEditTextDefaultText(CharSequence charSequence) {
        this.f152891l.setVisibility(0);
        this.f152891l.setText(charSequence);
    }

    public void setEditTextHint(CharSequence charSequence) {
        this.f152891l.setVisibility(0);
        this.f152891l.setHint(charSequence);
    }

    public void setIconTitle(String str, CharSequence charSequence, Boolean bool, final Builder.IOnTitleClick iOnTitleClick, Builder.IIconAttach iIconAttach, Builder.ITitleAttach iTitleAttach) {
        LinearLayout linearLayout;
        this.H.setLayoutResource(R.layout.e3u);
        try {
            linearLayout = (LinearLayout) this.H.inflate();
        } catch (Exception unused) {
            this.H.setVisibility(0);
            linearLayout = null;
        }
        if (linearLayout != null && str != null) {
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.f98525nb);
            imageView.setVisibility(0);
            imageView.setImportantForAccessibility(2);
            if (iIconAttach != null) {
                iIconAttach.onIconAttach(imageView, str);
            }
        }
        if (linearLayout != null && charSequence != null) {
            TextView textView = (TextView) linearLayout.findViewById(R.id.f166992jq2);
            textView.setVisibility(0);
            Builder.ITextSmileySpan iTextSmileySpan = this.U;
            if (iTextSmileySpan != null) {
                charSequence = iTextSmileySpan.smileySpan(this.f152880a, charSequence.toString(), this.f152885f.getTextSize());
            }
            textView.setText(charSequence);
            if (iTitleAttach != null) {
                iTitleAttach.onTitleAttach(textView);
            }
        }
        if (bool.booleanValue() && linearLayout != null) {
            final ImageView imageView2 = (ImageView) linearLayout.findViewById(R.id.xiu);
            imageView2.setVisibility(0);
            a(0);
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMAlertDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Builder.IOnTitleClick iOnTitleClick2 = iOnTitleClick;
                    if (iOnTitleClick2 != null) {
                        iOnTitleClick2.onTitleClick(true);
                    }
                    if (imageView2.isSelected()) {
                        MMAlertDialog.this.M.startAnimation(MMAlertDialog.this.T);
                        MMAlertDialog.this.T.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.mm.ui.widget.dialog.MMAlertDialog.1.1
                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationEnd(Animation animation) {
                                MMAlertDialog.this.M.setVisibility(8);
                                MMAlertDialog.this.a(0);
                            }

                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationStart(Animation animation) {
                                MMAlertDialog mMAlertDialog = MMAlertDialog.this;
                                mMAlertDialog.a(mMAlertDialog.Q);
                            }

                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationRepeat(Animation animation) {
                            }
                        });
                        ObjectAnimator.ofFloat(imageView2, BasicAnimation.KeyPath.ROTATION, 180.0f, 0.0f).setDuration(200L).start();
                        imageView2.setSelected(false);
                        return;
                    }
                    MMAlertDialog.this.M.startAnimation(MMAlertDialog.this.R);
                    MMAlertDialog.this.R.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.mm.ui.widget.dialog.MMAlertDialog.1.2
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            MMAlertDialog.this.M.setVisibility(0);
                            MMAlertDialog.this.a(8);
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                            MMAlertDialog mMAlertDialog = MMAlertDialog.this;
                            mMAlertDialog.a(mMAlertDialog.S);
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }
                    });
                    ObjectAnimator.ofFloat(imageView2, BasicAnimation.KeyPath.ROTATION, 0.0f, 180.0f).setDuration(200L).start();
                    imageView2.setSelected(true);
                }
            });
        }
    }

    public void setIconTitleDetail(View view) {
        this.F = view;
        if (view != null) {
            this.I.setVisibility(8);
            this.f152890k.setVisibility(8);
            this.f152891l.setVisibility(8);
            this.M.removeAllViews();
            this.M.addView(this.F, new LinearLayout.LayoutParams(-1, -1));
            this.M.setVisibility(8);
        }
    }

    public void setLeftIconStyle(Bitmap bitmap, CharSequence charSequence, CharSequence charSequence2) {
        View inflate = View.inflate(this.f152880a, R.layout.e3q, null);
        if (bitmap != null) {
            ImageView imageView = (ImageView) inflate.findViewById(R.id.zcb);
            imageView.setVisibility(0);
            imageView.setImageBitmap(bitmap);
        }
        if (charSequence != null) {
            TextView textView = (TextView) inflate.findViewById(R.id.zcd);
            textView.setVisibility(0);
            Builder.ITextSmileySpan iTextSmileySpan = this.U;
            if (iTextSmileySpan != null) {
                charSequence = iTextSmileySpan.smileySpan(this.f152880a, charSequence.toString(), textView.getTextSize());
            }
            textView.setText(charSequence);
        }
        if (charSequence2 != null) {
            TextView textView2 = (TextView) inflate.findViewById(R.id.zcc);
            textView2.setVisibility(0);
            Builder.ITextSmileySpan iTextSmileySpan2 = this.U;
            if (iTextSmileySpan2 != null) {
                charSequence2 = iTextSmileySpan2.smileySpan(this.f152880a, charSequence2.toString(), textView2.getTextSize());
            }
            textView2.setText(charSequence2);
        }
        setView(inflate);
    }

    public void setMessage(CharSequence charSequence) {
        this.I.setVisibility(0);
        this.f152887h.setVisibility(0);
        Builder.ITextSmileySpan iTextSmileySpan = this.U;
        if (iTextSmileySpan != null) {
            charSequence = iTextSmileySpan.smileySpan(this.f152887h.getContext(), charSequence.toString(), this.f152887h.getTextSize());
        }
        this.f152887h.setText(charSequence);
    }

    public void setMsgContentBg(boolean z16) {
        if (z16) {
            int a16 = o.a(this.f152880a, 8);
            this.I.setVisibility(0);
            this.I.setPadding(a16, a16, a16, a16);
        }
    }

    public void setMsgContentBold(boolean z16) {
        this.f152887h.getPaint().setFakeBoldText(z16);
    }

    public void setMsgIcon(Drawable drawable) {
        if (this.E != null) {
            return;
        }
        this.I.setVisibility(0);
        this.C.setVisibility(0);
        this.C.setBackgroundDrawable(drawable);
    }

    public void setMsgIconVisibility(int i3) {
        this.I.setVisibility(i3);
        this.C.setVisibility(i3);
    }

    public void setMsgMaxLine(int i3) {
        this.f152887h.setMaxLines(i3);
    }

    public void setMsgSubDesc(CharSequence charSequence) {
        if (charSequence != null) {
            this.I.setVisibility(0);
            this.f152889j.setVisibility(0);
            Builder.ITextSmileySpan iTextSmileySpan = this.U;
            if (iTextSmileySpan != null) {
                charSequence = iTextSmileySpan.smileySpan(this.f152889j.getContext(), charSequence.toString(), this.f152889j.getTextSize());
            }
            this.f152889j.setText(charSequence);
        }
    }

    public void setMsgSubTitle(CharSequence charSequence) {
        this.I.setVisibility(0);
        this.f152888i.setVisibility(0);
        this.f152888i.setMaxLines(2);
        this.f152888i.setText(charSequence);
    }

    public void setMsgTvGravity(int i3) {
        TextView textView = this.f152887h;
        if (textView != null) {
            textView.setGravity(i3);
        }
    }

    public void setNegativeButton(CharSequence charSequence, final boolean z16, final DialogInterface.OnClickListener onClickListener) {
        Button button = this.f152884e;
        if (button == null) {
            return;
        }
        button.setVisibility(0);
        this.f152884e.setText(charSequence);
        this.f152884e.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMAlertDialog.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogInterface.OnClickListener onClickListener2 = onClickListener;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(MMAlertDialog.this, -2);
                }
                if (z16) {
                    MMAlertDialog.this.cancel();
                }
            }
        });
    }

    public void setNegativeButtonColor(int i3) {
        this.f152884e.setTextColor(i3);
    }

    public void setPositiveButton(CharSequence charSequence, final boolean z16, final DialogInterface.OnClickListener onClickListener) {
        Button button = this.f152883d;
        if (button == null) {
            return;
        }
        button.setVisibility(0);
        this.f152883d.setText(charSequence);
        this.f152883d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMAlertDialog.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogInterface.OnClickListener onClickListener2 = onClickListener;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(MMAlertDialog.this, -1);
                }
                if (z16) {
                    MMAlertDialog.this.dismiss();
                }
            }
        });
    }

    public void setPositiveButtonColor(int i3) {
        this.f152883d.setTextColor(i3);
    }

    public void setRightIconStyle(Bitmap bitmap, CharSequence charSequence, CharSequence charSequence2) {
        View inflate = View.inflate(this.f152880a, R.layout.e3r, null);
        if (bitmap != null) {
            ImageView imageView = (ImageView) inflate.findViewById(R.id.zcb);
            imageView.setVisibility(0);
            imageView.setImageBitmap(bitmap);
        }
        if (charSequence != null) {
            TextView textView = (TextView) inflate.findViewById(R.id.zcd);
            textView.setVisibility(0);
            Builder.ITextSmileySpan iTextSmileySpan = this.U;
            if (iTextSmileySpan != null) {
                charSequence = iTextSmileySpan.smileySpan(this.f152880a, charSequence.toString(), textView.getTextSize());
            }
            textView.setText(charSequence);
        }
        if (charSequence2 != null) {
            TextView textView2 = (TextView) inflate.findViewById(R.id.zcc);
            textView2.setVisibility(0);
            Builder.ITextSmileySpan iTextSmileySpan2 = this.U;
            if (iTextSmileySpan2 != null) {
                charSequence2 = iTextSmileySpan2.smileySpan(this.f152880a, charSequence2.toString(), textView2.getTextSize());
            }
            textView2.setText(charSequence2);
        }
        setView(inflate);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        this.G.setVisibility(0);
        this.f152885f.setVisibility(0);
        Builder.ITextSmileySpan iTextSmileySpan = this.U;
        if (iTextSmileySpan != null) {
            charSequence = iTextSmileySpan.smileySpan(this.f152880a, charSequence.toString(), this.f152885f.getTextSize());
        }
        this.f152885f.setMaxLines(2);
        this.f152885f.setText(charSequence);
        this.f152885f.getPaint().setFakeBoldText(true);
        c(this.f152880a.getResources().getColor(R.color.arc));
    }

    public void setTitleColor(int i3) {
        this.f152885f.setTextColor(ColorStateList.valueOf(i3));
    }

    public void setTitleDesc(CharSequence charSequence) {
        this.G.setVisibility(0);
        this.f152886g.setVisibility(0);
        Builder.ITextSmileySpan iTextSmileySpan = this.U;
        if (iTextSmileySpan != null) {
            charSequence = iTextSmileySpan.smileySpan(this.f152880a, charSequence.toString(), this.f152885f.getTextSize());
        }
        this.f152886g.setText(charSequence);
    }

    public void setTitleGravity(int i3) {
        TextView textView = this.f152885f;
        if (textView != null) {
            textView.setGravity(i3);
        }
    }

    public void setTitleMaxLine(int i3) {
        this.f152885f.setMaxLines(i3);
    }

    public void setView(View view, int i3) {
        this.E = view;
        if (view != null) {
            this.I.setVisibility(0);
            this.L.setVisibility(0);
            this.L.removeAllViews();
            this.L.setGravity(1);
            this.L.addView(this.E, new LinearLayout.LayoutParams(i3, i3));
        }
    }

    public void setiOnDialogDismissListener(IOnDialogDismissListener iOnDialogDismissListener) {
        this.W = iOnDialogDismissListener;
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
        } catch (Exception e16) {
            n.a("MicroMsg.MMAlertDialog", e16, "", new Object[0]);
        }
    }

    private Resources d() {
        return com.tencent.luggage.wxa.no.a.a(this.f152880a);
    }

    public final void b(final AlertParams alertParams) {
        Button button = this.f152884e;
        if (button == null || alertParams == null) {
            return;
        }
        button.setVisibility(0);
        this.f152884e.setText(alertParams.f152862y);
        this.f152884e.post(new Runnable() { // from class: com.tencent.mm.ui.widget.dialog.MMAlertDialog.6
            @Override // java.lang.Runnable
            public void run() {
                Layout layout = MMAlertDialog.this.f152884e.getLayout();
                if (layout != null && layout.getEllipsisCount(0) > 0) {
                    n.c("MicroMsg.MMAlertDialog", "NegativeButton text too long, show updown mode!!", new Object[0]);
                    MMAlertDialog.this.a(alertParams);
                }
            }
        });
        this.f152884e.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMAlertDialog.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogInterface.OnClickListener onClickListener = alertParams.H;
                if (onClickListener != null) {
                    onClickListener.onClick(MMAlertDialog.this, -2);
                }
                MMAlertDialog.this.cancel();
            }
        });
    }

    public final void c(int i3) {
        TextView textView = this.f152887h;
        if (textView != null) {
            textView.setTextColor(i3);
        }
    }

    public final void c(final AlertParams alertParams) {
        Button button = this.f152883d;
        if (button == null || alertParams == null) {
            return;
        }
        button.setVisibility(0);
        this.f152883d.setText(alertParams.f152861x);
        this.f152883d.post(new Runnable() { // from class: com.tencent.mm.ui.widget.dialog.MMAlertDialog.4
            @Override // java.lang.Runnable
            public void run() {
                Layout layout = MMAlertDialog.this.f152883d.getLayout();
                if (layout != null && layout.getEllipsisCount(0) > 0) {
                    n.c("MicroMsg.MMAlertDialog", "PositiveButton text too long, show updown mode!!", new Object[0]);
                    MMAlertDialog.this.a(alertParams);
                }
            }
        });
        this.f152883d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMAlertDialog.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogInterface.OnClickListener onClickListener = alertParams.G;
                if (onClickListener != null) {
                    onClickListener.onClick(MMAlertDialog.this, -1);
                }
                if (alertParams.f152836c0) {
                    MMAlertDialog.this.dismiss();
                }
            }
        });
    }

    public final void a(Builder.ITextSmileySpan iTextSmileySpan) {
        this.U = iTextSmileySpan;
    }

    public void setMsgIcon(int i3) {
        if (this.E != null) {
            return;
        }
        this.I.setVisibility(0);
        this.C.setVisibility(0);
        this.C.setBackgroundResource(i3);
    }

    public void setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        setNegativeButton(charSequence, true, onClickListener);
    }

    public void setPositiveButton(int i3, DialogInterface.OnClickListener onClickListener) {
        setPositiveButton(d().getString(i3), true, onClickListener);
    }

    public MMAlertDialog(Context context, int i3) {
        super(context, R.style.ayj);
        this.O = false;
        this.P = false;
        this.f152880a = context;
        a(context);
    }

    public final void a(Context context) {
        LinearLayout linearLayout = (LinearLayout) View.inflate(this.f152880a, R.layout.fjt, null);
        this.f152881b = linearLayout;
        this.f152882c = (LinearLayout) linearLayout.findViewById(R.id.slf);
        this.f152883d = (Button) this.f152881b.findViewById(R.id.zce);
        this.f152884e = (Button) this.f152881b.findViewById(R.id.zc7);
        this.f152885f = (TextView) this.f152881b.findViewById(R.id.zcf);
        this.f152886g = (TextView) this.f152881b.findViewById(R.id.zch);
        this.f152887h = (TextView) this.f152881b.findViewById(R.id.zc_);
        this.f152888i = (TextView) this.f152881b.findViewById(R.id.zcd);
        this.f152889j = (TextView) this.f152881b.findViewById(R.id.zcc);
        this.f152890k = (TextView) this.f152881b.findViewById(R.id.u4c);
        this.f152891l = (EditText) this.f152881b.findViewById(R.id.u4d);
        this.f152892m = (CheckBox) this.f152881b.findViewById(R.id.u4b);
        this.C = (ImageView) this.f152881b.findViewById(R.id.zcb);
        this.D = (ImageView) this.f152881b.findViewById(R.id.bmt);
        this.G = (LinearLayout) this.f152881b.findViewById(R.id.zcg);
        this.H = (ViewStub) this.f152881b.findViewById(R.id.f98645nn);
        this.I = (LinearLayout) this.f152881b.findViewById(R.id.zca);
        this.K = (ViewGroup) this.f152881b.findViewById(R.id.f166297zc2);
        this.N = this.f152881b.findViewById(R.id.zc6);
        this.L = (LinearLayout) this.f152881b.findViewById(R.id.zc9);
        this.M = (ViewGroup) this.f152881b.findViewById(R.id.f98635nm);
        setCanceledOnTouchOutside(true);
        this.Q = AnimationUtils.loadAnimation(this.f152880a, R.anim.f154470lm);
        this.R = AnimationUtils.loadAnimation(this.f152880a, R.anim.f154470lm);
        this.S = AnimationUtils.loadAnimation(this.f152880a, R.anim.f154471ln);
        this.T = AnimationUtils.loadAnimation(this.f152880a, R.anim.f154471ln);
    }

    public void setMessage(int i3) {
        this.I.setVisibility(0);
        this.f152887h.setVisibility(0);
        this.f152887h.setText(i3);
    }

    public void setNegativeButton(int i3, DialogInterface.OnClickListener onClickListener) {
        setNegativeButton(d().getString(i3), onClickListener);
    }

    public void setView(View view) {
        setView(view, -1);
    }

    public void setMsgIcon(Bitmap bitmap) {
        if (this.E != null) {
            return;
        }
        this.I.setVisibility(0);
        this.C.setVisibility(0);
        this.C.setImageBitmap(bitmap);
    }

    @Override // android.app.Dialog
    public void setTitle(int i3) {
        this.G.setVisibility(0);
        this.f152885f.setVisibility(0);
        this.f152885f.setMaxLines(2);
        this.f152885f.setText(i3);
        this.f152885f.getPaint().setFakeBoldText(true);
        c(this.f152880a.getResources().getColor(R.color.arc));
    }

    public void setMsgIcon(String str) {
        o.a(this.f152880a, 120);
        this.I.setVisibility(0);
        this.C.setVisibility(0);
    }

    public final Bitmap a(Bitmap bitmap, ImageView imageView, int i3, int i16) {
        int i17;
        int i18;
        float f16 = i16 / i3;
        int c16 = o.c(this.f152880a, R.dimen.bfr);
        int c17 = o.c(this.f152880a, R.dimen.bfq);
        if (f16 <= 0.0f || f16 >= 0.5d) {
            if (f16 >= 0.5d && f16 < 1.0f) {
                c16 = (int) (c17 * f16);
                i18 = c16;
            } else if (f16 >= 1.0f && f16 < 2.0f) {
                i17 = (int) (c17 / f16);
                i18 = c17;
                c16 = i18;
                c17 = i17;
            } else if (f16 >= 2.0f) {
                i18 = c17;
                c17 = c16;
                c16 = (int) (c16 * f16);
            } else {
                c16 = 0;
                i17 = 0;
                c17 = 0;
                i18 = 0;
            }
            i17 = c17;
        } else {
            i17 = (int) (c16 / f16);
            i18 = c16;
        }
        if (c16 <= 0 || i17 <= 0 || bitmap == null) {
            return null;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i17, c16, true);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(c17, i18));
        return createScaledBitmap;
    }

    public final void a(int i3) {
        LinearLayout linearLayout = this.I;
        if (linearLayout != null) {
            linearLayout.setVisibility(i3);
        }
        LinearLayout linearLayout2 = this.L;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(i3);
        }
        TextView textView = this.f152890k;
        if (textView != null && this.O) {
            textView.setVisibility(i3);
        }
        EditText editText = this.f152891l;
        if (editText != null) {
            if (!this.P) {
                editText.setVisibility(8);
            } else {
                editText.setVisibility(i3);
            }
        }
    }

    public final void a(Animation animation) {
        LinearLayout linearLayout = this.I;
        if (linearLayout != null) {
            linearLayout.startAnimation(animation);
        }
        LinearLayout linearLayout2 = this.L;
        if (linearLayout2 != null) {
            linearLayout2.startAnimation(animation);
        }
        TextView textView = this.f152890k;
        if (textView != null && this.O) {
            textView.startAnimation(animation);
        }
        EditText editText = this.f152891l;
        if (editText != null) {
            if (!this.P) {
                editText.setVisibility(8);
            } else {
                editText.startAnimation(animation);
            }
        }
    }

    public final void a(final AlertParams alertParams) {
        View inflate = View.inflate(this.f152880a, R.layout.e3o, null);
        this.f152884e = (Button) inflate.findViewById(R.id.zc7);
        Button button = (Button) inflate.findViewById(R.id.zce);
        this.f152883d = button;
        button.setVisibility(0);
        this.f152883d.setText(alertParams.f152861x);
        int i3 = alertParams.Y;
        if (i3 != 0) {
            this.f152883d.setTextColor(i3);
        }
        this.f152883d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMAlertDialog.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogInterface.OnClickListener onClickListener = alertParams.G;
                if (onClickListener != null) {
                    onClickListener.onClick(MMAlertDialog.this, -1);
                }
                if (alertParams.f152836c0) {
                    MMAlertDialog.this.dismiss();
                }
            }
        });
        this.f152884e.setVisibility(0);
        this.f152884e.setText(alertParams.f152862y);
        int i16 = alertParams.X;
        if (i16 != 0) {
            this.f152884e.setTextColor(i16);
        }
        this.f152884e.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMAlertDialog.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogInterface.OnClickListener onClickListener = alertParams.H;
                if (onClickListener != null) {
                    onClickListener.onClick(MMAlertDialog.this, -2);
                }
                MMAlertDialog.this.cancel();
            }
        });
        a(inflate, new LinearLayout.LayoutParams(-1, -1));
    }

    public final void a(DialogInterface.OnDismissListener onDismissListener) {
        this.V = onDismissListener;
    }

    public final void a(View view, ViewGroup.LayoutParams layoutParams) {
        this.N.setVisibility(8);
        this.K.removeAllViews();
        this.K.addView(view, layoutParams);
    }
}
