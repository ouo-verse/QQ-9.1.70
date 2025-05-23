package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tenpay.sdk.util.UinConfigManager;
import feedcloud.FeedCloudMeta$StNotice;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0014\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/biz/qqcircle/fragments/message/presenter/QFSDiffTimeNoticeMessagePresenter;", "Lcom/tencent/biz/qqcircle/fragments/message/presenter/QFSTopReplayMessagePresenter;", "Lfeedcloud/FeedCloudMeta$StNotice;", UinConfigManager.KEY_ADS, "", "setContent", "setTime", "", "getLogTag", "", "viewType", "<init>", "(I)V", "Companion", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public class QFSDiffTimeNoticeMessagePresenter extends QFSTopReplayMessagePresenter {

    @NotNull
    private static final String TAG = "QFSDiffTimeNoticeMessagePresenter";

    public QFSDiffTimeNoticeMessagePresenter(int i3) {
        super(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSTopReplayMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.QFSDefaultNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    @NotNull
    public String getLogTag() {
        return TAG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter
    public void setContent(@NotNull FeedCloudMeta$StNotice notice) {
        Intrinsics.checkNotNullParameter(notice, "notice");
        String str = notice.message.get();
        if (TextUtils.isEmpty(str)) {
            this.mMessageContainer.setVisibility(8);
            return;
        }
        this.mMessageContainer.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        appendMessageTimeText(spannableStringBuilder, notice);
        this.mTvMessage.setMinimumWidth(QFSBaseNoticeMessagePresenter.MESSAGE_VIEW_MIN_WIDTH);
        this.mTvMessage.setText(spannableStringBuilder);
        reportImpEvent(this.mTvMessage);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter
    public void setTime(@NotNull FeedCloudMeta$StNotice notice) {
        Intrinsics.checkNotNullParameter(notice, "notice");
        this.mTvTime.setVisibility(8);
    }
}
