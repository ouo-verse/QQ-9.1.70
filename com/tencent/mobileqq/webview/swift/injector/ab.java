package com.tencent.mobileqq.webview.swift.injector;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.webview.injector.DownloadInjector;
import com.tencent.mobileqq.webview.injector.WebSdkInitInjector;
import com.tencent.mobileqq.webview.swift.AbsBaseWebViewActivityImpl;
import com.tencent.mobileqq.webview.swift.WebViewSurfaceInjectorImpl;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatisticInjectorImpl;
import com.tencent.smtt.sdk.QbSdk;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ab {
    static IPatchRedirector $redirector_;

    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_web_tbs.yml", version = 2)
    private static ArrayList<Class<? extends w>> A;

    /* renamed from: a, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_Config.yml", version = 1)
    private static ArrayList<Class<? extends c>> f314577a;

    /* renamed from: b, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_DeviceInfo.yml", version = 1)
    private static ArrayList<Class<? extends d>> f314578b;

    /* renamed from: c, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_Report.yml", version = 1)
    private static ArrayList<Class<? extends m>> f314579c;

    /* renamed from: d, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_Dialog.yml", version = 1)
    private static ArrayList<Class<? extends e>> f314580d;

    /* renamed from: e, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_Download.yml", version = 1)
    private static ArrayList<Class<? extends f>> f314581e;

    /* renamed from: f, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_QQActivity.yml", version = 1)
    private static ArrayList<Class<? extends j>> f314582f;

    /* renamed from: g, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_QQPerf.yml", version = 1)
    private static ArrayList<Class<? extends k>> f314583g;

    /* renamed from: h, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_QQUA.yml", version = 1)
    private static ArrayList<Class<? extends l>> f314584h;

    /* renamed from: i, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_Theme.yml", version = 1)
    private static ArrayList<Class<? extends r>> f314585i;

    /* renamed from: j, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_Util.yml", version = 1)
    private static ArrayList<Class<? extends v>> f314586j;

    /* renamed from: k, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_WebUI.yml", version = 1)
    private static ArrayList<Class<? extends x>> f314587k;

    /* renamed from: l, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_Req.yml", version = 1)
    private static ArrayList<Class<? extends n>> f314588l;

    /* renamed from: m, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_Permission.yml", version = 1)
    private static ArrayList<Class<? extends h>> f314589m;

    /* renamed from: n, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_Common.yml", version = 1)
    private static ArrayList<Class<? extends b>> f314590n;

    /* renamed from: o, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_abs_base_web_view_activity.yml", version = 2)
    private static ArrayList<Class<? extends a>> f314591o;

    /* renamed from: p, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_web_statistic.yml", version = 2)
    private static ArrayList<Class<? extends o>> f314592p;

    /* renamed from: q, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_web_tbs.yml", version = 2)
    private static ArrayList<Class<? extends p>> f314593q;

    /* renamed from: r, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_web_accelerator.yml", version = 2)
    private static ArrayList<Class<? extends q>> f314594r;

    /* renamed from: s, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_webview_surface.yml", version = 2)
    private static ArrayList<Class<? extends y>> f314595s;

    /* renamed from: t, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_web_color_note.yml", version = 2)
    private static ArrayList<Class<? extends com.tencent.mobileqq.webview.util.k>> f314596t;

    /* renamed from: u, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_web_process_receiver.yml", version = 2)
    private static ArrayList<Class<? extends com.tencent.mobileqq.webview.util.l>> f314597u;

    /* renamed from: v, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_Pskey_Fetcher.yml", version = 1)
    private static ArrayList<Class<? extends i>> f314598v;

    /* renamed from: w, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_Third_Sig_Fetcher.yml", version = 1)
    private static ArrayList<Class<? extends s>> f314599w;

    /* renamed from: x, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_plugin_engine.yml", version = 1)
    private static ArrayList<Class<? extends com.tencent.mobileqq.webview.nativeapi.b>> f314600x;

    /* renamed from: y, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_AppSetting.yml", version = 1)
    private static ArrayList<Class<? extends com.tencent.mobileqq.inject.b>> f314601y;

    /* renamed from: z, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_web_tbs.yml", version = 2)
    private static ArrayList<Class<? extends QbSdk.TbsInstallerCallBack>> f314602z;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49384);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList<Class<? extends c>> arrayList = new ArrayList<>();
        f314577a = arrayList;
        arrayList.add(com.tencent.mobileqq.webview.injector.b.class);
        ArrayList<Class<? extends d>> arrayList2 = new ArrayList<>();
        f314578b = arrayList2;
        arrayList2.add(com.tencent.mobileqq.webview.injector.c.class);
        ArrayList<Class<? extends m>> arrayList3 = new ArrayList<>();
        f314579c = arrayList3;
        arrayList3.add(com.tencent.mobileqq.webview.injector.j.class);
        ArrayList<Class<? extends e>> arrayList4 = new ArrayList<>();
        f314580d = arrayList4;
        arrayList4.add(com.tencent.mobileqq.webview.injector.d.class);
        ArrayList<Class<? extends f>> arrayList5 = new ArrayList<>();
        f314581e = arrayList5;
        arrayList5.add(DownloadInjector.class);
        ArrayList<Class<? extends j>> arrayList6 = new ArrayList<>();
        f314582f = arrayList6;
        arrayList6.add(com.tencent.mobileqq.webview.injector.g.class);
        ArrayList<Class<? extends k>> arrayList7 = new ArrayList<>();
        f314583g = arrayList7;
        arrayList7.add(com.tencent.mobileqq.webview.injector.h.class);
        ArrayList<Class<? extends l>> arrayList8 = new ArrayList<>();
        f314584h = arrayList8;
        arrayList8.add(com.tencent.mobileqq.webview.injector.i.class);
        ArrayList<Class<? extends r>> arrayList9 = new ArrayList<>();
        f314585i = arrayList9;
        arrayList9.add(com.tencent.mobileqq.webview.injector.m.class);
        ArrayList<Class<? extends v>> arrayList10 = new ArrayList<>();
        f314586j = arrayList10;
        arrayList10.add(com.tencent.mobileqq.webview.injector.p.class);
        ArrayList<Class<? extends x>> arrayList11 = new ArrayList<>();
        f314587k = arrayList11;
        arrayList11.add(com.tencent.mobileqq.webview.injector.s.class);
        ArrayList<Class<? extends n>> arrayList12 = new ArrayList<>();
        f314588l = arrayList12;
        arrayList12.add(com.tencent.mobileqq.webview.injector.k.class);
        ArrayList<Class<? extends h>> arrayList13 = new ArrayList<>();
        f314589m = arrayList13;
        arrayList13.add(com.tencent.mobileqq.webview.injector.e.class);
        ArrayList<Class<? extends b>> arrayList14 = new ArrayList<>();
        f314590n = arrayList14;
        arrayList14.add(com.tencent.mobileqq.webview.injector.a.class);
        ArrayList<Class<? extends a>> arrayList15 = new ArrayList<>();
        f314591o = arrayList15;
        arrayList15.add(AbsBaseWebViewActivityImpl.class);
        ArrayList<Class<? extends o>> arrayList16 = new ArrayList<>();
        f314592p = arrayList16;
        arrayList16.add(SwiftBrowserStatisticInjectorImpl.class);
        ArrayList<Class<? extends p>> arrayList17 = new ArrayList<>();
        f314593q = arrayList17;
        arrayList17.add(com.tencent.mobileqq.webview.swift.component.u.class);
        ArrayList<Class<? extends q>> arrayList18 = new ArrayList<>();
        f314594r = arrayList18;
        arrayList18.add(com.tencent.mobileqq.webview.swift.utils.h.class);
        ArrayList<Class<? extends y>> arrayList19 = new ArrayList<>();
        f314595s = arrayList19;
        arrayList19.add(WebViewSurfaceInjectorImpl.class);
        ArrayList<Class<? extends com.tencent.mobileqq.webview.util.k>> arrayList20 = new ArrayList<>();
        f314596t = arrayList20;
        arrayList20.add(com.tencent.mobileqq.webview.swift.x.class);
        ArrayList<Class<? extends com.tencent.mobileqq.webview.util.l>> arrayList21 = new ArrayList<>();
        f314597u = arrayList21;
        arrayList21.add(com.tencent.mobileqq.webprocess.d.class);
        ArrayList<Class<? extends i>> arrayList22 = new ArrayList<>();
        f314598v = arrayList22;
        arrayList22.add(com.tencent.mobileqq.webview.injector.f.class);
        ArrayList<Class<? extends s>> arrayList23 = new ArrayList<>();
        f314599w = arrayList23;
        arrayList23.add(com.tencent.mobileqq.webview.injector.o.class);
        ArrayList<Class<? extends com.tencent.mobileqq.webview.nativeapi.b>> arrayList24 = new ArrayList<>();
        f314600x = arrayList24;
        arrayList24.add(com.tencent.mobileqq.Doraemon.h.class);
        ArrayList<Class<? extends com.tencent.mobileqq.inject.b>> arrayList25 = new ArrayList<>();
        f314601y = arrayList25;
        arrayList25.add(com.tencent.mobileqq.injector.d.class);
        ArrayList<Class<? extends QbSdk.TbsInstallerCallBack>> arrayList26 = new ArrayList<>();
        f314602z = arrayList26;
        arrayList26.add(com.tencent.mobileqq.webview.injector.l.class);
        ArrayList<Class<? extends w>> arrayList27 = new ArrayList<>();
        A = arrayList27;
        arrayList27.add(WebSdkInitInjector.class);
    }

    public ab() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
