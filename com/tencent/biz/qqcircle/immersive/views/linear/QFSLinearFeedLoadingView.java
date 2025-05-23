package com.tencent.biz.qqcircle.immersive.views.linear;

import android.content.Context;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import e30.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0014\u00a8\u0006\r"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/linear/QFSLinearFeedLoadingView;", "Lcom/tencent/biz/qqcircle/widgets/QCircleBaseWidgetView;", "Le30/b;", "", "getLayoutId", "objData", c.G, "", "bindData", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSLinearFeedLoadingView extends QCircleBaseWidgetView<b> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSLinearFeedLoadingView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(@Nullable b objData, int pos) {
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.ghk;
    }
}
