package com.tencent.biz.pubaccount.weishi.verticalvideo.advcard;

import com.tencent.mobileqq.R;
import cooperation.qzone.webviewplugin.personalize.QZoneCoverStoreJsPlugin;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/WSDownloadStatus;", "", "desResId", "", "containerBackgroundResId", "btnResId", "type", "(Ljava/lang/String;IIIII)V", "getBtnResId", "()I", "getContainerBackgroundResId", "getDesResId", "getType", QZoneCoverStoreJsPlugin.INIT_PLUGIN, "Download", "Waiting", "Downloading", "Pause", "Completed", "Installing", "Installed", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes32.dex */
public enum WSDownloadStatus {
    Init(R.string.x7u, 0, R.drawable.ggq, 1),
    Download(R.string.x7u, 0, R.drawable.ggl, 1),
    Waiting(R.string.x7z, 0, R.drawable.ggl, 2),
    Downloading(0, R.drawable.ggk, R.drawable.ggn, 2),
    Pause(R.string.x7v, R.drawable.ggk, R.drawable.ggn, 3),
    Completed(R.string.x7w, 0, R.drawable.ggl, 4),
    Installing(R.string.x7x, 0, R.drawable.ggl, 4),
    Installed(R.string.x7y, 0, R.drawable.ggl, 5);

    private final int btnResId;
    private final int containerBackgroundResId;
    private final int desResId;
    private final int type;

    WSDownloadStatus(int i3, int i16, int i17, int i18) {
        this.desResId = i3;
        this.containerBackgroundResId = i16;
        this.btnResId = i17;
        this.type = i18;
    }

    public final int getBtnResId() {
        return this.btnResId;
    }

    public final int getContainerBackgroundResId() {
        return this.containerBackgroundResId;
    }

    public final int getDesResId() {
        return this.desResId;
    }

    public final int getType() {
        return this.type;
    }
}
