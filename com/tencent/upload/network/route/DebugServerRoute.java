package com.tencent.upload.network.route;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.upload.network.route.IUploadRouteStrategy;
import cooperation.qzone.util.QZoneAppCtrlUploadFileLogic;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes27.dex */
public final class DebugServerRoute {
    private static final /* synthetic */ DebugServerRoute[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final DebugServerRoute CUSTOM;
    public static final DebugServerRoute DB;
    public static final DebugServerRoute DEBUG1;
    public static final DebugServerRoute DEBUG2;
    public static final DebugServerRoute DEBUG3;
    public static final DebugServerRoute DEBUG4;
    public static final DebugServerRoute DEBUG5;
    public static final DebugServerRoute DEBUG6;
    public static final DebugServerRoute DEBUG7;
    public static final DebugServerRoute DEBUG8;
    public static final DebugServerRoute DEBUG9;
    public static final DebugServerRoute DEV;
    private String desc;
    private String serverIp;
    private int serverPort;
    private int type;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11454);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        DebugServerRoute debugServerRoute = new DebugServerRoute(QZoneAppCtrlUploadFileLogic.DB_PATH, 0, 1, QZoneAppCtrlUploadFileLogic.DB_PATH, "113.108.67.20", TVKEventId.PLAYER_STATE_SPEED_RATIO_CHANGED);
        DB = debugServerRoute;
        DebugServerRoute debugServerRoute2 = new DebugServerRoute("DEV", 1, 2, "\u5f00\u53d1", "113.108.67.16", TVKEventId.PLAYER_STATE_SPEED_RATIO_CHANGED);
        DEV = debugServerRoute2;
        DebugServerRoute debugServerRoute3 = new DebugServerRoute("DEBUG1", 2, 3, "\u8054\u8c031", "183.61.56.21", TVKEventId.PLAYER_STATE_SPEED_RATIO_CHANGED);
        DEBUG1 = debugServerRoute3;
        DebugServerRoute debugServerRoute4 = new DebugServerRoute("DEBUG2", 3, 4, "\u8054\u8c032", "183.61.56.21", TVKEventId.PLAYER_STATE_SPEED_RATIO_CHANGED);
        DEBUG2 = debugServerRoute4;
        DebugServerRoute debugServerRoute5 = new DebugServerRoute("DEBUG3", 4, 5, "\u8054\u8c033", "113.108.84.33", TVKEventId.PLAYER_STATE_SPEED_RATIO_CHANGED);
        DEBUG3 = debugServerRoute5;
        DebugServerRoute debugServerRoute6 = new DebugServerRoute("DEBUG4", 5, 6, "\u8054\u8c034", "113.108.89.186", TVKEventId.PLAYER_STATE_SPEED_RATIO_CHANGED);
        DEBUG4 = debugServerRoute6;
        DebugServerRoute debugServerRoute7 = new DebugServerRoute("DEBUG5", 6, 7, "\u8054\u8c035", "59.37.116.68", TVKEventId.PLAYER_STATE_SPEED_RATIO_CHANGED);
        DEBUG5 = debugServerRoute7;
        DebugServerRoute debugServerRoute8 = new DebugServerRoute("DEBUG6", 7, 8, "\u8054\u8c036", "183.61.56.21", TVKEventId.PLAYER_STATE_SPEED_RATIO_CHANGED);
        DEBUG6 = debugServerRoute8;
        DebugServerRoute debugServerRoute9 = new DebugServerRoute("DEBUG7", 8, 9, "\u8054\u8c037", "58.250.9.61", TVKEventId.PLAYER_STATE_SPEED_RATIO_CHANGED);
        DEBUG7 = debugServerRoute9;
        DebugServerRoute debugServerRoute10 = new DebugServerRoute("DEBUG8", 9, 10, "\u8054\u8c038", "58.250.9.60", TVKEventId.PLAYER_STATE_SPEED_RATIO_CHANGED);
        DEBUG8 = debugServerRoute10;
        DebugServerRoute debugServerRoute11 = new DebugServerRoute("DEBUG9", 10, 11, "\u8054\u8c039", "58.251.80.171", TVKEventId.PLAYER_STATE_SPEED_RATIO_CHANGED);
        DEBUG9 = debugServerRoute11;
        DebugServerRoute debugServerRoute12 = new DebugServerRoute("CUSTOM", 11, 1000, "\u81ea\u5b9a\u4e49", "183.61.56.21", TVKEventId.PLAYER_STATE_SPEED_RATIO_CHANGED);
        CUSTOM = debugServerRoute12;
        $VALUES = new DebugServerRoute[]{debugServerRoute, debugServerRoute2, debugServerRoute3, debugServerRoute4, debugServerRoute5, debugServerRoute6, debugServerRoute7, debugServerRoute8, debugServerRoute9, debugServerRoute10, debugServerRoute11, debugServerRoute12};
    }

    DebugServerRoute(String str, int i3, int i16, String str2, String str3, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2, str3, Integer.valueOf(i17));
            return;
        }
        this.type = i16;
        this.desc = str2;
        this.serverIp = str3;
        this.serverPort = i17;
    }

    public static DebugServerRoute getByType(int i3) {
        for (DebugServerRoute debugServerRoute : values()) {
            if (debugServerRoute.type == i3) {
                return debugServerRoute;
            }
        }
        return null;
    }

    public static DebugServerRoute valueOf(String str) {
        return (DebugServerRoute) Enum.valueOf(DebugServerRoute.class, str);
    }

    public static DebugServerRoute[] values() {
        return (DebugServerRoute[]) $VALUES.clone();
    }

    public String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.desc;
    }

    public String getServerIp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.serverIp;
    }

    public int getServerPort() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.serverPort;
    }

    public int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.type;
    }

    public UploadRoute getUploadRoute() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (UploadRoute) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new UploadRoute(this.serverIp, this.serverPort, IUploadRouteStrategy.RouteCategoryType.RECENT);
    }

    public void setServerIp(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            if (this.type != CUSTOM.getType()) {
                return;
            }
            this.serverIp = str;
        }
    }

    public void setServerPort(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            if (this.type != CUSTOM.getType()) {
                return;
            }
            this.serverPort = i3;
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.desc + "(" + this.serverIp + ":" + this.serverPort + ")";
    }
}
