package com.tencent.mobileqq.onlinestatus;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.oidb.cmd0xe62$ReqBody;
import tencent.im.oidb.cmd0xe63.oidb_cmd0xe63$ReqBody;
import tencent.im.oidb.cmd0xe63.oidb_cmd0xe63$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes16.dex */
public class bc extends MSFServlet {
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Intent intent, FromServiceMsg fromServiceMsg) {
        boolean z16;
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg;
        int i3;
        long longExtra = intent.getLongExtra("param_online_status_type", 0L);
        boolean z17 = true;
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusPermissionServlet", 2, "handleModifyOnlineStatusPermission | onlineStatusType = ", Long.valueOf(longExtra));
        }
        Bundle bundleExtra = intent.getBundleExtra("param_extra_bundle");
        if (fromServiceMsg.isSuccess()) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg2 = null;
            try {
                oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                try {
                    byte[] bArr = new byte[r15.getInt() - 4];
                    ByteBuffer.wrap(fromServiceMsg.getWupBuffer()).get(bArr);
                    oidb_sso_oidbssopkg.mergeFrom(bArr);
                } catch (InvalidProtocolBufferMicroException e16) {
                    e = e16;
                    oidb_sso_oidbssopkg2 = oidb_sso_oidbssopkg;
                    if (QLog.isColorLevel()) {
                        QLog.d("OnlineStatusPermissionServlet", 2, "handleModifyOnlineStatusPermission parseFrom byte", e);
                    }
                    oidb_sso_oidbssopkg = oidb_sso_oidbssopkg2;
                    i3 = oidb_sso_oidbssopkg.uint32_result.get();
                    if (QLog.isColorLevel()) {
                    }
                    if (i3 != 0) {
                    }
                    z16 = z17;
                    notifyObserver(intent, 2, z16, bundleExtra, bb.class);
                }
            } catch (InvalidProtocolBufferMicroException e17) {
                e = e17;
            }
            i3 = oidb_sso_oidbssopkg.uint32_result.get();
            if (QLog.isColorLevel()) {
                QLog.d("OnlineStatusPermissionServlet", 2, "handleModifyOnlineStatusPermission | result = ", Integer.valueOf(i3));
            }
            if (i3 != 0) {
                f(getAppRuntime(), intent);
                boolean z18 = bundleExtra.getBoolean("param_need_switch_online_status", false);
                int i16 = bundleExtra.getInt("StatusId", 0);
                if (z18) {
                    ((IOnlineStatusService) getAppRuntime().getRuntimeService(IOnlineStatusService.class, "")).updateOnlineStatus(AppRuntime.Status.online, i16);
                }
            } else {
                z17 = false;
            }
            z16 = z17;
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("OnlineStatusPermissionServlet", 2, "handleModifyOnlineStatusPermission | response.result = " + fromServiceMsg.getResultCode());
            }
            z16 = false;
        }
        notifyObserver(intent, 2, z16, bundleExtra, bb.class);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(Intent intent, FromServiceMsg fromServiceMsg) {
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg;
        int i3;
        long longExtra = intent.getLongExtra("param_online_status_type", 0L);
        boolean z16 = false;
        boolean booleanExtra = intent.getBooleanExtra("from_register", false);
        Bundle bundle = new Bundle();
        bundle.putBoolean("from_register", booleanExtra);
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusPermissionServlet", 2, "handleOnlineStatusPermission | onlineStatusType = ", Long.valueOf(longExtra));
        }
        if (fromServiceMsg.isSuccess()) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg2 = null;
            try {
                oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            } catch (InvalidProtocolBufferMicroException e16) {
                e = e16;
            }
            try {
                byte[] bArr = new byte[r13.getInt() - 4];
                ByteBuffer.wrap(fromServiceMsg.getWupBuffer()).get(bArr);
                oidb_sso_oidbssopkg.mergeFrom(bArr);
            } catch (InvalidProtocolBufferMicroException e17) {
                e = e17;
                oidb_sso_oidbssopkg2 = oidb_sso_oidbssopkg;
                if (QLog.isColorLevel()) {
                    QLog.d("OnlineStatusPermissionServlet", 2, "handleOnlineStatusPermission parseFrom byte", e);
                }
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg2;
                i3 = oidb_sso_oidbssopkg.uint32_result.get();
                if (QLog.isColorLevel()) {
                }
                if (i3 == 0) {
                    byte[] byteArray = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
                    try {
                        oidb_cmd0xe63$RspBody oidb_cmd0xe63_rspbody = new oidb_cmd0xe63$RspBody();
                        oidb_cmd0xe63_rspbody.mergeFrom(byteArray);
                        g(oidb_cmd0xe63_rspbody);
                        z16 = true;
                    } catch (InvalidProtocolBufferMicroException e18) {
                        if (QLog.isColorLevel()) {
                            QLog.d("OnlineStatusPermissionServlet", 2, "handleOnlineStatusPermission erro ", e18);
                        }
                    }
                }
                notifyObserver(intent, 1, z16, bundle, bb.class);
            }
            i3 = oidb_sso_oidbssopkg.uint32_result.get();
            if (QLog.isColorLevel()) {
                QLog.d("OnlineStatusPermissionServlet", 2, "handleOnlineStatusPermission | result = ", Integer.valueOf(i3));
            }
            if (i3 == 0 && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                byte[] byteArray2 = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
                oidb_cmd0xe63$RspBody oidb_cmd0xe63_rspbody2 = new oidb_cmd0xe63$RspBody();
                oidb_cmd0xe63_rspbody2.mergeFrom(byteArray2);
                g(oidb_cmd0xe63_rspbody2);
                z16 = true;
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusPermissionServlet", 2, "handleOnlineStatusPermission | response.result = " + fromServiceMsg.getResultCode());
        }
        notifyObserver(intent, 1, z16, bundle, bb.class);
    }

    private void c(Intent intent, Packet packet) {
        long longExtra = intent.getLongExtra("param_online_status_type", 0L);
        boolean z16 = true;
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusPermissionServlet", 2, "packModifyOnlineStatusPermission | onlineStatusType = ", Long.valueOf(longExtra));
        }
        int intExtra = intent.getIntExtra("param_has_all_permission", 0);
        long[] longArrayExtra = intent.getLongArrayExtra("param_part_permission_list");
        ArrayList<Integer> integerArrayListExtra = intent.getIntegerArrayListExtra("param_smart_status_list");
        cmd0xe62$ReqBody cmd0xe62_reqbody = new cmd0xe62$ReqBody();
        if (intExtra == 1 || intExtra == 2) {
            cmd0xe62_reqbody.set_type.set(intExtra);
            if (longArrayExtra != null) {
                ArrayList arrayList = new ArrayList(longArrayExtra.length);
                for (long j3 : longArrayExtra) {
                    arrayList.add(Long.valueOf(j3));
                }
                cmd0xe62_reqbody.rpt_uint64_uin.set(arrayList);
            }
        }
        if (integerArrayListExtra != null) {
            if (integerArrayListExtra.size() > 0) {
                z16 = false;
            }
            cmd0xe62_reqbody.bool_clear_smart_status.set(z16);
            cmd0xe62_reqbody.rpt_uint32_smart_status.set(integerArrayListExtra);
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(3682);
        oidb_sso_oidbssopkg.uint32_service_type.set(2);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(cmd0xe62_reqbody.toByteArray()));
        byte[] byteArray = oidb_sso_oidbssopkg.toByteArray();
        packet.setSSOCommand("OidbSvc.0xe63_1");
        ByteBuffer allocate = ByteBuffer.allocate(byteArray.length + 4);
        allocate.putInt(byteArray.length + 4);
        allocate.put(byteArray);
        packet.putSendData(allocate.array());
    }

    private void d(Intent intent, Packet packet) {
        long longExtra = intent.getLongExtra("param_online_status_type", 0L);
        boolean booleanExtra = intent.getBooleanExtra("param_fetch_only_smart_devices", false);
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusPermissionServlet", 2, "packOnlineStatusPermission | onlineStatusType = ", Long.valueOf(longExtra), "onlySmartDevices = ", Boolean.valueOf(booleanExtra));
        }
        oidb_cmd0xe63$ReqBody oidb_cmd0xe63_reqbody = new oidb_cmd0xe63$ReqBody();
        oidb_cmd0xe63_reqbody.uint32_req_type.set(1);
        oidb_cmd0xe63_reqbody.bool_only_smart_status.set(booleanExtra);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(3683);
        oidb_sso_oidbssopkg.uint32_service_type.set(1);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_cmd0xe63_reqbody.toByteArray()));
        byte[] byteArray = oidb_sso_oidbssopkg.toByteArray();
        packet.setSSOCommand("OidbSvc.0xe63_1");
        ByteBuffer allocate = ByteBuffer.allocate(byteArray.length + 4);
        allocate.putInt(byteArray.length + 4);
        allocate.put(byteArray);
        packet.putSendData(allocate.array());
    }

    public static NewIntent e(AppRuntime appRuntime, long j3, boolean z16, boolean z17) {
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusPermissionServlet", 2, "requestOnlineStatusPermission | onlineStatusType = ", Long.valueOf(j3));
        }
        NewIntent newIntent = new NewIntent(appRuntime.getApplication(), bc.class);
        newIntent.putExtra("param_online_status_request", 1);
        newIntent.putExtra("param_online_status_type", j3);
        newIntent.putExtra("param_fetch_only_smart_devices", z16);
        newIntent.putExtra("from_register", z17);
        appRuntime.startServlet(newIntent);
        return newIntent;
    }

    private void f(AppRuntime appRuntime, Intent intent) {
        ArrayList arrayList;
        OnlineStatusPermissionManager onlineStatusPermissionManager = (OnlineStatusPermissionManager) ((IOnlineStatusManagerService) appRuntime.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(com.tencent.mobileqq.onlinestatus.manager.i.class);
        int intExtra = intent.getIntExtra("param_has_all_permission", 0);
        long[] longArrayExtra = intent.getLongArrayExtra("param_part_permission_list");
        ArrayList<Integer> integerArrayListExtra = intent.getIntegerArrayListExtra("param_smart_status_list");
        boolean z16 = true;
        if (intExtra == 1 || intExtra == 2) {
            if (intExtra != 1) {
                z16 = false;
            }
            if (longArrayExtra != null) {
                arrayList = new ArrayList(longArrayExtra.length);
                for (long j3 : longArrayExtra) {
                    arrayList.add(Long.valueOf(j3));
                }
            } else {
                arrayList = null;
            }
            onlineStatusPermissionManager.K(new OnlineStatusFriendsPermissionItem(z16, arrayList));
        }
        if (integerArrayListExtra != null) {
            onlineStatusPermissionManager.N(integerArrayListExtra);
        }
    }

    private void g(oidb_cmd0xe63$RspBody oidb_cmd0xe63_rspbody) {
        boolean z16;
        List<Long> list;
        List<Integer> arrayList;
        if (oidb_cmd0xe63_rspbody.bool_online_status_visible_to_all_frd.has()) {
            z16 = oidb_cmd0xe63_rspbody.bool_online_status_visible_to_all_frd.get();
            if (QLog.isColorLevel()) {
                QLog.d("OnlineStatusPermissionServlet", 2, "handleOnlineStatusPermission | entity.allHasPermission = ", Boolean.valueOf(z16));
            }
        } else {
            z16 = true;
        }
        if (oidb_cmd0xe63_rspbody.rpt_uint64_uin_can_see_my_online_status.has()) {
            if (oidb_cmd0xe63_rspbody.rpt_uint64_uin_can_see_my_online_status.get() == null) {
                list = new ArrayList<>(0);
            } else {
                list = oidb_cmd0xe63_rspbody.rpt_uint64_uin_can_see_my_online_status.get();
            }
            if (QLog.isColorLevel()) {
                QLog.d("OnlineStatusPermissionServlet", 2, "handleOnlineStatusPermission | entity.hasPermissionList.size=", Integer.valueOf(list.size()));
            }
        } else {
            list = null;
        }
        if (oidb_cmd0xe63_rspbody.rpt_uint32_smart_status.has()) {
            if (oidb_cmd0xe63_rspbody.rpt_uint32_smart_status.get() == null) {
                arrayList = new ArrayList<>(0);
            } else {
                arrayList = oidb_cmd0xe63_rspbody.rpt_uint32_smart_status.get();
            }
            if (QLog.isColorLevel()) {
                QLog.d("OnlineStatusPermissionServlet", 2, "handleOnlineStatusPermission | entity.smartSelectedStatusList.size=", Integer.valueOf(arrayList.size()));
            }
        } else {
            arrayList = new ArrayList<>(0);
        }
        if (!z16 && arrayList.size() <= 0) {
            if (QLog.isColorLevel()) {
                QLog.d("OnlineStatusPermissionServlet", 2, "saveReceiveData | params is error");
            }
        } else {
            OnlineStatusPermissionManager onlineStatusPermissionManager = (OnlineStatusPermissionManager) ((IOnlineStatusManagerService) getAppRuntime().getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(com.tencent.mobileqq.onlinestatus.manager.i.class);
            OnlineStatusFriendsPermissionItem onlineStatusFriendsPermissionItem = new OnlineStatusFriendsPermissionItem(z16, list);
            onlineStatusPermissionManager.N(arrayList);
            onlineStatusPermissionManager.K(onlineStatusFriendsPermissionItem);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        String str;
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (QLog.isColorLevel()) {
            boolean isSuccess = fromServiceMsg.isSuccess();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("OnlineStatusPermissionServlet onReceive:");
            sb5.append(serviceCmd);
            sb5.append(" is ");
            if (isSuccess) {
                str = "";
            } else {
                str = "not";
            }
            sb5.append(str);
            sb5.append(" success");
            QLog.d("OnlineStatusPermissionServlet", 2, sb5.toString());
        }
        if (serviceCmd != null && serviceCmd.equals("OidbSvc.0xe63_1")) {
            int intExtra = intent.getIntExtra("param_online_status_request", 0);
            if (QLog.isColorLevel()) {
                QLog.d("OnlineStatusPermissionServlet", 2, "OnlineStatusPermissionServlet onReceive reqType", Integer.valueOf(intExtra));
            }
            if (intExtra == 1) {
                b(intent, fromServiceMsg);
            } else if (intExtra == 2) {
                a(intent, fromServiceMsg);
            }
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        int intExtra = intent.getIntExtra("param_online_status_request", 0);
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusPermissionServlet", 2, "OnlineStatusPermissionServlet onSend reqType", Integer.valueOf(intExtra));
        }
        if (intExtra == 1) {
            d(intent, packet);
        } else if (intExtra == 2) {
            c(intent, packet);
        }
    }
}
