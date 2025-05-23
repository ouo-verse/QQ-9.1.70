package com.qzone.reborn.intimate.ntcompose;

import ck.c;
import i01.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002JI\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tj\u0004\u0018\u0001`\rH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/qzone/reborn/intimate/ntcompose/a;", "Li01/e;", "", "a", "c", "", "method", "", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "<init>", "()V", "d", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class a extends e {
    private final void a() {
        c.INSTANCE.a(true);
    }

    private final void c() {
        c.INSTANCE.a(false);
    }

    @Override // i01.e, i01.a
    public Object call(String method, Object params, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (Intrinsics.areEqual(method, "onEnterLoveTree")) {
            a();
            return Unit.INSTANCE;
        }
        if (Intrinsics.areEqual(method, "onExitLoveTree")) {
            c();
            return Unit.INSTANCE;
        }
        return super.call(method, params, callback);
    }
}
