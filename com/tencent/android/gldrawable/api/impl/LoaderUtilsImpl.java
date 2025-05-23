package com.tencent.android.gldrawable.api.impl;

import android.app.Application;
import android.content.Context;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.android.gldrawable.api.ILoadUtils;
import com.tencent.android.gldrawable.api.IReporter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.qqsomonitor.api.ISoMonitorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.ReportInfo;
import com.tencent.mobileqq.vas.VasNtCommonReporter;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.ZipDownloadBusiness;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 #2\u00020\u0001:\u0001#B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016J\u0016\u0010\u001a\u001a\u00020\r2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u001cH\u0016J\u0016\u0010\u001d\u001a\u00020\r2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u001cH\u0016J\u0018\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006$"}, d2 = {"Lcom/tencent/android/gldrawable/api/impl/LoaderUtilsImpl;", "Lcom/tencent/android/gldrawable/api/ILoadUtils;", "()V", "isFirstLoadApk", "", "()Z", "setFirstLoadApk", "(Z)V", "checkCRC", "f1", "Ljava/io/File;", "f2", "copyFile", "", TtmlNode.ATTR_TTS_ORIGIN, "dst", "deleteFilesInDirectory", QzoneZipCacheHelper.DIR, "getApkFile", "context", "Landroid/content/Context;", "getApplication", "Landroid/app/Application;", "getReport", "Lcom/tencent/android/gldrawable/api/IReporter;", "getTestApkFile", "postSubTask", "block", "Lkotlin/Function0;", "postUITask", "showTestToast", "toast", "", "unzipFile", "dstDir", "Companion", "vas-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class LoaderUtilsImpl implements ILoadUtils {
    private static final boolean DEBUG = false;
    private boolean isFirstLoadApk = true;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void postSubTask$lambda$1(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void postUITask$lambda$0(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTestToast$lambda$2(Context context, String toast) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(toast, "$toast");
        QQToast.makeText(context, toast, 0).show();
    }

    @Override // com.tencent.android.gldrawable.api.ILoadUtils
    public boolean checkCRC(@NotNull File f16, @NotNull File f26) {
        Intrinsics.checkNotNullParameter(f16, "f1");
        Intrinsics.checkNotNullParameter(f26, "f2");
        long cRC32Value = IOUtil.getCRC32Value(f16);
        if (cRC32Value == -1) {
            return false;
        }
        long cRC32Value2 = IOUtil.getCRC32Value(f26);
        if (cRC32Value2 == -1 || cRC32Value2 != cRC32Value) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.android.gldrawable.api.ILoadUtils
    public void copyFile(@NotNull File origin, @NotNull File dst) throws Exception {
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(dst, "dst");
        if (FileUtils.copyFile(origin, dst)) {
        } else {
            throw new IOException();
        }
    }

    @Override // com.tencent.android.gldrawable.api.ILoadUtils
    public void deleteFilesInDirectory(@NotNull File dir) throws Exception {
        Intrinsics.checkNotNullParameter(dir, "dir");
        FileUtils.deleteFilesInDirectory(dir.getAbsolutePath());
    }

    @Override // com.tencent.android.gldrawable.api.ILoadUtils
    @NotNull
    public File getApkFile(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!VasToggle.isEnable(VasToggle.GLDRAWABLE, true)) {
            return new File("none");
        }
        ZipDownloadBusiness zipDownloadBusiness = (ZipDownloadBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(ZipDownloadBusiness.class);
        File gLDrawablePath = zipDownloadBusiness.getGLDrawablePath();
        Intrinsics.checkNotNullExpressionValue(gLDrawablePath, "downloadBusiness\n                .glDrawablePath");
        if (!gLDrawablePath.exists() || this.isFirstLoadApk) {
            zipDownloadBusiness.startDownload(15);
            this.isFirstLoadApk = false;
        }
        QLog.d("GLDrawable", 2, "\u5f53\u524d\u4f7f\u7528\u7684\u52a8\u6001\u5305\u8def\u5f84\uff1a" + gLDrawablePath + " exists=" + gLDrawablePath.exists());
        return gLDrawablePath;
    }

    @Override // com.tencent.android.gldrawable.api.ILoadUtils
    @NotNull
    public Application getApplication() {
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        return context;
    }

    @Override // com.tencent.android.gldrawable.api.ILoadUtils
    @NotNull
    public IReporter getReport() {
        final String str = "GLDrawable";
        return new IReporter() { // from class: com.tencent.android.gldrawable.api.impl.LoaderUtilsImpl$getReport$1
            @Override // com.tencent.android.gldrawable.api.IReporter
            public void logE(@NotNull String s16) {
                Intrinsics.checkNotNullParameter(s16, "s");
                QLog.e(str, 1, s16);
            }

            @Override // com.tencent.android.gldrawable.api.IReporter
            public void logI(@NotNull String s16) {
                Intrinsics.checkNotNullParameter(s16, "s");
                if (QLog.isDebugVersion()) {
                    QLog.i(str, 1, s16);
                }
            }

            @Override // com.tencent.android.gldrawable.api.IReporter
            public void report(@NotNull String event, @NotNull String statusCode, @NotNull String statusMsg, long elapse) {
                Intrinsics.checkNotNullParameter(event, "event");
                Intrinsics.checkNotNullParameter(statusCode, "statusCode");
                Intrinsics.checkNotNullParameter(statusMsg, "statusMsg");
                try {
                    ReportInfo.report$default(VasNtCommonReporter.getHistoryFeature("gldrawable").setValue2(event).setValue3(statusCode).setValue4(statusMsg).setNum1(elapse), false, 1, null);
                } catch (Exception e16) {
                    QLog.e(str, 1, "report exception", e16);
                }
            }

            @Override // com.tencent.android.gldrawable.api.IReporter
            public void logE(@NotNull String s16, @NotNull Throwable e16) {
                Intrinsics.checkNotNullParameter(s16, "s");
                Intrinsics.checkNotNullParameter(e16, "e");
                QLog.e(str, 1, s16, e16);
            }
        };
    }

    @Override // com.tencent.android.gldrawable.api.ILoadUtils
    @NotNull
    public File getTestApkFile() {
        return new File(getApplication().getExternalFilesDir(""), "gldrawable.apk");
    }

    /* renamed from: isFirstLoadApk, reason: from getter */
    public final boolean getIsFirstLoadApk() {
        return this.isFirstLoadApk;
    }

    @Override // com.tencent.android.gldrawable.api.ILoadUtils
    public void postSubTask(@NotNull final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.android.gldrawable.api.impl.c
            @Override // java.lang.Runnable
            public final void run() {
                LoaderUtilsImpl.postSubTask$lambda$1(Function0.this);
            }
        });
    }

    @Override // com.tencent.android.gldrawable.api.ILoadUtils
    public void postUITask(@NotNull final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.android.gldrawable.api.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                LoaderUtilsImpl.postUITask$lambda$0(Function0.this);
            }
        });
    }

    public final void setFirstLoadApk(boolean z16) {
        this.isFirstLoadApk = z16;
    }

    @Override // com.tencent.android.gldrawable.api.ILoadUtils
    public void showTestToast(@NotNull final Context context, @NotNull final String toast) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toast, "toast");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.android.gldrawable.api.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                LoaderUtilsImpl.showTestToast$lambda$2(context, toast);
            }
        });
    }

    @Override // com.tencent.android.gldrawable.api.ILoadUtils
    public void unzipFile(@NotNull File origin, @NotNull File dstDir) throws Exception {
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(dstDir, "dstDir");
        FileUtils.uncompressZip(origin.getAbsolutePath(), dstDir.getAbsolutePath(), false, Pattern.compile(".*\\.so$"));
        ((ISoMonitorApi) QRoute.api(ISoMonitorApi.class)).registerSoFile(MobileQQ.sMobileQQ, new File(dstDir, "lib/arm64-v8a/libgldrawable.so"));
    }
}
