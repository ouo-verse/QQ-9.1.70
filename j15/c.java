package j15;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class c extends a {

    /* renamed from: d, reason: collision with root package name */
    private i15.a f409147d;

    public c(Map<String, String> map) {
        super(map);
    }

    @Override // j15.a
    protected void a(Map<String, String> map) {
        super.a(map);
        if (map == null) {
            QLog.e("VasADBannerConfigInfo", 1, "buildData error with data = null");
            return;
        }
        try {
            this.f409147d = i15.a.a().k(map.get("topText")).c(map.get("bottomText")).j(map.get("textColor")).e(map.get("coutdownBgColor")).h(map.get("coutdownTextColor")).d(map.get("buttonTitle")).b();
            if (!TextUtils.isEmpty(map.get("enableCountdown"))) {
                this.f409147d.f407038a = Integer.parseInt(map.get("enableCountdown"));
            }
            if (!TextUtils.isEmpty(map.get("countdownMinute"))) {
                this.f409147d.f407039b = Integer.parseInt(map.get("countdownMinute"));
            }
            if (!TextUtils.isEmpty(map.get("countdownSecond"))) {
                this.f409147d.f407040c = Integer.parseInt(map.get("countdownSecond"));
            }
            f().f407080k = this.f409147d;
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e("VasADBannerConfigInfo", 1, "qboss banner buildData error msg = " + e16.getMessage());
        }
    }

    @Override // j15.a
    public void c(SharedPreferences sharedPreferences, String str) {
        if (sharedPreferences == null) {
            return;
        }
        super.c(sharedPreferences, str);
        try {
            this.f409147d = i15.a.a().k(sharedPreferences.getString("splash_union_banner_top_text" + str, "")).c(sharedPreferences.getString("splash_union_banner_bottom_text" + str, "")).j(sharedPreferences.getString("splash_union_banner_text_color" + str, "")).e(sharedPreferences.getString("splash_union_banner_cout_down_bg_color" + str, "")).h(sharedPreferences.getString("splash_union_banner_cout_down_text_color" + str, "")).d(sharedPreferences.getString("splash_union_banner_botton_title" + str, "")).i(sharedPreferences.getInt("splash_union_banner_enable_count_down" + str, -1)).f(sharedPreferences.getInt("splash_union_banner_count_down_min" + str, -1)).g(sharedPreferences.getInt("splash_union_banner_count_down_sec" + str, -1)).b();
            if (f() != null) {
                f().f407080k = this.f409147d;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e("VasADBannerConfigInfo", 1, "buildUnionBannerFromSP error msg = " + e16.getMessage());
        }
    }

    @Override // j15.a
    public void j(String str) {
        SharedPreferences l3 = com.tencent.mobileqq.vassplash.common.c.l(BaseApplication.getContext(), str + "");
        if (l3 != null && f() != null) {
            super.j(str);
            i15.d f16 = f();
            if (f16 == null) {
                return;
            }
            SharedPreferences.Editor edit = l3.edit();
            String str2 = f16.f407075f;
            edit.putString("splash_union_banner_top_text" + str2, this.f409147d.f407041d);
            edit.putString("splash_union_banner_bottom_text" + str2, this.f409147d.f407042e);
            edit.putString("splash_union_banner_text_color" + str2, this.f409147d.f407043f);
            edit.putString("splash_union_banner_cout_down_bg_color" + str2, this.f409147d.f407044g);
            edit.putString("splash_union_banner_cout_down_text_color" + str2, this.f409147d.f407045h);
            edit.putString("splash_union_banner_botton_title" + str2, this.f409147d.f407046i);
            edit.putInt("splash_union_banner_enable_count_down" + str2, this.f409147d.f407038a);
            edit.putInt("splash_union_banner_count_down_min" + str2, this.f409147d.f407039b);
            edit.putInt("splash_union_banner_count_down_sec" + str2, this.f409147d.f407040c);
            edit.apply();
        }
    }

    public i15.a k() {
        i15.a aVar;
        if (f() != null && (aVar = this.f409147d) != null) {
            return aVar;
        }
        return null;
    }
}
