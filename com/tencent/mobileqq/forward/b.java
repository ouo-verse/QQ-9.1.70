package com.tencent.mobileqq.forward;

import android.text.TextUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qwallet.preload.IPreloadResource;
import com.tencent.protofile.getappinfo.GetAppInfoProto$Ads;
import com.tencent.protofile.getappinfo.GetAppInfoProto$AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto$GetAppinfoResponse;
import java.util.List;
import tencent.im.oidb.oidb_0xd55$RspBody;
import tencent.im.oidb.qqconnect$AndroidAppInfo;
import tencent.im.oidb.qqconnect$Appinfo;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f210984a;

    /* renamed from: b, reason: collision with root package name */
    private String f210985b;

    /* renamed from: c, reason: collision with root package name */
    private String f210986c;

    /* renamed from: d, reason: collision with root package name */
    private String f210987d;

    /* renamed from: e, reason: collision with root package name */
    private String f210988e;

    /* renamed from: f, reason: collision with root package name */
    private String f210989f;

    /* renamed from: g, reason: collision with root package name */
    private int f210990g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f210991h;

    /* renamed from: i, reason: collision with root package name */
    private String f210992i;

    /* renamed from: j, reason: collision with root package name */
    public GetAppInfoProto$Ads f210993j;

    /* renamed from: k, reason: collision with root package name */
    public List<Share.d> f210994k;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static b a(GetAppInfoProto$GetAppinfoResponse getAppInfoProto$GetAppinfoResponse) {
        String str;
        String str2;
        b bVar = new b();
        bVar.f210993j = getAppInfoProto$GetAppinfoResponse.ads;
        List<Share.d> h16 = Share.h(getAppInfoProto$GetAppinfoResponse.iconsURL);
        bVar.f210994k = h16;
        if (!h16.isEmpty()) {
            bVar.f210984a = Share.l(bVar.f210994k, 16);
            bVar.f210985b = Share.l(bVar.f210994k, 100);
            bVar.f210990g = d(bVar.f210994k);
        }
        GetAppInfoProto$AndroidInfo getAppInfoProto$AndroidInfo = getAppInfoProto$GetAppinfoResponse.androidInfo;
        if (getAppInfoProto$AndroidInfo != null) {
            bVar.f210991h = true;
            String str3 = "";
            if (!getAppInfoProto$AndroidInfo.sourceUrl.has()) {
                str = "";
            } else {
                str = getAppInfoProto$AndroidInfo.sourceUrl.get();
            }
            bVar.f210986c = str;
            if (!getAppInfoProto$AndroidInfo.messagetail.has()) {
                str2 = "";
            } else {
                str2 = getAppInfoProto$AndroidInfo.messagetail.get();
            }
            bVar.f210987d = str2;
            if (getAppInfoProto$AndroidInfo.packName.has()) {
                str3 = getAppInfoProto$AndroidInfo.packName.get();
            }
            bVar.f210988e = str3;
        }
        com.tencent.open.agent.util.t.b("AppInfo", "convertToAppInfo AppInfo : ", bVar.toString());
        return bVar;
    }

    public static void b(oidb_0xd55$RspBody oidb_0xd55_rspbody, String str, b bVar) {
        String str2;
        bVar.f210991h = true;
        qqconnect$Appinfo qqconnect_appinfo = oidb_0xd55_rspbody.appinfo;
        bVar.f210984a = qqconnect_appinfo.icon_mini_url.get();
        bVar.f210985b = qqconnect_appinfo.icon_url.get();
        bVar.f210990g = e(qqconnect_appinfo);
        bVar.f210986c = qqconnect_appinfo.source_url.get();
        bVar.f210987d = qqconnect_appinfo.app_name.get();
        String k3 = k(qqconnect_appinfo, str);
        bVar.f210988e = k3;
        bVar.f210989f = m(qqconnect_appinfo, k3);
        if (oidb_0xd55_rspbody.wording.has()) {
            str2 = oidb_0xd55_rspbody.wording.get();
        } else {
            str2 = "";
        }
        bVar.f210992i = str2;
        com.tencent.open.agent.util.t.b("AppInfo", "fillAppInfo AppInfo : ", bVar.toString());
    }

    static int d(List<Share.d> list) {
        int i3 = 0;
        for (Share.d dVar : list) {
            if ("16".equals(dVar.f97507b.get())) {
                i3 |= 1;
            } else if (IPreloadResource.ABI_64.equals(dVar.f97507b.get())) {
                i3 |= 2;
            } else if ("100".equals(dVar.f97507b.get())) {
                i3 |= 4;
            }
        }
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0014, code lost:
    
        if (r2.icon_small_url.has() != false) goto L6;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int e(qqconnect$Appinfo qqconnect_appinfo) {
        ?? r06;
        boolean has = qqconnect_appinfo.icon_mini_url.has();
        if (!qqconnect_appinfo.icon_middle_url.has()) {
            r06 = has;
        }
        r06 = (has ? 1 : 0) | 2;
        if (qqconnect_appinfo.icon_url.has()) {
            return r06 | 4;
        }
        return r06;
    }

    static String k(qqconnect$Appinfo qqconnect_appinfo, String str) {
        String str2 = null;
        if (qqconnect_appinfo.mobile_app_info.has() && qqconnect_appinfo.mobile_app_info.android_app_info.has()) {
            for (qqconnect$AndroidAppInfo qqconnect_androidappinfo : qqconnect_appinfo.mobile_app_info.android_app_info.get()) {
                if (qqconnect_androidappinfo.pack_name.has()) {
                    str2 = qqconnect_androidappinfo.pack_name.get();
                    if (str2.equals(str)) {
                        return str;
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        return str;
    }

    static String m(qqconnect$Appinfo qqconnect_appinfo, String str) {
        if (qqconnect_appinfo.mobile_app_info.has() && qqconnect_appinfo.mobile_app_info.android_app_info.has()) {
            for (qqconnect$AndroidAppInfo qqconnect_androidappinfo : qqconnect_appinfo.mobile_app_info.android_app_info.get()) {
                if (qqconnect_androidappinfo.pack_name.has() && str.equals(qqconnect_androidappinfo.pack_name.get()) && qqconnect_androidappinfo.url_scheme.has()) {
                    return qqconnect_androidappinfo.url_scheme.get();
                }
            }
            return null;
        }
        return null;
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.f210990g;
    }

    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f210987d;
    }

    public String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f210992i;
    }

    public String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f210985b;
    }

    public String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f210984a;
    }

    public String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f210988e;
    }

    public String l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f210989f;
    }

    public String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f210986c;
    }

    public boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.f210991h;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "iconUrlMini=" + this.f210984a + ", iconUrlBig=" + this.f210985b + ", appLackOfIcons=" + this.f210990g + ", isAndroidInfoExist=" + this.f210991h + ", sourceUrl=" + this.f210986c + ", appName=" + this.f210987d + ", pkgName=" + this.f210988e + ", mErrorWording=" + this.f210992i + ",scheme:" + this.f210989f;
    }
}
