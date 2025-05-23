package com.tencent.biz.qqcircle.immersive.datacardcover.widget;

import android.content.Context;
import android.view.View;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import h40.QFSPersonalCoverFeedInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0014\u00a8\u0006\f"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverBaseItemView;", "Lcom/tencent/biz/qqcircle/widgets/QCircleBaseWidgetView;", "Lh40/a;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public abstract class QFSPersonalCoverBaseItemView extends QCircleBaseWidgetView<QFSPersonalCoverFeedInfo> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSPersonalCoverBaseItemView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(widthMeasureSpec) * 4) / 3, 1073741824));
    }
}
