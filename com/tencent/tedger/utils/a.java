package com.tencent.tedger.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import cooperation.qzone.remote.ServiceConst;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String[] f375356a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49269);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f375356a = new String[]{ServiceConst.PARA_SESSION_ID, "items", DownloadInfo.spKey_Config, "rank_info", CheckForwardServlet.KEY_ERR_CODE, "event_id", "ret_code", "time_cost", "err_msg", "rerank_trace_id", "edge_recom_trace", CheckForwardServlet.KEY_REQ_ID};
        }
    }

    public static HashMap<String, Object> a(com.tencent.tedgecontext.a aVar, EdgeStatus edgeStatus) {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (edgeStatus != null) {
            try {
                if (!TextUtils.isEmpty(edgeStatus.getReportMsg())) {
                    JSONObject jSONObject = new JSONObject(edgeStatus.getReportMsg());
                    for (String str : f375356a) {
                        if (jSONObject.has(str)) {
                            hashMap.put(str, jSONObject.getString(str));
                            jSONObject.remove(str);
                        }
                    }
                    if (edgeStatus.getCode() != 0) {
                        hashMap.put(CheckForwardServlet.KEY_ERR_CODE, String.valueOf(edgeStatus.getCode()));
                        hashMap.put("ret_code", String.valueOf(edgeStatus.getCode()));
                        hashMap.put("err_msg", edgeStatus.getMsg());
                        hashMap.put(DownloadInfo.spKey_Config, aVar.e());
                    } else {
                        hashMap.put("ret_code", "0");
                    }
                    hashMap.put("edge_recom_trace", jSONObject.toString());
                }
            } catch (Exception e16) {
                if (aVar != null && aVar.l() != null) {
                    aVar.l().e("TEdgeReportUtils", aVar.l().a(), "parseFromEdgeStatus error: " + e16);
                }
            }
        }
        return hashMap;
    }
}
