package com.tencent.mobileqq.teamwork;

import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes18.dex */
public class OpenDocsPerformanceRecorder extends ProcessOpenDocsPerformanceData {
    private volatile long C;

    /* renamed from: h, reason: collision with root package name */
    private volatile long f291496h;

    /* renamed from: i, reason: collision with root package name */
    private volatile long f291497i;

    /* renamed from: f, reason: collision with root package name */
    private volatile String f291495f = ITDocFileBrowserFacade.EngineType.WEB.name();

    /* renamed from: m, reason: collision with root package name */
    private volatile int f291498m = 0;
    private volatile int D = 0;
    private volatile String E = "";
    private volatile int F = 0;
    private volatile int G = 0;
    private volatile int H = 0;
    private volatile int I = 0;
    private volatile int J = 0;

    public String a() {
        return this.f291495f;
    }

    public int b() {
        return this.D;
    }

    public void c() {
        this.f291497i = System.currentTimeMillis();
        this.f291498m = 1;
    }

    public void e(int i3, String str) {
        this.J = 1;
        this.C = System.currentTimeMillis();
        this.D = i3;
        this.E = str;
    }

    public void f(ITDocFileBrowserFacade.EngineType engineType) {
        if (engineType != null) {
            this.f291495f = engineType.name();
        }
    }

    public void g(int i3) {
        this.G = 1;
        this.H = i3;
    }

    public void j() {
        this.I = 1;
    }

    public void k() {
        this.f291496h = System.currentTimeMillis();
    }

    public void l() {
        this.F = 1;
    }

    public Map<String, Object> m() {
        long j3;
        long j16;
        long j17;
        long j18;
        long j19;
        HashMap hashMap = new HashMap();
        if (this.C != 0 && this.f291496h != 0) {
            j3 = this.C - this.f291496h;
        } else {
            j3 = 0;
        }
        if (this.f291497i != 0 && this.f291496h != 0) {
            j16 = this.f291497i - this.f291496h;
        } else {
            j16 = 0;
        }
        if (this.f291499d != 0 && this.f291497i != 0) {
            j17 = this.f291499d - this.f291497i;
        } else {
            j17 = 0;
        }
        long j26 = this.f291500e;
        if (j26 != 0) {
            long j27 = this.f291499d;
            if (j27 != 0) {
                j18 = j26 - j27;
                if (this.C == 0 && this.f291500e != 0) {
                    j19 = this.C - this.f291500e;
                } else {
                    j19 = 0;
                }
                hashMap.put(IPrefRecorder.MILESTONE_AI_ELIMINATE_TOTAL_COST, Long.valueOf(Math.max(j3, 0L)));
                hashMap.put("download_resource_cost", Long.valueOf(Math.max(j16, 0L)));
                hashMap.put("process_create_cost", Long.valueOf(Math.max(j17, 0L)));
                hashMap.put("load_init_cost", Long.valueOf(Math.max(j18, 0L)));
                hashMap.put("load_file_cost", Long.valueOf(Math.max(j19, 0L)));
                hashMap.put(StartupReportKey.ENGINE_TYPE, this.f291495f);
                hashMap.put("download_resource_success", Integer.valueOf(this.f291498m));
                hashMap.put("error_code", Integer.valueOf(this.D));
                hashMap.put("error_msg", this.E);
                hashMap.put(VRReportDefine$ReportParam.IS_TIMEOUT, Integer.valueOf(this.F));
                hashMap.put("is_data_available", Integer.valueOf(this.J));
                hashMap.put("use_web_fallback", Integer.valueOf(this.G));
                hashMap.put("native_engine_error_code", Integer.valueOf(this.H));
                hashMap.put("is_has_password", Integer.valueOf(this.I));
                return hashMap;
            }
        }
        j18 = 0;
        if (this.C == 0) {
        }
        j19 = 0;
        hashMap.put(IPrefRecorder.MILESTONE_AI_ELIMINATE_TOTAL_COST, Long.valueOf(Math.max(j3, 0L)));
        hashMap.put("download_resource_cost", Long.valueOf(Math.max(j16, 0L)));
        hashMap.put("process_create_cost", Long.valueOf(Math.max(j17, 0L)));
        hashMap.put("load_init_cost", Long.valueOf(Math.max(j18, 0L)));
        hashMap.put("load_file_cost", Long.valueOf(Math.max(j19, 0L)));
        hashMap.put(StartupReportKey.ENGINE_TYPE, this.f291495f);
        hashMap.put("download_resource_success", Integer.valueOf(this.f291498m));
        hashMap.put("error_code", Integer.valueOf(this.D));
        hashMap.put("error_msg", this.E);
        hashMap.put(VRReportDefine$ReportParam.IS_TIMEOUT, Integer.valueOf(this.F));
        hashMap.put("is_data_available", Integer.valueOf(this.J));
        hashMap.put("use_web_fallback", Integer.valueOf(this.G));
        hashMap.put("native_engine_error_code", Integer.valueOf(this.H));
        hashMap.put("is_has_password", Integer.valueOf(this.I));
        return hashMap;
    }
}
