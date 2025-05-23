package com.tencent.mobileqq.troop.memberlevel.api;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b implements IConfigData {
    static IPatchRedirector $redirector_;
    private String C;
    private String D;
    private boolean E;
    public int F;

    /* renamed from: d, reason: collision with root package name */
    private List<Integer> f297782d;

    /* renamed from: e, reason: collision with root package name */
    private HashMap<Integer, c> f297783e;

    /* renamed from: f, reason: collision with root package name */
    private HashMap<Integer, a> f297784f;

    /* renamed from: h, reason: collision with root package name */
    private HashMap<Integer, JSONObject> f297785h;

    /* renamed from: i, reason: collision with root package name */
    private TreeMap<Integer, Integer> f297786i;

    /* renamed from: m, reason: collision with root package name */
    private String f297787m;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f297782d = new ArrayList();
        this.f297783e = new HashMap<>();
        this.f297784f = new HashMap<>();
        this.f297785h = new HashMap<>();
        this.f297786i = new TreeMap<>();
        this.f297787m = "";
        this.C = "";
        this.D = "";
        this.E = false;
        this.F = 0;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(25:8|(6:9|10|11|(3:115|116|(3:118|(3:121|122|119)|123))|13|14)|(3:83|84|(24:86|(13:90|91|92|93|94|95|96|97|98|99|100|87|88)|107|17|18|19|20|(3:24|(3:27|28|25)|29)|30|(3:34|(3:37|38|35)|39)|40|(4:42|51|52|53)(1:77)|54|55|(1:57)(1:70)|58|59|60|61|62|63|47|(1:49)|50))|16|17|18|19|20|(4:22|24|(1:25)|29)|30|(4:32|34|(1:35)|39)|40|(0)(0)|54|55|(0)(0)|58|59|60|61|62|63|47|(0)|50) */
    /* JADX WARN: Can't wrap try/catch for region: R(30:8|9|10|11|(3:115|116|(3:118|(3:121|122|119)|123))|13|14|(3:83|84|(24:86|(13:90|91|92|93|94|95|96|97|98|99|100|87|88)|107|17|18|19|20|(3:24|(3:27|28|25)|29)|30|(3:34|(3:37|38|35)|39)|40|(4:42|51|52|53)(1:77)|54|55|(1:57)(1:70)|58|59|60|61|62|63|47|(1:49)|50))|16|17|18|19|20|(4:22|24|(1:25)|29)|30|(4:32|34|(1:35)|39)|40|(0)(0)|54|55|(0)(0)|58|59|60|61|62|63|47|(0)|50) */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01e6, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01eb, code lost:
    
        r18 = r1;
        r1 = r0;
        r0 = r4;
        r4 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01e8, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01e9, code lost:
    
        r3 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01f1, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01f2, code lost:
    
        r3 = r22;
        r4 = r2;
        r31 = r1;
        r1 = r0;
        r0 = r18;
        r18 = r31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01fd, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01fe, code lost:
    
        r3 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0209, code lost:
    
        r1 = r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x011b A[Catch: JSONException -> 0x016b, TRY_LEAVE, TryCatch #6 {JSONException -> 0x016b, blocks: (B:99:0x00c4, B:22:0x010d, B:25:0x0115, B:27:0x011b, B:32:0x017d, B:35:0x0185, B:37:0x018b, B:42:0x01b4), top: B:98:0x00c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x018b A[Catch: JSONException -> 0x016b, TRY_LEAVE, TryCatch #6 {JSONException -> 0x016b, blocks: (B:99:0x00c4, B:22:0x010d, B:25:0x0115, B:27:0x011b, B:32:0x017d, B:35:0x0185, B:37:0x018b, B:42:0x01b4), top: B:98:0x00c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01b4 A[Catch: JSONException -> 0x016b, TRY_ENTER, TRY_LEAVE, TryCatch #6 {JSONException -> 0x016b, blocks: (B:99:0x00c4, B:22:0x010d, B:25:0x0115, B:27:0x011b, B:32:0x017d, B:35:0x0185, B:37:0x018b, B:42:0x01b4), top: B:98:0x00c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b l(String str) {
        String str2;
        b bVar;
        String str3;
        ArrayList arrayList;
        JSONException jSONException;
        String str4;
        boolean z16;
        String str5;
        String str6;
        String str7;
        String str8;
        JSONObject jSONObject;
        JSONArray jSONArray;
        JSONObject jSONObject2;
        JSONArray jSONArray2;
        b bVar2;
        JSONArray jSONArray3;
        JSONArray jSONArray4;
        JSONObject jSONObject3;
        String string;
        int i3;
        int i16;
        String str9 = "";
        String str10 = "TroopMemberLevelMapConfig";
        if (QLog.isColorLevel()) {
            QLog.d("TroopMemberLevelMapConfig", 2, "content : " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        b bVar3 = new b();
        HashMap<Integer, c> hashMap = new HashMap<>();
        HashMap<Integer, a> hashMap2 = new HashMap<>();
        HashMap<Integer, JSONObject> hashMap3 = new HashMap<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        ArrayList arrayList2 = new ArrayList();
        try {
            jSONObject = new JSONObject(str);
            JSONArray jSONArray5 = jSONObject.getJSONArray("grayTroopUins");
            if (jSONArray5 != null) {
                try {
                    if (jSONArray5.length() > 0) {
                        for (int i17 = 0; i17 < jSONArray5.length(); i17++) {
                            arrayList2.add(Integer.valueOf(jSONArray5.getInt(i17)));
                        }
                    }
                } catch (JSONException e16) {
                    jSONException = e16;
                    str4 = "";
                    str2 = str4;
                    bVar = bVar3;
                    str3 = "TroopMemberLevelMapConfig";
                    arrayList = arrayList2;
                    str5 = str3;
                    z16 = true;
                    QLog.e(str5, 1, "parse exception, content=" + str, jSONException);
                    str7 = str9;
                    str8 = str2;
                    str6 = str4;
                    bVar.f297783e = hashMap;
                    bVar.f297784f = hashMap2;
                    bVar.f297785h = hashMap3;
                    ArrayList arrayList3 = arrayList;
                    bVar.f297782d = arrayList3;
                    bVar.f297786i = treeMap;
                    bVar.f297787m = str7;
                    bVar.C = str8;
                    bVar.D = str6;
                    bVar.E = z16;
                    if (QLog.isColorLevel()) {
                    }
                    return bVar;
                }
            }
            jSONArray = jSONObject.getJSONArray("troopMemberLevelMap");
        } catch (JSONException e17) {
            e = e17;
            str2 = "";
            bVar = bVar3;
            str3 = "TroopMemberLevelMapConfig";
            arrayList = arrayList2;
        }
        if (jSONArray != null) {
            try {
            } catch (JSONException e18) {
                e = e18;
                str2 = "";
            }
            if (jSONArray.length() > 0) {
                str2 = "";
                int i18 = 0;
                while (i18 < jSONArray.length()) {
                    try {
                        jSONObject2 = jSONArray.getJSONObject(i18);
                        jSONArray2 = jSONArray;
                        arrayList = arrayList2;
                        try {
                            str3 = str10;
                        } catch (JSONException e19) {
                            e = e19;
                            str3 = str10;
                        }
                    } catch (JSONException e26) {
                        e = e26;
                        str3 = str10;
                        arrayList = arrayList2;
                        jSONException = e;
                        bVar = bVar3;
                        str4 = str2;
                        str9 = str4;
                        str5 = str3;
                        z16 = true;
                        QLog.e(str5, 1, "parse exception, content=" + str, jSONException);
                        str7 = str9;
                        str8 = str2;
                        str6 = str4;
                        bVar.f297783e = hashMap;
                        bVar.f297784f = hashMap2;
                        bVar.f297785h = hashMap3;
                        ArrayList arrayList32 = arrayList;
                        bVar.f297782d = arrayList32;
                        bVar.f297786i = treeMap;
                        bVar.f297787m = str7;
                        bVar.C = str8;
                        bVar.D = str6;
                        bVar.E = z16;
                        if (QLog.isColorLevel()) {
                        }
                        return bVar;
                    }
                    try {
                        bVar2 = bVar3;
                        try {
                            hashMap.put(Integer.valueOf(jSONObject2.getInt("rankid")), new c(jSONObject2.getInt("begin"), jSONObject2.getInt("end"), jSONObject2.getInt("rankid"), jSONObject2.getString("rankname")));
                            i18++;
                            jSONArray = jSONArray2;
                            arrayList2 = arrayList;
                            str10 = str3;
                            bVar3 = bVar2;
                        } catch (JSONException e27) {
                            jSONException = e27;
                            str4 = str2;
                            str9 = str4;
                            bVar = bVar2;
                            str5 = str3;
                            z16 = true;
                            QLog.e(str5, 1, "parse exception, content=" + str, jSONException);
                            str7 = str9;
                            str8 = str2;
                            str6 = str4;
                            bVar.f297783e = hashMap;
                            bVar.f297784f = hashMap2;
                            bVar.f297785h = hashMap3;
                            ArrayList arrayList322 = arrayList;
                            bVar.f297782d = arrayList322;
                            bVar.f297786i = treeMap;
                            bVar.f297787m = str7;
                            bVar.C = str8;
                            bVar.D = str6;
                            bVar.E = z16;
                            if (QLog.isColorLevel()) {
                            }
                            return bVar;
                        }
                    } catch (JSONException e28) {
                        e = e28;
                        jSONException = e;
                        bVar = bVar3;
                        str4 = str2;
                        str9 = str4;
                        str5 = str3;
                        z16 = true;
                        QLog.e(str5, 1, "parse exception, content=" + str, jSONException);
                        str7 = str9;
                        str8 = str2;
                        str6 = str4;
                        bVar.f297783e = hashMap;
                        bVar.f297784f = hashMap2;
                        bVar.f297785h = hashMap3;
                        ArrayList arrayList3222 = arrayList;
                        bVar.f297782d = arrayList3222;
                        bVar.f297786i = treeMap;
                        bVar.f297787m = str7;
                        bVar.C = str8;
                        bVar.D = str6;
                        bVar.E = z16;
                        if (QLog.isColorLevel()) {
                        }
                        return bVar;
                    }
                }
                bVar2 = bVar3;
                str3 = str10;
                arrayList = arrayList2;
                jSONArray3 = jSONObject.getJSONArray("titleBackgroundColor");
                if (jSONArray3 != null && jSONArray3.length() > 0) {
                    for (i16 = 0; i16 < jSONArray3.length(); i16++) {
                        JSONObject jSONObject4 = jSONArray3.getJSONObject(i16);
                        String string2 = jSONObject4.getString("start");
                        String string3 = jSONObject4.getString("end");
                        hashMap2.put(Integer.valueOf(jSONObject4.getInt("titleId")), new a(jSONObject4.getInt("titleId"), string2, string3, jSONObject4.optString("darkStart", string2), jSONObject4.optString("darkEnd", string3), jSONObject4.optString("textColor", "#FFFFFF"), jSONObject4.optString("darkTextColor", "#FFFFFF")));
                        hashMap3.put(Integer.valueOf(jSONObject4.getInt("titleId")), jSONObject4);
                    }
                }
                jSONArray4 = jSONObject.getJSONArray("oldLevelToNewLevelMap");
                if (jSONArray4 != null && jSONArray4.length() > 0) {
                    for (i3 = 0; i3 < jSONArray4.length(); i3++) {
                        JSONObject jSONObject5 = jSONArray4.getJSONObject(i3);
                        treeMap.put(Integer.valueOf(jSONObject5.getInt(QCircleDaTongConstant.ElementParamValue.XSJ_SHARE_PANEL_STYLE_OLD)), Integer.valueOf(jSONObject5.getInt(QCircleDaTongConstant.ElementParamValue.NEW)));
                    }
                }
                jSONObject3 = jSONObject.getJSONObject("onlyLevelBackgroundColor");
                if (jSONObject3 == null) {
                    String string4 = jSONObject3.getString("start");
                    try {
                        str7 = string4;
                        str8 = jSONObject3.getString("end");
                    } catch (JSONException e29) {
                        str9 = string4;
                        bVar = bVar2;
                        jSONException = e29;
                        str4 = str2;
                        str5 = str3;
                        z16 = true;
                        QLog.e(str5, 1, "parse exception, content=" + str, jSONException);
                        str7 = str9;
                        str8 = str2;
                        str6 = str4;
                        bVar.f297783e = hashMap;
                        bVar.f297784f = hashMap2;
                        bVar.f297785h = hashMap3;
                        ArrayList arrayList32222 = arrayList;
                        bVar.f297782d = arrayList32222;
                        bVar.f297786i = treeMap;
                        bVar.f297787m = str7;
                        bVar.C = str8;
                        bVar.D = str6;
                        bVar.E = z16;
                        if (QLog.isColorLevel()) {
                        }
                        return bVar;
                    }
                } else {
                    str8 = str2;
                    str7 = str8;
                }
                string = jSONObject.getString("newGroupMemberLevelJumpUrl");
                if (string == null) {
                    str6 = string;
                } else {
                    str6 = str2;
                }
                bVar = bVar2;
                bVar.F = jSONObject.getInt("configVersion");
                str5 = str3;
                z16 = true;
                bVar.f297783e = hashMap;
                bVar.f297784f = hashMap2;
                bVar.f297785h = hashMap3;
                ArrayList arrayList322222 = arrayList;
                bVar.f297782d = arrayList322222;
                bVar.f297786i = treeMap;
                bVar.f297787m = str7;
                bVar.C = str8;
                bVar.D = str6;
                bVar.E = z16;
                if (QLog.isColorLevel()) {
                    QLog.d(str5, 2, "levelMap.size : " + hashMap.size() + ",levelColorMap.size :" + hashMap2.size() + ", tempGrayList.size :" + arrayList322222.size());
                }
                return bVar;
            }
        }
        str2 = "";
        bVar2 = bVar3;
        str3 = str10;
        arrayList = arrayList2;
        jSONArray3 = jSONObject.getJSONArray("titleBackgroundColor");
        if (jSONArray3 != null) {
            while (i16 < jSONArray3.length()) {
            }
        }
        jSONArray4 = jSONObject.getJSONArray("oldLevelToNewLevelMap");
        if (jSONArray4 != null) {
            while (i3 < jSONArray4.length()) {
            }
        }
        jSONObject3 = jSONObject.getJSONObject("onlyLevelBackgroundColor");
        if (jSONObject3 == null) {
        }
        string = jSONObject.getString("newGroupMemberLevelJumpUrl");
        if (string == null) {
        }
        bVar = bVar2;
        bVar.F = jSONObject.getInt("configVersion");
        str5 = str3;
        z16 = true;
        bVar.f297783e = hashMap;
        bVar.f297784f = hashMap2;
        bVar.f297785h = hashMap3;
        ArrayList arrayList3222222 = arrayList;
        bVar.f297782d = arrayList3222222;
        bVar.f297786i = treeMap;
        bVar.f297787m = str7;
        bVar.C = str8;
        bVar.D = str6;
        bVar.E = z16;
        if (QLog.isColorLevel()) {
        }
        return bVar;
    }

    public int[] a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (int[]) iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
        a aVar = this.f297784f.get(Integer.valueOf(i3));
        if (aVar != null) {
            String str = aVar.f297776b;
            String str2 = aVar.f297777c;
            if (QQTheme.isNowThemeIsNight()) {
                str = aVar.f297779e;
                str2 = aVar.f297780f;
            }
            return new int[]{Color.parseColor(str), Color.parseColor(str2)};
        }
        return null;
    }

    public int b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, i3)).intValue();
        }
        HashMap<Integer, c> hashMap = this.f297783e;
        if (hashMap == null) {
            return 0;
        }
        Iterator<Integer> it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            c cVar = this.f297783e.get(it.next());
            if (cVar.f297788a <= i3 && i3 <= cVar.f297789b) {
                return cVar.f297790c;
            }
        }
        return 0;
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.D;
    }

    public int d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this, i3)).intValue();
        }
        TreeMap<Integer, Integer> treeMap = this.f297786i;
        if (treeMap == null || treeMap.size() == 0) {
            return 0;
        }
        for (Map.Entry<Integer, Integer> entry : this.f297786i.entrySet()) {
            int intValue = entry.getKey().intValue();
            int intValue2 = entry.getValue().intValue();
            if (i3 == intValue) {
                return intValue2;
            }
        }
        return 0;
    }

    public int[] e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (int[]) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (!TextUtils.isEmpty(this.f297787m) && !TextUtils.isEmpty(this.C)) {
            return new int[]{Color.parseColor(this.f297787m), Color.parseColor(this.C)};
        }
        return null;
    }

    public JSONObject f(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (JSONObject) iPatchRedirector.redirect((short) 10, (Object) this, i3);
        }
        return this.f297785h.get(Integer.valueOf(i3));
    }

    public String g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        HashMap<Integer, c> hashMap = this.f297783e;
        if (hashMap == null) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopMemberLevelMapConfig", 2, "getRankNameByLevel levelMap is null");
            }
            return "";
        }
        Iterator<Integer> it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            c cVar = this.f297783e.get(it.next());
            if (cVar != null && cVar.f297788a <= i3 && cVar.f297789b >= i3) {
                return cVar.f297791d;
            }
        }
        return "";
    }

    public int h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, i3)).intValue();
        }
        a aVar = this.f297784f.get(Integer.valueOf(i3));
        if (aVar != null) {
            String str = aVar.f297778d;
            if (QQTheme.isNowThemeIsNight()) {
                str = aVar.f297781g;
            }
            if (!TextUtils.isEmpty(str)) {
                return Color.parseColor(str);
            }
            return -1;
        }
        return -1;
    }

    public boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return !TextUtils.isEmpty(this.D);
    }

    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.E;
    }

    public boolean k(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).booleanValue();
        }
        boolean z16 = true;
        if (!TextUtils.isEmpty(str) && this.f297782d != null) {
            String substring = str.substring(str.length() - 1);
            for (int i3 = 0; i3 < this.f297782d.size(); i3++) {
                if (String.valueOf(this.f297782d.get(i3)).equals(substring)) {
                    return true;
                }
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("grayTroopUinList is null ? ");
            if (this.f297782d != null) {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("TroopMemberLevelMapConfig", 2, sb5.toString());
        }
        return false;
    }
}
