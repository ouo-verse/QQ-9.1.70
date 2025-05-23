package com.tencent.mobileqq.miniapp;

import android.os.Bundle;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f246792a;

    /* renamed from: b, reason: collision with root package name */
    public int f246793b;

    /* renamed from: c, reason: collision with root package name */
    public int f246794c;

    /* renamed from: d, reason: collision with root package name */
    public String f246795d;

    /* renamed from: e, reason: collision with root package name */
    public String f246796e;

    /* renamed from: f, reason: collision with root package name */
    public String f246797f;

    /* renamed from: g, reason: collision with root package name */
    public String f246798g;

    /* renamed from: h, reason: collision with root package name */
    public int f246799h;

    /* renamed from: i, reason: collision with root package name */
    public int f246800i;

    /* renamed from: j, reason: collision with root package name */
    public String f246801j;

    /* renamed from: k, reason: collision with root package name */
    public String f246802k;

    /* renamed from: l, reason: collision with root package name */
    public long f246803l;

    /* renamed from: m, reason: collision with root package name */
    public long f246804m;

    /* renamed from: n, reason: collision with root package name */
    public long f246805n;

    /* renamed from: o, reason: collision with root package name */
    public Set<String> f246806o;

    /* renamed from: p, reason: collision with root package name */
    public String f246807p;

    /* renamed from: q, reason: collision with root package name */
    public Bundle f246808q;

    /* renamed from: r, reason: collision with root package name */
    public String f246809r;

    /* renamed from: s, reason: collision with root package name */
    public String f246810s;

    /* renamed from: t, reason: collision with root package name */
    public String f246811t;

    public d(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            return;
        }
        this.f246801j = "";
        this.f246806o = new HashSet();
        this.f246792a = str;
        this.f246793b = i3;
        this.f246807p = b(str, i3);
        this.f246808q = new Bundle();
    }

    public static String b(String str, int i3) {
        return i3 + "_" + str;
    }

    public static String[] d(String str) {
        return str.split("_");
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.f246803l > NetConnInfoCenter.getServerTimeMillis()) {
            return true;
        }
        return false;
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.f246805n > NetConnInfoCenter.getServerTimeMillis()) {
            return true;
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "MiniAppInfo{appId='" + this.f246792a + "', appType=" + this.f246793b + ", platform=" + this.f246794c + ", appName='" + this.f246795d + "', iconUrl='" + this.f246796e + "', iconUrl64='" + this.f246797f + "', iconUrl32='" + this.f246798g + "', appState=" + this.f246799h + ", appVersion=" + this.f246800i + ", appPkgUrl='" + this.f246801j + "', wording='" + this.f246802k + "', infoNextReqMillis=" + this.f246803l + ", infoNextReqMillis2=" + this.f246804m + ", expirationTime=" + this.f246805n + ", permissionListSet=" + this.f246806o + ", cacheKey='" + this.f246807p + "', extras=" + this.f246808q + ", pkgName='" + this.f246809r + "', sdkVersion='" + this.f246811t + "'}";
    }
}
