package com.tencent.mobileqq.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.device_lock_query_status$RspBody;
import com.tencent.ims.get_config$ReqBody;
import com.tencent.ims.get_config$RspBody;
import com.tencent.ims.wx_msg_opt$ReqBody;
import com.tencent.ims.wx_msg_opt$RspBody;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.notification.NotificationController;
import com.tenpay.sdk.util.UinConfigManager;
import java.nio.ByteBuffer;
import java.util.List;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x614.Oidb_0x614$DeviceManageHead;
import tencent.im.oidb.cmd0x614.Oidb_0x614$ReNameDeviceNameReqBody;
import tencent.im.oidb.cmd0x614.Oidb_0x614$ReqBody;
import tencent.im.oidb.cmd0x614.Oidb_0x614$RspBody;
import tencent.im.oidb.cmd0xeb8.oidb_0xeb8$PhoneInfo;
import tencent.im.oidb.cmd0xeb8.oidb_0xeb8$ReqBody;
import tencent.im.oidb.cmd0xeb8.oidb_0xeb8$RspBody;
import tencent.im.oidb.cmd0xebd.oidb_0xebd$ReqBody;
import tencent.im.oidb.cmd0xebd.oidb_0xebd$RspBody;
import tencent.im.oidb.cmd0xec0.oidb_0xec0$ReqBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class SecSvcHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private int f195060d;

    SecSvcHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f195060d = 1;
        }
    }

    private void J2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16 = false;
        Bundle bundle = null;
        if (obj != null) {
            try {
                if (fromServiceMsg.isSuccess()) {
                    oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                    oidb_sso_oidbssopkg.mergeFrom(fromServiceMsg.getWupBuffer());
                    Bundle bundle2 = new Bundle();
                    try {
                        if (oidb_sso_oidbssopkg.uint32_result.has()) {
                            if (oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                                z16 = true;
                            }
                            bundle2.putInt("ret_code", oidb_sso_oidbssopkg.uint32_result.get());
                        }
                        if (oidb_sso_oidbssopkg.str_error_msg.has()) {
                            bundle2.putString("err_msg", oidb_sso_oidbssopkg.str_error_msg.get());
                        }
                        bundle = bundle2;
                    } catch (Exception e16) {
                        e = e16;
                        bundle = bundle2;
                        if (QLog.isColorLevel()) {
                            QLog.d("SecSvcHandler", 2, "onBindPhoneNumLogin error:" + e.getMessage());
                        }
                        notifyUI(7, z16, bundle);
                    }
                }
            } catch (Exception e17) {
                e = e17;
            }
        }
        notifyUI(7, z16, bundle);
    }

    private void K2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        String str;
        int i16;
        String str2;
        int i17 = 0;
        if (obj != null && fromServiceMsg.isSuccess()) {
            try {
                get_config$RspBody get_config_rspbody = new get_config$RspBody();
                get_config_rspbody.mergeFrom((byte[]) obj);
                Bundle bundle = new Bundle();
                if (get_config_rspbody.u32_proto_version.has()) {
                    i3 = get_config_rspbody.u32_proto_version.get();
                } else {
                    i3 = 1;
                }
                bundle.putInt("proto_version", i3);
                String str3 = "";
                if (!get_config_rspbody.str_config_name.has()) {
                    str = "";
                } else {
                    str = get_config_rspbody.str_config_name.get();
                }
                bundle.putString(UinConfigManager.KEY_CONFIG_NAME, str);
                if (get_config_rspbody.u32_config_version.has()) {
                    i16 = get_config_rspbody.u32_config_version.get();
                } else {
                    i16 = 0;
                }
                bundle.putInt(NotificationController.Constants.CONFIG_VERSION, i16);
                if (get_config_rspbody.u32_effect_time.has()) {
                    i17 = get_config_rspbody.u32_effect_time.get();
                }
                bundle.putInt("effect_time", i17);
                if (!get_config_rspbody.str_md5.has()) {
                    str2 = "";
                } else {
                    str2 = get_config_rspbody.str_md5.get();
                }
                bundle.putString("md5", str2);
                if (get_config_rspbody.str_download_link.has()) {
                    str3 = get_config_rspbody.str_download_link.get();
                }
                bundle.putString("download_url", str3);
                notifyUI(1, true, bundle);
                return;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("SecSvcHandler", 2, "onGetAntiFraudConfig error:" + e16.getMessage());
                    return;
                }
                return;
            }
        }
        notifyUI(1, false, null);
    }

    private void L2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        Exception e16;
        boolean z17;
        int i3 = 0;
        Bundle bundle = null;
        if (obj != null) {
            try {
                if (fromServiceMsg.isSuccess()) {
                    oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                    oidb_sso_oidbssopkg.mergeFrom(fromServiceMsg.getWupBuffer());
                    if (oidb_sso_oidbssopkg.uint32_result.get() == 0 && oidb_sso_oidbssopkg.bytes_bodybuffer.has()) {
                        oidb_0xeb8$RspBody oidb_0xeb8_rspbody = new oidb_0xeb8$RspBody();
                        oidb_0xeb8_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                        int i16 = oidb_0xeb8_rspbody.uint32_check_result.get();
                        if (i16 > 0) {
                            z16 = true;
                            if (i16 != 4) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            try {
                                Bundle bundle2 = new Bundle();
                                try {
                                    bundle2.putInt("check_result", i16);
                                    if (i16 == 3) {
                                        i3 = 1;
                                    }
                                    bundle2.putInt("need_unify", i3);
                                    U2(oidb_0xeb8_rspbody, bundle2, z17);
                                    i3 = 1;
                                    bundle = bundle2;
                                } catch (Exception e17) {
                                    e16 = e17;
                                    bundle = bundle2;
                                    if (QLog.isColorLevel()) {
                                        QLog.d("SecSvcHandler", 2, "onGetPhoneBindInfo error:" + e16.getMessage());
                                    }
                                    notifyUI(5, z16, bundle);
                                }
                            } catch (Exception e18) {
                                e16 = e18;
                            }
                        }
                    }
                }
            } catch (Exception e19) {
                z16 = false;
                e16 = e19;
            }
        }
        z16 = i3;
        notifyUI(5, z16, bundle);
    }

    private void M2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        Object attribute;
        if (obj != null && fromServiceMsg != null && toServiceMsg != null && fromServiceMsg.isSuccess()) {
            if (OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, new MessageMicro<oidb_0xebd$RspBody>() { // from class: tencent.im.oidb.cmd0xebd.oidb_0xebd$RspBody
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0xebd$RspBody.class);
            }) == 0) {
                notifyUI(10, true, toServiceMsg.getAttribute("open_close_contacts", Boolean.FALSE));
                return;
            } else {
                notifyUI(10, false, toServiceMsg.getAttribute("open_close_contacts", Boolean.FALSE));
                return;
            }
        }
        if (toServiceMsg == null) {
            attribute = Boolean.FALSE;
        } else {
            attribute = toServiceMsg.getAttribute("open_close_contacts", Boolean.FALSE);
        }
        notifyUI(10, false, attribute);
    }

    private void N2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        boolean z16 = false;
        if (obj != null && fromServiceMsg.isSuccess()) {
            device_lock_query_status$RspBody device_lock_query_status_rspbody = new device_lock_query_status$RspBody();
            try {
                device_lock_query_status_rspbody.mergeFrom(fromServiceMsg.getWupBuffer());
                Bundle bundle = new Bundle();
                if (device_lock_query_status_rspbody.u32_status.has()) {
                    i3 = device_lock_query_status_rspbody.u32_status.get();
                } else {
                    i3 = 0;
                }
                bundle.putInt("status", i3);
                String str = "";
                if (device_lock_query_status_rspbody.str_wording.has()) {
                    str = device_lock_query_status_rspbody.str_wording.get();
                }
                bundle.putString("wording", str);
                if (device_lock_query_status_rspbody.u32_ret.has() && device_lock_query_status_rspbody.u32_ret.get() == 0) {
                    z16 = true;
                }
                notifyUI(3, z16, bundle);
                return;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("SecSvcHandler", 2, "onQueryDevLockStatus error:" + e16.getMessage());
                    return;
                }
                return;
            }
        }
        notifyUI(3, false, null);
    }

    private void O2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16 = false;
        Bundle bundle = null;
        if (obj != null) {
            try {
                if (fromServiceMsg.isSuccess()) {
                    oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                    oidb_sso_oidbssopkg.mergeFrom(fromServiceMsg.getWupBuffer());
                    if (oidb_sso_oidbssopkg.bytes_bodybuffer.has()) {
                        Oidb_0x614$RspBody oidb_0x614$RspBody = new Oidb_0x614$RspBody();
                        oidb_0x614$RspBody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                        if (oidb_0x614$RspBody.msg_dm_head.has()) {
                            Oidb_0x614$DeviceManageHead oidb_0x614$DeviceManageHead = oidb_0x614$RspBody.msg_dm_head;
                            if (oidb_0x614$DeviceManageHead.uint32_result.has() && oidb_0x614$DeviceManageHead.uint32_result.get() == 0) {
                                z16 = true;
                                Bundle bundle2 = new Bundle();
                                try {
                                    bundle2.putInt("index", toServiceMsg.extraData.getInt("index"));
                                    bundle2.putString("target_name", toServiceMsg.extraData.getString("target_name"));
                                    bundle2.putByteArray("target_desc", toServiceMsg.extraData.getByteArray("target_desc"));
                                    bundle = bundle2;
                                } catch (Exception e16) {
                                    e = e16;
                                    bundle = bundle2;
                                    if (QLog.isColorLevel()) {
                                        QLog.d("SecSvcHandler", 2, "onRenameAuthDev error:" + e.getMessage());
                                    }
                                    notifyUI(4, z16, bundle);
                                }
                            }
                        }
                    }
                }
            } catch (Exception e17) {
                e = e17;
            }
        }
        notifyUI(4, z16, bundle);
    }

    private void P2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16 = false;
        Bundle bundle = null;
        if (obj != null) {
            try {
                if (fromServiceMsg.isSuccess()) {
                    oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                    oidb_sso_oidbssopkg.mergeFrom(fromServiceMsg.getWupBuffer());
                    Bundle bundle2 = new Bundle();
                    try {
                        if (oidb_sso_oidbssopkg.uint32_result.has()) {
                            if (oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                                z16 = true;
                            }
                            bundle2.putInt("ret_code", oidb_sso_oidbssopkg.uint32_result.get());
                        }
                        if (oidb_sso_oidbssopkg.str_error_msg.has()) {
                            bundle2.putString("err_msg", oidb_sso_oidbssopkg.str_error_msg.get());
                        }
                        bundle = bundle2;
                    } catch (Exception e16) {
                        e = e16;
                        bundle = bundle2;
                        if (QLog.isColorLevel()) {
                            QLog.d("SecSvcHandler", 2, "onUnbindPhoneNumLogin error:" + e.getMessage());
                        }
                        notifyUI(8, z16, bundle);
                    }
                }
            } catch (Exception e17) {
                e = e17;
            }
        }
        notifyUI(8, z16, bundle);
    }

    private void Q2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        Bundle bundle;
        Exception e16;
        boolean z16 = false;
        if (obj != null && fromServiceMsg != null && toServiceMsg != null && fromServiceMsg.isSuccess()) {
            try {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom(fromServiceMsg.getWupBuffer());
                bundle = new Bundle();
                try {
                    if (oidb_sso_oidbssopkg.uint32_result.has()) {
                        if (oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                            z16 = true;
                        }
                        bundle.putInt("ret_code", oidb_sso_oidbssopkg.uint32_result.get());
                    }
                    if (oidb_sso_oidbssopkg.str_error_msg.has()) {
                        bundle.putString("err_msg", oidb_sso_oidbssopkg.str_error_msg.get());
                    }
                } catch (Exception e17) {
                    e16 = e17;
                    if (QLog.isColorLevel()) {
                        QLog.d("SecSvcHandler", 2, "onUnbindPhoneNumLogin error:" + e16.getMessage());
                    }
                    notifyUI(8, z16, bundle);
                    return;
                }
            } catch (Exception e18) {
                bundle = null;
                e16 = e18;
            }
            notifyUI(8, z16, bundle);
            return;
        }
        notifyUI(8, false, -1);
    }

    private void R2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        int i16;
        int i17;
        if (obj != null && fromServiceMsg.isSuccess()) {
            wx_msg_opt$RspBody wx_msg_opt_rspbody = new wx_msg_opt$RspBody();
            try {
                wx_msg_opt_rspbody.mergeFrom(fromServiceMsg.getWupBuffer());
                Bundle bundle = new Bundle();
                if (wx_msg_opt_rspbody.uint32_cmd.has()) {
                    i3 = wx_msg_opt_rspbody.uint32_cmd.get();
                } else {
                    i3 = 1;
                }
                bundle.putInt("cmd", i3);
                if (wx_msg_opt_rspbody.uint32_ret.has()) {
                    i16 = wx_msg_opt_rspbody.uint32_ret.get();
                } else {
                    i16 = -1;
                }
                bundle.putInt("ret", i16);
                if (wx_msg_opt_rspbody.uint32_opt.has()) {
                    i17 = wx_msg_opt_rspbody.uint32_opt.get();
                } else {
                    i17 = 2;
                }
                bundle.putInt("opt", i17);
                String str = "";
                if (wx_msg_opt_rspbody.str_wording.has()) {
                    str = wx_msg_opt_rspbody.str_wording.get();
                }
                bundle.putString("wording", str);
                notifyUI(2, true, bundle);
                return;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("SecSvcHandler", 2, "onWXSyncQQMsgOption error:" + e16.getMessage());
                    return;
                }
                return;
            }
        }
        notifyUI(2, false, null);
    }

    private void U2(oidb_0xeb8$RspBody oidb_0xeb8_rspbody, Bundle bundle, boolean z16) {
        int i3;
        if (oidb_0xeb8_rspbody.str_mibao_change_url.has()) {
            bundle.putString("mibao_change_url", oidb_0xeb8_rspbody.str_mibao_change_url.get());
        }
        if (oidb_0xeb8_rspbody.str_mibao_set_url.has()) {
            bundle.putString("mibao_set_url", oidb_0xeb8_rspbody.str_mibao_set_url.get());
        }
        if (oidb_0xeb8_rspbody.str_mibao_verify_url.has()) {
            bundle.putString("mibao_verify_url", oidb_0xeb8_rspbody.str_mibao_verify_url.get());
        }
        if (oidb_0xeb8_rspbody.str_hori_bar_tips.has()) {
            bundle.putString("str_hori_bar_tips", oidb_0xeb8_rspbody.str_hori_bar_tips.get());
        }
        if (oidb_0xeb8_rspbody.str_red_dot_tips.has()) {
            bundle.putString("str_red_dot_tips", oidb_0xeb8_rspbody.str_red_dot_tips.get());
        }
        if (oidb_0xeb8_rspbody.bool_is_IOT.get()) {
            bundle.putBoolean("bool_is_IOT", true);
            bundle.putString("verify_phone_url", oidb_0xeb8_rspbody.str_verify_premibao_url.get());
        }
        if (oidb_0xeb8_rspbody.rpt_phone_info.has()) {
            List<oidb_0xeb8$PhoneInfo> list = oidb_0xeb8_rspbody.rpt_phone_info.get();
            Parcelable[] parcelableArr = new Bundle[list.size()];
            boolean z17 = z16;
            for (int i16 = 0; i16 < list.size(); i16++) {
                oidb_0xeb8$PhoneInfo oidb_0xeb8_phoneinfo = list.get(i16);
                if (oidb_0xeb8_phoneinfo != null) {
                    Bundle bundle2 = new Bundle();
                    if (oidb_0xeb8_phoneinfo.uint32_phone_type.has()) {
                        i3 = oidb_0xeb8_phoneinfo.uint32_phone_type.get();
                        bundle2.putInt("phone_type", i3);
                        if (i3 == 4) {
                            bundle.putBoolean("phone_verified", false);
                            bundle.putString("phone_unverified_number", oidb_0xeb8_phoneinfo.str_phone.get());
                            bundle.putString("verify_phone_url", oidb_0xeb8_rspbody.str_verify_premibao_url.get());
                        }
                    } else {
                        i3 = -1;
                    }
                    if (oidb_0xeb8_phoneinfo.str_country_code.has()) {
                        bundle2.putString("country_code", oidb_0xeb8_phoneinfo.str_country_code.get());
                        if (i3 == 1) {
                            bundle.putString("country_code", oidb_0xeb8_phoneinfo.str_country_code.get());
                        }
                    }
                    if (oidb_0xeb8_phoneinfo.str_phone.has()) {
                        bundle2.putString("phone", oidb_0xeb8_phoneinfo.str_phone.get());
                        ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).setPhoneToMMKV(oidb_0xeb8_phoneinfo.str_phone.get());
                        bundle.putString("phone", oidb_0xeb8_phoneinfo.str_phone.get());
                        if (i3 == 1) {
                            bundle.putString("phone", oidb_0xeb8_phoneinfo.str_phone.get());
                        }
                    }
                    if (oidb_0xeb8_phoneinfo.uint32_phone_status.has()) {
                        int i17 = oidb_0xeb8_phoneinfo.uint32_phone_status.get();
                        bundle2.putInt("status", i17);
                        if (i3 == 1) {
                            bundle.putInt("status", i17);
                        }
                        if (i17 == 4) {
                            QLog.e("SecSvcHandler", 1, "onGetNewPhoneUnityInfo: get phone type: " + i3 + " fail.");
                            z17 = false;
                        }
                    }
                    if (oidb_0xeb8_phoneinfo.bytes_vas_phone.has()) {
                        bundle2.putByteArray("vaskey", oidb_0xeb8_phoneinfo.bytes_vas_phone.get().toByteArray());
                    }
                    parcelableArr[i16] = bundle2;
                }
            }
            bundle.putParcelableArray("phone_info", parcelableArr);
            ((PhoneUnityManager) ((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getManager(QQManagerFactory.PHONE_UNITY_MANAGER)).j(bundle);
            bundle.putBoolean("is_all_phone_get", z17);
        }
    }

    public void D2(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bArr);
            return;
        }
        if (bArr == null) {
            notifyUI(7, false, null);
            return;
        }
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 19);
        allocate.putShort((short) 3);
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        allocate.putInt((int) qQAppInterface.getLongAccountUin());
        allocate.put((byte) bArr.length);
        allocate.put(bArr);
        allocate.putShort((short) 2);
        allocate.putShort((short) 1);
        allocate.putShort((short) 1);
        allocate.put((byte) 0);
        allocate.putShort((short) 2);
        allocate.putShort((short) 1);
        allocate.put((byte) 1);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(2579);
        oidb_sso_oidbssopkg.uint32_service_type.set(16);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", qQAppInterface.getCurrentAccountUin(), "OidbSvc.0xa13");
        toServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        sendPbReq(toServiceMsg);
    }

    public void E2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            I2(false);
        }
    }

    public void F2(String str) {
        int parseInt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SecSvcHandler", 2, "getAntiFraudConfig");
        }
        get_config$ReqBody get_config_reqbody = new get_config$ReqBody();
        get_config_reqbody.u64_uin.set(((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getLongAccountUin());
        get_config_reqbody.u32_appid.set(AppSetting.f());
        get_config_reqbody.u32_proto_version.set(1);
        PBUInt32Field pBUInt32Field = get_config_reqbody.u32_seq;
        int i3 = this.f195060d;
        this.f195060d = i3 + 1;
        pBUInt32Field.set(i3);
        get_config_reqbody.str_config_name.set(str);
        String k3 = AntiFraudConfigFileUtil.n().k(str, "Version");
        if (!TextUtils.isEmpty(k3)) {
            try {
                parseInt = Integer.parseInt(k3);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            get_config_reqbody.u32_config_version.set(parseInt);
            ToServiceMsg createToServiceMsg = createToServiceMsg("SecuritySvc.GetConfig");
            createToServiceMsg.putWupBuffer(get_config_reqbody.toByteArray());
            sendPbReq(createToServiceMsg);
        }
        parseInt = 0;
        get_config_reqbody.u32_config_version.set(parseInt);
        ToServiceMsg createToServiceMsg2 = createToServiceMsg("SecuritySvc.GetConfig");
        createToServiceMsg2.putWupBuffer(get_config_reqbody.toByteArray());
        sendPbReq(createToServiceMsg2);
    }

    public void G2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        oidb_0xeb8$ReqBody oidb_0xeb8_reqbody = new oidb_0xeb8$ReqBody();
        oidb_0xeb8_reqbody.uint32_src.set(i3);
        oidb_0xeb8_reqbody.uint32_proto_ver.set(2);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(3768);
        oidb_sso_oidbssopkg.uint32_service_type.set(1);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0xeb8_reqbody.toByteArray()));
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", ((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getCurrentAccountUin(), "OidbSvc.0xeb8");
        toServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        sendPbReq(toServiceMsg);
    }

    public void H2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        wx_msg_opt$ReqBody wx_msg_opt_reqbody = new wx_msg_opt$ReqBody();
        wx_msg_opt_reqbody.uint64_uin.set(((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getLongAccountUin());
        wx_msg_opt_reqbody.uint32_cmd.set(1);
        PBUInt32Field pBUInt32Field = wx_msg_opt_reqbody.uint32_seq;
        int i3 = this.f195060d;
        this.f195060d = i3 + 1;
        pBUInt32Field.set(i3);
        wx_msg_opt_reqbody.uint32_opt.set(1);
        ToServiceMsg createToServiceMsg = createToServiceMsg("DevLockAuthSvc.WxMsgOpt");
        createToServiceMsg.putWupBuffer(wx_msg_opt_reqbody.toByteArray());
        sendPbReq(createToServiceMsg);
    }

    protected void I2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
            return;
        }
        oidb_0xebd$ReqBody oidb_0xebd_reqbody = new oidb_0xebd$ReqBody();
        oidb_0xebd_reqbody.uint32_set_is_searched_by_mobile.set(z16 ? 1 : 0);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xebd", 3773, 1, oidb_0xebd_reqbody.toByteArray());
        makeOIDBPkg.addAttribute("open_close_contacts", Boolean.valueOf(z16));
        sendPbReq(makeOIDBPkg);
    }

    public void S2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            I2(true);
        }
    }

    public void T2(Bundle bundle) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) bundle);
            return;
        }
        if (bundle == null) {
            return;
        }
        String string = bundle.getString("uin");
        String string2 = bundle.getString("appname");
        long j16 = bundle.getLong("appid");
        long j17 = bundle.getLong("sub_appid");
        byte[] byteArray = bundle.getByteArray("device_guid");
        String string3 = bundle.getString("target_name");
        byte[] byteArray2 = bundle.getByteArray("target_desc");
        int i3 = bundle.getInt("index");
        try {
            j3 = Long.parseLong(string);
        } catch (Throwable th5) {
            th5.printStackTrace();
            j3 = 0;
        }
        long j18 = j3;
        Oidb_0x614$DeviceManageHead oidb_0x614$DeviceManageHead = new Oidb_0x614$DeviceManageHead();
        oidb_0x614$DeviceManageHead.uint32_cmd.set(0);
        oidb_0x614$DeviceManageHead.uint32_result.set(0);
        oidb_0x614$DeviceManageHead.uint64_uin.set(j18);
        oidb_0x614$DeviceManageHead.bytes_guid.set(ByteStringMicro.copyFrom(byteArray));
        int i16 = (int) j16;
        oidb_0x614$DeviceManageHead.uint32_appid.set(i16);
        int i17 = (int) j17;
        oidb_0x614$DeviceManageHead.uint32_subappid.set(i17);
        oidb_0x614$DeviceManageHead.bytes_appname.set(ByteStringMicro.copyFromUtf8(string2));
        Oidb_0x614$ReNameDeviceNameReqBody oidb_0x614$ReNameDeviceNameReqBody = new Oidb_0x614$ReNameDeviceNameReqBody();
        oidb_0x614$ReNameDeviceNameReqBody.bytes_guid.set(ByteStringMicro.copyFrom(byteArray));
        oidb_0x614$ReNameDeviceNameReqBody.uint32_appid.set(i16);
        oidb_0x614$ReNameDeviceNameReqBody.uint32_subappid.set(i17);
        oidb_0x614$ReNameDeviceNameReqBody.bytes_appname.set(ByteStringMicro.copyFromUtf8(string2));
        oidb_0x614$ReNameDeviceNameReqBody.bytes_device_des.set(ByteStringMicro.copyFrom(byteArray2));
        oidb_0x614$ReNameDeviceNameReqBody.bytes_rename_device_name.set(ByteStringMicro.copyFromUtf8(string3));
        Oidb_0x614$ReqBody oidb_0x614$ReqBody = new Oidb_0x614$ReqBody();
        oidb_0x614$ReqBody.msg_dm_head.set(oidb_0x614$DeviceManageHead);
        oidb_0x614$ReqBody.msg_mdn_req_body.set(oidb_0x614$ReNameDeviceNameReqBody);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1556);
        oidb_sso_oidbssopkg.uint32_service_type.set(1);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x614$ReqBody.toByteArray()));
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", string, "OidbSvc.0x614_1");
        toServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        toServiceMsg.extraData.putLong("uin", j18);
        toServiceMsg.extraData.putString("target_name", string3);
        toServiceMsg.extraData.putByteArray("target_desc", byteArray2);
        toServiceMsg.extraData.putInt("index", i3);
        sendPbReq(toServiceMsg);
    }

    public void V2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        int i3 = 2;
        if (QLog.isColorLevel()) {
            QLog.d("SecSvcHandler", 2, "setWXSyncQQMsgOption");
        }
        wx_msg_opt$ReqBody wx_msg_opt_reqbody = new wx_msg_opt$ReqBody();
        wx_msg_opt_reqbody.uint64_uin.set(((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getLongAccountUin());
        wx_msg_opt_reqbody.uint32_cmd.set(2);
        PBUInt32Field pBUInt32Field = wx_msg_opt_reqbody.uint32_seq;
        int i16 = this.f195060d;
        this.f195060d = i16 + 1;
        pBUInt32Field.set(i16);
        PBUInt32Field pBUInt32Field2 = wx_msg_opt_reqbody.uint32_opt;
        if (z16) {
            i3 = 1;
        }
        pBUInt32Field2.set(i3);
        ToServiceMsg createToServiceMsg = createToServiceMsg("DevLockAuthSvc.WxMsgOpt");
        createToServiceMsg.putWupBuffer(wx_msg_opt_reqbody.toByteArray());
        sendPbReq(createToServiceMsg);
    }

    public void W2(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bArr);
            return;
        }
        if (bArr == null) {
            notifyUI(8, false, -1);
            return;
        }
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 7);
        allocate.putShort((short) 3);
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        allocate.putInt((int) qQAppInterface.getLongAccountUin());
        allocate.put((byte) bArr.length);
        allocate.put(bArr);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1197);
        oidb_sso_oidbssopkg.uint32_service_type.set(11);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", qQAppInterface.getCurrentAccountUin(), "OidbSvc.0x4ad");
        toServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        sendPbReq(toServiceMsg);
    }

    public void X2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            sendPbReq(makeOIDBPkg("OidbSvc.0xec0", 3776, 0, new MessageMicro<oidb_0xec0$ReqBody>() { // from class: tencent.im.oidb.cmd0xec0.oidb_0xec0$ReqBody
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0xec0$ReqBody.class);
            }.toByteArray()));
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return cx.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (serviceCmd.equalsIgnoreCase("SecuritySvc.GetConfig")) {
            K2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (serviceCmd.equalsIgnoreCase("DevLockAuthSvc.WxMsgOpt")) {
            R2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (serviceCmd.equalsIgnoreCase("DevLockSecSvc.DevLockQuery")) {
            N2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (serviceCmd.equalsIgnoreCase("OidbSvc.0x614_1")) {
            O2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (serviceCmd.equalsIgnoreCase("OidbSvc.0xa13")) {
            J2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (serviceCmd.equalsIgnoreCase("OidbSvc.0x4ad")) {
            P2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (serviceCmd.equalsIgnoreCase("OidbSvc.0xeb8")) {
            L2(toServiceMsg, fromServiceMsg, obj);
        } else if (serviceCmd.equalsIgnoreCase("OidbSvc.0xebd")) {
            M2(toServiceMsg, fromServiceMsg, obj);
        } else if (serviceCmd.equalsIgnoreCase("OidbSvc.0xec0")) {
            Q2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
