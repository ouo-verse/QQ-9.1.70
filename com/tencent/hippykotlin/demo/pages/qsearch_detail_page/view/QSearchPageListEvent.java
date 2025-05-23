package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view;

import com.tencent.kuikly.core.views.PageListEvent;
import com.tencent.kuikly.core.views.ScrollParams;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes32.dex */
public final class QSearchPageListEvent extends PageListEvent {
    public Function1<? super ScrollParams, Unit> innerDragBeginHandler;
    public Function1<? super ScrollParams, Unit> innerDragEndHandler;
    public Function1<Object, Unit> innerPageChangeHandler;
    public Function1<? super ScrollParams, Unit> innerScrollEndHandler;
    public Function1<? super ScrollParams, Unit> innerScrollHandler;
    public final List<Function1<ScrollParams, Unit>> scrollListeners = new ArrayList();
    public final List<Function1<ScrollParams, Unit>> scrollEndListeners = new ArrayList();
    public final List<Function1<ScrollParams, Unit>> dragBeginListeners = new ArrayList();
    public final List<Function1<ScrollParams, Unit>> dragEndListeners = new ArrayList();
    public final List<Function1<Object, Unit>> pageChangeListeners = new ArrayList();

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List<kotlin.jvm.functions.Function1<com.tencent.kuikly.core.views.bn, kotlin.Unit>>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List<kotlin.jvm.functions.Function1<com.tencent.kuikly.core.views.bn, kotlin.Unit>>, java.util.ArrayList] */
    public final void addDragBeginListener(Function1<? super ScrollParams, Unit> function1) {
        if (this.innerDragBeginHandler == null) {
            QSearchPageListEvent$addDragBeginListener$1 qSearchPageListEvent$addDragBeginListener$1 = new QSearchPageListEvent$addDragBeginListener$1(this);
            this.innerDragBeginHandler = qSearchPageListEvent$addDragBeginListener$1;
            Intrinsics.checkNotNull(qSearchPageListEvent$addDragBeginListener$1);
            dragBegin(qSearchPageListEvent$addDragBeginListener$1);
        }
        if (this.dragBeginListeners.contains(function1)) {
            return;
        }
        this.dragBeginListeners.add(function1);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List<kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit>>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List<kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit>>, java.util.ArrayList] */
    public final void addPageChangeListener(Function1<Object, Unit> function1) {
        if (this.innerPageChangeHandler == null) {
            QSearchPageListEvent$addPageChangeListener$1 qSearchPageListEvent$addPageChangeListener$1 = new QSearchPageListEvent$addPageChangeListener$1(this);
            this.innerPageChangeHandler = qSearchPageListEvent$addPageChangeListener$1;
            Intrinsics.checkNotNull(qSearchPageListEvent$addPageChangeListener$1);
            pageIndexDidChanged(qSearchPageListEvent$addPageChangeListener$1);
        }
        if (this.pageChangeListeners.contains(function1)) {
            return;
        }
        this.pageChangeListeners.add(function1);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List<kotlin.jvm.functions.Function1<com.tencent.kuikly.core.views.bn, kotlin.Unit>>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List<kotlin.jvm.functions.Function1<com.tencent.kuikly.core.views.bn, kotlin.Unit>>, java.util.ArrayList] */
    public final void addScrollEndListener(Function1<? super ScrollParams, Unit> function1) {
        if (this.innerScrollEndHandler == null) {
            QSearchPageListEvent$addScrollEndListener$1 qSearchPageListEvent$addScrollEndListener$1 = new QSearchPageListEvent$addScrollEndListener$1(this);
            this.innerScrollEndHandler = qSearchPageListEvent$addScrollEndListener$1;
            Intrinsics.checkNotNull(qSearchPageListEvent$addScrollEndListener$1);
            scrollEnd(qSearchPageListEvent$addScrollEndListener$1);
        }
        if (this.scrollEndListeners.contains(function1)) {
            return;
        }
        this.scrollEndListeners.add(function1);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List<kotlin.jvm.functions.Function1<com.tencent.kuikly.core.views.bn, kotlin.Unit>>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List<kotlin.jvm.functions.Function1<com.tencent.kuikly.core.views.bn, kotlin.Unit>>, java.util.ArrayList] */
    public final void addScrollListener(Function1<? super ScrollParams, Unit> function1) {
        if (this.innerScrollHandler == null) {
            QSearchPageListEvent$addScrollListener$1 qSearchPageListEvent$addScrollListener$1 = new QSearchPageListEvent$addScrollListener$1(this);
            this.innerScrollHandler = qSearchPageListEvent$addScrollListener$1;
            Intrinsics.checkNotNull(qSearchPageListEvent$addScrollListener$1);
            scroll(qSearchPageListEvent$addScrollListener$1);
        }
        if (this.scrollListeners.contains(function1)) {
            return;
        }
        this.scrollListeners.add(function1);
    }
}
