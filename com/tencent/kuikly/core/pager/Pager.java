package com.tencent.kuikly.core.pager;

import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.base.AnimationManager;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.RenderView;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.exception.PagerNotFoundExceptionKt;
import com.tencent.kuikly.core.global.GlobalFunctions;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.TaskManager;
import com.tencent.kuikly.core.module.FontModule;
import com.tencent.kuikly.core.module.MemoryCacheModule;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.module.NetworkModule;
import com.tencent.kuikly.core.module.PerformanceModule;
import com.tencent.kuikly.core.module.m;
import com.tencent.kuikly.core.module.q;
import com.tencent.kuikly.core.module.r;
import com.tencent.kuikly.core.module.s;
import com.tencent.kuikly.core.module.t;
import com.tencent.kuikly.core.pager.b;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tribe.async.log.SLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u00ec\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\b&\u0018\u0000 \u00ab\u00012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0002\u00ac\u0001B\t\u00a2\u0006\u0006\b\u00a9\u0001\u0010\u00aa\u0001J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\u001e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0002J\b\u0010\u0017\u001a\u00020\u0005H\u0002J\b\u0010\u0018\u001a\u00020\u0005H\u0002J\b\u0010\u0019\u001a\u00020\u0005H\u0002J\b\u0010\u001a\u001a\u00020\u0005H\u0002J\b\u0010\u001b\u001a\u00020\u0005H\u0002J \u0010!\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0002J\u0018\u0010\"\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0002J\b\u0010#\u001a\u00020\u0002H\u0016J\u0018\u0010&\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u001cH\u0016J\b\u0010'\u001a\u00020\u0005H\u0016J\b\u0010(\u001a\u00020\u0005H\u0016J\b\u0010)\u001a\u00020\u0005H\u0016J\"\u0010.\u001a\u00020\u00052\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\n2\b\u0010-\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010/\u001a\u00020\u0003H\u0016J#\u00101\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u00100*\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a2\u0006\u0004\b1\u00102J!\u00103\u001a\u00028\u0000\"\b\b\u0000\u00100*\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a2\u0006\u0004\b3\u00102J\u0016\u00107\u001a\u00020\u00052\u0006\u00104\u001a\u00020\n2\u0006\u00106\u001a\u000205J\u0016\u0010;\u001a\u00020\u00052\u0006\u00108\u001a\u00020\n2\u0006\u0010:\u001a\u000209J\u0016\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0018\u00010<H\u0016J\u001a\u0010?\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010>2\u0006\u00108\u001a\u00020\nH\u0016J\b\u0010@\u001a\u00020\u0005H\u0016J\b\u0010A\u001a\u00020\u0005H\u0016J\b\u0010B\u001a\u00020\u0005H\u0016J\b\u0010C\u001a\u00020\u0005H\u0016J\u0010\u0010D\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cH\u0016JA\u0010L\u001a\u00020\u00052\f\u0010F\u001a\b\u0012\u0004\u0012\u00020E0\u00132\u0006\u0010G\u001a\u00020E2!\u0010K\u001a\u001d\u0012\u0013\u0012\u00110E\u00a2\u0006\f\bI\u0012\b\b\u000b\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020\u00050HH\u0016J\u0010\u0010M\u001a\u00020\u00052\u0006\u0010G\u001a\u00020EH\u0016J\u0010\u0010P\u001a\u00020\u00052\u0006\u0010O\u001a\u00020NH\u0016J\u0010\u0010Q\u001a\u00020\u00052\u0006\u0010O\u001a\u00020NH\u0016J\u0010\u0010S\u001a\u00020\u00052\u0006\u0010O\u001a\u00020RH\u0016J\u0010\u0010T\u001a\u00020\u00052\u0006\u0010O\u001a\u00020RH\u0016J\u0012\u0010V\u001a\u00020\u00052\n\b\u0002\u0010U\u001a\u0004\u0018\u00010EJ\u0018\u0010Y\u001a\u00020\u00052\u0006\u0010W\u001a\u00020\n2\u0006\u0010X\u001a\u00020\u001cH\u0016J \u0010]\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020*2\u000e\u0010\\\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030[H\u0016J\u0010\u0010^\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020*H\u0016J\u001a\u0010_\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010[2\u0006\u0010Z\u001a\u00020*H\u0016J\u001a\u0010a\u001a\u00020\u00052\u0010\u0010\u0014\u001a\f\u0012\u0004\u0012\u00020\u00050\u0013j\u0002``H\u0016J\u0016\u0010b\u001a\u00020\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013H\u0016J\u0016\u0010c\u001a\u00020\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013H\u0016J\u0018\u0010e\u001a\u00020\u00052\u0006\u0010d\u001a\u00020\n2\u0006\u0010J\u001a\u00020EH\u0016J\u0012\u0010f\u001a\u0004\u0018\u00010E2\u0006\u0010d\u001a\u00020\nH\u0016J\b\u0010g\u001a\u00020\u0005H\u0004J\b\u0010h\u001a\u00020\u0005H\u0016J\b\u0010i\u001a\u00020\u0011H\u0016J\u0010\u0010l\u001a\u00020\u00052\u0006\u0010k\u001a\u00020jH\u0016R0\u0010o\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0mj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b`n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bo\u0010pR0\u0010q\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002050mj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u000205`n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bq\u0010pR7\u0010v\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002090mj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u000209`n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\br\u0010s\u001a\u0004\bt\u0010uR@\u0010w\u001a.\u0012\u0004\u0012\u00020*\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030[0mj\u0016\u0012\u0004\u0012\u00020*\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030[`n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bw\u0010pR\"\u0010%\u001a\u00020x8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R&\u0010~\u001a\u00020\n8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0016\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R \u0010\u0088\u0001\u001a\u00030\u0084\u00018VX\u0096\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0085\u0001\u0010s\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R,\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0018\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R+\u0010\u0092\u0001\u001a\u0014\u0012\u0004\u0012\u00020N0\u0090\u0001j\t\u0012\u0004\u0012\u00020N`\u0091\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R+\u0010\u0094\u0001\u001a\u0014\u0012\u0004\u0012\u00020R0\u0090\u0001j\t\u0012\u0004\u0012\u00020R`\u0091\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0094\u0001\u0010\u0093\u0001R\u001c\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0095\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R7\u0010\u009a\u0001\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00130\u0098\u0001j\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0013`\u0099\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R7\u0010\u009c\u0001\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00130\u0098\u0001j\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0013`\u0099\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009c\u0001\u0010\u009b\u0001R2\u0010\u009d\u0001\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020E0mj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020E`n8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u009d\u0001\u0010pR\u0019\u0010\u009e\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R\u0019\u0010k\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bk\u0010\u00a0\u0001R\u0019\u0010\u00a1\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a1\u0001\u0010\u009f\u0001R\u001f\u0010\u00a3\u0001\u001a\u00020\u00118VX\u0096\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00a2\u0001\u0010s\u001a\u0006\b\u00a3\u0001\u0010\u00a4\u0001R9\u0010\u00a5\u0001\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020E0mj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020E`n8\u0016X\u0096\u0004\u00a2\u0006\u000e\n\u0005\b\u00a5\u0001\u0010p\u001a\u0005\b\u00a6\u0001\u0010uR\u0017\u0010\u00a8\u0001\u001a\u00020\u00118VX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u00a7\u0001\u0010\u00a4\u0001\u00a8\u0006\u00ad\u0001"}, d2 = {"Lcom/tencent/kuikly/core/pager/Pager;", "Lcom/tencent/kuikly/core/base/ComposeView;", "Lcom/tencent/kuikly/core/base/k;", "Lcom/tencent/kuikly/core/base/l;", "Lcom/tencent/kuikly/core/pager/b;", "", "dispatchPageWillDestroy", "injectVarToModule", "Lcom/tencent/kuikly/core/module/Module;", "module", "", "name", "createModuleIfNeed", "initCoreModules", "initExternalModules", "createBody", "layoutIfNeed", "", SLog.LOG_TAG, "Lkotlin/Function0;", "task", "performTask", "performDidCalculateLayoutTasks", "performLayoutFinishTasks", "notifyPagerDidLayoutObservers", "notifyPagerWillCalculateLayoutObservers", "notifyPagerCalculateLayoutFinishObservers", "setupRootViewSizeStyle", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "data", "", "width", "height", "handlePagerViewSizeDidChanged", "dispatchOnRootViewSizeChanged", "createAttr", "pagerId", ISchemeApi.KEY_PAGE_DATA, "onCreatePager", "onDestroyPager", "onLayoutView", "onFirstFramePaint", "", "viewRef", "event", "res", "onViewEvent", "createEvent", "T", "getModule", "(Ljava/lang/String;)Lcom/tencent/kuikly/core/module/Module;", "acquireModule", "moduleName", "Lcom/tencent/kuikly/core/pager/a;", "moduleCreator", "registerModule", "viewClassName", "Lcom/tencent/kuikly/core/pager/f;", "viewCreator", "registerViewCreator", "", "createExternalModules", "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "createViewFromRegister", "pageDidAppear", "pageDidDisappear", Pager.PAGER_EVENT_WILL_DESTROY, "syncFlushUI", Pager.PAGER_EVENT_THEME_DID_CHANGED, "", "valueBlock", "byOwner", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "value", "valueChange", "bindValueChange", "unbindAllValueChange", "Lcom/tencent/kuikly/core/pager/c;", "observer", "addPagerEventObserver", "removePagerEventObserver", "Lcom/tencent/kuikly/core/pager/e;", "addPagerLayoutEventObserver", "removePagerLayoutEventObserver", "scrollObject", "fireOnPagerDidScroll", "pagerEvent", "eventData", "onReceivePagerEvent", "nativeRef", "Lcom/tencent/kuikly/core/base/AbstractBaseView;", "view", "putNativeViewRef", "removeNativeViewRef", "getViewWithNativeRef", "Lcom/tencent/kuikly/core/manager/Task;", "addNextTickTask", "addTaskWhenPagerUpdateLayoutFinish", "addTaskWhenPagerDidCalculateLayout", "key", "setMemoryCache", "getValueForKey", "initModule", "didInit", "isWillDestroy", "Lcom/tencent/kuikly/core/pager/PageCreateTrace;", "pageTrace", "setPageTrace", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "modulesMap", "Ljava/util/HashMap;", "moduleCreatorMap", "viewCreatorMap$delegate", "Lkotlin/Lazy;", "getViewCreatorMap", "()Ljava/util/HashMap;", "viewCreatorMap", "nativeRefViewMap", "Lcom/tencent/kuikly/core/pager/g;", "Lcom/tencent/kuikly/core/pager/g;", "getPageData", "()Lcom/tencent/kuikly/core/pager/g;", "setPageData", "(Lcom/tencent/kuikly/core/pager/g;)V", "pageName", "Ljava/lang/String;", "getPageName", "()Ljava/lang/String;", "setPageName", "(Ljava/lang/String;)V", "Lcom/tencent/kuikly/core/coroutines/g;", "lifecycleScope$delegate", "getLifecycleScope", "()Lcom/tencent/kuikly/core/coroutines/g;", "lifecycleScope", "Lcom/tencent/kuikly/core/base/AnimationManager;", "animationManager", "Lcom/tencent/kuikly/core/base/AnimationManager;", "getAnimationManager", "()Lcom/tencent/kuikly/core/base/AnimationManager;", "setAnimationManager", "(Lcom/tencent/kuikly/core/base/AnimationManager;)V", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "pagerEventObserverSet", "Ljava/util/HashSet;", "layoutEventObserverSet", "Lcom/tencent/kuikly/core/manager/TaskManager;", "taskManager", "Lcom/tencent/kuikly/core/manager/TaskManager;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "layoutFinishTasks", "Ljava/util/ArrayList;", "didCalculateLayoutTasks", "keyValueMap", "willDestroy", "Z", "Lcom/tencent/kuikly/core/pager/PageCreateTrace;", "innerDidCreateBody", "isDebugUIInspector$delegate", "isDebugUIInspector", "()Z", "dynamicExtProps", "getDynamicExtProps", "getDidCreateBody", "didCreateBody", "<init>", "()V", "Companion", "a", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public abstract class Pager extends ComposeView<com.tencent.kuikly.core.base.k, com.tencent.kuikly.core.base.l> implements com.tencent.kuikly.core.pager.b {
    public static final String HEIGHT = "height";
    public static final String PAGER_EVENT_DID_APPEAR = "viewDidAppear";
    public static final String PAGER_EVENT_DID_DISAPPEAR = "viewDidDisappear";
    public static final String PAGER_EVENT_FIRST_FRAME_PAINT = "pageFirstFramePaint";
    public static final String PAGER_EVENT_ROOT_VIEW_SIZE_CHANGED = "rootViewSizeDidChanged";
    public static final String PAGER_EVENT_SET_NEED_LAYOUT = "setNeedLayout";
    public static final String PAGER_EVENT_THEME_DID_CHANGED = "themeDidChanged";
    public static final String PAGER_EVENT_WILL_DESTROY = "pageWillDestroy";
    public static final String WIDTH = "width";
    private AnimationManager animationManager;
    private ArrayList<Function0<Unit>> didCalculateLayoutTasks;
    private final HashMap<String, Object> dynamicExtProps;
    private boolean innerDidCreateBody;

    /* renamed from: isDebugUIInspector$delegate, reason: from kotlin metadata */
    private final Lazy isDebugUIInspector;
    private final HashMap<String, Object> keyValueMap;
    private HashSet<com.tencent.kuikly.core.pager.e> layoutEventObserverSet;
    private ArrayList<Function0<Unit>> layoutFinishTasks;

    /* renamed from: lifecycleScope$delegate, reason: from kotlin metadata */
    private final Lazy lifecycleScope;
    private final HashMap<Integer, AbstractBaseView<?, ?>> nativeRefViewMap;
    private com.tencent.kuikly.core.pager.g pageData;
    private String pageName;
    private PageCreateTrace pageTrace;
    private HashSet<com.tencent.kuikly.core.pager.c> pagerEventObserverSet;
    private TaskManager taskManager;

    /* renamed from: viewCreatorMap$delegate, reason: from kotlin metadata */
    private final Lazy viewCreatorMap;
    private boolean willDestroy;
    private final HashMap<String, Module> modulesMap = new HashMap<>();
    private final HashMap<String, a> moduleCreatorMap = new HashMap<>();

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/kuikly/core/pager/Pager$b", "Lcom/tencent/kuikly/core/pager/a;", "Lcom/tencent/kuikly/core/module/Module;", "createModule", "core_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b implements a {
        b() {
        }

        @Override // com.tencent.kuikly.core.pager.a
        public Module createModule() {
            return new PerformanceModule();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/kuikly/core/pager/Pager$c", "Lcom/tencent/kuikly/core/pager/a;", "Lcom/tencent/kuikly/core/module/Module;", "createModule", "core_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class c implements a {
        c() {
        }

        @Override // com.tencent.kuikly.core.pager.a
        public Module createModule() {
            return new t();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/kuikly/core/pager/Pager$d", "Lcom/tencent/kuikly/core/pager/a;", "Lcom/tencent/kuikly/core/module/Module;", "createModule", "core_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class d implements a {
        d() {
        }

        @Override // com.tencent.kuikly.core.pager.a
        public Module createModule() {
            return new FontModule();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/kuikly/core/pager/Pager$e", "Lcom/tencent/kuikly/core/pager/a;", "Lcom/tencent/kuikly/core/module/Module;", "createModule", "core_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class e implements a {
        e() {
        }

        @Override // com.tencent.kuikly.core.pager.a
        public Module createModule() {
            return new com.tencent.kuikly.core.module.e();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/kuikly/core/pager/Pager$f", "Lcom/tencent/kuikly/core/pager/a;", "Lcom/tencent/kuikly/core/module/Module;", "createModule", "core_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class f implements a {
        f() {
        }

        @Override // com.tencent.kuikly.core.pager.a
        public Module createModule() {
            return new com.tencent.kuikly.core.module.a();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/kuikly/core/pager/Pager$g", "Lcom/tencent/kuikly/core/pager/a;", "Lcom/tencent/kuikly/core/module/Module;", "createModule", "core_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class g implements a {
        g() {
        }

        @Override // com.tencent.kuikly.core.pager.a
        public Module createModule() {
            return new q();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/kuikly/core/pager/Pager$h", "Lcom/tencent/kuikly/core/pager/a;", "Lcom/tencent/kuikly/core/module/Module;", "createModule", "core_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class h implements a {
        h() {
        }

        @Override // com.tencent.kuikly.core.pager.a
        public Module createModule() {
            return new com.tencent.kuikly.core.module.k();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/kuikly/core/pager/Pager$i", "Lcom/tencent/kuikly/core/pager/a;", "Lcom/tencent/kuikly/core/module/Module;", "createModule", "core_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class i implements a {
        i() {
        }

        @Override // com.tencent.kuikly.core.pager.a
        public Module createModule() {
            return new MemoryCacheModule();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/kuikly/core/pager/Pager$j", "Lcom/tencent/kuikly/core/pager/a;", "Lcom/tencent/kuikly/core/module/Module;", "createModule", "core_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class j implements a {
        j() {
        }

        @Override // com.tencent.kuikly.core.pager.a
        public Module createModule() {
            return new r();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/kuikly/core/pager/Pager$k", "Lcom/tencent/kuikly/core/pager/a;", "Lcom/tencent/kuikly/core/module/Module;", "createModule", "core_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class k implements a {
        k() {
        }

        @Override // com.tencent.kuikly.core.pager.a
        public Module createModule() {
            return new s();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/kuikly/core/pager/Pager$l", "Lcom/tencent/kuikly/core/pager/a;", "Lcom/tencent/kuikly/core/module/Module;", "createModule", "core_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class l implements a {
        l() {
        }

        @Override // com.tencent.kuikly.core.pager.a
        public Module createModule() {
            return new com.tencent.kuikly.core.module.p();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/kuikly/core/pager/Pager$m", "Lcom/tencent/kuikly/core/pager/a;", "Lcom/tencent/kuikly/core/module/Module;", "createModule", "core_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class m implements a {
        m() {
        }

        @Override // com.tencent.kuikly.core.pager.a
        public Module createModule() {
            return new NetworkModule();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/kuikly/core/pager/Pager$n", "Lcom/tencent/kuikly/core/pager/a;", "Lcom/tencent/kuikly/core/module/Module;", "createModule", "core_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class n implements a {
        n() {
        }

        @Override // com.tencent.kuikly.core.pager.a
        public Module createModule() {
            return new com.tencent.kuikly.core.module.d();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/kuikly/core/pager/Pager$o", "Lcom/tencent/kuikly/core/pager/a;", "Lcom/tencent/kuikly/core/module/Module;", "createModule", "core_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class o implements a {
        o() {
        }

        @Override // com.tencent.kuikly.core.pager.a
        public Module createModule() {
            return new com.tencent.kuikly.core.module.b();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/kuikly/core/pager/Pager$p", "Lcom/tencent/kuikly/core/pager/a;", "Lcom/tencent/kuikly/core/module/Module;", "createModule", "core_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class p implements a {
        p() {
        }

        @Override // com.tencent.kuikly.core.pager.a
        public Module createModule() {
            return new com.tencent.kuikly.core.module.o();
        }
    }

    public Pager() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<HashMap<String, com.tencent.kuikly.core.pager.f>>() { // from class: com.tencent.kuikly.core.pager.Pager$viewCreatorMap$2
            @Override // kotlin.jvm.functions.Function0
            public final HashMap<String, f> invoke() {
                return new HashMap<>();
            }
        });
        this.viewCreatorMap = lazy;
        this.nativeRefViewMap = new HashMap<>();
        this.pageData = new com.tencent.kuikly.core.pager.g();
        this.pageName = "";
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<com.tencent.kuikly.core.coroutines.g>() { // from class: com.tencent.kuikly.core.pager.Pager$lifecycleScope$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.kuikly.core.coroutines.g invoke() {
                return new com.tencent.kuikly.core.coroutines.g();
            }
        });
        this.lifecycleScope = lazy2;
        this.pagerEventObserverSet = new HashSet<>();
        this.layoutEventObserverSet = new HashSet<>();
        this.layoutFinishTasks = new ArrayList<>();
        this.didCalculateLayoutTasks = new ArrayList<>();
        this.keyValueMap = new HashMap<>();
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.kuikly.core.pager.Pager$isDebugUIInspector$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(Pager.this.debugUIInspector());
            }
        });
        this.isDebugUIInspector = lazy3;
        this.dynamicExtProps = new HashMap<>();
    }

    private final void createBody() {
        createFlexNode();
        createRenderView();
        RenderView renderView = getRenderView();
        if (renderView != null) {
            renderView.f();
        }
        PageCreateTrace pageCreateTrace = this.pageTrace;
        if (pageCreateTrace != null) {
            pageCreateTrace.g();
        }
        layoutIfNeed();
        PageCreateTrace pageCreateTrace2 = this.pageTrace;
        if (pageCreateTrace2 != null) {
            pageCreateTrace2.f();
        }
        getFlexNode().K0(new Function0<Unit>() { // from class: com.tencent.kuikly.core.pager.Pager$createBody$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                RenderView renderView2 = Pager.this.getRenderView();
                if (renderView2 != null) {
                    RenderView.i(renderView2, Pager.PAGER_EVENT_SET_NEED_LAYOUT, 0, true, 2, null);
                }
            }
        });
    }

    private final void createModuleIfNeed(String name) {
        a aVar;
        if (this.modulesMap.containsKey(name) || !this.moduleCreatorMap.containsKey(name) || (aVar = this.moduleCreatorMap.get(name)) == null) {
            return;
        }
        Module createModule = aVar.createModule();
        this.modulesMap.put(name, createModule);
        injectVarToModule(createModule);
    }

    private final void dispatchOnRootViewSizeChanged(double width, double height) {
        List list;
        list = CollectionsKt___CollectionsKt.toList(this.pagerEventObserverSet);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((com.tencent.kuikly.core.pager.c) it.next()).onRootViewSizeChanged(width, height);
        }
        onPageRootViewSizeChanged(width, height);
    }

    private final void dispatchPageWillDestroy() {
        pageWillDestroy();
        onReceivePagerEvent(PAGER_EVENT_WILL_DESTROY, new com.tencent.kuikly.core.nvi.serialization.json.e());
    }

    private final HashMap<String, com.tencent.kuikly.core.pager.f> getViewCreatorMap() {
        return (HashMap) this.viewCreatorMap.getValue();
    }

    private final void initCoreModules() {
        registerModule("KRNotifyModule", new h());
        registerModule("KRMemoryCacheModule", new i());
        registerModule("KRSharedPreferencesModule", new j());
        registerModule("KRSnapshotModule", new k());
        registerModule("KRRouterModule", new l());
        registerModule("KRNetworkModule", new m());
        registerModule("KRCodecModule", new n());
        registerModule("KRCalendarModule", new o());
        registerModule("KRReflectionModule", new p());
        registerModule("KRPerformanceModule", new b());
        registerModule("KRTurboDisplayModule", new c());
        registerModule("KRFontModule", new d());
        registerModule("KRDiskCacheModule", new e());
        registerModule("KRAccessibilityModule", new f());
        registerModule("KRSQLiteModule", new g());
    }

    private final void initExternalModules() {
        Map<String, Module> createExternalModules = createExternalModules();
        if (createExternalModules != null) {
            this.modulesMap.putAll(createExternalModules);
        }
    }

    private final void injectVarToModule() {
        Iterator<Map.Entry<String, Module>> it = this.modulesMap.entrySet().iterator();
        while (it.hasNext()) {
            injectVarToModule(it.next().getValue());
        }
    }

    private final void notifyPagerCalculateLayoutFinishObservers() {
        List list;
        list = CollectionsKt___CollectionsKt.toList(this.layoutEventObserverSet);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((com.tencent.kuikly.core.pager.e) it.next()).onPagerCalculateLayoutFinish();
        }
    }

    private final void notifyPagerDidLayoutObservers() {
        List list;
        list = CollectionsKt___CollectionsKt.toList(this.layoutEventObserverSet);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((com.tencent.kuikly.core.pager.e) it.next()).onPagerDidLayout();
        }
    }

    private final void notifyPagerWillCalculateLayoutObservers() {
        List list;
        list = CollectionsKt___CollectionsKt.toList(this.layoutEventObserverSet);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((com.tencent.kuikly.core.pager.e) it.next()).onPagerWillCalculateLayoutFinish();
        }
    }

    private final void performDidCalculateLayoutTasks() {
        List list;
        list = CollectionsKt___CollectionsKt.toList(this.didCalculateLayoutTasks);
        this.didCalculateLayoutTasks.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Function0) it.next()).invoke();
        }
    }

    private final void performLayoutFinishTasks() {
        List list;
        list = CollectionsKt___CollectionsKt.toList(this.layoutFinishTasks);
        this.layoutFinishTasks.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Function0) it.next()).invoke();
        }
    }

    private final void setupRootViewSizeStyle() {
        attr(new Function1<com.tencent.kuikly.core.base.k, Unit>() { // from class: com.tencent.kuikly.core.pager.Pager$setupRootViewSizeStyle$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(k kVar) {
                invoke2(kVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(k attr) {
                Intrinsics.checkNotNullParameter(attr, "$this$attr");
                attr.mo153width(Pager.this.getPageData().m());
                attr.mo141height(Pager.this.getPageData().l());
            }
        });
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView, com.tencent.kuikly.core.pager.b
    public <T extends Module> T acquireModule(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        createModuleIfNeed(name);
        if (!this.modulesMap.containsKey(name)) {
            PagerNotFoundExceptionKt.a("acquireModule \u5931\u8d25\uff1a" + name + " \u672a\u6ce8\u518c\uff0c\u8bf7\u5728\u91cd\u5199Pager.createExternalModules\u65b9\u6cd5\u65f6\u673a\u4e2d\u6dfb\u52a0\u6ce8\u518c(\u8c03\u7528Pager.registerModule\u65b9\u6cd5\u6ce8\u518c)");
        }
        Module module = this.modulesMap.get(name);
        Intrinsics.checkNotNull(module, "null cannot be cast to non-null type T of com.tencent.kuikly.core.pager.Pager.acquireModule");
        return (T) module;
    }

    public void addNextTickTask(Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        TaskManager taskManager = this.taskManager;
        if (taskManager != null) {
            taskManager.c(task);
        }
    }

    public void addPagerEventObserver(com.tencent.kuikly.core.pager.c observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.pagerEventObserverSet.add(observer);
    }

    public void addPagerLayoutEventObserver(com.tencent.kuikly.core.pager.e observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.layoutEventObserverSet.add(observer);
    }

    public void addTaskWhenPagerDidCalculateLayout(Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        this.didCalculateLayoutTasks.add(task);
    }

    public void addTaskWhenPagerUpdateLayoutFinish(Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        this.layoutFinishTasks.add(task);
    }

    public void bindValueChange(Function0<? extends Object> valueBlock, Object byOwner, Function1<Object, Unit> valueChange) {
        Intrinsics.checkNotNullParameter(valueBlock, "valueBlock");
        Intrinsics.checkNotNullParameter(byOwner, "byOwner");
        Intrinsics.checkNotNullParameter(valueChange, "valueChange");
        com.tencent.kuikly.core.manager.c.f117352a.i().k(valueBlock, byOwner, valueChange);
    }

    public Map<String, Module> createExternalModules() {
        return null;
    }

    @Override // com.tencent.kuikly.core.pager.b
    public FlexNode createFlexNodeInstance() {
        return b.a.a(this);
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public DeclarativeBaseView<?, ?> createViewFromRegister(String viewClassName) {
        com.tencent.kuikly.core.pager.f fVar;
        Intrinsics.checkNotNullParameter(viewClassName, "viewClassName");
        if (getViewCreatorMap().isEmpty() || (fVar = getViewCreatorMap().get(viewClassName)) == null) {
            return null;
        }
        return fVar.createView();
    }

    public boolean debugUIInspector() {
        return b.a.b(this);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView, com.tencent.kuikly.core.base.AbstractBaseView
    public void didInit() {
        PageCreateTrace pageCreateTrace = this.pageTrace;
        if (pageCreateTrace != null) {
            pageCreateTrace.c();
        }
        super.didInit();
        setupRootViewSizeStyle();
        PageCreateTrace pageCreateTrace2 = this.pageTrace;
        if (pageCreateTrace2 != null) {
            pageCreateTrace2.b();
        }
    }

    public final void fireOnPagerDidScroll(Object scrollObject) {
        List list;
        list = CollectionsKt___CollectionsKt.toList(this.layoutEventObserverSet);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((com.tencent.kuikly.core.pager.e) it.next()).onPagerDidScroll(scrollObject);
        }
    }

    @Override // com.tencent.kuikly.core.pager.b
    public AnimationManager getAnimationManager() {
        return this.animationManager;
    }

    @Override // com.tencent.kuikly.core.pager.b
    /* renamed from: getDidCreateBody, reason: from getter */
    public boolean getInnerDidCreateBody() {
        return this.innerDidCreateBody;
    }

    @Override // com.tencent.kuikly.core.pager.b
    public HashMap<String, Object> getDynamicExtProps() {
        return this.dynamicExtProps;
    }

    public com.tencent.kuikly.core.coroutines.g getLifecycleScope() {
        return (com.tencent.kuikly.core.coroutines.g) this.lifecycleScope.getValue();
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView, com.tencent.kuikly.core.pager.b
    public <T extends Module> T getModule(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        createModuleIfNeed(name);
        Module module = this.modulesMap.get(name);
        if (module instanceof Module) {
            return (T) module;
        }
        return null;
    }

    @Override // com.tencent.kuikly.core.pager.b
    public com.tencent.kuikly.core.pager.g getPageData() {
        return this.pageData;
    }

    @Override // com.tencent.kuikly.core.pager.b
    public String getPageName() {
        return this.pageName;
    }

    @Override // com.tencent.kuikly.core.pager.b
    public Object getValueForKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.keyValueMap.get(key);
    }

    public AbstractBaseView<?, ?> getViewWithNativeRef(int nativeRef) {
        return this.nativeRefViewMap.get(Integer.valueOf(nativeRef));
    }

    @Override // com.tencent.kuikly.core.pager.b
    public com.tencent.kuikly.core.pager.b hostPager() {
        return b.a.d(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void initModule() {
        initCoreModules();
        initExternalModules();
        injectVarToModule();
    }

    @Override // com.tencent.kuikly.core.pager.b
    public com.tencent.kuikly.core.pager.b innerPager() {
        return b.a.e(this);
    }

    @Override // com.tencent.kuikly.core.pager.b
    public boolean isDebugUIInspector() {
        return ((Boolean) this.isDebugUIInspector.getValue()).booleanValue();
    }

    public boolean isNightMode() {
        return b.a.f(this);
    }

    public boolean isV2() {
        return b.a.g(this);
    }

    @Override // com.tencent.kuikly.core.pager.b
    /* renamed from: isWillDestroy, reason: from getter */
    public boolean getWillDestroy() {
        return this.willDestroy;
    }

    public void onCreatePager(String pagerId, com.tencent.kuikly.core.nvi.serialization.json.e pageData) {
        Intrinsics.checkNotNullParameter(pagerId, "pagerId");
        Intrinsics.checkNotNullParameter(pageData, "pageData");
        PageCreateTrace pageCreateTrace = this.pageTrace;
        if (pageCreateTrace != null) {
            pageCreateTrace.e();
        }
        setPagerId(pagerId);
        getPageData().r(pageData);
        this.taskManager = new TaskManager(pagerId);
        willInit();
        initModule();
        didMoveToParentView();
        didInit();
        createBody();
        this.innerDidCreateBody = true;
        PageCreateTrace pageCreateTrace2 = this.pageTrace;
        if (pageCreateTrace2 != null) {
            pageCreateTrace2.d();
        }
    }

    public void onFirstFramePaint() {
        ((PerformanceModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRPerformanceModule")).a(new Function1<com.tencent.kuikly.core.module.m, Unit>() { // from class: com.tencent.kuikly.core.pager.Pager$onFirstFramePaint$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(m mVar) {
                invoke2(mVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(m mVar) {
                KLog.INSTANCE.d(Pager.this.getPageName(), String.valueOf(mVar != null ? mVar.getPageLoadTime() : null));
            }
        });
    }

    public void onLayoutView() {
        layoutIfNeed();
    }

    public void onPageRootViewSizeChanged(double d16, double d17) {
        b.a.i(this, d16, d17);
    }

    public void onReceivePagerEvent(String pagerEvent, com.tencent.kuikly.core.nvi.serialization.json.e eventData) {
        List list;
        Intrinsics.checkNotNullParameter(pagerEvent, "pagerEvent");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        list = CollectionsKt___CollectionsKt.toList(this.pagerEventObserverSet);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((com.tencent.kuikly.core.pager.c) it.next()).onPagerEvent(pagerEvent, eventData);
        }
        switch (pagerEvent.hashCode()) {
            case -2124303921:
                if (pagerEvent.equals(PAGER_EVENT_DID_APPEAR)) {
                    pageDidAppear();
                    return;
                }
                return;
            case -1488301262:
                if (pagerEvent.equals(PAGER_EVENT_FIRST_FRAME_PAINT)) {
                    onFirstFramePaint();
                    return;
                }
                return;
            case -970249943:
                if (pagerEvent.equals(PAGER_EVENT_DID_DISAPPEAR)) {
                    pageDidDisappear();
                    return;
                }
                return;
            case 785330845:
                if (pagerEvent.equals(PAGER_EVENT_ROOT_VIEW_SIZE_CHANGED)) {
                    handlePagerViewSizeDidChanged(eventData, eventData.h("width"), eventData.h("height"));
                    return;
                }
                return;
            case 1860346846:
                if (pagerEvent.equals(PAGER_EVENT_THEME_DID_CHANGED)) {
                    themeDidChanged(eventData);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.kuikly.core.pager.b
    public void onReceivePagerEventV2(String str, Object obj) {
        b.a.j(this, str, obj);
    }

    public void onUnhandledException(String str) {
        b.a.k(this, str);
    }

    public void onViewEvent(int viewRef, String event, com.tencent.kuikly.core.nvi.serialization.json.e res) {
        Intrinsics.checkNotNullParameter(event, "event");
        AbstractBaseView<?, ?> viewWithNativeRef = getViewWithNativeRef(viewRef);
        if (viewWithNativeRef != null) {
            viewWithNativeRef.onFireEvent(event, res);
        }
    }

    public void pageWillDestroy() {
        b.a.n(this);
    }

    public float pagerDensity() {
        return b.a.o(this);
    }

    public void putNativeViewRef(int nativeRef, AbstractBaseView<?, ?> view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.nativeRefViewMap.put(Integer.valueOf(nativeRef), view);
    }

    public final void registerModule(String moduleName, a moduleCreator) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(moduleCreator, "moduleCreator");
        this.moduleCreatorMap.put(moduleName, moduleCreator);
    }

    public final void registerViewCreator(String viewClassName, com.tencent.kuikly.core.pager.f viewCreator) {
        Intrinsics.checkNotNullParameter(viewClassName, "viewClassName");
        Intrinsics.checkNotNullParameter(viewCreator, "viewCreator");
        getViewCreatorMap().put(viewClassName, viewCreator);
    }

    public void removeNativeViewRef(int nativeRef) {
        this.nativeRefViewMap.remove(Integer.valueOf(nativeRef));
    }

    public void removePagerEventObserver(com.tencent.kuikly.core.pager.c observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.pagerEventObserverSet.remove(observer);
    }

    public void removePagerLayoutEventObserver(com.tencent.kuikly.core.pager.e observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.layoutEventObserverSet.remove(observer);
    }

    public boolean scaleFontSizeEnable() {
        return b.a.p(this);
    }

    @Override // com.tencent.kuikly.core.pager.b
    public void setAnimationManager(AnimationManager animationManager) {
        this.animationManager = animationManager;
    }

    @Override // com.tencent.kuikly.core.pager.b
    public void setMemoryCache(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.keyValueMap.put(key, value);
        ((MemoryCacheModule) acquireModule("KRMemoryCacheModule")).e(key, value);
    }

    public void setPageData(com.tencent.kuikly.core.pager.g gVar) {
        Intrinsics.checkNotNullParameter(gVar, "<set-?>");
        this.pageData = gVar;
    }

    @Override // com.tencent.kuikly.core.pager.b
    public void setPageName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pageName = str;
    }

    public void setPageTrace(PageCreateTrace pageTrace) {
        Intrinsics.checkNotNullParameter(pageTrace, "pageTrace");
        this.pageTrace = pageTrace;
    }

    public void syncFlushUI() {
        BridgeManager.f117344a.o(getPagerId());
    }

    public void themeDidChanged(com.tencent.kuikly.core.nvi.serialization.json.e data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    public void unbindAllValueChange(Object byOwner) {
        Intrinsics.checkNotNullParameter(byOwner, "byOwner");
        com.tencent.kuikly.core.manager.c.f117352a.i().y(byOwner);
    }

    private final void handlePagerViewSizeDidChanged(com.tencent.kuikly.core.nvi.serialization.json.e data, double width, double height) {
        if (((float) width) == getPageData().m()) {
            if (((float) height) == getPageData().l()) {
                return;
            }
        }
        getPageData().G(data, width, height);
        setupRootViewSizeStyle();
        dispatchOnRootViewSizeChanged(width, height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void layoutIfNeed() {
        int i3 = 3;
        while (getFlexNode().getIsDirty() && i3 - 1 >= 0) {
            notifyPagerWillCalculateLayoutObservers();
            getFlexNode().b(null);
            notifyPagerCalculateLayoutFinishObservers();
            performDidCalculateLayoutTasks();
            notifyPagerDidLayoutObservers();
            performLayoutFinishTasks();
        }
        if (getFlexNode().getIsDirty()) {
            performTask(true, new Function0<Unit>() { // from class: com.tencent.kuikly.core.pager.Pager$layoutIfNeed$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    Pager.this.layoutIfNeed();
                }
            });
        }
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public com.tencent.kuikly.core.base.k createAttr() {
        return new com.tencent.kuikly.core.base.k();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public com.tencent.kuikly.core.base.l createEvent() {
        return new com.tencent.kuikly.core.base.l();
    }

    public void onDestroyPager() {
        this.willDestroy = true;
        dispatchPageWillDestroy();
        willRemoveFromParentView();
        didRemoveFromParentView();
        this.pagerEventObserverSet.clear();
        this.layoutEventObserverSet.clear();
        GlobalFunctions.f117252a.b(getPagerId());
        TaskManager taskManager = this.taskManager;
        if (taskManager != null) {
            taskManager.b();
        }
        getFlexNode().K0(null);
        this.nativeRefViewMap.clear();
        this.modulesMap.clear();
        this.keyValueMap.clear();
        AnimationManager animationManager = getAnimationManager();
        if (animationManager != null) {
            animationManager.d();
        }
    }

    private final void performTask(boolean async, Function0<Unit> task) {
        if (async) {
            TimerKt.e(getPagerId(), 1, task);
        } else {
            task.invoke();
        }
    }

    private final void injectVarToModule(Module module) {
        module.injectVar$core_release(getPagerId(), getPageData());
    }

    public static /* synthetic */ void fireOnPagerDidScroll$default(Pager pager, Object obj, int i3, Object obj2) {
        if (obj2 == null) {
            if ((i3 & 1) != 0) {
                obj = null;
            }
            pager.fireOnPagerDidScroll(obj);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fireOnPagerDidScroll");
    }

    public void pageDidAppear() {
    }

    public void pageDidDisappear() {
    }
}
