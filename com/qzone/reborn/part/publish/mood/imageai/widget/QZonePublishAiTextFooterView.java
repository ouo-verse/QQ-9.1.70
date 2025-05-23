package com.qzone.reborn.part.publish.mood.imageai.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u0014B\u0019\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0014R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/qzone/reborn/part/publish/mood/imageai/widget/QZonePublishAiTextFooterView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "", "", "getLayoutId", "objData", c.G, "", "bindData", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "tvTipsView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "f", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZonePublishAiTextFooterView extends QZoneBaseWidgetView<Object> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final TextView tvTipsView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZonePublishAiTextFooterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.n9b);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_pic_to_text_bottom_tips)");
        this.tvTipsView = (TextView) findViewById;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object objData, int pos) {
        this.tvTipsView.setText(g.f53821a.b().U0());
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cno;
    }
}
