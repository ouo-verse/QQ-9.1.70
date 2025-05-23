package com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager;
import com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class StickerRecRepository extends com.tencent.mobileqq.mvvm.a implements IStickerRecManager.ImgUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    private AppInterface f179946a;

    /* renamed from: b, reason: collision with root package name */
    private StickerRecManagerImpl f179947b;

    /* renamed from: c, reason: collision with root package name */
    private d f179948c;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.StickerRecRepository$1, reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ StickerRecRepository this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.f179947b.init();
        }
    }

    public StickerRecManagerImpl l() {
        if (this.f179947b == null) {
            this.f179947b = StickerRecManagerImpl.get(this.f179946a);
        }
        return this.f179947b;
    }

    public void m(d dVar) {
        this.f179948c = dVar;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager.ImgUpdateListener
    public void onImgUpdated(List<IStickerRecEmoticon> list, String str, String str2, int i3, String str3) {
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecRepository", 2, "data=" + list.size());
        }
        final y61.b bVar = new y61.b(list, str, str2, i3, str3);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.StickerRecRepository.2
            @Override // java.lang.Runnable
            public void run() {
                StickerRecRepository.this.f179948c.L1().setValue(bVar);
            }
        });
    }
}
