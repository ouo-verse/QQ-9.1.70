package com.tencent.mobileqq.ark.module;

import android.text.TextUtils;
import com.tencent.ark.open.ArkUtil;
import com.tencent.mobileqq.ark.api.scheme.QQSchemeHandler;
import com.tencent.mobileqq.ark.api.scheme.TelSchemeHandler;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    @ConfigInject(configPath = "Business/qqark-impl/src/main/resources/Inject_ArkAppSchemeCenter.yml", version = 1)
    protected static final HashMap<String, Class<? extends h>> f199576a;

    /* renamed from: b, reason: collision with root package name */
    @ConfigInject(configPath = "Business/qqark-impl/src/main/resources/Inject_ArkAppSchemeCenter.yml", version = 1)
    protected static final ArrayList<Class<? extends i>> f199577b;

    static {
        HashMap<String, Class<? extends h>> hashMap = new HashMap<>();
        f199576a = hashMap;
        hashMap.put("miniapp", com.tencent.mobileqq.ark.api.scheme.b.class);
        hashMap.put("mqzone", com.tencent.mobileqq.ark.api.scheme.d.class);
        hashMap.put("app", com.tencent.mobileqq.ark.api.scheme.a.class);
        hashMap.put("tel", TelSchemeHandler.class);
        hashMap.put("qq", QQSchemeHandler.class);
        ArrayList<Class<? extends i>> arrayList = new ArrayList<>();
        f199577b = arrayList;
        arrayList.add(com.tencent.mobileqq.ark.api.scheme.c.class);
    }

    public static boolean a(String str, String str2, JSONObject jSONObject, long j3, String str3, String str4) {
        String str5;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            str5 = "";
        } else {
            str5 = str2;
        }
        QLog.i("ArkApp.SchemeCenter", 1, "navigate url: " + ArkUtil.filterKeyForLog(str, new String[0]));
        String[] split = str.split(":");
        if (split.length <= 1) {
            return false;
        }
        Iterator<Class<? extends i>> it = f199577b.iterator();
        while (it.hasNext()) {
            try {
            } catch (Exception e16) {
                e = e16;
            }
            try {
            } catch (Exception e17) {
                e = e17;
                QLog.i("ArkApp.SchemeCenter", 1, "interceptor exception, " + e.toString());
            }
            if (it.next().newInstance().a(str, str5, jSONObject)) {
                return true;
            }
        }
        String str6 = split[0];
        Class<? extends h> cls = f199576a.get(str6);
        if (cls == null) {
            QLog.i("ArkApp.SchemeCenter", 1, "scheme handler not found for " + str6);
            return false;
        }
        try {
            h newInstance = cls.newInstance();
            String substring = str.substring(str6.length() + 1);
            if (substring.startsWith("//")) {
                substring = substring.substring(2);
            }
            newInstance.a(substring, str5, jSONObject, j3, str3, str4);
            return true;
        } catch (Exception unused) {
            QLog.i("ArkApp.SchemeCenter", 1, "create scheme handler fail + " + cls.toString());
            return false;
        }
    }
}
