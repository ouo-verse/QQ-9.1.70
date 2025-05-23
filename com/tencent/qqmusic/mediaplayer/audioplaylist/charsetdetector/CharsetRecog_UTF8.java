package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

/* compiled from: P */
/* loaded from: classes23.dex */
class CharsetRecog_UTF8 extends CharsetRecognizer {
    @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
    public String getName() {
        return "UTF-8";
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x008c A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008e  */
    @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CharsetMatch match(CharsetDetector charsetDetector) {
        boolean z16;
        int i3;
        byte[] bArr = charsetDetector.fRawInput;
        int i16 = 0;
        if (charsetDetector.fRawLength >= 3 && (bArr[0] & 255) == 239 && (bArr[1] & 255) == 187 && (bArr[2] & 255) == 191) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        while (i17 < charsetDetector.fRawLength) {
            byte b16 = bArr[i17];
            if ((b16 & 128) != 0) {
                if ((b16 & 224) == 192) {
                    i3 = 1;
                } else if ((b16 & 240) == 224) {
                    i3 = 2;
                } else {
                    if ((b16 & 248) == 240) {
                        i3 = 3;
                    }
                    i18++;
                }
                while (true) {
                    i17++;
                    if (i17 < charsetDetector.fRawLength) {
                        if ((bArr[i17] & 192) != 128) {
                            break;
                        }
                        i3--;
                        if (i3 == 0) {
                            i19++;
                            break;
                        }
                    }
                }
            }
            i17++;
        }
        if (!z16 || i18 != 0) {
            if (!z16 || i19 <= i18 * 10) {
                if (i19 <= 3 || i18 != 0) {
                    if (i19 <= 0 || i18 != 0) {
                        if (i19 == 0 && i18 == 0) {
                            i16 = 15;
                        } else if (i19 > i18 * 10) {
                            i16 = 25;
                        }
                        if (i16 == 0) {
                            return null;
                        }
                        return new CharsetMatch(charsetDetector, this, i16);
                    }
                }
            }
            i16 = 80;
            if (i16 == 0) {
            }
        }
        i16 = 100;
        if (i16 == 0) {
        }
    }
}
