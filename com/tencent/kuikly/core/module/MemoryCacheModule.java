package com.tencent.kuikly.core.module;

import com.tencent.mobileqq.vaswebviewplugin.ColorRingJsPlugin;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u0000 \u00102\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b\b\u0010\tJ \u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ \u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0018\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0002R\u001b\u0010\u0016\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/kuikly/core/module/MemoryCacheModule;", "Lcom/tencent/kuikly/core/module/Module;", "", "moduleName", "key", "", "value", "", "e", "(Ljava/lang/String;Ljava/lang/Object;)V", "workspace", "", "costLimit", "countLimit", "f", "d", "b", "c", "a", "Lkotlin/Lazy;", "getPageWorkspace", "()Ljava/lang/String;", "pageWorkspace", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MemoryCacheModule extends Module {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy pageWorkspace;

    public MemoryCacheModule() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<String>() { // from class: com.tencent.kuikly.core.module.MemoryCacheModule$pageWorkspace$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "page_" + MemoryCacheModule.this.hashCode() + "_workspace";
            }
        });
        this.pageWorkspace = lazy;
    }

    public final void a(String workspace) {
        Intrinsics.checkNotNullParameter(workspace, "workspace");
        syncToNativeMethod(QCircleLpReportDc05507.KEY_CLEAR, new Object[]{workspace}, (Function1<Object, Unit>) null);
    }

    public final Object b(String workspace, String key) {
        Intrinsics.checkNotNullParameter(workspace, "workspace");
        Intrinsics.checkNotNullParameter(key, "key");
        return syncToNativeMethod("get", new Object[]{workspace, key}, (Function1<Object, Unit>) null);
    }

    public final void c(String workspace, String key) {
        Intrinsics.checkNotNullParameter(workspace, "workspace");
        Intrinsics.checkNotNullParameter(key, "key");
        syncToNativeMethod("remove", new Object[]{workspace, key}, (Function1<Object, Unit>) null);
    }

    public final void d(String workspace, String key, Object value) {
        Intrinsics.checkNotNullParameter(workspace, "workspace");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        syncToNativeMethod("set", new Object[]{workspace, key, value}, (Function1<Object, Unit>) null);
    }

    public final void e(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        if (com.tencent.kuikly.core.pager.h.a().getPageData().getNativeBuild() >= 9 && (value instanceof byte[])) {
            asyncToNativeMethod("setObject", new Object[]{key, value}, (Function1<Object, Unit>) null);
            return;
        }
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v("key", key);
        eVar.v("value", value);
        Module.toNative$default(this, false, "setObject", eVar.toString(), null, false, 24, null);
    }

    public final void f(String workspace, int costLimit, int countLimit) {
        Intrinsics.checkNotNullParameter(workspace, "workspace");
        syncToNativeMethod(ColorRingJsPlugin.Method_SetUp, new Object[]{workspace, Integer.valueOf(costLimit), Integer.valueOf(countLimit)}, (Function1<Object, Unit>) null);
    }

    @Override // com.tencent.kuikly.core.module.Module
    public String moduleName() {
        return "KRMemoryCacheModule";
    }
}
