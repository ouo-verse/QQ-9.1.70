package com.tencent.smtt.utils.recorder;

import android.content.Context;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.utils.TbsLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f369806a;

    /* renamed from: c, reason: collision with root package name */
    private boolean f369808c = false;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, Long> f369807b = new HashMap();

    a() {
    }

    private boolean a(long j3) {
        return j3 <= JsonGrayBusiId.UI_RESERVE_100000_110000 && j3 > 0;
    }

    private long b(String str) {
        Long l3 = this.f369807b.get(str);
        if (l3 != null) {
            return l3.longValue();
        }
        return 0L;
    }

    public static a a() {
        if (f369806a == null) {
            synchronized (TbsLogReport.class) {
                if (f369806a == null) {
                    f369806a = new a();
                }
            }
        }
        return f369806a;
    }

    public String b() {
        long b16 = b("init_tbs_end") - b("init_tbs_Start");
        long b17 = b("preinit_finish") - b("preinit_start");
        long b18 = b("create_webview_end") - b("create_webview_start");
        long b19 = b("core_load_end") - b("core_load_start");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("");
        sb5.append("initX5Environment: ");
        if (!a(b16)) {
            b16 = -1;
        }
        sb5.append(b16);
        sb5.append(",");
        String sb6 = sb5.toString();
        StringBuilder sb7 = new StringBuilder();
        sb7.append(sb6);
        sb7.append("preInit: ");
        if (!a(b17)) {
            b17 = -1;
        }
        sb7.append(b17);
        sb7.append(",");
        String sb8 = sb7.toString();
        StringBuilder sb9 = new StringBuilder();
        sb9.append(sb8);
        sb9.append("webview: ");
        if (!a(b18)) {
            b18 = -1;
        }
        sb9.append(b18);
        sb9.append(",");
        String sb10 = sb9.toString();
        StringBuilder sb11 = new StringBuilder();
        sb11.append(sb10);
        sb11.append("coreLoadCost: ");
        if (!a(b19)) {
            b19 = -1;
        }
        sb11.append(b19);
        return sb11.toString();
    }

    public void a(String str) {
        this.f369807b.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    public void a(Context context) {
        if (this.f369808c) {
            return;
        }
        TbsLog.i("TbsTimeRecorder", b());
        this.f369808c = true;
        TbsLogReport tbsLogReport = TbsLogReport.getInstance(context);
        tbsLogReport.eventReport(TbsLogReport.EventType.TYPE_CORE_LOAD_PERFORMANCE, tbsLogReport.tbsLogInfo());
    }
}
