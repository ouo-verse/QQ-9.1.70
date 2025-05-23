package com.tencent.biz.pubaccount.weishi.api;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import java.util.HashMap;
import java.util.Map;
import sy.a;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes4.dex */
public interface IWSManager extends QRouteApi {
    public static final String IPC_MODULE_NAME = "WSIPCModule";

    boolean doJumpAction(String str, Context context, Map<String, String> map, Object obj);

    void enterTrendsTabWs(Context context, String str, boolean z16, BusinessInfoCheckUpdate.AppInfo appInfo, Intent intent);

    boolean enterWSOperationH5(Context context, HashMap<String, String> hashMap);

    void enterWSPublicAccount(Context context, String str, boolean z16);

    boolean enterWSVerticalPlayerPageForMiniApp(Context context, HashMap<String, String> hashMap);

    QIPCModule getIPCModule();

    void handleArkJump(String str, String str2);

    boolean isBeaconRealtimeSwitchOpen();

    boolean isFastClick();

    void openQQSchema(Context context, String str, Object obj);

    void openWeishi(Context context, String str, String str2);

    void preloadData();

    void sendArkMsg(Bundle bundle, a aVar);

    void setBeaconRealtimeSwitchOpen(boolean z16);

    void setWeishiLastFeedId(String str);
}
