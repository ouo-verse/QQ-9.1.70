package com.tencent.biz.qqcircle.fragments.message.item;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.fragments.message.presenter.QFSMessageNewFriendLoadMorePresenter;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMessageLoadMoreItemView extends QFSBaseMessageItemView {
    private static final String TAG = "QFSMessageLoadMoreItemView";

    public QFSMessageLoadMoreItemView(@NonNull Context context, int i3) {
        super(context, i3);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gij;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return TAG;
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.item.QFSBaseMessageItemView
    protected com.tencent.biz.qqcircle.fragments.message.presenter.a initPresenter() {
        return new QFSMessageNewFriendLoadMorePresenter(this.mViewType);
    }
}
