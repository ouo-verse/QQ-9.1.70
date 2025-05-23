package com.tencent.qqmini.sdk.launcher.model;

import java.util.Properties;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MtaReportSt {
    public String reportKey;
    public Properties reportObj;

    public MtaReportSt(String str, Properties properties) {
        this.reportObj = properties;
        this.reportKey = str;
    }
}
