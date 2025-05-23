package com.tencent.zplan.common.soloader;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0002J\n\u0010\u0004\u001a\u00020\u0002*\u00020\u0002J\n\u0010\u0005\u001a\u00020\u0002*\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/zplan/common/soloader/d;", "", "Ljava/io/File;", "b", "a", "c", "<init>", "()V", "common_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f385270a = new d();

    d() {
    }

    @NotNull
    public final File a(@NotNull File deleteIfExists) {
        Intrinsics.checkNotNullParameter(deleteIfExists, "$this$deleteIfExists");
        if (deleteIfExists.exists() && !deleteIfExists.delete()) {
            throw new Exception(deleteIfExists + " \u6587\u4ef6\u65e0\u6cd5\u5220\u9664");
        }
        return deleteIfExists;
    }

    @NotNull
    public final File b(@NotNull File shouldBeDirectory) {
        Intrinsics.checkNotNullParameter(shouldBeDirectory, "$this$shouldBeDirectory");
        shouldBeDirectory.mkdirs();
        if (!shouldBeDirectory.isDirectory() && shouldBeDirectory.exists()) {
            throw new Exception(shouldBeDirectory + " \u4e0d\u662f\u76ee\u5f55");
        }
        return shouldBeDirectory;
    }

    @NotNull
    public final File c(@NotNull File willBeFile) {
        Intrinsics.checkNotNullParameter(willBeFile, "$this$willBeFile");
        if (!willBeFile.isDirectory()) {
            File parentFile = willBeFile.getParentFile();
            if (parentFile != null) {
                b(parentFile);
            }
            return willBeFile;
        }
        throw new Exception(willBeFile + " \u5df2\u6709\u76ee\u5f55");
    }
}
