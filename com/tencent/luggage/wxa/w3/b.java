package com.tencent.luggage.wxa.w3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends Preference {
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
    public int f144067a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f144068b;

    /* renamed from: c, reason: collision with root package name */
    public RelativeLayout.LayoutParams f144069c;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f144070d;

    /* renamed from: e, reason: collision with root package name */
    public String f144071e;

    /* renamed from: f, reason: collision with root package name */
    public int f144072f;

    /* renamed from: g, reason: collision with root package name */
    public int f144073g;

    /* renamed from: h, reason: collision with root package name */
    public int f144074h;

    /* renamed from: i, reason: collision with root package name */
    public int f144075i;

    /* renamed from: j, reason: collision with root package name */
    public String f144076j;

    /* renamed from: k, reason: collision with root package name */
    public String f144077k;

    /* renamed from: l, reason: collision with root package name */
    public int f144078l;

    /* renamed from: m, reason: collision with root package name */
    public int f144079m;

    public b(Context context) {
        this(context, null);
    }

    public void a(Bitmap bitmap) {
        this.D = bitmap;
        this.f144067a = -1;
        ImageView imageView = this.f144068b;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    public void b(int i3) {
        this.E = i3;
        ImageView imageView = this.f144068b;
        if (imageView != null) {
            imageView.setVisibility(i3);
        }
    }

    public void c(int i3) {
        this.F = i3;
        ViewGroup viewGroup = this.K;
        if (viewGroup != null) {
            viewGroup.setVisibility(i3);
        }
    }

    @Override // android.preference.Preference
    public void onBindView(View view) {
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.f165764de0);
        this.S = imageView;
        if (imageView != null) {
            Drawable drawable = this.f144070d;
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
                this.S.setVisibility(0);
            } else if (getIcon() != null) {
                ImageView imageView2 = this.S;
                Drawable icon = getIcon();
                this.f144070d = icon;
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
            this.R.setVisibility(this.f144073g);
            this.R.setText(this.f144071e);
            if (this.f144072f != -1) {
                this.R.setBackgroundDrawable(this.U.getResources().getDrawable(this.f144072f));
            }
        }
        TextView textView2 = (TextView) view.findViewById(R.id.f95805fz);
        this.Q = textView2;
        if (textView2 != null) {
            textView2.setVisibility(this.f144079m);
            this.Q.setText(this.f144077k);
            if (this.f144078l != -1) {
                this.Q.setBackgroundDrawable(this.U.getResources().getDrawable(this.f144078l));
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
        imageView3.setVisibility(this.f144074h);
        int i17 = this.X;
        if (i17 != -1) {
            this.J.setImageResource(i17);
        }
        this.f144068b = (ImageView) view.findViewById(R.id.xir);
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
            this.f144068b.setImageBitmap(bitmap);
        } else {
            int i18 = this.f144067a;
            if (i18 != -1) {
                this.f144068b.setImageResource(i18);
            }
        }
        this.f144068b.setVisibility(this.E);
        this.K.setVisibility(this.F);
        RelativeLayout.LayoutParams layoutParams = this.f144069c;
        if (layoutParams != null) {
            this.f144068b.setLayoutParams(layoutParams);
        }
        this.O = (TextView) view.findViewById(android.R.id.title);
        TextView textView3 = (TextView) view.findViewById(R.id.bg6);
        this.P = textView3;
        if (textView3 != null) {
            textView3.setVisibility(this.f144075i);
            this.P.setText(this.f144076j);
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
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.content);
        viewGroup2.removeAllViews();
        View.inflate(getContext(), R.layout.fdh, viewGroup2);
        return onCreateView;
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f144067a = -1;
        this.f144068b = null;
        this.f144071e = "";
        this.f144072f = -1;
        this.f144073g = 8;
        this.f144074h = 8;
        this.f144075i = 8;
        this.f144076j = "";
        this.f144077k = "";
        this.f144078l = -1;
        this.f144079m = 8;
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
        setLayoutResource(R.layout.fdg);
    }

    public void a(int i3) {
        this.f144067a = i3;
        this.D = null;
        ImageView imageView = this.f144068b;
        if (imageView != null) {
            imageView.setImageResource(i3);
        }
    }

    public void a(int i3, int i16) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i16);
        this.f144069c = layoutParams;
        layoutParams.addRule(13);
        ImageView imageView = this.f144068b;
        if (imageView == null) {
            return;
        }
        imageView.setLayoutParams(this.f144069c);
    }

    public ImageView a() {
        return this.f144068b;
    }
}
