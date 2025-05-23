package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007B\u001d\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u0006\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/widget/QIDStatusFormSimpleItem;", "Lcom/tencent/mobileqq/widget/FormSimpleItem;", "", "i", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class QIDStatusFormSimpleItem extends FormSimpleItem {
    public QIDStatusFormSimpleItem(@Nullable Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.FormSimpleItem
    public void i() {
        super.i();
        this.M.setCompoundDrawablePadding(BaseAIOUtils.f(12.0f, getResources()));
    }

    public QIDStatusFormSimpleItem(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        c().getLayoutParams().width = -1;
    }
}
