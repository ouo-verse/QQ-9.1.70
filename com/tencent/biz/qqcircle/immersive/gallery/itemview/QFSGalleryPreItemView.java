package com.tencent.biz.qqcircle.immersive.gallery.itemview;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StImage;
import java.util.Map;

/* loaded from: classes4.dex */
public class QFSGalleryPreItemView extends QCircleBaseWidgetView<FeedCloudMeta$StImage> {

    /* renamed from: d, reason: collision with root package name */
    private RoundCornerImageView f86440d;

    public QFSGalleryPreItemView(@NonNull Context context) {
        super(context);
        n0(this);
    }

    private void l0(int i3) {
        VideoReport.setElementId(this.f86440d, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_PICTURE);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_index", Integer.valueOf(i3 + 1));
        VideoReport.setElementParams(this.f86440d, buildElementParams);
        VideoReport.setElementExposePolicy(this.f86440d, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(this.f86440d, EndExposurePolicy.REPORT_ALL);
        VideoReport.traverseExposure();
    }

    private void n0(View view) {
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) view.findViewById(R.id.f43101lk);
        this.f86440d = roundCornerImageView;
        roundCornerImageView.setCorner(ViewUtils.dpToPx(4.0f));
        this.f86440d.setColor(-1);
        this.f86440d.setBorderWidth(ViewUtils.dpToPx(2.0f));
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gcw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSGalleryRecommendTagFeedItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(FeedCloudMeta$StImage feedCloudMeta$StImage, int i3) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f86440d.getLayoutParams();
        layoutParams.width = ViewUtils.dpToPx(33.0f);
        layoutParams.leftMargin = ViewUtils.dpToPx(2.0f);
        layoutParams.rightMargin = ViewUtils.dpToPx(2.0f);
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(feedCloudMeta$StImage.picUrl.get()).setRequestWidth(ViewUtils.dpToPx(33.0f)).setRequestHeight(ViewUtils.dpToPx(44.0f)).setTargetView(this.f86440d));
        l0(i3);
    }

    public ImageView m0() {
        return this.f86440d;
    }

    public void o0() {
        RoundCornerImageView roundCornerImageView = this.f86440d;
        if (roundCornerImageView != null) {
            roundCornerImageView.setBorder(true);
            this.f86440d.invalidate();
        }
    }

    public void p0() {
        RoundCornerImageView roundCornerImageView = this.f86440d;
        if (roundCornerImageView != null) {
            roundCornerImageView.setBorder(false);
            this.f86440d.invalidate();
        }
    }
}
