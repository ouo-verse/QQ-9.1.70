package com.tencent.biz.qqcircle.fragments.message.item;

import android.content.Context;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0014\u00a8\u0006\r"}, d2 = {"Lcom/tencent/biz/qqcircle/fragments/message/item/QFSMessageMsgRecomHeadItemView;", "Lcom/tencent/biz/qqcircle/fragments/message/item/QFSBaseMessageItemView;", "", "getLayoutId", "Lcom/tencent/biz/qqcircle/fragments/message/presenter/a;", "initPresenter", "", "getLogTag", "Landroid/content/Context;", "context", "viewType", "<init>", "(Landroid/content/Context;I)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSMessageMsgRecomHeadItemView extends QFSBaseMessageItemView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSMessageMsgRecomHeadItemView(@NotNull Context context, int i3) {
        super(context, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f168747gq2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    @NotNull
    public String getLogTag() {
        return "QFSMessageMsgRecomHeadItemView";
    }

    @Override // com.tencent.biz.qqcircle.fragments.message.item.QFSBaseMessageItemView
    @Nullable
    protected com.tencent.biz.qqcircle.fragments.message.presenter.a initPresenter() {
        return null;
    }
}
