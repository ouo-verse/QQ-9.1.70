package com.tencent.mobileqq.tianshu.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tianshu.data.NumRedGetMsgCallback;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.utils.RedTouchUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class RedTouchManagerImpl implements IRedTouchManager {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "RedPointLog.RedTouchManagerImpl";
    private RedTouchManager mRedTouchManager;

    public RedTouchManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public String appToString(BusinessInfoCheckUpdate.AppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) appInfo);
        }
        return RedTouchManager.g(appInfo);
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public void checkMsgExpire() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            redTouchManager.i();
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public void conversationRemainReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
        } else {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.tianshu.api.impl.RedTouchManagerImpl.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RedTouchManagerImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (RedTouchManagerImpl.this.mRedTouchManager != null) {
                        RedTouchManagerImpl.this.mRedTouchManager.l();
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public BusinessInfoCheckUpdate.AppInfo createNumAppInfo(int i3, int i16, String str, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (BusinessInfoCheckUpdate.AppInfo) iPatchRedirector.redirect((short) 43, this, Integer.valueOf(i3), Integer.valueOf(i16), str, Integer.valueOf(i17));
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            return redTouchManager.n(i3, i16, str, i17);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public void dismissRedTouch(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, (Object) str);
            return;
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            redTouchManager.r(str);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public void getAndSetAppInfoJsReport(int i3, ArrayList<String> arrayList, String str, String str2, String str3, String str4, String str5, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, Integer.valueOf(i3), arrayList, str, str2, str3, str4, str5, Integer.valueOf(i16));
            return;
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            redTouchManager.t(i3, arrayList, str, str2, str3, str4, str5, i16);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public int getAppIdByPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Integer) iPatchRedirector.redirect((short) 35, (Object) this, (Object) str)).intValue();
        }
        return RedTouchUtil.getAppIdByPath(str);
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public BusinessInfoCheckUpdate.AppInfo getAppInfo(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (BusinessInfoCheckUpdate.AppInfo) iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) str);
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            return redTouchManager.u(i3, str);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public BusinessInfoCheckUpdate.AppInfo getAppInfoByPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (BusinessInfoCheckUpdate.AppInfo) iPatchRedirector.redirect((short) 41, (Object) this, (Object) str);
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            return redTouchManager.v(str);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public BusinessInfoCheckUpdate.AppInfo getAppInfoFilterByID(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (BusinessInfoCheckUpdate.AppInfo) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), str, str2);
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            return redTouchManager.w(i3, str, str2);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public JSONObject getBufferExtParamAppInfo(BusinessInfoCheckUpdate.AppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (JSONObject) iPatchRedirector.redirect((short) 42, (Object) this, (Object) appInfo);
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            return redTouchManager.x(appInfo);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public int getExtraNumRedTotalNum(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, i3)).intValue();
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            return redTouchManager.z(i3);
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public String getLastClickPath(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return (String) iPatchRedirector.redirect((short) 48, (Object) this, (Object) appInterface);
        }
        return RedTouchUtil.getLastClickPath(appInterface);
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public BusinessInfoCheckUpdate.TimeRspBody getLocalTimeRspBody() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (BusinessInfoCheckUpdate.TimeRspBody) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            return redTouchManager.A();
        }
        QLog.e(TAG, 1, "warnning redtouch manager null");
        return null;
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public void getNumRedMsgByMsgIdArray(long[] jArr, String str, NumRedGetMsgCallback numRedGetMsgCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, jArr, str, numRedGetMsgCallback);
            return;
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            redTouchManager.E(jArr, str, numRedGetMsgCallback);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public int getNumRedNumByAppIdAndMsgType(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager == null) {
            return 0;
        }
        return redTouchManager.F(i3, i16);
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public int getNumRedNumByPath(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str, i3)).intValue();
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            return redTouchManager.G(str, i3);
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public List<BusinessInfoCheckUpdate.NumRedPath> getNumRedPathListByAppId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (List) iPatchRedirector.redirect((short) 11, (Object) this, i3);
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            return redTouchManager.H(i3);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public BusinessInfoCheckUpdate.AppInfo getNumRedPointInfo(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (BusinessInfoCheckUpdate.AppInfo) iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) str);
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            return redTouchManager.I(i3, str);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public int getNumRedShowNumByAppSet(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this, i3)).intValue();
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            return redTouchManager.J(i3);
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public BusinessInfoCheckUpdate.RedTypeInfo getRedTouchInfoByAppSet(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (BusinessInfoCheckUpdate.RedTypeInfo) iPatchRedirector.redirect((short) 45, (Object) this, i3);
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            return redTouchManager.L(i3);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public List<BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface> getRegisterInterfaces() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return (List) iPatchRedirector.redirect((short) 61, (Object) this);
        }
        return d.a();
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public String getSetAppInfoReportMsg(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this, (Object) str, (Object) str2);
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            return redTouchManager.R(str, str2);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public String getTraceInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return (String) iPatchRedirector.redirect((short) 58, (Object) this);
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            return redTouchManager.T();
        }
        return "";
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public boolean hasAppInfo(String str) {
        BusinessInfoCheckUpdate.AppInfo v3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Boolean) iPatchRedirector.redirect((short) 36, (Object) this, (Object) str)).booleanValue();
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager == null || (v3 = redTouchManager.v(str)) == null || v3.iNewFlag.get() == 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public boolean isNumRedTouchEnable(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, i3)).booleanValue();
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            return redTouchManager.a0(i3);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public boolean isUnShowMsgByAppId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, i3)).booleanValue();
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            return redTouchManager.b0(i3);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public boolean notifyAppInfoChangeUpdate(BusinessInfoCheckUpdate.TimeRspBody timeRspBody, BusinessInfoCheckUpdate.TimeRspBody timeRspBody2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, this, timeRspBody, timeRspBody2, Integer.valueOf(i3))).booleanValue();
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager == null) {
            return false;
        }
        redTouchManager.f0(timeRspBody, timeRspBody2, i3);
        return true;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else if (appRuntime instanceof AppInterface) {
            this.mRedTouchManager = new RedTouchManager((AppInterface) appRuntime);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            redTouchManager.onDestroy();
            this.mRedTouchManager = null;
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public void onRedTouchItemClick(BusinessInfoCheckUpdate.AppInfo appInfo, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) appInfo, (Object) str);
            return;
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            redTouchManager.i0(appInfo, str);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public void onRedTouchItemExposure(BusinessInfoCheckUpdate.AppInfo appInfo, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) appInfo, (Object) str);
            return;
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null && appInfo != null) {
            redTouchManager.l0(appInfo, str);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public void onReportBusinessRedTouch(BusinessInfoCheckUpdate.AppInfo appInfo, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) appInfo, (Object) str);
            return;
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            redTouchManager.q0(appInfo, str);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public void onReportNumRedPoint(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3, (Object) str);
            return;
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            redTouchManager.r0(i3, str);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public void onReportRedPointClickWithMissions(BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16, List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, appInfo, Boolean.valueOf(z16), list);
            return;
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            redTouchManager.u0(appInfo, z16, list);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public void onReportRedPointExposure(BusinessInfoCheckUpdate.AppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) appInfo);
            return;
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null && appInfo != null) {
            redTouchManager.v0(appInfo);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public void parseNumRedPushInfo(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) bArr);
            return;
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            redTouchManager.y0(bArr);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public boolean parsePushRedTouchInfo(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Boolean) iPatchRedirector.redirect((short) 38, (Object) this, (Object) bArr)).booleanValue();
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            return redTouchManager.z0(bArr);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public void redTouchsArrived(BusinessInfoCheckUpdate.TimeRspBody timeRspBody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this, (Object) timeRspBody);
            return;
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            redTouchManager.C0(timeRspBody);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public void reportLevelOneRedInfo(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            redTouchManager.E0(i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public void reportLevelZeroRedInfo(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            redTouchManager.I0(i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public void reportStatistic(BusinessInfoCheckUpdate.AppInfo appInfo, JSONObject jSONObject, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, appInfo, jSONObject, Integer.valueOf(i3));
            return;
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            redTouchManager.L0(appInfo, jSONObject, i3);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public List<BusinessInfoCheckUpdate.AppInfo> requestAppInfoListByAppSet(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (List) iPatchRedirector.redirect((short) 14, (Object) this, i3);
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            return redTouchManager.O0(i3);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public List<BusinessInfoCheckUpdate.AppSetting> requestSettingInfoList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (List) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            return redTouchManager.P0();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public void resetFlag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this);
            return;
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            redTouchManager.R0();
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public void residenceReport(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, j3);
            return;
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            redTouchManager.S0(j3);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public boolean saveTimeRepBody(BusinessInfoCheckUpdate.TimeRspBody timeRspBody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, (Object) timeRspBody)).booleanValue();
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            return redTouchManager.V0(timeRspBody);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public int updateAppInfo(BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Integer) iPatchRedirector.redirect((short) 40, this, appInfo, Boolean.valueOf(z16))).intValue();
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager == null) {
            return 0;
        }
        return redTouchManager.Z0(appInfo, z16);
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public boolean updateMsgAppInfo(BusinessInfoCheckUpdate.TimeRspBody timeRspBody, BusinessInfoCheckUpdate.TimeRspBody timeRspBody2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, (Object) timeRspBody, (Object) timeRspBody2)).booleanValue();
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            redTouchManager.e1(timeRspBody, timeRspBody2);
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public boolean updateNumberRedInfoByPath(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return ((Boolean) iPatchRedirector.redirect((short) 60, (Object) this, (Object) str, i3)).booleanValue();
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            return redTouchManager.h1(str, i3);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public int updateSettingById(int i3, boolean z16, long j3, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return ((Integer) iPatchRedirector.redirect((short) 59, this, Integer.valueOf(i3), Boolean.valueOf(z16), Long.valueOf(j3), Boolean.valueOf(z17))).intValue();
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager == null) {
            return 0;
        }
        return redTouchManager.i1(i3, z16, j3, z17);
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public String wrapperRedTouchUrl(String str, BusinessInfoCheckUpdate.AppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (String) iPatchRedirector.redirect((short) 37, (Object) this, (Object) str, (Object) appInfo);
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            return redTouchManager.j1(str, appInfo);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public BusinessInfoCheckUpdate.AppInfo createNumAppInfo(int i3, int i16, String str, int i17, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return (BusinessInfoCheckUpdate.AppInfo) iPatchRedirector.redirect((short) 44, this, Integer.valueOf(i3), Integer.valueOf(i16), str, Integer.valueOf(i17), Boolean.valueOf(z16));
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            return redTouchManager.o(i3, i16, str, i17, z16);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public BusinessInfoCheckUpdate.RedTypeInfo getRedTouchInfoByAppSet(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return (BusinessInfoCheckUpdate.RedTypeInfo) iPatchRedirector.redirect((short) 46, (Object) this, i3, (Object) str);
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            return redTouchManager.M(i3, str);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public void onRedTouchItemClick(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, (Object) str);
            return;
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            redTouchManager.k0(str);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public void reportLevelOneRedInfo(int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
            return;
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            redTouchManager.H0(i3 + "", i16, str);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public void reportLevelZeroRedInfo(int i3, int i16, boolean z16, IRedTouchManager.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), aVar);
            return;
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            redTouchManager.J0(i3, i16, z16, aVar);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public void reportStatistic(BusinessInfoCheckUpdate.AppInfo appInfo, JSONObject jSONObject, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, appInfo, jSONObject, Integer.valueOf(i3), str);
            return;
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            redTouchManager.M0(appInfo, jSONObject, i3, str);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public BusinessInfoCheckUpdate.RedTypeInfo getRedTouchInfoByAppSet(int i3, String str, List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return (BusinessInfoCheckUpdate.RedTypeInfo) iPatchRedirector.redirect((short) 47, this, Integer.valueOf(i3), str, list);
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            return redTouchManager.N(i3, str, list);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public void reportLevelOneRedInfo(BusinessInfoCheckUpdate.AppInfo appInfo, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, this, appInfo, Integer.valueOf(i3), str);
            return;
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            redTouchManager.F0(appInfo, i3, str);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchManager
    public void reportLevelOneRedInfo(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, (Object) str, i3);
            return;
        }
        RedTouchManager redTouchManager = this.mRedTouchManager;
        if (redTouchManager != null) {
            redTouchManager.G0(str, i3);
        }
    }
}
