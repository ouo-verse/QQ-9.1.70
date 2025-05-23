package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$StBatchGetContactRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.utils.fh;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppBatchGetContactServlet extends MiniAppAbstractServlet {
    public static final String KEY_APP_IDS = "key_app_ids";
    public static final String KEY_CONTACT_LIST = "contact_list";
    public static final String TAG = "MiniAppBatchGetContactServlet";

    public MiniAppBatchGetContactServlet() {
        this.observerId = 1039;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        MessageMicro<INTERFACE$StBatchGetContactRsp> messageMicro = new MessageMicro<INTERFACE$StBatchGetContactRsp>() { // from class: NS_MINI_INTERFACE.INTERFACE$StBatchGetContactRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"contactList"}, new Object[]{null}, INTERFACE$StBatchGetContactRsp.class);
            public final PBRepeatMessageField<INTERFACE$StContactInfo> contactList = PBField.initRepeatMessage(INTERFACE$StContactInfo.class);
        };
        messageMicro.mergeFrom(bArr);
        if (bundle.getLong("retCode") == 0) {
            Object pbToJson = GdtJsonPbUtil.pbToJson(messageMicro);
            if (pbToJson != null) {
                bundle.putString(KEY_CONTACT_LIST, pbToJson.toString());
            }
            notifyObserver(intent, 1039, true, bundle, MiniAppObserver.class);
            return;
        }
        notifyObserver(intent, 1039, false, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        byte[] encode = new BatchGetContactRequest(intent.getStringArrayListExtra(KEY_APP_IDS)).encode(intent, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1), getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(BatchGetContactRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
