package pl4;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.utils.l;
import com.tencent.util.QQDeviceInfo;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import trpc.yes.common.BaseInterfaceOuterClass$CSQQAccessBaseInfo;
import trpc.yes.common.BaseInterfaceOuterClass$CSQQAccessReply;
import trpc.yes.common.BaseInterfaceOuterClass$CSQQAccessReqHeader;
import trpc.yes.common.BaseInterfaceOuterClass$CSQQAccessRequest;
import trpc.yes.common.BaseInterfaceOuterClass$CSQQAccessRspHeader;
import trpc.yes.common.BaseInterfaceOuterClass$NetInfo;
import trpc.yes.common.BaseInterfaceOuterClass$Terminal;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class a extends MSFServlet {

    /* compiled from: P */
    /* renamed from: pl4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static class C11028a {
        public static NewIntent a(MessageMicro messageMicro, Class<? extends a> cls) {
            NewIntent newIntent = new NewIntent(BaseApplication.getContext(), cls);
            newIntent.putExtra("bytes", messageMicro.toByteArray());
            return newIntent;
        }
    }

    protected byte[] a(Intent intent) {
        return intent.getByteArrayExtra("bytes");
    }

    protected abstract int b();

    protected boolean c() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x014a  */
    @Override // mqq.app.MSFServlet
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        boolean z16;
        BaseInterfaceOuterClass$CSQQAccessReply baseInterfaceOuterClass$CSQQAccessReply;
        int i3;
        String str;
        String str2;
        int i16;
        BaseInterfaceOuterClass$CSQQAccessRspHeader baseInterfaceOuterClass$CSQQAccessRspHeader;
        byte[] byteArray;
        int b16 = b();
        Bundle bundle = new Bundle();
        bundle.putInt("req_cmd", b16);
        if (fromServiceMsg != null) {
            bundle.putParcelable("msf_data", fromServiceMsg);
            bundle.putInt("msf_code", fromServiceMsg.getResultCode());
        }
        boolean z17 = true;
        boolean z18 = false;
        if (fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            z16 = true;
        } else {
            z16 = false;
        }
        bundle.putBoolean("msf_success", z16);
        if (fromServiceMsg == null) {
            l.e("NetCore_BaseTimiGameServlet_", "onReceive cmd=" + b16 + ", response is null");
        } else if (!fromServiceMsg.isSuccess()) {
            l.e("NetCore_BaseTimiGameServlet_", "onReceive cmd=" + b16 + ", msf not success - " + fromServiceMsg.getResultCode());
        } else {
            byte[] a16 = fh.a(fromServiceMsg.getWupBuffer());
            byte[] bArr = null;
            try {
                baseInterfaceOuterClass$CSQQAccessReply = new BaseInterfaceOuterClass$CSQQAccessReply();
            } catch (InvalidProtocolBufferMicroException e16) {
                e = e16;
                baseInterfaceOuterClass$CSQQAccessReply = null;
            }
            try {
                baseInterfaceOuterClass$CSQQAccessReply.mergeFrom(a16);
            } catch (InvalidProtocolBufferMicroException e17) {
                e = e17;
                e.printStackTrace();
                if (baseInterfaceOuterClass$CSQQAccessReply.get() == null) {
                }
                l.e("NetCore_BaseTimiGameServlet_", "onReceive cmd=" + b16 + ", decode CSQQAccessReply fail - " + a16);
                i3 = -9999;
                str = "";
                str2 = "\u56de\u5305\u89e3\u6790\u5931\u8d25";
                i16 = -9999;
                bundle.putInt("timi_code", i3);
                if (bArr != null) {
                }
                bundle.putString("timi_errmsg", str);
                bundle.putString("timi_displaymsg", str2);
                bundle.putInt("timi_subcode", i16);
                notifyObserver(intent, 0, z18, bundle, null);
            }
            if (baseInterfaceOuterClass$CSQQAccessReply.get() == null && (baseInterfaceOuterClass$CSQQAccessRspHeader = baseInterfaceOuterClass$CSQQAccessReply.rsp_header) != null) {
                if (c()) {
                    byteArray = baseInterfaceOuterClass$CSQQAccessReply.toByteArray();
                } else {
                    byteArray = baseInterfaceOuterClass$CSQQAccessReply.rsp_body.get().toByteArray();
                }
                bArr = byteArray;
                i3 = baseInterfaceOuterClass$CSQQAccessRspHeader.error_code.get();
                str = baseInterfaceOuterClass$CSQQAccessRspHeader.error_message.get();
                str2 = baseInterfaceOuterClass$CSQQAccessRspHeader.disply_error_message.get();
                i16 = baseInterfaceOuterClass$CSQQAccessRspHeader.system_error_sub_code.get();
                if (i3 != 0) {
                    z17 = false;
                }
                if (z17) {
                    l.i("NetCore_BaseTimiGameServlet_", "onReceive cmd=" + b16 + ", timi notify success!");
                } else {
                    l.e("NetCore_BaseTimiGameServlet_", "onReceive cmd=" + b16 + ", timi notify error, timiErrorCode=" + i3 + ", timiErrorMsg=" + str + ", timiDisplayErrorMsg=" + str2);
                }
                z18 = z17;
            } else {
                l.e("NetCore_BaseTimiGameServlet_", "onReceive cmd=" + b16 + ", decode CSQQAccessReply fail - " + a16);
                i3 = -9999;
                str = "";
                str2 = "\u56de\u5305\u89e3\u6790\u5931\u8d25";
                i16 = -9999;
            }
            bundle.putInt("timi_code", i3);
            if (bArr != null) {
                bundle.putByteArray("timi_data", bArr);
            }
            bundle.putString("timi_errmsg", str);
            bundle.putString("timi_displaymsg", str2);
            bundle.putInt("timi_subcode", i16);
        }
        notifyObserver(intent, 0, z18, bundle, null);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        int i3;
        int b16 = b();
        if (intent == null) {
            l.e("NetCore_BaseTimiGameServlet_", "onSend bad request, cmd=" + b16);
            return;
        }
        if (c() && b16 == 0) {
            b16 = intent.getIntExtra("req_cmd", 0);
        }
        if (packet == null) {
            l.e("NetCore_BaseTimiGameServlet_", "onSend bad packet, cmd=" + b16);
            return;
        }
        BaseInterfaceOuterClass$Terminal baseInterfaceOuterClass$Terminal = new BaseInterfaceOuterClass$Terminal();
        baseInterfaceOuterClass$Terminal.qimei.set(QQDeviceInfo.getQIMEI());
        baseInterfaceOuterClass$Terminal.phone_system.set(2);
        baseInterfaceOuterClass$Terminal.platform_type.set(2);
        baseInterfaceOuterClass$Terminal.client_version.set(com.tencent.timi.game.utils.c.b().a());
        BaseInterfaceOuterClass$NetInfo baseInterfaceOuterClass$NetInfo = new BaseInterfaceOuterClass$NetInfo();
        baseInterfaceOuterClass$NetInfo.client_ip.set(com.tencent.timi.game.utils.c.b().c());
        BaseInterfaceOuterClass$CSQQAccessBaseInfo baseInterfaceOuterClass$CSQQAccessBaseInfo = new BaseInterfaceOuterClass$CSQQAccessBaseInfo();
        baseInterfaceOuterClass$CSQQAccessBaseInfo.terminal.set(baseInterfaceOuterClass$Terminal);
        baseInterfaceOuterClass$CSQQAccessBaseInfo.net_info.set(baseInterfaceOuterClass$NetInfo);
        BaseInterfaceOuterClass$CSQQAccessReqHeader baseInterfaceOuterClass$CSQQAccessReqHeader = new BaseInterfaceOuterClass$CSQQAccessReqHeader();
        baseInterfaceOuterClass$CSQQAccessReqHeader.cmd.set(b16);
        BaseInterfaceOuterClass$CSQQAccessRequest baseInterfaceOuterClass$CSQQAccessRequest = new BaseInterfaceOuterClass$CSQQAccessRequest();
        baseInterfaceOuterClass$CSQQAccessRequest.base_info.set(baseInterfaceOuterClass$CSQQAccessBaseInfo);
        baseInterfaceOuterClass$CSQQAccessRequest.req_header.set(baseInterfaceOuterClass$CSQQAccessReqHeader);
        if (c()) {
            baseInterfaceOuterClass$CSQQAccessRequest.body_type.set(1);
        }
        byte[] a16 = a(intent);
        if (a16 != null && a16.length > 0) {
            baseInterfaceOuterClass$CSQQAccessRequest.req_body.set(ByteStringMicro.copyFrom(a16));
        }
        byte[] byteArray = baseInterfaceOuterClass$CSQQAccessRequest.toByteArray();
        packet.setSSOCommand("trpc.yes.qq_access_proxy.QQAccess.ClientDo");
        packet.putSendData(fh.b(byteArray));
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onSend cmd=");
        sb5.append(b16);
        sb5.append(", requestBody.size= ");
        if (a16 != null) {
            i3 = a16.length;
        } else {
            i3 = -1;
        }
        sb5.append(i3);
        l.i("NetCore_BaseTimiGameServlet_", sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.MSFServlet
    public void sendToMSF(Intent intent, ToServiceMsg toServiceMsg) {
        super.sendToMSF(intent, toServiceMsg);
        l.i("NetCore_BaseTimiGameServlet_", "sendToMSF cmd=" + b() + ", appSeq= " + toServiceMsg.getAppSeq());
    }
}
