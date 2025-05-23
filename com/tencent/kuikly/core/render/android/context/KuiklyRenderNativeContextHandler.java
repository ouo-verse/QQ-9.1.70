package com.tencent.kuikly.core.render.android.context;

import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.render.android.exception.KRNativeBizException;
import d01.o;
import d01.u;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014JN\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0002JM\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0082 J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016JL\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\u00112\b\u0010\b\u001a\u0004\u0018\u00010\u00112\b\u0010\t\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u0011H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeContextHandler;", "Lcom/tencent/kuikly/core/render/android/context/e;", "", "methodId", "Lcom/tencent/kuikly/core/render/android/context/KRKValue;", "arg0", "arg1", "arg2", "arg3", "arg4", "arg5", "callNative", "", "callKtMethod", "", "contextCode", "init", "", "callKotlinMethod", "<init>", "()V", "Companion", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KuiklyRenderNativeContextHandler extends e {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0003J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0003J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0003J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0003\u00a8\u0006\f"}, d2 = {"Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderNativeContextHandler$Companion;", "", "()V", "callError", "", "error", "", "logDebug", "tag", "msg", "logError", "logInfo", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void callError(String error) {
            o l3 = u.f392615m.l();
            if (l3 != null) {
                l3.uncaughtException(new KRNativeBizException(error));
                return;
            }
            throw new KRNativeBizException(error);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void logDebug(String tag, String msg2) {
            KLog.INSTANCE.d(tag, msg2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void logError(String tag, String msg2) {
            KLog.INSTANCE.e(tag, msg2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void logInfo(String tag, String msg2) {
            KLog.INSTANCE.i(tag, msg2);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @JvmStatic
    private static final void callError(String str) {
        INSTANCE.callError(str);
    }

    private final native void callKtMethod(int methodId, KRKValue arg0, KRKValue arg1, KRKValue arg2, KRKValue arg3, KRKValue arg4, KRKValue arg5);

    private final KRKValue callNative(int methodId, KRKValue arg0, KRKValue arg1, KRKValue arg2, KRKValue arg3, KRKValue arg4, KRKValue arg5) {
        KRKValue b16;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        List<? extends Object> listOf;
        com.tencent.kuikly.core.render.android.css.ktx.b.l();
        c callNativeCallback = getCallNativeCallback();
        Object obj6 = null;
        if (callNativeCallback != null) {
            KuiklyRenderNativeMethod a16 = KuiklyRenderNativeMethod.INSTANCE.a(methodId);
            Object[] objArr = new Object[6];
            if (arg0 != null) {
                obj = arg0.getValue();
            } else {
                obj = null;
            }
            objArr[0] = obj;
            if (arg1 != null) {
                obj2 = arg1.getValue();
            } else {
                obj2 = null;
            }
            objArr[1] = obj2;
            if (arg2 != null) {
                obj3 = arg2.getValue();
            } else {
                obj3 = null;
            }
            objArr[2] = obj3;
            if (arg3 != null) {
                obj4 = arg3.getValue();
            } else {
                obj4 = null;
            }
            objArr[3] = obj4;
            if (arg4 != null) {
                obj5 = arg4.getValue();
            } else {
                obj5 = null;
            }
            objArr[4] = obj5;
            if (arg5 != null) {
                obj6 = arg5.getValue();
            }
            objArr[5] = obj6;
            listOf = CollectionsKt__CollectionsKt.listOf(objArr);
            obj6 = callNativeCallback.h(a16, listOf);
        }
        b16 = i.b(obj6);
        return b16;
    }

    @JvmStatic
    private static final void logDebug(String str, String str2) {
        INSTANCE.logDebug(str, str2);
    }

    @JvmStatic
    private static final void logError(String str, String str2) {
        INSTANCE.logError(str, str2);
    }

    @JvmStatic
    private static final void logInfo(String str, String str2) {
        INSTANCE.logInfo(str, str2);
    }

    @Override // com.tencent.kuikly.core.render.android.context.e
    public void callKotlinMethod(int methodId, @Nullable Object arg0, @Nullable Object arg1, @Nullable Object arg2, @Nullable Object arg3, @Nullable Object arg4, @Nullable Object arg5) {
        KRKValue b16;
        KRKValue b17;
        KRKValue b18;
        KRKValue b19;
        KRKValue b26;
        KRKValue b27;
        b16 = i.b(arg0);
        b17 = i.b(arg1);
        b18 = i.b(arg2);
        b19 = i.b(arg3);
        b26 = i.b(arg4);
        b27 = i.b(arg5);
        callKtMethod(methodId, b16, b17, b18, b19, b26, b27);
    }

    @Override // com.tencent.kuikly.core.render.android.context.b
    public void init(@NotNull String contextCode) {
        Intrinsics.checkNotNullParameter(contextCode, "contextCode");
    }
}
