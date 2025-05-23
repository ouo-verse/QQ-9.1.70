package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_APP_PAY.MiniAppMidasPay$StMiniCheckOfferIdRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppCheckOfferIdServlet extends MiniAppAbstractServlet {
    public static final String KEY_ERR_MSG = "key_err_msg";
    public static final String KEY_EXT = "key_ext";
    public static final String KEY_EXTENDINFO = "key_extendinfo";
    public static final String KEY_FIRST_REFER = "key_first_refer";
    public static final String KEY_FIRST_VIA = "key_first_via";
    public static final String KEY_MINI_APPID = "key_appid";
    public static final String KEY_OFFER_ID = "key_offer_id";
    public static final String KEY_RESULT = "key_result";
    public static final String TAG = "MiniAppCheckOfferIdServlet";

    public MiniAppCheckOfferIdServlet() {
        this.observerId = 1021;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        MiniAppMidasPay$StMiniCheckOfferIdRsp miniAppMidasPay$StMiniCheckOfferIdRsp = new MiniAppMidasPay$StMiniCheckOfferIdRsp();
        miniAppMidasPay$StMiniCheckOfferIdRsp.mergeFrom(bArr);
        if (miniAppMidasPay$StMiniCheckOfferIdRsp.result != null) {
            COMM.StCommonExt stCommonExt = miniAppMidasPay$StMiniCheckOfferIdRsp.extInfo;
            if (stCommonExt != null) {
                bundle.putByteArray("key_extendinfo", stCommonExt.toByteArray());
            }
            PBStringField pBStringField = miniAppMidasPay$StMiniCheckOfferIdRsp.firstRefer;
            if (pBStringField != null) {
                bundle.putString(KEY_FIRST_REFER, pBStringField.get());
            }
            PBStringField pBStringField2 = miniAppMidasPay$StMiniCheckOfferIdRsp.firstVia;
            if (pBStringField2 != null) {
                bundle.putString(KEY_FIRST_VIA, pBStringField2.get());
            }
            bundle.putInt("key_result", miniAppMidasPay$StMiniCheckOfferIdRsp.result.get());
            notifyObserver(intent, 1021, true, bundle, MiniAppObserver.class);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "onProcessData. result = " + miniAppMidasPay$StMiniCheckOfferIdRsp.result);
        }
        notifyObserver(intent, 1021, false, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        COMM.StCommonExt stCommonExt;
        String stringExtra = intent.getStringExtra("key_appid");
        String stringExtra2 = intent.getStringExtra(KEY_OFFER_ID);
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_ext");
        int intExtra = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
        if (byteArrayExtra != null) {
            stCommonExt = new COMM.StCommonExt();
            try {
                stCommonExt.mergeFrom(byteArrayExtra);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "onSend. mergeFrom exception!");
                }
                e16.printStackTrace();
            }
        } else {
            stCommonExt = null;
        }
        byte[] encode = new CheckOfferIdRequest(stCommonExt, stringExtra, stringExtra2).encode(intent, intExtra, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(CheckOfferIdRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onSend. intent: " + intent.toString());
        }
        super.onSend(intent, packet);
    }
}
