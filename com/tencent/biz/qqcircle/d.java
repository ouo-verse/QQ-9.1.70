package com.tencent.biz.qqcircle;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$Entry;
import java.net.URI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final HashSet<String> f84158a;

    static {
        HashSet<String> hashSet = new HashSet<>();
        f84158a = hashSet;
        hashSet.add("_wwv");
        hashSet.add("_proxy");
        hashSet.add("_wv");
    }

    private static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_url_white_list_check", false)) {
            return true;
        }
        String A4 = uq3.c.A4();
        if (TextUtils.isEmpty(A4)) {
            QLog.e("QCircleJsUrlConfig", 1, "checkDomainIsValid whiteList is empty, use default whiteList");
            A4 = ".qq.com,.tencent.com";
        }
        for (String str2 : A4.split(",")) {
            if (str.endsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(@NonNull String str) {
        try {
            URI uri = new URI(str.trim());
            String host = uri.getHost();
            QLog.d("QCircleJsUrlConfig", 1, "url:" + str + " domain:" + host);
            if (TextUtils.isEmpty(host) || !a(host)) {
                return false;
            }
            if (!uri.getScheme().equals("https")) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static HashMap<String, String> c(String str) {
        Uri parse;
        try {
            if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null) {
                HashMap<String, String> hashMap = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    hashMap.put(str2, parse.getQueryParameter(str2));
                }
                return hashMap;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return new HashMap<>();
    }

    public static String d(List<FeedCloudCommon$Entry> list, String str) {
        return QCirclePluginUtil.getValueFromListEntry(list, str, "");
    }
}
