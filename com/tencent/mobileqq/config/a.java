package com.tencent.mobileqq.config;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.utils.httputils.PkgTools;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    public static com.tencent.mobileqq.config.struct.a a(String str) {
        com.tencent.mobileqq.config.struct.a aVar = new com.tencent.mobileqq.config.struct.a();
        String e16 = e(str);
        aVar.f202963a = PkgTools.decodeCgi(PkgTools.getParaVal("DESC", e16));
        aVar.f202964b = PkgTools.decodeCgi(PkgTools.getParaVal("SUBJECT", e16));
        String paraVal = PkgTools.getParaVal("RESPCONDITION", e16);
        aVar.f202965c = paraVal;
        if (!paraVal.equals("MANUAL") && !aVar.f202965c.equals("AUTO") && !aVar.f202965c.equals("SEMIAUTO")) {
            return null;
        }
        aVar.f202966d = PkgTools.getParaVal("RESPDESC", e16);
        aVar.f202967e = PkgTools.getParaVal("RESPCONTENTTYPES", e16);
        aVar.f202968f = PkgTools.getParaVal("RESPDEST", e16);
        aVar.f202969g = PkgTools.getParaVal("RESPCONTENTS", e16);
        aVar.f202966d = PkgTools.decodeCgi(aVar.f202966d);
        aVar.f202968f = PkgTools.decodeCgi(aVar.f202968f).trim();
        aVar.f202969g = PkgTools.decodeCgi(aVar.f202969g);
        return aVar;
    }

    public static String b(String str) {
        if (str != null && str.length() > 0) {
            return PkgTools.getParaVal("RESPCONTENTTYPES", str);
        }
        return null;
    }

    public static int c(String str) {
        if (str == null || str.length() <= 0) {
            return -1;
        }
        String e16 = e(str);
        String paraVal = PkgTools.getParaVal("RESPCONDITION", e16);
        if (PkgTools.getParaVal("RESPCONTENTTYPES", e16).equals("PRELOAD")) {
            return 3;
        }
        if (paraVal.equals("MANUAL")) {
            return 0;
        }
        if (paraVal.equals("AUTO")) {
            return 1;
        }
        if (!paraVal.equals("SEMIAUTO")) {
            return -1;
        }
        return 2;
    }

    public static com.tencent.mobileqq.config.struct.a d(String str) {
        com.tencent.mobileqq.config.struct.a a16 = a(str);
        if (a16 == null) {
            return a16;
        }
        if (a16.f202965c.equals("MANUAL")) {
            a16.b(false);
        } else if (a16.f202965c.equals("AUTO")) {
            a16.a();
        } else if (a16.f202965c.equals("SEMIAUTO")) {
            a16.a();
        }
        return a16;
    }

    private static String e(String str) {
        if (str != null && str.length() > 0) {
            return PkgTools.replace(PkgTools.replace(str, 0, "||QQNO||", e.l()), 0, "||LICENCE||", AppSetting.i());
        }
        return "";
    }
}
