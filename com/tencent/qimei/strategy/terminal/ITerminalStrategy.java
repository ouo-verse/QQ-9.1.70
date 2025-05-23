package com.tencent.qimei.strategy.terminal;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface ITerminalStrategy {
    @Deprecated
    ITerminalStrategy enableAndroidId(boolean z16);

    ITerminalStrategy enableAudit(boolean z16);

    @Deprecated
    ITerminalStrategy enableBuildModel(boolean z16);

    @Deprecated
    ITerminalStrategy enableCid(boolean z16);

    @Deprecated
    ITerminalStrategy enableIMEI(boolean z16);

    @Deprecated
    ITerminalStrategy enableIMSI(boolean z16);

    boolean enableIp();

    @Deprecated
    ITerminalStrategy enableMAC(boolean z16);

    @Deprecated
    ITerminalStrategy enableOAID(boolean z16);

    @Deprecated
    ITerminalStrategy enableProcessInfo(boolean z16);

    ITerminalStrategy setAndroidId(String str);

    ITerminalStrategy setAuditDomain(String str, int i3);

    ITerminalStrategy setAuditErrUrl(String str);

    ITerminalStrategy setAuditSoPath(String str);

    ITerminalStrategy setBuildModel(String str);

    @Deprecated
    ITerminalStrategy setCid(String str);

    ITerminalStrategy setHidProcess(String str);

    @Deprecated
    ITerminalStrategy setIMEI(String str);

    @Deprecated
    ITerminalStrategy setIMSI(String str);

    @Deprecated
    ITerminalStrategy setMAC(String str);

    ITerminalStrategy setOAID(String str);

    ITerminalStrategy setQimeiSoPath(String str);

    ITerminalStrategy setReportDomain(String str);

    ITerminalStrategy setUserAgreePrivacy(boolean z16);
}
