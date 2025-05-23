package com.tencent.qne;

import android.content.Context;
import androidx.annotation.Keep;
import com.tencent.ams.dsdk.utils.DBHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qne.model.Backend;
import com.tencent.qne.model.QneInterpreter;
import com.tencent.qne.util.Logger;
import com.tencent.qne.util.a;
import io.github.landerlyoung.jenny.NativeMethodProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@NativeProxy(allFields = false, allMethods = true)
@Keep
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J\b\u0010\u0014\u001a\u00020\u0004H\u0007J\b\u0010\u0015\u001a\u00020\u0004H\u0007J\b\u0010\u0016\u001a\u00020\u0004H\u0007J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0018\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/tencent/qne/QneFoundationHelper;", "", "()V", "TAG", "", "libraryPath", "", "mtkCachePath", "rootPath", "appendDspLibraryPath", "", "path", "findFileRecursively", DBHelper.COL_FOLDER, "suffix", "getBackend", "inferenceType", "", "getLibraryPath", WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_LIBRARY, "getMTKCachePath", "getRootPath", "getSnpeAdspLibraryPath", "init", "context", "Landroid/content/Context;", "initMTKCachePath", "isBackendSupported", "", "unzip", "zipFilePath", "folderPath", "qne_debug"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes22.dex */
public final class QneFoundationHelper {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final QneFoundationHelper INSTANCE;

    @NotNull
    private static final String TAG = "[qne]QneFoundationHelper";

    @NotNull
    private static final List<String> libraryPath;

    @NotNull
    private static String mtkCachePath;

    @NotNull
    private static String rootPath;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14376);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        INSTANCE = new QneFoundationHelper();
        rootPath = "";
        libraryPath = new ArrayList();
        mtkCachePath = "";
    }

    QneFoundationHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @Nullable
    public static final String findFileRecursively(@NotNull String folder, @NotNull String suffix) {
        Intrinsics.checkNotNullParameter(folder, "folder");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return a.e(folder, suffix);
    }

    @JvmStatic
    @Nullable
    public static final String getBackend(int inferenceType) {
        Backend d16 = QneInterpreter.f344344a.d(inferenceType);
        if (d16 == null) {
            return null;
        }
        return d16.d();
    }

    @JvmStatic
    @NotNull
    public static final String getLibraryPath(@NotNull String library) {
        boolean z16;
        Intrinsics.checkNotNullParameter(library, "library");
        List<String> list = libraryPath;
        synchronized (list) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                String e16 = a.e((String) it.next(), library);
                if (e16 != null && e16.length() != 0) {
                    z16 = false;
                    if (z16 && new File(e16).exists()) {
                        return e16;
                    }
                }
                z16 = true;
                if (z16) {
                }
            }
            Unit unit = Unit.INSTANCE;
            return "";
        }
    }

    @JvmStatic
    @NotNull
    public static final String getMTKCachePath() {
        return mtkCachePath;
    }

    @JvmStatic
    @NotNull
    public static final String getRootPath() {
        return rootPath;
    }

    @JvmStatic
    @NotNull
    public static final String getSnpeAdspLibraryPath() {
        String joinToString$default;
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(libraryPath, ";", null, null, 0, null, null, 62, null);
        return joinToString$default;
    }

    @JvmStatic
    public static final boolean isBackendSupported(int inferenceType) {
        boolean z16;
        if (QneInterpreter.f344344a.d(inferenceType) != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Logger.i(TAG, "isBackendSupported for inferenceType:" + inferenceType + ", support:" + z16);
        return z16;
    }

    @JvmStatic
    public static final boolean unzip(@NotNull String zipFilePath, @NotNull String folderPath) {
        Intrinsics.checkNotNullParameter(zipFilePath, "zipFilePath");
        Intrinsics.checkNotNullParameter(folderPath, "folderPath");
        long currentTimeMillis = System.currentTimeMillis();
        boolean h16 = a.h(zipFilePath, folderPath);
        Logger.i(TAG, "unzip " + zipFilePath + " to " + folderPath + " success:" + h16 + ", cost:" + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return h16;
    }

    @NativeMethodProxy(enabled = false)
    public final void appendDspLibraryPath(@NotNull String path) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) path);
            return;
        }
        Intrinsics.checkNotNullParameter(path, "path");
        if (path.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        List<String> list = libraryPath;
        synchronized (list) {
            if (!list.contains(path)) {
                list.add(path);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @NativeMethodProxy(enabled = false)
    public final void init(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        String absolutePath = context.getFilesDir().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "context.filesDir.absolutePath");
        rootPath = absolutePath;
        String str = context.getApplicationInfo().nativeLibraryDir;
        Intrinsics.checkNotNullExpressionValue(str, "context.applicationInfo.nativeLibraryDir");
        appendDspLibraryPath(str);
        initMTKCachePath(context);
    }

    @NativeMethodProxy(enabled = false)
    public final void initMTKCachePath(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        File file = new File(context.getCacheDir().getAbsolutePath(), "QNE");
        if (!file.exists() && !file.mkdir()) {
            return;
        }
        File file2 = new File(file, "mtk");
        if (!file2.exists() && !file2.mkdir()) {
            return;
        }
        String absolutePath = file2.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "mtkDir.absolutePath");
        mtkCachePath = absolutePath;
    }
}
