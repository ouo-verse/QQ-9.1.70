package com.tencent.mobileqq.troop.essencemsg;

import android.text.TextUtils;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f295306a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<String> f295307b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f295308c;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f295306a = 20;
        this.f295307b = new ArrayList<>();
        this.f295308c = true;
    }

    public static c b(ai[] aiVarArr) {
        boolean z16;
        c cVar = new c();
        for (ai aiVar : aiVarArr) {
            String str = aiVar.f202268b;
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (QLog.isColorLevel()) {
                        QLog.i("TroopEssenceMsgEntryConfig", 2, "jsonObj:" + jSONObject.toString());
                    }
                    cVar.f295306a = jSONObject.optInt("limitMemberNum", 0);
                    if (jSONObject.optInt("globalOpenWithNoCheckGrayUin", 0) > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    cVar.f295308c = z16;
                    JSONArray optJSONArray = jSONObject.optJSONArray("grayQunUin");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                            cVar.f295307b.add(String.valueOf(optJSONArray.get(i3)));
                        }
                    }
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopEssenceMsgEntryConfig", 2, "config:" + cVar.toString());
        }
        return cVar;
    }

    public boolean a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        if (this.f295308c) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int length = str.length();
        Iterator<String> it = this.f295307b.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (length >= next.length() && str.substring(length - next.length()).equals(next)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "mLimitMemberNum:" + this.f295306a + "\r\nmGlobalOpenWithNoCheckGrayUin:" + this.f295308c + "\r\nmGrayTroopTailUins:" + this.f295307b.toArray() + "\r\n";
    }
}
