package com.tencent.av.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.ui.QavListItemBase;
import com.tencent.av.ui.effect.view.EffectMaterialImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.CircleProgress;

/* loaded from: classes3.dex */
public class QavPtvTemplateItemView extends QavListItemBase {
    CircleProgress C;
    ImageView D;
    RelativeLayout E;
    public boolean F;

    /* renamed from: i, reason: collision with root package name */
    TextView f75112i;

    /* renamed from: m, reason: collision with root package name */
    EffectMaterialImageView f75113m;

    public QavPtvTemplateItemView(Context context) {
        super(context);
        this.F = false;
        this.f75021e = context;
    }

    @Override // com.tencent.av.ui.QavListItemBase
    public void b(int i3, boolean z16, boolean z17, QavListItemBase.c cVar, QavListItemBase.a aVar) {
        String str;
        int i16;
        if (cVar == null) {
            return;
        }
        super.a(i3, aVar);
        setId(i3);
        setTag(cVar);
        this.f75113m.setTag(cVar);
        if (TextUtils.isEmpty(cVar.f75024a)) {
            if (this.E.getVisibility() != 4) {
                this.E.setVisibility(4);
                return;
            }
            return;
        }
        if (this.E.getVisibility() != 0) {
            this.E.setVisibility(0);
        }
        if ("0".equals(cVar.f75024a)) {
            if (!TextUtils.isEmpty(cVar.f75025b)) {
                i16 = Integer.valueOf(cVar.f75025b).intValue();
            } else {
                i16 = 0;
            }
            if (i16 > 0) {
                this.f75113m.setImageResource(i16);
            } else {
                this.f75113m.setImageResource(R.drawable.trans);
            }
        } else if (!TextUtils.isEmpty(cVar.f75025b)) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.a47);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(getResources().getColor(R.color.f157377nt));
            gradientDrawable.setShape(1);
            gradientDrawable.setSize(dimensionPixelSize, dimensionPixelSize);
            obtain.mRequestWidth = dimensionPixelSize;
            obtain.mRequestHeight = dimensionPixelSize;
            obtain.mFailedDrawable = gradientDrawable;
            obtain.mLoadingDrawable = gradientDrawable;
            URLDrawable drawable = URLDrawable.getDrawable(cVar.f75025b, obtain);
            drawable.setTag(com.tencent.mobileqq.urldrawable.a.d(dimensionPixelSize, dimensionPixelSize));
            if (z17) {
                drawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306322b);
            }
            this.f75113m.setImageDrawable(drawable);
        }
        int i17 = cVar.f75029f;
        if (i17 != 4 && i17 != 5) {
            this.f75113m.setCircle(false);
        } else {
            this.f75113m.setCircle(true);
        }
        if (!cVar.f75027d && !cVar.f75024a.equals("0")) {
            this.D.setVisibility(0);
        } else {
            this.D.setVisibility(8);
        }
        this.C.setVisibility(8);
        setDimmed(cVar.f75031h);
        setHighlight(z16);
        if (cVar.f75036m) {
            this.f75112i.setVisibility(0);
            TextView textView = this.f75112i;
            if (TextUtils.isEmpty(cVar.f75026c)) {
                str = " ";
            } else {
                str = cVar.f75026c;
            }
            textView.setText(str);
            return;
        }
        this.f75112i.setVisibility(8);
    }

    @Override // com.tencent.av.ui.QavListItemBase
    public void c(QavListItemBase.c cVar, int i3) {
        int i16 = i3 % 2;
        if (i16 == 0) {
            this.E.setBackgroundColor(Color.argb(255, 224, 176, 216));
        } else {
            this.E.setBackgroundColor(Color.argb(155, 224, 176, 216));
        }
        if (!this.F) {
            this.f75113m.setBackgroundColor(Color.argb(255, 168, 168, 236));
        } else {
            this.f75113m.setBackgroundColor(getResources().getColor(R.color.f157549sr));
        }
        if (cVar != null && "0".equals(cVar.f75024a)) {
            setBackgroundColor(-16711681);
        } else if (i16 == 0) {
            setBackgroundColor(-7829368);
        } else {
            setBackgroundColor(-3355444);
        }
    }

    @Override // com.tencent.av.ui.QavListItemBase
    public int d() {
        return this.f75020d;
    }

    @Override // com.tencent.av.ui.QavListItemBase
    public void e(int i3, int i16) {
        int color;
        int i17;
        ((LayoutInflater) this.f75021e.getSystemService("layout_inflater")).inflate(R.layout.f168517z9, this);
        int color2 = getResources().getColor(R.color.skin_black);
        if (!this.F) {
            color = getResources().getColor(R.color.f156818c9);
            i17 = R.drawable.f7u;
        } else {
            color = getResources().getColor(R.color.f157549sr);
            i17 = R.drawable.f7v;
        }
        this.E = (RelativeLayout) findViewById(R.id.f166585gb2);
        this.f75113m = (EffectMaterialImageView) findViewById(R.id.f166567g81);
        this.D = (ImageView) findViewById(R.id.g7x);
        this.C = (CircleProgress) findViewById(R.id.f166568g83);
        this.f75112i = (TextView) findViewById(R.id.hid);
        this.D.setImageResource(i17);
        g(i3, i16);
        this.C.setStrokeWidth(1.6f);
        this.C.setBgAndProgressColor(30, color2, 100, color);
        this.f75113m.setOnClickListener(this);
        if (this.F) {
            if (this.E.getParent() instanceof LinearLayout) {
                ((LinearLayout) this.E.getParent()).setGravity(83);
            }
            this.f75113m.setDimmedColor(-47980);
        }
    }

    @Override // com.tencent.av.ui.QavListItemBase
    public void f(int i3) {
        if (i3 >= 100) {
            if (this.C.getVisibility() != 8) {
                this.C.setVisibility(8);
            }
            this.D.setVisibility(8);
        } else if (i3 < 0) {
            if (this.C.getVisibility() != 8) {
                this.C.setVisibility(8);
            }
            this.D.setVisibility(0);
        } else {
            if (this.C.getVisibility() != 0) {
                this.C.setVisibility(0);
            }
            this.C.setProgress(i3);
            this.D.setVisibility(8);
        }
    }

    @Override // com.tencent.av.ui.QavListItemBase
    public void g(int i3, int i16) {
        View findViewById = findViewById(R.id.f166586gb3);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i16;
        findViewById.setLayoutParams(layoutParams);
    }

    public void setDimmed(boolean z16) {
        this.f75113m.setDimmed(z16);
    }

    @Override // com.tencent.av.ui.QavListItemBase
    public void setHighlight(boolean z16) {
        this.f75113m.setHighlight(z16);
    }
}
