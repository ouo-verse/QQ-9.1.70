package oicq.wlogin_sdk.devicelock;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class TLV_CommRsp extends d {
    public int ErrInfoType;
    public int RetCode = -1;
    public int Reason = 0;
    public byte[] ErrTitle = new byte[0];
    public byte[] ErrMsg = new byte[0];
    public byte[] ErrInfo = new byte[0];

    public TLV_CommRsp() {
        this._type = 1;
    }

    @Override // oicq.wlogin_sdk.devicelock.d
    public void parse() {
        int i3 = this._head_len;
        this.RetCode = util.buf_to_int32(this._buf, i3);
        int i16 = i3 + 4;
        this.Reason = util.buf_to_int32(this._buf, i16);
        int i17 = i16 + 4;
        int buf_to_int16 = util.buf_to_int16(this._buf, i17);
        int i18 = i17 + 2;
        byte[] bArr = new byte[buf_to_int16];
        this.ErrTitle = bArr;
        System.arraycopy(this._buf, i18, bArr, 0, buf_to_int16);
        int i19 = i18 + buf_to_int16;
        int buf_to_int162 = util.buf_to_int16(this._buf, i19);
        int i26 = i19 + 2;
        byte[] bArr2 = new byte[buf_to_int162];
        this.ErrMsg = bArr2;
        System.arraycopy(this._buf, i26, bArr2, 0, buf_to_int162);
        int i27 = i26 + buf_to_int162;
        this.ErrInfoType = util.buf_to_int16(this._buf, i27);
        int i28 = i27 + 2;
        int buf_to_int163 = util.buf_to_int16(this._buf, i28);
        byte[] bArr3 = new byte[buf_to_int163];
        this.ErrInfo = bArr3;
        System.arraycopy(this._buf, i28 + 2, bArr3, 0, buf_to_int163);
    }
}
