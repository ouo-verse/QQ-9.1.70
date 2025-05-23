package com.tencent.mobileqq.vas.config.business.qvip;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SSOErrorInfoMapConfig implements Serializable {
    public HashMap<String, ErrorInfoMap> mErrorMap = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class ErrorInfoMap {
        public HashMap<String, LocaleInfoMap> mErrorInfoMap = new HashMap<>();
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class LocaleInfoMap {
        public HashMap<String, String> mLocalInfoMap = new HashMap<>();
    }

    public String getErrorInfo(String str, String str2) {
        if (this.mErrorMap.containsKey(str)) {
            ErrorInfoMap errorInfoMap = this.mErrorMap.get(str);
            if (errorInfoMap.mErrorInfoMap.containsKey(str2)) {
                LocaleInfoMap localeInfoMap = errorInfoMap.mErrorInfoMap.get(str2);
                String country = Locale.getDefault().getCountry();
                String str3 = Locale.getDefault().getLanguage().toLowerCase() + "_" + country.toLowerCase();
                if (localeInfoMap.mLocalInfoMap.containsKey(str3)) {
                    return localeInfoMap.mLocalInfoMap.get(str3);
                }
                return null;
            }
            return null;
        }
        return null;
    }
}
