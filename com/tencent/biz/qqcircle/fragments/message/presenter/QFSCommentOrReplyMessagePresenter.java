package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.mobileqq.R;
import feedcloud.FeedCloudMeta$StNotice;

/* loaded from: classes4.dex */
public class QFSCommentOrReplyMessagePresenter extends QFSTopReplayMessagePresenter {
    private static final String KEY_COMMENT_POSTER = "commentPoster";
    private static final String TAG = "QFSCommentOrReplyMessagePresenter";

    public QFSCommentOrReplyMessagePresenter(int i3) {
        super(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSTopReplayMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.QFSDefaultNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    public String getLogTag() {
        return TAG;
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter
    protected SpannableStringBuilder getTimeText(FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        if (feedCloudMeta$StNotice == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(feedCloudMeta$StNotice.typeName.get())) {
            spannableStringBuilder.append((CharSequence) feedCloudMeta$StNotice.typeName.get());
        }
        appendMessageTimeText(spannableStringBuilder, this.mItemInfo.getStNotice());
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter
    public void setContent(FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        String str = feedCloudMeta$StNotice.message.get();
        if (TextUtils.isEmpty(str)) {
            this.mMessageContainer.setVisibility(8);
            return;
        }
        this.mMessageContainer.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String valueFromListEntry = QCirclePluginUtil.getValueFromListEntry(this.mItemInfo.getNoticeBusiData().busiInfo.get(), KEY_COMMENT_POSTER, "");
        if (!TextUtils.isEmpty(valueFromListEntry)) {
            spannableStringBuilder.append((CharSequence) com.tencent.biz.qqcircle.utils.h.a(R.string.t0u)).append((CharSequence) Html.fromHtml("<b'>" + valueFromListEntry + "\uff1a</b>"));
        }
        spannableStringBuilder.append((CharSequence) str);
        this.mTvMessage.setMinimumWidth(QFSBaseNoticeMessagePresenter.MESSAGE_VIEW_MIN_WIDTH);
        this.mTvMessage.setText(spannableStringBuilder);
        reportImpEvent(this.mTvMessage);
    }
}
