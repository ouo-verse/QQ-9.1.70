package com.tencent.mobileqq.filter.music;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.view.Surface;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.FileReaderHelper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
@SuppressLint({"NewApi"})
/* loaded from: classes12.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private InterfaceC7597a f209769a;

    /* renamed from: b, reason: collision with root package name */
    private int f209770b;

    /* renamed from: c, reason: collision with root package name */
    private int f209771c;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<Float> f209772d;

    /* renamed from: e, reason: collision with root package name */
    private int f209773e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f209774f;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filter.music.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public interface InterfaceC7597a {
        boolean a(double d16);
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f209769a = null;
        this.f209773e = 1024;
        this.f209774f = false;
        this.f209771c = 0;
        this.f209772d = new ArrayList<>();
    }

    public static String[] d() {
        return new String[]{FileReaderHelper.MP3_EXT, FileReaderHelper.WAV_EXT, "3gpp", "3gp", "amr", FileReaderHelper.AAC_EXT, FileReaderHelper.M4A_EXT, "ogg"};
    }

    public static boolean e() {
        CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_MEIZU.equals(Build.MANUFACTURER);
        return false;
    }

    private int f(int i3) {
        return (int) ((((i3 * 1.0d) * this.f209770b) / (c() * 1000.0d)) + 0.5d);
    }

    /* JADX WARN: Code restructure failed: missing block: B:122:0x0341, code lost:
    
        r0 = r12.position();
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0350, code lost:
    
        if ((r0 - r32.f209771c) <= ((c() * 2) * r4)) goto L295;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0352, code lost:
    
        r12.position(r32.f209771c);
        r12.order(java.nio.ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(r8);
        r12.position(r0);
        r32.f209771c += (c() * 2) * r4;
        r2 = r15;
        r3 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0377, code lost:
    
        if (r2 >= (r25 / r4)) goto L296;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0379, code lost:
    
        r5 = r15;
        r6 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x037b, code lost:
    
        if (r5 >= r4) goto L299;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x037d, code lost:
    
        r6 = r6 + java.lang.Math.abs((int) r8[(r2 * r4) + r5]);
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x038a, code lost:
    
        r6 = r6 / r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x038b, code lost:
    
        if (r3 >= r6) goto L298;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x038d, code lost:
    
        r3 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x038e, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0391, code lost:
    
        r2 = (int) java.lang.Math.sqrt(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0398, code lost:
    
        monitor-enter(r32);
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x039b, code lost:
    
        if (r20 >= 0.0f) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x03a0, code lost:
    
        if (r19 >= 0.0f) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x03b1, code lost:
    
        r32.f209772d.add(java.lang.Float.valueOf(((r19 + r20) + r2) / 3.0f));
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x03c2, code lost:
    
        r19 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x03a2, code lost:
    
        r32.f209772d.add(java.lang.Float.valueOf((r20 + r2) / 2.0f));
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x03c4, code lost:
    
        monitor-exit(r32);
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x03c5, code lost:
    
        r20 = r2;
        r21 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x03ce, code lost:
    
        r2 = r32.f209771c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x03d0, code lost:
    
        if (r0 <= r2) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x03d2, code lost:
    
        r3 = (r0 - r2) / 2;
        r5 = new short[r3];
        r12.position(r2);
        r12.order(java.nio.ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(r5);
        r12.position(r0);
        r32.f209771c = r0;
        r0 = r15;
        r14 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x03f1, code lost:
    
        if (r0 >= (r3 / r4)) goto L300;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x03f3, code lost:
    
        r2 = r15;
        r6 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x03f5, code lost:
    
        if (r2 >= r4) goto L303;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x03f7, code lost:
    
        r6 = r6 + java.lang.Math.abs((int) r5[(r0 * r4) + r2]);
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0404, code lost:
    
        r6 = r6 / r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0405, code lost:
    
        if (r14 >= r6) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0407, code lost:
    
        r14 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0408, code lost:
    
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x040b, code lost:
    
        r0 = (float) java.lang.Math.sqrt(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0411, code lost:
    
        monitor-enter(r32);
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0414, code lost:
    
        if (r20 >= 0.0f) goto L206;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0416, code lost:
    
        r32.f209772d.add(java.lang.Float.valueOf(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x045f, code lost:
    
        monitor-exit(r32);
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0474, code lost:
    
        r12.clear();
        r27.release();
        r9.stop();
        r9.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:?, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0424, code lost:
    
        if (r19 >= 0.0f) goto L209;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0426, code lost:
    
        r20 = (r20 + r0) / 2.0f;
        r32.f209772d.add(java.lang.Float.valueOf(r20));
        r32.f209772d.add(java.lang.Float.valueOf(r20));
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x043f, code lost:
    
        r32.f209772d.add(java.lang.Float.valueOf(((r19 + r20) + r0) / 3.0f));
        r32.f209772d.add(java.lang.Float.valueOf((r20 + r0) / 2.0f));
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0420, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0462, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x0463, code lost:
    
        monitor-enter(r32);
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0464, code lost:
    
        r32.f209772d.add(java.lang.Float.valueOf((r20 + r21) / 2.0f));
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x0473, code lost:
    
        monitor-exit(r32);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean g(File file, int i3, MusicItemInfo musicItemInfo) throws IOException {
        int i16;
        int i17;
        MediaExtractor mediaExtractor;
        MediaCodec.BufferInfo bufferInfo;
        int i18;
        int i19;
        ByteBuffer byteBuffer;
        short[] sArr;
        int i26;
        ByteBuffer byteBuffer2;
        int i27;
        MediaFormat mediaFormat;
        short[] sArr2;
        int i28;
        int i29;
        byte[] bArr;
        int i36;
        ByteBuffer byteBuffer3;
        MediaExtractor mediaExtractor2 = new MediaExtractor();
        int length = (int) file.length();
        try {
            mediaExtractor2.setDataSource(file.getPath());
            int trackCount = mediaExtractor2.getTrackCount();
            int i37 = 0;
            int i38 = 0;
            MediaFormat mediaFormat2 = null;
            while (true) {
                if (i38 >= trackCount) {
                    break;
                }
                mediaFormat2 = mediaExtractor2.getTrackFormat(i38);
                if (mediaFormat2 != null && mediaFormat2.getString("mime").startsWith("audio/")) {
                    mediaExtractor2.selectTrack(i38);
                    break;
                }
                i38++;
            }
            if (i38 != trackCount) {
                if (mediaFormat2 == null) {
                    mediaExtractor2.release();
                    return false;
                }
                int i39 = musicItemInfo.musicStart + i3;
                int i46 = 2;
                if (i39 > 0) {
                    mediaExtractor2.seekTo(i39 * 1000, 2);
                }
                int integer = mediaFormat2.getInteger("channel-count");
                this.f209770b = mediaFormat2.getInteger("sample-rate");
                if (musicItemInfo.isMyMusicInfo()) {
                    i16 = musicItemInfo.musicEnd;
                    i17 = musicItemInfo.musicStart;
                } else {
                    i16 = (int) ((((float) mediaFormat2.getLong("durationUs")) / 1000.0f) + 0.5f);
                    i17 = musicItemInfo.musicStart;
                }
                int i47 = (int) ((((i16 - (i17 + i3)) / 1000.0f) * this.f209770b) + 0.5f);
                this.f209773e = 1024;
                while (true) {
                    float f16 = this.f209770b * 1.0f;
                    int i48 = this.f209773e;
                    if (f16 / i48 >= 30.0f || i48 <= 128) {
                        break;
                    }
                    this.f209773e = i48 / 2;
                }
                MediaCodec createDecoderByType = MediaCodec.createDecoderByType(mediaFormat2.getString("mime"));
                createDecoderByType.configure(mediaFormat2, (Surface) null, (MediaCrypto) null, 0);
                createDecoderByType.start();
                ByteBuffer[] inputBuffers = createDecoderByType.getInputBuffers();
                ByteBuffer[] outputBuffers = createDecoderByType.getOutputBuffers();
                MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
                ByteBuffer allocate = ByteBuffer.allocate(1048576);
                Boolean bool = Boolean.TRUE;
                synchronized (this) {
                    this.f209772d.clear();
                }
                this.f209771c = 0;
                int c16 = c() * integer;
                short[] sArr3 = new short[c16];
                boolean z16 = true;
                this.f209774f = true;
                boolean z17 = false;
                int i49 = 0;
                ByteBuffer[] byteBufferArr = outputBuffers;
                Boolean bool2 = bool;
                MediaCodec.BufferInfo bufferInfo3 = bufferInfo2;
                int i56 = c16;
                float f17 = -1.0f;
                float f18 = -1.0f;
                float f19 = -1.0f;
                byte[] bArr2 = null;
                ByteBuffer byteBuffer4 = allocate;
                int i57 = 0;
                while (true) {
                    try {
                        int dequeueInputBuffer = createDecoderByType.dequeueInputBuffer(100L);
                        if (!z17 && dequeueInputBuffer >= 0) {
                            try {
                                int readSampleData = mediaExtractor2.readSampleData(inputBuffers[dequeueInputBuffer], i37);
                                if (bool2.booleanValue()) {
                                    try {
                                        if (mediaFormat2.getString("mime").equals("audio/mp4a-latm") && readSampleData == i46) {
                                            mediaExtractor2.advance();
                                            i49 += readSampleData;
                                            bufferInfo = bufferInfo3;
                                            i18 = i56;
                                            i19 = i57;
                                            byteBuffer = byteBuffer4;
                                            sArr = sArr3;
                                            bool2 = Boolean.FALSE;
                                        }
                                    } catch (MediaCodec.CryptoException e16) {
                                        e = e16;
                                        mediaExtractor = mediaExtractor2;
                                        QLog.e("MusicSoundFile", 1, "MediaCodec queue input buffer error.", e);
                                        byteBuffer4.clear();
                                        mediaExtractor.release();
                                        createDecoderByType.stop();
                                        createDecoderByType.release();
                                        return true;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        mediaExtractor = mediaExtractor2;
                                        byteBuffer4.clear();
                                        mediaExtractor.release();
                                        createDecoderByType.stop();
                                        createDecoderByType.release();
                                        throw th;
                                    }
                                }
                                if (readSampleData < 0) {
                                    i19 = i57;
                                    byteBuffer = byteBuffer4;
                                    bufferInfo = bufferInfo3;
                                    i18 = i56;
                                    sArr = sArr3;
                                    createDecoderByType.queueInputBuffer(dequeueInputBuffer, 0, 0, -1L, 4);
                                    z17 = z16;
                                } else {
                                    bufferInfo = bufferInfo3;
                                    i18 = i56;
                                    i19 = i57;
                                    byteBuffer = byteBuffer4;
                                    sArr = sArr3;
                                    createDecoderByType.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, mediaExtractor2.getSampleTime(), 0);
                                    mediaExtractor2.advance();
                                    int i58 = i49 + readSampleData;
                                    InterfaceC7597a interfaceC7597a = this.f209769a;
                                    if (interfaceC7597a != null && !interfaceC7597a.a(i58 / length)) {
                                        byteBuffer.clear();
                                        mediaExtractor2.release();
                                        createDecoderByType.stop();
                                        createDecoderByType.release();
                                        byteBuffer.clear();
                                        mediaExtractor2.release();
                                        createDecoderByType.stop();
                                        createDecoderByType.release();
                                        return z16;
                                    }
                                    i49 = i58;
                                }
                                bool2 = Boolean.FALSE;
                            } catch (MediaCodec.CryptoException e17) {
                                e = e17;
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        } else {
                            bufferInfo = bufferInfo3;
                            i18 = i56;
                            i19 = i57;
                            byteBuffer = byteBuffer4;
                            sArr = sArr3;
                        }
                        i26 = i49;
                        try {
                            int dequeueOutputBuffer = createDecoderByType.dequeueOutputBuffer(bufferInfo, 100L);
                            if (dequeueOutputBuffer >= 0 && (i29 = bufferInfo.size) > 0) {
                                if (i19 < i29) {
                                    try {
                                        bArr = new byte[i29];
                                        i19 = i29;
                                    } catch (MediaCodec.CryptoException e18) {
                                        e = e18;
                                        byteBuffer4 = byteBuffer;
                                        mediaExtractor = mediaExtractor2;
                                        QLog.e("MusicSoundFile", 1, "MediaCodec queue input buffer error.", e);
                                        byteBuffer4.clear();
                                        mediaExtractor.release();
                                        createDecoderByType.stop();
                                        createDecoderByType.release();
                                        return true;
                                    } catch (Throwable th7) {
                                        th = th7;
                                        byteBuffer4 = byteBuffer;
                                        mediaExtractor = mediaExtractor2;
                                        byteBuffer4.clear();
                                        mediaExtractor.release();
                                        createDecoderByType.stop();
                                        createDecoderByType.release();
                                        throw th;
                                    }
                                } else {
                                    bArr = bArr2;
                                }
                                byteBufferArr[dequeueOutputBuffer].get(bArr, 0, i29);
                                byteBufferArr[dequeueOutputBuffer].clear();
                                if (byteBuffer.remaining() < bufferInfo.size) {
                                    int position = byteBuffer.position();
                                    i36 = i19;
                                    mediaFormat = mediaFormat2;
                                    mediaExtractor = mediaExtractor2;
                                    i27 = length;
                                    int i59 = (int) (position * ((length * 1.0d) / i26) * 1.2d);
                                    int i65 = i59 - position;
                                    try {
                                        int i66 = bufferInfo.size;
                                        if (i65 < i66 + 5242880) {
                                            i59 = i66 + position + 5242880;
                                        }
                                        int i67 = 10;
                                        while (true) {
                                            if (i67 > 0) {
                                                try {
                                                    byteBuffer3 = ByteBuffer.allocate(i59);
                                                    break;
                                                } catch (MediaCodec.CryptoException e19) {
                                                    e = e19;
                                                    byteBuffer4 = byteBuffer;
                                                    QLog.e("MusicSoundFile", 1, "MediaCodec queue input buffer error.", e);
                                                    byteBuffer4.clear();
                                                    mediaExtractor.release();
                                                    createDecoderByType.stop();
                                                    createDecoderByType.release();
                                                    return true;
                                                } catch (OutOfMemoryError unused) {
                                                    i67--;
                                                } catch (Throwable th8) {
                                                    th = th8;
                                                    byteBuffer4 = byteBuffer;
                                                    byteBuffer4.clear();
                                                    mediaExtractor.release();
                                                    createDecoderByType.stop();
                                                    createDecoderByType.release();
                                                    throw th;
                                                }
                                            } else {
                                                byteBuffer3 = null;
                                                break;
                                            }
                                        }
                                        if (i67 == 0) {
                                            byteBuffer4 = byteBuffer;
                                            break;
                                        }
                                        byteBuffer.rewind();
                                        byteBuffer2 = byteBuffer;
                                        try {
                                            byteBuffer3.put(byteBuffer2);
                                        } catch (MediaCodec.CryptoException e26) {
                                            e = e26;
                                            byteBuffer4 = byteBuffer2;
                                            QLog.e("MusicSoundFile", 1, "MediaCodec queue input buffer error.", e);
                                            byteBuffer4.clear();
                                            mediaExtractor.release();
                                            createDecoderByType.stop();
                                            createDecoderByType.release();
                                            return true;
                                        } catch (Throwable th9) {
                                            th = th9;
                                            byteBuffer4 = byteBuffer2;
                                            byteBuffer4.clear();
                                            mediaExtractor.release();
                                            createDecoderByType.stop();
                                            createDecoderByType.release();
                                            throw th;
                                        }
                                        try {
                                            byteBuffer3.position(position);
                                        } catch (MediaCodec.CryptoException e27) {
                                            e = e27;
                                            byteBuffer4 = byteBuffer3;
                                            QLog.e("MusicSoundFile", 1, "MediaCodec queue input buffer error.", e);
                                            byteBuffer4.clear();
                                            mediaExtractor.release();
                                            createDecoderByType.stop();
                                            createDecoderByType.release();
                                            return true;
                                        } catch (Throwable th10) {
                                            th = th10;
                                            byteBuffer4 = byteBuffer3;
                                            byteBuffer4.clear();
                                            mediaExtractor.release();
                                            createDecoderByType.stop();
                                            createDecoderByType.release();
                                            throw th;
                                        }
                                    } catch (MediaCodec.CryptoException e28) {
                                        e = e28;
                                        byteBuffer2 = byteBuffer;
                                    } catch (Throwable th11) {
                                        th = th11;
                                        byteBuffer2 = byteBuffer;
                                    }
                                } else {
                                    mediaExtractor = mediaExtractor2;
                                    i27 = length;
                                    i36 = i19;
                                    mediaFormat = mediaFormat2;
                                    byteBuffer3 = byteBuffer;
                                }
                                i28 = 0;
                                byteBuffer3.put(bArr, 0, bufferInfo.size);
                                createDecoderByType.releaseOutputBuffer(dequeueOutputBuffer, false);
                                int position2 = byteBuffer3.position();
                                while (position2 - this.f209771c > c() * 2 * integer) {
                                    byteBuffer3.position(this.f209771c);
                                    short[] sArr4 = sArr;
                                    byteBuffer3.order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(sArr4);
                                    byteBuffer3.position(position2);
                                    this.f209771c += c() * 2 * integer;
                                    int i68 = -1;
                                    for (int i69 = 0; i69 < i18 / integer; i69++) {
                                        int i75 = 0;
                                        for (int i76 = 0; i76 < integer; i76++) {
                                            i75 += Math.abs((int) sArr4[(i69 * integer) + i76]);
                                        }
                                        int i77 = i75 / integer;
                                        if (i68 < i77) {
                                            i68 = i77;
                                        }
                                    }
                                    float sqrt = (float) Math.sqrt(i68);
                                    synchronized (this) {
                                        if (f18 >= 0.0f) {
                                            if (f17 < 0.0f) {
                                                this.f209772d.add(Float.valueOf((f18 + sqrt) / 2.0f));
                                            } else {
                                                this.f209772d.add(Float.valueOf(((f17 + f18) + sqrt) / 3.0f));
                                            }
                                            f17 = f18;
                                        }
                                    }
                                    f18 = sqrt;
                                    f19 = f18;
                                    sArr = sArr4;
                                }
                                sArr2 = sArr;
                                byteBuffer4 = byteBuffer3;
                                i19 = i36;
                                bArr2 = bArr;
                            } else {
                                mediaExtractor = mediaExtractor2;
                                i27 = length;
                                mediaFormat = mediaFormat2;
                                sArr2 = sArr;
                                i28 = 0;
                                ByteBuffer byteBuffer5 = byteBuffer;
                                if (dequeueOutputBuffer == -3) {
                                    byteBufferArr = createDecoderByType.getOutputBuffers();
                                }
                                byteBuffer4 = byteBuffer5;
                            }
                        } catch (MediaCodec.CryptoException e29) {
                            e = e29;
                            byteBuffer2 = byteBuffer;
                            mediaExtractor = mediaExtractor2;
                        } catch (Throwable th12) {
                            th = th12;
                            byteBuffer2 = byteBuffer;
                            mediaExtractor = mediaExtractor2;
                        }
                    } catch (MediaCodec.CryptoException e36) {
                        e = e36;
                        mediaExtractor = mediaExtractor2;
                    } catch (Throwable th13) {
                        th = th13;
                        mediaExtractor = mediaExtractor2;
                    }
                    try {
                        try {
                            if ((bufferInfo.flags & 4) != 0 || byteBuffer4.position() / (integer * 2) >= i47) {
                                break;
                            }
                            bufferInfo3 = bufferInfo;
                            sArr3 = sArr2;
                            i49 = i26;
                            i37 = i28;
                            i56 = i18;
                            mediaExtractor2 = mediaExtractor;
                            length = i27;
                            mediaFormat2 = mediaFormat;
                            z16 = true;
                            i57 = i19;
                            i46 = 2;
                        } catch (MediaCodec.CryptoException e37) {
                            e = e37;
                            QLog.e("MusicSoundFile", 1, "MediaCodec queue input buffer error.", e);
                            byteBuffer4.clear();
                            mediaExtractor.release();
                            createDecoderByType.stop();
                            createDecoderByType.release();
                            return true;
                        }
                    } catch (Throwable th14) {
                        th = th14;
                        byteBuffer4.clear();
                        mediaExtractor.release();
                        createDecoderByType.stop();
                        createDecoderByType.release();
                        throw th;
                    }
                }
            } else {
                throw new RuntimeException("No audio track found in " + file);
            }
        } catch (IOException e38) {
            mediaExtractor2.release();
            throw e38;
        }
    }

    private void h(InterfaceC7597a interfaceC7597a) {
        this.f209769a = interfaceC7597a;
    }

    public boolean a(MusicItemInfo musicItemInfo, InterfaceC7597a interfaceC7597a, int i3) throws IOException {
        String localPath;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, musicItemInfo, interfaceC7597a, Integer.valueOf(i3))).booleanValue();
        }
        if (musicItemInfo == null || (localPath = musicItemInfo.getLocalPath()) == null) {
            return false;
        }
        File file = new File(localPath);
        if (file.exists()) {
            String[] split = file.getName().toLowerCase().split("\\.");
            if (split.length < 2 || !Arrays.asList(d()).contains(split[split.length - 1])) {
                return false;
            }
            h(interfaceC7597a);
            return g(file, i3, musicItemInfo);
        }
        throw new FileNotFoundException(localPath);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006b A[Catch: all -> 0x00c5, TryCatch #0 {, blocks: (B:10:0x0017, B:12:0x0021, B:15:0x0029, B:17:0x0038, B:21:0x006b, B:29:0x0085, B:33:0x008d, B:39:0x0095, B:42:0x00a6, B:45:0x00bf, B:48:0x00c1, B:50:0x003f, B:52:0x0047, B:54:0x0052, B:56:0x00c3), top: B:9:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public float b(int i3) {
        int i16;
        float f16;
        int i17;
        int i18;
        float f17;
        float f18;
        float floatValue;
        int i19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Float) iPatchRedirector.redirect((short) 5, (Object) this, i3)).floatValue();
        }
        synchronized (this) {
            int f19 = f(i3);
            ArrayList<Float> arrayList = this.f209772d;
            float f26 = -1.0f;
            if (arrayList != null && arrayList.size() > f19) {
                int f27 = f(2000);
                if (this.f209772d.size() < f27) {
                    f27 = this.f209772d.size();
                } else {
                    i16 = f19 - (f27 / 2);
                    if (i16 >= 0) {
                        int i26 = (f27 / 2) + f19;
                        if (i26 > this.f209772d.size()) {
                            i16 = this.f209772d.size() - f27;
                            f27 = this.f209772d.size();
                        } else {
                            f27 = i26;
                        }
                        f16 = 65535.0f;
                        i18 = 0;
                        f17 = 0.0f;
                        f18 = 0.0f;
                        for (i17 = i16; i17 < f27; i17++) {
                            float floatValue2 = this.f209772d.get(i17).floatValue();
                            if (floatValue2 < f16 && floatValue2 > 0.0f) {
                                f16 = floatValue2;
                            }
                            if (floatValue2 > f17) {
                                f17 = floatValue2;
                            }
                            f18 += floatValue2;
                            if (floatValue2 > 0.0f) {
                                i19 = 0;
                            } else {
                                i19 = 1;
                            }
                            i18 += i19;
                        }
                        if (f16 < f17 && this.f209772d.get(f19).floatValue() > 0.0f) {
                            float f28 = f18 / ((f27 - i16) - i18);
                            floatValue = (this.f209772d.get(f19).floatValue() - f28) / (f17 - f28);
                            if (floatValue < 0.0f) {
                                f26 = floatValue;
                            }
                            return f26;
                        }
                        return -1.0f;
                    }
                }
                i16 = 0;
                f16 = 65535.0f;
                i18 = 0;
                f17 = 0.0f;
                f18 = 0.0f;
                while (i17 < f27) {
                }
                if (f16 < f17) {
                    float f282 = f18 / ((f27 - i16) - i18);
                    floatValue = (this.f209772d.get(f19).floatValue() - f282) / (f17 - f282);
                    if (floatValue < 0.0f) {
                    }
                    return f26;
                }
                return -1.0f;
            }
            return -1.0f;
        }
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f209773e;
    }
}
