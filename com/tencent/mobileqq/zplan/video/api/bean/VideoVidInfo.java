package com.tencent.mobileqq.zplan.video.api.bean;

import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u000bB/\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\f\u001a\u0004\b\u000b\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0017\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/zplan/video/api/bean/g;", "", "Lorg/json/JSONObject;", "c", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "vid", "cid", "getMediaName", "mediaName", "d", "I", "getMediaEpisode", "()I", "mediaEpisode", "e", "getMediaDuration", "mediaDuration", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "f", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.video.api.bean.g, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class VideoVidInfo {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String vid;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String cid;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String mediaName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int mediaEpisode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int mediaDuration;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zplan/video/api/bean/g$a;", "", "Luu4/h;", "txVidInfo", "Lcom/tencent/mobileqq/zplan/video/api/bean/g;", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.video.api.bean.g$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        public final VideoVidInfo a(uu4.h txVidInfo) {
            if (txVidInfo == null) {
                return null;
            }
            String vid = txVidInfo.f440081a;
            String cid = txVidInfo.f440082b;
            String mediaName = txVidInfo.f440083c;
            int i3 = txVidInfo.f440087g;
            int i16 = txVidInfo.f440085e;
            Intrinsics.checkNotNullExpressionValue(vid, "vid");
            Intrinsics.checkNotNullExpressionValue(cid, "cid");
            Intrinsics.checkNotNullExpressionValue(mediaName, "mediaName");
            return new VideoVidInfo(vid, cid, mediaName, i3, i16);
        }
    }

    public VideoVidInfo(String vid, String cid, String mediaName, int i3, int i16) {
        Intrinsics.checkNotNullParameter(vid, "vid");
        Intrinsics.checkNotNullParameter(cid, "cid");
        Intrinsics.checkNotNullParameter(mediaName, "mediaName");
        this.vid = vid;
        this.cid = cid;
        this.mediaName = mediaName;
        this.mediaEpisode = i3;
        this.mediaDuration = i16;
    }

    /* renamed from: a, reason: from getter */
    public final String getCid() {
        return this.cid;
    }

    /* renamed from: b, reason: from getter */
    public final String getVid() {
        return this.vid;
    }

    public final JSONObject c() {
        String str;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Vid", this.vid);
        jSONObject.put("Cid", this.cid);
        try {
            str = URLEncoder.encode(this.mediaName, "UTF-8");
            Intrinsics.checkNotNullExpressionValue(str, "encode(mediaName, \"UTF-8\")");
        } catch (Exception e16) {
            e16.printStackTrace();
            str = "";
        }
        jSONObject.put("MediaName", str);
        jSONObject.put("MediaEpisode", this.mediaEpisode);
        jSONObject.put("MediaDuration", this.mediaDuration);
        return jSONObject;
    }

    public int hashCode() {
        return (((((((this.vid.hashCode() * 31) + this.cid.hashCode()) * 31) + this.mediaName.hashCode()) * 31) + this.mediaEpisode) * 31) + this.mediaDuration;
    }

    public String toString() {
        return "VideoVidInfo(vid=" + this.vid + ", cid=" + this.cid + ", mediaName=" + this.mediaName + ", mediaEpisode=" + this.mediaEpisode + ", mediaDuration=" + this.mediaDuration + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoVidInfo)) {
            return false;
        }
        VideoVidInfo videoVidInfo = (VideoVidInfo) other;
        return Intrinsics.areEqual(this.vid, videoVidInfo.vid) && Intrinsics.areEqual(this.cid, videoVidInfo.cid) && Intrinsics.areEqual(this.mediaName, videoVidInfo.mediaName) && this.mediaEpisode == videoVidInfo.mediaEpisode && this.mediaDuration == videoVidInfo.mediaDuration;
    }
}
