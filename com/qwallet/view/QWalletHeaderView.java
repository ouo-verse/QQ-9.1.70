package com.qwallet.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.qwallet.utils.QWalletUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qwallet.widget.NumAnim;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QWalletHeaderView extends BaseNestHeaderLayout {
    public TextView C;
    public TextView D;
    public TextView E;
    public NumAnim F;
    public ImageView G;
    public ImageView H;
    public RelativeLayout I;
    public ImageView J;
    public RelativeLayout K;
    public View L;
    public ImageView M;
    public TextView N;
    public ImageView P;
    public ImageView Q;
    public RelativeLayout R;
    public View S;
    public ImageView T;
    public TextView U;
    public ImageView V;
    public ImageView W;

    /* renamed from: a0, reason: collision with root package name */
    public RelativeLayout f41798a0;

    /* renamed from: b0, reason: collision with root package name */
    public LinearLayout f41799b0;

    /* renamed from: c0, reason: collision with root package name */
    public LinearLayout f41800c0;

    /* renamed from: d0, reason: collision with root package name */
    public Button f41801d0;

    /* renamed from: e, reason: collision with root package name */
    public TouchWebView f41802e;

    /* renamed from: e0, reason: collision with root package name */
    public QWalletHeaderViewRootLayout f41803e0;

    /* renamed from: f, reason: collision with root package name */
    public RelativeLayout f41804f;

    /* renamed from: f0, reason: collision with root package name */
    public ImageView f41805f0;

    /* renamed from: g0, reason: collision with root package name */
    public TextView f41806g0;

    /* renamed from: h, reason: collision with root package name */
    public ImageView f41807h;

    /* renamed from: i, reason: collision with root package name */
    public LinearLayout f41808i;

    /* renamed from: m, reason: collision with root package name */
    public RelativeLayout f41809m;

    public QWalletHeaderView(@NonNull Context context) {
        super(context);
        c();
    }

    private void c() {
        QWalletHeaderViewRootLayout qWalletHeaderViewRootLayout = (QWalletHeaderViewRootLayout) this.f41789d.findViewById(R.id.root);
        this.f41803e0 = qWalletHeaderViewRootLayout;
        qWalletHeaderViewRootLayout.f41810d = this;
        this.f41804f = (RelativeLayout) this.f41789d.findViewById(R.id.f66893bv);
        ImageView imageView = (ImageView) this.f41789d.findViewById(R.id.f166669h64);
        this.f41807h = imageView;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (layoutParams != null && displayMetrics != null) {
            layoutParams.width = (displayMetrics.widthPixels - ViewUtils.dip2px(16.0f)) - ViewUtils.dip2px(16.0f);
        }
        this.f41808i = (LinearLayout) this.f41789d.findViewById(R.id.h6n);
        this.f41809m = (RelativeLayout) this.f41789d.findViewById(R.id.h6l);
        this.C = (TextView) this.f41789d.findViewById(R.id.h6j);
        this.D = (TextView) this.f41789d.findViewById(R.id.f66853br);
        this.E = (TextView) this.f41789d.findViewById(R.id.f166668h62);
        this.H = (ImageView) this.f41789d.findViewById(R.id.h5z);
        Typeface c16 = QWalletUtils.c(getContext());
        if (c16 != null) {
            this.C.setTypeface(c16);
            this.D.setTypeface(c16);
        }
        this.F = new NumAnim(this.C, this.D);
        this.G = (ImageView) this.f41789d.findViewById(R.id.f166667h61);
        this.I = (RelativeLayout) this.f41789d.findViewById(R.id.h6s);
        this.J = (ImageView) this.f41789d.findViewById(R.id.h6z);
        this.K = (RelativeLayout) this.f41789d.findViewById(R.id.h6o);
        this.L = this.f41789d.findViewById(R.id.f66863bs);
        this.M = (ImageView) this.f41789d.findViewById(R.id.h66);
        this.N = (TextView) this.f41789d.findViewById(R.id.h67);
        this.P = (ImageView) this.f41789d.findViewById(R.id.h69);
        this.Q = (ImageView) this.f41789d.findViewById(R.id.h68);
        this.R = (RelativeLayout) this.f41789d.findViewById(R.id.h6q);
        this.S = this.f41789d.findViewById(R.id.f66873bt);
        this.T = (ImageView) this.f41789d.findViewById(R.id.h6_);
        this.U = (TextView) this.f41789d.findViewById(R.id.h6a);
        this.V = (ImageView) this.f41789d.findViewById(R.id.h6c);
        this.W = (ImageView) this.f41789d.findViewById(R.id.h6b);
        this.f41798a0 = (RelativeLayout) this.f41789d.findViewById(R.id.h5g);
        this.f41799b0 = (LinearLayout) this.f41789d.findViewById(R.id.h5d);
        this.f41800c0 = (LinearLayout) this.f41789d.findViewById(R.id.f66793bl);
        this.f41801d0 = (Button) this.f41789d.findViewById(R.id.vqz);
        this.f41805f0 = (ImageView) this.f41789d.findViewById(R.id.h6k);
        this.f41806g0 = (TextView) this.f41789d.findViewById(R.id.h6y);
        this.I.post(new Runnable() { // from class: com.qwallet.view.QWalletHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                ((RelativeLayout.LayoutParams) QWalletHeaderView.this.f41805f0.getLayoutParams()).leftMargin = (QWalletHeaderView.this.I.getWidth() - x.c(QWalletHeaderView.this.getContext(), 40.0f)) / 2;
            }
        });
    }

    @Override // com.qwallet.view.BaseLayout
    protected int a() {
        return R.layout.bdv;
    }

    @Override // com.qwallet.view.a
    public boolean isPined() {
        return false;
    }

    @Override // com.qwallet.view.BaseNestHeaderLayout, com.qwallet.view.a
    public void onScrollTo(int i3, int i16, int i17, int i18) {
        super.onScrollTo(i3, i16, i17, i18);
    }

    public QWalletHeaderView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }
}
