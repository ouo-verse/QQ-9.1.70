package com.tencent.biz.subscribe.account_folder.recommend_banner;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StEntry;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StImage;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.subscribe.d;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RecommendBannerEntryItemView extends RelativeLayout {
    private boolean C;
    private CertifiedAccountMeta$StEntry D;

    /* renamed from: d, reason: collision with root package name */
    private RoundCornerImageView f95616d;

    /* renamed from: e, reason: collision with root package name */
    private RoundCornerImageView f95617e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f95618f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f95619h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f95620i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f95621m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(RecommendBannerEntryItemView.this.getContext(), QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.PUBLIC_ACCOUNT_DISCOVER_PAGE_SCHEMA, QzoneConfig.DEFAULT_PUBLIC_ACCOUNT_DISCOVER_PAGE_SCHEMA), 2016, null, null);
            QZoneHelper.prepareForQQPublicAccountPublishPage();
            VSReporter.n(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "auth_page", "clk_find", 0, 0, new String[0]);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public RecommendBannerEntryItemView(Context context) {
        super(context);
        a(context);
    }

    protected void a(Context context) {
        View.inflate(context, R.layout.c78, this);
        setMinimumHeight(x.c(context, 213.0f));
        setPadding(x.c(context, 6.0f), x.c(context, 10.0f), x.c(context, 6.0f), x.c(context, 20.0f));
        setWillNotDraw(false);
        setLayerType(1, null);
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) findViewById(R.id.a2o);
        this.f95616d = roundCornerImageView;
        roundCornerImageView.setCorner(ImmersiveUtils.dpToPx(7.0f));
        RoundCornerImageView roundCornerImageView2 = (RoundCornerImageView) findViewById(R.id.f164546a31);
        this.f95617e = roundCornerImageView2;
        roundCornerImageView2.setCorner(ImmersiveUtils.dpToPx(7.0f));
        this.f95619h = (TextView) findViewById(R.id.f9d);
        this.f95620i = (TextView) findViewById(R.id.f163918c6);
        this.f95618f = (ImageView) findViewById(R.id.lzl);
        setOnClickListener(new a());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        Paint paint = new Paint();
        if (this.f95621m) {
            paint.setColor(-15263977);
        } else {
            paint.setColor(-1);
        }
        if (!this.C) {
            paint.setShadowLayer(x.c(getContext(), 15.0f), 0, x.c(getContext(), 5.0f), 436207616);
        }
        int c16 = x.c(getContext(), 6.0f);
        RectF rectF = new RectF(paddingLeft, paddingTop, width, height);
        float f16 = c16;
        canvas.drawRoundRect(rectF, f16, f16, paint);
        super.onDraw(canvas);
    }

    public void setEntry(CertifiedAccountMeta$StEntry certifiedAccountMeta$StEntry) {
        this.D = certifiedAccountMeta$StEntry;
        if (certifiedAccountMeta$StEntry == null) {
            return;
        }
        CertifiedAccountMeta$StImage certifiedAccountMeta$StImage = certifiedAccountMeta$StEntry.cover;
        if (certifiedAccountMeta$StImage != null) {
            UIUtils.t(this.f95616d, certifiedAccountMeta$StImage.url.get(), this.f95616d.getWidth(), this.f95616d.getHeight(), null, "");
        }
        this.f95619h.setText(this.D.title.get());
        if (d.h(this.D.type.get())) {
            this.f95618f.setVisibility(0);
        } else {
            this.f95618f.setVisibility(8);
        }
    }

    public void setInNightMode(boolean z16) {
        this.f95621m = z16;
    }

    public void setIsCloseShadow(boolean z16) {
        this.C = z16;
    }

    public RecommendBannerEntryItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public RecommendBannerEntryItemView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a(context);
    }
}
