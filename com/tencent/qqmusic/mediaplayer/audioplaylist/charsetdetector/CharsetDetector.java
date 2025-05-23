package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

import com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_2022;
import com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_Unicode;
import com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_mbcs;
import com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_sbcs;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class CharsetDetector {
    private static final List<CSRecognizerInfo> ALL_CS_RECOGNIZERS;
    private static final int kBufSize = 8000;
    String fDeclaredEncoding;
    private boolean[] fEnabledRecognizers;
    int fInputLen;
    InputStream fInputStream;
    byte[] fRawInput;
    int fRawLength;
    byte[] fInputBytes = new byte[8000];
    short[] fByteStats = new short[256];
    boolean fC1Bytes = false;
    private boolean fStripTags = false;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class CSRecognizerInfo {
        boolean isDefaultEnabled;
        CharsetRecognizer recognizer;

        public CSRecognizerInfo(CharsetRecognizer charsetRecognizer, boolean z16) {
            this.recognizer = charsetRecognizer;
            this.isDefaultEnabled = z16;
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_UTF8(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_Unicode.CharsetRecog_UTF_16_BE(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_Unicode.CharsetRecog_UTF_16_LE(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_Unicode.CharsetRecog_UTF_32_BE(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_Unicode.CharsetRecog_UTF_32_LE(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_mbcs.CharsetRecog_sjis(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_2022.CharsetRecog_2022JP(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_2022.CharsetRecog_2022CN(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_2022.CharsetRecog_2022KR(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_mbcs.CharsetRecog_gb_18030(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_mbcs.CharsetRecog_euc.CharsetRecog_euc_jp(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_mbcs.CharsetRecog_euc.CharsetRecog_euc_kr(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_mbcs.CharsetRecog_big5(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_1(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_2(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_5_ru(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_6_ar(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_7_el(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_8_I_he(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_8_he(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_windows_1251(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_windows_1256(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_KOI8_R(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_9_tr(), true));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_IBM424_he_rtl(), false));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_IBM424_he_ltr(), false));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_IBM420_ar_rtl(), false));
        arrayList.add(new CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_IBM420_ar_ltr(), false));
        ALL_CS_RECOGNIZERS = Collections.unmodifiableList(arrayList);
    }

    private void MungeInput() {
        int i3;
        int i16;
        if (this.fStripTags) {
            int i17 = 0;
            i3 = 0;
            i16 = 0;
            boolean z16 = false;
            for (int i18 = 0; i18 < this.fRawLength; i18++) {
                byte[] bArr = this.fInputBytes;
                if (i17 >= bArr.length) {
                    break;
                }
                byte b16 = this.fRawInput[i18];
                if (b16 == 60) {
                    if (z16) {
                        i16++;
                    }
                    i3++;
                    z16 = true;
                }
                if (!z16) {
                    bArr[i17] = b16;
                    i17++;
                }
                if (b16 == 62) {
                    z16 = false;
                }
            }
            this.fInputLen = i17;
        } else {
            i3 = 0;
            i16 = 0;
        }
        if (i3 < 5 || i3 / 5 < i16 || (this.fInputLen < 100 && this.fRawLength > 600)) {
            int i19 = this.fRawLength;
            if (i19 > 8000) {
                i19 = 8000;
            }
            int i26 = 0;
            while (i26 < i19) {
                this.fInputBytes[i26] = this.fRawInput[i26];
                i26++;
            }
            this.fInputLen = i26;
        }
        Arrays.fill(this.fByteStats, (short) 0);
        for (int i27 = 0; i27 < this.fInputLen; i27++) {
            int i28 = this.fInputBytes[i27] & 255;
            short[] sArr = this.fByteStats;
            sArr[i28] = (short) (sArr[i28] + 1);
        }
        this.fC1Bytes = false;
        for (int i29 = 128; i29 <= 159; i29++) {
            if (this.fByteStats[i29] != 0) {
                this.fC1Bytes = true;
                return;
            }
        }
    }

    public static String[] getAllDetectableCharsets() {
        int size = ALL_CS_RECOGNIZERS.size();
        String[] strArr = new String[size];
        for (int i3 = 0; i3 < size; i3++) {
            strArr[i3] = ALL_CS_RECOGNIZERS.get(i3).recognizer.getName();
        }
        return strArr;
    }

    public CharsetMatch detect() {
        CharsetMatch[] detectAll = detectAll();
        if (detectAll != null && detectAll.length != 0) {
            return detectAll[0];
        }
        return null;
    }

    public CharsetMatch[] detectAll() {
        boolean z16;
        CharsetMatch match;
        ArrayList arrayList = new ArrayList();
        MungeInput();
        int i3 = 0;
        while (true) {
            List<CSRecognizerInfo> list = ALL_CS_RECOGNIZERS;
            if (i3 < list.size()) {
                CSRecognizerInfo cSRecognizerInfo = list.get(i3);
                boolean[] zArr = this.fEnabledRecognizers;
                if (zArr != null) {
                    z16 = zArr[i3];
                } else {
                    z16 = cSRecognizerInfo.isDefaultEnabled;
                }
                if (z16 && (match = cSRecognizerInfo.recognizer.match(this)) != null) {
                    arrayList.add(match);
                }
                i3++;
            } else {
                Collections.sort(arrayList);
                Collections.reverse(arrayList);
                return (CharsetMatch[]) arrayList.toArray(new CharsetMatch[arrayList.size()]);
            }
        }
    }

    public boolean enableInputFilter(boolean z16) {
        boolean z17 = this.fStripTags;
        this.fStripTags = z16;
        return z17;
    }

    @Deprecated
    public String[] getDetectableCharsets() {
        boolean z16;
        ArrayList arrayList = new ArrayList(ALL_CS_RECOGNIZERS.size());
        int i3 = 0;
        while (true) {
            List<CSRecognizerInfo> list = ALL_CS_RECOGNIZERS;
            if (i3 < list.size()) {
                CSRecognizerInfo cSRecognizerInfo = list.get(i3);
                boolean[] zArr = this.fEnabledRecognizers;
                if (zArr == null) {
                    z16 = cSRecognizerInfo.isDefaultEnabled;
                } else {
                    z16 = zArr[i3];
                }
                if (z16) {
                    arrayList.add(cSRecognizerInfo.recognizer.getName());
                }
                i3++;
            } else {
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
        }
    }

    public Reader getReader(InputStream inputStream, String str) {
        this.fDeclaredEncoding = str;
        try {
            setText(inputStream);
            CharsetMatch detect = detect();
            if (detect == null) {
                return null;
            }
            return detect.getReader();
        } catch (IOException unused) {
            return null;
        }
    }

    public String getString(byte[] bArr, String str) {
        this.fDeclaredEncoding = str;
        try {
            setText(bArr);
            CharsetMatch detect = detect();
            if (detect == null) {
                return null;
            }
            return detect.getString(-1);
        } catch (IOException unused) {
            return null;
        }
    }

    public boolean inputFilterEnabled() {
        return this.fStripTags;
    }

    public CharsetDetector setDeclaredEncoding(String str) {
        this.fDeclaredEncoding = str;
        return this;
    }

    @Deprecated
    public CharsetDetector setDetectableCharset(String str, boolean z16) {
        List<CSRecognizerInfo> list;
        boolean z17;
        int i3 = 0;
        int i16 = 0;
        while (true) {
            list = ALL_CS_RECOGNIZERS;
            if (i16 < list.size()) {
                CSRecognizerInfo cSRecognizerInfo = list.get(i16);
                if (cSRecognizerInfo.recognizer.getName().equals(str)) {
                    if (cSRecognizerInfo.isDefaultEnabled == z16) {
                        z17 = true;
                    }
                } else {
                    i16++;
                }
            } else {
                i16 = -1;
                break;
            }
        }
        z17 = false;
        if (i16 >= 0) {
            if (this.fEnabledRecognizers == null && !z17) {
                this.fEnabledRecognizers = new boolean[list.size()];
                while (true) {
                    List<CSRecognizerInfo> list2 = ALL_CS_RECOGNIZERS;
                    if (i3 >= list2.size()) {
                        break;
                    }
                    this.fEnabledRecognizers[i3] = list2.get(i3).isDefaultEnabled;
                    i3++;
                }
            }
            boolean[] zArr = this.fEnabledRecognizers;
            if (zArr != null) {
                zArr[i16] = z16;
            }
            return this;
        }
        throw new IllegalArgumentException("Invalid encoding: \"" + str + "\"");
    }

    public CharsetDetector setText(byte[] bArr) {
        this.fRawInput = bArr;
        this.fRawLength = bArr.length;
        return this;
    }

    public CharsetDetector setText(InputStream inputStream) throws IOException {
        this.fInputStream = inputStream;
        int i3 = 8000;
        inputStream.mark(8000);
        this.fRawInput = new byte[8000];
        this.fRawLength = 0;
        while (i3 > 0) {
            int read = this.fInputStream.read(this.fRawInput, this.fRawLength, i3);
            if (read <= 0) {
                break;
            }
            this.fRawLength += read;
            i3 -= read;
        }
        this.fInputStream.reset();
        return this;
    }
}
