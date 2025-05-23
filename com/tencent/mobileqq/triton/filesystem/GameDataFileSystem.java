package com.tencent.mobileqq.triton.filesystem;

import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H&J \u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;", "", "getFile", "Ljava/io/File;", "pathInGame", "", "getFilePathInGame", "file", "newTempFile", "Lcom/tencent/mobileqq/triton/filesystem/TemporaryFile;", "hash", "suffix", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public interface GameDataFileSystem {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ TemporaryFile newTempFile$default(GameDataFileSystem gameDataFileSystem, String str, String str2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    str = null;
                }
                if ((i3 & 2) != 0) {
                    str2 = null;
                }
                return gameDataFileSystem.newTempFile(str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: newTempFile");
        }
    }

    @NotNull
    File getFile(@NotNull String pathInGame);

    @NotNull
    String getFilePathInGame(@NotNull File file);

    @NotNull
    TemporaryFile newTempFile(@Nullable String hash, @Nullable String suffix);
}
