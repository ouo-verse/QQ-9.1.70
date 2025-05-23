package com.tencent.richframework.gallery.bean;

import com.tencent.mobileqq.highway.transaction.Tracker;
import com.tencent.raft.codegenmeta.utils.RLog;
import com.tencent.tmdownloader.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0015B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/richframework/gallery/bean/RFWLayerVideoLoadState;", "", "()V", "currentPlayState", "Lcom/tencent/richframework/gallery/bean/RFWLayerVideoLoadState$PlayState;", "getCurrentPlayState", "()Lcom/tencent/richframework/gallery/bean/RFWLayerVideoLoadState$PlayState;", "setCurrentPlayState", "(Lcom/tencent/richframework/gallery/bean/RFWLayerVideoLoadState$PlayState;)V", "fileDownloadState", "Lcom/tencent/richframework/gallery/bean/RFWLayerFileDownloadState;", "getFileDownloadState", "()Lcom/tencent/richframework/gallery/bean/RFWLayerFileDownloadState;", "setFileDownloadState", "(Lcom/tencent/richframework/gallery/bean/RFWLayerFileDownloadState;)V", "mediaId", "", "getMediaId", "()Ljava/lang/String;", "setMediaId", "(Ljava/lang/String;)V", "PlayState", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWLayerVideoLoadState {

    @Nullable
    private PlayState currentPlayState;

    @Nullable
    private RFWLayerFileDownloadState fileDownloadState;
    public String mediaId;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/richframework/gallery/bean/RFWLayerVideoLoadState$PlayState;", "", "(Ljava/lang/String;I)V", "BUFFERING", "PLAYING", Tracker.PAUSE, RLog.ERROR, a.CONNTECTSTATE_FINISH, "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public enum PlayState {
        BUFFERING,
        PLAYING,
        PAUSE,
        ERROR,
        FINISH
    }

    @Nullable
    public final PlayState getCurrentPlayState() {
        return this.currentPlayState;
    }

    @Nullable
    public final RFWLayerFileDownloadState getFileDownloadState() {
        return this.fileDownloadState;
    }

    @NotNull
    public final String getMediaId() {
        String str = this.mediaId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaId");
        }
        return str;
    }

    public final void setCurrentPlayState(@Nullable PlayState playState) {
        this.currentPlayState = playState;
    }

    public final void setFileDownloadState(@Nullable RFWLayerFileDownloadState rFWLayerFileDownloadState) {
        this.fileDownloadState = rFWLayerFileDownloadState;
    }

    public final void setMediaId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mediaId = str;
    }
}
