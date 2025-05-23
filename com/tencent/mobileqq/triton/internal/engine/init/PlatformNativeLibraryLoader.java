package com.tencent.mobileqq.triton.internal.engine.init;

import android.annotation.SuppressLint;
import com.tencent.mobileqq.triton.exception.ErrorCodes;
import com.tencent.mobileqq.triton.exception.TritonInitException;
import com.tencent.mobileqq.triton.filesystem.EnginePackage;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.statistic.NativeLibraryLoadStatistic;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\t\u001a\u00020\nJ.\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/engine/init/PlatformNativeLibraryLoader;", "", "()V", "TAG", "", "engineLibs", "", "loadEngineNativeLibrary", "Lcom/tencent/mobileqq/triton/statistic/NativeLibraryLoadStatistic;", "enginePackage", "Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "loadOneLibrary", "", "name", "optional", "", "list", "", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class PlatformNativeLibraryLoader {
    public static final PlatformNativeLibraryLoader INSTANCE = new PlatformNativeLibraryLoader();
    private static final String TAG = "TritonNativeLibraryLoader";
    private static final List<String> engineLibs;

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf("triton");
        engineLibs = listOf;
    }

    PlatformNativeLibraryLoader() {
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    private final void loadOneLibrary(String name, boolean optional, EnginePackage enginePackage, List<NativeLibraryLoadStatistic> list) {
        TritonInitException tritonInitException;
        boolean z16;
        File engineNativeLibrary = enginePackage.getEngineNativeLibrary(name);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (engineNativeLibrary != null) {
                System.load(engineNativeLibrary.getAbsolutePath());
            } else {
                System.loadLibrary(name);
            }
            tritonInitException = null;
        } catch (UnsatisfiedLinkError e16) {
            tritonInitException = new TritonInitException("failed to load library [" + name + "] file:[" + engineNativeLibrary + "] " + e16.getMessage(), ErrorCodes.NATIVE_LOAD_LIBRARY, e16);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (tritonInitException == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        list.add(new NativeLibraryLoadStatistic(z16, name, engineNativeLibrary, optional, currentTimeMillis2, tritonInitException));
        if (tritonInitException != null) {
            if (optional) {
                Logger.i$default(TAG, "optional library load failed, " + tritonInitException.getMessage(), null, 4, null);
                return;
            }
            Logger.e(TAG, tritonInitException.getMessage(), tritonInitException);
            throw tritonInitException;
        }
    }

    @NotNull
    public final List<NativeLibraryLoadStatistic> loadEngineNativeLibrary(@NotNull EnginePackage enginePackage) throws TritonInitException {
        Intrinsics.checkParameterIsNotNull(enginePackage, "enginePackage");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = engineLibs.iterator();
        while (it.hasNext()) {
            INSTANCE.loadOneLibrary((String) it.next(), false, enginePackage, arrayList);
        }
        return arrayList;
    }
}
