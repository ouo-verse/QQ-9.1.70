package com.tencent.hippykotlin.demo.pages.foundation.view;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class VideoInfo {
    public final boolean adaptHeight;
    public final String coverLayerUrl;
    public final String coverPicUrl;
    public boolean disableAppendHostAfterIP;
    public final long durationMs;
    public e extDtReportParams;
    public final String feedPb;
    public final int index;
    public final long startPosMs;
    public final String url;
    public final boolean useUrlAsId;
    public final String vid;

    public VideoInfo(String str, long j3, String str2, long j16, String str3, String str4, int i3, boolean z16, String str5, boolean z17) {
        this.url = str;
        this.startPosMs = j3;
        this.feedPb = str2;
        this.durationMs = j16;
        this.coverPicUrl = str3;
        this.coverLayerUrl = str4;
        this.index = i3;
        this.adaptHeight = z16;
        this.vid = str5;
        this.useUrlAsId = z17;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int m3 = QQAudioParams$$ExternalSyntheticOutline0.m(this.index, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.coverLayerUrl, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.coverPicUrl, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.durationMs, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.feedPb, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.startPosMs, this.url.hashCode() * 31, 31), 31), 31), 31), 31), 31);
        boolean z16 = this.adaptHeight;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.vid, (m3 + i3) * 31, 31);
        boolean z17 = this.useUrlAsId;
        return m16 + (z17 ? 1 : z17 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("VideoInfo(url=");
        m3.append(this.url);
        m3.append(", startPosMs=");
        m3.append(this.startPosMs);
        m3.append(", feedPb=");
        m3.append(this.feedPb);
        m3.append(", durationMs=");
        m3.append(this.durationMs);
        m3.append(", coverPicUrl=");
        m3.append(this.coverPicUrl);
        m3.append(", coverLayerUrl=");
        m3.append(this.coverLayerUrl);
        m3.append(", index=");
        m3.append(this.index);
        m3.append(", adaptHeight=");
        m3.append(this.adaptHeight);
        m3.append(", vid=");
        m3.append(this.vid);
        m3.append(", useUrlAsId=");
        return BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1.m(m3, this.useUrlAsId, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoInfo)) {
            return false;
        }
        VideoInfo videoInfo = (VideoInfo) obj;
        return Intrinsics.areEqual(this.url, videoInfo.url) && this.startPosMs == videoInfo.startPosMs && Intrinsics.areEqual(this.feedPb, videoInfo.feedPb) && this.durationMs == videoInfo.durationMs && Intrinsics.areEqual(this.coverPicUrl, videoInfo.coverPicUrl) && Intrinsics.areEqual(this.coverLayerUrl, videoInfo.coverLayerUrl) && this.index == videoInfo.index && this.adaptHeight == videoInfo.adaptHeight && Intrinsics.areEqual(this.vid, videoInfo.vid) && this.useUrlAsId == videoInfo.useUrlAsId;
    }

    public /* synthetic */ VideoInfo(String str, long j3, String str2, long j16, String str3, String str4, int i3, boolean z16, String str5, int i16) {
        this(str, j3, str2, j16, str3, str4, i3, (i16 & 128) != 0 ? false : z16, (i16 & 256) != 0 ? "" : str5, false);
    }
}
