package com.tencent.mobileqq.config.business;

import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mobileqq.dpc.IDPCApiConstant;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class au {

    /* renamed from: a, reason: collision with root package name */
    public long f202534a = 1;

    /* renamed from: b, reason: collision with root package name */
    public long f202535b = 0;

    /* renamed from: c, reason: collision with root package name */
    public long f202536c = QZoneHelper.Constants.SUPPORT_MIX_MUSIC_DEFAULT;

    /* renamed from: d, reason: collision with root package name */
    public long f202537d = GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_FOR_TV;

    /* renamed from: e, reason: collision with root package name */
    public long f202538e = GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_FOR_TV;

    /* renamed from: f, reason: collision with root package name */
    public long f202539f = GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_FOR_TV;

    /* renamed from: g, reason: collision with root package name */
    public String f202540g = IDPCApiConstant.PIC_PREDOWNLOAD_FLOW_DEFAULT;

    /* renamed from: h, reason: collision with root package name */
    public String f202541h = IDPCApiConstant.PIC_PREDOWNLOAD_TROOP_DEFAULT;

    /* renamed from: i, reason: collision with root package name */
    public long f202542i = 100;

    /* renamed from: j, reason: collision with root package name */
    public String f202543j = "51f3f3f7";

    /* renamed from: k, reason: collision with root package name */
    public long f202544k = 150;

    /* renamed from: l, reason: collision with root package name */
    public long f202545l = 40960;

    /* renamed from: m, reason: collision with root package name */
    public long f202546m = 71680;

    /* renamed from: n, reason: collision with root package name */
    public long f202547n = 204800;

    /* renamed from: o, reason: collision with root package name */
    public long f202548o = 1;

    /* renamed from: p, reason: collision with root package name */
    public String f202549p = "20-24;0-1";

    /* renamed from: q, reason: collision with root package name */
    public long f202550q = 819200;

    /* renamed from: r, reason: collision with root package name */
    public int f202551r = 1000;

    /* renamed from: s, reason: collision with root package name */
    public int f202552s = 32;

    private static String a(com.tencent.mobileqq.config.ai[] aiVarArr) {
        if (aiVarArr != null && aiVarArr.length != 0) {
            long j3 = Long.MIN_VALUE;
            com.tencent.mobileqq.config.ai aiVar = null;
            for (com.tencent.mobileqq.config.ai aiVar2 : aiVarArr) {
                if (aiVar2 != null && (aiVar == null || aiVar2.f202267a > j3)) {
                    j3 = aiVar2.f202267a;
                    aiVar = aiVar2;
                }
            }
            if (aiVar == null) {
                QLog.i("PicPreDownloadBean", 1, "getConfContentWithMaxID: no config");
                return null;
            }
            QLog.i("PicPreDownloadBean", 1, "getConfContentWithMaxID: task-id=" + aiVar.f202267a);
            return aiVar.f202268b;
        }
        QLog.i("PicPreDownloadBean", 1, "getConfContentWithMaxID: conf is empty");
        return null;
    }

    public static au b(com.tencent.mobileqq.config.ai[] aiVarArr) {
        au auVar = new au();
        String a16 = a(aiVarArr);
        if (a16 == null) {
            return auVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(a16);
            c(jSONObject, auVar);
            d(jSONObject, auVar);
            e(jSONObject, auVar);
        } catch (JSONException e16) {
            QLog.i("PicPreDownloadBean", 1, "parse: EXCEPTION:" + e16);
        }
        if (QLog.isColorLevel()) {
            QLog.i("PicPreDownloadBean", 2, "parse: " + a16 + " bean:" + auVar.toString());
        }
        return auVar;
    }

    private static void c(JSONObject jSONObject, au auVar) {
        if (jSONObject.has("PicPreDownSwitchNew")) {
            auVar.f202534a = jSONObject.optLong("PicPreDownSwitchNew");
        }
        if (jSONObject.has("PicAuDownTimePoint")) {
            auVar.f202535b = jSONObject.optLong("PicAuDownTimePoint");
        }
        if (jSONObject.has("MaxWifiFlow")) {
            auVar.f202536c = jSONObject.optLong("MaxWifiFlow");
        }
        if (jSONObject.has("Max4GFlow")) {
            auVar.f202537d = jSONObject.optLong("Max4GFlow");
        }
        if (jSONObject.has("Max3GFlow")) {
            auVar.f202538e = jSONObject.optLong("Max3GFlow");
        }
        if (jSONObject.has("Max2GFlow")) {
            auVar.f202539f = jSONObject.optLong("Max2GFlow");
        }
    }

    private static void d(JSONObject jSONObject, au auVar) {
        if (jSONObject.has("flowCombination")) {
            auVar.f202540g = jSONObject.optString("flowCombination");
        }
        if (jSONObject.has("troopCombination")) {
            auVar.f202541h = jSONObject.optString("troopCombination");
        }
        if (jSONObject.has("maxRequest")) {
            auVar.f202542i = jSONObject.optLong("maxRequest");
        }
        if (jSONObject.has("xGPreDownPolicy")) {
            auVar.f202543j = jSONObject.optString("xGPreDownPolicy");
        }
        if (jSONObject.has("AFBFlowHitXG")) {
            auVar.f202544k = jSONObject.optLong("AFBFlowHitXG");
        }
        if (jSONObject.has("AFBFlowMissXG")) {
            auVar.f202545l = jSONObject.optLong("AFBFlowMissXG");
        }
        if (jSONObject.has("APicAvgSize")) {
            auVar.f202546m = jSONObject.optLong("APicAvgSize");
        }
        if (jSONObject.has("APicMaxSize")) {
            auVar.f202547n = jSONObject.optLong("APicMaxSize");
        }
        if (jSONObject.has("enablePeakFlow")) {
            auVar.f202548o = jSONObject.optLong("enablePeakFlow");
        }
        if (jSONObject.has("PeakFlowTimePeriod")) {
            auVar.f202549p = jSONObject.optString("PeakFlowTimePeriod");
        }
        if (jSONObject.has("PeakFlowMaxPicSize")) {
            auVar.f202550q = jSONObject.optLong("PeakFlowMaxPicSize");
        }
    }

    private static void e(JSONObject jSONObject, au auVar) {
        if (jSONObject.has("gifWifiPreDownloadLimit")) {
            auVar.f202551r = jSONObject.optInt("gifWifiPreDownloadLimit");
        }
        if (jSONObject.has("gifXgPreDownloadLimit")) {
            auVar.f202552s = jSONObject.optInt("gifXgPreDownloadLimit");
        }
    }

    public String toString() {
        return "PicPreDownloadBean{PreDownSwitchNew=" + this.f202534a + ",PicAuDownTimePoint=" + this.f202535b + ",PreDownMaxWifiFlow=" + this.f202536c + ",PreDownMax4GFlow=" + this.f202537d + ",PreDownMax3GFlow=" + this.f202538e + ",PreDownMax2GFlow=" + this.f202539f + ",flowsCombination=" + this.f202540g + ",troopCombination=" + this.f202541h + ",requestListMaxSize=" + this.f202542i + ",xGPreDownPolicy=" + this.f202543j + ",xgFlowHitFeedback=" + this.f202544k + ",XgFlowMissFeedback=" + this.f202545l + ",pisSizeAvg=" + this.f202546m + ",pisSizeMax=" + this.f202547n + ",mEnablePeakFlow=" + this.f202548o + ",mPeakFlowTimePeriod=" + this.f202549p + ",mPeakFlowMaxPicSize=" + this.f202550q + ",gifWifiPreDownloadLimit=" + this.f202551r + ",gifXgPreDownloadLimit=" + this.f202552s + '}';
    }
}
