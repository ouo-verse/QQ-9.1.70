package com.tencent.gdtad.basics.flip;

import android.content.Context;
import com.tencent.gdtad.basics.adshake.animatorview.animator.Animator;
import com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer;
import com.tencent.gdtad.basics.adshake.animatorview.layer.BitmapLayer;
import com.tencent.gdtad.basics.adshake.animatorview.layer.GroupLayer;
import com.tencent.gdtad.basics.adshake.util.ShakeUtils;
import lm0.a;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a extends GroupLayer {
    private Context C;
    private int D;

    /* renamed from: d, reason: collision with root package name */
    private final float f108776d;

    /* renamed from: e, reason: collision with root package name */
    private final float f108777e;

    /* renamed from: f, reason: collision with root package name */
    private BitmapLayer f108778f;

    /* renamed from: h, reason: collision with root package name */
    private GradientLayer f108779h;

    /* renamed from: i, reason: collision with root package name */
    private GradientLayer f108780i;

    /* renamed from: m, reason: collision with root package name */
    private a.C10732a f108781m;

    public a() {
        super(new AnimatorLayer[0]);
        this.f108776d = 0.7f;
        this.f108777e = 0.41f;
        this.D = 0;
    }

    private GradientLayer a(int i3) {
        GradientLayer gradientLayer = new GradientLayer();
        gradientLayer.setCenterX(getCenterX());
        gradientLayer.setCenterY(getCenterY());
        gradientLayer.setWidth((int) (getWidth() * 0.41f));
        gradientLayer.setHeight((int) (getHeight() * 0.7f));
        gradientLayer.a(i3);
        return gradientLayer;
    }

    private BitmapLayer b() {
        int width = getWidth();
        int height = getHeight();
        BitmapLayer bitmapLayer = new BitmapLayer(ShakeUtils.bitmapFromBase64StringSafe("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", width, height));
        bitmapLayer.setWidth(width);
        bitmapLayer.setHeight(height);
        bitmapLayer.setCenterX(getCenterX());
        bitmapLayer.setCenterY(getCenterY());
        return bitmapLayer;
    }

    public void c(Context context, int i3, int i16, int i17, int i18, int i19) {
        removeAllLayers();
        setCenterX(i3);
        setCenterY(i16);
        setWidth(i17);
        setHeight(i18);
        this.C = context;
        this.f108778f = b();
        this.f108779h = a(1);
        GradientLayer a16 = a(2);
        this.f108780i = a16;
        this.D = i19;
        addLayers(this.f108778f, this.f108779h, a16);
    }

    public void d() {
        a.C10732a c10732a = new a.C10732a(this, new Animator[0]);
        this.f108781m = c10732a;
        c10732a.b(this.D);
        setAnimator(this.f108781m);
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer, com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorAction
    public void postRotationY(float f16) {
        super.postRotationY(f16);
        a.C10732a c10732a = this.f108781m;
        if (c10732a != null) {
            c10732a.c(f16);
        }
    }
}
