package com.tencent.kuikly.core.render.android.context;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.kuikly.core.render.android.KuiklyContextParams;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.kuikly.core.render.android.scheduler.KuiklyRenderThreadManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\b&\u0018\u0000 82\u00020\u0001:\u00019B\u0007\u00a2\u0006\u0004\b6\u00107J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016JL\u0010\u0014\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0012\u0010\u0019\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0018H\u0016J\u0018\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0004J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\n\u0010 \u001a\u00020\u0005*\u00020\u0005J\u0015\u0010#\u001a\u00020\"*\u0006\u0012\u0002\b\u00030!\u00a2\u0006\u0004\b#\u0010$R$\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010,\u001a\u0004\u0018\u00010\t8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0018\u00102\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00104\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u0006:"}, d2 = {"Lcom/tencent/kuikly/core/render/android/context/e;", "Lcom/tencent/kuikly/core/render/android/context/b;", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderContextMethod;", "method", "", "", "args", "", "call", "Lcom/tencent/kuikly/core/render/android/context/c;", "callback", "registerCallNative", "", "methodId", "arg0", "arg1", "arg2", "arg3", "arg4", "arg5", "callKotlinMethod", "Lcom/tencent/kuikly/core/render/android/context/a;", "listener", "setBridgeStatusListener", "Lcom/tencent/kuikly/core/render/android/exception/a;", "setRenderExceptionListener", "", "throwable", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "notifyException", "destroy", "toKotlinObject", "", "", "hasByteArrayElement", "([Ljava/lang/Object;)Z", "Lcom/tencent/kuikly/core/render/android/g;", "contextParams", "Lcom/tencent/kuikly/core/render/android/g;", "getContextParams", "()Lcom/tencent/kuikly/core/render/android/g;", "setContextParams", "(Lcom/tencent/kuikly/core/render/android/g;)V", "callNativeCallback", "Lcom/tencent/kuikly/core/render/android/context/c;", "getCallNativeCallback", "()Lcom/tencent/kuikly/core/render/android/context/c;", "setCallNativeCallback", "(Lcom/tencent/kuikly/core/render/android/context/c;)V", "bridgeStatusListener", "Lcom/tencent/kuikly/core/render/android/context/a;", "exceptionListener", "Lcom/tencent/kuikly/core/render/android/exception/a;", "<init>", "()V", "Companion", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public abstract class e implements b {
    private static final int CALL_ARGS_COUNT = 6;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private volatile a bridgeStatusListener;

    @Nullable
    private volatile c callNativeCallback;

    @Nullable
    private KuiklyContextParams contextParams;
    private volatile com.tencent.kuikly.core.render.android.exception.a exceptionListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/kuikly/core/render/android/context/e$a;", "", "", "CALL_ARGS_COUNT", "I", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.context.e$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.tencent.kuikly.core.render.android.context.b
    public void call(@NotNull KuiklyRenderContextMethod method, @NotNull List<? extends Object> args) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(args, "args");
        KuiklyRenderThreadManager.f118203b.a(this.contextParams);
        List arrayList = new ArrayList();
        int size = args.size();
        int i3 = 0;
        while (true) {
            Object obj = null;
            if (i3 >= size) {
                break;
            }
            Object obj2 = args.get(i3);
            if (obj2 != null) {
                obj = toKotlinObject(obj2);
            }
            arrayList.add(obj);
            i3++;
        }
        if (arrayList.size() >= 6) {
            arrayList = arrayList.subList(0, 6);
        } else {
            int size2 = 6 - arrayList.size();
            for (int i16 = 0; i16 < size2; i16++) {
                arrayList.add(null);
            }
        }
        a aVar = this.bridgeStatusListener;
        if (aVar != null) {
            aVar.a();
        }
        callKotlinMethod(method.ordinal(), com.tencent.kuikly.core.render.android.css.ktx.b.c(arrayList), com.tencent.kuikly.core.render.android.css.ktx.b.o(arrayList), com.tencent.kuikly.core.render.android.css.ktx.b.v(arrayList), com.tencent.kuikly.core.render.android.css.ktx.b.d(arrayList), com.tencent.kuikly.core.render.android.css.ktx.b.b(arrayList), com.tencent.kuikly.core.render.android.css.ktx.b.q(arrayList));
        a aVar2 = this.bridgeStatusListener;
        if (aVar2 != null) {
            aVar2.d();
        }
    }

    public abstract void callKotlinMethod(int methodId, @Nullable Object arg0, @Nullable Object arg1, @Nullable Object arg2, @Nullable Object arg3, @Nullable Object arg4, @Nullable Object arg5);

    @Override // com.tencent.kuikly.core.render.android.context.b
    public void destroy() {
        this.exceptionListener = null;
        this.callNativeCallback = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final c getCallNativeCallback() {
        return this.callNativeCallback;
    }

    @Nullable
    public final KuiklyContextParams getContextParams() {
        return this.contextParams;
    }

    public final boolean hasByteArrayElement(@NotNull Object[] hasByteArrayElement) {
        Intrinsics.checkNotNullParameter(hasByteArrayElement, "$this$hasByteArrayElement");
        for (Object obj : hasByteArrayElement) {
            if (obj instanceof byte[]) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyException(@NotNull Throwable throwable, @NotNull ErrorReason errorReason) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(errorReason, "errorReason");
        com.tencent.kuikly.core.render.android.exception.a aVar = this.exceptionListener;
        if (aVar != null) {
            aVar.b(throwable, errorReason);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.context.b
    public void registerCallNative(@NotNull c callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callNativeCallback = callback;
    }

    @Override // com.tencent.kuikly.core.render.android.context.b
    public void setBridgeStatusListener(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.bridgeStatusListener = listener;
    }

    protected final void setCallNativeCallback(@Nullable c cVar) {
        this.callNativeCallback = cVar;
    }

    public final void setContextParams(@Nullable KuiklyContextParams kuiklyContextParams) {
        this.contextParams = kuiklyContextParams;
    }

    @Override // com.tencent.kuikly.core.render.android.context.b
    public void setRenderExceptionListener(@Nullable com.tencent.kuikly.core.render.android.exception.a listener) {
        this.exceptionListener = listener;
    }

    @NotNull
    public final Object toKotlinObject(@NotNull Object toKotlinObject) {
        List list;
        Intrinsics.checkNotNullParameter(toKotlinObject, "$this$toKotlinObject");
        if (toKotlinObject instanceof Map) {
            String jSONObject = com.tencent.kuikly.core.render.android.css.ktx.b.E((Map) toKotlinObject).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "(this as Map<String, Any\u2026toJSONObject().toString()");
            return jSONObject;
        }
        if (toKotlinObject instanceof List) {
            String jSONArray = com.tencent.kuikly.core.render.android.css.ktx.b.D((List) toKotlinObject).toString();
            Intrinsics.checkNotNullExpressionValue(jSONArray, "(this as List<Any>).toJSONArray().toString()");
            return jSONArray;
        }
        if (toKotlinObject instanceof JSONObject) {
            return toKotlinObject.toString();
        }
        if (toKotlinObject instanceof Object[]) {
            Object[] objArr = (Object[]) toKotlinObject;
            if (!hasByteArrayElement(objArr)) {
                list = ArraysKt___ArraysKt.toList(objArr);
                if (list != null) {
                    String jSONArray2 = com.tencent.kuikly.core.render.android.css.ktx.b.D(list).toString();
                    Intrinsics.checkNotNullExpressionValue(jSONArray2, "(this.toList() as List<A\u2026.toJSONArray().toString()");
                    return jSONArray2;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            }
            return toKotlinObject;
        }
        return toKotlinObject;
    }
}
