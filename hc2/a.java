package hc2;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.onlinestatus.utils.q;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;
import tencent.im.msg.im_msg_body$RichText;
import tencent.im.oidb.cmd0xcd5.oidb_cmd0xcd5$GetDataReq;
import tencent.im.oidb.cmd0xcd5.oidb_cmd0xcd5$GetDataRsp;
import tencent.im.oidb.cmd0xcd5.oidb_cmd0xcd5$ReqBody;
import tencent.im.oidb.cmd0xcd5.oidb_cmd0xcd5$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;
import tencent.im.storage.wording_storage$WordingCfg;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a extends MSFServlet {
    private oidb_sso$OIDBSSOPkg a(FromServiceMsg fromServiceMsg) {
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        byte[] bArr = new byte[r4.getInt() - 4];
        ByteBuffer.wrap(fromServiceMsg.getWupBuffer()).get(bArr);
        try {
            oidb_sso_oidbssopkg.mergeFrom(bArr);
            return oidb_sso_oidbssopkg;
        } catch (InvalidProtocolBufferMicroException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(MSFServlet.TAG, 2, "respGetBirthday|oidb_sso parseFrom byte", e16);
                return null;
            }
            return null;
        }
    }

    private void b(Intent intent, FromServiceMsg fromServiceMsg) {
        boolean z16;
        Bundle bundle = new Bundle();
        boolean z17 = false;
        int i3 = 0;
        z17 = false;
        try {
            if (fromServiceMsg.isSuccess()) {
                oidb_sso$OIDBSSOPkg a16 = a(fromServiceMsg);
                try {
                    if (a16 != null) {
                        if (a16.uint32_result.get() == 0) {
                            try {
                                oidb_cmd0xcd5$RspBody oidb_cmd0xcd5_rspbody = new oidb_cmd0xcd5$RspBody();
                                oidb_cmd0xcd5_rspbody.mergeFrom(a16.bytes_bodybuffer.get().toByteArray());
                                oidb_cmd0xcd5$GetDataRsp oidb_cmd0xcd5_getdatarsp = oidb_cmd0xcd5_rspbody.getdata_rsp.get();
                                if (oidb_cmd0xcd5_getdatarsp != null && oidb_cmd0xcd5_getdatarsp.flag.get() != 1 && oidb_cmd0xcd5_getdatarsp.pb_data.has()) {
                                    byte[] byteArray = oidb_cmd0xcd5_getdatarsp.pb_data.get().toByteArray();
                                    wording_storage$WordingCfg wording_storage_wordingcfg = new wording_storage$WordingCfg();
                                    wording_storage_wordingcfg.mergeFrom(byteArray);
                                    if (wording_storage_wordingcfg.select_id.has()) {
                                        i3 = wording_storage_wordingcfg.select_id.get();
                                    }
                                    List<im_msg_body$RichText> list = wording_storage_wordingcfg.wording_list.get();
                                    if (list != null && list.size() > i3) {
                                        bundle.putString("key_auto_reply", new q().a(list.get(i3).elems.get()));
                                    }
                                }
                                z16 = true;
                                notifyObserver(intent, 12485, z16, bundle, null);
                                return;
                            } catch (InvalidProtocolBufferMicroException e16) {
                                e = e16;
                                z17 = true;
                                QLog.e(MSFServlet.TAG, 1, "decode err: ", e);
                                notifyObserver(intent, 12485, z17, bundle, null);
                            }
                        }
                    }
                    notifyObserver(intent, 12485, z16, bundle, null);
                    return;
                } catch (InvalidProtocolBufferMicroException e17) {
                    z17 = z16;
                    e = e17;
                    QLog.e(MSFServlet.TAG, 1, "decode err: ", e);
                    notifyObserver(intent, 12485, z17, bundle, null);
                }
                z16 = false;
            }
        } catch (InvalidProtocolBufferMicroException e18) {
            e = e18;
        }
        notifyObserver(intent, 12485, z17, bundle, null);
    }

    public static void c(AppRuntime appRuntime, String str, BusinessObserver businessObserver) {
        oidb_cmd0xcd5$ReqBody oidb_cmd0xcd5_reqbody = new oidb_cmd0xcd5$ReqBody();
        oidb_cmd0xcd5$GetDataReq oidb_cmd0xcd5_getdatareq = new oidb_cmd0xcd5$GetDataReq();
        oidb_cmd0xcd5_getdatareq.query_type.set(3);
        oidb_cmd0xcd5_getdatareq.target_uin.set(Long.parseLong(str));
        oidb_cmd0xcd5_reqbody.getdata_req.set(oidb_cmd0xcd5_getdatareq);
        oidb_cmd0xcd5_reqbody.service_type.set(1);
        d(appRuntime, 3285, ProfileContants.CMD_AUTO_REPLY, oidb_cmd0xcd5_reqbody.toByteArray(), businessObserver);
    }

    private static void d(AppRuntime appRuntime, int i3, String str, byte[] bArr, BusinessObserver businessObserver) {
        if (appRuntime == null) {
            QLog.e(MSFServlet.TAG, 1, "sendRequest QQAppInterface is null, command is " + str);
            return;
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(i3);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(bArr));
        NewIntent newIntent = new NewIntent(appRuntime.getApp(), a.class);
        newIntent.putExtra("cmd", str);
        newIntent.putExtra("data", oidb_sso_oidbssopkg.toByteArray());
        newIntent.setObserver(businessObserver);
        appRuntime.startServlet(newIntent);
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        if (QLog.isColorLevel()) {
            QLog.i(MSFServlet.TAG, 2, "onReceive");
        }
        if (intent != null && fromServiceMsg != null && ProfileContants.CMD_AUTO_REPLY.equals(fromServiceMsg.getServiceCmd())) {
            b(intent, fromServiceMsg);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        byte[] byteArrayExtra = intent.getByteArrayExtra("data");
        String stringExtra = intent.getStringExtra("cmd");
        QLog.i(MSFServlet.TAG, 1, "onSend, cmd is " + stringExtra);
        packet.setSSOCommand(stringExtra);
        packet.putSendData(fh.b(byteArrayExtra));
        if (QLog.isColorLevel()) {
            QLog.i(MSFServlet.TAG, 2, "onSend exit");
        }
    }
}
