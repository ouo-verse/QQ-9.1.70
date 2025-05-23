package fu3;

import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ReportProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.AppBrandUtil;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    private boolean f400648d;

    /* renamed from: a, reason: collision with root package name */
    private long f400645a = 0;

    /* renamed from: b, reason: collision with root package name */
    private long f400646b = 0;

    /* renamed from: c, reason: collision with root package name */
    private String f400647c = null;

    /* renamed from: e, reason: collision with root package name */
    private String f400649e = "";

    public a(boolean z16) {
        this.f400648d = z16;
    }

    private HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("path", this.f400647c);
        hashMap.put("platForm", "Android");
        hashMap.put("version", this.f400649e);
        return hashMap;
    }

    private void c(String str, boolean z16, HashMap<String, String> hashMap) {
        if (this.f400648d) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("report event:");
            sb5.append(str);
            sb5.append(",isSuccess:");
            sb5.append(z16);
            sb5.append(". [");
            for (String str2 : hashMap.keySet()) {
                sb5.append("(");
                sb5.append(str2);
                sb5.append(",");
                sb5.append(hashMap.get(str2));
                sb5.append(")");
            }
            sb5.append(". ]");
            QMLog.d("MiniViewReporter", sb5.toString());
        }
        ((ReportProxy) ProxyManager.get(ReportProxy.class)).reportCounter(str, z16, hashMap);
    }

    private void f(Map<String, String> map, long j3) {
        if (this.f400648d) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("reportTimeCost:");
            sb5.append(j3);
            sb5.append(". [");
            for (String str : map.keySet()) {
                sb5.append("(");
                sb5.append(str);
                sb5.append(",");
                sb5.append(map.get(str));
                sb5.append(")");
            }
            sb5.append(". ]");
            QMLog.d("MiniViewReporter", sb5.toString());
        }
        ((ReportProxy) ProxyManager.get(ReportProxy.class)).reportContainerTimeCost(map, j3);
    }

    private void g() {
        long currentTimeMillis = System.currentTimeMillis() - this.f400645a;
        HashMap<String, String> a16 = a();
        a16.put("step_name", "mini_app_launch_end");
        ((ReportProxy) ProxyManager.get(ReportProxy.class)).reportContainerTimeCost(a16, currentTimeMillis);
    }

    public void b() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f400645a = currentTimeMillis;
        this.f400646b = currentTimeMillis;
        HashMap<String, String> a16 = a();
        a16.put("mini_tag", "init");
        c(ReportProxy.COUNTER_EVENT_LOAD, true, a16);
    }

    public void d(int i3, String str) {
        boolean z16;
        if (i3 == 0) {
            e("mini_app_content_ready");
        }
        HashMap<String, String> a16 = a();
        a16.put("errorcode", String.valueOf(i3));
        a16.put("mini_tag", "result");
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        c(ReportProxy.COUNTER_EVENT_LOAD, z16, a16);
    }

    public void e(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = currentTimeMillis - this.f400646b;
        this.f400646b = currentTimeMillis;
        HashMap<String, String> a16 = a();
        a16.put("step_name", str);
        f(a16, j3);
        if ("mini_app_dom_ready".equals(str)) {
            g();
        }
    }

    public void h() {
        this.f400646b = System.currentTimeMillis();
        this.f400645a = System.currentTimeMillis();
        HashMap<String, String> a16 = a();
        a16.put("mini_tag", TVKCommonParamEnum.REQ_PARAM_KEY_RETRY);
        c(ReportProxy.COUNTER_EVENT_LOAD, true, a16);
    }

    public void i() {
        c(ReportProxy.COUNTER_EVENT_WHITE_SCREEN, false, a());
    }

    public void j(int i3) {
        HashMap<String, String> a16 = a();
        a16.put("retry_times", String.valueOf(i3));
        c(ReportProxy.COUNTER_EVENT_WHITE_SCREEN, true, a16);
    }

    public void k(String str) {
        if (str == null) {
            this.f400647c = "";
        } else {
            this.f400647c = AppBrandUtil.getUrlWithoutParams(str);
        }
    }

    public void l(String str) {
        this.f400649e = str;
    }
}
