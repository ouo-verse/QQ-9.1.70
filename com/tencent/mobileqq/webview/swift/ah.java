package com.tencent.mobileqq.webview.swift;

import com.tencent.biz.pubaccount.api.IPublicAccountWebviewPlugin;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.openpay.constants.OpenConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import java.util.HashMap;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ah {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap<Long, String> f314195a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49121);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HashMap<Long, String> hashMap = new HashMap<>(50, 0.75f);
        f314195a = hashMap;
        hashMap.put(1L, "http");
        hashMap.put(2L, "https");
        hashMap.put(4L, IPublicAccountWebviewPlugin.SCHEME);
        hashMap.put(8L, OpenConstants.ApiName.PAY);
        hashMap.put(16L, "qqvip");
        hashMap.put(32L, "qqjsbridge");
        hashMap.put(64L, "tel");
        hashMap.put(128L, "sms");
        hashMap.put(256L, SchemaUtils.SCHEMA_MQQAPI);
        hashMap.put(512L, "mqqopensdkapi");
        hashMap.put(1024L, "mqqmdpass");
        hashMap.put(2048L, "mqq");
        hashMap.put(4096L, "qapp");
        hashMap.put(8192L, "mqqflyticket");
        hashMap.put(16384L, "mqqwpa");
        hashMap.put(32768L, "wtloginmqq");
        hashMap.put(65536L, ProcessConstant.QQWIFI);
        hashMap.put(131072L, "apollo");
        hashMap.put(262144L, "mqqverifycode");
        hashMap.put(524288L, "mqqconnect");
        hashMap.put(1048576L, "mqqvoipivr");
        hashMap.put(2097152L, "mqqdevlock");
        hashMap.put(4194304L, ProcessConstant.QQFAV);
        hashMap.put(16777216L, ProcessConstant.READINJOY);
        hashMap.put(33554432L, "nowmqqapi");
        hashMap.put(67108864L, WinkDaTongReportConstant.ElementParamValue.XSJ_OPERATION_TYPE_AUTH);
        hashMap.put(134217728L, "txc");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(long j3) {
        HashMap<Long, String> hashMap = f314195a;
        if (hashMap.containsKey(Long.valueOf(j3))) {
            return hashMap.get(Long.valueOf(j3));
        }
        return "";
    }
}
