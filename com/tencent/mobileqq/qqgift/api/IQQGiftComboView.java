package com.tencent.mobileqq.qqgift.api;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import nh2.c;
import ph2.b;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQQGiftComboView extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        void onComplete();
    }

    View createView(Context context, c cVar, b bVar);

    void hideAnimation(View view);

    boolean isPagSoReady(Context context);

    void loadPag(Context context, a aVar);

    void removePagloadCallbacks();

    void showAnimation(View view);
}
