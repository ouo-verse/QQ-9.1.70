package com.qq.e.comm.plugin.tangramsplash.report;

import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.util.GDTLogger;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SplashLinkReporter {

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    @interface SourceType {
        public static final int MATERIAL_APNG_IMG = 19;
        public static final int MATERIAL_BROKEN_VIDEO = 3;
        public static final int MATERIAL_FOCUS_IMG = 5;
        public static final int MATERIAL_FOCUS_VIDEO = 4;
        public static final int MATERIAL_IMG = 2;
        public static final int MATERIAL_VIDEO = 1;
    }

    private static int a(int i3) {
        int i16 = 1;
        if (i3 == 1) {
            return 2;
        }
        if (i3 == 6) {
            return 5;
        }
        if (i3 != 2) {
            i16 = 4;
            if (i3 != 7) {
                if (i3 == 5) {
                    return 3;
                }
                return i3 == 4 ? 19 : Integer.MIN_VALUE;
            }
        }
        return i16;
    }

    public static void b(int i3, String str, String str2, int i16, String str3) {
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        bVar.b(str2);
        bVar.a(str);
        bVar.c(str3);
        try {
            JSONObject jSONObject = new JSONObject();
            int a16 = a(i16);
            if (a16 != Integer.MIN_VALUE) {
                jSONObject.putOpt("res_type", Integer.valueOf(a16));
            }
            bVar.a(jSONObject);
        } catch (Throwable th5) {
            GDTLogger.e(th5.getMessage());
        }
        StatTracer.trackEvent(i3, 0, bVar, (com.qq.e.comm.plugin.stat.c) null);
    }

    public static void a(int i3, r rVar) {
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        if (rVar != null) {
            bVar.c(rVar.y());
            bVar.b(rVar.f());
            bVar.a(rVar.s());
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("order_type", Integer.valueOf(a(rVar)));
                bVar.a(jSONObject);
            } catch (Throwable th5) {
                GDTLogger.e(th5.getMessage());
            }
        }
        StatTracer.trackEvent(i3, 0, bVar, (com.qq.e.comm.plugin.stat.c) null);
    }

    public static void a(int i3, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        r rVar = new r(GDTADManager.getInstance().getAppStatus().getAPPID(), str, null, com.qq.e.comm.plugin.base.ad.b.SPLASH);
        try {
            rVar.e(new JSONObject(str2));
            a(i3, rVar);
        } catch (Throwable th5) {
            GDTLogger.e("reportOutSplashEvent error", th5);
        }
    }

    public static void a(int i3, String str, String str2, int i16, String str3) {
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        bVar.b(str2);
        bVar.a(str);
        bVar.c(str3);
        try {
            JSONObject jSONObject = new JSONObject();
            int a16 = a(i16);
            if (a16 != Integer.MIN_VALUE) {
                jSONObject.putOpt("res_type", Integer.valueOf(a16));
            }
            bVar.a(jSONObject);
        } catch (Throwable th5) {
            GDTLogger.e(th5.getMessage());
        }
        StatTracer.trackEvent(i3, 0, bVar, (com.qq.e.comm.plugin.stat.c) null);
    }

    public static void a(int i3, String str, String str2, int i16, long j3, String str3) {
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        bVar.b(str2);
        bVar.a(str);
        bVar.a(j3);
        bVar.c(str3);
        try {
            JSONObject jSONObject = new JSONObject();
            int a16 = a(i16);
            if (a16 != Integer.MIN_VALUE) {
                jSONObject.putOpt("res_type", Integer.valueOf(a16));
            }
            bVar.a(jSONObject);
        } catch (Throwable th5) {
            GDTLogger.e(th5.getMessage());
        }
        StatTracer.trackEvent(i3, 0, bVar, (com.qq.e.comm.plugin.stat.c) null);
    }

    public static void a(int i3, String str, String str2, int i16, long j3, int i17, String str3) {
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        bVar.b(str2);
        bVar.a(str);
        bVar.a(j3);
        bVar.c(str3);
        try {
            JSONObject jSONObject = new JSONObject();
            int a16 = a(i16);
            if (a16 != Integer.MIN_VALUE) {
                jSONObject.putOpt("res_type", Integer.valueOf(a16));
            }
            jSONObject.putOpt("error_code", Integer.valueOf(i17));
            bVar.a(jSONObject);
        } catch (Throwable th5) {
            GDTLogger.e(th5.getMessage());
        }
        StatTracer.trackEvent(i3, 0, bVar, (com.qq.e.comm.plugin.stat.c) null);
    }

    public static void a(r rVar, int i3, int i16, int i17) {
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        if (rVar != null) {
            bVar.c(rVar.y());
            bVar.b(rVar.f());
            bVar.a(rVar.s());
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("error_code", Integer.valueOf(i17));
            jSONObject.putOpt("enum_code", Integer.valueOf(i16));
            jSONObject.putOpt("order_type", Integer.valueOf(a(rVar)));
            bVar.a(jSONObject);
        } catch (Throwable th5) {
            GDTLogger.e(th5.getMessage());
        }
        StatTracer.trackEvent(i3, 0, bVar, (com.qq.e.comm.plugin.stat.c) null);
    }

    private static int a(r rVar) {
        if (rVar != null && rVar.bi() && !TextUtils.isEmpty(rVar.bx().ad())) {
            if (rVar.bf() == 1 || rVar.bf() == 1) {
                return 13;
            }
            if (rVar.bf() == 0 || rVar.bf() == 0) {
                return 14;
            }
        }
        return 999;
    }
}
