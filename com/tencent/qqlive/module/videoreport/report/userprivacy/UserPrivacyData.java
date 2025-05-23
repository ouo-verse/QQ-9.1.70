package com.tencent.qqlive.module.videoreport.report.userprivacy;

import android.text.TextUtils;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes22.dex */
public class UserPrivacyData {
    private static final String SEPARATE = "#*";
    private String mAccountId;
    private int mCount;
    public Map<String, String> mInfoMap = new ConcurrentHashMap();
    private String mMainLogin;

    public UserPrivacyData(String str, String str2, Map<String, String> map) {
        this.mCount = 0;
        this.mAccountId = str;
        this.mMainLogin = str2;
        for (String str3 : map.keySet()) {
            this.mInfoMap.put(formatString(str3), formatString(map.get(str3)));
        }
        this.mCount = 1;
    }

    private void filterSet(Set<String> set, Set<String> set2) {
        if (set != null && set2 != null) {
            for (String str : set2) {
                if (!TextUtils.isEmpty(str)) {
                    set.remove(str);
                }
            }
        }
    }

    private String formatString(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public void append(Map<String, String> map) {
        int i3;
        for (String str : this.mInfoMap.keySet()) {
            String str2 = this.mInfoMap.get(str) + SEPARATE;
            if (map.containsKey(str)) {
                str2 = str2 + formatString(map.get(str));
            }
            this.mInfoMap.put(str, formatString(str2));
        }
        Set<String> keySet = this.mInfoMap.keySet();
        Set<String> keySet2 = map.keySet();
        filterSet(keySet2, keySet);
        StringBuilder sb5 = new StringBuilder();
        int i16 = 0;
        while (true) {
            i3 = this.mCount;
            if (i16 >= i3) {
                break;
            }
            sb5.append(SEPARATE);
            i16++;
        }
        this.mCount = i3 + 1;
        for (String str3 : keySet2) {
            this.mInfoMap.put(formatString(str3), ((Object) sb5) + formatString(map.get(str3)));
        }
    }

    public String getAccountId() {
        return this.mAccountId;
    }

    public int getCount() {
        return this.mCount;
    }

    public Map<String, String> getInfoMap() {
        return this.mInfoMap;
    }

    public String getMainLogin() {
        return this.mMainLogin;
    }
}
