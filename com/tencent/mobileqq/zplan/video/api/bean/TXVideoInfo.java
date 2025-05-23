package com.tencent.mobileqq.zplan.video.api.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0006\u0010\u0003\u001a\u00020\u0002J'\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u00c6\u0001J\t\u0010\u000b\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\r\u001a\u00020\fH\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0017\u0010\t\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/zplan/video/api/bean/b;", "", "", "g", "Lcom/tencent/mobileqq/zplan/video/api/bean/e;", "playInfo", "Lcom/tencent/mobileqq/zplan/video/api/bean/c;", "mediaInfo", "Lcom/tencent/mobileqq/zplan/video/api/bean/d;", "paramInfo", "a", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/zplan/video/api/bean/e;", "e", "()Lcom/tencent/mobileqq/zplan/video/api/bean/e;", "b", "Lcom/tencent/mobileqq/zplan/video/api/bean/c;", "c", "()Lcom/tencent/mobileqq/zplan/video/api/bean/c;", "f", "(Lcom/tencent/mobileqq/zplan/video/api/bean/c;)V", "Lcom/tencent/mobileqq/zplan/video/api/bean/d;", "d", "()Lcom/tencent/mobileqq/zplan/video/api/bean/d;", "<init>", "(Lcom/tencent/mobileqq/zplan/video/api/bean/e;Lcom/tencent/mobileqq/zplan/video/api/bean/c;Lcom/tencent/mobileqq/zplan/video/api/bean/d;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.video.api.bean.b, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class TXVideoInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final VideoPlayInfo playInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private VideoMediaInfo mediaInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final VideoParamInfo paramInfo;

    public TXVideoInfo(VideoPlayInfo playInfo, VideoMediaInfo mediaInfo, VideoParamInfo paramInfo) {
        Intrinsics.checkNotNullParameter(playInfo, "playInfo");
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        Intrinsics.checkNotNullParameter(paramInfo, "paramInfo");
        this.playInfo = playInfo;
        this.mediaInfo = mediaInfo;
        this.paramInfo = paramInfo;
    }

    public final TXVideoInfo a(VideoPlayInfo playInfo, VideoMediaInfo mediaInfo, VideoParamInfo paramInfo) {
        Intrinsics.checkNotNullParameter(playInfo, "playInfo");
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        Intrinsics.checkNotNullParameter(paramInfo, "paramInfo");
        return new TXVideoInfo(playInfo, mediaInfo, paramInfo);
    }

    /* renamed from: c, reason: from getter */
    public final VideoMediaInfo getMediaInfo() {
        return this.mediaInfo;
    }

    /* renamed from: d, reason: from getter */
    public final VideoParamInfo getParamInfo() {
        return this.paramInfo;
    }

    /* renamed from: e, reason: from getter */
    public final VideoPlayInfo getPlayInfo() {
        return this.playInfo;
    }

    public final void f(VideoMediaInfo videoMediaInfo) {
        Intrinsics.checkNotNullParameter(videoMediaInfo, "<set-?>");
        this.mediaInfo = videoMediaInfo;
    }

    public final String g() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("PlayInfo", this.playInfo.d());
        jSONObject.put("MediaInfo", this.mediaInfo.d());
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026t())\n        }.toString()");
        return jSONObject2;
    }

    public int hashCode() {
        return (((this.playInfo.hashCode() * 31) + this.mediaInfo.hashCode()) * 31) + this.paramInfo.hashCode();
    }

    public String toString() {
        return "TXVideoInfo(playInfo=" + this.playInfo + ", mediaInfo=" + this.mediaInfo + ", paramInfo=" + this.paramInfo + ")";
    }

    public static /* synthetic */ TXVideoInfo b(TXVideoInfo tXVideoInfo, VideoPlayInfo videoPlayInfo, VideoMediaInfo videoMediaInfo, VideoParamInfo videoParamInfo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            videoPlayInfo = tXVideoInfo.playInfo;
        }
        if ((i3 & 2) != 0) {
            videoMediaInfo = tXVideoInfo.mediaInfo;
        }
        if ((i3 & 4) != 0) {
            videoParamInfo = tXVideoInfo.paramInfo;
        }
        return tXVideoInfo.a(videoPlayInfo, videoMediaInfo, videoParamInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TXVideoInfo)) {
            return false;
        }
        TXVideoInfo tXVideoInfo = (TXVideoInfo) other;
        return Intrinsics.areEqual(this.playInfo, tXVideoInfo.playInfo) && Intrinsics.areEqual(this.mediaInfo, tXVideoInfo.mediaInfo) && Intrinsics.areEqual(this.paramInfo, tXVideoInfo.paramInfo);
    }
}
