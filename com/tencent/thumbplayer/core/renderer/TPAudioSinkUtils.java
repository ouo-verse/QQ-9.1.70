package com.tencent.thumbplayer.core.renderer;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import com.tencent.thumbplayer.core.renderer.ITPAudioSink;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes26.dex */
public class TPAudioSinkUtils {
    public static final int INDEX_UNSET = -1;
    public static final int LENGTH_UNSET = -1;
    public static final long MICROS_PER_SECOND = 1000000;
    public static final long TIME_END_OF_SOURCE = Long.MIN_VALUE;
    public static final long TIME_UNSET = -9223372036854775807L;

    public static long ceilDivide(long j3, long j16) {
        return ((j3 + j16) - 1) / j16;
    }

    public static <T> T checkNotNull(@Nullable T t16) {
        t16.getClass();
        return t16;
    }

    public static void checkState(boolean z16) {
        if (z16) {
        } else {
            throw new IllegalStateException();
        }
    }

    public static int constrainValue(int i3, int i16, int i17) {
        return Math.max(i16, Math.min(i3, i17));
    }

    public static Handler createHandler(Looper looper, @Nullable Handler.Callback callback) {
        return new Handler(looper, callback);
    }

    public static Handler createHandlerForCurrentOrMainLooper() {
        return createHandlerForCurrentOrMainLooper(null);
    }

    public static long durationUsToSampleCount(long j3, int i3) {
        return ceilDivide(j3 * i3, 1000000L);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0002. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0015 A[RETURN] */
    @SuppressLint({"InlinedApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getAudioTrackChannelConfig(int i3) {
        switch (i3) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return 204;
            case 5:
                return 220;
            case 6:
                return 252;
            case 7:
                return 1276;
            case 8:
                return 6396;
            case 9:
            case 11:
            default:
                return 0;
            case 10:
                if (Build.VERSION.SDK_INT >= 32) {
                    return 737532;
                }
                break;
            case 12:
                return 743676;
        }
    }

    public static int getBigEndianInt(ByteBuffer byteBuffer, int i3) {
        int i16 = byteBuffer.getInt(i3);
        if (byteBuffer.order() != ByteOrder.BIG_ENDIAN) {
            return Integer.reverseBytes(i16);
        }
        return i16;
    }

    private static int getChannelConfigForPassthrough(int i3) {
        int i16 = Build.VERSION.SDK_INT;
        if (i16 <= 28) {
            if (i3 == 7) {
                i3 = 8;
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                i3 = 6;
            }
        }
        if (i16 <= 26 && "fugu".equals(Build.DEVICE) && i3 == 1) {
            i3 = 2;
        }
        return getAudioTrackChannelConfig(i3);
    }

    public static Looper getCurrentOrMainLooper() {
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            return Looper.getMainLooper();
        }
        return myLooper;
    }

    public static int getEncoding(String str) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals("audio/eac3-joc")) {
                    c16 = 0;
                    break;
                }
                break;
            case -1365340241:
                if (str.equals("audio/vnd.dts.hd;profile=lbr")) {
                    c16 = 1;
                    break;
                }
                break;
            case -1095064472:
                if (str.equals("audio/vnd.dts")) {
                    c16 = 2;
                    break;
                }
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    c16 = 3;
                    break;
                }
                break;
            case 187078297:
                if (str.equals("audio/ac4")) {
                    c16 = 4;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    c16 = 5;
                    break;
                }
                break;
            case 1504831518:
                if (str.equals("audio/mpeg")) {
                    c16 = 6;
                    break;
                }
                break;
            case 1504891608:
                if (str.equals("audio/opus")) {
                    c16 = 7;
                    break;
                }
                break;
            case 1505942594:
                if (str.equals("audio/vnd.dts.hd")) {
                    c16 = '\b';
                    break;
                }
                break;
            case 1556697186:
                if (str.equals("audio/true-hd")) {
                    c16 = '\t';
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return 18;
            case 1:
                return 8;
            case 2:
                return 7;
            case 3:
                return 5;
            case 4:
                return 17;
            case 5:
                return 6;
            case 6:
                return 9;
            case 7:
                return 20;
            case '\b':
                return 8;
            case '\t':
                return 14;
            default:
                return 0;
        }
    }

    @Nullable
    public static Pair<Integer, Integer> getEncodingAndChannelConfigForPassthrough(ITPAudioSink.Format format) {
        int encoding = getEncoding((String) checkNotNull(format.sampleMimeType));
        int channelConfigForPassthrough = getChannelConfigForPassthrough(format.channelCount);
        if (channelConfigForPassthrough == 0) {
            return null;
        }
        return Pair.create(Integer.valueOf(encoding), Integer.valueOf(channelConfigForPassthrough));
    }

    private static int getFrameSizeInSamples(int i3, int i16) {
        if (i16 != 1) {
            if (i16 == 2) {
                return gdt_analysis_event.EVENT_GET_SYSTEM_CHROME_VERSION;
            }
            if (i16 == 3) {
                return MsgConstant.KRMFILETHUMBSIZE384;
            }
            throw new IllegalArgumentException();
        }
        if (i3 == 3) {
            return gdt_analysis_event.EVENT_GET_SYSTEM_CHROME_VERSION;
        }
        return PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT;
    }

    public static int getFramesPerEncodedSample(int i3, ByteBuffer byteBuffer) {
        switch (i3) {
            case 5:
            case 6:
            case 18:
                return parseAc3SyncframeAudioSampleCount(byteBuffer);
            case 7:
            case 8:
                return parseDtsAudioSampleCount(byteBuffer);
            case 9:
                int parseMpegAudioFrameSampleCount = parseMpegAudioFrameSampleCount(getBigEndianInt(byteBuffer, byteBuffer.position()));
                if (parseMpegAudioFrameSampleCount != -1) {
                    return parseMpegAudioFrameSampleCount;
                }
                throw new IllegalArgumentException();
            case 10:
            case 16:
                return 1024;
            case 11:
            case 12:
                return 2048;
            case 13:
            case 14:
            case 17:
            default:
                throw new IllegalStateException("Unexpected audio encoding: " + i3);
            case 15:
                return 512;
        }
    }

    public static long getMediaDurationForPlayoutDuration(long j3, float f16) {
        if (f16 == 1.0f) {
            return j3;
        }
        return Math.round(j3 * f16);
    }

    public static int getPcmFrameSize(int i3, int i16) {
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4 && i3 != 22) {
                    throw new IllegalArgumentException();
                }
                return i16 * 4;
            }
            return i16;
        }
        return i16 * 2;
    }

    public static long getPlayoutDurationForMediaDuration(long j3, float f16) {
        if (f16 == 1.0f) {
            return j3;
        }
        return Math.round(j3 / f16);
    }

    public static boolean isAutomotive(Context context) {
        if (context.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) {
            return true;
        }
        return false;
    }

    public static boolean isEncodingLinearPcm(int i3) {
        if (i3 != 3 && i3 != 2 && i3 != 22 && i3 != 4) {
            return false;
        }
        return true;
    }

    private static boolean isMagicPresent(int i3) {
        if ((i3 & (-2097152)) == -2097152) {
            return true;
        }
        return false;
    }

    public static boolean isTv(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        if (uiModeManager != null && uiModeManager.getCurrentModeType() == 4) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Thread lambda$newSingleThreadExecutor$0(String str, Runnable runnable) {
        return new BaseThread(runnable, str);
    }

    public static ExecutorService newSingleThreadExecutor(final String str) {
        return ProxyExecutors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.tencent.thumbplayer.core.renderer.d
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread lambda$newSingleThreadExecutor$0;
                lambda$newSingleThreadExecutor$0 = TPAudioSinkUtils.lambda$newSingleThreadExecutor$0(str, runnable);
                return lambda$newSingleThreadExecutor$0;
            }
        });
    }

    public static int parseAc3SyncframeAudioSampleCount(ByteBuffer byteBuffer) {
        boolean z16;
        int[] iArr = {1, 2, 3, 6};
        int i3 = 3;
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
                i3 = (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4;
            }
            return iArr[i3] * 256;
        }
        return 1536;
    }

    public static int parseDtsAudioSampleCount(ByteBuffer byteBuffer) {
        int i3;
        byte b16;
        int i16;
        byte b17;
        if (byteBuffer.getInt(0) != -233094848 && byteBuffer.getInt(0) != -398277519) {
            if (byteBuffer.getInt(0) == 622876772) {
                return 4096;
            }
            int position = byteBuffer.position();
            byte b18 = byteBuffer.get(position);
            if (b18 != -2) {
                if (b18 != -1) {
                    if (b18 != 31) {
                        i3 = (byteBuffer.get(position + 4) & 1) << 6;
                        b16 = byteBuffer.get(position + 5);
                    } else {
                        i3 = (byteBuffer.get(position + 5) & 7) << 4;
                        b17 = byteBuffer.get(position + 6);
                    }
                } else {
                    i3 = (byteBuffer.get(position + 4) & 7) << 4;
                    b17 = byteBuffer.get(position + 7);
                }
                i16 = b17 & 60;
                return (((i16 >> 2) | i3) + 1) * 32;
            }
            i3 = (byteBuffer.get(position + 5) & 1) << 6;
            b16 = byteBuffer.get(position + 4);
            i16 = b16 & 252;
            return (((i16 >> 2) | i3) + 1) * 32;
        }
        return 1024;
    }

    public static int parseMpegAudioFrameSampleCount(int i3) {
        int i16;
        int i17;
        if (!isMagicPresent(i3) || (i16 = (i3 >>> 19) & 3) == 1 || (i17 = (i3 >>> 17) & 3) == 0) {
            return -1;
        }
        int i18 = (i3 >>> 12) & 15;
        int i19 = (i3 >>> 10) & 3;
        if (i18 == 0 || i18 == 15 || i19 == 3) {
            return -1;
        }
        return getFrameSizeInSamples(i16, i17);
    }

    public static long sampleCountToDurationUs(long j3, int i3) {
        return (j3 * 1000000) / i3;
    }

    public static long usToMs(long j3) {
        if (j3 != -9223372036854775807L && j3 != Long.MIN_VALUE) {
            return j3 / 1000;
        }
        return j3;
    }

    public static Handler createHandlerForCurrentOrMainLooper(@Nullable Handler.Callback callback) {
        return createHandler(getCurrentOrMainLooper(), callback);
    }
}
