package com.tencent.mobileqq.config.business.qfile;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadChnConfigInfo;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.weiyun.transmission.db.JobDbManager;
import cooperation.qzone.QZoneHelper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class r implements rb1.a<String>, h {

    /* renamed from: e, reason: collision with root package name */
    private long f202775e = QZoneHelper.Constants.NO_WIFI_UPLOAD_VIDEO_MAX_SIZE_DEFAULT;

    /* renamed from: f, reason: collision with root package name */
    private boolean f202776f = false;

    /* renamed from: h, reason: collision with root package name */
    private ExcitingTransferUploadChnConfigInfo f202777h = new ExcitingTransferUploadChnConfigInfo();

    /* renamed from: d, reason: collision with root package name */
    public String f202774d = "";

    private void e(JSONObject jSONObject) {
        try {
            this.f202776f = jSONObject.getBoolean("enableaqq");
            JSONObject jSONObject2 = jSONObject.getJSONObject(DownloadInfo.spKey_Config);
            if (jSONObject2 != null) {
                this.f202777h.uMuliFileSizeLimit = jSONObject2.getLong("mulifilesizelimit");
                this.f202777h.uMaxChannelNum = jSONObject2.getInt("maxchannelnum");
                this.f202777h.uPieceSize = jSONObject2.getInt("piecesize");
                this.f202777h.nMaxEachHostTotalUseCount = jSONObject2.getInt("maxeachhosttotalusecount");
                this.f202777h.nMaxEachHostErrorCount = jSONObject2.getInt("maxeachhosterrorcount");
                this.f202777h.nMaxEachHostParallelUseCount = jSONObject2.getInt("maxeachhostparallelusecount");
                this.f202777h.nConnectTimeout = jSONObject2.getLong("connecttimeout");
                this.f202777h.nDataTimeout = jSONObject2.getLong("datatimeout");
                this.f202777h.nTotoalDataTimeout = jSONObject2.getLong("totoaldatatimeout");
                this.f202775e = jSONObject2.getLong("limitedsize");
            } else {
                this.f202775e = QZoneHelper.Constants.NO_WIFI_UPLOAD_VIDEO_MAX_SIZE_DEFAULT;
                this.f202777h = new ExcitingTransferUploadChnConfigInfo();
            }
            QLog.i("QFileExcitingGroupUploadConfigBean<FileAssistant>", 1, "parse Exciting-Group-Upload config: enable:" + this.f202776f + " LimitedSize:" + this.f202775e + " " + this.f202777h.toString());
        } catch (JSONException e16) {
            QLog.e("QFileExcitingGroupUploadConfigBean<FileAssistant>", 1, QLog.getStackTraceString(e16));
        }
    }

    private void f() {
        this.f202775e = QZoneHelper.Constants.NO_WIFI_UPLOAD_VIDEO_MAX_SIZE_DEFAULT;
        this.f202776f = false;
        this.f202777h = new ExcitingTransferUploadChnConfigInfo();
    }

    @Override // com.tencent.mobileqq.config.business.qfile.h
    public long a() {
        return this.f202775e;
    }

    @Override // com.tencent.mobileqq.config.business.qfile.h
    public boolean b() {
        return this.f202776f;
    }

    @Override // com.tencent.mobileqq.config.business.qfile.h
    public ExcitingTransferUploadChnConfigInfo c() {
        return this.f202777h;
    }

    @Override // rb1.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onParse(String str) {
        JSONObject jSONObject;
        String lowerCase = str.toLowerCase();
        this.f202774d = lowerCase;
        if (TextUtils.isEmpty(lowerCase)) {
            QLog.w("QFileExcitingGroupUploadConfigBean<FileAssistant>", 1, "configContent is empty, use default value");
            f();
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(this.f202774d);
            if (jSONObject2.length() == 0) {
                QLog.w("QFileExcitingGroupUploadConfigBean<FileAssistant>", 1, "configContent is empty json, use default value");
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
                if (!TextUtils.isEmpty(trim) && (jSONObject = jSONObject2.optJSONObject(trim).getJSONObject(JobDbManager.TBL_UPLOAD)) != null) {
                    e(jSONObject);
                    z16 = true;
                    break;
                }
                i3++;
            }
            if (!z16) {
                QLog.w("QFileExcitingGroupUploadConfigBean<FileAssistant>", 1, "configContent no Exciting-Group-Upload config, use default value");
                f();
            }
        } catch (JSONException e16) {
            QLog.e("QFileExcitingGroupUploadConfigBean<FileAssistant>", 1, QLog.getStackTraceString(e16));
        }
    }
}
