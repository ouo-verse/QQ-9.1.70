package com.tencent.biz.subscribe.account_folder.top_pannel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerViewNew;
import com.tencent.mobileqq.R;

/* loaded from: classes5.dex */
public class TopPanelViewNew extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private a f95679d;

    /* renamed from: e, reason: collision with root package name */
    private RecommendBannerViewNew f95680e;

    /* renamed from: f, reason: collision with root package name */
    private View f95681f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f95682h;

    public TopPanelViewNew(Context context) {
        super(context);
        this.f95682h = false;
        a(context);
    }

    protected void a(Context context) {
        this.f95682h = SubscribeUtils.m();
        View.inflate(context, R.layout.c6w, this);
        if (this.f95682h) {
            setBackgroundColor(-16777216);
        }
        this.f95680e = (RecommendBannerViewNew) findViewById(R.id.f166764i24);
        this.f95681f = findViewById(R.id.lne);
    }

    public void setOnHideBtnClickListener(View.OnClickListener onClickListener) {
        View view = this.f95681f;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setPresenter(a aVar) {
        this.f95679d = aVar;
        RecommendBannerViewNew recommendBannerViewNew = this.f95680e;
        if (recommendBannerViewNew != null) {
            recommendBannerViewNew.setPresenter(aVar);
        }
    }

    public TopPanelViewNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f95682h = false;
        a(context);
    }

    public TopPanelViewNew(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f95682h = false;
        a(context);
    }
}
