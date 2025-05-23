package am0;

import ADV_REPORT.mobile_adv_report_req;
import com.tencent.gdt.tangram.ad.qzone.d;
import java.util.Map;
import yl0.h;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c extends h {

    /* renamed from: a, reason: collision with root package name */
    private b f26298a;

    public c(b bVar) {
        this.f26298a = bVar;
    }

    public wl0.a b() {
        String obj;
        if (this.f26298a == null) {
            return null;
        }
        mobile_adv_report_req mobile_adv_report_reqVar = new mobile_adv_report_req();
        mobile_adv_report_reqVar.cookie = this.f26298a.d();
        mobile_adv_report_reqVar.busi_param = this.f26298a.c();
        mobile_adv_report_reqVar.report_posi = this.f26298a.h();
        mobile_adv_report_reqVar.write_return_code = this.f26298a.i();
        mobile_adv_report_reqVar.client_time = System.currentTimeMillis();
        mobile_adv_report_reqVar.action_expectation = this.f26298a.g();
        mobile_adv_report_reqVar.is_trace = this.f26298a.j();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("cookie =");
        Map<Integer, String> map = mobile_adv_report_reqVar.cookie;
        String str = "null";
        if (map == null) {
            obj = "null";
        } else {
            obj = map.toString();
        }
        sb5.append(obj);
        d.b("AdAsyncEventSessionFactory", sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append("busi_param =");
        Map<Integer, String> map2 = mobile_adv_report_reqVar.busi_param;
        if (map2 != null) {
            str = map2.toString();
        }
        sb6.append(str);
        d.b("AdAsyncEventSessionFactory", sb6.toString());
        d.b("AdAsyncEventSessionFactory", "report_posi =" + mobile_adv_report_reqVar.report_posi);
        wl0.a aVar = new wl0.a();
        aVar.f445785a = a();
        wl0.b bVar = new wl0.b();
        aVar.f445786b = bVar;
        bVar.f445788a = mobile_adv_report_reqVar;
        return aVar;
    }
}
