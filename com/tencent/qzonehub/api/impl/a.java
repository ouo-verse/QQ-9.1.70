package com.tencent.qzonehub.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes34.dex */
public class a {
    public static ArrayList<String> b(List<LocalMediaInfo> list) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < list.size(); i3++) {
            LocalMediaInfo localMediaInfo = list.get(i3);
            if (localMediaInfo != null) {
                if (d(localMediaInfo)) {
                    arrayList.add(a(localMediaInfo, "extDownloadUrl", ""));
                } else {
                    arrayList.add(localMediaInfo.path);
                }
            }
        }
        return arrayList;
    }

    private static String c(LocalMediaInfo localMediaInfo) {
        return a(localMediaInfo, "extQZonePhotoId", "");
    }

    private static String a(LocalMediaInfo localMediaInfo, String str, String str2) {
        HashMap<String, Serializable> hashMap;
        return (localMediaInfo == null || (hashMap = localMediaInfo.extData) == null) ? str2 : (String) hashMap.get(str);
    }

    public static boolean d(LocalMediaInfo localMediaInfo) {
        if (localMediaInfo == null) {
            return false;
        }
        return !TextUtils.isEmpty(c(localMediaInfo));
    }
}
