package com.tencent.biz.qqcircle.fragments.message.presenter;

import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QFSMessageItemInfo;

/* loaded from: classes4.dex */
public class QFSPostPositiveMessagePresenter extends QFSDefaultNoticeMessagePresenter {
    private static final String TAG = "QFSPostPositiveMessagePresenter";

    public QFSPostPositiveMessagePresenter(int i3) {
        super(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSDefaultNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    public void bindCustomData(@NonNull QFSMessageItemInfo qFSMessageItemInfo, int i3) {
        super.bindCustomData(qFSMessageItemInfo, i3);
        this.mIvRightArrowLine1.setVisibility(8);
        this.mSubMessageContainer.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSDefaultNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    public String getLogTag() {
        return TAG;
    }
}
