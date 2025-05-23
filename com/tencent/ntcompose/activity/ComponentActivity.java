package com.tencent.ntcompose.activity;

import androidx.compose.runtime.Composer;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.base.AnimationManager;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.coroutines.g;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.pager.PageCreateTrace;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.kuikly.core.pager.b;
import com.tencent.kuikly.core.pager.f;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.ntcompose.activity.d;
import com.tencent.ntcompose.core.ComposeRenderCore;
import com.tencent.ntcompose.lifecycle.common.Lifecycle;
import com.tencent.ntcompose.lifecycle.viewmodel.i;
import com.tencent.ntcompose.lifecycle.viewmodel.j;
import com.tencent.ntcompose.lifecycle.viewmodel.k;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ba\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\b\u00a2\u0006\u0005\b\u00d4\u0001\u0010:J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u000e\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0002J\u0006\u0010\u0014\u001a\u00020\u0013J\u0012\u0010\u0015\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0016J%\u0010\u001e\u001a\u001f\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001b\u0012\u0004\u0012\u00020\u00070\u001aj\u0002`\u001c\u00a2\u0006\u0002\b\u001dH\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\b\u0010 \u001a\u00020\u0007H\u0016J\b\u0010!\u001a\u00020\u0007H\u0016J\b\u0010\"\u001a\u00020\u0007H\u0016J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010$\u001a\u00020#H\u0016J\b\u0010&\u001a\u00020\u0007H\u0016J\u0016\u0010*\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)\u0018\u00010'H\u0016J\b\u0010+\u001a\u00020\u0007H\u0016J\u0018\u0010.\u001a\u00020\u00072\u0006\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020#H\u0016J\u0018\u0010/\u001a\u00020\u00072\u0006\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020#H\u0016J\b\u00100\u001a\u00020\u0007H\u0016J\"\u00104\u001a\u00020\u00072\u0006\u00102\u001a\u0002012\u0006\u0010\n\u001a\u00020(2\b\u00103\u001a\u0004\u0018\u00010#H\u0016J\b\u00106\u001a\u000205H\u0016J\b\u00107\u001a\u000205H\u0016J\b\u00108\u001a\u000205H\u0016J\u000f\u0010;\u001a\u00020\u0007H\u0000\u00a2\u0006\u0004\b9\u0010:J\b\u0010<\u001a\u00020\u0002H\u0016J\b\u0010=\u001a\u00020\u0002H\u0016J\u0018\u0010>\u001a\u00020\u00072\u0006\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020#H\u0016J\b\u0010?\u001a\u00020\u0007H\u0016J\b\u0010@\u001a\u00020\u0007H\u0016J\"\u0010A\u001a\u00020\u00072\u0006\u00102\u001a\u0002012\u0006\u0010\n\u001a\u00020(2\b\u00103\u001a\u0004\u0018\u00010#H\u0016J#\u0010D\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010B*\u00020)2\u0006\u0010C\u001a\u00020(H\u0016\u00a2\u0006\u0004\bD\u0010EJ!\u0010F\u001a\u00028\u0000\"\b\b\u0000\u0010B*\u00020)2\u0006\u0010C\u001a\u00020(H\u0016\u00a2\u0006\u0004\bF\u0010EJ\u0016\u0010G\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)\u0018\u00010'H\u0016J\b\u0010H\u001a\u00020\u0007H\u0016J\u0010\u0010I\u001a\u00020\u00072\u0006\u0010$\u001a\u00020#H\u0016JA\u0010P\u001a\u00020\u00072\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00010J2\u0006\u0010L\u001a\u00020\u00012!\u0010O\u001a\u001d\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\bM\u0012\b\bC\u0012\u0004\b\b(N\u0012\u0004\u0012\u00020\u00070\u001aH\u0016J\u0010\u0010Q\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u0001H\u0016J\u0010\u0010T\u001a\u00020\u00072\u0006\u0010S\u001a\u00020RH\u0016J\u0010\u0010U\u001a\u00020\u00072\u0006\u0010S\u001a\u00020RH\u0016J\u0010\u0010W\u001a\u00020\u00072\u0006\u0010S\u001a\u00020VH\u0016J\u0010\u0010X\u001a\u00020\u00072\u0006\u0010S\u001a\u00020VH\u0016J\u0018\u0010[\u001a\u00020\u00072\u0006\u0010Y\u001a\u00020(2\u0006\u0010Z\u001a\u00020#H\u0016J\u0018\u0010_\u001a\u00020\u00072\u0006\u0010]\u001a\u00020\\2\u0006\u0010^\u001a\u00020\\H\u0016J\u0018\u0010`\u001a\u00020\u00072\u0006\u0010Y\u001a\u00020(2\u0006\u0010Z\u001a\u00020\u0001H\u0016J \u0010d\u001a\u00020\u00072\u0006\u0010a\u001a\u0002012\u000e\u0010c\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030bH\u0016J\u0010\u0010e\u001a\u00020\u00072\u0006\u0010a\u001a\u000201H\u0016J\u001a\u0010f\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010b2\u0006\u0010a\u001a\u000201H\u0016J\u001a\u0010i\u001a\u00020\u00072\u0010\u0010h\u001a\f\u0012\u0004\u0012\u00020\u00070Jj\u0002`gH\u0016J\u0016\u0010j\u001a\u00020\u00072\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00070JH\u0016J\u0016\u0010k\u001a\u00020\u00072\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00070JH\u0016J\u0018\u0010m\u001a\u00020\u00072\u0006\u0010l\u001a\u00020(2\u0006\u0010N\u001a\u00020\u0001H\u0016J\u0012\u0010n\u001a\u0004\u0018\u00010\u00012\u0006\u0010l\u001a\u00020(H\u0016J\b\u0010o\u001a\u000205H\u0016J\b\u0010p\u001a\u00020\u0007H\u0016J\b\u0010q\u001a\u000205H\u0016J\b\u0010r\u001a\u000205H\u0016J\b\u0010s\u001a\u000205H\u0016J\u0010\u0010v\u001a\u00020\u00072\u0006\u0010u\u001a\u00020tH\u0016J\u0016\u0010z\u001a\u00020\u00072\u0006\u0010w\u001a\u00020(2\u0006\u0010y\u001a\u00020xJ\u0016\u0010~\u001a\u00020\u00072\u0006\u0010{\u001a\u00020(2\u0006\u0010}\u001a\u00020|R6\u0010\u0080\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010J\u00a2\u0006\u0002\b\u007f8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0018\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R)\u0010\u0086\u0001\u001a\u0002058\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0018\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0018\u0010\u008d\u0001\u001a\u00030\u008c\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001c\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R!\u0010\u0097\u0001\u001a\u00030\u0092\u00018FX\u0086\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R\u0019\u0010\u0098\u0001\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0098\u0001\u0010\u0087\u0001R\u001a\u0010\u009a\u0001\u001a\u00030\u0099\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R!\u0010\u00a0\u0001\u001a\u00030\u009c\u00018VX\u0096\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u009d\u0001\u0010\u0094\u0001\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001R!\u0010\u00a5\u0001\u001a\u00030\u00a1\u00018FX\u0086\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00a2\u0001\u0010\u0094\u0001\u001a\u0006\b\u00a3\u0001\u0010\u00a4\u0001R!\u0010\u00aa\u0001\u001a\u00030\u00a6\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00a7\u0001\u0010\u0094\u0001\u001a\u0006\b\u00a8\u0001\u0010\u00a9\u0001R \u0010\u00ac\u0001\u001a\u0002058VX\u0096\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00ab\u0001\u0010\u0094\u0001\u001a\u0006\b\u00ac\u0001\u0010\u0089\u0001R!\u0010\u00b1\u0001\u001a\u00030\u00ad\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00ae\u0001\u0010\u0094\u0001\u001a\u0006\b\u00af\u0001\u0010\u00b0\u0001R*\u0010-\u001a\u00030\u00b2\u00012\u0007\u0010N\u001a\u00030\u00b2\u00018V@VX\u0096\u000e\u00a2\u0006\u0010\u001a\u0006\b\u00b3\u0001\u0010\u00b4\u0001\"\u0006\b\u00b5\u0001\u0010\u00b6\u0001R)\u0010\u00bb\u0001\u001a\u00020(2\u0006\u0010N\u001a\u00020(8V@VX\u0096\u000e\u00a2\u0006\u0010\u001a\u0006\b\u00b7\u0001\u0010\u00b8\u0001\"\u0006\b\u00b9\u0001\u0010\u00ba\u0001R\u0017\u0010\u00bd\u0001\u001a\u0002058VX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u00bc\u0001\u0010\u0089\u0001R\u0018\u0010\u00c1\u0001\u001a\u00030\u00be\u00018VX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u00bf\u0001\u0010\u00c0\u0001R/\u0010\u00c7\u0001\u001a\u0005\u0018\u00010\u00c2\u00012\t\u0010N\u001a\u0005\u0018\u00010\u00c2\u00018V@VX\u0096\u000e\u00a2\u0006\u0010\u001a\u0006\b\u00c3\u0001\u0010\u00c4\u0001\"\u0006\b\u00c5\u0001\u0010\u00c6\u0001R5\u0010\u00cc\u0001\u001a \u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00010\u00c8\u0001j\u000f\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u0001`\u00c9\u00018VX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u00ca\u0001\u0010\u00cb\u0001R\u0018\u0010\u00cf\u0001\u001a\u00030\u008f\u00018VX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u00cd\u0001\u0010\u00ce\u0001R\u0018\u0010\u00d3\u0001\u001a\u00030\u00d0\u00018VX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u00d1\u0001\u0010\u00d2\u0001\u00a8\u0006\u00d5\u0001"}, d2 = {"Lcom/tencent/ntcompose/activity/ComponentActivity;", "", "Lcom/tencent/kuikly/core/pager/b;", "Lcom/tencent/ntcompose/activity/d;", "Lcom/tencent/ntcompose/lifecycle/common/c;", "Lcom/tencent/ntcompose/lifecycle/viewmodel/k;", "Lcom/tencent/ntcompose/foundation/event/d;", "", "ensureOnBackDispatcher", "Lcom/tencent/ntcompose/lifecycle/common/Lifecycle$Event;", "event", "dispatch", "Lcom/tencent/ntcompose/activity/a;", Constants.FILE_INSTANCE_STATE, "dispatchActivityPostCreated", "dispatchActivityPostResumed", "dispatchActivityPrePause", "dispatchActivityPreDestroyed", "addViewModelClearObserver", "Lcom/tencent/kuikly/core/pager/Pager;", "getPager", "onCreate", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "composeCreate", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/base/ViewContainer;", "Lcom/tencent/kuikly/core/base/ViewBuilder;", "Lkotlin/ExtensionFunctionType;", "composeBody", "composeDidInit", "composePageDidAppear", "composePageDidDisappear", "composePageWillDestroy", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "data", "composeThemeDidChanged", "composeFirstFramePaint", "", "", "Lcom/tencent/kuikly/core/module/Module;", "composeCreateExternalModules", "composeDestroyPager", "pagerId", ISchemeApi.KEY_PAGE_DATA, "composeCreatePager", "composeDidCreatedPager", "composeLayoutView", "", "viewRef", "res", "composeViewEvent", "", "composeScaleFontSizeEnable", "composeDebugUIInspector", "composeIsNightMode", "renderContent$ntcompose_release", "()V", "renderContent", "innerPager", "hostPager", "onCreatePager", "onDestroyPager", "onLayoutView", "onViewEvent", "T", "name", "getModule", "(Ljava/lang/String;)Lcom/tencent/kuikly/core/module/Module;", "acquireModule", "createExternalModules", "syncFlushUI", Pager.PAGER_EVENT_THEME_DID_CHANGED, "Lkotlin/Function0;", "valueBlock", "byOwner", "Lkotlin/ParameterName;", "value", "valueChange", "bindValueChange", "unbindAllValueChange", "Lcom/tencent/kuikly/core/pager/c;", "observer", "addPagerEventObserver", "removePagerEventObserver", "Lcom/tencent/kuikly/core/pager/e;", "addPagerLayoutEventObserver", "removePagerLayoutEventObserver", "pagerEvent", "eventData", "onReceivePagerEvent", "", "width", "height", "onPageRootViewSizeChanged", "onReceivePagerEventV2", "nativeRef", "Lcom/tencent/kuikly/core/base/AbstractBaseView;", "view", "putNativeViewRef", "removeNativeViewRef", "getViewWithNativeRef", "Lcom/tencent/kuikly/core/manager/Task;", "task", "addNextTickTask", "addTaskWhenPagerUpdateLayoutFinish", "addTaskWhenPagerDidCalculateLayout", "key", "setMemoryCache", "getValueForKey", "isWillDestroy", "didInit", MiniGamePAHippyBaseFragment.KEY_THEME, "debugUIInspector", "scaleFontSizeEnable", "Lcom/tencent/kuikly/core/pager/PageCreateTrace;", "pageTrace", "setPageTrace", "moduleName", "Lcom/tencent/kuikly/core/pager/a;", "moduleCreator", "registerModule", "viewClassName", "Lcom/tencent/kuikly/core/pager/f;", "viewCreator", "registerViewCreator", "Landroidx/compose/runtime/Composable;", "content", "Lkotlin/jvm/functions/Function2;", "getContent$ntcompose_release", "()Lkotlin/jvm/functions/Function2;", "setContent$ntcompose_release", "(Lkotlin/jvm/functions/Function2;)V", "didRenderContent", "Z", "getDidRenderContent$ntcompose_release", "()Z", "setDidRenderContent$ntcompose_release", "(Z)V", "Lcom/tencent/ntcompose/activity/e;", "pager", "Lcom/tencent/ntcompose/activity/e;", "Lcom/tencent/ntcompose/foundation/event/c;", "_onBackPressedDispatcher", "Lcom/tencent/ntcompose/foundation/event/c;", "Lvo3/a;", "lifecycleRegistry$delegate", "Lkotlin/Lazy;", "getLifecycleRegistry", "()Lvo3/a;", "lifecycleRegistry", "isLifecycleRegistryInitialized", "Lcom/tencent/ntcompose/lifecycle/common/Lifecycle$State;", "activityState", "Lcom/tencent/ntcompose/lifecycle/common/Lifecycle$State;", "Lcom/tencent/ntcompose/lifecycle/viewmodel/j;", "viewModelStore$delegate", "getViewModelStore", "()Lcom/tencent/ntcompose/lifecycle/viewmodel/j;", "viewModelStore", "Lcom/tencent/ntcompose/ui/platform/c;", "intent$delegate", "getIntent", "()Lcom/tencent/ntcompose/ui/platform/c;", "intent", "Lcom/tencent/ntcompose/lifecycle/viewmodel/i$b;", "defaultFactory$delegate", "getDefaultFactory", "()Lcom/tencent/ntcompose/lifecycle/viewmodel/i$b;", "defaultFactory", "isDebugUIInspector$delegate", "isDebugUIInspector", "Lcom/tencent/ntcompose/core/ComposeRenderCore;", "renderCore$delegate", "getRenderCore", "()Lcom/tencent/ntcompose/core/ComposeRenderCore;", "renderCore", "Lcom/tencent/kuikly/core/pager/g;", "getPageData", "()Lcom/tencent/kuikly/core/pager/g;", "setPageData", "(Lcom/tencent/kuikly/core/pager/g;)V", "getPageName", "()Ljava/lang/String;", "setPageName", "(Ljava/lang/String;)V", "pageName", "getDidCreateBody", "didCreateBody", "Lcom/tencent/kuikly/core/coroutines/g;", "getLifecycleScope", "()Lcom/tencent/kuikly/core/coroutines/g;", "lifecycleScope", "Lcom/tencent/kuikly/core/base/AnimationManager;", "getAnimationManager", "()Lcom/tencent/kuikly/core/base/AnimationManager;", "setAnimationManager", "(Lcom/tencent/kuikly/core/base/AnimationManager;)V", "animationManager", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getDynamicExtProps", "()Ljava/util/HashMap;", "dynamicExtProps", "getOnBackPressedDispatcher", "()Lcom/tencent/ntcompose/foundation/event/c;", "onBackPressedDispatcher", "Lcom/tencent/ntcompose/lifecycle/common/Lifecycle;", "getLifecycle", "()Lcom/tencent/ntcompose/lifecycle/common/Lifecycle;", "lifecycle", "<init>", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class ComponentActivity implements com.tencent.kuikly.core.pager.b, d, com.tencent.ntcompose.lifecycle.common.c, k, com.tencent.ntcompose.foundation.event.d {
    public static final int $stable = 8;
    private com.tencent.ntcompose.foundation.event.c _onBackPressedDispatcher;
    private Lifecycle.State activityState;
    private Function2<? super Composer, ? super Integer, Unit> content;

    /* renamed from: defaultFactory$delegate, reason: from kotlin metadata */
    private final Lazy defaultFactory;
    private boolean didRenderContent;

    /* renamed from: intent$delegate, reason: from kotlin metadata */
    private final Lazy intent;

    /* renamed from: isDebugUIInspector$delegate, reason: from kotlin metadata */
    private final Lazy isDebugUIInspector;
    private boolean isLifecycleRegistryInitialized;

    /* renamed from: lifecycleRegistry$delegate, reason: from kotlin metadata */
    private final Lazy lifecycleRegistry;
    private final e pager = new e(this);

    /* renamed from: renderCore$delegate, reason: from kotlin metadata */
    private final Lazy renderCore;

    /* renamed from: viewModelStore$delegate, reason: from kotlin metadata */
    private final Lazy viewModelStore;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n"}, d2 = {"Lcom/tencent/ntcompose/lifecycle/common/c;", "<anonymous parameter 0>", "Lcom/tencent/ntcompose/lifecycle/common/Lifecycle$Event;", "e", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements com.tencent.ntcompose.lifecycle.common.a {
        a() {
        }

        @Override // com.tencent.ntcompose.lifecycle.common.a
        public final void onStateChanged(com.tencent.ntcompose.lifecycle.common.c cVar, Lifecycle.Event e16) {
            Intrinsics.checkNotNullParameter(cVar, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(e16, "e");
            if (e16 == Lifecycle.Event.ON_DESTROY) {
                ComponentActivity.this.getViewModelStore().a();
            }
        }
    }

    public ComponentActivity() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<vo3.a>() { // from class: com.tencent.ntcompose.activity.ComponentActivity$lifecycleRegistry$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final vo3.a invoke() {
                Lifecycle.State state;
                ComponentActivity.this.isLifecycleRegistryInitialized = true;
                vo3.a aVar = new vo3.a(ComponentActivity.this);
                state = ComponentActivity.this.activityState;
                aVar.j(state);
                return aVar;
            }
        });
        this.lifecycleRegistry = lazy;
        this.activityState = Lifecycle.State.INITIALIZED;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<j>() { // from class: com.tencent.ntcompose.activity.ComponentActivity$viewModelStore$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final j invoke() {
                ComponentActivity.this.addViewModelClearObserver();
                return new j();
            }
        });
        this.viewModelStore = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<com.tencent.ntcompose.ui.platform.c>() { // from class: com.tencent.ntcompose.activity.ComponentActivity$intent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.ntcompose.ui.platform.c invoke() {
                return new com.tencent.ntcompose.ui.platform.c(new com.tencent.ntcompose.ui.platform.b(), ComponentActivity.this.getPageName(), ComponentActivity.this.getPageData().n());
            }
        });
        this.intent = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<xo3.a>() { // from class: com.tencent.ntcompose.activity.ComponentActivity$defaultFactory$2
            @Override // kotlin.jvm.functions.Function0
            public final xo3.a invoke() {
                return xo3.a.f448236a;
            }
        });
        this.defaultFactory = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.ntcompose.activity.ComponentActivity$isDebugUIInspector$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(ComponentActivity.this.debugUIInspector());
            }
        });
        this.isDebugUIInspector = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<ComposeRenderCore>() { // from class: com.tencent.ntcompose.activity.ComponentActivity$renderCore$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ComposeRenderCore invoke() {
                return new ComposeRenderCore();
            }
        });
        this.renderCore = lazy6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addViewModelClearObserver() {
        getLifecycle().a(new a());
    }

    private final void dispatch(Lifecycle.Event event) {
        if (this.isLifecycleRegistryInitialized) {
            Lifecycle lifecycle = getLifecycle();
            if (lifecycle instanceof vo3.a) {
                ((vo3.a) lifecycle).e(event);
            }
        }
    }

    private final void dispatchActivityPostCreated(com.tencent.ntcompose.activity.a savedInstanceState) {
        this.activityState = Lifecycle.State.CREATED;
        dispatch(Lifecycle.Event.ON_CREATE);
    }

    private final void dispatchActivityPostResumed() {
        this.activityState = Lifecycle.State.RESUMED;
        dispatch(Lifecycle.Event.ON_RESUME);
    }

    private final void dispatchActivityPreDestroyed() {
        this.activityState = Lifecycle.State.DESTROYED;
        dispatch(Lifecycle.Event.ON_DESTROY);
    }

    private final void dispatchActivityPrePause() {
        this.activityState = Lifecycle.State.CREATED;
        dispatch(Lifecycle.Event.ON_PAUSE);
    }

    private final void ensureOnBackDispatcher() {
        this._onBackPressedDispatcher = new com.tencent.ntcompose.foundation.event.c(this);
    }

    private final i.b getDefaultFactory() {
        return (i.b) this.defaultFactory.getValue();
    }

    private final ComposeRenderCore getRenderCore() {
        return (ComposeRenderCore) this.renderCore.getValue();
    }

    @Override // com.tencent.kuikly.core.pager.b
    public <T extends Module> T acquireModule(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return (T) this.pager.acquireModule(name);
    }

    @Override // com.tencent.kuikly.core.pager.b
    public void addNextTickTask(Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        this.pager.addNextTickTask(task);
    }

    @Override // com.tencent.kuikly.core.pager.b
    public void addPagerEventObserver(com.tencent.kuikly.core.pager.c observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.pager.addPagerEventObserver(observer);
    }

    @Override // com.tencent.kuikly.core.pager.b
    public void addPagerLayoutEventObserver(com.tencent.kuikly.core.pager.e observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.pager.addPagerLayoutEventObserver(observer);
    }

    @Override // com.tencent.kuikly.core.pager.b
    public void addTaskWhenPagerDidCalculateLayout(Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        this.pager.addTaskWhenPagerDidCalculateLayout(task);
    }

    @Override // com.tencent.kuikly.core.pager.b
    public void addTaskWhenPagerUpdateLayoutFinish(Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        this.pager.addTaskWhenPagerUpdateLayoutFinish(task);
    }

    public void bindValueChange(Function0<? extends Object> valueBlock, Object byOwner, Function1<Object, Unit> valueChange) {
        Intrinsics.checkNotNullParameter(valueBlock, "valueBlock");
        Intrinsics.checkNotNullParameter(byOwner, "byOwner");
        Intrinsics.checkNotNullParameter(valueChange, "valueChange");
        this.pager.bindValueChange(valueBlock, valueChange);
    }

    public Function1<ViewContainer<?, ?>, Unit> composeBody() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.ntcompose.activity.ComponentActivity$composeBody$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer) {
                invoke2(viewContainer);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ViewContainer<?, ?> viewContainer) {
                Intrinsics.checkNotNullParameter(viewContainer, "$this$null");
                ComponentActivity.this.renderContent$ntcompose_release();
            }
        };
    }

    public void composeCreate() {
        d.a.a(this);
        onCreate(null);
        dispatchActivityPostCreated(null);
    }

    public Map<String, Module> composeCreateExternalModules() {
        return createExternalModules();
    }

    public void composeCreatePager(String pagerId, com.tencent.kuikly.core.nvi.serialization.json.e pageData) {
        Intrinsics.checkNotNullParameter(pagerId, "pagerId");
        Intrinsics.checkNotNullParameter(pageData, "pageData");
        onCreatePager(pagerId, pageData);
    }

    public boolean composeDebugUIInspector() {
        return debugUIInspector();
    }

    public void composeDestroyPager() {
        dispatchActivityPreDestroyed();
        onDestroy();
        getRenderCore().a();
    }

    public void composeDidCallEndFromNative(int i3) {
        d.a.b(this, i3);
    }

    public void composeDidCreatedPager(String pagerId, com.tencent.kuikly.core.nvi.serialization.json.e pageData) {
        Intrinsics.checkNotNullParameter(pagerId, "pagerId");
        Intrinsics.checkNotNullParameter(pageData, "pageData");
    }

    public void composeDidInit() {
        d.a.c(this);
        didInit();
    }

    public void composeFirstFramePaint() {
        onFirstFramePaint();
    }

    public boolean composeIsNightMode() {
        return isNightMode();
    }

    public void composeLayoutView() {
        onLayoutView();
    }

    public void composePageDidAppear() {
        onResume();
        pageDidAppear();
        dispatchActivityPostResumed();
    }

    public void composePageDidDisappear() {
        dispatchActivityPrePause();
        onPause();
        pageDidDisappear();
    }

    public void composePageWillDestroy() {
        pageWillDestroy();
    }

    public boolean composeScaleFontSizeEnable() {
        return scaleFontSizeEnable();
    }

    public void composeThemeDidChanged(com.tencent.kuikly.core.nvi.serialization.json.e data) {
        Intrinsics.checkNotNullParameter(data, "data");
        themeDidChanged(data);
    }

    public void composeViewEvent(int viewRef, String event, com.tencent.kuikly.core.nvi.serialization.json.e res) {
        Intrinsics.checkNotNullParameter(event, "event");
        onViewEvent(viewRef, event, res);
    }

    public Map<String, Module> createExternalModules() {
        return null;
    }

    @Override // com.tencent.kuikly.core.pager.b
    public FlexNode createFlexNodeInstance() {
        return b.a.a(this);
    }

    @Override // com.tencent.kuikly.core.pager.b
    public boolean debugUIInspector() {
        return false;
    }

    public void didInit() {
        b.a.c(this);
    }

    @Override // com.tencent.kuikly.core.pager.b
    public AnimationManager getAnimationManager() {
        return this.pager.getAnimationManager();
    }

    public final Function2<Composer, Integer, Unit> getContent$ntcompose_release() {
        return this.content;
    }

    @Override // com.tencent.kuikly.core.pager.b
    /* renamed from: getDidCreateBody */
    public boolean getInnerDidCreateBody() {
        return this.pager.getInnerDidCreateBody();
    }

    /* renamed from: getDidRenderContent$ntcompose_release, reason: from getter */
    public final boolean getDidRenderContent() {
        return this.didRenderContent;
    }

    @Override // com.tencent.kuikly.core.pager.b
    public HashMap<String, Object> getDynamicExtProps() {
        return this.pager.getDynamicExtProps();
    }

    public final com.tencent.ntcompose.ui.platform.c getIntent() {
        return (com.tencent.ntcompose.ui.platform.c) this.intent.getValue();
    }

    @Override // com.tencent.ntcompose.lifecycle.common.c
    public Lifecycle getLifecycle() {
        return getLifecycleRegistry();
    }

    public final vo3.a getLifecycleRegistry() {
        return (vo3.a) this.lifecycleRegistry.getValue();
    }

    public g getLifecycleScope() {
        return this.pager.getLifecycleScope();
    }

    @Override // com.tencent.kuikly.core.pager.b
    public <T extends Module> T getModule(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return (T) this.pager.getModule(name);
    }

    public com.tencent.ntcompose.foundation.event.c getOnBackPressedDispatcher() {
        ensureOnBackDispatcher();
        com.tencent.ntcompose.foundation.event.c cVar = this._onBackPressedDispatcher;
        Intrinsics.checkNotNull(cVar);
        return cVar;
    }

    @Override // com.tencent.kuikly.core.pager.b
    public com.tencent.kuikly.core.pager.g getPageData() {
        return this.pager.getPageData();
    }

    @Override // com.tencent.kuikly.core.pager.b
    public String getPageName() {
        return this.pager.getPageName();
    }

    public final Pager getPager() {
        return this.pager;
    }

    @Override // com.tencent.kuikly.core.pager.b
    public Object getValueForKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.pager.getValueForKey(key);
    }

    @Override // com.tencent.ntcompose.lifecycle.viewmodel.k
    public j getViewModelStore() {
        return (j) this.viewModelStore.getValue();
    }

    @Override // com.tencent.kuikly.core.pager.b
    public AbstractBaseView<?, ?> getViewWithNativeRef(int nativeRef) {
        return this.pager.getViewWithNativeRef(nativeRef);
    }

    @Override // com.tencent.kuikly.core.pager.b
    public com.tencent.kuikly.core.pager.b innerPager() {
        return this.pager;
    }

    @Override // com.tencent.kuikly.core.pager.b
    public boolean isDebugUIInspector() {
        return ((Boolean) this.isDebugUIInspector.getValue()).booleanValue();
    }

    @Override // com.tencent.kuikly.core.pager.b
    public boolean isNightMode() {
        return false;
    }

    public boolean isV2() {
        return b.a.g(this);
    }

    @Override // com.tencent.kuikly.core.pager.b
    /* renamed from: isWillDestroy */
    public boolean getWillDestroy() {
        return this.pager.getWillDestroy();
    }

    @Override // com.tencent.kuikly.core.pager.b
    public void onCreatePager(String pagerId, com.tencent.kuikly.core.nvi.serialization.json.e pageData) {
        Intrinsics.checkNotNullParameter(pagerId, "pagerId");
        Intrinsics.checkNotNullParameter(pageData, "pageData");
    }

    public void onFirstFramePaint() {
        b.a.h(this);
    }

    public void onPageRootViewSizeChanged(double width, double height) {
        b.a.i(this, width, height);
    }

    @Override // com.tencent.kuikly.core.pager.b
    public void onReceivePagerEvent(String pagerEvent, com.tencent.kuikly.core.nvi.serialization.json.e eventData) {
        Intrinsics.checkNotNullParameter(pagerEvent, "pagerEvent");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
    }

    @Override // com.tencent.kuikly.core.pager.b
    public void onReceivePagerEventV2(String pagerEvent, Object eventData) {
        Intrinsics.checkNotNullParameter(pagerEvent, "pagerEvent");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        b.a.j(this, pagerEvent, eventData);
    }

    @Override // com.tencent.kuikly.core.pager.b
    public void onUnhandledException(String str) {
        b.a.k(this, str);
    }

    @Override // com.tencent.kuikly.core.pager.b
    public void onViewEvent(int viewRef, String event, com.tencent.kuikly.core.nvi.serialization.json.e res) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    public void pageDidAppear() {
        b.a.l(this);
    }

    public void pageDidDisappear() {
        b.a.m(this);
    }

    public void pageWillDestroy() {
        b.a.n(this);
    }

    @Override // com.tencent.kuikly.core.pager.b
    public float pagerDensity() {
        return b.a.o(this);
    }

    @Override // com.tencent.kuikly.core.pager.b
    public void putNativeViewRef(int nativeRef, AbstractBaseView<?, ?> view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.pager.putNativeViewRef(nativeRef, view);
    }

    public final void registerModule(String moduleName, com.tencent.kuikly.core.pager.a moduleCreator) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(moduleCreator, "moduleCreator");
        getPager().registerModule(moduleName, moduleCreator);
    }

    public final void registerViewCreator(String viewClassName, f viewCreator) {
        Intrinsics.checkNotNullParameter(viewClassName, "viewClassName");
        Intrinsics.checkNotNullParameter(viewCreator, "viewCreator");
        getPager().registerViewCreator(viewClassName, viewCreator);
    }

    @Override // com.tencent.kuikly.core.pager.b
    public void removeNativeViewRef(int nativeRef) {
        this.pager.removeNativeViewRef(nativeRef);
    }

    @Override // com.tencent.kuikly.core.pager.b
    public void removePagerEventObserver(com.tencent.kuikly.core.pager.c observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.pager.removePagerEventObserver(observer);
    }

    @Override // com.tencent.kuikly.core.pager.b
    public void removePagerLayoutEventObserver(com.tencent.kuikly.core.pager.e observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.pager.removePagerLayoutEventObserver(observer);
    }

    public final void renderContent$ntcompose_release() {
        Function2<? super Composer, ? super Integer, Unit> function2 = this.content;
        if (function2 != null) {
            this.didRenderContent = true;
            getRenderCore().b(this.pager, function2);
        }
        this.content = null;
    }

    @Override // com.tencent.kuikly.core.pager.b
    public boolean scaleFontSizeEnable() {
        return false;
    }

    @Override // com.tencent.kuikly.core.pager.b
    public void setAnimationManager(AnimationManager animationManager) {
        this.pager.setAnimationManager(animationManager);
    }

    public final void setContent$ntcompose_release(Function2<? super Composer, ? super Integer, Unit> function2) {
        this.content = function2;
    }

    public final void setDidRenderContent$ntcompose_release(boolean z16) {
        this.didRenderContent = z16;
    }

    @Override // com.tencent.kuikly.core.pager.b
    public void setMemoryCache(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.pager.setMemoryCache(key, value);
    }

    public void setPageData(com.tencent.kuikly.core.pager.g value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.pager.setPageData(value);
    }

    @Override // com.tencent.kuikly.core.pager.b
    public void setPageName(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.pager.setPageName(value);
    }

    @Override // com.tencent.kuikly.core.pager.b
    public void setPageTrace(PageCreateTrace pageTrace) {
        Intrinsics.checkNotNullParameter(pageTrace, "pageTrace");
        this.pager.setPageTrace(pageTrace);
    }

    @Override // com.tencent.kuikly.core.pager.b
    public void syncFlushUI() {
        this.pager.syncFlushUI();
    }

    public void themeDidChanged(com.tencent.kuikly.core.nvi.serialization.json.e data) {
        Intrinsics.checkNotNullParameter(data, "data");
        b.a.q(this, data);
    }

    public void unbindAllValueChange(Object byOwner) {
        Intrinsics.checkNotNullParameter(byOwner, "byOwner");
        this.pager.unbindAllValueChange();
    }

    @Override // com.tencent.kuikly.core.pager.b
    public com.tencent.kuikly.core.pager.b hostPager() {
        return this;
    }

    public void onDestroy() {
    }

    @Override // com.tencent.kuikly.core.pager.b
    public void onDestroyPager() {
    }

    @Override // com.tencent.kuikly.core.pager.b
    public void onLayoutView() {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onCreate(com.tencent.ntcompose.activity.a savedInstanceState) {
    }
}
