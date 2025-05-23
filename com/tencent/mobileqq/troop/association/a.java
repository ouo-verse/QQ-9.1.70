package com.tencent.mobileqq.troop.association;

import android.text.TextUtils;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f294465a;

    /* renamed from: b, reason: collision with root package name */
    public int f294466b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<Integer> f294467c;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f294465a = 0;
        this.f294466b = 0;
        this.f294467c = new ArrayList<>();
    }

    public static a b(ai[] aiVarArr) {
        a aVar = new a();
        for (ai aiVar : aiVarArr) {
            String str = aiVar.f202268b;
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (QLog.isColorLevel()) {
                        QLog.i("TroopAssociationsEntryConfig", 2, "jsonObj:" + jSONObject.toString());
                    }
                    aVar.f294465a = jSONObject.optInt("switchOn", 0);
                    aVar.f294466b = jSONObject.optInt("troopMemberCount_ahn", 0);
                    JSONArray optJSONArray = jSONObject.optJSONArray("troopType_ahn");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                            if (optJSONArray.get(i3) instanceof Integer) {
                                aVar.f294467c.add((Integer) optJSONArray.get(i3));
                            }
                        }
                    }
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopAssociationsEntryConfig", 2, "config:" + aVar.toString());
        }
        return aVar;
    }

    public boolean a(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Long.valueOf(j3))).booleanValue();
        }
        int i16 = this.f294465a;
        if (i16 == 0) {
            return false;
        }
        if (i16 == 2) {
            return true;
        }
        if (i16 == 1 && !TextUtils.isEmpty(str) && i3 <= this.f294466b && this.f294467c.contains(Integer.valueOf((int) j3))) {
            return true;
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "mSwitchOn:" + this.f294465a + "\r\nmTroopMemberCount:" + this.f294466b + "\r\nmGrayTroopType:" + this.f294467c.toString() + "\r\n";
    }
}
