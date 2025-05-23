package com.tencent.open.api.impl;

import com.tencent.open.api.IOpenBrowserAppInfo;
import com.tencent.open.e;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OpenBrowserAppInfoImpl implements IOpenBrowserAppInfo {
    @Override // com.tencent.open.api.IOpenBrowserAppInfo
    public String getBrowserAppPackage(AppRuntime appRuntime, String str) {
        String c16 = e.b().c(appRuntime, str);
        if (c16 == null) {
            return "";
        }
        return c16;
    }

    @Override // com.tencent.open.api.IOpenBrowserAppInfo
    public String getBrowserAppSign(AppRuntime appRuntime, String str) {
        String a16 = e.b().a(appRuntime, str);
        if (a16 == null) {
            return "";
        }
        return a16;
    }
}
