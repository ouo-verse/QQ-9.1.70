package com.tencent.mobileqq.webview.api.impl;

import android.content.Intent;
import com.tencent.mobileqq.webview.api.IBlessJsApi;

/* compiled from: P */
/* loaded from: classes35.dex */
public class BlessJsApiImpl implements IBlessJsApi {
    @Override // com.tencent.mobileqq.webview.api.IBlessJsApi
    public Intent getPtvIntent(Intent intent, String str, String str2, String str3, String str4, String str5, String str6) {
        if (intent == null) {
            intent = new Intent();
        }
        if (str == null) {
            str = "";
        }
        intent.putExtra("bless_ptv_url", str);
        if (str2 == null) {
            str2 = "";
        }
        intent.putExtra("bless_ptv_uuid", str2);
        if (str3 == null) {
            str3 = "";
        }
        intent.putExtra("bless_ptv_md5", str3);
        if (str4 == null) {
            str4 = "";
        }
        intent.putExtra("bless_ptv_nick", str4);
        if (str5 == null) {
            str5 = "";
        }
        intent.putExtra("ptv_file_path", str5);
        if (str6 == null) {
            str6 = "";
        }
        intent.putExtra("ptv_thumb_path", str6);
        return intent;
    }

    @Override // com.tencent.mobileqq.webview.api.IBlessJsApi
    public Intent getBlessIntent(Intent intent, String str, int i3, int i16) {
        if (intent == null) {
            intent = new Intent();
        }
        intent.setAction("com.tencent.mobileqq.BlessJsApiPlugin");
        if (str == null) {
            str = "";
        }
        intent.putExtra("callback", str);
        intent.putExtra("bless_type", i3);
        intent.putExtra("bless_num", i16);
        return intent;
    }
}
