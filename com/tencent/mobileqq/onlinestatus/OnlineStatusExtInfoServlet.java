package com.tencent.mobileqq.onlinestatus;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import kc2.b;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.oidb.cmd0xe84.oidb_0xe84$Condition;
import tencent.im.oidb.cmd0xe84.oidb_0xe84$CustomData;
import tencent.im.oidb.cmd0xe84.oidb_0xe84$ReqBody;
import tencent.im.oidb.cmd0xe84.oidb_0xe84$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OnlineStatusExtInfoServlet extends MSFServlet {
    /* JADX WARN: Removed duplicated region for block: B:19:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Intent intent, FromServiceMsg fromServiceMsg) {
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg;
        int i3;
        boolean z16;
        boolean z17;
        AppRuntime appRuntime;
        int i16;
        List<oidb_0xe84$CustomData> list;
        boolean z18;
        String str = "";
        String stringExtra = intent.getStringExtra("param_constellation");
        String stringExtra2 = intent.getStringExtra("param_today_date");
        boolean z19 = false;
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusExtInfoServlet", 2, "handleGetConstellationTrend | constellation = ", stringExtra, " todayDate: ", stringExtra2);
        }
        Bundle bundle = new Bundle();
        if (fromServiceMsg.isSuccess()) {
            try {
                oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            } catch (InvalidProtocolBufferMicroException e16) {
                e = e16;
                oidb_sso_oidbssopkg = null;
            }
            try {
                ByteBuffer wrap = ByteBuffer.wrap(fromServiceMsg.getWupBuffer());
                byte[] bArr = new byte[wrap.getInt() - 4];
                wrap.get(bArr);
                oidb_sso_oidbssopkg.mergeFrom(bArr);
            } catch (InvalidProtocolBufferMicroException e17) {
                e = e17;
                if (QLog.isColorLevel()) {
                    QLog.d("OnlineStatusExtInfoServlet", 2, "handleGetConstellationTrend parseFrom byte", e);
                }
                i3 = oidb_sso_oidbssopkg.uint32_result.get();
                if (QLog.isColorLevel()) {
                }
                if (i3 != 0) {
                }
                z16 = false;
                z19 = z16;
                z17 = z19;
                notifyObserver(intent, 1, z17, bundle, kc2.e.class);
            }
            i3 = oidb_sso_oidbssopkg.uint32_result.get();
            if (QLog.isColorLevel()) {
                QLog.d("OnlineStatusExtInfoServlet", 2, "handleGetConstellationTrend | result = ", Integer.valueOf(i3));
            }
            if (i3 != 0 && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                byte[] byteArray = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
                try {
                    appRuntime = getAppRuntime();
                    oidb_0xe84$RspBody oidb_0xe84_rspbody = new oidb_0xe84$RspBody();
                    oidb_0xe84_rspbody.mergeFrom(byteArray);
                    i16 = oidb_0xe84_rspbody.uint32_interval.get();
                    kc2.c.s(appRuntime, i16);
                    list = oidb_0xe84_rspbody.msg_custom_data.get();
                } catch (InvalidProtocolBufferMicroException e18) {
                    e = e18;
                }
                if (list.size() == 2) {
                    try {
                        oidb_0xe84$CustomData oidb_0xe84_customdata = list.get(0);
                        byte[] byteArray2 = oidb_0xe84_customdata.bytes_data.get().toByteArray();
                        byte[] byteArray3 = oidb_0xe84_customdata.bytes_jump_link.get().toByteArray();
                        String str2 = new String(oidb_0xe84_customdata.bytes_png_link.get().toByteArray());
                        String str3 = new String(oidb_0xe84_customdata.bytes_icon_link.get().toByteArray());
                        String str4 = new String(oidb_0xe84_customdata.bytes_text_color.get().toByteArray());
                        String str5 = new String(byteArray2);
                        String str6 = new String(byteArray3);
                        String str7 = new String(list.get(1).bytes_data.get().toByteArray());
                        try {
                            String x16 = kc2.c.x(appRuntime);
                            if (!str5.equals(x16)) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("OnlineStatusExtInfoServlet", 2, "handleGetConstellationTrend: invoked. ", " jsonChanged: ", Boolean.valueOf(z18), " cacheTrendJson: ", x16, " constellationJson: ", str5);
                            }
                            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(appRuntime.getCurrentAccountUin());
                            IOnlineStatusInfoService iOnlineStatusInfoService = (IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class);
                            com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c onlineStatusSimpleInfoWithUid = iOnlineStatusInfoService.getOnlineStatusSimpleInfoWithUid(uidFromUin, "OnlineStatusExtInfoServlet");
                            if (onlineStatusSimpleInfoWithUid != null) {
                                onlineStatusSimpleInfoWithUid.x0(str3);
                                onlineStatusSimpleInfoWithUid.y0(str6);
                                onlineStatusSimpleInfoWithUid.v0(str2);
                                onlineStatusSimpleInfoWithUid.w0(kc2.c.g());
                                iOnlineStatusInfoService.updateOnlineStatusSimpleInfo(onlineStatusSimpleInfoWithUid, "OnlineStatusExtInfoServlet", (hx3.c<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a>) null);
                                kc2.c.s(appRuntime, i16);
                                kc2.c.t(appRuntime, str5);
                                kc2.c.r(appRuntime, str4);
                                String p16 = onlineStatusSimpleInfoWithUid.p();
                                if (z18 || TextUtils.isEmpty(p16) || TextUtils.isEmpty(x16)) {
                                    String c16 = new kc2.b().e(str5).c();
                                    String c17 = new kc2.b().e(str7).c();
                                    if (!TextUtils.isEmpty(c16)) {
                                        onlineStatusSimpleInfoWithUid.B0(stringExtra + APLogFileUtil.SEPARATOR_LOG + c16);
                                    } else {
                                        onlineStatusSimpleInfoWithUid.B0(null);
                                    }
                                    if (!TextUtils.isEmpty(c17)) {
                                        onlineStatusSimpleInfoWithUid.C0(stringExtra + APLogFileUtil.SEPARATOR_LOG + c17);
                                    } else {
                                        onlineStatusSimpleInfoWithUid.C0(null);
                                    }
                                    kc2.b e19 = new kc2.b().e(str5);
                                    b.Companion companion = kc2.b.INSTANCE;
                                    onlineStatusSimpleInfoWithUid.z0(e19.d(companion.a()));
                                    onlineStatusSimpleInfoWithUid.A0(new kc2.b().e(str5).d(companion.b()));
                                    iOnlineStatusInfoService.updateOnlineStatusSimpleInfo(onlineStatusSimpleInfoWithUid, "OnlineStatusExtInfoServlet", (hx3.c<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a>) null);
                                }
                            }
                            if (((IOnlineStatusService) appRuntime.getRuntimeService(IOnlineStatusService.class, "")).getExtOnlineStatus() == 1040) {
                                kc2.d.f412021a.a(appRuntime, 1040);
                            }
                            String v3 = kc2.c.v(appRuntime, appRuntime.getCurrentAccountUin());
                            String[] split = v3.split("\\|");
                            if (split.length == 2) {
                                str = split[1].trim();
                            }
                            bundle.putString("key_today_constellation_trend", str);
                            if (QLog.isColorLevel()) {
                                QLog.d("OnlineStatusExtInfoServlet", 2, "handleGetConstellationTrend: invoked. ", " suitableTrend: ", v3);
                            }
                            z19 = true;
                        } catch (InvalidProtocolBufferMicroException e26) {
                            e = e26;
                            z19 = true;
                        }
                    } catch (InvalidProtocolBufferMicroException e27) {
                        e = e27;
                        z19 = false;
                    }
                    z17 = z19;
                } else {
                    try {
                        if (QLog.isColorLevel()) {
                            Object[] objArr = new Object[3];
                            z16 = false;
                            try {
                                objArr[0] = "handleGetConstellationTrend: invoked. error ";
                                objArr[1] = " customDatas: ";
                                objArr[2] = Integer.valueOf(list.size());
                                QLog.d("OnlineStatusExtInfoServlet", 2, objArr);
                            } catch (InvalidProtocolBufferMicroException e28) {
                                e = e28;
                                z19 = z16;
                                QLog.e("OnlineStatusExtInfoServlet", 1, "handleGetConstellationTrend: failed. ", e);
                                z17 = z19;
                                notifyObserver(intent, 1, z17, bundle, kc2.e.class);
                            }
                        } else {
                            z16 = false;
                        }
                    } catch (InvalidProtocolBufferMicroException e29) {
                        e = e29;
                        z16 = false;
                    }
                }
                QLog.e("OnlineStatusExtInfoServlet", 1, "handleGetConstellationTrend: failed. ", e);
                z17 = z19;
            } else {
                z16 = false;
            }
            z19 = z16;
            z17 = z19;
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("OnlineStatusExtInfoServlet", 2, "handleGetConstellationTrend | response.result = " + fromServiceMsg.getResultCode());
            }
            z17 = false;
        }
        notifyObserver(intent, 1, z17, bundle, kc2.e.class);
    }

    public static NewIntent b(AppRuntime appRuntime, String str) {
        NewIntent newIntent = new NewIntent(appRuntime.getApplication(), OnlineStatusExtInfoServlet.class);
        newIntent.putExtra("param_request_type", 1);
        newIntent.putExtra("param_constellation", str);
        newIntent.putExtra("param_today_date", kc2.c.g());
        newIntent.putExtra("param_tomorrow_date", kc2.c.y());
        appRuntime.startServlet(newIntent);
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusExtInfoServlet", 2, "requestConstellationTrendTwoDay: invoked. ", " constellation: ", str);
        }
        return newIntent;
    }

    private void c(Intent intent, Packet packet) {
        String stringExtra = intent.getStringExtra("param_constellation");
        String stringExtra2 = intent.getStringExtra("param_today_date");
        String stringExtra3 = intent.getStringExtra("param_tomorrow_date");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        oidb_0xe84$ReqBody oidb_0xe84_reqbody = new oidb_0xe84$ReqBody();
        oidb_0xe84$Condition oidb_0xe84_condition = new oidb_0xe84$Condition();
        oidb_0xe84_condition.bytes_key.set(ByteStringMicro.copyFromUtf8(stringExtra));
        oidb_0xe84_condition.bytes_date.set(ByteStringMicro.copyFromUtf8(stringExtra2));
        oidb_0xe84$Condition oidb_0xe84_condition2 = new oidb_0xe84$Condition();
        oidb_0xe84_condition2.bytes_key.set(ByteStringMicro.copyFromUtf8(stringExtra));
        oidb_0xe84_condition2.bytes_date.set(ByteStringMicro.copyFromUtf8(stringExtra3));
        oidb_0xe84_reqbody.msg_condi.set(new ArrayList<oidb_0xe84$Condition>(oidb_0xe84_condition, oidb_0xe84_condition2) { // from class: com.tencent.mobileqq.onlinestatus.OnlineStatusExtInfoServlet.1
            final /* synthetic */ oidb_0xe84$Condition val$condition;
            final /* synthetic */ oidb_0xe84$Condition val$condition2;

            {
                this.val$condition = oidb_0xe84_condition;
                this.val$condition2 = oidb_0xe84_condition2;
                add(oidb_0xe84_condition);
                add(oidb_0xe84_condition2);
            }
        });
        oidb_0xe84_reqbody.uint64_appid.set(1108937847L);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(3716);
        oidb_sso_oidbssopkg.uint32_service_type.set(1);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0xe84_reqbody.toByteArray()));
        byte[] byteArray = oidb_sso_oidbssopkg.toByteArray();
        packet.setSSOCommand("OidbSvc.0xe84_1");
        ByteBuffer allocate = ByteBuffer.allocate(byteArray.length + 4);
        allocate.putInt(byteArray.length + 4);
        allocate.put(byteArray);
        packet.putSendData(allocate.array());
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        String str;
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (QLog.isColorLevel()) {
            boolean isSuccess = fromServiceMsg.isSuccess();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onReceive:");
            sb5.append(serviceCmd);
            sb5.append(" is ");
            if (isSuccess) {
                str = "";
            } else {
                str = "not";
            }
            sb5.append(str);
            sb5.append(" success");
            QLog.d("OnlineStatusExtInfoServlet", 2, sb5.toString());
        }
        if (serviceCmd != null && serviceCmd.equals("OidbSvc.0xe84_1")) {
            int intExtra = intent.getIntExtra("param_request_type", 0);
            if (QLog.isColorLevel()) {
                QLog.d("OnlineStatusExtInfoServlet", 2, "onReceive reqType", Integer.valueOf(intExtra));
            }
            if (intExtra == 1) {
                a(intent, fromServiceMsg);
            }
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        int intExtra = intent.getIntExtra("param_request_type", 0);
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusExtInfoServlet", 2, " onSend reqType", Integer.valueOf(intExtra));
        }
        if (intExtra == 1) {
            c(intent, packet);
        }
    }
}
