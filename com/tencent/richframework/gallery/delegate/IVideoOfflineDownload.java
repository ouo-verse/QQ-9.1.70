package com.tencent.richframework.gallery.delegate;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/richframework/gallery/delegate/IVideoOfflineDownload;", "", "startVideoOfflineDownload", "", "mediaId", "", "stopVideoOfflineDownload", "", "qq-layer-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public interface IVideoOfflineDownload {
    boolean startVideoOfflineDownload(@Nullable String mediaId);

    void stopVideoOfflineDownload(@Nullable String mediaId);
}
