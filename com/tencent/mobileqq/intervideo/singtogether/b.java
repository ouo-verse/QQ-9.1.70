package com.tencent.mobileqq.intervideo.singtogether;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.aio.video.aio_video$ReqGetOpenIdByUin;
import tencent.aio.video.aio_video$RspGetOpenIdByUin;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b extends MSFServlet {
    public static NewIntent a(long j3, long j16, QQAppInterface qQAppInterface) {
        int O = Utils.O(j16);
        NewIntent newIntent = new NewIntent(qQAppInterface.getApplication(), b.class);
        newIntent.putExtra("appId", O);
        newIntent.putExtra("sso_command", "QQAIOMediaSvc.get_openid_by_uin");
        newIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 1);
        newIntent.putExtra("uin", j3);
        qQAppInterface.startServlet(newIntent);
        return newIntent;
    }

    private void b(int i3, Intent intent, FromServiceMsg fromServiceMsg) {
        boolean z16;
        byte[] a16 = fh.a(fromServiceMsg.getWupBuffer());
        if (fromServiceMsg.isSuccess() && a16 != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Bundle bundle = new Bundle();
        int intExtra = intent.getIntExtra("appId", 0);
        long longExtra = intent.getLongExtra("uin", 0L);
        bundle.putInt("appId", intExtra);
        bundle.putLong("uin", longExtra);
        if (QLog.isColorLevel()) {
            QLog.d("FetchOpenIdServlet", 2, "handleOpenIdFromUin success=" + z16 + " resultCode=" + fromServiceMsg.getResultCode() + " appId=" + intExtra + " uin=" + longExtra);
        }
        if (z16) {
            try {
                aio_video$RspGetOpenIdByUin aio_video_rspgetopenidbyuin = new aio_video$RspGetOpenIdByUin();
                aio_video_rspgetopenidbyuin.mergeFrom(a16);
                int i16 = aio_video_rspgetopenidbyuin.err_info.err_code.get();
                if (i16 == 0) {
                    String stringUtf8 = aio_video_rspgetopenidbyuin.open_id.get().toStringUtf8();
                    bundle.putString("openId", stringUtf8);
                    QLog.d("FetchOpenIdServlet", 2, "handleOpenIdFromUin openid=" + stringUtf8);
                    notifyObserver(intent, i3, true, bundle, a.class);
                    return;
                }
                String stringUtf82 = aio_video_rspgetopenidbyuin.err_info.err_msg.get().toStringUtf8();
                if (QLog.isColorLevel()) {
                    QLog.w("FetchOpenIdServlet", 2, "handleOpenIdFromUin code=" + i16 + " errorMsg=" + stringUtf82);
                }
                bundle.putString("error_msg", stringUtf82);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.w("FetchOpenIdServlet", 2, "handleOpenIdFromUin e", e16);
                }
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.w("FetchOpenIdServlet", 2, "handleOpenIdFromUin ex", e17);
                }
            }
        }
        notifyObserver(intent, i3, false, bundle, a.class);
    }

    private void c(Intent intent, Packet packet) {
        long longExtra = intent.getLongExtra("uin", 0L);
        int intExtra = intent.getIntExtra("appId", 0);
        String stringExtra = intent.getStringExtra("sso_command");
        if (QLog.isColorLevel()) {
            QLog.d("FetchOpenIdServlet", 2, "sendPacket uin=" + longExtra + " appId=" + intExtra);
        }
        aio_video$ReqGetOpenIdByUin aio_video_reqgetopenidbyuin = new aio_video$ReqGetOpenIdByUin();
        aio_video_reqgetopenidbyuin.app_id.set(intExtra);
        aio_video_reqgetopenidbyuin.target_uin.set(longExtra);
        packet.setSSOCommand(stringExtra);
        packet.putSendData(fh.b(aio_video_reqgetopenidbyuin.toByteArray()));
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        int intExtra = intent.getIntExtra(AppConstants.Key.SHARE_REQ_TYPE, -1);
        if (QLog.isColorLevel()) {
            QLog.d("FetchOpenIdServlet", 2, "onReceive cmd:" + intExtra);
        }
        b(intExtra, intent, fromServiceMsg);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        if (QLog.isColorLevel()) {
            QLog.d("FetchOpenIdServlet", 2, "onSend");
        }
        c(intent, packet);
    }
}
