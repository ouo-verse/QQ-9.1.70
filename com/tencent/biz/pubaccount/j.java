package com.tencent.biz.pubaccount;

import com.tencent.image.NativeGifImage;

/* compiled from: P */
/* loaded from: classes4.dex */
public class j extends NativeGifImage {

    /* renamed from: a, reason: collision with root package name */
    private a f79857a;

    /* renamed from: b, reason: collision with root package name */
    private int f79858b;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface a {
        void onPlayFinish();
    }

    public void c() {
        this.f79857a = null;
    }

    public void d(a aVar) {
        this.f79857a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.image.NativeGifImage, com.tencent.image.AbstractGifImage
    public void executeNewTask() {
        if (this.mCurrentLoop == this.f79858b) {
            a aVar = this.f79857a;
            if (aVar != null) {
                aVar.onPlayFinish();
                return;
            }
            return;
        }
        super.executeNewTask();
    }
}
