package com.tencent.mobileqq.download.unite.config;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    public List<String> f203573a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public List<String> f203574b;

    /* renamed from: c, reason: collision with root package name */
    public String f203575c;

    /* renamed from: d, reason: collision with root package name */
    public String f203576d;

    /* renamed from: e, reason: collision with root package name */
    public String f203577e;

    /* renamed from: f, reason: collision with root package name */
    public String f203578f;

    /* renamed from: g, reason: collision with root package name */
    public String f203579g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f203580h;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f203573a = new ArrayList();
        this.f203574b = new ArrayList();
        this.f203575c = HardCodeUtil.qqStr(R.string.f237237gi);
        this.f203576d = HardCodeUtil.qqStr(R.string.f237207gf);
        this.f203577e = HardCodeUtil.qqStr(R.string.f237227gh);
        this.f203578f = HardCodeUtil.qqStr(R.string.f237217gg);
        this.f203579g = HardCodeUtil.qqStr(R.string.f237197ge);
        this.f203580h = true;
    }

    private static List<String> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            try {
                arrayList.add(jSONArray.getString(i3));
            } catch (JSONException e16) {
                QLog.e("[UniteDownload] DownloadConfigBean", 1, "jsonArray2List error: ", e16);
            }
        }
        return arrayList;
    }

    public static a b(ai[] aiVarArr) {
        a aVar = new a();
        if (aiVarArr != null && aiVarArr.length > 0) {
            for (ai aiVar : aiVarArr) {
                String str = aiVar.f202268b;
                QLog.d("[UniteDownload] DownloadConfigBean", 2, "[config] parse: invoked. ", " content: ", str);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    JSONArray optJSONArray = jSONObject.optJSONArray("BlackList");
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("WhiteList");
                    aVar.f203573a = a(optJSONArray);
                    aVar.f203574b = a(optJSONArray2);
                    aVar.f203575c = jSONObject.optString("DialogTitle", HardCodeUtil.qqStr(R.string.f237237gi));
                    aVar.f203576d = jSONObject.optString("DialogContent", HardCodeUtil.qqStr(R.string.f237207gf));
                    aVar.f203578f = jSONObject.optString("DialogDownloadButton", HardCodeUtil.qqStr(R.string.f237217gg));
                    aVar.f203579g = jSONObject.optString("DialogCancelButton", HardCodeUtil.qqStr(R.string.f237197ge));
                    aVar.f203577e = jSONObject.optString("DialogFeedbackButton", HardCodeUtil.qqStr(R.string.f237227gh));
                    aVar.f203580h = jSONObject.optBoolean("EnableUniteDownloadDialog", true);
                } catch (Throwable th5) {
                    QLog.e("[UniteDownload] DownloadConfigBean", 1, th5, new Object[0]);
                }
            }
        }
        return aVar;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "DownloadConfigBean{blacklist=" + this.f203573a + ", whitelist=" + this.f203574b + ", dialogTitle='" + this.f203575c + "', dialogContent='" + this.f203576d + "', dialogFeedbackButton='" + this.f203577e + "', dialogDownloadButton='" + this.f203578f + "', dialogCancelButton='" + this.f203579g + "', enableUniteDownloadDialog=" + this.f203580h + '}';
    }
}
