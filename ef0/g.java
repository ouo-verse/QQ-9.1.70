package ef0;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import org.java_websocket.WebSocketImpl;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8$GetFilePreviewRspBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8$RspBody;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class g extends ProtoUtils.TroopProtocolObserver {
    protected void b(int i3, byte[] bArr, Bundle bundle) {
        Bundle bundle2;
        Bundle bundle3;
        if (i3 == 0 && bArr != null) {
            oidb_0x6d8$RspBody oidb_0x6d8_rspbody = new oidb_0x6d8$RspBody();
            try {
                oidb_0x6d8_rspbody.mergeFrom(bArr);
                if (!oidb_0x6d8_rspbody.file_preview_rsp.has()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopFileProtocol", 2, "no file_preview rsp.");
                    }
                    c(false, i3, null, null, 0, 0, null, null, null, null, bundle);
                    return;
                }
                oidb_0x6d8$GetFilePreviewRspBody oidb_0x6d8_getfilepreviewrspbody = oidb_0x6d8_rspbody.file_preview_rsp.get();
                if (!oidb_0x6d8_getfilepreviewrspbody.bytes_download_url.has()) {
                    c(false, i3, null, null, 0, 0, null, null, null, null, bundle);
                    return;
                }
                int i16 = oidb_0x6d8_getfilepreviewrspbody.int32_ret_code.get();
                String str = oidb_0x6d8_getfilepreviewrspbody.str_ret_msg.get();
                String str2 = oidb_0x6d8_getfilepreviewrspbody.str_client_wording.get();
                int i17 = oidb_0x6d8_getfilepreviewrspbody.int32_server_ip.get();
                int i18 = oidb_0x6d8_getfilepreviewrspbody.int32_server_port.get();
                String str3 = oidb_0x6d8_getfilepreviewrspbody.str_download_dns.get();
                ByteStringMicro byteStringMicro = oidb_0x6d8_getfilepreviewrspbody.bytes_download_url.get();
                ByteStringMicro byteStringMicro2 = oidb_0x6d8_getfilepreviewrspbody.bytes_reserved_field.get();
                String str4 = oidb_0x6d8_getfilepreviewrspbody.str_cookie_val.get();
                oidb_0x6d8_getfilepreviewrspbody.str_download_dns_https.get().toStringUtf8();
                oidb_0x6d8_getfilepreviewrspbody.uint32_preview_port_https.get();
                if (bundle == null) {
                    bundle3 = new Bundle();
                } else {
                    bundle3 = bundle;
                }
                try {
                    if (!TextUtils.isEmpty(str3)) {
                        bundle3.putString("strHttpsDomain", str3);
                        bundle3.putInt("httpsPort", WebSocketImpl.DEFAULT_WSS_PORT);
                    }
                    c(true, i16, str, str2, i17, i18, str3, byteStringMicro, str4, byteStringMicro2, bundle3);
                } catch (InvalidProtocolBufferMicroException unused) {
                    bundle2 = bundle3;
                    c(false, i3, null, null, 0, 0, null, null, null, null, bundle2);
                }
            } catch (InvalidProtocolBufferMicroException unused2) {
                bundle2 = bundle;
            }
        } else {
            c(false, i3, null, null, 0, 0, null, null, null, null, bundle);
        }
    }

    public abstract void c(boolean z16, int i3, String str, String str2, int i16, int i17, String str3, ByteStringMicro byteStringMicro, String str4, ByteStringMicro byteStringMicro2, Bundle bundle);

    @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
    public void onResult(int i3, byte[] bArr, Bundle bundle) {
        b(i3, bArr, bundle);
    }
}
