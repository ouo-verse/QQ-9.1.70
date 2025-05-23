package com.tencent.mobileqq.app.identity;

import QQService.DeviceItemDes;
import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import face.qqlogin.FaceSecureCheck$SecureCheckResponse;
import mqq.app.AppRuntime;
import tencent.im.oidb.oidb_0x5e1$RspBody;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface ISafeApi extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface a {
        void error(String str);
    }

    int checkDevLockStatus(AppRuntime appRuntime, String str, com.tencent.mobileqq.loginregister.servlet.h hVar);

    void clickFaceSettingEntry(AppRuntime appRuntime, Activity activity, String str, String str2, boolean z16, oidb_0x5e1$RspBody oidb_0x5e1_rspbody, FaceSecureCheck$SecureCheckResponse faceSecureCheck$SecureCheckResponse, a aVar);

    boolean delAuthDev(AppRuntime appRuntime, String str, DeviceItemDes deviceItemDes, boolean z16, long j3, byte[] bArr);

    boolean delHistoryDev(AppRuntime appRuntime, String str, DeviceItemDes deviceItemDes, long j3, byte[] bArr);

    boolean getAuthLoginAndOnlineDevList(AppRuntime appRuntime, String str, long j3);

    com.tencent.mobileqq.friend.observer.b getDevListObserver(d dVar);

    BusinessObserver getDevLockObserver(d dVar);

    boolean getIsPushRecommandDevLock(AppRuntime appRuntime);

    boolean getLoginDevList(AppRuntime appRuntime, String str, long j3);

    boolean getRecentLoginAndOnlineDevList(AppRuntime appRuntime, String str, long j3);

    String getUpdatePwdUrl(String str);

    void getWxMsgOptions(AppRuntime appRuntime);

    void gotoPwdSetWebsite(String str, String str2, Activity activity, AppInterface appInterface);

    boolean isH5Jump();

    void logoutAfterReleaseAccount();

    boolean needDeleteDevLock();

    int setLocalDevlockStatus(AppRuntime appRuntime, Context context, String str, boolean z16);

    int setLocalSecretPhoneUrl(String str);

    void setWXSyncQQMsgOption(AppRuntime appRuntime, boolean z16);
}
