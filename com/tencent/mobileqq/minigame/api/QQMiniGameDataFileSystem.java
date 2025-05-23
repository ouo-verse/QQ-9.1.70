package com.tencent.mobileqq.minigame.api;

import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.triton.filesystem.GameDataFileSystem;
import com.tencent.mobileqq.triton.filesystem.TemporaryFile;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u001c\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0016R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/minigame/api/QQMiniGameDataFileSystem;", "Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;", "()V", MosaicConstants$JsProperty.PROP_FILE_MANAGER, "Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;", "kotlin.jvm.PlatformType", "getFile", "Ljava/io/File;", "pathInGame", "", "getFilePathInGame", "file", "newTempFile", "Lcom/tencent/mobileqq/triton/filesystem/TemporaryFile;", "hash", "suffix", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class QQMiniGameDataFileSystem implements GameDataFileSystem {
    private final MiniAppFileManager fileManager = MiniAppFileManager.getInstance();

    @Override // com.tencent.mobileqq.triton.filesystem.GameDataFileSystem
    public File getFile(String pathInGame) {
        Intrinsics.checkNotNullParameter(pathInGame, "pathInGame");
        return new File(this.fileManager.getAbsolutePath(pathInGame));
    }

    @Override // com.tencent.mobileqq.triton.filesystem.GameDataFileSystem
    public String getFilePathInGame(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        String wxFilePathByExistLocalPath = this.fileManager.getWxFilePathByExistLocalPath(file.getAbsolutePath());
        Intrinsics.checkNotNullExpressionValue(wxFilePathByExistLocalPath, "fileManager.getWxFilePat\u2026alPath(file.absolutePath)");
        return wxFilePathByExistLocalPath;
    }

    @Override // com.tencent.mobileqq.triton.filesystem.GameDataFileSystem
    public TemporaryFile newTempFile(String hash, String suffix) {
        File file = new File(this.fileManager.getTmpPath(suffix));
        String scheme = this.fileManager.getWxFilePathByExistLocalPath(file.getAbsolutePath());
        Intrinsics.checkNotNullExpressionValue(scheme, "scheme");
        return new TemporaryFile(file, scheme);
    }
}
