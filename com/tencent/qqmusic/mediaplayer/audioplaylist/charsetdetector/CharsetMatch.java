package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/* compiled from: P */
/* loaded from: classes23.dex */
public class CharsetMatch implements Comparable<CharsetMatch> {
    private String fCharsetName;
    private int fConfidence;
    private InputStream fInputStream;
    private String fLang;
    private byte[] fRawInput;
    private int fRawLength;

    public CharsetMatch(CharsetDetector charsetDetector, CharsetRecognizer charsetRecognizer, int i3) {
        this.fRawInput = null;
        this.fInputStream = null;
        this.fConfidence = i3;
        InputStream inputStream = charsetDetector.fInputStream;
        if (inputStream == null) {
            this.fRawInput = charsetDetector.fRawInput;
            this.fRawLength = charsetDetector.fRawLength;
        }
        this.fInputStream = inputStream;
        this.fCharsetName = charsetRecognizer.getName();
        this.fLang = charsetRecognizer.getLanguage();
    }

    public int getConfidence() {
        return this.fConfidence;
    }

    public String getLanguage() {
        return this.fLang;
    }

    public String getName() {
        return this.fCharsetName;
    }

    public Reader getReader() {
        InputStream inputStream = this.fInputStream;
        if (inputStream == null) {
            inputStream = new ByteArrayInputStream(this.fRawInput, 0, this.fRawLength);
        }
        try {
            inputStream.reset();
            return new InputStreamReader(inputStream, getName());
        } catch (IOException unused) {
            return null;
        }
    }

    public String getString() throws IOException {
        return getString(-1);
    }

    @Override // java.lang.Comparable
    public int compareTo(CharsetMatch charsetMatch) {
        int i3 = this.fConfidence;
        int i16 = charsetMatch.fConfidence;
        if (i3 > i16) {
            return 1;
        }
        return i3 < i16 ? -1 : 0;
    }

    public String getString(int i3) throws IOException {
        if (this.fInputStream != null) {
            StringBuilder sb5 = new StringBuilder();
            char[] cArr = new char[1024];
            Reader reader = getReader();
            if (i3 < 0) {
                i3 = Integer.MAX_VALUE;
            }
            while (true) {
                int read = reader.read(cArr, 0, Math.min(i3, 1024));
                if (read >= 0) {
                    sb5.append(cArr, 0, read);
                    i3 -= read;
                } else {
                    reader.close();
                    return sb5.toString();
                }
            }
        } else {
            String name = getName();
            int indexOf = name.indexOf(name.indexOf("_rtl") < 0 ? "_ltr" : "_rtl");
            if (indexOf > 0) {
                name = name.substring(0, indexOf);
            }
            return new String(this.fRawInput, name);
        }
    }

    public CharsetMatch(CharsetDetector charsetDetector, CharsetRecognizer charsetRecognizer, int i3, String str, String str2) {
        this.fRawInput = null;
        this.fInputStream = null;
        this.fConfidence = i3;
        InputStream inputStream = charsetDetector.fInputStream;
        if (inputStream == null) {
            this.fRawInput = charsetDetector.fRawInput;
            this.fRawLength = charsetDetector.fRawLength;
        }
        this.fInputStream = inputStream;
        this.fCharsetName = str;
        this.fLang = str2;
    }
}
