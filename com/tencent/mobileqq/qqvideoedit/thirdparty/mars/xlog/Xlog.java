package com.tencent.mobileqq.qqvideoedit.thirdparty.mars.xlog;

import androidx.annotation.Keep;
import com.tencent.mobileqq.msf.core.f0.c.e.h;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u00c0\u0002\u0018\u00002\u00020\u0001:\u000223B\t\b\u0002\u00a2\u0006\u0004\b1\u00100J\t\u0010\u0003\u001a\u00020\u0002H\u0087 J\u0011\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0087 J\u0019\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0087 JQ\u0010\u0016\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\tH\u0087 J\u0011\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\fH\u0087 J\u0011\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0004H\u0087 J\u0011\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0004H\u0087 J\u0011\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0087 J\u0011\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0013H\u0087 J\u0011\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0013H\u0087 J+\u0010'\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00132\b\u0010&\u001a\u0004\u0018\u00010\tH\u0087 R2\u0010)\u001a\u00020\f2\u0006\u0010(\u001a\u00020\f8\u00c6\u0001@\u00c6\u0001X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b)\u0010*\u0012\u0004\b/\u00100\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/mars/xlog/Xlog;", "", "", "appenderClose", "", "isSync", "appenderFlush", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/mars/xlog/Xlog$XLoggerInfo;", "logInfo", "", "log", "logWrite", "", "level", "tag", "filename", "funcname", "line", "pid", "", "tid", "maintid", "logWrite2", "mode", "setAppenderMode", h.f248218g, "setConsoleLogOpen", "setErrLogOpen", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/mars/xlog/Xlog$XLogConfig;", "logConfig", "appenderOpen", "size", "setMaxFileSize", "duration", "setMaxAliveTime", "logPrefix", "startSec", "endSec", "tmpLogPath", "getPeriodLogs", "<set-?>", "logLevel", "I", "getLogLevel", "()I", "setLogLevel", "(I)V", "getLogLevel$annotations", "()V", "<init>", "XLogConfig", "XLoggerInfo", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class Xlog {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final Xlog f275871a = new Xlog();

    /* compiled from: P */
    @Keep
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001a\u0010!\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/mars/xlog/Xlog$XLogConfig;", "", "()V", "cachedays", "", "getCachedays", "()I", "setCachedays", "(I)V", "cachedir", "", "getCachedir", "()Ljava/lang/String;", "setCachedir", "(Ljava/lang/String;)V", "compresslevel", "getCompresslevel", "setCompresslevel", "compressmode", "getCompressmode", "setCompressmode", "level", "getLevel", "setLevel", "logdir", "getLogdir", "setLogdir", "mode", "getMode", "setMode", "nameprefix", "getNameprefix", "setNameprefix", "pubkey", "getPubkey", "setPubkey", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public static final class XLogConfig {
        private int cachedays;

        @Nullable
        private String cachedir;
        private int compresslevel;
        private int compressmode;

        @Nullable
        private String logdir;
        private int mode;

        @Nullable
        private String nameprefix;
        private int level = 2;

        @NotNull
        private String pubkey = "";

        public final int getCachedays() {
            return this.cachedays;
        }

        @Nullable
        public final String getCachedir() {
            return this.cachedir;
        }

        public final int getCompresslevel() {
            return this.compresslevel;
        }

        public final int getCompressmode() {
            return this.compressmode;
        }

        public final int getLevel() {
            return this.level;
        }

        @Nullable
        public final String getLogdir() {
            return this.logdir;
        }

        public final int getMode() {
            return this.mode;
        }

        @Nullable
        public final String getNameprefix() {
            return this.nameprefix;
        }

        @NotNull
        public final String getPubkey() {
            return this.pubkey;
        }

        public final void setCachedays(int i3) {
            this.cachedays = i3;
        }

        public final void setCachedir(@Nullable String str) {
            this.cachedir = str;
        }

        public final void setCompresslevel(int i3) {
            this.compresslevel = i3;
        }

        public final void setCompressmode(int i3) {
            this.compressmode = i3;
        }

        public final void setLevel(int i3) {
            this.level = i3;
        }

        public final void setLogdir(@Nullable String str) {
            this.logdir = str;
        }

        public final void setMode(int i3) {
            this.mode = i3;
        }

        public final void setNameprefix(@Nullable String str) {
            this.nameprefix = str;
        }

        public final void setPubkey(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.pubkey = str;
        }
    }

    /* compiled from: P */
    @Keep
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001a\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/mars/xlog/Xlog$XLoggerInfo;", "", "()V", "filename", "", "getFilename", "()Ljava/lang/String;", "setFilename", "(Ljava/lang/String;)V", "funcname", "getFuncname", "setFuncname", "level", "", "getLevel", "()I", "setLevel", "(I)V", "line", "getLine", "setLine", "maintid", "", "getMaintid", "()J", "setMaintid", "(J)V", "pid", "getPid", "setPid", "tag", "getTag", "setTag", "tid", "getTid", "setTid", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public static final class XLoggerInfo {

        @Nullable
        private String filename;

        @Nullable
        private String funcname;
        private int level;
        private int line;
        private long maintid;
        private long pid;

        @Nullable
        private String tag;
        private long tid;

        @Nullable
        public final String getFilename() {
            return this.filename;
        }

        @Nullable
        public final String getFuncname() {
            return this.funcname;
        }

        public final int getLevel() {
            return this.level;
        }

        public final int getLine() {
            return this.line;
        }

        public final long getMaintid() {
            return this.maintid;
        }

        public final long getPid() {
            return this.pid;
        }

        @Nullable
        public final String getTag() {
            return this.tag;
        }

        public final long getTid() {
            return this.tid;
        }

        public final void setFilename(@Nullable String str) {
            this.filename = str;
        }

        public final void setFuncname(@Nullable String str) {
            this.funcname = str;
        }

        public final void setLevel(int i3) {
            this.level = i3;
        }

        public final void setLine(int i3) {
            this.line = i3;
        }

        public final void setMaintid(long j3) {
            this.maintid = j3;
        }

        public final void setPid(long j3) {
            this.pid = j3;
        }

        public final void setTag(@Nullable String str) {
            this.tag = str;
        }

        public final void setTid(long j3) {
            this.tid = j3;
        }
    }

    Xlog() {
    }

    @JvmStatic
    public static final native void appenderClose();

    @JvmStatic
    public static final native void appenderFlush(boolean isSync);

    @JvmStatic
    public static final native void appenderOpen(@NotNull XLogConfig logConfig);

    public static final native int getLogLevel();

    @JvmStatic
    public static final native boolean getPeriodLogs(@NotNull String logPrefix, long startSec, long endSec, @Nullable String tmpLogPath);

    @JvmStatic
    public static final native void logWrite(@NotNull XLoggerInfo logInfo, @NotNull String log);

    @JvmStatic
    public static final native void logWrite2(int level, @NotNull String tag, @NotNull String filename, @NotNull String funcname, int line, int pid, long tid, long maintid, @NotNull String log);

    @JvmStatic
    public static final native void setAppenderMode(int mode);

    @JvmStatic
    public static final native void setConsoleLogOpen(boolean isOpen);

    @JvmStatic
    public static final native void setErrLogOpen(boolean isOpen);

    public static final native void setLogLevel(int i3);

    @JvmStatic
    public static final native void setMaxAliveTime(long duration);

    @JvmStatic
    public static final native void setMaxFileSize(long size);
}
