package com.tencent.kuikly.core.views;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.PanGestureParams;
import com.tencent.kuikly.core.views.co;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b)\u0010*J,\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u001c\u0010\u000b\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J$\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\u001c\u0010\f\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\u001c\u0010\r\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\u001c\u0010\u000e\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\u001c\u0010\u0010\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J@\u0010\u0017\u001a\u00020\u000626\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u0011H\u0016J\u001c\u0010\u0019\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00060\u0004H\u0016R\"\u0010\u001a\u001a\u00020\b8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fRT\u0010 \u001a4\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00118\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010&\u001a\u00020\b8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u001b\u001a\u0004\b'\u0010\u001d\"\u0004\b(\u0010\u001f\u00a8\u0006+"}, d2 = {"Lcom/tencent/kuikly/core/views/ScrollerEvent;", "Lcom/tencent/kuikly/core/base/event/Event;", "", AdMetricTag.EVENT_NAME, "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/views/bn;", "", "handler", "", "sync", "registerScrollerEvent", "scroll", "scrollEnd", "dragBegin", "dragEnd", "Lcom/tencent/kuikly/core/views/co;", "willDragEndBySync", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "contentSizeChanged", "Lcom/tencent/kuikly/core/base/event/h;", "pan", "syncScroll", "Z", "getSyncScroll$core_release", "()Z", "setSyncScroll$core_release", "(Z)V", "contentSizeChangedHandlerFn", "Lkotlin/jvm/functions/Function2;", "getContentSizeChangedHandlerFn$core_release", "()Lkotlin/jvm/functions/Function2;", "setContentSizeChangedHandlerFn$core_release", "(Lkotlin/jvm/functions/Function2;)V", "didSetPanDirectionGesture", "getDidSetPanDirectionGesture$core_release", "setDidSetPanDirectionGesture$core_release", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class ScrollerEvent extends Event {
    private Function2<? super Float, ? super Float, Unit> contentSizeChangedHandlerFn;
    private boolean didSetPanDirectionGesture;
    private boolean syncScroll;

    private final void registerScrollerEvent(String eventName, final Function1<? super ScrollParams, Unit> handler, boolean sync) {
        register(eventName, new Function1<Object, Unit>() { // from class: com.tencent.kuikly.core.views.ScrollerEvent$registerScrollerEvent$1
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
                if (obj instanceof com.tencent.kuikly.core.nvi.serialization.json.e) {
                    handler.invoke(ScrollParams.INSTANCE.a((com.tencent.kuikly.core.nvi.serialization.json.e) obj));
                } else if (obj instanceof ScrollParams) {
                    handler.invoke(obj);
                }
            }
        }, sync);
    }

    public void contentSizeChanged(Function2<? super Float, ? super Float, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.contentSizeChangedHandlerFn = handler;
    }

    public void dragBegin(Function1<? super ScrollParams, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        registerScrollerEvent("dragBegin", handler, false);
    }

    public void dragEnd(Function1<? super ScrollParams, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        registerScrollerEvent("dragEnd", handler, false);
    }

    public final Function2<Float, Float, Unit> getContentSizeChangedHandlerFn$core_release() {
        return this.contentSizeChangedHandlerFn;
    }

    /* renamed from: getDidSetPanDirectionGesture$core_release, reason: from getter */
    public final boolean getDidSetPanDirectionGesture() {
        return this.didSetPanDirectionGesture;
    }

    /* renamed from: getSyncScroll$core_release, reason: from getter */
    public final boolean getSyncScroll() {
        return this.syncScroll;
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [com.tencent.kuikly.core.base.Attr] */
    @Override // com.tencent.kuikly.core.base.event.Event
    public void pan(final Function1<? super PanGestureParams, Unit> handler) {
        ?? viewAttr;
        Intrinsics.checkNotNullParameter(handler, "handler");
        AbstractBaseView<?, ?> view = getView();
        Integer panDirection = (view == null || (viewAttr = view.getViewAttr()) == 0) ? null : viewAttr.getPanDirection();
        if (panDirection != null && panDirection.intValue() != 0) {
            this.didSetPanDirectionGesture = true;
        }
        if (this.didSetPanDirectionGesture) {
            AbstractBaseView<?, ?> view2 = getView();
            final ScrollerView scrollerView = view2 instanceof ScrollerView ? (ScrollerView) view2 : null;
            if (scrollerView != null) {
                scrollerView.performTaskWhenContentViewDidCreated(new Function1<ScrollerContentView, Unit>() { // from class: com.tencent.kuikly.core.views.ScrollerEvent$pan$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ScrollerContentView scrollerContentView) {
                        invoke2(scrollerContentView);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Type inference failed for: r2v3, types: [com.tencent.kuikly.core.base.event.Event] */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ScrollerContentView it) {
                        ?? viewEvent;
                        Intrinsics.checkNotNullParameter(it, "it");
                        ScrollerContentView contentView = scrollerView.getContentView();
                        if (contentView == null || (viewEvent = contentView.getViewEvent()) == 0) {
                            return;
                        }
                        viewEvent.pan(handler);
                    }
                });
                return;
            }
            return;
        }
        super.pan(handler);
    }

    public void scroll(Function1<? super ScrollParams, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        scroll(false, handler);
    }

    public void scrollEnd(Function1<? super ScrollParams, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        registerScrollerEvent("scrollEnd", handler, false);
    }

    public final void setContentSizeChangedHandlerFn$core_release(Function2<? super Float, ? super Float, Unit> function2) {
        this.contentSizeChangedHandlerFn = function2;
    }

    public final void setDidSetPanDirectionGesture$core_release(boolean z16) {
        this.didSetPanDirectionGesture = z16;
    }

    public final void setSyncScroll$core_release(boolean z16) {
        this.syncScroll = z16;
    }

    public void willDragEndBySync(final Function1<? super co, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        register("willDragEnd", new Function1<Object, Unit>() { // from class: com.tencent.kuikly.core.views.ScrollerEvent$willDragEndBySync$1
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
                if (obj instanceof com.tencent.kuikly.core.nvi.serialization.json.e) {
                    Function1<co, Unit> function1 = handler;
                    co.Companion companion = co.INSTANCE;
                    com.tencent.kuikly.core.nvi.serialization.json.e eVar = (com.tencent.kuikly.core.nvi.serialization.json.e) obj;
                    AbstractBaseView<?, ?> view = this.getView();
                    function1.invoke(companion.a(eVar, view instanceof ScrollerView ? (ScrollerView) view : null));
                    return;
                }
                if (obj instanceof co) {
                    handler.invoke(obj);
                }
            }
        }, true);
    }

    public void scroll(boolean sync, Function1<? super ScrollParams, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.syncScroll = sync;
        registerScrollerEvent("scroll", handler, sync);
    }
}
