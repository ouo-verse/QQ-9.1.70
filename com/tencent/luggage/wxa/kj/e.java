package com.tencent.luggage.wxa.kj;

import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mm.modelappbrand.image.WxaIconTransformation;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public ImageView f132164a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f132165b;

    /* renamed from: c, reason: collision with root package name */
    public Button f132166c;

    public e(Context context, com.tencent.luggage.wxa.c5.e eVar) {
        super(context);
        a(eVar);
    }

    public final void a(com.tencent.luggage.wxa.c5.e eVar) {
        View.inflate(getContext(), R.layout.dxy, this);
        this.f132164a = (ImageView) findViewById(R.id.sqw);
        this.f132165b = (TextView) findViewById(R.id.sqy);
        this.f132166c = (Button) findViewById(R.id.sqv);
        boolean z16 = true;
        this.f132165b.setText(getResources().getString(R.string.f16378242, eVar.j0().f125955a));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f132164a.getLayoutParams();
        if (eVar.E() == null || eVar.E().b() == null || !eVar.E().b().a()) {
            z16 = false;
        }
        if (z16) {
            layoutParams.topMargin = com.tencent.luggage.wxa.kn.a.c(getContext(), R.dimen.c1x);
            this.f132164a.setLayoutParams(layoutParams);
            requestLayout();
        }
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        this.f132164a.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        AppBrandSimpleImageLoader.instance().attach(this.f132164a, eVar.j0().f125957c, ((com.tencent.luggage.wxa.il.l) eVar.f(com.tencent.luggage.wxa.il.l.class)).q(), WxaIconTransformation.INSTANCE);
        this.f132166c.setVisibility(8);
        setBackgroundColor(-1);
    }
}
