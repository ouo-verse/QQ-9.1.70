package jr;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import appoint.define.appoint_define$GPS;
import appoint.define.appoint_define$LBSInfo;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.mini.servlet.MiniAppTranRoomIdServlet;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import tencent.im.oidb.cmd0x983.oidb_cmd0x983$AddonItem;
import tencent.im.oidb.cmd0x983.oidb_cmd0x983$ReqBody;
import tencent.im.oidb.cmd0x983.oidb_cmd0x983$RspBody;
import tencent.im.oidb.lbspack.MqqLbsPack$LBSSig;
import tencent.im.oidb.lbspack.MqqLbsPack$PoiInfo;
import tencent.im.oidb.lbspack.MqqLbsPack$ReqGetLBSPID;
import tencent.im.oidb.lbspack.MqqLbsPack$ReqGetPOIList;
import tencent.im.oidb.lbspack.MqqLbsPack$ReqOpenLBSRPReport;
import tencent.im.oidb.lbspack.MqqLbsPack$RspGetLBSPID;
import tencent.im.oidb.lbspack.MqqLbsPack$RspGetPOIList;
import tencent.im.oidb.lbspack.MqqLbsPack$RspHead;
import tencent.im.oidb.lbspack.MqqLbsPack$RspOpenLBSRPReport;
import tencent.im.oidb.lbspack.MqqLbsPack$SelectedUinInfo;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b extends MSFServlet {
    public static ByteStringMicro a(String str) {
        byte[] bytes = !TextUtils.isEmpty(str) ? str.getBytes() : null;
        if (bytes != null) {
            return ByteStringMicro.copyFrom(bytes);
        }
        return null;
    }

    public int b(int i3) {
        if (i3 != 1) {
            if (i3 == 2) {
                return 3;
            }
            if (i3 == 3) {
                return 1;
            }
            if (i3 != 4) {
                return -1;
            }
            return 7;
        }
        return 0;
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        byte[] byteArray;
        String str;
        int intExtra = intent.getIntExtra("k_cmd", 0);
        if (intExtra == 1) {
            int intExtra2 = intent.getIntExtra("key_longitude", 0);
            int intExtra3 = intent.getIntExtra(AECameraConstants.KEY_LATITUDE, 0);
            MqqLbsPack$LBSSig mqqLbsPack$LBSSig = new MqqLbsPack$LBSSig();
            mqqLbsPack$LBSSig.int32_lon.set(intExtra2);
            mqqLbsPack$LBSSig.int32_lat.set(intExtra3);
            mqqLbsPack$LBSSig.uint32_time.set(intent.getIntExtra("key_time", 0));
            String stringExtra = intent.getStringExtra("key_verify_key");
            if (stringExtra != null) {
                mqqLbsPack$LBSSig.bytes_verify_key.set(a(stringExtra));
            }
            int intExtra4 = intent.getIntExtra("key_longitude_cur", 0);
            int intExtra5 = intent.getIntExtra("key_latitude_cur", 0);
            if (QLog.isColorLevel()) {
                QLog.d("LbsPack", 2, "LbsPackPoiListServlet onSend CMD_GET_POI_LIST_REQ  longitude_cur = " + intExtra4 + ", latitude_cur = " + intExtra5 + ", longitude = " + intExtra2 + ", latitude = " + intExtra3);
            }
            MqqLbsPack$ReqGetPOIList mqqLbsPack$ReqGetPOIList = new MqqLbsPack$ReqGetPOIList();
            mqqLbsPack$ReqGetPOIList.int32_lon.set(intExtra4);
            mqqLbsPack$ReqGetPOIList.int32_lat.set(intExtra5);
            mqqLbsPack$ReqGetPOIList.msg_lbs_sig.set(mqqLbsPack$LBSSig);
            mqqLbsPack$ReqGetPOIList.uint32_lbs_accuracy.set(intent.getIntExtra("key_accuracy", 0));
            String stringExtra2 = intent.getStringExtra("key_encrypt_sig");
            if (stringExtra2 != null) {
                mqqLbsPack$ReqGetPOIList.bytes_encrypt_sig.set(a(stringExtra2));
            }
            byteArray = mqqLbsPack$ReqGetPOIList.toByteArray();
            str = "LBSRedPack.ReqGetPOIList";
        } else if (intExtra == 2) {
            long longExtra = intent.getLongExtra("key_poi_id", 0L);
            String stringExtra3 = intent.getStringExtra("key_pid");
            int intExtra6 = intent.getIntExtra("key_pack_status", 0);
            MqqLbsPack$ReqOpenLBSRPReport mqqLbsPack$ReqOpenLBSRPReport = new MqqLbsPack$ReqOpenLBSRPReport();
            mqqLbsPack$ReqOpenLBSRPReport.uint64_poi_id.set(longExtra);
            if (stringExtra3 != null && !TextUtils.isEmpty(stringExtra3)) {
                mqqLbsPack$ReqOpenLBSRPReport.bytes_pid.set(a(stringExtra3), true);
            }
            mqqLbsPack$ReqOpenLBSRPReport.uint32_status.set(intExtra6);
            byteArray = mqqLbsPack$ReqOpenLBSRPReport.toByteArray();
            str = "LBSRedPack.ReqOpenLBSRPReport";
        } else if (intExtra == 3) {
            int intExtra7 = intent.getIntExtra("key_longitude", 0);
            int intExtra8 = intent.getIntExtra(AECameraConstants.KEY_LATITUDE, 0);
            MqqLbsPack$LBSSig mqqLbsPack$LBSSig2 = new MqqLbsPack$LBSSig();
            mqqLbsPack$LBSSig2.int32_lon.set(intExtra7);
            mqqLbsPack$LBSSig2.int32_lat.set(intExtra8);
            mqqLbsPack$LBSSig2.uint32_time.set(intent.getIntExtra("key_time", 0));
            String stringExtra4 = intent.getStringExtra("key_verify_key");
            if (stringExtra4 != null) {
                mqqLbsPack$LBSSig2.bytes_verify_key.set(a(stringExtra4));
            }
            MqqLbsPack$SelectedUinInfo mqqLbsPack$SelectedUinInfo = new MqqLbsPack$SelectedUinInfo();
            mqqLbsPack$SelectedUinInfo.uint32_all_frd.set(intent.getIntExtra("key_all_friends_flag", 0));
            long longExtra2 = intent.getLongExtra(MiniAppTranRoomIdServlet.KEY_GROUP_ID, 0L);
            if (longExtra2 != 0) {
                mqqLbsPack$SelectedUinInfo.uint64_group_code.set(longExtra2);
            }
            long longExtra3 = intent.getLongExtra("key_dicuss_id", 0L);
            if (longExtra3 != 0) {
                mqqLbsPack$SelectedUinInfo.uint64_discuss_uin.set(longExtra3);
            }
            long longExtra4 = intent.getLongExtra("key_friend_uin", 0L);
            if (longExtra4 != 0) {
                mqqLbsPack$SelectedUinInfo.uint64_uin.set(longExtra4);
            }
            int intExtra9 = intent.getIntExtra("key_poi_latitude", 0);
            int intExtra10 = intent.getIntExtra("key_poi_longitude", 0);
            MqqLbsPack$PoiInfo mqqLbsPack$PoiInfo = new MqqLbsPack$PoiInfo();
            mqqLbsPack$PoiInfo.int32_lat.set(intExtra9);
            mqqLbsPack$PoiInfo.int32_lon.set(intExtra10);
            String stringExtra5 = intent.getStringExtra("key_poi_NAME");
            if (stringExtra5 != null) {
                mqqLbsPack$PoiInfo.bytes_name.set(a(stringExtra5));
            }
            String stringExtra6 = intent.getStringExtra("key_poi_address");
            if (stringExtra6 != null) {
                mqqLbsPack$PoiInfo.bytes_addr.set(a(stringExtra6));
            }
            mqqLbsPack$PoiInfo.uint64_poi_id.set(intent.getLongExtra("key_poi_id", 0L));
            int intExtra11 = intent.getIntExtra("key_longitude_cur", 0);
            int intExtra12 = intent.getIntExtra("key_latitude_cur", 0);
            if (QLog.isColorLevel()) {
                QLog.d("LbsPack", 2, "LbsPackPoiListServlet onSend CMD_GET_PID  longitude_cur1 = " + intExtra11 + ", latitude_cur1 = " + intExtra12 + ", longitude1 = " + intExtra7 + ", latitude1 = " + intExtra8 + ", latitude_poi = " + intExtra9 + ", longitude_poi = " + intExtra10);
            }
            MqqLbsPack$ReqGetLBSPID mqqLbsPack$ReqGetLBSPID = new MqqLbsPack$ReqGetLBSPID();
            mqqLbsPack$ReqGetLBSPID.int32_lon.set(intExtra11);
            mqqLbsPack$ReqGetLBSPID.int32_lat.set(intExtra12);
            mqqLbsPack$ReqGetLBSPID.uin_grp_dis_info.set(mqqLbsPack$SelectedUinInfo);
            mqqLbsPack$ReqGetLBSPID.msg_lbs_sig.set(mqqLbsPack$LBSSig2);
            mqqLbsPack$ReqGetLBSPID.uint32_lbs_accuracy.set(intent.getIntExtra("key_accuracy", 0));
            String stringExtra7 = intent.getStringExtra("key_encrypt_sig");
            if (stringExtra7 != null) {
                mqqLbsPack$ReqGetLBSPID.bytes_encrypt_sig.set(a(stringExtra7));
            }
            mqqLbsPack$ReqGetLBSPID.uint32_qa.set(intent.getIntExtra("key_posion_flag", 0));
            mqqLbsPack$ReqGetLBSPID.msg_poi_info.set(mqqLbsPack$PoiInfo);
            byteArray = mqqLbsPack$ReqGetLBSPID.toByteArray();
            str = "LBSRedPack.ReqGetLBSPID";
        } else if (intExtra == 4) {
            if (QLog.isColorLevel()) {
                QLog.d("LbsPack", 2, "onSend. LBSTemplate");
            }
            double doubleExtra = intent.getDoubleExtra("key_longitude", 0.0d);
            double doubleExtra2 = intent.getDoubleExtra(AECameraConstants.KEY_LATITUDE, 0.0d);
            int intExtra13 = intent.getIntExtra("key_lbs_template_network_type", 0);
            oidb_cmd0x983$ReqBody oidb_cmd0x983_reqbody = new oidb_cmd0x983$ReqBody();
            appoint_define$LBSInfo appoint_define_lbsinfo = new appoint_define$LBSInfo();
            appoint_define$GPS appoint_define_gps = new appoint_define$GPS();
            appoint_define_gps.int32_lon.set((int) (doubleExtra * 1000000.0d));
            appoint_define_gps.int32_lat.set((int) (doubleExtra2 * 1000000.0d));
            appoint_define_gps.int32_type.set(1);
            appoint_define_lbsinfo.msg_gps.set(appoint_define_gps);
            oidb_cmd0x983_reqbody.msg_lbs_info.set(appoint_define_lbsinfo);
            oidb_cmd0x983_reqbody.uint32_network.set(intExtra13);
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(2435);
            oidb_sso_oidbssopkg.uint32_result.set(0);
            oidb_sso_oidbssopkg.uint32_service_type.set(0);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_cmd0x983_reqbody.toByteArray()));
            byteArray = oidb_sso_oidbssopkg.toByteArray();
            str = "OidbSvc.0x983";
        } else {
            throw new RuntimeException("unknow cmd: " + intExtra);
        }
        ByteBuffer allocate = ByteBuffer.allocate(byteArray.length + 4);
        allocate.putInt(byteArray.length + 4).put(byteArray);
        byte[] array = allocate.array();
        packet.setSSOCommand(str);
        packet.putSendData(array);
        if (QLog.isColorLevel()) {
            QLog.d("LbsPack", 2, "LbsPackPoiListServlet onSend ssoCmd:" + str);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        boolean z16;
        List<oidb_cmd0x983$AddonItem> list;
        boolean isSuccess = fromServiceMsg == null ? false : fromServiceMsg.isSuccess();
        int intExtra = intent.getIntExtra("k_cmd", 0);
        Bundle bundle = new Bundle();
        int b16 = b(intExtra);
        if (isSuccess) {
            try {
                byte[] bArr = new byte[r0.getInt() - 4];
                ByteBuffer.wrap(fromServiceMsg.getWupBuffer()).get(bArr);
                if (intExtra == 1) {
                    MqqLbsPack$RspGetPOIList mqqLbsPack$RspGetPOIList = new MqqLbsPack$RspGetPOIList();
                    mqqLbsPack$RspGetPOIList.mergeFrom(bArr);
                    if (mqqLbsPack$RspGetPOIList.rpt_msg_poi_info_list.has()) {
                        List<MqqLbsPack$PoiInfo> list2 = mqqLbsPack$RspGetPOIList.rpt_msg_poi_info_list.get();
                        if (QLog.isColorLevel()) {
                            QLog.d("LbsPack", 2, "LbsPackPoiListServlet onReceive CMD_GET_POI_LIST_REQ poiList.size = " + list2.size());
                        }
                    }
                    if (mqqLbsPack$RspGetPOIList.msg_head.has()) {
                        MqqLbsPack$RspHead mqqLbsPack$RspHead = mqqLbsPack$RspGetPOIList.msg_head.get();
                        int i3 = mqqLbsPack$RspHead.uint32_result.get();
                        if (i3 != 0) {
                            c.c("actLbsSendPoiListFailure", i3);
                        } else {
                            c.d("actLbsSendPoiListFailure");
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("LbsPack", 2, "LbsPackPoiListServlet onReceive CMD_GET_POI_LIST_REQ result = " + i3);
                        }
                        bundle.putInt("key_receive_result", i3);
                        String stringUtf8 = mqqLbsPack$RspHead.bytes_err_msg.get().toStringUtf8();
                        if (stringUtf8 != null) {
                            if (QLog.isColorLevel()) {
                                QLog.d("LbsPack", 2, "LbsPackPoiListServlet onReceive CMD_GET_POI_LIST_REQ errMsg = " + stringUtf8);
                            }
                            bundle.putString("key_erro_msg", stringUtf8);
                        }
                    }
                } else if (intExtra == 2) {
                    MqqLbsPack$RspOpenLBSRPReport mqqLbsPack$RspOpenLBSRPReport = new MqqLbsPack$RspOpenLBSRPReport();
                    mqqLbsPack$RspOpenLBSRPReport.mergeFrom(bArr);
                    if (mqqLbsPack$RspOpenLBSRPReport.msg_head.has()) {
                        MqqLbsPack$RspHead mqqLbsPack$RspHead2 = mqqLbsPack$RspOpenLBSRPReport.msg_head;
                        int i16 = mqqLbsPack$RspHead2.uint32_result.get();
                        if (QLog.isColorLevel()) {
                            QLog.d("LbsPack", 2, "LbsPackPoiListServlet onReceive CMD_REPORT_OPEN_LBS_PACK_REQ result = " + i16);
                        }
                        bundle.putInt("key_receive_result", i16);
                        String stringUtf82 = mqqLbsPack$RspHead2.bytes_err_msg.get().toStringUtf8();
                        if (stringUtf82 != null) {
                            if (QLog.isColorLevel()) {
                                QLog.d("LbsPack", 2, "LbsPackPoiListServlet onReceive  CMD_REPORT_OPEN_LBS_PACK_REQ errMsg = " + stringUtf82);
                            }
                            bundle.putString("key_erro_msg", stringUtf82);
                        }
                    }
                } else if (intExtra == 3) {
                    MqqLbsPack$RspGetLBSPID mqqLbsPack$RspGetLBSPID = new MqqLbsPack$RspGetLBSPID();
                    mqqLbsPack$RspGetLBSPID.mergeFrom(bArr);
                    if (mqqLbsPack$RspGetLBSPID.msg_head.has()) {
                        int i17 = mqqLbsPack$RspGetLBSPID.msg_head.get().uint32_result.get();
                        if (QLog.isColorLevel()) {
                            QLog.d("LbsPack", 2, "LbsPackPoiListServlet onReceive CMD_GET_PID result = " + i17);
                        }
                        if (i17 == 0) {
                            c.d("actLbsSendGetPidFailure");
                        } else {
                            c.c("actLbsSendGetPidFailure", i17);
                        }
                        bundle.putInt("key_receive_result", i17);
                        String stringUtf83 = mqqLbsPack$RspGetLBSPID.msg_head.bytes_err_msg.get().toStringUtf8();
                        if (stringUtf83 != null) {
                            if (QLog.isColorLevel()) {
                                QLog.d("LbsPack", 2, "LbsPackPoiListServlet onReceive  CMD_GET_PID errMsg = " + stringUtf83);
                            }
                            bundle.putString("key_erro_msg", stringUtf83);
                        }
                    }
                    if (mqqLbsPack$RspGetLBSPID.bytes_pid.has()) {
                        String stringUtf84 = mqqLbsPack$RspGetLBSPID.bytes_pid.get().toStringUtf8();
                        if (QLog.isColorLevel()) {
                            QLog.d("LbsPack", 2, "LbsPackPoiListServlet onReceive CMD_GET_PID pid = " + stringUtf84);
                        }
                        bundle.putString("key_pid", stringUtf84);
                    }
                } else if (intExtra == 4) {
                    oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                    oidb_sso_oidbssopkg.mergeFrom(bArr);
                    if (oidb_sso_oidbssopkg.uint32_result.get() == 0 && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                        oidb_cmd0x983$RspBody oidb_cmd0x983_rspbody = new oidb_cmd0x983$RspBody();
                        oidb_cmd0x983_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                        if (oidb_cmd0x983_rspbody.rpt_addon_list.has() && (list = oidb_cmd0x983_rspbody.rpt_addon_list.get()) != null) {
                            ArrayList<String> arrayList = new ArrayList<>(list.size());
                            Iterator<oidb_cmd0x983$AddonItem> it = list.iterator();
                            while (it.hasNext()) {
                                arrayList.add(it.next().uint32_addon_id.get() + "");
                            }
                            bundle.putStringArrayList("key_lbs_template_ids", arrayList);
                        }
                    }
                    bundle.putInt("key_lbs_template_cookie", intent.getIntExtra("key_lbs_template_cookie", -1));
                } else {
                    throw new RuntimeException("unknow cmd: " + intExtra);
                }
            } catch (InvalidProtocolBufferMicroException unused) {
                if (QLog.isColorLevel()) {
                    QLog.e("LbsPack", 2, "LbsPackPoiListServlet onReceive exception:" + intExtra);
                }
                z16 = false;
            }
        } else if (intExtra == 1) {
            c.c("actLbsSendPoiListFailure", -10006);
        } else if (intExtra == 3) {
            c.c("actLbsSendGetPidFailure", -10006);
        } else if (intExtra == 4) {
            if (QLog.isColorLevel()) {
                if (fromServiceMsg != null) {
                    QLog.d("LbsPack", 2, "onReceive. LBSTemplate. resultCode:" + fromServiceMsg.getResultCode() + " errorMsg:" + fromServiceMsg.getBusinessFailMsg());
                } else {
                    QLog.d("LbsPack", 2, "onReceive. LBSTemplate fail");
                }
            }
            bundle.putInt("key_lbs_template_cookie", intent.getIntExtra("key_lbs_template_cookie", -1));
        }
        z16 = isSuccess;
        notifyObserver(intent, b16, z16, bundle, a.class);
    }
}
