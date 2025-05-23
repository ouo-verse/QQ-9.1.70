package com.tencent.kuikly.core.directives;

import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.VirtualViewKt;
import com.tencent.kuikly.core.reactive.ReactiveObserver;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B0\u0012\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u000e\u00a2\u0006\u0002\b\u000f\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016R\u001c\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR%\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u000e\u00a2\u0006\u0002\b\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/kuikly/core/directives/BindDirectivesView;", "Lcom/tencent/kuikly/core/directives/a;", "", ReportConstant.COSTREPORT_PREFIX, "t", "u", "v", "didInit", "didRemoveFromParentView", "Lkotlin/Function0;", "", "a", "Lkotlin/jvm/functions/Function0;", "bindValue", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "b", "Lkotlin/jvm/functions/Function1;", "creator", "c", "Ljava/lang/Object;", "bindValueResult", "", "d", "Z", "isDidInit", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class BindDirectivesView extends a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Function0<Object> bindValue;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Function1<BindDirectivesView, Unit> creator;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Object bindValueResult;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isDidInit;

    /* JADX WARN: Multi-variable type inference failed */
    public BindDirectivesView(Function0<? extends Object> bindValue, Function1<? super BindDirectivesView, Unit> creator) {
        Intrinsics.checkNotNullParameter(bindValue, "bindValue");
        Intrinsics.checkNotNullParameter(creator, "creator");
        this.bindValue = bindValue;
        this.creator = creator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s() {
        this.creator.invoke(this);
        u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        v();
        removeChildren();
    }

    private final void u() {
        DeclarativeBaseView<?, ?> declarativeBaseView;
        int indexOf;
        ViewContainer<?, ?> h16 = h();
        if (h16 != null) {
            List<DeclarativeBaseView<?, ?>> a16 = VirtualViewKt.a(h16);
            Iterator<T> it = VirtualViewKt.a(this).iterator();
            while (it.hasNext() && (indexOf = a16.indexOf((declarativeBaseView = (DeclarativeBaseView) it.next()))) >= 0 && indexOf < a16.size()) {
                h16.insertDomSubView(declarativeBaseView, indexOf);
            }
        }
    }

    private final void v() {
        ViewContainer<?, ?> h16 = h();
        if (h16 != null) {
            Iterator<T> it = VirtualViewKt.a(this).iterator();
            while (it.hasNext()) {
                h16.removeDomSubView((DeclarativeBaseView) it.next());
            }
        }
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public void didInit() {
        super.didInit();
        ReactiveObserver.INSTANCE.b(this, new Function1<Boolean, Unit>() { // from class: com.tencent.kuikly.core.directives.BindDirectivesView$didInit$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                Function0 function0;
                Object obj;
                boolean z17;
                function0 = BindDirectivesView.this.bindValue;
                final Object invoke = function0.invoke();
                obj = BindDirectivesView.this.bindValueResult;
                if (Intrinsics.areEqual(invoke, obj)) {
                    return;
                }
                BindDirectivesView.this.bindValueResult = invoke;
                z17 = BindDirectivesView.this.isDidInit;
                if (z17) {
                    ReactiveObserver.Companion companion = ReactiveObserver.INSTANCE;
                    final BindDirectivesView bindDirectivesView = BindDirectivesView.this;
                    companion.a(new Function0<Unit>() { // from class: com.tencent.kuikly.core.directives.BindDirectivesView$didInit$1.1
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
                            Object obj2;
                            Object obj3;
                            Object obj4 = invoke;
                            obj2 = bindDirectivesView.bindValueResult;
                            if (Intrinsics.areEqual(obj4, obj2)) {
                                bindDirectivesView.t();
                                obj3 = bindDirectivesView.bindValueResult;
                                if (obj3 != null) {
                                    bindDirectivesView.s();
                                }
                            }
                        }
                    });
                }
            }
        });
        this.isDidInit = true;
        if (this.bindValueResult != null) {
            this.creator.invoke(this);
        }
    }

    @Override // com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.DeclarativeBaseView
    public void didRemoveFromParentView() {
        super.didRemoveFromParentView();
    }
}
