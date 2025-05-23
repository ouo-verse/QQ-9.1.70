package com.qzone.commoncode.module.gdt;

import com.tencent.gdtad.aditem.GdtAd;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public boolean f46207a;

    /* renamed from: b, reason: collision with root package name */
    public int f46208b;

    /* renamed from: c, reason: collision with root package name */
    public int f46209c;

    /* renamed from: d, reason: collision with root package name */
    public int f46210d;

    public d(GdtAd gdtAd) {
        this.f46207a = false;
        this.f46208b = Integer.MIN_VALUE;
        this.f46209c = Integer.MIN_VALUE;
        this.f46210d = Integer.MIN_VALUE;
        if (gdtAd == null) {
            QZLog.e("GdtVideoPCDNParamsForQZone", "[Data][build] error, ad is null");
            return;
        }
        this.f46207a = gdtAd.isVideoPCDNEnabled();
        this.f46208b = gdtAd.getVideoEmergencyTimeSeconds(Integer.MIN_VALUE);
        this.f46209c = gdtAd.getVideoSafePlayTimeSeconds(Integer.MIN_VALUE);
        this.f46210d = gdtAd.getVideoPreloadDurationSeconds(Integer.MIN_VALUE);
    }

    public boolean a() {
        if (this.f46207a) {
            return this.f46208b > 0 && this.f46209c > 0 && this.f46210d > 0;
        }
        return true;
    }
}
