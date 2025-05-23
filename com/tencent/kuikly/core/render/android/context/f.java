package com.tencent.kuikly.core.render.android.context;

import com.tencent.kuikly.core.IKuiklyCoreEntry;
import com.tencent.kuikly.core.render.android.context.d;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.kuikly.core.render.android.exception.KRAarBizException;
import com.tencent.kuikly.core.render.android.expand.KuiklyRenderClassLoad;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001f2\u00020\u0001:\u0001\u0005B\u0013\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002JL\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/kuikly/core/render/android/context/f;", "Lcom/tencent/kuikly/core/render/android/context/e;", "", "contextCode", "Lcom/tencent/kuikly/core/render/android/context/d;", "a", "", "methodId", "", "arg0", "arg1", "arg2", "arg3", "arg4", "arg5", "", "callKotlinMethod", "init", "destroy", "Lcom/tencent/kuikly/core/IKuiklyCoreEntry;", "Lcom/tencent/kuikly/core/IKuiklyCoreEntry;", "kuiklyCoreEntry", "Lcom/tencent/kuikly/core/render/android/context/KTNativeKotlinBridgeDelegator;", "b", "Lcom/tencent/kuikly/core/render/android/context/KTNativeKotlinBridgeDelegator;", "bridgeDelegator", "c", "Lcom/tencent/kuikly/core/render/android/context/d;", "kuiklyDexClassLoader", "<init>", "(Lcom/tencent/kuikly/core/render/android/context/d;)V", "d", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class f extends e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private IKuiklyCoreEntry kuiklyCoreEntry;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private KTNativeKotlinBridgeDelegator bridgeDelegator;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private volatile d kuiklyDexClassLoader;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/kuikly/core/render/android/context/f$a;", "", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.context.f$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JN\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/kuikly/core/render/android/context/f$b", "Lcom/tencent/kuikly/core/IKuiklyCoreEntry$Delegate;", "", "methodId", "", "arg0", "arg1", "arg2", "arg3", "arg4", "arg5", "callNative", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class b implements IKuiklyCoreEntry.Delegate {
        b() {
        }

        @Override // com.tencent.kuikly.core.IKuiklyCoreEntry.Delegate
        @Nullable
        public Object callNative(int methodId, @Nullable Object arg0, @Nullable Object arg1, @Nullable Object arg2, @Nullable Object arg3, @Nullable Object arg4, @Nullable Object arg5) {
            Object obj;
            List<? extends Object> listOf;
            try {
                c callNativeCallback = f.this.getCallNativeCallback();
                if (callNativeCallback != null) {
                    KuiklyRenderNativeMethod a16 = KuiklyRenderNativeMethod.INSTANCE.a(methodId);
                    listOf = CollectionsKt__CollectionsKt.listOf(arg0, arg1, arg2, arg3, arg4, arg5);
                    obj = callNativeCallback.h(a16, listOf);
                } else {
                    obj = null;
                }
                if (obj == null) {
                    return null;
                }
                return f.this.toKotlinObject(obj);
            } catch (Throwable th5) {
                f.this.notifyException(new KRAarBizException(th5), ErrorReason.CALL_NATIVE);
                return null;
            }
        }
    }

    public f(@Nullable d dVar) {
        this.kuiklyDexClassLoader = dVar;
    }

    private final d a(String contextCode) {
        d dVar = this.kuiklyDexClassLoader;
        if (dVar == null) {
            d.Companion companion = d.INSTANCE;
            ClassLoader classLoader = f.class.getClassLoader();
            Intrinsics.checkNotNullExpressionValue(classLoader, "javaClass.classLoader");
            d a16 = companion.a(contextCode, classLoader);
            KuiklyRenderClassLoad.f117708b.b(a16, true);
            this.kuiklyDexClassLoader = a16;
            return a16;
        }
        return dVar;
    }

    @Override // com.tencent.kuikly.core.render.android.context.e
    public void callKotlinMethod(int methodId, @Nullable Object arg0, @Nullable Object arg1, @Nullable Object arg2, @Nullable Object arg3, @Nullable Object arg4, @Nullable Object arg5) {
        try {
            IKuiklyCoreEntry iKuiklyCoreEntry = this.kuiklyCoreEntry;
            if (iKuiklyCoreEntry != null) {
                iKuiklyCoreEntry.callKotlinMethod(methodId, arg0, arg1, arg2, arg3, arg4, arg5);
            }
        } catch (Throwable th5) {
            notifyException(new KRAarBizException(th5), ErrorReason.CALL_KOTLIN);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.context.e, com.tencent.kuikly.core.render.android.context.b
    public void destroy() {
        super.destroy();
        this.kuiklyDexClassLoader = null;
        this.kuiklyCoreEntry = null;
        KTNativeKotlinBridgeDelegator kTNativeKotlinBridgeDelegator = this.bridgeDelegator;
        if (kTNativeKotlinBridgeDelegator != null) {
            kTNativeKotlinBridgeDelegator.b();
        }
    }

    @Override // com.tencent.kuikly.core.render.android.context.b
    public void init(@NotNull String contextCode) {
        Intrinsics.checkNotNullParameter(contextCode, "contextCode");
        try {
            d a16 = a(contextCode);
            Class<?> loadClass = a16.loadClass("com.tencent.kuikly.core.android.KuiklyCoreEntry");
            if (loadClass != null) {
                IKuiklyCoreEntry iKuiklyCoreEntry = (IKuiklyCoreEntry) loadClass.newInstance();
                KTNativeKotlinBridgeDelegator kTNativeKotlinBridgeDelegator = new KTNativeKotlinBridgeDelegator(true, new b(), a16, loadClass);
                iKuiklyCoreEntry.setDelegate(kTNativeKotlinBridgeDelegator.getNativeKotlinBridgeDelegate());
                this.bridgeDelegator = kTNativeKotlinBridgeDelegator;
                this.kuiklyCoreEntry = iKuiklyCoreEntry;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<com.tencent.kuikly.core.IKuiklyCoreEntry>");
        } catch (Throwable th5) {
            notifyException(new KRAarBizException(th5), ErrorReason.INITIALIZE);
        }
    }
}
