package com.tencent.mobileqq.troop.redpoint.api.impl;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.redpoint.api.IRedPointInfoService;
import com.tencent.mobileqq.troop.redpoint.api.IRedPointUtilsApi;
import com.tencent.mobileqq.troop.redpoint.c;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;

/* loaded from: classes19.dex */
public class RedPointUtilsApiImpl implements IRedPointUtilsApi {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "RedPointUtils";

    public RedPointUtilsApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.redpoint.api.IRedPointUtilsApi
    public void addRedPointListener(AppRuntime appRuntime, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) appRuntime, (Object) cVar);
        } else if (appRuntime != null && cVar != null) {
            ((IRedPointInfoService) appRuntime.getRuntimeService(IRedPointInfoService.class, "")).addRedPointListener(cVar);
        }
    }

    @Override // com.tencent.mobileqq.troop.redpoint.api.IRedPointUtilsApi
    public void cleanRedPointInfoById(AppRuntime appRuntime, String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appRuntime, str, str2, Integer.valueOf(i3));
            return;
        }
        if (appRuntime != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "cleanRedPointInfoById : uin = " + str + ", uinType = " + str2 + ", redId = " + i3);
            }
            ((IRedPointInfoService) appRuntime.getRuntimeService(IRedPointInfoService.class, "")).cleanRedPointInfoById(str, str2, i3);
        }
    }

    @Override // com.tencent.mobileqq.troop.redpoint.api.IRedPointUtilsApi
    public void cleanRedPointInfoByIds(AppRuntime appRuntime, String str, String str2, List<Integer> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, appRuntime, str, str2, list);
            return;
        }
        if (appRuntime != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && list != null && !list.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "cleanRedPointInfoByIds : uin = " + str + ", uinType = " + str2 + ", redPointIdList = " + list.toString());
            }
            ((IRedPointInfoService) appRuntime.getRuntimeService(IRedPointInfoService.class, "")).cleanRedPointInfoByIds(str, str2, list);
        }
    }

    @Override // com.tencent.mobileqq.troop.redpoint.api.IRedPointUtilsApi
    public void notifyRedPointViewClick(AppRuntime appRuntime, String str, String str2, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, appRuntime, str, str2, view);
            return;
        }
        if (appRuntime != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "notifyRedPointViewClick uin = " + str + ", uinType = " + str2);
            }
            ((IRedPointInfoService) appRuntime.getRuntimeService(IRedPointInfoService.class, "")).notifyRedPointViewClick(str, str2, view);
        }
    }

    @Override // com.tencent.mobileqq.troop.redpoint.api.IRedPointUtilsApi
    public void removeRedPointListener(AppRuntime appRuntime, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) appRuntime, (Object) cVar);
        } else if (appRuntime != null && cVar != null) {
            ((IRedPointInfoService) appRuntime.getRuntimeService(IRedPointInfoService.class, "")).removeRedPointListener(cVar);
        }
    }

    @Override // com.tencent.mobileqq.troop.redpoint.api.IRedPointUtilsApi
    public void updateRedPointInfo(AppRuntime appRuntime, String str, String str2, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appRuntime, str, str2, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (appRuntime != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateRedPointInfo : uin = " + str + ", uinType = " + str2 + ", redId = " + i3 + ", unReadNum = " + i16);
            }
            ((IRedPointInfoService) appRuntime.getRuntimeService(IRedPointInfoService.class, "")).updateRedPointInfo(str, str2, i3, i16);
        }
    }
}
