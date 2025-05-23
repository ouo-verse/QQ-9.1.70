package com.tencent.mobileqq.webview.swift;

import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.biz.webviewplugin.OpenCenterPlugin;
import com.tencent.biz.webviewplugin.WebSoPlugin;
import com.tencent.gamecenter.wadl.biz.jsplugin.GameCenterInterruptPlugin;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.vaswebviewplugin.VasWebReport;
import com.tencent.mobileqq.webview.WebSecurityPluginV2;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "CommonJsPluginFactory";

    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_common_js_plugin.yml", version = 2)
    public static ArrayList<Class<? extends WebViewPlugin>> sCommonJsPluginList;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48509);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        ArrayList<Class<? extends WebViewPlugin>> arrayList = new ArrayList<>();
        sCommonJsPluginList = arrayList;
        arrayList.add(GameCenterInterruptPlugin.class);
        sCommonJsPluginList.add(com.tencent.mobileqq.antiphing.a.class);
        sCommonJsPluginList.add(com.tencent.mobileqq.webview.g.class);
        sCommonJsPluginList.add(WebSecurityPluginV2.class);
        sCommonJsPluginList.add(VasWebReport.class);
        sCommonJsPluginList.add(WebSoPlugin.class);
        sCommonJsPluginList.add(com.tencent.biz.webviewplugin.ae.class);
        sCommonJsPluginList.add(OfflinePlugin.class);
        sCommonJsPluginList.add(com.tencent.biz.webviewplugin.x.class);
        sCommonJsPluginList.add(WebViewJumpPlugin.class);
        sCommonJsPluginList.add(com.tencent.mobileqq.webviewplugin.b.class);
        sCommonJsPluginList.add(com.tencent.mobileqq.jsp.h.class);
        sCommonJsPluginList.add(UiApiPlugin.class);
        sCommonJsPluginList.add(OpenCenterPlugin.class);
        sCommonJsPluginList.add(MiniAppPlugin.class);
        sCommonJsPluginList.add(QzoneWebViewOfflinePlugin.class);
        sCommonJsPluginList.add(com.tencent.gdtad.web.k.class);
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public List<WebViewPlugin> getCommonJsPlugin() {
        boolean isDebugVersion;
        RuntimeException runtimeException;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<Class<? extends WebViewPlugin>> it = sCommonJsPluginList.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().newInstance());
            }
        } finally {
            if (isDebugVersion) {
            }
            return arrayList;
        }
        return arrayList;
    }
}
