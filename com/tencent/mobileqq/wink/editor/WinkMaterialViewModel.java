package com.tencent.mobileqq.wink.editor;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import com.tencent.videocut.model.Size;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkMaterialViewModel extends ViewModel {
    public static final String FRAME = "\u8fb9\u6846";
    public static final String RECOMMEND_METACATEGORY = "recommend";
    private static final String TAG = "WinkMaterialViewModel";
    public static final String UNCATEGORIZED_METACATEGORY = "uncategorized";
    public static final String WATERMARK_CAT_ID = "1000300";
    private Observer<List<MetaCategory>> mEffectsObserver;
    private Observer<List<MetaCategory>> mFiltersObserver;
    private Observer<List<MetaCategory>> mLyricStickersObserver;
    private Observer<List<MetaCategory>> mStickersObserver;
    private Observer<List<MetaCategory>> mStickersWithQQEmoticonObserver;
    private Observer<List<MetaCategory>> mTemplatesObserver;
    private Observer<List<MetaCategory>> mTextsObserver;
    private Observer<List<MetaCategory>> mVideoFirstTemplatesObserver;
    private MutableLiveData<com.tencent.mobileqq.wink.editor.model.b> mFilterMaterialVOLiveData = new MutableLiveData<>();
    private MutableLiveData<com.tencent.mobileqq.wink.editor.model.b> mStickerMaterialVOLiveData = new MutableLiveData<>();
    private MutableLiveData<com.tencent.mobileqq.wink.editor.model.b> mStickerWithQQEmoticonMaterialVOLiveData = new MutableLiveData<>();
    private MutableLiveData<com.tencent.mobileqq.wink.editor.model.b> mLyricStickerMaterialVOLiveData = new MutableLiveData<>();
    private MutableLiveData<com.tencent.mobileqq.wink.editor.model.b> mTextMaterialVOLiveData = new MutableLiveData<>();
    private MutableLiveData<com.tencent.mobileqq.wink.editor.model.b> mEffectMaterialVOLiveData = new MutableLiveData<>();
    private MutableLiveData<com.tencent.mobileqq.wink.editor.model.b> mTemplatesLiveData = new MutableLiveData<>();
    private MutableLiveData<com.tencent.mobileqq.wink.editor.model.b> mVideoFirstTemplatesVOLiveData = new MutableLiveData<>();
    private final List<MetaCategory> mStickerCategories = new ArrayList();
    private final List<MetaMaterial> mStickerMaterials = new ArrayList();
    private final HashMap<String, com.tencent.mobileqq.wink.editor.model.b> mWinkMaterialVOHashMap = new HashMap<>();
    private final ArrayList<String> allBottomPanelRhythmTypes = new ArrayList<>();
    private String bottomPanelSelectRhythmType = AECameraPrefsUtil.f318480r;
    public boolean isSwitchType = false;

    public WinkMaterialViewModel() {
        buildCategory();
    }

    private void addCategoryToAllVOMap(List<MetaCategory> list) {
        Iterator<String> it = getAllBottomPanelRhythmTypes().iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.wink.editor.model.b bVar = this.mWinkMaterialVOHashMap.get(it.next());
            if (bVar != null) {
                for (MetaCategory metaCategory : list) {
                    Iterator<MetaMaterial> it5 = bVar.b().iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        } else if (c.o(it5.next()).equals(metaCategory.f30532id)) {
                            if (!bVar.a().contains(metaCategory)) {
                                bVar.a().add(metaCategory);
                            }
                        }
                    }
                }
            }
        }
    }

    private void addInvisibleToAllVOMap(List<MetaMaterial> list) {
        for (MetaMaterial metaMaterial : list) {
            Iterator<String> it = getAllBottomPanelRhythmTypes().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                com.tencent.mobileqq.wink.editor.model.b bVar = this.mWinkMaterialVOHashMap.get(next);
                if (bVar != null && next != null) {
                    if (next.equals(c.l0(metaMaterial))) {
                        bVar.c().add(metaMaterial);
                        break;
                    } else if (next.equals(AECameraPrefsUtil.f318480r)) {
                        bVar.c().add(metaMaterial);
                    }
                }
            }
        }
    }

    private void addMaterialToAllVOMap(MetaMaterial metaMaterial) {
        Iterator<String> it = getAllBottomPanelRhythmTypes().iterator();
        while (it.hasNext()) {
            String next = it.next();
            com.tencent.mobileqq.wink.editor.model.b bVar = this.mWinkMaterialVOHashMap.get(next);
            if (bVar != null && next != null) {
                if (next.equals(c.l0(metaMaterial))) {
                    bVar.b().add(metaMaterial);
                    return;
                } else if (next.equals(AECameraPrefsUtil.f318480r)) {
                    bVar.b().add(metaMaterial);
                }
            }
        }
    }

    private void buildCategory() {
        initFiltersObserver();
        initStickersWithoutModifyObserver();
        initStickersObserver();
        initTextsObserver();
        initEffectsObserver();
        initFirstTemplatesObserver();
        initLyricStickerObserver();
    }

    private void buildMaterialVOMap(List<MetaCategory> list) {
        this.allBottomPanelRhythmTypes.clear();
        ArrayList<String> R1 = WinkEditorResourceManager.a1().R1();
        if (R1 != null) {
            this.allBottomPanelRhythmTypes.addAll(R1);
        }
        this.mWinkMaterialVOHashMap.clear();
        Iterator<String> it = getAllBottomPanelRhythmTypes().iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!this.mWinkMaterialVOHashMap.containsKey(next)) {
                this.mWinkMaterialVOHashMap.put(next, new com.tencent.mobileqq.wink.editor.model.b(new ArrayList(), new ArrayList(), new ArrayList()));
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (MetaCategory metaCategory : list) {
            if (metaCategory.f30532id.equals(UNCATEGORIZED_METACATEGORY)) {
                addInvisibleToAllVOMap(metaCategory.materials);
            } else {
                arrayList.add(metaCategory);
            }
        }
        for (MetaCategory metaCategory2 : arrayList) {
            ArrayList<MetaMaterial> arrayList4 = metaCategory2.materials;
            if (arrayList4 != null) {
                Iterator<MetaMaterial> it5 = arrayList4.iterator();
                while (it5.hasNext()) {
                    MetaMaterial next2 = it5.next();
                    if (next2 != null) {
                        c.o1(next2, metaCategory2.f30532id);
                        c.p1(next2, metaCategory2.name);
                        boolean z16 = false;
                        c.n1(next2, false);
                        c.G1(next2, false);
                        if ("recommend".equals(metaCategory2.f30532id)) {
                            addMaterialToAllVOMap(next2);
                            arrayList3.add(next2);
                        } else {
                            Iterator it6 = arrayList3.iterator();
                            while (it6.hasNext()) {
                                if (next2.f30533id.equals(((MetaMaterial) it6.next()).f30533id)) {
                                    arrayList2.add(next2);
                                    z16 = true;
                                }
                            }
                            if (!z16) {
                                addMaterialToAllVOMap(next2);
                            }
                        }
                    }
                }
                if (arrayList2.size() > 0) {
                    addMaterialToAllVOMap(arrayList2);
                    arrayList2.clear();
                }
            }
        }
        addCategoryToAllVOMap(arrayList);
    }

    private void initEffectsObserver() {
        this.mEffectsObserver = new Observer() { // from class: com.tencent.mobileqq.wink.editor.di
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkMaterialViewModel.this.lambda$initEffectsObserver$5((List) obj);
            }
        };
        WinkEditorResourceManager.a1().N0().observeForever(this.mEffectsObserver);
    }

    private void initFiltersObserver() {
        this.mFiltersObserver = new Observer() { // from class: com.tencent.mobileqq.wink.editor.dl
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkMaterialViewModel.this.lambda$initFiltersObserver$0((List) obj);
            }
        };
        WinkEditorResourceManager.a1().Q0().observeForever(this.mFiltersObserver);
    }

    private void initFirstTemplatesObserver() {
        this.mVideoFirstTemplatesObserver = new Observer() { // from class: com.tencent.mobileqq.wink.editor.dm
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkMaterialViewModel.this.lambda$initFirstTemplatesObserver$8((List) obj);
            }
        };
        WinkEditorResourceManager.a1().S0().observeForever(this.mVideoFirstTemplatesObserver);
    }

    private void initLyricStickerObserver() {
        if (this.mLyricStickersObserver == null) {
            this.mLyricStickersObserver = new Observer() { // from class: com.tencent.mobileqq.wink.editor.dk
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkMaterialViewModel.this.lambda$initLyricStickerObserver$1((List) obj);
                }
            };
        }
        WinkEditorResourceManager.a1().h1().observeForever(this.mLyricStickersObserver);
        ms.a.f(TAG, "init and register mLyricStickersObserver");
    }

    private void initMaterials(List<MetaCategory> list) {
        if (list != null && !list.isEmpty()) {
            for (MetaCategory metaCategory : list) {
                com.tencent.mobileqq.wink.editor.sticker.m.L(metaCategory.f30532id, metaCategory.materials);
                initMaterials(metaCategory.subCategories);
            }
        }
    }

    private void initQzoneImageTemplatesObserver() {
        this.mTemplatesObserver = new Observer() { // from class: com.tencent.mobileqq.wink.editor.dn
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkMaterialViewModel.this.lambda$initQzoneImageTemplatesObserver$7((List) obj);
            }
        };
        WinkEditorResourceManager.a1().A1().observeForever(this.mTemplatesObserver);
    }

    private void initStickersObserver() {
        if (this.mStickersObserver == null) {
            this.mStickersObserver = new Observer() { // from class: com.tencent.mobileqq.wink.editor.do
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkMaterialViewModel.this.lambda$initStickersObserver$2((List) obj);
                }
            };
        }
        WinkEditorResourceManager.a1().I1().observeForever(this.mStickersObserver);
        ms.a.f(TAG, "init and register sticker");
    }

    private void initStickersWithoutModifyObserver() {
        if (this.mStickersWithQQEmoticonObserver == null) {
            this.mStickersWithQQEmoticonObserver = new Observer() { // from class: com.tencent.mobileqq.wink.editor.dj
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkMaterialViewModel.this.lambda$initStickersWithoutModifyObserver$3((List) obj);
                }
            };
        }
        WinkEditorResourceManager.a1().J1().observeForever(this.mStickersWithQQEmoticonObserver);
        ms.a.f(TAG, "init and register sticker");
    }

    private void initTextsObserver() {
        if (this.mTextsObserver == null) {
            this.mTextsObserver = new Observer() { // from class: com.tencent.mobileqq.wink.editor.dp
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkMaterialViewModel.this.lambda$initTextsObserver$4((List) obj);
                }
            };
        }
        WinkEditorResourceManager.a1().X1().observeForever(this.mTextsObserver);
    }

    private void initVideoTemplatesObserver() {
        this.mTemplatesObserver = new Observer() { // from class: com.tencent.mobileqq.wink.editor.dq
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkMaterialViewModel.this.lambda$initVideoTemplatesObserver$6((List) obj);
            }
        };
        WinkEditorResourceManager.a1().h2().observeForever(this.mTemplatesObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initEffectsObserver$5(List list) {
        this.mEffectMaterialVOLiveData.postValue(new com.tencent.mobileqq.wink.editor.model.b(list, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initFiltersObserver$0(List list) {
        ArrayList arrayList = new ArrayList();
        this.mFilterMaterialVOLiveData.postValue(new com.tencent.mobileqq.wink.editor.model.b(new ArrayList(list), arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initFirstTemplatesObserver$8(List list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            arrayList.addAll(((MetaCategory) list.get(0)).materials);
        }
        this.mVideoFirstTemplatesVOLiveData.postValue(new com.tencent.mobileqq.wink.editor.model.b(list, arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initLyricStickerObserver$1(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            arrayList.addAll(((MetaCategory) list.get(i3)).materials);
        }
        this.mLyricStickerMaterialVOLiveData.postValue(new com.tencent.mobileqq.wink.editor.model.b(list, arrayList));
        ms.a.f(TAG, "initStickersObserver:" + list.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initQzoneImageTemplatesObserver$7(List list) {
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            MetaCategory metaCategory = (MetaCategory) it.next();
            if (metaCategory.f30532id.equals(HippyQQConstants.HIPPY_CHANNEL)) {
                buildMaterialVOMap(metaCategory.subCategories);
                break;
            }
        }
        this.mTemplatesLiveData.postValue(this.mWinkMaterialVOHashMap.get(AECameraPrefsUtil.f318480r));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initStickersObserver$2(List list) {
        ms.a.f(TAG, "initStickersObserver:" + list.size());
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            MetaCategory metaCategory = (MetaCategory) list.get(i3);
            arrayList.addAll(com.tencent.mobileqq.wink.editor.sticker.m.L(metaCategory.f30532id, metaCategory.materials));
        }
        this.mStickerCategories.clear();
        this.mStickerCategories.addAll(list);
        this.mStickerMaterials.clear();
        this.mStickerMaterials.addAll(arrayList);
        this.mStickerMaterialVOLiveData.postValue(new com.tencent.mobileqq.wink.editor.model.b(list, addPlaceHolder(list)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initStickersWithoutModifyObserver$3(List list) {
        ms.a.f(TAG, "initStickersWithoutModifyObserver:" + list.size());
        initMaterials(list);
        this.mStickerWithQQEmoticonMaterialVOLiveData.postValue(new com.tencent.mobileqq.wink.editor.model.b(new ArrayList(list), Collections.emptyList()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initTextsObserver$4(List list) {
        this.mTextMaterialVOLiveData.postValue(new com.tencent.mobileqq.wink.editor.model.b(list, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initVideoTemplatesObserver$6(List list) {
        buildMaterialVOMap(list);
        this.mTemplatesLiveData.postValue(this.mWinkMaterialVOHashMap.get(this.bottomPanelSelectRhythmType));
    }

    public List<MetaMaterial> addPlaceHolder(List<MetaCategory> list) {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            MetaCategory metaCategory = list.get(i3);
            List<MetaMaterial> L = com.tencent.mobileqq.wink.editor.sticker.m.L(metaCategory.f30532id, metaCategory.materials);
            int size = L.size() % 4;
            if (size != 0) {
                for (int i16 = 0; i16 < 4 - size; i16++) {
                    L.add(c.f1());
                }
            }
            if (i3 > 0) {
                for (int i17 = 0; i17 < L.size(); i17++) {
                    c.o1(L.get(i17), metaCategory.f30532id);
                    c.p1(L.get(i17), metaCategory.name);
                    MetaMaterial metaMaterial = L.get(i17);
                    if (i17 < 4) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    com.tencent.mobileqq.wink.editor.sticker.m.s0(metaMaterial, z16);
                }
            }
            arrayList.addAll(L);
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void filterSticker(Size size, Size size2, boolean z16) {
        boolean z17;
        Iterator<MetaCategory> it;
        if (size.height.intValue() != 0) {
            float intValue = ((size2.height.intValue() - size.height.intValue()) * 1.0f) / size.height.intValue();
            QzoneConfig.getInstance();
            if (intValue > QzoneConfig.getWinkEditorFrameStickerThreshold() * 2.0f) {
                z17 = true;
                boolean z18 = !z16;
                w53.b.f(TAG, "filterSticker: filterFrameSticker = " + z17 + ", filterWatermarkSticker = " + z18);
                ArrayList arrayList = new ArrayList();
                it = this.mStickerCategories.iterator();
                while (it.hasNext()) {
                    MetaCategory c16 = c.c(it.next());
                    if (!z17 || !"\u8fb9\u6846".equals(c16.name)) {
                        if (!z18 || !WATERMARK_CAT_ID.equals(c16.f30532id)) {
                            arrayList.add(c16);
                            List<MetaMaterial> L = com.tencent.mobileqq.wink.editor.sticker.m.L(c16.f30532id, c16.materials);
                            ArrayList<MetaMaterial> arrayList2 = new ArrayList<>();
                            for (MetaMaterial metaMaterial : L) {
                                if (!z17 || !"\u8fb9\u6846".equals(c.p(metaMaterial))) {
                                    if (!z18 || !WATERMARK_CAT_ID.equals(c.o(metaMaterial))) {
                                        if (!z18 || !com.tencent.mobileqq.wink.editor.sticker.m.Y(metaMaterial)) {
                                            arrayList2.add(metaMaterial);
                                        }
                                    }
                                }
                            }
                            c16.materials = arrayList2;
                        }
                    }
                }
                this.mStickerMaterialVOLiveData.postValue(new com.tencent.mobileqq.wink.editor.model.b(arrayList, addPlaceHolder(arrayList)));
            }
        }
        z17 = false;
        boolean z182 = !z16;
        w53.b.f(TAG, "filterSticker: filterFrameSticker = " + z17 + ", filterWatermarkSticker = " + z182);
        ArrayList arrayList3 = new ArrayList();
        it = this.mStickerCategories.iterator();
        while (it.hasNext()) {
        }
        this.mStickerMaterialVOLiveData.postValue(new com.tencent.mobileqq.wink.editor.model.b(arrayList3, addPlaceHolder(arrayList3)));
    }

    public ArrayList<String> getAllBottomPanelRhythmTypes() {
        return this.allBottomPanelRhythmTypes;
    }

    public String getBottomPanelSelectRhythmType() {
        return this.bottomPanelSelectRhythmType;
    }

    public LiveData<com.tencent.mobileqq.wink.editor.model.b> getEffectMaterialVOLiveData() {
        return this.mEffectMaterialVOLiveData;
    }

    public LiveData<com.tencent.mobileqq.wink.editor.model.b> getFilterMaterialVOLiveData() {
        return this.mFilterMaterialVOLiveData;
    }

    public LiveData<com.tencent.mobileqq.wink.editor.model.b> getFirstTemplatesVOLiveData() {
        return this.mVideoFirstTemplatesVOLiveData;
    }

    public LiveData<com.tencent.mobileqq.wink.editor.model.b> getLyricStickerMaterialVOLiveData() {
        return this.mLyricStickerMaterialVOLiveData;
    }

    public LiveData<com.tencent.mobileqq.wink.editor.model.b> getStickerMaterialVOLiveData() {
        return this.mStickerMaterialVOLiveData;
    }

    public LiveData<com.tencent.mobileqq.wink.editor.model.b> getStickerWithQQEmoticonMaterialVOLiveData() {
        return this.mStickerWithQQEmoticonMaterialVOLiveData;
    }

    public LiveData<com.tencent.mobileqq.wink.editor.model.b> getTemplatesLiveData() {
        return this.mTemplatesLiveData;
    }

    public LiveData<com.tencent.mobileqq.wink.editor.model.b> getTextMaterialVOLiveData() {
        return this.mTextMaterialVOLiveData;
    }

    public com.tencent.mobileqq.wink.editor.model.b getWinkMaterialVOByTypes(String str) {
        return this.mWinkMaterialVOHashMap.get(str);
    }

    public void initTemplateObserver(boolean z16) {
        if (z16) {
            initQzoneImageTemplatesObserver();
        } else {
            initVideoTemplatesObserver();
        }
    }

    public void onBottomPanelTabRhythmSwitch(String str) {
        if (getAllBottomPanelRhythmTypes().contains(str)) {
            this.isSwitchType = true;
            com.tencent.mobileqq.wink.editor.model.b bVar = this.mWinkMaterialVOHashMap.get(str);
            if (bVar != null) {
                this.bottomPanelSelectRhythmType = str;
                this.mTemplatesLiveData.postValue(bVar);
                return;
            }
            MutableLiveData<List<MetaCategory>> h26 = WinkEditorResourceManager.a1().h2();
            if (h26 != null && h26.getValue() != null) {
                buildMaterialVOMap(h26.getValue());
                com.tencent.mobileqq.wink.editor.model.b bVar2 = this.mWinkMaterialVOHashMap.get(str);
                if (bVar2 != null) {
                    this.bottomPanelSelectRhythmType = str;
                    this.mTemplatesLiveData.postValue(bVar2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        if (this.mFiltersObserver != null) {
            WinkEditorResourceManager.a1().Q0().removeObserver(this.mFiltersObserver);
        }
        if (this.mStickersObserver != null) {
            WinkEditorResourceManager.a1().I1().removeObserver(this.mStickersObserver);
        }
        if (this.mStickersWithQQEmoticonObserver != null) {
            WinkEditorResourceManager.a1().J1().removeObserver(this.mStickersWithQQEmoticonObserver);
        }
        if (this.mTextsObserver != null) {
            WinkEditorResourceManager.a1().X1().removeObserver(this.mTextsObserver);
        }
        if (this.mEffectsObserver != null) {
            WinkEditorResourceManager.a1().N0().removeObserver(this.mEffectsObserver);
        }
        if (this.mTemplatesObserver != null) {
            WinkEditorResourceManager.a1().h2().removeObserver(this.mTemplatesObserver);
        }
        if (this.mVideoFirstTemplatesObserver != null) {
            WinkEditorResourceManager.a1().S0().removeObserver(this.mVideoFirstTemplatesObserver);
        }
        if (this.mLyricStickersObserver != null) {
            WinkEditorResourceManager.a1().h1().removeObserver(this.mLyricStickersObserver);
        }
    }

    private void addMaterialToAllVOMap(List<MetaMaterial> list) {
        Iterator<MetaMaterial> it = list.iterator();
        while (it.hasNext()) {
            addMaterialToAllVOMap(it.next());
        }
    }
}
