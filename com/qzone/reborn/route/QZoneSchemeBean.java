package com.qzone.reborn.route;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneSchemeBean implements Serializable {
    public static final String KEY_SCHEME = "key_scheme";
    public static final String QZONE_BUSINESS_PREFIX = "arouse";
    public static final String REGEX = "\\?";
    private static final long serialVersionUID = 5838484954896817978L;
    private HashMap<String, String> mAttrs;
    private String mBusinessAction;
    private String mPageAction;
    private String mScheme;

    private void a(String[] strArr) {
        if (strArr.length == 2) {
            this.mBusinessAction = "fake_business";
            this.mPageAction = strArr[1];
        } else if (strArr.length == 3) {
            this.mBusinessAction = strArr[1];
            this.mPageAction = strArr[2];
        }
    }

    private void b(String str) {
        Uri parse = Uri.parse(str);
        Set<String> queryParameterNames = parse.getQueryParameterNames();
        if (this.mAttrs == null) {
            this.mAttrs = new HashMap<>();
        }
        this.mAttrs.put("key_scheme", str);
        for (String str2 : queryParameterNames) {
            if (!TextUtils.isEmpty(str2)) {
                String queryParameter = parse.getQueryParameter(str2);
                if (!TextUtils.isEmpty(queryParameter)) {
                    this.mAttrs.put(str2, queryParameter);
                }
            }
        }
    }

    public QZoneSchemeBean convertSchemeToBean(String str) {
        String[] split;
        if (TextUtils.isEmpty(str)) {
            QLog.e("QZoneSchemeBean", 1, "convertSchemeToBean jumpStr == null");
            return this;
        }
        try {
            this.mScheme = str;
            split = str.split("\\?");
        } catch (Exception e16) {
            QLog.e("QZoneSchemeBean", 1, "convertSchemeToBean e = " + e16);
        }
        if (split.length < 1) {
            return this;
        }
        String[] split2 = split[0].substring(9).split("/");
        if (split2.length < 2 || !QZONE_BUSINESS_PREFIX.equals(split2[0])) {
            return this;
        }
        a(split2);
        b(str);
        return this;
    }

    public HashMap<String, String> getAttrs() {
        return this.mAttrs;
    }

    public String getBusinessAction() {
        return this.mBusinessAction;
    }

    public String getPageAction() {
        return this.mPageAction;
    }

    public String getScheme() {
        return this.mScheme;
    }
}
