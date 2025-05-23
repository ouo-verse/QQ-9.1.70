package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QFSMessageItemInfo;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.mobileqq.R;

/* loaded from: classes4.dex */
public class QFSUnsupportedMessagePresenter extends QFSBaseNoticeMessagePresenter {
    private static final String TAG = "QFSUnsupportedMessagePresenter";

    public QFSUnsupportedMessagePresenter(int i3) {
        super(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    public void bindCustomData(@NonNull QFSMessageItemInfo qFSMessageItemInfo, int i3) {
        Context context;
        super.bindCustomData(qFSMessageItemInfo, i3);
        QCircleAsyncTextView qCircleAsyncTextView = this.mTvMessage;
        if (qCircleAsyncTextView != null && (context = this.mContext) != null) {
            qCircleAsyncTextView.setText(context.getString(R.string.f183933ki));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    public String getLogTag() {
        return TAG;
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    protected void initClickListener() {
    }
}
