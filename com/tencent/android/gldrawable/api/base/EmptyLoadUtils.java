package com.tencent.android.gldrawable.api.base;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.android.gldrawable.api.ILoadUtils;
import com.tencent.android.gldrawable.api.IReporter;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0011H\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0011H\u0016J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u0011H\u0016J\u0016\u0010!\u001a\u00020\u00142\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00140#H\u0016J\u0016\u0010$\u001a\u00020\u00142\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00140#H\u0016J\u0018\u0010%\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020'H\u0016J\u0018\u0010(\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u0011H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f\u00a8\u0006*"}, d2 = {"Lcom/tencent/android/gldrawable/api/base/EmptyLoadUtils;", "Lcom/tencent/android/gldrawable/api/ILoadUtils;", "()V", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler$delegate", "Lkotlin/Lazy;", "workHandler", "Lcom/tencent/android/gldrawable/api/base/AutoReleaseThreadHandler;", "getWorkHandler", "()Lcom/tencent/android/gldrawable/api/base/AutoReleaseThreadHandler;", "workHandler$delegate", "checkCRC", "", "f1", "Ljava/io/File;", "f2", "copyFile", "", TtmlNode.ATTR_TTS_ORIGIN, "dst", "deleteFilesInDirectory", QzoneZipCacheHelper.DIR, "getApkFile", "context", "Landroid/content/Context;", "getApplication", "Landroid/app/Application;", "getReport", "Lcom/tencent/android/gldrawable/api/IReporter;", "getTestApkFile", "postSubTask", "block", "Lkotlin/Function0;", "postUITask", "showTestToast", "toast", "", "unzipFile", "dstDir", "api_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class EmptyLoadUtils implements ILoadUtils {

    /* renamed from: mainHandler$delegate, reason: from kotlin metadata */
    private final Lazy mainHandler;

    /* renamed from: workHandler$delegate, reason: from kotlin metadata */
    private final Lazy workHandler;

    public EmptyLoadUtils() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.android.gldrawable.api.base.EmptyLoadUtils$mainHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Handler invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
        this.mainHandler = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<AutoReleaseThreadHandler>() { // from class: com.tencent.android.gldrawable.api.base.EmptyLoadUtils$workHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AutoReleaseThreadHandler invoke() {
                return new AutoReleaseThreadHandler();
            }
        });
        this.workHandler = lazy2;
    }

    private final Handler getMainHandler() {
        return (Handler) this.mainHandler.getValue();
    }

    private final AutoReleaseThreadHandler getWorkHandler() {
        return (AutoReleaseThreadHandler) this.workHandler.getValue();
    }

    @Override // com.tencent.android.gldrawable.api.ILoadUtils
    public boolean checkCRC(@NotNull File f16, @NotNull File f26) {
        Intrinsics.checkNotNullParameter(f16, "f1");
        Intrinsics.checkNotNullParameter(f26, "f2");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.android.gldrawable.api.ILoadUtils
    public void copyFile(@NotNull File origin, @NotNull File dst) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(dst, "dst");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.android.gldrawable.api.ILoadUtils
    public void deleteFilesInDirectory(@NotNull File dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.android.gldrawable.api.ILoadUtils
    @NotNull
    public File getApkFile(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.android.gldrawable.api.ILoadUtils
    @NotNull
    public Application getApplication() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.android.gldrawable.api.ILoadUtils
    @NotNull
    public IReporter getReport() {
        final String str = "GLDrawable";
        return new IReporter() { // from class: com.tencent.android.gldrawable.api.base.EmptyLoadUtils$getReport$1
            @Override // com.tencent.android.gldrawable.api.IReporter
            public void logE(@NotNull String s16) {
                Intrinsics.checkNotNullParameter(s16, "s");
                Log.e(str, s16);
            }

            @Override // com.tencent.android.gldrawable.api.IReporter
            public void logI(@NotNull String s16) {
                Intrinsics.checkNotNullParameter(s16, "s");
                Log.i(str, s16);
            }

            @Override // com.tencent.android.gldrawable.api.IReporter
            public void report(@NotNull String event, @NotNull String statusCode, @NotNull String statusMsg, long elapse) {
                Intrinsics.checkNotNullParameter(event, "event");
                Intrinsics.checkNotNullParameter(statusCode, "statusCode");
                Intrinsics.checkNotNullParameter(statusMsg, "statusMsg");
                Log.i(str, ">>report>> " + event + TokenParser.SP + statusCode + TokenParser.SP + statusMsg);
            }

            @Override // com.tencent.android.gldrawable.api.IReporter
            public void logE(@NotNull String s16, @NotNull Throwable e16) {
                Intrinsics.checkNotNullParameter(s16, "s");
                Intrinsics.checkNotNullParameter(e16, "e");
                Log.e(str, s16, e16);
            }
        };
    }

    @Override // com.tencent.android.gldrawable.api.ILoadUtils
    @NotNull
    public File getTestApkFile() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.android.gldrawable.api.ILoadUtils
    public void postSubTask(@NotNull Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        getWorkHandler().post(new EmptyLoadUtils$sam$java_lang_Runnable$0(block));
    }

    @Override // com.tencent.android.gldrawable.api.ILoadUtils
    public void postUITask(@NotNull Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            block.invoke();
        } else {
            getMainHandler().post(new EmptyLoadUtils$sam$java_lang_Runnable$0(block));
        }
    }

    @Override // com.tencent.android.gldrawable.api.ILoadUtils
    public void showTestToast(@NotNull Context context, @NotNull String toast) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toast, "toast");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.android.gldrawable.api.ILoadUtils
    public void unzipFile(@NotNull File origin, @NotNull File dstDir) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(dstDir, "dstDir");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
