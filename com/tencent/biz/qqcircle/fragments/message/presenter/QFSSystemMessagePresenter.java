package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes4.dex */
public class QFSSystemMessagePresenter extends QFSDefaultNoticeMessagePresenter {
    private static final String TAG = "QFSSystemMessagePresenter";

    /* loaded from: classes4.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f84498d;

        a(Context context) {
            this.f84498d = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSSystemMessagePresenter.this.consumeItemNewFlag();
            QLog.i(QFSSystemMessagePresenter.TAG, 1, "clickSystemMessage messageId" + QFSSystemMessagePresenter.this.mItemInfo.getStNotice().feedId.get());
            if (QFSSystemMessagePresenter.this.mItemInfo.getNoticeBusiData() != null && QFSSystemMessagePresenter.this.mItemInfo.getNoticeBusiData().busiInfo.get() != null) {
                String d16 = com.tencent.biz.qqcircle.d.d(QFSSystemMessagePresenter.this.mItemInfo.getNoticeBusiData().busiInfo.get(), "noticeFeedJumpUrl");
                QLog.i(QFSSystemMessagePresenter.TAG, 1, "clickSystemMessage get jumpUrl" + d16);
                if (!TextUtils.isEmpty(d16)) {
                    com.tencent.biz.qqcircle.launcher.c.j(this.f84498d, d16, true);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QFSSystemMessagePresenter(int i3) {
        super(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSDefaultNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    public void initCustomView(Context context, @NonNull View view) {
        super.initCustomView(context, view);
        this.mContainerClickListener = new a(context);
    }
}
