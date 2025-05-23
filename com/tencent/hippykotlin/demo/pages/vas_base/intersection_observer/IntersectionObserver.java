package com.tencent.hippykotlin.demo.pages.vas_base.intersection_observer;

import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.kuikly.core.pager.b;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ScrollerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class IntersectionObserver {
    public final Function2<List<IntersectionObserverEntry>, IntersectionObserver, Unit> callback;
    public final Map<ObservableView<?, ?>, Integer> observeItemMap = new LinkedHashMap();
    public final Options options;
    public final Lazy pager$delegate;
    public final Scheduler<ObservableView<?, ?>> scheduler;
    public final Lazy threshold$delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public IntersectionObserver(Options options, Function2<? super List<IntersectionObserverEntry>, ? super IntersectionObserver, Unit> function2) {
        Lazy lazy;
        Lazy lazy2;
        this.options = options;
        this.callback = function2;
        Scheduler<ObservableView<?, ?>> scheduler = new Scheduler<>();
        this.scheduler = scheduler;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.intersection_observer.IntersectionObserver$pager$2
            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return c.f117352a.g();
            }
        });
        this.pager$delegate = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<List<Float>>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.intersection_observer.IntersectionObserver$threshold$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<Float> invoke() {
                List sorted;
                Set set;
                List<Float> mutableList;
                List<Float> list = IntersectionObserver.this.options.threshold;
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = list.iterator();
                while (true) {
                    boolean z16 = false;
                    if (!it.hasNext()) {
                        sorted = CollectionsKt___CollectionsKt.sorted(arrayList);
                        set = CollectionsKt___CollectionsKt.toSet(sorted);
                        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) set);
                        mutableList.add(0, Float.valueOf(-1.0f));
                        return mutableList;
                    }
                    Object next = it.next();
                    double floatValue = ((Number) next).floatValue();
                    if (0.0d <= floatValue && floatValue <= 1.0d) {
                        z16 = true;
                    }
                    if (z16) {
                        arrayList.add(next);
                    }
                }
            }
        });
        this.threshold$delegate = lazy2;
        scheduler.subscribe(new Function1<Set<ObservableView<?, ?>>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.intersection_observer.IntersectionObserver.1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r5v4, types: [java.util.LinkedHashMap, java.util.Map<com.tencent.hippykotlin.demo.pages.vas_base.intersection_observer.ObservableView<?, ?>, java.lang.Integer>] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.tencent.kuikly.core.base.Attr, com.tencent.kuikly.core.base.Props] */
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Set<ObservableView<?, ?>> set) {
                IntersectionObserverEntry intersectionObserverEntry;
                Object obj;
                int indexOf;
                Margin margin;
                Margin margin2;
                ArrayList arrayList = new ArrayList();
                IntersectionObserver intersectionObserver = IntersectionObserver.this;
                Iterator<T> it = set.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ObservableView<?, ?> observableView = (ObservableView) it.next();
                    intersectionObserver.getClass();
                    ViewContainer<?, ?> domParent = observableView.getDomParent();
                    d frame = observableView.getFrame();
                    Rect rect = new Rect(frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
                    float f16 = rect.width * rect.height;
                    while (true) {
                        intersectionObserverEntry = null;
                        if (domParent == null) {
                            break;
                        }
                        intersectionObserver.options.getClass();
                        b bVar = (b) intersectionObserver.pager$delegate.getValue();
                        Intrinsics.checkNotNull(bVar, "null cannot be cast to non-null type com.tencent.kuikly.core.pager.Pager");
                        boolean areEqual = Intrinsics.areEqual(domParent, (Pager) bVar);
                        if (domParent instanceof ScrollerView) {
                            ScrollerView scrollerView = (ScrollerView) domParent;
                            rect.translate(-scrollerView.getCurOffsetX(), -scrollerView.getCurOffsetY());
                            d frame2 = domParent.getFrame();
                            Rect rect2 = new Rect(frame2.getX(), frame2.getY(), frame2.getWidth(), frame2.getHeight());
                            if (areEqual) {
                                intersectionObserver.options.getClass();
                                margin2 = Margin.f160default;
                            } else {
                                margin2 = null;
                            }
                            rect.intersect(rect2, margin2);
                        } else if (Intrinsics.areEqual(domParent.getViewAttr().getProp("overflow"), Integer.valueOf(com.tencent.kuikly.core.base.d.b(true))) || areEqual) {
                            d frame3 = domParent.getFrame();
                            Rect rect3 = new Rect(frame3.getX(), frame3.getY(), frame3.getWidth(), frame3.getHeight());
                            if (areEqual) {
                                intersectionObserver.options.getClass();
                                margin = Margin.f160default;
                            } else {
                                margin = null;
                            }
                            rect.intersect(rect3, margin);
                        }
                        if (areEqual || rect.isZero()) {
                            break;
                        }
                        rect.translate(domParent.getFrame().getX(), domParent.getFrame().getY());
                        domParent = domParent.getDomParent();
                    }
                    if (domParent != null) {
                        float f17 = f16 > 0.0f ? (rect.width * rect.height) / f16 : 0.0f;
                        Integer num = (Integer) intersectionObserver.observeItemMap.get(observableView);
                        if (rect.isZero()) {
                            indexOf = 0;
                        } else {
                            List list = (List) intersectionObserver.threshold$delegate.getValue();
                            List list2 = (List) intersectionObserver.threshold$delegate.getValue();
                            ListIterator listIterator = list2.listIterator(list2.size());
                            while (true) {
                                if (!listIterator.hasPrevious()) {
                                    obj = null;
                                    break;
                                }
                                obj = listIterator.previous();
                                if (f17 >= ((Number) obj).floatValue()) {
                                    break;
                                }
                            }
                            indexOf = CollectionsKt___CollectionsKt.indexOf((List<? extends Object>) list, obj);
                        }
                        intersectionObserver.observeItemMap.put(observableView, Integer.valueOf(indexOf));
                        if (num == null || indexOf != num.intValue()) {
                            intersectionObserverEntry = new IntersectionObserverEntry(observableView, f17, new Rect(rect.f114307x, rect.f114308y, rect.width, rect.height), indexOf > 0);
                        }
                    }
                    if (intersectionObserverEntry != null) {
                        arrayList.add(intersectionObserverEntry);
                    }
                }
                if (!arrayList.isEmpty()) {
                    IntersectionObserver intersectionObserver2 = IntersectionObserver.this;
                    intersectionObserver2.callback.invoke(arrayList, intersectionObserver2);
                }
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List<kotlin.jvm.functions.Function0<kotlin.Unit>>, java.util.ArrayList] */
    public final void observe(final ObservableView<?, ?> observableView) {
        if (this.observeItemMap.containsKey(observableView)) {
            return;
        }
        this.observeItemMap.put(observableView, null);
        for (ViewContainer<?, ?> domParent = observableView.getDomParent(); domParent != null; domParent = domParent.getDomParent()) {
            if (domParent instanceof ScrollerView) {
                observableView.scrollers.add(domParent);
                ((ScrollerView) domParent).addScrollerViewEventObserver(observableView);
            }
        }
        observableView.frameChangeHandlers.add(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.intersection_observer.IntersectionObserver$observe$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                Scheduler<ObservableView<?, ?>> scheduler = IntersectionObserver.this.scheduler;
                scheduler.container.add(observableView);
                if (scheduler.timer == null) {
                    scheduler.timer = TimerKt.d(100, new Scheduler$add$1(scheduler));
                }
                return Unit.INSTANCE;
            }
        });
        Scheduler<ObservableView<?, ?>> scheduler = this.scheduler;
        scheduler.container.add(observableView);
        if (scheduler.timer == null) {
            scheduler.timer = TimerKt.d(100, new Scheduler$add$1(scheduler));
        }
    }
}
