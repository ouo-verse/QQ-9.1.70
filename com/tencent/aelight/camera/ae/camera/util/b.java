package com.tencent.aelight.camera.ae.camera.util;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaMuxer;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b {
    @Nullable
    public static String a(String str, String str2, String str3) {
        try {
            new File(str3).createNewFile();
            MediaExtractor mediaExtractor = new MediaExtractor();
            mediaExtractor.setDataSource(str2);
            MediaExtractor mediaExtractor2 = new MediaExtractor();
            mediaExtractor2.setDataSource(str);
            MediaMuxer mediaMuxer = new MediaMuxer(str3, 0);
            mediaExtractor.selectTrack(0);
            int addTrack = mediaMuxer.addTrack(mediaExtractor.getTrackFormat(0));
            mediaExtractor2.selectTrack(0);
            int addTrack2 = mediaMuxer.addTrack(mediaExtractor2.getTrackFormat(0));
            ByteBuffer allocate = ByteBuffer.allocate(1048576);
            ByteBuffer allocate2 = ByteBuffer.allocate(1048576);
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
            mediaExtractor.seekTo(0L, 2);
            mediaExtractor2.seekTo(0L, 2);
            mediaMuxer.start();
            boolean z16 = false;
            while (!z16) {
                bufferInfo.offset = 0;
                int readSampleData = mediaExtractor.readSampleData(allocate, 0);
                bufferInfo.size = readSampleData;
                if (readSampleData >= 0 && bufferInfo2.size >= 0) {
                    bufferInfo.presentationTimeUs = mediaExtractor.getSampleTime();
                    bufferInfo.flags = mediaExtractor.getSampleFlags();
                    mediaMuxer.writeSampleData(addTrack, allocate, bufferInfo);
                    mediaExtractor.advance();
                }
                bufferInfo.size = 0;
                z16 = true;
            }
            boolean z17 = false;
            while (!z17) {
                bufferInfo2.offset = 0;
                int readSampleData2 = mediaExtractor2.readSampleData(allocate2, 0);
                bufferInfo2.size = readSampleData2;
                if (bufferInfo.size >= 0 && readSampleData2 >= 0) {
                    bufferInfo2.presentationTimeUs = mediaExtractor2.getSampleTime();
                    bufferInfo2.flags = mediaExtractor2.getSampleFlags();
                    mediaMuxer.writeSampleData(addTrack2, allocate2, bufferInfo2);
                    mediaExtractor2.advance();
                }
                bufferInfo2.size = 0;
                z17 = true;
            }
            mediaMuxer.stop();
            mediaMuxer.release();
            mediaExtractor2.release();
            mediaExtractor.release();
            return str3;
        } catch (IOException e16) {
            ms.a.d("AEVoiceVideoMergeUtil", "Mixer Error 1 " + e16.toString(), e16);
            return null;
        } catch (Exception e17) {
            ms.a.d("AEVoiceVideoMergeUtil", "Mixer Error 2 " + e17.toString(), e17);
            return null;
        }
    }
}
