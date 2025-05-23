package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QFSMessageItemInfo;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta$StNotice;

/* loaded from: classes4.dex */
public class QFSUserPublishNewContentsMessagePresenter extends QFSBaseNormalMessagePresenter {
    private static final String TAG = "QFSUserPublishNewContentsMessagePresenter";

    /* loaded from: classes4.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSUserPublishNewContentsMessagePresenter.this.handleAvatarClick(view);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes4.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedCloudMeta$StNotice stNotice;
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSMessageItemInfo qFSMessageItemInfo = QFSUserPublishNewContentsMessagePresenter.this.mItemInfo;
            if (qFSMessageItemInfo == null) {
                stNotice = null;
            } else {
                stNotice = qFSMessageItemInfo.getStNotice();
            }
            if (stNotice != null) {
                String str = stNotice.operation.jumpUrl.get();
                if (TextUtils.isEmpty(str)) {
                    QFSUserPublishNewContentsMessagePresenter.this.handleContainerClick(view);
                } else {
                    com.tencent.biz.qqcircle.launcher.c.g(view.getContext(), str);
                    QFSUserPublishNewContentsMessagePresenter.this.removeRedPoint();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QFSUserPublishNewContentsMessagePresenter(int i3) {
        super(i3);
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNormalMessagePresenter
    protected View.OnClickListener getAvatarClickListener() {
        if (((QFSBaseNormalMessagePresenter) this).mAvatarClickListener == null) {
            ((QFSBaseNormalMessagePresenter) this).mAvatarClickListener = new a();
        }
        return ((QFSBaseNormalMessagePresenter) this).mAvatarClickListener;
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNormalMessagePresenter
    protected View.OnClickListener getContainerClickListener() {
        if (this.mContainerClickListener == null) {
            this.mContainerClickListener = new b();
        }
        return this.mContainerClickListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNormalMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    public String getLogTag() {
        return TAG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNormalMessagePresenter
    public void setMessageView(@NonNull FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        if (TextUtils.isEmpty(feedCloudMeta$StNotice.feed.video.fileId.get())) {
            super.setMessageView(feedCloudMeta$StNotice);
            return;
        }
        String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f1918645y);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a16);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(QFSQUIUtilsKt.d(RFWApplication.getApplication(), R.color.qui_common_text_link)), 0, a16.length(), 33);
        spannableStringBuilder.append((CharSequence) " ");
        spannableStringBuilder.append((CharSequence) feedCloudMeta$StNotice.message.get());
        this.mTvMessage.setText(spannableStringBuilder);
    }
}
