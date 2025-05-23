package org.apache.commons.io;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import java.io.Serializable;
import org.apache.commons.lang.CharEncoding;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ByteOrderMark implements Serializable {
    public static final char UTF_BOM = '\ufeff';
    private static final long serialVersionUID = 1;
    private final int[] bytes;
    private final String charsetName;
    public static final ByteOrderMark UTF_8 = new ByteOrderMark("UTF-8", 239, 187, 191);
    public static final ByteOrderMark UTF_16BE = new ByteOrderMark(CharEncoding.UTF_16BE, 254, 255);
    public static final ByteOrderMark UTF_16LE = new ByteOrderMark(CharEncoding.UTF_16LE, 255, 254);
    public static final ByteOrderMark UTF_32BE = new ByteOrderMark("UTF-32BE", 0, 0, 254, 255);
    public static final ByteOrderMark UTF_32LE = new ByteOrderMark("UTF-32LE", 255, 254, 0, 0);

    public ByteOrderMark(String str, int... iArr) {
        if (str != null && !str.isEmpty()) {
            if (iArr != null && iArr.length != 0) {
                this.charsetName = str;
                int[] iArr2 = new int[iArr.length];
                this.bytes = iArr2;
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                return;
            }
            throw new IllegalArgumentException("No bytes specified");
        }
        throw new IllegalArgumentException("No charsetName specified");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ByteOrderMark)) {
            return false;
        }
        ByteOrderMark byteOrderMark = (ByteOrderMark) obj;
        if (this.bytes.length != byteOrderMark.length()) {
            return false;
        }
        int i3 = 0;
        while (true) {
            int[] iArr = this.bytes;
            if (i3 < iArr.length) {
                if (iArr[i3] != byteOrderMark.get(i3)) {
                    return false;
                }
                i3++;
            } else {
                return true;
            }
        }
    }

    public int get(int i3) {
        return this.bytes[i3];
    }

    public byte[] getBytes() {
        byte[] bArr = new byte[this.bytes.length];
        int i3 = 0;
        while (true) {
            int[] iArr = this.bytes;
            if (i3 < iArr.length) {
                bArr[i3] = (byte) iArr[i3];
                i3++;
            } else {
                return bArr;
            }
        }
    }

    public String getCharsetName() {
        return this.charsetName;
    }

    public int hashCode() {
        int hashCode = getClass().hashCode();
        for (int i3 : this.bytes) {
            hashCode += i3;
        }
        return hashCode;
    }

    public int length() {
        return this.bytes.length;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(getClass().getSimpleName());
        sb5.append('[');
        sb5.append(this.charsetName);
        sb5.append(MsgSummary.STR_COLON);
        for (int i3 = 0; i3 < this.bytes.length; i3++) {
            if (i3 > 0) {
                sb5.append(",");
            }
            sb5.append(RelationNTPushServiceImpl.PRE_HEX_STRING);
            sb5.append(Integer.toHexString(this.bytes[i3] & 255).toUpperCase());
        }
        sb5.append(']');
        return sb5.toString();
    }
}
