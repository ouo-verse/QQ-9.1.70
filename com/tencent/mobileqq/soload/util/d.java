package com.tencent.mobileqq.soload.util;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.soload.api.impl.SoLoaderServiceImpl;
import com.tencent.mobileqq.soload.api.impl.r;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.util.LinkedList;
import java.util.Map;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d {
    static IPatchRedirector $redirector_;

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (String str2 : r.d()) {
            String str3 = RFixConstants.SO_PATH + str2 + ".so";
            if (!TextUtils.isEmpty(str3) && str.contains(str3)) {
                return str2;
            }
        }
        return null;
    }

    private static com.tencent.mobileqq.soload.api.impl.f b(String str) {
        LinkedList<com.tencent.mobileqq.soload.api.impl.f> linkedList;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<LoadParam, com.tencent.mobileqq.soload.api.impl.f> map = SoLoaderServiceImpl.LOADER_IN_LOADING;
        synchronized (map) {
            linkedList = new LinkedList(map.values());
        }
        for (com.tencent.mobileqq.soload.api.impl.f fVar : linkedList) {
            if (fVar != null && fVar.d(str)) {
                return fVar;
            }
        }
        return null;
    }

    public static void c(String str, String str2) {
        com.tencent.mobileqq.soload.api.impl.f fVar;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            String a16 = a(str2);
            if (TextUtils.isEmpty(a16)) {
                fVar = b(str2);
                if (fVar == null && !str2.contains("com.tencent.mobileqq.soload")) {
                    return;
                }
            } else {
                fVar = null;
            }
            String str3 = "process:" + MobileQQ.processName + "msg:" + str + str2;
            if (!TextUtils.isEmpty(a16)) {
                String e16 = r.e(a16);
                com.tencent.mobileqq.soload.entity.a.c(a16, e16, 1);
                h.m("ver=" + e16, "SoLoadModule", "SoLoadSingle", "Exception", a16, 2, str3);
            } else if (fVar != null) {
                fVar.b(str3);
            } else {
                h.m(null, "SoLoadModule", "SoLoadSingle", "Exception", "SoLoadWidget", 2, str3);
            }
            h.i(str3);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }
}
