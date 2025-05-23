package com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.impl.ScenesRecommendManagerImpl;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d extends com.tencent.mobileqq.mvvm.c<StickerRecRepository> implements b, ScenesRecommendManagerImpl.a {
    private MutableLiveData<String> C;
    private p D;
    private long E;
    private boolean F;
    private boolean G;

    /* renamed from: i, reason: collision with root package name */
    private MutableLiveData<y61.b> f179959i;

    /* renamed from: m, reason: collision with root package name */
    private MutableLiveData<y61.a> f179960m;

    public d(StickerRecRepository stickerRecRepository) {
        super(stickerRecRepository);
        this.f179959i = new MutableLiveData<>();
        this.f179960m = new MutableLiveData<>();
        this.C = new MutableLiveData<>();
        this.F = false;
        this.G = false;
    }

    public MutableLiveData<y61.b> L1() {
        return this.f179959i;
    }

    public void M1(boolean z16) {
        this.F = z16;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.impl.ScenesRecommendManagerImpl.a
    public boolean a(String str) {
        p pVar = this.D;
        if (pVar == null) {
            QLog.i("ScenesRecommendManager", 2, "mSessionInfo is null");
            return false;
        }
        String str2 = pVar.f179557e;
        QLog.i("ScenesRecommendManager", 2, "checkUinIsCurrentChat  uin = " + str + " | curUin = " + str2);
        return str2.equalsIgnoreCase(str);
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.impl.ScenesRecommendManagerImpl.a
    public void p0(com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.b bVar) {
        QLog.i("ScenesRecommendManager", 1, "handleScenesRec start");
        if (!((StickerRecRepository) this.mRepository).l().isEmotionRecSettingOpen()) {
            QLog.i("ScenesRecommendManager", 1, "handleScenesRec isEmotionRecSettingOpen = false");
            return;
        }
        this.E = System.currentTimeMillis();
        StickerRecManagerImpl l3 = ((StickerRecRepository) this.mRepository).l();
        p pVar = this.D;
        l3.analyzeForScenesMode(bVar, pVar.f179555d, pVar.f179557e);
    }
}
