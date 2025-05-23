package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.reactive.ReactiveObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0006\u001a\u00020\u0003*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u00a2\u0006\u0002\b\u0004\u001a#\u0010\t\u001a\u00020\u0003*\u00020\u00022\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0001\u00a2\u0006\u0002\b\u0004\u001a#\u0010\f\u001a\u00020\u0003*\u00020\u00022\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\u0001\u00a2\u0006\u0002\b\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/kuikly/core/base/ViewContainer;", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/views/RichTextView;", "", "Lkotlin/ExtensionFunctionType;", "init", "b", "Lcom/tencent/kuikly/core/views/cf;", "textSpanInit", "c", "Lcom/tencent/kuikly/core/views/ImageSpan;", "spanInit", "a", "core_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class RichTextViewKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(RichTextView richTextView, Function1<? super ImageSpan, Unit> spanInit) {
        Intrinsics.checkNotNullParameter(richTextView, "<this>");
        Intrinsics.checkNotNullParameter(spanInit, "spanInit");
        ImageSpan imageSpan = new ImageSpan();
        spanInit.invoke(imageSpan);
        imageSpan.D(richTextView);
        ((RichTextAttr) richTextView.getViewAttr()).addSpan$core_release(imageSpan);
    }

    public static final void b(ViewContainer<?, ?> viewContainer, final Function1<? super RichTextView, Unit> init) {
        Intrinsics.checkNotNullParameter(viewContainer, "<this>");
        Intrinsics.checkNotNullParameter(init, "init");
        DeclarativeBaseView<?, ?> createViewFromRegister = viewContainer.createViewFromRegister("RichTextView");
        RichTextView richTextView = createViewFromRegister instanceof RichTextView ? (RichTextView) createViewFromRegister : null;
        if (richTextView == null) {
            richTextView = new RichTextView();
        }
        viewContainer.addChild(richTextView, new Function1<RichTextView, Unit>() { // from class: com.tencent.kuikly.core.views.RichTextViewKt$RichText$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RichTextView richTextView2) {
                invoke2(richTextView2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final RichTextView addChild) {
                Intrinsics.checkNotNullParameter(addChild, "$this$addChild");
                ReactiveObserver.Companion companion = ReactiveObserver.INSTANCE;
                final Function1<RichTextView, Unit> function1 = init;
                companion.b(addChild, new Function1<Boolean, Unit>() { // from class: com.tencent.kuikly.core.views.RichTextViewKt$RichText$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public final void invoke(boolean z16) {
                        ((RichTextAttr) RichTextView.this.getViewAttr()).resetSpans$core_release();
                        RichTextView.this.setWillInit$core_release(true);
                        function1.invoke(RichTextView.this);
                        RichTextView.this.setWillInit$core_release(false);
                        RichTextView.this.getFlexNode().a0();
                    }
                });
                Function1<RichTextAttr, Unit> attrInitBlock$core_release = addChild.getAttrInitBlock$core_release();
                if (attrInitBlock$core_release != null) {
                    addChild.attr(attrInitBlock$core_release);
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void c(RichTextView richTextView, Function1<? super cf, Unit> textSpanInit) {
        Intrinsics.checkNotNullParameter(richTextView, "<this>");
        Intrinsics.checkNotNullParameter(textSpanInit, "textSpanInit");
        cf cfVar = new cf();
        cfVar.setPagerId(richTextView.getPagerId());
        textSpanInit.invoke(cfVar);
        ((RichTextAttr) richTextView.getViewAttr()).addSpan$core_release(cfVar);
    }
}
