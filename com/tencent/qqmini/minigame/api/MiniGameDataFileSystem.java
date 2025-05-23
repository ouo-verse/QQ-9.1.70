package com.tencent.qqmini.minigame.api;

import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.triton.filesystem.GameDataFileSystem;
import com.tencent.mobileqq.triton.filesystem.TemporaryFile;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.model.ApkgBaseInfo;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0016J\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqmini/minigame/api/MiniGameDataFileSystem;", "Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;", "info", "Lcom/tencent/qqmini/sdk/launcher/model/ApkgBaseInfo;", "(Lcom/tencent/qqmini/sdk/launcher/model/ApkgBaseInfo;)V", MosaicConstants$JsProperty.PROP_FILE_MANAGER, "Lcom/tencent/qqmini/sdk/core/manager/MiniAppFileManager;", "kotlin.jvm.PlatformType", "getFile", "Ljava/io/File;", "pathInGame", "", "getFilePathInGame", "file", "newTempFile", "Lcom/tencent/mobileqq/triton/filesystem/TemporaryFile;", "hash", "suffix", "lib_minigame_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public final class MiniGameDataFileSystem implements GameDataFileSystem {
    private final MiniAppFileManager fileManager;

    public MiniGameDataFileSystem(@NotNull ApkgBaseInfo info) {
        Intrinsics.checkParameterIsNotNull(info, "info");
        this.fileManager = MiniAppFileManager.getMiniAppFileManager(info);
    }

    @Override // com.tencent.mobileqq.triton.filesystem.GameDataFileSystem
    @NotNull
    public File getFile(@NotNull String pathInGame) {
        Intrinsics.checkParameterIsNotNull(pathInGame, "pathInGame");
        return new File(this.fileManager.getAbsolutePath(pathInGame));
    }

    @Override // com.tencent.mobileqq.triton.filesystem.GameDataFileSystem
    @NotNull
    public String getFilePathInGame(@NotNull File file) {
        Intrinsics.checkParameterIsNotNull(file, "file");
        String wxFilePathByExistLocalPath = this.fileManager.getWxFilePathByExistLocalPath(file.getAbsolutePath());
        Intrinsics.checkExpressionValueIsNotNull(wxFilePathByExistLocalPath, "fileManager.getWxFilePat\u2026alPath(file.absolutePath)");
        return wxFilePathByExistLocalPath;
    }

    @Override // com.tencent.mobileqq.triton.filesystem.GameDataFileSystem
    @NotNull
    public TemporaryFile newTempFile(@Nullable String hash, @Nullable String suffix) {
        File file = new File(this.fileManager.getTmpPath(suffix));
        String scheme = this.fileManager.getWxFilePathByExistLocalPath(file.getAbsolutePath());
        Intrinsics.checkExpressionValueIsNotNull(scheme, "scheme");
        return new TemporaryFile(file, scheme);
    }
}
