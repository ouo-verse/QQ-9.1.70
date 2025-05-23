package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QFSMessageItemInfo;
import com.tencent.biz.qqcircle.fragments.message.presenter.QFSBusinessMessagePresenter;
import com.tencent.biz.qqcircle.utils.QFSMessageAvatarWrapper;
import com.tencent.biz.qqcircle.utils.cy;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta$StNotice;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import qqcircle.QQCircleFeedBase$StNoticePattonInfo;
import qqcircle.QQCircleFeedBase$StNoticeTxtInfo;

/* loaded from: classes4.dex */
public class QFSBusinessMessagePresenter extends QFSBaseNormalMessagePresenter {
    private static final String TAG = "QFSBusinessMessagePresenter";
    private QQCircleFeedBase$StNoticeTxtInfo mNoticeTxtInfo;

    /* loaded from: classes4.dex */
    private class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        private final String f84474d;

        public a(String str) {
            this.f84474d = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Unit b(View view, String str) {
            if (view.getContext() != null) {
                com.tencent.biz.qqcircle.launcher.c.j(view.getContext(), cy.g(str, 5), true);
                return null;
            }
            return null;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(final View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!TextUtils.isEmpty(this.f84474d)) {
                if (cy.n(this.f84474d)) {
                    if (cy.o(this.f84474d)) {
                        new com.tencent.biz.qqcircle.immersive.request.b(this.f84474d, new Function1() { // from class: com.tencent.biz.qqcircle.fragments.message.presenter.f
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit b16;
                                b16 = QFSBusinessMessagePresenter.a.b(view, (String) obj);
                                return b16;
                            }
                        }).d();
                        QLog.d(QFSBusinessMessagePresenter.this.getLogTag(), 1, "handle url is intercepted by wink publish task");
                    } else {
                        com.tencent.biz.qqcircle.launcher.c.j(view.getContext(), cy.g(this.f84474d, 5), true);
                    }
                } else {
                    com.tencent.biz.qqcircle.launcher.c.j(view.getContext(), this.f84474d, true);
                }
                if (QFSBusinessMessagePresenter.this.mItemInfo.getStNotice() != null) {
                    QFSBusinessMessagePresenter qFSBusinessMessagePresenter = QFSBusinessMessagePresenter.this;
                    QFSMessageAvatarWrapper qFSMessageAvatarWrapper = qFSBusinessMessagePresenter.mAvatarWrap;
                    if (qFSMessageAvatarWrapper != null) {
                        qFSMessageAvatarWrapper.f();
                    } else {
                        QLog.e(qFSBusinessMessagePresenter.getLogTag(), 1, "handleSchemeClick mAvatarWrap is null");
                    }
                }
            } else {
                QLog.e(QFSBusinessMessagePresenter.this.getLogTag(), 1, "[onClick] mUrl is empty");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QFSBusinessMessagePresenter(int i3) {
        super(i3);
    }

    private String getMessageDescTxt() {
        QQCircleFeedBase$StNoticePattonInfo qQCircleFeedBase$StNoticePattonInfo;
        QFSMessageItemInfo qFSMessageItemInfo = this.mItemInfo;
        if (qFSMessageItemInfo != null && qFSMessageItemInfo.getNoticeBusiData() != null && this.mItemInfo.getNoticeBusiData().pattonInfo != null) {
            qQCircleFeedBase$StNoticePattonInfo = this.mItemInfo.getNoticeBusiData().pattonInfo.get();
        } else {
            qQCircleFeedBase$StNoticePattonInfo = null;
        }
        if (qQCircleFeedBase$StNoticePattonInfo != null) {
            int i3 = qQCircleFeedBase$StNoticePattonInfo.pattonType.get();
            if (i3 == 1) {
                this.mNoticeTxtInfo = qQCircleFeedBase$StNoticePattonInfo.plainTxt.txtInfo.get();
            } else if (i3 == 2) {
                this.mNoticeTxtInfo = qQCircleFeedBase$StNoticePattonInfo.leftTxtRightPic.txtInfo.get();
            } else if (i3 == 3) {
                this.mNoticeTxtInfo = qQCircleFeedBase$StNoticePattonInfo.leftTxtRightButton.txtInfo.get();
            } else {
                QLog.d(getLogTag(), 1, "error patternType:" + i3);
            }
        }
        QQCircleFeedBase$StNoticeTxtInfo qQCircleFeedBase$StNoticeTxtInfo = this.mNoticeTxtInfo;
        if (qQCircleFeedBase$StNoticeTxtInfo == null) {
            QLog.e(getLogTag(), 1, "[getMessageDescTxt] mNoticeTxtInfo == null");
            return "";
        }
        return qQCircleFeedBase$StNoticeTxtInfo.content.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getAvatarClickListener$0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        handleAvatarClick(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNormalMessagePresenter
    protected View.OnClickListener getAvatarClickListener() {
        if (((QFSBaseNormalMessagePresenter) this).mAvatarClickListener == null) {
            ((QFSBaseNormalMessagePresenter) this).mAvatarClickListener = new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.fragments.message.presenter.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QFSBusinessMessagePresenter.this.lambda$getAvatarClickListener$0(view);
                }
            };
        }
        return ((QFSBaseNormalMessagePresenter) this).mAvatarClickListener;
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNormalMessagePresenter
    protected View.OnClickListener getContainerClickListener() {
        a aVar = new a(this.mNoticeTxtInfo.schemaUrl.get());
        this.mContainerClickListener = aVar;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNormalMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    public String getLogTag() {
        return TAG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNormalMessagePresenter
    public void setMessageView(@NonNull FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        QCircleAsyncTextView qCircleAsyncTextView = this.mTvMessage;
        if (qCircleAsyncTextView != null) {
            qCircleAsyncTextView.setSingleLine(true);
            this.mTvMessage.setEllipsize(TextUtils.TruncateAt.END);
            this.mTvMessage.setText(getMessageDescTxt());
        }
    }
}
