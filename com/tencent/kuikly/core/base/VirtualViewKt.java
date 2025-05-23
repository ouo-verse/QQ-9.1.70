package com.tencent.kuikly.core.base;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\u001a\u0012\u0010\u0002\u001a\u00020\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0000\u001a \u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00000\u0004*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "", "b", "Lcom/tencent/kuikly/core/base/ViewContainer;", "", "a", "core_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class VirtualViewKt {
    public static final List<DeclarativeBaseView<?, ?>> a(ViewContainer<?, ?> viewContainer) {
        Intrinsics.checkNotNullParameter(viewContainer, "<this>");
        final ArrayList arrayList = new ArrayList();
        viewContainer.forEachChild(new Function1<DeclarativeBaseView<?, ?>, Unit>() { // from class: com.tencent.kuikly.core.base.VirtualViewKt$domChildren$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DeclarativeBaseView<?, ?> declarativeBaseView) {
                invoke2(declarativeBaseView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DeclarativeBaseView<?, ?> child) {
                Intrinsics.checkNotNullParameter(child, "child");
                if (VirtualViewKt.b(child)) {
                    arrayList.addAll(VirtualViewKt.a((ViewContainer) child));
                } else {
                    arrayList.add(child);
                }
            }
        });
        return arrayList;
    }

    public static final boolean b(DeclarativeBaseView<?, ?> declarativeBaseView) {
        Intrinsics.checkNotNullParameter(declarativeBaseView, "<this>");
        return declarativeBaseView instanceof ab;
    }
}
