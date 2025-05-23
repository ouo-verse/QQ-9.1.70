package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QFSMessageItemInfo;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;

/* loaded from: classes4.dex */
public class QFSKolMessagePresenter extends QFSBaseNoticeMessagePresenter {
    private static final String TAG = "QFSKolMessagePresenter";
    private Drawable mArrowDrawable;

    /* loaded from: classes4.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f84488d;

        a(Context context) {
            this.f84488d = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSKolMessagePresenter.this.consumeItemNewFlag();
            if (QFSKolMessagePresenter.this.mItemInfo.getNoticeBusiData() != null && QFSKolMessagePresenter.this.mItemInfo.getNoticeBusiData().busiInfo.get() != null) {
                String d16 = com.tencent.biz.qqcircle.d.d(QFSKolMessagePresenter.this.mItemInfo.getNoticeBusiData().busiInfo.get(), "noticeFeedJumpUrl");
                QLog.i(QFSKolMessagePresenter.TAG, 1, "clickSystemMessage get jumpUrl" + d16);
                if (!TextUtils.isEmpty(d16)) {
                    com.tencent.biz.qqcircle.launcher.c.j(this.f84488d, d16, true);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QFSKolMessagePresenter(int i3) {
        super(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    public void bindCustomData(@NonNull QFSMessageItemInfo qFSMessageItemInfo, int i3) {
        super.bindCustomData(qFSMessageItemInfo, i3);
        if (qFSMessageItemInfo.getStNotice() != null && qFSMessageItemInfo.getStNotice().message.get() != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            String str = qFSMessageItemInfo.getStNotice().feed.content.get();
            spannableStringBuilder.append((CharSequence) str);
            String string = this.mContext.getString(R.string.f183673jt);
            spannableStringBuilder.append((CharSequence) string);
            spannableStringBuilder.setSpan(new StyleSpan(1), str.length(), str.length() + string.length(), 33);
            if (this.mArrowDrawable == null) {
                Drawable drawable = QCircleSkinHelper.getInstance().getDrawable(this.mContext, R.drawable.qvideo_skin_icon_general_arrow_right_primary);
                this.mArrowDrawable = drawable;
                drawable.setBounds(0, ImmersiveUtils.dpToPx(1.5f), ImmersiveUtils.dpToPx(14.0f), ImmersiveUtils.dpToPx(14.0f));
            }
            QCircleAsyncTextView.e(spannableStringBuilder, spannableStringBuilder.length(), this.mArrowDrawable);
            this.mTvMessage.setText(spannableStringBuilder);
            this.mTvMessage.setVisibility(0);
            reportClickEvent(this.mTvMessage);
            return;
        }
        this.mTvMessage.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.a
    public String getLogTag() {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    protected void initClickListener() {
        QCircleAsyncTextView qCircleAsyncTextView = this.mTvMessage;
        if (qCircleAsyncTextView != null) {
            qCircleAsyncTextView.setOnLongClickListener(this.mOnItemLongClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter, com.tencent.biz.qqcircle.fragments.message.presenter.a
    public void initCustomView(Context context, @NonNull View view) {
        super.initCustomView(context, view);
        this.mTvMessage.setOnClickListener(new a(context));
        View view2 = this.mContentContainer;
        if (view2 != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view2.getLayoutParams();
            layoutParams.rightMargin = ImmersiveUtils.dpToPx(16.0f);
            this.mContentContainer.setLayoutParams(layoutParams);
        }
    }
}
