package com.tencent.mobileqq.app.identity.impl;

import QQService.DeviceItemDes;
import QQService.SvcRspGetDevLoginInfo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.AuthDevOpenUgActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.app.cx;
import com.tencent.mobileqq.app.identity.ISafeApi;
import com.tencent.mobileqq.app.identity.d;
import com.tencent.mobileqq.app.utils.IdentificationUtils;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.login.bq;
import com.tencent.mobileqq.loginregister.servlet.h;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mqp.app.sec.ScConfigManager;
import com.tencent.mqp.app.sec.c;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import face.qqlogin.FaceSecureCheck$SecureCheckResponse;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.oidb_0x5e1$RspBody;

/* compiled from: P */
/* loaded from: classes11.dex */
public class SafeApiImpl implements ISafeApi {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "SafeApiImpl";

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a extends ar {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f195788d;

        a(d dVar) {
            this.f195788d = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SafeApiImpl.this, (Object) dVar);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onDelDevResult(boolean z16, String str, byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, bArr);
            } else {
                this.f195788d.onDelDevResult(z16, str, bArr);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onGetRecentLoginAndLoginDevResult(boolean z16, SvcRspGetDevLoginInfo svcRspGetDevLoginInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), svcRspGetDevLoginInfo);
            } else {
                this.f195788d.onGetRecentLoginAndLoginDevResult(z16, svcRspGetDevLoginInfo);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class b extends cx {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f195790d;

        b(d dVar) {
            this.f195790d = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SafeApiImpl.this, (Object) dVar);
            }
        }

        @Override // com.tencent.mobileqq.app.cx
        protected void g(boolean z16, int i3, byte[] bArr, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Integer.valueOf(i3), bArr, str);
            } else {
                this.f195790d.onRenameAuthDev(z16, i3, bArr, str);
            }
        }

        @Override // com.tencent.mobileqq.app.cx
        protected void j(int i3, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bundle);
            } else {
                this.f195790d.onWXSyncQQMsgOption(i3, bundle);
            }
        }
    }

    public SafeApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$clickFaceSettingEntry$0(ISafeApi.a aVar, String str) {
        if (aVar != null) {
            aVar.error(str);
        }
    }

    @Override // com.tencent.mobileqq.app.identity.ISafeApi
    public int checkDevLockStatus(AppRuntime appRuntime, String str, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, this, appRuntime, str, hVar)).intValue();
        }
        return EquipmentLockImpl.o().f(appRuntime, str, hVar);
    }

    @Override // com.tencent.mobileqq.app.identity.ISafeApi
    public void clickFaceSettingEntry(AppRuntime appRuntime, Activity activity, String str, String str2, boolean z16, oidb_0x5e1$RspBody oidb_0x5e1_rspbody, FaceSecureCheck$SecureCheckResponse faceSecureCheck$SecureCheckResponse, final ISafeApi.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, appRuntime, activity, str, str2, Boolean.valueOf(z16), oidb_0x5e1_rspbody, faceSecureCheck$SecureCheckResponse, aVar);
        } else {
            IdentificationUtils.a(appRuntime, activity, str, str2, z16, oidb_0x5e1_rspbody, faceSecureCheck$SecureCheckResponse, new IdentificationUtils.c() { // from class: com.tencent.mobileqq.app.identity.impl.a
                @Override // com.tencent.mobileqq.app.utils.IdentificationUtils.c
                public final void error(String str3) {
                    SafeApiImpl.lambda$clickFaceSettingEntry$0(ISafeApi.a.this, str3);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.app.identity.ISafeApi
    public boolean delAuthDev(AppRuntime appRuntime, String str, DeviceItemDes deviceItemDes, boolean z16, long j3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, appRuntime, str, deviceItemDes, Boolean.valueOf(z16), Long.valueOf(j3), bArr)).booleanValue();
        }
        return EquipmentLockImpl.o().l(appRuntime, str, deviceItemDes, z16, j3, bArr);
    }

    @Override // com.tencent.mobileqq.app.identity.ISafeApi
    public boolean delHistoryDev(AppRuntime appRuntime, String str, DeviceItemDes deviceItemDes, long j3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, appRuntime, str, deviceItemDes, Long.valueOf(j3), bArr)).booleanValue();
        }
        return EquipmentLockImpl.o().m(appRuntime, str, deviceItemDes, bArr);
    }

    @Override // com.tencent.mobileqq.app.identity.ISafeApi
    public boolean getAuthLoginAndOnlineDevList(AppRuntime appRuntime, String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, appRuntime, str, Long.valueOf(j3))).booleanValue();
        }
        return EquipmentLockImpl.o().n(appRuntime, str, j3);
    }

    @Override // com.tencent.mobileqq.app.identity.ISafeApi
    public com.tencent.mobileqq.friend.observer.b getDevListObserver(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (com.tencent.mobileqq.friend.observer.b) iPatchRedirector.redirect((short) 14, (Object) this, (Object) dVar);
        }
        return new a(dVar);
    }

    @Override // com.tencent.mobileqq.app.identity.ISafeApi
    public BusinessObserver getDevLockObserver(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (BusinessObserver) iPatchRedirector.redirect((short) 15, (Object) this, (Object) dVar);
        }
        return new b(dVar);
    }

    @Override // com.tencent.mobileqq.app.identity.ISafeApi
    public boolean getIsPushRecommandDevLock(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) appRuntime)).booleanValue();
        }
        return EquipmentLockImpl.o().p();
    }

    @Override // com.tencent.mobileqq.app.identity.ISafeApi
    public boolean getLoginDevList(AppRuntime appRuntime, String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, this, appRuntime, str, Long.valueOf(j3))).booleanValue();
        }
        return EquipmentLockImpl.o().q(appRuntime, str, j3);
    }

    @Override // com.tencent.mobileqq.app.identity.ISafeApi
    public boolean getRecentLoginAndOnlineDevList(AppRuntime appRuntime, String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, this, appRuntime, str, Long.valueOf(j3))).booleanValue();
        }
        return EquipmentLockImpl.o().r(appRuntime, str, j3);
    }

    @Override // com.tencent.mobileqq.app.identity.ISafeApi
    public String getUpdatePwdUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        }
        c cVar = (c) ScConfigManager.i().e("SecCenterConfig", false);
        if (cVar != null) {
            return cVar.a("ModifyPwdUrls", str);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.identity.ISafeApi
    public void getWxMsgOptions(AppRuntime appRuntime) {
        SecSvcHandler secSvcHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            if (!(appRuntime instanceof AppInterface) || (secSvcHandler = (SecSvcHandler) ((AppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER)) == null) {
                return;
            }
            secSvcHandler.H2();
        }
    }

    @Override // com.tencent.mobileqq.app.identity.ISafeApi
    public void gotoPwdSetWebsite(String str, String str2, Activity activity, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, str, str2, activity, appInterface);
        } else if (!TextUtils.isEmpty(str)) {
            bq.c(str, str2, activity, appInterface);
        } else {
            bq.b(str2, activity, appInterface);
        }
    }

    @Override // com.tencent.mobileqq.app.identity.ISafeApi
    public boolean isH5Jump() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return AuthDevOpenUgActivity.getIsH5Jump();
    }

    @Override // com.tencent.mobileqq.app.identity.ISafeApi
    public void logoutAfterReleaseAccount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        QLog.i(TAG, 1, "logoutAfterReleaseAccount");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        if (peekAppRuntime instanceof QQAppInterface) {
            ThemeUiPlugin.destroy((QQAppInterface) peekAppRuntime);
        }
        ChatBackgroundManager.d();
        ImageCacheHelper.f98636a.e();
        QQSettingUtil.i(BaseApplication.getContext(), peekAppRuntime.getCurrentAccountUin(), QQSettingUtil.d(BaseApplication.getContext(), peekAppRuntime.getCurrentAccountUin()) + 1);
        if (QQPlayerService.s0()) {
            Intent intent = new Intent();
            intent.setAction("qqplayer_exit_action");
            BaseApplication.getContext().sendBroadcast(intent);
        }
        peekAppRuntime.logout(true);
    }

    @Override // com.tencent.mobileqq.app.identity.ISafeApi
    public boolean needDeleteDevLock() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106092", false);
        QLog.d(TAG, 1, "needDeleteDevLock switch: " + isSwitchOn);
        return isSwitchOn;
    }

    @Override // com.tencent.mobileqq.app.identity.ISafeApi
    public int setLocalDevlockStatus(AppRuntime appRuntime, Context context, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, appRuntime, context, str, Boolean.valueOf(z16))).intValue();
        }
        return EquipmentLockImpl.o().H(appRuntime, context, str, z16);
    }

    @Override // com.tencent.mobileqq.app.identity.ISafeApi
    public int setLocalSecretPhoneUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str)).intValue();
        }
        return EquipmentLockImpl.o().I(str);
    }

    @Override // com.tencent.mobileqq.app.identity.ISafeApi
    public void setWXSyncQQMsgOption(AppRuntime appRuntime, boolean z16) {
        SecSvcHandler secSvcHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appRuntime, Boolean.valueOf(z16));
            return;
        }
        if (appRuntime instanceof AppInterface) {
            secSvcHandler = (SecSvcHandler) ((AppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
        } else {
            secSvcHandler = null;
        }
        if (secSvcHandler != null) {
            secSvcHandler.V2(z16);
        }
    }
}
