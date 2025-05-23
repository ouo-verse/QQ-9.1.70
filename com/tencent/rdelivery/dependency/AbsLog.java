package com.tencent.rdelivery.dependency;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.raft.codegenmeta.utils.RLog;
import com.tencent.raft.standard.log.IRLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0010\b&\u0018\u00002\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0006H&J.\u0010\u000e\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH&J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J;\u0010\u0016\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u0015\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00140\u0013\"\u0004\u0018\u00010\u0014H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0016\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J&\u0010\u0016\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J5\u0010\u0016\u001a\u00020\n2\u0010\u0010\u0018\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u00132\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0019J;\u0010\u001a\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u0015\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00140\u0013\"\u0004\u0018\u00010\u0014H\u0016\u00a2\u0006\u0004\b\u001a\u0010\u0017J\u001c\u0010\u001a\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J&\u0010\u001a\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J5\u0010\u001a\u001a\u00020\n2\u0010\u0010\u0018\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u00132\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0004\b\u001a\u0010\u0019J;\u0010\u001b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u0015\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00140\u0013\"\u0004\u0018\u00010\u0014H\u0016\u00a2\u0006\u0004\b\u001b\u0010\u0017J\u001c\u0010\u001b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J&\u0010\u001b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J5\u0010\u001b\u001a\u00020\n2\u0010\u0010\u0018\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u00132\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0004\b\u001b\u0010\u0019J;\u0010\u001c\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u0015\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00140\u0013\"\u0004\u0018\u00010\u0014H\u0016\u00a2\u0006\u0004\b\u001c\u0010\u0017J\u001c\u0010\u001c\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J&\u0010\u001c\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J5\u0010\u001c\u001a\u00020\n2\u0010\u0010\u0018\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u00132\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0004\b\u001c\u0010\u0019J;\u0010\u001d\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u0015\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00140\u0013\"\u0004\u0018\u00010\u0014H\u0016\u00a2\u0006\u0004\b\u001d\u0010\u0017J\u001c\u0010\u001d\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J&\u0010\u001d\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J5\u0010\u001d\u001a\u00020\n2\u0010\u0010\u0018\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u00132\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0004\b\u001d\u0010\u0019JC\u0010\u001e\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u0015\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00140\u0013\"\u0004\u0018\u00010\u0014H\u0016\u00a2\u0006\u0004\b\u001e\u0010\u001fJ=\u0010\u001e\u001a\u00020\n2\u0010\u0010\u0018\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u00132\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0004\b\u001e\u0010 J$\u0010\u001e\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J.\u0010\u001e\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006$"}, d2 = {"Lcom/tencent/rdelivery/dependency/AbsLog;", "Lcom/tencent/raft/standard/log/IRLog;", "", "levelVale", "Lcom/tencent/rdelivery/dependency/AbsLog$Level;", "a", "", "tag", "logLevel", "msg", "", "b", "", "throwable", "c", "", "isColorLevel", "flushLog", "format", "", "", "args", "v", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "([Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "d", "i", "w", "e", "log", "(Ljava/lang/String;ILjava/lang/String;[Ljava/lang/Object;)V", "([Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V", "<init>", "()V", "Level", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public abstract class AbsLog implements IRLog {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/rdelivery/dependency/AbsLog$Level;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "VERBOSE", "DEBUG", "INFO", "WARN", RLog.ERROR, "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes25.dex */
    public enum Level {
        VERBOSE(0),
        DEBUG(1),
        INFO(2),
        WARN(3),
        ERROR(4);

        private final int value;

        Level(int i3) {
            this.value = i3;
        }

        public final int getValue() {
            return this.value;
        }
    }

    private final Level a(int levelVale) {
        Level level = Level.VERBOSE;
        if (levelVale != level.getValue()) {
            Level level2 = Level.DEBUG;
            if (levelVale != level2.getValue()) {
                level2 = Level.INFO;
                if (levelVale != level2.getValue()) {
                    level2 = Level.WARN;
                    if (levelVale != level2.getValue()) {
                        level2 = Level.ERROR;
                        if (levelVale != level2.getValue()) {
                            return level;
                        }
                    }
                }
            }
            return level2;
        }
        return level;
    }

    public abstract void b(@Nullable String tag, @NotNull Level logLevel, @Nullable String msg2);

    public abstract void c(@Nullable String tag, @NotNull Level logLevel, @Nullable String msg2, @Nullable Throwable throwable);

    @Override // com.tencent.raft.standard.log.IRLog
    public void d(@Nullable String tag, @Nullable String format, @NotNull Object... args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        if (format != null) {
            Level level = Level.DEBUG;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Object[] copyOf = Arrays.copyOf(args, args.length);
            String format2 = String.format(format, Arrays.copyOf(copyOf, copyOf.length));
            Intrinsics.checkExpressionValueIsNotNull(format2, "java.lang.String.format(format, *args)");
            b(tag, level, format2);
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void e(@Nullable String tag, @Nullable String format, @NotNull Object... args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        if (format != null) {
            Level level = Level.ERROR;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Object[] copyOf = Arrays.copyOf(args, args.length);
            String format2 = String.format(format, Arrays.copyOf(copyOf, copyOf.length));
            Intrinsics.checkExpressionValueIsNotNull(format2, "java.lang.String.format(format, *args)");
            b(tag, level, format2);
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void i(@Nullable String tag, @Nullable String format, @NotNull Object... args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        if (format != null) {
            Level level = Level.INFO;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Object[] copyOf = Arrays.copyOf(args, args.length);
            String format2 = String.format(format, Arrays.copyOf(copyOf, copyOf.length));
            Intrinsics.checkExpressionValueIsNotNull(format2, "java.lang.String.format(format, *args)");
            b(tag, level, format2);
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public boolean isColorLevel() {
        return false;
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void log(@Nullable String tag, int logLevel, @Nullable String format, @NotNull Object... args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        if (format != null) {
            Level a16 = a(logLevel);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Object[] copyOf = Arrays.copyOf(args, args.length);
            String format2 = String.format(format, Arrays.copyOf(copyOf, copyOf.length));
            Intrinsics.checkExpressionValueIsNotNull(format2, "java.lang.String.format(format, *args)");
            b(tag, a16, format2);
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void v(@Nullable String tag, @Nullable String format, @NotNull Object... args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        if (format != null) {
            Level level = Level.VERBOSE;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Object[] copyOf = Arrays.copyOf(args, args.length);
            String format2 = String.format(format, Arrays.copyOf(copyOf, copyOf.length));
            Intrinsics.checkExpressionValueIsNotNull(format2, "java.lang.String.format(format, *args)");
            b(tag, level, format2);
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void w(@Nullable String tag, @Nullable String format, @NotNull Object... args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        if (format != null) {
            Level level = Level.WARN;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Object[] copyOf = Arrays.copyOf(args, args.length);
            String format2 = String.format(format, Arrays.copyOf(copyOf, copyOf.length));
            Intrinsics.checkExpressionValueIsNotNull(format2, "java.lang.String.format(format, *args)");
            b(tag, level, format2);
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void d(@Nullable String tag, @Nullable String msg2) {
        b(tag, Level.DEBUG, msg2);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void e(@Nullable String tag, @Nullable String msg2) {
        b(tag, Level.ERROR, msg2);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void i(@Nullable String tag, @Nullable String msg2) {
        b(tag, Level.INFO, msg2);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void log(@Nullable String tag, int logLevel, @Nullable String msg2) {
        b(tag, a(logLevel), msg2);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void v(@Nullable String tag, @Nullable String msg2) {
        b(tag, Level.VERBOSE, msg2);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void w(@Nullable String tag, @Nullable String msg2) {
        b(tag, Level.WARN, msg2);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void d(@Nullable String tag, @Nullable String msg2, @Nullable Throwable throwable) {
        c(tag, Level.DEBUG, msg2, throwable);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void e(@Nullable String tag, @Nullable String msg2, @Nullable Throwable throwable) {
        c(tag, Level.ERROR, msg2, throwable);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void i(@Nullable String tag, @Nullable String msg2, @Nullable Throwable throwable) {
        c(tag, Level.INFO, msg2, throwable);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void log(@Nullable String tag, int logLevel, @Nullable String msg2, @Nullable Throwable throwable) {
        c(tag, a(logLevel), msg2, throwable);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void v(@Nullable String tag, @Nullable String msg2, @Nullable Throwable throwable) {
        c(tag, Level.VERBOSE, msg2, throwable);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void w(@Nullable String tag, @Nullable String msg2, @Nullable Throwable throwable) {
        c(tag, Level.WARN, msg2, throwable);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void d(@Nullable String[] tags, @Nullable String msg2, @Nullable Throwable throwable) {
        if (tags != null) {
            for (String str : tags) {
                c(str, Level.DEBUG, msg2, throwable);
            }
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void e(@Nullable String[] tags, @Nullable String msg2, @Nullable Throwable throwable) {
        if (tags != null) {
            for (String str : tags) {
                c(str, Level.ERROR, msg2, throwable);
            }
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void i(@Nullable String[] tags, @Nullable String msg2, @Nullable Throwable throwable) {
        if (tags != null) {
            for (String str : tags) {
                c(str, Level.INFO, msg2, throwable);
            }
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void log(@Nullable String[] tags, int logLevel, @Nullable String msg2, @Nullable Throwable throwable) {
        if (tags != null) {
            for (String str : tags) {
                c(str, a(logLevel), msg2, throwable);
            }
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void v(@Nullable String[] tags, @Nullable String msg2, @Nullable Throwable throwable) {
        if (tags != null) {
            for (String str : tags) {
                c(str, Level.VERBOSE, msg2, throwable);
            }
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void w(@Nullable String[] tags, @Nullable String msg2, @Nullable Throwable throwable) {
        if (tags != null) {
            for (String str : tags) {
                c(str, Level.WARN, msg2, throwable);
            }
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void flushLog() {
    }
}
