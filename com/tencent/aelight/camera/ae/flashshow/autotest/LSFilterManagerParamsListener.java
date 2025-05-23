package com.tencent.aelight.camera.ae.flashshow.autotest;

import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aelight.camera.ae.flashshow.autotest.a;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.config.BeautyRealConfig;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.HashMap;

/* loaded from: classes32.dex */
public class LSFilterManagerParamsListener implements a.InterfaceC0552a {

    /* renamed from: a, reason: collision with root package name */
    private AEFilterManager f64133a;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<String, VideoMaterial> f64134b;

    public LSFilterManagerParamsListener(AEFilterManager aEFilterManager) {
        this.f64133a = aEFilterManager;
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.autotest.a.InterfaceC0552a
    public VideoMaterial b(final String str) {
        if (this.f64134b == null) {
            this.f64134b = new HashMap<>();
        }
        if (this.f64134b.containsKey(str)) {
            return this.f64134b.get(str);
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.autotest.LSFilterManagerParamsListener.1
            @Override // java.lang.Runnable
            public void run() {
                LSFilterManagerParamsListener.this.f64134b.clear();
                HashMap hashMap = LSFilterManagerParamsListener.this.f64134b;
                String str2 = str;
                hashMap.put(str2, VideoMaterial.loadLightAsset(str2));
                QLog.d("LSFilterManagerParamsListener", 4, "Loaded material:" + str);
            }
        }, 64, null, true);
        return null;
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.autotest.a.InterfaceC0552a
    public void c(String str, int i3) {
        this.f64133a.updateLutGL(str);
        this.f64133a.updateLutAlpha(i3);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.autotest.a.InterfaceC0552a
    public void e(VideoMaterial videoMaterial, int i3) {
        this.f64133a.updateMaterialGL(videoMaterial);
        this.f64133a.updateFenGeAlpha(i3);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.autotest.a.InterfaceC0552a
    public void h(BeautyRealConfig.TYPE type, int i3) {
        this.f64133a.setBeautyOrTransformLevel(type, i3);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.autotest.a.InterfaceC0552a
    public void a(String str, int i3) {
        if (str == null) {
            return;
        }
        this.f64133a.openAndUpdateBasicSoftLight(str, i3);
        this.f64133a.openBeautyEnable(true);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.autotest.a.InterfaceC0552a
    public void d(String str, int i3) {
        if (str == null) {
            return;
        }
        this.f64133a.openAndUpdateBasicMultiply(str, i3);
        this.f64133a.openBeautyEnable(true);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.autotest.a.InterfaceC0552a
    public void f(String str) {
        if (str == null) {
            return;
        }
        this.f64133a.openFaceThinEnable(str);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.autotest.a.InterfaceC0552a
    public void g(String str, int i3, int i16) {
        if (str == null) {
            return;
        }
        this.f64133a.openAndUpdateBasicLips(str, i3, i16);
        this.f64133a.openBeautyEnable(true);
    }
}
