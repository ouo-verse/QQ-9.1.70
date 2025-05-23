package com.tencent.mobileqq.zplan.video.api.bean;

import com.tencent.mobileqq.zplan.video.api.bean.VideoVodInfo;
import com.tencent.qqmini.miniapp.widget.media.live.TXJSAdapterConstants;
import dv4.j;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001\rB5\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u001a\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\t\u0012\u0006\u0010 \u001a\u00020\u0006\u00a2\u0006\u0004\b!\u0010\"J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019R\u0017\u0010\u001d\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\r\u0010\u001cR\u0017\u0010 \u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0014\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/zplan/video/api/bean/c;", "", "Lorg/json/JSONObject;", "d", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/mobileqq/zplan/video/api/bean/f;", "a", "Ljava/util/List;", "getVideoStreamInfoList", "()Ljava/util/List;", "videoStreamInfoList", "b", "I", "()I", TXJSAdapterConstants.PLAYER_KEY_PLAY_TYPE, "Lcom/tencent/mobileqq/zplan/video/api/bean/h;", "c", "Lcom/tencent/mobileqq/zplan/video/api/bean/h;", "()Lcom/tencent/mobileqq/zplan/video/api/bean/h;", "vodInfo", "Z", "()Z", "needLeave", "e", "getRoomType", "roomType", "<init>", "(Ljava/util/List;ILcom/tencent/mobileqq/zplan/video/api/bean/h;ZI)V", "f", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.video.api.bean.c, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class VideoMediaInfo {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<VideoStreamInfo> videoStreamInfoList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int playType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final VideoVodInfo vodInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean needLeave;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int roomType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zplan/video/api/bean/c$a;", "", "Ldv4/j;", "streamInfo", "Lcom/tencent/mobileqq/zplan/video/api/bean/c;", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.video.api.bean.c$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final VideoMediaInfo a(j streamInfo) {
            Intrinsics.checkNotNullParameter(streamInfo, "streamInfo");
            ArrayList arrayList = new ArrayList();
            dv4.b[] bVarArr = streamInfo.f395037c;
            Intrinsics.checkNotNullExpressionValue(bVarArr, "streamInfo.address");
            for (dv4.b bVar : bVarArr) {
                String mediaUrl = bVar.f395017a;
                int i3 = bVar.f395020d;
                Intrinsics.checkNotNullExpressionValue(mediaUrl, "mediaUrl");
                arrayList.add(new VideoStreamInfo(mediaUrl, i3));
            }
            int i16 = streamInfo.f395038d;
            dv4.c cVar = streamInfo.f395039e;
            boolean z16 = cVar != null ? cVar.f395021a : false;
            VideoVodInfo.Companion companion = VideoVodInfo.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(cVar, "streamInfo.commonInfo");
            return new VideoMediaInfo(arrayList, i16, companion.a(cVar), z16, streamInfo.f395040f);
        }

        Companion() {
        }
    }

    public VideoMediaInfo(List<VideoStreamInfo> videoStreamInfoList, int i3, VideoVodInfo vodInfo, boolean z16, int i16) {
        Intrinsics.checkNotNullParameter(videoStreamInfoList, "videoStreamInfoList");
        Intrinsics.checkNotNullParameter(vodInfo, "vodInfo");
        this.videoStreamInfoList = videoStreamInfoList;
        this.playType = i3;
        this.vodInfo = vodInfo;
        this.needLeave = z16;
        this.roomType = i16;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getNeedLeave() {
        return this.needLeave;
    }

    /* renamed from: b, reason: from getter */
    public final int getPlayType() {
        return this.playType;
    }

    /* renamed from: c, reason: from getter */
    public final VideoVodInfo getVodInfo() {
        return this.vodInfo;
    }

    public final JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (VideoStreamInfo videoStreamInfo : this.videoStreamInfoList) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("MediaUrl", videoStreamInfo.getMediaUrl());
            jSONObject2.put("MediaLevel", videoStreamInfo.getMediaLevel());
            jSONArray.mo162put(jSONObject2);
        }
        jSONObject.put("StreamInfo", jSONArray);
        jSONObject.put("PlayType", this.playType);
        jSONObject.put("MediaType", this.roomType);
        jSONObject.put("VodInfo", this.vodInfo.b());
        return jSONObject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.videoStreamInfoList.hashCode() * 31) + this.playType) * 31) + this.vodInfo.hashCode()) * 31;
        boolean z16 = this.needLeave;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((hashCode + i3) * 31) + this.roomType;
    }

    public String toString() {
        return "VideoMediaInfo(videoStreamInfoList=" + this.videoStreamInfoList + ", playType=" + this.playType + ", vodInfo=" + this.vodInfo + ", needLeave=" + this.needLeave + ", roomType=" + this.roomType + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoMediaInfo)) {
            return false;
        }
        VideoMediaInfo videoMediaInfo = (VideoMediaInfo) other;
        return Intrinsics.areEqual(this.videoStreamInfoList, videoMediaInfo.videoStreamInfoList) && this.playType == videoMediaInfo.playType && Intrinsics.areEqual(this.vodInfo, videoMediaInfo.vodInfo) && this.needLeave == videoMediaInfo.needLeave && this.roomType == videoMediaInfo.roomType;
    }
}
