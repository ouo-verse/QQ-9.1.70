package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.RenderView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/kuikly/core/views/APNGVView;", "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "Lcom/tencent/kuikly/core/views/a;", "Lcom/tencent/kuikly/core/views/b;", tl.h.F, "i", "", "viewName", "", "play", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class APNGVView extends DeclarativeBaseView<a, b> {
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public a createAttr() {
        return new a();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public b createEvent() {
        return new b();
    }

    public final void play() {
        performTaskWhenRenderViewDidLoad(new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.APNGVView$play$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                RenderView renderView = APNGVView.this.getRenderView();
                if (renderView != null) {
                    RenderView.b(renderView, "play", "", null, 4, null);
                }
            }
        });
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public String viewName() {
        return "KRAPNGView";
    }
}
