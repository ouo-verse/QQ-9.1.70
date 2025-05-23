package com.qzone.homepage.ui.component;

import android.app.Activity;
import android.text.TextUtils;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.mobileqq.magicface.model.f;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.base.MD5Utils;
import com.tencent.qzonehub.api.IQzoneGiftFullScreenViewControllerProxy;
import cooperation.qzone.IQzoneGiftFullScreenViewController;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.cache.CacheManager;
import java.io.File;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private IQzoneGiftFullScreenViewController f47706a;

    /* compiled from: P */
    /* renamed from: com.qzone.homepage.ui.component.b$b, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public static class C0393b {

        /* renamed from: a, reason: collision with root package name */
        public Activity f47708a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f47709b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f47710c;

        /* renamed from: d, reason: collision with root package name */
        public int f47711d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f47712e;

        /* renamed from: f, reason: collision with root package name */
        public String f47713f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f47714g;

        /* renamed from: h, reason: collision with root package name */
        public String f47715h;

        public static C0393b a(Activity activity, boolean z16, boolean z17, String str, int i3, BusinessFeedData businessFeedData) {
            C0393b c0393b = new C0393b();
            c0393b.f47708a = activity;
            c0393b.f47709b = z16;
            c0393b.f47710c = z17;
            c0393b.f47715h = str;
            c0393b.f47711d = i3;
            if (businessFeedData != null && businessFeedData.getUser() != null && businessFeedData.getFeedCommInfo() != null) {
                c0393b.f47712e = QZoneFeedUtil.R(businessFeedData);
                c0393b.f47713f = businessFeedData.getUser().personalizedPassivePraiseUrl;
                c0393b.f47714g = businessFeedData.getFeedCommInfo().isBizRecomFeeds();
            }
            return c0393b;
        }
    }

    public void a(C0393b c0393b) {
        if (c0393b == null || TextUtils.isEmpty(c0393b.f47713f)) {
            return;
        }
        try {
            if (!LocalMultiProcConfig.getBool(LocalMultiProcConfig.QZONE_PASSIVE_PRAISE_ENABLED, true) || c0393b.f47710c || c0393b.f47714g || c0393b.f47711d != -1 || !c0393b.f47709b || c0393b.f47712e) {
                return;
            }
            String replace = c0393b.f47713f.replace("sbig", f.d());
            StringBuilder sb5 = new StringBuilder();
            sb5.append(CacheManager.getPraiseDir());
            String str = File.separator;
            sb5.append(str);
            sb5.append(MD5Utils.toMD5(replace));
            sb5.append(str);
            String sb6 = sb5.toString();
            File file = new File(sb6);
            if (file.exists() && file.isDirectory() && ((IQzoneGiftFullScreenViewControllerProxy) QRoute.api(IQzoneGiftFullScreenViewControllerProxy.class)).isSupportMagicface()) {
                if (this.f47706a == null) {
                    this.f47706a = ((IQzoneGiftFullScreenViewControllerProxy) QRoute.api(IQzoneGiftFullScreenViewControllerProxy.class)).getQzoneGiftFullScreenViewController(c0393b.f47708a);
                }
                if (!TextUtils.isEmpty(c0393b.f47715h)) {
                    ClickReport.m("633", "1", c0393b.f47715h);
                }
                this.f47706a.playMaigcface(c0393b.f47713f + "", sb6, true, new a());
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements IQzoneGiftFullScreenViewController.GiftFullScreenPlayListener {
        a() {
        }

        @Override // cooperation.qzone.IQzoneGiftFullScreenViewController.GiftFullScreenPlayListener
        public void giftFullScreenPlayEnd() {
        }
    }
}
