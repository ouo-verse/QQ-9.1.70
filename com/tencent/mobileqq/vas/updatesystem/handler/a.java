package com.tencent.mobileqq.vas.updatesystem.handler;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.vas.utils.VasCommonUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a extends MSFServlet {

    /* renamed from: d, reason: collision with root package name */
    public static String f311209d = "cmd";

    /* renamed from: e, reason: collision with root package name */
    public static String f311210e = "data";

    /* renamed from: f, reason: collision with root package name */
    public static String f311211f = "timeout";

    /* renamed from: h, reason: collision with root package name */
    public static String f311212h = "trace_id";

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        byte[] bArr;
        if (fromServiceMsg.isSuccess()) {
            int length = fromServiceMsg.getWupBuffer().length - 4;
            bArr = new byte[length];
            VasCommonUtils.INSTANCE.copyData(bArr, 0, fromServiceMsg.getWupBuffer(), 4, length);
        } else {
            bArr = null;
        }
        VasUpdateHandler vasUpdateHandler = (VasUpdateHandler) ((BaseQQAppInterface) super.getAppRuntime()).getBusinessHandler(VasUpdateHandler.f311201h);
        if (vasUpdateHandler != null) {
            vasUpdateHandler.onReceive(intent, fromServiceMsg, bArr);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        String stringExtra = intent.getStringExtra(f311209d);
        byte[] byteArrayExtra = intent.getByteArrayExtra(f311210e);
        long longExtra = intent.getLongExtra(f311211f, 30000L);
        String stringExtra2 = intent.getStringExtra(f311212h);
        if (!TextUtils.isEmpty(stringExtra)) {
            packet.setSSOCommand(stringExtra);
            packet.setTimeout(longExtra);
            if (byteArrayExtra != null) {
                byte[] bArr = new byte[byteArrayExtra.length + 4];
                VasCommonUtils vasCommonUtils = VasCommonUtils.INSTANCE;
                vasCommonUtils.dWord2Byte(bArr, 0, byteArrayExtra.length + 4);
                vasCommonUtils.copyData(bArr, 4, byteArrayExtra, byteArrayExtra.length);
                packet.putSendData(bArr);
            } else {
                byte[] bArr2 = new byte[4];
                VasCommonUtils.INSTANCE.dWord2Byte(bArr2, 0, 4L);
                packet.putSendData(bArr2);
            }
        }
        if (!TextUtils.isEmpty(stringExtra2)) {
            packet.setTraceInfo(stringExtra2);
        }
    }
}
