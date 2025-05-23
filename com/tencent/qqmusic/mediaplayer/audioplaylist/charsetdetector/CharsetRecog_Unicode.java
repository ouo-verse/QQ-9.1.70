package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

import org.apache.commons.lang.CharEncoding;

/* compiled from: P */
/* loaded from: classes23.dex */
abstract class CharsetRecog_Unicode extends CharsetRecognizer {

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class CharsetRecog_UTF_16_BE extends CharsetRecog_Unicode {
        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_Unicode, com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
        public String getName() {
            return CharEncoding.UTF_16BE;
        }

        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_Unicode, com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
        public CharsetMatch match(CharsetDetector charsetDetector) {
            byte[] bArr = charsetDetector.fRawInput;
            int min = Math.min(bArr.length, 30);
            int i3 = 10;
            int i16 = 0;
            int i17 = 0;
            while (true) {
                if (i17 >= min - 1) {
                    break;
                }
                int codeUnit16FromBytes = CharsetRecog_Unicode.codeUnit16FromBytes(bArr[i17], bArr[i17 + 1]);
                if (i17 == 0 && codeUnit16FromBytes == 65279) {
                    i3 = 100;
                    break;
                }
                i3 = CharsetRecog_Unicode.adjustConfidence(codeUnit16FromBytes, i3);
                if (i3 == 0 || i3 == 100) {
                    break;
                }
                i17 += 2;
            }
            if (min >= 4 || i3 >= 100) {
                i16 = i3;
            }
            if (i16 > 0) {
                return new CharsetMatch(charsetDetector, this, i16);
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class CharsetRecog_UTF_16_LE extends CharsetRecog_Unicode {
        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_Unicode, com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
        public String getName() {
            return CharEncoding.UTF_16LE;
        }

        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_Unicode, com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
        public CharsetMatch match(CharsetDetector charsetDetector) {
            byte[] bArr = charsetDetector.fRawInput;
            int min = Math.min(bArr.length, 30);
            int i3 = 10;
            int i16 = 0;
            int i17 = 0;
            while (true) {
                if (i17 >= min - 1) {
                    break;
                }
                int codeUnit16FromBytes = CharsetRecog_Unicode.codeUnit16FromBytes(bArr[i17 + 1], bArr[i17]);
                if (i17 == 0 && codeUnit16FromBytes == 65279) {
                    i3 = 100;
                    break;
                }
                i3 = CharsetRecog_Unicode.adjustConfidence(codeUnit16FromBytes, i3);
                if (i3 == 0 || i3 == 100) {
                    break;
                }
                i17 += 2;
            }
            if (min >= 4 || i3 >= 100) {
                i16 = i3;
            }
            if (i16 > 0) {
                return new CharsetMatch(charsetDetector, this, i16);
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static abstract class CharsetRecog_UTF_32 extends CharsetRecog_Unicode {
        public abstract int getChar(byte[] bArr, int i3);

        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_Unicode, com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
        public abstract String getName();

        /* JADX WARN: Removed duplicated region for block: B:28:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_Unicode, com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public CharsetMatch match(CharsetDetector charsetDetector) {
            boolean z16;
            byte[] bArr = charsetDetector.fRawInput;
            int i3 = (charsetDetector.fRawLength / 4) * 4;
            if (i3 == 0) {
                return null;
            }
            int i16 = 0;
            if (getChar(bArr, 0) == 65279) {
                z16 = true;
            } else {
                z16 = false;
            }
            int i17 = 0;
            int i18 = 0;
            for (int i19 = 0; i19 < i3; i19 += 4) {
                int i26 = getChar(bArr, i19);
                if (i26 >= 0 && i26 < 1114111 && (i26 < 55296 || i26 > 57343)) {
                    i18++;
                } else {
                    i17++;
                }
            }
            if (!z16 || i17 != 0) {
                if (!z16 || i18 <= i17 * 10) {
                    if (i18 <= 3 || i17 != 0) {
                        if (i18 <= 0 || i17 != 0) {
                            if (i18 > i17 * 10) {
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

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class CharsetRecog_UTF_32_BE extends CharsetRecog_UTF_32 {
        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_Unicode.CharsetRecog_UTF_32
        public int getChar(byte[] bArr, int i3) {
            return (bArr[i3 + 3] & 255) | ((bArr[i3 + 0] & 255) << 24) | ((bArr[i3 + 1] & 255) << 16) | ((bArr[i3 + 2] & 255) << 8);
        }

        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_Unicode.CharsetRecog_UTF_32, com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_Unicode, com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
        public String getName() {
            return "UTF-32BE";
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class CharsetRecog_UTF_32_LE extends CharsetRecog_UTF_32 {
        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_Unicode.CharsetRecog_UTF_32
        public int getChar(byte[] bArr, int i3) {
            return (bArr[i3 + 0] & 255) | ((bArr[i3 + 3] & 255) << 24) | ((bArr[i3 + 2] & 255) << 16) | ((bArr[i3 + 1] & 255) << 8);
        }

        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_Unicode.CharsetRecog_UTF_32, com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_Unicode, com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
        public String getName() {
            return "UTF-32LE";
        }
    }

    public static int adjustConfidence(int i3, int i16) {
        if (i3 == 0) {
            i16 -= 10;
        } else if ((i3 >= 32 && i3 <= 255) || i3 == 10) {
            i16 += 10;
        }
        if (i16 < 0) {
            return 0;
        }
        if (i16 > 100) {
            return 100;
        }
        return i16;
    }

    public static int codeUnit16FromBytes(byte b16, byte b17) {
        return ((b16 & 255) << 8) | (b17 & 255);
    }

    @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
    public abstract String getName();

    @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
    public abstract CharsetMatch match(CharsetDetector charsetDetector);
}
