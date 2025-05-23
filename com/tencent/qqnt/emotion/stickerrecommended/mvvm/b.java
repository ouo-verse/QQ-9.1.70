package com.tencent.qqnt.emotion.stickerrecommended.mvvm;

import com.tencent.aio.data.AIOParam;
import com.tencent.common.app.AppInterface;
import com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.StickerRecKeywordFrom;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface b {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public interface a {
        void a(boolean z16);
    }

    void K0(AppInterface appInterface);

    void O0(String str, String str2, StickerRecKeywordFrom stickerRecKeywordFrom, a aVar);

    void Y0(com.tencent.qqnt.emotion.stickerrecommended.mvvm.data.a aVar);

    void d1(boolean z16);

    void f0(boolean z16);

    void init(AIOParam aIOParam);

    boolean z1(String str, String str2, StickerRecKeywordFrom stickerRecKeywordFrom);
}
