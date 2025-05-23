package com.tencent.mobileqq.triton.internal.game;

import com.tencent.mobileqq.triton.filesystem.GameDataFileSystem;
import com.tencent.mobileqq.triton.filesystem.TemporaryFile;
import com.tencent.mobileqq.triton.internal.utils.Consts;
import io.github.landerlyoung.jenny.NativeProxy;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@NativeProxy(allFields = false, allMethods = true, namespace = Consts.JNI_NAMESPACE)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006J\u0011\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/game/GameDataFileSystemBridge;", "", "gameDataFileSystem", "Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;", "(Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;)V", "getFile", "", "pathInGame", "getFilePathInGame", "file", "newTempFile", "", "()[Ljava/lang/Object;", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class GameDataFileSystemBridge {
    private final GameDataFileSystem gameDataFileSystem;

    public GameDataFileSystemBridge(@NotNull GameDataFileSystem gameDataFileSystem) {
        Intrinsics.checkParameterIsNotNull(gameDataFileSystem, "gameDataFileSystem");
        this.gameDataFileSystem = gameDataFileSystem;
    }

    @NotNull
    public final String getFile(@NotNull String pathInGame) {
        Intrinsics.checkParameterIsNotNull(pathInGame, "pathInGame");
        String absolutePath = this.gameDataFileSystem.getFile(pathInGame).getAbsolutePath();
        Intrinsics.checkExpressionValueIsNotNull(absolutePath, "gameDataFileSystem.getFi\u2026(pathInGame).absolutePath");
        return absolutePath;
    }

    @NotNull
    public final String getFilePathInGame(@NotNull String file) {
        Intrinsics.checkParameterIsNotNull(file, "file");
        return this.gameDataFileSystem.getFilePathInGame(new File(file));
    }

    @NotNull
    public final Object[] newTempFile() {
        TemporaryFile newTempFile$default = GameDataFileSystem.DefaultImpls.newTempFile$default(this.gameDataFileSystem, null, null, 3, null);
        return new Object[]{newTempFile$default.getFile(), newTempFile$default.getPathInGame()};
    }
}
