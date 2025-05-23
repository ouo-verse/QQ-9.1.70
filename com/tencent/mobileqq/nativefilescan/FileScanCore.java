package com.tencent.mobileqq.nativefilescan;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0014B\u0011\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0016\u0010\u0017JA\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0082 JI\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0082 J6\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bJ>\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bR\u0016\u0010\n\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/nativefilescan/FileScanCore;", "", "", "path", "", "ignoreHideDir", "recursive", "Lcom/tencent/mobileqq/nativefilescan/DirSizeData;", "sizeData", "Lcom/tencent/mobileqq/nativefilescan/ILogger;", "logger", "Lcom/tencent/mobileqq/nativefilescan/Callback;", "callback", "", "getDirSize", "inFilter", "outFilter", "getTargetFormatFileList", "d", "e", "a", "Lcom/tencent/mobileqq/nativefilescan/ILogger;", "<init>", "(Lcom/tencent/mobileqq/nativefilescan/ILogger;)V", "core_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes15.dex */
public final class FileScanCore {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private static ILogger f252483b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile FileScanCore f252484c;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ILogger logger;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/nativefilescan/FileScanCore$a;", "", "Lcom/tencent/mobileqq/nativefilescan/ILogger;", "logger", "Lcom/tencent/mobileqq/nativefilescan/FileScanCore;", "a", "Lcom/tencent/mobileqq/nativefilescan/ILogger;", "getLogger", "()Lcom/tencent/mobileqq/nativefilescan/ILogger;", "c", "(Lcom/tencent/mobileqq/nativefilescan/ILogger;)V", "INSTANCE", "Lcom/tencent/mobileqq/nativefilescan/FileScanCore;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "core_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.mobileqq.nativefilescan.FileScanCore$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this);
        }

        public static /* synthetic */ FileScanCore b(Companion companion, ILogger iLogger, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                iLogger = null;
            }
            return companion.a(iLogger);
        }

        @NotNull
        public final FileScanCore a(@Nullable ILogger logger) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                FileScanCore fileScanCore = FileScanCore.f252484c;
                if (fileScanCore == null) {
                    synchronized (this) {
                        fileScanCore = FileScanCore.f252484c;
                        if (fileScanCore == null) {
                            fileScanCore = new FileScanCore(logger);
                            FileScanCore.f252484c = fileScanCore;
                            FileScanCore.INSTANCE.c(logger);
                        }
                    }
                }
                return fileScanCore;
            }
            return (FileScanCore) iPatchRedirector.redirect((short) 3, (Object) this, (Object) logger);
        }

        public final void c(@Nullable ILogger iLogger) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                FileScanCore.f252483b = iLogger;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) iLogger);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        String stackTraceToString;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8029);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        INSTANCE = new Companion(null);
        try {
            System.loadLibrary("nativefilescan");
        } catch (UnsatisfiedLinkError e16) {
            ILogger iLogger = f252483b;
            if (iLogger != null) {
                stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
                iLogger.e("FileScanCore", stackTraceToString);
            }
        }
    }

    public FileScanCore(@Nullable ILogger iLogger) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iLogger);
        } else {
            this.logger = iLogger;
        }
    }

    private final native void getDirSize(String path, boolean ignoreHideDir, boolean recursive, DirSizeData sizeData, ILogger logger, Callback callback);

    private final native void getTargetFormatFileList(String path, boolean ignoreHideDir, boolean recursive, ILogger logger, String inFilter, String outFilter, Callback callback);

    public final void d(@NotNull String path, boolean ignoreHideDir, boolean recursive, @NotNull DirSizeData sizeData, @Nullable Callback callback) {
        CharSequence trim;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, path, Boolean.valueOf(ignoreHideDir), Boolean.valueOf(recursive), sizeData, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(sizeData, "sizeData");
        trim = StringsKt__StringsKt.trim((CharSequence) path);
        String obj = trim.toString();
        if (TextUtils.isEmpty(obj)) {
            ILogger iLogger = this.logger;
            if (iLogger != null) {
                iLogger.d("FileScanCore", "FileScanCore::getDirSize invalid path: " + path);
                return;
            }
            return;
        }
        getDirSize(obj, ignoreHideDir, recursive, sizeData, this.logger, callback);
    }

    public final void e(@NotNull String path, boolean ignoreHideDir, boolean recursive, @NotNull String inFilter, @NotNull String outFilter, @Nullable Callback callback) {
        CharSequence trim;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, path, Boolean.valueOf(ignoreHideDir), Boolean.valueOf(recursive), inFilter, outFilter, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(inFilter, "inFilter");
        Intrinsics.checkNotNullParameter(outFilter, "outFilter");
        trim = StringsKt__StringsKt.trim((CharSequence) path);
        if (TextUtils.isEmpty(trim.toString())) {
            ILogger iLogger = this.logger;
            if (iLogger != null) {
                iLogger.d("FileScanCore", "FileScanCore::getDirSize invalid path: " + path);
                return;
            }
            return;
        }
        getTargetFormatFileList(path, ignoreHideDir, recursive, this.logger, inFilter, outFilter, callback);
    }
}
