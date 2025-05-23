package com.tencent.midas.api;

import com.tencent.midas.api.request.APIabResult;
import com.tencent.midas.api.request.APPurchase;

/* loaded from: classes9.dex */
public interface APOnIabPurchaseFinished {
    void onIabPurchaseFinished(APIabResult aPIabResult, APPurchase aPPurchase);

    void onIabyNeedLogin();
}
