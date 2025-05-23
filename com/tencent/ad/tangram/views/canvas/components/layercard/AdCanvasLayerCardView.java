package com.tencent.ad.tangram.views.canvas.components.layercard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.image.AdImageViewAdapter;
import com.tencent.ad.tangram.image.AdImageViewBuilder;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.ad.tangram.views.AdViewStatus;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentData;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdCanvasAppBtnComponentView;
import com.tencent.ad.tangram.views.canvas.components.imagescarousel.AdCanvasImagesCarouselComponentView;
import com.tencent.ad.tangram.views.canvas.components.picture.AdCanvasPictureComponentView;
import com.tencent.ad.tangram.views.canvas.framework.AdCanvasViewListener;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import java.lang.ref.WeakReference;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdCanvasLayerCardView extends AdCanvasComponentView implements AdImageViewAdapter.Callback {
    private static final String LAYER_CARD_MASK = "iVBORw0KGgoAAAANSUhEUgAAAAIAAAS0CAYAAABKatlfAAAAAXNSR0IArs4c6QAAAERlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAAAqADAAQAAAABAAAEtAAAAADpDgMIAAAEZklEQVRoBe2YDU4dQQyD36O9/2V6v1Jiab/F8mRmlsIKVUUqSvPj2JkEnng+Ho9fb/9eX+rbe+NRHn39fPteIXkwyvFqofJkDji/jxarHMOBGDgPa/olfNS0aGDA+dP50MKRXdfxFiQ3fLLKPTY6m/M53qPX5L2ggdHwUQtrepkPLWRQjmHP5DmESMbIkDxGtTzoYj5bfAzn+R7HGd7F53hT71683HMXH5tP0fDxQgOjUpyqPGOcrMpyzxnjLKo4kCfjTZz0kFwGNDAmuhZ8/s+nBtpP9bu91618xntoW3crn40ruJWPzcfGoo2y07vj3o1Pdc/fRP/+fGIIvMXsQ2Cs1u3vddf+fLf5/HhbUz7t1M6e71Uh+1Keea7/x3pR/iy3h46V0CbshkhGBYvExxVy8KQxyVmFpKnIwxmDUC0bOBgf40x5qsDT5EDM+FClgyUH8mUkIORfTDtn5Th1Be6Jqmwx4QNnqpKPPOIz7m66KBegheiVfLJKyaYUwAkOoZRDOYa3sF6OUyo8GV2EzKC741SLRimA0MBgEzJn0dS7kwwyBsjk4LEcADFS6XaIXrTAoDvaLZT7s93UcY4flatyqorPQHJ/F4nMAmzd+8Fw0HQSCj40FQ7jLV0eMqU7c/ZykMuQdgFu8DmTTRc4MgJnMl5XCg4CMQg1j2t8sqrK6YUK3ivnk5zxpAHO9RC64IwBZ7sven2MM+VJFU+TAzF7AiUXVf3plRx0ocJCkN+5r4bPosXkLlIpfJ5sbxmaPJ5jx7IcDwZjkUfaA+dsasg2KNe+yyeRB3yqqfUSVXtc5GA4Hz1B6Mrk5JM5eGRA7DqfY5gpGfLOR1M9ptHkrJbNmkLeqhBIC1dKsklGxaX7anqZ0iYHGqgwPlRN7gvOCGTgO/dOCx8UxMoYhPo9BBA+eBxH8+lxSEaOPPCBIaPDIDRJzpCqPsSnEZh8msfd2Gemkb1yPpmDJ41EJmcVYs4oxWC8dgW84GfcF93NaDhDrHmCxbvTonAY+NZ99cizOV+pgo9r370vaGDwTPJodMHHm9p8GhzlBI4n23ihgXHyOX6DUC7j8uNS7qMrqngapZbjxNj5zCnPpKmHSGZ7MSrkY8EznqEjG852aMFHOPYEMPyMe2eqRp5nQoUMcozPmdPvITkgswDnvVe5+PQ4lAOIMQj1OFkFH8fZ5ePlrI0/bvDJKohNPpxMQpBPZIWcz6V73/19ai0mfFBKDp40Jjmr0IKPetk+A5gzhBg5eDA8pP2JOXuOMWz4VM6le4f8eV9FY8xnslGNLnGOfSYZA6XJR57d+wIQQ8iiwXiDD00HybbP4Cx0pRyQMcSQH5UYtLBlQw4GLfBMXofkRmk1JecEZGLHSjQ5k3JCZQi5lILjfGzrmhxwyiDHOe+EwMnJ47EnUK+q+rr7auSM+ZySY58JwZnJM3DuXR5TSjlGQ6yZc/ChafJpWmgTAieTE3nQInCySsjMGV1l0PRT78t6qcVfPoGo/gFHAqOmRMO9vAAAAABJRU5ErkJggg==";
    private static final String NO_VIRUS_TAG = "iVBORw0KGgoAAAANSUhEUgAAABoAAAAgCAMAAAA7dZg3AAAAdVBMVEUAAACampqYmJiYmJiYmJicnJyYmJiXl5eXl5eampqYmJiYmJibm5uioqKYmJiXl5eYmJiYmJiampqXl5eYmJiZmZmYmJiYmJiampqampqfn5+YmJiYmJiZmZmYmJiYmJiYmJiYmJiXl5eZmZmenp6Xl5eXl5eBcAPkAAAAJnRSTlMAQcj49QXsz8Asn2wUCuDlr3wy2qh5ZVo7JRDx1Ey0nZCGVkYZUc+GMUUAAAEJSURBVCjPxdJXbsQgFEDRZ1ywPS5xn95z97/EIMQwTOL/3A8L+UgI0JOgQutCVtvEkGxW4HSEtgV9ko+KyQBjVY3AsSvcNkoNMSYViSlSmOJBqY3Y32SlBYtlhmWBsVv6VILSfulGMBTJStG/005/hRRKSx7Q3PmLFRm6CqjhK/Wi9hJQlDjrnXjytj2Q1/KijLu87C1yJxPNJM7yhLMTmVBSksvLOPuD5pTygJ2zpvSyg4ekrfE/lTTmO0O08oJ2tBTt81OeDcouigRdh1JrksKNIKjqLZWCbz+3MPTi6gcIZniJiW/27fY3s1wkaNvA4TLPlwSarXxUX2Ns8bWW31VdnmX59D7PD1RRHeX9vgF3AAAAAElFTkSuQmCC";
    private static final String STAR_DARK = "iVBORw0KGgoAAAANSUhEUgAAABwAAAAaCAYAAACkVDyJAAAAAXNSR0IArs4c6QAAAERlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAAHKADAAQAAAABAAAAGgAAAADr/QECAAACbElEQVRIDa2Wz2sTQRTHdzdGhIB66s2ChKhgr9oWBQ/Wu2cNSjQ/KOJBz6Wl0LMeRCE/NBqj5+JVj4pSz4K0iAf/ARWiQtjEzws7ZTaZ2WSSDkxn9r33/X73+3ZnU8+bYtRqtUsyp4B6h6YBgVmPcJdd8b4roNFoXAjD8L3gUqnUxWKx+MGFI3Apltper7ehMPpexcatTg7r9foSIh910iAIlkul0ic9lrR3cmhy1O/31fNM0tnPTeyQt/Ic5Dv7SG3j+/75crn8WQtZty4Ok5wk5WLiRofNZvNIt9vN4ihH9SnmGWYhhhy9aBL6ytzF8V46nf5WKBT+DZf57Xb7aKfTuU1CkecAnEDMeDPDBLZrOKDo/yC/x9yVNZPJPA3y+fxvkocJrDLlIM/PKgaHF3HMR5yrojHQkqSMarV6j+XB4OLg/9yvVCoPhTbWNs7ZHe7s0UE4HJDTVpzd5Zw+Vh5ighLk9S+xVGcVlWcIT4XjUhdeNUYEJUF7b7I8Y7ocG4Gq0WNziza+UAG1GgUlieg17rKF05QqnmQFE4K5gdhrU71VUIpp71vAKyagLYbgO9p4xZYf1zI58K4jEWN1SEuPofTTVS2qP05Lf5mwVof8uC6YAJPEkrBWQZ7d2UnITTVJ2CRBo0Neih0crMiUvUXQiJVa6z9R3GUMBPkXYmu8gduayCLP+iq5Ld3VMFartwtCsgDQY/0OYIPP0yv2cqBjg5djm7o3fBavk9hkf1KwsSLtwtjSVqs1BzAEKN/W07h6aRJTPJKTGqmNMKFwqLy+GlvKj+9firKQ/NGLx+1x26XmCW1+DofxC/UfzavsrjiuOakAAAAASUVORK5CYII=";
    private static final String STAR_LIGHT = "iVBORw0KGgoAAAANSUhEUgAAABwAAAAaCAYAAACkVDyJAAAAAXNSR0IArs4c6QAAAERlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAAHKADAAQAAAABAAAAGgAAAADr/QECAAACoElEQVRIDa1WTWgTURCeeU1Cs6H1Ip6qF0kRLPbiT6VCs6bem4gXhaqVKiIe9Fz1oGc9iAct/oLeTHpXmggtltqLB0EaxIM38RTJpjRmx5nQbdL1vU028cFm3/tmvu/beT+7AeiiVRczE3J1QYVINyQCuL3FS4flY1iCs5gdJ3CXhIegTlgnc8thNFSYZMklpDsep7XvYe3uoSp0CtkxIvdjqyiiOm7ZuZVWLKgfqkKCZnWeKGPeenpQ4L3jCivF7BFw3VWtmlJHE6ncJ23MB3ZeIQVUEhTzGWorpMKF/s3o7/1/apBEomGetgO8XS76uL4hPkfAr4S4HolCKVYb+Ib2iw1fEiCtnBusbjiX0MUkoTsMBEne73uJ+LeHhshKBD9YpYSk1klRKd5vPVU49rrMgZgL7lU2SfOh3termTynaGxppUVbPMRruwqnmLlBLt3voSgjFRXetFL5B5KwbSiDSiFzjWfi4f+osCHOYlzo9YSdfyRjaTsMBagWM7NE9LhXU1lDRLwST+XnRddr/xhKoFrInGfDZ7zqnR8bT5HvvFtdNpyJ2/mXLXCjqzWUSPVD9izV6RWb9vlJQWM2q2MfTscncm90eUZDSa4Upt7x7prUEY0YwvuEvXDKFA+cMn5aPvDhWjuO0ZDWzuzizTMUzk7OHw0J18QzGlbL9RETqR0exDUa8lf9YDthUzyIazTk3aStkNdoVUFkUi7p60xNXMk1/4lCHJH3RLPhF0A1Z9lvF5oYHKsUTk8Bufd49ZozIlxDM1bIVg0SH+DvSqlpyx49lNhp1pAUTGKSI7kCelydp/Yc0nJmj7MJn/nldNca3D2Ph5/UdGQ/RmuXo0751yx/J25ZMRjF8fxPf452TEszA0y2tMEOQOGKhi71LyUG6YhPH1qRAAAAAElFTkSuQmCC";
    private static final String TAG = "AdCanvasLayerCardView";
    private AdCanvasAppBtnComponentView adCanvasAppBtnComponentView;

    @Nullable
    private AdCanvasImagesCarouselComponentView adCanvasImagesCarouselComponentView;
    private final WeakReference<AdImageViewBuilder.Listener> imageViewlistener;

    @Nullable
    private View logoView;

    @Nullable
    private AdCanvasLayerCardData value;

    public AdCanvasLayerCardView(@NonNull Context context, WeakReference<AdCanvasViewListener> weakReference, AdCanvasLayerCardData adCanvasLayerCardData, Handler handler) {
        super(context, weakReference);
        this.imageViewlistener = new WeakReference<>(new AdImageViewBuilder.Listener() { // from class: com.tencent.ad.tangram.views.canvas.components.layercard.AdCanvasLayerCardView.1
            @Override // com.tencent.ad.tangram.image.AdImageViewBuilder.Listener
            public void onStopLoad(boolean z16) {
                AdCanvasLayerCardView.this.onStopLoad(z16);
            }
        });
        init(context, adCanvasLayerCardData, handler);
    }

    private void init(@Nullable Context context, @Nullable AdCanvasLayerCardData adCanvasLayerCardData, Handler handler) {
        if (context == null || adCanvasLayerCardData == null || !adCanvasLayerCardData.isValid()) {
            return;
        }
        this.value = adCanvasLayerCardData;
        FrameLayout frameLayout = new FrameLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.value.width, -2);
        addView(frameLayout);
        frameLayout.setBackgroundColor(-16777216);
        frameLayout.setLayoutParams(layoutParams);
        this.adCanvasImagesCarouselComponentView = new AdCanvasImagesCarouselComponentView(context, this.canvasViewListener, this.value.adCanvasImagesCarouselComponentData, handler);
        AdCanvasLayerCardData adCanvasLayerCardData2 = this.value;
        frameLayout.addView(this.adCanvasImagesCarouselComponentView, new FrameLayout.LayoutParams(adCanvasLayerCardData2.width, adCanvasLayerCardData2.height));
        View imageView = new ImageView(context);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        imageView.setLayoutParams(layoutParams2);
        Bitmap bitmapFromString = AdUIUtils.getBitmapFromString(LAYER_CARD_MASK);
        if (bitmapFromString != null) {
            imageView.setBackgroundDrawable(new BitmapDrawable(bitmapFromString));
        }
        frameLayout.addView(imageView, layoutParams2);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(PlayerResources.RawId.BASE);
        relativeLayout.setPadding(AdUIUtils.dp2px(20.0f, context.getResources()), AdUIUtils.dp2px(42.0f, context.getResources()), AdUIUtils.dp2px(20.0f, context.getResources()), AdUIUtils.dp2px(20.0f, context.getResources()));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams3.gravity = 80;
        layoutParams3.leftMargin = AdUIUtils.dp2px(24.0f, context.getResources());
        layoutParams3.rightMargin = AdUIUtils.dp2px(24.0f, context.getResources());
        layoutParams3.bottomMargin = AdUIUtils.dp2px(72.0f, context.getResources());
        relativeLayout.setBackgroundColor(Color.parseColor("#DEDDDE"));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(AdUIUtils.dp2px(10.0f, context.getResources()));
        gradientDrawable.setAlpha(216);
        gradientDrawable.setColor(Color.parseColor("#DEDDDE"));
        relativeLayout.setBackground(gradientDrawable);
        frameLayout.addView(relativeLayout);
        relativeLayout.setLayoutParams(layoutParams3);
        AdImageViewBuilder.Params params = new AdImageViewBuilder.Params();
        params.context = new WeakReference<>(context);
        params.url = this.value.logoUrl;
        params.callback = new WeakReference<>(this);
        params.listener = this.imageViewlistener;
        View buildImageView = AdImageViewBuilder.getInstance().buildImageView(params);
        this.logoView = buildImageView;
        if (buildImageView == null) {
            AdLog.e(TAG, "buildImageView Failed");
            stopLoad(false);
            return;
        }
        buildImageView.setId(8738);
        relativeLayout.addView(this.logoView);
        ViewGroup.LayoutParams layoutParams4 = this.logoView.getLayoutParams();
        AdCanvasLayerCardData adCanvasLayerCardData3 = this.value;
        layoutParams4.width = adCanvasLayerCardData3.logoWidth;
        layoutParams4.height = adCanvasLayerCardData3.logoHeight;
        this.logoView.setLayoutParams(layoutParams4);
        TextView textView = new TextView(context);
        textView.setId(13107);
        textView.setText(this.value.appName);
        textView.setTextSize(15.0f);
        textView.setMaxLines(1);
        textView.setTextColor(Color.parseColor("#000000"));
        textView.setMaxWidth(AdUIUtils.dp2px(170.0f, context.getResources()));
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.getPaint().setFakeBoldText(true);
        relativeLayout.addView(textView);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        layoutParams5.addRule(1, this.logoView.getId());
        layoutParams5.leftMargin = AdUIUtils.dp2px(12.0f, context.getResources());
        layoutParams5.topMargin = AdUIUtils.dp2px(10.0f, context.getResources());
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(AdUIUtils.dp2px(12.0f, context.getResources()), AdUIUtils.dp2px(12.0f, context.getResources()));
        layoutParams6.leftMargin = AdUIUtils.dp2px(3.0f, context.getResources());
        layoutParams6.topMargin = AdUIUtils.dp2px(5.0f, context.getResources());
        int min = Math.min(this.value.starCount, 5);
        for (int i3 = 0; i3 < min; i3++) {
            ImageView imageView2 = new ImageView(context);
            imageView2.setImageBitmap(AdUIUtils.getBitmapFromString(STAR_LIGHT));
            linearLayout.addView(imageView2, layoutParams6);
        }
        for (int i16 = 0; i16 < 5 - min; i16++) {
            ImageView imageView3 = new ImageView(context);
            imageView3.setImageBitmap(AdUIUtils.getBitmapFromString(STAR_DARK));
            linearLayout.addView(imageView3, layoutParams6);
        }
        TextView textView2 = new TextView(context);
        textView2.setMaxWidth(AdUIUtils.dp2px(120.0f, context.getResources()));
        textView2.setText(this.value.downloadCount != 0 ? "(" + AdUIUtils.formatNumberToChineseUnit(this.value.downloadCount) + ")" : "");
        textView2.setMaxLines(1);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setTextColor(Color.parseColor("#000000"));
        textView2.setTextSize(15.0f);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams7.leftMargin = AdUIUtils.dp2px(3.0f, context.getResources());
        linearLayout.addView(textView2, layoutParams7);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(1, this.logoView.getId());
        layoutParams8.addRule(3, textView.getId());
        layoutParams8.leftMargin = AdUIUtils.dp2px(12.0f, context.getResources());
        layoutParams8.topMargin = AdUIUtils.dp2px(10.0f, context.getResources());
        relativeLayout.addView(linearLayout, layoutParams8);
        TextView textView3 = new TextView(context);
        textView3.setId(17476);
        textView3.setText(this.value.appDesc);
        textView3.setTextSize(14.0f);
        textView3.setTextColor(Color.parseColor("#000000"));
        textView3.setMaxLines(3);
        textView3.setEllipsize(TextUtils.TruncateAt.END);
        relativeLayout.addView(textView3);
        RelativeLayout.LayoutParams layoutParams9 = (RelativeLayout.LayoutParams) textView3.getLayoutParams();
        layoutParams9.addRule(3, this.logoView.getId());
        layoutParams9.topMargin = AdUIUtils.dp2px(20.0f, context.getResources());
        layoutParams9.bottomMargin = AdUIUtils.dp2px(20.0f, context.getResources());
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        relativeLayout2.setId(21845);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams10.addRule(15, -1);
        layoutParams10.addRule(3, textView3.getId());
        relativeLayout.addView(relativeLayout2, layoutParams10);
        this.adCanvasAppBtnComponentView = new AdCanvasAppBtnComponentView(context, this.canvasViewListener, this.value.adCanvasAppBtnComponentData, true, false);
        relativeLayout2.addView(this.adCanvasAppBtnComponentView, new RelativeLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(1);
        FrameLayout.LayoutParams layoutParams11 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams11.gravity = 80;
        layoutParams11.bottomMargin = AdUIUtils.dp2px(30.0f, context.getResources());
        frameLayout.addView(linearLayout2, layoutParams11);
        String[] strArr = {"\u65e0\u5e7f\u544a", "\u65e0\u75c5\u6bd2", "\u6709\u4fdd\u969c"};
        for (int i17 = 0; i17 < 3; i17++) {
            String str = strArr[i17];
            ImageView imageView4 = new ImageView(context);
            imageView4.setImageBitmap(AdUIUtils.getBitmapFromString(NO_VIRUS_TAG));
            LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(AdUIUtils.dp2px(16.0f, context.getResources()), AdUIUtils.dp2px(16.0f, context.getResources()));
            if (i17 > 0) {
                layoutParams12.leftMargin = AdUIUtils.dp2px(25.0f, context.getResources());
            }
            layoutParams12.rightMargin = AdUIUtils.dp2px(5.0f, context.getResources());
            linearLayout2.addView(imageView4, layoutParams12);
            TextView textView4 = new TextView(context);
            textView4.setText(str);
            textView4.setTextSize(13.0f);
            textView4.setTextColor(Color.parseColor("#676363"));
            linearLayout2.addView(textView4);
        }
    }

    @Nullable
    public AdCanvasImagesCarouselComponentView getAdCanvasImagesCarouselComponentView() {
        return this.adCanvasImagesCarouselComponentView;
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView
    @Nullable
    public AdCanvasComponentData getData() {
        return this.value;
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView
    @Nullable
    public AdViewStatus getStatus() {
        return this.status;
    }

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView
    public void onLocationChanged() {
        super.onLocationChanged();
        AdCanvasImagesCarouselComponentView adCanvasImagesCarouselComponentView = this.adCanvasImagesCarouselComponentView;
        if (adCanvasImagesCarouselComponentView != null && adCanvasImagesCarouselComponentView.getAdCanvasPictureComponentViews() != null) {
            for (AdCanvasPictureComponentView adCanvasPictureComponentView : this.adCanvasImagesCarouselComponentView.getAdCanvasPictureComponentViews()) {
                if (adCanvasPictureComponentView != null) {
                    adCanvasPictureComponentView.onLocationChanged();
                }
            }
        }
    }

    @Override // com.tencent.ad.tangram.image.AdImageViewAdapter.Callback
    public void onStopLoad(boolean z16) {
    }
}
