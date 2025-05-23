package com.tencent.aelight.camera.ae.gif.giftext.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.data.AEGifMaterialManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEGIFMaterialViewModel extends ViewModel {

    /* renamed from: i, reason: collision with root package name */
    private MutableLiveData<com.tencent.aelight.camera.ae.download.a> f65429i = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name */
    private Map<String, AEGifMaterialManager.b> f65430m = new HashMap();

    public void M1(AppInterface appInterface, rq.a aVar) {
        AEGifMaterialManager.b bVar = new AEGifMaterialManager.b() { // from class: com.tencent.aelight.camera.ae.gif.giftext.viewmodel.AEGIFMaterialViewModel.1
            @Override // com.tencent.aelight.camera.ae.data.AEGifMaterialManager.b
            public void a(final MetaMaterial metaMaterial) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.gif.giftext.viewmodel.AEGIFMaterialViewModel.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AEGIFMaterialViewModel.this.f65429i.setValue(new com.tencent.aelight.camera.ae.download.a(metaMaterial, 0, 0));
                    }
                });
            }

            @Override // com.tencent.aelight.camera.ae.data.AEGifMaterialManager.b
            public void b(final MetaMaterial metaMaterial) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.gif.giftext.viewmodel.AEGIFMaterialViewModel.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AEGIFMaterialViewModel.this.f65429i.setValue(new com.tencent.aelight.camera.ae.download.a(metaMaterial, 2, 0));
                    }
                });
            }

            @Override // com.tencent.aelight.camera.ae.data.AEGifMaterialManager.b
            public void c(MetaMaterial metaMaterial, int i3) {
            }
        };
        this.f65430m.put(aVar.f431893d.f30533id, bVar);
        AEGifMaterialManager.o().l(appInterface, aVar.f431893d, bVar);
    }

    public MutableLiveData<com.tencent.aelight.camera.ae.download.a> N1() {
        return this.f65429i;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.f65430m.clear();
    }
}
