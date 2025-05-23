package com.tencent.mobileqq.nativefilescan;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001JA\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH&\u00a2\u0006\u0002\u0010\rJO\u0010\u000e\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH&\u00a2\u0006\u0002\u0010\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/nativefilescan/Callback;", "", "onDirInfoAvailable", "", "dirArray", "", "", "nameArray", "accessTimeArray", "", "sizeArray", "lastIndex", "", "([Ljava/lang/String;[Ljava/lang/String;[J[JI)V", "onFileInfoAvailable", "filePathArray", "extensionArrayArray", "lastModifiedTimeArray", "([Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;[J[JI)V", "core_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes15.dex */
public interface Callback {
    void onDirInfoAvailable(@NotNull String[] dirArray, @NotNull String[] nameArray, @NotNull long[] accessTimeArray, @NotNull long[] sizeArray, int lastIndex);

    void onFileInfoAvailable(@NotNull String[] filePathArray, @NotNull String[] nameArray, @NotNull String[] extensionArrayArray, @NotNull long[] lastModifiedTimeArray, @NotNull long[] sizeArray, int lastIndex);
}
