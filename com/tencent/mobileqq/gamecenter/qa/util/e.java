package com.tencent.mobileqq.gamecenter.qa.util;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes12.dex */
public class e {
    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, Map<Integer, String> map) {
        WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
        wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule(str3).setOperId(str5).setOperType(str6).setGameAppId(str7).setExt(1, str4).setExt(11, str).setExt(12, str2);
        if (map != null && map.keySet().size() > 0) {
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                wadlReportBuilder.setExt(entry.getKey().intValue(), entry.getValue());
            }
        }
        wadlReportBuilder.report();
    }

    public static void b(String str, String str2, String str3, String str4, String str5, String str6, String str7, Map<Integer, String> map, String str8) {
        WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
        wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule(str3).setOperId(str5).setOperType(str6).setGameAppId(str7).setExt(1, str4).setExt(11, str).setExt(12, str2).setTianjiReportStr(str8);
        if (map != null && map.keySet().size() > 0) {
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                wadlReportBuilder.setExt(entry.getKey().intValue(), entry.getValue());
            }
        }
        wadlReportBuilder.report();
    }
}
