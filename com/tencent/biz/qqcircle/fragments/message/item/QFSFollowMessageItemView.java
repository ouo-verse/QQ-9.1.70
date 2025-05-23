package com.tencent.biz.qqcircle.fragments.message.item;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter;
import com.tencent.biz.qqcircle.fragments.message.presenter.QFSFollowMessagePresenter;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFollowMessageItemView extends QFSBaseNoticeMessageItemView {
    private static final String TAG = "QFSFollowMessageItemView";

    public QFSFollowMessageItemView(@NonNull Context context, int i3) {
        super(context, i3);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gic;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return TAG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.item.QFSBaseNoticeMessageItemView, com.tencent.biz.qqcircle.fragments.message.item.QFSBaseMessageItemView
    public QFSBaseNoticeMessagePresenter initPresenter() {
        return new QFSFollowMessagePresenter(getViewType());
    }
}
