package oicq.wlogin_sdk.devicelock;

import oicq.wlogin_sdk.tools.util;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes28.dex */
public class d {
    public int _max = 128;
    public int _pos = 0;
    public int _type = 0;
    public int _head_len = 4;
    public int _body_len = 0;
    public byte[] _buf = new byte[128];

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
        set_length();
    }

    public void fill_head() {
        util.int16_to_buf(this._buf, this._pos, this._type);
        int i3 = this._pos + 2;
        this._pos = i3;
        util.int16_to_buf(this._buf, i3, 0);
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

    public int get_size() {
        return this._pos;
    }

    public int get_type() {
        return this._type;
    }

    public int put_block(byte[] bArr, int i3) {
        int length = bArr.length;
        util.int16_to_buf(this._buf, i3, length);
        int i16 = i3 + 2;
        System.arraycopy(bArr, 0, this._buf, i16, length);
        return i16 + length;
    }

    public int put_int16(int i3, int i16) {
        util.int16_to_buf(this._buf, i16, i3);
        return i16 + 2;
    }

    public int put_int32(long j3, int i3) {
        util.int64_to_buf32(this._buf, i3, j3);
        return i3 + 4;
    }

    public int put_int64(long j3, int i3) {
        util.int64_to_buf(this._buf, i3, j3);
        return i3 + 8;
    }

    public int put_int8(int i3, int i16) {
        util.int8_to_buf(this._buf, i16, i3);
        return i16 + 1;
    }

    public int set_buf(byte[] bArr, int i3) {
        if (i3 > this._max) {
            int i16 = i3 + 128;
            this._max = i16;
            this._buf = new byte[i16];
        }
        this._pos = i3;
        System.arraycopy(bArr, 0, this._buf, 0, i3);
        this._type = util.buf_to_int16(bArr, 0);
        this._body_len = i3 - this._head_len;
        try {
            parse();
            return 0;
        } catch (Exception unused) {
            return -1009;
        }
    }

    public int set_data(byte[] bArr, int i3) {
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
        util.int16_to_buf(this._buf, 0, this._type);
        util.int16_to_buf(this._buf, 2, this._body_len);
        try {
            parse();
            return 0;
        } catch (Exception unused) {
            return -1009;
        }
    }

    public void set_length() {
        util.int16_to_buf(this._buf, 2, this._pos - this._head_len);
    }

    public String toString() {
        String str = "";
        for (int i3 = 0; i3 < this._pos; i3++) {
            str = (str + Integer.toHexString((this._buf[i3] >> 4) & 15)) + Integer.toHexString(this._buf[i3] & RegisterType.DOUBLE_HI);
        }
        return str;
    }

    public void parse() {
    }
}
