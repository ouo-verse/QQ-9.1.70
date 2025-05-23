package com.qzone.reborn.layer.recommendphoto;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.qzone.util.ar;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneFeedxLayerRecommendTitleView extends QZoneBaseWidgetView {

    /* renamed from: e, reason: collision with root package name */
    private FrameLayout f58091e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f58092f;

    /* renamed from: h, reason: collision with root package name */
    private Context f58093h;

    /* renamed from: i, reason: collision with root package name */
    private QZoneFeedxLayerRecommendPhotoBean f58094i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QZoneFeedxLayerRecommendTitleView.this.f58093h instanceof Activity) {
                ((Activity) QZoneFeedxLayerRecommendTitleView.this.f58093h).onBackPressed();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QZoneFeedxLayerRecommendTitleView(Context context, QZoneFeedxLayerRecommendPhotoBean qZoneFeedxLayerRecommendPhotoBean) {
        super(context);
        this.f58093h = context;
        this.f58094i = qZoneFeedxLayerRecommendPhotoBean;
        p0(this);
    }

    private void n0() {
        ImageView imageView = this.f58092f;
        if (imageView == null) {
            return;
        }
        QZoneFeedxLayerRecommendPhotoBean qZoneFeedxLayerRecommendPhotoBean = this.f58094i;
        if (qZoneFeedxLayerRecommendPhotoBean != null && !qZoneFeedxLayerRecommendPhotoBean.isShowBackView) {
            imageView.setVisibility(8);
        } else {
            imageView.setOnClickListener(new a());
        }
    }

    private void o0() {
        FrameLayout frameLayout = this.f58091e;
        if (frameLayout != null && (frameLayout.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f58091e.getLayoutParams();
            layoutParams.topMargin = ar.n(this.f58093h);
            this.f58091e.setLayoutParams(layoutParams);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cfr;
    }

    private void p0(View view) {
        if (view == null) {
            return;
        }
        this.f58091e = (FrameLayout) view.findViewById(R.id.ex9);
        this.f58092f = (ImageView) view.findViewById(R.id.ex7);
        o0();
        n0();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
    }
}
