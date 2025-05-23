package com.tencent.state.square.media;

import com.tencent.state.square.SquareBase;
import com.tencent.state.square.download.SquareDownloader;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/state/square/media/SquareMedia;", "", "()V", "CommonPlayerPool", "Lcom/tencent/state/square/media/SquarePlayerPool;", "getCommonPlayerPool", "()Lcom/tencent/state/square/media/SquarePlayerPool;", "Downloader", "Lcom/tencent/state/square/download/SquareDownloader;", "getDownloader", "()Lcom/tencent/state/square/download/SquareDownloader;", "enabledUseUrl", "", "getEnabledUseUrl", "()Z", "setEnabledUseUrl", "(Z)V", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareMedia {
    public static final SquareMedia INSTANCE = new SquareMedia();
    private static final SquareDownloader Downloader = new SquareDownloader(SquareBase.INSTANCE.getAvatarDiskCache());
    private static boolean enabledUseUrl = true;
    private static final SquarePlayerPool CommonPlayerPool = new SquarePlayerPool(null, 1, 0 == true ? 1 : 0);

    SquareMedia() {
    }

    public final SquarePlayerPool getCommonPlayerPool() {
        return CommonPlayerPool;
    }

    public final SquareDownloader getDownloader() {
        return Downloader;
    }

    public final boolean getEnabledUseUrl() {
        return enabledUseUrl;
    }

    public final void setEnabledUseUrl(boolean z16) {
        enabledUseUrl = z16;
    }
}
