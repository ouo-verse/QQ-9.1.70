package com.tencent.square.debugger;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0014\u0010\n\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bJ\u0006\u0010\u000b\u001a\u00020\u0004R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\fR\"\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/square/debugger/b;", "", "Lcom/tencent/square/debugger/e;", "proxy", "", "f", "", "a", "Lkotlin/Function0;", "task", "c", "d", "Lcom/tencent/square/debugger/e;", "", "b", "Z", "()Z", "e", "(Z)V", "getShaderUseMulti", "<init>", "()V", "square_debugger_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static e proxy;

    /* renamed from: c, reason: collision with root package name */
    public static final b f373562c = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean getShaderUseMulti = true;

    b() {
    }

    public final String a() {
        String currentAccountUin;
        e eVar = proxy;
        return (eVar == null || (currentAccountUin = eVar.getCurrentAccountUin()) == null) ? "2326781934" : currentAccountUin;
    }

    public final boolean b() {
        return getShaderUseMulti;
    }

    public final void c(Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        e eVar = proxy;
        if (eVar != null) {
            eVar.a(task);
        }
    }

    public final void e(boolean z16) {
        getShaderUseMulti = z16;
    }

    public final void f(e proxy2) {
        Intrinsics.checkNotNullParameter(proxy2, "proxy");
        proxy = proxy2;
    }

    public final void d() {
        proxy = null;
    }
}
