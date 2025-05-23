package com.tencent.luggage.wxa.ar;

import com.tencent.xweb.IXWebPreferences;
import com.tencent.xweb.XWebPreferences;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a1 {
    public static boolean a(ArrayList arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            String stringValue = XWebPreferences.getStringValue(IXWebPreferences.XWEB_HTTP_DNS);
            x0.d("XWebUpdateHttpDnsHostList", "addHttpDnsHostList, current: " + stringValue);
            ArrayList arrayList2 = new ArrayList();
            if (stringValue != null && stringValue.length() != 0) {
                arrayList2.addAll(Arrays.asList(stringValue.split("\\|")));
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    if (arrayList2.contains(arrayList.get(i3))) {
                        x0.d("XWebUpdateHttpDnsHostList", "addHttpDnsHostList, add " + ((String) arrayList.get(i3)) + " fail, exist");
                    } else {
                        arrayList2.add((String) arrayList.get(i3));
                        x0.d("XWebUpdateHttpDnsHostList", "addHttpDnsHostList, add " + ((String) arrayList.get(i3)) + " success");
                    }
                }
                arrayList = arrayList2;
            } else {
                x0.d("XWebUpdateHttpDnsHostList", "addHttpDnsHostList, current is empty, add success");
            }
            String a16 = no0.a.a("|", arrayList);
            XWebPreferences.setValue(IXWebPreferences.XWEB_HTTP_DNS, a16);
            x0.d("XWebUpdateHttpDnsHostList", "after addHttpDnsHostList, list: " + a16);
            return true;
        }
        x0.d("XWebUpdateHttpDnsHostList", "addHttpDnsHostList fail, add empty list");
        return false;
    }

    public static boolean b(ArrayList arrayList) {
        String stringValue = XWebPreferences.getStringValue(IXWebPreferences.XWEB_HTTP_DNS);
        if (stringValue != null && stringValue.length() != 0) {
            XWebPreferences.setValue(IXWebPreferences.XWEB_HTTP_DNS, "");
        }
        String stringValue2 = XWebPreferences.getStringValue(IXWebPreferences.XWEB_HTTP_DNS);
        if (stringValue2 != null && stringValue2.length() != 0) {
            x0.d("XWebUpdateHttpDnsHostList", "deleteAllHttpDnsHostList fail");
            return false;
        }
        x0.d("XWebUpdateHttpDnsHostList", "deleteAllHttpDnsHostList success");
        return true;
    }

    public static boolean c(ArrayList arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            String stringValue = XWebPreferences.getStringValue(IXWebPreferences.XWEB_HTTP_DNS);
            x0.d("XWebUpdateHttpDnsHostList", "deleteHttpDnsHostList, current: " + stringValue);
            ArrayList arrayList2 = new ArrayList();
            if (stringValue != null && stringValue.length() != 0) {
                arrayList2.addAll(Arrays.asList(stringValue.split("\\|")));
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    if (arrayList2.contains(arrayList.get(i3))) {
                        arrayList2.remove(arrayList.get(i3));
                        x0.d("XWebUpdateHttpDnsHostList", "deleteHttpDnsHostList, delete " + ((String) arrayList.get(i3)) + " success");
                    } else {
                        x0.d("XWebUpdateHttpDnsHostList", "deleteHttpDnsHostList, delete " + ((String) arrayList.get(i3)) + " fail, not exist");
                    }
                }
                String a16 = no0.a.a("|", arrayList2);
                XWebPreferences.setValue(IXWebPreferences.XWEB_HTTP_DNS, a16);
                x0.d("XWebUpdateHttpDnsHostList", "after deleteHttpDnsHostList, list: " + a16);
                return true;
            }
            x0.d("XWebUpdateHttpDnsHostList", "deleteHttpDnsHostList, current is empty, delete fail");
            return false;
        }
        x0.d("XWebUpdateHttpDnsHostList", "deleteHttpDnsHostList fail, delete empty list");
        return false;
    }
}
