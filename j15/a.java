package j15;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.minigame.minigamecenter.hippy.MiniGameCenterHippyFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import cooperation.vip.qqbanner.manager.VasADBannerCountDownManager;
import cooperation.vip.qqbanner.manager.VasADBannerManager;
import cooperation.vip.qqbanner.manager.VasADCountDownInmersionBannerManager;
import cooperation.vip.qqbanner.manager.VasADImmersionBannerManager;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public SparseArray<C10566a> f409140a = new SparseArray<>();

    /* renamed from: b, reason: collision with root package name */
    private i15.d f409141b;

    /* renamed from: c, reason: collision with root package name */
    private int f409142c;

    /* compiled from: P */
    /* renamed from: j15.a$a, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public static class C10566a {

        /* renamed from: a, reason: collision with root package name */
        public String f409143a;

        /* renamed from: b, reason: collision with root package name */
        public String f409144b;

        /* renamed from: c, reason: collision with root package name */
        public String f409145c;

        public boolean a() {
            if (TextUtils.isEmpty(this.f409145c)) {
                return false;
            }
            return q.p(this.f409145c);
        }

        public void b(boolean z16) {
            if (QZLog.isColorLevel()) {
                QZLog.i("VasADBannerConfigInfo", 2, " qboss resources down response resUrl = " + this.f409143a + " isSuccess = " + z16);
            }
        }

        public C10566a c(String str) {
            this.f409145c = str;
            return this;
        }

        public C10566a d(String str) {
            this.f409143a = str;
            return this;
        }
    }

    public a(Map<String, String> map) {
        a(map);
    }

    public static a d(Map<String, String> map, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case 49:
                if (str.equals("1")) {
                    c16 = 0;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c16 = 1;
                    break;
                }
                break;
            case 1507456:
                if (str.equals("1012")) {
                    c16 = 2;
                    break;
                }
                break;
            case 1508392:
                if (str.equals("1108")) {
                    c16 = 3;
                    break;
                }
                break;
            case 1508454:
                if (str.equals("1128")) {
                    c16 = 4;
                    break;
                }
                break;
            case 1508607:
                if (str.equals("1176")) {
                    c16 = 5;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
            case 4:
                return new d(map);
            case 1:
            case 3:
                return new c(map);
            case 2:
                return new a(map);
            case 5:
                return new b(map);
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Map<String, String> map) {
        if (map == null) {
            QLog.e("VasADBannerConfigInfo", 1, "buildData error with bannerData is null");
            return;
        }
        QLog.d("VasADBannerConfigInfo", 1, "bannerData:", map);
        try {
            C10566a c10566a = new C10566a();
            c10566a.f409143a = map.get("res_url");
            c10566a.f409144b = map.get("res_url_md5");
            c10566a.f409145c = cooperation.vip.qqbanner.manager.a.e().f(c10566a.f409143a);
            this.f409140a.put(1, c10566a);
            this.f409141b = i15.d.a().k(map.get("jump_url")).i(map.get("jump_schema_url")).m(map.get(MiniGameCenterHippyFragment.EXTRA_KEY_AD_TRACE_INFO)).c(map.get("adId")).d(map.get("bannertype")).l(c10566a.f409145c).h(com.tencent.mobileqq.vassplash.common.c.y(map.get("isAdSplash"))).e(com.tencent.mobileqq.vassplash.common.c.f(map, "unitBannerThirdPartyReportURLForClick")).f(com.tencent.mobileqq.vassplash.common.c.f(map, "unitBannerThirdPartyReportURLForExposure")).g(map.get("connect_adids")).b();
            if (!TextUtils.isEmpty(map.get("res_type"))) {
                this.f409141b.f407070a = Integer.parseInt(map.get("res_type"));
            }
            if (!TextUtils.isEmpty(map.get("jump_type"))) {
                this.f409141b.f407073d = Integer.parseInt(map.get("jump_type"));
            }
            if (!TextUtils.isEmpty(map.get("WebViewPreloadFlag"))) {
                this.f409142c = Integer.parseInt(map.get("WebViewPreloadFlag"));
            } else {
                this.f409142c = 1;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e("VasADBannerConfigInfo", 1, "buildData error msg = " + e16.getMessage());
        }
    }

    public boolean b() {
        for (int i3 = 0; i3 < this.f409140a.size(); i3++) {
            C10566a valueAt = this.f409140a.valueAt(i3);
            if (valueAt == null || TextUtils.isEmpty(valueAt.f409145c) || !valueAt.a()) {
                return false;
            }
        }
        return true;
    }

    public void c(SharedPreferences sharedPreferences, String str) {
        if (sharedPreferences != null && !TextUtils.isEmpty(str)) {
            try {
                i15.d b16 = i15.d.a().n(sharedPreferences.getInt("splash_union_banner_type_res_type" + str, 0)).k(sharedPreferences.getString("splash_union_banner_jump_url_" + str, "")).i(sharedPreferences.getString("splash_union_banner_jump_schema_url_" + str, "")).j(sharedPreferences.getInt("splash_union_banner_jump_type_" + str, -1)).m(sharedPreferences.getString("splash_union_banner_traceinfo_" + str, "")).c(sharedPreferences.getString("splash_union_banner_adid_" + str, "")).l(sharedPreferences.getString("splash_union_banner_res_path_" + str, "")).d(sharedPreferences.getString("splash_union_banner_type_" + str, "-1")).h(sharedPreferences.getInt("splash_union_banner_is_adsplash_" + str, 0)).e(com.tencent.mobileqq.vassplash.common.c.g(sharedPreferences, "splash_union_banner_c2s_click_url_", str)).f(com.tencent.mobileqq.vassplash.common.c.g(sharedPreferences, "splash_union_banner_c2s_exposure_url_", str)).b();
                C10566a c10566a = new C10566a();
                c10566a.f409145c = b16.f407077h;
                this.f409141b = b16;
                this.f409140a.put(1, c10566a);
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.e("VasADBannerConfigInfo", 1, "buildUnionBannerFromSP error msg = " + e16.getMessage());
            }
        }
    }

    public VasADBannerManager e() {
        i15.d dVar = this.f409141b;
        if (dVar == null || TextUtils.isEmpty(dVar.f407076g)) {
            return null;
        }
        String str = this.f409141b.f407076g;
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case 49:
                if (str.equals("1")) {
                    c16 = 0;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c16 = 1;
                    break;
                }
                break;
            case 1507456:
                if (str.equals("1012")) {
                    c16 = 2;
                    break;
                }
                break;
            case 1508392:
                if (str.equals("1108")) {
                    c16 = 3;
                    break;
                }
                break;
            case 1508454:
                if (str.equals("1128")) {
                    c16 = 4;
                    break;
                }
                break;
            case 1508607:
                if (str.equals("1176")) {
                    c16 = 5;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
            case 4:
                return new VasADImmersionBannerManager();
            case 1:
            case 3:
                return new VasADBannerCountDownManager();
            case 2:
                return new VasADBannerManager();
            case 5:
                return new VasADCountDownInmersionBannerManager();
            default:
                return null;
        }
    }

    public i15.d f() {
        return this.f409141b;
    }

    public boolean g() {
        i15.d dVar = this.f409141b;
        if (dVar != null && dVar.f407082m == 1) {
            return true;
        }
        return false;
    }

    public boolean h() {
        i15.d dVar = this.f409141b;
        if (dVar != null && ("1".equals(dVar.f407076g) || "2".equals(this.f409141b.f407076g))) {
            return true;
        }
        return false;
    }

    public boolean i() {
        if (this.f409142c == 1) {
            return true;
        }
        return false;
    }

    public void j(String str) {
        SharedPreferences l3 = com.tencent.mobileqq.vassplash.common.c.l(BaseApplication.getContext(), str + "");
        if (l3 != null && !TextUtils.isEmpty(str)) {
            i15.d dVar = this.f409141b;
            String str2 = dVar.f407075f + "";
            SharedPreferences.Editor edit = l3.edit();
            edit.putInt("splash_union_banner_type_res_type" + str2, dVar.f407070a);
            edit.putString("splash_union_banner_jump_url_" + str2, dVar.f407071b);
            edit.putString("splash_union_banner_jump_schema_url_" + str2, dVar.f407072c);
            edit.putInt("splash_union_banner_jump_type_" + str2, dVar.f407073d);
            edit.putString("splash_union_banner_traceinfo_" + str2, dVar.f407074e);
            edit.putString("splash_union_banner_adid_" + str2, dVar.f407075f);
            edit.putString("splash_union_banner_type_" + str2, dVar.f407076g);
            edit.putString("splash_union_banner_res_path_" + str2, dVar.f407077h);
            edit.putInt("splash_union_banner_is_adsplash_" + str2, dVar.f407082m);
            com.tencent.mobileqq.vassplash.common.c.w(dVar.f407084o, "splash_union_banner_c2s_exposure_url_", str2, edit);
            com.tencent.mobileqq.vassplash.common.c.w(dVar.f407083n, "splash_union_banner_c2s_click_url_", str2, edit);
            edit.apply();
        }
    }
}
