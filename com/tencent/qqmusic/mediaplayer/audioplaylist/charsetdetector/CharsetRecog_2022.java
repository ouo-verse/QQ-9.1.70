package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

import com.tencent.mobileqq.wink.storage.kv.MaskType;

/* compiled from: P */
/* loaded from: classes23.dex */
abstract class CharsetRecog_2022 extends CharsetRecognizer {

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class CharsetRecog_2022CN extends CharsetRecog_2022 {
        private byte[][] escapeSequences = {new byte[]{27, 36, 41, 65}, new byte[]{27, 36, 41, 71}, new byte[]{27, 36, 42, 72}, new byte[]{27, 36, 41, 69}, new byte[]{27, 36, 43, 73}, new byte[]{27, 36, 43, 74}, new byte[]{27, 36, 43, 75}, new byte[]{27, 36, 43, 76}, new byte[]{27, 36, 43, 77}, new byte[]{27, 78}, new byte[]{27, 79}};

        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
        public String getName() {
            return "ISO-2022-CN";
        }

        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
        public CharsetMatch match(CharsetDetector charsetDetector) {
            int match = match(charsetDetector.fInputBytes, charsetDetector.fInputLen, this.escapeSequences);
            if (match == 0) {
                return null;
            }
            return new CharsetMatch(charsetDetector, this, match);
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class CharsetRecog_2022JP extends CharsetRecog_2022 {
        private byte[][] escapeSequences = {new byte[]{27, 36, 40, 67}, new byte[]{27, 36, 40, 68}, new byte[]{27, 36, MaskType.MASK_TYPE_EXTERNAL}, new byte[]{27, 36, 65}, new byte[]{27, 36, 66}, new byte[]{27, 38, MaskType.MASK_TYPE_EXTERNAL}, new byte[]{27, 40, 66}, new byte[]{27, 40, 72}, new byte[]{27, 40, 73}, new byte[]{27, 40, 74}, new byte[]{27, 46, 65}, new byte[]{27, 46, 70}};

        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
        public String getName() {
            return "ISO-2022-JP";
        }

        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
        public CharsetMatch match(CharsetDetector charsetDetector) {
            int match = match(charsetDetector.fInputBytes, charsetDetector.fInputLen, this.escapeSequences);
            if (match == 0) {
                return null;
            }
            return new CharsetMatch(charsetDetector, this, match);
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class CharsetRecog_2022KR extends CharsetRecog_2022 {
        private byte[][] escapeSequences = {new byte[]{27, 36, 41, 67}};

        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
        public String getName() {
            return "ISO-2022-KR";
        }

        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
        public CharsetMatch match(CharsetDetector charsetDetector) {
            int match = match(charsetDetector.fInputBytes, charsetDetector.fInputLen, this.escapeSequences);
            if (match == 0) {
                return null;
            }
            return new CharsetMatch(charsetDetector, this, match);
        }
    }

    public int match(byte[] bArr, int i3, byte[][] bArr2) {
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        while (i16 < i3) {
            if (bArr[i16] == 27) {
                for (byte[] bArr3 : bArr2) {
                    if (i3 - i16 >= bArr3.length) {
                        for (int i26 = 1; i26 < bArr3.length; i26++) {
                            if (bArr3[i26] != bArr[i16 + i26]) {
                                break;
                            }
                        }
                        i17++;
                        i16 += bArr3.length - 1;
                        break;
                    }
                }
                i19++;
            }
            byte b16 = bArr[i16];
            if (b16 == 14 || b16 == 15) {
                i18++;
            }
            i16++;
        }
        if (i17 == 0) {
            return 0;
        }
        int i27 = ((i17 * 100) - (i19 * 100)) / (i19 + i17);
        int i28 = i17 + i18;
        if (i28 < 5) {
            i27 -= (5 - i28) * 10;
        }
        if (i27 < 0) {
            return 0;
        }
        return i27;
    }
}
