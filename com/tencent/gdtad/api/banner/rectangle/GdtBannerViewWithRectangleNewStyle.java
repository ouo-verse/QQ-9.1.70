package com.tencent.gdtad.api.banner.rectangle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.RelativeLayout;
import com.tencent.ad.tangram.statistics.AdAntiSpamForClick;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.api.banner.GdtBannerParams;
import com.tencent.gdtad.api.banner.GdtBannerView;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.GdtUIUtils;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtBannerViewWithRectangleNewStyle extends RelativeLayout implements GdtBannerView {

    /* renamed from: d, reason: collision with root package name */
    private GdtHandler.Params f108513d;

    /* renamed from: e, reason: collision with root package name */
    private AdAntiSpamForClick f108514e;

    /* renamed from: f, reason: collision with root package name */
    private GdtBannerView f108515f;

    /* renamed from: h, reason: collision with root package name */
    private Path f108516h;

    /* renamed from: i, reason: collision with root package name */
    private RectF f108517i;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f108518a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f108519b;

        a(int i3, int i16) {
            this.f108518a = i3;
            this.f108519b = i16;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, this.f108518a, this.f108519b, 8.0f);
        }
    }

    public GdtBannerViewWithRectangleNewStyle(Context context, GdtBannerParams gdtBannerParams) {
        super(context);
        this.f108514e = new AdAntiSpamForClick();
        if (context != null && gdtBannerParams != null && gdtBannerParams.isValid() && GdtBannerParams.isCreativeSizeValid(gdtBannerParams.clickParams.f108486ad)) {
            this.f108513d = gdtBannerParams.clickParams;
            if (!c()) {
                GdtLog.e("GdtBannerViewWithRectangleStyle", "constructor");
                return;
            }
            this.f108516h = new Path();
            this.f108517i = new RectF();
            if (b() != null) {
                a();
                if (b().getCreativeSize() == 65 || b().getCreativeSize() == 184 || b().getCreativeSize() == 194) {
                    this.f108515f = new b(getContext(), this.f108513d);
                }
                if (b().getCreativeSize() == 285) {
                    this.f108515f = new d(getContext(), this.f108513d, GdtUIUtils.dp2px(111.0f, getResources()), GdtUIUtils.dp2px(83.0f, getResources()));
                }
                if (b().getCreativeSize() == 185) {
                    this.f108515f = new c(getContext(), this.f108513d);
                }
            }
            GdtBannerView gdtBannerView = this.f108515f;
            if (gdtBannerView != null && gdtBannerView.getView() != null) {
                addView(this.f108515f.getView());
                return;
            }
            return;
        }
        GdtLog.e("GdtBannerViewWithRectangleStyle", "constructor");
    }

    private void a() {
        GradientDrawable gradientDrawable;
        if (b().getCreativeSize() != 65 && b().getCreativeSize() != 184 && b().getCreativeSize() != 194 && b().getCreativeSize() != 185) {
            if (b().getCreativeSize() == 285) {
                gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(-1);
            } else {
                gradientDrawable = null;
            }
        } else {
            GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.argb(255, 255, 255, 255), Color.argb(255, 192, 231, 255)});
            gradientDrawable2.setGradientCenter(0.5f, 0.9f);
            gradientDrawable = gradientDrawable2;
        }
        if (gradientDrawable != null) {
            gradientDrawable.setCornerRadius(10.0f);
        }
        setBackground(gradientDrawable);
    }

    private GdtAd b() {
        GdtHandler.Params params = this.f108513d;
        if (params != null && params.isValid()) {
            return this.f108513d.f108486ad;
        }
        return null;
    }

    private boolean c() {
        GdtHandler.Params params = this.f108513d;
        if (params != null && params.isValid()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.gdtad.api.GdtAdView
    public void destroy(Context context) {
        GdtLog.i("GdtBannerViewWithRectangleStyle", "destroy");
        GdtBannerView gdtBannerView = this.f108515f;
        if (gdtBannerView != null) {
            gdtBannerView.destroy(context);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        setClipToOutline(true);
        setOutlineProvider(new a(width, height));
        super.dispatchDraw(canvas);
    }

    @Override // com.tencent.gdtad.api.banner.GdtBannerView
    public AdAntiSpamForClick getAntiSpamForClick() {
        return this.f108514e;
    }

    @Override // com.tencent.gdtad.api.banner.GdtBannerView
    public View getOptionsView() {
        GdtBannerView gdtBannerView = this.f108515f;
        if (gdtBannerView != null) {
            return gdtBannerView.getOptionsView();
        }
        return null;
    }

    @Override // com.tencent.gdtad.api.GdtAdView
    public void pause(Context context) {
        GdtLog.i("GdtBannerViewWithRectangleStyle", "pause");
        GdtBannerView gdtBannerView = this.f108515f;
        if (gdtBannerView != null && gdtBannerView.getAntiSpamForClick() != null) {
            this.f108515f.getAntiSpamForClick().setHasBeenPaused();
        }
        GdtBannerView gdtBannerView2 = this.f108515f;
        if (gdtBannerView2 != null) {
            gdtBannerView2.pause(context);
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        Object obj = this.f108515f;
        if (obj instanceof View) {
            ((View) obj).performClick();
        }
        return super.performClick();
    }

    @Override // com.tencent.gdtad.api.GdtAdView
    public void resume(Context context) {
        GdtLog.i("GdtBannerViewWithRectangleStyle", "resume");
        GdtBannerView gdtBannerView = this.f108515f;
        if (gdtBannerView != null) {
            gdtBannerView.resume(context);
        }
    }

    @Override // com.tencent.gdtad.api.banner.GdtBannerView
    public void setSize(int i3, int i16) {
        GdtBannerView gdtBannerView = this.f108515f;
        if (gdtBannerView != null && gdtBannerView.getView() != null && i3 > 0 && i16 > 0) {
            this.f108515f.getView().setLayoutParams(new RelativeLayout.LayoutParams(i3, i16));
            this.f108515f.setSize(i3, i16);
            return;
        }
        GdtLog.e("GdtBannerViewWithRectangleStyle", "setSize error");
    }

    @Override // com.tencent.gdtad.api.GdtAdView
    public View getView() {
        return this;
    }
}
