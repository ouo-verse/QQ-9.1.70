package com.tencent.thumbplayer.core.codec.decoder;

import android.os.Build;
import android.util.SparseArray;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import com.tencent.thumbplayer.core.utils.TPMethodCalledByNative;
import com.tencent.thumbplayer.core.utils.TPNativeLog;
import java.util.concurrent.atomic.AtomicInteger;

@RequiresApi(api = 16)
/* loaded from: classes26.dex */
public class TPMediaCodecManager {
    private static final String TAG = "TPMediaCodecManager";
    private static SparseArray<ITPMediaCodecDecoder> mCodecList = new SparseArray<>();
    private static AtomicInteger codecNum = new AtomicInteger(0);

    private static native void _onMediaCodecException(int i3, String str);

    private static native void _onMediaCodecReady(int i3, String str);

    private static native void _onMediaCodecReportEvent(int i3, int i16);

    private static native void _onMediaDrmInfo(int i3, Object obj);

    private static void addCodecToList(int i3, ITPMediaCodecDecoder iTPMediaCodecDecoder) {
        synchronized (TPMediaCodecManager.class) {
            mCodecList.put(i3, iTPMediaCodecDecoder);
        }
    }

    @TPMethodCalledByNative
    public static int createMediaCodec(boolean z16) {
        ITPMediaCodecDecoder tPMediaCodecVideoDecoder;
        if (codecNum.get() >= Integer.MAX_VALUE) {
            codecNum.set(0);
        }
        int andIncrement = codecNum.getAndIncrement();
        if (z16) {
            tPMediaCodecVideoDecoder = new TPMediaCodecAudioDecoder(andIncrement);
        } else {
            tPMediaCodecVideoDecoder = new TPMediaCodecVideoDecoder(andIncrement);
        }
        addCodecToList(andIncrement, tPMediaCodecVideoDecoder);
        return andIncrement;
    }

    @TPMethodCalledByNative
    public static int flushMediaCodec(int i3) {
        ITPMediaCodecDecoder codecById = getCodecById(i3);
        if (codecById == null) {
            TPNativeLog.printLog(1, TAG, "flushMediaCodec failed!");
            return 3;
        }
        return codecById.flush();
    }

    private static ITPMediaCodecDecoder getCodecById(int i3) {
        ITPMediaCodecDecoder iTPMediaCodecDecoder;
        synchronized (TPMediaCodecManager.class) {
            iTPMediaCodecDecoder = mCodecList.get(i3);
        }
        if (iTPMediaCodecDecoder == null) {
            TPNativeLog.printLog(1, TAG, "No such codec by id:" + i3);
            return null;
        }
        return iTPMediaCodecDecoder;
    }

    @TPMethodCalledByNative
    public static int getMediaType(int i3) {
        ITPMediaCodecDecoder codecById = getCodecById(i3);
        if (codecById == null) {
            return -1;
        }
        return codecById.getMediaType();
    }

    @TPMethodCalledByNative
    public static int getSDKVersion() {
        return Build.VERSION.SDK_INT;
    }

    @TPMethodCalledByNative
    public static boolean initAudioMediaCodec(int i3, String str, int i16, int i17, int i18, int i19) {
        ITPMediaCodecDecoder codecById = getCodecById(i3);
        if (codecById == null) {
            TPNativeLog.printLog(1, TAG, "initAudioMediaCodec failed!");
            return false;
        }
        if (!codecById.initDecoder(str, i16, i17, i18, i19)) {
            return false;
        }
        return codecById.startDecoder();
    }

    @TPMethodCalledByNative
    public static boolean initVideoMediaCodec(int i3, String str, int i16, int i17, int i18, Surface surface, int i19, int i26, int i27) {
        ITPMediaCodecDecoder codecById = getCodecById(i3);
        if (codecById == null) {
            TPNativeLog.printLog(1, TAG, "initVideoMediaCodec failed!");
            return false;
        }
        if (!codecById.initDecoder(str, i16, i17, i18, surface, i19, i26, i27)) {
            return false;
        }
        return codecById.startDecoder();
    }

    public static void onMediaCodecException(int i3, String str) {
        _onMediaCodecException(i3, str);
    }

    public static void onMediaCodecReady(int i3, String str) {
        _onMediaCodecReady(i3, str);
    }

    public static void onMediaCodecReportEvent(int i3, int i16) {
        _onMediaCodecReportEvent(i3, i16);
    }

    public static void onMediaDrmInfo(int i3, Object obj) {
        _onMediaDrmInfo(i3, obj);
    }

    @TPMethodCalledByNative
    public static TPFrameInfo receiveOneFrame(int i3) {
        ITPMediaCodecDecoder codecById = getCodecById(i3);
        if (codecById == null) {
            TPNativeLog.printLog(1, TAG, "receiveOneFrame failed!");
            return null;
        }
        return codecById.dequeueOutputBuffer();
    }

    @TPMethodCalledByNative
    public static int releaseMediaCodec(int i3) {
        ITPMediaCodecDecoder codecById = getCodecById(i3);
        if (codecById == null) {
            TPNativeLog.printLog(1, TAG, "releaseMediaCodec failed!");
            return 3;
        }
        removeCodecFromList(i3);
        return codecById.release();
    }

    @TPMethodCalledByNative
    public static int releaseVideoFrame(int i3, int i16, boolean z16, long j3) {
        ITPMediaCodecDecoder codecById = getCodecById(i3);
        if (codecById == null) {
            TPNativeLog.printLog(1, TAG, "releaseVideoFrame failed!");
            return 3;
        }
        return codecById.releaseOutputBuffer(i16, z16, j3);
    }

    private static void removeCodecFromList(int i3) {
        synchronized (TPMediaCodecManager.class) {
            mCodecList.remove(i3);
        }
    }

    @TPMethodCalledByNative
    public static int sendOnePacket(int i3, byte[] bArr, boolean z16, long j3, boolean z17) {
        ITPMediaCodecDecoder codecById = getCodecById(i3);
        if (codecById == null) {
            TPNativeLog.printLog(1, TAG, "sendOnePacket failed!");
            return 3;
        }
        return codecById.decode(bArr, z16, j3, z17);
    }

    @TPMethodCalledByNative
    public static void setCryptoInfo(int i3, int i16, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i17, int i18, int i19) {
        ITPMediaCodecDecoder codecById = getCodecById(i3);
        if (codecById == null) {
            TPNativeLog.printLog(1, TAG, "setMediaCodecParamObject failed!");
        } else {
            codecById.setCryptoInfo(i16, iArr, iArr2, bArr, bArr2, i17, i18, i19);
        }
    }

    @TPMethodCalledByNative
    public static int setMediaCodecOperateRate(int i3, float f16) {
        ITPMediaCodecDecoder codecById = getCodecById(i3);
        if (codecById == null) {
            TPNativeLog.printLog(1, TAG, "setMediaCodecOperateRate failed!");
            return 3;
        }
        return codecById.setOperateRate(f16);
    }

    @TPMethodCalledByNative
    public static boolean setMediaCodecParamBool(int i3, int i16, boolean z16) {
        ITPMediaCodecDecoder codecById = getCodecById(i3);
        if (codecById == null) {
            TPNativeLog.printLog(1, TAG, "setMediaCodecParamBool failed!");
            return false;
        }
        return codecById.setParamBool(i16, z16);
    }

    @TPMethodCalledByNative
    public static boolean setMediaCodecParamBytes(int i3, int i16, byte[] bArr) {
        ITPMediaCodecDecoder codecById = getCodecById(i3);
        if (codecById == null) {
            TPNativeLog.printLog(1, TAG, "setMediaCodecParamBytes failed!");
            return false;
        }
        return codecById.setParamBytes(i16, bArr);
    }

    @TPMethodCalledByNative
    public static boolean setMediaCodecParamInt(int i3, int i16, int i17) {
        ITPMediaCodecDecoder codecById = getCodecById(i3);
        if (codecById == null) {
            TPNativeLog.printLog(1, TAG, "setMediaCodecParamInt failed!");
            return false;
        }
        return codecById.setParamInt(i16, i17);
    }

    @TPMethodCalledByNative
    public static boolean setMediaCodecParamLong(int i3, int i16, long j3) {
        ITPMediaCodecDecoder codecById = getCodecById(i3);
        if (codecById == null) {
            TPNativeLog.printLog(1, TAG, "setMediaCodecParamLong failed!");
            return false;
        }
        return codecById.setParamLong(i16, j3);
    }

    @TPMethodCalledByNative
    public static boolean setMediaCodecParamObject(int i3, int i16, Object obj) {
        ITPMediaCodecDecoder codecById = getCodecById(i3);
        if (codecById == null) {
            TPNativeLog.printLog(1, TAG, "setMediaCodecParamObject failed!");
            return false;
        }
        return codecById.setParamObject(i16, obj);
    }

    @TPMethodCalledByNative
    public static boolean setMediaCodecParamString(int i3, int i16, String str) {
        ITPMediaCodecDecoder codecById = getCodecById(i3);
        if (codecById == null) {
            TPNativeLog.printLog(1, TAG, "setMediaCodecParamString failed!");
            return false;
        }
        return codecById.setParamString(i16, str);
    }

    @TPMethodCalledByNative
    public static int setMediaCodecSurface(int i3, Surface surface) {
        ITPMediaCodecDecoder codecById = getCodecById(i3);
        if (codecById == null) {
            TPNativeLog.printLog(1, TAG, "setMediaCodecSurface failed!");
            return 3;
        }
        return codecById.setOutputSurface(surface);
    }

    @TPMethodCalledByNative
    public static int signalEndOfStream(int i3) {
        ITPMediaCodecDecoder codecById = getCodecById(i3);
        if (codecById == null) {
            TPNativeLog.printLog(1, TAG, "signalEndOfStream failed!");
            return 3;
        }
        return codecById.signalEndOfStream();
    }
}
