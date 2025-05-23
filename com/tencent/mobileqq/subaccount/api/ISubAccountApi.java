package com.tencent.mobileqq.subaccount.api;

import QQService.BindUin;
import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.ServerConfigManager;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISubAccountApi extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        void a(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface b {
        void a(String str, boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface c {
        void a(boolean z16, String str, String str2);

        void b(boolean z16, String str, com.tencent.mobileqq.subaccount.logic.a aVar);

        void c(boolean z16, String str, com.tencent.mobileqq.subaccount.logic.b bVar);

        void d(boolean z16, String str, com.tencent.mobileqq.subaccount.logic.a aVar);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface d {
        void a(boolean z16, String str, String str2);

        void b(boolean z16, String str, boolean z17);

        void c(boolean z16, String str, boolean z17);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface e {
        void a(boolean z16, boolean z17);

        void b(boolean z16, boolean z17);

        void c(boolean z16, boolean z17);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface f {
        String a();

        int getStatus();
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface g {
        int a();

        boolean isShowRedDot();
    }

    boolean cleanThirdQQUnreadMsgNum(SimpleAccount simpleAccount);

    void clearGestureData(Context context, String str);

    BusinessObserver createMessageObserver(d dVar);

    BusinessObserver createSubAccountBindObserver(e eVar);

    void deleteHistory(AppInterface appInterface, String str);

    String getAccountManagerName();

    List<f> getAllSubAccountInfo();

    BusinessObserver getCardObserver(a aVar);

    BusinessObserver getFriendListObserver(b bVar);

    BusinessObserver getMessageObserver(c cVar);

    com.tencent.mobileqq.app.message.a getProcessor(AppInterface appInterface);

    String getQRCodeKey();

    String getServerConfigValue(ServerConfigManager.ConfigType configType, String str);

    String getTabIndex();

    g getUnreadCount(String str);

    void loginSuccessInit(AppRuntime appRuntime, String str);

    void notifyBusinessMessage(int i3, boolean z16, Object obj);

    void notifyUI(int i3, boolean z16, Object obj);

    void refreshConversation();

    void setBindUinStatus(AppInterface appInterface, byte b16, ArrayList<BindUin> arrayList);

    void setDisplayThirdQQSwitch(AppInterface appInterface, boolean z16);

    void startAllSubMessageAccountMsg(boolean z16);

    boolean startAllSubMessageAccountMsg(boolean z16, int i3);

    int startGetThirdQQUnreadNum(boolean z16);
}
