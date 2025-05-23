package com.tencent.crossengine.log;

import com.tencent.crossengine.log.LogDelegate;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J$\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J$\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J$\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/crossengine/log/a;", "", "", "tag", "message", "", "throwable", "", "b", h.F, "l", "e", "Lcom/tencent/crossengine/log/LogDelegate;", "delegate", "j", "<init>", "()V", "library_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes32.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f100479a = new a();

    a() {
    }

    @JvmStatic
    public static final void b(String tag, String message, Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.throwUninitializedPropertyAccessException("delegate");
        LogDelegate.Level level = LogDelegate.Level.VERBOSE;
        throw null;
    }

    @JvmStatic
    public static final void e(String tag, String message, Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.throwUninitializedPropertyAccessException("delegate");
        LogDelegate.Level level = LogDelegate.Level.VERBOSE;
        throw null;
    }

    @JvmStatic
    public static final void h(String tag, String message, Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.throwUninitializedPropertyAccessException("delegate");
        LogDelegate.Level level = LogDelegate.Level.VERBOSE;
        throw null;
    }

    @JvmStatic
    public static final void l(String tag, String message, Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.throwUninitializedPropertyAccessException("delegate");
        LogDelegate.Level level = LogDelegate.Level.VERBOSE;
        throw null;
    }

    public final void j(LogDelegate delegate) {
        Intrinsics.checkParameterIsNotNull(delegate, "delegate");
    }

    @JvmStatic
    public static final void a(String str, String str2) {
        c(str, str2, null, 4, null);
    }

    @JvmStatic
    public static final void d(String str, String str2) {
        f(str, str2, null, 4, null);
    }

    @JvmStatic
    public static final void g(String str, String str2) {
        i(str, str2, null, 4, null);
    }

    @JvmStatic
    public static final void k(String str, String str2) {
        m(str, str2, null, 4, null);
    }

    public static /* synthetic */ void c(String str, String str2, Throwable th5, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            th5 = null;
        }
        b(str, str2, th5);
    }

    public static /* synthetic */ void f(String str, String str2, Throwable th5, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            th5 = null;
        }
        e(str, str2, th5);
    }

    public static /* synthetic */ void i(String str, String str2, Throwable th5, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            th5 = null;
        }
        h(str, str2, th5);
    }

    public static /* synthetic */ void m(String str, String str2, Throwable th5, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            th5 = null;
        }
        l(str, str2, th5);
    }
}
