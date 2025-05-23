package com.tencent.biz.qqcircle.widgets.feed;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import e30.b;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StFeedShowReason;

/* loaded from: classes5.dex */
public class QFSPolymerizationFeedItemView extends QCircleBaseWidgetView<b> {
    private static final String TAG = "QFSPolymerizationFeedItemView";
    private String mFeedCoverUrl;
    private ImageView mIvFeed;
    private ImageView mIvPicIcon;
    private ImageView mLabelIcon;
    private TextView mTvNum;

    public QFSPolymerizationFeedItemView(@NonNull Context context) {
        super(context);
        initView();
    }

    private void bindLabel() {
        FeedCloudMeta$StFeedShowReason feedCloudMeta$StFeedShowReason = getData().g().feedShowReason;
        if (feedCloudMeta$StFeedShowReason == null) {
            this.mLabelIcon.setVisibility(8);
            return;
        }
        int i3 = feedCloudMeta$StFeedShowReason.get().type.get();
        if (i3 != 1) {
            if (i3 != 2) {
                this.mLabelIcon.setVisibility(8);
                return;
            } else {
                this.mLabelIcon.setVisibility(0);
                this.mLabelIcon.setImageDrawable(getContext().getResources().getDrawable(R.drawable.f162094ot4));
                return;
            }
        }
        this.mLabelIcon.setVisibility(0);
        this.mLabelIcon.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ot5));
    }

    private void initImage() {
        if (TextUtils.equals(this.mFeedCoverUrl, getData().g().cover.picUrl.get())) {
            return;
        }
        FeedCloudMeta$StFeed g16 = getData().g();
        if (g16.type.get() == 3) {
            this.mIvPicIcon.setVisibility(8);
        } else if (g16.type.get() == 2) {
            this.mIvPicIcon.setVisibility(0);
        }
        this.mIvFeed.setImageDrawable(null);
        this.mFeedCoverUrl = g16.cover.picUrl.get();
        Option targetView = Option.obtain().setUrl(this.mFeedCoverUrl).setTargetView(this.mIvFeed);
        targetView.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
        targetView.setLoadingDrawable(new ColorDrawable(getResources().getColor(R.color.qvideo_skin_color_bg_default)));
        QCircleFeedPicLoader.g().loadImage(targetView);
    }

    private void updateLikeCount() {
        this.mTvNum.setText(r.f(getData().g().likeInfo.count.get()));
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gnp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return TAG;
    }

    protected void initView() {
        this.mIvFeed = (ImageView) findViewById(R.id.y2y);
        this.mTvNum = (TextView) findViewById(R.id.f109666gf);
        this.mIvPicIcon = (ImageView) findViewById(R.id.y6u);
        this.mLabelIcon = (ImageView) findViewById(R.id.yce);
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
        updateLikeCount();
        bindLabel();
    }
}
