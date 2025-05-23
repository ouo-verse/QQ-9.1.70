package com.tencent.smtt.utils.recorder;

import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import java.util.HashMap;

/* loaded from: classes25.dex */
public class TbsWebViewPerformanceRecorder {

    /* renamed from: a, reason: collision with root package name */
    private long f369799a = 0;

    /* renamed from: b, reason: collision with root package name */
    private long f369800b = 0;

    /* renamed from: c, reason: collision with root package name */
    private long f369801c = 0;

    /* renamed from: d, reason: collision with root package name */
    private long f369802d = 0;

    /* renamed from: e, reason: collision with root package name */
    private long f369803e = 0;

    /* renamed from: f, reason: collision with root package name */
    private IX5WebViewBase f369804f = null;

    /* renamed from: g, reason: collision with root package name */
    private String f369805g = "unknown";

    public long getAverageUrlLoadTime() {
        long j3 = this.f369801c;
        if (j3 == 0) {
            return 0L;
        }
        return this.f369802d / j3;
    }

    public long getConstructTime() {
        return this.f369799a;
    }

    public long getCoreInitTime() {
        return this.f369800b;
    }

    public String getCurrentUrl() {
        return this.f369805g;
    }

    public long getCurrentUrlLoadTime() {
        return this.f369803e;
    }

    public String getLog() {
        return "TbsWebViewPerformanceRecorder{constructTime=" + this.f369799a + ", coreInitTime=" + this.f369800b + ", currentUrlLoadTime=" + this.f369803e + ", currentUrl='" + this.f369805g + "'}";
    }

    public HashMap<String, String> getX5WebviewPerformance() {
        try {
            IX5WebViewBase iX5WebViewBase = this.f369804f;
            if (iX5WebViewBase != null && iX5WebViewBase.getX5WebViewExtension() != null) {
                return this.f369804f.getX5WebViewExtension().getPerformanceDataByForce();
            }
        } catch (Throwable unused) {
        }
        return new HashMap<>();
    }

    public void recordCoreInitTime(long j3) {
        this.f369800b = j3;
    }

    public void recordUrlLoadTime(long j3, String str) {
        this.f369802d += j3;
        this.f369801c++;
        this.f369803e = j3;
        this.f369805g = str;
    }

    public void recordWebViewConstruct(long j3) {
        this.f369799a = j3;
    }

    public void setX5Webview(IX5WebViewBase iX5WebViewBase) {
        this.f369804f = iX5WebViewBase;
    }
}
