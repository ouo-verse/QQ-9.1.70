package com.tencent.ntcompose.core;

import com.tencent.kuikly.core.base.ScopeMarker;
import com.tencent.kuikly.core.base.ViewContainer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a-\u0010\u0006\u001a\u00020\u0003*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u00a2\u0006\u0002\b\u0004H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/kuikly/core/base/ViewContainer;", "Lkotlin/Function1;", "Lcom/tencent/ntcompose/core/g;", "", "Lkotlin/ExtensionFunctionType;", "attr", "a", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ComposeOnKuiklyKt {
    @ScopeMarker
    public static final void a(ViewContainer<?, ?> viewContainer, final Function1<? super g, Unit> attr) {
        Intrinsics.checkNotNullParameter(viewContainer, "<this>");
        Intrinsics.checkNotNullParameter(attr, "attr");
        viewContainer.addChild(new KuiklyNTComposeView(), new Function1<KuiklyNTComposeView, Unit>() { // from class: com.tencent.ntcompose.core.ComposeOnKuiklyKt$NTCompose$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KuiklyNTComposeView kuiklyNTComposeView) {
                invoke2(kuiklyNTComposeView);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KuiklyNTComposeView addChild) {
                Intrinsics.checkNotNullParameter(addChild, "$this$addChild");
                attr.invoke(addChild.getViewAttr());
            }
        });
    }
}
