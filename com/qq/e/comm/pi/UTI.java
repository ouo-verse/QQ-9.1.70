package com.qq.e.comm.pi;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.tg.download.data.MediaCustomDownloaderCallBackInfo;
import com.qq.e.tg.tangram.action.TangramAdActionParams;
import com.qq.e.tg.tangram.module.TangramAd;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface UTI {
    boolean deleteApk(Context context, int i3);

    void doClick(TangramAd tangramAd, View view, TangramAdActionParams tangramAdActionParams);

    void doClick(String str, String str2, View view, TangramAdActionParams tangramAdActionParams);

    String getAdRequestCgi(int i3);

    Map<String, String> getAdRequestParams(int i3, int i16, String str, LoadAdParams loadAdParams);

    MediaCustomDownloaderCallBackInfo getApkInfo(String str);

    List<MediaCustomDownloaderCallBackInfo> getApkInfoList();

    JSONObject getAppInfoFromAdJson(String str);

    JSONObject getDeviceInfo() throws JSONException;

    JSONObject getDeviceInfo(int i3) throws JSONException;

    JSONObject getDeviceInfo(int i3, boolean z16) throws JSONException;

    List<JSONObject> getDownloadedPackage(Context context);

    Pair<String, String> getTaidAndOaid();

    String handleJs(View view, JSONObject jSONObject, String str, JsCallback jsCallback);

    void installApp(Context context, int i3);

    void onActivityResultCallBack();

    void onExposure(TangramAd tangramAd, View view, long j3);

    void onExposure(TangramAd tangramAd, View view, long j3, TangramAdActionParams tangramAdActionParams);

    void onExposure(String str, String str2, View view, long j3);

    void onExposure(String str, String str2, View view, long j3, TangramAdActionParams tangramAdActionParams);

    void sendUpdateWuJiRequest();
}
