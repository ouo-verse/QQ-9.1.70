package com.immersion.touchsensesdk;

import android.content.Context;
import android.util.Log;

/* loaded from: classes2.dex */
public class HapticMediaPlayer {
    private static final String TAG = "HapticMediaPlayer";
    private static boolean sSDKHealthState = true;
    private ConnectionProxy mConnectionProxy;
    private long mNativeInstance;

    /* loaded from: classes2.dex */
    public static class EffectInfo {
        public static final int EFFECT_MUTED_STATE = 52;
        public static final int EFFECT_STATE = 51;
        public static final int RESOURCE_DURATION = 55;
        public static final int RESOURCE_LOCATION = 54;
        public static final int RESOURCE_STATE = 50;
        public static final int RESOURCE_TYPE = 53;
    }

    /* loaded from: classes2.dex */
    public static class EffectPriority {
        public static final int HIGH = 3;
        public static final int HIGHEST = 4;
        public static final int LOW = 1;
        public static final int LOWEST = 0;
        public static final int NORMAL = 2;
        public static final int NUM_OF_PRIORITIES = 5;
    }

    /* loaded from: classes2.dex */
    public static class EffectState {
        public static final int BUFFERING = 23;
        public static final int IDLE = 20;
        public static final int PAUSED = 22;
        public static final int PLAYING = 21;
        public static final int TIMEOUT = 24;
    }

    /* loaded from: classes2.dex */
    public static class HapticEffectLocation {
        public static final int LOCAL_HAPTIC_EFFECT = 1;
        public static final int REMOTE_HAPTIC_EFFECT = 2;
    }

    /* loaded from: classes2.dex */
    public static class HapticEffectMutedState {
        public static final int MUTED = 30;
        public static final int UNMUTED = 31;
    }

    /* loaded from: classes2.dex */
    public static class HapticEffectType {
        public static final int ASYNC_HAPTIC_EFFECT = 1;
        public static final int SYNC_HAPTIC_EFFECT = 2;
    }

    /* loaded from: classes2.dex */
    public static class PlaybackType {
        public static final int ANDROID_VIBRATE_API_PLAYBACK = 1;
        public static final int NO_PLAYBACK = 0;
        public static final int TOUCHSENSE_PLAYBACK = 2;
    }

    /* loaded from: classes2.dex */
    public static class PlayerInfo {
        public static final int PLAYER_PLAYBACK_TYPE = 46;
        public static final int PLAYER_STATE = 40;
        public static final int PLAYER_VERSION_BUILD = 43;
        public static final int PLAYER_VERSION_MAINTENANCE = 44;
        public static final int PLAYER_VERSION_MAJOR = 41;
        public static final int PLAYER_VERSION_MINOR = 42;
        public static final int PLAYER_VERSION_PATCH = 45;
    }

    /* loaded from: classes2.dex */
    public static class PlayerState {
        public static final int BAD_PARAMETER = 1;
        public static final int INITIALIZED = 0;
        public static final int INVALID_CREDENTIALS = 3;
        public static final int MISSING_PERMISSIONS = 2;
    }

    /* loaded from: classes2.dex */
    public static class ResourceState {
        public static final int DOWNLOAD_ERROR = 13;
        public static final int INVALID = 11;
        public static final int NOT_READY = 10;
        public static final int READY = 12;
    }

    /* loaded from: classes2.dex */
    public static class TouchSenseSDKError {
        public static final int HAPT_NOT_READY = -9;
        public static final int INVALID_EFFECT = -3;
        public static final int INVALID_PARAMETER = -1;
        public static final int INVALID_STATE = -13;
        public static final int INVALID_URI = -2;
        public static final int IO_ERROR = -7;
        public static final int LIB_VERSION_NOT_FOUND = -14;
        public static final int OUT_OF_MEMORY = -5;
        public static final int PLAYER_NOT_INITIALIZED = -11;
        public static final int SDK_INOPERATIVE = -15;
        public static final int SUCCESS = 0;
        public static final int TOO_MANY_CONCURRENT_EFFECTS = -12;
        public static final int TOO_MANY_EFFECTS = -10;
    }

    HapticMediaPlayer(long j3) {
        this.mNativeInstance = j3;
    }

    private int _nAddResource(long j3, String str, int i3) {
        try {
            return nAddResource(j3, str, i3);
        } catch (Throwable th5) {
            updateSDKHealthState(th5);
            return -15;
        }
    }

    private static long _nCreate(Context context, String str, String str2, String str3, IConnectionProxy iConnectionProxy) {
        try {
            return nCreate(context, str, str2, str3, iConnectionProxy);
        } catch (Throwable th5) {
            updateSDKHealthState(th5);
            return 0L;
        }
    }

    private int _nDispose(long j3) {
        try {
            return nDispose(j3);
        } catch (Throwable th5) {
            updateSDKHealthState(th5);
            return -15;
        }
    }

    private int _nGetEffectInfo(long j3, int i3, int i16) {
        try {
            return nGetEffectInfo(j3, i3, i16);
        } catch (Throwable th5) {
            updateSDKHealthState(th5);
            return -15;
        }
    }

    private int _nGetPlayerInfo(long j3, int i3) {
        try {
            return nGetPlayerInfo(j3, i3);
        } catch (Throwable th5) {
            updateSDKHealthState(th5);
            return -15;
        }
    }

    private int _nMute(long j3, int i3) {
        try {
            return nMute(j3, i3);
        } catch (Throwable th5) {
            updateSDKHealthState(th5);
            return -15;
        }
    }

    private int _nPause(long j3, int i3) {
        try {
            return nPause(j3, i3);
        } catch (Throwable th5) {
            updateSDKHealthState(th5);
            return -15;
        }
    }

    private int _nPlay(long j3, int i3, int i16) {
        try {
            return nPlay(j3, i3, i16);
        } catch (Throwable th5) {
            updateSDKHealthState(th5);
            return -15;
        }
    }

    private int _nRemoveResource(long j3, int i3) {
        try {
            return nRemoveResource(j3, i3);
        } catch (Throwable th5) {
            updateSDKHealthState(th5);
            return -15;
        }
    }

    private int _nResume(long j3, int i3) {
        try {
            return nResume(j3, i3);
        } catch (Throwable th5) {
            updateSDKHealthState(th5);
            return -15;
        }
    }

    private int _nSeek(long j3, int i3, long j16) {
        try {
            return nSeek(j3, i3, j16);
        } catch (Throwable th5) {
            updateSDKHealthState(th5);
            return -15;
        }
    }

    private int _nStop(long j3, int i3) {
        try {
            return nStop(j3, i3);
        } catch (Throwable th5) {
            updateSDKHealthState(th5);
            return -15;
        }
    }

    private int _nUnmute(long j3, int i3) {
        try {
            return nUnmute(j3, i3);
        } catch (Throwable th5) {
            updateSDKHealthState(th5);
            return -15;
        }
    }

    private int _nUpdate(long j3, int i3, long j16) {
        try {
            return nUpdate(j3, i3, j16);
        } catch (Throwable th5) {
            updateSDKHealthState(th5);
            return -15;
        }
    }

    public static synchronized HapticMediaPlayer create(Context context, String str, String str2, String str3, AsyncConnectionProxy asyncConnectionProxy) {
        ConnectionProxy connectionProxy;
        synchronized (HapticMediaPlayer.class) {
            if (!sSDKHealthState) {
                Log.e(TAG, "TouchSense SDK has previously encountered a fatal error is now inoperative! Haptics will not be played.");
                return null;
            }
            if (asyncConnectionProxy != null) {
                connectionProxy = (ConnectionProxy) asyncConnectionProxy.getConnectionProxy();
            } else {
                connectionProxy = null;
            }
            long _nCreate = _nCreate(context, str, str2, str3, connectionProxy);
            if (_nCreate == 0) {
                return null;
            }
            HapticMediaPlayer hapticMediaPlayer = new HapticMediaPlayer(_nCreate);
            hapticMediaPlayer.mConnectionProxy = connectionProxy;
            if (hapticMediaPlayer.versionCheck()) {
                return hapticMediaPlayer;
            }
            throw new IllegalStateException("HapticMediaPlayer could not be initialized. Version mismatch between TouchSenseSDK.jar and libTouchSenseSDK.so. Make sure the two libraries are compatible.");
        }
    }

    private native int nAddResource(long j3, String str, int i3);

    private static native long nCreate(Context context, String str, String str2, String str3, IConnectionProxy iConnectionProxy);

    private native int nDispose(long j3);

    private native int nGetEffectInfo(long j3, int i3, int i16);

    private native int nGetPlayerInfo(long j3, int i3);

    private native int nMute(long j3, int i3);

    private native int nPause(long j3, int i3);

    private native int nPlay(long j3, int i3, int i16);

    private native int nRemoveResource(long j3, int i3);

    private native int nResume(long j3, int i3);

    private native int nSeek(long j3, int i3, long j16);

    private native int nStop(long j3, int i3);

    private native int nUnmute(long j3, int i3);

    private native int nUpdate(long j3, int i3, long j16);

    private static void updateSDKHealthState(Throwable th5) {
        sSDKHealthState = false;
        Log.e(TAG, "TouchSense SDK has encountered a fatal error and is now inoperative! Haptics will not be played.");
        th5.printStackTrace();
    }

    private final boolean versionCheck() {
        int[] iArr = {41, 42, 43, 44, 45};
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < 5; i3++) {
            int playerInfo = getPlayerInfo(iArr[i3]);
            if (playerInfo < 0) {
                break;
            }
            if (i3 != 0) {
                sb5.append(".");
            }
            sb5.append(playerInfo);
        }
        String replaceAll = sb5.toString().replaceAll("(\\.0)+$", "");
        Log.i(TAG, "Native version: " + replaceAll + ", Jar version: " + BuildConfig.VERSION_NAME);
        return BuildConfig.VERSION_NAME.contains(replaceAll);
    }

    public final int addResource(String str, int i3) {
        if (sSDKHealthState) {
            return _nAddResource(this.mNativeInstance, str, i3);
        }
        return -15;
    }

    public final int dispose() {
        ConnectionProxy connectionProxy = this.mConnectionProxy;
        if (connectionProxy != null) {
            connectionProxy.abort();
            this.mConnectionProxy = null;
        }
        if (sSDKHealthState) {
            return _nDispose(this.mNativeInstance);
        }
        return -15;
    }

    public final int getEffectInfo(int i3, int i16) {
        if (sSDKHealthState) {
            return _nGetEffectInfo(this.mNativeInstance, i3, i16);
        }
        return -15;
    }

    public final int getPlayerInfo(int i3) {
        if (sSDKHealthState) {
            return _nGetPlayerInfo(this.mNativeInstance, i3);
        }
        return -15;
    }

    public final int mute(int i3) {
        if (sSDKHealthState) {
            return _nMute(this.mNativeInstance, i3);
        }
        return -15;
    }

    public final int pause(int i3) {
        if (sSDKHealthState) {
            return _nPause(this.mNativeInstance, i3);
        }
        return -15;
    }

    public final int play(int i3, int i16) {
        if (sSDKHealthState) {
            return _nPlay(this.mNativeInstance, i3, i16);
        }
        return -15;
    }

    public final int removeResource(int i3) {
        if (sSDKHealthState) {
            return _nRemoveResource(this.mNativeInstance, i3);
        }
        return -15;
    }

    public final int resume(int i3) {
        if (sSDKHealthState) {
            return _nResume(this.mNativeInstance, i3);
        }
        return -15;
    }

    public final int seek(int i3, long j3) {
        if (sSDKHealthState) {
            return _nSeek(this.mNativeInstance, i3, j3);
        }
        return -15;
    }

    public final int stop(int i3) {
        if (sSDKHealthState) {
            return _nStop(this.mNativeInstance, i3);
        }
        return -15;
    }

    public final int unmute(int i3) {
        if (sSDKHealthState) {
            return _nUnmute(this.mNativeInstance, i3);
        }
        return -15;
    }

    public final int update(int i3, long j3) {
        if (sSDKHealthState) {
            return _nUpdate(this.mNativeInstance, i3, j3);
        }
        return -15;
    }

    public final int play(int i3) {
        return play(i3, 2);
    }
}
