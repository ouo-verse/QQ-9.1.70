package com.tencent.mobileqq.mini.out.webPlugins;

import android.content.Intent;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.webview.swift.f;

/* loaded from: classes33.dex */
public class MiniCreatePluginChecker implements f {
    @Override // com.tencent.mobileqq.webview.swift.f
    public String[] providePreCreatePlugins(Intent intent, String str, String str2) {
        if (!str.contains("sou.qq.com") && !MiniAppLauncher.isMiniAppUrl(str)) {
            return new String[0];
        }
        return new String[]{"miniApp"};
    }

    @Override // com.tencent.mobileqq.webview.swift.c
    public void onPreInit() {
    }
}
