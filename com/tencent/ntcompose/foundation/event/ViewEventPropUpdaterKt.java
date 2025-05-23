package com.tencent.ntcompose.foundation.event;

import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.LongPressParams;
import com.tencent.kuikly.core.base.event.PanGestureParams;
import com.tencent.kuikly.core.base.w;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.viewpager.event.HippyPageItemExposureEvent;
import com.tencent.ntcompose.core.ModifiersKt;
import com.tencent.ntcompose.core.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\u001aC\u0010\f\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005\u001a\u009d\u0001\u0010\t\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u00052%\b\u0002\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u00052!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005\u001aK\u0010\u0017\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00132!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005\u001a\u001e\u0010\u001a\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\n0\u0005\u001a\u0018\u0010\u001d\u001a\u00020\u0000*\u00020\u00002\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\u001b\u001a-\u0010!\u001a\u00020\u0000*\u00020\u00002!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u001e\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\n0\u0005\u001a/\u0010%\u001a\u00020\u0000*\u00020\u00002!\u0010$\u001a\u001d\u0012\u0013\u0012\u00110\"\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\n0\u0005H\u0007\u001a \u0010(\u001a\u00020\u0000*\u00020\u00002\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\n0\u0005H\u0007\u001a \u0010*\u001a\u00020\u0000*\u00020\u00002\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\n0\u0005H\u0007\u001a-\u0010+\u001a\u00020\u0000*\u00020\u00002!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u001e\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\n0\u0005\u001a3\u00100\u001a\u00020\u0000*\u00020\u00002'\u0010/\u001a#\u0012\u0015\u0012\u0013\u0018\u00010,\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\n0\u0005j\u0002`.\u001a3\u00102\u001a\u00020\u0000*\u00020\u00002'\u00101\u001a#\u0012\u0015\u0012\u0013\u0018\u00010,\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\n0\u0005j\u0002`.\u001a3\u00104\u001a\u00020\u0000*\u00020\u00002'\u00103\u001a#\u0012\u0015\u0012\u0013\u0018\u00010,\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\n0\u0005j\u0002`.\u001a-\u00108\u001a\u00020\u0000*\u00020\u00002!\u00107\u001a\u001d\u0012\u0013\u0012\u001105\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\n0\u0005\u001a3\u0010:\u001a\u00020\u0000*\u00020\u00002'\u00109\u001a#\u0012\u0015\u0012\u0013\u0018\u00010,\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\n0\u0005j\u0002`.\u00a8\u0006;"}, d2 = {"Lcom/tencent/ntcompose/core/i;", "", NodeProps.ENABLED, "", "onClickLabel", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/base/event/c;", "Lkotlin/ParameterName;", "name", "e", "", NodeProps.ON_CLICK, "c", "onLongClickLabel", "Lcom/tencent/kuikly/core/base/event/e;", NodeProps.ON_LONG_CLICK, "onDoubleClick", "", "minimumPanTouches", "Lcom/tencent/ntcompose/foundation/event/PanDirection;", "direction", "Lcom/tencent/kuikly/core/base/event/h;", "onPanEventGesture", DomainData.DOMAIN_NAME, "Lcom/tencent/ntcompose/foundation/event/a;", "onTouchEvent", "p", "Lkotlin/Function0;", "onHitTestCallback", "i", "Lcom/tencent/kuikly/core/layout/d;", AIInput.KEY_FRAME, "onChanged", "j", "Lcom/tencent/kuikly/core/base/w;", "size", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lap3/a;", "onPlaced", "l", "onGloballyPositioned", "k", "a", "", "parma", "Lcom/tencent/kuikly/core/base/event/EventHandlerFn;", "onWillAppear", "r", HippyPageItemExposureEvent.EVENT_PAGER_ITEM_DID_APPEAR, "g", "onDidDisappear", h.F, "", "percentage01", "onAppearPercentage", "b", "onRenderViewDidCreated", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ViewEventPropUpdaterKt {
    public static final i a(i iVar, Function1<? super com.tencent.kuikly.core.layout.d, Unit> onChanged) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(onChanged, "onChanged");
        return ModifiersKt.c(iVar, "addLayoutFrameDidChange", onChanged, null, null, null, null, ViewEventPropUpdater.f339229a, 60, null);
    }

    public static final i b(i iVar, Function1<? super Float, Unit> onAppearPercentage) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(onAppearPercentage, "onAppearPercentage");
        return ModifiersKt.c(iVar, "appearPercentage", onAppearPercentage, null, null, null, null, ViewEventPropUpdater.f339229a, 60, null);
    }

    public static final i c(i iVar, boolean z16, String str, Function1<? super ClickParams, Unit> onClick) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        return ModifiersKt.c(iVar, "click", onClick, null, null, null, null, ViewEventPropUpdater.f339229a, 60, null);
    }

    public static final i e(i iVar, boolean z16, String str, String str2, Function1<? super LongPressParams, Unit> function1, Function1<? super ClickParams, Unit> function12, Function1<? super ClickParams, Unit> onClick) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        return ModifiersKt.c(iVar, "combinedClickable", onClick, function12, function1, null, null, ViewEventPropUpdater.f339229a, 48, null);
    }

    public static final i g(i iVar, Function1<Object, Unit> onDidAppear) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(onDidAppear, "onDidAppear");
        return ModifiersKt.c(iVar, "didAppear", onDidAppear, null, null, null, null, ViewEventPropUpdater.f339229a, 60, null);
    }

    public static final i h(i iVar, Function1<Object, Unit> onDidDisappear) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(onDidDisappear, "onDidDisappear");
        return ModifiersKt.c(iVar, "didDisappear", onDidDisappear, null, null, null, null, ViewEventPropUpdater.f339229a, 60, null);
    }

    public static final i i(i iVar, Function0<Unit> onHitTestCallback) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(onHitTestCallback, "onHitTestCallback");
        return ModifiersKt.c(iVar, "hitTestSelf", onHitTestCallback, null, null, null, null, ViewEventPropUpdater.f339229a, 60, null);
    }

    public static final i j(i iVar, final Function1<? super com.tencent.kuikly.core.layout.d, Unit> onChanged) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(onChanged, "onChanged");
        return l(iVar, new Function1<ap3.a, Unit>() { // from class: com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt$layoutFrameDidChange$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ap3.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ap3.a it) {
                Intrinsics.checkNotNullParameter(it, "it");
                onChanged.invoke(ap3.c.a(it));
            }
        });
    }

    public static final i k(i iVar, Function1<? super ap3.a, Unit> onGloballyPositioned) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(onGloballyPositioned, "onGloballyPositioned");
        return ModifiersKt.c(iVar, "onGlobalPosition", onGloballyPositioned, null, null, null, null, ViewEventPropUpdater.f339229a, 60, null);
    }

    public static final i l(i iVar, Function1<? super ap3.a, Unit> onPlaced) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(onPlaced, "onPlaced");
        return ModifiersKt.c(iVar, "onPlaced", onPlaced, null, null, null, null, ViewEventPropUpdater.f339229a, 60, null);
    }

    public static final i m(i iVar, Function1<? super w, Unit> onSizeChanged) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(onSizeChanged, "onSizeChanged");
        return ModifiersKt.c(iVar, MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, onSizeChanged, null, null, null, null, ViewEventPropUpdater.f339229a, 60, null);
    }

    public static final i n(i iVar, boolean z16, int i3, PanDirection direction, Function1<? super PanGestureParams, Unit> onPanEventGesture) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(onPanEventGesture, "onPanEventGesture");
        if (!z16) {
            i3 = Integer.MAX_VALUE;
        }
        return ModifiersKt.c(iVar, "pan_gesture", onPanEventGesture, Integer.valueOf(i3), direction, null, null, ViewEventPropUpdater.f339229a, 48, null);
    }

    public static final i p(i iVar, Function1<? super MotionEvent, Unit> onTouchEvent) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(onTouchEvent, "onTouchEvent");
        return ModifiersKt.c(iVar, "pointerInteropFilter", onTouchEvent, null, null, null, null, ViewEventPropUpdater.f339229a, 60, null);
    }

    public static final i q(i iVar, Function1<Object, Unit> onRenderViewDidCreated) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(onRenderViewDidCreated, "onRenderViewDidCreated");
        return ModifiersKt.c(iVar, "renderViewDidCreated", onRenderViewDidCreated, null, null, null, null, ViewEventPropUpdater.f339229a, 60, null);
    }

    public static final i r(i iVar, Function1<Object, Unit> onWillAppear) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(onWillAppear, "onWillAppear");
        return ModifiersKt.c(iVar, "willAppear", onWillAppear, null, null, null, null, ViewEventPropUpdater.f339229a, 60, null);
    }

    public static /* synthetic */ i d(i iVar, boolean z16, String str, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        if ((i3 & 2) != 0) {
            str = null;
        }
        return c(iVar, z16, str, function1);
    }

    public static /* synthetic */ i o(i iVar, boolean z16, int i3, PanDirection panDirection, Function1 function1, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            z16 = true;
        }
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        if ((i16 & 4) != 0) {
            panDirection = PanDirection.ALL;
        }
        return n(iVar, z16, i3, panDirection, function1);
    }

    public static /* synthetic */ i f(i iVar, boolean z16, String str, String str2, Function1 function1, Function1 function12, Function1 function13, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        return e(iVar, z16, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? null : function1, (i3 & 16) != 0 ? null : function12, function13);
    }
}
