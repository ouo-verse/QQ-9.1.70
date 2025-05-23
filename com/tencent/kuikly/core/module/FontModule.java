package com.tencent.kuikly.core.module;

import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004R7\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/kuikly/core/module/FontModule;", "Lcom/tencent/kuikly/core/module/Module;", "", "moduleName", "", "fontSize", "b", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "a", "Lkotlin/Lazy;", "()Ljava/util/HashMap;", "fontFitResultCacheMap", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class FontModule extends Module {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy fontFitResultCacheMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ!\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/kuikly/core/module/FontModule$a;", "", "", "fontSize", "", "scaleFontSizeEnable", "a", "(FLjava/lang/Boolean;)F", "", "MODULE_NAME", "Ljava/lang/String;", "SCALE_FONT_SIZE_METHOD", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.kuikly.core.module.FontModule$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final float a(float fontSize, Boolean scaleFontSizeEnable) {
            com.tencent.kuikly.core.pager.b g16 = com.tencent.kuikly.core.manager.c.f117352a.g();
            boolean scaleFontSizeEnable2 = g16.scaleFontSizeEnable();
            if (scaleFontSizeEnable != null) {
                scaleFontSizeEnable2 = scaleFontSizeEnable.booleanValue();
            }
            return (!scaleFontSizeEnable2 || g16.getPageData().getNativeBuild() < 3) ? fontSize : ((FontModule) g16.acquireModule("KRFontModule")).b(fontSize);
        }

        Companion() {
        }
    }

    public FontModule() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<HashMap<Float, Float>>() { // from class: com.tencent.kuikly.core.module.FontModule$fontFitResultCacheMap$2
            @Override // kotlin.jvm.functions.Function0
            public final HashMap<Float, Float> invoke() {
                return new HashMap<>();
            }
        });
        this.fontFitResultCacheMap = lazy;
    }

    private final HashMap<Float, Float> a() {
        return (HashMap) this.fontFitResultCacheMap.getValue();
    }

    public final float b(float fontSize) {
        Float f16 = a().get(Float.valueOf(fontSize));
        if (f16 != null) {
            return f16.floatValue();
        }
        Object syncToNativeMethod = syncToNativeMethod("scaleFontSize", new Object[]{Float.valueOf(fontSize)}, new Function1<Object, Unit>() { // from class: com.tencent.kuikly.core.module.FontModule$scaleFontSize$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }
        });
        String str = syncToNativeMethod instanceof String ? (String) syncToNativeMethod : null;
        Float valueOf = str != null ? Float.valueOf(Float.parseFloat(str)) : null;
        if (valueOf != null) {
            a().put(Float.valueOf(fontSize), Float.valueOf(valueOf.floatValue()));
        }
        return valueOf != null ? valueOf.floatValue() : fontSize;
    }

    @Override // com.tencent.kuikly.core.module.Module
    public String moduleName() {
        return "KRFontModule";
    }
}
