package com.tencent.mobileqq.data;

import android.text.TextUtils;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class SimilarityData {
    public String icon;
    public String title;
    public List<String> wordings;

    public SimilarityData() {
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\nicon=");
        Object obj = "null";
        if (TextUtils.isEmpty(this.icon)) {
            str = "null";
        } else {
            str = this.icon;
        }
        sb5.append(str);
        sb5.append("\ntitle=");
        if (TextUtils.isEmpty(this.title)) {
            str2 = "null";
        } else {
            str2 = this.title;
        }
        sb5.append(str2);
        sb5.append("\nwordings=");
        List<String> list = this.wordings;
        if (list != null && list.size() > 0) {
            obj = this.wordings;
        }
        sb5.append(obj);
        return sb5.toString();
    }

    public SimilarityData(String str, String str2, List<String> list) {
        this.icon = str;
        this.title = str2;
        this.wordings = list;
    }
}
