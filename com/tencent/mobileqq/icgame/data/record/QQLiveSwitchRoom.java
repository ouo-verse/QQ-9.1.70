package com.tencent.mobileqq.icgame.data.record;

/* compiled from: P */
/* loaded from: classes15.dex */
public class QQLiveSwitchRoom {
    public static final long VIDEO_SOURCE_ILLEGAL = 65536;
    public String anchorHead;
    public String anchorNick;
    public String coverUrl;
    public long equipStatus;
    public int gameId;
    public int gameTagId;
    public Long popularity;
    public long roomId;
    public int roomType;
    public String title;
    public String videoId;
    public long videoSource;
    public String videoUrl;
    public String rtmpUrl = "";
    public String traceInfo = "";

    public QQLiveSwitchRoom(long j3, String str, String str2, int i3, int i16, int i17, long j16, String str3, String str4, Long l3, String str5, String str6, long j17) {
        this.roomId = j3;
        this.videoUrl = str;
        this.videoId = str2;
        this.roomType = i3;
        this.gameId = i16;
        this.gameTagId = i17;
        this.videoSource = j16;
        this.coverUrl = str3;
        this.title = str4;
        this.popularity = l3;
        this.anchorNick = str5;
        this.anchorHead = str6;
        this.equipStatus = j17;
    }

    public String toString() {
        return "QQLiveSwitchRoom{roomId=" + this.roomId + ", videoUrl='" + this.videoUrl + "', videoId='" + this.videoId + "', roomType=" + this.roomType + ", gameId=" + this.gameId + ", gameTagId=" + this.gameTagId + ", videoSource=" + this.videoSource + ", coverUrl='" + this.coverUrl + "', title='" + this.title + "', popularity=" + this.popularity + ", anchorNick='" + this.anchorNick + "', rtmpUrl='" + this.rtmpUrl + "', traceInfo='" + this.traceInfo + "'}";
    }
}
