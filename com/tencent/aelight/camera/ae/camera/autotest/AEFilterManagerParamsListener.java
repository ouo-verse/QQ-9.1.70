package com.tencent.aelight.camera.ae.camera.autotest;

import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aelight.camera.ae.camera.autotest.a;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.config.BeautyRealConfig;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.HashMap;

/* loaded from: classes32.dex */
public class AEFilterManagerParamsListener implements a.InterfaceC0535a {

    /* renamed from: a, reason: collision with root package name */
    private AEFilterManager f62203a;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<String, VideoMaterial> f62204b;

    public AEFilterManagerParamsListener(AEFilterManager aEFilterManager) {
        this.f62203a = aEFilterManager;
    }

    @Override // com.tencent.aelight.camera.ae.camera.autotest.a.InterfaceC0535a
    public VideoMaterial b(final String str) {
        if (this.f62204b == null) {
            this.f62204b = new HashMap<>();
        }
        if (this.f62204b.containsKey(str)) {
            return this.f62204b.get(str);
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.autotest.AEFilterManagerParamsListener.1
            @Override // java.lang.Runnable
            public void run() {
                AEFilterManagerParamsListener.this.f62204b.clear();
                HashMap hashMap = AEFilterManagerParamsListener.this.f62204b;
                String str2 = str;
                hashMap.put(str2, VideoMaterial.loadLightAsset(str2));
                QLog.d("AEFilterManagerParamsListener", 4, "Loaded material:" + str);
            }
        }, 64, null, true);
        return null;
    }

    @Override // com.tencent.aelight.camera.ae.camera.autotest.a.InterfaceC0535a
    public void c(String str, int i3) {
        this.f62203a.updateLutGL(str);
        this.f62203a.updateLutAlpha(i3);
    }

    @Override // com.tencent.aelight.camera.ae.camera.autotest.a.InterfaceC0535a
    public void e(VideoMaterial videoMaterial, int i3) {
        this.f62203a.updateMaterialGL(videoMaterial);
        this.f62203a.updateFenGeAlpha(i3);
    }

    @Override // com.tencent.aelight.camera.ae.camera.autotest.a.InterfaceC0535a
    public void h(BeautyRealConfig.TYPE type, int i3) {
        this.f62203a.setBeautyOrTransformLevel(type, i3);
    }

    @Override // com.tencent.aelight.camera.ae.camera.autotest.a.InterfaceC0535a
    public void a(String str, int i3) {
        if (str == null) {
            return;
        }
        this.f62203a.openAndUpdateBasicSoftLight(str, i3);
        this.f62203a.openBeautyEnable(true);
    }

    @Override // com.tencent.aelight.camera.ae.camera.autotest.a.InterfaceC0535a
    public void d(String str, int i3) {
        if (str == null) {
            return;
        }
        this.f62203a.openAndUpdateBasicMultiply(str, i3);
        this.f62203a.openBeautyEnable(true);
    }

    @Override // com.tencent.aelight.camera.ae.camera.autotest.a.InterfaceC0535a
    public void f(String str) {
        if (str == null) {
            return;
        }
        this.f62203a.openFaceThinEnable(str);
    }

    @Override // com.tencent.aelight.camera.ae.camera.autotest.a.InterfaceC0535a
    public void g(String str, int i3, int i16) {
        if (str == null) {
            return;
        }
        this.f62203a.openAndUpdateBasicLips(str, i3, i16);
        this.f62203a.openBeautyEnable(true);
    }
}
