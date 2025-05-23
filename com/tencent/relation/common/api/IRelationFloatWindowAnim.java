package com.tencent.relation.common.api;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IRelationFloatWindowAnim extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface a {
        void onAnimationEnd();
    }

    void doCircleEnterAnimation(View view, com.tencent.relation.common.window.a aVar);

    void doCircleOuterAnimation(View view, com.tencent.relation.common.window.a aVar, a aVar2);
}
