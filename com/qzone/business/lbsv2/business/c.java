package com.qzone.business.lbsv2.business;

import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.util.QZLog;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c implements b {

    /* renamed from: c, reason: collision with root package name */
    private static String f44575c;

    /* renamed from: a, reason: collision with root package name */
    private b f44577a;

    /* renamed from: b, reason: collision with root package name */
    private static Object f44574b = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static ConcurrentHashMap<String, c> f44576d = new ConcurrentHashMap<>();

    c(String str) {
        f44575c = str;
        this.f44577a = QZoneNewJustLocation.h(str);
    }

    public static c g(String str) {
        c cVar = f44576d.get(str);
        if (cVar == null) {
            synchronized (f44574b) {
                cVar = f44576d.get(str);
                if (cVar == null) {
                    cVar = new c(str);
                    f44576d.put(str, cVar);
                }
            }
        }
        return cVar;
    }

    @Override // com.qzone.business.lbsv2.business.b
    public LbsDataV2.GpsInfo a() {
        return this.f44577a.a();
    }

    @Override // com.qzone.business.lbsv2.business.b
    public double b() {
        return this.f44577a.b();
    }

    @Override // com.qzone.business.lbsv2.business.b
    public LbsDataV2.GpsInfo c() {
        return this.f44577a.c();
    }

    @Override // com.qzone.business.lbsv2.business.b
    public double d() {
        return this.f44577a.d();
    }

    @Override // com.qzone.business.lbsv2.business.b
    public LbsDataV2.PoiInfo e() {
        return this.f44577a.e();
    }

    @Override // com.qzone.business.lbsv2.business.b
    public void f() {
        try {
            if (BaseApplication.getContext() != null && BaseApplication.getContext().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
                QZLog.w(QZLog.TO_DEVICE_TAG, "\u5b9a\u4f4d\u6709\u7248\u672c\u6216\u6743\u9650\u9650\u5236");
            } else {
                this.f44577a.f();
            }
        } catch (Throwable th5) {
            QZLog.e(QZLog.TO_DEVICE_TAG, "\u53d1\u8d77\u5b9a\u4f4d\u5931\u8d25", th5);
        }
    }
}
