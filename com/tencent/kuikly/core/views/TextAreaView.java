package com.tencent.kuikly.core.views;

import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.RenderView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J)\u0010\u0013\u001a\u00020\u00042!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00040\rJ\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000eJ)\u0010\u0018\u001a\u00020\u00042!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00040\r\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/kuikly/core/views/TextAreaView;", "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "Lcom/tencent/kuikly/core/views/cc;", "Lcom/tencent/kuikly/core/views/TextAreaEvent;", "", "willInit", "i", "j", "", "viewName", "createRenderView", "l", tl.h.F, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cursorIndex", "callback", "k", "index", DomainData.DOMAIN_NAME, "", "height", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class TextAreaView extends DeclarativeBaseView<cc, TextAreaEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public void createRenderView() {
        super.createRenderView();
        if (((cc) getAttr()).getAutofocus()) {
            l();
        }
    }

    public final void h() {
        performTaskWhenRenderViewDidLoad(new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.TextAreaView$blur$1
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
                RenderView renderView = TextAreaView.this.getRenderView();
                if (renderView != null) {
                    RenderView.b(renderView, "blur", "", null, 4, null);
                }
            }
        });
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public cc createAttr() {
        return new cc();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public TextAreaEvent createEvent() {
        return new TextAreaEvent();
    }

    public final void k(final Function1<? super Integer, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        performTaskWhenRenderViewDidLoad(new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.TextAreaView$cursorIndex$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                RenderView renderView = TextAreaView.this.getRenderView();
                if (renderView != null) {
                    final Function1<Integer, Unit> function1 = callback;
                    renderView.a("getCursorIndex", "", new Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit>() { // from class: com.tencent.kuikly.core.views.TextAreaView$cursorIndex$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar) {
                            invoke2(eVar);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(com.tencent.kuikly.core.nvi.serialization.json.e eVar) {
                            function1.invoke(Integer.valueOf(eVar != null ? eVar.j("cursorIndex") : -1));
                        }
                    });
                }
            }
        });
    }

    public final void l() {
        performTaskWhenRenderViewDidLoad(new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.TextAreaView$focus$1
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
                RenderView renderView = TextAreaView.this.getRenderView();
                if (renderView != null) {
                    RenderView.b(renderView, WSPublicAccReport.SOP_NAME_FOCUS, "", null, 4, null);
                }
            }
        });
    }

    public final void m(final Function1<? super Float, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        performTaskWhenRenderViewDidLoad(new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.TextAreaView$getInnerContentHeight$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                RenderView renderView = TextAreaView.this.getRenderView();
                if (renderView != null) {
                    final Function1<Float, Unit> function1 = callback;
                    RenderView.b(renderView, "getInnerContentHeight", null, new Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit>() { // from class: com.tencent.kuikly.core.views.TextAreaView$getInnerContentHeight$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar) {
                            invoke2(eVar);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(com.tencent.kuikly.core.nvi.serialization.json.e eVar) {
                            function1.invoke(Float.valueOf((float) (eVar != null ? eVar.h("height") : 0.0d)));
                        }
                    }, 2, null);
                }
            }
        });
    }

    public final void n(final int index) {
        performTaskWhenRenderViewDidLoad(new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.TextAreaView$setCursorIndex$1
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
                RenderView renderView = TextAreaView.this.getRenderView();
                if (renderView != null) {
                    RenderView.b(renderView, "setCursorIndex", String.valueOf(index), null, 4, null);
                }
            }
        });
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public String viewName() {
        return "KRTextAreaView";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public void willInit() {
        super.willInit();
        cc.n((cc) getViewAttr(), 15, null, 2, null);
    }
}
