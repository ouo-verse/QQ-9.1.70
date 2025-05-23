package com.tencent.tmassistantsdk.internal.logreport;

import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.internal.protocol.jce.StatStdReport;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b extends a {

    /* renamed from: d, reason: collision with root package name */
    protected static b f380554d;

    b() {
    }

    public static synchronized b g() {
        b bVar;
        synchronized (b.class) {
            if (f380554d == null) {
                f380554d = new b();
            }
            bVar = f380554d;
        }
        return bVar;
    }

    @Override // com.tencent.tmassistantsdk.internal.logreport.a
    protected boolean a() {
        return true;
    }

    @Override // com.tencent.tmassistantsdk.internal.logreport.a
    protected com.tencent.tmassistant.common.a.a c() {
        return com.tencent.tmassistantsdk.a.c.a.a.e();
    }

    @Override // com.tencent.tmassistantsdk.internal.logreport.a
    protected byte d() {
        return (byte) 3;
    }

    public StatStdReport a(String str, String str2, String str3) {
        StatStdReport statStdReport = new StatStdReport();
        statStdReport.name = str3;
        statStdReport.time = System.currentTimeMillis();
        statStdReport.versionInfo = "1.3";
        statStdReport.extraData = str;
        statStdReport.traceId = str2;
        return statStdReport;
    }

    public static String a(TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct) {
        StringBuffer stringBuffer = new StringBuffer();
        if (tMAssistantCallYYBParamStruct != null) {
            stringBuffer.append(GlobalUtil.getAppPackageName(GlobalUtil.getInstance().getContext()));
            stringBuffer.append("_");
            stringBuffer.append(String.valueOf(GlobalUtil.getAppVersionCode(GlobalUtil.getInstance().getContext())));
            stringBuffer.append("_");
            stringBuffer.append(tMAssistantCallYYBParamStruct.channelId);
            stringBuffer.append("_");
            stringBuffer.append(tMAssistantCallYYBParamStruct.via);
            stringBuffer.append("_");
            stringBuffer.append(tMAssistantCallYYBParamStruct.uin);
            stringBuffer.append("_");
            stringBuffer.append(tMAssistantCallYYBParamStruct.taskAppId);
            stringBuffer.append("_");
            stringBuffer.append(tMAssistantCallYYBParamStruct.taskPackageName);
            stringBuffer.append("_");
            stringBuffer.append(tMAssistantCallYYBParamStruct.taskVersion);
        }
        return stringBuffer.toString();
    }
}
