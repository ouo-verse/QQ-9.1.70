package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class RegTLV extends tlv_t {
    public int _head_len;

    public RegTLV(int i3) {
        super(i3);
        this._head_len = 4;
    }

    public byte[] getBuf() {
        return get_buf();
    }

    public void setByte(byte b16) {
        setData(new byte[]{b16}, 1);
    }

    public void setData(byte[] bArr, int i3) {
        int i16 = this._head_len;
        int i17 = i3 + i16;
        if (i17 > this._max) {
            int i18 = i17 + 128;
            this._max = i18;
            byte[] bArr2 = new byte[i18];
            System.arraycopy(this._buf, 0, bArr2, 0, i16);
            this._buf = bArr2;
        }
        int i19 = this._head_len;
        this._pos = i3 + i19;
        System.arraycopy(bArr, 0, this._buf, i19, i3);
        this._body_len = i3;
        util.int16_to_buf(this._buf, 0, this._cmd);
        util.int16_to_buf(this._buf, 2, this._body_len);
    }

    public void setInt(int i3) {
        byte[] bArr = new byte[4];
        util.int32_to_buf(bArr, 0, i3);
        setData(bArr, 4);
    }

    public void setLong(long j3) {
        byte[] bArr = new byte[8];
        util.int64_to_buf(bArr, 0, j3);
        setData(bArr, 8);
    }

    public void setShort(int i3) {
        byte[] bArr = new byte[2];
        util.int16_to_buf(bArr, 0, i3);
        setData(bArr, 2);
    }
}
