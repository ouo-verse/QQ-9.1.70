package oicq.wlogin_sdk.tlv_type;

import java.io.Serializable;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t implements Serializable {
    public int _body_len;
    public byte[] _buf;
    public int _cmd;
    public int _head_len;
    public int _max;
    public int _pos;
    public int _type;

    public tlv_t() {
        this._max = 128;
        this._pos = 0;
        this._type = 0;
        this._head_len = 4;
        this._body_len = 0;
        this._buf = new byte[128];
        this._cmd = 0;
    }

    public void fill_body(byte[] bArr, int i3) {
        int i16 = this._max;
        int i17 = this._head_len;
        if (i3 > i16 - i17) {
            int i18 = i17 + i3 + 64;
            this._max = i18;
            byte[] bArr2 = new byte[i18];
            System.arraycopy(this._buf, 0, bArr2, 0, this._pos);
            this._buf = bArr2;
        }
        this._body_len = i3;
        System.arraycopy(bArr, 0, this._buf, this._pos, i3);
        this._pos += i3;
    }

    public void fill_head(int i3) {
        util.int16_to_buf(this._buf, this._pos, i3);
        int i16 = this._pos + 2;
        this._pos = i16;
        util.int16_to_buf(this._buf, i16, 0);
        this._pos += 2;
    }

    public byte[] get_buf() {
        int i3 = this._pos;
        byte[] bArr = new byte[i3];
        System.arraycopy(this._buf, 0, bArr, 0, i3);
        return bArr;
    }

    public byte[] get_data() {
        int i3 = this._body_len;
        byte[] bArr = new byte[i3];
        System.arraycopy(this._buf, this._head_len, bArr, 0, i3);
        return bArr;
    }

    public int get_data_len() {
        return this._body_len;
    }

    public int get_tlv(byte[] bArr, int i3, int i16) {
        int i17;
        int search_tlv = search_tlv(bArr, i3, i16, this._cmd);
        if (search_tlv < 0 || this._head_len >= (i17 = i16 - (search_tlv - i3))) {
            return -1;
        }
        int buf_to_int16 = util.buf_to_int16(bArr, search_tlv + 2);
        this._body_len = buf_to_int16;
        int i18 = this._head_len + buf_to_int16;
        if (i18 > i17) {
            return -1;
        }
        set_buf(bArr, search_tlv, i18);
        if (verify().booleanValue()) {
            return search_tlv + this._head_len + this._body_len;
        }
        return -1005;
    }

    public int limit_len(byte[] bArr, int i3) {
        if (bArr != null) {
            if (bArr.length > i3) {
                return i3;
            }
            return bArr.length;
        }
        return 0;
    }

    public int search_tlv(byte[] bArr, int i3, int i16, int i17) {
        int length = bArr.length;
        while (i3 < length) {
            int i18 = i3 + 2;
            if (i18 > length) {
                break;
            }
            if (util.buf_to_int16(bArr, i3) != i17) {
                if (i18 + 2 > length) {
                    break;
                }
                i3 = util.buf_to_int16(bArr, i18) + 2 + i18;
            } else {
                return i3;
            }
        }
        return -1;
    }

    public void set_buf(byte[] bArr, int i3) {
        if (i3 > this._max) {
            int i16 = i3 + 128;
            this._max = i16;
            this._buf = new byte[i16];
        }
        this._pos = i3;
        System.arraycopy(bArr, 0, this._buf, 0, i3);
        this._cmd = util.buf_to_int16(bArr, 0);
        this._body_len = i3 - this._head_len;
    }

    public void set_data(byte[] bArr, int i3) {
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

    public void set_length() {
        util.int16_to_buf(this._buf, 2, this._pos - this._head_len);
    }

    public Boolean verify() {
        return Boolean.TRUE;
    }

    public tlv_t(int i3) {
        this._max = 128;
        this._pos = 0;
        this._type = 0;
        this._head_len = 4;
        this._body_len = 0;
        this._buf = new byte[128];
        this._cmd = i3;
    }

    public int get_tlv(byte[] bArr, int i3, int i16, byte[] bArr2) {
        int search_tlv = search_tlv(bArr, i3, i16, this._cmd);
        if (search_tlv < 0) {
            return -1;
        }
        int i17 = i16 - (search_tlv - i3);
        byte[] bArr3 = new byte[i17];
        System.arraycopy(bArr, search_tlv, bArr3, 0, i17);
        return get_tlv(bArr3, i17, bArr2);
    }

    public void set_buf(byte[] bArr, int i3, int i16) {
        if (i16 > this._max) {
            int i17 = i16 + 128;
            this._max = i17;
            this._buf = new byte[i17];
        }
        this._pos = i16;
        System.arraycopy(bArr, i3, this._buf, 0, i16);
        this._cmd = util.buf_to_int16(bArr, i3);
        this._body_len = i16 - this._head_len;
    }

    public void set_data(byte[] bArr, int i3, int i16) {
        int i17 = this._head_len;
        int i18 = i16 + i17;
        if (i18 > this._max) {
            int i19 = i18 + 128;
            this._max = i19;
            byte[] bArr2 = new byte[i19];
            System.arraycopy(this._buf, 0, bArr2, 0, i17);
            this._buf = bArr2;
        }
        int i26 = this._head_len;
        this._pos = i16 + i26;
        System.arraycopy(bArr, i3, this._buf, i26, i16);
        this._body_len = i16;
        util.int16_to_buf(this._buf, 0, this._cmd);
        util.int16_to_buf(this._buf, 2, this._body_len);
    }

    public int get_tlv(byte[] bArr, int i3, byte[] bArr2) {
        if (this._head_len >= i3) {
            return -1;
        }
        int buf_to_int16 = util.buf_to_int16(bArr, 2);
        this._body_len = buf_to_int16;
        int i16 = this._head_len;
        if (i16 + buf_to_int16 > i3) {
            return -1;
        }
        byte[] decrypt = cryptor.decrypt(bArr, i16, buf_to_int16, bArr2);
        if (decrypt == null) {
            return -1015;
        }
        int i17 = this._head_len;
        if (decrypt.length + i17 > this._max) {
            int length = decrypt.length + i17;
            this._max = length;
            this._buf = new byte[length];
        }
        this._pos = 0;
        System.arraycopy(bArr, 0, this._buf, 0, i17);
        int i18 = this._pos + this._head_len;
        this._pos = i18;
        System.arraycopy(decrypt, 0, this._buf, i18, decrypt.length);
        this._pos += decrypt.length;
        this._body_len = decrypt.length;
        return !verify().booleanValue() ? -1005 : 0;
    }
}
