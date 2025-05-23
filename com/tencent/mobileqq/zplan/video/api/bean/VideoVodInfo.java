package com.tencent.mobileqq.zplan.video.api.bean;

import com.tencent.mobileqq.zplan.video.api.bean.VideoVidInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\fB#\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0016\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/zplan/video/api/bean/h;", "", "Lorg/json/JSONObject;", "b", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/zplan/video/api/bean/g;", "a", "Lcom/tencent/mobileqq/zplan/video/api/bean/g;", "()Lcom/tencent/mobileqq/zplan/video/api/bean/g;", "currentVidInfo", "getNextVidInfo", "nextVidInfo", "c", "I", "getCurrentPosition", "()I", "currentPosition", "<init>", "(Lcom/tencent/mobileqq/zplan/video/api/bean/g;Lcom/tencent/mobileqq/zplan/video/api/bean/g;I)V", "d", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.video.api.bean.h, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class VideoVodInfo {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final VideoVidInfo currentVidInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final VideoVidInfo nextVidInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int currentPosition;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zplan/video/api/bean/h$a;", "", "Ldv4/c;", "commonInfo", "Lcom/tencent/mobileqq/zplan/video/api/bean/h;", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.video.api.bean.h$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VideoVodInfo a(dv4.c commonInfo) {
            Intrinsics.checkNotNullParameter(commonInfo, "commonInfo");
            VideoVidInfo.Companion companion = VideoVidInfo.INSTANCE;
            return new VideoVodInfo(companion.a(commonInfo.f395022b), companion.a(commonInfo.f395023c), commonInfo.f395024d);
        }

        Companion() {
        }
    }

    public VideoVodInfo(VideoVidInfo videoVidInfo, VideoVidInfo videoVidInfo2, int i3) {
        this.currentVidInfo = videoVidInfo;
        this.nextVidInfo = videoVidInfo2;
        this.currentPosition = i3;
    }

    /* renamed from: a, reason: from getter */
    public final VideoVidInfo getCurrentVidInfo() {
        return this.currentVidInfo;
    }

    public final JSONObject b() {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        VideoVidInfo videoVidInfo = this.currentVidInfo;
        jSONObject2.put("CurrentVid", videoVidInfo != null ? videoVidInfo.c() : null);
        VideoVidInfo videoVidInfo2 = this.nextVidInfo;
        if (videoVidInfo2 == null || (jSONObject = videoVidInfo2.c()) == null) {
            jSONObject = new JSONObject();
        }
        jSONObject2.put("NextVid", jSONObject);
        jSONObject2.put("CurrentPosition", this.currentPosition);
        return jSONObject2;
    }

    public int hashCode() {
        VideoVidInfo videoVidInfo = this.currentVidInfo;
        int hashCode = (videoVidInfo == null ? 0 : videoVidInfo.hashCode()) * 31;
        VideoVidInfo videoVidInfo2 = this.nextVidInfo;
        return ((hashCode + (videoVidInfo2 != null ? videoVidInfo2.hashCode() : 0)) * 31) + this.currentPosition;
    }

    public String toString() {
        return "VideoVodInfo(currentVidInfo=" + this.currentVidInfo + ", nextVidInfo=" + this.nextVidInfo + ", currentPosition=" + this.currentPosition + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoVodInfo)) {
            return false;
        }
        VideoVodInfo videoVodInfo = (VideoVodInfo) other;
        return Intrinsics.areEqual(this.currentVidInfo, videoVodInfo.currentVidInfo) && Intrinsics.areEqual(this.nextVidInfo, videoVodInfo.nextVidInfo) && this.currentPosition == videoVodInfo.currentPosition;
    }
}
