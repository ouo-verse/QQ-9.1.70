package com.tencent.mobileqq.qqvideoedit.editor;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.qqvideoedit.edit.manager.VideoEditorResourceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class VideoMaterialViewModel extends ViewModel {
    public static final String FRAME = "\u8fb9\u6846";
    private MutableLiveData<xj2.a> mFilterMaterialVOLiveData;
    private Observer<List<MetaCategory>> mFiltersObserver;
    private final boolean mIsImageMode;
    private final int mPhoneLevel;
    private MutableLiveData<xj2.a> mStickerMaterialVOLiveData;
    private Observer<List<MetaCategory>> mStickersObserver;
    private MutableLiveData<xj2.a> mTextMaterialVOLiveData;
    private Observer<List<MetaCategory>> mTextsObserver;
    private Observer<List<MetaCategory>> mVideoTemplatesObserver;
    private MutableLiveData<xj2.a> mVideoTemplatesVOLiveData;
    private final List<MetaCategory> mStickerCategories = new ArrayList();
    private final List<MetaMaterial> mStickerMaterials = new ArrayList();

    public VideoMaterialViewModel(int i3, boolean z16) {
        this.mPhoneLevel = i3;
        this.mIsImageMode = z16;
        initStickersObserver();
        initTextsObserver();
        initVideoTemplatesObserver();
    }

    private void initStickersObserver() {
        this.mStickerMaterialVOLiveData = new MutableLiveData<>();
        this.mStickersObserver = new Observer() { // from class: com.tencent.mobileqq.qqvideoedit.editor.ao
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VideoMaterialViewModel.this.lambda$initStickersObserver$0((List) obj);
            }
        };
        VideoEditorResourceManager.L().P().observeForever(this.mStickersObserver);
    }

    private void initTextsObserver() {
        this.mTextMaterialVOLiveData = new MutableLiveData<>();
        this.mTextsObserver = new Observer() { // from class: com.tencent.mobileqq.qqvideoedit.editor.aq
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VideoMaterialViewModel.this.lambda$initTextsObserver$1((List) obj);
            }
        };
        VideoEditorResourceManager.L().V().observeForever(this.mTextsObserver);
    }

    private void initVideoTemplatesObserver() {
        this.mVideoTemplatesVOLiveData = new MutableLiveData<>();
        this.mVideoTemplatesObserver = new Observer() { // from class: com.tencent.mobileqq.qqvideoedit.editor.ap
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VideoMaterialViewModel.this.lambda$initVideoTemplatesObserver$2((List) obj);
            }
        };
        VideoEditorResourceManager.L().Y().observeForever(this.mVideoTemplatesObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initStickersObserver$0(List list) {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            MetaCategory metaCategory = (MetaCategory) list.get(i3);
            List<MetaMaterial> B = com.tencent.mobileqq.qqvideoedit.editor.sticker.h.B(metaCategory.f30532id, metaCategory.materials);
            int size = B.size() % 4;
            if (size != 0) {
                for (int i16 = 0; i16 < 4 - size; i16++) {
                    B.add(b.r());
                }
            }
            if (i3 > 0) {
                for (int i17 = 0; i17 < B.size(); i17++) {
                    b.v(B.get(i17), metaCategory.f30532id);
                    b.w(B.get(i17), metaCategory.name);
                    MetaMaterial metaMaterial = B.get(i17);
                    if (i17 < 4) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    com.tencent.mobileqq.qqvideoedit.editor.sticker.h.R(metaMaterial, z16);
                }
            }
            arrayList.addAll(B);
        }
        this.mStickerCategories.clear();
        this.mStickerCategories.addAll(list);
        this.mStickerMaterials.clear();
        this.mStickerMaterials.addAll(arrayList);
        this.mStickerMaterialVOLiveData.postValue(new xj2.a(list, arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initTextsObserver$1(List list) {
        this.mTextMaterialVOLiveData.postValue(new xj2.a(list, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initVideoTemplatesObserver$2(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MetaCategory metaCategory = (MetaCategory) it.next();
            ArrayList<MetaMaterial> arrayList2 = metaCategory.materials;
            if (arrayList2 != null) {
                Iterator<MetaMaterial> it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    MetaMaterial next = it5.next();
                    if (next != null) {
                        b.v(next, metaCategory.f30532id);
                        b.u(next, false);
                        b.y(next, false);
                        arrayList.add(next);
                    }
                }
            }
        }
        this.mVideoTemplatesVOLiveData.postValue(new xj2.a(list, arrayList));
    }

    public LiveData<xj2.a> getFilterMaterialVOLiveData() {
        return this.mFilterMaterialVOLiveData;
    }

    public LiveData<xj2.a> getStickerMaterialVOLiveData() {
        return this.mStickerMaterialVOLiveData;
    }

    public LiveData<xj2.a> getTextMaterialVOLiveData() {
        return this.mTextMaterialVOLiveData;
    }

    public LiveData<xj2.a> getVideoTemplatesVOLiveData() {
        return this.mVideoTemplatesVOLiveData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        if (this.mFiltersObserver != null) {
            VideoEditorResourceManager.L().F().removeObserver(this.mFiltersObserver);
        }
        if (this.mStickersObserver != null) {
            VideoEditorResourceManager.L().P().removeObserver(this.mStickersObserver);
        }
        if (this.mTextsObserver != null) {
            VideoEditorResourceManager.L().V().removeObserver(this.mTextsObserver);
        }
        if (this.mVideoTemplatesObserver != null) {
            VideoEditorResourceManager.L().Y().removeObserver(this.mVideoTemplatesObserver);
        }
    }

    public void showAllSticker() {
        this.mStickerMaterialVOLiveData.postValue(new xj2.a(this.mStickerCategories, this.mStickerMaterials));
    }

    public void showStickerWithoutFrame() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (MetaCategory metaCategory : this.mStickerCategories) {
            if (!"\u8fb9\u6846".equals(metaCategory.name)) {
                arrayList.add(metaCategory);
            }
        }
        for (MetaMaterial metaMaterial : this.mStickerMaterials) {
            if (!"\u8fb9\u6846".equals(b.b(metaMaterial))) {
                arrayList2.add(metaMaterial);
            }
        }
        this.mStickerMaterialVOLiveData.postValue(new xj2.a(arrayList, arrayList2));
    }
}
