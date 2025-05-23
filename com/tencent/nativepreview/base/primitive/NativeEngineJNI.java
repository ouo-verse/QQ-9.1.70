package com.tencent.nativepreview.base.primitive;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.nativepreview.service.ILogger;
import com.tencent.nativepreview.service.IReporter;
import com.tencent.nativepreview.service.drive.DriveUploadCallback;
import com.tencent.nativepreview.service.drive.DriveUploadRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/nativepreview/base/primitive/NativeEngineJNI;", "", "()V", "Companion", "native_preview_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class NativeEngineJNI {
    static IPatchRedirector $redirector_;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0087 J\u0011\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0087 J\t\u0010\u000f\u001a\u00020\fH\u0087 J\t\u0010\u0010\u001a\u00020\u000eH\u0087 J\u0011\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\fH\u0087 J\u0011\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0087 J\u0011\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\bH\u0087 J\u0011\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0087 J\u0019\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0087 \u00a8\u0006 "}, d2 = {"Lcom/tencent/nativepreview/base/primitive/NativeEngineJNI$Companion;", "", "()V", "createEditor", "", "shell", "viewContext", "docType", "", "useNextEngine", "", QAdRewardDefine$VideoParams.CACHE_PATH, "", "destroyEditor", "", "getVersionInfo", "initJNI", "loadICUData", "path", "setLogger", "log", "Lcom/tencent/nativepreview/service/ILogger;", "setLoggerLevel", "level", "setReporter", "report", "Lcom/tencent/nativepreview/service/IReporter;", "uploadToDrive", "req", "Lcom/tencent/nativepreview/service/drive/DriveUploadRequest;", "callback", "Lcom/tencent/nativepreview/service/drive/DriveUploadCallback;", "native_preview_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
                return;
            }
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) defaultConstructorMarker);
        }

        @JvmStatic
        @Keep
        public final long createEditor(long shell, long viewContext, int docType, boolean useNextEngine, @NotNull String cachePath) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, this, Long.valueOf(shell), Long.valueOf(viewContext), Integer.valueOf(docType), Boolean.valueOf(useNextEngine), cachePath)).longValue();
            }
            return NativeEngineJNI.createEditor(shell, viewContext, docType, useNextEngine, cachePath);
        }

        @JvmStatic
        @Keep
        public final void destroyEditor(long shell) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, shell);
            } else {
                NativeEngineJNI.destroyEditor(shell);
            }
        }

        @JvmStatic
        @Keep
        @NotNull
        public final String getVersionInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return NativeEngineJNI.getVersionInfo();
        }

        @JvmStatic
        @Keep
        public final void initJNI() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                NativeEngineJNI.initJNI();
            }
        }

        @JvmStatic
        @Keep
        public final void loadICUData(@NotNull String path) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) path);
            } else {
                NativeEngineJNI.loadICUData(path);
            }
        }

        @JvmStatic
        @Keep
        public final void setLogger(@NotNull ILogger log) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) log);
            } else {
                NativeEngineJNI.setLogger(log);
            }
        }

        @JvmStatic
        @Keep
        public final void setLoggerLevel(int level) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, level);
            } else {
                NativeEngineJNI.setLoggerLevel(level);
            }
        }

        @JvmStatic
        @Keep
        public final void setReporter(@NotNull IReporter report) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) report);
            } else {
                NativeEngineJNI.setReporter(report);
            }
        }

        @JvmStatic
        @Keep
        public final void uploadToDrive(@NotNull DriveUploadRequest req, @NotNull DriveUploadCallback callback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) req, (Object) callback);
            } else {
                NativeEngineJNI.uploadToDrive(req, callback);
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14555);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        Companion companion = new Companion(null);
        INSTANCE = companion;
        companion.initJNI();
    }

    public NativeEngineJNI() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @Keep
    public static final native long createEditor(long j3, long j16, int i3, boolean z16, @NotNull String str);

    @JvmStatic
    @Keep
    public static final native void destroyEditor(long j3);

    @JvmStatic
    @Keep
    @NotNull
    public static final native String getVersionInfo();

    @JvmStatic
    @Keep
    public static final native void initJNI();

    @JvmStatic
    @Keep
    public static final native void loadICUData(@NotNull String str);

    @JvmStatic
    @Keep
    public static final native void setLogger(@NotNull ILogger iLogger);

    @JvmStatic
    @Keep
    public static final native void setLoggerLevel(int i3);

    @JvmStatic
    @Keep
    public static final native void setReporter(@NotNull IReporter iReporter);

    @JvmStatic
    @Keep
    public static final native void uploadToDrive(@NotNull DriveUploadRequest driveUploadRequest, @NotNull DriveUploadCallback driveUploadCallback);
}
