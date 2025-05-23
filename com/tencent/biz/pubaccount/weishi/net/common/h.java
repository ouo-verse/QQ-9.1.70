package com.tencent.biz.pubaccount.weishi.net.common;

import NS_KING_PUBLIC.stReqHeader;
import QMF_PROTOCAL.RetryInfo;
import UserGrowth.cnst.sMapExtKeyABTest;
import UserGrowth.stReportItem;
import UserGrowth.stWeishiReportReq;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.s;
import com.tencent.biz.pubaccount.weishi.util.p;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.QUA;
import cooperation.qzone.WNSStream;
import cooperation.qzone.remote.ServiceConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class h {
    public static <T extends JceStruct> byte[] a(g<T> gVar) {
        WNSStream wNSStream = new WNSStream(1000027, QUA.getQUA3(), gVar.getLoginUserId(), new byte[0], p.b(), new RetryInfo());
        byte[] d16 = d(gVar);
        if (d16 != null) {
            return fh.b(wNSStream.pack(MsfSdkUtils.getNextAppSeq(), gVar.getCmdString(), d16, false));
        }
        return null;
    }

    private static <T extends JceStruct> void b(g<T> gVar, stReqHeader streqheader, String str) {
        if ("stWeishiReportReq".equals(gVar.getReqUniKey())) {
            streqheader.mapExt = c(gVar);
        } else {
            streqheader.mapExt = new HashMap();
        }
        streqheader.mapExt.put("iAuthType", "2");
        Map<String, String> map = streqheader.mapExt;
        if (str == null) {
            str = "";
        }
        map.put("sUid", str);
        streqheader.mapExt.put("sSessionKey", "");
        String f16 = com.tencent.biz.pubaccount.weishi.report.a.f(BaseApplication.getContext());
        if (TextUtils.isEmpty(f16)) {
            f16 = "000000000000000";
        }
        streqheader.mapExt.put("imei", f16);
        String j3 = p.j();
        Map<String, String> map2 = streqheader.mapExt;
        if (j3 == null) {
            j3 = "";
        }
        map2.put(TVKLiveRequestBuilder.RequestParamKey.QIMEI36, j3);
        String k3 = p.k();
        Map<String, String> map3 = streqheader.mapExt;
        if (k3 == null) {
            k3 = "";
        }
        map3.put("qimei36", k3);
        streqheader.mapExt.put(TPDownloadProxyEnum.USER_SSID, p.r());
        streqheader.mapExt.put("ssid_ip", p.q());
        streqheader.mapExt.put("ab_policy_info", gVar.getExpABTestDataStr());
        streqheader.mapExt.put("teen_mode", String.valueOf(f.b()));
        streqheader.mapExt.put(QCircleDaTongConstant.ElementParamKey.XSJ_QQ_MODE, String.valueOf(f.a()));
        String sessionId = WSPublicAccReport.getInstance().getSessionId();
        streqheader.mapExt.put(ServiceConst.PARA_SESSION_ID, sessionId != null ? sessionId : "");
        gVar.onBuildHeaderMapExt(streqheader.mapExt);
        x.j("[WSService][Encoder]", "[getHeader]mCmd:" + gVar.getRequestCmd() + ", mReqScene:" + gVar.getRequestScene() + ", header:" + streqheader.mapExt.toString());
    }

    private static <T extends JceStruct> Map<String, String> c(g<T> gVar) {
        JceStruct jceStruct = gVar.req;
        if (!(jceStruct instanceof stWeishiReportReq)) {
            return new HashMap();
        }
        ArrayList<stReportItem> arrayList = ((stWeishiReportReq) jceStruct).report_list;
        if (arrayList.size() <= 0) {
            return new HashMap();
        }
        stReportItem streportitem = arrayList.get(0);
        x.i("[WSService][Encoder]", "[getCacheMapExt]\u4e0a\u62a5\u53d6 pageType: " + streportitem.pagetype);
        Map<String, String> map = g.pageTypeExtMap.get(Integer.valueOf(streportitem.pagetype));
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                x.i("[WSService][Encoder]", "getCacheMapExt\u53d6\u51fa\u6765" + gVar.getReqUniKey() + " --- key: " + entry.getKey() + ", value: " + entry.getValue());
                if (sMapExtKeyABTest.value.equals(entry.getKey()) && streportitem.optype == 121) {
                    entry.setValue("");
                    x.l("[WSService][Encoder]", "\u521d\u59cb\u5316\u4e0a\u62a5\uff0cqq_abtest \u6e05\u7a7aqq_abtest");
                }
            }
            return map;
        }
        x.i("[WSService][Encoder]", "[getCacheMapExt]\u6ca1\u6709pageType\u4e3a" + streportitem.pagetype + "\u7684extMap");
        return new HashMap();
    }

    private static <T extends JceStruct> byte[] d(g<T> gVar) {
        stReqHeader e16 = e(gVar);
        com.tencent.biz.pubaccount.weishi.net.f fVar = new com.tencent.biz.pubaccount.weishi.net.f();
        fVar.setRequestId(gVar.requestId);
        gVar.requestId++;
        fVar.setServantName("king");
        fVar.setFuncName(gVar.getOnlyCmd());
        fVar.setEncodeName("UTF-8");
        fVar.put("stReqHeader", e16);
        fVar.a(9999);
        if (gVar.req != null && !TextUtils.isEmpty(gVar.getRequestCmd())) {
            fVar.put(gVar.getReqUniKey(), gVar.req);
            x.i("[WSService][Encoder]", "[getEncodedUniParameter]req\u540d :" + gVar.getReqUniKey());
        }
        return fVar.encode();
    }

    private static <T extends JceStruct> stReqHeader e(g<T> gVar) {
        stReqHeader streqheader = new stReqHeader();
        String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        streqheader.authInfo = s.h().i(account, "", gVar.isShouldStartQQAuth());
        streqheader.iChid = 0;
        streqheader.person_id = com.tencent.biz.pubaccount.weishi.net.h.f80972a;
        streqheader.platform = "Android";
        streqheader.appversion = p.n(BaseApplication.getContext());
        streqheader.user_ip = p.d();
        streqheader.strQua = QUA.getQUA3();
        streqheader.device_info = p.e();
        x.b("[WSService][Encoder]", "[getHeader]device_info:" + streqheader.device_info);
        streqheader.h265key = p.f();
        streqheader.appid = 1101083114;
        b(gVar, streqheader, account);
        streqheader.iAppVersion = p.a();
        return streqheader;
    }
}
