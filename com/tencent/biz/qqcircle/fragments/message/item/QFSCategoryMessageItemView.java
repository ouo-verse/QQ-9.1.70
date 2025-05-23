package com.tencent.biz.qqcircle.fragments.message.item;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.fragments.message.presenter.QFSCategoryMessagePresenter;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCategoryMessageItemView extends QFSBaseMessageItemView {
    private static final String TAG = "QFSCategoryMessageItemView";

    public QFSCategoryMessageItemView(@NonNull Context context, int i3) {
        super(context, i3);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gi_;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return TAG;
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.item.QFSBaseMessageItemView
    public com.tencent.biz.qqcircle.fragments.message.presenter.a initPresenter() {
        return new QFSCategoryMessagePresenter(getViewType());
    }
}
