package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util;

import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.b;
import com.tencent.kuikly.core.pager.g;
import java.util.Map;
import java.util.Set;
import kotlin.text.Regex;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchReport {
    public static final QSearchReport INSTANCE = new QSearchReport();

    public final boolean isPhoneNumSearch(String str) {
        return new Regex("^1[0-9]{10}$").matches(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c1, code lost:
    
        if ((5 <= r4 && r4 < 11) != false) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final e packContactParams(Map<String, String> map, b bVar, boolean z16, long j3, String str) {
        g pageData;
        Set<String> keySet;
        KLog.INSTANCE.d("QSearchReport", "packContactParams params=" + map + " tabType:" + j3 + " keyword=" + str);
        e eVar = new e();
        if (map != null && (keySet = map.keySet()) != null) {
            for (String str2 : keySet) {
                String str3 = map.get(str2);
                if (str3 == null) {
                    str3 = "";
                }
                eVar.v(str2, str3);
            }
        }
        if (bVar != null && (pageData = bVar.getPageData()) != null) {
            ISearchReport iSearchReport = bVar instanceof ISearchReport ? (ISearchReport) bVar : null;
            if (iSearchReport != null) {
                int userSource = iSearchReport.getUserSource();
                QSearchReport qSearchReport = INSTANCE;
                boolean isAndroid = pageData.getIsAndroid();
                int i3 = qSearchReport.isPhoneNumSearch(str) ? isAndroid ? 3014 : 2014 : isAndroid ? 3020 : 2020;
                boolean isPhoneNumSearch = qSearchReport.isPhoneNumSearch(str);
                int i16 = 3;
                boolean z17 = true;
                if (userSource == 3 || userSource == 7) {
                    i16 = isPhoneNumSearch ? z16 ? 1 : 0 : 4;
                } else if (userSource != 10) {
                    boolean isPhoneNumSearch2 = qSearchReport.isPhoneNumSearch(str);
                    if (new Regex("\\d+").matches(str)) {
                        int length = str.length();
                    }
                    z17 = false;
                    if (isPhoneNumSearch2 || z17) {
                        if (j3 == 1) {
                            i16 = 11;
                        } else if (j3 == 5) {
                            i16 = 12;
                        }
                    } else if (j3 == 1) {
                        i16 = 13;
                    } else if (j3 == 5) {
                        i16 = 14;
                    }
                } else {
                    i16 = 5;
                }
                KLog.INSTANCE.d("QSearchReport", "packContactParams sourceId=" + i3 + " subSourceId=" + i16);
                eVar.t("sourceId", i3);
                eVar.t("subSourceId", i16);
            }
        }
        return eVar;
    }
}
