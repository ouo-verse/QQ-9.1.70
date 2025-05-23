package com.tencent.oskplayer.util;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ContentTypeFixer implements Fixer<Map<String, List<String>>> {
    public static final String GENERAL_CONTENT_TYPE = "application/octet-stream";
    private final String mLogTag;
    private final String mPreferredContentType;

    public ContentTypeFixer(String str, String str2) {
        this.mPreferredContentType = str;
        this.mLogTag = str2;
    }

    public String fix(String str) {
        if (!str.equals("application/octet-stream") || TextUtils.isEmpty(this.mPreferredContentType)) {
            return str;
        }
        PlayerUtils.log(5, this.mLogTag, "modify contentType from " + str + " to " + this.mPreferredContentType);
        return this.mPreferredContentType;
    }

    @Override // com.tencent.oskplayer.util.Fixer
    public Map<String, List<String>> fix(Map<String, List<String>> map) {
        List<String> list;
        if (map == null || (list = map.get("Content-Type")) == null || list.size() <= 0) {
            return map;
        }
        String str = list.get(0);
        if (!str.equals("application/octet-stream") || TextUtils.isEmpty(this.mPreferredContentType)) {
            return map;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getKey().equals("Content-Type")) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.mPreferredContentType);
                hashMap.put("Content-Type", arrayList);
                PlayerUtils.log(5, this.mLogTag, "fix Content-Type from " + str + " to " + this.mPreferredContentType);
            } else {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
