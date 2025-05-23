package com.tencent.gdtad.api.banner.rectangle;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.ad.tangram.statistics.AdAntiSpamForClick;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.api.banner.GdtBannerView;
import com.tencent.gdtad.api.banner.GdtBannerViewBuilder;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes6.dex */
final class d extends RelativeLayout implements GdtBannerView {
    private ImageView C;

    /* renamed from: d, reason: collision with root package name */
    private GdtHandler.Params f108527d;

    /* renamed from: e, reason: collision with root package name */
    private int f108528e;

    /* renamed from: f, reason: collision with root package name */
    private int f108529f;

    /* renamed from: h, reason: collision with root package name */
    private URLImageView f108530h;

    /* renamed from: i, reason: collision with root package name */
    private URLImageView f108531i;

    /* renamed from: m, reason: collision with root package name */
    private URLImageView f108532m;

    public d(Context context, GdtHandler.Params params, int i3, int i16) {
        super(context);
        this.f108528e = Integer.MIN_VALUE;
        this.f108529f = Integer.MIN_VALUE;
        if (context != null && params != null && params.isValid() && i3 >= 0 && i16 >= 0) {
            this.f108527d = params;
            ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(0);
            addView(linearLayout, layoutParams);
            this.f108528e = i3;
            this.f108529f = i16;
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i3, i16);
            String str = a().getImageData(0).url;
            String str2 = a().getImageData(1).url;
            String str3 = a().getImageData(2).url;
            URLImageView uRLImageView = new URLImageView(context);
            this.f108530h = uRLImageView;
            uRLImageView.setId(R.id.crz);
            this.f108530h.setImageURL(str);
            linearLayout.addView(this.f108530h, layoutParams2);
            URLImageView uRLImageView2 = new URLImageView(context);
            this.f108531i = uRLImageView2;
            uRLImageView2.setId(R.id.f165341cs0);
            this.f108531i.setImageURL(str2);
            linearLayout.addView(this.f108531i, layoutParams2);
            URLImageView uRLImageView3 = new URLImageView(context);
            this.f108532m = uRLImageView3;
            uRLImageView3.setId(R.id.f165342cs1);
            this.f108532m.setImageURL(str3);
            linearLayout.addView(this.f108532m, layoutParams2);
            ViewGroup.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            ImageView imageView = new ImageView(context);
            this.C = imageView;
            imageView.setImageResource(R.drawable.mxk);
            addView(this.C, layoutParams3);
            this.C.bringToFront();
            return;
        }
        GdtLog.e("GdtBannerViewWithThreePictures", "constructor");
    }

    private GdtAd a() {
        GdtHandler.Params params = this.f108527d;
        if (params != null && params.isValid()) {
            return this.f108527d.f108486ad;
        }
        return null;
    }

    @Override // com.tencent.gdtad.api.banner.GdtBannerView
    public AdAntiSpamForClick getAntiSpamForClick() {
        return null;
    }

    @Override // com.tencent.gdtad.api.banner.GdtBannerView
    public View getOptionsView() {
        return this.C;
    }

    @Override // com.tencent.gdtad.api.banner.GdtBannerView
    public void setSize(int i3, int i16) {
        if (this.f108528e > 0 && this.f108529f > 0 && this.f108530h != null && this.f108531i != null && this.f108532m != null && i3 > 0 && i16 > 0) {
            int width = (GdtBannerViewBuilder.getWidth(i16) - (GdtUIUtils.dp2px(4.0f, getResources()) * 2)) / 3;
            this.f108530h.setLayoutParams(new LinearLayout.LayoutParams(width, i16));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, i16);
            layoutParams.leftMargin = GdtUIUtils.dp2px(4.0f, getResources());
            layoutParams.rightMargin = GdtUIUtils.dp2px(4.0f, getResources());
            layoutParams.weight = 1.0f;
            this.f108531i.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(width, i16);
            layoutParams2.rightMargin = -1;
            this.f108532m.setLayoutParams(layoutParams2);
            int intValue = Double.valueOf((i3 * 70) / com.tencent.luggage.wxa.yf.d.CTRL_INDEX).intValue();
            int intValue2 = Double.valueOf((intValue * 3) / 7).intValue();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.C.getLayoutParams();
            if (layoutParams3 != null) {
                layoutParams3.width = intValue;
                layoutParams3.height = intValue2;
                layoutParams3.leftMargin = GdtUIUtils.dp2px(6.0f, getResources());
                layoutParams3.topMargin = GdtUIUtils.dp2px(6.0f, getResources());
                return;
            }
            return;
        }
        GdtLog.e("GdtBannerViewWithThreePictures", "setSize error");
    }

    @Override // com.tencent.gdtad.api.GdtAdView
    public View getView() {
        return this;
    }

    @Override // com.tencent.gdtad.api.GdtAdView
    public void destroy(Context context) {
    }

    @Override // com.tencent.gdtad.api.GdtAdView
    public void pause(Context context) {
    }

    @Override // com.tencent.gdtad.api.GdtAdView
    public void resume(Context context) {
    }
}
