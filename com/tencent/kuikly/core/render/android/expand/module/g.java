package com.tencent.kuikly.core.render.android.expand.module;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010JI\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/module/g;", "Li01/e;", "", "method", "", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "a", "<init>", "()V", "d", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class g extends i01.e {
    @Nullable
    public final String a(@Nullable Object params) {
        boolean z16;
        if (!(params instanceof Object[])) {
            params = null;
        }
        Object[] objArr = (Object[]) params;
        if (objArr != null) {
            if (objArr.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                Object obj = objArr[0];
                if (obj != null) {
                    float floatValue = ((Float) obj).floatValue();
                    d01.f c16 = d01.u.f392615m.c();
                    if (c16 != null) {
                        floatValue = c16.b(floatValue);
                    }
                    return String.valueOf(floatValue);
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
            }
        }
        return null;
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable Object params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (Intrinsics.areEqual(method, "scaleFontSize")) {
            return a(params);
        }
        return super.call(method, params, callback);
    }
}
