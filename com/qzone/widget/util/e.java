package com.qzone.widget.util;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes37.dex */
public class e {
    public static List<String> a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<String> b16 = b(str, "\"(https?://[^\"]+)\"");
            if (b16 != null) {
                for (String str2 : b16) {
                    if (((IQzoneWebViewPluginHelper) QRoute.api(IQzoneWebViewPluginHelper.class)).checkOfflineUrl(str2) && !arrayList.contains(str2)) {
                        arrayList.add(str2);
                    }
                }
            }
            List<String> b17 = b(str, "url\\((//[^\\)]+)\\)");
            if (b17 != null) {
                for (String str3 : b17) {
                    String str4 = "https:" + str3;
                    if (((IQzoneWebViewPluginHelper) QRoute.api(IQzoneWebViewPluginHelper.class)).checkOfflineUrl(str4) && !TextUtils.isEmpty(str3) && !arrayList.contains(str4)) {
                        arrayList.add(str4);
                    }
                }
            }
            return arrayList;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private static List<String> b(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Matcher matcher = Pattern.compile(str2).matcher(str);
            while (matcher.find()) {
                String group = matcher.group(1);
                if (group != null) {
                    group = group.trim();
                }
                if (!TextUtils.isEmpty(group) && !group.contains(" ") && !arrayList.contains(group)) {
                    arrayList.add(group);
                }
            }
            if (arrayList.size() == 0) {
                return null;
            }
            return arrayList;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
