package com.tencent.mobileqq.vaswebviewplugin;

import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class HealthUiPlugin extends VasWebviewUiPlugin {
    private static final String TAG = "HealthUiPlugin";
    public boolean mIsJDUpdateConfigInit;
    public ArrayList<String> mJDUpdateConfig = new ArrayList<>(4);

    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewUiPlugin
    protected boolean excuteEvent(final String str, long j3, Map<String, Object> map) {
        if (!TextUtils.isEmpty(str) && j3 == 16) {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.vaswebviewplugin.HealthUiPlugin.1
                @Override // java.lang.Runnable
                public void run() {
                    JSONArray jSONArray;
                    int i3;
                    String str2;
                    String str3;
                    HealthUiPlugin healthUiPlugin = HealthUiPlugin.this;
                    if (healthUiPlugin.mRuntime == null) {
                        return;
                    }
                    synchronized (healthUiPlugin.mJDUpdateConfig) {
                        if (!HealthUiPlugin.this.mIsJDUpdateConfigInit) {
                            try {
                                File file = new File(HealthUiPlugin.this.mRuntime.a().getApplicationContext().getFilesDir(), ClubContentJsonTask.sIndividuationTask.jsonName);
                                if (file.exists() && (jSONArray = new JSONObject(FileUtils.readFileContent(file)).getJSONObject("data").getJSONArray("jdUploadLog")) != null) {
                                    int length = jSONArray.length();
                                    for (int i16 = 0; i16 < length; i16++) {
                                        JSONObject jSONObject = jSONArray.getJSONObject(i16);
                                        if (jSONObject.has("jdUploadLog")) {
                                            String string = jSONObject.getString("jdUploadLog");
                                            if (!TextUtils.isEmpty(string)) {
                                                HealthUiPlugin.this.mJDUpdateConfig.add(string);
                                            }
                                        }
                                    }
                                }
                            } catch (Exception unused) {
                            }
                            HealthUiPlugin.this.mIsJDUpdateConfigInit = true;
                        }
                    }
                    if (HealthUiPlugin.this.mJDUpdateConfig.size() == 0) {
                        return;
                    }
                    try {
                        i3 = NetworkUtil.getSystemNetwork(HealthUiPlugin.this.mRuntime.a().getApplicationContext());
                    } catch (Exception unused2) {
                        i3 = 0;
                    }
                    if (i3 == 0) {
                        return;
                    }
                    String str4 = i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? null : "4G" : "3G" : "2G" : "wifi";
                    if (!TextUtils.isEmpty(str4) && HealthUiPlugin.this.mJDUpdateConfig.contains(str4)) {
                        if (str.contains("jd.com") || str.contains("wanggou.com") || str.contains("paipai.com")) {
                            StringBuilder sb5 = new StringBuilder();
                            try {
                                sb5.append("jd");
                                sb5.append("|");
                                sb5.append(URLEncoder.encode(str, "UTF-8"));
                                sb5.append("|");
                                sb5.append(str4);
                                sb5.append("|");
                                sb5.append("android");
                                sb5.append("|");
                                sb5.append(AppSetting.f99551k);
                                sb5.append("|");
                                sb5.append("|");
                                sb5.append("|");
                                sb5.append("|");
                                sb5.append("|");
                                sb5.append("|");
                                sb5.append("|");
                                DcReportUtil.c(null, "dc00454", sb5.toString(), false);
                            } catch (Exception e16) {
                                e16.printStackTrace();
                            }
                        }
                        if (str.contains("91160.com") || str.contains("guahao.com")) {
                            int indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                            if (indexOf != -1) {
                                str2 = str.substring(0, indexOf);
                                str3 = str.substring(indexOf + 1);
                            } else {
                                str2 = str;
                                str3 = null;
                            }
                            if (!TextUtils.isEmpty(str3)) {
                                try {
                                    str2 = str2 + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + URLEncoder.encode(str3, "UTF-8");
                                } catch (Exception unused3) {
                                }
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d(HealthUiPlugin.TAG, 2, "report guahao url \n" + str2);
                            }
                            DcReportUtil.c(null, "dc00454", "jiankang|" + str2 + "|" + str4 + "|android|" + AppSetting.f99551k + "|||||||", false);
                        }
                    }
                }
            }, 5, null, false);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin
    public long getPluginBusiness() {
        return 65536L;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 19L;
    }
}
