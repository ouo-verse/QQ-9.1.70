package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.mobileqq.R;

/* loaded from: classes4.dex */
public abstract class QFSBaseMultiPersonActionMessagePresenter extends QFSDefaultNoticeMessagePresenter {
    protected TextView mTvMessageCount;

    public QFSBaseMultiPersonActionMessagePresenter(int i3) {
        super(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSDefaultNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    public void initCustomView(Context context, @NonNull View view) {
        int i3;
        super.initCustomView(context, view);
        TextView textView = (TextView) view.findViewById(R.id.f109296ff);
        this.mTvMessageCount = textView;
        textView.setVisibility(0);
        TextView textView2 = this.mTvMessageCount;
        if (this.mViewType == 31) {
            i3 = R.color.qui_common_text_secondary;
        } else {
            i3 = R.color.qui_common_text_primary;
        }
        textView2.setTextColor(QFSQUIUtilsKt.d(context, i3));
        this.mTvMessage.setSingleLine();
    }
}
