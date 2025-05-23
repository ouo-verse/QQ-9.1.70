package com.tencent.gdtad.api.banner.rectangle;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ad.tangram.statistics.AdAntiSpamForClick;
import com.tencent.ecommerce.repo.consumer.resp.PlayUI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.api.banner.GdtBannerView;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes6.dex */
abstract class a extends RelativeLayout implements GdtBannerView {
    private View C;
    private e D;

    /* renamed from: d, reason: collision with root package name */
    private GdtHandler.Params f108521d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f108522e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f108523f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f108524h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f108525i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f108526m;

    public a(Context context, GdtHandler.Params params) {
        super(context);
        if (params != null && params.isValid()) {
            this.f108521d = params;
            this.C = g(context, params);
            f(context);
            if (h().getCreativeSize() != 194) {
                e(context);
            }
            c(context);
            if (h().getCreativeSize() != 194) {
                a(context);
            }
            if ((h().getCreativeSize() == 184 || h().getCreativeSize() == 194) && h().getProductType() == 12 && h().getAppDownloadNum() != 0) {
                d(context);
            }
            b(context);
        }
    }

    private void a(Context context) {
        TextView textView = new TextView(context);
        this.f108525i = textView;
        textView.setMaxLines(1);
        this.f108525i.setMaxEms(8);
        this.f108525i.setEllipsize(TextUtils.TruncateAt.END);
        this.f108525i.setText(h().getAdvertiser_corporate_image_name());
        this.f108525i.setTextColor(Color.parseColor("#A6A6A6"));
        this.f108525i.setId(R.id.vly);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, R.id.cry);
        layoutParams.addRule(1, R.id.f165340vm3);
        addView(this.f108525i, layoutParams);
    }

    private void b(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(GdtUIUtils.dp2px(14.0f, getResources()));
        gradientDrawable.setColor(Color.parseColor("#12B7F5"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(1, this.C.getId());
        TextView textView = new TextView(context);
        this.f108523f = textView;
        textView.setGravity(17);
        this.f108523f.setTextColor(-1);
        k();
        this.f108523f.setBackground(gradientDrawable);
        addView(this.f108523f, layoutParams);
    }

    private void c(Context context) {
        String text;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        TextView textView = new TextView(context);
        this.f108524h = textView;
        textView.setMaxLines(1);
        this.f108524h.setEllipsize(TextUtils.TruncateAt.END);
        TextView textView2 = this.f108524h;
        if (TextUtils.isEmpty(h().getText())) {
            text = h().getDescription();
        } else {
            text = h().getText();
        }
        textView2.setText(text);
        this.f108524h.setTextColor(Color.parseColor("#333333"));
        this.f108524h.setId(R.id.cry);
        if (h().getCreativeSize() == 194) {
            layoutParams.addRule(1, this.C.getId());
        } else {
            layoutParams.addRule(1, R.id.f165340vm3);
        }
        addView(this.f108524h, layoutParams);
    }

    private void d(Context context) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        TextView textView = new TextView(context);
        this.f108526m = textView;
        textView.setId(R.id.f165337vm0);
        this.f108526m.setMaxLines(1);
        this.f108526m.setEllipsize(TextUtils.TruncateAt.END);
        this.f108526m.setText(em0.a.a(h().getAppDownloadNum()));
        this.f108526m.setTextColor(Color.parseColor("#A6A6A6"));
        if (h().getCreativeSize() == 194) {
            layoutParams.addRule(1, this.C.getId());
        } else {
            layoutParams.addRule(1, R.id.vly);
        }
        layoutParams.addRule(3, R.id.cry);
        addView(this.f108526m, layoutParams);
    }

    private void e(Context context) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, this.C.getId());
        e eVar = new e(context);
        this.D = eVar;
        eVar.d(GdtUIUtils.dp2px(7.0f, getResources()));
        this.D.setImageURL(h().getAdvertiser_corporate_logo());
        this.D.setId(R.id.f165340vm3);
        addView(this.D, layoutParams);
    }

    private void f(Context context) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        ImageView imageView = new ImageView(context);
        this.f108522e = imageView;
        imageView.setImageResource(R.drawable.mxk);
        addView(this.f108522e, layoutParams);
    }

    private boolean i() {
        GdtHandler.Params params = this.f108521d;
        if (params != null && params.isValid() && h() != null && h().getImageData() != null && h().getImageData().isValid()) {
            return true;
        }
        return false;
    }

    private void j(int i3) {
        int intValue = Double.valueOf((i3 * 22) / 166).intValue();
        TextView textView = this.f108525i;
        if (textView != null) {
            textView.setTextSize(0, intValue);
        }
        TextView textView2 = this.f108526m;
        if (textView2 != null) {
            textView2.setTextSize(0, intValue);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f108526m.getLayoutParams();
            if (layoutParams != null) {
                if (h().getCreativeSize() == 194) {
                    layoutParams.leftMargin = GdtUIUtils.dp2px(9.0f, getResources());
                } else {
                    layoutParams.leftMargin = GdtUIUtils.dp2px(7.0f, getResources());
                }
            }
        }
    }

    private void k() {
        if (i() && this.f108523f != null) {
            this.f108523f.setText(h().getButtonText(GdtHandler.canLaunchApp(this.f108521d)));
        }
    }

    private void l(int i3, int i16, int i17) {
        int intValue;
        if (h().getCreativeSize() != 65 && h().getCreativeSize() != 185) {
            if (h().getCreativeSize() == 184) {
                intValue = Double.valueOf((i3 * PlayUI.UIType.BIG_CARD_SHAPED_PIC) / com.tencent.luggage.wxa.yf.d.CTRL_INDEX).intValue();
            } else if (h().getCreativeSize() == 194) {
                intValue = Double.valueOf((i3 * 480) / com.tencent.luggage.wxa.yf.d.CTRL_INDEX).intValue();
            } else {
                intValue = 0;
            }
        } else {
            intValue = Double.valueOf((i3 * 345) / com.tencent.luggage.wxa.yf.d.CTRL_INDEX).intValue();
        }
        int intValue2 = Double.valueOf((i16 * 50) / 166).intValue();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f108523f.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = intValue;
            layoutParams.height = intValue2;
            layoutParams.rightMargin = GdtUIUtils.dp2px(9.0f, getResources());
            layoutParams.leftMargin = GdtUIUtils.dp2px(9.0f, getResources());
            layoutParams.bottomMargin = GdtUIUtils.dp2px(7.0f, getResources());
            layoutParams.topMargin = GdtUIUtils.dp2px(7.0f, getResources());
        }
        this.f108523f.setTextSize(0, i17);
    }

    private void m(int i3) {
        if (h().getCreativeSize() == 194 && this.f108526m == null) {
            this.f108524h.setMaxLines(2);
        }
        this.f108524h.setTextSize(0, i3);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f108524h.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = GdtUIUtils.dp2px(8.0f, getResources());
            layoutParams.rightMargin = GdtUIUtils.dp2px(9.0f, getResources());
            layoutParams.bottomMargin = GdtUIUtils.dp2px(5.0f, getResources());
            if (h().getCreativeSize() == 194) {
                layoutParams.leftMargin = GdtUIUtils.dp2px(9.0f, getResources());
            }
        }
    }

    private void n(int i3, int i16) {
        int intValue;
        if (h().getCreativeSize() != 65 && h().getCreativeSize() != 185) {
            if (h().getCreativeSize() == 184) {
                intValue = Double.valueOf((i3 * 222) / com.tencent.luggage.wxa.yf.d.CTRL_INDEX).intValue();
            } else if (h().getCreativeSize() == 194) {
                intValue = Double.valueOf((i3 * 168) / com.tencent.luggage.wxa.yf.d.CTRL_INDEX).intValue();
            } else {
                intValue = 0;
            }
        } else {
            intValue = Double.valueOf((i3 * 303) / com.tencent.luggage.wxa.yf.d.CTRL_INDEX).intValue();
        }
        if (this.C.getLayoutParams() != null) {
            this.C.getLayoutParams().width = intValue;
            this.C.getLayoutParams().height = i16;
        }
    }

    private void o(int i3) {
        int intValue = Double.valueOf((i3 * 70) / com.tencent.luggage.wxa.yf.d.CTRL_INDEX).intValue();
        int intValue2 = Double.valueOf((intValue * 3) / 7).intValue();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f108522e.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = intValue;
            layoutParams.height = intValue2;
            layoutParams.leftMargin = GdtUIUtils.dp2px(6.0f, getResources());
            layoutParams.topMargin = GdtUIUtils.dp2px(6.0f, getResources());
        }
    }

    private void p(int i3) {
        ViewGroup.LayoutParams layoutParams;
        int intValue = Double.valueOf((i3 * 72) / com.tencent.luggage.wxa.yf.d.CTRL_INDEX).intValue();
        e eVar = this.D;
        if (eVar != null) {
            layoutParams = eVar.getLayoutParams();
        } else {
            layoutParams = null;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.width = intValue;
            layoutParams2.height = intValue;
            layoutParams2.topMargin = GdtUIUtils.dp2px(8.0f, getResources());
            layoutParams2.leftMargin = GdtUIUtils.dp2px(10.0f, getResources());
            layoutParams2.rightMargin = GdtUIUtils.dp2px(7.0f, getResources());
        }
    }

    protected abstract View g(Context context, GdtHandler.Params params);

    @Override // com.tencent.gdtad.api.banner.GdtBannerView
    public AdAntiSpamForClick getAntiSpamForClick() {
        return null;
    }

    @Override // com.tencent.gdtad.api.banner.GdtBannerView
    public View getOptionsView() {
        return this.f108522e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GdtAd h() {
        GdtHandler.Params params = this.f108521d;
        if (params != null && params.isValid()) {
            return this.f108521d.f108486ad;
        }
        return null;
    }

    @Override // com.tencent.gdtad.api.GdtAdView
    public void resume(Context context) {
        k();
    }

    @Override // com.tencent.gdtad.api.banner.GdtBannerView
    public void setSize(int i3, int i16) {
        if (i3 > 0 && i16 > 0 && this.f108522e != null && this.f108523f != null && this.f108524h != null && this.C != null) {
            n(i3, i16);
            p(i3);
            o(i3);
            int intValue = Double.valueOf((i16 * 26) / 166).intValue();
            l(i3, i16, intValue);
            m(intValue);
            j(i16);
            return;
        }
        GdtLog.e("GdtBannerViewWithOneMediaView", "setSize error");
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
}
