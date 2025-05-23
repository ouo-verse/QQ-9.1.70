package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.freesia.IConfigData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.DiyStatusEmoInfo;
import com.tencent.mobileqq.config.avatar.AvatarViewConfigLoader;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.onlinestatus.utils.NewStatusCache;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ai implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    private HashMap<String, com.tencent.mobileqq.onlinestatus.au> f202500d = new HashMap<>(20);

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<com.tencent.mobileqq.onlinestatus.au> f202501e = new ArrayList<>(20);

    /* renamed from: f, reason: collision with root package name */
    private HashSet<com.tencent.mobileqq.onlinestatus.au> f202502f = new HashSet<>(9);

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<DiyStatusEmoInfo> f202503h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    private Map<Integer, ArrayList<com.tencent.mobileqq.onlinestatus.au>> f202504i = new HashMap();

    /* renamed from: m, reason: collision with root package name */
    private final Set<com.tencent.mobileqq.onlinestatus.au> f202505m = new HashSet();
    private boolean C = false;
    public com.tencent.mobileqq.onlinestatus.guide.b D = new com.tencent.mobileqq.onlinestatus.guide.b();

    public ai() {
        int i3 = 0;
        while (true) {
            AppRuntime.Status[] statusArr = com.tencent.mobileqq.onlinestatus.ar.f255483a;
            if (i3 < statusArr.length) {
                AppRuntime.Status status = statusArr[i3];
                com.tencent.mobileqq.onlinestatus.au auVar = new com.tencent.mobileqq.onlinestatus.au(status);
                this.f202501e.add(auVar);
                this.f202500d.put(com.tencent.mobileqq.onlinestatus.au.a(status, auVar.f255489b), auVar);
                i3++;
            } else {
                return;
            }
        }
    }

    @Nullable
    private static com.tencent.mobileqq.onlinestatus.au d(long j3, @NonNull ai aiVar) {
        if (j3 > AppRuntime.Status.dnd.getValue()) {
            return null;
        }
        return aiVar.i(com.tencent.mobileqq.onlinestatus.utils.ae.b((int) j3), 0L);
    }

    public static ArrayList<com.tencent.mobileqq.onlinestatus.au> f(List<? extends com.tencent.mobileqq.onlinestatus.au> list) {
        if (list == null) {
            return null;
        }
        ArrayList<com.tencent.mobileqq.onlinestatus.au> arrayList = new ArrayList<>();
        boolean studyModeSwitch = ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
        for (com.tencent.mobileqq.onlinestatus.au auVar : list) {
            if (!studyModeSwitch || auVar.f255497j) {
                arrayList.add(auVar);
            }
        }
        return arrayList;
    }

    public static boolean l() {
        if (com.tencent.mobileqq.onlinestatus.af.D() <= 0) {
            return true;
        }
        return false;
    }

    private static boolean o(long j3, String str, String str2) {
        if (j3 == 0) {
            return false;
        }
        if (j3 <= AppRuntime.Status.dnd.getValue() && OnlineStatusToggleUtils.d()) {
            return true;
        }
        if (!OnlineStatusToggleUtils.A() && j3 == 2017) {
            return true;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return true;
    }

    public static ai p(String str) {
        ai aiVar = new ai();
        try {
            JSONObject jSONObject = new JSONObject(str);
            q(jSONObject, "online_status", aiVar.f202500d, aiVar.f202501e, aiVar.f202502f, aiVar.f202505m, aiVar);
            t(jSONObject, "diy_emo", aiVar.f202503h);
            aiVar.D = com.tencent.mobileqq.onlinestatus.guide.b.a(jSONObject);
            AvatarViewConfigLoader.INSTANCE.a().l(jSONObject);
            QLog.d("OnlineStatusConfProcessor", 1, "confBean = " + com.tencent.util.k.f(aiVar.u(), Arrays.asList("title")));
            NewStatusCache.f256304a.j(aiVar.f202505m);
            return aiVar;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("OnlineStatusConfProcessor", 1, "parse e:", e16.toString());
            }
            return aiVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x012a A[Catch: Exception -> 0x0187, TryCatch #0 {Exception -> 0x0187, blocks: (B:3:0x000c, B:6:0x0017, B:8:0x001d, B:13:0x002d, B:15:0x004f, B:18:0x0083, B:20:0x0089, B:21:0x0090, B:23:0x00a2, B:25:0x00af, B:28:0x0111, B:30:0x012a, B:31:0x012d, B:33:0x0133, B:35:0x013e, B:36:0x015b, B:38:0x0163, B:40:0x016b, B:41:0x0173, B:43:0x0179, B:48:0x014d, B:50:0x00c0), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0179 A[Catch: Exception -> 0x0187, TRY_LEAVE, TryCatch #0 {Exception -> 0x0187, blocks: (B:3:0x000c, B:6:0x0017, B:8:0x001d, B:13:0x002d, B:15:0x004f, B:18:0x0083, B:20:0x0089, B:21:0x0090, B:23:0x00a2, B:25:0x00af, B:28:0x0111, B:30:0x012a, B:31:0x012d, B:33:0x0133, B:35:0x013e, B:36:0x015b, B:38:0x0163, B:40:0x016b, B:41:0x0173, B:43:0x0179, B:48:0x014d, B:50:0x00c0), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x017f  */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void q(JSONObject jSONObject, String str, HashMap<String, com.tencent.mobileqq.onlinestatus.au> hashMap, ArrayList<com.tencent.mobileqq.onlinestatus.au> arrayList, HashSet<com.tencent.mobileqq.onlinestatus.au> hashSet, Set<com.tencent.mobileqq.onlinestatus.au> set, ai aiVar) {
        long j3;
        char c16 = 0;
        ?? r65 = 1;
        try {
            long serverTime = NetConnInfoCenter.getServerTime();
            JSONArray optJSONArray = jSONObject.optJSONArray(str);
            if (optJSONArray != null) {
                int i3 = 0;
                while (i3 < optJSONArray.length()) {
                    JSONObject jSONObject2 = (JSONObject) optJSONArray.get(i3);
                    if (jSONObject2 != 0) {
                        long optLong = jSONObject2.optLong("id");
                        String optString = jSONObject2.optString("title");
                        String optString2 = jSONObject2.optString("icon");
                        String optString3 = jSONObject2.optString("big_icon");
                        if (!o(optLong, optString, optString2)) {
                            Object[] objArr = new Object[8];
                            objArr[c16] = "error pamas:id=";
                            objArr[r65] = Long.valueOf(optLong);
                            objArr[2] = " title=";
                            objArr[3] = optString;
                            objArr[4] = " icon=";
                            objArr[5] = optString2;
                            objArr[6] = " bigIcon=";
                            objArr[7] = optString3;
                            QLog.d("OnlineStatusConfProcessor", (int) r65, objArr);
                        } else if (optLong == 1000 && l()) {
                            QLog.d("OnlineStatusConfProcessor", (int) r65, "incompatible for battery status");
                        } else {
                            com.tencent.mobileqq.onlinestatus.au auVar = new com.tencent.mobileqq.onlinestatus.au(optLong, optString, optString2, optString3);
                            if (OnlineStatusToggleUtils.d()) {
                                j3 = optLong;
                                if (j3 <= AppRuntime.Status.dnd.getValue()) {
                                    com.tencent.mobileqq.onlinestatus.au d16 = d(j3, aiVar);
                                    if (d16 != null) {
                                        auVar = d16;
                                    }
                                    auVar.f255513z = jSONObject2.optLong("new_expired_time", -1L);
                                    r(jSONObject2, auVar, j3);
                                    if ("online_status".equals(str)) {
                                        com.tencent.mobileqq.onlinestatus.model.c.a(jSONObject2, auVar);
                                    }
                                    if (!OnlineStatusToggleUtils.d() && j3 <= AppRuntime.Status.dnd.getValue()) {
                                        hashMap.put(com.tencent.mobileqq.onlinestatus.au.a(auVar.f255494g, 0L), auVar);
                                        s(arrayList, auVar);
                                    } else {
                                        hashMap.put(com.tencent.mobileqq.onlinestatus.au.a(AppRuntime.Status.online, auVar.f255489b), auVar);
                                        arrayList.add(auVar);
                                    }
                                    if (TextUtils.isEmpty(auVar.f255498k) && !TextUtils.isEmpty(auVar.f255499l)) {
                                        hashSet.add(auVar);
                                    }
                                    if (auVar.f255513z <= serverTime) {
                                        set.add(auVar);
                                    }
                                    i3++;
                                    c16 = 0;
                                    r65 = 1;
                                }
                            } else {
                                j3 = optLong;
                            }
                            auVar.f255498k = jSONObject2.optString(WadlProxyConsts.RES_URL);
                            auVar.f255499l = jSONObject2.optString("md5");
                            auVar.f255497j = jSONObject2.optBoolean("showInStudyMode", r65);
                            auVar.f255500m = jSONObject2.optString("animate_icon");
                            auVar.f255501n = jSONObject2.optString("jump_url");
                            auVar.f255502o = jSONObject2.optString("bubble_str", "");
                            auVar.f255503p = jSONObject2.optString("bg_url", "");
                            auVar.f255504q = jSONObject2.optString(LayoutAttrDefine.BG_Color, "");
                            auVar.f255511x = jSONObject2.optString("jump_entrance_text", "");
                            auVar.f255513z = jSONObject2.optLong("new_expired_time", -1L);
                            r(jSONObject2, auVar, j3);
                            if ("online_status".equals(str)) {
                            }
                            if (!OnlineStatusToggleUtils.d()) {
                            }
                            hashMap.put(com.tencent.mobileqq.onlinestatus.au.a(AppRuntime.Status.online, auVar.f255489b), auVar);
                            arrayList.add(auVar);
                            if (TextUtils.isEmpty(auVar.f255498k)) {
                            }
                            if (auVar.f255513z <= serverTime) {
                            }
                            i3++;
                            c16 = 0;
                            r65 = 1;
                        }
                    }
                    i3++;
                    c16 = 0;
                    r65 = 1;
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("OnlineStatusConfProcessor", 1, "parse array:", e16.toString());
            }
        }
    }

    private static void r(JSONObject jSONObject, com.tencent.mobileqq.onlinestatus.au auVar, long j3) {
        if (!OnlineStatusToggleUtils.d()) {
            return;
        }
        auVar.f255505r = jSONObject.optString("normal_background", "");
        auVar.f255506s = jSONObject.optString("normal_bg_color", "");
        auVar.f255507t = jSONObject.optString("tofu_background", "");
        auVar.f255508u = jSONObject.optString("poster_text", "");
        auVar.f255509v = jSONObject.optString("poster_status_text_color", "");
        auVar.f255510w = jSONObject.optString("select_color", "");
        if (j3 != 1000) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("sub_action_items");
        auVar.f255512y = new ArrayList<>();
        if (optJSONObject != null) {
            int i3 = 0;
            while (i3 < optJSONObject.length()) {
                com.tencent.mobileqq.onlinestatus.au auVar2 = new com.tencent.mobileqq.onlinestatus.au(auVar.f255489b, auVar.f255490c, auVar.f255491d, auVar.f255492e);
                auVar2.f255505r = jSONObject.optString("normal_background", "");
                auVar2.f255506s = jSONObject.optString("normal_bg_color", "");
                auVar2.f255507t = jSONObject.optString("tofu_background", "");
                auVar2.f255508u = jSONObject.optString("poster_text", "");
                auVar2.f255509v = jSONObject.optString("poster_status_text_color", "");
                auVar2.f255510w = jSONObject.optString("select_color", "");
                auVar.f255512y.add(auVar2);
                i3++;
                optJSONObject = optJSONObject;
            }
        }
    }

    private static void s(ArrayList<com.tencent.mobileqq.onlinestatus.au> arrayList, com.tencent.mobileqq.onlinestatus.au auVar) {
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            com.tencent.mobileqq.onlinestatus.au auVar2 = arrayList.get(i3);
            if (auVar2.f255489b == auVar.f255489b && auVar2.f255494g == auVar.f255494g) {
                arrayList.set(i3, auVar);
                return;
            }
        }
    }

    private static void t(JSONObject jSONObject, String str, ArrayList<DiyStatusEmoInfo> arrayList) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray(str);
            if (optJSONArray != null) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject jSONObject2 = (JSONObject) optJSONArray.get(i3);
                    if (jSONObject2 != null) {
                        arrayList.add(new DiyStatusEmoInfo(jSONObject2.optInt("type"), jSONObject2.optInt("id"), jSONObject2.optString("word")));
                    }
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("OnlineStatusConfProcessor", 1, "parse array:", e16.toString());
            }
        }
    }

    public ArrayList<com.tencent.mobileqq.onlinestatus.au> a() {
        ArrayList<com.tencent.mobileqq.onlinestatus.au> g16;
        ArrayList<com.tencent.mobileqq.onlinestatus.au> arrayList = new ArrayList<>();
        ArrayList<com.tencent.mobileqq.onlinestatus.au> arrayList2 = this.f202501e;
        if (arrayList2 == null) {
            return arrayList;
        }
        boolean studyModeSwitch = ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
        for (com.tencent.mobileqq.onlinestatus.au auVar : arrayList2) {
            if (!studyModeSwitch || auVar.f255497j) {
                int i3 = auVar.B;
                if (i3 != 0 && (g16 = g(i3)) != null && !g16.isEmpty()) {
                    arrayList.addAll(g16);
                } else if (auVar.f255494g == AppRuntime.Status.qme) {
                    int size = arrayList.size();
                    int i16 = 0;
                    while (true) {
                        if (i16 >= arrayList.size()) {
                            break;
                        }
                        com.tencent.mobileqq.onlinestatus.au auVar2 = arrayList.get(i16);
                        if (auVar2.f255494g == AppRuntime.Status.online && auVar2.f255489b == 0) {
                            size = i16 + 1;
                            break;
                        }
                        i16++;
                    }
                    if (size >= arrayList.size()) {
                        arrayList.add(auVar);
                    } else {
                        arrayList.add(size, auVar);
                    }
                } else {
                    arrayList.add(auVar);
                }
            }
        }
        return arrayList;
    }

    public ArrayList<String> b() {
        ArrayList<com.tencent.mobileqq.onlinestatus.au> arrayList;
        ArrayList<String> arrayList2 = new ArrayList<>();
        for (com.tencent.mobileqq.onlinestatus.au auVar : this.f202501e) {
            arrayList2.add(auVar.f255507t);
            if (auVar.f255489b == 1000 && (arrayList = auVar.f255512y) != null && !arrayList.isEmpty() && auVar.f255512y.size() > 0) {
                Iterator<com.tencent.mobileqq.onlinestatus.au> it = auVar.f255512y.iterator();
                while (it.hasNext()) {
                    arrayList2.add(it.next().f255507t);
                }
            }
        }
        return arrayList2;
    }

    public ArrayList<DiyStatusEmoInfo> c() {
        return this.f202503h;
    }

    public ArrayList<com.tencent.mobileqq.onlinestatus.au> e(AppRuntime.Status status, long j3, boolean z16) {
        if (!z16) {
            return a();
        }
        ArrayList<com.tencent.mobileqq.onlinestatus.au> arrayList = this.f202501e;
        if (arrayList == null) {
            return new ArrayList<>();
        }
        com.tencent.mobileqq.onlinestatus.au i3 = i(status, j3);
        if (i3.B != 0) {
            int i16 = 0;
            while (true) {
                if (i16 < arrayList.size()) {
                    com.tencent.mobileqq.onlinestatus.au auVar = arrayList.get(i16);
                    if (auVar != null && auVar.B == i3.B) {
                        arrayList.set(i16, i3);
                        break;
                    }
                    i16++;
                } else {
                    break;
                }
            }
        }
        return f(arrayList);
    }

    @Nullable
    public ArrayList<com.tencent.mobileqq.onlinestatus.au> g(int i3) {
        Map<Integer, ArrayList<com.tencent.mobileqq.onlinestatus.au>> map = this.f202504i;
        if (map == null) {
            return null;
        }
        return map.get(Integer.valueOf(i3));
    }

    public ArrayList<com.tencent.mobileqq.onlinestatus.au> h() {
        return this.f202501e;
    }

    @NonNull
    public com.tencent.mobileqq.onlinestatus.au i(AppRuntime.Status status, long j3) {
        if (status == null) {
            QLog.d("OnlineStatus", 1, "getOnlineStatusItem with null, id:", Long.valueOf(j3));
            status = AppRuntime.Status.online;
        }
        com.tencent.mobileqq.onlinestatus.au auVar = this.f202500d.get(com.tencent.mobileqq.onlinestatus.au.a(status, j3));
        if (auVar == null) {
            return new com.tencent.mobileqq.onlinestatus.au(AppRuntime.Status.online);
        }
        return auVar;
    }

    public Set<com.tencent.mobileqq.onlinestatus.au> j() {
        return new HashSet(this.f202502f);
    }

    public boolean k() {
        ArrayList<com.tencent.mobileqq.onlinestatus.au> arrayList = this.f202501e;
        if (arrayList == null || arrayList.size() <= com.tencent.mobileqq.onlinestatus.ar.f255483a.length) {
            return false;
        }
        return true;
    }

    public boolean m(AppRuntime.Status status, long j3) {
        return false;
    }

    public boolean n(AppRuntime.Status status, long j3) {
        Iterator<com.tencent.mobileqq.onlinestatus.au> it = this.f202502f.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.onlinestatus.au next = it.next();
            if (j3 == next.f255489b && status == next.f255494g) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder(50);
        for (com.tencent.mobileqq.onlinestatus.au auVar : this.f202501e) {
            sb5.append("id:");
            sb5.append(auVar.f255489b);
            sb5.append(" ");
            sb5.append("title:");
            sb5.append(auVar.f255490c);
            sb5.append(" ");
            sb5.append("icon:");
            sb5.append(auVar.f255491d);
            sb5.append("\n");
            sb5.append("bubbleStr:");
            sb5.append(auVar.f255502o);
            sb5.append("\n");
        }
        return sb5.toString();
    }

    public String u() {
        ArrayList<com.tencent.mobileqq.onlinestatus.au> arrayList = this.f202501e;
        StringBuilder sb5 = new StringBuilder();
        for (com.tencent.mobileqq.onlinestatus.au auVar : arrayList) {
            sb5.append("id:");
            sb5.append(auVar.f255489b);
            sb5.append(" ");
            sb5.append("title:");
            sb5.append(auVar.f255490c);
            sb5.append(" ");
        }
        return sb5.toString();
    }

    public void v() {
        if (!this.C && k()) {
            QLog.d("OnlineStatusConfProcessor", 1, "tryToFoldBaseStatusCopyOnWrite");
            this.C = true;
            HashMap hashMap = new HashMap(this.f202504i);
            ArrayList<com.tencent.mobileqq.onlinestatus.au> arrayList = new ArrayList<>(this.f202501e);
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int i3 = 0;
            while (true) {
                AppRuntime.Status[] statusArr = com.tencent.mobileqq.onlinestatus.ar.f255483a;
                if (i3 < statusArr.length) {
                    AppRuntime.Status status = statusArr[i3];
                    if (status != AppRuntime.Status.qme) {
                        com.tencent.mobileqq.onlinestatus.au i16 = i(status, 0L);
                        i16.B = -100;
                        if (status != AppRuntime.Status.online) {
                            arrayList3.add(i16);
                        }
                        arrayList2.add(i16);
                    }
                    i3++;
                } else {
                    arrayList.removeAll(arrayList3);
                    hashMap.put(-100, arrayList2);
                    this.f202501e = arrayList;
                    this.f202504i = hashMap;
                    return;
                }
            }
        }
    }
}
