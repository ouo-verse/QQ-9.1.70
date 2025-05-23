package com.tencent.kuikly.core.views.layout;

import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.layout.FlexAlign;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/kuikly/core/views/layout/ColumnView;", "Lcom/tencent/kuikly/core/views/layout/b;", "Lcom/tencent/kuikly/core/base/m;", "Lcom/tencent/kuikly/core/base/event/Event;", "", "willInit", h.F, "createEvent", "Lcom/tencent/kuikly/core/layout/FlexAlign;", "a", "Lcom/tencent/kuikly/core/layout/FlexAlign;", "i", "()Lcom/tencent/kuikly/core/layout/FlexAlign;", "j", "(Lcom/tencent/kuikly/core/layout/FlexAlign;)V", "align", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ColumnView extends b<m, Event> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private FlexAlign align = FlexAlign.STRETCH;

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public Event createEvent() {
        return new Event();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public m createAttr() {
        return new m();
    }

    /* renamed from: i, reason: from getter */
    public final FlexAlign getAlign() {
        return this.align;
    }

    public final void j(FlexAlign flexAlign) {
        Intrinsics.checkNotNullParameter(flexAlign, "<set-?>");
        this.align = flexAlign;
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public void willInit() {
        super.willInit();
        attr(new Function1<m, Unit>() { // from class: com.tencent.kuikly.core.views.layout.ColumnView$willInit$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(m mVar) {
                invoke2(mVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(m attr) {
                Intrinsics.checkNotNullParameter(attr, "$this$attr");
                attr.flexDirectionColumn();
                attr.alignItems(ColumnView.this.getAlign());
            }
        });
    }
}
