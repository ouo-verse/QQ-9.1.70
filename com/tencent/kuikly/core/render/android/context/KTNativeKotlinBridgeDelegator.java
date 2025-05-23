package com.tencent.kuikly.core.render.android.context;

import com.tencent.kuikly.core.IKuiklyCoreEntry;
import d01.w;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001d\u0012\u000e\b\u0002\u0010*\u001a\b\u0012\u0002\b\u0003\u0018\u00010$\u00a2\u0006\u0004\b+\u0010,J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0002J\u0006\u0010\b\u001a\u00020\u0003R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0010\u0010\u0013\"\u0004\b\u001b\u0010\u0015R$\u0010#\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R(\u0010*\u001a\b\u0012\u0002\b\u0003\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/kuikly/core/render/android/context/KTNativeKotlinBridgeDelegator;", "", "arg0", "", "g", "e", "block", "f", "b", "a", "Ljava/lang/Object;", "coreEntryCompanionInstance", "Ljava/lang/reflect/Method;", "Ljava/lang/reflect/Method;", "invokeKTBlockMethod", "Lcom/tencent/kuikly/core/IKuiklyCoreEntry$Delegate;", "c", "Lcom/tencent/kuikly/core/IKuiklyCoreEntry$Delegate;", "d", "()Lcom/tencent/kuikly/core/IKuiklyCoreEntry$Delegate;", "setNativeKotlinBridgeDelegate", "(Lcom/tencent/kuikly/core/IKuiklyCoreEntry$Delegate;)V", "nativeKotlinBridgeDelegate", "", "Z", "isDexMode", "()Z", "setDelegate", "delegate", "Lcom/tencent/kuikly/core/render/android/context/d;", "Lcom/tencent/kuikly/core/render/android/context/d;", "getDexClassLoader", "()Lcom/tencent/kuikly/core/render/android/context/d;", "setDexClassLoader", "(Lcom/tencent/kuikly/core/render/android/context/d;)V", "dexClassLoader", "Ljava/lang/Class;", "Ljava/lang/Class;", "getCoreEntryClass", "()Ljava/lang/Class;", "setCoreEntryClass", "(Ljava/lang/Class;)V", "coreEntryClass", "<init>", "(ZLcom/tencent/kuikly/core/IKuiklyCoreEntry$Delegate;Lcom/tencent/kuikly/core/render/android/context/d;Ljava/lang/Class;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KTNativeKotlinBridgeDelegator {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Object coreEntryCompanionInstance;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Method invokeKTBlockMethod;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private IKuiklyCoreEntry.Delegate nativeKotlinBridgeDelegate;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isDexMode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IKuiklyCoreEntry.Delegate delegate;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d dexClassLoader;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Class<?> coreEntryClass;

    public KTNativeKotlinBridgeDelegator(boolean z16, @Nullable IKuiklyCoreEntry.Delegate delegate, @Nullable d dVar, @Nullable Class<?> cls) {
        this.isDexMode = z16;
        this.delegate = delegate;
        this.dexClassLoader = dVar;
        this.coreEntryClass = cls;
        this.nativeKotlinBridgeDelegate = new KTNativeKotlinBridgeDelegator$nativeKotlinBridgeDelegate$1(this);
    }

    private final void e() {
        Class<?> cls;
        Method method;
        d dVar = this.dexClassLoader;
        if (dVar != null && (cls = this.coreEntryClass) != null) {
            if (this.coreEntryCompanionInstance != null && this.invokeKTBlockMethod != null) {
                return;
            }
            try {
                Class<?> loadClass = dVar.loadClass("com.tencent.kuikly.core.android.KuiklyCoreEntry$Companion");
                if (loadClass != null) {
                    method = loadClass.getDeclaredMethod("invokeKotlinBlock", Object.class);
                } else {
                    method = null;
                }
                this.invokeKTBlockMethod = method;
                this.coreEntryCompanionInstance = cls.getDeclaredField("Companion").get(null);
            } catch (Throwable th5) {
                w.f392617a.c("initKTBlockMethod", "get invokeKotlinBlock error: " + th5);
            }
        }
    }

    private final void f(Object block) {
        e();
        try {
            Method method = this.invokeKTBlockMethod;
            if (method != null) {
                method.invoke(this.coreEntryCompanionInstance, block);
            }
        } catch (Throwable th5) {
            w.f392617a.c("initKTBlockMethod", "invokeKotlinBlock error: " + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(Object arg0) {
        if (this.isDexMode) {
            if (this.dexClassLoader != null) {
                f(arg0);
            }
        } else {
            if (arg0 != null) {
                ((Function0) TypeIntrinsics.beforeCheckcastToFunctionOfArity(arg0, 0)).invoke();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type () -> kotlin.Unit");
        }
    }

    public final void b() {
        this.delegate = null;
        this.coreEntryCompanionInstance = null;
        this.invokeKTBlockMethod = null;
        this.coreEntryClass = null;
        this.dexClassLoader = null;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final IKuiklyCoreEntry.Delegate getDelegate() {
        return this.delegate;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final IKuiklyCoreEntry.Delegate getNativeKotlinBridgeDelegate() {
        return this.nativeKotlinBridgeDelegate;
    }

    public /* synthetic */ KTNativeKotlinBridgeDelegator(boolean z16, IKuiklyCoreEntry.Delegate delegate, d dVar, Class cls, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, delegate, (i3 & 4) != 0 ? null : dVar, (i3 & 8) != 0 ? null : cls);
    }
}
