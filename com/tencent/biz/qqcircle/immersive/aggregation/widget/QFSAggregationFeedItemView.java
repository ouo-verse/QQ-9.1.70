package com.tencent.biz.qqcircle.immersive.aggregation.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import e30.b;
import feedcloud.FeedCloudMeta$StFeed;
import w20.a;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSAggregationFeedItemView extends QCircleBaseWidgetView<b> implements Observer<b> {

    /* renamed from: d, reason: collision with root package name */
    private final ImageView f84784d;

    /* renamed from: e, reason: collision with root package name */
    private final TextView f84785e;

    /* renamed from: f, reason: collision with root package name */
    private final ImageView f84786f;

    /* renamed from: h, reason: collision with root package name */
    private String f84787h;

    public QFSAggregationFeedItemView(@NonNull Context context) {
        super(context);
        this.f84784d = (ImageView) findViewById(R.id.y2y);
        this.f84785e = (TextView) findViewById(R.id.f109666gf);
        this.f84786f = (ImageView) findViewById(R.id.y6u);
    }

    private void initImage() {
        int i3;
        if (TextUtils.equals(this.f84787h, getData().g().cover.picUrl.get())) {
            return;
        }
        this.f84784d.setImageDrawable(null);
        this.f84787h = getData().g().cover.picUrl.get();
        Option targetView = Option.obtain().setUrl(this.f84787h).setTargetView(this.f84784d);
        targetView.setLoadingDrawable(new ColorDrawable(getResources().getColor(R.color.qvideo_skin_color_bg_default)));
        QCircleFeedPicLoader.g().loadImage(targetView);
        ImageView imageView = this.f84786f;
        if (getData().g().type.get() == 2) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    private void l0(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.f84785e.setText(r.f(feedCloudMeta$StFeed.likeInfo.count.get()));
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g7g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSAggregationFeedItemView";
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onChanged(b bVar) {
        if (bVar != null && bVar.g() != null) {
            l0(bVar.g());
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(i3) * 4) / 3, 1073741824));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(b bVar, int i3) {
        if (bVar == null || bVar.g() == null) {
            return;
        }
        initImage();
        l0(bVar.g());
        a.j().observerGlobalState(bVar, this);
    }
}
