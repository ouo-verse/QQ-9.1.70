package com.tencent.state.square.media;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/state/square/media/PlayConfig;", "", "loopCount", "", "isLoop", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID, "", "(IZLjava/lang/String;)V", "()Z", "setLoop", "(Z)V", "getLoopCount", "()I", "setLoopCount", "(I)V", "getUniqueId", "()Ljava/lang/String;", "setUniqueId", "(Ljava/lang/String;)V", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class PlayConfig {
    private boolean isLoop;
    private int loopCount;
    private String uniqueId;

    public PlayConfig() {
        this(0, false, null, 7, null);
    }

    public final int getLoopCount() {
        return this.loopCount;
    }

    public final String getUniqueId() {
        return this.uniqueId;
    }

    /* renamed from: isLoop, reason: from getter */
    public final boolean getIsLoop() {
        return this.isLoop;
    }

    public final void setLoop(boolean z16) {
        this.isLoop = z16;
    }

    public final void setLoopCount(int i3) {
        this.loopCount = i3;
    }

    public final void setUniqueId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uniqueId = str;
    }

    public PlayConfig(int i3, boolean z16, String uniqueId) {
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        this.loopCount = i3;
        this.isLoop = z16;
        this.uniqueId = uniqueId;
    }

    public /* synthetic */ PlayConfig(int i3, boolean z16, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 1 : i3, (i16 & 2) != 0 ? false : z16, (i16 & 4) != 0 ? "" : str);
    }
}
