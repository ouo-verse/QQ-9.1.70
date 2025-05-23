package com.tencent.kuikly.core.base;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.kuikly.core.base.ComposeViewLifecycle;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.views.internal.GroupView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005B\u0007\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u001a\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J%\u0010\u001e\u001a\u001f\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001b\u0012\u0004\u0012\u00020\u00060\u001aj\u0002`\u001c\u00a2\u0006\u0002\b\u001dH&R\u0016\u0010\u001f\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001b\u0010&\u001a\u00020!8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0011\u0010*\u001a\u00020'8F\u00a2\u0006\u0006\u001a\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/kuikly/core/base/ComposeView;", "Lcom/tencent/kuikly/core/base/k;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/kuikly/core/base/l;", "E", "Lcom/tencent/kuikly/core/views/internal/GroupView;", "", "created", "viewWillLoad", "viewDidLoad", "viewDidLayout", "viewWillUnload", "viewDidUnload", "viewDestroyed", "willInit", "didInit", "willRemoveFromParentView", "didRemoveFromParentView", "", "viewName", "", "isRenderView", AdMetricTag.EVENT_NAME, "", "param", "emit", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/base/ViewContainer;", "Lcom/tencent/kuikly/core/base/ViewBuilder;", "Lkotlin/ExtensionFunctionType;", "body", "needLifecycle", "Z", "Lcom/tencent/kuikly/core/base/ComposeViewLifecycle;", "lifecycle$delegate", "Lkotlin/Lazy;", "getLifecycle", "()Lcom/tencent/kuikly/core/base/ComposeViewLifecycle;", "lifecycle", "Lcom/tencent/kuikly/core/pager/g;", "getPagerData", "()Lcom/tencent/kuikly/core/pager/g;", "pagerData", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public abstract class ComposeView<A extends k, E extends l> extends GroupView<A, E> {

    /* renamed from: lifecycle$delegate, reason: from kotlin metadata */
    private final Lazy lifecycle = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ComposeViewLifecycle>(this) { // from class: com.tencent.kuikly.core.base.ComposeView$lifecycle$2
        final /* synthetic */ ComposeView<A, E> this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ComposeViewLifecycle invoke() {
            ((ComposeView) this.this$0).needLifecycle = true;
            return new ComposeViewLifecycle();
        }
    });
    private boolean needLifecycle;

    public abstract Function1<ViewContainer<?, ?>, Unit> body();

    public void created() {
        if (this.needLifecycle) {
            getLifecycle().a(ComposeViewLifecycle.Stage.CREATED);
        }
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public void didInit() {
        super.didInit();
        created();
        viewWillLoad();
        body().invoke(this);
        viewDidLoad();
        getPager().addTaskWhenPagerUpdateLayoutFinish(new Function0<Unit>(this) { // from class: com.tencent.kuikly.core.base.ComposeView$didInit$1
            final /* synthetic */ ComposeView<A, E> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.viewDidLayout();
            }
        });
    }

    @Override // com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.DeclarativeBaseView
    public void didRemoveFromParentView() {
        super.didRemoveFromParentView();
        viewDidUnload();
        viewDestroyed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void emit(String eventName, Object param) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        ((l) getEvent()).onFireEvent(eventName, param);
    }

    public final ComposeViewLifecycle getLifecycle() {
        return (ComposeViewLifecycle) this.lifecycle.getValue();
    }

    public final com.tencent.kuikly.core.pager.g getPagerData() {
        return getPager().getPageData();
    }

    @Override // com.tencent.kuikly.core.views.internal.GroupView, com.tencent.kuikly.core.base.DeclarativeBaseView
    public boolean isRenderView() {
        return isRenderViewForFlatLayer$core_release();
    }

    public void viewDestroyed() {
        if (this.needLifecycle) {
            getLifecycle().a(ComposeViewLifecycle.Stage.VIEW_DESTROYED);
        }
    }

    public void viewDidLayout() {
        if (this.needLifecycle) {
            getLifecycle().a(ComposeViewLifecycle.Stage.VIEW_DID_LAYOUT);
        }
    }

    public void viewDidLoad() {
        if (this.needLifecycle) {
            getLifecycle().a(ComposeViewLifecycle.Stage.VIEW_DID_LOAD);
        }
    }

    public void viewDidUnload() {
        if (this.needLifecycle) {
            getLifecycle().a(ComposeViewLifecycle.Stage.VIEW_DID_UNLOAD);
        }
    }

    @Override // com.tencent.kuikly.core.views.internal.GroupView, com.tencent.kuikly.core.base.AbstractBaseView
    public String viewName() {
        return "KRView";
    }

    public void viewWillLoad() {
        if (this.needLifecycle) {
            getLifecycle().a(ComposeViewLifecycle.Stage.VIEW_WILL_LOAD);
        }
    }

    public void viewWillUnload() {
        if (this.needLifecycle) {
            getLifecycle().a(ComposeViewLifecycle.Stage.VIEW_WILL_UNLOAD);
        }
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public void willInit() {
        super.willInit();
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public void willRemoveFromParentView() {
        super.willRemoveFromParentView();
        viewWillUnload();
    }
}
