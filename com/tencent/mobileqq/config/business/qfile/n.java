package com.tencent.mobileqq.config.business.qfile;

import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class n implements rb1.a<String>, IConfigData {

    /* renamed from: d, reason: collision with root package name */
    public HashMap<String, com.tencent.mobileqq.filemanager.data.c> f202760d;

    /* renamed from: e, reason: collision with root package name */
    public String f202761e;

    public n() {
        HashMap<String, com.tencent.mobileqq.filemanager.data.c> hashMap = new HashMap<>();
        this.f202760d = hashMap;
        hashMap.put("*", new com.tencent.mobileqq.filemanager.data.c());
        this.f202761e = "";
    }

    @Override // rb1.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onParse(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.length() == 0) {
                return;
            }
            this.f202761e = str;
            JSONArray names = jSONObject.names();
            for (int i3 = 0; i3 < names.length(); i3++) {
                String lowerCase = names.getString(i3).trim().toLowerCase();
                if (!TextUtils.isEmpty(lowerCase)) {
                    JSONObject optJSONObject = jSONObject.optJSONObject(lowerCase);
                    com.tencent.mobileqq.filemanager.data.c cVar = new com.tencent.mobileqq.filemanager.data.c();
                    cVar.f207739c = optJSONObject.getInt("CellNetAutoDownloadSize");
                    cVar.f207738b = optJSONObject.getInt("CellNetWarningSize");
                    cVar.f207737a = optJSONObject.getInt("WiFiNetAutoDownloadSize");
                    if (!lowerCase.contains(",")) {
                        this.f202760d.put(lowerCase, cVar);
                    } else {
                        for (String str2 : lowerCase.split(",")) {
                            String lowerCase2 = str2.trim().toLowerCase();
                            if (!TextUtils.isEmpty(lowerCase2)) {
                                this.f202760d.put(lowerCase2, cVar);
                            }
                        }
                    }
                }
            }
        } catch (JSONException e16) {
            QLog.e("QFileDownloadConfigBean", 1, QLog.getStackTraceString(e16));
        }
    }
}
