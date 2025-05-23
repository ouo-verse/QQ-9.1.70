package com.tencent.tgpa.lite.g;

import android.os.AsyncTask;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tenpay.ndk.CftSoLoader;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public class k extends AsyncTask<Void, Void, Void> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f375979a;

    /* renamed from: b, reason: collision with root package name */
    private String f375980b;

    public k(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
        } else {
            this.f375979a = str;
            this.f375980b = str2;
        }
    }

    private String a() {
        if (com.tencent.tgpa.lite.a.b.a().f375869b.f375872b == null) {
            com.tencent.tgpa.lite.a.b.a().f375869b.f375872b = j.a("IvParameter", null);
        }
        return com.tencent.tgpa.lite.a.b.a().f375869b.f375872b;
    }

    private String b() {
        if (com.tencent.tgpa.lite.a.b.a().f375869b.f375871a == null) {
            com.tencent.tgpa.lite.a.b.a().f375869b.f375871a = j.a("SecretKey", null);
        }
        return com.tencent.tgpa.lite.a.b.a().f375869b.f375871a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Void) iPatchRedirector.redirect((short) 2, (Object) this, (Object) voidArr);
        }
        try {
            str = this.f375979a;
            str2 = this.f375980b;
        } catch (IOException e16) {
            e16.printStackTrace();
            h.b("simple report report data failed, ple check network!", new Object[0]);
        } catch (InvalidKeyException e17) {
            e17.printStackTrace();
            h.b("simple report report data exception, ple check key!", new Object[0]);
        } catch (InvalidParameterException e18) {
            e18.printStackTrace();
            h.b("simple report report data exception, ple check iv!", new Object[0]);
        } catch (Exception e19) {
            e19.printStackTrace();
            h.b("simple report report data exception, ple check!", new Object[0]);
        }
        if (str == null || str2 == null) {
            h.b("report failed! ple check event_name/event_data!", new Object[0]);
            return null;
        }
        h.a("event_name: %s , event_data: %s .", str, str2);
        String b16 = b();
        String a16 = a();
        if (b16 == null) {
            throw new InvalidKeyException("key get null!");
        }
        if (a16 == null) {
            throw new InvalidParameterException("ivparameter get null!");
        }
        String str3 = new String(e.b(e.a(str2.getBytes(), b16, a16)));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("tgpa_id", com.tencent.tgpa.lite.f.a.c());
        jSONObject.put("event_name", str);
        jSONObject.put("event_data", str3);
        jSONObject.put("event_time", c.a());
        jSONObject.put(HianalyticsBaseData.SDK_TYPE, "simple");
        jSONObject.put("sdk_tag", "Android");
        jSONObject.put("version_name", CftSoLoader.VERSION_1_2_6);
        jSONObject.put("version_code", String.valueOf(26));
        jSONObject.put("cpu_info", d.g());
        jSONObject.put("ui_mode", d.i());
        jSONObject.put("screen_size", d.h());
        jSONObject.put("can_phone", d.a());
        String jSONObject2 = jSONObject.toString();
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("accept", "application/json");
        String str4 = com.tencent.tgpa.lite.f.a.a() + "/cloudctrl/xid_report_v2";
        h.a("simple report url: %s , event json data: %s", str4, jSONObject2);
        h.a("simple report finished. response data: %s .", String.valueOf(g.a(str4, jSONObject2, hashMap)));
        return null;
    }
}
