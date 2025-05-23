package com.tencent.biz.qqstory.utils;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* compiled from: P */
@TargetApi(16)
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private int f94452a;

    /* renamed from: b, reason: collision with root package name */
    private ByteOrder f94453b = ByteOrder.nativeOrder();

    public static void a(String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("ExtractPCMFromFile", 2, "==gli== createSilentPCMFile duration = " + i3);
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                try {
                    byte[] bArr = new byte[88];
                    for (int i16 = 0; i16 < 88; i16++) {
                        bArr[i16] = -1;
                    }
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str));
                    for (long j3 = 0; j3 < i3; j3++) {
                        try {
                            bufferedOutputStream2.write(bArr);
                        } catch (Exception e16) {
                            e = e16;
                            bufferedOutputStream = bufferedOutputStream2;
                            QLog.e("ExtractPCMFromFile", 1, e.toString());
                            if (bufferedOutputStream != null) {
                                bufferedOutputStream.close();
                            }
                            return;
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedOutputStream = bufferedOutputStream2;
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException e17) {
                                    e17.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                    int i17 = 88 * i3;
                    int i18 = ((((int) (i3 * 0.2f)) / 2) * 2) + i17;
                    int i19 = (i18 + (2048 - (i18 % 2048))) - i17;
                    if (i19 > 0) {
                        for (int i26 = 0; i26 < i19; i26++) {
                            bufferedOutputStream2.write(-1);
                        }
                    }
                    bufferedOutputStream2.flush();
                    bufferedOutputStream2.close();
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e18) {
                e = e18;
            }
        } catch (IOException e19) {
            e19.printStackTrace();
        }
    }

    public static void b(MediaFormat mediaFormat) {
        int integer = mediaFormat.getInteger("max-input-size");
        if (integer <= 0 || integer > 134217728) {
            QLog.e("ExtractPCMFromFile", 1, "fixACodec22885421: ", new Exception("max-input-size overflow ! " + integer + " > 134217728"));
            mediaFormat.setInteger("max-input-size", 134217728);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0194  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean e(LocalMediaInfo localMediaInfo, int i3, int i16, String str, SlideItemInfo slideItemInfo) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        long j3;
        ByteBuffer allocate;
        int i17;
        long j16;
        int i18;
        int i19;
        MediaExtractor mediaExtractor = new MediaExtractor();
        File file = new File(localMediaInfo.path);
        try {
            mediaExtractor.setDataSource(localMediaInfo.path);
            int trackCount = mediaExtractor.getTrackCount();
            BufferedOutputStream bufferedOutputStream2 = null;
            MediaFormat mediaFormat = null;
            int i26 = 0;
            while (true) {
                if (i26 >= trackCount) {
                    break;
                }
                mediaFormat = mediaExtractor.getTrackFormat(i26);
                if (mediaFormat.getString("mime").startsWith("audio/")) {
                    mediaExtractor.selectTrack(i26);
                    break;
                }
                i26++;
            }
            if (i26 != trackCount && mediaFormat != null) {
                b(mediaFormat);
                if (i3 > 0) {
                    mediaExtractor.seekTo(i3 * 1000, 2);
                }
                long j17 = mediaFormat.getLong("durationUs");
                float f16 = i16 / ((float) localMediaInfo.mDuration);
                if (f16 == 0.0f || f16 > 1.0f) {
                    f16 = 1.0f;
                }
                long j18 = f16 * ((float) j17);
                if (j18 != 0) {
                    j17 = j18;
                }
                int a16 = a.a(mediaFormat, localMediaInfo.path);
                int b16 = a.b(mediaFormat);
                this.f94452a = b16;
                slideItemInfo.I = b16;
                MediaCodec createDecoderByType = MediaCodec.createDecoderByType(mediaFormat.getString("mime"));
                createDecoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 0);
                createDecoderByType.start();
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                try {
                    try {
                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (IOException e16) {
                    e16.printStackTrace();
                } catch (StackOverflowError e17) {
                    QLog.d("ExtractPCMFromFile", 1, "", e17);
                }
                try {
                    ByteBuffer order = ByteBuffer.allocate(2).order(this.f94453b);
                    ShortBuffer asShortBuffer = order.asShortBuffer();
                    ByteBuffer byteBuffer = null;
                    boolean z16 = false;
                    while (true) {
                        int dequeueInputBuffer = createDecoderByType.dequeueInputBuffer(60000L);
                        if (dequeueInputBuffer >= 0) {
                            ByteBuffer byteBuffer2 = createDecoderByType.getInputBuffers()[dequeueInputBuffer];
                            byteBuffer2.clear();
                            int readSampleData = mediaExtractor.readSampleData(byteBuffer2, 0);
                            long sampleTime = mediaExtractor.getSampleTime();
                            if (readSampleData >= 0 && (j17 <= 0 || sampleTime < j17)) {
                                i19 = readSampleData;
                                j16 = sampleTime;
                                i18 = 0;
                                createDecoderByType.queueInputBuffer(dequeueInputBuffer, 0, i19, j16, i18);
                                mediaExtractor.advance();
                            }
                            j16 = -1;
                            i18 = 4;
                            i19 = 0;
                            createDecoderByType.queueInputBuffer(dequeueInputBuffer, 0, i19, j16, i18);
                            mediaExtractor.advance();
                        } else if (QLog.isColorLevel()) {
                            QLog.d("ExtractPCMFromFile", 2, "readFile() called with: inputBufferIndex = [" + dequeueInputBuffer + "]");
                        }
                        int dequeueOutputBuffer = createDecoderByType.dequeueOutputBuffer(bufferInfo, 60000L);
                        if (dequeueOutputBuffer >= 0) {
                            int i27 = bufferInfo.size;
                            if (i27 > 0) {
                                if (byteBuffer == null) {
                                    allocate = ByteBuffer.allocate(i27);
                                } else {
                                    int capacity = byteBuffer.capacity();
                                    int i28 = bufferInfo.size;
                                    if (capacity < i28) {
                                        allocate = ByteBuffer.allocate(i28);
                                    }
                                    byteBuffer.rewind();
                                    j3 = j17;
                                    createDecoderByType.getOutputBuffers()[dequeueOutputBuffer].get(byteBuffer.array(), 0, bufferInfo.size);
                                    ShortBuffer asShortBuffer2 = byteBuffer.order(this.f94453b).asShortBuffer();
                                    for (i17 = 0; i17 < bufferInfo.size; i17 += a16 * 2) {
                                        int i29 = 0;
                                        for (int i36 = 0; i36 < a16; i36++) {
                                            i29 += asShortBuffer2.get();
                                        }
                                        asShortBuffer.rewind();
                                        asShortBuffer.put((short) (i29 / a16));
                                        asShortBuffer.rewind();
                                        bufferedOutputStream.write(order.array());
                                    }
                                    if ((bufferInfo.flags & 4) != 0) {
                                    }
                                    createDecoderByType.getOutputBuffers()[dequeueOutputBuffer].clear();
                                    createDecoderByType.releaseOutputBuffer(dequeueOutputBuffer, false);
                                }
                                byteBuffer = allocate;
                                byteBuffer.rewind();
                                j3 = j17;
                                createDecoderByType.getOutputBuffers()[dequeueOutputBuffer].get(byteBuffer.array(), 0, bufferInfo.size);
                                ShortBuffer asShortBuffer22 = byteBuffer.order(this.f94453b).asShortBuffer();
                                while (i17 < bufferInfo.size) {
                                }
                                if ((bufferInfo.flags & 4) != 0) {
                                }
                                createDecoderByType.getOutputBuffers()[dequeueOutputBuffer].clear();
                                createDecoderByType.releaseOutputBuffer(dequeueOutputBuffer, false);
                            } else {
                                j3 = j17;
                                QLog.e("ExtractPCMFromFile", 2, "readFile  : outputBufferIndex < 0");
                            }
                            z16 = true;
                            createDecoderByType.getOutputBuffers()[dequeueOutputBuffer].clear();
                            createDecoderByType.releaseOutputBuffer(dequeueOutputBuffer, false);
                        } else {
                            j3 = j17;
                        }
                        if (z16) {
                            mediaExtractor.release();
                            createDecoderByType.stop();
                            createDecoderByType.release();
                            bufferedOutputStream.close();
                            return true;
                        }
                        j17 = j3;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    bufferedOutputStream2 = bufferedOutputStream;
                    try {
                        QLog.e("ExtractPCMFromFile", 2, th.toString());
                        mediaExtractor.release();
                        createDecoderByType.stop();
                        createDecoderByType.release();
                        if (bufferedOutputStream2 != null) {
                            bufferedOutputStream2.close();
                        }
                        return false;
                    } catch (Throwable th7) {
                        mediaExtractor.release();
                        createDecoderByType.stop();
                        createDecoderByType.release();
                        if (bufferedOutputStream2 != null) {
                            try {
                                bufferedOutputStream2.close();
                                throw th7;
                            } catch (IOException e18) {
                                e18.printStackTrace();
                                throw th7;
                            } catch (StackOverflowError e19) {
                                QLog.d("ExtractPCMFromFile", 1, "", e19);
                                throw th7;
                            }
                        }
                        throw th7;
                    }
                }
            } else {
                QLog.w("ExtractPCMFromFile", 1, "No audio track found in " + file);
                mediaExtractor.release();
                slideItemInfo.H = false;
                return false;
            }
        } catch (IOException e26) {
            QLog.w("ExtractPCMFromFile", 1, "readFile setDataSource exception: " + file, e26);
            mediaExtractor.release();
            slideItemInfo.H = false;
            return false;
        }
    }

    private void f(String str, SlideItemInfo slideItemInfo) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        File file = new File(str);
        try {
            mediaExtractor.setDataSource(str);
            int trackCount = mediaExtractor.getTrackCount();
            MediaFormat mediaFormat = null;
            int i3 = 0;
            while (true) {
                if (i3 >= trackCount) {
                    break;
                }
                mediaFormat = mediaExtractor.getTrackFormat(i3);
                if (mediaFormat.getString("mime").startsWith("audio/")) {
                    mediaExtractor.selectTrack(i3);
                    break;
                }
                i3++;
            }
            if (i3 != trackCount && mediaFormat != null) {
                mediaFormat.getInteger("channel-count");
                int b16 = a.b(mediaFormat);
                this.f94452a = b16;
                slideItemInfo.I = b16;
                mediaExtractor.release();
                return;
            }
            QLog.w("ExtractPCMFromFile", 1, "No audio track found in " + file);
            mediaExtractor.release();
            slideItemInfo.H = false;
        } catch (IOException e16) {
            QLog.w("ExtractPCMFromFile", 1, "setDataSource exception: " + file, e16);
            mediaExtractor.release();
            slideItemInfo.H = false;
        }
    }

    public void c(String str, SlideItemInfo slideItemInfo) {
        try {
            slideItemInfo.H = true;
            f(str, slideItemInfo);
        } catch (IOException unused) {
            QLog.e("ExtractPCMFromFile", 2, "Exception : getMetaDataFromFile ERROR");
        }
    }

    public boolean d(LocalMediaInfo localMediaInfo, int i3, int i16, String str, SlideItemInfo slideItemInfo) {
        try {
            slideItemInfo.H = true;
            return e(localMediaInfo, i3, i16, str, slideItemInfo);
        } catch (IOException unused) {
            QLog.e("ExtractPCMFromFile", 2, "Exception : getPCMFromFile ERROR");
            return false;
        }
    }
}
