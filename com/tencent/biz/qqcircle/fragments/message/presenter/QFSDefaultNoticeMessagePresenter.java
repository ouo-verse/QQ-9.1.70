package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QFSMessageItemInfo;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleRoundImageView;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StNotice;
import feedcloud.FeedCloudMeta$StOperation;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StLikeBusiData;

/* loaded from: classes4.dex */
public class QFSDefaultNoticeMessagePresenter extends QFSBaseNoticeMessagePresenter {
    public static final String TAG = "QFSDefaultNoticeMessagePresenter";
    private ViewStub mFeedCoverViewStub;
    protected View mFlCoverContainer;
    protected QCircleRoundImageView mIvCover;
    protected ImageView mIvVideoIcon;

    public QFSDefaultNoticeMessagePresenter(int i3) {
        super(i3);
    }

    private void initCover(FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        String str;
        ViewStub viewStub;
        if (TextUtils.isEmpty(feedCloudMeta$StNotice.feed.cover.picUrl.get())) {
            return;
        }
        if (this.mFlCoverContainer == null && (viewStub = this.mFeedCoverViewStub) != null) {
            this.mFlCoverContainer = viewStub.inflate();
        }
        View view = this.mFlCoverContainer;
        if (view == null) {
            return;
        }
        this.mIvCover = (QCircleRoundImageView) view.findViewById(R.id.lnn);
        this.mIvVideoIcon = (ImageView) this.mFlCoverContainer.findViewById(R.id.y2z);
        int i3 = 0;
        this.mFlCoverContainer.setVisibility(0);
        this.mIvCover.setRoundRect(cx.a(4.0f));
        if (this.mIvCover.getTag(R.id.f31710rs) instanceof String) {
            str = (String) this.mIvCover.getTag(R.id.f31710rs);
        } else {
            str = "";
        }
        String str2 = feedCloudMeta$StNotice.feed.cover.picUrl.get();
        this.mIvCover.setTag(R.id.f31710rs, str2);
        if (!str.equals(str2)) {
            Option requestHeight = Option.obtain().setUrl(str2).setTargetView(this.mIvCover).setFromPreLoad(false).setPredecode(true).setSupportRecycler(true).setRequestWidth(this.mIvCover.getWidth()).setRequestHeight(this.mIvCover.getHeight());
            requestHeight.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
            QCircleFeedPicLoader.g().loadImage(requestHeight);
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.fragments.message.presenter.QFSDefaultNoticeMessagePresenter.1
            @Override // java.lang.Runnable
            public void run() {
                VideoReport.setElementId(QFSDefaultNoticeMessagePresenter.this.mFlCoverContainer, QCircleDaTongConstant.ElementId.EM_XSJ_FEED_THUMBNAIL);
                QFSDefaultNoticeMessagePresenter qFSDefaultNoticeMessagePresenter = QFSDefaultNoticeMessagePresenter.this;
                VideoReport.setElementParams(qFSDefaultNoticeMessagePresenter.mFlCoverContainer, qFSDefaultNoticeMessagePresenter.getDtReportSubViewParams());
            }
        });
        ImageView imageView = this.mIvVideoIcon;
        if (!QCirclePluginUtil.isVideoFeed(feedCloudMeta$StNotice.feed)) {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        this.mFlCoverContainer.setOnClickListener(getCoverClickListener());
        this.mFlCoverContainer.setOnLongClickListener(this.mOnItemLongClickListener);
        setTouchLister(this.mFlCoverContainer);
        setCoverDtReportConfig(this.mFlCoverContainer, feedCloudMeta$StNotice.operation.opUser.f398463id.get(), feedCloudMeta$StNotice.feed.f398449id.get(), feedCloudMeta$StNotice.feed.poster.f398463id.get());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    @CallSuper
    public void bindCustomData(@NonNull QFSMessageItemInfo qFSMessageItemInfo, int i3) {
        super.bindCustomData(qFSMessageItemInfo, i3);
        initCover(qFSMessageItemInfo.getStNotice());
    }

    protected View.OnClickListener getCoverClickListener() {
        return getContainerClickListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter
    public QCircleLayerBean getDefaultContentDetailAttrs(View view) {
        QCircleLayerBean defaultContentDetailAttrs;
        boolean z16;
        try {
            if (this.mItemInfo.getStNotice().feed.get() == null || (defaultContentDetailAttrs = super.getDefaultContentDetailAttrs(view)) == null) {
                return null;
            }
            if (view.getId() == R.id.f165924y30) {
                z16 = true;
            } else {
                z16 = false;
            }
            initOtherQCircleBean(defaultContentDetailAttrs, z16);
            QCircleRoundImageView qCircleRoundImageView = this.mIvCover;
            if (qCircleRoundImageView != null) {
                int[] iArr = new int[2];
                qCircleRoundImageView.getLocationInWindow(iArr);
                QFSTransitionAnimBean qFSTransitionAnimBean = new QFSTransitionAnimBean();
                int i3 = iArr[0];
                defaultContentDetailAttrs.setTransitionAnimBean(qFSTransitionAnimBean.setLayoutRect(new QFSTransitionAnimBean.SourceRect(i3, iArr[1], this.mIvCover.getWidth() + i3, iArr[1] + this.mIvCover.getHeight())).setScaleType(ImageView.ScaleType.CENTER_CROP).setImageUrl(this.mItemInfo.getStNotice().feed.cover.picUrl.get()));
                defaultContentDetailAttrs.getTransitionAnimBean().setCoverDrawable(this.mIvCover.getDrawable());
            }
            return defaultContentDetailAttrs;
        } catch (Exception e16) {
            QLog.e(getLogTag(), 1, "jumpDetailPageError:" + e16.getMessage());
            e16.printStackTrace();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    public String getLogTag() {
        return TAG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    public void initCustomView(Context context, @NonNull View view) {
        super.initCustomView(context, view);
        this.mFeedCoverViewStub = (ViewStub) view.findViewById(R.id.f33040vd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initOtherQCircleBean(QCircleInitBean qCircleInitBean, boolean z16) {
        QFSMessageItemInfo qFSMessageItemInfo = this.mItemInfo;
        if (qFSMessageItemInfo != null && qFSMessageItemInfo.getStNotice() != null && this.mItemInfo.getStNotice().operation != null) {
            FeedCloudMeta$StOperation feedCloudMeta$StOperation = this.mItemInfo.getStNotice().operation;
            if (this.mViewType == 13 && feedCloudMeta$StOperation.like != null) {
                QQCircleFeedBase$StLikeBusiData qQCircleFeedBase$StLikeBusiData = new QQCircleFeedBase$StLikeBusiData();
                try {
                    qQCircleFeedBase$StLikeBusiData.mergeFrom(feedCloudMeta$StOperation.like.busiData.get().toByteArray());
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                }
                qCircleInitBean.setPolyLike(qQCircleFeedBase$StLikeBusiData.curPolyLikeInfo.get());
                QLog.d(getLogTag(), 1, "fullscreen url" + qQCircleFeedBase$StLikeBusiData.curPolyLikeInfo.fullScreenURLAND.get());
            }
        }
    }

    protected void setCoverDtReportConfig(View view, String str, String str2, String str3) {
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_FEED_THUMBNAIL);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FROM_UIN, str);
        buildElementParams.put("xsj_feed_id", str2);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, str3);
        VideoReport.setElementParams(view, buildElementParams);
    }
}
