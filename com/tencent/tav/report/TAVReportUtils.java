package com.tencent.tav.report;

import android.media.MediaCodec;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVReportUtils {
    public static String toString(MediaCodec.BufferInfo bufferInfo) {
        if (bufferInfo == null) {
            return "null";
        }
        return "BufferInfo{offset=" + bufferInfo.offset + ", size=" + bufferInfo.size + ", presentationTimeUs=" + bufferInfo.presentationTimeUs + ", flags=" + bufferInfo.flags + '}';
    }
}
