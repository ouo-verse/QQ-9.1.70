package com.tencent.biz.qqcircle.fragments.message.item;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.fragments.message.presenter.QFSBaseNoticeMessagePresenter;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class QFSBaseNoticeMessageItemView extends QFSBaseMessageItemView {
    public QFSBaseNoticeMessageItemView(@NonNull Context context, int i3) {
        super(context, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.message.item.QFSBaseMessageItemView
    public abstract QFSBaseNoticeMessagePresenter initPresenter();
}
