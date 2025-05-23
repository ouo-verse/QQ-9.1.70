package com.tencent.zplan.utils;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\"\u0010\t\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J,\u0010\f\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u001a\u0010\r\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J$\u0010\u000e\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\"\u0010\u000f\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J,\u0010\u0010\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u001a\u0010\u0011\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J$\u0010\u0012\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\"\u0010\u0013\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J,\u0010\u0014\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u001a\u0010\u0015\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J$\u0010\u0016\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\"\u0010\u0017\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J,\u0010\u0018\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nR\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/zplan/utils/ZLog;", "", "", "tag", "message", "", "c", "", "clr", "a", "", "t", "b", "k", "l", "i", "j", "o", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "f", "g", "d", "e", "Llx4/d;", "Lkotlin/Lazy;", h.F, "()Llx4/d;", "logger", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class ZLog {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Lazy logger;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final ZLog f386189b = new ZLog();

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<lx4.d>() { // from class: com.tencent.zplan.utils.ZLog$logger$2
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final lx4.d invoke() {
                return (lx4.d) mx4.a.f417748a.a(lx4.d.class);
            }
        });
        logger = lazy;
    }

    ZLog() {
    }

    private final lx4.d h() {
        return (lx4.d) logger.getValue();
    }

    public final void a(@Nullable String tag, int clr, @Nullable String message) {
        b(tag, clr, message, null);
    }

    public final void b(@Nullable String tag, int clr, @Nullable String message, @Nullable Throwable t16) {
        lx4.d h16 = h();
        if (h16 != null) {
            h16.d(tag, clr, message, t16);
        }
    }

    public final void c(@Nullable String tag, @Nullable String message) {
        b(tag, 1, message, null);
    }

    public final void d(@Nullable String tag, int clr, @Nullable String message) {
        e(tag, clr, message, null);
    }

    public final void e(@Nullable String tag, int clr, @Nullable String message, @Nullable Throwable t16) {
        lx4.d h16 = h();
        if (h16 != null) {
            h16.e(tag, clr, message, t16);
        }
    }

    public final void f(@Nullable String tag, @Nullable String message) {
        e(tag, 1, message, null);
    }

    public final void g(@Nullable String tag, @Nullable String message, @Nullable Throwable t16) {
        e(tag, 1, message, t16);
    }

    public final void i(@Nullable String tag, int clr, @Nullable String message) {
        j(tag, clr, message, null);
    }

    public final void j(@Nullable String tag, int clr, @Nullable String message, @Nullable Throwable t16) {
        lx4.d h16 = h();
        if (h16 != null) {
            h16.i(tag, clr, message, t16);
        }
    }

    public final void k(@Nullable String tag, @Nullable String message) {
        j(tag, 1, message, null);
    }

    public final void l(@Nullable String tag, @Nullable String message, @Nullable Throwable t16) {
        j(tag, 1, message, t16);
    }

    public final void m(@Nullable String tag, int clr, @Nullable String message) {
        n(tag, clr, message, null);
    }

    public final void n(@Nullable String tag, int clr, @Nullable String message, @Nullable Throwable t16) {
        lx4.d h16 = h();
        if (h16 != null) {
            h16.w(tag, clr, message, t16);
        }
    }

    public final void o(@Nullable String tag, @Nullable String message) {
        n(tag, 1, message, null);
    }

    public final void p(@Nullable String tag, @Nullable String message, @Nullable Throwable t16) {
        n(tag, 1, message, t16);
    }
}
