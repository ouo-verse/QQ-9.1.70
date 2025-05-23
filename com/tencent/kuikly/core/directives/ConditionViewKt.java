package com.tencent.kuikly.core.directives;

import com.tencent.kuikly.core.base.ViewContainer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a;\u0010\t\u001a\u00020\u0006*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00002\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\u0002\b\u0007\u001a;\u0010\n\u001a\u00020\u0006*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00002\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\u0002\b\u0007\u001a+\u0010\u000b\u001a\u00020\u0006*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00002\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\u0002\b\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/kuikly/core/base/ViewContainer;", "Lkotlin/Function0;", "", "condition", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/directives/ConditionView;", "", "Lkotlin/ExtensionFunctionType;", "creator", "c", "b", "a", "core_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ConditionViewKt {
    public static final void a(ViewContainer<?, ?> viewContainer, Function1<? super ConditionView, Unit> creator) {
        Intrinsics.checkNotNullParameter(viewContainer, "<this>");
        Intrinsics.checkNotNullParameter(creator, "creator");
        viewContainer.addChild(new ConditionView(ConditionType.VELSE, new Function0<Object>() { // from class: com.tencent.kuikly.core.directives.ConditionViewKt$velse$view$1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.TRUE;
            }
        }, creator), new Function1<ConditionView, Unit>() { // from class: com.tencent.kuikly.core.directives.ConditionViewKt$velse$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ConditionView addChild) {
                Intrinsics.checkNotNullParameter(addChild, "$this$addChild");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ConditionView conditionView) {
                invoke2(conditionView);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void b(ViewContainer<?, ?> viewContainer, Function0<? extends Object> condition, Function1<? super ConditionView, Unit> creator) {
        Intrinsics.checkNotNullParameter(viewContainer, "<this>");
        Intrinsics.checkNotNullParameter(condition, "condition");
        Intrinsics.checkNotNullParameter(creator, "creator");
        viewContainer.addChild(new ConditionView(ConditionType.VELSEIF, condition, creator), new Function1<ConditionView, Unit>() { // from class: com.tencent.kuikly.core.directives.ConditionViewKt$velseif$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ConditionView addChild) {
                Intrinsics.checkNotNullParameter(addChild, "$this$addChild");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ConditionView conditionView) {
                invoke2(conditionView);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void c(ViewContainer<?, ?> viewContainer, Function0<? extends Object> condition, Function1<? super ConditionView, Unit> creator) {
        Intrinsics.checkNotNullParameter(viewContainer, "<this>");
        Intrinsics.checkNotNullParameter(condition, "condition");
        Intrinsics.checkNotNullParameter(creator, "creator");
        viewContainer.addChild(new ConditionView(ConditionType.VIF, condition, creator), new Function1<ConditionView, Unit>() { // from class: com.tencent.kuikly.core.directives.ConditionViewKt$vif$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ConditionView addChild) {
                Intrinsics.checkNotNullParameter(addChild, "$this$addChild");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ConditionView conditionView) {
                invoke2(conditionView);
                return Unit.INSTANCE;
            }
        });
    }
}
