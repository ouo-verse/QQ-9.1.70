package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleLikeBean;
import com.tencent.biz.qqcircle.beans.QFSMessageItemInfo;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$BytesEntry;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class QFSNewJoinMessagePresenter extends QFSBaseNoticeMessagePresenter {
    private static final String TAG = "QFSNewJoinMessagePresenter";
    protected View.OnClickListener mContainerClickListener;
    protected View mFlButtonContainer;
    private ViewStub mMessageBtnViewStub;
    protected TextView mTvRightBtnView;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSNewJoinMessagePresenter.this.consumeItemNewFlag();
            if (QFSNewJoinMessagePresenter.this.mItemInfo.getStNotice() != null) {
                int i3 = 0;
                long j3 = 0;
                if (QFSNewJoinMessagePresenter.this.mItemInfo.getNoticeBusiData() != null && QFSNewJoinMessagePresenter.this.mItemInfo.getNoticeBusiData().busiInfo.get() != null) {
                    try {
                        i3 = Integer.parseInt(QCirclePluginUtil.getValueFromListEntry(QFSNewJoinMessagePresenter.this.mItemInfo.getNoticeBusiData().busiInfo.get(), "unread_like_count", "0"));
                        j3 = Long.parseLong(QCirclePluginUtil.getValueFromListEntry(QFSNewJoinMessagePresenter.this.mItemInfo.getNoticeBusiData().busiInfo.get(), "last_like_time", "0"));
                    } catch (Exception e16) {
                        QLog.e(QFSNewJoinMessagePresenter.TAG, 1, e16.toString());
                    }
                }
                QCircleLikeBean qCircleLikeBean = new QCircleLikeBean();
                qCircleLikeBean.setFeed(QFSNewJoinMessagePresenter.this.mItemInfo.getStNotice().feed);
                qCircleLikeBean.setRequestType(23);
                qCircleLikeBean.setNoticeType(QFSNewJoinMessagePresenter.this.mViewType);
                qCircleLikeBean.setCount(i3);
                qCircleLikeBean.setTime(j3);
                qCircleLikeBean.setFromReportBean(QFSNewJoinMessagePresenter.this.getReportBean().m466clone());
                qCircleLikeBean.setBusiTranparentList(QFSNewJoinMessagePresenter.this.getBizTransparentData());
                com.tencent.biz.qqcircle.launcher.c.R(view.getContext(), qCircleLikeBean);
                QFSNewJoinMessagePresenter.this.reportClickEvent(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QFSNewJoinMessagePresenter(int i3) {
        super(i3);
    }

    private void dpReportConfig() {
        TextView textView = this.mTvRightBtnView;
        if (textView == null) {
            return;
        }
        VideoReport.setElementId(textView, QCircleDaTongConstant.ElementId.EM_XSJ_MSG_FEATURE_BUTTON);
        VideoReport.setElementParams(this.mTvRightBtnView, new QCircleDTParamBuilder().buildElementParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<byte[]> getBizTransparentData() {
        ArrayList<byte[]> arrayList = new ArrayList<>();
        if (this.mItemInfo.getStNotice().get() != null && this.mItemInfo.getStNotice().operation.get() != null && this.mItemInfo.getStNotice().operation.busiTranparent.get() != null) {
            Iterator<FeedCloudCommon$BytesEntry> it = this.mItemInfo.getStNotice().operation.busiTranparent.get().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toByteArray());
            }
        }
        return arrayList;
    }

    private void initArrowView() {
        this.mIvRightArrowLine1.setVisibility(8);
        this.mRightArrow.setVisibility(8);
    }

    private void initBtnView() {
        ViewStub viewStub;
        if (this.mFlButtonContainer == null && (viewStub = this.mMessageBtnViewStub) != null) {
            this.mFlButtonContainer = viewStub.inflate();
        }
        View view = this.mFlButtonContainer;
        if (view == null) {
            return;
        }
        view.setVisibility(0);
        TextView textView = (TextView) this.mFlButtonContainer.findViewById(R.id.f109316fh);
        this.mTvRightBtnView = textView;
        textView.setVisibility(0);
        this.mTvRightBtnView.setText(R.string.f184103kz);
        this.mTvRightBtnView.setOnClickListener(getLikeViewClickListener());
        dpReportConfig();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    public void bindCustomData(@NonNull QFSMessageItemInfo qFSMessageItemInfo, int i3) {
        super.bindCustomData(qFSMessageItemInfo, i3);
        initArrowView();
        initBtnView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter
    public View.OnClickListener getLikeViewClickListener() {
        View.OnClickListener onClickListener = this.mContainerClickListener;
        if (onClickListener != null) {
            return onClickListener;
        }
        a aVar = new a();
        this.mContainerClickListener = aVar;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    public String getLogTag() {
        return TAG;
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    protected void initClickListener() {
        View view = this.mContainer;
        if (view != null) {
            view.setOnClickListener(getLikeViewClickListener());
            this.mContainer.setOnLongClickListener(this.mOnItemLongClickListener);
        }
        TextView textView = this.mTvNick;
        if (textView != null) {
            textView.setOnClickListener(getLikeViewClickListener());
            this.mTvNick.setOnLongClickListener(this.mOnItemLongClickListener);
        }
        QCircleAsyncTextView qCircleAsyncTextView = this.mTvMessage;
        if (qCircleAsyncTextView != null) {
            qCircleAsyncTextView.setOnClickListener(getLikeViewClickListener());
            this.mTvMessage.setOnLongClickListener(this.mOnItemLongClickListener);
        }
        QCircleAsyncTextView qCircleAsyncTextView2 = this.mSubMessage;
        if (qCircleAsyncTextView2 != null) {
            qCircleAsyncTextView2.setOnClickListener(getLikeViewClickListener());
            this.mSubMessage.setOnLongClickListener(this.mOnItemLongClickListener);
        }
        QCircleAsyncTextView qCircleAsyncTextView3 = this.mSummery;
        if (qCircleAsyncTextView3 != null) {
            qCircleAsyncTextView3.setOnClickListener(getLikeViewClickListener());
            this.mSummery.setOnLongClickListener(this.mOnItemLongClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    public void initCustomView(Context context, @NonNull View view) {
        super.initCustomView(context, view);
        this.mMessageBtnViewStub = (ViewStub) view.findViewById(R.id.f33060vf);
    }
}
