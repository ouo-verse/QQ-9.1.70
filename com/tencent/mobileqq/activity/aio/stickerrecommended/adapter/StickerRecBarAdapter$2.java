package com.tencent.mobileqq.activity.aio.stickerrecommended.adapter;

import com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
class StickerRecBarAdapter$2 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ List f179903d;
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public void run() {
        StickerRecManagerImpl stickerRecManagerImpl = StickerRecManagerImpl.get(a.a(null));
        stickerRecManagerImpl.updateSort(a.b(null));
        stickerRecManagerImpl.updateStickerLastTime(this.f179903d);
    }
}
