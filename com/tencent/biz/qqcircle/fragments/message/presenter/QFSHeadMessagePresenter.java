package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.variation.HostChatUtils;
import com.tencent.biz.qqcircle.beans.QFSMessageItemInfo;
import com.tencent.biz.qqcircle.helpers.q;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.biz.qqcircle.richframework.widget.drag.DragTextView;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StNoticeCategory;
import java.util.Map;
import qqcircle.QQCircleCounterMsg$MergePsvRedPoint;

/* loaded from: classes4.dex */
public class QFSHeadMessagePresenter extends a implements View.OnClickListener {
    private static final int DELAY_DISMISS_RED_POINT = 200;
    private static final int KEY_CATEGORY_ID = -100;
    private static final int KEY_DRAG_TEXT_VIEW_ID = -101;
    private static final String TAG = "QFSHeadMessagePresenter";
    private ImageView mIvCommentAndAt;
    private ImageView mIvPraiseAndCollect;
    private ImageView mIvPush;
    private DragTextView mRedPointCommentAndAt;
    private DragTextView mRedPointPraiseAndCollect;
    private DragTextView mRedPointPush;
    private View mRlCommentAndAt;
    private View mRlPraiseAndCollect;
    private View mRlPush;

    public QFSHeadMessagePresenter(int i3) {
        super(i3);
    }

    private String getPicUrl(int i3) {
        Map<Integer, FeedCloudMeta$StNoticeCategory> map;
        FeedCloudMeta$StNoticeCategory feedCloudMeta$StNoticeCategory;
        FeedCloudMeta$StImage feedCloudMeta$StImage;
        QFSMessageItemInfo qFSMessageItemInfo = this.mItemInfo;
        if (qFSMessageItemInfo != null) {
            map = qFSMessageItemInfo.getHeadNoticeCategoryMap();
        } else {
            map = null;
        }
        if (map == null || map.isEmpty() || (feedCloudMeta$StNoticeCategory = map.get(Integer.valueOf(i3))) == null || (feedCloudMeta$StImage = feedCloudMeta$StNoticeCategory.icon) == null) {
            return "";
        }
        return feedCloudMeta$StImage.picUrl.get();
    }

    private void loadImage(ImageView imageView, String str) {
        String url = QCircleSkinHelper.getInstance().getUrl(str);
        int dimension = (int) this.mContext.getResources().getDimension(R.dimen.d2y);
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(url).setRequestWidth(dimension).setRequestHeight(dimension).setTargetView(imageView).setEnableAutoDeleteLocalCache(false));
    }

    private void loadImageView() {
        String picUrl = getPicUrl(1);
        String picUrl2 = getPicUrl(2);
        String picUrl3 = getPicUrl(3);
        ImageView imageView = this.mIvCommentAndAt;
        if (TextUtils.isEmpty(picUrl)) {
            picUrl = "qvideo_skin_icon_msgpage_services_comment_v2";
        }
        loadImage(imageView, picUrl);
        ImageView imageView2 = this.mIvPraiseAndCollect;
        if (TextUtils.isEmpty(picUrl2)) {
            picUrl2 = "qvideo_skin_icon_msgpage_services_like_v2";
        }
        loadImage(imageView2, picUrl2);
        ImageView imageView3 = this.mIvPush;
        if (TextUtils.isEmpty(picUrl3)) {
            picUrl3 = "qvideo_skin_icon_msgpage_services_rocket_v2";
        }
        loadImage(imageView3, picUrl3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportDT(QFSMessageItemInfo qFSMessageItemInfo, View view) {
        if (qFSMessageItemInfo == null) {
            return;
        }
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_PASSIVE_MSG_ENTRANCE);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_PRIVATE_LETTER, 0);
        int intValue = ((Integer) view.getTag(-100)).intValue();
        buildElementParams.put("xsj_msg_entrance_name_new", this.mItemInfo.getHeadNoticeCategoryMap().get(Integer.valueOf(intValue)).report_info.entrance_name.get());
        QQCircleCounterMsg$MergePsvRedPoint y16 = q.r().y(intValue);
        if (y16 == null) {
            y16 = new QQCircleCounterMsg$MergePsvRedPoint();
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_TYPE, Integer.valueOf(y16.type.get()));
        buildElementParams.put("xsj_reddot_number", Integer.valueOf(y16.num.get()));
        VideoReport.setElementParams(view, buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRedPoint(DragTextView dragTextView) {
        QQCircleCounterMsg$MergePsvRedPoint y16 = q.r().y(((Integer) dragTextView.getTag(-100)).intValue());
        if (y16 != null && y16.num.get() > 0) {
            dragTextView.setVisibility(0);
            dragTextView.setText(HostChatUtils.getMaxUnReadCountText(y16.num.get()));
        } else {
            dragTextView.setVisibility(8);
        }
    }

    private void setViewTag(View view, DragTextView dragTextView, int i3) {
        view.setTag(-100, Integer.valueOf(i3));
        dragTextView.setTag(-100, Integer.valueOf(i3));
        view.setTag(-101, dragTextView);
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    protected void bindCustomData(@NonNull final QFSMessageItemInfo qFSMessageItemInfo, int i3) {
        loadImageView();
        setRedPoint(this.mRedPointCommentAndAt);
        setRedPoint(this.mRedPointPraiseAndCollect);
        setRedPoint(this.mRedPointPush);
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.fragments.message.presenter.QFSHeadMessagePresenter.1
            @Override // java.lang.Runnable
            public void run() {
                QFSHeadMessagePresenter qFSHeadMessagePresenter = QFSHeadMessagePresenter.this;
                qFSHeadMessagePresenter.reportDT(qFSMessageItemInfo, qFSHeadMessagePresenter.mRlCommentAndAt);
                QFSHeadMessagePresenter qFSHeadMessagePresenter2 = QFSHeadMessagePresenter.this;
                qFSHeadMessagePresenter2.reportDT(qFSMessageItemInfo, qFSHeadMessagePresenter2.mRlPraiseAndCollect);
                QFSHeadMessagePresenter qFSHeadMessagePresenter3 = QFSHeadMessagePresenter.this;
                qFSHeadMessagePresenter3.reportDT(qFSMessageItemInfo, qFSHeadMessagePresenter3.mRlPush);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    public String getLogTag() {
        return TAG;
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    protected void initClickListener() {
        this.mRlCommentAndAt.setOnClickListener(this);
        this.mRlPraiseAndCollect.setOnClickListener(this);
        this.mRlPush.setOnClickListener(this);
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    protected void initCustomView(Context context, @NonNull View view) {
        this.mRlCommentAndAt = view.findViewById(R.id.f75413yw);
        this.mRlPraiseAndCollect = view.findViewById(R.id.f7587405);
        this.mRlPush = view.findViewById(R.id.f7588406);
        this.mRedPointCommentAndAt = (DragTextView) this.mRlCommentAndAt.findViewById(R.id.f110576iw);
        this.mRedPointPraiseAndCollect = (DragTextView) this.mRlPraiseAndCollect.findViewById(R.id.f110576iw);
        this.mRedPointPush = (DragTextView) this.mRlPush.findViewById(R.id.f110576iw);
        this.mIvCommentAndAt = (ImageView) view.findViewById(R.id.y1r);
        this.mIvPraiseAndCollect = (ImageView) view.findViewById(R.id.f165957y74);
        this.mIvPush = (ImageView) view.findViewById(R.id.y7c);
        setViewTag(this.mRlCommentAndAt, this.mRedPointCommentAndAt, 1);
        setViewTag(this.mRlPraiseAndCollect, this.mRedPointPraiseAndCollect, 2);
        setViewTag(this.mRlPush, this.mRedPointPush, 3);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(final View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!FastClickUtils.isFastDoubleClick(TAG)) {
            QFSMessageItemInfo qFSMessageItemInfo = this.mItemInfo;
            if (qFSMessageItemInfo == null) {
                QLog.e(getLogTag(), 1, "onClick mItemInfo is null");
            } else {
                Map<Integer, FeedCloudMeta$StNoticeCategory> headNoticeCategoryMap = qFSMessageItemInfo.getHeadNoticeCategoryMap();
                if (headNoticeCategoryMap != null && !headNoticeCategoryMap.isEmpty()) {
                    final int intValue = ((Integer) view.getTag(-100)).intValue();
                    FeedCloudMeta$StNoticeCategory feedCloudMeta$StNoticeCategory = headNoticeCategoryMap.get(Integer.valueOf(intValue));
                    if (feedCloudMeta$StNoticeCategory == null) {
                        QLog.e(getLogTag(), 1, "onClick category is null, id = " + intValue);
                    } else {
                        QLog.d(getLogTag(), 1, "onClick category id = " + intValue + ", url = " + feedCloudMeta$StNoticeCategory.jump_url.get());
                        QCircleSchemeLauncher.f(view.getContext(), feedCloudMeta$StNoticeCategory.jump_url.get());
                        RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.tencent.biz.qqcircle.fragments.message.presenter.QFSHeadMessagePresenter.2
                            @Override // java.lang.Runnable
                            public void run() {
                                q.r().O(intValue);
                                QFSHeadMessagePresenter.this.setRedPoint((DragTextView) view.getTag(-101));
                            }
                        }, 200L);
                    }
                } else {
                    QLog.e(getLogTag(), 1, "onClick categoryMap is null or empty");
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
