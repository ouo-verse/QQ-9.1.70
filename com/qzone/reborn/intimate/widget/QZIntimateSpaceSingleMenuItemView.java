package com.qzone.reborn.intimate.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eB\u001b\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\r\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0014\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/intimate/widget/QZIntimateSpaceSingleMenuItemView;", "Lcom/qzone/reborn/intimate/widget/QZIntimateSpaceBaseMenuItemView;", "", "getLayoutId", "Landroid/view/View;", "p0", "Lij/e;", "bean", com.tencent.luggage.wxa.c8.c.G, "", "n0", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZIntimateSpaceSingleMenuItemView extends QZIntimateSpaceBaseMenuItemView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZIntimateSpaceSingleMenuItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setName((TextView) findViewById(R.id.nfz));
        setState((TextView) findViewById(R.id.f162940ng0));
        setIcon((ImageView) findViewById(R.id.nfy));
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cl7;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.intimate.widget.QZIntimateSpaceBaseMenuItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0 */
    public void bindData(ij.e bean, int pos) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        super.bindData(bean, pos);
    }

    @Override // com.qzone.reborn.intimate.widget.QZIntimateSpaceBaseMenuItemView
    protected View p0() {
        return findViewById(R.id.nfw);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZIntimateSpaceSingleMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setName((TextView) findViewById(R.id.nfz));
        setState((TextView) findViewById(R.id.f162940ng0));
        setIcon((ImageView) findViewById(R.id.nfy));
    }
}
