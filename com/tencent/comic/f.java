package com.tencent.comic;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f99365a = false;

    /* renamed from: b, reason: collision with root package name */
    private static final ArrayList<String> f99366b;

    /* renamed from: c, reason: collision with root package name */
    private static final Map<String, String> f99367c;

    /* renamed from: d, reason: collision with root package name */
    private static Map<String, a> f99368d;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class a implements Comparable<a> {

        /* renamed from: d, reason: collision with root package name */
        int f99369d;

        /* renamed from: e, reason: collision with root package name */
        String f99370e;

        /* renamed from: f, reason: collision with root package name */
        String f99371f;

        /* renamed from: h, reason: collision with root package name */
        String f99372h;

        /* renamed from: i, reason: collision with root package name */
        String f99373i;

        @Override // java.lang.Comparable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            int i3 = this.f99369d;
            int i16 = aVar.f99369d;
            if (i3 < i16) {
                return -1;
            }
            if (i3 > i16) {
                return 1;
            }
            int indexOf = f.f99366b.indexOf(this.f99370e);
            int indexOf2 = f.f99366b.indexOf(aVar.f99370e);
            if (indexOf < indexOf2) {
                return -1;
            }
            return indexOf > indexOf2 ? 1 : 0;
        }
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>(5);
        f99366b = arrayList;
        arrayList.add("index");
        arrayList.add(MiniProgramLpReportDC04239.MORE_BUTTON_RESERVERS_FAV);
        arrayList.add("category");
        arrayList.add("more");
        arrayList.add(VipFunCallConstants.KEY_GROUP);
        HashMap hashMap = new HashMap(5);
        f99367c = hashMap;
        hashMap.put("NavConfig", "index");
        hashMap.put("FavNavConfig", MiniProgramLpReportDC04239.MORE_BUTTON_RESERVERS_FAV);
        hashMap.put("CateNavConfig", "category");
        hashMap.put("MoreNavConfig", "more");
        hashMap.put("GroupNavConfig", VipFunCallConstants.KEY_GROUP);
        f99365a = l();
    }

    public static boolean b() {
        f99365a = c();
        return f99365a;
    }

    private static boolean c() {
        String[] list;
        Map<String, a> i3 = i();
        if (i3 == null || i3.isEmpty() || (list = g().list()) == null || list.length <= 0) {
            return false;
        }
        List asList = Arrays.asList(list);
        Iterator<a> it = i3.values().iterator();
        while (it.hasNext()) {
            if (!asList.contains(it.next().f99373i)) {
                return false;
            }
        }
        return true;
    }

    public static File d() {
        return new File(com.tencent.comic.utils.a.b().getFilesDir(), "comic_config/");
    }

    public static File e() {
        return new File(d(), VasUpdateConstants.SCID_COMIC_NAV_CONFIG);
    }

    public static JSONObject f() throws JSONException {
        String readFileContent = FileUtils.readFileContent(new File(d(), VasUpdateConstants.SCID_COMIC_NAV_CONFIG));
        if (TextUtils.isEmpty(readFileContent)) {
            return null;
        }
        return new JSONObject(readFileContent);
    }

    public static File g() {
        return new File(d(), "tab_icons/");
    }

    public static String h(String str) {
        if (f99365a) {
            return new File(g(), str).getAbsolutePath();
        }
        return null;
    }

    public static Map<String, a> i() {
        if (f99368d == null) {
            m();
        }
        return f99368d;
    }

    public static List<a> j() {
        Map<String, a> i3 = i();
        if (i3 == null || i3.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (a aVar : i3.values()) {
            if (aVar.f99369d >= 0) {
                arrayList.add(aVar);
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static void k(AppRuntime appRuntime) {
        if (VasNormalToggle.VAS_DELIST_COMIC.isEnable(false)) {
            return;
        }
        if (l()) {
            m();
        } else {
            ((IVasQuickUpdateService) appRuntime.getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(100L, VasUpdateConstants.SCID_COMIC_NAV_CONFIG, "helper");
        }
        if (b()) {
            return;
        }
        ((IVasQuickUpdateService) appRuntime.getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(100L, VasUpdateConstants.SCID_COMIC_NAV_ICON, "helper");
    }

    public static boolean l() {
        return e().exists();
    }

    public static void m() {
        try {
            JSONObject f16 = f();
            if (f16 != null) {
                Map<String, a> map = f99368d;
                if (map != null) {
                    map.clear();
                }
                f99368d = new HashMap();
                Iterator keys = f16.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    JSONArray optJSONArray = f16.optJSONArray(str);
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        int length = optJSONArray.length() - 1;
                        while (true) {
                            if (length < 0) {
                                break;
                            }
                            JSONObject optJSONObject = optJSONArray.optJSONObject(length);
                            if (optJSONObject == null || !com.tencent.mobileqq.webview.swift.utils.i.b(optJSONObject, str)) {
                                length--;
                            } else {
                                a aVar = new a();
                                String optString = optJSONObject.optString("tabKey");
                                aVar.f99370e = optString;
                                if (TextUtils.isEmpty(optString)) {
                                    Map<String, String> map2 = f99367c;
                                    if (map2.containsKey(str)) {
                                        aVar.f99370e = map2.get(str);
                                    }
                                }
                                aVar.f99369d = optJSONObject.optInt("sequence");
                                aVar.f99371f = optJSONObject.optString("tabName");
                                aVar.f99372h = optJSONObject.optString("tabUrl");
                                aVar.f99373i = optJSONObject.optString("tabIcon");
                                f99368d.put(str, aVar);
                            }
                        }
                    }
                }
            }
        } catch (JSONException e16) {
            QLog.e("VipComicNavConfigHelper", 1, e16, new Object[0]);
        }
    }
}
