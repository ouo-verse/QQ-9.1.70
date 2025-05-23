package com.tencent.android.gldrawable.api;

import android.app.Application;
import android.content.Context;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0005H&J\u0016\u0010\u0015\u001a\u00020\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0017H&J\u0016\u0010\u0018\u001a\u00020\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0017H&J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005H&\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/android/gldrawable/api/ILoadUtils;", "", "checkCRC", "", "f1", "Ljava/io/File;", "f2", "copyFile", "", TtmlNode.ATTR_TTS_ORIGIN, "dst", "deleteFilesInDirectory", QzoneZipCacheHelper.DIR, "getApkFile", "context", "Landroid/content/Context;", "getApplication", "Landroid/app/Application;", "getReport", "Lcom/tencent/android/gldrawable/api/IReporter;", "getTestApkFile", "postSubTask", "block", "Lkotlin/Function0;", "postUITask", "showTestToast", "toast", "", "unzipFile", "dstDir", "api_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public interface ILoadUtils {
    boolean checkCRC(@NotNull File f16, @NotNull File f26);

    void copyFile(@NotNull File origin, @NotNull File dst) throws Exception;

    void deleteFilesInDirectory(@NotNull File dir) throws Exception;

    @NotNull
    File getApkFile(@NotNull Context context);

    @NotNull
    Application getApplication();

    @NotNull
    IReporter getReport();

    @NotNull
    File getTestApkFile();

    void postSubTask(@NotNull Function0<Unit> block);

    void postUITask(@NotNull Function0<Unit> block);

    void showTestToast(@NotNull Context context, @NotNull String toast);

    void unzipFile(@NotNull File origin, @NotNull File dstDir) throws Exception;
}
