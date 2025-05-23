package com.tencent.avcore.jni.codec;

import android.annotation.SuppressLint;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: P */
@RequiresApi(api = 16)
/* loaded from: classes3.dex */
public abstract class AndroidCodecBase implements MediaCodecConstants {
    static IPatchRedirector $redirector_ = null;
    private static final int TIMEOUT_GET_CODEC_INFO_CODEC_MS = 1000;
    public static boolean isCallFuncTimeout;
    private static AndroidCodecStatus mAndroidCodecBaseStatus;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14192);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            isCallFuncTimeout = false;
            mAndroidCodecBaseStatus = AndroidCodecStatus.OK;
        }
    }

    public AndroidCodecBase() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static AndroidCodecStatus callGetCodecCountStatus() {
        return mAndroidCodecBaseStatus;
    }

    public static MediaCodecInfo.CodecCapabilities getCodecCapabilities(MediaCodecInfo mediaCodecInfo, String str) {
        try {
            return mediaCodecInfo.getCapabilitiesForType(str);
        } catch (Exception e16) {
            if (AVCoreLog.isDevelopLevel()) {
                AVCoreLog.e("AndroidCodec", "getCodecCapabilities, Exception, mime[" + str + "]", e16);
            }
            mAndroidCodecBaseStatus = AndroidCodecStatus.ErrorGetCapabilityesForType;
            return null;
        }
    }

    private static int getCodecCountTimeOut(long j3) {
        int i3;
        if (j3 <= 0 || j3 >= 1000) {
            j3 = 1000;
        }
        Callable<Integer> callable = new Callable<Integer>() { // from class: com.tencent.avcore.jni.codec.AndroidCodecBase.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? Integer.valueOf(MediaCodecList.getCodecCount()) : (Integer) iPatchRedirector.redirect((short) 2, (Object) this);
            }
        };
        ExecutorService newSingleThreadExecutor = ProxyExecutors.newSingleThreadExecutor();
        Future submit = newSingleThreadExecutor.submit(callable);
        try {
            i3 = ((Integer) submit.get(j3, TimeUnit.MILLISECONDS)).intValue();
        } catch (TimeoutException unused) {
            AVCoreLog.e("AndroidCodec", "getCodecCount timeout");
            mAndroidCodecBaseStatus = AndroidCodecStatus.ErrorGetCodecInfoTimeOut;
            submit.cancel(true);
            i3 = 0;
            newSingleThreadExecutor.shutdown();
            return i3;
        } catch (Exception e16) {
            e16.printStackTrace();
            mAndroidCodecBaseStatus = AndroidCodecStatus.ErrorGetCodecInfoException;
            i3 = 0;
            newSingleThreadExecutor.shutdown();
            return i3;
        }
        newSingleThreadExecutor.shutdown();
        return i3;
    }

    public static MediaCodecInfo getCodecInfo(String str) {
        int codecCount;
        mAndroidCodecBaseStatus = AndroidCodecStatus.OK;
        try {
            if (isCallFuncTimeout) {
                codecCount = getCodecCountTimeOut(1000L);
            } else {
                codecCount = MediaCodecList.getCodecCount();
            }
            for (int i3 = 0; i3 < codecCount; i3++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i3);
                if (codecInfoAt.getName().equalsIgnoreCase(str)) {
                    return codecInfoAt;
                }
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @SuppressLint({"NewApi"})
    public static List<MediaCodecInfo> getDecoderInfos(String str) {
        int codecCount;
        ArrayList arrayList = new ArrayList();
        mAndroidCodecBaseStatus = AndroidCodecStatus.OK;
        try {
            if (isCallFuncTimeout) {
                codecCount = getCodecCountTimeOut(1000L);
            } else {
                codecCount = MediaCodecList.getCodecCount();
            }
            for (int i3 = 0; i3 < codecCount; i3++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i3);
                if (!codecInfoAt.isEncoder() && !codecInfoAt.getName().contains(".sw.") && !codecInfoAt.getName().contains(".SW.") && !codecInfoAt.getName().contains("google") && !codecInfoAt.getName().contains("Google") && !codecInfoAt.getName().contains("GOOGLE")) {
                    for (String str2 : codecInfoAt.getSupportedTypes()) {
                        if (str2.equalsIgnoreCase(str)) {
                            arrayList.add(codecInfoAt);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public static List<MediaCodecInfo> getEndoderInfos(String str) {
        int codecCount;
        ArrayList arrayList = new ArrayList();
        mAndroidCodecBaseStatus = AndroidCodecStatus.OK;
        try {
            if (isCallFuncTimeout) {
                codecCount = getCodecCountTimeOut(1000L);
            } else {
                codecCount = MediaCodecList.getCodecCount();
            }
            for (int i3 = 0; i3 < codecCount; i3++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i3);
                if (codecInfoAt.isEncoder() && !codecInfoAt.getName().contains(".sw.") && !codecInfoAt.getName().contains(".SW.") && !codecInfoAt.getName().contains("google") && !codecInfoAt.getName().contains("Google") && !codecInfoAt.getName().contains("GOOGLE")) {
                    for (String str2 : codecInfoAt.getSupportedTypes()) {
                        if (str2.equalsIgnoreCase(str)) {
                            arrayList.add(codecInfoAt);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public abstract boolean checkCallHwCodecFuncTimeOut();

    public abstract BufferData dequeueDecoderOutputBuffer(long j3);

    public abstract BufferData dequeueOutputBuffer();

    public abstract void flush();

    public abstract AndroidCodecStatus getAndroidCodecStatus();

    public abstract BufferData getInputBuffer();

    public abstract ByteBuffer getInputBuffer(int i3);

    public abstract ByteBuffer getOutputBuffer(int i3);

    public abstract MediaFormat getOutputFormat(int i3);

    public abstract boolean init(String str, MediaFormat mediaFormat, int i3, IMediaCodecCallback iMediaCodecCallback);

    public abstract boolean init(String str, MediaFormat mediaFormat, String str2, Surface surface, IMediaCodecCallback iMediaCodecCallback);

    public abstract boolean init(String str, MediaFormat mediaFormat, String str2, boolean z16, IMediaCodecCallback iMediaCodecCallback);

    public abstract void queueInputBuffer(int i3, int i16, long j3, int i17);

    public abstract void release();

    public abstract void releaseOutputBuffer(int i3);

    public abstract void reset();

    public abstract void setParameters(Bundle bundle);

    public abstract boolean start();

    public abstract void stop();
}
