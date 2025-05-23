package com.tencent.qqmusic.mediaplayer;

import com.tencent.qqmusic.mediaplayer.util.Logger;

/* loaded from: classes23.dex */
public class AudioPlayerConfigure {
    private static final String LIB_PREFIX = "lib";
    private static final String LIB_SUFFIX = ".so";
    private static final String TAG = "AudioPlayerConfigure";
    static ISoLibraryLoader mISoLibraryLoader = new ISoLibraryLoader() { // from class: com.tencent.qqmusic.mediaplayer.AudioPlayerConfigure.1
        @Override // com.tencent.qqmusic.mediaplayer.ISoLibraryLoader
        public String findLibPath(String str) {
            if (!str.startsWith("lib")) {
                str = "lib" + str;
            }
            if (!str.endsWith(AudioPlayerConfigure.LIB_SUFFIX)) {
                return str + AudioPlayerConfigure.LIB_SUFFIX;
            }
            return str;
        }

        @Override // com.tencent.qqmusic.mediaplayer.ISoLibraryLoader
        public boolean load(String str) {
            System.loadLibrary(str);
            return true;
        }
    };
    static int minAudioTrackWaitTimeMs = 300;
    private static IAudioTrackCreator sAudioTrackCreator = null;
    private static boolean sIsNlogEnabled = false;

    public static boolean enableNativeLog(String str) {
        return enableNativeLog(NativeLibs.nlog.getName(), str);
    }

    private static byte[] findLibPath(byte[] bArr) {
        return mISoLibraryLoader.findLibPath(new String(bArr)).getBytes();
    }

    public static IAudioTrackCreator getAudioTrackCreator() {
        return sAudioTrackCreator;
    }

    public static ISoLibraryLoader getSoLibraryLoader() {
        return mISoLibraryLoader;
    }

    public static void setAudioTrackCreator(IAudioTrackCreator iAudioTrackCreator) {
        sAudioTrackCreator = iAudioTrackCreator;
    }

    public static void setAudioTrackMinWaitTimeMs(int i3) {
        minAudioTrackWaitTimeMs = i3;
    }

    public static void setLog(ILog iLog) {
        if (iLog != null) {
            iLog.i(TAG, "QQMusicAudioPlayer codec version:1.30.19");
        }
        Logger.setLog(iLog);
    }

    public static void setSoLibraryLoader(ISoLibraryLoader iSoLibraryLoader) {
        if (iSoLibraryLoader != null) {
            mISoLibraryLoader = iSoLibraryLoader;
        }
    }

    public static boolean enableNativeLog(String str, String str2) {
        if (sIsNlogEnabled) {
            return true;
        }
        String findLibPath = getSoLibraryLoader().findLibPath(str);
        Logger.i(TAG, "[enableNativeLog] loading log lib: " + findLibPath);
        boolean z16 = str2 == null;
        if (NLog.init(str, str2, 0) && NativeLog.init(findLibPath) == 0) {
            sIsNlogEnabled = true;
            NLog.setWriteCallback(z16);
            Logger.i(TAG, "[enableNativeLog] succeed");
        } else {
            Logger.e(TAG, "[enableNativeLog] failed");
        }
        return sIsNlogEnabled;
    }
}
