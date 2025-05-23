package com.tencent.mobileqq.transfile.dns;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class DomainData {
    static IPatchRedirector $redirector_ = null;
    public static final String DOMAIN_NAME = "n";
    public static final String IP_LIST = "l";
    private static final String TAG = "NtDns.DomainData";
    public String mDomain;
    public ArrayList<IpData> mIpList;

    public DomainData(String str, ArrayList<IpData> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) arrayList);
        } else {
            this.mDomain = str;
            this.mIpList = arrayList;
        }
    }

    public static String parse(HashMap<String, DomainData> hashMap) {
        if (hashMap == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (DomainData domainData : hashMap.values()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(DOMAIN_NAME, domainData.mDomain);
                jSONObject.put("l", IpData.parse(domainData.mIpList));
                jSONArray.mo162put(jSONObject);
            }
            return jSONArray.toString();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "parse error", e16);
            return null;
        }
    }

    public static HashMap<String, DomainData> unParse(String str) {
        try {
            HashMap<String, DomainData> hashMap = new HashMap<>();
            JSONArray jSONArray = new JSONArray(str);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                String string = jSONObject.getString(DOMAIN_NAME);
                hashMap.put(string, new DomainData(string, IpData.unParse(jSONObject.getString("l"))));
            }
            return hashMap;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "unParse error", e16);
            return null;
        }
    }
}
