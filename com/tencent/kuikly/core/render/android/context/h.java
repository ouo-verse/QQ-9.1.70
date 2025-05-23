package com.tencent.kuikly.core.render.android.context;

import com.tencent.kuikly.core.IKuiklyCoreEntry;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016JL\u0010\u0011\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0016JN\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0016R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/kuikly/core/render/android/context/h;", "Lcom/tencent/kuikly/core/render/android/context/e;", "Lcom/tencent/kuikly/core/IKuiklyCoreEntry$Delegate;", "", "contextCode", "", "init", "destroy", "", "methodId", "", "arg0", "arg1", "arg2", "arg3", "arg4", "arg5", "callKotlinMethod", "callNative", "Lcom/tencent/kuikly/core/IKuiklyCoreEntry;", "a", "Lcom/tencent/kuikly/core/IKuiklyCoreEntry;", "kuiklyCoreEntry", "Lcom/tencent/kuikly/core/render/android/context/KTNativeKotlinBridgeDelegator;", "b", "Lcom/tencent/kuikly/core/render/android/context/KTNativeKotlinBridgeDelegator;", "bridgeDelegator", "<init>", "()V", "d", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class h extends e implements IKuiklyCoreEntry.Delegate {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final IKuiklyCoreEntry kuiklyCoreEntry;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final KTNativeKotlinBridgeDelegator bridgeDelegator;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    private static final Class<?> f117539c = Class.forName("com.tencent.kuikly.core.android.KuiklyCoreEntry");

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R$\u0010\n\u001a\u0012\u0012\u0002\b\u0003 \t*\b\u0012\u0002\b\u0003\u0018\u00010\b0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/kuikly/core/render/android/context/h$a;", "", "Lcom/tencent/kuikly/core/IKuiklyCoreEntry;", "b", "", "pageName", "", "a", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "kuiklyClass", "Ljava/lang/Class;", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.context.h$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public final boolean a(@NotNull String pageName) {
            Intrinsics.checkNotNullParameter(pageName, "pageName");
            b().triggerRegisterPages();
            return BridgeManager.f117344a.B(pageName);
        }

        @NotNull
        public final IKuiklyCoreEntry b() {
            Object newInstance = h.f117539c.newInstance();
            if (newInstance != null) {
                return (IKuiklyCoreEntry) newInstance;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.IKuiklyCoreEntry");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public h() {
        IKuiklyCoreEntry b16 = INSTANCE.b();
        this.kuiklyCoreEntry = b16;
        KTNativeKotlinBridgeDelegator kTNativeKotlinBridgeDelegator = new KTNativeKotlinBridgeDelegator(false, this, null, null, 12, null);
        this.bridgeDelegator = kTNativeKotlinBridgeDelegator;
        b16.setDelegate(kTNativeKotlinBridgeDelegator.getNativeKotlinBridgeDelegate());
    }

    @Override // com.tencent.kuikly.core.render.android.context.e
    public void callKotlinMethod(int methodId, @Nullable Object arg0, @Nullable Object arg1, @Nullable Object arg2, @Nullable Object arg3, @Nullable Object arg4, @Nullable Object arg5) {
        try {
            this.kuiklyCoreEntry.callKotlinMethod(methodId, arg0, arg1, arg2, arg3, arg4, arg5);
        } catch (Throwable th5) {
            notifyException(th5, ErrorReason.CALL_KOTLIN);
        }
    }

    @Override // com.tencent.kuikly.core.IKuiklyCoreEntry.Delegate
    @Nullable
    public Object callNative(int methodId, @Nullable Object arg0, @Nullable Object arg1, @Nullable Object arg2, @Nullable Object arg3, @Nullable Object arg4, @Nullable Object arg5) {
        Object obj;
        List<? extends Object> listOf;
        try {
            c callNativeCallback = getCallNativeCallback();
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
            return toKotlinObject(obj);
        } catch (Throwable th5) {
            notifyException(th5, ErrorReason.CALL_NATIVE);
            return null;
        }
    }

    @Override // com.tencent.kuikly.core.render.android.context.e, com.tencent.kuikly.core.render.android.context.b
    public void destroy() {
        super.destroy();
        this.bridgeDelegator.b();
    }

    @Override // com.tencent.kuikly.core.render.android.context.b
    public void init(@NotNull String contextCode) {
        Intrinsics.checkNotNullParameter(contextCode, "contextCode");
    }
}
