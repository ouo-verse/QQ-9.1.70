package com.tencent.gdtad.basics.adbox;

import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public String f108694a;

    /* renamed from: b, reason: collision with root package name */
    public String f108695b;

    /* renamed from: c, reason: collision with root package name */
    public String f108696c;

    /* renamed from: d, reason: collision with root package name */
    public String f108697d;

    /* renamed from: e, reason: collision with root package name */
    public GdtAd f108698e;

    public e(GdtAd gdtAd) {
        if (gdtAd != null && gdtAd.info != null) {
            this.f108698e = gdtAd;
            c();
        }
    }

    private String a(qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo displayInfo) {
        if (displayInfo == null) {
            return "";
        }
        String trim = displayInfo.basic_info.txt.get().trim();
        if (!TextUtils.isEmpty(trim)) {
            return trim;
        }
        return displayInfo.basic_info.desc.get().trim();
    }

    private void c() {
        String traceId = this.f108698e.getTraceId();
        long aId = this.f108698e.getAId();
        qq_ad_get.QQAdGetRsp.AdInfo adInfo = this.f108698e.info;
        if (adInfo == null) {
            this.f108697d = traceId + aId;
            return;
        }
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo displayInfo = adInfo.display_info;
        this.f108694a = displayInfo.basic_info.img.get();
        this.f108695b = displayInfo.mini_program_name.get().trim();
        this.f108696c = a(displayInfo);
        this.f108697d = this.f108695b + aId + traceId;
    }

    public boolean b() {
        if (this.f108698e != null && !TextUtils.isEmpty(this.f108694a)) {
            return true;
        }
        return false;
    }
}
