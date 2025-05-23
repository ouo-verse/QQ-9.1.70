package com.tencent.mobileqq.qqlive.data.record;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveSwitchRoom {
    static IPatchRedirector $redirector_ = null;
    public static final long VIDEO_SOURCE_ILLEGAL = 65536;
    public String anchorHead;
    public String anchorNick;
    public String coverUrl;
    public long equipStatus;
    public int gameId;
    public int gameTagId;
    public String liveProductType;
    public boolean pip;
    public Long popularity;
    public long roomId;
    public int roomType;
    public String rtmpUrl;
    public String title;
    public String traceInfo;
    public String videoId;
    public long videoSource;
    public String videoUrl;

    public QQLiveSwitchRoom(long j3, String str, String str2, int i3, int i16, int i17, long j16, String str3, String str4, Long l3, String str5, String str6, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), str, str2, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Long.valueOf(j16), str3, str4, l3, str5, str6, Long.valueOf(j17));
            return;
        }
        this.rtmpUrl = "";
        this.traceInfo = "";
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "QQLiveSwitchRoom{roomId=" + this.roomId + ", videoUrl='" + this.videoUrl + "', videoId='" + this.videoId + "', roomType=" + this.roomType + ", gameId=" + this.gameId + ", gameTagId=" + this.gameTagId + ", videoSource=" + this.videoSource + ", coverUrl='" + this.coverUrl + "', title='" + this.title + "', popularity=" + this.popularity + ", anchorNick='" + this.anchorNick + "', rtmpUrl='" + this.rtmpUrl + "', traceInfo='" + this.traceInfo + "'}";
    }
}
