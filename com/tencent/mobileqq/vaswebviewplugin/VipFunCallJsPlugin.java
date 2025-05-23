package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.VasIpcTempData;
import com.tencent.mobileqq.vas.h;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.vipav.VipFunCallPreviewActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public class VipFunCallJsPlugin extends VasWebviewJsPlugin {
    public static final String BusinessName = "funCall";
    public static final int DOWNLOAD_DONE = 3;
    public static final int DOWNLOAD_ERROR = -4;
    public static final int DOWNLOAD_PARAM_ERR = -2;
    public static final int DOWNLOAD_PROGRESS = 2;
    public static final int DOWNLOAD_START = 1;
    public static final String TAG = "VipFunCallJsPlugin";
    String SetFuncallCallBack = "";
    SparseIntArray down_progress = new SparseIntArray();
    SparseIntArray down_status = new SparseIntArray();
    SparseIntArray down_bgprogress = new SparseIntArray();
    SparseIntArray down_bgstatus = new SparseIntArray();
    SparseIntArray down_ringProgress = new SparseIntArray();
    SparseIntArray down_ringStatus = new SparseIntArray();
    VasIpcTempData ipcData = new VasIpcTempData("fun_call");

    public void callPJs(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "method:" + str + ", json:" + str2);
        }
        callJs(str, str2);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return BusinessName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin
    public long getPluginBusiness() {
        return 2148007936L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(9:14|15|(2:295|296)|(24:17|18|(1:20)(1:288)|21|(2:23|24)(1:287)|25|(2:27|28)(1:285)|29|30|31|(2:274|275)(1:33)|34|(1:36)(1:273)|37|(2:39|40)(1:272)|41|(2:43|44)(1:271)|45|(1:47)(1:270)|48|(1:50)|60|61|62)|(5:(3:252|253|(11:255|256|257|258|65|66|67|68|(4:70|(1:72)|78|79)(4:83|84|85|(1:87)(4:88|89|(11:91|92|93|94|95|96|(4:98|99|100|101)(1:136)|102|(1:104)|105|(2:107|108)(7:109|110|111|112|(1:114)|115|(4:117|118|119|120)(2:122|(2:124|125)(1:126))))(4:148|149|150|(13:169|170|(7:172|173|174|175|(1:177)(1:226)|178|(4:180|181|182|183)(1:185))(1:233)|186|(2:188|(1:190))|191|(2:193|(1:195))|196|197|(2:214|(2:223|(1:225))(2:220|(1:222)))(2:203|(1:205))|206|(2:210|(1:212))|213)(4:152|153|154|(3:156|(3:158|159|160)(1:163)|161)(1:164)))|81))|80|81))|68|(0)(0)|80|81)|64|65|66|67) */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x085f, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x0860, code lost:
    
        r3 = r32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x0858, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x0859, code lost:
    
        r3 = r32;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0231 A[Catch: Exception -> 0x029b, JSONException -> 0x02a4, TRY_ENTER, TryCatch #31 {JSONException -> 0x02a4, Exception -> 0x029b, blocks: (B:258:0x01e5, B:70:0x0231, B:72:0x0237), top: B:257:0x01e5 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02af  */
    /* JADX WARN: Type inference failed for: r1v105 */
    /* JADX WARN: Type inference failed for: r1v111 */
    /* JADX WARN: Type inference failed for: r1v112 */
    /* JADX WARN: Type inference failed for: r1v28, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v38 */
    /* JADX WARN: Type inference failed for: r3v39 */
    /* JADX WARN: Type inference failed for: r3v41, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v70 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        String str4;
        ?? r36;
        String str5;
        String str6;
        String str7;
        JSONException jSONException;
        Exception exc;
        String str8;
        String str9;
        int i3;
        String str10;
        int i16;
        int i17;
        String string;
        String string2;
        String str11;
        String str12;
        String str13;
        String str14;
        Bundle bundle;
        String str15;
        ?? equals;
        String str16;
        JSONObject jSONObject;
        int i18;
        String str17;
        JSONObject jSONObject2;
        String str18;
        JSONObject jSONObject3;
        String str19;
        String str20;
        Exception e16;
        JSONException e17;
        if (QLog.isColorLevel()) {
            str4 = "handleJsRequest, url=";
            QLog.d(TAG, 2, "handleJsRequest, url=" + str);
        } else {
            str4 = "handleJsRequest, url=";
        }
        if (!BusinessName.equals(str2) || str == null || str3 == null) {
            return false;
        }
        try {
            try {
                JSONObject jsonFromJSBridge = WebViewPlugin.getJsonFromJSBridge(str);
                if (jsonFromJSBridge == null) {
                    return true;
                }
                try {
                    if (QLog.isColorLevel()) {
                        try {
                            QLog.d(TAG, 2, "handleJsRequest JSON = " + jsonFromJSBridge.toString());
                        } catch (JSONException e18) {
                            str5 = ", url=";
                            str9 = str;
                            jSONException = e18;
                            str7 = TAG;
                            QLog.e(str7, 1, "handleJsRequest, JSONException=" + jSONException.getMessage() + str5 + str9);
                            return true;
                        } catch (Exception e19) {
                            str8 = str;
                            exc = e19;
                            str7 = TAG;
                            QLog.e(str7, 1, "handleJsRequest, Exception=" + exc.getMessage() + ", url=" + str8);
                            return true;
                        }
                    }
                    try {
                        String optString = jsonFromJSBridge.optString("callback");
                        i3 = jsonFromJSBridge.has("callId") ? jsonFromJSBridge.getInt("callId") : 0;
                        if (jsonFromJSBridge.has(VipFunCallConstants.KEY_RING_ID)) {
                            str10 = optString;
                            i16 = jsonFromJSBridge.getInt(VipFunCallConstants.KEY_RING_ID);
                        } else {
                            str10 = optString;
                            i16 = 0;
                        }
                        i17 = jsonFromJSBridge.has(VipFunCallConstants.KEY_FEET_TYPE) ? jsonFromJSBridge.getInt(VipFunCallConstants.KEY_FEET_TYPE) : 1;
                        try {
                            if (jsonFromJSBridge.has("mediaUrl")) {
                                try {
                                    string = jsonFromJSBridge.getString("mediaUrl");
                                } catch (JSONException e26) {
                                    str5 = ", url=";
                                    str9 = str;
                                    jSONException = e26;
                                    str7 = TAG;
                                    QLog.e(str7, 1, "handleJsRequest, JSONException=" + jSONException.getMessage() + str5 + str9);
                                    return true;
                                } catch (Exception e27) {
                                    str8 = str;
                                    exc = e27;
                                    str7 = TAG;
                                    QLog.e(str7, 1, "handleJsRequest, Exception=" + exc.getMessage() + ", url=" + str8);
                                    return true;
                                }
                            } else {
                                string = "";
                            }
                            string2 = jsonFromJSBridge.has("fuzzImageUrl") ? jsonFromJSBridge.getString("fuzzImageUrl") : "";
                            if (jsonFromJSBridge.has("imageUrl")) {
                                str12 = jsonFromJSBridge.getString("imageUrl");
                                str11 = "errorMessage";
                            } else {
                                str11 = "errorMessage";
                                str12 = "";
                            }
                            if (jsonFromJSBridge.has("ringUrl")) {
                                str14 = jsonFromJSBridge.getString("ringUrl");
                                str13 = "code";
                            } else {
                                str13 = "code";
                                str14 = "";
                            }
                            String string3 = jsonFromJSBridge.has("thumbnailUrl") ? jsonFromJSBridge.getString("thumbnailUrl") : "";
                            String string4 = jsonFromJSBridge.has("name") ? jsonFromJSBridge.getString("name") : "";
                            try {
                                bundle = new Bundle();
                                bundle.putInt("callId", i3);
                                bundle.putInt(VipFunCallConstants.KEY_RING_ID, i16);
                                bundle.putInt(VipFunCallConstants.KEY_FEET_TYPE, i17);
                                bundle.putString(VipFunCallConstants.KEY_URL_VIDEO, string);
                                bundle.putString(VipFunCallConstants.KEY_URL_FUZZPIC, string2);
                                bundle.putString(VipFunCallConstants.KEY_URL_PICTURE, str12);
                                bundle.putString(VipFunCallConstants.KEY_URL_RING, str14);
                                bundle.putString(VipFunCallConstants.KEY_URL_CALL_THUM, string3);
                                bundle.putString(VipFunCallConstants.KEY_URL_CALL_THUM, string3);
                                bundle.putString("name", string4);
                                VasCommonReporter.getHistoryJsbFeature(getNameSpace()).setValue2(str3).report();
                            } catch (JSONException e28) {
                                e = e28;
                                r36 = str;
                                str7 = TAG;
                            } catch (Exception e29) {
                                e = e29;
                                r36 = str;
                                str7 = TAG;
                            }
                        } catch (JSONException e36) {
                            e = e36;
                            r36 = str;
                            str7 = TAG;
                        } catch (Exception e37) {
                            e = e37;
                            r36 = str;
                            str7 = TAG;
                        }
                    } catch (JSONException e38) {
                        e = e38;
                        r36 = str;
                        str7 = TAG;
                        str5 = ", url=";
                        str6 = r36;
                        jSONException = e;
                        str9 = str6;
                        QLog.e(str7, 1, "handleJsRequest, JSONException=" + jSONException.getMessage() + str5 + str9);
                        return true;
                    } catch (Exception e39) {
                        e = e39;
                        r36 = str;
                        str7 = TAG;
                        exc = e;
                        str8 = r36;
                        QLog.e(str7, 1, "handleJsRequest, Exception=" + exc.getMessage() + ", url=" + str8);
                        return true;
                    }
                    try {
                        try {
                            if (QLog.isColorLevel()) {
                                try {
                                    if (!"queryDownloadInfo".equals(str3)) {
                                        String str21 = "handleJsRequest callid=" + i3 + ", ringid=" + i16 + ", feeType" + i17 + ", mediaUrl=" + string + ", fuzzImageUrl" + string2 + ", imageUrl=" + str12 + ", ringUrl" + str14;
                                        str15 = TAG;
                                        try {
                                            QLog.d(str15, 2, str21);
                                            JSONObject jSONObject4 = new JSONObject();
                                            String str22 = str13;
                                            jSONObject4.put(str22, 0);
                                            String str23 = str11;
                                            jSONObject4.put(str23, str3 + " has done.");
                                            equals = "openPreview".equals(str3);
                                            int i19 = i17;
                                            if (equals == 0) {
                                                if (QLog.isColorLevel()) {
                                                    QLog.d(str15, 2, "openPreview ringId=" + i16 + ", callId=" + i3);
                                                }
                                                VipFunCallJsPlugin vipFunCallJsPlugin = this;
                                                Activity a16 = vipFunCallJsPlugin.mRuntime.a();
                                                Intent intent = new Intent(a16, (Class<?>) VipFunCallPreviewActivity.class);
                                                intent.putExtra(VipFunCallConstants.KEY_TO_UIN, vipFunCallJsPlugin.mRuntime.b().getAccount());
                                                intent.putExtra("callId", i3);
                                                intent.putExtra(VipFunCallConstants.KEY_RING_ID, i16);
                                                intent.putExtra("bundle", bundle);
                                                a16.startActivity(intent);
                                                vipFunCallJsPlugin.callJs(str10, jSONObject4.toString());
                                                equals = vipFunCallJsPlugin;
                                            } else {
                                                VipFunCallJsPlugin vipFunCallJsPlugin2 = this;
                                                String str24 = string;
                                                String str25 = string2;
                                                String str26 = str10;
                                                try {
                                                    if ("setFunCallMedia".equals(str3)) {
                                                        vipFunCallJsPlugin2.SetFuncallCallBack = str26;
                                                        bundle.putInt("callId", i3);
                                                        bundle.putInt(VipFunCallConstants.KEY_RING_ID, i16);
                                                        bundle.putInt(VipFunCallConstants.KEY_FEET_TYPE, i19);
                                                        vipFunCallJsPlugin2.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("funcall_set", str26, vipFunCallJsPlugin2.mOnRemoteResp.key, bundle), false, false);
                                                        equals = vipFunCallJsPlugin2;
                                                    } else {
                                                        if ("downloadFunCallMedia".equals(str3)) {
                                                            String str27 = str15;
                                                            try {
                                                                String e46 = h.e(i16, 3);
                                                                try {
                                                                    int testResStatus = testResStatus(i16, e46, vipFunCallJsPlugin2.down_ringStatus, vipFunCallJsPlugin2.down_ringProgress, "down_ring");
                                                                    if (QLog.isColorLevel()) {
                                                                        str20 = str27;
                                                                        try {
                                                                            QLog.d(str20, 2, "startDownload, ringPath=" + e46 + ", ringId=" + i16 + ", ringUrl in=" + str14 + ", resStatus:" + testResStatus);
                                                                        } catch (JSONException e47) {
                                                                            e17 = e47;
                                                                            str5 = ", url=";
                                                                            str9 = str;
                                                                            jSONException = e17;
                                                                            str7 = str20;
                                                                            QLog.e(str7, 1, "handleJsRequest, JSONException=" + jSONException.getMessage() + str5 + str9);
                                                                            return true;
                                                                        } catch (Exception e48) {
                                                                            e16 = e48;
                                                                            str8 = str;
                                                                            exc = e16;
                                                                            str7 = str20;
                                                                            QLog.e(str7, 1, "handleJsRequest, Exception=" + exc.getMessage() + ", url=" + str8);
                                                                            return true;
                                                                        }
                                                                    } else {
                                                                        str20 = str27;
                                                                    }
                                                                    String resourcePathByUrl = VipFunCallUtil.getResourcePathByUrl(null, i3, VipFunCallUtil.getResourceType(), str24);
                                                                    int testResStatus2 = testResStatus(i3, resourcePathByUrl, vipFunCallJsPlugin2.down_status, vipFunCallJsPlugin2.down_progress, "down_fcVideo");
                                                                    if (QLog.isColorLevel()) {
                                                                        QLog.d(str20, 2, "startDownload, mediaUrl=" + str24 + ", fcPath=" + resourcePathByUrl + ", callId=" + i3 + ", resStatus:" + testResStatus2);
                                                                    }
                                                                    if (TextUtils.isEmpty(resourcePathByUrl)) {
                                                                        QLog.e(str20, 1, "startDownload queryDownloadInfo no mediaUrl , fcPath=null.");
                                                                        jSONObject4.put(str22, VipFunCallConstants.SETFUNCALL_ERR_ERRID);
                                                                        jSONObject4.put(str23, "no mediaUrl , fcPath=null");
                                                                        vipFunCallJsPlugin2.callJs(str26, jSONObject4.toString());
                                                                        return true;
                                                                    }
                                                                    String resourcePathByUrl2 = VipFunCallUtil.getResourcePathByUrl(null, i3, 9, str25);
                                                                    try {
                                                                        int testResStatus3 = testResStatus(i3, resourcePathByUrl2, vipFunCallJsPlugin2.down_bgstatus, vipFunCallJsPlugin2.down_bgprogress, "down_fuzzpic");
                                                                        if (QLog.isColorLevel()) {
                                                                            QLog.d(str20, 2, "startDownload, fuzzUrl=" + str25 + ", fuzzPath=" + resourcePathByUrl2 + ", callId=" + i3 + ", resStatus:" + testResStatus3);
                                                                        }
                                                                        if (!Utils.B()) {
                                                                            QLog.e(str20, 1, "startDownload SDCard not available.");
                                                                            jSONObject4.put(str22, VipFunCallConstants.SETFUNCALL_ERR_NOSDCARD);
                                                                            jSONObject4.put(str23, "no sdcard");
                                                                            callJs(str26, jSONObject4.toString());
                                                                            return true;
                                                                        }
                                                                        long z16 = Utils.z();
                                                                        if (z16 < 1048576) {
                                                                            QLog.e(str20, 1, "startDownload Insufficient SDCard space, required: reserved:1048576|available:" + z16);
                                                                            jSONObject4.put(str22, VipFunCallConstants.SETFUNCALL_ERR_DISKHASFULL);
                                                                            jSONObject4.put(str23, "SDCard is full");
                                                                            callJs(str26, jSONObject4.toString());
                                                                            return true;
                                                                        }
                                                                        sendRemoteReq(com.tencent.mobileqq.emosm.a.a("funcall_download", str26, this.mOnRemoteResp.key, bundle), false, false);
                                                                        jSONObject4.put(str23, "id is downloading");
                                                                        callJs(str26, jSONObject4.toString());
                                                                    } catch (JSONException e49) {
                                                                        e17 = e49;
                                                                        str5 = ", url=";
                                                                        str9 = str;
                                                                        jSONException = e17;
                                                                        str7 = str20;
                                                                        QLog.e(str7, 1, "handleJsRequest, JSONException=" + jSONException.getMessage() + str5 + str9);
                                                                        return true;
                                                                    } catch (Exception e56) {
                                                                        e16 = e56;
                                                                        str8 = str;
                                                                        exc = e16;
                                                                        str7 = str20;
                                                                        QLog.e(str7, 1, "handleJsRequest, Exception=" + exc.getMessage() + ", url=" + str8);
                                                                        return true;
                                                                    }
                                                                } catch (JSONException e57) {
                                                                    str5 = ", url=";
                                                                    str9 = str;
                                                                    jSONException = e57;
                                                                    str7 = str27;
                                                                } catch (Exception e58) {
                                                                    str8 = str;
                                                                    exc = e58;
                                                                    str7 = str27;
                                                                }
                                                            } catch (JSONException e59) {
                                                                str16 = str;
                                                                jSONException = e59;
                                                                str7 = str27;
                                                                str5 = ", url=";
                                                                str9 = str16;
                                                                QLog.e(str7, 1, "handleJsRequest, JSONException=" + jSONException.getMessage() + str5 + str9);
                                                                return true;
                                                            } catch (Exception e65) {
                                                                e = e65;
                                                                r36 = str;
                                                                str7 = str27;
                                                                exc = e;
                                                                str8 = r36;
                                                                QLog.e(str7, 1, "handleJsRequest, Exception=" + exc.getMessage() + ", url=" + str8);
                                                                return true;
                                                            }
                                                        } else {
                                                            String str28 = str14;
                                                            str7 = str15;
                                                            VipFunCallJsPlugin vipFunCallJsPlugin3 = vipFunCallJsPlugin2;
                                                            try {
                                                                try {
                                                                    r36 = "queryDownloadInfo".equals(str3);
                                                                    if (r36 != 0) {
                                                                        try {
                                                                            JSONObject jSONObject5 = new JSONObject();
                                                                            if (vipFunCallJsPlugin3.down_status.get(i3) <= 0) {
                                                                                String resourcePathByUrl3 = VipFunCallUtil.getResourcePathByUrl(null, i3, VipFunCallUtil.getResourceType(), str24);
                                                                                i18 = i16;
                                                                                str17 = str25;
                                                                                jSONObject2 = jSONObject4;
                                                                                jSONObject = jSONObject5;
                                                                                try {
                                                                                    int testResStatus4 = testResStatus(i3, resourcePathByUrl3, vipFunCallJsPlugin3.down_status, vipFunCallJsPlugin3.down_progress, "query_fcVideo");
                                                                                    if (QLog.isColorLevel()) {
                                                                                        StringBuilder sb5 = new StringBuilder();
                                                                                        sb5.append("queryDownloadInfo video, mediaUrl=");
                                                                                        sb5.append(str24);
                                                                                        sb5.append(", fcPath=");
                                                                                        str19 = resourcePathByUrl3;
                                                                                        sb5.append(str19);
                                                                                        sb5.append(", callId=");
                                                                                        sb5.append(i3);
                                                                                        sb5.append(", resStatus:");
                                                                                        sb5.append(testResStatus4);
                                                                                        QLog.d(str7, 2, sb5.toString());
                                                                                    } else {
                                                                                        str19 = resourcePathByUrl3;
                                                                                    }
                                                                                    if (TextUtils.isEmpty(str19)) {
                                                                                        QLog.e(str7, 1, "queryDownloadInfo Error no mediaUrl , fcPath=null.");
                                                                                        jSONObject2.put(str22, VipFunCallConstants.SETFUNCALL_ERR_ERRID);
                                                                                        jSONObject2.put(str23, str3 + " no mediaUrl , fcPath=null");
                                                                                        callJs(str26, jSONObject2.toString());
                                                                                        return true;
                                                                                    }
                                                                                    vipFunCallJsPlugin3 = this;
                                                                                    str18 = str26;
                                                                                } catch (JSONException e66) {
                                                                                    e = e66;
                                                                                    str5 = ", url=";
                                                                                    str6 = str;
                                                                                    jSONException = e;
                                                                                    str9 = str6;
                                                                                    QLog.e(str7, 1, "handleJsRequest, JSONException=" + jSONException.getMessage() + str5 + str9);
                                                                                    return true;
                                                                                } catch (Exception e67) {
                                                                                    e = e67;
                                                                                    r36 = str;
                                                                                    exc = e;
                                                                                    str8 = r36;
                                                                                    QLog.e(str7, 1, "handleJsRequest, Exception=" + exc.getMessage() + ", url=" + str8);
                                                                                    return true;
                                                                                }
                                                                            } else {
                                                                                jSONObject = jSONObject5;
                                                                                i18 = i16;
                                                                                str17 = str25;
                                                                                jSONObject2 = jSONObject4;
                                                                                str18 = str26;
                                                                            }
                                                                            if (vipFunCallJsPlugin3.down_bgstatus.get(i3) <= 0) {
                                                                                String str29 = str17;
                                                                                String resourcePathByUrl4 = VipFunCallUtil.getResourcePathByUrl(null, i3, 9, str29);
                                                                                int testResStatus5 = testResStatus(i3, resourcePathByUrl4, vipFunCallJsPlugin3.down_bgstatus, vipFunCallJsPlugin3.down_bgprogress, "query_fuzzpic");
                                                                                if (QLog.isColorLevel()) {
                                                                                    QLog.d(str7, 2, "queryDownloadInfo bg, fuzzUrl=" + str29 + ", fuzzPath=" + resourcePathByUrl4 + ", callId=" + i3 + ", resStatus:" + testResStatus5);
                                                                                }
                                                                            }
                                                                            int i26 = i18;
                                                                            if (vipFunCallJsPlugin3.down_ringStatus.get(i26) <= 0) {
                                                                                String e68 = h.e(i26, 3);
                                                                                int testResStatus6 = testResStatus(i26, e68, vipFunCallJsPlugin3.down_ringStatus, vipFunCallJsPlugin3.down_ringProgress, "query_ring");
                                                                                if (QLog.isColorLevel()) {
                                                                                    QLog.d(str7, 2, "queryDownloadInfo ring, ringPath=" + e68 + ", ringId=" + i26 + ", ringUrl=" + str28 + ", resStatus:" + testResStatus6 + ", callId=" + i3);
                                                                                }
                                                                            }
                                                                            if (vipFunCallJsPlugin3.down_status.get(i3) == 1 && vipFunCallJsPlugin3.down_bgstatus.get(i3) == 1 && vipFunCallJsPlugin3.down_ringStatus.get(i26) == 1) {
                                                                                jSONObject3 = jSONObject;
                                                                                jSONObject3.put("status", 1);
                                                                                jSONObject3.put("onProgress", 0);
                                                                                if (QLog.isColorLevel()) {
                                                                                    QLog.d(str7, 2, "queryDownloadInfo DOWNLOAD_START, ringId=" + i26 + ", callId=" + i3);
                                                                                }
                                                                            } else {
                                                                                jSONObject3 = jSONObject;
                                                                                if (vipFunCallJsPlugin3.down_status.get(i3) == 3 && vipFunCallJsPlugin3.down_bgstatus.get(i3) == 3 && vipFunCallJsPlugin3.down_ringStatus.get(i26) == 3) {
                                                                                    jSONObject3.put("status", 3);
                                                                                    jSONObject3.put("onProgress", 100);
                                                                                    if (QLog.isColorLevel()) {
                                                                                        QLog.d(str7, 2, "queryDownloadInfo DOWNLOAD_DONE, ringId=" + i26 + ", callId=" + i3);
                                                                                    }
                                                                                } else {
                                                                                    int i27 = (((vipFunCallJsPlugin3.down_progress.get(i3) * 6) + (vipFunCallJsPlugin3.down_bgprogress.get(i3) * 1)) + (vipFunCallJsPlugin3.down_ringProgress.get(i26) * 3)) / 10;
                                                                                    jSONObject3.put("status", 2);
                                                                                    jSONObject3.put("onProgress", i27);
                                                                                    if (QLog.isColorLevel()) {
                                                                                        QLog.d(str7, 2, "DOWNLOAD_PROGRESS ringId=" + i26 + ", progress = " + i27 + " call");
                                                                                    }
                                                                                }
                                                                            }
                                                                            Bundle bundle2 = (Bundle) vipFunCallJsPlugin3.ipcData.get(String.valueOf(i3), Bundle.class);
                                                                            if (bundle2 != null && bundle2.getInt("status") == 3) {
                                                                                jSONObject3.put("status", 3);
                                                                                jSONObject3.put("onProgress", 100);
                                                                                if (QLog.isColorLevel()) {
                                                                                    QLog.d(str7, 2, "new queryDownloadInfo DOWNLOAD_DONE, ringId=" + i26 + ", callId=" + i3);
                                                                                }
                                                                            }
                                                                            jSONObject2.put("data", jSONObject3);
                                                                            vipFunCallJsPlugin3.callJs(str18, jSONObject2.toString());
                                                                        } catch (JSONException e69) {
                                                                            e = e69;
                                                                        }
                                                                    } else {
                                                                        try {
                                                                            if ("delFunCallGroup".equals(str3)) {
                                                                                vipFunCallJsPlugin3.SetFuncallCallBack = str26;
                                                                                if (QLog.isColorLevel()) {
                                                                                    StringBuilder sb6 = new StringBuilder();
                                                                                    sb6.append("handleJsRequest delFunCallGroup, url=");
                                                                                    sb6.append(str);
                                                                                    QLog.d(str7, 2, sb6.toString());
                                                                                }
                                                                                vipFunCallJsPlugin3.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("funcall_delete", str26, vipFunCallJsPlugin3.mOnRemoteResp.key, bundle), false, false);
                                                                            } else {
                                                                                QLog.e(str7, 1, str4 + str);
                                                                                jSONObject4.put(str22, -1);
                                                                                jSONObject4.put(str23, str3 + " is Error method.");
                                                                                vipFunCallJsPlugin3.callJs(str26, jSONObject4.toString());
                                                                            }
                                                                        } catch (JSONException e75) {
                                                                            e = e75;
                                                                            str5 = ", url=";
                                                                            str6 = r36;
                                                                            jSONException = e;
                                                                            str9 = str6;
                                                                            QLog.e(str7, 1, "handleJsRequest, JSONException=" + jSONException.getMessage() + str5 + str9);
                                                                            return true;
                                                                        } catch (Exception e76) {
                                                                            e = e76;
                                                                            exc = e;
                                                                            str8 = r36;
                                                                            QLog.e(str7, 1, "handleJsRequest, Exception=" + exc.getMessage() + ", url=" + str8);
                                                                            return true;
                                                                        }
                                                                    }
                                                                } catch (Exception e77) {
                                                                    e = e77;
                                                                }
                                                            } catch (JSONException e78) {
                                                                e = e78;
                                                                r36 = str;
                                                            }
                                                        }
                                                        return true;
                                                    }
                                                } catch (JSONException e79) {
                                                    e = e79;
                                                    r36 = str;
                                                    str7 = str15;
                                                    str5 = ", url=";
                                                    str6 = r36;
                                                    jSONException = e;
                                                    str9 = str6;
                                                    QLog.e(str7, 1, "handleJsRequest, JSONException=" + jSONException.getMessage() + str5 + str9);
                                                    return true;
                                                }
                                            }
                                            return true;
                                        } catch (JSONException e85) {
                                            str5 = ", url=";
                                            str9 = str;
                                            jSONException = e85;
                                            str7 = str15;
                                            QLog.e(str7, 1, "handleJsRequest, JSONException=" + jSONException.getMessage() + str5 + str9);
                                            return true;
                                        } catch (Exception e86) {
                                            str8 = str;
                                            exc = e86;
                                            str7 = str15;
                                            QLog.e(str7, 1, "handleJsRequest, Exception=" + exc.getMessage() + ", url=" + str8);
                                            return true;
                                        }
                                    }
                                } catch (JSONException e87) {
                                    str5 = ", url=";
                                    str9 = str;
                                    jSONException = e87;
                                    str7 = TAG;
                                    QLog.e(str7, 1, "handleJsRequest, JSONException=" + jSONException.getMessage() + str5 + str9);
                                    return true;
                                } catch (Exception e88) {
                                    str8 = str;
                                    exc = e88;
                                    str7 = TAG;
                                    QLog.e(str7, 1, "handleJsRequest, Exception=" + exc.getMessage() + ", url=" + str8);
                                    return true;
                                }
                            }
                            if (equals == 0) {
                            }
                            return true;
                        } catch (JSONException e89) {
                            str16 = str;
                            jSONException = e89;
                            str7 = str15;
                        }
                    } catch (Exception e95) {
                        e = e95;
                        r36 = str;
                        str7 = str15;
                        exc = e;
                        str8 = r36;
                        QLog.e(str7, 1, "handleJsRequest, Exception=" + exc.getMessage() + ", url=" + str8);
                        return true;
                    }
                    str15 = TAG;
                    JSONObject jSONObject42 = new JSONObject();
                    String str222 = str13;
                    jSONObject42.put(str222, 0);
                    String str232 = str11;
                    jSONObject42.put(str232, str3 + " has done.");
                    equals = "openPreview".equals(str3);
                    int i192 = i17;
                } catch (JSONException e96) {
                    e = e96;
                    r36 = str;
                }
            } catch (Exception e97) {
                e = e97;
                r36 = str;
            }
        } catch (JSONException e98) {
            e = e98;
            str5 = ", url=";
            str6 = str;
            str7 = TAG;
        }
    }

    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    public void onPushMsg(Bundle bundle) {
        SparseIntArray sparseIntArray;
        SparseIntArray sparseIntArray2;
        if (bundle != null) {
            try {
                String string = bundle.getString("callbackId");
                int i3 = bundle.getInt("srcType");
                if (i3 == 6) {
                    int i16 = bundle.getInt("resourceType");
                    if (i16 == 6) {
                        sparseIntArray = this.down_progress;
                        sparseIntArray2 = this.down_status;
                    } else if (i16 == 9) {
                        sparseIntArray = this.down_bgprogress;
                        sparseIntArray2 = this.down_bgstatus;
                    } else if (i16 == 3) {
                        sparseIntArray = this.down_ringProgress;
                        sparseIntArray2 = this.down_ringStatus;
                    } else if (i16 == 7) {
                        QLog.d(TAG, 1, "onPushMsg resourceType = TYPE_PICTURE:" + i16);
                        sparseIntArray = this.down_progress;
                        sparseIntArray2 = this.down_status;
                    } else {
                        sparseIntArray = null;
                        sparseIntArray2 = null;
                    }
                    if (sparseIntArray != null && sparseIntArray2 != null) {
                        int i17 = bundle.getInt(VipFunCallConstants.KEY_STATUSE);
                        int i18 = bundle.getInt("callId");
                        if (2 == i17) {
                            sparseIntArray.put(i18, bundle.getInt("progress"));
                            sparseIntArray2.put(i18, 2);
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "onProgress, id=" + i18 + ",srcType=" + i3 + ",resourceType=" + i16 + ",progress=" + sparseIntArray.get(i18));
                                return;
                            }
                            return;
                        }
                        if (3 == i17) {
                            boolean z16 = bundle.getBoolean(VipFunCallConstants.KEY_BOO_RESULT, true);
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "onDone, id=" + i18 + ",srcType=" + i3 + ",resourceType=" + i16 + ",result=" + z16);
                            }
                            if (z16) {
                                sparseIntArray.put(i18, 100);
                                sparseIntArray2.put(i18, 3);
                                if (!TextUtils.isEmpty(string)) {
                                    super.callJs(string, "{'result':0, 'message':'OK'}");
                                    return;
                                }
                                return;
                            }
                            sparseIntArray.put(i18, 100);
                            sparseIntArray2.put(i18, -4);
                            if (!TextUtils.isEmpty(string)) {
                                super.callJs(string, "{'result':-4, 'message':'download Error'}");
                                return;
                            }
                            return;
                        }
                        if (1 == i17 && QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "onStart, id=" + i18 + ",srcType=" + i3 + ",resourceType=" + i16);
                            return;
                        }
                        return;
                    }
                    QLog.e(TAG, 1, "onPushMsg Error0: resourceType=" + i16);
                    return;
                }
                if (i3 == 7) {
                    int i19 = bundle.getInt("result");
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "setMedia, result=" + i19);
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        if (i19 == 0) {
                            jSONObject.put("code", i19);
                            jSONObject.put("errorMessage", "sucess");
                        } else {
                            jSONObject.put("code", i19);
                            jSONObject.put("errorMessage", "set funcall err");
                        }
                        if (!TextUtils.isEmpty(string)) {
                            QLog.d(TAG, 2, "setMedia, callbackId=" + string + ", sid=" + this.SetFuncallCallBack);
                        }
                        callJs(this.SetFuncallCallBack, jSONObject.toString());
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                }
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        }
    }

    int testResStatus(int i3, String str, SparseIntArray sparseIntArray, SparseIntArray sparseIntArray2, String str2) {
        int i16 = 3;
        if (TextUtils.isEmpty(str)) {
            sparseIntArray2.put(i3, 100);
            sparseIntArray.put(i3, 3);
            i16 = -2;
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "testResStatus path isEmpty, id=" + i3 + ", path=" + str + ", from=" + str2 + ", local=-2");
            }
        } else {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                sparseIntArray2.put(i3, 100);
                sparseIntArray.put(i3, 3);
            } else {
                sparseIntArray2.put(i3, 0);
                sparseIntArray.put(i3, 1);
                i16 = 1;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "testResStatus, id=" + i3 + ", path=" + str + ", from=" + str2 + ", local=" + i16);
        }
        return i16;
    }
}
