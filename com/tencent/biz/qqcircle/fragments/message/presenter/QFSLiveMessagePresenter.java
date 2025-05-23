package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QFSMessageItemInfo;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta$StNotice;

/* loaded from: classes4.dex */
public class QFSLiveMessagePresenter extends QFSBaseNormalMessagePresenter {
    private static final String TAG = "QFSLiveMessagePresenter";

    /* loaded from: classes4.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view == null) {
                QLog.e(QFSLiveMessagePresenter.this.getLogTag(), 1, "[containerClick] v == null");
            } else {
                QFSMessageItemInfo qFSMessageItemInfo = QFSLiveMessagePresenter.this.mItemInfo;
                if (qFSMessageItemInfo != null && qFSMessageItemInfo.getStNotice() != null) {
                    String str = QFSLiveMessagePresenter.this.mItemInfo.getStNotice().operation.jumpUrl.get();
                    QLog.d(QFSLiveMessagePresenter.this.getLogTag(), 1, "[containerClick] jumpUrl:" + str);
                    com.tencent.biz.qqcircle.launcher.c.g(view.getContext(), str);
                    QFSLiveMessagePresenter.this.removeRedPoint();
                } else {
                    QLog.e(QFSLiveMessagePresenter.this.getLogTag(), 1, "[containerClick] stNotice == null");
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QFSLiveMessagePresenter(int i3) {
        super(i3);
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNormalMessagePresenter
    protected View.OnClickListener getContainerClickListener() {
        if (this.mContainerClickListener == null) {
            this.mContainerClickListener = new a();
        }
        return this.mContainerClickListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNormalMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    public String getLogTag() {
        return TAG;
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNormalMessagePresenter
    protected int getRemoveRedPointPageType() {
        return 0;
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNormalMessagePresenter
    protected boolean isNeedShowAvatarLivingStatus(@NonNull QFSMessageItemInfo qFSMessageItemInfo) {
        if (qFSMessageItemInfo.getStNotice() == null) {
            return false;
        }
        boolean z16 = qFSMessageItemInfo.getStNotice().operation.opUser.isUserInLivingStatus.get();
        QLog.d(getLogTag(), 1, "[isNeedShowAvatarLivingStatus] isLiving:" + z16);
        return z16;
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNormalMessagePresenter
    protected void setNickView(@NonNull FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        TextView textView = this.mTvNick;
        if (textView != null) {
            textView.setText(feedCloudMeta$StNotice.operation.opUser.nick.get() + com.tencent.biz.qqcircle.utils.h.a(R.string.f1918145t));
        }
    }
}
