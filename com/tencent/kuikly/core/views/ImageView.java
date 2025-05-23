package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.base.DeclarativeBaseView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\nJ\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u000f\u0010\t\u001a\u00020\bH\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0000\u00a2\u0006\u0004\b\u000b\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/kuikly/core/views/ImageView;", "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "Lcom/tencent/kuikly/core/views/af;", "Lcom/tencent/kuikly/core/views/ImageEvent;", "i", "j", "", "viewName", "", tl.h.F, "()V", "k", "<init>", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class ImageView extends DeclarativeBaseView<af, ImageEvent> {
    public final void h() {
        didSetProp("placeholder", "");
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public af createAttr() {
        return new af();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public ImageEvent createEvent() {
        return new ImageEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k() {
        if (((ImageEvent) getViewEvent()).handlerWithEventName("loadSuccess") == null) {
            ((ImageEvent) getViewEvent()).j(new Function1<LoadSuccessParams, Unit>() { // from class: com.tencent.kuikly.core.views.ImageView$setClearPlaceholderHandler$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LoadSuccessParams loadSuccessParams) {
                    invoke2(loadSuccessParams);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LoadSuccessParams it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ImageView.this.h();
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public String viewName() {
        if (((af) getAttr()).getShouldWrapper() && getPager().getPageData().getNativeBuild() >= 1) {
            return "KRWrapperImageView";
        }
        return "KRImageView";
    }
}
