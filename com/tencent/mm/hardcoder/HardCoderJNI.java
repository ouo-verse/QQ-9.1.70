package com.tencent.mm.hardcoder;

import android.os.Process;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes9.dex */
public class HardCoderJNI {
    public static final long ACTION_ALLOC_MEMORY = 65536;
    public static final long ACTION_ANIMATION = 2;
    public static final long ACTION_DECODE_PIC = 64;
    public static final long ACTION_DECODE_STREAM = 1024;
    public static final long ACTION_DECODE_VIDEO = 256;
    public static final long ACTION_DEXO2OAT = 1;
    public static final long ACTION_ENCODE_PIC = 128;
    public static final long ACTION_ENCODE_STREAM = 2048;
    public static final long ACTION_ENCODE_VIDEO = 512;
    public static final long ACTION_INIT_LISTVIEW = 16;
    public static final long ACTION_NET_RX = 131072;
    public static final long ACTION_NET_TX = 262144;
    public static final long ACTION_ONCREATE = 4;
    public static final long ACTION_ONDESTROY = 8;
    public static final long ACTION_QUERY_SQL = 4096;
    public static final long ACTION_READ_FILE = 16384;
    public static final long ACTION_SCROLL_LISTVIEW = 32;
    public static final long ACTION_WRITE_FILE = 32768;
    public static final long ACTION_WRITE_SQL = 8192;
    public static final int CALLBACK_TYPE_BASE = 0;
    public static final int CALLBACK_TYPE_DATA = 2;
    public static final int CALLBACK_TYPE_STATUS = 1;
    public static final int CLIENT_CONNECT = -20000;
    public static final int CLIENT_DISCONNECT = -20001;
    public static final int CPU_LEVEL_0 = 0;
    public static final int CPU_LEVEL_1 = 1;
    public static final int CPU_LEVEL_2 = 2;
    public static final int CPU_LEVEL_3 = 3;
    public static final boolean DEBUG = false;
    public static final int ERR_CLIENT_ALREADY_INIT = -20002;
    public static final int ERR_UNAUTHORIZED = -10001;
    public static final int FUNC_BASE = 1000;
    public static final int FUNC_CANCEL_CPU_CORE_FOR_THREAD = 1005;
    public static final int FUNC_CANCEL_CPU_HIGH_FREQ = 1003;
    public static final int FUNC_CANCEL_GPU_HIGH_FREQ = 1017;
    public static final int FUNC_CANCEL_HIGH_IO_FREQ = 1007;
    public static final int FUNC_CANCEL_UNIFY_CPU_IO_THREAD_CORE = 1014;
    public static final int FUNC_CHECK_PERMISSION = 1001;
    public static final int FUNC_CONFIGURE = 1018;
    public static final int FUNC_CPU_CORE_FOR_THREAD = 1004;
    public static final int FUNC_CPU_HIGH_FREQ = 1002;
    public static final int FUNC_GPU_HIGH_FREQ = 1016;
    public static final int FUNC_HIGH_IO_FREQ = 1006;
    public static final int FUNC_LOCAL = 0;
    public static final int FUNC_REG_ANR_CALLBACK = 1010;
    public static final int FUNC_REG_PRELOAD_BOOT_RESOURCE = 1011;
    public static final int FUNC_REG_SYSTEM_EVENT_CALLBACK = 1015;
    public static final int FUNC_RESET_SCREEN_RESOLUTION = 1009;
    public static final int FUNC_SET_SCREEN_RESOLUTION = 1008;
    public static final int FUNC_TERMINATE_APP = 1012;
    public static final int FUNC_UNIFY_CPU_IO_THREAD_CORE = 1013;
    public static final int GPU_LEVEL_0 = 0;
    public static final int GPU_LEVEL_1 = 1;
    public static final int IO_LEVEL_0 = 0;
    public static final int IO_LEVEL_1 = 1;
    public static final int IO_LEVEL_2 = 2;
    public static final int IO_LEVEL_3 = 3;
    public static final boolean IS_HCDEBUG;
    public static final int SCENE_ALBUM_SCROLL = 702;
    public static final int SCENE_BOOT = 101;
    public static final int SCENE_CHAT_SCROLL = 704;
    public static final int SCENE_DECODE_PIC = 601;
    public static final int SCENE_ENCODE_VIDEO = 603;
    public static final int SCENE_ENTER_CHATTING = 301;
    public static final int SCENE_GIF = 602;
    public static final int SCENE_MEDIA_GALLERY_SCROLL = 703;
    public static final int SCENE_OPEN_PANEL = 801;
    public static final int SCENE_QUIT_CHATTING = 302;
    public static final int SCENE_RECEIVE_MSG = 201;
    public static final int SCENE_SCENE_DB = 501;
    public static final int SCENE_SEND_MSG = 202;
    public static final int SCENE_SEND_PIC_MSG = 203;
    public static final int SCENE_SNS_SCROLL = 701;
    public static final int SCENE_UPDATE_CHATROOM = 401;
    private static final String TAG = "HardCoder.JNI";
    private static Callback callback;
    public static boolean checkEnv;
    public static boolean hcDebug;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface Callback {
        void onANR(String str);
    }

    static {
        boolean z16 = HardCoderManager.IS_DEBUG;
        IS_HCDEBUG = z16;
        hcDebug = z16;
        checkEnv = true;
    }

    HardCoderJNI() {
    }

    public static native long cancelCpuCoreForThread(int[] iArr, int i3, long j3);

    public static native long cancelCpuHighFreq(int i3, long j3);

    public static native long cancelGpuHighFreq(int i3, long j3);

    public static native long cancelHighIOFreq(int i3, long j3);

    public static native long cancelUnifyCpuIOThreadCoreGpu(boolean z16, boolean z17, boolean z18, boolean z19, int[] iArr, int i3, long j3);

    public static native long checkPermission(String[] strArr, String[] strArr2, int i3, int i16, int i17, long j3);

    public static native long configure(byte[] bArr, int i3, long j3);

    public static native long getParameters(byte[] bArr, int i3, long j3);

    private static native int getTickRate();

    public static native int initHardCoder(String str, int i3, String str2);

    public static native int isRunning();

    public static void onData(int i3, long j3, long j16, int i16, int i17, int i18, byte[] bArr) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onData callbackType:" + i3 + ", requestId:" + j3 + ", timestamp:" + j16 + ", retCode:" + i16 + ", funcId:" + i17 + ", dataType:" + i18);
        }
        if (i3 == 1) {
            if (i17 == 0 && i16 == -20001) {
                HardCoderManager.getInstance().onSocketDisconnect();
                return;
            }
            return;
        }
        if (i3 != 2) {
            onRequestCallback(i3, j3, i16, i17, i18, bArr);
            return;
        }
        if (i17 != 1010 || callback == null) {
            return;
        }
        try {
            str = new String(bArr);
        } catch (Throwable unused) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "onData anr to string failed\u3002 dataType:" + i18);
            }
            str = "";
        }
        callback.onANR(str);
    }

    private static void onRequestCallback(int i3, long j3, int i16, int i17, int i18, byte[] bArr) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onData onRequestCallback:" + i3 + " requestId:" + j3 + " retCode:" + i16 + " funcId:" + i17 + " dataType:" + i18);
        }
    }

    public static native long registerANRCallback(int i3, long j3);

    public static long registerANRCallback(Callback callback2) {
        callback = callback2;
        return registerANRCallback(Process.myTid(), SystemClock.elapsedRealtime());
    }

    public static native long registerBootPreloadResource(String[] strArr, int i3, long j3);

    public static native long registerSystemEventCallback(int i3, long j3);

    public static native long requestCpuCoreForThread(int i3, long j3, int[] iArr, int i16, int i17, long j16);

    public static native long requestCpuHighFreq(int i3, long j3, int i16, int i17, int i18, long j16);

    public static native long requestGpuHighFreq(int i3, long j3, int i16, int i17, int i18, long j16);

    public static native long requestHighIOFreq(int i3, long j3, int i16, int i17, int i18, long j16);

    public static native long requestScreenResolution(int i3, String str, int i16, long j3);

    public static native long requestUnifyCpuIOThreadCoreGpu(int i3, long j3, int i16, int i17, int i18, int[] iArr, int i19, int i26, long j16);

    public static native long resetScreenResolution(int i3, long j3);

    private static native void setDebug(boolean z16);

    private static native void setHCEnable(boolean z16);

    public static native void setRetryConnectInterval(int i3);

    public static int startTraceCpuLoad(int i3) {
        return startTraceCpuLoad(i3, 20);
    }

    public static native int startTraceCpuLoad(int i3, int i16);

    public static native int stopTraceCpuLoad(int i3);

    public static native long terminateApp(int i3, long j3);

    public static void onData(int i3, long j3, int i16, int i17, int i18, byte[] bArr) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onData callbackType:" + i3 + " timestamp:" + j3 + " errCode:" + i16 + " funcid:" + i17 + " dataType:" + i18);
        }
        if (i16 == -20001) {
            HardCoderManager.getInstance().onSocketDisconnect();
        }
        if (callback != null) {
            try {
                str = new String(bArr);
            } catch (Throwable unused) {
                str = "";
            }
            callback.onANR(str);
        }
    }
}
