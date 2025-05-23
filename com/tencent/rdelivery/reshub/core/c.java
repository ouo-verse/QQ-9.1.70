package com.tencent.rdelivery.reshub.core;

import com.tencent.rdelivery.reshub.FileSuffix;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u001c\u0010\r\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016J#\u0010\u0010\u001a\u00020\u00042\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u000e\"\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/rdelivery/reshub/core/c;", "Lcom/tencent/rdelivery/reshub/api/d;", "Lcom/tencent/rdelivery/reshub/api/e;", "pathParam", "", "b", "c", "a", "type", "fileExtension", "f", "d", QzoneZipCacheHelper.DIR, "e", "", "path", "g", "([Ljava/lang/String;)Ljava/lang/String;", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public class c implements com.tencent.rdelivery.reshub.api.d {
    @Override // com.tencent.rdelivery.reshub.api.d
    @NotNull
    public String a(@NotNull com.tencent.rdelivery.reshub.api.e pathParam) {
        Intrinsics.checkParameterIsNotNull(pathParam, "pathParam");
        return f(pathParam, "unzip", null);
    }

    @Override // com.tencent.rdelivery.reshub.api.d
    @NotNull
    public String b(@NotNull com.tencent.rdelivery.reshub.api.e pathParam) {
        Intrinsics.checkParameterIsNotNull(pathParam, "pathParam");
        return f(pathParam, "res", FileSuffix.RES_FILE);
    }

    @Override // com.tencent.rdelivery.reshub.api.d
    @NotNull
    public String c(@NotNull com.tencent.rdelivery.reshub.api.e pathParam) {
        Intrinsics.checkParameterIsNotNull(pathParam, "pathParam");
        return f(pathParam, "diff", ".diff");
    }

    @NotNull
    public String d(@NotNull com.tencent.rdelivery.reshub.api.e buildDir, @NotNull String type) {
        String str;
        Intrinsics.checkParameterIsNotNull(buildDir, "$this$buildDir");
        Intrinsics.checkParameterIsNotNull(type, "type");
        String rootPath = new File(g.d().getFilesDir(), "res_hub").getAbsolutePath();
        if (j.L.S()) {
            str = g.h().getConfigStoreSuffix();
        } else {
            str = "store";
        }
        String a16 = buildDir.a();
        if (a16 != null) {
            str = a16;
        }
        String g16 = g(buildDir.e(), buildDir.f(), buildDir.d(), str, type);
        Intrinsics.checkExpressionValueIsNotNull(rootPath, "rootPath");
        return g(rootPath, g16, buildDir.getResId(), buildDir.b());
    }

    @NotNull
    public String e(@NotNull com.tencent.rdelivery.reshub.api.e buildFilePath, @NotNull String dir, @NotNull String fileExtension) {
        Intrinsics.checkParameterIsNotNull(buildFilePath, "$this$buildFilePath");
        Intrinsics.checkParameterIsNotNull(dir, "dir");
        Intrinsics.checkParameterIsNotNull(fileExtension, "fileExtension");
        return g(dir, buildFilePath.getResId() + "_" + buildFilePath.b() + fileExtension);
    }

    @NotNull
    public String f(@NotNull com.tencent.rdelivery.reshub.api.e buildPath, @NotNull String type, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(buildPath, "$this$buildPath");
        Intrinsics.checkParameterIsNotNull(type, "type");
        String d16 = d(buildPath, type);
        if (str != null) {
            return e(buildPath, d16, str);
        }
        return d16 + File.separator;
    }

    @NotNull
    public String g(@NotNull String... path) {
        String joinToString$default;
        boolean isBlank;
        Intrinsics.checkParameterIsNotNull(path, "path");
        ArrayList arrayList = new ArrayList();
        for (String str : path) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                arrayList.add(str);
            }
        }
        String str2 = File.separator;
        Intrinsics.checkExpressionValueIsNotNull(str2, "File.separator");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, str2, null, null, 0, null, null, 62, null);
        return joinToString$default;
    }
}
