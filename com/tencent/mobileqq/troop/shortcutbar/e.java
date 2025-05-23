package com.tencent.mobileqq.troop.shortcutbar;

import android.text.TextUtils;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f298633e;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f298634f;

    /* renamed from: g, reason: collision with root package name */
    public static int f298635g;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<Integer> f298636a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<Integer> f298637b;

    /* renamed from: c, reason: collision with root package name */
    public int f298638c;

    /* renamed from: d, reason: collision with root package name */
    public int f298639d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76527);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f298635g = 1;
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f298636a = new ArrayList<>();
        this.f298637b = new ArrayList<>();
        this.f298638c = 0;
        this.f298639d = 0;
        f298633e = false;
    }

    public static e d(ai[] aiVarArr) {
        boolean z16;
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        boolean z17 = false;
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        for (ai aiVar : aiVarArr) {
            String str = aiVar.f202268b;
            if (!TextUtils.isEmpty(str)) {
                arrayList.clear();
                arrayList2.clear();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    i3 = jSONObject.optInt("globalOpen", 0);
                    i16 = jSONObject.optInt("globalOpenStudyMode", 0);
                    i17 = jSONObject.optInt("groupShortcutBarSwitchWithoutAdmin", 0);
                    i18 = jSONObject.optInt("groupAppHotRecommendSwitch", 0);
                    JSONArray optJSONArray = jSONObject.optJSONArray("enabledGroupTypes");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        for (int i19 = 0; i19 < optJSONArray.length(); i19++) {
                            arrayList.add(Integer.valueOf(optJSONArray.getInt(i19)));
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("enabledGroupTypesStudyMode");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        for (int i26 = 0; i26 < optJSONArray2.length(); i26++) {
                            arrayList2.add(Integer.valueOf(optJSONArray2.getInt(i26)));
                        }
                    }
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        }
        e eVar = new e();
        if (i3 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        f298633e = z16;
        if (i16 == 1) {
            z17 = true;
        }
        f298634f = z17;
        eVar.f298636a = arrayList;
        eVar.f298638c = i17;
        eVar.f298639d = i18;
        eVar.f298637b = arrayList2;
        if (QLog.isColorLevel()) {
            QLog.d("TroopShortcutBarConfig", 2, "parse:" + eVar.toString());
        }
        return eVar;
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.f298639d > 0) {
            return true;
        }
        return false;
    }

    public boolean b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, i3)).booleanValue();
        }
        if (true == f298633e || this.f298636a.contains(Integer.valueOf(i3))) {
            return true;
        }
        return false;
    }

    public boolean c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, i3)).booleanValue();
        }
        if (true == f298634f || this.f298637b.contains(Integer.valueOf(i3))) {
            return true;
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "isGlobalOpen:" + f298633e + "\r\nisGlobalStudyModeOpen:" + f298634f + "\r\nmTroopShortCutBarSwitchList:" + this.f298636a + "\r\nmStudyModeTroopSwitchList:" + this.f298637b + "\r\ngroupShortcutBarSwitchWithoutAdmin:" + this.f298638c + "\r\ngroupAppHotRecommendSwitch:" + this.f298639d + "\r\n";
    }
}
