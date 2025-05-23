package com.tencent.kuikly.core.pager;

import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.base.AnimationManager;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.module.Module;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\u0000H\u0016J\b\u0010\u000b\u001a\u00020\u0000H\u0016J\"\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H&J#\u0010\u0014\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0012*\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0016\u001a\u00028\u0000\"\b\b\u0000\u0010\u0012*\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0016\u0010\u0015J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H&J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H&J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001cH&J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001cH&J\u0018\u0010!\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0004H&J\u0018\u0010\"\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0001H\u0016J \u0010&\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\f2\u000e\u0010%\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030$H&J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\fH&J\u001a\u0010(\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010$2\u0006\u0010#\u001a\u00020\fH\u0016J\u001a\u0010,\u001a\u00020\u00062\u0010\u0010+\u001a\f\u0012\u0004\u0012\u00020\u00060)j\u0002`*H&J\u0016\u0010-\u001a\u00020\u00062\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00060)H&J\u0016\u0010.\u001a\u00020\u00062\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00060)H&J\u0018\u00101\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u0001H\u0016J\u0012\u00102\u001a\u0004\u0018\u00010\u00012\u0006\u0010/\u001a\u00020\u0002H\u0016J\b\u00104\u001a\u000203H\u0016J\b\u00105\u001a\u000203H\u0016J\b\u00106\u001a\u000203H\u0016J\b\u00107\u001a\u000203H\u0016J\b\u00109\u001a\u000208H\u0016J\u0010\u0010;\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u0002H\u0016J\u0010\u0010>\u001a\u00020\u00062\u0006\u0010=\u001a\u00020<H\u0016J\n\u0010@\u001a\u0004\u0018\u00010?H\u0016R\u001c\u0010\u0005\u001a\u00020A8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001c\u0010J\u001a\u00020\u00028&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001e\u0010P\u001a\u0004\u0018\u00010K8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u0014\u0010Q\u001a\u0002038&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bQ\u0010RR\u0014\u0010T\u001a\u0002038&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bS\u0010RR0\u0010Y\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010Uj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001`V8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bW\u0010X\u00a8\u0006Z"}, d2 = {"Lcom/tencent/kuikly/core/pager/b;", "", "", "pagerId", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", ISchemeApi.KEY_PAGE_DATA, "", "onCreatePager", "onDestroyPager", "onLayoutView", "innerPager", "hostPager", "", "viewRef", "event", "res", "onViewEvent", "Lcom/tencent/kuikly/core/module/Module;", "T", "name", "getModule", "(Ljava/lang/String;)Lcom/tencent/kuikly/core/module/Module;", "acquireModule", "syncFlushUI", "Lcom/tencent/kuikly/core/pager/c;", "observer", "addPagerEventObserver", "removePagerEventObserver", "Lcom/tencent/kuikly/core/pager/e;", "addPagerLayoutEventObserver", "removePagerLayoutEventObserver", "pagerEvent", "eventData", "onReceivePagerEvent", "onReceivePagerEventV2", "nativeRef", "Lcom/tencent/kuikly/core/base/AbstractBaseView;", "view", "putNativeViewRef", "removeNativeViewRef", "getViewWithNativeRef", "Lkotlin/Function0;", "Lcom/tencent/kuikly/core/manager/Task;", "task", "addNextTickTask", "addTaskWhenPagerUpdateLayoutFinish", "addTaskWhenPagerDidCalculateLayout", "key", "value", "setMemoryCache", "getValueForKey", "", "isWillDestroy", MiniGamePAHippyBaseFragment.KEY_THEME, "debugUIInspector", "scaleFontSizeEnable", "", "pagerDensity", "stack", "onUnhandledException", "Lcom/tencent/kuikly/core/pager/PageCreateTrace;", "pageTrace", "setPageTrace", "Lcom/tencent/kuikly/core/layout/FlexNode;", "createFlexNodeInstance", "Lcom/tencent/kuikly/core/pager/g;", "getPageData", "()Lcom/tencent/kuikly/core/pager/g;", "setPageData", "(Lcom/tencent/kuikly/core/pager/g;)V", "getPageName", "()Ljava/lang/String;", "setPageName", "(Ljava/lang/String;)V", "pageName", "Lcom/tencent/kuikly/core/base/AnimationManager;", "getAnimationManager", "()Lcom/tencent/kuikly/core/base/AnimationManager;", "setAnimationManager", "(Lcom/tencent/kuikly/core/base/AnimationManager;)V", "animationManager", "isDebugUIInspector", "()Z", "getDidCreateBody", "didCreateBody", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getDynamicExtProps", "()Ljava/util/HashMap;", "dynamicExtProps", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public interface b {
    <T extends Module> T acquireModule(String name);

    void addNextTickTask(Function0<Unit> task);

    void addPagerEventObserver(c observer);

    void addPagerLayoutEventObserver(e observer);

    void addTaskWhenPagerDidCalculateLayout(Function0<Unit> task);

    void addTaskWhenPagerUpdateLayoutFinish(Function0<Unit> task);

    FlexNode createFlexNodeInstance();

    boolean debugUIInspector();

    AnimationManager getAnimationManager();

    /* renamed from: getDidCreateBody */
    boolean getInnerDidCreateBody();

    HashMap<String, Object> getDynamicExtProps();

    <T extends Module> T getModule(String name);

    g getPageData();

    String getPageName();

    Object getValueForKey(String key);

    AbstractBaseView<?, ?> getViewWithNativeRef(int nativeRef);

    b hostPager();

    b innerPager();

    boolean isDebugUIInspector();

    boolean isNightMode();

    /* renamed from: isWillDestroy */
    boolean getWillDestroy();

    void onCreatePager(String pagerId, com.tencent.kuikly.core.nvi.serialization.json.e pageData);

    void onDestroyPager();

    void onLayoutView();

    void onReceivePagerEvent(String pagerEvent, com.tencent.kuikly.core.nvi.serialization.json.e eventData);

    void onReceivePagerEventV2(String pagerEvent, Object eventData);

    void onUnhandledException(String stack);

    void onViewEvent(int viewRef, String event, com.tencent.kuikly.core.nvi.serialization.json.e res);

    float pagerDensity();

    void putNativeViewRef(int nativeRef, AbstractBaseView<?, ?> view);

    void removeNativeViewRef(int nativeRef);

    void removePagerEventObserver(c observer);

    void removePagerLayoutEventObserver(e observer);

    boolean scaleFontSizeEnable();

    void setAnimationManager(AnimationManager animationManager);

    void setMemoryCache(String key, Object value);

    void setPageName(String str);

    void setPageTrace(PageCreateTrace pageTrace);

    void syncFlushUI();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class a {
        public static FlexNode a(b bVar) {
            return null;
        }

        public static boolean b(b bVar) {
            return false;
        }

        public static boolean f(b bVar) {
            return false;
        }

        public static boolean g(b bVar) {
            return false;
        }

        public static void j(b bVar, String pagerEvent, Object eventData) {
            Intrinsics.checkNotNullParameter(pagerEvent, "pagerEvent");
            Intrinsics.checkNotNullParameter(eventData, "eventData");
        }

        public static void k(b bVar, String stack) {
            Intrinsics.checkNotNullParameter(stack, "stack");
        }

        public static float o(b bVar) {
            Float density = bVar.getPageData().getDensity();
            if (density != null) {
                return density.floatValue();
            }
            return 0.0f;
        }

        public static boolean p(b bVar) {
            return false;
        }

        public static void q(b bVar, com.tencent.kuikly.core.nvi.serialization.json.e data) {
            Intrinsics.checkNotNullParameter(data, "data");
        }

        public static void c(b bVar) {
        }

        public static b d(b bVar) {
            return bVar;
        }

        public static b e(b bVar) {
            return bVar;
        }

        public static void h(b bVar) {
        }

        public static void l(b bVar) {
        }

        public static void m(b bVar) {
        }

        public static void n(b bVar) {
        }

        public static void i(b bVar, double d16, double d17) {
        }
    }
}
