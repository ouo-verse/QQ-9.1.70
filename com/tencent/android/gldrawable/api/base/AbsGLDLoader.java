package com.tencent.android.gldrawable.api.base;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.android.gldrawable.api.GLDrawableApi;
import com.tencent.android.gldrawable.api.IGLDrawableLoader;
import com.tencent.android.gldrawable.api.ILoaderCallback;
import com.tencent.android.gldrawable.api.IReporter;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import dalvik.system.DexClassLoader;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0002J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rH\u0002J\b\u0010\u001c\u001a\u00020\u0006H\u0002J\b\u0010\u001d\u001a\u00020\u0006H\u0002J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020#H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u0006X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006%"}, d2 = {"Lcom/tencent/android/gldrawable/api/base/AbsGLDLoader;", "Lcom/tencent/android/gldrawable/api/IGLDrawableLoader;", "()V", "classLoader", "Ldalvik/system/DexClassLoader;", "isLoaded", "", "()Z", "setLoaded", "(Z)V", "isLoading", "isStatic", "libRootDir", "Ljava/io/File;", "getLibRootDir", "()Ljava/io/File;", "libRootDir$delegate", "Lkotlin/Lazy;", "fakeLoadApk", "", "callback", "Lcom/tencent/android/gldrawable/api/ILoaderCallback;", "getClassLoader", "Ljava/lang/ClassLoader;", "getInstallRoot", "initClassLoader", "installRoot", "apkFile", "is64Bit", "isX86", "loadSync", "onLoadSucess", "syncDoLoadApk", "waitDownloadFinished", "context", "Landroid/content/Context;", "Companion", "api_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public abstract class AbsGLDLoader implements IGLDrawableLoader {
    private static final String APK_NAME = "gldrawable.apk";
    private static final String OPT_DIT = "opt";
    private static final int WAIT_DOWNLOAD = 5000;
    private DexClassLoader classLoader;
    private boolean isLoaded;
    private boolean isLoading;
    private final boolean isStatic;

    /* renamed from: libRootDir$delegate, reason: from kotlin metadata */
    private final Lazy libRootDir;

    public AbsGLDLoader() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<File>() { // from class: com.tencent.android.gldrawable.api.base.AbsGLDLoader$libRootDir$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final File invoke() {
                return new File(AbsGLDLoader.this.getLoaderUtils().getApplication().getFilesDir(), "gldrawablelib");
            }
        });
        this.libRootDir = lazy;
    }

    private final void fakeLoadApk(ILoaderCallback callback) {
        if (getIsLoaded()) {
            callback.onLoadSucceed();
        } else {
            callback.onLoadFailed();
        }
    }

    private final File getInstallRoot() {
        if (!getLibRootDir().exists()) {
            getLibRootDir().mkdirs();
        }
        return getLibRootDir();
    }

    private final File getLibRootDir() {
        return (File) this.libRootDir.getValue();
    }

    private final DexClassLoader initClassLoader(File installRoot, File apkFile) throws Exception {
        File file;
        if (installRoot.exists() && apkFile.exists()) {
            File file2 = new File(installRoot, APK_NAME);
            if (!getLoaderUtils().checkCRC(file2, apkFile)) {
                getLoaderUtils().deleteFilesInDirectory(installRoot);
                getLoaderUtils().copyFile(apkFile, file2);
                getLoaderUtils().unzipFile(file2, installRoot);
            }
            if (!isX86()) {
                if (!is64Bit()) {
                    file = new File(installRoot, "/lib/armeabi-v7a");
                } else {
                    file = new File(installRoot, "/lib/arm64-v8a");
                }
            } else if (!is64Bit()) {
                file = new File(installRoot, "/lib/x86");
            } else {
                file = new File(installRoot, "/lib/x86_64");
            }
            if (file.exists() && file.isDirectory()) {
                File file3 = new File(installRoot, OPT_DIT);
                if (file3.exists()) {
                    getLoaderUtils().deleteFilesInDirectory(file3);
                }
                if (!file3.exists()) {
                    file3.mkdirs();
                }
                if (file3.exists() && file3.isDirectory()) {
                    String absolutePath = file2.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath, "installFile.absolutePath");
                    String absolutePath2 = file3.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath2, "optimizedDirectory.absolutePath");
                    String absolutePath3 = file.getAbsolutePath();
                    ClassLoader classLoader = AbsGLDLoader.class.getClassLoader();
                    Intrinsics.checkNotNull(classLoader);
                    Intrinsics.checkNotNullExpressionValue(classLoader, "AbsGLDLoader::class.java.classLoader!!");
                    return new GLDClassLoader(absolutePath, absolutePath2, absolutePath3, classLoader);
                }
            }
        }
        return null;
    }

    private final boolean is64Bit() {
        return Process.is64Bit();
    }

    private final boolean isX86() {
        boolean z16;
        boolean contains$default;
        boolean equals;
        try {
            String abi = Build.CPU_ABI;
            Intrinsics.checkNotNullExpressionValue(abi, "abi");
            if (abi.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                equals = StringsKt__StringsJVMKt.equals(ResourceAttributes.HostArchValues.X86, abi, true);
                if (equals) {
                    return true;
                }
            }
            for (String platform : Build.SUPPORTED_ABIS) {
                if (!TextUtils.isEmpty(platform)) {
                    Intrinsics.checkNotNullExpressionValue(platform, "platform");
                    if (platform != null) {
                        String lowerCase = platform.toLowerCase();
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                        contains$default = StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) ResourceAttributes.HostArchValues.X86, false, 2, (Object) null);
                        if (contains$default) {
                            return true;
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00bb, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b8, code lost:
    
        if (getIsLoaded() == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void syncDoLoadApk(ILoaderCallback callback) {
        try {
            try {
                Application application = getLoaderUtils().getApplication();
                if (!waitDownloadFinished(application)) {
                    IReporter.DefaultImpls.report$default(GLDrawableApi.INSTANCE.getLogger$api_release(), "gldrawable_main_init", "error", "apk not exists", 0L, 8, null);
                    if (getIsLoaded()) {
                        callback.onLoadSucceed();
                        onLoadSucess();
                        return;
                    } else {
                        callback.onLoadFailed();
                        return;
                    }
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                DexClassLoader initClassLoader = initClassLoader(getInstallRoot(), getLoaderUtils().getApkFile(application));
                if (initClassLoader != null) {
                    this.classLoader = initClassLoader;
                    setLoaded(true);
                    GLDrawableApi.INSTANCE.getLogger$api_release().report("gldrawable_main_init", "sucess", "", SystemClock.uptimeMillis() - uptimeMillis);
                } else {
                    IReporter.DefaultImpls.report$default(GLDrawableApi.INSTANCE.getLogger$api_release(), "gldrawable_main_init", "error", "initClassLoader error", 0L, 8, null);
                }
            } catch (Exception e16) {
                IReporter.DefaultImpls.report$default(GLDrawableApi.INSTANCE.getLogger$api_release(), "gldrawable_main_init", "error", String.valueOf(e16.getMessage()), 0L, 8, null);
                e16.printStackTrace();
            }
        } finally {
            if (getIsLoaded()) {
                callback.onLoadSucceed();
                onLoadSucess();
            } else {
                callback.onLoadFailed();
            }
        }
    }

    private final boolean waitDownloadFinished(Context context) {
        File apkFile = getLoaderUtils().getApkFile(context);
        long uptimeMillis = SystemClock.uptimeMillis();
        GLDrawableApi.INSTANCE.getLogger$api_release().logI("load apk: " + apkFile.getAbsoluteFile());
        while (!apkFile.exists()) {
            SystemClock.sleep(100L);
            if (SystemClock.uptimeMillis() - uptimeMillis >= 5000) {
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.android.gldrawable.api.IGLDrawableLoader
    @Nullable
    public ClassLoader getClassLoader() {
        return this.classLoader;
    }

    @Override // com.tencent.android.gldrawable.api.IGLDrawableLoader
    /* renamed from: isLoaded, reason: from getter */
    public boolean getIsLoaded() {
        return this.isLoaded;
    }

    @Override // com.tencent.android.gldrawable.api.IGLDrawableLoader
    /* renamed from: isStatic, reason: from getter */
    public boolean getIsStatic() {
        return this.isStatic;
    }

    @Override // com.tencent.android.gldrawable.api.IGLDrawableLoader
    public void loadSync(@NotNull ILoaderCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.isLoading = true;
        try {
            if (getIsLoaded()) {
                fakeLoadApk(callback);
                return;
            }
            synchronized (AbsGLDLoader.class) {
                if (getIsLoaded()) {
                    fakeLoadApk(callback);
                } else {
                    syncDoLoadApk(callback);
                    Unit unit = Unit.INSTANCE;
                }
            }
        } finally {
            this.isLoading = false;
        }
    }

    public void onLoadSucess() {
        GLDrawableApi.config().setLogger(GLDrawableApi.INSTANCE.getLogger$api_release());
    }

    public void setLoaded(boolean z16) {
        this.isLoaded = z16;
    }
}
