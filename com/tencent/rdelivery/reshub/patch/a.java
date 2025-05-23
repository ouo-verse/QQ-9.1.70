package com.tencent.rdelivery.reshub.patch;

import com.tencent.rdelivery.reshub.core.g;
import com.tencent.rdelivery.reshub.util.m;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jz3.b;
import jz3.d;
import jz3.e;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J&\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002J&\u0010\t\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002J&\u0010\f\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0002J$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\n\u001a\u00020\u0003H\u0002J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J&\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/rdelivery/reshub/patch/a;", "", "", "", "fileNames", "srcPath", "targetPath", "", "d", "c", "path", "desc", "b", "e", "Ljz3/e;", "resConfig", "a", "patchPath", "localConfig", "remoteConfig", "Lcom/tencent/rdelivery/reshub/report/a;", "f", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class a {
    private final boolean a(String path, e resConfig) {
        return b.b(resConfig.f411270k, path, false, 4, null);
    }

    private final boolean b(List<String> fileNames, String path, String desc) {
        List<String> e16 = e(fileNames, path);
        boolean isEmpty = e16.isEmpty();
        if (!isEmpty) {
            d.c("BigResPatchMerger", "Lack Of Required Files(" + e16 + ") in " + desc + " Path: " + path);
        }
        return isEmpty;
    }

    private final boolean c(List<String> fileNames, String srcPath, String targetPath) {
        Object m476constructorimpl;
        boolean z16;
        try {
            Result.Companion companion = Result.INSTANCE;
            for (String str : fileNames) {
                File file = new File(m.d(srcPath, str));
                File file2 = new File(m.d(targetPath, str));
                if (file.isDirectory()) {
                    FilesKt__UtilsKt.copyRecursively$default(file, file2, true, null, 4, null);
                } else {
                    FilesKt__UtilsKt.copyTo$default(file, file2, false, 0, 6, null);
                }
                d.a("BigResPatchMerger", "Copy BigResFile From Current: " + file.getPath() + " -> " + file2.getPath());
            }
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            d.d("BigResPatchMerger", "Copy Files(" + fileNames + ") Fail: " + srcPath + " -> " + targetPath, m479exceptionOrNullimpl);
        }
        return z16;
    }

    private final boolean d(List<String> fileNames, String srcPath, String targetPath) {
        if (fileNames.isEmpty()) {
            return true;
        }
        List<String> e16 = e(fileNames, targetPath);
        if (b(e16, srcPath, "Src") && c(e16, srcPath, targetPath) && b(fileNames, targetPath, "Target")) {
            return true;
        }
        return false;
    }

    private final List<String> e(List<String> fileNames, String path) {
        boolean contains;
        File file = new File(path);
        if (!file.exists()) {
            d.c("BigResPatchMerger", "Path Not Exist, Cannot Find Lack Files(" + fileNames + "): " + path);
            return fileNames;
        }
        if ((!fileNames.isEmpty()) && !file.isDirectory()) {
            d.c("BigResPatchMerger", "Path Not a Directory, Cannot Find Lack Files(" + fileNames + "): " + path);
            return fileNames;
        }
        String[] existFiles = file.list();
        ArrayList arrayList = new ArrayList();
        for (Object obj : fileNames) {
            Intrinsics.checkExpressionValueIsNotNull(existFiles, "existFiles");
            contains = ArraysKt___ArraysKt.contains(existFiles, (String) obj);
            if (!contains) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    public final com.tencent.rdelivery.reshub.report.a f(@NotNull String patchPath, @NotNull String targetPath, @NotNull e localConfig, @NotNull e remoteConfig) {
        boolean z16;
        Intrinsics.checkParameterIsNotNull(patchPath, "patchPath");
        Intrinsics.checkParameterIsNotNull(targetPath, "targetPath");
        Intrinsics.checkParameterIsNotNull(localConfig, "localConfig");
        Intrinsics.checkParameterIsNotNull(remoteConfig, "remoteConfig");
        String str = remoteConfig.f411260a;
        if (g.b(patchPath, targetPath, false, null, 12, null) == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            String str2 = "Unzip Big Res(" + str + ") Patch Fail:  " + patchPath + " -> " + targetPath;
            com.tencent.rdelivery.reshub.report.a aVar = new com.tencent.rdelivery.reshub.report.a();
            aVar.e(5007);
            aVar.g(str2);
            return aVar;
        }
        String curBigResPath = localConfig.G;
        List<String> subFiles = remoteConfig.f411282w;
        Intrinsics.checkExpressionValueIsNotNull(subFiles, "subFiles");
        Intrinsics.checkExpressionValueIsNotNull(curBigResPath, "curBigResPath");
        if (!d(subFiles, curBigResPath, targetPath)) {
            String str3 = "Fail to Copy Remained Big Res(" + str + ") File: " + curBigResPath + " -> " + targetPath;
            com.tencent.rdelivery.reshub.report.a aVar2 = new com.tencent.rdelivery.reshub.report.a();
            aVar2.e(5007);
            aVar2.g(str3);
            return aVar2;
        }
        if (!a(targetPath, remoteConfig)) {
            String str4 = "Fail to Check New Big Res(" + str + ") Files: " + targetPath;
            com.tencent.rdelivery.reshub.report.a aVar3 = new com.tencent.rdelivery.reshub.report.a();
            aVar3.e(5008);
            aVar3.g(str4);
            return aVar3;
        }
        return com.tencent.rdelivery.reshub.report.b.a();
    }
}
