package com.tencent.state.square.media;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.state.square.download.Source;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000f\u001a\u00020\u0004H\u0016R\u0011\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/state/square/media/MediaSource;", "Lcom/tencent/state/square/download/Source;", "Ljava/io/Serializable;", "remoteUrl", "", QAdRewardDefine$VideoParams.CACHE_PATH, "coverUrl", QQWinkConstants.COVER_PATH, "isPlayWithDownload", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getCoverPath", "()Ljava/lang/String;", "getCoverUrl", "()Z", "toString", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MediaSource extends Source {
    private final String coverPath;
    private final String coverUrl;
    private final boolean isPlayWithDownload;

    public /* synthetic */ MediaSource(String str, String str2, String str3, String str4, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? true : z16);
    }

    public final String getCoverPath() {
        return this.coverPath;
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    /* renamed from: isPlayWithDownload, reason: from getter */
    public final boolean getIsPlayWithDownload() {
        return this.isPlayWithDownload;
    }

    public String toString() {
        return "MediaSource(remoteUrl=" + getRemoteUrl() + ", cachePath=" + getCachePath() + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaSource(String remoteUrl, String cachePath, String coverUrl, String coverPath, boolean z16) {
        super(remoteUrl, cachePath);
        Intrinsics.checkNotNullParameter(remoteUrl, "remoteUrl");
        Intrinsics.checkNotNullParameter(cachePath, "cachePath");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(coverPath, "coverPath");
        this.coverUrl = coverUrl;
        this.coverPath = coverPath;
        this.isPlayWithDownload = z16;
    }
}
