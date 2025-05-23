package com.tencent.kuikly.core.render.android.expand.module;

import android.util.ArrayMap;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vaswebviewplugin.ColorRingJsPlugin;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001d\u0010\u000f\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\f2\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0002JI\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\r2+\u0010\u0019\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014j\u0004\u0018\u0001`\u0018H\u0016JI\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u0019\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014j\u0004\u0018\u0001`\u0018H\u0016R \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/module/j;", "Li01/e;", "", "params", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "j", "d", "i", "a", "c", "T", "", "key", "g", "(Ljava/lang/String;)Ljava/lang/Object;", "value", "l", "method", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "Landroid/util/ArrayMap;", "Landroid/util/ArrayMap;", "cacheMap", "<init>", "()V", "e", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class j extends i01.e {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ArrayMap<String, Object> cacheMap = new ArrayMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/module/j$a;", "", "", "KEY_KEY", "Ljava/lang/String;", "KEY_VALUE", "METHOD_CLEAR", "METHOD_CLEAR_ALL", "METHOD_GET", "METHOD_REMOVE", "METHOD_SET", "METHOD_SETUP", "METHOD_SET_OBJECT", "MODULE_NAME", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.expand.module.j$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void a(Object params) {
        if (params != null) {
            Object obj = ((Object[]) params)[0];
            if (obj != null) {
                i.f118055b.d((String) obj);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<*>");
    }

    private final void c(Object params) {
        i.f118055b.c();
    }

    private final Object d(Object params) {
        if (params != null) {
            Object[] objArr = (Object[]) params;
            Object obj = objArr[0];
            if (obj != null) {
                String str = (String) obj;
                Object obj2 = objArr[1];
                if (obj2 != null) {
                    return i.b(i.f118055b, str, 0, 2, null).get((String) obj2);
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<*>");
    }

    private final void i(Object params) {
        if (params != null) {
            Object[] objArr = (Object[]) params;
            Object obj = objArr[0];
            if (obj != null) {
                String str = (String) obj;
                Object obj2 = objArr[1];
                if (obj2 != null) {
                    i.b(i.f118055b, str, 0, 2, null).remove((String) obj2);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<*>");
    }

    private final void j(Object params) {
        if (params != null) {
            Object[] objArr = (Object[]) params;
            Object obj = objArr[0];
            if (obj != null) {
                String str = (String) obj;
                Object obj2 = objArr[1];
                if (obj2 != null) {
                    String str2 = (String) obj2;
                    Object obj3 = objArr[2];
                    if (obj3 != null) {
                        i.b(i.f118055b, str, 0, 2, null).put(str2, obj3);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<*>");
    }

    private final void m(Object params) {
        if (params == null) {
            return;
        }
        if (params instanceof Object[]) {
            Object[] objArr = (Object[]) params;
            if (objArr.length < 2) {
                return;
            }
            Object obj = objArr[0];
            if (obj != null) {
                String str = (String) obj;
                Object obj2 = objArr[1];
                if (obj2 != null) {
                    l(str, obj2);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        JSONObject k06 = KRCSSViewExtensionKt.k0((String) params);
        Object opt = k06.opt("value");
        if (opt != null) {
            String key = k06.optString("key");
            Intrinsics.checkNotNullExpressionValue(key, "key");
            l(key, opt);
        }
    }

    private final void o(Object params) {
        if (params != null) {
            Object[] objArr = (Object[]) params;
            Object obj = objArr[0];
            if (obj != null) {
                String str = (String) obj;
                Object obj2 = objArr[1];
                if (obj2 != null) {
                    i.f118055b.a(str, ((Integer) obj2).intValue());
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<*>");
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (method.hashCode() != 458029633 || !method.equals("setObject")) {
            return super.call(method, params, callback);
        }
        m(params);
        return Unit.INSTANCE;
    }

    @Nullable
    public final <T> T g(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        T t16 = (T) this.cacheMap.get(key);
        if (!(t16 instanceof Object)) {
            return null;
        }
        return t16;
    }

    public final void l(@NotNull String key, @NotNull Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.cacheMap.put(key, value);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable Object params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -934610812:
                if (method.equals("remove")) {
                    i(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 102230:
                if (method.equals("get")) {
                    return d(params);
                }
                return super.call(method, params, callback);
            case 113762:
                if (method.equals("set")) {
                    j(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 94746189:
                if (method.equals(QCircleLpReportDc05507.KEY_CLEAR)) {
                    a(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 109329021:
                if (method.equals(ColorRingJsPlugin.Method_SetUp)) {
                    o(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 458029633:
                if (method.equals("setObject")) {
                    m(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 790268948:
                if (method.equals("clearAll")) {
                    c(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            default:
                return super.call(method, params, callback);
        }
    }
}
