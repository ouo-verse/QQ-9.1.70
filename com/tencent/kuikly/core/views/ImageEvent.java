package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.base.event.Event;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u0006\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/kuikly/core/views/ImageEvent;", "Lcom/tencent/kuikly/core/base/event/Event;", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/views/au;", "", "handler", "j", "Lcom/tencent/kuikly/core/views/at;", "i", "Lcom/tencent/kuikly/core/views/as;", tl.h.F, "<init>", "()V", "a", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class ImageEvent extends Event {
    /* JADX WARN: Multi-variable type inference failed */
    public final void h(final Function1<? super LoadFailureParams, Unit> handler) {
        af afVar;
        Intrinsics.checkNotNullParameter(handler, "handler");
        AbstractBaseView<?, ?> view = getView();
        ImageView imageView = view instanceof ImageView ? (ImageView) view : null;
        if (imageView != null && (afVar = (af) imageView.getViewAttr()) != null) {
            afVar.m();
        }
        register("loadFailure", new Function1<Object, Unit>() { // from class: com.tencent.kuikly.core.views.ImageEvent$loadFailure$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                handler.invoke(LoadFailureParams.INSTANCE.a(obj));
            }
        });
    }

    public void i(final Function1<? super LoadResolutionParams, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        register("loadResolution", new Function1<Object, Unit>() { // from class: com.tencent.kuikly.core.views.ImageEvent$loadResolution$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                handler.invoke(LoadResolutionParams.INSTANCE.a(obj));
            }
        });
    }

    public void j(final Function1<? super LoadSuccessParams, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        register("loadSuccess", new Function1<Object, Unit>() { // from class: com.tencent.kuikly.core.views.ImageEvent$loadSuccess$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                handler.invoke(LoadSuccessParams.INSTANCE.a(obj));
                AbstractBaseView<?, ?> view = this.getView();
                ImageView imageView = view instanceof ImageView ? (ImageView) view : null;
                if (imageView != null) {
                    imageView.h();
                }
            }
        });
    }
}
