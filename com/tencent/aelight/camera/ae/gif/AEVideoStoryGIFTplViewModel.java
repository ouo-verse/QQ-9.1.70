package com.tencent.aelight.camera.ae.gif;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.data.AEGifMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialWrapper;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEVideoStoryGIFTplViewModel extends ViewModel {

    /* renamed from: i, reason: collision with root package name */
    private MutableLiveData<com.tencent.aelight.camera.ae.download.a> f65320i = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name */
    private MutableLiveData<AEMaterialWrapper> f65321m = new MutableLiveData<>();
    private MutableLiveData<String> C = new MutableLiveData<>();
    private MutableLiveData<String> D = new MutableLiveData<>();
    private Map<String, AEGifMaterialManager.b> E = new HashMap();

    public void N1(AEMaterialWrapper aEMaterialWrapper) {
        ms.a.f("AEVideoStoryGIFTplViewModel", "[applyGIFTpl], material=" + aEMaterialWrapper);
        ms.a.f("AEGIFStickerListPart", "[applyGIFTpl], material=" + aEMaterialWrapper);
        this.f65321m.postValue(aEMaterialWrapper);
    }

    public void O1() {
        AEMaterialWrapper value = this.f65321m.getValue();
        ms.a.f("AEVideoStoryGIFTplViewModel", "[applyGIFTplAgain], lastMaterial=" + value);
        this.f65321m.postValue(value);
    }

    public void P1(AEMaterialWrapper aEMaterialWrapper) {
        AEGifMaterialManager.b bVar = new AEGifMaterialManager.b() { // from class: com.tencent.aelight.camera.ae.gif.AEVideoStoryGIFTplViewModel.1
            @Override // com.tencent.aelight.camera.ae.data.AEGifMaterialManager.b
            public void a(final MetaMaterial metaMaterial) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.gif.AEVideoStoryGIFTplViewModel.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AEVideoStoryGIFTplViewModel.this.f65320i.setValue(new com.tencent.aelight.camera.ae.download.a(metaMaterial, 0, 0));
                    }
                });
            }

            @Override // com.tencent.aelight.camera.ae.data.AEGifMaterialManager.b
            public void b(final MetaMaterial metaMaterial) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.gif.AEVideoStoryGIFTplViewModel.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AEVideoStoryGIFTplViewModel.this.f65320i.setValue(new com.tencent.aelight.camera.ae.download.a(metaMaterial, 2, 0));
                    }
                });
            }

            @Override // com.tencent.aelight.camera.ae.data.AEGifMaterialManager.b
            public void c(MetaMaterial metaMaterial, int i3) {
                AEVideoStoryGIFTplViewModel.this.f65320i.postValue(new com.tencent.aelight.camera.ae.download.a(metaMaterial, 1, i3));
            }
        };
        this.E.put(aEMaterialWrapper.f63553a, bVar);
        AEGifMaterialManager.o().l(com.tencent.aelight.camera.aebase.a.a(), aEMaterialWrapper.f63554b, bVar);
    }

    public MutableLiveData<String> Q1() {
        return this.C;
    }

    public MutableLiveData<AEMaterialWrapper> R1() {
        return this.f65321m;
    }

    public MutableLiveData<String> S1() {
        return this.D;
    }

    public MutableLiveData<com.tencent.aelight.camera.ae.download.a> T1() {
        return this.f65320i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.E.clear();
    }

    public void M1(AEMaterialWrapper aEMaterialWrapper) {
        if (aEMaterialWrapper != null) {
            this.C.postValue(aEMaterialWrapper.f63554b.additionalFields.get("savename"));
        } else {
            this.C.postValue(null);
        }
    }
}
