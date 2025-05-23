package com.tencent.biz.webviewplugin;

import android.content.Intent;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ac implements com.tencent.mobileqq.webview.swift.f, com.tencent.mobileqq.webview.swift.e {
    @Override // com.tencent.mobileqq.webview.swift.e
    public String[] a(Intent intent) {
        if (intent.getBooleanExtra("fromQZone", false)) {
            return new String[]{QzonePlugin.C};
        }
        return new String[0];
    }

    @Override // com.tencent.mobileqq.webview.swift.f
    public String[] providePreCreatePlugins(Intent intent, String str, String str2) {
        if (intent.getBooleanExtra("fromQZone", false) && (str2.equals("http") || str2.equals("https"))) {
            return new String[]{QzonePlugin.C};
        }
        return new String[0];
    }

    @Override // com.tencent.mobileqq.webview.swift.c
    public void onPreInit() {
    }
}
