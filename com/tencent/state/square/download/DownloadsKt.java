package com.tencent.state.square.download;

import com.tencent.state.square.SquareBase;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"SquareViewDownloader", "Lcom/tencent/state/square/download/SquareDownloader;", "getSquareViewDownloader", "()Lcom/tencent/state/square/download/SquareDownloader;", "cacheFile", "Ljava/io/File;", "Lcom/tencent/state/square/download/Source;", "getCacheFile", "(Lcom/tencent/state/square/download/Source;)Ljava/io/File;", "square_base_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class DownloadsKt {

    @NotNull
    private static final SquareDownloader SquareViewDownloader = new SquareDownloader(SquareBase.INSTANCE.getAvatarDiskCache());

    @NotNull
    public static final File getCacheFile(@NotNull Source cacheFile) {
        Intrinsics.checkNotNullParameter(cacheFile, "$this$cacheFile");
        return new File(cacheFile.getCachePath());
    }

    @NotNull
    public static final SquareDownloader getSquareViewDownloader() {
        return SquareViewDownloader;
    }
}
