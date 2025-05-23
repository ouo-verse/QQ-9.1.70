package com.tencent.rdelivery.reshub.util;

import android.util.Log;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.raft.standard.log.IRLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\b\u0016\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J;\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0004\b\f\u0010\rJ\u001c\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J&\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J5\u0010\f\u001a\u00020\u00042\u0010\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016\u00a2\u0006\u0004\b\f\u0010\u0010J;\u0010\u0011\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0004\b\u0011\u0010\rJ\u001c\u0010\u0011\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J&\u0010\u0011\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J5\u0010\u0011\u001a\u00020\u00042\u0010\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0010J;\u0010\u0012\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0004\b\u0012\u0010\rJ\u001c\u0010\u0012\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J&\u0010\u0012\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J5\u0010\u0012\u001a\u00020\u00042\u0010\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0010J;\u0010\u0013\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0004\b\u0013\u0010\rJ\u001c\u0010\u0013\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J&\u0010\u0013\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J5\u0010\u0013\u001a\u00020\u00042\u0010\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0010J;\u0010\u0014\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0004\b\u0014\u0010\rJ\u001c\u0010\u0014\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J&\u0010\u0014\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J5\u0010\u0014\u001a\u00020\u00042\u0010\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0010JC\u0010\u0017\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J$\u0010\u0017\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J.\u0010\u0017\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J=\u0010\u0017\u001a\u00020\u00042\u0010\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\t2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/rdelivery/reshub/util/g;", "Lcom/tencent/raft/standard/log/IRLog;", "", "isColorLevel", "", "flushLog", "", "tag", "msg", "", "", "params", "v", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "", ReportConstant.COSTREPORT_TRANS, "([Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "d", "i", "w", "e", "", "level", "log", "(Ljava/lang/String;ILjava/lang/String;[Ljava/lang/Object;)V", "([Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V", "<init>", "()V", "b", "a", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public class g implements IRLog {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f364600a = jz3.a.f411254a;

    @Override // com.tencent.raft.standard.log.IRLog
    public void d(@Nullable String[] tag, @Nullable String msg2, @Nullable Throwable tr5) {
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void e(@Nullable String[] tag, @Nullable String msg2, @Nullable Throwable tr5) {
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void i(@Nullable String[] tag, @Nullable String msg2, @Nullable Throwable tr5) {
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public boolean isColorLevel() {
        return false;
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void log(@Nullable String[] tag, int level, @Nullable String msg2, @Nullable Throwable tr5) {
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void v(@Nullable String[] tag, @Nullable String msg2, @Nullable Throwable tr5) {
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void w(@Nullable String[] tag, @Nullable String msg2, @Nullable Throwable tr5) {
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void d(@Nullable String tag, @Nullable String msg2, @NotNull Object... params) {
        Intrinsics.checkParameterIsNotNull(params, "params");
        log(tag, 1, msg2, params);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void e(@Nullable String tag, @Nullable String msg2, @NotNull Object... params) {
        Intrinsics.checkParameterIsNotNull(params, "params");
        log(tag, 4, msg2, params);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void i(@Nullable String tag, @Nullable String msg2, @NotNull Object... params) {
        Intrinsics.checkParameterIsNotNull(params, "params");
        log(tag, 2, msg2, params);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void log(@Nullable String tag, int level, @Nullable String msg2, @NotNull Object... params) {
        Object m476constructorimpl;
        Intrinsics.checkParameterIsNotNull(params, "params");
        if (f364600a && msg2 != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(msg2, Arrays.copyOf(new Object[]{params}, 1));
                Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
                m476constructorimpl = Result.m476constructorimpl(format);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null) {
                m476constructorimpl = "";
            }
            log(tag, level, (String) m476constructorimpl);
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void v(@Nullable String tag, @Nullable String msg2, @NotNull Object... params) {
        Intrinsics.checkParameterIsNotNull(params, "params");
        log(tag, 0, msg2, params);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void w(@Nullable String tag, @Nullable String msg2, @NotNull Object... params) {
        Intrinsics.checkParameterIsNotNull(params, "params");
        log(tag, 3, msg2, params);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void d(@Nullable String tag, @Nullable String msg2) {
        log(tag, 1, msg2);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void e(@Nullable String tag, @Nullable String msg2) {
        log(tag, 4, msg2);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void i(@Nullable String tag, @Nullable String msg2) {
        log(tag, 2, msg2);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void v(@Nullable String tag, @Nullable String msg2) {
        log(tag, 0, msg2);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void w(@Nullable String tag, @Nullable String msg2) {
        log(tag, 3, msg2);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void d(@Nullable String tag, @Nullable String msg2, @Nullable Throwable tr5) {
        log(tag, 1, msg2, tr5);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void e(@Nullable String tag, @Nullable String msg2, @Nullable Throwable tr5) {
        log(tag, 4, msg2, tr5);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void i(@Nullable String tag, @Nullable String msg2, @Nullable Throwable tr5) {
        log(tag, 2, msg2, tr5);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void v(@Nullable String tag, @Nullable String msg2, @Nullable Throwable tr5) {
        log(tag, 0, msg2, tr5);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void w(@Nullable String tag, @Nullable String msg2, @Nullable Throwable tr5) {
        log(tag, 3, msg2, tr5);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void log(@Nullable String tag, int level, @Nullable String msg2) {
        log(tag, level, msg2, (Throwable) null);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void log(@Nullable String tag, int level, @Nullable String msg2, @Nullable Throwable tr5) {
        if (f364600a && msg2 != null) {
            if (tr5 == null) {
                if (level == 0) {
                    Log.v(tag, msg2);
                    return;
                }
                if (level == 1) {
                    Log.d(tag, msg2);
                    return;
                }
                if (level == 2) {
                    Log.i(tag, msg2);
                    return;
                } else if (level == 3) {
                    Log.w(tag, msg2);
                    return;
                } else {
                    if (level != 4) {
                        return;
                    }
                    Log.e(tag, msg2);
                    return;
                }
            }
            if (level == 0) {
                Log.v(tag, msg2, tr5);
                return;
            }
            if (level == 1) {
                Log.d(tag, msg2, tr5);
                return;
            }
            if (level == 2) {
                Log.i(tag, msg2, tr5);
            } else if (level == 3) {
                Log.w(tag, msg2, tr5);
            } else {
                if (level != 4) {
                    return;
                }
                Log.e(tag, msg2, tr5);
            }
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void flushLog() {
    }
}
