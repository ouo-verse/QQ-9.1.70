package com.tencent.kuikly.core.base;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.layout.FlexNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\n\b&\u0018\u0000 h*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u00052\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00062\u00020\u00072\u00020\b:\u0001iB\u0007\u00a2\u0006\u0004\bf\u0010gJ\b\u0010\n\u001a\u00020\tH\u0002J\u000f\u0010\u000b\u001a\u00028\u0001H\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b\u000f\u0010\fJ!\u0010\u0013\u001a\u00020\t2\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\t0\u0010\u00a2\u0006\u0002\b\u0011H\u0016J\"\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0010\u0010\u0017\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0019H&J\b\u0010\u001b\u001a\u00020\tH\u0016J\b\u0010\u001c\u001a\u00020\tH\u0016J\u000f\u0010\u001d\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u001d\u0010\u000eJ\u000f\u0010\u001e\u001a\u00028\u0001H&\u00a2\u0006\u0004\b\u001e\u0010\fJ\b\u0010 \u001a\u00020\u001fH&J\u001a\u0010#\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\b\u0010$\u001a\u00020\tH\u0016J\b\u0010%\u001a\u00020\tH\u0016J\u0010\u0010&\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u000f\u0010'\u001a\u00028\u0000H\u0004\u00a2\u0006\u0004\b'\u0010\u000eJ\u000f\u0010+\u001a\u00020(H\u0010\u00a2\u0006\u0004\b)\u0010*J\u0018\u0010.\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\u0007H\u0016J\u0018\u0010/\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\u0007H\u0016J\u0014\u00102\u001a\u00020\t2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\t00J\u0006\u00103\u001a\u00020\tJI\u0010:\u001a\u00020\t2\u0006\u00104\u001a\u00020\u001f2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u001f2-\b\u0002\u00109\u001a'\u0012\u0015\u0012\u0013\u0018\u00010!\u00a2\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\t\u0018\u00010\u0010j\u0004\u0018\u0001`8R\u0017\u0010<\u001a\u00020;8\u0006\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\"\u0010@\u001a\u00020;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010=\u001a\u0004\bA\u0010?\"\u0004\bB\u0010CR\"\u0010D\u001a\u00020\u001f8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010J\u001a\u00020\u00148\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001b\u0010S\u001a\u00028\u00008DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010\u000eR\u001b\u0010\u0013\u001a\u00028\u00018DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\bT\u0010Q\u001a\u0004\bU\u0010\fR\u001b\u0010X\u001a\u00020(8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bV\u0010Q\u001a\u0004\bW\u0010*R$\u0010Z\u001a\u0004\u0018\u00010Y8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R'\u0010d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t000`8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\ba\u0010Q\u001a\u0004\bb\u0010cR\u0014\u0010\u0015\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\be\u0010M\u00a8\u0006j"}, d2 = {"Lcom/tencent/kuikly/core/base/AbstractBaseView;", "Lcom/tencent/kuikly/core/base/Attr;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/kuikly/core/base/event/Event;", "E", "Lcom/tencent/kuikly/core/base/BaseObject;", "Lcom/tencent/kuikly/core/base/q;", "", "Lcom/tencent/kuikly/core/base/p;", "", "injectDebugName", "internalCreateEvent", "()Lcom/tencent/kuikly/core/base/event/Event;", "getViewAttr", "()Lcom/tencent/kuikly/core/base/Attr;", "getViewEvent", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "init", "event", "Lcom/tencent/kuikly/core/layout/d;", AIInput.KEY_FRAME, "Lcom/tencent/kuikly/core/base/ViewContainer;", "toView", "convertFrame", "Lcom/tencent/kuikly/core/pager/b;", "getPager", "willInit", "didInit", "createAttr", "createEvent", "", "viewName", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "data", "onFireEvent", "createFlexNode", "removeFlexNode", "layoutFrameDidChanged", "internalCreateAttr", "Lcom/tencent/kuikly/core/layout/FlexNode;", "internalCreateFlexNode$core_release", "()Lcom/tencent/kuikly/core/layout/FlexNode;", "internalCreateFlexNode", "propKey", "propValue", "didSetProp", "syncProp", "Lkotlin/Function0;", "task", "performTaskWhenRenderViewDidLoad", "performRenderViewLazyTasks", "methodName", "params", "Lkotlin/ParameterName;", "name", "Lcom/tencent/kuikly/core/module/CallbackFn;", "callback", "callRenderViewMethod", "", "nativeRef", "I", "getNativeRef", "()I", "parentRef", "getParentRef", "setParentRef", "(I)V", "pagerId", "Ljava/lang/String;", "getPagerId", "()Ljava/lang/String;", "setPagerId", "(Ljava/lang/String;)V", "layoutFrame", "Lcom/tencent/kuikly/core/layout/d;", "getLayoutFrame", "()Lcom/tencent/kuikly/core/layout/d;", "setLayoutFrame", "(Lcom/tencent/kuikly/core/layout/d;)V", "attr$delegate", "Lkotlin/Lazy;", "getAttr", "attr", "event$delegate", "getEvent", "flexNode$delegate", "getFlexNode", "flexNode", "Lcom/tencent/kuikly/core/base/RenderView;", "renderView", "Lcom/tencent/kuikly/core/base/RenderView;", "getRenderView", "()Lcom/tencent/kuikly/core/base/RenderView;", "setRenderView", "(Lcom/tencent/kuikly/core/base/RenderView;)V", "", "renderViewLazyTasks$delegate", "getRenderViewLazyTasks", "()Ljava/util/List;", "renderViewLazyTasks", "getFrame", "<init>", "()V", "Companion", "a", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public abstract class AbstractBaseView<A extends Attr, E extends Event> extends BaseObject implements q<A, E>, p {
    private static int nativeRefProducer;

    /* renamed from: attr$delegate, reason: from kotlin metadata */
    private final Lazy attr;

    /* renamed from: event$delegate, reason: from kotlin metadata */
    private final Lazy event;

    /* renamed from: flexNode$delegate, reason: from kotlin metadata */
    private final Lazy flexNode;
    private com.tencent.kuikly.core.layout.d layoutFrame;
    private final int nativeRef;
    private String pagerId;
    private int parentRef;
    private RenderView renderView;

    /* renamed from: renderViewLazyTasks$delegate, reason: from kotlin metadata */
    private final Lazy renderViewLazyTasks;

    public AbstractBaseView() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        int i3 = nativeRefProducer + 1;
        nativeRefProducer = i3;
        this.nativeRef = i3;
        this.pagerId = "";
        this.layoutFrame = com.tencent.kuikly.core.layout.d.INSTANCE.a();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<A>(this) { // from class: com.tencent.kuikly.core.base.AbstractBaseView$attr$2
            final /* synthetic */ AbstractBaseView<A, E> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Incorrect return type in method signature: ()TA; */
            @Override // kotlin.jvm.functions.Function0
            public final Attr invoke() {
                return this.this$0.internalCreateAttr();
            }
        });
        this.attr = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<E>(this) { // from class: com.tencent.kuikly.core.base.AbstractBaseView$event$2
            final /* synthetic */ AbstractBaseView<A, E> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Incorrect return type in method signature: ()TE; */
            @Override // kotlin.jvm.functions.Function0
            public final Event invoke() {
                Event internalCreateEvent;
                internalCreateEvent = this.this$0.internalCreateEvent();
                return internalCreateEvent;
            }
        });
        this.event = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<FlexNode>(this) { // from class: com.tencent.kuikly.core.base.AbstractBaseView$flexNode$2
            final /* synthetic */ AbstractBaseView<A, E> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FlexNode invoke() {
                return this.this$0.internalCreateFlexNode$core_release();
            }
        });
        this.flexNode = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<ArrayList<Function0<? extends Unit>>>() { // from class: com.tencent.kuikly.core.base.AbstractBaseView$renderViewLazyTasks$2
            @Override // kotlin.jvm.functions.Function0
            public final ArrayList<Function0<? extends Unit>> invoke() {
                return new ArrayList<>();
            }
        });
        this.renderViewLazyTasks = lazy4;
    }

    private final List<Function0<Unit>> getRenderViewLazyTasks() {
        return (List) this.renderViewLazyTasks.getValue();
    }

    private final void injectDebugName() {
        A attr = getAttr();
        String simpleName = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
        if (simpleName == null) {
            simpleName = "";
        }
        attr.debugName(simpleName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final E internalCreateEvent() {
        E createEvent = createEvent();
        createEvent.init(getPagerId(), this.nativeRef);
        return createEvent;
    }

    public final void callRenderViewMethod(final String methodName, final String params, final Function1<? super com.tencent.kuikly.core.nvi.serialization.json.e, Unit> callback) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        performTaskWhenRenderViewDidLoad(new Function0<Unit>(this) { // from class: com.tencent.kuikly.core.base.AbstractBaseView$callRenderViewMethod$1
            final /* synthetic */ AbstractBaseView<A, E> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                RenderView renderView = this.this$0.getRenderView();
                if (renderView != null) {
                    renderView.a(methodName, params, callback);
                }
            }
        });
    }

    public com.tencent.kuikly.core.layout.d convertFrame(com.tencent.kuikly.core.layout.d frame, ViewContainer<?, ?> toView) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        return com.tencent.kuikly.core.layout.d.INSTANCE.a();
    }

    public abstract A createAttr();

    public abstract E createEvent();

    public void createFlexNode() {
        final Function1<Boolean, Unit> s16 = getFlexNode().s();
        getFlexNode().u0(new Function1<Boolean, Unit>() { // from class: com.tencent.kuikly.core.base.AbstractBaseView$createFlexNode$1
            /* JADX INFO: Access modifiers changed from: package-private */
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

            public final void invoke(boolean z16) {
                Function1<Boolean, Unit> function1 = s16;
                if (function1 != null) {
                    function1.invoke(Boolean.valueOf(z16));
                }
                final AbstractBaseView<A, E> abstractBaseView = this;
                Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.kuikly.core.base.AbstractBaseView$createFlexNode$1$action$1
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
                        if (abstractBaseView.getLayoutFrame().f() || !abstractBaseView.getFlexNode().getLayoutFrame().equals(abstractBaseView.getLayoutFrame())) {
                            AbstractBaseView<A, E> abstractBaseView2 = abstractBaseView;
                            abstractBaseView2.setLayoutFrame(abstractBaseView2.getFlexNode().getLayoutFrame());
                            AbstractBaseView<A, E> abstractBaseView3 = abstractBaseView;
                            abstractBaseView3.layoutFrameDidChanged(abstractBaseView3.getFlexNode().getLayoutFrame());
                        }
                    }
                };
                if (z16) {
                    this.getPager().addTaskWhenPagerDidCalculateLayout(function0);
                } else {
                    function0.invoke();
                }
            }
        });
    }

    public void didInit() {
        if (getPager().debugUIInspector()) {
            injectDebugName();
        }
    }

    public void didSetProp(String propKey, Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        RenderView renderView = this.renderView;
        if (renderView != null) {
            renderView.k(propKey, propValue);
        }
    }

    public void event(Function1<? super E, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        init.invoke(getEvent());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final A getAttr() {
        return (A) this.attr.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E getEvent() {
        return (E) this.event.getValue();
    }

    public final FlexNode getFlexNode() {
        return (FlexNode) this.flexNode.getValue();
    }

    public com.tencent.kuikly.core.layout.d getFrame() {
        return getFlexNode().getLayoutFrame();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final com.tencent.kuikly.core.layout.d getLayoutFrame() {
        return this.layoutFrame;
    }

    public final int getNativeRef() {
        return this.nativeRef;
    }

    public abstract com.tencent.kuikly.core.pager.b getPager();

    @Override // com.tencent.kuikly.core.base.p
    public String getPagerId() {
        return this.pagerId;
    }

    public final int getParentRef() {
        return this.parentRef;
    }

    public final RenderView getRenderView() {
        return this.renderView;
    }

    public A getViewAttr() {
        return getAttr();
    }

    public E getViewEvent() {
        return getEvent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final A internalCreateAttr() {
        A createAttr = createAttr();
        createAttr.setPagerId(getPagerId());
        createAttr.setNativeRef(this.nativeRef);
        createAttr.setFlexNode(getFlexNode());
        return createAttr;
    }

    public FlexNode internalCreateFlexNode$core_release() {
        FlexNode createFlexNodeInstance = getPager().createFlexNodeInstance();
        return createFlexNodeInstance == null ? new FlexNode() : createFlexNodeInstance;
    }

    public void layoutFrameDidChanged(com.tencent.kuikly.core.layout.d frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
    }

    public void onFireEvent(String event, com.tencent.kuikly.core.nvi.serialization.json.e data) {
        Intrinsics.checkNotNullParameter(event, "event");
        getEvent().onFireEvent(event, data);
    }

    public final void performRenderViewLazyTasks() {
        if (!getRenderViewLazyTasks().isEmpty()) {
            Iterator<T> it = getRenderViewLazyTasks().iterator();
            while (it.hasNext()) {
                ((Function0) it.next()).invoke();
            }
            getRenderViewLazyTasks().clear();
        }
    }

    public final void performTaskWhenRenderViewDidLoad(Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (this.renderView != null) {
            task.invoke();
        } else {
            getRenderViewLazyTasks().add(task);
        }
    }

    public void removeFlexNode() {
        int V;
        FlexNode flexNode = getFlexNode().getCom.tencent.mtt.hippy.views.common.HippyNestedScrollComponent.PRIORITY_PARENT java.lang.String();
        if (flexNode != null && (V = flexNode.V(getFlexNode())) >= 0) {
            flexNode.h0(V);
        }
        getFlexNode().H0(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setLayoutFrame(com.tencent.kuikly.core.layout.d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<set-?>");
        this.layoutFrame = dVar;
    }

    public void setPagerId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pagerId = str;
    }

    public final void setParentRef(int i3) {
        this.parentRef = i3;
    }

    public final void setRenderView(RenderView renderView) {
        this.renderView = renderView;
    }

    public void syncProp(String propKey, Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        RenderView renderView = this.renderView;
        if (renderView != null) {
            renderView.k(propKey, propValue);
        }
    }

    public abstract String viewName();

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void callRenderViewMethod$default(AbstractBaseView abstractBaseView, String str, String str2, Function1 function1, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                str2 = null;
            }
            if ((i3 & 4) != 0) {
                function1 = null;
            }
            abstractBaseView.callRenderViewMethod(str, str2, function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callRenderViewMethod");
    }

    public void willInit() {
    }
}
