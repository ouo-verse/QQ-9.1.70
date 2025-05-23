package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.utils.QFSMessageAvatarWrapper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes4.dex */
public class QFSPositiveFeedbackMessagePresenter extends QFSDiffTimeNoticeMessagePresenter {
    private static final String TAG = "QFSPositiveFeedbackMessagePresenter";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f84496d;

        a(String str) {
            this.f84496d = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSPositiveFeedbackMessagePresenter.this.consumeItemNewFlag();
            if (TextUtils.isEmpty(this.f84496d)) {
                QLog.i(QFSPositiveFeedbackMessagePresenter.TAG, 1, "[getClickListener] jumpUrl == null");
            } else {
                com.tencent.biz.qqcircle.launcher.c.j(view.getContext(), this.f84496d, true);
                QFSPositiveFeedbackMessagePresenter.this.reportClickEvent(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QFSPositiveFeedbackMessagePresenter(int i3) {
        super(i3);
    }

    private View.OnClickListener getClickListener(String str) {
        return new a(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSDiffTimeNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.QFSTopReplayMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.QFSDefaultNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    public String getLogTag() {
        return TAG;
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    protected void initClickListener() {
        String str = this.mItemInfo.getStNotice().operation.opUser.get().jumpUrl.get();
        String d16 = com.tencent.biz.qqcircle.d.d(this.mItemInfo.getNoticeBusiData().urlInfo.get(), "noticeMessageJumpUrl");
        String d17 = com.tencent.biz.qqcircle.d.d(this.mItemInfo.getNoticeBusiData().urlInfo.get(), "noticeCoverJumpUrl");
        QFSMessageAvatarWrapper qFSMessageAvatarWrapper = this.mAvatarWrap;
        if (qFSMessageAvatarWrapper != null) {
            qFSMessageAvatarWrapper.q(getClickListener(str));
        } else {
            QLog.e(getLogTag(), 1, "initClickListener mAvatarWrap is null");
        }
        this.mTvNick.setOnClickListener(getClickListener(str));
        this.mTvMessage.setOnClickListener(getClickListener(d16));
        this.mFlCoverContainer.setOnClickListener(getClickListener(d17));
        this.mContainer.setOnClickListener(getClickListener(d16));
        this.mTvNick.setOnLongClickListener(this.mOnItemLongClickListener);
        this.mTvMessage.setOnLongClickListener(this.mOnItemLongClickListener);
        this.mFlCoverContainer.setOnLongClickListener(this.mOnItemLongClickListener);
        this.mContainer.setOnLongClickListener(this.mOnItemLongClickListener);
    }
}
