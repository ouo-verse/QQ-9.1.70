package com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser;

import com.tencent.qqmusic.mediaplayer.audioplaylist.TrackInfo;
import com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetDetector;
import com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetMatch;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/* loaded from: classes23.dex */
public abstract class AudioPlayListItemParser {
    public static final String TAG = "AudioListItemParser";
    protected CharsetDetector charsetDetector = new CharsetDetector();
    protected String mUri;

    public static String delSeprator(String str) {
        return str.substring(str.indexOf("\"") + 1, str.lastIndexOf("\""));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x005b -> B:12:0x005e). Please report as a decompilation issue!!! */
    public String guessCharsetEncoding(InputStream inputStream) {
        BufferedInputStream bufferedInputStream;
        String str = "unicode";
        BufferedInputStream bufferedInputStream2 = null;
        BufferedInputStream bufferedInputStream3 = null;
        bufferedInputStream2 = null;
        bufferedInputStream2 = null;
        try {
            try {
                try {
                    bufferedInputStream = new BufferedInputStream(inputStream);
                    try {
                        this.charsetDetector.setText(bufferedInputStream);
                        CharsetMatch detect = this.charsetDetector.detect();
                        if (detect != null) {
                            int confidence = detect.getConfidence();
                            str = detect.getName();
                            Logger.i(TAG, "Audio list file encode: " + str + " ,confidence: " + confidence);
                            bufferedInputStream3 = confidence;
                        }
                        bufferedInputStream.close();
                        bufferedInputStream2 = bufferedInputStream3;
                    } catch (IOException e16) {
                        e = e16;
                        bufferedInputStream2 = bufferedInputStream;
                        Logger.e(TAG, "guess encoding ex", e);
                        if (bufferedInputStream2 != null) {
                            bufferedInputStream2.close();
                            bufferedInputStream2 = bufferedInputStream2;
                        }
                        return str;
                    } catch (Throwable th5) {
                        th = th5;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e17) {
                                Logger.e(TAG, "guess encoding close fis ex", e17);
                            }
                        }
                        throw th;
                    }
                } catch (IOException e18) {
                    e = e18;
                }
            } catch (IOException e19) {
                Logger.e(TAG, "guess encoding close fis ex", e19);
                bufferedInputStream2 = bufferedInputStream2;
            }
            return str;
        } catch (Throwable th6) {
            th = th6;
            bufferedInputStream = bufferedInputStream2;
        }
    }

    public abstract boolean isParseSuccess();

    public abstract Iterator<TrackInfo> iterator();

    public abstract void parse() throws Exception;
}
