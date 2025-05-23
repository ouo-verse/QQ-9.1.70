package com.tencent.state.library.data;

import com.tencent.state.template.data.Decorator;
import com.tencent.state.template.item.TemplateDecoratorItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/state/library/data/LibraryDecoratorItem;", "Lcom/tencent/state/template/item/TemplateDecoratorItem;", "decorator", "Lcom/tencent/state/template/data/Decorator;", "(Lcom/tencent/state/template/data/Decorator;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryDecoratorItem extends TemplateDecoratorItem {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LibraryDecoratorItem(Decorator decorator) {
        super(decorator, null);
        Intrinsics.checkNotNullParameter(decorator, "decorator");
    }
}
