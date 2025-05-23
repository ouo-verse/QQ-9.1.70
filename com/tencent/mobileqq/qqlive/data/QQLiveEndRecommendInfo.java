package com.tencent.mobileqq.qqlive.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveEndRecommendInfo {
    static IPatchRedirector $redirector_;
    public int gameId;
    public int gameTagId;
    public boolean hasWeaponIcon;
    public String headerUrl;
    public String nick;
    public long popularity;
    public String roomBg;
    public long roomId;
    public String roomTitle;
    public int roomType;
    public String rtmpUrl;
    public String traceInfo;
    public String videoId;
    public long videoSource;
    public String videoUrl;

    public QQLiveEndRecommendInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.roomBg = "";
        this.nick = "";
        this.popularity = 0L;
        this.roomTitle = "";
        this.headerUrl = "";
        this.videoUrl = "";
        this.videoId = "";
        this.rtmpUrl = "";
        this.traceInfo = "";
        this.hasWeaponIcon = false;
    }
}
