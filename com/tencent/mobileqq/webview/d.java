package com.tencent.mobileqq.webview;

import com.tencent.comic.ui.QQComicTitleBarView;
import com.tencent.mobileqq.ad.webview.titlebar.LebaShoppingTitleBarView;
import com.tencent.mobileqq.flashshow.api.hybird.FSPublishTitleBarView;
import com.tencent.mobileqq.guild.feed.publish.webview.GuildFeedDetailTitleBarView;
import com.tencent.mobileqq.guild.feed.publish.webview.GuildFeedPublishTitleBarView;
import com.tencent.mobileqq.guild.media.thirdapp.container.webview.GuildOpenMediaTitleBarView;
import com.tencent.mobileqq.guild.webview.GuildGiftH5TitleBarView;
import com.tencent.mobileqq.guild.webview.QQGuildApplicationChannelLinkTitleBarView;
import com.tencent.mobileqq.guild.webview.QQGuildH5TitleBarView;
import com.tencent.mobileqq.qcircle.api.hybird.QCircleTitleBarView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqwink.api.impl.hybrid.WinkPublishTitleBarView;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.webview.swift.QzoneSwitchFragmentTitleBarUI;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.component.v;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_browser_title_map.yml", version = 4)
    public static final HashMap<String, Class<? extends SwiftIphoneTitleBarUI>> f313840a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48479);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HashMap<String, Class<? extends SwiftIphoneTitleBarUI>> hashMap = new HashMap<>();
        f313840a = hashMap;
        hashMap.put("14", LebaShoppingTitleBarView.class);
        hashMap.put("13", GuildGiftH5TitleBarView.class);
        hashMap.put("12", GuildOpenMediaTitleBarView.class);
        hashMap.put("11", QQGuildApplicationChannelLinkTitleBarView.class);
        hashMap.put("10", GuildFeedDetailTitleBarView.class);
        hashMap.put("9", GuildFeedPublishTitleBarView.class);
        hashMap.put("8", QQGuildH5TitleBarView.class);
        hashMap.put("7", WinkPublishTitleBarView.class);
        hashMap.put("6", FSPublishTitleBarView.class);
        hashMap.put("4", QCircleTitleBarView.class);
        hashMap.put("2", QzoneSwitchFragmentTitleBarUI.class);
        hashMap.put("1", QQComicTitleBarView.class);
        if (hashMap.size() > 0) {
            if (QLog.isColorLevel()) {
                for (Map.Entry<String, Class<? extends SwiftIphoneTitleBarUI>> entry : hashMap.entrySet()) {
                    QLog.i("SwiftWebTitleBuilder", 2, "Key = " + entry.getKey() + ", Value = " + entry.getValue().toString());
                }
                return;
            }
            return;
        }
        QLog.e("SwiftWebTitleBuilder", 1, "S_SWIFT_TITLE_HASH_MAP inject failed !");
    }

    public static SwiftIphoneTitleBarUI a(v vVar) {
        int i3;
        WebViewProvider webViewProvider = vVar.P;
        if (webViewProvider != null && webViewProvider.getIntent() != null) {
            i3 = vVar.P.getIntent().getIntExtra("titleBarStyle", 0);
        } else {
            i3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SwiftWebTitleBuilder", 2, "title bar style is" + i3);
        }
        Class<? extends SwiftIphoneTitleBarUI> cls = f313840a.get(String.valueOf(i3));
        if (cls == null) {
            return new SwiftIphoneTitleBarUI(vVar);
        }
        try {
            Constructor<? extends SwiftIphoneTitleBarUI> declaredConstructor = cls.getDeclaredConstructor(v.class);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(vVar);
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
            return new SwiftIphoneTitleBarUI(vVar);
        } catch (InstantiationException e17) {
            e17.printStackTrace();
            return new SwiftIphoneTitleBarUI(vVar);
        } catch (NoSuchMethodException e18) {
            e18.printStackTrace();
            return new SwiftIphoneTitleBarUI(vVar);
        } catch (InvocationTargetException e19) {
            e19.printStackTrace();
            return new SwiftIphoneTitleBarUI(vVar);
        }
    }
}
