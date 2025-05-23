package com.tencent.aelight.camera.ae.camera.filter;

import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.ttpic.openapi.config.BeautyRealConfig;
import com.tencent.ttpic.openapi.offlineset.AEOfflineConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.light.WatermarkConfig;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f62275a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f62276b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f62277c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f62278d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f62279e;

    /* renamed from: g, reason: collision with root package name */
    private List<AEResInfo> f62281g;

    /* renamed from: f, reason: collision with root package name */
    private final Map<BeautyRealConfig.TYPE, Integer> f62280f = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    private WatermarkConfig f62282h = null;

    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.ae.camera.filter.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public static class C0536a {
        public static a a() {
            return b("defaultBeautyV7.json");
        }

        public static a b(String str) {
            a aVar = new a();
            aVar.f62275a = str;
            aVar.f62276b = false;
            aVar.f62277c = true;
            aVar.f62278d = true;
            aVar.f62279e = false;
            if (AEOfflineConfig.getPhonePerfLevel() < 3) {
                aVar.f62280f.put(BeautyRealConfig.TYPE.FACE_FEATURE_LIPS_LUT_ALPHA, 0);
                aVar.f62280f.put(BeautyRealConfig.TYPE.REMOVE_POUNCH, 0);
                aVar.f62280f.put(BeautyRealConfig.TYPE.FACE_FEATURE_REDCHEEK, 0);
                aVar.f62280f.put(BeautyRealConfig.TYPE.FACE_FEATURE_SOFT, 0);
                aVar.f62280f.put(BeautyRealConfig.TYPE.TOOTH_WHITEN, 0);
                aVar.f62280f.put(BeautyRealConfig.TYPE.REMOVE_WRINKLES2, 0);
            }
            aVar.g();
            return aVar;
        }

        public static a c() {
            a aVar = new a();
            aVar.f62275a = "defaultBeautyV6.json";
            aVar.f62276b = false;
            aVar.f62277c = false;
            aVar.f62278d = false;
            aVar.f62279e = true;
            aVar.f62280f.put(BeautyRealConfig.TYPE.EYE_LIGHTEN, 35);
            aVar.f62280f.put(BeautyRealConfig.TYPE.REMOVE_POUNCH, 40);
            aVar.f62280f.put(BeautyRealConfig.TYPE.COLOR_TONE, 50);
            return aVar;
        }
    }

    a() {
    }

    private void h() {
        if (this.f62281g == null) {
            this.f62281g = new ArrayList();
        }
    }

    public void g() {
        if (p()) {
            h();
            this.f62281g.add(AEResInfo.LIGHT_RES_BUNDLE_FACE_STATIC_FEATURE);
        }
        if (o()) {
            h();
            this.f62281g.add(AEResInfo.LIGHT_RES_BUNDLE_BODY);
        }
    }

    public Map<BeautyRealConfig.TYPE, Integer> i() {
        return Collections.unmodifiableMap(this.f62280f);
    }

    public List<AEResInfo> j() {
        return this.f62281g;
    }

    public String k() {
        String str = this.f62275a;
        return str == null ? "defaultBeautyV6.json" : str;
    }

    public WatermarkConfig l() {
        return this.f62282h;
    }

    public boolean m() {
        return this.f62276b;
    }

    public boolean n() {
        return this.f62279e;
    }

    public boolean o() {
        return this.f62278d;
    }

    public boolean p() {
        return this.f62277c;
    }

    public void q(WatermarkConfig watermarkConfig) {
        this.f62282h = watermarkConfig;
    }
}
