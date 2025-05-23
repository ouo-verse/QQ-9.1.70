package com.tencent.kuikly.core.render.android.layer;

import android.graphics.Rect;
import android.graphics.RectF;
import android.util.ArrayMap;
import android.util.SizeF;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.render.android.KuiklyContextParams;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.kuikly.core.render.android.expand.module.r;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.tdf.module.TDFBaseModule;
import com.tencent.tdf.utils.TDFListUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\u0018\u0000 R2\u00020\u0001:\u0001MB\u0007\u00a2\u0006\u0004\be\u0010fJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\nH\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\nH\u0002J\u0018\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\nH\u0002J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0012\u0010\u001e\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u0010H\u0002J\u0018\u0010#\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0016J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020$H\u0016J\u0018\u0010'\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010,\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u0002H\u0016J \u0010/\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010.\u001a\u00020-H\u0016J\u0018\u00101\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u0010H\u0016J\u0018\u00104\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00103\u001a\u000202H\u0016J\u0018\u00107\u001a\u0002052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00106\u001a\u000205H\u0016JO\u0010@\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00108\u001a\u00020\n2\b\u00109\u001a\u0004\u0018\u00010\n2+\u0010?\u001a'\u0012\u0015\u0012\u0013\u0018\u00010-\u00a2\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020\u0007\u0018\u00010:j\u0004\u0018\u0001`>H\u0016JQ\u0010A\u001a\u0004\u0018\u00010-2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u00108\u001a\u00020\n2\b\u00109\u001a\u0004\u0018\u00010-2+\u0010?\u001a'\u0012\u0015\u0012\u0013\u0018\u00010-\u00a2\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020\u0007\u0018\u00010:j\u0004\u0018\u0001`>H\u0016J\u0088\u0001\u0010E\u001a\u0004\u0018\u00010-2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u00108\u001a\u00020\n2\b\u00109\u001a\u0004\u0018\u00010\n2\b\u0010B\u001a\u0004\u0018\u00010\n2+\u0010C\u001a'\u0012\u0015\u0012\u0013\u0018\u00010-\u00a2\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020\u0007\u0018\u00010:j\u0004\u0018\u0001`>2+\u0010D\u001a'\u0012\u0015\u0012\u0013\u0018\u00010-\u00a2\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020\u0007\u0018\u00010:j\u0004\u0018\u0001`>H\u0016J\u0018\u0010F\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010G\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010H\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010.\u001a\u00020-H\u0016J\"\u0010J\u001a\u0004\u0018\u00010-2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010I\u001a\u00020\n2\u0006\u00109\u001a\u00020\nH\u0016J\u0012\u0010K\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J#\u0010M\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010L*\u00020\u00132\u0006\u0010<\u001a\u00020\nH\u0016\u00a2\u0006\u0004\bM\u0010NJ\u0012\u0010O\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010R\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u00022\u0006\u0010Q\u001a\u00020\u0002H\u0016J\b\u0010S\u001a\u00020\u0007H\u0016J\b\u0010T\u001a\u00020\u0007H\u0016J\b\u0010U\u001a\u00020\u0007H\u0016R\u001e\u0010X\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010WR\u001a\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00040Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010ZR\u001e\u0010\\\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010ZR \u0010_\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00130]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010^R\u0014\u0010b\u001a\u00020`8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010aR&\u0010d\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040c0]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010^\u00a8\u0006g"}, d2 = {"Lcom/tencent/kuikly/core/render/android/layer/KuiklyRenderLayerHandler;", "Lcom/tencent/kuikly/core/render/android/layer/a;", "", "tag", "Lcom/tencent/kuikly/core/render/android/layer/d;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "renderViewHandler", "", "I", "K", "", "viewName", "y", UserInfo.SEX_FEMALE, "H", "D", "Li01/b;", "B", "moduleName", "Li01/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "E", "Landroid/view/View;", "view", "propKey", "J", "Li01/c;", "viewExport", "G", "shadowHandler", HippyTKDListViewAdapter.X, "Lcom/tencent/kuikly/core/render/android/d;", "renderView", "Lcom/tencent/kuikly/core/render/android/g;", "contextParam", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/kuikly/core/render/android/layer/b;", "initCallback", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, ReportConstant.COSTREPORT_PREFIX, "u", "parentTag", "childTag", "index", "l", "", "propValue", "p", "shadow", "i", "Landroid/graphics/RectF;", AIInput.KEY_FRAME, h.F, "Landroid/util/SizeF;", "constraintSize", "k", "method", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "r", "f", "callId", "successCallback", "errorCallback", "j", "c", "d", "t", "methodName", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "T", "a", "(Ljava/lang/String;)Li01/a;", "b", "currentTag", "newTag", "g", "e", DomainData.DOMAIN_NAME, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "renderViewWeakRef", "Landroid/util/SparseArray;", "Landroid/util/SparseArray;", "renderViewRegistry", "shadowRegistry", "Landroid/util/ArrayMap;", "Landroid/util/ArrayMap;", "moduleRegistry", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "moduleRegistryWRLock", "", "renderViewReuseListMap", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KuiklyRenderLayerHandler implements a {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private WeakReference<com.tencent.kuikly.core.render.android.d> renderViewWeakRef;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private SparseArray<i01.b> shadowRegistry;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final SparseArray<RenderViewHandler> renderViewRegistry = new SparseArray<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ArrayMap<String, i01.a> moduleRegistry = new ArrayMap<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ReentrantReadWriteLock moduleRegistryWRLock = new ReentrantReadWriteLock();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ArrayMap<String, List<RenderViewHandler>> renderViewReuseListMap = new ArrayMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/kuikly/core/render/android/layer/KuiklyRenderLayerHandler$a;", "", "", "HR_SET_PROP_OPERATION", "Ljava/lang/String;", "", "MAX_REUSE_COUNT", "I", "ROOT_VIEW_TAG", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.layer.KuiklyRenderLayerHandler$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final RenderViewHandler A(int tag) {
        com.tencent.kuikly.core.render.android.css.ktx.b.l();
        return this.renderViewRegistry.get(tag);
    }

    private final i01.b B(int tag) {
        com.tencent.kuikly.core.render.android.css.ktx.b.l();
        SparseArray<i01.b> sparseArray = this.shadowRegistry;
        if (sparseArray != null) {
            return sparseArray.get(tag);
        }
        return null;
    }

    private final void D(int tag) {
        i01.c viewExport;
        RenderViewHandler A = A(tag);
        if (A != null && (viewExport = A.getViewExport()) != null) {
            H(A.getViewName(), A);
            com.tencent.kuikly.core.render.android.css.ktx.b.n(viewExport);
            viewExport.onDestroy();
        }
        K(tag);
    }

    private final i01.a E(final String moduleName) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        c.c(this.moduleRegistryWRLock, new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.layer.KuiklyRenderLayerHandler$moduleHandlerWithName$1
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

            /* JADX WARN: Type inference failed for: r1v3, types: [i01.a, T] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ArrayMap arrayMap;
                Ref.ObjectRef objectRef2 = objectRef;
                arrayMap = KuiklyRenderLayerHandler.this.moduleRegistry;
                objectRef2.element = (i01.a) arrayMap.get(moduleName);
            }
        });
        return (i01.a) objectRef.element;
    }

    private final RenderViewHandler F(String viewName) {
        int lastIndex;
        com.tencent.kuikly.core.render.android.css.ktx.b.l();
        List<RenderViewHandler> list = this.renderViewReuseListMap.get(viewName);
        if (list != null && !list.isEmpty()) {
            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list);
            return list.remove(lastIndex);
        }
        return null;
    }

    private final void G(i01.c viewExport) {
        com.tencent.kuikly.core.render.android.d dVar;
        com.tencent.kuikly.core.render.android.a kuiklyRenderContext;
        Set<String> set;
        WeakReference<com.tencent.kuikly.core.render.android.d> weakReference;
        com.tencent.kuikly.core.render.android.d dVar2;
        com.tencent.kuikly.core.render.android.b e16;
        WeakReference<com.tencent.kuikly.core.render.android.d> weakReference2 = this.renderViewWeakRef;
        if (weakReference2 != null && (dVar = weakReference2.get()) != null && (kuiklyRenderContext = dVar.getKuiklyRenderContext()) != null && (set = (Set) kuiklyRenderContext.Q0(viewExport.f(), "hr_set_prop_operation")) != null) {
            for (String str : set) {
                if (!viewExport.s(str) && (weakReference = this.renderViewWeakRef) != null && (dVar2 = weakReference.get()) != null && (e16 = dVar2.e()) != null) {
                    e16.c(viewExport, str);
                }
            }
        }
        viewExport.h();
    }

    private final void H(String viewName, RenderViewHandler renderViewHandler) {
        com.tencent.kuikly.core.render.android.css.ktx.b.l();
        if (!KRCSSViewExtensionKt.l(renderViewHandler.getViewExport().f()) && renderViewHandler.getViewExport().getReusable()) {
            List<RenderViewHandler> list = this.renderViewReuseListMap.get(viewName);
            if (list == null) {
                list = new ArrayList<>();
                this.renderViewReuseListMap.put(viewName, list);
            }
            if (list.size() >= 50) {
                return;
            }
            G(renderViewHandler.getViewExport());
            list.add(renderViewHandler);
        }
    }

    private final void I(int tag, RenderViewHandler renderViewHandler) {
        this.renderViewRegistry.put(tag, renderViewHandler);
    }

    private final void J(View view, String propKey) {
        com.tencent.kuikly.core.render.android.d dVar;
        com.tencent.kuikly.core.render.android.a kuiklyRenderContext;
        WeakReference<com.tencent.kuikly.core.render.android.d> weakReference = this.renderViewWeakRef;
        if (weakReference != null && (dVar = weakReference.get()) != null && (kuiklyRenderContext = dVar.getKuiklyRenderContext()) != null) {
            Set set = (Set) kuiklyRenderContext.P0(view, "hr_set_prop_operation");
            if (set == null) {
                set = new LinkedHashSet();
                kuiklyRenderContext.N0(view, "hr_set_prop_operation", set);
            }
            set.add(propKey);
        }
    }

    private final void K(int tag) {
        this.renderViewRegistry.remove(tag);
    }

    private final void y(int tag, String viewName) {
        com.tencent.kuikly.core.render.android.d dVar;
        com.tencent.kuikly.core.render.android.css.ktx.b.l();
        WeakReference<com.tencent.kuikly.core.render.android.d> weakReference = this.renderViewWeakRef;
        if (weakReference != null && (dVar = weakReference.get()) != null) {
            RenderViewHandler A = A(tag);
            if (A == null) {
                A = F(viewName);
            }
            if (A == null) {
                A = new RenderViewHandler(viewName, dVar.e().i(viewName, dVar.getKuiklyRenderContext().getContext()));
            }
            A.getViewExport().setKuiklyRenderContext(dVar.getKuiklyRenderContext());
            I(tag, A);
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [i01.a, T] */
    /* JADX WARN: Type inference failed for: r4v3, types: [i01.a, T] */
    private final i01.a z(final String moduleName) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? E = E(moduleName);
        objectRef.element = E;
        if (((i01.a) E) == null) {
            c.d(this.moduleRegistryWRLock, new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.layer.KuiklyRenderLayerHandler$getModuleHandler$1
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

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WeakReference weakReference;
                    ArrayMap arrayMap;
                    com.tencent.kuikly.core.render.android.d dVar;
                    com.tencent.kuikly.core.render.android.b e16;
                    i01.a createModule;
                    WeakReference weakReference2;
                    com.tencent.kuikly.core.render.android.d dVar2;
                    Ref.ObjectRef objectRef2 = objectRef;
                    weakReference = KuiklyRenderLayerHandler.this.renderViewWeakRef;
                    T t16 = 0;
                    r2 = null;
                    com.tencent.kuikly.core.render.android.a aVar = null;
                    t16 = 0;
                    t16 = 0;
                    t16 = 0;
                    if (weakReference != null && (dVar = (com.tencent.kuikly.core.render.android.d) weakReference.get()) != null && (e16 = dVar.e()) != null && (createModule = e16.createModule(moduleName)) != null) {
                        weakReference2 = KuiklyRenderLayerHandler.this.renderViewWeakRef;
                        if (weakReference2 != null && (dVar2 = (com.tencent.kuikly.core.render.android.d) weakReference2.get()) != null) {
                            aVar = dVar2.getKuiklyRenderContext();
                        }
                        createModule.setKuiklyRenderContext(aVar);
                        Unit unit = Unit.INSTANCE;
                        t16 = createModule;
                    }
                    objectRef2.element = t16;
                    arrayMap = KuiklyRenderLayerHandler.this.moduleRegistry;
                    arrayMap.put(moduleName, (i01.a) objectRef.element);
                    i01.a aVar2 = (i01.a) objectRef.element;
                    if (aVar2 != null) {
                        aVar2.onCreate();
                    }
                }
            });
            objectRef.element = E(moduleName);
        }
        return (i01.a) objectRef.element;
    }

    public void C(@NotNull com.tencent.kuikly.core.render.android.d renderView, @NotNull KuiklyContextParams contextParam) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        Intrinsics.checkNotNullParameter(contextParam, "contextParam");
        this.renderViewWeakRef = new WeakReference<>(renderView);
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    @Nullable
    public <T extends i01.a> T a(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        T t16 = (T) z(name);
        if (!(t16 instanceof i01.a)) {
            return null;
        }
        return t16;
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    @Nullable
    public View b(int tag) {
        i01.c viewExport;
        RenderViewHandler A = A(tag);
        if (A != null && (viewExport = A.getViewExport()) != null) {
            return viewExport.f();
        }
        return null;
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    public void c(int tag, @NotNull String viewName) {
        com.tencent.kuikly.core.render.android.d dVar;
        com.tencent.kuikly.core.render.android.d dVar2;
        com.tencent.kuikly.core.render.android.b e16;
        Intrinsics.checkNotNullParameter(viewName, "viewName");
        com.tencent.kuikly.core.render.android.css.ktx.b.l();
        WeakReference<com.tencent.kuikly.core.render.android.d> weakReference = this.renderViewWeakRef;
        if (weakReference != null && (dVar = weakReference.get()) != null) {
            Intrinsics.checkNotNullExpressionValue(dVar, "renderViewWeakRef?.get() ?: return");
            SparseArray<i01.b> sparseArray = this.shadowRegistry;
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.shadowRegistry = sparseArray;
            }
            SparseArray<i01.b> sparseArray2 = this.shadowRegistry;
            if (sparseArray2 != null) {
                sparseArray2.get(tag);
            }
            WeakReference<com.tencent.kuikly.core.render.android.d> weakReference2 = this.renderViewWeakRef;
            if (weakReference2 != null && (dVar2 = weakReference2.get()) != null && (e16 = dVar2.e()) != null) {
                i01.b h16 = e16.h(viewName);
                h16.setKuiklyRenderContext(dVar.getKuiklyRenderContext());
                sparseArray.put(tag, h16);
            }
        }
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    public void d(int tag) {
        com.tencent.kuikly.core.render.android.css.ktx.b.l();
        SparseArray<i01.b> sparseArray = this.shadowRegistry;
        if (sparseArray != null) {
            sparseArray.remove(tag);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    @Nullable
    public Object f(@NotNull String moduleName, @NotNull String method, @Nullable Object params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(method, "method");
        i01.a z16 = z(moduleName);
        if (z16 != null) {
            return z16.call(method, params, callback);
        }
        return null;
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    public void g(int currentTag, int newTag) {
        RenderViewHandler A = A(currentTag);
        if (A != null) {
            K(currentTag);
            I(newTag, A);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    public void h(int tag, @NotNull RectF frame) {
        com.tencent.kuikly.core.render.android.a aVar;
        com.tencent.kuikly.core.render.android.d dVar;
        Intrinsics.checkNotNullParameter(frame, "frame");
        com.tencent.kuikly.core.render.android.css.ktx.b.l();
        WeakReference<com.tencent.kuikly.core.render.android.d> weakReference = this.renderViewWeakRef;
        if (weakReference != null && (dVar = weakReference.get()) != null) {
            aVar = dVar.getKuiklyRenderContext();
        } else {
            aVar = null;
        }
        Rect rect = new Rect();
        rect.left = com.tencent.kuikly.core.render.android.css.ktx.b.K(aVar, frame.left);
        rect.top = com.tencent.kuikly.core.render.android.css.ktx.b.K(aVar, frame.top);
        rect.right = com.tencent.kuikly.core.render.android.css.ktx.b.K(aVar, frame.right);
        rect.bottom = com.tencent.kuikly.core.render.android.css.ktx.b.K(aVar, frame.bottom);
        Unit unit = Unit.INSTANCE;
        p(tag, AIInput.KEY_FRAME, rect);
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    public void i(int tag, @NotNull i01.b shadow) {
        i01.c viewExport;
        Intrinsics.checkNotNullParameter(shadow, "shadow");
        com.tencent.kuikly.core.render.android.css.ktx.b.l();
        RenderViewHandler A = A(tag);
        if (A != null && (viewExport = A.getViewExport()) != null) {
            viewExport.setShadow(shadow);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    @Nullable
    public Object j(@NotNull String moduleName, @NotNull String method, @Nullable String params, @Nullable String callId, @Nullable Function1<Object, Unit> successCallback, @Nullable Function1<Object, Unit> errorCallback) {
        Object obj;
        com.tencent.kuikly.core.render.android.d dVar;
        com.tencent.kuikly.core.render.android.b e16;
        TDFBaseModule b16;
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(method, "method");
        WeakReference<com.tencent.kuikly.core.render.android.d> weakReference = this.renderViewWeakRef;
        if (weakReference != null && (dVar = weakReference.get()) != null && (e16 = dVar.e()) != null && (b16 = e16.b(moduleName)) != null) {
            List<Object> fromJsonStr = TDFListUtils.fromJsonStr(params);
            if (callId == null) {
                callId = "-1";
            }
            obj = b16.invoke(method, fromJsonStr, new r(callId, successCallback, errorCallback));
        } else {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        return com.tencent.kuikly.core.render.android.css.ktx.b.O(obj);
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    @NotNull
    public SizeF k(int tag, @NotNull SizeF constraintSize) {
        com.tencent.kuikly.core.render.android.a aVar;
        com.tencent.kuikly.core.render.android.d dVar;
        Intrinsics.checkNotNullParameter(constraintSize, "constraintSize");
        com.tencent.kuikly.core.render.android.css.ktx.b.l();
        i01.b B = B(tag);
        x(B);
        WeakReference<com.tencent.kuikly.core.render.android.d> weakReference = this.renderViewWeakRef;
        if (weakReference != null && (dVar = weakReference.get()) != null) {
            aVar = dVar.getKuiklyRenderContext();
        } else {
            aVar = null;
        }
        SizeF M = com.tencent.kuikly.core.render.android.css.ktx.b.M(aVar, constraintSize);
        if (B != null) {
            return com.tencent.kuikly.core.render.android.css.ktx.b.B(aVar, B.c(M));
        }
        return constraintSize;
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    public void l(int parentTag, int childTag, int index) {
        boolean z16;
        i01.c viewExport;
        ViewGroup k3;
        i01.c viewExport2;
        com.tencent.kuikly.core.render.android.d dVar;
        if (parentTag == -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            A(parentTag);
        }
        A(childTag);
        if (z16) {
            WeakReference<com.tencent.kuikly.core.render.android.d> weakReference = this.renderViewWeakRef;
            if (weakReference == null || (dVar = weakReference.get()) == null || (k3 = dVar.getView()) == null) {
                return;
            }
        } else {
            RenderViewHandler A = A(parentTag);
            if (A == null || (viewExport = A.getViewExport()) == null || (k3 = com.tencent.kuikly.core.render.android.css.ktx.b.k(viewExport)) == null) {
                return;
            }
        }
        RenderViewHandler A2 = A(childTag);
        if (A2 != null && (viewExport2 = A2.getViewExport()) != null) {
            View f16 = viewExport2.f();
            if (index > k3.getChildCount() || index == -1) {
                index = k3.getChildCount();
            }
            k3.addView(f16, index);
            viewExport2.n(k3);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    public void m(@NotNull b initCallback) {
        Intrinsics.checkNotNullParameter(initCallback, "initCallback");
        initCallback.c();
        initCallback.d();
        initCallback.a();
        initCallback.b();
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    @Nullable
    public i01.b o(int tag) {
        i01.b B = B(tag);
        x(B);
        return B;
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    public void onDestroy() {
        c.c(this.moduleRegistryWRLock, new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.layer.KuiklyRenderLayerHandler$onDestroy$1
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
                ArrayMap arrayMap;
                arrayMap = KuiklyRenderLayerHandler.this.moduleRegistry;
                Iterator it = arrayMap.values().iterator();
                while (it.hasNext()) {
                    ((i01.a) it.next()).onDestroy();
                }
            }
        });
        int size = this.renderViewRegistry.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.renderViewRegistry.valueAt(i3).getViewExport().onDestroy();
        }
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    public void p(int tag, @NotNull String propKey, @NotNull Object propValue) {
        i01.c viewExport;
        boolean z16;
        com.tencent.kuikly.core.render.android.d dVar;
        com.tencent.kuikly.core.render.android.b e16;
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        com.tencent.kuikly.core.render.android.css.ktx.b.l();
        RenderViewHandler A = A(tag);
        if (A != null && (viewExport = A.getViewExport()) != null) {
            boolean b16 = viewExport.b(propKey, propValue);
            if (!b16) {
                WeakReference<com.tencent.kuikly.core.render.android.d> weakReference = this.renderViewWeakRef;
                if (weakReference != null && (dVar = weakReference.get()) != null && (e16 = dVar.e()) != null) {
                    z16 = e16.e(viewExport, propKey, propValue);
                } else {
                    z16 = false;
                }
                b16 = z16;
            }
            if (viewExport.getReusable() && b16) {
                J(viewExport.f(), propKey);
            }
        }
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    @Nullable
    public Object q(int tag, @NotNull String methodName, @NotNull String params) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(params, "params");
        i01.b B = B(tag);
        if (B != null) {
            return B.d(methodName, params);
        }
        return null;
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    public void r(int tag, @NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        i01.c viewExport;
        Intrinsics.checkNotNullParameter(method, "method");
        com.tencent.kuikly.core.render.android.css.ktx.b.l();
        RenderViewHandler A = A(tag);
        if (A != null && (viewExport = A.getViewExport()) != null) {
            viewExport.call(method, params, callback);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    public void s(int tag, @NotNull String viewName) {
        Intrinsics.checkNotNullParameter(viewName, "viewName");
        com.tencent.kuikly.core.render.android.css.ktx.b.l();
        A(tag);
        y(tag, viewName);
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    public void t(int tag, @NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        i01.b B = B(tag);
        if (B != null) {
            B.b(propKey, propValue);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    public void u(int tag) {
        com.tencent.kuikly.core.render.android.css.ktx.b.l();
        D(tag);
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    public void e() {
    }

    @Override // com.tencent.kuikly.core.render.android.layer.a
    public void n() {
    }

    private final void x(i01.b shadowHandler) {
    }
}
