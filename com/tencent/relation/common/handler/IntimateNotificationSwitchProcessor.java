package com.tencent.relation.common.handler;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x587.oidb_0x587$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;

@KeepClassConstructor
/* loaded from: classes25.dex */
public class IntimateNotificationSwitchProcessor extends AbsProfileCommonProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f364715a;

    /* renamed from: b, reason: collision with root package name */
    private static final MMKVOptionEntityV2 f364716b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27665);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f364715a = "SYNC_INTIMATE_NOTIFICATION_PUSH_SWITCH";
            f364716b = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        }
    }

    public IntimateNotificationSwitchProcessor(AppRuntime appRuntime) {
        super(appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        }
    }

    public static boolean a(String str) {
        boolean z16 = false;
        int i3 = f364716b.getInt(f364715a + "_" + str, 0);
        if (i3 == 0 || i3 == 2) {
            z16 = true;
        }
        QLog.i("IntimateNotificationSwitchProcessor", 1, "checkReceiveNotifyPushSwitchIsOpen: " + z16);
        return z16;
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
        IntimateNotificationSwitchProcessor intimateNotificationSwitchProcessor = (IntimateNotificationSwitchProcessor) com.tencent.mobileqq.profilecommon.utils.a.a(IntimateNotificationSwitchProcessor.class, appRuntime);
        if (intimateNotificationSwitchProcessor == null) {
            QLog.d("IntimateNotificationSwitchProcessor", 1, "setReceiveNotifyPushSwitch switchProcessor == null");
        } else {
            intimateNotificationSwitchProcessor.d(z16);
        }
    }

    private void d(boolean z16) {
        int i3;
        int i16 = 1;
        QLog.i("IntimateNotificationSwitchProcessor", 1, "setReceiveNotifyPushSwitchInner isOpen =" + z16);
        if (this.appRuntime == null) {
            QLog.d("IntimateNotificationSwitchProcessor", 1, "setReceiveNotifyPushSwitchInner appRuntime == null");
            return;
        }
        oidb_0x587$ReqBody oidb_0x587_reqbody = new oidb_0x587$ReqBody();
        oidb_0x587_reqbody.rpt_uint64_uins.add(Long.valueOf(this.appRuntime.getLongAccountUin()));
        PBUInt32Field pBUInt32Field = oidb_0x587_reqbody.uint32_intimate_notification_push_switch;
        if (z16) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        pBUInt32Field.set(i3);
        Bundle bundle = new Bundle();
        String str = f364715a;
        if (z16) {
            i16 = 2;
        }
        bundle.putInt(str, i16);
        setProfileDetail(oidb_0x587_reqbody, bundle);
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public String getProcessorKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "IntimateNotificationSwitchProcessor";
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
        oidb_0x5eb_reqbody.uint32_intimate_notification_push_switch.set(1);
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
                QLog.d("IntimateNotificationSwitchProcessor", 1, "onGetProfileDetailResponse uin is empty, uin=\"" + b16 + "\"");
                return;
            }
            if (!oidb_0x5eb_udcuindata.uint32_intimate_notification_push_switch.has()) {
                QLog.d("IntimateNotificationSwitchProcessor", 1, "onGetProfileDetailResponse switch not exist");
                return;
            }
            int i3 = oidb_0x5eb_udcuindata.uint32_intimate_notification_push_switch.get();
            QLog.i("IntimateNotificationSwitchProcessor", 1, "onGetProfileDetailResponse switch exist, value =" + i3);
            f364716b.putInt(f364715a + "_" + b16, i3);
            return;
        }
        QLog.d("IntimateNotificationSwitchProcessor", 1, "onGetProfileDetailResponse udcUinData == null");
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onSetProfileDetailResponse(Bundle bundle, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, bundle, Boolean.valueOf(z16));
            return;
        }
        QLog.i("IntimateNotificationSwitchProcessor", 1, "onSetProfileDetailResponse success =" + z16 + " param: " + bundle);
        if (z16 && bundle != null) {
            int i3 = bundle.getInt(f364715a, -1);
            if (i3 == -1) {
                return;
            }
            f364716b.putInt(f364715a + "_" + this.appRuntime.getCurrentUin(), i3);
            return;
        }
        QQToast.makeText(BaseApplication.getContext(), 1, R.string.f160951we, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }
}
