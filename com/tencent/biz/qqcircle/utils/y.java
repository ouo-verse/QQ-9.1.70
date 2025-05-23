package com.tencent.biz.qqcircle.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class y {
    public static String[] a(String str) {
        ArrayList<String> arrayList = new ArrayList();
        String[] strArr = {"", ""};
        arrayList.add("meterial");
        arrayList.add("template");
        arrayList.add("sticker");
        arrayList.add("filter");
        arrayList.add("music");
        arrayList.add("libtemplate");
        for (String str2 : arrayList) {
            if (!TextUtils.isEmpty(c(str, str2))) {
                String c16 = c(str, str2);
                if (TextUtils.equals("url", str2)) {
                    str2 = "page";
                }
                if (TextUtils.isEmpty(strArr[0])) {
                    strArr[0] = str2;
                    strArr[1] = c16;
                } else {
                    strArr[0] = strArr[0] + "," + str2;
                    strArr[1] = strArr[1] + "," + c16;
                }
            }
        }
        return strArr;
    }

    public static String b(String str, int i3) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(c(str, "taskid"))) {
            hashMap.put("xsj_operation_activity_id", c(str, "taskid"));
        }
        String[] a16 = a(str);
        if (a16 != null && a16.length > 1) {
            hashMap.put("xsj_material_type", a16[0]);
            hashMap.put("xsj_material_id", a16[1]);
        }
        hashMap.put("xsj_resource_type", Integer.valueOf(i3));
        StringBuilder sb5 = new StringBuilder();
        for (Map.Entry entry : hashMap.entrySet()) {
            sb5.append(ContainerUtils.FIELD_DELIMITER + ((String) entry.getKey()) + ContainerUtils.KEY_VALUE_DELIMITER + entry.getValue());
        }
        return sb5.toString();
    }

    public static String c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse.getQueryParameter(str2) == null) {
                return "";
            }
            return parse.getQueryParameter(str2);
        } catch (Exception e16) {
            QLog.e("QCircleMaterialGuideUtils", 1, "parseSchema error, schema: " + str + ", key: " + str2, e16);
            return "";
        }
    }
}
