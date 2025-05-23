package com.tencent.biz.subscribe.account_folder.top_pannel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.account_folder.passive_bubble.PassiveBubbleView;
import com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerView;
import com.tencent.mobileqq.R;

/* loaded from: classes5.dex */
public class TopPanelView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private a f95675d;

    /* renamed from: e, reason: collision with root package name */
    private RecommendBannerView f95676e;

    /* renamed from: f, reason: collision with root package name */
    private PassiveBubbleView f95677f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f95678h;

    public TopPanelView(Context context) {
        super(context);
        a(context);
    }

    protected void a(Context context) {
        View.inflate(context, R.layout.f167696ek, this);
        setBackgroundResource(R.drawable.f160540jm);
        this.f95676e = (RecommendBannerView) findViewById(R.id.f166764i24);
        this.f95677f = (PassiveBubbleView) findViewById(R.id.fip);
        this.f95678h = (TextView) findViewById(R.id.f166932j73);
    }

    public void setPresenter(a aVar) {
        this.f95675d = aVar;
        RecommendBannerView recommendBannerView = this.f95676e;
        if (recommendBannerView != null) {
            recommendBannerView.setPresenter(aVar);
        }
    }

    public TopPanelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public TopPanelView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a(context);
    }
}
