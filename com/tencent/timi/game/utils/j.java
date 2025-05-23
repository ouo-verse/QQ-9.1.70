package com.tencent.timi.game.utils;

import android.net.Uri;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes26.dex */
public class j {
    public static Uri a(Uri uri, Map<String, String> map) {
        Uri.Builder buildUpon = uri.buildUpon();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        return buildUpon.build();
    }

    public static Uri b(Uri uri, Set<String> set) {
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(uri.getScheme());
        builder.authority(uri.getAuthority());
        builder.path(uri.getPath());
        HashSet<String> hashSet = new HashSet(queryParameterNames);
        hashSet.removeAll(set);
        for (String str : hashSet) {
            builder.appendQueryParameter(str, uri.getQueryParameter(str));
        }
        return builder.build();
    }
}
