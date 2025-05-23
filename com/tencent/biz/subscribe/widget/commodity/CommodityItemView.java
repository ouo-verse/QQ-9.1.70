package com.tencent.biz.subscribe.widget.commodity;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StYouZanGood;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.d;
import com.tencent.biz.subscribe.widget.SubscribeShareHelper;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.BaseURLDrawableHelper;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CommodityItemView extends BaseWidgetView {
    private SquareImageView E;
    private TextView F;
    private TextView G;
    private View H;
    private View I;
    private boolean J;
    private int K;
    private CertifiedAccountMeta$StFeed L;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (CommodityItemView.this.f() != null && !CommodityItemView.this.J) {
                if (CommodityItemView.this.f() instanceof CommodityBean) {
                    str = ((CommodityBean) CommodityItemView.this.f()).mUrl;
                } else {
                    str = ((CertifiedAccountMeta$StYouZanGood) CommodityItemView.this.f()).url.get();
                }
                if (CommodityItemView.this.L != null) {
                    VSReporter.n(CommodityItemView.this.L.poster.f24929id.get(), "auth_" + SubscribeShareHelper.s(CommodityItemView.this.g()), "clk_goods", 0, 0, new String[0]);
                }
                d.m(str, 8002);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public CommodityItemView(Context context) {
        this(context, null);
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected void c(Object obj) {
        String str;
        long j3;
        String str2;
        String format;
        if (obj instanceof CommodityBean) {
            CommodityBean commodityBean = (CommodityBean) obj;
            str = commodityBean.mTitle;
            j3 = commodityBean.mPrice;
            str2 = commodityBean.mImg;
        } else {
            CertifiedAccountMeta$StYouZanGood certifiedAccountMeta$StYouZanGood = (CertifiedAccountMeta$StYouZanGood) obj;
            str = certifiedAccountMeta$StYouZanGood.title.get();
            j3 = certifiedAccountMeta$StYouZanGood.price.get();
            str2 = certifiedAccountMeta$StYouZanGood.img.get();
        }
        this.F.setText(str);
        if (j3 % 100 == 0) {
            format = String.format("%d", Long.valueOf(j3 / 100));
        } else {
            format = String.format("%.2f", Float.valueOf(((float) j3) / 100.0f));
        }
        this.G.setText(format);
        if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
            try {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mLoadingDrawable = URLDrawableHelper.getLoadingDrawable();
                obtain.mFailedDrawable = BaseURLDrawableHelper.getFailedDrawable();
                URLDrawable drawable = URLDrawable.getDrawable(str2, obtain);
                if (drawable != null) {
                    this.E.setImageDrawable(drawable);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = this.L;
            if (certifiedAccountMeta$StFeed != null) {
                VSReporter.n(certifiedAccountMeta$StFeed.poster.f24929id.get(), "auth_" + SubscribeShareHelper.s(g()), "exp_goods", 0, 0, new String[0]);
                return;
            }
            return;
        }
        ImageLoader.getInstance().loadImageAsync(str2, new ImageLoader.ImageLoadListener() { // from class: com.tencent.biz.subscribe.widget.commodity.CommodityItemView.1
            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageLoaded(String str3, final Drawable drawable2, ImageLoader.Options options) {
                if (CommodityItemView.this.E != null) {
                    CommodityItemView.this.post(new Runnable() { // from class: com.tencent.biz.subscribe.widget.commodity.CommodityItemView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CommodityItemView.this.E.setImageDrawable(drawable2);
                        }
                    });
                }
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageCanceled(String str3, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageFailed(String str3, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageProgress(String str3, float f16, ImageLoader.Options options) {
            }
        });
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected int i() {
        return R.layout.c6r;
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected View.OnClickListener k() {
        return new a();
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected void p(Context context, View view) {
        this.E = (SquareImageView) view.findViewById(R.id.lng);
        this.F = (TextView) view.findViewById(R.id.f167039mc4);
        this.G = (TextView) view.findViewById(R.id.mc5);
        this.H = view.findViewById(R.id.f167032mc1);
        this.I = view.findViewById(R.id.lnh);
        this.K = (ImmersiveUtils.getScreenWidth() * 5) / 6;
        if (getLayoutParams() == null) {
            setLayoutParams(new FrameLayout.LayoutParams(this.K, ImmersiveUtils.dpToPx(132.0f)));
        }
        this.G.setTextSize((ImmersiveUtils.getScreenWidth() / 750) * 24);
    }

    public void setCurrentFeed(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        this.L = certifiedAccountMeta$StFeed;
    }

    public void setIsPublishUI(boolean z16) {
        this.J = z16;
        if (!z16) {
            return;
        }
        if (this.H.getVisibility() == 0) {
            this.H.setVisibility(8);
        }
        if (this.I.getVisibility() == 8) {
            this.I.setVisibility(0);
        }
    }

    public View v() {
        return this.I;
    }

    public CommodityItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommodityItemView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected View r() {
        return this;
    }
}
