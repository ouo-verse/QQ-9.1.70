package oicq.wlogin_sdk.tlv_type;

import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t508 extends tlv_t {
    public static boolean doFetch = true;
    public static int timeout = 1000;
    public static byte[] userBuf = new byte[0];

    public tlv_t508() {
        this._cmd = 1288;
    }

    @Override // oicq.wlogin_sdk.tlv_type.tlv_t
    public Boolean verify() {
        try {
            try {
                ByteBuffer wrap = ByteBuffer.wrap(this._buf);
                wrap.position(this._head_len);
                boolean z16 = true;
                if (wrap.get() != 1) {
                    z16 = false;
                }
                doFetch = z16;
                timeout = wrap.getInt();
                byte[] bArr = new byte[wrap.getShort()];
                userBuf = bArr;
                wrap.get(bArr);
                if (timeout == 0) {
                    timeout = 1000;
                }
                if (userBuf == null) {
                    userBuf = new byte[0];
                }
                return Boolean.TRUE;
            } catch (Exception unused) {
                Boolean bool = Boolean.FALSE;
                if (timeout == 0) {
                    timeout = 1000;
                }
                if (userBuf == null) {
                    userBuf = new byte[0];
                }
                return bool;
            }
        } catch (Throwable th5) {
            if (timeout == 0) {
                timeout = 1000;
            }
            if (userBuf == null) {
                userBuf = new byte[0];
            }
            throw th5;
        }
    }
}
