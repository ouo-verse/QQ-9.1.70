package com.tencent.bugly.common.reporter.upload;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.reporter.link.PluginLinkDataProxy;
import com.tencent.bugly.common.utils.FileUtil;
import com.tencent.rmonitor.common.logger.Logger;
import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.zip.GZIPOutputStream;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SampleUpload extends QAPMUpload {
    private static final String TAG = "CrashReport";
    private final String baseType;
    private final JSONObject mRequestJson;
    private JSONObject mResponseJson;
    private final String subType;

    public SampleUpload(@NotNull URL url, JSONObject jSONObject) {
        super(url);
        String str;
        String str2;
        String str3 = null;
        this.mResponseJson = null;
        this.mRequestJson = jSONObject;
        if (jSONObject != null) {
            try {
                str = jSONObject.optString(ReportDataBuilder.KEY_BASE_TYPE, "");
                try {
                    str3 = jSONObject.optString("sub_type", "");
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                str = null;
            }
            str2 = str3;
            str3 = str;
        } else {
            str2 = null;
        }
        this.baseType = str3;
        this.subType = str2;
    }

    private void buildHeader(HashMap<String, String> hashMap) {
        hashMap.put("Content-Encoding", "gzip");
        hashMap.put("Content-Type", "application/json");
    }

    public JSONObject getResponseJson() {
        return this.mResponseJson;
    }

    @Override // com.tencent.bugly.common.reporter.upload.BaseUpload
    public void request() {
        HttpURLConnection httpURLConnection;
        if (this.mRequestJson == null || EntranceResponseProcessor.whetherBlockReport(this.baseType, this.subType)) {
            return;
        }
        PluginLinkDataProxy.getInstance().collectPluginLinkData(this.mRequestJson);
        HashMap<String, String> hashMap = new HashMap<>();
        buildHeader(hashMap);
        try {
            httpURLConnection = connectionBuilder(hashMap, 30000, 30000);
            if (httpURLConnection != null) {
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(new DataOutputStream(httpURLConnection.getOutputStream()));
                    gZIPOutputStream.write(this.mRequestJson.toString().getBytes());
                    gZIPOutputStream.finish();
                    if (httpURLConnection.getResponseCode() >= 400) {
                        Logger.f365497g.w(TAG, FileUtil.readStream(new BufferedInputStream(httpURLConnection.getErrorStream()), 8192));
                    } else {
                        JSONObject jSONObject = new JSONObject(FileUtil.readStream(new BufferedInputStream(httpURLConnection.getInputStream()), 8192));
                        this.mResponseJson = jSONObject;
                        if (jSONObject.optInt("code") == 0) {
                            EntranceResponseProcessor.onEntranceResponse(this.baseType, this.subType, this.mResponseJson);
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        th.printStackTrace();
                        this.mResponseJson = null;
                        if (httpURLConnection == null) {
                            return;
                        }
                    } finally {
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    }
                }
            }
        } catch (Throwable th6) {
            th = th6;
            httpURLConnection = null;
        }
    }
}
