package com.tencent.libra.util;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.util.RFWStringBuilderUtils;
import com.tencent.libra.request.Option;
import defpackage.RFWLogExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J7\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000e\"\u00020\u0001\u00a2\u0006\u0002\u0010\u000fJ7\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000e\"\u00020\u0001\u00a2\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0004J7\u0010\u0017\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000e\"\u00020\u0001\u00a2\u0006\u0002\u0010\u000fJ7\u0010\u0017\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000e\"\u00020\u0001\u00a2\u0006\u0002\u0010\u0011J=\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000eH\u0002\u00a2\u0006\u0002\u0010\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/libra/util/LibraLogUtil;", "", "()V", "INVALID_SEQ", "", "TAG", "", "e", "", "tag", "reportLevel", "option", "Lcom/tencent/libra/request/Option;", "message", "", "(Ljava/lang/String;ILcom/tencent/libra/request/Option;[Ljava/lang/Object;)V", "seq", "(Ljava/lang/String;II[Ljava/lang/Object;)V", "execLogTask", "runnable", "Ljava/lang/Runnable;", "getLogTag", "getSeqLog", "i", "log", "isErrorLog", "", "(ZLjava/lang/String;II[Ljava/lang/Object;)V", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class LibraLogUtil {

    @NotNull
    public static final LibraLogUtil INSTANCE = new LibraLogUtil();
    public static final int INVALID_SEQ = -1;
    private static final String TAG = "LibraLogUtil";

    LibraLogUtil() {
    }

    private final void log(final boolean isErrorLog, final String tag, final int reportLevel, final int seq, final Object[] message) {
        final long currentTimeMillis = System.currentTimeMillis();
        execLogTask(new Runnable() { // from class: com.tencent.libra.util.LibraLogUtil$log$1
            @Override // java.lang.Runnable
            public final void run() {
                StringBuilder obtain = RFWStringBuilderUtils.obtain();
                obtain.append(LibraLogUtil.INSTANCE.getSeqLog(seq));
                obtain.append(", realLogTime=");
                obtain.append(currentTimeMillis);
                obtain.append(", ");
                for (Object obj : message) {
                    obtain.append(obj);
                }
                String sb5 = obtain.toString();
                Intrinsics.checkNotNullExpressionValue(sb5, "stringBuilder.append(get\u2026              .toString()");
                if (isErrorLog) {
                    RFWLog.e(tag, reportLevel, sb5);
                } else {
                    RFWLog.i(tag, reportLevel, sb5);
                }
            }
        });
    }

    public final void e(@NotNull String tag, int reportLevel, @NotNull Option option, @NotNull Object... message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(option, "option");
        Intrinsics.checkNotNullParameter(message, "message");
        log(true, tag, reportLevel, option.getSeq(), message);
    }

    public final void execLogTask(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        RFWLogExecutor.f25095b.a(true, runnable);
    }

    @NotNull
    public final String getLogTag(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return "LibraPicLoader_" + tag;
    }

    @NotNull
    public final String getSeqLog(@NotNull Option option) {
        Intrinsics.checkNotNullParameter(option, "option");
        return getSeqLog(option.getSeq());
    }

    public final void i(@NotNull String tag, int reportLevel, @NotNull Option option, @NotNull Object... message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(option, "option");
        Intrinsics.checkNotNullParameter(message, "message");
        log(false, tag, reportLevel, option.getSeq(), message);
    }

    public final void e(@NotNull String tag, int reportLevel, int seq, @NotNull Object... message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        log(true, tag, reportLevel, seq, message);
    }

    @NotNull
    public final String getSeqLog(int seq) {
        if (seq == -1) {
            return "";
        }
        return "seq=" + seq;
    }

    public final void i(@NotNull String tag, int reportLevel, int seq, @NotNull Object... message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        log(false, tag, reportLevel, seq, message);
    }
}
