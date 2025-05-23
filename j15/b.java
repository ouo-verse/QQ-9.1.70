package j15;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import j15.a;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b extends a {

    /* renamed from: d, reason: collision with root package name */
    private i15.b f409146d;

    public b(Map<String, String> map) {
        super(map);
    }

    private void k(int i3, String str, String str2) {
        a.C10566a c10566a = new a.C10566a();
        c10566a.f409143a = str;
        c10566a.f409144b = str2;
        if (!TextUtils.isEmpty(str)) {
            c10566a.f409145c = cooperation.vip.qqbanner.manager.a.e().f(str);
        }
        this.f409140a.put(i3, c10566a);
    }

    @Override // j15.a
    protected void a(Map<String, String> map) {
        boolean z16;
        super.a(map);
        if (map != null && !map.isEmpty()) {
            try {
                this.f409146d = i15.b.a().l(map.get("topText")).f(map.get("bottomText")).i(map.get("text_png")).j(map.get("end_timeColor")).h(map.get("cartoon")).g(map.get("cartoon_md5")).e(map.get("end_pic")).c(map.get("end_cartoon")).k(map.get("statusBarColor")).d(map.get("end_res_url")).b();
                if (!TextUtils.isEmpty(map.get("end_time"))) {
                    this.f409146d.f407051e = Integer.parseInt(map.get("end_time"));
                }
                if (!TextUtils.isEmpty(map.get("fixed_type"))) {
                    i15.b bVar = this.f409146d;
                    if (Integer.parseInt(map.get("fixed_type")) == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    bVar.f407058l = z16;
                }
                i15.b bVar2 = this.f409146d;
                k(5, bVar2.f407053g, bVar2.f407054h);
                k(3, this.f409146d.f407050d, "");
                k(6, this.f409146d.f407056j, "");
                k(4, this.f409146d.f407055i, "");
                k(7, this.f409146d.f407057k, "");
                return;
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.e("vas_banner|VasADBannerCountDownImmersionInfo", 1, "banner parseJson error msg = " + e16.getMessage());
                return;
            }
        }
        QLog.e("vas_banner|VasADBannerCountDownImmersionInfo", 1, "bannerData is empty");
    }

    public i15.b l() {
        if (f() == null) {
            return null;
        }
        return this.f409146d;
    }
}
