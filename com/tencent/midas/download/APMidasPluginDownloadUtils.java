package com.tencent.midas.download;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.comm.APMidasRSATools;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes9.dex */
public class APMidasPluginDownloadUtils {
    private static final String TAG = "PDUtils";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean checkIniFileExist(File file) {
        if (file == null || !file.isDirectory()) {
            return false;
        }
        return new File(file, "MidasSign.ini").exists();
    }

    private static JSONArray getPureH5UpdateJsAlertData(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("midassdk://") && str.length() > 11) {
            try {
                JSONObject jSONObject = new JSONObject(str.substring(11, str.length()));
                if (jSONObject.has("action") && "update".equalsIgnoreCase(jSONObject.getString("action")) && jSONObject.has("data") && !TextUtils.isEmpty(jSONObject.getString("data"))) {
                    return jSONObject.getJSONArray("data");
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        return null;
    }

    public static boolean handlePureH5UpdateJsAlertLogic(final Context context, String str) {
        if (context == null) {
            APLog.d(TAG, "Cannot handle h5 update logic! Null context!");
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            APLog.d(TAG, "Cannot handle h5 update logic! Empty alert message!");
            return false;
        }
        boolean isPureH5UpdateJsAlert = isPureH5UpdateJsAlert(str);
        JSONArray pureH5UpdateJsAlertData = getPureH5UpdateJsAlertData(str);
        if (pureH5UpdateJsAlertData == null) {
            APLog.d(TAG, "Cannot handle h5 update logic! Not relevant message!");
            return isPureH5UpdateJsAlert;
        }
        APLog.d(TAG, "Got h5 update alert message!");
        final ArrayList<APMidasPluginDownInfo> parseDownJson = parseDownJson(pureH5UpdateJsAlertData);
        if (parseDownJson == null) {
            APLog.d(TAG, "Got h5 update alert message! Cannot parse json to list!");
            return isPureH5UpdateJsAlert;
        }
        if (parseDownJson.size() <= 0) {
            APLog.d(TAG, "Got h5 update alert message! Cannot parse json to list! Size error = " + parseDownJson.size());
            return isPureH5UpdateJsAlert;
        }
        APLog.d(TAG, "Got h5 update alert message! Start down lists = " + parseDownJson.toString());
        APMidasPluginDownloadManager.startDownload(context, parseDownJson, new IAPMidasPluginDownListener() { // from class: com.tencent.midas.download.APMidasPluginDownloadUtils.1
            @Override // com.tencent.midas.download.IAPMidasPluginDownListener
            public void onDownloadSuccess() {
                APLog.d(APMidasPluginDownloadUtils.TAG, "Got h5 update alert message! List download success!");
                APMidasPluginDownloadUtils.writeMidasSignFile(context, parseDownJson);
            }

            @Override // com.tencent.midas.download.IAPMidasPluginDownListener
            public void onDownloadFail(int i3) {
            }
        });
        return isPureH5UpdateJsAlert;
    }

    private static boolean isPureH5UpdateJsAlert(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("midassdk://") && str.length() > 11) {
            try {
                JSONObject jSONObject = new JSONObject(str.substring(11, str.length()));
                if (jSONObject.has("action") && "update".equalsIgnoreCase(jSONObject.getString("action"))) {
                    APLog.d(TAG, "isPureH5UpdateJsAlert msg = " + str);
                    APLog.d(TAG, "isPureH5UpdateJsAlert == true!");
                    return true;
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    private static ArrayList<APMidasPluginDownInfo> parseDownJson(JSONArray jSONArray) {
        if (jSONArray == null) {
            APLog.e(TAG, "Cannot parse down json! jsonArray is null!");
            return null;
        }
        try {
            int length = jSONArray.length();
            if (length == 0) {
                APLog.e(TAG, "Cannot parse down json! jsonArray length is 0!");
                return null;
            }
            ArrayList<APMidasPluginDownInfo> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < length; i3++) {
                APMidasPluginDownInfo aPMidasPluginDownInfo = new APMidasPluginDownInfo();
                JSONObject jSONObject = (JSONObject) jSONArray.get(i3);
                String string = jSONObject.getString("file_name");
                aPMidasPluginDownInfo.name = string;
                if (TextUtils.isEmpty(string)) {
                    APLog.e(TAG, "Cannot parse down json! item's name is empty!");
                    return null;
                }
                String string2 = jSONObject.getString("update_md5");
                aPMidasPluginDownInfo.new_md5_encode = string2;
                if (TextUtils.isEmpty(string2)) {
                    APLog.e(TAG, "Cannot parse down json! item's new encode md5 is empty!");
                    return null;
                }
                try {
                    aPMidasPluginDownInfo.new_md5_decode = new APMidasRSATools().deCodeKey(aPMidasPluginDownInfo.new_md5_encode).substring(r7.length() - 32);
                    APLog.d(TAG, "Parse down json! name = " + aPMidasPluginDownInfo.name + " decode md5 success!");
                } catch (Exception e16) {
                    e16.printStackTrace();
                    APLog.e(TAG, "Cannot parse down json, decode md5 got exception = " + e16);
                }
                if (TextUtils.isEmpty(aPMidasPluginDownInfo.new_md5_decode)) {
                    APLog.e(TAG, "Cannot parse down json! item's new decode md5 is empty!");
                    return null;
                }
                String string3 = jSONObject.getString("full_download_url");
                aPMidasPluginDownInfo.full_url = string3;
                if (TextUtils.isEmpty(string3)) {
                    APLog.e(TAG, "Cannot parse down json! item's full url is empty!");
                    return null;
                }
                arrayList.add(aPMidasPluginDownInfo);
            }
            return arrayList;
        } catch (Exception e17) {
            e17.printStackTrace();
            APLog.e(TAG, "Cannot parse down json! exception = " + e17);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void writeMidasSignFile(Context context, ArrayList<APMidasPluginDownInfo> arrayList) {
        if (context == null) {
            APLog.e(TAG, "Cannot write MidasSign.ini! null context!");
            return;
        }
        if (arrayList == null) {
            APLog.e(TAG, "Cannot write MidasSign.ini! null list!");
            return;
        }
        if (arrayList.size() <= 0) {
            APLog.e(TAG, "Cannot write MidasSign.ini! list size error = " + arrayList.size());
            return;
        }
        File file = new File(context.getApplicationContext().getDir("midaspluginsTemp", 0), "MidasSign.ini");
        if (file.exists() && !file.delete()) {
            APLog.e(TAG, "Cannot delete old MidasSign.ini file!");
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            String str = arrayList.get(i3).name;
            if (TextUtils.isEmpty(str)) {
                APLog.e(TAG, "Cannot write MidasSign.ini! item name empty!");
                return;
            }
            if (!str.endsWith(".apk")) {
                str = str + ".apk";
            }
            String str2 = arrayList.get(i3).new_md5_encode;
            if (TextUtils.isEmpty(str2)) {
                APLog.e(TAG, "Cannot write MidasSign.ini! item md5 empty!");
                return;
            }
            sb5.append(str + ":" + str2);
            sb5.append("\r\n");
        }
        String sb6 = sb5.toString();
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(sb6);
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e16) {
            e16.printStackTrace();
            APLog.e(TAG, "Write MidasSign.ini got exception = " + e16);
        }
        APLog.d(TAG, "Write MidasSign.ini success!");
    }
}
