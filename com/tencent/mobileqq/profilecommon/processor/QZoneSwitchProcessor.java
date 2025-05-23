package com.tencent.mobileqq.profilecommon.processor;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x587.oidb_0x587$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;

@KeepClassConstructor
/* loaded from: classes16.dex */
public class QZoneSwitchProcessor extends AbsProfileCommonProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f260939a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74196);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f260939a = "QZONE_RECEIVE_NOTIFY_PUSH_SWITCH";
        }
    }

    public QZoneSwitchProcessor(AppRuntime appRuntime) {
        super(appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        }
    }

    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r4v5 */
    public static int a(String str) {
        ?? r46;
        if (QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeInt(f260939a + "_" + str, 0) == 0) {
            r46 = 1;
        } else {
            r46 = 0;
        }
        QLog.d("QZoneSwitchProcessor", 1, "getReceiveNotifyPushSwitch: ", Boolean.valueOf((boolean) r46));
        return r46;
    }

    private String b(oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata) {
        if (oidb_0x5eb_udcuindata.uint64_uin.has()) {
            return String.valueOf(oidb_0x5eb_udcuindata.uint64_uin.get());
        }
        AppRuntime appRuntime = this.appRuntime;
        if (appRuntime == null) {
            return "";
        }
        return appRuntime.getCurrentUin();
    }

    public static void c(AppRuntime appRuntime, boolean z16) {
        try {
            QZoneSwitchProcessor qZoneSwitchProcessor = (QZoneSwitchProcessor) com.tencent.mobileqq.profilecommon.utils.a.a(QZoneSwitchProcessor.class, appRuntime);
            if (qZoneSwitchProcessor != null) {
                qZoneSwitchProcessor.d(z16);
            }
        } catch (Exception e16) {
            QLog.i("QZoneSwitchProcessor", 1, "setReceiveNotifyPushSwitch error:", e16);
        }
    }

    private void d(boolean z16) {
        QLog.i("QZoneSwitchProcessor", 1, "setReceiveNotifyPushSwitchInner isOpen =" + z16);
        if (this.appRuntime == null) {
            QLog.i("QZoneSwitchProcessor", 1, "setReceiveNotifyPushSwitchInner appRuntime == null");
            return;
        }
        oidb_0x587$ReqBody oidb_0x587_reqbody = new oidb_0x587$ReqBody();
        oidb_0x587_reqbody.rpt_uint64_uins.add(Long.valueOf(this.appRuntime.getLongAccountUin()));
        oidb_0x587_reqbody.uint32_qzone_receive_notify_push_switch.set(!z16 ? 1 : 0);
        Bundle bundle = new Bundle();
        bundle.putInt(f260939a, !z16 ? 1 : 0);
        setProfileDetail(oidb_0x587_reqbody, bundle);
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public String getProcessorKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "QZoneSwitchProcessor";
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public boolean onGetProfileDetailRequestForLogin(oidb_0x5eb$ReqBody oidb_0x5eb_reqbody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) oidb_0x5eb_reqbody)).booleanValue();
        }
        if (oidb_0x5eb_reqbody == null) {
            return true;
        }
        oidb_0x5eb_reqbody.uint32_qzone_receive_notify_push_switch.set(1);
        return true;
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onGetProfileDetailResponse(Bundle bundle, boolean z16, oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, bundle, Boolean.valueOf(z16), oidb_0x5eb_udcuindata);
            return;
        }
        if (z16 && oidb_0x5eb_udcuindata != null) {
            String b16 = b(oidb_0x5eb_udcuindata);
            if (TextUtils.isEmpty(b16)) {
                QLog.i("QZoneSwitchProcessor", 1, "[onGetProfileDetailResponse] uin is empty, uin=\"" + b16 + "\"");
                return;
            }
            if (!oidb_0x5eb_udcuindata.uint32_qzone_receive_notify_push_switch.has()) {
                QLog.i("QZoneSwitchProcessor", 1, "[onGetProfileDetailResponse] switch not exist, uin =" + b16);
                return;
            }
            int i3 = oidb_0x5eb_udcuindata.uint32_qzone_receive_notify_push_switch.get();
            QLog.i("QZoneSwitchProcessor", 1, "[onGetProfileDetailResponse] switch exist, value =" + i3);
            boolean bool = LocalMultiProcConfig.getBool("QzoneMyfeedsShowPush" + b16, true);
            if (i3 == 0 && !bool) {
                QLog.i("QZoneSwitchProcessor", 1, "[onGetProfileDetailResponse] local switch need migarate to server");
                d(false);
                LocalMultiProcConfig.removeKey(LocalMultiProcConfig.PREFS_NAME_QZ_QQ_SETTING, "QzoneMyfeedsShowPush" + b16);
                return;
            }
            QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeInt(f260939a + "_" + b16, i3);
            return;
        }
        QLog.i("QZoneSwitchProcessor", 1, "onGetProfileDetailResponse udcUinData == null");
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onSetProfileDetailResponse(Bundle bundle, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, bundle, Boolean.valueOf(z16));
            return;
        }
        QLog.i("QZoneSwitchProcessor", 1, "onSetProfileDetailResponse success =" + z16 + " param: " + bundle);
        if (z16 && bundle != null) {
            int i3 = bundle.getInt(f260939a, -1);
            if (i3 == -1) {
                return;
            }
            QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeInt(f260939a + "_" + this.appRuntime.getCurrentUin(), i3);
            return;
        }
        try {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.i8c, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        } catch (Throwable th5) {
            QLog.e("QZoneSwitchProcessor", 1, "onSetProfileDetailResponse exception: ", th5);
        }
    }
}
