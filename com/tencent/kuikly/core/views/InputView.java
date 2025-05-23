package com.tencent.kuikly.core.views;

import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.RenderView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/kuikly/core/views/InputView;", "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "Lcom/tencent/kuikly/core/views/ai;", "Lcom/tencent/kuikly/core/views/InputEvent;", "i", "j", "", "viewName", "", "createRenderView", "text", IECSearchBar.METHOD_SET_TEXT, "k", tl.h.F, "", "index", "l", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class InputView extends DeclarativeBaseView<ai, InputEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public void createRenderView() {
        super.createRenderView();
        if (((ai) getAttr()).getAutofocus()) {
            k();
        }
    }

    public final void h() {
        performTaskWhenRenderViewDidLoad(new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.InputView$blur$1
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
                RenderView renderView = InputView.this.getRenderView();
                if (renderView != null) {
                    RenderView.b(renderView, "blur", "", null, 4, null);
                }
            }
        });
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public ai createAttr() {
        return new ai();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public InputEvent createEvent() {
        return new InputEvent();
    }

    public final void k() {
        performTaskWhenRenderViewDidLoad(new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.InputView$focus$1
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
                RenderView renderView = InputView.this.getRenderView();
                if (renderView != null) {
                    RenderView.b(renderView, WSPublicAccReport.SOP_NAME_FOCUS, "", null, 4, null);
                }
            }
        });
    }

    public final void l(final int index) {
        performTaskWhenRenderViewDidLoad(new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.InputView$setCursorIndex$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                RenderView renderView = InputView.this.getRenderView();
                if (renderView != null) {
                    RenderView.b(renderView, "setCursorIndex", String.valueOf(index), null, 4, null);
                }
            }
        });
    }

    public final void setText(final String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        performTaskWhenRenderViewDidLoad(new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.InputView$setText$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                RenderView renderView = InputView.this.getRenderView();
                if (renderView != null) {
                    RenderView.b(renderView, IECSearchBar.METHOD_SET_TEXT, text, null, 4, null);
                }
            }
        });
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public String viewName() {
        return "KRTextFieldView";
    }
}
