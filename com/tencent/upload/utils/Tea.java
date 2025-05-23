package com.tencent.upload.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Tea {
    static IPatchRedirector $redirector_;
    private int contextStart;
    private int crypt;
    private boolean header;
    private byte[] key;
    private byte[] out;
    private int padding;
    private byte[] plain;
    private int pos;
    private int preCrypt;
    private byte[] prePlain;
    private Random random;

    public Tea() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.header = true;
            this.random = new Random();
        }
    }

    private byte[] decipher(byte[] bArr, int i3) {
        try {
            long unsignedInt = getUnsignedInt(bArr, i3, 4);
            long unsignedInt2 = getUnsignedInt(bArr, i3 + 4, 4);
            long unsignedInt3 = getUnsignedInt(this.key, 0, 4);
            long unsignedInt4 = getUnsignedInt(this.key, 4, 4);
            long unsignedInt5 = getUnsignedInt(this.key, 8, 4);
            long unsignedInt6 = getUnsignedInt(this.key, 12, 4);
            int i16 = 16;
            long j3 = 3816266640L;
            while (true) {
                int i17 = i16 - 1;
                if (i16 <= 0) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) unsignedInt);
                    dataOutputStream.writeInt((int) unsignedInt2);
                    dataOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                unsignedInt2 = (unsignedInt2 - ((((unsignedInt << 4) + unsignedInt5) ^ (unsignedInt + j3)) ^ ((unsignedInt >>> 5) + unsignedInt6))) & 4294967295L;
                unsignedInt = (unsignedInt - ((((unsignedInt2 << 4) + unsignedInt3) ^ (unsignedInt2 + j3)) ^ ((unsignedInt2 >>> 5) + unsignedInt4))) & 4294967295L;
                j3 = (j3 - 2654435769L) & 4294967295L;
                i16 = i17;
            }
        } catch (IOException unused) {
            return new byte[50];
        }
    }

    private boolean decrypt8Bytes(byte[] bArr, int i3, int i16) {
        this.pos = 0;
        while (true) {
            int i17 = this.pos;
            if (i17 < 8) {
                if (this.contextStart + i17 >= i16) {
                    return true;
                }
                byte[] bArr2 = this.prePlain;
                bArr2[i17] = (byte) (bArr2[i17] ^ bArr[(this.crypt + i3) + i17]);
                this.pos = i17 + 1;
            } else {
                byte[] decipher = decipher(this.prePlain);
                this.prePlain = decipher;
                if (decipher == null) {
                    return false;
                }
                this.contextStart += 8;
                this.crypt += 8;
                this.pos = 0;
                return true;
            }
        }
    }

    private byte[] encipher(byte[] bArr) {
        try {
            long unsignedInt = getUnsignedInt(bArr, 0, 4);
            long unsignedInt2 = getUnsignedInt(bArr, 4, 4);
            long unsignedInt3 = getUnsignedInt(this.key, 0, 4);
            long unsignedInt4 = getUnsignedInt(this.key, 4, 4);
            long unsignedInt5 = getUnsignedInt(this.key, 8, 4);
            long unsignedInt6 = getUnsignedInt(this.key, 12, 4);
            int i3 = 16;
            long j3 = 0;
            while (true) {
                int i16 = i3 - 1;
                if (i3 > 0) {
                    j3 = (j3 + 2654435769L) & 4294967295L;
                    unsignedInt = (unsignedInt + ((((unsignedInt2 << 4) + unsignedInt3) ^ (unsignedInt2 + j3)) ^ ((unsignedInt2 >>> 5) + unsignedInt4))) & 4294967295L;
                    unsignedInt2 = (unsignedInt2 + ((((unsignedInt << 4) + unsignedInt5) ^ (unsignedInt + j3)) ^ ((unsignedInt >>> 5) + unsignedInt6))) & 4294967295L;
                    i3 = i16;
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) unsignedInt);
                    dataOutputStream.writeInt((int) unsignedInt2);
                    dataOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException unused) {
            return null;
        }
    }

    private byte[] encrypt(byte[] bArr, int i3, int i16, byte[] bArr2) {
        int i17;
        byte[] bArr3 = new byte[8];
        this.plain = bArr3;
        this.prePlain = new byte[8];
        this.pos = 1;
        this.padding = 0;
        this.preCrypt = 0;
        this.crypt = 0;
        this.key = bArr2;
        this.header = true;
        int i18 = (i16 + 10) % 8;
        this.pos = i18;
        if (i18 != 0) {
            this.pos = 8 - i18;
        }
        this.out = new byte[this.pos + i16 + 10];
        bArr3[0] = (byte) ((rand() & 248) | this.pos);
        int i19 = 1;
        while (true) {
            i17 = this.pos;
            if (i19 > i17) {
                break;
            }
            this.plain[i19] = (byte) (rand() & 255);
            i19++;
        }
        this.pos = i17 + 1;
        for (int i26 = 0; i26 < 8; i26++) {
            this.prePlain[i26] = 0;
        }
        this.padding = 1;
        while (this.padding <= 2) {
            int i27 = this.pos;
            if (i27 < 8) {
                byte[] bArr4 = this.plain;
                this.pos = i27 + 1;
                bArr4[i27] = (byte) (rand() & 255);
                this.padding++;
            }
            if (this.pos == 8) {
                encrypt8Bytes();
            }
        }
        while (i16 > 0) {
            int i28 = this.pos;
            if (i28 < 8) {
                byte[] bArr5 = this.plain;
                this.pos = i28 + 1;
                bArr5[i28] = bArr[i3];
                i16--;
                i3++;
            }
            if (this.pos == 8) {
                encrypt8Bytes();
            }
        }
        this.padding = 1;
        while (true) {
            int i29 = this.padding;
            if (i29 <= 7) {
                int i36 = this.pos;
                if (i36 < 8) {
                    byte[] bArr6 = this.plain;
                    this.pos = i36 + 1;
                    bArr6[i36] = 0;
                    this.padding = i29 + 1;
                }
                if (this.pos == 8) {
                    encrypt8Bytes();
                }
            } else {
                return this.out;
            }
        }
    }

    private void encrypt8Bytes() {
        this.pos = 0;
        while (true) {
            int i3 = this.pos;
            if (i3 >= 8) {
                break;
            }
            if (this.header) {
                byte[] bArr = this.plain;
                byte[] bArr2 = this.prePlain;
                if (bArr2 != null && bArr2.length > i3) {
                    bArr[i3] = (byte) (bArr2[i3] ^ bArr[i3]);
                }
            } else {
                byte[] bArr3 = this.plain;
                bArr3[i3] = (byte) (bArr3[i3] ^ this.out[this.preCrypt + i3]);
            }
            this.pos = i3 + 1;
        }
        System.arraycopy(encipher(this.plain), 0, this.out, this.crypt, 8);
        byte[] bArr4 = this.prePlain;
        if (bArr4 != null && bArr4.length >= 8) {
            this.pos = 0;
            while (true) {
                int i16 = this.pos;
                if (i16 >= 8) {
                    break;
                }
                int i17 = this.crypt + i16;
                byte[] bArr5 = this.out;
                bArr5[i17] = (byte) (bArr5[i17] ^ this.prePlain[i16]);
                this.pos = i16 + 1;
            }
        }
        System.arraycopy(this.plain, 0, this.prePlain, 0, 8);
        int i18 = this.crypt;
        this.preCrypt = i18;
        this.crypt = i18 + 8;
        this.pos = 0;
        this.header = false;
    }

    private static long getUnsignedInt(byte[] bArr, int i3, int i16) {
        int i17;
        if (i16 > 8) {
            i17 = i3 + 8;
        } else {
            i17 = i16 + i3;
        }
        long j3 = 0;
        while (i3 < i17) {
            j3 = (j3 << 8) | (bArr[i3] & 255);
            i3++;
        }
        return ((-1) & j3) | (j3 >>> 32);
    }

    private int rand() {
        return this.random.nextInt();
    }

    protected byte[] decrypt(byte[] bArr, int i3, int i16, byte[] bArr2) {
        byte[] bArr3;
        byte[] bArr4;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (byte[]) iPatchRedirector.redirect((short) 2, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16), bArr2);
        }
        this.preCrypt = 0;
        this.crypt = 0;
        this.key = bArr2;
        int i18 = i3 + 8;
        byte[] bArr5 = new byte[i18];
        if (i16 % 8 != 0 || i16 < 16) {
            return null;
        }
        byte[] decipher = decipher(bArr, i3);
        this.prePlain = decipher;
        if (decipher != null && decipher.length > 0) {
            this.pos = decipher[0] & 7;
        }
        int i19 = (i16 - this.pos) - 10;
        if (i19 < 0) {
            return null;
        }
        for (int i26 = i3; i26 < i18; i26++) {
            bArr5[i26] = 0;
        }
        this.out = new byte[i19];
        this.preCrypt = 0;
        this.crypt = 8;
        this.contextStart = 8;
        this.pos++;
        this.padding = 1;
        while (true) {
            int i27 = this.padding;
            if (i27 <= 2) {
                int i28 = this.pos;
                if (i28 < 8) {
                    this.pos = i28 + 1;
                    this.padding = i27 + 1;
                }
                if (this.pos == 8) {
                    if (!decrypt8Bytes(bArr, i3, i16)) {
                        return null;
                    }
                    bArr5 = bArr;
                }
            } else {
                while (i19 != 0) {
                    int i29 = this.pos;
                    if (i29 < 8 && (bArr4 = this.prePlain) != null && bArr4.length > i29) {
                        this.out[i17] = (byte) (bArr4[i29] ^ bArr5[(this.preCrypt + i3) + i29]);
                        i17++;
                        i19--;
                        this.pos = i29 + 1;
                    }
                    if (this.pos == 8) {
                        this.preCrypt = this.crypt - 8;
                        if (!decrypt8Bytes(bArr, i3, i16)) {
                            return null;
                        }
                        bArr5 = bArr;
                    }
                }
                this.padding = 1;
                while (this.padding < 8) {
                    int i36 = this.pos;
                    if (i36 < 8 && (bArr3 = this.prePlain) != null && bArr3.length > i36) {
                        if ((bArr3[i36] ^ bArr5[(this.preCrypt + i3) + i36]) != 0) {
                            return null;
                        }
                        this.pos = i36 + 1;
                    }
                    if (this.pos == 8) {
                        this.preCrypt = this.crypt;
                        if (!decrypt8Bytes(bArr, i3, i16)) {
                            return null;
                        }
                        bArr5 = bArr;
                    }
                    this.padding++;
                }
                return this.out;
            }
        }
    }

    private byte[] decipher(byte[] bArr) {
        return decipher(bArr, 0);
    }

    protected byte[] encrypt(byte[] bArr, byte[] bArr2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? encrypt(bArr, 0, bArr.length, bArr2) : (byte[]) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bArr, (Object) bArr2);
    }

    protected byte[] decrypt(byte[] bArr, byte[] bArr2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? decrypt(bArr, 0, bArr.length, bArr2) : (byte[]) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bArr, (Object) bArr2);
    }
}
