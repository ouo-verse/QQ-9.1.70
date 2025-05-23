package com.tencent.biz.qqcircle.fragments.message.item;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.fragments.message.presenter.QFSUrgeUpdateMessagePresenter;
import com.tencent.mobileqq.R;

/* loaded from: classes4.dex */
public class QFSMultiPersonalMessageItemView extends QFSBaseMessageItemView {
    private static final String TAG = "QFSMultiPersonalMessageItemView";

    public QFSMultiPersonalMessageItemView(@NonNull Context context, int i3) {
        super(context, i3);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gik;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return TAG;
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.item.QFSBaseMessageItemView
    protected com.tencent.biz.qqcircle.fragments.message.presenter.a initPresenter() {
        return new QFSUrgeUpdateMessagePresenter(getViewType());
    }
}
