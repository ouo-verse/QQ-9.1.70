package com.tencent.mobileqq.nearby.api;

import android.annotation.TargetApi;
import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface INearbyAppInterface extends QRouteApi {
    void addManager(int i3, Manager manager);

    void addObserver(BusinessObserver businessObserver);

    void finalize() throws Throwable;

    String getAccount();

    BaseApplication getApp();

    int getAppid();

    MobileQQ getApplication();

    BusinessHandler getBusinessHandler(String str);

    String getCurrentAccountUin();

    String getCurrentNickname();

    EntityManagerFactory getEntityManagerFactory();

    EntityManagerFactory getEntityManagerFactory(String str);

    long getLongAccountUin();

    Manager getManager(int i3);

    MobileQQServiceBase getMobileQQService();

    String getModuleId();

    com.tencent.mobileqq.nearby.ipc.b getNearbyProcManager();

    <T extends IRuntimeService> T getRuntimeService(Class<T> cls, String str);

    int getmPerfState();

    Object getmSelfRespEncounterInfo();

    b getmService();

    boolean isSVip();

    boolean isVip();

    void nearbyReportClickEvent(String str, String str2, String str3, String str4, String str5, int i3, int i16, String str6, String str7, String str8, String str9);

    void onCreate(Bundle bundle);

    void onDestroy();

    void receiveToService(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);

    void removeObserver(BusinessObserver businessObserver);

    void reportClickEventAsync(String str, String str2, String str3, String str4, String str5, int i3, int i16, String str6, String str7, String str8, String str9);

    @TargetApi(14)
    void setTalkbackSwitch();

    void setmPerfState(int i3);

    void setmPreLoadTime(long j3);

    void setmPreloadFrom(int i3);

    void setmSelfRespEncounterInfo(Object obj);

    void setmService(b bVar);

    void start(boolean z16);

    void startServlet(NewIntent newIntent);

    void updatePerfState(int i3, int i16);

    void writeVoteRedDotState(int i3);
}
