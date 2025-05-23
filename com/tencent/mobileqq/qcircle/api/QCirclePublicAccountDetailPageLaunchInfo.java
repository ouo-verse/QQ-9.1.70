package com.tencent.mobileqq.qcircle.api;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.tencent.ads.data.AdParam;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.luggage.wxa.p004if.w;
import com.tencent.mobileqq.msf.core.auth.k;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vas.ipc.VasLiveIPCModule;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 %2\u00020\u0001:\u0004%&'(B{\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0010J\u0010\u0010\"\u001a\u0004\u0018\u00010\u00002\u0006\u0010#\u001a\u00020\u0003J\u0006\u0010$\u001a\u00020\u0003R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001cR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0012R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0012R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0012\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountDetailPageLaunchInfo;", "", "publicAccountName", "", "flowType", "", "preloadTriggerCount", "createTimeSec", "", "feedId", VasLiveIPCModule.KEY_ANCHOR_UIN, "transData", "reportData", QCircleScheme.AttrDetail.FEED_INFO, "Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountDetailPageLaunchInfo$FeedInfo;", "autoPlay", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountDetailPageLaunchInfo$FeedInfo;I)V", "getAnchorUin", "()Ljava/lang/String;", "getAutoPlay", "()I", "getCreateTimeSec", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFeedId", "getFeedInfo", "()Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountDetailPageLaunchInfo$FeedInfo;", "getFlowType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPreloadTriggerCount", "getPublicAccountName", "getReportData", "getTransData", "parseFromJSONStr", "jsonStr", "toJSONStr", "Companion", "FeedInfo", "RawStringJsonAdapter", "VideoInfo", "qcircle-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class QCirclePublicAccountDetailPageLaunchInfo {

    @NotNull
    private static final String TAG = "QCirclePublicAccountDetailPageLaunchInfo";

    @SerializedName(VasLiveIPCModule.KEY_ANCHOR_UIN)
    @Nullable
    private final String anchorUin;

    @SerializedName("ap")
    private final int autoPlay;

    @SerializedName(WadlProxyConsts.CREATE_TIME)
    @Nullable
    private final Long createTimeSec;

    @SerializedName("feedId")
    @Nullable
    private final String feedId;

    @SerializedName(QCircleScheme.AttrDetail.FEED_INFO)
    @Nullable
    private final FeedInfo feedInfo;

    @SerializedName("flowType")
    @Nullable
    private final Integer flowType;

    @SerializedName(AdParam.PF)
    @Nullable
    private final Integer preloadTriggerCount;

    @SerializedName("pubName")
    @Nullable
    private final String publicAccountName;

    @SerializedName("reportData")
    @JsonAdapter(RawStringJsonAdapter.class)
    @Nullable
    private final String reportData;

    @SerializedName("transData")
    @JsonAdapter(RawStringJsonAdapter.class)
    @Nullable
    private final String transData;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u00b9\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0002\u0010\u0014J\u0006\u0010*\u001a\u00020\u0005R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001d\u0010\u0019R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001e\u0010\u0019R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001f\u0010\u0019R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b!\u0010\u0019R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b#\u0010\u0019R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b$\u0010\u0019R \u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b)\u0010\u0019\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountDetailPageLaunchInfo$FeedInfo;", "", "type", "", "nick", "", "avatar", "content", VasLiveIPCModule.KEY_ANCHOR_UIN, "likeNum", "fuelNum", "commentNum", "shareNum", "coverUrl", "width", "height", "recomReason", "playNum", QCircleScheme.AttrDetail.VIDEO_INFO, "Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountDetailPageLaunchInfo$VideoInfo;", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountDetailPageLaunchInfo$VideoInfo;)V", "getAnchorUin", "()Ljava/lang/String;", "getAvatar", "getCommentNum", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getContent", "getCoverUrl", "getFuelNum", "getHeight", "getLikeNum", "getNick", "getPlayNum", "getRecomReason", "getShareNum", "getType", w.NAME, "()Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountDetailPageLaunchInfo$VideoInfo;", "setVideoInfo", "(Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountDetailPageLaunchInfo$VideoInfo;)V", "getWidth", "toJSONStr", "qcircle-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class FeedInfo {

        @SerializedName("uin")
        @Nullable
        private final String anchorUin;

        @SerializedName("avatar")
        @Nullable
        private final String avatar;

        @SerializedName("commentNum")
        @Nullable
        private final Integer commentNum;

        @SerializedName("content")
        @Nullable
        private final String content;

        @SerializedName("coverUrl")
        @Nullable
        private final String coverUrl;

        @SerializedName("fuelNum")
        @Nullable
        private final Integer fuelNum;

        @SerializedName("height")
        @Nullable
        private final Integer height;

        @SerializedName("likeNum")
        @Nullable
        private final Integer likeNum;

        @SerializedName("nick")
        @Nullable
        private final String nick;

        @SerializedName("playNum")
        @Nullable
        private final Integer playNum;

        @SerializedName("recomReason")
        @Nullable
        private final String recomReason;

        @SerializedName("shareNum")
        @Nullable
        private final Integer shareNum;

        @SerializedName("type")
        @Nullable
        private final Integer type;

        @SerializedName(QCircleScheme.AttrDetail.VIDEO_INFO)
        @Nullable
        private VideoInfo videoInfo;

        @SerializedName("width")
        @Nullable
        private final Integer width;

        public FeedInfo() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
        }

        @Nullable
        public final String getAnchorUin() {
            return this.anchorUin;
        }

        @Nullable
        public final String getAvatar() {
            return this.avatar;
        }

        @Nullable
        public final Integer getCommentNum() {
            return this.commentNum;
        }

        @Nullable
        public final String getContent() {
            return this.content;
        }

        @Nullable
        public final String getCoverUrl() {
            return this.coverUrl;
        }

        @Nullable
        public final Integer getFuelNum() {
            return this.fuelNum;
        }

        @Nullable
        public final Integer getHeight() {
            return this.height;
        }

        @Nullable
        public final Integer getLikeNum() {
            return this.likeNum;
        }

        @Nullable
        public final String getNick() {
            return this.nick;
        }

        @Nullable
        public final Integer getPlayNum() {
            return this.playNum;
        }

        @Nullable
        public final String getRecomReason() {
            return this.recomReason;
        }

        @Nullable
        public final Integer getShareNum() {
            return this.shareNum;
        }

        @Nullable
        public final Integer getType() {
            return this.type;
        }

        @Nullable
        public final VideoInfo getVideoInfo() {
            return this.videoInfo;
        }

        @Nullable
        public final Integer getWidth() {
            return this.width;
        }

        public final void setVideoInfo(@Nullable VideoInfo videoInfo) {
            this.videoInfo = videoInfo;
        }

        @NotNull
        public final String toJSONStr() {
            String json = new Gson().toJson(this);
            if (json == null) {
                return "";
            }
            return json;
        }

        public FeedInfo(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable Integer num5, @Nullable String str5, @Nullable Integer num6, @Nullable Integer num7, @Nullable String str6, @Nullable Integer num8, @Nullable VideoInfo videoInfo) {
            this.type = num;
            this.nick = str;
            this.avatar = str2;
            this.content = str3;
            this.anchorUin = str4;
            this.likeNum = num2;
            this.fuelNum = num3;
            this.commentNum = num4;
            this.shareNum = num5;
            this.coverUrl = str5;
            this.width = num6;
            this.height = num7;
            this.recomReason = str6;
            this.playNum = num8;
            this.videoInfo = videoInfo;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ FeedInfo(Integer num, String str, String str2, String str3, String str4, Integer num2, Integer num3, Integer num4, Integer num5, String str5, Integer num6, Integer num7, String str6, Integer num8, VideoInfo videoInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? r2 : num, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? "" : str3, (i3 & 16) != 0 ? "" : str4, (i3 & 32) != 0 ? r2 : num2, (i3 & 64) != 0 ? r2 : num3, (i3 & 128) != 0 ? r2 : num4, (i3 & 256) != 0 ? r2 : num5, (i3 & 512) != 0 ? "" : str5, (i3 & 1024) != 0 ? r2 : num6, (i3 & 2048) != 0 ? r2 : num7, (i3 & 4096) == 0 ? str6 : "", (i3 & 8192) == 0 ? num8 : 0, (i3 & 16384) != 0 ? null : videoInfo);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountDetailPageLaunchInfo$RawStringJsonAdapter;", "Lcom/google/gson/TypeAdapter;", "", "()V", k.f247491e, "jsonReader", "Lcom/google/gson/stream/JsonReader;", k.f247492f, "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "qcircle-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class RawStringJsonAdapter extends TypeAdapter<String> {
        @Override // com.google.gson.TypeAdapter
        @NotNull
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public String read2(@NotNull JsonReader jsonReader) {
            Intrinsics.checkNotNullParameter(jsonReader, "jsonReader");
            try {
                String jsonElement = new JsonParser().parse(jsonReader).toString();
                Intrinsics.checkNotNullExpressionValue(jsonElement, "{\n                JsonPa\u2026.toString()\n            }");
                return jsonElement;
            } catch (JsonIOException e16) {
                QLog.e(QCirclePublicAccountDetailPageLaunchInfo.TAG, 1, "RawStringJsonAdapter read exception", e16);
                return "";
            } catch (JsonSyntaxException e17) {
                QLog.e(QCirclePublicAccountDetailPageLaunchInfo.TAG, 1, "RawStringJsonAdapter read exception", e17);
                return "";
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(@NotNull JsonWriter out, @NotNull String value) {
            Intrinsics.checkNotNullParameter(out, "out");
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                out.jsonValue(value);
            } catch (IOException e16) {
                QLog.e(QCirclePublicAccountDetailPageLaunchInfo.TAG, 1, "RawStringJsonAdapter write exception value=" + value, e16);
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0007\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountDetailPageLaunchInfo$VideoInfo;", "", "fileId", "", "playUrl", "duration", "", "isQUIC", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;)V", "getDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFileId", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPlayUrl", "qcircle-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class VideoInfo {

        @SerializedName("duration")
        @Nullable
        private final Long duration;

        @SerializedName("fileId")
        @Nullable
        private final String fileId;

        @SerializedName("isQUIC")
        @Nullable
        private final Boolean isQUIC;

        @SerializedName("playUrl")
        @Nullable
        private final String playUrl;

        public VideoInfo() {
            this(null, null, null, null, 15, null);
        }

        @Nullable
        public final Long getDuration() {
            return this.duration;
        }

        @Nullable
        public final String getFileId() {
            return this.fileId;
        }

        @Nullable
        public final String getPlayUrl() {
            return this.playUrl;
        }

        @Nullable
        /* renamed from: isQUIC, reason: from getter */
        public final Boolean getIsQUIC() {
            return this.isQUIC;
        }

        public VideoInfo(@Nullable String str, @Nullable String str2, @Nullable Long l3, @Nullable Boolean bool) {
            this.fileId = str;
            this.playUrl = str2;
            this.duration = l3;
            this.isQUIC = bool;
        }

        public /* synthetic */ VideoInfo(String str, String str2, Long l3, Boolean bool, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? 0L : l3, (i3 & 8) != 0 ? Boolean.FALSE : bool);
        }
    }

    public QCirclePublicAccountDetailPageLaunchInfo() {
        this(null, null, null, null, null, null, null, null, null, 0, 1023, null);
    }

    @Nullable
    public final String getAnchorUin() {
        return this.anchorUin;
    }

    public final int getAutoPlay() {
        return this.autoPlay;
    }

    @Nullable
    public final Long getCreateTimeSec() {
        return this.createTimeSec;
    }

    @Nullable
    public final String getFeedId() {
        return this.feedId;
    }

    @Nullable
    public final FeedInfo getFeedInfo() {
        return this.feedInfo;
    }

    @Nullable
    public final Integer getFlowType() {
        return this.flowType;
    }

    @Nullable
    public final Integer getPreloadTriggerCount() {
        return this.preloadTriggerCount;
    }

    @Nullable
    public final String getPublicAccountName() {
        return this.publicAccountName;
    }

    @Nullable
    public final String getReportData() {
        return this.reportData;
    }

    @Nullable
    public final String getTransData() {
        return this.transData;
    }

    @Nullable
    public final QCirclePublicAccountDetailPageLaunchInfo parseFromJSONStr(@NotNull String jsonStr) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        try {
            return (QCirclePublicAccountDetailPageLaunchInfo) new Gson().fromJson(jsonStr, QCirclePublicAccountDetailPageLaunchInfo.class);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "parseFromJSONStr error, jsonStr=" + jsonStr, e16);
            return null;
        }
    }

    @NotNull
    public final String toJSONStr() {
        String json = new Gson().toJson(this);
        if (json == null) {
            return "";
        }
        return json;
    }

    public QCirclePublicAccountDetailPageLaunchInfo(@Nullable String str, @Nullable Integer num, @Nullable Integer num2, @Nullable Long l3, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable FeedInfo feedInfo, int i3) {
        this.publicAccountName = str;
        this.flowType = num;
        this.preloadTriggerCount = num2;
        this.createTimeSec = l3;
        this.feedId = str2;
        this.anchorUin = str3;
        this.transData = str4;
        this.reportData = str5;
        this.feedInfo = feedInfo;
        this.autoPlay = i3;
    }

    public /* synthetic */ QCirclePublicAccountDetailPageLaunchInfo(String str, Integer num, Integer num2, Long l3, String str2, String str3, String str4, String str5, FeedInfo feedInfo, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? null : num, (i16 & 4) != 0 ? null : num2, (i16 & 8) != 0 ? 0L : l3, (i16 & 16) != 0 ? "" : str2, (i16 & 32) == 0 ? str3 : "", (i16 & 64) != 0 ? "{}" : str4, (i16 & 128) == 0 ? str5 : "{}", (i16 & 256) == 0 ? feedInfo : null, (i16 & 512) != 0 ? 0 : i3);
    }
}
