package com.tencent.gamecenter.wadl.sdk.downloader.pcdn;

import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.raft.standard.report.BaseEvent;
import com.tencent.raft.standard.report.IRReport;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final HashSet<String> f107441a = new HashSet<>();

    /* renamed from: b, reason: collision with root package name */
    private static final HashSet<String> f107442b = new HashSet<>();

    private static String a(String str, String str2) {
        return "start_" + str + str2;
    }

    public static void b(String str, String str2) {
        String a16 = a(str, str2);
        HashSet<String> hashSet = f107441a;
        if (hashSet.contains(a16)) {
            return;
        }
        com.tencent.gamecenter.wadl.sdk.common.e.b.e("PCDNReportUtil", "reportOnStart,id:" + str + ",url:" + str2);
        hashSet.add(a16);
        HashMap hashMap = new HashMap();
        hashMap.put("ext11", "1");
        hashMap.put("ext12", "160");
        hashMap.put("oper_module", "769");
        hashMap.put("ext1", "76901");
        hashMap.put(WadlReportBuilder.TableElem.OPER_ID, "989899");
        hashMap.put(WadlReportBuilder.TableElem.GAME_APPID, str);
        hashMap.put("ext27", str2);
        a(hashMap);
    }

    private static String a(String str, String str2, int i3) {
        return "failed_" + str + str2 + i3;
    }

    public static void b(String str, String str2, int i3) {
        String a16 = a(str, str2, i3);
        HashSet<String> hashSet = f107442b;
        if (hashSet.contains(a16)) {
            return;
        }
        com.tencent.gamecenter.wadl.sdk.common.e.b.e("PCDNReportUtil", "reportOnFailed,id:" + str + ",url:" + str2 + ",errorCode:" + i3);
        hashSet.add(a16);
        HashMap hashMap = new HashMap();
        hashMap.put("ext11", "1");
        hashMap.put("ext12", "160");
        hashMap.put("oper_module", "769");
        hashMap.put("ext1", "76901");
        hashMap.put(WadlReportBuilder.TableElem.OPER_ID, "989900");
        hashMap.put(WadlReportBuilder.TableElem.GAME_APPID, str);
        hashMap.put("ext27", str2);
        hashMap.put("ext28", i3 + "");
        hashMap.put("ext29", a.a(i3));
        a(hashMap);
    }

    public static void a(String str, String str2, float f16, int i3) {
        com.tencent.gamecenter.wadl.sdk.common.e.b.e("PCDNReportUtil", "reportOnComplete,id:" + str + ",url:" + str2 + ",shareRatio:" + f16 + ",avgSpeed:" + i3);
        HashMap hashMap = new HashMap();
        hashMap.put("ext11", "1");
        hashMap.put("ext12", "160");
        hashMap.put("oper_module", "769");
        hashMap.put("ext1", "76901");
        hashMap.put(WadlReportBuilder.TableElem.OPER_ID, "989898");
        hashMap.put(WadlReportBuilder.TableElem.GAME_APPID, str);
        hashMap.put("ext27", str2);
        hashMap.put("ext28", f16 + "");
        hashMap.put("ext31", i3 + "");
        a(hashMap);
    }

    private static void a(HashMap<String, String> hashMap) {
        BaseEvent baseEvent = new BaseEvent("", "", true, hashMap);
        IRReport iRReport = com.tencent.gamecenter.wadl.sdk.common.a.f106990m;
        if (iRReport != null) {
            iRReport.report(baseEvent);
        }
    }
}
