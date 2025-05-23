package com.tencent.qqmusic.mediaplayer.formatdetector;

import android.text.TextUtils;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.AudioRecognition;
import com.tencent.qqmusic.mediaplayer.NativeLibs;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;

/* compiled from: P */
/* loaded from: classes23.dex */
public class FormatDetector {
    private static final String TAG = "FormatDetector";
    private static final FormatDetector mInstance = new FormatDetector();
    public static boolean sIsLoadSuccess;

    static {
        sIsLoadSuccess = false;
        sIsLoadSuccess = NativeLibs.loadAll(NativeLibs.audioCommon, NativeLibs.formatDetector);
    }

    public static AudioFormat.AudioType getAudioFormat(String str) throws IllegalArgumentException {
        return getAudioFormat(str, true);
    }

    public static AudioFormat.AudioType getAudioType(String str) {
        AudioFormat.AudioType audioType = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (sIsLoadSuccess) {
            AudioFormat.AudioType audioFormat = getAudioFormat(str);
            if (AudioFormat.isAudioType(audioFormat)) {
                audioType = audioFormat;
            }
        }
        return !AudioFormat.isAudioType(audioType) ? getAudioTypeFromExtension(str.substring(str.lastIndexOf(46) + 1).toLowerCase()) : audioType;
    }

    public static AudioFormat.AudioType getAudioTypeFromExtension(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (AudioFormat.AudioType audioType : AudioFormat.AudioType.values()) {
            if (audioType.getExtension().equalsIgnoreCase(str)) {
                return audioType;
            }
        }
        return AudioFormat.AudioType.UNSUPPORT;
    }

    private native int getFormat(String str, boolean z16);

    private native int getFormatFromDataSource(IDataSource iDataSource, boolean z16);

    public static AudioFormat.AudioType getAudioFormat(String str, boolean z16) throws IllegalArgumentException {
        if (str != null) {
            try {
                return AudioFormat.getAudioType(mInstance.getFormat(str, z16));
            } catch (UnsatisfiedLinkError e16) {
                Logger.e(TAG, e16);
                return AudioRecognition.guessFormat(str);
            }
        }
        throw new IllegalArgumentException("filePath can't be null!");
    }

    public static AudioFormat.AudioType getAudioFormat(IDataSource iDataSource, boolean z16) throws IllegalArgumentException {
        if (iDataSource != null) {
            AudioFormat.AudioType audioType = AudioFormat.AudioType.UNSUPPORT;
            try {
                return AudioFormat.getAudioType(mInstance.getFormatFromDataSource(iDataSource, z16));
            } catch (UnsatisfiedLinkError e16) {
                Logger.e(TAG, e16);
                return audioType;
            }
        }
        throw new IllegalArgumentException("dataSource can't be null!");
    }

    public static AudioFormat.AudioType getAudioType(IDataSource iDataSource) throws IllegalArgumentException {
        if (iDataSource != null) {
            AudioFormat.AudioType audioType = AudioFormat.AudioType.UNSUPPORT;
            if (!sIsLoadSuccess) {
                return audioType;
            }
            AudioFormat.AudioType audioFormat = getAudioFormat(iDataSource, false);
            return AudioFormat.isAudioType(audioFormat) ? audioFormat : audioType;
        }
        throw new IllegalArgumentException("dataSource can't be null!");
    }
}
