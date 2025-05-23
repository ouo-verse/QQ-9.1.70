package com.tencent.treasurecard.bean;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f381152a;

    /* renamed from: b, reason: collision with root package name */
    public String f381153b;

    /* renamed from: c, reason: collision with root package name */
    public String f381154c;

    /* renamed from: d, reason: collision with root package name */
    public String f381155d;

    /* renamed from: e, reason: collision with root package name */
    public String f381156e;

    /* renamed from: f, reason: collision with root package name */
    public String f381157f;

    /* renamed from: g, reason: collision with root package name */
    public String f381158g;

    public b(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
            return;
        }
        this.f381154c = "";
        this.f381156e = "";
        this.f381157f = "";
        this.f381158g = "";
        this.f381152a = str;
        this.f381155d = str2;
        this.f381153b = UUID.randomUUID().toString();
    }

    private void b() {
        if (!TextUtils.isEmpty(this.f381156e)) {
            this.f381156e = com.tencent.treasurecard.util.b.a(this.f381156e);
        }
        if (!TextUtils.isEmpty(this.f381158g)) {
            this.f381158g = com.tencent.treasurecard.util.b.a(this.f381158g);
        }
        if (!TextUtils.isEmpty(this.f381157f)) {
            this.f381157f = com.tencent.treasurecard.util.b.a(this.f381157f);
        }
    }

    private Map<String, String> c() {
        TreeMap treeMap = new TreeMap();
        treeMap.put("channelId", this.f381152a);
        treeMap.put("msgId", this.f381153b);
        treeMap.put("userId", this.f381154c);
        treeMap.put("openType", this.f381155d);
        treeMap.put("message", this.f381156e);
        treeMap.put("expandParams", this.f381157f);
        return treeMap;
    }

    private String e(String str, Map<String, String> map) {
        if (map != null) {
            return f(str + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, map);
        }
        return str;
    }

    private String f(String str, Map<String, String> map) {
        for (String str2 : map.keySet()) {
            str = str + str2 + ContainerUtils.KEY_VALUE_DELIMITER + map.get(str2) + ContainerUtils.FIELD_DELIMITER;
        }
        int length = str.length();
        if (length < 1) {
            return "";
        }
        return str.substring(0, length - 1);
    }

    public b a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (b) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f381158g = str;
        }
        return this;
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return f("", c());
    }

    public String g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        b();
        Map<String, String> c16 = c();
        c16.put("sign", this.f381158g);
        return e(str, c16);
    }
}
