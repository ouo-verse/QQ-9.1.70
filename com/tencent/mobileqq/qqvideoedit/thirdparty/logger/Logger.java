package com.tencent.mobileqq.qqvideoedit.thirdparty.logger;

import com.tencent.mobileqq.qqvideoedit.thirdparty.logger.log.LogLevel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.logger.log.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0002J\u0016\u0010\r\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u0016\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u0016\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u0016\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010J\u001e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/logger/Logger;", "", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/logger/log/LogLevel;", "level", "", "tag", "msg", "", h.F, "curLogLevel", "configLogLevel", "", "g", "f", "b", "c", "", "throwable", "e", "d", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class Logger {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final Logger f275870a = new Logger();

    Logger() {
    }

    public static final /* synthetic */ a a() {
        return null;
    }

    private final boolean g(LogLevel curLogLevel, LogLevel configLogLevel) {
        if (configLogLevel != null && curLogLevel.compareTo(configLogLevel) >= 0) {
            return true;
        }
        return false;
    }

    private final void h(LogLevel level, String tag, String msg2) {
        g(level, null);
    }

    public final void b(@NotNull String tag, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        h(LogLevel.DEBUG, tag, msg2);
    }

    public final void c(@NotNull String tag, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        h(LogLevel.ERROR, tag, msg2);
    }

    public final void d(@NotNull String tag, @NotNull String msg2, @NotNull Throwable throwable) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        c(tag, fk2.a.f399711a.a(msg2, throwable));
    }

    public final void e(@NotNull String tag, @NotNull Throwable throwable) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        c(tag, fk2.a.f399711a.b(throwable));
    }

    public final void f(@NotNull String tag, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        h(LogLevel.INFO, tag, msg2);
    }
}
