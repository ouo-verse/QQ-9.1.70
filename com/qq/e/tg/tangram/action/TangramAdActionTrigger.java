package com.qq.e.tg.tangram.action;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.JsCallback;
import com.qq.e.comm.pi.UTI;
import com.qq.e.tg.download.data.MediaCustomDownloaderCallBackInfo;
import com.qq.e.tg.tangram.module.TangramAd;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TangramAdActionTrigger {

    /* renamed from: a, reason: collision with root package name */
    private UTI f40872a;

    TangramAdActionTrigger() {
    }

    public TangramAdActionTrigger(UTI uti) {
        this.f40872a = uti;
    }

    public void deleteApp(Context context, int i3) {
        this.f40872a.deleteApk(context, i3);
    }

    public void doClick(TangramAd tangramAd, View view, TangramAdActionParams tangramAdActionParams) {
        this.f40872a.doClick(tangramAd, view, tangramAdActionParams);
    }

    public String getAdRequestCgi(int i3) {
        return this.f40872a.getAdRequestCgi(i3);
    }

    public Map<String, String> getAdRequestParams(int i3, int i16, String str, LoadAdParams loadAdParams) {
        return this.f40872a.getAdRequestParams(i3, i16, str, loadAdParams);
    }

    public MediaCustomDownloaderCallBackInfo getApkInfo(String str) {
        return this.f40872a.getApkInfo(str);
    }

    public List<MediaCustomDownloaderCallBackInfo> getApkInfoList() {
        return this.f40872a.getApkInfoList();
    }

    public JSONObject getAppInfoFromAdJson(String str) {
        return this.f40872a.getAppInfoFromAdJson(str);
    }

    public JSONObject getDeviceInfo(int i3) {
        try {
            return this.f40872a.getDeviceInfo(i3);
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public List<JSONObject> getDownloadedApkList(Context context) {
        return this.f40872a.getDownloadedPackage(context);
    }

    public Pair<String, String> getTaidAndOaid() {
        return this.f40872a.getTaidAndOaid();
    }

    public void installApp(Context context, int i3) {
        this.f40872a.installApp(context, i3);
    }

    public void onExposure(TangramAd tangramAd, View view, long j3) {
        this.f40872a.onExposure(tangramAd, view, j3);
    }

    public void sendUpdateWuJiRequest() {
        this.f40872a.sendUpdateWuJiRequest();
    }

    public void doClick(String str, String str2, View view, TangramAdActionParams tangramAdActionParams) {
        this.f40872a.doClick(str, str2, view, tangramAdActionParams);
    }

    public JSONObject getDeviceInfo(int i3, boolean z16) {
        try {
            return this.f40872a.getDeviceInfo(i3, z16);
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public void onExposure(TangramAd tangramAd, View view, long j3, TangramAdActionParams tangramAdActionParams) {
        this.f40872a.onExposure(tangramAd, view, j3, tangramAdActionParams);
    }

    public void onExposure(String str, String str2, View view, long j3) {
        this.f40872a.onExposure(str, str2, view, j3);
    }

    public void onExposure(String str, String str2, View view, long j3, TangramAdActionParams tangramAdActionParams) {
        this.f40872a.onExposure(str, str2, view, j3, tangramAdActionParams);
    }

    public void handleJs(View view, JSONObject jSONObject, String str, JsCallback jsCallback) {
    }
}
