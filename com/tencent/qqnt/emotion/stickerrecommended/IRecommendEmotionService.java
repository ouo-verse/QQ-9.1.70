package com.tencent.qqnt.emotion.stickerrecommended;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes24.dex */
public interface IRecommendEmotionService<T> extends QRouteApi {
    void clearSpecWordType(com.tencent.aio.api.runtime.a aVar);

    String getSpecKeyWord(com.tencent.aio.api.runtime.a aVar);

    void onEmotionKeywordDimiss(com.tencent.aio.api.runtime.a aVar);

    void openEmoticonDetailPage(Context context, com.tencent.qqnt.emotion.ipc.b bVar, T t16, int i3);
}
