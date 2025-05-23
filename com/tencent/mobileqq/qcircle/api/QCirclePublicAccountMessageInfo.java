package com.tencent.mobileqq.qcircle.api;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b.\b\u0086\b\u0018\u0000 62\u00020\u0001:\u00016B\u0085\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0011J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0016J\u0010\u0010&\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001cJ\t\u0010'\u001a\u00020\tH\u00c6\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0016J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u008e\u0001\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010.J\u0013\u0010/\u001a\u00020\u00052\b\u00100\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00101\u001a\u00020\tH\u00d6\u0001J\u0010\u00102\u001a\u0004\u0018\u00010\u00002\u0006\u00103\u001a\u00020\u0003J\u0006\u00104\u001a\u00020\u0003J\t\u00105\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0004\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0013\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountMessageInfo;", "", "feedId", "", "isLocal", "", "receiveTimeSec", "", "redDotType", "", "hasOrangeWord", WadlProxyConsts.KEY_JUMP_URL, "reportData", "videoPlayUrl", "coverUrl", "launchInfoStr", "id", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;ILjava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCoverUrl", "()Ljava/lang/String;", "getFeedId", "getHasOrangeWord", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getId", "getJumpUrl", "getLaunchInfoStr", "getReceiveTimeSec", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getRedDotType", "()I", "getReportData", "getVideoPlayUrl", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;ILjava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountMessageInfo;", "equals", "other", "hashCode", "parseFromJSONStr", "jsonStr", "toJSONStr", "toString", "Companion", "qcircle-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final /* data */ class QCirclePublicAccountMessageInfo {
    public static final int RED_DOT_TYPE_NONE = 1;
    public static final int RED_DOT_TYPE_NORMAL = 2;
    public static final int RED_DOT_TYPE_NUM = 3;
    public static final int RED_DOT_TYPE_UNKNOWN = 0;

    @Nullable
    private final String coverUrl;

    @Nullable
    private final String feedId;

    @Nullable
    private final Boolean hasOrangeWord;

    @NotNull
    private final String id;

    @Nullable
    private final Boolean isLocal;

    @Nullable
    private final String jumpUrl;

    @Nullable
    private final String launchInfoStr;

    @Nullable
    private final Long receiveTimeSec;
    private final int redDotType;

    @Nullable
    private final String reportData;

    @Nullable
    private final String videoPlayUrl;

    public QCirclePublicAccountMessageInfo() {
        this(null, null, null, 0, null, null, null, null, null, null, null, 2047, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final String getLaunchInfoStr() {
        return this.launchInfoStr;
    }

    @NotNull
    /* renamed from: component11, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Boolean getIsLocal() {
        return this.isLocal;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Long getReceiveTimeSec() {
        return this.receiveTimeSec;
    }

    /* renamed from: component4, reason: from getter */
    public final int getRedDotType() {
        return this.redDotType;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Boolean getHasOrangeWord() {
        return this.hasOrangeWord;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getReportData() {
        return this.reportData;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getVideoPlayUrl() {
        return this.videoPlayUrl;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @NotNull
    public final QCirclePublicAccountMessageInfo copy(@Nullable String feedId, @Nullable Boolean isLocal, @Nullable Long receiveTimeSec, int redDotType, @Nullable Boolean hasOrangeWord, @Nullable String jumpUrl, @Nullable String reportData, @Nullable String videoPlayUrl, @Nullable String coverUrl, @Nullable String launchInfoStr, @NotNull String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        return new QCirclePublicAccountMessageInfo(feedId, isLocal, receiveTimeSec, redDotType, hasOrangeWord, jumpUrl, reportData, videoPlayUrl, coverUrl, launchInfoStr, id5);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QCirclePublicAccountMessageInfo)) {
            return false;
        }
        QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo = (QCirclePublicAccountMessageInfo) other;
        if (Intrinsics.areEqual(this.feedId, qCirclePublicAccountMessageInfo.feedId) && Intrinsics.areEqual(this.isLocal, qCirclePublicAccountMessageInfo.isLocal) && Intrinsics.areEqual(this.receiveTimeSec, qCirclePublicAccountMessageInfo.receiveTimeSec) && this.redDotType == qCirclePublicAccountMessageInfo.redDotType && Intrinsics.areEqual(this.hasOrangeWord, qCirclePublicAccountMessageInfo.hasOrangeWord) && Intrinsics.areEqual(this.jumpUrl, qCirclePublicAccountMessageInfo.jumpUrl) && Intrinsics.areEqual(this.reportData, qCirclePublicAccountMessageInfo.reportData) && Intrinsics.areEqual(this.videoPlayUrl, qCirclePublicAccountMessageInfo.videoPlayUrl) && Intrinsics.areEqual(this.coverUrl, qCirclePublicAccountMessageInfo.coverUrl) && Intrinsics.areEqual(this.launchInfoStr, qCirclePublicAccountMessageInfo.launchInfoStr) && Intrinsics.areEqual(this.id, qCirclePublicAccountMessageInfo.id)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @Nullable
    public final String getFeedId() {
        return this.feedId;
    }

    @Nullable
    public final Boolean getHasOrangeWord() {
        return this.hasOrangeWord;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @Nullable
    public final String getLaunchInfoStr() {
        return this.launchInfoStr;
    }

    @Nullable
    public final Long getReceiveTimeSec() {
        return this.receiveTimeSec;
    }

    public final int getRedDotType() {
        return this.redDotType;
    }

    @Nullable
    public final String getReportData() {
        return this.reportData;
    }

    @Nullable
    public final String getVideoPlayUrl() {
        return this.videoPlayUrl;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8;
        String str = this.feedId;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        Boolean bool = this.isLocal;
        if (bool == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = bool.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        Long l3 = this.receiveTimeSec;
        if (l3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = l3.hashCode();
        }
        int i18 = (((i17 + hashCode3) * 31) + this.redDotType) * 31;
        Boolean bool2 = this.hasOrangeWord;
        if (bool2 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = bool2.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        String str2 = this.jumpUrl;
        if (str2 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str2.hashCode();
        }
        int i26 = (i19 + hashCode5) * 31;
        String str3 = this.reportData;
        if (str3 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = str3.hashCode();
        }
        int i27 = (i26 + hashCode6) * 31;
        String str4 = this.videoPlayUrl;
        if (str4 == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = str4.hashCode();
        }
        int i28 = (i27 + hashCode7) * 31;
        String str5 = this.coverUrl;
        if (str5 == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = str5.hashCode();
        }
        int i29 = (i28 + hashCode8) * 31;
        String str6 = this.launchInfoStr;
        if (str6 != null) {
            i3 = str6.hashCode();
        }
        return ((i29 + i3) * 31) + this.id.hashCode();
    }

    @Nullable
    public final Boolean isLocal() {
        return this.isLocal;
    }

    @Nullable
    public final QCirclePublicAccountMessageInfo parseFromJSONStr(@NotNull String jsonStr) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        try {
            return (QCirclePublicAccountMessageInfo) new Gson().fromJson(jsonStr, QCirclePublicAccountMessageInfo.class);
        } catch (JsonSyntaxException e16) {
            QLog.e("IQCirclePublicAccountMessageService", 1, "parse MessageInfo FromJSONStr error, jsonStr=" + jsonStr, e16);
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

    @NotNull
    public String toString() {
        return "QCirclePublicAccountMessageInfo(feedId=" + this.feedId + ", isLocal=" + this.isLocal + ", receiveTimeSec=" + this.receiveTimeSec + ", redDotType=" + this.redDotType + ", hasOrangeWord=" + this.hasOrangeWord + ", jumpUrl=" + this.jumpUrl + ", reportData=" + this.reportData + ", videoPlayUrl=" + this.videoPlayUrl + ", coverUrl=" + this.coverUrl + ", launchInfoStr=" + this.launchInfoStr + ", id=" + this.id + ')';
    }

    public QCirclePublicAccountMessageInfo(@Nullable String str, @Nullable Boolean bool, @Nullable Long l3, int i3, @Nullable Boolean bool2, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @NotNull String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        this.feedId = str;
        this.isLocal = bool;
        this.receiveTimeSec = l3;
        this.redDotType = i3;
        this.hasOrangeWord = bool2;
        this.jumpUrl = str2;
        this.reportData = str3;
        this.videoPlayUrl = str4;
        this.coverUrl = str5;
        this.launchInfoStr = str6;
        this.id = id5;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ QCirclePublicAccountMessageInfo(String str, Boolean bool, Long l3, int i3, Boolean bool2, String str2, String str3, String str4, String str5, String str6, String str7, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r0);
        String str8;
        String str9 = (i16 & 1) != 0 ? "" : str;
        Boolean bool3 = (i16 & 2) != 0 ? Boolean.FALSE : bool;
        Long l16 = (i16 & 4) != 0 ? 0L : l3;
        int i17 = (i16 & 8) != 0 ? 0 : i3;
        Boolean bool4 = (i16 & 16) != 0 ? Boolean.FALSE : bool2;
        String str10 = (i16 & 32) != 0 ? "" : str2;
        String str11 = (i16 & 64) != 0 ? "" : str3;
        String str12 = (i16 & 128) != 0 ? "" : str4;
        String str13 = (i16 & 256) != 0 ? "" : str5;
        String str14 = (i16 & 512) != 0 ? "" : str6;
        if ((i16 & 1024) != 0) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str9 != null ? str9 : "");
            sb5.append(l16);
            str8 = sb5.toString();
        } else {
            str8 = str7;
        }
    }
}
