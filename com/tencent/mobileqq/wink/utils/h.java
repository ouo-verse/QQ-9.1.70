package com.tencent.mobileqq.wink.utils;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes21.dex */
public class h {
    private static void a(String str) {
        WinkDatongCurrentParams.put(str, null);
    }

    private static void b() {
        a("xsj_operation_activity_id");
        a("xsj_resource_type");
        a("xsj_template_id");
    }

    public static void c(Intent intent) {
        if (intent == null) {
            b();
            return;
        }
        Serializable serializableExtra = intent.getSerializableExtra("key_attrs");
        if (serializableExtra instanceof HashMap) {
            HashMap hashMap = (HashMap) serializableExtra;
            d(hashMap, "taskid", "xsj_operation_activity_id");
            d(hashMap, "xsj_resource_type", "xsj_resource_type");
            d(hashMap, "libtemplate", "xsj_template_id");
            d(hashMap, "xsj_tianshu_task_id", "xsj_tianshu_task_id");
            d(hashMap, "xsj_publish_location", "xsj_publish_location");
            d(hashMap, "xsj_guide_text", "xsj_guide_text");
            return;
        }
        b();
    }

    private static void d(HashMap<String, String> hashMap, String str, String str2) {
        if (hashMap.containsKey(str)) {
            String str3 = hashMap.get(str);
            QLog.d("DatongReportInitializeParamsUtil", 1, "putOrClear, key: " + str + ", value: " + str3);
            if (TextUtils.isEmpty(str3)) {
                a(str2);
                return;
            } else {
                WinkDatongCurrentParams.put(str2, str3);
                return;
            }
        }
        a(str2);
    }
}
