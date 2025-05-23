package com.tencent.mobileqq.config.business.qfile;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadConfig;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class q implements rb1.a<String>, g {

    /* renamed from: e, reason: collision with root package name */
    private long f202771e = QZoneHelper.Constants.NO_WIFI_UPLOAD_VIDEO_MAX_SIZE_DEFAULT;

    /* renamed from: f, reason: collision with root package name */
    private boolean f202772f = false;

    /* renamed from: h, reason: collision with root package name */
    private ExcitingTransferDownloadConfig f202773h = new ExcitingTransferDownloadConfig();

    /* renamed from: d, reason: collision with root package name */
    public String f202770d = "";

    private void e(JSONObject jSONObject) {
        try {
            this.f202772f = jSONObject.getBoolean("enableaqq");
            JSONObject jSONObject2 = jSONObject.getJSONObject(DownloadInfo.spKey_Config);
            if (jSONObject2 != null) {
                if (jSONObject2.has("oneslicesize")) {
                    this.f202773h.mSliceSize = jSONObject2.getLong("oneslicesize");
                } else {
                    this.f202773h.mSliceSize = 524288L;
                }
                this.f202773h.uMaxParrallelSlice = jSONObject2.getInt("maxparrallelslice");
                this.f202773h.uMaxWaitingSlice = jSONObject2.getInt("maxtotalwaitingslice");
                this.f202773h.uNotifyIntervals = jSONObject2.getInt("notifyintervals");
                this.f202773h.uSpeedDuration = jSONObject2.getInt("speedduration");
                this.f202771e = jSONObject2.getInt("limitedsize");
                if (jSONObject2.has("slicenum")) {
                    this.f202773h.uSliceNum = jSONObject2.getInt("slicenum");
                } else {
                    this.f202773h.uSliceNum = 10;
                }
            } else {
                this.f202771e = QZoneHelper.Constants.NO_WIFI_UPLOAD_VIDEO_MAX_SIZE_DEFAULT;
                this.f202773h = new ExcitingTransferDownloadConfig();
            }
            QLog.i("QFileExcitingGroupDownloadConfigBean<FileAssistant>", 1, "parse Exciting-Group-Download config: enable:" + this.f202772f + " LimitedSize:" + this.f202771e + " " + this.f202773h.toString());
        } catch (JSONException e16) {
            QLog.e("QFileExcitingGroupDownloadConfigBean<FileAssistant>", 1, QLog.getStackTraceString(e16));
        }
    }

    private void f() {
        this.f202771e = QZoneHelper.Constants.NO_WIFI_UPLOAD_VIDEO_MAX_SIZE_DEFAULT;
        this.f202772f = false;
        this.f202773h = new ExcitingTransferDownloadConfig();
    }

    @Override // com.tencent.mobileqq.config.business.qfile.g
    public long a() {
        return this.f202771e;
    }

    @Override // com.tencent.mobileqq.config.business.qfile.g
    public boolean b() {
        return this.f202772f;
    }

    @Override // com.tencent.mobileqq.config.business.qfile.g
    public ExcitingTransferDownloadConfig c() {
        return this.f202773h;
    }

    @Override // rb1.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onParse(String str) {
        JSONObject jSONObject;
        String lowerCase = str.toLowerCase();
        this.f202770d = lowerCase;
        if (TextUtils.isEmpty(lowerCase)) {
            QLog.w("QFileExcitingGroupDownloadConfigBean<FileAssistant>", 1, "configContent is empty, use default value");
            f();
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(this.f202770d);
            if (jSONObject2.length() == 0) {
                QLog.w("QFileExcitingGroupDownloadConfigBean<FileAssistant>", 1, "configContent is empty json, use default value");
                f();
                return;
            }
            JSONArray names = jSONObject2.names();
            boolean z16 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= names.length()) {
                    break;
                }
                String trim = names.getString(i3).trim();
                if (!TextUtils.isEmpty(trim) && (jSONObject = jSONObject2.optJSONObject(trim).getJSONObject("download")) != null) {
                    e(jSONObject);
                    z16 = true;
                    break;
                }
                i3++;
            }
            if (!z16) {
                QLog.w("QFileExcitingGroupDownloadConfigBean<FileAssistant>", 1, "configContent no Exciting-Group-Download config, use default value");
                f();
            }
        } catch (JSONException e16) {
            QLog.e("QFileExcitingGroupDownloadConfigBean<FileAssistant>", 1, QLog.getStackTraceString(e16));
        }
    }
}
