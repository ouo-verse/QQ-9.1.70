package com.tencent.kuikly.core.render.android;

import android.content.Context;
import android.util.ArrayMap;
import android.view.View;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.kuikly.core.render.android.exception.KuiklyRenderModuleExportException;
import com.tencent.kuikly.core.render.android.exception.KuiklyRenderShadowExportException;
import com.tencent.kuikly.core.render.android.exception.KuiklyRenderViewExportException;
import com.tencent.tdf.module.TDFBaseModule;
import com.tencent.tdf.module.TDFModuleContext;
import com.tencent.tdf.module.TDFModuleManager;
import com.tencent.tdf.module.TDFModuleProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00103\u001a\u000201\u00a2\u0006\u0004\b4\u00105J \u0010\b\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016J\u001e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J4\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\t2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00122\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\rH\u0016J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\tH\u0016J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0013H\u0016J \u0010$\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\t2\u0006\u0010\"\u001a\u00020!H\u0016J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\tH\u0016J\u0018\u0010&\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\tH\u0016R,\u0010)\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00120'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010(R&\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\r0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010(R&\u0010*\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010(R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00190+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010,R\u0014\u00100\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010/R\u0014\u00103\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u00102\u00a8\u00066"}, d2 = {"Lcom/tencent/kuikly/core/render/android/h;", "Lcom/tencent/kuikly/core/render/android/b;", "Ljava/lang/Class;", "Lcom/tencent/tdf/module/TDFBaseModule;", "clazz", "Lcom/tencent/tdf/module/TDFModuleProvider;", "provider", "", "f", "", "moduleName", "b", "name", "Lkotlin/Function0;", "Li01/a;", "creator", "a", "viewName", "Lkotlin/Function1;", "Landroid/content/Context;", "Li01/c;", "renderViewExportCreator", "Li01/b;", "shadowExportCreator", "g", "Li01/d;", "handler", "d", "createModule", "context", "i", "renderViewExport", "propKey", "", "propValue", "", "e", tl.h.F, "c", "Landroid/util/ArrayMap;", "Landroid/util/ArrayMap;", "viewExportCreator", "moduleExportCreator", "", "Ljava/util/List;", "viewPropExternalHandlerList", "Lcom/tencent/tdf/module/TDFModuleManager;", "Lcom/tencent/tdf/module/TDFModuleManager;", "tdfModuleManager", "Lcom/tencent/kuikly/core/render/android/a;", "Lcom/tencent/kuikly/core/render/android/a;", "renderContext", "<init>", "(Lcom/tencent/kuikly/core/render/android/a;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class h implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ArrayMap<String, Function1<Context, i01.c>> viewExportCreator;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ArrayMap<String, Function0<i01.b>> shadowExportCreator;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ArrayMap<String, Function0<i01.a>> moduleExportCreator;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final List<i01.d> viewPropExternalHandlerList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final TDFModuleManager tdfModuleManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.kuikly.core.render.android.a renderContext;

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00042\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\fH\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/kuikly/core/render/android/h$a", "Lcom/tencent/tdf/module/TDFModuleContext;", "Landroid/view/View;", "getRootView", "", "moduleName", "Lcom/tencent/tdf/module/TDFBaseModule;", "getModule", "", "id", "getView", AdMetricTag.EVENT_NAME, "", "", "params", "", "sendEvent", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class a extends TDFModuleContext {
        a() {
        }

        @Override // com.tencent.tdf.module.TDFModuleContext
        @Nullable
        public TDFBaseModule getModule(@Nullable String moduleName) {
            d O0;
            b e16;
            if (moduleName == null || (O0 = h.this.renderContext.O0()) == null || (e16 = O0.e()) == null) {
                return null;
            }
            return e16.b(moduleName);
        }

        @Override // com.tencent.tdf.module.TDFModuleContext
        @Nullable
        public View getRootView() {
            d O0 = h.this.renderContext.O0();
            if (O0 != null) {
                return O0.getView();
            }
            return null;
        }

        @Override // com.tencent.tdf.module.TDFModuleContext
        @Nullable
        public View getView(int id5) {
            return h.this.renderContext.b(id5);
        }

        @Override // com.tencent.tdf.module.TDFModuleContext
        public void sendEvent(@NotNull String eventName, @NotNull Map<String, Object> params) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Intrinsics.checkNotNullParameter(params, "params");
            d O0 = h.this.renderContext.O0();
            if (O0 != null) {
                O0.d(eventName, params);
            }
        }
    }

    public h(@NotNull com.tencent.kuikly.core.render.android.a renderContext) {
        Intrinsics.checkNotNullParameter(renderContext, "renderContext");
        this.renderContext = renderContext;
        this.viewExportCreator = new ArrayMap<>();
        this.shadowExportCreator = new ArrayMap<>();
        this.moduleExportCreator = new ArrayMap<>();
        this.viewPropExternalHandlerList = new ArrayList();
        this.tdfModuleManager = new TDFModuleManager(new a());
    }

    @Override // com.tencent.kuikly.core.render.android.b
    public void a(@NotNull String name, @NotNull Function0<? extends i01.a> creator) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(creator, "creator");
        this.moduleExportCreator.put(name, creator);
    }

    @Override // com.tencent.kuikly.core.render.android.b
    @NotNull
    public TDFBaseModule b(@NotNull String moduleName) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        TDFBaseModule module = this.tdfModuleManager.getModule(moduleName);
        if (module != null) {
            return module;
        }
        throw new KuiklyRenderModuleExportException("can not find TDFModule, name: " + moduleName);
    }

    @Override // i01.d
    public boolean c(@NotNull i01.c renderViewExport, @NotNull String propKey) {
        Intrinsics.checkNotNullParameter(renderViewExport, "renderViewExport");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Iterator<i01.d> it = this.viewPropExternalHandlerList.iterator();
        while (it.hasNext()) {
            if (it.next().c(renderViewExport, propKey)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.kuikly.core.render.android.b
    @NotNull
    public i01.a createModule(@NotNull String name) {
        i01.a invoke;
        Intrinsics.checkNotNullParameter(name, "name");
        Function0<i01.a> function0 = this.moduleExportCreator.get(name);
        if (function0 != null && (invoke = function0.invoke()) != null) {
            return invoke;
        }
        throw new KuiklyRenderModuleExportException("can not find moduleExport, name: " + name);
    }

    @Override // com.tencent.kuikly.core.render.android.b
    public void d(@NotNull i01.d handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.viewPropExternalHandlerList.add(handler);
    }

    @Override // i01.d
    public boolean e(@NotNull i01.c renderViewExport, @NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(renderViewExport, "renderViewExport");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        Iterator<i01.d> it = this.viewPropExternalHandlerList.iterator();
        while (it.hasNext()) {
            if (it.next().e(renderViewExport, propKey, propValue)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.kuikly.core.render.android.b
    public void f(@NotNull Class<? extends TDFBaseModule> clazz, @NotNull TDFModuleProvider provider) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.tdfModuleManager.addModule(clazz, provider);
    }

    @Override // com.tencent.kuikly.core.render.android.b
    public void g(@NotNull String viewName, @NotNull Function1<? super Context, ? extends i01.c> renderViewExportCreator, @Nullable Function0<? extends i01.b> shadowExportCreator) {
        Intrinsics.checkNotNullParameter(viewName, "viewName");
        Intrinsics.checkNotNullParameter(renderViewExportCreator, "renderViewExportCreator");
        this.viewExportCreator.put(viewName, renderViewExportCreator);
        if (shadowExportCreator != null) {
            this.shadowExportCreator.put(viewName, shadowExportCreator);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.b
    @NotNull
    public i01.b h(@NotNull String name) {
        i01.b invoke;
        Intrinsics.checkNotNullParameter(name, "name");
        Function0<i01.b> function0 = this.shadowExportCreator.get(name);
        if (function0 != null && (invoke = function0.invoke()) != null) {
            return invoke;
        }
        throw new KuiklyRenderShadowExportException("can not find shadowExport, name: " + name);
    }

    @Override // com.tencent.kuikly.core.render.android.b
    @NotNull
    public i01.c i(@NotNull String name, @NotNull Context context) {
        i01.c invoke;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Function1<Context, i01.c> function1 = this.viewExportCreator.get(name);
        if (function1 != null && (invoke = function1.invoke(context)) != null) {
            return invoke;
        }
        throw new KuiklyRenderViewExportException("can not find viewExport, name: " + name);
    }
}
