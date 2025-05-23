package com.tencent.kuikly.core.render.android.context;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8ScriptException;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import d01.w;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002JL\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/kuikly/core/render/android/context/g;", "Lcom/tencent/kuikly/core/render/android/context/e;", "Lcom/eclipsesource/v8/V8Array;", "parameters", "", "b", "", "methodId", "arg0", "arg1", "arg2", "arg3", "arg4", "arg5", "", "callKotlinMethod", "", "contextCode", "init", "destroy", "Lcom/eclipsesource/v8/V8;", "a", "Lcom/eclipsesource/v8/V8;", "v8Runtime", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class g extends e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private V8 v8Runtime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002\u00a8\u0006\b\u00b8\u0006\u0000"}, d2 = {"com/tencent/kuikly/core/render/android/context/KuiklyRenderJsContextHandler$init$1$1", "Lcom/eclipsesource/v8/JavaCallback;", "Lcom/eclipsesource/v8/V8Object;", "receiver", "Lcom/eclipsesource/v8/V8Array;", "parameters", "", "invoke", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class a implements JavaCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f117537b;

        a(String str) {
            this.f117537b = str;
        }

        @Override // com.eclipsesource.v8.JavaCallback
        @Nullable
        public Object invoke(@Nullable V8Object receiver, @Nullable V8Array parameters) {
            return g.this.b(parameters);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/eclipsesource/v8/V8Object;", "kotlin.jvm.PlatformType", "parameters", "Lcom/eclipsesource/v8/V8Array;", "invoke"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    static final class b implements JavaVoidCallback {

        /* renamed from: a, reason: collision with root package name */
        public static final b f117538a = new b();

        b() {
        }

        @Override // com.eclipsesource.v8.JavaVoidCallback
        public final void invoke(V8Object v8Object, V8Array v8Array) {
            String str;
            if (v8Array == null || (str = v8Array.getString(0)) == null) {
                str = "";
            }
            w.f392617a.c("KuiklyRender", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object b(V8Array parameters) {
        Object obj = null;
        if (parameters == null) {
            return null;
        }
        KuiklyRenderNativeMethod a16 = KuiklyRenderNativeMethod.INSTANCE.a(parameters.getInteger(0));
        ArrayList arrayList = new ArrayList();
        int length = parameters.length();
        for (int i3 = 1; i3 < length; i3++) {
            arrayList.add(parameters.get(i3));
        }
        c callNativeCallback = getCallNativeCallback();
        if (callNativeCallback != null) {
            obj = callNativeCallback.h(a16, arrayList);
        }
        if (obj instanceof Unit) {
            return "";
        }
        return obj;
    }

    @Override // com.tencent.kuikly.core.render.android.context.e
    public void callKotlinMethod(int methodId, @Nullable Object arg0, @Nullable Object arg1, @Nullable Object arg2, @Nullable Object arg3, @Nullable Object arg4, @Nullable Object arg5) {
        try {
            V8 v85 = this.v8Runtime;
            if (v85 != null) {
                v85.executeJSFunction("callKotlinMethod", Integer.valueOf(methodId), arg0, arg1, arg2, arg3, arg4, arg5);
            }
        } catch (V8ScriptException e16) {
            notifyException(e16, ErrorReason.CALL_KOTLIN);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.context.e, com.tencent.kuikly.core.render.android.context.b
    public void destroy() {
        super.destroy();
        V8 v85 = this.v8Runtime;
        if (v85 != null) {
            v85.close();
        }
        this.v8Runtime = null;
    }

    @Override // com.tencent.kuikly.core.render.android.context.b
    public void init(@NotNull String contextCode) {
        Intrinsics.checkNotNullParameter(contextCode, "contextCode");
        V8 createV8Runtime = V8.createV8Runtime();
        createV8Runtime.registerJavaMethod(new a(contextCode), "callNative");
        createV8Runtime.registerJavaMethod(b.f117538a, "nativeLog");
        try {
            createV8Runtime.executeVoidScript(contextCode, "nativevue2.js", 0);
        } catch (V8ScriptException e16) {
            notifyException(e16, ErrorReason.INITIALIZE);
        }
        Unit unit = Unit.INSTANCE;
        this.v8Runtime = createV8Runtime;
    }
}
