package com.qq.e.comm.plugin.stat;

import com.qq.e.comm.net.NetworkClientImpl;
import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;
import com.qq.e.comm.net.rr.S2SSRequest;
import com.qq.e.comm.plugin.k.ag;
import com.qq.e.comm.plugin.k.aj;
import com.qq.e.comm.plugin.k.ap;
import com.qq.e.comm.plugin.k.x;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import java.util.concurrent.Future;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes3.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private static final String f39724a;

    /* renamed from: b, reason: collision with root package name */
    private static final String f39725b;

    static {
        Object obj;
        Object[] objArr = new Object[2];
        String str = "ttc.gdt.qq.com";
        if (aj.f()) {
            obj = "ttc.gdt.qq.com";
        } else {
            obj = "sdkreport.e.qq.com";
        }
        objArr[0] = obj;
        objArr[1] = "link_event";
        f39724a = String.format("https://%s/%s", objArr);
        Object[] objArr2 = new Object[2];
        if (!aj.f()) {
            str = "sdkreport.e.qq.com";
        }
        objArr2[0] = str;
        objArr2[1] = "report_log";
        f39725b = String.format("https://%s/%s", objArr2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Future<Response> a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        x a16 = h.a();
        a16.a(LinkReportConstant$GlobalKey.EVENTS, jSONArray);
        ap.a().a(h.c());
        Request a17 = a(f39724a, a16.toString(), false, com.qq.e.comm.plugin.j.c.a("reportGzip", 1, 1));
        GDTLogger.e("Report stat event : " + a16.toString());
        return NetworkClientImpl.getInstance().submit(a17, 3, 1);
    }

    public static Future<Response> a(String str) {
        x b16 = h.b();
        if (b16 == null) {
            return null;
        }
        ap.a().a(h.c());
        b16.a("log", str);
        return NetworkClientImpl.getInstance().submit(a(f39725b, b16.toString(), false, com.qq.e.comm.plugin.j.c.a("reportGzip", 1, 1)), 3, 1);
    }

    private static Request a(String str, String str2, boolean z16, boolean z17) {
        return new S2SSRequest(str, str2.getBytes(ag.f39619a), z16, z17);
    }
}
