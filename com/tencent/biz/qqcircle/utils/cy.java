package com.tencent.biz.qqcircle.utils;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class cy {
    public static String a(String str, String str2) {
        return str + ContainerUtils.FIELD_DELIMITER + PeakConstants.QCIRCLE_CLIENT_TRACEID + ContainerUtils.KEY_VALUE_DELIMITER + str2;
    }

    public static String b(String str, String str2) {
        return str + ContainerUtils.FIELD_DELIMITER + "xsj_feed_id" + ContainerUtils.KEY_VALUE_DELIMITER + str2;
    }

    public static String c(String str, int i3) {
        return str + ContainerUtils.FIELD_DELIMITER + IProfileCardConst.KEY_FROM_TYPE + ContainerUtils.KEY_VALUE_DELIMITER + i3;
    }

    public static String d(String str, String str2) {
        return str + ContainerUtils.FIELD_DELIMITER + "music" + ContainerUtils.KEY_VALUE_DELIMITER + str2;
    }

    public static String e(String str, int i3, String str2, String str3) {
        return f(h(g(str, i3), str2), str3);
    }

    public static String f(String str, String str2) {
        return str + ContainerUtils.FIELD_DELIMITER + "xsj_publish_location" + ContainerUtils.KEY_VALUE_DELIMITER + str2;
    }

    public static String g(String str, int i3) {
        return str + ContainerUtils.FIELD_DELIMITER + "xsj_resource_type" + ContainerUtils.KEY_VALUE_DELIMITER + i3;
    }

    public static String h(String str, String str2) {
        return str + ContainerUtils.FIELD_DELIMITER + "xsj_tianshu_task_id" + ContainerUtils.KEY_VALUE_DELIMITER + str2;
    }

    public static void i(Bundle bundle, String str, String str2) {
        if (bundle == null) {
            QLog.e("WinkSchemaUtil", 1, "bundle is null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("WinkSchemaUtil", 1, "key is null");
            return;
        }
        HashMap hashMap = (HashMap) bundle.getSerializable("key_attrs");
        if (hashMap != null) {
            hashMap.put(str, str2);
            bundle.putSerializable("key_attrs", hashMap);
        } else {
            HashMap hashMap2 = new HashMap();
            hashMap2.put(str, str2);
            bundle.putSerializable("key_attrs", hashMap2);
        }
    }

    public static String j(String str) {
        return k(str, "libtemplate");
    }

    public static String k(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return Uri.parse(str).getQueryParameter(str2);
        } catch (Exception e16) {
            QLog.e("WinkSchemaUtil", 1, "parseSchema error, schema: " + str + ", key: " + str2, e16);
            return "";
        }
    }

    public static String l(String str) {
        return k(str, "taskid");
    }

    public static boolean m(String str) {
        if (str != null && str.contains(QCircleScheme.Q_CIRCLE_ACTION_OPEN_UNIFIEDTAGFLOW)) {
            return true;
        }
        return false;
    }

    public static boolean n(String str) {
        if (str != null && str.contains(QCircleScheme.Q_CIRCLE_ACTION_OPEN_QQPUBLISH)) {
            return true;
        }
        return false;
    }

    public static boolean o(String str) {
        boolean z16;
        if (str == null) {
            return false;
        }
        boolean contains = str.contains(QCircleScheme.AttrQQPublish.ADVERTISE_JOB_ID);
        if (str.contains(QCircleScheme.AttrQQPublish.ADVERTISE_JOB_ID) && str.contains(QCircleScheme.AttrQQPublish.ADVERTISE_JOB_TYPE) && str.contains(QCircleScheme.AttrQQPublish.ADVERTISE_BIZ_ID)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!contains && !z16) {
            return false;
        }
        return true;
    }
}
