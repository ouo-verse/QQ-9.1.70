package com.tencent.biz.qqstory.utils;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import com.tencent.mobileqq.qqlive.api.common.RTCAudioDefine;
import com.tencent.mobileqq.shortvideo.util.AudioResample;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;

/* compiled from: P */
@TargetApi(16)
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f94451a = {96000, 88200, 64000, 48000, 44100, 32000, RTCAudioDefine.RTC_AUDIO_SAMPLE_RATE_24000, 22050, 16000, 12000, 11025, 8000, 7350, 0, 0, 0};

    public static int a(MediaFormat mediaFormat, String str) {
        int i3;
        if (mediaFormat == null) {
            return -1;
        }
        int integer = mediaFormat.getInteger("channel-count");
        try {
            i3 = AudioResample.parseMp4Info(str);
        } catch (UnsatisfiedLinkError unused) {
            i3 = -2000;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SegmentClipUtils", 2, "getRealAudioChannel:  channels=" + i3 + " channelsBake: " + integer);
        }
        if (i3 > 0) {
            return i3;
        }
        return integer;
    }

    public static int b(MediaFormat mediaFormat) {
        if (mediaFormat == null) {
            return -1;
        }
        ByteBuffer byteBuffer = mediaFormat.getByteBuffer("csd-0");
        if (byteBuffer.remaining() <= 2) {
            return mediaFormat.getInteger("sample-rate");
        }
        int remaining = byteBuffer.remaining();
        int position = byteBuffer.position();
        byte[] bArr = new byte[remaining];
        byteBuffer.get(bArr);
        byteBuffer.position(position);
        byteBuffer.limit(position + remaining);
        int i3 = (remaining - 2) * 8;
        if (i3 > 11) {
            byte b16 = bArr[2];
            byte b17 = bArr[3];
            if ((((b16 & 255) << 3) | ((b17 & 255) >>> 5)) == 695) {
                if ((b17 & 31) == 5 && i3 - 16 > 0) {
                    byte b18 = bArr[4];
                    if (((b18 & 255) >>> 7) == 1) {
                        int i16 = (b18 & Byte.MAX_VALUE) >>> 3;
                        if (i16 < 13) {
                            return f94451a[i16];
                        }
                        return mediaFormat.getInteger("sample-rate");
                    }
                }
            } else {
                if (((b16 & 255) | ((bArr[1] & 7) << 8)) == 520) {
                    return f94451a[4];
                }
            }
        }
        return mediaFormat.getInteger("sample-rate");
    }
}
