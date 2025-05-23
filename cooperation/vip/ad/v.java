package cooperation.vip.ad;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.activity.recent.bannerprocessor.RenewalsBannerProcessor;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.guild.nt.misc.api.IJumpApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.IConfigProxy;
import com.tencent.mobileqq.vas.pay.api.IVasPayRenewalPage;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.toggle.VasLongToggle;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.URLUtil;
import cooperation.vip.pb.TianShuAccess;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    protected int f391231a = 596;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.redtouch.h f391232d;

        a(com.tencent.mobileqq.redtouch.h hVar) {
            this.f391232d = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            BannerManager.l().O(RenewalsBannerProcessor.f185265f, 0, null);
            w.g(this.f391232d.f280298a, 122);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.redtouch.h f391233d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f391234e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ BaseActivity f391235f;

        b(com.tencent.mobileqq.redtouch.h hVar, View view, BaseActivity baseActivity) {
            this.f391233d = hVar;
            this.f391234e = view;
            this.f391235f = baseActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (this.f391233d.f280301d.startsWith("mqqapi://")) {
                v.e(this.f391234e.getContext(), this.f391233d.f280301d);
            } else {
                String d16 = v.d(this.f391233d.f280301d);
                if (d16.contains("mqq") && d16.contains("vasrenewal") && d16.contains("open")) {
                    ((IVasPayRenewalPage) QRoute.api(IVasPayRenewalPage.class)).open(this.f391234e.getContext(), d16);
                    BannerManager.l().O(RenewalsBannerProcessor.f185265f, 0, null);
                } else if (d16.contains("mqqapi://")) {
                    v.e(this.f391234e.getContext(), d16);
                } else {
                    if ("1".equals(this.f391233d.f280308k)) {
                        intent = new Intent(this.f391235f, (Class<?>) QQBrowserActivity.class);
                    } else if ("2".equals(this.f391233d.f280308k)) {
                        intent = new Intent(this.f391235f, (Class<?>) QQTranslucentBrowserActivity.class);
                    } else {
                        intent = null;
                    }
                    if (intent != null) {
                        intent.putExtra("url", this.f391233d.f280301d);
                        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
                        this.f391235f.startActivity(intent);
                        BannerManager.l().O(RenewalsBannerProcessor.f185265f, 0, null);
                    }
                }
            }
            w.g(this.f391233d.f280298a, 102);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public static boolean c(BaseActivity baseActivity, View view, com.tencent.mobileqq.redtouch.h hVar) {
        if (baseActivity != null && view != null && hVar != null) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = URLUtil.getArgumentsFromURL(str).get("clmInfo");
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            return new JSONObject(str2).getString("url");
        } catch (JSONException unused) {
            QLog.w("TianshuRenewalsBarManager", 1, "get url string failed");
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(Context context, String str) {
        try {
            ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(context, str);
            BannerManager.l().O(RenewalsBannerProcessor.f185265f, 0, null);
        } catch (Exception unused) {
            QLog.i("TianshuRenewalsBarManager", 1, "Failed to jump source: " + str);
        }
    }

    private static void i() {
        ((IWebProcessPreload) QRoute.api(IWebProcessPreload.class)).preloadWebProcess(35, null);
    }

    public static void k(BaseActivity baseActivity, View view, com.tencent.mobileqq.redtouch.h hVar, boolean z16) {
        URLDrawable drawable;
        if (c(baseActivity, view, hVar)) {
            return;
        }
        com.tencent.mobileqq.vas.utils.b.a(hVar.f280301d);
        TextView textView = (TextView) view.findViewById(R.id.i78);
        String str = hVar.f280300c;
        if (textView != null && !TextUtils.isEmpty(str)) {
            textView.setText(str);
        }
        URLImageView uRLImageView = (URLImageView) view.findViewById(R.id.f72973sa);
        if (uRLImageView != null && !TextUtils.isEmpty(hVar.f280302e) && (drawable = URLDrawable.getDrawable(hVar.f280302e)) != null) {
            uRLImageView.setImageDrawable(drawable);
        }
        TextView textView2 = (TextView) view.findViewById(R.id.i77);
        if (textView2 != null && !TextUtils.isEmpty(hVar.f280303f)) {
            textView2.setText(hVar.f280303f);
        }
        view.setVisibility(0);
        i();
        w.g(hVar.f280298a, 101);
        a aVar = new a(hVar);
        b bVar = new b(hVar, view, baseActivity);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.i76);
        if (frameLayout != null) {
            frameLayout.setOnClickListener(bVar);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.f72963s_);
        if (imageView != null) {
            imageView.setOnClickListener(aVar);
        }
        n(baseActivity, view, hVar, z16);
    }

    private static void l(com.tencent.mobileqq.redtouch.h hVar, QQAppInterface qQAppInterface, View view) {
        String str;
        URLDrawable drawable;
        if (qQAppInterface != null && view != null && hVar != null) {
            URLImageView uRLImageView = (URLImageView) view.findViewById(R.id.f72953s9);
            TextView textView = (TextView) view.findViewById(R.id.i77);
            if (uRLImageView != null && textView != null) {
                uRLImageView.setVisibility(8);
                if (ThemeUtil.isInNightMode(qQAppInterface)) {
                    IConfigProxy iConfigProxy = VasLongToggle.VAS_BLUETIPS_NIGHTMODE_CONFIG;
                    String optString = iConfigProxy.getJson().optString("btn_image");
                    str = iConfigProxy.getJson().optString("btn_textcolor");
                    if (!iConfigProxy.isEnable(true) || TextUtils.isEmpty(str)) {
                        str = "#FDC256";
                    }
                    if (iConfigProxy.isEnable(true) && !TextUtils.isEmpty(optString)) {
                        uRLImageView.setImageDrawable(URLDrawable.getDrawable(optString));
                        uRLImageView.setVisibility(0);
                    }
                } else {
                    if (!TextUtils.isEmpty(hVar.f280305h) && (drawable = URLDrawable.getDrawable(hVar.f280305h)) != null) {
                        uRLImageView.setImageDrawable(drawable);
                        uRLImageView.setVisibility(0);
                    }
                    if (!TextUtils.isEmpty(hVar.f280307j)) {
                        str = hVar.f280307j;
                    } else {
                        str = "#4B94EA";
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    try {
                        textView.setTextColor(Color.parseColor(str));
                    } catch (Exception e16) {
                        QLog.e("TianshuRenewalsBarManager", 1, e16, new Object[0]);
                    }
                }
            }
        }
    }

    private static void m(com.tencent.mobileqq.redtouch.h hVar, boolean z16, QQAppInterface qQAppInterface, Resources resources, View view) {
        if (qQAppInterface != null && hVar != null && resources != null && view != null) {
            TextView textView = (TextView) view.findViewById(R.id.i78);
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.i76);
            URLImageView uRLImageView = (URLImageView) view.findViewById(R.id.f72943s8);
            if (textView != null && frameLayout != null && uRLImageView != null) {
                if (ThemeUtil.isInNightMode(qQAppInterface)) {
                    o(resources, textView, frameLayout, uRLImageView);
                } else if (!TextUtils.isEmpty(hVar.f280304g)) {
                    p(hVar, resources, textView, uRLImageView);
                } else {
                    q(z16, resources, textView, frameLayout, uRLImageView);
                }
            }
        }
    }

    public static void n(BaseActivity baseActivity, View view, com.tencent.mobileqq.redtouch.h hVar, boolean z16) {
        if (view == null || hVar == null || baseActivity == null || view.getVisibility() != 0) {
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) baseActivity.getAppRuntime();
        m(hVar, z16, qQAppInterface, baseActivity.getResources(), view);
        l(hVar, qQAppInterface, view);
    }

    private static void o(Resources resources, TextView textView, FrameLayout frameLayout, URLImageView uRLImageView) {
        IConfigProxy iConfigProxy = VasLongToggle.VAS_BLUETIPS_NIGHTMODE_CONFIG;
        String optString = iConfigProxy.getJson().optString("bg_image");
        String optString2 = iConfigProxy.getJson().optString("textcolor");
        if (iConfigProxy.isEnable(true) && !TextUtils.isEmpty(optString)) {
            uRLImageView.setImageDrawable(URLDrawable.getDrawable(optString));
            uRLImageView.setVisibility(0);
        } else {
            frameLayout.setBackground(resources.getDrawable(R.drawable.f160540jm));
            uRLImageView.setVisibility(8);
        }
        if (iConfigProxy.isEnable(true) && !TextUtils.isEmpty(optString2)) {
            try {
                textView.setTextColor(Color.parseColor(optString2));
                return;
            } catch (Exception unused) {
                textView.setTextColor(-1);
                return;
            }
        }
        textView.setTextColor(resources.getColorStateList(R.color.skin_black_theme_version2));
    }

    private static void p(com.tencent.mobileqq.redtouch.h hVar, Resources resources, TextView textView, URLImageView uRLImageView) {
        URLDrawable drawable = URLDrawable.getDrawable(hVar.f280304g);
        if (drawable != null) {
            uRLImageView.setImageDrawable(drawable);
            uRLImageView.setVisibility(0);
        }
        if (!TextUtils.isEmpty(hVar.f280306i)) {
            try {
                textView.setTextColor(Color.parseColor(hVar.f280306i));
                return;
            } catch (Exception e16) {
                QLog.e("TianshuRenewalsBarManager", 1, e16, new Object[0]);
                return;
            }
        }
        textView.setTextColor(resources.getColorStateList(R.color.skin_black_theme_version2));
    }

    private static void q(boolean z16, Resources resources, TextView textView, FrameLayout frameLayout, URLImageView uRLImageView) {
        if (z16 && (ThemeUtil.isDefaultTheme() || ThemeUtil.isSimpleDayTheme(false))) {
            frameLayout.setBackground(resources.getDrawable(R.drawable.f160541jn));
        } else {
            frameLayout.setBackground(resources.getDrawable(R.drawable.f160540jm));
        }
        uRLImageView.setVisibility(8);
        textView.setTextColor(resources.getColorStateList(R.color.skin_black_theme_version2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(TianShuAccess.RspEntry rspEntry) {
        TianShuAccess.AdPlacementInfo adPlacementInfo;
        TianShuAccess.AdItem adItem;
        if (rspEntry == null || (adPlacementInfo = rspEntry.value) == null || adPlacementInfo.lst.size() < 1 || (adItem = rspEntry.value.lst.get(0)) == null) {
            return;
        }
        j(adItem);
    }

    public void g(Map<Integer, TianShuAccess.RspEntry> map, int i3) {
        boolean z16;
        BannerManager l3 = BannerManager.l();
        int i16 = RenewalsBannerProcessor.f185265f;
        if (l3.g(i16) == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && i3 == 2) {
            BannerManager.l().D(i16, 2001);
        } else {
            f(map.get(Integer.valueOf(this.f391231a)));
        }
    }

    public void j(TianShuAccess.AdItem adItem) {
        if (adItem != null && adItem.argList.size() >= 1) {
            HashMap hashMap = new HashMap();
            for (TianShuAccess.MapEntry mapEntry : adItem.argList.get()) {
                hashMap.put(mapEntry.key.get(), mapEntry.value.get());
            }
            com.tencent.mobileqq.redtouch.h hVar = new com.tencent.mobileqq.redtouch.h();
            hVar.f280298a = adItem.iAdId.get() + "";
            hVar.f280299b = adItem.traceinfo.get();
            hVar.f280300c = (String) hashMap.get("text_content");
            hVar.f280301d = (String) hashMap.get("url");
            hVar.f280302e = (String) hashMap.get("pic_icon");
            hVar.f280308k = (String) hashMap.get("url_type");
            hVar.f280303f = (String) hashMap.get("text_button");
            hVar.f280304g = (String) hashMap.get("pic_bg");
            hVar.f280305h = (String) hashMap.get("pic_button");
            hVar.f280306i = (String) hashMap.get("color_content");
            hVar.f280307j = (String) hashMap.get("color_button");
            if (!TextUtils.isEmpty(hVar.f280300c) && !TextUtils.isEmpty(hVar.f280301d) && !TextUtils.isEmpty(hVar.f280303f) && !TextUtils.isEmpty(hVar.f280302e)) {
                Message obtain = Message.obtain();
                obtain.what = 2000;
                obtain.obj = hVar;
                BannerManager.l().G(RenewalsBannerProcessor.f185265f, obtain);
            }
        }
    }

    public void h() {
    }
}
