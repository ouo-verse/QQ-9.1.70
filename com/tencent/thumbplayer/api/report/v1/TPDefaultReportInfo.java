package com.tencent.thumbplayer.api.report.v1;

import java.util.Properties;

/* loaded from: classes26.dex */
public abstract class TPDefaultReportInfo {
    public String appVersion;
    public int cdnId;
    public String cdnIp;
    public String cdnUip;
    public int cdnUrlIndex;
    public int dlType;
    public boolean enableP2p;
    public Properties extraReportInfo;
    public int freeType;
    public String guid;
    public boolean isOnline;
    public int loginType;
    public float mediaDuration;
    public int mediaFormat;
    public int mediaRate;
    public String mediaResolution;
    public long platform;
    public String qqOpenId;
    public int scenesId;
    public int subtitleCdnType;
    public int subtitleUrlIndex;
    public int testId;
    public String uin;
    public String uip;
    public String vid;
    public String wxOpenId;

    public abstract int getPlayType();
}
