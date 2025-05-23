package com.tencent.biz.qqcircle.fragments.message.item;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.beans.QFSMessageItemInfo;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class QFSBaseMessageItemView extends QCircleBaseWidgetView<QFSMessageItemInfo> {
    protected com.tencent.biz.qqcircle.fragments.message.presenter.a mMessagePresenter;

    public QFSBaseMessageItemView(@NonNull Context context, int i3) {
        super(context, i3);
        com.tencent.biz.qqcircle.fragments.message.presenter.a initPresenter = initPresenter();
        this.mMessagePresenter = initPresenter;
        if (initPresenter != null) {
            initPresenter.initView(context, this);
        }
    }

    protected abstract com.tencent.biz.qqcircle.fragments.message.presenter.a initPresenter();

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.tencent.biz.qqcircle.fragments.message.presenter.a aVar = this.mMessagePresenter;
        if (aVar != null) {
            aVar.onAttachedToWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.tencent.biz.qqcircle.fragments.message.presenter.a aVar = this.mMessagePresenter;
        if (aVar != null) {
            aVar.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    public void setOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        super.setOnLongClickListener(onLongClickListener);
        com.tencent.biz.qqcircle.fragments.message.presenter.a aVar = this.mMessagePresenter;
        if (aVar != null) {
            aVar.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setPageParam(int i3, int i16) {
        com.tencent.biz.qqcircle.fragments.message.presenter.a aVar = this.mMessagePresenter;
        if (aVar != null) {
            aVar.setPageParam(i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(QFSMessageItemInfo qFSMessageItemInfo, int i3) {
        com.tencent.biz.qqcircle.fragments.message.presenter.a aVar = this.mMessagePresenter;
        if (aVar != null) {
            aVar.setReportBean(getReportBean());
            this.mMessagePresenter.bindData(qFSMessageItemInfo, i3);
        }
    }
}
