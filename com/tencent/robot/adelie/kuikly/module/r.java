package com.tencent.robot.adelie.kuikly.module;

import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u001a;\u0010\t\u001a\u00020\u0005*'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0000j\u0004\u0018\u0001`\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u001aG\u0010\f\u001a\u00020\u0005*'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0000j\u0004\u0018\u0001`\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u001a;\u0010\r\u001a\u00020\u0005*'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0000j\u0004\u0018\u0001`\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a8\u0006\u000e"}, d2 = {"Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "", "data", "d", "errorMsg", "showMsg", "b", "a", "robot-business-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class r {
    public static final void a(@Nullable Function1<Object, Unit> function1, @Nullable String str) {
        if (function1 != null) {
            function1.invoke(new Gson().toJson(new KuiklyRenderCallbackData(true, str, null, 4, null)));
        }
    }

    public static final void b(@Nullable Function1<Object, Unit> function1, @Nullable String str, @Nullable String str2) {
        if (function1 != null) {
            function1.invoke(new Gson().toJson(new KuiklyRenderCallbackData(false, str2, str)));
        }
    }

    public static /* synthetic */ void c(Function1 function1, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        b(function1, str, str2);
    }

    public static final void d(@Nullable Function1<Object, Unit> function1, @Nullable String str) {
        if (function1 != null) {
            function1.invoke(new Gson().toJson(new KuiklyRenderCallbackData(true, str, null, 4, null)));
        }
    }

    public static /* synthetic */ void e(Function1 function1, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        d(function1, str);
    }
}
