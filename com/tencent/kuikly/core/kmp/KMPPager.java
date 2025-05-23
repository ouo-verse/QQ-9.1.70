package com.tencent.kuikly.core.kmp;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.pager.PageCreateTrace;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b^\u0010_J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016J\"\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0019H\u0016J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0019H\u0016J \u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00102\u000e\u0010\u001e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001dH\u0016J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0010H\u0016J\u001a\u0010$\u001a\u00020\u00062\u0010\u0010#\u001a\f\u0012\u0004\u0012\u00020\u00060!j\u0002`\"H\u0016J\u0016\u0010%\u001a\u00020\u00062\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060!H\u0016J\u0016\u0010&\u001a\u00020\u00062\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060!H\u0016J\b\u0010'\u001a\u00020\u0006H\u0016J\b\u0010(\u001a\u00020\u0006H\u0016J\b\u0010)\u001a\u00020\u0006H\u0016J\b\u0010*\u001a\u00020\u0006H\u0016J%\u0010/\u001a\u001f\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030,\u0012\u0004\u0012\u00020\u00060+j\u0002`-\u00a2\u0006\u0002\b.H\u0016J\u001a\u00103\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00022\b\u00102\u001a\u0004\u0018\u000101H\u0016J\b\u00105\u001a\u000204H\u0016J\u001a\u00107\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\b\u00106\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u00108\u001a\u00020\u0006H\u0016J\b\u00109\u001a\u00020\u0006H\u0016JJ\u0010?\u001a\u00020\u0006\"\u0010\b\u0000\u0010;*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030:2\u0006\u0010<\u001a\u00028\u00002\u0017\u0010=\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060+\u00a2\u0006\u0002\b.2\u0006\u0010>\u001a\u00020\u0010H\u0016\u00a2\u0006\u0004\b?\u0010@J\u0018\u0010A\u001a\u00020\u00062\u000e\u0010<\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030:H\u0016J \u0010B\u001a\u00020\u00062\u000e\u0010<\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030:2\u0006\u0010>\u001a\u00020\u0010H\u0016J\u0010\u0010E\u001a\u00020\u00062\u0006\u0010D\u001a\u00020CH\u0016J\u0018\u0010G\u001a\u00020\u00062\u000e\u0010F\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030:H\u0016JA\u0010N\u001a\u00020\u00062\f\u0010H\u001a\b\u0012\u0004\u0012\u0002010!2\u0006\u0010I\u001a\u0002012!\u0010M\u001a\u001d\u0012\u0013\u0012\u001101\u00a2\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(L\u0012\u0004\u0012\u00020\u00060+H\u0016J\u0010\u0010O\u001a\u00020\u00062\u0006\u0010I\u001a\u000201H\u0016J!\u0010Q\u001a\u00020\u00062\u0017\u0010=\u001a\u0013\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020\u00060+\u00a2\u0006\u0002\b.H\u0016J!\u0010\u0012\u001a\u00020\u00062\u0017\u0010=\u001a\u0013\u0012\u0004\u0012\u00020R\u0012\u0004\u0012\u00020\u00060+\u00a2\u0006\u0002\b.H\u0016J\b\u0010S\u001a\u00020\u0006H\u0016J\b\u0010T\u001a\u00020\u0006H\u0016J\b\u0010U\u001a\u00020\u0006H\u0016JN\u0010W\u001a\u00020\u0006\"\u0010\b\u0000\u0010;*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030:*\u00028\u00002'\u0010W\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000V\u00a2\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00060+H\u0016\u00a2\u0006\u0004\bW\u0010XJ\u0010\u0010Y\u001a\u00020\u00062\u0006\u0010D\u001a\u00020CH\u0016J\u001a\u0010Z\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u001d2\u0006\u0010\u001c\u001a\u00020\u0010H\u0016R\u001e\u0010]\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010,8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b[\u0010\\\u00a8\u0006`"}, d2 = {"Lcom/tencent/kuikly/core/kmp/KMPPager;", "Lcom/tencent/kuikly/core/pager/Pager;", "", "pagerId", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", ISchemeApi.KEY_PAGE_DATA, "", "onCreatePager", "onDestroyPager", "pagerEvent", "eventData", "onReceivePagerEvent", "onLayoutView", "Lcom/tencent/kuikly/core/pager/PageCreateTrace;", "pageTrace", "setPageTrace", "", "viewRef", "event", "res", "onViewEvent", "Lcom/tencent/kuikly/core/pager/c;", "observer", "addPagerEventObserver", "removePagerEventObserver", "Lcom/tencent/kuikly/core/pager/e;", "addPagerLayoutEventObserver", "removePagerLayoutEventObserver", "nativeRef", "Lcom/tencent/kuikly/core/base/AbstractBaseView;", "view", "putNativeViewRef", "removeNativeViewRef", "Lkotlin/Function0;", "Lcom/tencent/kuikly/core/manager/Task;", "task", "addNextTickTask", "addTaskWhenPagerUpdateLayoutFinish", "addTaskWhenPagerDidCalculateLayout", "didInit", "willInit", "willRemoveFromParentView", "didRemoveFromParentView", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/base/ViewContainer;", "Lcom/tencent/kuikly/core/base/ViewBuilder;", "Lkotlin/ExtensionFunctionType;", "body", AdMetricTag.EVENT_NAME, "", "param", "emit", "", "isRenderView", "data", "onFireEvent", "createFlexNode", "createRenderView", "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "T", "child", "init", "index", "addChild", "(Lcom/tencent/kuikly/core/base/DeclarativeBaseView;Lkotlin/jvm/functions/Function1;I)V", "removeChild", "didInsertDomChild", "Lcom/tencent/kuikly/core/layout/d;", AIInput.KEY_FRAME, "layoutFrameDidChanged", "subView", "insertSubRenderView", "valueBlock", "byOwner", "Lkotlin/ParameterName;", "name", "value", "valueChange", "bindValueChange", "unbindAllValueChange", "Lcom/tencent/kuikly/core/base/k;", "attr", "Lcom/tencent/kuikly/core/base/l;", "onFirstFramePaint", "syncFlushUI", "bringToFront", "Lcom/tencent/kuikly/core/base/aa;", "ref", "(Lcom/tencent/kuikly/core/base/DeclarativeBaseView;Lkotlin/jvm/functions/Function1;)V", "setFrameToRenderView", "getViewWithNativeRef", "getDomParent", "()Lcom/tencent/kuikly/core/base/ViewContainer;", "domParent", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class KMPPager extends Pager {
    @Override // com.tencent.kuikly.core.base.ViewContainer
    public <T extends DeclarativeBaseView<?, ?>> void addChild(T child, Function1<? super T, Unit> init, int index) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(init, "init");
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public void addNextTickTask(Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public void addPagerEventObserver(com.tencent.kuikly.core.pager.c observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public void addPagerLayoutEventObserver(com.tencent.kuikly.core.pager.e observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public void addTaskWhenPagerDidCalculateLayout(Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public void addTaskWhenPagerUpdateLayoutFinish(Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView, com.tencent.kuikly.core.base.q
    public void attr(Function1<? super k, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
    }

    @Override // com.tencent.kuikly.core.pager.Pager
    public void bindValueChange(Function0<? extends Object> valueBlock, Object byOwner, Function1<Object, Unit> valueChange) {
        Intrinsics.checkNotNullParameter(valueBlock, "valueBlock");
        Intrinsics.checkNotNullParameter(byOwner, "byOwner");
        Intrinsics.checkNotNullParameter(valueChange, "valueChange");
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.kuikly.core.kmp.KMPPager$body$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ViewContainer<?, ?> viewContainer) {
                Intrinsics.checkNotNullParameter(viewContainer, "$this$null");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer) {
                invoke2(viewContainer);
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.ViewContainer
    public void didInsertDomChild(DeclarativeBaseView<?, ?> child, int index) {
        Intrinsics.checkNotNullParameter(child, "child");
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public void emit(String eventName, Object param) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public void event(Function1<? super l, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public ViewContainer<?, ?> getDomParent() {
        return null;
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public AbstractBaseView<?, ?> getViewWithNativeRef(int nativeRef) {
        return null;
    }

    @Override // com.tencent.kuikly.core.base.ViewContainer
    public void insertSubRenderView(DeclarativeBaseView<?, ?> subView) {
        Intrinsics.checkNotNullParameter(subView, "subView");
    }

    @Override // com.tencent.kuikly.core.base.ComposeView, com.tencent.kuikly.core.views.internal.GroupView, com.tencent.kuikly.core.base.DeclarativeBaseView
    public boolean isRenderView() {
        return false;
    }

    @Override // com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.DeclarativeBaseView, com.tencent.kuikly.core.base.AbstractBaseView
    public void layoutFrameDidChanged(com.tencent.kuikly.core.layout.d frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public void onCreatePager(String pagerId, com.tencent.kuikly.core.nvi.serialization.json.e pageData) {
        Intrinsics.checkNotNullParameter(pagerId, "pagerId");
        Intrinsics.checkNotNullParameter(pageData, "pageData");
        setPagerId(pagerId);
        getPageData().r(pageData);
        initModule();
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public void onDestroyPager() {
        super.onDestroyPager();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public void onFireEvent(String event, com.tencent.kuikly.core.nvi.serialization.json.e data) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public void onReceivePagerEvent(String pagerEvent, com.tencent.kuikly.core.nvi.serialization.json.e eventData) {
        Intrinsics.checkNotNullParameter(pagerEvent, "pagerEvent");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        switch (pagerEvent.hashCode()) {
            case -2124303921:
                if (pagerEvent.equals(Pager.PAGER_EVENT_DID_APPEAR)) {
                    pageDidAppear();
                    return;
                }
                return;
            case -970249943:
                if (pagerEvent.equals(Pager.PAGER_EVENT_DID_DISAPPEAR)) {
                    pageDidDisappear();
                    return;
                }
                return;
            case 785330845:
                if (pagerEvent.equals(Pager.PAGER_EVENT_ROOT_VIEW_SIZE_CHANGED)) {
                    onPageRootViewSizeChanged(eventData.h("width"), eventData.h("height"));
                    return;
                }
                return;
            case 1860346846:
                if (pagerEvent.equals(Pager.PAGER_EVENT_THEME_DID_CHANGED)) {
                    themeDidChanged(eventData);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public void onViewEvent(int viewRef, String event, com.tencent.kuikly.core.nvi.serialization.json.e res) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public void putNativeViewRef(int nativeRef, AbstractBaseView<?, ?> view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public <T extends DeclarativeBaseView<?, ?>> void ref(T t16, Function1<? super aa<T>, Unit> ref) {
        Intrinsics.checkNotNullParameter(t16, "<this>");
        Intrinsics.checkNotNullParameter(ref, "ref");
    }

    @Override // com.tencent.kuikly.core.base.ViewContainer
    public void removeChild(DeclarativeBaseView<?, ?> child) {
        Intrinsics.checkNotNullParameter(child, "child");
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public void removePagerEventObserver(com.tencent.kuikly.core.pager.c observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public void removePagerLayoutEventObserver(com.tencent.kuikly.core.pager.e observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public void setFrameToRenderView(com.tencent.kuikly.core.layout.d frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public void setPageTrace(PageCreateTrace pageTrace) {
        Intrinsics.checkNotNullParameter(pageTrace, "pageTrace");
    }

    @Override // com.tencent.kuikly.core.pager.Pager
    public void unbindAllValueChange(Object byOwner) {
        Intrinsics.checkNotNullParameter(byOwner, "byOwner");
    }

    @Override // com.tencent.kuikly.core.views.internal.GroupView
    public void bringToFront() {
    }

    @Override // com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.AbstractBaseView
    public void createFlexNode() {
    }

    @Override // com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.DeclarativeBaseView
    public void createRenderView() {
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.base.ComposeView, com.tencent.kuikly.core.base.AbstractBaseView
    public void didInit() {
    }

    @Override // com.tencent.kuikly.core.base.ComposeView, com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.DeclarativeBaseView
    public void didRemoveFromParentView() {
    }

    @Override // com.tencent.kuikly.core.pager.Pager
    public void onFirstFramePaint() {
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public void onLayoutView() {
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public void syncFlushUI() {
    }

    @Override // com.tencent.kuikly.core.base.ComposeView, com.tencent.kuikly.core.base.AbstractBaseView
    public void willInit() {
    }

    @Override // com.tencent.kuikly.core.base.ComposeView, com.tencent.kuikly.core.base.DeclarativeBaseView
    public void willRemoveFromParentView() {
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public void removeNativeViewRef(int nativeRef) {
    }
}
