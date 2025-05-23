package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.variation.HostChatUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleLikeBean;
import com.tencent.biz.qqcircle.beans.QFSMessageItemInfo;
import com.tencent.biz.qqcircle.utils.QFSMessageAvatarWrapper;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.libra.request.Option;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$BytesEntry;
import feedcloud.FeedCloudMeta$StNotice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import qqcircle.QQCircleFeedBase$StNoticeBusiData;

/* loaded from: classes4.dex */
public class QFSUrgeUpdateMessagePresenter extends QFSBaseNormalMessagePresenter {
    private static final String TAG = "QFSUrgeUpdateMessagePresenter";

    /* loaded from: classes4.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSUrgeUpdateMessagePresenter qFSUrgeUpdateMessagePresenter = QFSUrgeUpdateMessagePresenter.this;
            QFSMessageItemInfo qFSMessageItemInfo = qFSUrgeUpdateMessagePresenter.mItemInfo;
            if (qFSMessageItemInfo == null) {
                QLog.e(qFSUrgeUpdateMessagePresenter.getLogTag(), 1, "container click: mItemInfo is null");
            } else {
                QQCircleFeedBase$StNoticeBusiData noticeBusiData = qFSMessageItemInfo.getNoticeBusiData();
                int i3 = 0;
                long j3 = 0;
                if (noticeBusiData != null && noticeBusiData.busiInfo.get() != null) {
                    try {
                        i3 = Integer.parseInt(QCirclePluginUtil.getValueFromListEntry(noticeBusiData.busiInfo.get(), "unread_like_count", "0"));
                        j3 = Long.parseLong(QCirclePluginUtil.getValueFromListEntry(noticeBusiData.busiInfo.get(), "last_like_time", "0"));
                    } catch (Exception e16) {
                        QLog.e(QFSUrgeUpdateMessagePresenter.this.getLogTag(), 1, e16.toString());
                    }
                }
                QCircleLikeBean qCircleLikeBean = new QCircleLikeBean();
                qCircleLikeBean.setRequestType(QFSUrgeUpdateMessagePresenter.this.mViewType);
                qCircleLikeBean.setNoticeType(QFSUrgeUpdateMessagePresenter.this.mViewType);
                qCircleLikeBean.setCount(i3);
                qCircleLikeBean.setTime(j3);
                qCircleLikeBean.setFromReportBean(QFSUrgeUpdateMessagePresenter.this.getReportBean().m466clone());
                FeedCloudMeta$StNotice stNotice = QFSUrgeUpdateMessagePresenter.this.mItemInfo.getStNotice();
                if (stNotice != null && stNotice.operation != null) {
                    qCircleLikeBean.setFeed(stNotice.feed);
                    ArrayList arrayList = new ArrayList();
                    Iterator<FeedCloudCommon$BytesEntry> it = stNotice.operation.busiTranparent.get().iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().toByteArray());
                    }
                    qCircleLikeBean.setBusiTranparentList(arrayList);
                    HashMap<String, String> hashMap = new HashMap<>(2);
                    hashMap.put("jump_url", stNotice.operation.jumpUrl.get());
                    if (noticeBusiData != null) {
                        String valueFromListEntry = QCirclePluginUtil.getValueFromListEntry(noticeBusiData.busiInfo.get(), "urgeCount", "");
                        QLog.i(QFSUrgeUpdateMessagePresenter.TAG, 1, "containerClick userCount = " + valueFromListEntry);
                        hashMap.put(QCircleSchemeAttr.MessageList.COUNT, valueFromListEntry);
                    }
                    qCircleLikeBean.setSchemeAttrs(hashMap);
                }
                com.tencent.biz.qqcircle.launcher.c.B0(view.getContext(), qCircleLikeBean);
                QFSUrgeUpdateMessagePresenter.this.removeRedPoint();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QFSUrgeUpdateMessagePresenter(int i3) {
        super(i3);
    }

    private void adjustMessageLayout(final boolean z16) {
        LinearLayout linearLayout = this.mRightContainer;
        if (linearLayout == null) {
            QLog.e(getLogTag(), 1, "adjustMessageLayout rightContainer is null");
        } else {
            linearLayout.post(new Runnable() { // from class: com.tencent.biz.qqcircle.fragments.message.presenter.QFSUrgeUpdateMessagePresenter.1
                @Override // java.lang.Runnable
                public void run() {
                    int i3;
                    QFSUrgeUpdateMessagePresenter qFSUrgeUpdateMessagePresenter = QFSUrgeUpdateMessagePresenter.this;
                    LinearLayout linearLayout2 = qFSUrgeUpdateMessagePresenter.mMessageContainer;
                    if (linearLayout2 != null && qFSUrgeUpdateMessagePresenter.mRightContainer != null) {
                        if (linearLayout2.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) QFSUrgeUpdateMessagePresenter.this.mMessageContainer.getLayoutParams();
                            if (z16) {
                                i3 = QFSUrgeUpdateMessagePresenter.this.mRightContainer.getWidth();
                            } else {
                                i3 = 0;
                            }
                            layoutParams.rightMargin = i3;
                            QFSUrgeUpdateMessagePresenter.this.mMessageContainer.setLayoutParams(layoutParams);
                            QFSUrgeUpdateMessagePresenter.this.mMessageContainer.requestLayout();
                            return;
                        }
                        return;
                    }
                    QLog.e(qFSUrgeUpdateMessagePresenter.getLogTag(), 1, "adjustMessageLayout container is null, isShowRightView = " + z16);
                }
            });
        }
    }

    private void setLeftIconView(@NonNull FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        if (!feedCloudMeta$StNotice.operation.has()) {
            QLog.e(getLogTag(), 1, "setAvatarOrLeftIconView not has operation");
            return;
        }
        QFSMessageAvatarWrapper qFSMessageAvatarWrapper = this.mAvatarWrap;
        if (qFSMessageAvatarWrapper != null && this.mIvIcon != null) {
            qFSMessageAvatarWrapper.r(8);
            this.mIvIcon.setVisibility(0);
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(QCircleSkinHelper.getInstance().getUrl(feedCloudMeta$StNotice.operation.opUser.icon.iconUrl.get())).setTargetView(this.mIvIcon).setRequestWidth(this.mDefAvatarSize.getWidth()).setRequestHeight(this.mDefAvatarSize.getHeight()).setEnableAutoDeleteLocalCache(false));
            return;
        }
        QLog.e(getLogTag(), 1, "setLeftIconView view is null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNormalMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    public void bindCustomData(@NonNull QFSMessageItemInfo qFSMessageItemInfo, int i3) {
        super.bindCustomData(qFSMessageItemInfo, i3);
        if (qFSMessageItemInfo.getStNotice() != null) {
            setLeftIconView(qFSMessageItemInfo.getStNotice());
        }
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNormalMessagePresenter
    protected View.OnClickListener getContainerClickListener() {
        if (this.mContainerClickListener == null) {
            this.mContainerClickListener = new a();
        }
        return this.mContainerClickListener;
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNormalMessagePresenter
    protected String getElementId() {
        return QCircleDaTongConstant.ElementId.EM_XSJ_PASSIVE_MSG_ENTRANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNormalMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    public String getLogTag() {
        return TAG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNormalMessagePresenter
    public void setMessageView(@NonNull FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        QCircleAsyncTextView qCircleAsyncTextView = this.mTvMessage;
        if (qCircleAsyncTextView != null && this.mTvMessageCount != null) {
            if (this.mItemInfo == null) {
                QLog.e(getLogTag(), 1, "setMessageView mItemInfo is null");
                return;
            }
            qCircleAsyncTextView.setSingleLine(true);
            this.mTvMessage.setText(feedCloudMeta$StNotice.message.get());
            String valueFromListEntry = QCirclePluginUtil.getValueFromListEntry(this.mItemInfo.getNoticeBusiData().busiInfo.get(), "noticeVisitorCountMessage", "");
            String valueFromListEntry2 = QCirclePluginUtil.getValueFromListEntry(this.mItemInfo.getNoticeBusiData().busiInfo.get(), "urgeCount", "");
            try {
                valueFromListEntry2 = HostChatUtils.getMaxUnReadCountText(Integer.parseInt(valueFromListEntry2));
            } catch (Exception e16) {
                QLog.e(getLogTag(), 1, "getUserCount:" + e16.getMessage());
            }
            String replace = valueFromListEntry.replace("*", valueFromListEntry2);
            if (!TextUtils.isEmpty(replace)) {
                this.mTvMessageCount.setText(replace);
                return;
            }
            return;
        }
        QLog.e(getLogTag(), 1, "setMessageView message view is null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNormalMessagePresenter
    public boolean setRightView(@NonNull FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        boolean rightView = super.setRightView(feedCloudMeta$StNotice);
        adjustMessageLayout(rightView);
        return rightView;
    }
}
