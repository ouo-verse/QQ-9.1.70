package com.tencent.qqmini.sdk.utils;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0082 J\u0013\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0082 J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002R\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqmini/sdk/utils/BrotliUtil;", "", "", "inPath", "", "a", "outPath", "", "nativeDecompress", "nativeDecompressToBytes", "soPath", "", "b", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isLoaded", "<init>", "()V", "lib_minisdk_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class BrotliUtil {

    /* renamed from: b, reason: collision with root package name */
    public static final BrotliUtil f348352b = new BrotliUtil();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final AtomicBoolean isLoaded = new AtomicBoolean(false);

    BrotliUtil() {
    }

    @JvmStatic
    @Nullable
    public static final byte[] a(@NotNull String inPath) {
        Intrinsics.checkParameterIsNotNull(inPath, "inPath");
        if (isLoaded.get()) {
            try {
                return f348352b.nativeDecompressToBytes(inPath);
            } catch (Throwable th5) {
                QMLog.e("BrotliUtil", "decompress: load old so, crashed.", th5);
            }
        }
        QMLog.e("BrotliUtil", "decompress: so is not loaded.");
        return null;
    }

    private final native boolean nativeDecompress(String inPath, String outPath);

    private final native byte[] nativeDecompressToBytes(String inPath);

    public final void b(@NotNull String soPath) {
        Intrinsics.checkParameterIsNotNull(soPath, "soPath");
        try {
            File file = new File(soPath);
            if (file.exists()) {
                System.load(file.getAbsolutePath());
            } else {
                System.loadLibrary(soPath);
            }
            isLoaded.set(true);
        } catch (Throwable th5) {
            QMLog.e("BrotliUtil", "loadSo failed, e=", th5);
        }
    }
}
