package com.qzone.component.banner;

import TianShuJce.AdItem;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewStub;
import android.widget.FrameLayout;
import com.qzone.common.account.LoginData;
import com.qzone.util.ak;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.open.ArkAppInfo;
import com.tencent.ark.open.ArkView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.ark.api.IArkHelper;
import com.tencent.mobileqq.ark.f;
import com.tencent.mobileqq.ark.module.g;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.util.QQCustomArkDialogUtil;
import cooperation.qzone.QUA;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ArkAdsBanner extends Banner {
    public boolean C;
    private ArkView D;
    private boolean E;
    private AdItem F;
    private ArkViewImplement.LoadCallback G;

    /* renamed from: h, reason: collision with root package name */
    private FrameLayout f46290h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f46291i;

    /* renamed from: m, reason: collision with root package name */
    public boolean f46292m;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class ArkAdsBannerArkNotify implements g {
        public ArkAdsBannerArkNotify() {
        }

        @Override // com.tencent.mobileqq.ark.module.g
        public boolean notify(String str, String str2, String str3) {
            if (TextUtils.isEmpty(str3)) {
                return false;
            }
            try {
                String string = new JSONObject(str3).getString("type");
                if ("banner".equals(string)) {
                    ak.f(ArkAdsBanner.this.F, 102);
                } else if ("closeBtn".equals(string)) {
                    ak.f(ArkAdsBanner.this.F, 122);
                }
                ArkAdsBanner.this.f46291i = true;
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qzone.component.banner.ArkAdsBanner.ArkAdsBannerArkNotify.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ArkAdsBanner.this.g();
                    }
                });
            } catch (Exception e16) {
                QLog.e("ArkAdsBanner", 1, "Banner Notify exception =" + e16, ", appname :" + str + ", eventName:" + str2, ", params:" + str3);
            }
            return true;
        }
    }

    public ArkAdsBanner(Context context) {
        super(context);
        this.f46292m = true;
        this.C = false;
        this.E = false;
        this.G = new a();
    }

    private String w(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        hashMap3.put("uin", LoginData.getInstance().getUin() + "");
        hashMap3.put("nick", LoginData.getInstance().getNickName(""));
        hashMap2.put(ITVKPlayerEventListener.KEY_USER_INFO, hashMap3);
        hashMap2.put("ua", QUA.getQUA3());
        hashMap2.put("data", jSONObject);
        hashMap.put("indexData", hashMap2);
        return new JSONObject(hashMap).toString();
    }

    private void x(String str, String str2, String str3, String str4, String str5) {
        this.D.setHardwareRenderingEnable(false);
        if (this.E) {
            return;
        }
        this.D.load(str, str2, str3, str4, str5, this.G);
        QLog.i("ArkAdsBanner", 1, QQCustomArkDialogUtil.META_DATA + str4);
    }

    public static String y(Map<String, String> map) {
        try {
            return new JSONObject(map).toString();
        } catch (Exception e16) {
            QLog.e("ArkAdsBanner", 1, e16, new Object[0]);
            return null;
        }
    }

    private void z() {
        ArkView arkView;
        int height;
        if (this.C || (arkView = this.D) == null || (height = arkView.getHeight()) == 0) {
            return;
        }
        int screenWidth = ViewUtils.getScreenWidth();
        double d16 = screenWidth;
        int i3 = (int) (d16 / (((d16 * 1.0d) / height) * 1.0d));
        ArkAppInfo.Size size = new ArkAppInfo.Size(screenWidth, i3);
        this.f46290h.getLayoutParams().width = screenWidth;
        this.f46290h.getLayoutParams().height = i3;
        this.D.setSize(size, size, size);
        QLog.i("ArkAdsBanner", 1, "resize arkview to:" + screenWidth + "," + i3);
        this.C = true;
    }

    @Override // com.qzone.component.banner.Banner
    public int d() {
        return 700;
    }

    @Override // com.qzone.component.banner.Banner
    public void destroy() {
        super.destroy();
        ArkView arkView = this.D;
        if (arkView != null) {
            arkView.onDestroy();
        }
        this.F = null;
        ((IArkAPIService) QRoute.api(IArkAPIService.class)).registerAppNotification("com.tencent.vas", null);
    }

    @Override // com.qzone.component.banner.Banner
    public int e() {
        return 31;
    }

    @Override // com.qzone.component.banner.Banner
    public void i(boolean z16) {
        if (this.f46297e) {
            if (z16 && this.E) {
                this.f46290h.setVisibility(0);
                this.f46290h.setContentDescription("\u5e7f\u544a");
                this.f46290h.setFocusable(true);
                z();
                ak.f(this.F, 101);
                this.f46298f = false;
                return;
            }
            this.f46290h.setVisibility(8);
        }
    }

    @Override // com.qzone.component.banner.Banner
    public boolean l() {
        return this.f46297e && this.f46290h.getVisibility() == 0;
    }

    @Override // com.qzone.component.banner.Banner
    public void t(com.qzone.feed.business.model.a aVar) {
        if (!this.f46297e) {
            QZLog.e("ArkAdsBanner", "updateBannerData: banner\u8fd8\u672a\u521d\u59cb\u5316\u6216\u521d\u59cb\u5316\u5931\u8d25");
            return;
        }
        AdItem a16 = com.qzone.component.banner.util.b.a(aVar);
        this.F = a16;
        if (a16 == null) {
            g();
            return;
        }
        String y16 = y(a16.argList);
        if (TextUtils.isEmpty(y16)) {
            return;
        }
        this.f46298f = true;
        try {
            JSONObject jSONObject = new JSONObject(y16);
            x("com.tencent.qzone.banner", jSONObject.optString(QQCustomArkDialogUtil.APP_VIEW), jSONObject.optString("version"), w(jSONObject), f.b());
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    static {
        l91.a.c(true);
        l91.a.a();
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements ArkViewImplement.LoadCallback {
        a() {
        }

        @Override // com.tencent.ark.ArkViewImplement.LoadCallback
        public void onLoadFailed(int i3, int i16, String str, boolean z16) {
            ArkAdsBanner.this.g();
            QLog.d("ArkAdsBanner", 1, "onLoadFailed" + i16 + str);
        }

        @Override // com.tencent.ark.ArkViewImplement.LoadCallback
        public void onLoadState(int i3) {
            if (i3 == 1) {
                ArkAdsBanner.this.E = true;
                ArkAdsBanner.this.c();
            } else if (i3 == 0) {
                ArkAdsBanner.this.E = false;
            } else {
                ArkAdsBanner.this.E = false;
            }
            QLog.d("ArkAdsBanner", 1, "onLoadState state =" + i3);
        }
    }

    @Override // com.qzone.component.banner.Banner
    public void h(ViewStub viewStub) {
        if (viewStub == null) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) viewStub.inflate();
        this.f46290h = frameLayout;
        if (frameLayout == null) {
            return;
        }
        this.D = (ArkView) frameLayout.findViewById(R.id.svi);
        this.f46290h.setVisibility(8);
        this.f46297e = true;
        int o16 = pl.a.f426446a.o(getContext());
        int i3 = (int) (o16 / 3.0d);
        this.f46290h.getLayoutParams().width = o16;
        this.f46290h.getLayoutParams().height = i3;
        ArkAppInfo.Size size = new ArkAppInfo.Size(o16, i3);
        this.D.setSize(size, size, size);
        this.D.setVisibility(0);
        ((IArkHelper) QRoute.api(IArkHelper.class)).preloadCommon();
        ((IArkAPIService) QRoute.api(IArkAPIService.class)).registerAppNotification("com.tencent.vas", new ArkAdsBannerArkNotify());
    }
}
