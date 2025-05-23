package com.tencent.ntcompose.activity;

import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.kuikly.core.pager.g;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010;\u001a\u000206\u00a2\u0006\u0004\bC\u0010DJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J%\u0010\u0011\u001a\u001f\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\t0\rj\u0002`\u000f\u00a2\u0006\u0002\b\u0010H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\u0016\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016J\"\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u001d\u001a\u00020\tH\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0007H\u0016J\b\u0010!\u001a\u00020\tH\u0016J\b\u0010#\u001a\u00020\"H\u0016J\b\u0010$\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020\"H\u0016J\u0018\u0010(\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0007H\u0016J\u0018\u0010*\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020)H\u0016J\b\u0010+\u001a\u00020\"H\u0016J\u0018\u0010/\u001a\u00020\t2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020,H\u0016J\n\u00101\u001a\u0004\u0018\u000100H\u0016J\b\u00103\u001a\u000202H\u0016J\u0010\u00105\u001a\u00020\t2\u0006\u00104\u001a\u00020\u0005H\u0016R\u0017\u0010;\u001a\u0002068\u0006\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\"\u0010\b\u001a\u00020<8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B\u00a8\u0006E"}, d2 = {"Lcom/tencent/ntcompose/activity/e;", "Lcom/tencent/kuikly/core/pager/Pager;", "Lcom/tencent/kuikly/core/pager/b;", "hostPager", "innerPager", "", "pagerId", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", ISchemeApi.KEY_PAGE_DATA, "", "onCreatePager", "onDestroyPager", "created", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/base/ViewContainer;", "Lcom/tencent/kuikly/core/base/ViewBuilder;", "Lkotlin/ExtensionFunctionType;", "body", "didInit", "", "Lcom/tencent/kuikly/core/module/Module;", "createExternalModules", "pageDidAppear", "onLayoutView", "", "viewRef", "event", "res", "onViewEvent", "pageDidDisappear", Pager.PAGER_EVENT_WILL_DESTROY, "data", Pager.PAGER_EVENT_THEME_DID_CHANGED, "onFirstFramePaint", "", "scaleFontSizeEnable", "debugUIInspector", MiniGamePAHippyBaseFragment.KEY_THEME, "pagerEvent", "eventData", "onReceivePagerEvent", "", "onReceivePagerEventV2", "isV2", "", "width", "height", "onPageRootViewSizeChanged", "Lcom/tencent/kuikly/core/layout/FlexNode;", "createFlexNodeInstance", "", "pagerDensity", "stack", "onUnhandledException", "Lcom/tencent/ntcompose/activity/ComponentActivity;", "a", "Lcom/tencent/ntcompose/activity/ComponentActivity;", "getComposeDelegate", "()Lcom/tencent/ntcompose/activity/ComponentActivity;", "composeDelegate", "Lcom/tencent/kuikly/core/pager/g;", "b", "Lcom/tencent/kuikly/core/pager/g;", "getPageData", "()Lcom/tencent/kuikly/core/pager/g;", "setPageData", "(Lcom/tencent/kuikly/core/pager/g;)V", "<init>", "(Lcom/tencent/ntcompose/activity/ComponentActivity;)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class e extends Pager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ComponentActivity composeDelegate;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private g pageData;

    public e(ComponentActivity composeDelegate) {
        Intrinsics.checkNotNullParameter(composeDelegate, "composeDelegate");
        this.composeDelegate = composeDelegate;
        this.pageData = new c();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public Function1<ViewContainer<?, ?>, Unit> body() {
        return this.composeDelegate.composeBody();
    }

    @Override // com.tencent.kuikly.core.pager.Pager
    public Map<String, Module> createExternalModules() {
        return this.composeDelegate.composeCreateExternalModules();
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public FlexNode createFlexNodeInstance() {
        return new com.tencent.ntcompose.foundation.layout.base.d();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public void created() {
        super.created();
        this.composeDelegate.composeCreate();
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public boolean debugUIInspector() {
        return this.composeDelegate.composeDebugUIInspector();
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.base.ComposeView, com.tencent.kuikly.core.base.AbstractBaseView
    public void didInit() {
        super.didInit();
        this.composeDelegate.composeDidInit();
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public g getPageData() {
        return this.pageData;
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public com.tencent.kuikly.core.pager.b hostPager() {
        return this.composeDelegate;
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public boolean isNightMode() {
        return this.composeDelegate.composeIsNightMode();
    }

    @Override // com.tencent.kuikly.core.pager.Pager
    public boolean isV2() {
        return this.composeDelegate.isV2();
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public void onCreatePager(String pagerId, com.tencent.kuikly.core.nvi.serialization.json.e pageData) {
        Intrinsics.checkNotNullParameter(pagerId, "pagerId");
        Intrinsics.checkNotNullParameter(pageData, "pageData");
        this.composeDelegate.composeCreatePager(pagerId, pageData);
        super.onCreatePager(pagerId, pageData);
        this.composeDelegate.composeDidCreatedPager(pagerId, pageData);
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public void onDestroyPager() {
        this.composeDelegate.composeDestroyPager();
        super.onDestroyPager();
    }

    @Override // com.tencent.kuikly.core.pager.Pager
    public void onFirstFramePaint() {
        super.onFirstFramePaint();
        this.composeDelegate.composeFirstFramePaint();
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public void onLayoutView() {
        this.composeDelegate.composeLayoutView();
        super.onLayoutView();
    }

    @Override // com.tencent.kuikly.core.pager.Pager
    public void onPageRootViewSizeChanged(double width, double height) {
        super.onPageRootViewSizeChanged(width, height);
        this.composeDelegate.onPageRootViewSizeChanged(width, height);
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public void onReceivePagerEvent(String pagerEvent, com.tencent.kuikly.core.nvi.serialization.json.e eventData) {
        Intrinsics.checkNotNullParameter(pagerEvent, "pagerEvent");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        super.onReceivePagerEvent(pagerEvent, eventData);
        this.composeDelegate.onReceivePagerEvent(pagerEvent, eventData);
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public void onReceivePagerEventV2(String pagerEvent, Object eventData) {
        Intrinsics.checkNotNullParameter(pagerEvent, "pagerEvent");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        super.onReceivePagerEventV2(pagerEvent, eventData);
        this.composeDelegate.onReceivePagerEventV2(pagerEvent, eventData);
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public void onUnhandledException(String stack) {
        Intrinsics.checkNotNullParameter(stack, "stack");
        super.onUnhandledException(stack);
        this.composeDelegate.onUnhandledException(stack);
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public void onViewEvent(int viewRef, String event, com.tencent.kuikly.core.nvi.serialization.json.e res) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.composeDelegate.composeViewEvent(viewRef, event, res);
        super.onViewEvent(viewRef, event, res);
    }

    @Override // com.tencent.kuikly.core.pager.Pager
    public void pageDidAppear() {
        super.pageDidAppear();
        this.composeDelegate.composePageDidAppear();
    }

    @Override // com.tencent.kuikly.core.pager.Pager
    public void pageDidDisappear() {
        super.pageDidDisappear();
        this.composeDelegate.composePageDidDisappear();
    }

    @Override // com.tencent.kuikly.core.pager.Pager
    public void pageWillDestroy() {
        super.pageWillDestroy();
        this.composeDelegate.composePageWillDestroy();
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public float pagerDensity() {
        return this.composeDelegate.pagerDensity();
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public boolean scaleFontSizeEnable() {
        return this.composeDelegate.composeScaleFontSizeEnable();
    }

    @Override // com.tencent.kuikly.core.pager.Pager
    public void setPageData(g gVar) {
        Intrinsics.checkNotNullParameter(gVar, "<set-?>");
        this.pageData = gVar;
    }

    @Override // com.tencent.kuikly.core.pager.Pager
    public void themeDidChanged(com.tencent.kuikly.core.nvi.serialization.json.e data) {
        Intrinsics.checkNotNullParameter(data, "data");
        super.themeDidChanged(data);
        this.composeDelegate.composeThemeDidChanged(data);
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public com.tencent.kuikly.core.pager.b innerPager() {
        return this;
    }
}
