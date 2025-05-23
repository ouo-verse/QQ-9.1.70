package com.qq.e.comm.plugin.e;

import android.text.TextUtils;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import com.qq.e.comm.util.SharedPreferencedUtil;
import com.qq.e.comm.util.StringUtil;
import com.tencent.gathererga.core.internal.util.l;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f39350a = Md5Util.encode("tangram");

    public static String a() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(101);
        linkedList.add(102);
        linkedList.add(103);
        linkedList.add(110);
        linkedList.add(111);
        linkedList.add(112);
        linkedList.add(104);
        linkedList.add(115);
        linkedList.add(307);
        linkedList.add(309);
        linkedList.add(310);
        return linkedList.toString();
    }

    public static boolean b() {
        return com.qq.e.comm.plugin.j.c.a("deviceAllAllowFileCache", 0, 1);
    }

    public static boolean c() {
        return com.qq.e.comm.plugin.j.c.a("deviceDeleteFileCache", 0, 1);
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return l.c(f39350a, str);
        } catch (Throwable th5) {
            GDTLogger.e(th5.getMessage());
            return null;
        }
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return l.a(f39350a, str);
        } catch (Throwable th5) {
            GDTLogger.e(th5.getMessage());
            return null;
        }
    }

    public static boolean b(int i3) {
        return com.qq.e.comm.plugin.j.c.a("deviceFileCacheDelete_" + i3, 0, 1);
    }

    public static String c(String str) {
        if (!TextUtils.isEmpty(str)) {
            String replaceAll = str.replaceAll(":", "");
            if (!TextUtils.isEmpty(replaceAll)) {
                String upperCase = replaceAll.toUpperCase();
                if (!TextUtils.isEmpty(upperCase)) {
                    String encode = Md5Util.encode(upperCase);
                    if (!TextUtils.isEmpty(encode)) {
                        String lowerCase = encode.toLowerCase();
                        if (!TextUtils.isEmpty(lowerCase)) {
                            return lowerCase;
                        }
                    }
                }
            }
        }
        return null;
    }

    public static String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            String encode = Md5Util.encode(str);
            if (!TextUtils.isEmpty(encode)) {
                String lowerCase = encode.toLowerCase();
                if (!TextUtils.isEmpty(lowerCase)) {
                    return lowerCase;
                }
            }
        }
        return null;
    }

    public static boolean a(int i3, boolean z16) {
        return com.qq.e.comm.plugin.e.a.d.a().a(i3, z16);
    }

    public static boolean a(int i3) {
        return com.qq.e.comm.plugin.j.c.a("deviceFileCache_" + i3, 0, 1);
    }

    public static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            if (!TextUtils.isEmpty(lowerCase)) {
                String encode = Md5Util.encode(lowerCase);
                if (!TextUtils.isEmpty(encode)) {
                    String lowerCase2 = encode.toLowerCase();
                    if (!TextUtils.isEmpty(lowerCase2)) {
                        return lowerCase2;
                    }
                }
            }
        }
        return null;
    }

    public static void a(JSONObject jSONObject) {
        if (!y.a(jSONObject) || SDKStatus.getSDKVersionCode() < 290) {
            return;
        }
        try {
            int i3 = SharedPreferencedUtil.getInt(SharedPreferencedUtil.KEY_USER_NOLOGIN_AD_RECOMMEND_STATUS, -1);
            if (i3 != -1) {
                jSONObject.putOpt("nologin_skip_privacy_types", Boolean.valueOf(i3 != 1));
            }
            int i16 = SharedPreferencedUtil.getInt(SharedPreferencedUtil.KEY_USER_AD_RECOMMEND_STATUS, -1);
            if (i16 != -1) {
                jSONObject.putOpt("no_rd", Boolean.valueOf(i16 != 1));
            }
            if (SDKStatus.getSDKVersionCode() < 350 || !com.qq.e.comm.plugin.j.c.a("reportAdInterestLabel", 1, 1)) {
                return;
            }
            if (i3 == 1 || i16 == 1) {
                String string = SharedPreferencedUtil.getString(SharedPreferencedUtil.KEY_USER_AD_INTEREST_LABEL, null);
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                jSONObject.putOpt("rd_tag", string);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public static JSONArray a(Map<Integer, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            try {
                Integer key = entry.getKey();
                if (key != null && key.intValue() != 0) {
                    String value = entry.getValue();
                    if (!StringUtil.isEmpty(value)) {
                        JSONObject jSONObject = (JSONObject) hashMap.get(value);
                        if (jSONObject == null) {
                            jSONObject = new JSONObject();
                            jSONObject.putOpt("id_h", value);
                            jSONObject.putOpt(MimeHelper.IMAGE_SUBTYPE_BITMAP, key);
                        } else {
                            jSONObject.putOpt(MimeHelper.IMAGE_SUBTYPE_BITMAP, Integer.valueOf(jSONObject.optInt(MimeHelper.IMAGE_SUBTYPE_BITMAP) | key.intValue()));
                        }
                        hashMap.put(value, jSONObject);
                    }
                }
            } catch (Throwable th5) {
                GDTLogger.e("DeviceInfoUtil mapIdInfo json exception.", th5);
            }
        }
        JSONArray jSONArray = new JSONArray();
        Iterator it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            try {
                JSONObject jSONObject2 = (JSONObject) ((Map.Entry) it.next()).getValue();
                if (y.a(jSONObject2) && !StringUtil.isEmpty(jSONObject2.optString("id_h")) && jSONObject2.optInt(MimeHelper.IMAGE_SUBTYPE_BITMAP) != 0) {
                    jSONArray.mo162put(jSONObject2);
                }
            } catch (Throwable th6) {
                GDTLogger.e("DeviceInfoUtil idInfoList json exception.", th6);
            }
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        return jSONArray;
    }
}
