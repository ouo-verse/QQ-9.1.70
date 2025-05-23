package com.tencent.mobileqq.troop.util;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replace(ContainerUtils.FIELD_DELIMITER, "&amp;").replace("'", "&apos;").replace("\"", "&quot;").replace(" ", "&nbsp;").replace("<", "&lt;").replace(">", "&gt;");
    }

    public static boolean b(AppRuntime appRuntime, String str, String str2) {
        TroopInfo findTroopInfo = ((ITroopInfoService) appRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(str);
        if (findTroopInfo == null) {
            return false;
        }
        return findTroopInfo.isTroopOwner(str2);
    }

    public static String c(String str) {
        return d(str);
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replace("&apos;", "'").replace("&quot;", "\"").replace("&nbsp;", " ").replace("&lt;", "<").replace("&gt;", ">").replace("&amp;", ContainerUtils.FIELD_DELIMITER);
    }
}
