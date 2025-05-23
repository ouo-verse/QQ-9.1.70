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
public class o implements rb1.a<String>, e {

    /* renamed from: e, reason: collision with root package name */
    private long f202763e = QZoneHelper.Constants.NO_WIFI_UPLOAD_VIDEO_MAX_SIZE_DEFAULT;

    /* renamed from: f, reason: collision with root package name */
    private boolean f202764f = false;

    /* renamed from: h, reason: collision with root package name */
    private ExcitingTransferDownloadConfig f202765h = new ExcitingTransferDownloadConfig();

    /* renamed from: d, reason: collision with root package name */
    public String f202762d = "";

    private void e(JSONObject jSONObject) {
        try {
            this.f202764f = jSONObject.getBoolean("enableaqq");
            JSONObject jSONObject2 = jSONObject.getJSONObject(DownloadInfo.spKey_Config);
            if (jSONObject2 != null) {
                if (jSONObject2.has("oneslicesize")) {
                    this.f202765h.mSliceSize = jSONObject2.getLong("oneslicesize");
                } else {
                    this.f202765h.mSliceSize = 524288L;
                }
                this.f202765h.uMaxParrallelSlice = jSONObject2.getInt("maxparrallelslice");
                this.f202765h.uMaxWaitingSlice = jSONObject2.getInt("maxtotalwaitingslice");
                this.f202765h.uNotifyIntervals = jSONObject2.getInt("notifyintervals");
                this.f202765h.uSpeedDuration = jSONObject2.getInt("speedduration");
                this.f202763e = jSONObject2.getInt("limitedsize");
                if (jSONObject2.has("slicenum")) {
                    this.f202765h.uSliceNum = jSONObject2.getInt("slicenum");
                } else {
                    this.f202765h.uSliceNum = 10;
                }
            } else {
                this.f202763e = QZoneHelper.Constants.NO_WIFI_UPLOAD_VIDEO_MAX_SIZE_DEFAULT;
                this.f202765h = new ExcitingTransferDownloadConfig();
            }
            QLog.i("QFileExcitingC2CDownloadConfigBean<FileAssistant>", 1, "parse Exciting-C2C-Download config: enable:" + this.f202764f + " LimitedSize:" + this.f202763e + " " + this.f202765h.toString());
        } catch (JSONException e16) {
            QLog.e("QFileExcitingC2CDownloadConfigBean<FileAssistant>", 1, QLog.getStackTraceString(e16));
        }
    }

    private void f() {
        this.f202763e = QZoneHelper.Constants.NO_WIFI_UPLOAD_VIDEO_MAX_SIZE_DEFAULT;
        this.f202764f = false;
        this.f202765h = new ExcitingTransferDownloadConfig();
    }

    @Override // com.tencent.mobileqq.config.business.qfile.e
    public long a() {
        return this.f202763e;
    }

    @Override // com.tencent.mobileqq.config.business.qfile.e
    public boolean b() {
        return this.f202764f;
    }

    @Override // com.tencent.mobileqq.config.business.qfile.e
    public ExcitingTransferDownloadConfig c() {
        return this.f202765h;
    }

    @Override // rb1.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onParse(String str) {
        JSONObject jSONObject;
        String lowerCase = str.toLowerCase();
        this.f202762d = lowerCase;
        if (TextUtils.isEmpty(lowerCase)) {
            QLog.w("QFileExcitingC2CDownloadConfigBean<FileAssistant>", 1, "configContent is empty, use default value");
            f();
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(this.f202762d);
            if (jSONObject2.length() == 0) {
                QLog.w("QFileExcitingC2CDownloadConfigBean<FileAssistant>", 1, "configContent is empty json, use default value");
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
                QLog.w("QFileExcitingC2CDownloadConfigBean<FileAssistant>", 1, "configContent no Exciting-C2C-Download config, use default value");
                f();
            }
        } catch (JSONException e16) {
            QLog.e("QFileExcitingC2CDownloadConfigBean<FileAssistant>", 1, QLog.getStackTraceString(e16));
        }
    }
}
