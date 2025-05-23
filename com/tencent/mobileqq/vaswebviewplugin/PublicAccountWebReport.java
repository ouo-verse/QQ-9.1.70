package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Intent;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import tencent.im.oidb.ac.ArticleComment$ReportNetConnectInfoRequest;
import tencent.im.oidb.ac.ArticleComment$ReportNetConnectInfoResponse;

/* loaded from: classes20.dex */
public class PublicAccountWebReport {
    public static final String TAG = "PublicAccountWebReport";
    public static final int THRESHOLD_2G = 4000;
    public static final int THRESHOLD_3G = 3000;
    public static final int THRESHOLD_4G = 2000;
    public static final int THRESHOLD_WIFI = 2000;

    public static void handlereportPublicAccountNetInfoResponse(Intent intent, FromServiceMsg fromServiceMsg, Object obj) {
        if (fromServiceMsg.isSuccess() && obj != null) {
            ArticleComment$ReportNetConnectInfoResponse articleComment$ReportNetConnectInfoResponse = new ArticleComment$ReportNetConnectInfoResponse();
            try {
                articleComment$ReportNetConnectInfoResponse.mergeFrom((byte[]) obj);
                articleComment$ReportNetConnectInfoResponse.ret.ret_code.get();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x001a, code lost:
    
        if (r5 > 3000) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x001f, code lost:
    
        if (r5 > 4000) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0022, code lost:
    
        if (r5 > 2000) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0015, code lost:
    
        if (r5 > 2000) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean netShouldReport(int i3) {
        int b16 = com.tencent.mqpsdk.util.a.b(null);
        boolean z16 = true;
        if (b16 != 1) {
            if (b16 != 2) {
                if (b16 != 3) {
                    if (b16 != 4) {
                        return false;
                    }
                }
            }
        }
    }

    public static void reportPublicAccountNetInfoRequest(AppRuntime appRuntime, int i3, int i16, int i17, int i18, String str, String str2) {
        int b16 = com.tencent.mqpsdk.util.a.b(null);
        String str3 = AppSetting.f99551k + ",3," + AppSetting.f99542b;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "urlStr: " + str + ",errorcode:" + i17 + ",netType:" + b16 + ",DNSCost" + i16 + ",connectCost:" + i3 + ",receiveCost:" + i18 + ",website_address:" + str2 + ",AppSetting.subVersion:" + str3);
        }
        if (appRuntime == null || !netShouldReport(i3 + i16 + i18)) {
            return;
        }
        NewIntent newIntent = new NewIntent(BaseApplication.getContext(), ((IPublicAccountServlet) QRoute.api(IPublicAccountServlet.class)).getServletClass());
        newIntent.putExtra("cmd", IPublicAccountConfigUtil.SSO_COMMOND_NET_CONNECT_INFO);
        ArticleComment$ReportNetConnectInfoRequest articleComment$ReportNetConnectInfoRequest = new ArticleComment$ReportNetConnectInfoRequest();
        articleComment$ReportNetConnectInfoRequest.netType.set(b16);
        articleComment$ReportNetConnectInfoRequest.versionInfo.set(str3);
        articleComment$ReportNetConnectInfoRequest.connectCost.set(i3);
        articleComment$ReportNetConnectInfoRequest.DNSCost.set(i16);
        articleComment$ReportNetConnectInfoRequest.errorcode.set(i17);
        articleComment$ReportNetConnectInfoRequest.receiveCost.set(i18);
        articleComment$ReportNetConnectInfoRequest.url.set(ByteStringMicro.copyFromUtf8(str));
        articleComment$ReportNetConnectInfoRequest.website_address.set(str2);
        newIntent.putExtra("data", articleComment$ReportNetConnectInfoRequest.toByteArray());
        appRuntime.startServlet(newIntent);
    }
}
