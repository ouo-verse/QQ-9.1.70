package com.tencent.kuikly.core.directives;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.reactive.ReactiveObserver;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.ListContentView;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.aq;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u009e\u0001\u0010\u0012\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00012\u001c\u0010\u0005\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002j\b\u0012\u0004\u0012\u00028\u0000`\u00042f\u0010\u0011\u001ab\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0006j\b\u0012\u0004\u0012\u00028\u0000`\u000f\u00a2\u0006\u0002\b\u0010\u001at\u0010\u0015\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00012\u001c\u0010\u0005\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002j\b\u0012\u0004\u0012\u00028\u0000`\u00042<\u0010\u0011\u001a8\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000e0\u0013j\b\u0012\u0004\u0012\u00028\u0000`\u0014\u00a2\u0006\u0002\b\u0010*h\u0010\u0016\u001a\u0004\b\u0000\u0010\u0000\".\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000e0\u0013\u00a2\u0006\u0002\b\u00102.\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000e0\u0013\u00a2\u0006\u0002\b\u0010*\u00bc\u0001\u0010\u0017\u001a\u0004\b\u0000\u0010\u0000\"X\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0006\u00a2\u0006\u0002\b\u00102X\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0006\u00a2\u0006\u0002\b\u0010*(\u0010\u0018\u001a\u0004\b\u0000\u0010\u0000\"\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u00022\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002\u00a8\u0006\u0019"}, d2 = {"T", "Lcom/tencent/kuikly/core/base/ViewContainer;", "Lkotlin/Function0;", "Lcom/tencent/kuikly/core/reactive/collection/c;", "Lcom/tencent/kuikly/core/directives/VItemList;", VideoTemplateParser.ITEM_LIST, "Lkotlin/Function4;", "Lcom/tencent/kuikly/core/directives/LoopDirectivesView;", "Lkotlin/ParameterName;", "name", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "index", "count", "", "Lcom/tencent/kuikly/core/directives/VItemIndexCreator;", "Lkotlin/ExtensionFunctionType;", "itemCreator", "b", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/directives/VItemCreator;", "a", "VItemCreator", "VItemIndexCreator", "VItemList", "core_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class LoopDirectivesViewKt {
    public static final <T> void a(ViewContainer<?, ?> viewContainer, Function0<c<T>> itemList, final Function2<? super LoopDirectivesView<T>, ? super T, Unit> itemCreator) {
        Intrinsics.checkNotNullParameter(viewContainer, "<this>");
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        Intrinsics.checkNotNullParameter(itemCreator, "itemCreator");
        b(viewContainer, itemList, new Function4<LoopDirectivesView<T>, T, Integer, Integer, Unit>() { // from class: com.tencent.kuikly.core.directives.LoopDirectivesViewKt$vfor$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2, Integer num, Integer num2) {
                invoke((LoopDirectivesView<LoopDirectivesView<T>>) obj, (LoopDirectivesView<T>) obj2, num.intValue(), num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LoopDirectivesView<T> vforIndex, T t16, int i3, int i16) {
                Intrinsics.checkNotNullParameter(vforIndex, "$this$vforIndex");
                itemCreator.invoke(vforIndex, t16);
            }
        });
    }

    public static final <T> void b(ViewContainer<?, ?> viewContainer, final Function0<c<T>> itemList, final Function4<? super LoopDirectivesView<T>, ? super T, ? super Integer, ? super Integer, Unit> itemCreator) {
        Intrinsics.checkNotNullParameter(viewContainer, "<this>");
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        Intrinsics.checkNotNullParameter(itemCreator, "itemCreator");
        final LoopDirectivesView loopDirectivesView = new LoopDirectivesView(itemList, itemCreator, false, 4, null);
        viewContainer.addChild(loopDirectivesView, new Function1<LoopDirectivesView<T>, Unit>() { // from class: com.tencent.kuikly.core.directives.LoopDirectivesViewKt$vforIndex$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke((LoopDirectivesView) obj);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void invoke(final LoopDirectivesView<T> addChild) {
                final List list;
                Intrinsics.checkNotNullParameter(addChild, "$this$addChild");
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                ReactiveObserver.Companion companion = ReactiveObserver.INSTANCE;
                final Function0<c<T>> function0 = itemList;
                final LoopDirectivesView<T> loopDirectivesView2 = loopDirectivesView;
                companion.b(addChild, new Function1<Boolean, Unit>() { // from class: com.tencent.kuikly.core.directives.LoopDirectivesViewKt$vforIndex$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16) {
                        T t16 = (T) ((c) ((c<T>) function0.invoke()));
                        Ref.ObjectRef<c<T>> objectRef2 = objectRef;
                        if (objectRef2.element == null) {
                            objectRef2.element = t16;
                        }
                        loopDirectivesView2.v(t16);
                    }
                });
                c<T> cVar = (c) objectRef.element;
                if (cVar == null) {
                    cVar = itemList.invoke();
                }
                addChild.s(cVar);
                int i3 = 0;
                if (addChild.h() instanceof ListContentView) {
                    list = CollectionsKt___CollectionsKt.toList(addChild.q());
                    ViewContainer<?, ?> h16 = addChild.h();
                    Intrinsics.checkNotNull(h16, "null cannot be cast to non-null type com.tencent.kuikly.core.views.ListContentView");
                    ViewContainer<?, ?> parent = ((ListContentView) h16).getParent();
                    Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type com.tencent.kuikly.core.views.ListView<*, *>");
                    final int firstContentLoadMaxIndex = ((ao) ((aq) parent).getViewAttr()).getFirstContentLoadMaxIndex();
                    if (firstContentLoadMaxIndex > 0 && list.size() > firstContentLoadMaxIndex) {
                        int size = list.size();
                        List subList = list.subList(0, firstContentLoadMaxIndex);
                        Function4<LoopDirectivesView<T>, T, Integer, Integer, Unit> function4 = itemCreator;
                        for (T t16 : subList) {
                            int i16 = i3 + 1;
                            if (i3 < 0) {
                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                            }
                            function4.invoke(addChild, t16, Integer.valueOf(i3), Integer.valueOf(size));
                            i3 = i16;
                        }
                        addChild.t(new Function1<LoopDirectivesView<?>, Unit>() { // from class: com.tencent.kuikly.core.directives.LoopDirectivesViewKt$vforIndex$1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LoopDirectivesView<?> loopDirectivesView3) {
                                invoke2(loopDirectivesView3);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LoopDirectivesView<?> loopDirectivesView3) {
                                Intrinsics.checkNotNullParameter(loopDirectivesView3, "$this$null");
                                addChild.u(new com.tencent.kuikly.core.reactive.collection.a(1, firstContentLoadMaxIndex, list.size() - firstContentLoadMaxIndex), list);
                            }
                        });
                        addChild.getPager().addNextTickTask(new Function0<Unit>() { // from class: com.tencent.kuikly.core.directives.LoopDirectivesViewKt$vforIndex$1.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                addChild.r();
                            }
                        });
                        return;
                    }
                }
                int size2 = addChild.q().size();
                c<T> q16 = addChild.q();
                Function4<LoopDirectivesView<T>, T, Integer, Integer, Unit> function42 = itemCreator;
                for (T t17 : q16) {
                    int i17 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    function42.invoke(addChild, t17, Integer.valueOf(i3), Integer.valueOf(size2));
                    i3 = i17;
                }
            }
        });
    }
}
