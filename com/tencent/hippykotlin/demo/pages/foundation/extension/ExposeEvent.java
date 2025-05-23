package com.tencent.hippykotlin.demo.pages.foundation.extension;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.lib.LodashKt;
import com.tencent.hippykotlin.demo.pages.foundation.lib.LodashKt$throttle$2;
import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.b;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.layout.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.kuikly.core.views.ScrollerView;
import com.tencent.kuikly.core.views.ad;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.apache.httpcore.message.TokenParser;
import zz0.a;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ExposeEvent extends b implements ad {
    public List<Float> appearPercentageList;
    public boolean debug;
    public int exposeLimit;
    public float exposeThreshold;
    public long exposeThrottle;
    public int exposeTime;
    public String exposeTimer;
    public d frameInWindow;
    public List<Integer> listViewNativeRefs;
    public boolean reachExposeThreshold;
    public boolean recursive;
    public List<ScrollViewFrameOffset> scrollViewFrameOffsetList;
    public long startTS;
    public final Function1<Object[], Unit> throttledCalculate;
    public final Function1<Object[], Boolean> throttledFireEvent;
    public int visibilityState;

    public ExposeEvent(int i3, float f16, int i16, long j3, boolean z16, boolean z17) {
        this.exposeLimit = i3;
        this.exposeThreshold = f16;
        this.exposeTime = i16;
        this.exposeThrottle = j3;
        this.recursive = z16;
        this.debug = z17;
        if (z17) {
            KLog.INSTANCE.d("ExposeEventCenter", "ExposeEvent init");
        }
        this.listViewNativeRefs = new ArrayList();
        this.visibilityState = 3;
        this.appearPercentageList = new ArrayList();
        this.exposeTimer = "";
        this.scrollViewFrameOffsetList = new ArrayList();
        this.throttledFireEvent = (LodashKt$throttle$2) LodashKt.throttle(LodashKt.limit(new Function1<Object[], Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.extension.ExposeEvent$throttledFireEvent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object[] objArr) {
                Object[] objArr2 = objArr;
                ExposeEvent exposeEvent = ExposeEvent.this;
                exposeEvent.getClass();
                long a16 = a.f453719a.a() - exposeEvent.startTS;
                if (exposeEvent.debug) {
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("cost ");
                    sb5.append(a16);
                    sb5.append(" exposeTime ");
                    DatalineDetailViewModel$$ExternalSyntheticOutline0.m(sb5, exposeEvent.exposeTime, kLog, "ExposeEventCenter");
                }
                ExposeEvent exposeEvent2 = ExposeEvent.this;
                Object obj = objArr2[0];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                return Boolean.valueOf(exposeEvent2.onFireEvent((String) obj, objArr2[1]));
            }
        }, this.exposeLimit), this.exposeThrottle);
        this.throttledCalculate = (LodashKt$throttle$2) LodashKt.throttle(new Function1<Object[], Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.extension.ExposeEvent$throttledCalculate$1
            {
                super(1);
            }

            /* JADX WARN: Code restructure failed: missing block: B:56:0x0167, code lost:
            
                if ((r1.getY() == 0.0f) == false) goto L58;
             */
            /* JADX WARN: Code restructure failed: missing block: B:97:0x02ac, code lost:
            
                if (r0.moreThanEqual(r15.getY(), r6) == false) goto L96;
             */
            /* JADX WARN: Type inference failed for: r1v22, types: [java.util.List<com.tencent.hippykotlin.demo.pages.foundation.extension.ScrollViewFrameOffset>, java.util.ArrayList] */
            /* JADX WARN: Type inference failed for: r5v10, types: [java.util.List<com.tencent.hippykotlin.demo.pages.foundation.extension.ScrollViewFrameOffset>, java.util.ArrayList] */
            /* JADX WARN: Type inference failed for: r5v4, types: [java.util.List<java.lang.Float>, java.util.ArrayList] */
            /* JADX WARN: Type inference failed for: r7v0, types: [java.util.List<com.tencent.hippykotlin.demo.pages.foundation.extension.ScrollViewFrameOffset>, java.util.ArrayList] */
            /* JADX WARN: Type inference failed for: r7v5, types: [java.util.List<java.lang.Float>, java.util.ArrayList] */
            @Override // kotlin.jvm.functions.Function1
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Unit invoke(Object[] objArr) {
                Object[] objArr2 = objArr;
                final ExposeEvent exposeEvent = ExposeEvent.this;
                DeclarativeBaseView declarativeBaseView = objArr2.length == 0 ? null : (DeclarativeBaseView) objArr2[0];
                if (declarativeBaseView == null) {
                    if (exposeEvent.getView() != null && (exposeEvent.getView() instanceof DeclarativeBaseView)) {
                        AbstractBaseView<?, ?> view = exposeEvent.getView();
                        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.kuikly.core.base.DeclarativeBaseView<*, *>");
                        declarativeBaseView = (DeclarativeBaseView) view;
                    }
                    return Unit.INSTANCE;
                }
                if (!exposeEvent.isEmpty() && declarativeBaseView.getNativeRef() == exposeEvent.getViewId() && declarativeBaseView.getParent() != null) {
                    if (exposeEvent.debug) {
                        KLog.INSTANCE.d("ExposeEventCenter", "do calculate");
                    }
                    exposeEvent.startTS = a.f453719a.a();
                    ViewContainer<?, ?> parent = declarativeBaseView.getParent();
                    final h k3 = declarativeBaseView.getFlexNode().getLayoutFrame().k();
                    final Ref.FloatRef floatRef = new Ref.FloatRef();
                    final Ref.FloatRef floatRef2 = new Ref.FloatRef();
                    exposeEvent.scrollViewFrameOffsetList.clear();
                    Function1<DeclarativeBaseView<?, ?>, Unit> function1 = new Function1<DeclarativeBaseView<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.extension.ExposeEvent$doCalculate$scrollViewHandler$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Type inference failed for: r0v11, types: [java.util.List<java.lang.Integer>, java.util.ArrayList] */
                        /* JADX WARN: Type inference failed for: r0v6, types: [java.util.List<com.tencent.hippykotlin.demo.pages.foundation.extension.ScrollViewFrameOffset>, java.util.ArrayList] */
                        /* JADX WARN: Type inference failed for: r0v8, types: [java.util.List<java.lang.Integer>, java.util.ArrayList] */
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(DeclarativeBaseView<?, ?> declarativeBaseView2) {
                            DeclarativeBaseView<?, ?> declarativeBaseView3 = declarativeBaseView2;
                            if (declarativeBaseView3 instanceof ScrollerView) {
                                ScrollerView scrollerView = (ScrollerView) declarativeBaseView3;
                                Ref.FloatRef.this.element = ((ScrollerAttr) scrollerView.getViewAttr()).getVisibleAreaIgnoreTopMargin();
                                floatRef2.element = ((ScrollerAttr) scrollerView.getViewAttr()).getVisibleAreaIgnoreBottomMargin();
                                h hVar = k3;
                                hVar.g(hVar.getX() - scrollerView.getCurOffsetX());
                                h hVar2 = k3;
                                hVar2.h(hVar2.getY() - scrollerView.getCurOffsetY());
                                exposeEvent.scrollViewFrameOffsetList.add(new ScrollViewFrameOffset(declarativeBaseView3.getFrame().getWidth(), declarativeBaseView3.getFrame().getHeight(), k3.getX(), k3.getY()));
                                if (!exposeEvent.listViewNativeRefs.contains(Integer.valueOf(declarativeBaseView3.getNativeRef()))) {
                                    exposeEvent.listViewNativeRefs.add(Integer.valueOf(declarativeBaseView3.getNativeRef()));
                                    if (exposeEvent.debug) {
                                        KLog.INSTANCE.d("ExposeEventCenter", "addScrollerViewEventObserver");
                                    }
                                    ((ScrollerView) declarativeBaseView3).addScrollerViewEventObserver(exposeEvent);
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    while (parent != null) {
                        boolean z18 = exposeEvent.recursive;
                        if ((!z18 || (parent instanceof Pager)) && (z18 || (parent instanceof ScrollerView) || (parent instanceof Pager))) {
                            break;
                        }
                        function1.invoke(parent);
                        k3.g(parent.getFlexNode().getLayoutFrame().getX() + k3.getX());
                        k3.h(parent.getFlexNode().getLayoutFrame().getY() + k3.getY());
                        parent = parent.getParent();
                    }
                    function1.invoke(parent);
                    if (parent == null) {
                        exposeEvent.updateViewVisibility$enumunboxing$(3, true);
                    } else {
                        h k16 = parent.getFlexNode().getLayoutFrame().k();
                        if (parent instanceof ScrollerView) {
                            k16.e(k16.getHeight() - (floatRef.element + floatRef2.element));
                            k3.h(k3.getY() - floatRef.element);
                        }
                        d i17 = k16.i();
                        if (exposeEvent.debug) {
                            KLog kLog = KLog.INSTANCE;
                            kLog.d("ExposeEventCenter", "windowFrame " + i17);
                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("frameInWindow ");
                            m3.append(k3.i());
                            kLog.d("ExposeEventCenter", m3.toString());
                            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("scrollViewFrameDeltaList: ");
                            m16.append(exposeEvent.scrollViewFrameOffsetList);
                            kLog.d("ExposeEventCenter", m16.toString());
                        }
                        float width = i17.getWidth();
                        float height = i17.getHeight();
                        if (exposeEvent.debug) {
                            if (i17.getX() == 0.0f) {
                            }
                            KLog kLog2 = KLog.INSTANCE;
                            StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("targetVisibleWindow xy: ");
                            m17.append(i17.getX());
                            m17.append(TokenParser.SP);
                            m17.append(i17.getY());
                            kLog2.i("ExposeEventCenter", m17.toString());
                        }
                        if (!(exposeEvent.exposeThreshold == 1.0f)) {
                            exposeEvent.appearPercentageList.clear();
                            if (exposeEvent.recursive) {
                                ?? r56 = exposeEvent.scrollViewFrameOffsetList;
                                ListIterator listIterator = r56.listIterator(r56.size());
                                while (listIterator.hasPrevious()) {
                                    ScrollViewFrameOffset scrollViewFrameOffset = (ScrollViewFrameOffset) listIterator.previous();
                                    exposeEvent.appearPercentageList.add(Float.valueOf(Math.max(Math.min(exposeEvent.intersectionArea(new d(k3.getX() - scrollViewFrameOffset.offsetX, k3.getY() - scrollViewFrameOffset.offsetY, scrollViewFrameOffset.f114185w, scrollViewFrameOffset.f114184h), k3.i()) / (k3.getWidth() * k3.getHeight()), 1.0f), 0.0f)));
                                }
                            }
                            final float max = Math.max(Math.min(exposeEvent.intersectionArea(i17, k3.i()) / (k3.getWidth() * k3.getHeight()), 1.0f), 0.0f);
                            if (exposeEvent.debug) {
                                KLog.INSTANCE.d("ExposeEventCenter", "percentage " + max + TokenParser.SP + exposeEvent.appearPercentageList);
                            }
                            if (!(exposeEvent.exposeThreshold == 1.0f)) {
                                exposeEvent.getPager().addNextTickTask(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.extension.ExposeEvent$fireExposeThreshold$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List<java.lang.Float>, java.util.ArrayList] */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        boolean z19;
                                        float f17 = max;
                                        ExposeEvent exposeEvent2 = exposeEvent;
                                        if (f17 > exposeEvent2.exposeThreshold) {
                                            ?? r06 = exposeEvent2.appearPercentageList;
                                            if (!(r06 instanceof Collection) || !r06.isEmpty()) {
                                                Iterator it = r06.iterator();
                                                while (it.hasNext()) {
                                                    if (!(((Number) it.next()).floatValue() > exposeEvent2.exposeThreshold)) {
                                                        z19 = false;
                                                        break;
                                                    }
                                                }
                                            }
                                            z19 = true;
                                            if (z19) {
                                                ExposeEvent exposeEvent3 = exposeEvent;
                                                if (!exposeEvent3.reachExposeThreshold) {
                                                    exposeEvent3.reachExposeThreshold = true;
                                                    if (exposeEvent3.exposeTime == 0) {
                                                        ExposeEvent.access$clearTimer(exposeEvent3);
                                                        exposeEvent.throttledFireEvent.invoke(new Object[]{"expose", new e()});
                                                    } else if (Intrinsics.areEqual(exposeEvent3.exposeTimer, "")) {
                                                        final long a16 = a.f453719a.a();
                                                        if (exposeEvent.debug) {
                                                            KLog.INSTANCE.d("ExposeEventCenter", "fireExposeThreshold start ts " + a16);
                                                        }
                                                        final ExposeEvent exposeEvent4 = exposeEvent;
                                                        int i18 = exposeEvent4.exposeTime;
                                                        final float f18 = max;
                                                        exposeEvent4.exposeTimer = TimerKt.d(i18, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.extension.ExposeEvent$fireExposeThreshold$1.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(0);
                                                            }

                                                            /* JADX WARN: Type inference failed for: r0v5, types: [java.util.List<java.lang.Float>, java.util.ArrayList] */
                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Unit invoke() {
                                                                boolean z26;
                                                                float f19 = f18;
                                                                ExposeEvent exposeEvent5 = exposeEvent4;
                                                                if (f19 > exposeEvent5.exposeThreshold) {
                                                                    ?? r07 = exposeEvent5.appearPercentageList;
                                                                    if (!(r07 instanceof Collection) || !r07.isEmpty()) {
                                                                        Iterator it5 = r07.iterator();
                                                                        while (it5.hasNext()) {
                                                                            if (!(((Number) it5.next()).floatValue() > exposeEvent5.exposeThreshold)) {
                                                                                z26 = false;
                                                                                break;
                                                                            }
                                                                        }
                                                                    }
                                                                    z26 = true;
                                                                    if (z26) {
                                                                        long a17 = a.f453719a.a();
                                                                        if (exposeEvent4.debug) {
                                                                            KLog.INSTANCE.d("ExposeEventCenter", "fireExposeThreshold end ts " + a17 + ", duration " + (a17 - a16));
                                                                        }
                                                                        exposeEvent4.throttledFireEvent.invoke(new Object[]{"expose", new e()});
                                                                        ExposeEvent.access$clearTimer(exposeEvent4);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }
                                                                exposeEvent4.reachExposeThreshold = false;
                                                                ExposeEvent.access$clearTimer(exposeEvent4);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }
                                        ExposeEvent exposeEvent5 = exposeEvent;
                                        exposeEvent5.reachExposeThreshold = false;
                                        ExposeEvent.access$clearTimer(exposeEvent5);
                                        return Unit.INSTANCE;
                                    }
                                });
                            }
                        } else {
                            if (exposeEvent.recursive) {
                                ?? r16 = exposeEvent.scrollViewFrameOffsetList;
                                ListIterator listIterator2 = r16.listIterator(r16.size());
                                while (listIterator2.hasPrevious()) {
                                    ScrollViewFrameOffset scrollViewFrameOffset2 = (ScrollViewFrameOffset) listIterator2.previous();
                                    if (!exposeEvent.isContaining(new h(scrollViewFrameOffset2.offsetX, scrollViewFrameOffset2.offsetY, k3.getWidth(), k3.getHeight()), scrollViewFrameOffset2.f114185w, scrollViewFrameOffset2.f114184h)) {
                                        exposeEvent.updateViewVisibility$enumunboxing$(3, true);
                                        break;
                                    }
                                }
                            }
                            if (k3.getWidth() + k3.getX() > 0.0f && !exposeEvent.moreThanEqual(k3.getX(), width)) {
                                if (k3.getHeight() + k3.getY() > 0.0f) {
                                }
                            }
                            r2 = true;
                            if (r2) {
                                exposeEvent.handleLeaving(true);
                            } else if (exposeEvent.isContaining(k3, width, height)) {
                                int i18 = exposeEvent.visibilityState;
                                if (i18 != 2 && i18 != 3) {
                                    exposeEvent.updateViewVisibility$enumunboxing$(4, true);
                                } else {
                                    exposeEvent.updateViewVisibility$enumunboxing$(1, true);
                                    exposeEvent.updateViewVisibility$enumunboxing$(4, true);
                                }
                            } else {
                                int i19 = exposeEvent.visibilityState;
                                if (i19 == 3) {
                                    exposeEvent.updateViewVisibility$enumunboxing$(1, true);
                                } else if (i19 == 4) {
                                    exposeEvent.updateViewVisibility$enumunboxing$(2, true);
                                }
                            }
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        }, this.recursive ? 400L : 150L);
    }

    public static final void access$clearTimer(ExposeEvent exposeEvent) {
        if (Intrinsics.areEqual(exposeEvent.exposeTimer, "")) {
            return;
        }
        TimerKt.b(exposeEvent.exposeTimer);
        exposeEvent.exposeTimer = "";
    }

    @Override // com.tencent.kuikly.core.views.ad
    public final void contentSizeDidChanged(float f16, float f17) {
        ad.a.a(this, f16, f17);
    }

    @Override // com.tencent.kuikly.core.views.ad
    public final void contentViewDidSetFrameToRenderView() {
        ad.a.b(this);
    }

    public final void handleLeaving(boolean z16) {
        int i3 = this.visibilityState;
        if (i3 != 1 && i3 != 4) {
            updateViewVisibility$enumunboxing$(3, z16);
        } else {
            updateViewVisibility$enumunboxing$(2, z16);
            updateViewVisibility$enumunboxing$(3, z16);
        }
    }

    public final float intersectionArea(d dVar, d dVar2) {
        float width = dVar.getWidth();
        float height = dVar.getHeight();
        float width2 = dVar2.getWidth();
        float height2 = dVar2.getHeight();
        float x16 = dVar.getX();
        float x17 = dVar.getX() + width;
        float x18 = dVar2.getX();
        float x19 = dVar2.getX() + width2;
        float y16 = dVar.getY();
        float y17 = dVar.getY() + height;
        float y18 = dVar2.getY();
        float y19 = dVar2.getY() + height2;
        float max = (width + width2) - (Math.max(x17, x19) - Math.min(x16, x18));
        float max2 = (height + height2) - (Math.max(y17, y19) - Math.min(y16, y18));
        if (max <= 0.0f || max2 <= 0.0f) {
            return 0.0f;
        }
        return max * max2;
    }

    public final boolean isContaining(h hVar, float f16, float f17) {
        if (hVar.getX() >= 0.0f) {
            float f18 = 1;
            if (lessThanEqual(hVar.getWidth() + hVar.getX(), f16 + f18) && hVar.getY() >= 0.0f) {
                if (lessThanEqual(hVar.getHeight() + hVar.getY(), f17 + f18)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.kuikly.core.views.ad
    public final void onContentOffsetDidChanged(float f16, float f17, ScrollParams scrollParams) {
        this.throttledCalculate.invoke(new Object[0]);
    }

    @Override // com.tencent.kuikly.core.views.ad
    public final void onPagerParentScrollerDidScroll() {
        ad.a.c(this);
    }

    @Override // com.tencent.kuikly.core.base.event.d
    public final void onRelativeCoordinatesDidChanged(DeclarativeBaseView<?, ?> declarativeBaseView) {
        if (this.debug) {
            KLog.INSTANCE.d("ExposeEventCenter", "onRelativeCoordinatesDidChanged");
        }
        this.throttledCalculate.invoke(new DeclarativeBaseView[]{declarativeBaseView});
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<java.lang.Integer>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List<java.lang.Integer>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.List<java.lang.Integer>, java.util.ArrayList] */
    @Override // com.tencent.kuikly.core.base.event.d
    public final void onRenderViewDidRemoved() {
        if (!this.listViewNativeRefs.isEmpty()) {
            Iterator it = this.listViewNativeRefs.iterator();
            while (it.hasNext()) {
                AbstractBaseView<?, ?> viewWithNativeRef = getPager().getViewWithNativeRef(((Number) it.next()).intValue());
                if (viewWithNativeRef != null && (viewWithNativeRef instanceof ScrollerView)) {
                    ((ScrollerView) viewWithNativeRef).removeScrollerViewEventObserver(this);
                }
            }
            this.listViewNativeRefs.clear();
        }
    }

    @Override // com.tencent.kuikly.core.base.event.b, com.tencent.kuikly.core.base.event.d
    public final void onViewDidRemove() {
        super.onViewDidRemove();
        if (isEmpty()) {
            return;
        }
        handleLeaving(!getPager().getWillDestroy());
    }

    @Override // com.tencent.kuikly.core.views.ad
    public final void scrollFrameDidChanged(d dVar) {
        if (this.debug) {
            KLog.INSTANCE.d("ExposeEventCenter", "scrollFrameDidChanged " + dVar);
        }
        this.throttledCalculate.invoke(new Object[0]);
    }

    @Override // com.tencent.kuikly.core.views.ad
    public final void scrollerDragBegin(ScrollParams scrollParams) {
        ad.a.e(this, scrollParams);
    }

    @Override // com.tencent.kuikly.core.views.ad
    public final void scrollerScrollDidEnd(ScrollParams scrollParams) {
        ad.a.f(this, scrollParams);
    }

    @Override // com.tencent.kuikly.core.views.ad
    public final void subViewsDidLayout() {
        AbstractBaseView<?, ?> view = getView();
        if (view == null || !(view instanceof DeclarativeBaseView)) {
            return;
        }
        d layoutFrame = view.getFlexNode().getLayoutFrame();
        d dVar = this.frameInWindow;
        if (dVar == null || Intrinsics.areEqual(layoutFrame, dVar)) {
            return;
        }
        this.frameInWindow = layoutFrame;
        if (this.debug) {
            KLog.INSTANCE.d("ExposeEventCenter", "subViewsDidLayout");
        }
        this.throttledCalculate.invoke(new DeclarativeBaseView[]{(DeclarativeBaseView) view});
    }

    public final void updateViewVisibility$enumunboxing$(int i3, boolean z16) {
        if (this.visibilityState != i3) {
            this.visibilityState = i3;
            if (this.exposeThreshold == 1.0f) {
                if (i3 == 4) {
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.extension.ExposeEvent$updateViewVisibility$1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            ExposeEvent exposeEvent = ExposeEvent.this;
                            if (exposeEvent.exposeTime == 0) {
                                ExposeEvent.access$clearTimer(exposeEvent);
                                ExposeEvent.this.throttledFireEvent.invoke(new Object[]{"expose", new e()});
                            } else if (Intrinsics.areEqual(exposeEvent.exposeTimer, "")) {
                                final long a16 = a.f453719a.a();
                                if (ExposeEvent.this.debug) {
                                    KLog.INSTANCE.d("ExposeEventCenter", "start ts " + a16);
                                }
                                final ExposeEvent exposeEvent2 = ExposeEvent.this;
                                exposeEvent2.exposeTimer = TimerKt.d(exposeEvent2.exposeTime, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.extension.ExposeEvent$updateViewVisibility$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        if (ExposeEvent.this.visibilityState == 4) {
                                            long a17 = a.f453719a.a();
                                            if (ExposeEvent.this.debug) {
                                                KLog.INSTANCE.d("ExposeEventCenter", "end ts " + a17 + ", duration " + (a17 - a16));
                                            }
                                            ExposeEvent.this.throttledFireEvent.invoke(new Object[]{"expose", new e()});
                                        }
                                        ExposeEvent.access$clearTimer(ExposeEvent.this);
                                        return Unit.INSTANCE;
                                    }
                                });
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    if (z16) {
                        getPager().addNextTickTask(function0);
                        return;
                    } else {
                        function0.invoke();
                        return;
                    }
                }
                if (Intrinsics.areEqual(this.exposeTimer, "")) {
                    return;
                }
                TimerKt.b(this.exposeTimer);
                this.exposeTimer = "";
            }
        }
    }

    public final boolean lessThanEqual(float f16, float f17) {
        return f16 <= f17 || ((double) Math.abs(f16 - f17)) <= 0.001d;
    }

    public final boolean moreThanEqual(float f16, float f17) {
        return f16 >= f17 || ((double) Math.abs(f16 - f17)) <= 0.001d;
    }

    @Override // com.tencent.kuikly.core.base.event.d
    public final void onRenderViewDidCreated() {
    }

    @Override // com.tencent.kuikly.core.base.event.d
    public final void onViewLayoutFrameDidChanged(DeclarativeBaseView<?, ?> declarativeBaseView) {
    }
}
