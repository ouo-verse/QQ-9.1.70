package com.tencent.ntcompose.core;

import androidx.compose.runtime.Composer;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J%\u0010\u000b\u001a\u001f\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b\u0012\u0004\u0012\u00020\u00040\u0007j\u0002`\t\u00a2\u0006\u0002\b\nH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016R\u001b\u0010\u0013\u001a\u00020\u000e8@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ntcompose/core/KuiklyNTComposeView;", "Lcom/tencent/kuikly/core/base/ComposeView;", "Lcom/tencent/ntcompose/core/g;", "Lcom/tencent/ntcompose/core/h;", "", "willInit", "didRemoveFromParentView", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/base/ViewContainer;", "Lcom/tencent/kuikly/core/base/ViewBuilder;", "Lkotlin/ExtensionFunctionType;", "body", tl.h.F, "i", "Lcom/tencent/ntcompose/core/ComposeRenderCore;", "a", "Lkotlin/Lazy;", "j", "()Lcom/tencent/ntcompose/core/ComposeRenderCore;", "composeRenderCore", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class KuiklyNTComposeView extends ComposeView<g, h> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy composeRenderCore;

    public KuiklyNTComposeView() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ComposeRenderCore>() { // from class: com.tencent.ntcompose.core.KuiklyNTComposeView$composeRenderCore$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ComposeRenderCore invoke() {
                return new ComposeRenderCore();
            }
        });
        this.composeRenderCore = lazy;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.ntcompose.core.KuiklyNTComposeView$body$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer) {
                invoke2(viewContainer);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ViewContainer<?, ?> viewContainer) {
                Intrinsics.checkNotNullParameter(viewContainer, "$this$null");
                Function2<Composer, Integer, Unit> h16 = ((g) KuiklyNTComposeView.this.getViewAttr()).h();
                if (h16 != null) {
                    KuiklyNTComposeView kuiklyNTComposeView = KuiklyNTComposeView.this;
                    kuiklyNTComposeView.j().b(viewContainer, h16);
                    ((g) kuiklyNTComposeView.getViewAttr()).j(null);
                }
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.ComposeView, com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.DeclarativeBaseView
    public void didRemoveFromParentView() {
        super.didRemoveFromParentView();
        j().a();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public g createAttr() {
        return new g();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public h createEvent() {
        return new h();
    }

    public final ComposeRenderCore j() {
        return (ComposeRenderCore) this.composeRenderCore.getValue();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView, com.tencent.kuikly.core.base.AbstractBaseView
    public void willInit() {
        super.willInit();
    }
}
