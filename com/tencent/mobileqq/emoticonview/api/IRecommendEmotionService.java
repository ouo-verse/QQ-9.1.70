package com.tencent.mobileqq.emoticonview.api;

import a61.b;
import android.content.Context;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes12.dex */
public interface IRecommendEmotionService<T> extends QRouteApi {
    void clearSpecWordType(b bVar);

    String getSpecKeyWord(b bVar);

    void onEmotionKeywordDimiss(b bVar);

    void openEmoticonDetailPage(Context context, IEmoticonMainPanelApp iEmoticonMainPanelApp, T t16, int i3);
}
