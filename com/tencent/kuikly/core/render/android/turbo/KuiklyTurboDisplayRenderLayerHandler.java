package com.tencent.kuikly.core.render.android.turbo;

import android.content.Context;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.util.SizeF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.kuikly.core.render.android.KuiklyContextParams;
import com.tencent.kuikly.core.render.android.d;
import com.tencent.kuikly.core.render.android.expand.module.KRTurboDisplayModule;
import com.tencent.kuikly.core.render.android.layer.KuiklyRenderLayerHandler;
import com.tencent.kuikly.core.render.android.scheduler.KuiklyRenderCoreUIScheduler;
import com.tencent.kuikly.core.render.android.scheduler.a;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import d01.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0001DB\u0007\u00a2\u0006\u0004\bz\u0010{J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0016\u0010\u000b\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u001e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J \u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0017H\u0016J \u0010#\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00112\u0006\u0010\"\u001a\u00020!H\u0016J\u0018\u0010&\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010%\u001a\u00020$H\u0016J\u0018\u0010)\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010(\u001a\u00020'H\u0016J\u0018\u0010,\u001a\u00020*2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010+\u001a\u00020*H\u0016JO\u00105\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u00112\b\u0010.\u001a\u0004\u0018\u00010\u00112+\u00104\u001a'\u0012\u0015\u0012\u0013\u0018\u00010!\u00a2\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\u0004\u0018\u00010/j\u0004\u0018\u0001`3H\u0016JQ\u00107\u001a\u0004\u0018\u00010!2\u0006\u00106\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u00112\b\u0010.\u001a\u0004\u0018\u00010!2+\u00104\u001a'\u0012\u0015\u0012\u0013\u0018\u00010!\u00a2\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\u0004\u0018\u00010/j\u0004\u0018\u0001`3H\u0016J\u0088\u0001\u0010;\u001a\u0004\u0018\u00010!2\u0006\u00106\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u00112\b\u0010.\u001a\u0004\u0018\u00010\u00112\b\u00108\u001a\u0004\u0018\u00010\u00112+\u00109\u001a'\u0012\u0015\u0012\u0013\u0018\u00010!\u00a2\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\u0004\u0018\u00010/j\u0004\u0018\u0001`32+\u0010:\u001a'\u0012\u0015\u0012\u0013\u0018\u00010!\u00a2\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\u0004\u0018\u00010/j\u0004\u0018\u0001`3H\u0016J\u0018\u0010<\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\u0010\u0010=\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J \u0010>\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00112\u0006\u0010\"\u001a\u00020!H\u0016J\"\u0010@\u001a\u0004\u0018\u00010!2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010?\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u0011H\u0016J\u0012\u0010A\u001a\u0004\u0018\u00010$2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J#\u0010D\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010C*\u00020B2\u0006\u00101\u001a\u00020\u0011H\u0016\u00a2\u0006\u0004\bD\u0010EJ\u0012\u0010G\u001a\u0004\u0018\u00010F2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0018\u0010J\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u00172\u0006\u0010I\u001a\u00020\u0017H\u0016J\b\u0010K\u001a\u00020\u0004H\u0016J\b\u0010L\u001a\u00020\u0004H\u0016J\b\u0010M\u001a\u00020\u0004H\u0016R$\u0010T\u001a\u0004\u0018\u00010N8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0016\u0010W\u001a\u00020U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010VR\u0018\u0010Z\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010YR \u0010]\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00020[8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010\\R \u0010_\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020^0[8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010\\R\u0014\u0010a\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u0010`R\u0016\u0010d\u001a\u00020b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010cR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010eR\u0016\u0010g\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010fR\u0018\u0010h\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010`R\u0016\u0010i\u001a\u00020b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010cR\u0016\u0010j\u001a\u00020b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010cR$\u0010m\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t\u0018\u00010k8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010lR\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010fR\u0016\u0010n\u001a\u00020b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010cR\u0016\u0010o\u001a\u00020b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010cR\u0016\u0010r\u001a\u00020p8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010qR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010sR\u0018\u0010v\u001a\u0004\u0018\u00010t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010uR\u0018\u0010y\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010x\u00a8\u0006|"}, d2 = {"Lcom/tencent/kuikly/core/render/android/turbo/KuiklyTurboDisplayRenderLayerHandler;", "Lcom/tencent/kuikly/core/render/android/layer/a;", "Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayNode;", "node", "", "J", "H", "K", "L", "Lkotlin/Function0;", "task", "G", "N", "Lcom/tencent/kuikly/core/render/android/d;", "renderView", "Lcom/tencent/kuikly/core/render/android/g;", "contextParam", "", "turboDisplayKey", "I", "Lcom/tencent/kuikly/core/render/android/layer/b;", "initCallback", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "tag", "viewName", ReportConstant.COSTREPORT_PREFIX, "u", "parentTag", "childTag", "index", "l", "propKey", "", "propValue", "p", "Li01/b;", "shadow", "i", "Landroid/graphics/RectF;", AIInput.KEY_FRAME, h.F, "Landroid/util/SizeF;", "constraintSize", "k", "method", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "r", "moduleName", "f", "callId", "successCallback", "errorCallback", "j", "c", "d", "t", "methodName", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "Li01/a;", "T", "a", "(Ljava/lang/String;)Li01/a;", "Landroid/view/View;", "b", "currentTag", "newTag", "g", "e", DomainData.DOMAIN_NAME, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/kuikly/core/render/android/scheduler/KuiklyRenderCoreUIScheduler;", "Lcom/tencent/kuikly/core/render/android/scheduler/KuiklyRenderCoreUIScheduler;", "getUiScheduler", "()Lcom/tencent/kuikly/core/render/android/scheduler/KuiklyRenderCoreUIScheduler;", "M", "(Lcom/tencent/kuikly/core/render/android/scheduler/KuiklyRenderCoreUIScheduler;)V", "uiScheduler", "Lcom/tencent/kuikly/core/render/android/layer/KuiklyRenderLayerHandler;", "Lcom/tencent/kuikly/core/render/android/layer/KuiklyRenderLayerHandler;", "renderLayerHandler", "Lcom/tencent/kuikly/core/render/android/turbo/a;", "Lcom/tencent/kuikly/core/render/android/turbo/a;", "turboDisplayCacheData", "", "Ljava/util/Map;", "realNodeMap", "Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayShadow;", "realShadowMap", "Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayNode;", "realRootNode", "", "Z", "lazyRendering", "Lcom/tencent/kuikly/core/render/android/g;", "Ljava/lang/String;", "turboDisplayCacheKey", "nextTurboDisplayRootNode", "needUpdateNextTurboDisplayRootNode", "needSyncMainQueueOnNextRunLoop", "", "Ljava/util/List;", "nextLoopTaskOnMainQueue", "didCacheTurbo", "closeAutoUpdateTurboDisplay", "Landroid/os/Handler;", "Landroid/os/Handler;", "uiHandler", "Lcom/tencent/kuikly/core/render/android/d;", "Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayCacheManager;", "Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayCacheManager;", "turboDisplayCacheManager", "Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayDiffPatch;", "Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayDiffPatch;", "diffPatch", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KuiklyTurboDisplayRenderLayerHandler implements com.tencent.kuikly.core.render.android.layer.a {

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private KuiklyRenderCoreUIScheduler uiScheduler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private a turboDisplayCacheData;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean lazyRendering;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private KuiklyContextParams contextParam;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private KRTurboDisplayNode nextTurboDisplayRootNode;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean needUpdateNextTurboDisplayRootNode;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean needSyncMainQueueOnNextRunLoop;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<Function0<Unit>> nextLoopTaskOnMainQueue;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private boolean didCacheTurbo;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private boolean closeAutoUpdateTurboDisplay;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private d renderView;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private KRTurboDisplayCacheManager turboDisplayCacheManager;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private KRTurboDisplayDiffPatch diffPatch;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private KuiklyRenderLayerHandler renderLayerHandler = new KuiklyRenderLayerHandler();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Map<Integer, KRTurboDisplayNode> realNodeMap = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Map<Integer, KRTurboDisplayShadow> realShadowMap = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final KRTurboDisplayNode realRootNode = new KRTurboDisplayNode(-1, "RootView");

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String turboDisplayCacheKey = "";

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private String turboDisplayKey = "";

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private Handler uiHandler = new Handler(Looper.getMainLooper());

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/kuikly/core/render/android/turbo/KuiklyTurboDisplayRenderLayerHandler$a;", "", "", "ROOT_VIEW_NAME", "Ljava/lang/String;", "TAG", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.turbo.KuiklyTurboDisplayRenderLayerHandler$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void G(Function0<Unit> task) {
        if (!this.needSyncMainQueueOnNextRunLoop) {
            this.needSyncMainQueueOnNextRunLoop = true;
            if (this.nextLoopTaskOnMainQueue == null) {
                this.nextLoopTaskOnMainQueue = new ArrayList();
            }
            List<Function0<Unit>> list = this.nextLoopTaskOnMainQueue;
            if (list != null) {
                list.add(task);
            }
            this.uiHandler.post(new Runnable() { // from class: com.tencent.kuikly.core.render.android.turbo.KuiklyTurboDisplayRenderLayerHandler$addTaskOnNextLoopMainQueueWihTask$1
                @Override // java.lang.Runnable
                public final void run() {
                    List list2;
                    KuiklyTurboDisplayRenderLayerHandler.this.needSyncMainQueueOnNextRunLoop = false;
                    list2 = KuiklyTurboDisplayRenderLayerHandler.this.nextLoopTaskOnMainQueue;
                    KuiklyTurboDisplayRenderLayerHandler.this.nextLoopTaskOnMainQueue = null;
                    if (list2 != null) {
                        Iterator it = list2.iterator();
                        while (it.hasNext()) {
                            ((Function0) it.next()).invoke();
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H() {
        KRTurboDisplayNode turboDisplayNode;
        boolean z16;
        String str;
        if (this.nextTurboDisplayRootNode == null) {
            this.nextTurboDisplayRootNode = this.realRootNode.e();
            L();
        }
        a aVar = this.turboDisplayCacheData;
        if (aVar != null && (turboDisplayNode = aVar.getTurboDisplayNode()) != null) {
            if (turboDisplayNode.getViewName().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                KRTurboDisplayDiffPatch kRTurboDisplayDiffPatch = this.diffPatch;
                if (kRTurboDisplayDiffPatch != null) {
                    kRTurboDisplayDiffPatch.c(this.renderLayerHandler, turboDisplayNode, this.realRootNode);
                }
            } else {
                w wVar = w.f392617a;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("diffPatchToRenderLayer, page: ");
                KuiklyContextParams kuiklyContextParams = this.contextParam;
                if (kuiklyContextParams != null) {
                    str = kuiklyContextParams.getPageUrl();
                } else {
                    str = null;
                }
                sb5.append(str);
                sb5.append(", turbo root node view name is empty");
                wVar.c("KuiklyTurboDisplayRenderLayer", sb5.toString());
            }
        }
        this.lazyRendering = false;
        K();
        this.turboDisplayCacheData = null;
    }

    private final void J(KRTurboDisplayNode node) {
        KRTurboDisplayDiffPatch kRTurboDisplayDiffPatch;
        if (node != null && (kRTurboDisplayDiffPatch = this.diffPatch) != null) {
            kRTurboDisplayDiffPatch.c(this.renderLayerHandler, null, node);
        }
    }

    private final void K() {
        ViewGroup view;
        Context context;
        a aVar;
        byte[] turboDisplayNodeData;
        KRTurboDisplayCacheManager kRTurboDisplayCacheManager;
        d dVar = this.renderView;
        if (dVar != null && (view = dVar.getView()) != null && (context = view.getContext()) != null && (aVar = this.turboDisplayCacheData) != null && (turboDisplayNodeData = aVar.getTurboDisplayNodeData()) != null && !KRTurboDisplayCacheManager.INSTANCE.e(context, this.turboDisplayCacheKey) && (kRTurboDisplayCacheManager = this.turboDisplayCacheManager) != null) {
            kRTurboDisplayCacheManager.f(turboDisplayNodeData, this.turboDisplayCacheKey);
        }
    }

    private final void L() {
        if (!this.needUpdateNextTurboDisplayRootNode) {
            this.needUpdateNextTurboDisplayRootNode = true;
            this.uiHandler.postDelayed(new Runnable() { // from class: com.tencent.kuikly.core.render.android.turbo.KuiklyTurboDisplayRenderLayerHandler$setNeedUpdateNextTurboDisplayRootNode$1
                @Override // java.lang.Runnable
                public final void run() {
                    KuiklyTurboDisplayRenderLayerHandler.this.N();
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N() {
        KRTurboDisplayCacheManager kRTurboDisplayCacheManager;
        KRTurboDisplayNode kRTurboDisplayNode;
        long currentTimeMillis;
        String str;
        KRTurboDisplayDiffPatch kRTurboDisplayDiffPatch = this.diffPatch;
        if (kRTurboDisplayDiffPatch == null || (kRTurboDisplayCacheManager = this.turboDisplayCacheManager) == null || !this.needUpdateNextTurboDisplayRootNode) {
            return;
        }
        com.tencent.kuikly.core.render.android.css.ktx.b.l();
        this.needUpdateNextTurboDisplayRootNode = false;
        if (!this.closeAutoUpdateTurboDisplay && (kRTurboDisplayNode = this.nextTurboDisplayRootNode) != null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            boolean g16 = kRTurboDisplayDiffPatch.g(kRTurboDisplayNode, this.realRootNode);
            if (!g16 && (this.lazyRendering || this.didCacheTurbo)) {
                currentTimeMillis = 0;
            } else {
                this.didCacheTurbo = true;
                long currentTimeMillis3 = System.currentTimeMillis();
                kRTurboDisplayCacheManager.e(kRTurboDisplayNode.e(), this.turboDisplayCacheKey);
                currentTimeMillis = System.currentTimeMillis() - currentTimeMillis3;
            }
            long currentTimeMillis4 = System.currentTimeMillis();
            w wVar = w.f392617a;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("updateNextTurboDisplayRootNode: ");
            sb5.append(currentTimeMillis4 - currentTimeMillis2);
            sb5.append(", deepCopyCostTime: ");
            sb5.append(currentTimeMillis);
            sb5.append(", didUpdated: ");
            sb5.append(g16);
            sb5.append(", page: ");
            KuiklyContextParams kuiklyContextParams = this.contextParam;
            if (kuiklyContextParams != null) {
                str = kuiklyContextParams.getPageUrl();
            } else {
                str = null;
            }
            sb5.append(str);
            wVar.c("KuiklyTurboDisplayRenderLayer", sb5.toString());
        }
    }

    public final void I(@NotNull d renderView, @NotNull KuiklyContextParams contextParam, @NotNull String turboDisplayKey) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        Intrinsics.checkNotNullParameter(contextParam, "contextParam");
        Intrinsics.checkNotNullParameter(turboDisplayKey, "turboDisplayKey");
        this.turboDisplayKey = turboDisplayKey;
        this.contextParam = contextParam;
        this.renderView = renderView;
        this.renderLayerHandler.C(renderView, contextParam);
        this.realNodeMap.put(-1, this.realRootNode);
        this.diffPatch = new KRTurboDisplayDiffPatch(renderView.e(), renderView.getKuiklyRenderContext());
        Context context = renderView.getView().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "renderView.view.context");
        this.turboDisplayCacheManager = new KRTurboDisplayCacheManager(context);
        this.turboDisplayCacheKey = KRTurboDisplayCacheManager.INSTANCE.c(turboDisplayKey, contextParam.getPageUrl());
        b.c(renderView.getKuiklyRenderContext(), new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.turbo.KuiklyTurboDisplayRenderLayerHandler$init$1
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
                KRTurboDisplayCacheManager kRTurboDisplayCacheManager;
                KRTurboDisplayNode kRTurboDisplayNode;
                String str;
                KuiklyTurboDisplayRenderLayerHandler.this.closeAutoUpdateTurboDisplay = true;
                kRTurboDisplayCacheManager = KuiklyTurboDisplayRenderLayerHandler.this.turboDisplayCacheManager;
                if (kRTurboDisplayCacheManager != null) {
                    kRTurboDisplayNode = KuiklyTurboDisplayRenderLayerHandler.this.realRootNode;
                    KRTurboDisplayNode e16 = kRTurboDisplayNode.e();
                    str = KuiklyTurboDisplayRenderLayerHandler.this.turboDisplayCacheKey;
                    kRTurboDisplayCacheManager.e(e16, str);
                }
            }
        }, new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.turbo.KuiklyTurboDisplayRenderLayerHandler$init$2
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
                KRTurboDisplayCacheManager kRTurboDisplayCacheManager;
                String str;
                kRTurboDisplayCacheManager = KuiklyTurboDisplayRenderLayerHandler.this.turboDisplayCacheManager;
                if (kRTurboDisplayCacheManager != null) {
                    str = KuiklyTurboDisplayRenderLayerHandler.this.turboDisplayCacheKey;
                    kRTurboDisplayCacheManager.i(str);
                }
                KuiklyTurboDisplayRenderLayerHandler.this.turboDisplayCacheData = null;
            }
        });
    }

    public final void M(@Nullable KuiklyRenderCoreUIScheduler kuiklyRenderCoreUIScheduler) {
        this.uiScheduler = kuiklyRenderCoreUIScheduler;
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    @Nullable
    public <T extends i01.a> T a(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return (T) this.renderLayerHandler.a(name);
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    @Nullable
    public View b(int tag) {
        return this.renderLayerHandler.b(tag);
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    public void c(int tag, @NotNull String viewName) {
        Intrinsics.checkNotNullParameter(viewName, "viewName");
        this.realShadowMap.put(Integer.valueOf(tag), new KRTurboDisplayShadow(tag, viewName));
        this.renderLayerHandler.c(tag, viewName);
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    public void d(int tag) {
        this.realShadowMap.remove(Integer.valueOf(tag));
        this.renderLayerHandler.d(tag);
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    public void e() {
        if (this.nextTurboDisplayRootNode != null) {
            N();
            this.closeAutoUpdateTurboDisplay = true;
            this.nextTurboDisplayRootNode = null;
        }
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    @Nullable
    public Object f(@NotNull String moduleName, @NotNull String method, @Nullable Object params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(method, "method");
        if (Intrinsics.areEqual(moduleName, "KRMemoryCacheModule") && (params instanceof String)) {
            this.realRootNode.a(moduleName, method, (String) params, callback);
        }
        return this.renderLayerHandler.f(moduleName, method, params, callback);
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    public void g(int currentTag, int newTag) {
        this.renderLayerHandler.g(currentTag, newTag);
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    public void h(int tag, @NotNull RectF frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        KRTurboDisplayNode kRTurboDisplayNode = this.realNodeMap.get(Integer.valueOf(tag));
        if (kRTurboDisplayNode != null) {
            kRTurboDisplayNode.w(frame);
            L();
        }
        if (!this.lazyRendering) {
            this.renderLayerHandler.h(tag, frame);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    public void i(int tag, @NotNull i01.b shadow) {
        Intrinsics.checkNotNullParameter(shadow, "shadow");
        L();
        if (!this.lazyRendering) {
            this.renderLayerHandler.i(tag, shadow);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    @Nullable
    public Object j(@NotNull String moduleName, @NotNull String method, @Nullable String params, @Nullable String callId, @Nullable Function1<Object, Unit> successCallback, @Nullable Function1<Object, Unit> errorCallback) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(method, "method");
        return this.renderLayerHandler.j(moduleName, method, params, callId, successCallback, errorCallback);
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    @NotNull
    public SizeF k(int tag, @NotNull SizeF constraintSize) {
        Intrinsics.checkNotNullParameter(constraintSize, "constraintSize");
        KRTurboDisplayShadow kRTurboDisplayShadow = this.realShadowMap.get(Integer.valueOf(tag));
        if (kRTurboDisplayShadow != null) {
            kRTurboDisplayShadow.b(constraintSize);
        }
        return this.renderLayerHandler.k(tag, constraintSize);
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    public void l(int parentTag, int childTag, int index) {
        KRTurboDisplayNode kRTurboDisplayNode = this.realNodeMap.get(Integer.valueOf(parentTag));
        KRTurboDisplayNode kRTurboDisplayNode2 = this.realNodeMap.get(Integer.valueOf(childTag));
        if (kRTurboDisplayNode != null && kRTurboDisplayNode2 != null) {
            kRTurboDisplayNode.t(kRTurboDisplayNode2, index);
            L();
        }
        if (!this.lazyRendering) {
            this.renderLayerHandler.l(parentTag, childTag, index);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    public void m(@NotNull com.tencent.kuikly.core.render.android.layer.b initCallback) {
        d dVar;
        KRTurboDisplayNode kRTurboDisplayNode;
        List<KRTurboDisplayNode> list;
        ViewParent viewParent;
        KRTurboDisplayNode turboDisplayNode;
        KRTurboDisplayNode turboDisplayNode2;
        boolean z16;
        String str;
        Intrinsics.checkNotNullParameter(initCallback, "initCallback");
        KRTurboDisplayCacheManager kRTurboDisplayCacheManager = this.turboDisplayCacheManager;
        if (kRTurboDisplayCacheManager != null && (dVar = this.renderView) != null) {
            long currentTimeMillis = System.currentTimeMillis();
            initCallback.c();
            a h16 = kRTurboDisplayCacheManager.h(this.turboDisplayCacheKey);
            this.turboDisplayCacheData = h16;
            boolean z17 = true;
            String str2 = null;
            if (h16 != null && (turboDisplayNode2 = h16.getTurboDisplayNode()) != null) {
                if (turboDisplayNode2.getViewName().length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    this.lazyRendering = true;
                    KRTurboDisplayModule kRTurboDisplayModule = (KRTurboDisplayModule) dVar.getKuiklyRenderContext().a("KRTurboDisplayModule");
                    if (kRTurboDisplayModule != null) {
                        kRTurboDisplayModule.a(true);
                    }
                } else {
                    w wVar = w.f392617a;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("page: ");
                    KuiklyContextParams kuiklyContextParams = this.contextParam;
                    if (kuiklyContextParams != null) {
                        str = kuiklyContextParams.getPageUrl();
                    } else {
                        str = null;
                    }
                    sb5.append(str);
                    sb5.append(", turbo root node view name is empty");
                    wVar.c("KuiklyTurboDisplayRenderLayer", sb5.toString());
                }
            }
            initCallback.b();
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            KuiklyRenderCoreUIScheduler kuiklyRenderCoreUIScheduler = this.uiScheduler;
            if (kuiklyRenderCoreUIScheduler != null) {
                kuiklyRenderCoreUIScheduler.s(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.turbo.KuiklyTurboDisplayRenderLayerHandler$didInit$2
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
                        KuiklyTurboDisplayRenderLayerHandler.this.H();
                    }
                });
            }
            if (this.lazyRendering) {
                KuiklyRenderCoreUIScheduler kuiklyRenderCoreUIScheduler2 = this.uiScheduler;
                if (kuiklyRenderCoreUIScheduler2 != null) {
                    kuiklyRenderCoreUIScheduler2.l();
                }
                long currentTimeMillis3 = System.currentTimeMillis();
                initCallback.a();
                a aVar = this.turboDisplayCacheData;
                if (aVar != null) {
                    kRTurboDisplayNode = aVar.getTurboDisplayNode();
                } else {
                    kRTurboDisplayNode = null;
                }
                J(kRTurboDisplayNode);
                initCallback.d();
                a aVar2 = this.turboDisplayCacheData;
                if (aVar2 != null && (turboDisplayNode = aVar2.getTurboDisplayNode()) != null) {
                    list = turboDisplayNode.j();
                } else {
                    list = null;
                }
                List<KRTurboDisplayNode> list2 = list;
                if (list2 != null && !list2.isEmpty()) {
                    z17 = false;
                }
                if (!z17) {
                    View b16 = dVar.b(list.get(0).getTag());
                    if (b16 != null) {
                        viewParent = b16.getParent();
                    } else {
                        viewParent = null;
                    }
                    if (!(viewParent instanceof ViewGroup)) {
                        viewParent = null;
                    }
                    ViewGroup viewGroup = (ViewGroup) viewParent;
                    if (viewGroup != null) {
                        viewGroup.requestLayout();
                    }
                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
                    w wVar2 = w.f392617a;
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("page: ");
                    KuiklyContextParams kuiklyContextParams2 = this.contextParam;
                    if (kuiklyContextParams2 != null) {
                        str2 = kuiklyContextParams2.getPageUrl();
                    }
                    sb6.append(str2);
                    sb6.append(", turbo_display render cost_time: ");
                    sb6.append(currentTimeMillis4);
                    sb6.append(", readTurboFileCostTime: ");
                    sb6.append(currentTimeMillis2);
                    wVar2.c("KuiklyTurboDisplayRenderLayer", sb6.toString());
                    return;
                }
                return;
            }
            initCallback.a();
            initCallback.d();
            w wVar3 = w.f392617a;
            StringBuilder sb7 = new StringBuilder();
            sb7.append("page: ");
            KuiklyContextParams kuiklyContextParams3 = this.contextParam;
            if (kuiklyContextParams3 != null) {
                str2 = kuiklyContextParams3.getPageUrl();
            }
            sb7.append(str2);
            sb7.append(" has not turboDisplay file");
            wVar3.c("KuiklyTurboDisplayRenderLayer", sb7.toString());
        }
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    public void n() {
        if (this.nextTurboDisplayRootNode == null) {
            K();
        }
        N();
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    @Nullable
    public i01.b o(final int tag) {
        final KRTurboDisplayShadow kRTurboDisplayShadow;
        final i01.b o16 = this.renderLayerHandler.o(tag);
        KRTurboDisplayShadow kRTurboDisplayShadow2 = this.realShadowMap.get(Integer.valueOf(tag));
        if (kRTurboDisplayShadow2 != null) {
            kRTurboDisplayShadow = kRTurboDisplayShadow2.c();
        } else {
            kRTurboDisplayShadow = null;
        }
        KuiklyRenderCoreUIScheduler kuiklyRenderCoreUIScheduler = this.uiScheduler;
        if (kuiklyRenderCoreUIScheduler != null) {
            a.C5875a.a(kuiklyRenderCoreUIScheduler, 0L, new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.turbo.KuiklyTurboDisplayRenderLayerHandler$shadow$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    Map map;
                    map = KuiklyTurboDisplayRenderLayerHandler.this.realNodeMap;
                    KRTurboDisplayNode kRTurboDisplayNode = (KRTurboDisplayNode) map.get(Integer.valueOf(tag));
                    KRTurboDisplayShadow kRTurboDisplayShadow3 = kRTurboDisplayShadow;
                    if (kRTurboDisplayShadow3 != null && kRTurboDisplayNode != null) {
                        kRTurboDisplayNode.B(kRTurboDisplayShadow3);
                    }
                    if (kRTurboDisplayNode != null) {
                        kRTurboDisplayNode.A(o16);
                    }
                }
            }, 1, null);
        }
        return o16;
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    public void onDestroy() {
        this.renderLayerHandler.onDestroy();
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    public void p(int tag, @NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        KRTurboDisplayNode kRTurboDisplayNode = this.realNodeMap.get(Integer.valueOf(tag));
        if (kRTurboDisplayNode != null) {
            kRTurboDisplayNode.y(propKey, propValue);
            L();
        }
        if (!this.lazyRendering) {
            this.renderLayerHandler.p(tag, propKey, propValue);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    @Nullable
    public Object q(int tag, @NotNull String methodName, @NotNull String params) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(params, "params");
        KRTurboDisplayShadow kRTurboDisplayShadow = this.realShadowMap.get(Integer.valueOf(tag));
        if (kRTurboDisplayShadow != null) {
            kRTurboDisplayShadow.a(methodName, params);
        }
        return this.renderLayerHandler.q(tag, methodName, params);
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    public void r(int tag, @NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        KRTurboDisplayNode kRTurboDisplayNode = this.realNodeMap.get(Integer.valueOf(tag));
        if (kRTurboDisplayNode != null && !kRTurboDisplayNode.getAddViewMethodDisable()) {
            kRTurboDisplayNode.c(method, params, callback);
        }
        if (!this.lazyRendering) {
            this.renderLayerHandler.r(tag, method, params, callback);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    public void s(int tag, @NotNull String viewName) {
        Intrinsics.checkNotNullParameter(viewName, "viewName");
        final KRTurboDisplayNode kRTurboDisplayNode = new KRTurboDisplayNode(tag, viewName);
        this.realNodeMap.put(Integer.valueOf(tag), kRTurboDisplayNode);
        L();
        G(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.turbo.KuiklyTurboDisplayRenderLayerHandler$createRenderView$1
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
                KRTurboDisplayNode.this.v(true);
            }
        });
        if (!this.lazyRendering) {
            this.renderLayerHandler.s(tag, viewName);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    public void t(int tag, @NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        KRTurboDisplayShadow kRTurboDisplayShadow = this.realShadowMap.get(Integer.valueOf(tag));
        if (kRTurboDisplayShadow != null) {
            kRTurboDisplayShadow.k(propKey, propValue);
        }
        this.renderLayerHandler.t(tag, propKey, propValue);
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    public void u(int tag) {
        KRTurboDisplayNode kRTurboDisplayNode = this.realNodeMap.get(Integer.valueOf(tag));
        if (kRTurboDisplayNode != null) {
            Integer parentTag = kRTurboDisplayNode.getParentTag();
            if (parentTag != null) {
                KRTurboDisplayNode kRTurboDisplayNode2 = this.realNodeMap.get(Integer.valueOf(parentTag.intValue()));
                if (kRTurboDisplayNode2 != null) {
                    kRTurboDisplayNode.u(kRTurboDisplayNode2);
                }
            }
            this.realNodeMap.remove(Integer.valueOf(tag));
        }
        if (!this.lazyRendering) {
            this.renderLayerHandler.u(tag);
        }
    }
}
