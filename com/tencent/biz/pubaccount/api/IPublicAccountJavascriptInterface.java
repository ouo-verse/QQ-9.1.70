package com.tencent.biz.pubaccount.api;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

@QAPI(process = {"all"})
/* loaded from: classes4.dex */
public interface IPublicAccountJavascriptInterface extends QRouteApi {
    public static final String KEY_PUB_UIN = "pubUin";
    public static final long MAX_H5_DATA_SIZE = 52428800;
    public static final String NAME_SPACE = "publicAccount";

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f79347a;

        /* renamed from: b, reason: collision with root package name */
        public String f79348b;

        /* renamed from: c, reason: collision with root package name */
        public String f79349c;
    }

    void deleteAllH5Data(AppInterface appInterface);

    int excuteShowProfile(AppInterface appInterface, Context context, String str);

    String getDataPath();

    boolean getLocationPermissionGrant(String str, String str2);

    WebViewPlugin getWebViewPlugin();
}
