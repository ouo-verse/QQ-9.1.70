package com.tencent.mobileqq.troop.homework.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopManagerService;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi;
import com.tencent.mobileqq.troop.observer.i;
import com.tencent.mobileqq.troop.troopreddot.handler.TroopRedDotHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0xe83.oidb_0xe83$AppInfo;
import tencent.im.oidb.cmd0xe83.oidb_0xe83$RspBody;

/* compiled from: P */
/* loaded from: classes19.dex */
public class HWTroopUtilsApiImpl implements IHWTroopUtilsApi {
    static IPatchRedirector $redirector_ = null;
    public static final String FILE_HW_TROOP_AIO_HAS_UNREAD_HOMEWORK = "file_homework_troop_aio_has_unread";
    private static final String TAG = "HWTroopUtilsApiImpl";

    public HWTroopUtilsApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void clearHomeworkTroopRedPointWith0x8c2(AppInterface appInterface, String str, String str2) {
        String str3;
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[4];
            objArr[0] = "clearHomeworkTroopRedPointWith0x8c2. troopUin=";
            if (str == null) {
                str3 = "";
            } else {
                str3 = str;
            }
            objArr[1] = str3;
            objArr[2] = ", type=";
            objArr[3] = str2;
            QLog.d(TAG, 2, objArr);
        }
        try {
            int parseInt = Integer.parseInt(str2);
            if (!TextUtils.isEmpty(str)) {
                ((qt2.a) appInterface.getBusinessHandler(TroopRedDotHandler.class.getName())).v2(str, parseInt);
            }
        } catch (NumberFormatException unused) {
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi
    public void clearHomeworkTroopRedPoint(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appInterface, (Object) str);
            return;
        }
        setAIOHomeworkBtnRedPoint(appInterface, str, 0);
        String valueOf = String.valueOf(1104445552);
        ((qt2.a) appInterface.getBusinessHandler(TroopRedDotHandler.class.getName())).b(i.f298024e, true, new Object[]{str, valueOf, Boolean.FALSE});
        clearHomeworkTroopRedPointWith0x8c2(appInterface, str, valueOf);
    }

    @Override // com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi
    public int getAIOHomeworkBtnRedPoint(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime, (Object) str)).intValue();
        }
        if (appRuntime == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        return appRuntime.getApp().getSharedPreferences(appRuntime.getCurrentAccountUin() + "_" + FILE_HW_TROOP_AIO_HAS_UNREAD_HOMEWORK, 0).getInt(str, 0);
    }

    @Override // com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi
    public boolean hasHomeworkTroopIdentity(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, i3)).booleanValue();
        }
        if (i3 != 332 && i3 != 333 && i3 != 334 && i3 != 335 && i3 != 336) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi
    public void setAIOHomeworkBtnRedPoint(AppRuntime appRuntime, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appRuntime, str, Integer.valueOf(i3));
            return;
        }
        if (appRuntime != null && !TextUtils.isEmpty(str)) {
            appRuntime.getApp().getSharedPreferences(appRuntime.getCurrentAccountUin() + "_" + FILE_HW_TROOP_AIO_HAS_UNREAD_HOMEWORK, 0).edit().putInt(str, i3).commit();
            ThreadManagerV2.post(new Runnable(appRuntime, str) { // from class: com.tencent.mobileqq.troop.homework.api.impl.HWTroopUtilsApiImpl.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ AppRuntime f296274d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f296275e;

                {
                    this.f296274d = appRuntime;
                    this.f296275e = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, HWTroopUtilsApiImpl.this, appRuntime, str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    byte[] troopAppListData = ((ITroopManagerService) this.f296274d.getRuntimeService(ITroopManagerService.class, "")).getTroopAppListData(this.f296275e);
                    if (troopAppListData != null) {
                        try {
                            oidb_0xe83$RspBody oidb_0xe83_rspbody = new oidb_0xe83$RspBody();
                            oidb_0xe83_rspbody.mergeFrom(troopAppListData);
                            List<oidb_0xe83$AppInfo> list = oidb_0xe83_rspbody.infos.get();
                            if (list != null && list.size() != 0) {
                                for (oidb_0xe83$AppInfo oidb_0xe83_appinfo : list) {
                                    if (oidb_0xe83_appinfo.appid.get() == 1104445552) {
                                        oidb_0xe83_appinfo.push_red_point.set(0);
                                        oidb_0xe83_rspbody.infos.set(list);
                                        ((ITroopManagerService) this.f296274d.getRuntimeService(ITroopManagerService.class, "")).setTroopAppListData(this.f296275e, oidb_0xe83_rspbody.toByteArray());
                                        ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).clearTroopShortCutBarAppRedPoint(this.f296274d, this.f296275e, 1104445552L);
                                        return;
                                    }
                                }
                                return;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.e(HWTroopUtilsApiImpl.TAG, 2, "setAIOHomeworkBtnRedPoint: appList == null || appList.size() == 0");
                            }
                        } catch (InvalidProtocolBufferMicroException unused) {
                            if (QLog.isColorLevel()) {
                                QLog.e(HWTroopUtilsApiImpl.TAG, 2, "setAIOHomeworkBtnRedPoint: InvalidProtocolBufferMicroException.");
                            }
                        }
                    }
                }
            }, 8, null, true);
        }
    }
}
