package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import feedcloud.FeedCloudMeta$StNotice;

/* loaded from: classes4.dex */
public class QFSNumNoticeMessagePresenter extends QFSDiffTimeNoticeMessagePresenter {
    private static final String KEY_NUM_IN_MESSAGE = "num_in_message";
    private static final String TAG = "QFSNumNoticeMessagePresenter";

    public QFSNumNoticeMessagePresenter(int i3) {
        super(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSDiffTimeNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.QFSTopReplayMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.QFSDefaultNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    public String getLogTag() {
        return TAG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSDiffTimeNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter
    public void setContent(FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        String str = feedCloudMeta$StNotice.message.get();
        if (TextUtils.isEmpty(str)) {
            this.mMessageContainer.setVisibility(8);
            return;
        }
        reportImpEvent(this.mTvMessage);
        this.mMessageContainer.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str.replace("*", QCirclePluginUtil.getValueFromListEntry(this.mItemInfo.getNoticeBusiData().busiInfo.get(), KEY_NUM_IN_MESSAGE, "")));
        appendMessageTimeText(spannableStringBuilder, feedCloudMeta$StNotice);
        this.mTvMessage.setMinimumWidth(QFSBaseNoticeMessagePresenter.MESSAGE_VIEW_MIN_WIDTH);
        this.mTvMessage.setText(spannableStringBuilder);
    }
}
