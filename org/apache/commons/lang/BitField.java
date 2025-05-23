package org.apache.commons.lang;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BitField {
    private final int _mask;
    private final int _shift_count;

    public BitField(int i3) {
        this._mask = i3;
        int i16 = 0;
        if (i3 != 0) {
            while ((i3 & 1) == 0) {
                i16++;
                i3 >>= 1;
            }
        }
        this._shift_count = i16;
    }

    public int clear(int i3) {
        return i3 & (~this._mask);
    }

    public byte clearByte(byte b16) {
        return (byte) clear(b16);
    }

    public short clearShort(short s16) {
        return (short) clear(s16);
    }

    public int getRawValue(int i3) {
        return i3 & this._mask;
    }

    public short getShortRawValue(short s16) {
        return (short) getRawValue(s16);
    }

    public short getShortValue(short s16) {
        return (short) getValue(s16);
    }

    public int getValue(int i3) {
        return getRawValue(i3) >> this._shift_count;
    }

    public boolean isAllSet(int i3) {
        int i16 = this._mask;
        if ((i3 & i16) == i16) {
            return true;
        }
        return false;
    }

    public boolean isSet(int i3) {
        if ((i3 & this._mask) != 0) {
            return true;
        }
        return false;
    }

    public int set(int i3) {
        return i3 | this._mask;
    }

    public int setBoolean(int i3, boolean z16) {
        if (z16) {
            return set(i3);
        }
        return clear(i3);
    }

    public byte setByte(byte b16) {
        return (byte) set(b16);
    }

    public byte setByteBoolean(byte b16, boolean z16) {
        if (z16) {
            return setByte(b16);
        }
        return clearByte(b16);
    }

    public short setShort(short s16) {
        return (short) set(s16);
    }

    public short setShortBoolean(short s16, boolean z16) {
        if (z16) {
            return setShort(s16);
        }
        return clearShort(s16);
    }

    public short setShortValue(short s16, short s17) {
        return (short) setValue(s16, s17);
    }

    public int setValue(int i3, int i16) {
        int i17 = this._mask;
        return (i3 & (~i17)) | ((i16 << this._shift_count) & i17);
    }
}
