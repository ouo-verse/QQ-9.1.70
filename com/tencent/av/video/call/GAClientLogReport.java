package com.tencent.av.video.call;

import com.tencent.avcore.jni.log.GAClientLogReportJni;
import com.tencent.avcore.jni.log.IClientLogReport;

/* compiled from: P */
/* loaded from: classes3.dex */
public class GAClientLogReport implements IClientLogReport {
    private static GAClientLogReport instance;
    private final GAClientLogReportJni mJni = new GAClientLogReportJni(this);

    GAClientLogReport() {
    }

    public static GAClientLogReport instance() {
        if (instance == null) {
            instance = new GAClientLogReport();
        }
        return instance;
    }

    @Override // com.tencent.avcore.jni.log.IClientLogReport
    public int sendLog(long j3, String str, byte[] bArr, boolean z16) {
        return ClientLogReport.instance().sendLog(j3, str, bArr, z16);
    }
}
