package org.jf.dexlib2.dexbacked;

import javax.annotation.Nonnull;
import org.jf.dexlib2.analysis.RegisterType;
import org.jf.dexlib2.dexbacked.DexBuffer;
import org.jf.util.ExceptionWithContext;
import org.jf.util.Utf8Utils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexReader<T extends DexBuffer> {

    @Nonnull
    public final T dexBuf;
    private int offset;

    public DexReader(@Nonnull T t16, int i3) {
        this.dexBuf = t16;
        this.offset = i3;
    }

    private int peekUleb128Size(boolean z16) {
        T t16 = this.dexBuf;
        int i3 = t16.baseOffset;
        int i16 = this.offset;
        int i17 = i3 + i16;
        byte[] bArr = t16.buf;
        int i18 = i17 + 1;
        if ((bArr[i17] & 255) > 127) {
            int i19 = i18 + 1;
            if ((bArr[i18] & 255) > 127) {
                i18 = i19 + 1;
                if ((bArr[i19] & 255) > 127) {
                    i19 = i18 + 1;
                    if ((bArr[i18] & 255) > 127) {
                        i18 = i19 + 1;
                        byte b16 = bArr[i19];
                        if (b16 >= 0) {
                            if ((b16 & RegisterType.DOUBLE_HI) > 7 && !z16) {
                                throw new ExceptionWithContext("Encountered valid uleb128 that is out of range at offset 0x%x", Integer.valueOf(this.offset));
                            }
                        } else {
                            throw new ExceptionWithContext("Invalid uleb128 integer encountered at offset 0x%x", Integer.valueOf(this.offset));
                        }
                    }
                }
            }
            i18 = i19;
        }
        return i18 - (i3 + i16);
    }

    private int readUleb128(boolean z16) {
        T t16 = this.dexBuf;
        int i3 = t16.baseOffset;
        int i16 = this.offset + i3;
        byte[] bArr = t16.buf;
        int i17 = i16 + 1;
        int i18 = bArr[i16] & 255;
        if (i18 > 127) {
            int i19 = i17 + 1;
            int i26 = bArr[i17] & 255;
            i18 = (i18 & 127) | ((i26 & 127) << 7);
            if (i26 > 127) {
                i17 = i19 + 1;
                int i27 = bArr[i19] & 255;
                i18 |= (i27 & 127) << 14;
                if (i27 > 127) {
                    i19 = i17 + 1;
                    int i28 = bArr[i17] & 255;
                    i18 |= (i28 & 127) << 21;
                    if (i28 > 127) {
                        i17 = i19 + 1;
                        byte b16 = bArr[i19];
                        if (b16 >= 0) {
                            if ((b16 & RegisterType.DOUBLE_HI) > 7 && !z16) {
                                throw new ExceptionWithContext("Encountered valid uleb128 that is out of range at offset 0x%x", Integer.valueOf(this.offset));
                            }
                            i18 |= b16 << 28;
                        } else {
                            throw new ExceptionWithContext("Invalid uleb128 integer encountered at offset 0x%x", Integer.valueOf(this.offset));
                        }
                    }
                }
            }
            i17 = i19;
        }
        this.offset = i17 - i3;
        return i18;
    }

    public int getOffset() {
        return this.offset;
    }

    public void moveRelative(int i3) {
        this.offset += i3;
    }

    public int peekBigUleb128Size() {
        T t16 = this.dexBuf;
        int i3 = t16.baseOffset;
        int i16 = this.offset;
        int i17 = i3 + i16;
        byte[] bArr = t16.buf;
        int i18 = i17 + 1;
        if ((bArr[i17] & 255) > 127) {
            int i19 = i18 + 1;
            if ((bArr[i18] & 255) > 127) {
                i18 = i19 + 1;
                if ((bArr[i19] & 255) > 127) {
                    i19 = i18 + 1;
                    if ((bArr[i18] & 255) > 127) {
                        i18 = i19 + 1;
                        if (bArr[i19] < 0) {
                            throw new ExceptionWithContext("Invalid uleb128 integer encountered at offset 0x%x", Integer.valueOf(this.offset));
                        }
                    }
                }
            }
            i18 = i19;
        }
        return i18 - (i3 + i16);
    }

    public int peekSleb128Size() {
        T t16 = this.dexBuf;
        int i3 = t16.baseOffset;
        int i16 = this.offset;
        int i17 = i3 + i16;
        byte[] bArr = t16.buf;
        int i18 = i17 + 1;
        if ((bArr[i17] & 255) > 127) {
            int i19 = i18 + 1;
            if ((bArr[i18] & 255) > 127) {
                i18 = i19 + 1;
                if ((bArr[i19] & 255) > 127) {
                    i19 = i18 + 1;
                    if ((bArr[i18] & 255) > 127) {
                        i18 = i19 + 1;
                        if ((bArr[i19] & 255) > 127) {
                            throw new ExceptionWithContext("Invalid sleb128 integer encountered at offset 0x%x", Integer.valueOf(this.offset));
                        }
                    }
                }
            }
            i18 = i19;
        }
        return i18 - (i3 + i16);
    }

    public int peekSmallUleb128Size() {
        return peekUleb128Size(false);
    }

    public int peekStringLength(int i3) {
        int[] iArr = new int[1];
        T t16 = this.dexBuf;
        Utf8Utils.utf8BytesWithUtf16LengthToString(t16.buf, t16.baseOffset + this.offset, i3, iArr);
        return iArr[0];
    }

    public int peekUbyte() {
        return this.dexBuf.readUbyte(this.offset);
    }

    public int peekUshort() {
        return this.dexBuf.readUshort(this.offset);
    }

    public int readBigUleb128() {
        T t16 = this.dexBuf;
        int i3 = t16.baseOffset;
        int i16 = this.offset + i3;
        byte[] bArr = t16.buf;
        int i17 = i16 + 1;
        int i18 = bArr[i16] & 255;
        if (i18 > 127) {
            int i19 = i17 + 1;
            int i26 = bArr[i17] & 255;
            i18 = (i18 & 127) | ((i26 & 127) << 7);
            if (i26 > 127) {
                i17 = i19 + 1;
                int i27 = bArr[i19] & 255;
                i18 |= (i27 & 127) << 14;
                if (i27 > 127) {
                    i19 = i17 + 1;
                    int i28 = bArr[i17] & 255;
                    i18 |= (i28 & 127) << 21;
                    if (i28 > 127) {
                        i17 = i19 + 1;
                        byte b16 = bArr[i19];
                        if (b16 >= 0) {
                            i18 |= b16 << 28;
                        } else {
                            throw new ExceptionWithContext("Invalid uleb128 integer encountered at offset 0x%x", Integer.valueOf(this.offset));
                        }
                    }
                }
            }
            i17 = i19;
        }
        this.offset = i17 - i3;
        return i18;
    }

    public int readByte() {
        int i3 = this.offset;
        int readByte = this.dexBuf.readByte(i3);
        this.offset = i3 + 1;
        return readByte;
    }

    public int readInt() {
        int i3 = this.offset;
        int readInt = this.dexBuf.readInt(i3);
        this.offset = i3 + 4;
        return readInt;
    }

    public int readLargeUleb128() {
        return readUleb128(true);
    }

    public long readLong() {
        int i3 = this.offset;
        long readLong = this.dexBuf.readLong(i3);
        this.offset = i3 + 8;
        return readLong;
    }

    public int readOptionalUint() {
        int i3 = this.offset;
        int readOptionalUint = this.dexBuf.readOptionalUint(i3);
        this.offset = i3 + 4;
        return readOptionalUint;
    }

    public int readShort() {
        int i3 = this.offset;
        int readShort = this.dexBuf.readShort(i3);
        this.offset = i3 + 2;
        return readShort;
    }

    public int readSizedInt(int i3) {
        int i16;
        int i17;
        int i18;
        T t16 = this.dexBuf;
        int i19 = t16.baseOffset;
        int i26 = this.offset + i19;
        byte[] bArr = t16.buf;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        i17 = (bArr[i26] & 255) | ((bArr[i26 + 1] & 255) << 8) | ((bArr[i26 + 2] & 255) << 16);
                        i18 = bArr[i26 + 3] << 24;
                    } else {
                        throw new ExceptionWithContext("Invalid size %d for sized int at offset 0x%x", Integer.valueOf(i3), Integer.valueOf(this.offset));
                    }
                } else {
                    i17 = (bArr[i26] & 255) | ((bArr[i26 + 1] & 255) << 8);
                    i18 = bArr[i26 + 2] << RegisterType.UNINIT_REF;
                }
            } else {
                i17 = bArr[i26] & 255;
                i18 = bArr[i26 + 1] << 8;
            }
            i16 = i18 | i17;
        } else {
            i16 = bArr[i26];
        }
        this.offset = (i26 + i3) - i19;
        return i16;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0013. Please report as an issue. */
    public long readSizedLong(int i3) {
        int i16;
        int i17;
        int i18;
        long j3;
        long j16;
        long j17;
        T t16 = this.dexBuf;
        int i19 = t16.baseOffset;
        int i26 = this.offset + i19;
        byte[] bArr = t16.buf;
        switch (i3) {
            case 1:
                i16 = bArr[i26];
                j3 = i16;
                this.offset = (i26 + i3) - i19;
                return j3;
            case 2:
                i17 = bArr[i26] & 255;
                i18 = bArr[i26 + 1] << 8;
                i16 = i18 | i17;
                j3 = i16;
                this.offset = (i26 + i3) - i19;
                return j3;
            case 3:
                i17 = (bArr[i26] & 255) | ((bArr[i26 + 1] & 255) << 8);
                i18 = bArr[i26 + 2] << RegisterType.UNINIT_REF;
                i16 = i18 | i17;
                j3 = i16;
                this.offset = (i26 + i3) - i19;
                return j3;
            case 4:
                j16 = (bArr[i26] & 255) | ((bArr[i26 + 1] & 255) << 8) | ((bArr[i26 + 2] & 255) << 16);
                j17 = bArr[i26 + 3] << 24;
                j3 = j16 | j17;
                this.offset = (i26 + i3) - i19;
                return j3;
            case 5:
                j16 = (bArr[i26] & 255) | ((bArr[i26 + 1] & 255) << 8) | ((bArr[i26 + 2] & 255) << 16) | ((255 & bArr[i26 + 3]) << 24);
                j17 = bArr[i26 + 4] << 32;
                j3 = j16 | j17;
                this.offset = (i26 + i3) - i19;
                return j3;
            case 6:
                j3 = (bArr[i26 + 5] << 40) | ((bArr[i26 + 4] & 255) << 32) | (bArr[i26] & 255) | ((bArr[i26 + 1] & 255) << 8) | ((bArr[i26 + 2] & 255) << 16) | ((bArr[i26 + 3] & 255) << 24);
                this.offset = (i26 + i3) - i19;
                return j3;
            case 7:
                j3 = ((bArr[i26 + 4] & 255) << 32) | (bArr[i26] & 255) | ((bArr[i26 + 1] & 255) << 8) | ((bArr[i26 + 2] & 255) << 16) | ((bArr[i26 + 3] & 255) << 24) | ((255 & bArr[i26 + 5]) << 40) | (bArr[i26 + 6] << 48);
                this.offset = (i26 + i3) - i19;
                return j3;
            case 8:
                j16 = ((bArr[i26 + 4] & 255) << 32) | (bArr[i26] & 255) | ((bArr[i26 + 1] & 255) << 8) | ((bArr[i26 + 2] & 255) << 16) | ((bArr[i26 + 3] & 255) << 24) | ((bArr[i26 + 5] & 255) << 40) | ((bArr[i26 + 6] & 255) << 48);
                j17 = bArr[i26 + 7] << 56;
                j3 = j16 | j17;
                this.offset = (i26 + i3) - i19;
                return j3;
            default:
                throw new ExceptionWithContext("Invalid size %d for sized long at offset 0x%x", Integer.valueOf(i3), Integer.valueOf(this.offset));
        }
    }

    public int readSizedRightExtendedInt(int i3) {
        int i16;
        int i17;
        byte b16;
        T t16 = this.dexBuf;
        int i18 = t16.baseOffset;
        int i19 = this.offset + i18;
        byte[] bArr = t16.buf;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        i17 = (bArr[i19] & 255) | ((bArr[i19 + 1] & 255) << 8) | ((bArr[i19 + 2] & 255) << 16);
                        b16 = bArr[i19 + 3];
                    } else {
                        throw new ExceptionWithContext("Invalid size %d for sized, right extended int at offset 0x%x", Integer.valueOf(i3), Integer.valueOf(this.offset));
                    }
                } else {
                    i17 = ((bArr[i19] & 255) << 8) | ((bArr[i19 + 1] & 255) << 16);
                    b16 = bArr[i19 + 2];
                }
            } else {
                i17 = (bArr[i19] & 255) << 16;
                b16 = bArr[i19 + 1];
            }
            i16 = (b16 << 24) | i17;
        } else {
            i16 = bArr[i19] << 24;
        }
        this.offset = (i19 + i3) - i18;
        return i16;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0015. Please report as an issue. */
    public long readSizedRightExtendedLong(int i3) {
        long j3;
        long j16;
        byte b16;
        T t16 = this.dexBuf;
        int i16 = t16.baseOffset;
        int i17 = this.offset + i16;
        byte[] bArr = t16.buf;
        switch (i3) {
            case 1:
                j3 = bArr[i17] << 56;
                this.offset = (i17 + i3) - i16;
                return j3;
            case 2:
                j16 = (bArr[i17] & 255) << 48;
                b16 = bArr[i17 + 1];
                j3 = j16 | (b16 << 56);
                this.offset = (i17 + i3) - i16;
                return j3;
            case 3:
                j16 = ((bArr[i17] & 255) << 40) | ((255 & bArr[i17 + 1]) << 48);
                b16 = bArr[i17 + 2];
                j3 = j16 | (b16 << 56);
                this.offset = (i17 + i3) - i16;
                return j3;
            case 4:
                j16 = ((bArr[i17] & 255) << 32) | ((bArr[i17 + 1] & 255) << 40) | ((255 & bArr[i17 + 2]) << 48);
                b16 = bArr[i17 + 3];
                j3 = j16 | (b16 << 56);
                this.offset = (i17 + i3) - i16;
                return j3;
            case 5:
                j16 = ((bArr[i17 + 1] & 255) << 32) | ((bArr[i17] & 255) << 24) | ((bArr[i17 + 2] & 255) << 40) | ((255 & bArr[i17 + 3]) << 48);
                b16 = bArr[i17 + 4];
                j3 = j16 | (b16 << 56);
                this.offset = (i17 + i3) - i16;
                return j3;
            case 6:
                j16 = ((bArr[i17 + 2] & 255) << 32) | ((bArr[i17] & 255) << 16) | ((bArr[i17 + 1] & 255) << 24) | ((bArr[i17 + 3] & 255) << 40) | ((255 & bArr[i17 + 4]) << 48);
                b16 = bArr[i17 + 5];
                j3 = j16 | (b16 << 56);
                this.offset = (i17 + i3) - i16;
                return j3;
            case 7:
                j16 = ((bArr[i17 + 3] & 255) << 32) | ((bArr[i17] & 255) << 8) | ((bArr[i17 + 1] & 255) << 16) | ((bArr[i17 + 2] & 255) << 24) | ((bArr[i17 + 4] & 255) << 40) | ((255 & bArr[i17 + 5]) << 48);
                b16 = bArr[i17 + 6];
                j3 = j16 | (b16 << 56);
                this.offset = (i17 + i3) - i16;
                return j3;
            case 8:
                j16 = ((bArr[i17 + 4] & 255) << 32) | (bArr[i17] & 255) | ((bArr[i17 + 1] & 255) << 8) | ((bArr[i17 + 2] & 255) << 16) | ((bArr[i17 + 3] & 255) << 24) | ((bArr[i17 + 5] & 255) << 40) | ((255 & bArr[i17 + 6]) << 48);
                b16 = bArr[i17 + 7];
                j3 = j16 | (b16 << 56);
                this.offset = (i17 + i3) - i16;
                return j3;
            default:
                throw new ExceptionWithContext("Invalid size %d for sized, right extended long at offset 0x%x", Integer.valueOf(i3), Integer.valueOf(this.offset));
        }
    }

    public int readSizedSmallUint(int i3) {
        T t16 = this.dexBuf;
        int i16 = t16.baseOffset;
        int i17 = this.offset + i16;
        byte[] bArr = t16.buf;
        int i18 = 0;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        byte b16 = bArr[i17 + 3];
                        if (b16 >= 0) {
                            i18 = b16 << 24;
                        } else {
                            throw new ExceptionWithContext("Encountered valid sized uint that is out of range at offset 0x%x", Integer.valueOf(this.offset));
                        }
                    } else {
                        throw new ExceptionWithContext("Invalid size %d for sized uint at offset 0x%x", Integer.valueOf(i3), Integer.valueOf(this.offset));
                    }
                }
                i18 |= (bArr[i17 + 2] & 255) << 16;
            }
            i18 |= (bArr[i17 + 1] & 255) << 8;
        }
        int i19 = (bArr[i17] & 255) | i18;
        this.offset = (i17 + i3) - i16;
        return i19;
    }

    public int readSleb128() {
        int i3;
        T t16 = this.dexBuf;
        int i16 = t16.baseOffset;
        int i17 = this.offset + i16;
        byte[] bArr = t16.buf;
        int i18 = i17 + 1;
        int i19 = bArr[i17] & 255;
        if (i19 <= 127) {
            i3 = (i19 << 25) >> 25;
        } else {
            int i26 = i18 + 1;
            int i27 = bArr[i18] & 255;
            int i28 = (i19 & 127) | ((i27 & 127) << 7);
            if (i27 <= 127) {
                i3 = (i28 << 18) >> 18;
            } else {
                i18 = i26 + 1;
                int i29 = bArr[i26] & 255;
                int i36 = i28 | ((i29 & 127) << 14);
                if (i29 <= 127) {
                    i3 = (i36 << 11) >> 11;
                } else {
                    i26 = i18 + 1;
                    int i37 = bArr[i18] & 255;
                    int i38 = i36 | ((i37 & 127) << 21);
                    if (i37 <= 127) {
                        i3 = (i38 << 4) >> 4;
                    } else {
                        i18 = i26 + 1;
                        int i39 = bArr[i26] & 255;
                        if (i39 <= 127) {
                            i3 = (i39 << 28) | i38;
                        } else {
                            throw new ExceptionWithContext("Invalid sleb128 integer encountered at offset 0x%x", Integer.valueOf(this.offset));
                        }
                    }
                }
            }
            i18 = i26;
        }
        this.offset = i18 - i16;
        return i3;
    }

    public int readSmallUint() {
        int i3 = this.offset;
        int readSmallUint = this.dexBuf.readSmallUint(i3);
        this.offset = i3 + 4;
        return readSmallUint;
    }

    public int readSmallUleb128() {
        return readUleb128(false);
    }

    public String readString(int i3) {
        int[] iArr = new int[1];
        T t16 = this.dexBuf;
        String utf8BytesWithUtf16LengthToString = Utf8Utils.utf8BytesWithUtf16LengthToString(t16.buf, t16.baseOffset + this.offset, i3, iArr);
        this.offset += iArr[0];
        return utf8BytesWithUtf16LengthToString;
    }

    public int readUbyte() {
        int i3 = this.offset;
        int readUbyte = this.dexBuf.readUbyte(i3);
        this.offset = i3 + 1;
        return readUbyte;
    }

    public int readUshort() {
        int i3 = this.offset;
        int readUshort = this.dexBuf.readUshort(i3);
        this.offset = i3 + 2;
        return readUshort;
    }

    public void setOffset(int i3) {
        this.offset = i3;
    }

    public void skipByte() {
        this.offset++;
    }

    public void skipUleb128() {
        T t16 = this.dexBuf;
        int i3 = t16.baseOffset;
        int i16 = this.offset + i3;
        byte[] bArr = t16.buf;
        int i17 = i16 + 1;
        if (bArr[i16] < 0) {
            int i18 = i17 + 1;
            if (bArr[i17] < 0) {
                i17 = i18 + 1;
                if (bArr[i18] < 0) {
                    i18 = i17 + 1;
                    if (bArr[i17] < 0) {
                        i17 = i18 + 1;
                        if (bArr[i18] < 0) {
                            throw new ExceptionWithContext("Invalid uleb128 integer encountered at offset 0x%x", Integer.valueOf(this.offset));
                        }
                    }
                }
            }
            i17 = i18;
        }
        this.offset = i17 - i3;
    }

    public int readByte(int i3) {
        return this.dexBuf.readByte(i3);
    }

    public int readInt(int i3) {
        return this.dexBuf.readInt(i3);
    }

    public long readLong(int i3) {
        return this.dexBuf.readLong(i3);
    }

    public int readShort(int i3) {
        return this.dexBuf.readShort(i3);
    }

    public int readSmallUint(int i3) {
        return this.dexBuf.readSmallUint(i3);
    }

    public int readUbyte(int i3) {
        return this.dexBuf.readUbyte(i3);
    }

    public int readUshort(int i3) {
        return this.dexBuf.readUshort(i3);
    }
}
