package com.tencent.mobileqq.qwallet.transaction;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.selectmember.ResultRecord;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IToPayManager extends QRouteApi {
    public static final String BROADCAST_PAYER_NOTIFY = "com.tencent.qwallet.payer.notify";
    public static final String KEY_RECOMMEND = "recommend";
    public static final String KEY_TIPS = "tips";

    /* loaded from: classes16.dex */
    public interface a {
        void onRefreshTopayList(boolean z16);
    }

    HashMap<String, Object> getTopayList(a aVar, boolean z16, int i3, int i16);

    void onReceivePayerNotify(BaseQQAppInterface baseQQAppInterface, String str, long j3);

    void removeObserver(AppRuntime appRuntime);

    void topay(AppActivity appActivity, ArrayList<ResultRecord> arrayList);
}
