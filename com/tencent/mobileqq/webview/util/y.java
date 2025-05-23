package com.tencent.mobileqq.webview.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tenpay.proxy.dlg.location.QbAddrData;

/* compiled from: P */
/* loaded from: classes20.dex */
public class y {
    static IPatchRedirector $redirector_;

    public static void a(String str, String str2, String str3, String str4, int i3, long j3, String str5, String str6, String str7, int i16, int i17, int i18, String str8, String str9, String str10, String str11, String str12) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(QbAddrData.DATA_SPLITER);
        stringBuffer.append(str2);
        stringBuffer.append(QbAddrData.DATA_SPLITER);
        stringBuffer.append(str3);
        stringBuffer.append(QbAddrData.DATA_SPLITER);
        stringBuffer.append(str4);
        stringBuffer.append(QbAddrData.DATA_SPLITER);
        stringBuffer.append(i3);
        stringBuffer.append(QbAddrData.DATA_SPLITER);
        stringBuffer.append(j3);
        stringBuffer.append(QbAddrData.DATA_SPLITER);
        stringBuffer.append(str5);
        stringBuffer.append(QbAddrData.DATA_SPLITER);
        stringBuffer.append(str6);
        stringBuffer.append(QbAddrData.DATA_SPLITER);
        stringBuffer.append(str7);
        stringBuffer.append(QbAddrData.DATA_SPLITER);
        stringBuffer.append(i16);
        stringBuffer.append(QbAddrData.DATA_SPLITER);
        stringBuffer.append(i17);
        stringBuffer.append(QbAddrData.DATA_SPLITER);
        stringBuffer.append(i18);
        stringBuffer.append(QbAddrData.DATA_SPLITER);
        stringBuffer.append(str8);
        stringBuffer.append(QbAddrData.DATA_SPLITER);
        stringBuffer.append(str9);
        stringBuffer.append(QbAddrData.DATA_SPLITER);
        stringBuffer.append(str10);
        stringBuffer.append(QbAddrData.DATA_SPLITER);
        stringBuffer.append(str11);
        stringBuffer.append(QbAddrData.DATA_SPLITER);
        stringBuffer.append(str12);
        ((com.tencent.mobileqq.webview.swift.injector.m) aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).d(null, "dc01183", stringBuffer.toString(), true);
    }

    public static void b(int i3, int i16, int i17, int i18, int i19, String str, String str2, int i26, int i27, int i28, int i29, int i36, String... strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i3);
        stringBuffer.append(QbAddrData.DATA_SPLITER);
        stringBuffer.append(i16);
        stringBuffer.append(QbAddrData.DATA_SPLITER);
        stringBuffer.append(i17);
        stringBuffer.append(QbAddrData.DATA_SPLITER);
        stringBuffer.append(i18);
        stringBuffer.append(QbAddrData.DATA_SPLITER);
        stringBuffer.append(i19);
        stringBuffer.append(QbAddrData.DATA_SPLITER);
        stringBuffer.append(str);
        stringBuffer.append(QbAddrData.DATA_SPLITER);
        stringBuffer.append(str2);
        stringBuffer.append(QbAddrData.DATA_SPLITER);
        stringBuffer.append(i26);
        stringBuffer.append(QbAddrData.DATA_SPLITER);
        stringBuffer.append(i27);
        stringBuffer.append(QbAddrData.DATA_SPLITER);
        stringBuffer.append(i28);
        stringBuffer.append(QbAddrData.DATA_SPLITER);
        stringBuffer.append(i29);
        stringBuffer.append(QbAddrData.DATA_SPLITER);
        stringBuffer.append(i36);
        if (strArr != null && strArr.length > 0) {
            String[] strArr2 = new String[5];
            System.arraycopy(strArr, 0, strArr2, 0, Math.min(5, strArr.length));
            for (int i37 = 0; i37 < 5; i37++) {
                if (strArr2[i37] == null) {
                    stringBuffer.append("|");
                } else {
                    stringBuffer.append("|" + strArr2[i37]);
                }
            }
        } else {
            stringBuffer.append(QbAddrData.DATA_SPLITER);
            stringBuffer.append(QbAddrData.DATA_SPLITER);
            stringBuffer.append(QbAddrData.DATA_SPLITER);
            stringBuffer.append(QbAddrData.DATA_SPLITER);
            stringBuffer.append(QbAddrData.DATA_SPLITER);
        }
        ((com.tencent.mobileqq.webview.swift.injector.m) aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).d(null, "sendtdbank|b_sng_qqvip_qq_webview|qq_webview", stringBuffer.toString(), true);
    }
}
