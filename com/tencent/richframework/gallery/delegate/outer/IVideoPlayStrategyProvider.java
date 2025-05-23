package com.tencent.richframework.gallery.delegate.outer;

import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import kotlin.Metadata;
import kotlin.jvm.JvmDefault;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/richframework/gallery/delegate/outer/IVideoPlayStrategyProvider;", "", "continuePlay", "", "mediaInfo", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "enableDispatchFileDownloadState", "getMinBufferingPacketDurationMs", "", "isAutoPlayWhenVisible", "isLoopPlay", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public interface IVideoPlayStrategyProvider {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public static final class DefaultImpls {
        public static boolean enableDispatchFileDownloadState(@NotNull IVideoPlayStrategyProvider iVideoPlayStrategyProvider, @NotNull RFWLayerItemMediaInfo mediaInfo) {
            Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
            return false;
        }
    }

    boolean continuePlay(@NotNull RFWLayerItemMediaInfo mediaInfo);

    boolean enableDispatchFileDownloadState(@NotNull RFWLayerItemMediaInfo mediaInfo);

    @JvmDefault
    long getMinBufferingPacketDurationMs(@NotNull RFWLayerItemMediaInfo mediaInfo);

    boolean isAutoPlayWhenVisible(@NotNull RFWLayerItemMediaInfo mediaInfo);

    boolean isLoopPlay(@NotNull RFWLayerItemMediaInfo mediaInfo);
}
