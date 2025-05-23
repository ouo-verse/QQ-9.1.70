package com.tencent.weclip.weyamnet;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes27.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static void a(String str, b bVar) {
        int i3;
        int i16;
        float[] fArr;
        int i17;
        MediaExtractor mediaExtractor = new MediaExtractor();
        int i18 = 1;
        try {
            mediaExtractor.setDataSource(str);
            int b16 = b(mediaExtractor);
            if (b16 < 0) {
                QLog.e("WEYamnetAudio", 1, "No audio track found in " + str);
                bVar.b(-1);
                return;
            }
            mediaExtractor.selectTrack(b16);
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(b16);
            long currentTimeMillis = System.currentTimeMillis();
            String string = trackFormat.getString("mime");
            if (string == null) {
                QLog.e("WEYamnetAudio", 1, "mime is null " + str);
                bVar.b(-1);
                return;
            }
            MediaCodec createDecoderByType = MediaCodec.createDecoderByType(string);
            int i19 = 0;
            createDecoderByType.configure(trackFormat, (Surface) null, (MediaCrypto) null, 0);
            createDecoderByType.start();
            long currentTimeMillis2 = System.currentTimeMillis();
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int i26 = 16000;
            float[] fArr2 = new float[16000];
            QLog.i("WEYamnetAudio", 1, "createDecoder cost\uff1a" + (currentTimeMillis2 - currentTimeMillis));
            int i27 = 0;
            int i28 = 0;
            boolean z16 = false;
            int i29 = 0;
            while (i28 == 0 && !z16) {
                int dequeueInputBuffer = createDecoderByType.dequeueInputBuffer(100L);
                if (dequeueInputBuffer >= 0) {
                    ByteBuffer inputBuffer = createDecoderByType.getInputBuffer(dequeueInputBuffer);
                    if (inputBuffer != null) {
                        int readSampleData = mediaExtractor.readSampleData(inputBuffer, i19);
                        if (readSampleData < 0) {
                            i16 = i27;
                            fArr = fArr2;
                            try {
                                createDecoderByType.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                                i28 = i18;
                            } catch (Exception e16) {
                                e = e16;
                                i3 = -1;
                                bVar.b(i3);
                                QLog.e("WEYamnetAudio", 1, "Error extracting and processing audio: ", e);
                                return;
                            }
                        } else {
                            i16 = i27;
                            fArr = fArr2;
                            createDecoderByType.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, mediaExtractor.getSampleTime(), 0);
                            mediaExtractor.advance();
                        }
                    }
                } else {
                    i16 = i27;
                    fArr = fArr2;
                }
                int dequeueOutputBuffer = createDecoderByType.dequeueOutputBuffer(bufferInfo, 10L);
                i27 = i16;
                while (true) {
                    if (dequeueOutputBuffer >= 0) {
                        ByteBuffer outputBuffer = createDecoderByType.getOutputBuffer(dequeueOutputBuffer);
                        if (outputBuffer != null) {
                            outputBuffer.position(bufferInfo.offset);
                            outputBuffer.limit(bufferInfo.offset + bufferInfo.size);
                            ByteBuffer allocate = ByteBuffer.allocate(bufferInfo.size);
                            allocate.put(outputBuffer);
                            allocate.flip();
                            allocate.order(ByteOrder.LITTLE_ENDIAN);
                            int i36 = bufferInfo.size / 2;
                            int max = Math.max(i18, i36 / 16000);
                            int i37 = i29;
                            int i38 = 0;
                            while (true) {
                                if (i38 >= i36) {
                                    break;
                                }
                                if (i37 < i26) {
                                    allocate.position(i38 * 2);
                                    fArr[i37] = allocate.getShort() / 32768.0f;
                                    i37++;
                                } else {
                                    i27++;
                                    boolean a16 = bVar.a(fArr, i27);
                                    if (a16) {
                                        z16 = a16;
                                        break;
                                    } else {
                                        z16 = a16;
                                        i37 = 0;
                                    }
                                }
                                i38 += max;
                                i26 = 16000;
                            }
                            i17 = 0;
                            createDecoderByType.releaseOutputBuffer(dequeueOutputBuffer, false);
                            if (z16) {
                                i29 = i37;
                                break;
                            }
                            dequeueOutputBuffer = createDecoderByType.dequeueOutputBuffer(bufferInfo, 10L);
                            i29 = i37;
                            i18 = 1;
                            i26 = 16000;
                        }
                    } else {
                        i17 = 0;
                        break;
                    }
                }
                fArr2 = fArr;
                i18 = 1;
                i26 = 16000;
                i19 = i17;
            }
            int i39 = i27;
            createDecoderByType.stop();
            createDecoderByType.release();
            mediaExtractor.release();
            if (!z16) {
                bVar.b(i39);
            }
        } catch (Exception e17) {
            e = e17;
            i3 = -1;
        }
    }

    private static int b(MediaExtractor mediaExtractor) {
        for (int i3 = 0; i3 < mediaExtractor.getTrackCount(); i3++) {
            String string = mediaExtractor.getTrackFormat(i3).getString("mime");
            if (string != null && string.startsWith("audio/")) {
                return i3;
            }
        }
        return -1;
    }
}
