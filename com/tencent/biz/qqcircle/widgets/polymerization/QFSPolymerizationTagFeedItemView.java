package com.tencent.biz.qqcircle.widgets.polymerization;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBRepeatField;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StFeedShowReason;

/* loaded from: classes5.dex */
public class QFSPolymerizationTagFeedItemView extends QCircleBaseWidgetView<e30.b> {
    private ImageView C;
    private boolean D;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f93794d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f93795e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f93796f;

    /* renamed from: h, reason: collision with root package name */
    private String f93797h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f93798i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f93799m;

    public QFSPolymerizationTagFeedItemView(@NonNull Context context) {
        super(context);
        initView();
    }

    private void bindLabel() {
        FeedCloudMeta$StFeedShowReason feedCloudMeta$StFeedShowReason = getData().g().feedShowReason;
        if (feedCloudMeta$StFeedShowReason != null && !this.D) {
            int i3 = feedCloudMeta$StFeedShowReason.get().type.get();
            if (i3 != 1) {
                if (i3 != 2) {
                    this.f93798i.setVisibility(8);
                    return;
                } else {
                    this.f93798i.setVisibility(0);
                    this.f93798i.setImageDrawable(getContext().getResources().getDrawable(R.drawable.f162094ot4));
                    return;
                }
            }
            this.f93798i.setVisibility(0);
            this.f93798i.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ot5));
            return;
        }
        this.f93798i.setVisibility(8);
    }

    private void initImage() {
        if (TextUtils.equals(this.f93797h, getData().g().cover.picUrl.get())) {
            return;
        }
        FeedCloudMeta$StFeed g16 = getData().g();
        if (g16.type.get() == 3) {
            this.f93796f.setVisibility(8);
        } else if (g16.type.get() == 2) {
            this.f93796f.setVisibility(0);
        }
        this.f93794d.setImageDrawable(null);
        this.f93797h = g16.cover.picUrl.get();
        Option targetView = Option.obtain().setUrl(this.f93797h).setTargetView(this.f93794d);
        targetView.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
        targetView.setLoadingDrawable(new ColorDrawable(getResources().getColor(R.color.qvideo_skin_color_bg_default)));
        QCircleFeedPicLoader.g().loadImage(targetView);
    }

    private void k0(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        PBRepeatField<Integer> pBRepeatField;
        if (feedCloudMeta$StFeed != null && (pBRepeatField = feedCloudMeta$StFeed.opMask2) != null && pBRepeatField.get() != null) {
            this.D = feedCloudMeta$StFeed.opMask2.get().contains(30);
        }
    }

    private void l0(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        PBRepeatField<Integer> pBRepeatField;
        if (feedCloudMeta$StFeed != null && (pBRepeatField = feedCloudMeta$StFeed.opMask2) != null && pBRepeatField.get() != null) {
            boolean contains = feedCloudMeta$StFeed.opMask2.get().contains(32);
            boolean contains2 = feedCloudMeta$StFeed.opMask2.get().contains(33);
            boolean contains3 = feedCloudMeta$StFeed.opMask2.get().contains(34);
            if (contains) {
                this.f93799m.setImageDrawable(QCircleSkinHelper.getInstance().getDrawable(R.drawable.orj));
                updateLikeCount();
            } else if (contains2) {
                this.f93799m.setImageDrawable(QCircleSkinHelper.getInstance().getDrawable(R.drawable.oqr));
                o0();
            } else if (contains3) {
                this.f93799m.setImageDrawable(QCircleSkinHelper.getInstance().getDrawable(R.drawable.orp));
                n0();
            } else {
                this.f93799m.setImageDrawable(QCircleSkinHelper.getInstance().getDrawable(R.drawable.orj));
                updateLikeCount();
            }
        }
    }

    private void m0() {
        int i3;
        ImageView imageView = this.C;
        if (imageView == null) {
            return;
        }
        if (this.D) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    private void n0() {
        if (QCirclePushInfoManager.e().f(getData().g().f398449id.get()) == null) {
            return;
        }
        this.f93795e.setText(r.f(r0.totalClickCount.get()));
    }

    private void o0() {
        this.f93795e.setText(r.f(getData().g().visitorInfo.viewCount.get()));
    }

    private void updateLikeCount() {
        this.f93795e.setText(r.f(getData().g().likeInfo.count.get()));
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gnv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSPolymerizationTagFeedItemView";
    }

    protected void initView() {
        this.f93794d = (ImageView) findViewById(R.id.y2y);
        this.f93795e = (TextView) findViewById(R.id.f109666gf);
        this.f93796f = (ImageView) findViewById(R.id.y6u);
        this.f93798i = (ImageView) findViewById(R.id.yce);
        this.f93799m = (ImageView) findViewById(R.id.y56);
        this.C = (ImageView) findViewById(R.id.f54472fa);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        int c16 = cx.c(getContext()) / 3;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(c16, 1073741824), View.MeasureSpec.makeMeasureSpec((c16 * 4) / 3, 1073741824));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(e30.b bVar, int i3) {
        if (bVar == null || bVar.g() == null) {
            return;
        }
        FeedCloudMeta$StFeed g16 = bVar.g();
        l0(g16);
        k0(g16);
        m0();
        initImage();
        bindLabel();
    }
}
