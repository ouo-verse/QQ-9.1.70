package com.tencent.weui.base.preference;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.preference.Preference;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes27.dex */
public class IconPreference extends Preference {
    static IPatchRedirector $redirector_;
    public int C;
    public Bitmap D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public ImageView J;
    public ViewGroup K;
    public View L;
    public View M;
    public ImageView N;
    public TextView O;
    public TextView P;
    public TextView Q;
    public TextView R;
    public ImageView S;
    public int T;
    public Context U;
    public boolean V;
    public boolean W;
    public int X;
    public boolean Y;

    /* renamed from: a, reason: collision with root package name */
    public int f384472a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f384473b;

    /* renamed from: c, reason: collision with root package name */
    public RelativeLayout.LayoutParams f384474c;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f384475d;

    /* renamed from: e, reason: collision with root package name */
    public String f384476e;

    /* renamed from: f, reason: collision with root package name */
    public int f384477f;

    /* renamed from: g, reason: collision with root package name */
    public int f384478g;

    /* renamed from: h, reason: collision with root package name */
    public int f384479h;

    /* renamed from: i, reason: collision with root package name */
    public int f384480i;

    /* renamed from: j, reason: collision with root package name */
    public String f384481j;

    /* renamed from: k, reason: collision with root package name */
    public String f384482k;

    /* renamed from: l, reason: collision with root package name */
    public int f384483l;

    /* renamed from: m, reason: collision with root package name */
    public int f384484m;

    public IconPreference(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public ImageView getRightIV() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (ImageView) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return this.f384473b;
    }

    @Override // android.preference.Preference
    public void onBindView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) view);
            return;
        }
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.f165764de0);
        this.S = imageView;
        if (imageView != null) {
            Drawable drawable = this.f384475d;
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
                this.S.setVisibility(0);
            } else if (getIcon() != null) {
                ImageView imageView2 = this.S;
                Drawable icon = getIcon();
                this.f384475d = icon;
                imageView2.setImageDrawable(icon);
                this.S.setVisibility(0);
            } else {
                this.S.setVisibility(8);
            }
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.zcl);
        linearLayout.setMinimumHeight(view.getResources().getDimensionPixelSize(R.dimen.bp7));
        int i3 = this.T;
        if (i3 != -1) {
            linearLayout.setMinimumHeight(i3);
        }
        TextView textView = (TextView) view.findViewById(R.id.f95795fy);
        this.R = textView;
        if (textView != null) {
            if (this.W) {
                textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.m0h, 0, 0, 0);
                this.R.setCompoundDrawablePadding((int) this.U.getResources().getDimension(R.dimen.bp8));
            } else {
                textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            this.R.setVisibility(this.f384478g);
            this.R.setText(this.f384476e);
            if (this.f384477f != -1) {
                this.R.setBackgroundDrawable(this.U.getResources().getDrawable(this.f384477f));
            }
        }
        TextView textView2 = (TextView) view.findViewById(R.id.f95805fz);
        this.Q = textView2;
        if (textView2 != null) {
            textView2.setVisibility(this.f384484m);
            this.Q.setText(this.f384482k);
            if (this.f384483l != -1) {
                this.Q.setBackgroundDrawable(this.U.getResources().getDrawable(this.f384483l));
            }
            int i16 = this.C;
            if (i16 != -1) {
                this.Q.setTextColor(i16);
            }
            if (this.V) {
                this.Q.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.m0h, 0);
                this.Q.setCompoundDrawablePadding((int) this.U.getResources().getDimension(R.dimen.bp8));
            } else {
                this.Q.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }
        ImageView imageView3 = (ImageView) view.findViewById(R.id.f95625fh);
        this.J = imageView3;
        imageView3.setVisibility(this.f384479h);
        int i17 = this.X;
        if (i17 != -1) {
            this.J.setImageResource(i17);
        }
        this.f384473b = (ImageView) view.findViewById(R.id.xir);
        this.K = (ViewGroup) view.findViewById(R.id.f74823xa);
        View findViewById = view.findViewById(R.id.f74593wo);
        this.M = findViewById;
        findViewById.setVisibility(this.H);
        View findViewById2 = view.findViewById(R.id.f74813x_);
        this.L = findViewById2;
        findViewById2.setVisibility(this.G);
        ImageView imageView4 = (ImageView) view.findViewById(R.id.i_m);
        this.N = imageView4;
        imageView4.setVisibility(this.I);
        Bitmap bitmap = this.D;
        if (bitmap != null) {
            this.f384473b.setImageBitmap(bitmap);
        } else {
            int i18 = this.f384472a;
            if (i18 != -1) {
                this.f384473b.setImageResource(i18);
            }
        }
        this.f384473b.setVisibility(this.E);
        this.K.setVisibility(this.F);
        RelativeLayout.LayoutParams layoutParams = this.f384474c;
        if (layoutParams != null) {
            this.f384473b.setLayoutParams(layoutParams);
        }
        this.O = (TextView) view.findViewById(android.R.id.title);
        TextView textView3 = (TextView) view.findViewById(R.id.bg6);
        this.P = textView3;
        if (textView3 != null) {
            textView3.setVisibility(this.f384480i);
            this.P.setText(this.f384481j);
            if (this.Y) {
                this.P.setTextColor(this.U.getResources().getColor(R.color.f157047bi4));
            } else {
                this.P.setTextColor(this.U.getResources().getColor(R.color.bv6));
            }
        }
        TextView textView4 = this.O;
        if (textView4 != null) {
            if (this.Y) {
                textView4.setTextColor(this.U.getResources().getColor(R.color.f157047bi4));
            } else {
                textView4.setTextColor(this.U.getResources().getColor(R.color.c7u));
            }
        }
        view.setEnabled(!this.Y);
    }

    @Override // android.preference.Preference
    public View onCreateView(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewGroup);
        }
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.content);
        viewGroup2.removeAllViews();
        View.inflate(getContext(), R.layout.frl, viewGroup2);
        return onCreateView;
    }

    public void resetTitleTvLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        TextView textView = this.O;
        if (textView != null) {
            textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        }
    }

    public void setDesc(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        this.f384481j = str;
        TextView textView = this.P;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setDescVisibility(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
            return;
        }
        this.f384480i = i3;
        TextView textView = this.P;
        if (textView != null) {
            textView.setVisibility(i3);
        }
    }

    public void setHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3);
        } else {
            this.T = i3;
        }
    }

    public void setIconDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) drawable);
        } else {
            this.f384475d = drawable;
        }
    }

    public void setIsTv1OnlyRedDot(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else {
            this.W = z16;
        }
    }

    public void setItemDisable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, z16);
        } else {
            this.Y = z16;
        }
    }

    public void setRightArrow(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
            return;
        }
        this.I = i3;
        ImageView imageView = this.N;
        if (imageView != null) {
            imageView.setVisibility(i3);
        }
    }

    public void setRightCenterProspectVisibility(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
            return;
        }
        this.H = i3;
        View view = this.M;
        if (view != null) {
            view.setVisibility(i3);
        }
    }

    public void setRightImage(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) bitmap);
            return;
        }
        this.D = bitmap;
        this.f384472a = -1;
        ImageView imageView = this.f384473b;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    public void setRightImageSrc(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
            return;
        }
        this.f384472a = i3;
        this.D = null;
        ImageView imageView = this.f384473b;
        if (imageView != null) {
            imageView.setImageResource(i3);
        }
    }

    public void setRightIvVivibility(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
            return;
        }
        this.E = i3;
        ImageView imageView = this.f384473b;
        if (imageView != null) {
            imageView.setVisibility(i3);
        }
    }

    public void setRightProspectVisibility(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
            return;
        }
        this.G = i3;
        View view = this.L;
        if (view != null) {
            view.setVisibility(i3);
        }
    }

    public void setRightRLVisibility(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
            return;
        }
        this.F = i3;
        ViewGroup viewGroup = this.K;
        if (viewGroup != null) {
            viewGroup.setVisibility(i3);
        }
    }

    public void setRightSize(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i16);
        this.f384474c = layoutParams;
        layoutParams.addRule(13);
        ImageView imageView = this.f384473b;
        if (imageView == null) {
            return;
        }
        imageView.setLayoutParams(this.f384474c);
    }

    public void setText1Vivibility(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        this.f384478g = i3;
        TextView textView = this.R;
        if (textView != null) {
            textView.setVisibility(i3);
        }
    }

    public void setText2Vivibility(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        this.f384484m = i3;
        TextView textView = this.Q;
        if (textView != null) {
            textView.setVisibility(i3);
        }
    }

    public void setTextDotVisibility(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
            return;
        }
        this.f384479h = i3;
        ImageView imageView = this.J;
        if (imageView != null) {
            imageView.setVisibility(i3);
        }
    }

    public void setTextIv(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.f384479h = i3;
            this.X = i16;
        }
    }

    public void setTextView1(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, i3);
        } else {
            this.f384476e = str;
            this.f384477f = i3;
        }
    }

    public void setTextView2(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            setTextView2(str, i3, this.C);
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, i3);
        }
    }

    public void setTextView2WithRedDot(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
            return;
        }
        this.V = z16;
        TextView textView = this.Q;
        if (textView != null) {
            if (z16) {
                textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.m0h, 0);
                this.Q.setCompoundDrawablePadding((int) this.U.getResources().getDimension(R.dimen.bp8));
            } else {
                textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }
    }

    public void setTitleTvMaxWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, i3);
            return;
        }
        TextView textView = this.O;
        if (textView != null) {
            textView.setMaxWidth(i3);
            this.O.setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    public IconPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public void setTextView2(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f384482k = str;
        this.f384483l = i3;
        this.C = i16;
        TextView textView = this.Q;
        if (textView != null) {
            textView.setText(str);
            if (i3 != -1) {
                this.Q.setBackgroundDrawable(this.U.getResources().getDrawable(i3));
            }
            if (i16 != -1) {
                this.Q.setTextColor(i16);
            }
        }
    }

    public IconPreference(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f384472a = -1;
        this.f384473b = null;
        this.f384476e = "";
        this.f384477f = -1;
        this.f384478g = 8;
        this.f384479h = 8;
        this.f384480i = 8;
        this.f384481j = "";
        this.f384482k = "";
        this.f384483l = -1;
        this.f384484m = 8;
        this.C = -1;
        this.D = null;
        this.E = 8;
        this.F = 8;
        this.G = 8;
        this.H = 8;
        this.I = 0;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.T = -1;
        this.V = false;
        this.W = false;
        this.X = -1;
        this.Y = false;
        this.U = context;
        setLayoutResource(R.layout.fkb);
    }
}
