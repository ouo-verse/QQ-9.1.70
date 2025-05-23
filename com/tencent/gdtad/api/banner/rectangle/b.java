package com.tencent.gdtad.api.banner.rectangle;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes6.dex */
final class b extends a {
    private URLImageView E;

    public b(Context context, GdtHandler.Params params) {
        super(context, params);
    }

    @Override // com.tencent.gdtad.api.banner.rectangle.a
    protected View g(Context context, GdtHandler.Params params) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = -5;
        layoutParams.addRule(9);
        URLImageView uRLImageView = new URLImageView(context);
        this.E = uRLImageView;
        uRLImageView.setImageURL(h().getBasic_img());
        this.E.setId(R.id.f165338vm1);
        addView(this.E, layoutParams);
        return this.E;
    }
}
