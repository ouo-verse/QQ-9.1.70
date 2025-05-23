package com.tencent.aelight.camera.aioeditor.richmedia.mediacodec;

import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.editor.composite.step.a;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypesTools;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.videocodec.audio.b;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import hd0.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AudioDecoder {

    /* renamed from: a, reason: collision with root package name */
    private AudioPlayRunnable f67481a;

    /* renamed from: b, reason: collision with root package name */
    private BgmAudioPlayRunnable f67482b;

    /* renamed from: c, reason: collision with root package name */
    private Thread f67483c;

    /* renamed from: d, reason: collision with root package name */
    public b f67484d;

    /* renamed from: e, reason: collision with root package name */
    private Thread f67485e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class AudioPlayRunnable implements Runnable {
        public boolean I;
        public boolean J;

        /* renamed from: f, reason: collision with root package name */
        private float f67488f;

        /* renamed from: h, reason: collision with root package name */
        private float f67489h;

        /* renamed from: d, reason: collision with root package name */
        private volatile int f67486d = 0;

        /* renamed from: e, reason: collision with root package name */
        private volatile int f67487e = -1;

        /* renamed from: i, reason: collision with root package name */
        private int f67490i = 0;

        /* renamed from: m, reason: collision with root package name */
        private int f67491m = 0;
        private long C = 0;
        private int D = 0;
        private volatile boolean E = false;
        private Object F = new Object();
        private volatile boolean G = false;
        private float H = -1.0f;

        public AudioPlayRunnable(float f16, float f17) {
            this.f67488f = 0.0f;
            this.f67489h = 0.0f;
            this.f67488f = f16;
            this.f67489h = f17;
        }

        private byte[] e() {
            byte[] bArr;
            FileInputStream fileInputStream;
            long currentTimeMillis = System.currentTimeMillis();
            File file = new File(AudioDecoder.this.f67484d.f312508a);
            int length = (int) file.length();
            this.D = length;
            int i3 = (int) (length * this.f67488f);
            this.f67490i = i3;
            int i16 = AudioDecoder.this.f67484d.f312509b.f288229d;
            int i17 = i3 % i16;
            if (i17 != 0) {
                this.f67490i = i3 + (i16 - i17);
            }
            float f16 = this.f67489h;
            if (f16 == 0.0f) {
                this.f67491m = length;
            } else {
                int i18 = (int) (length * f16);
                this.f67491m = i18;
                int i19 = i18 % i16;
                if (i19 != 0) {
                    this.f67491m = i18 + (i16 - i19);
                }
            }
            QLog.d("AudioDecoder", 4, "getAudioDataFromAudioFile begin startPosition=" + this.f67490i + " endPosition=" + this.f67491m);
            try {
                bArr = new byte[this.f67491m - this.f67490i];
            } catch (OutOfMemoryError unused) {
                QLog.e("AudioDecoder", 4, "getAudioDataFromAudioFile OutOfMemoryError!");
                ImageCacheHelper.f98636a.e();
                bArr = new byte[this.f67491m - this.f67490i];
            }
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = null;
            }
            try {
                int i26 = this.f67490i;
                if (i26 != 0) {
                    fileInputStream.skip(i26);
                }
                fileInputStream.read(bArr);
                try {
                    fileInputStream.close();
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
                QLog.d("AudioDecoder", 4, "getAudioDataFromAudioFile time cost=" + (System.currentTimeMillis() - currentTimeMillis));
                return bArr;
            } catch (Throwable th6) {
                th = th6;
                try {
                    QLog.e("AudioDecoder", 4, "AudioTrack Playback Failed");
                    th.printStackTrace();
                    return null;
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                        }
                    }
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x00cf A[Catch: all -> 0x0128, TryCatch #1 {all -> 0x0128, blocks: (B:5:0x000e, B:6:0x0025, B:8:0x002a, B:10:0x002e, B:12:0x0037, B:14:0x003b, B:16:0x0041, B:17:0x004a, B:19:0x0060, B:20:0x0062, B:21:0x006a, B:22:0x006c, B:29:0x007e, B:31:0x008e, B:33:0x00b8, B:36:0x00c2, B:37:0x00c5, B:39:0x00cf, B:41:0x00d7, B:43:0x00db, B:55:0x00f8, B:57:0x00f9, B:59:0x0101, B:60:0x010a, B:63:0x010e, B:64:0x0110, B:75:0x011b, B:79:0x011d, B:82:0x0095, B:84:0x009c, B:85:0x00a3, B:86:0x00aa, B:87:0x00b1, B:89:0x0124, B:45:0x00dc, B:47:0x00e0, B:49:0x00eb, B:50:0x00f4), top: B:4:0x000e, inners: #0, #3 }] */
        /* JADX WARN: Removed duplicated region for block: B:62:0x010e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0025 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void i(byte[] bArr) {
            AudioTrack audioTrack;
            int c16;
            boolean z16;
            QLog.d("AudioDecoder", 4, "begin playAudio");
            try {
                audioTrack = g();
            } catch (Throwable th5) {
                th = th5;
                audioTrack = null;
            }
            try {
                int minBufferSize = AudioTrack.getMinBufferSize(audioTrack.getSampleRate(), audioTrack.getChannelConfiguration(), audioTrack.getAudioFormat()) * 2;
                byte[] bArr2 = new byte[minBufferSize];
                this.I = false;
                while (this.f67486d < bArr.length && !this.I) {
                    if (this.H != -1.0f) {
                        if (this.G) {
                            if (QLog.isColorLevel()) {
                                QLog.d("AudioDecoder", 1, "playAudio, real do seek");
                            }
                            int i3 = (int) ((this.H * this.D) / this.f67489h);
                            int i16 = AudioDecoder.this.f67484d.f312509b.f288229d;
                            int i17 = i3 % i16;
                            if (i17 != 0) {
                                i3 += i16 - i17;
                            }
                            this.f67486d = i3 - this.f67490i;
                            audioTrack.flush();
                        }
                        this.H = -1.0f;
                    }
                    int i18 = AudioDecoder.this.f67484d.f312511d;
                    if (i18 == 1) {
                        c16 = a.c(bArr, this.f67486d, bArr2, minBufferSize);
                    } else if (i18 == 2) {
                        c16 = a.f(bArr, this.f67486d, bArr2, minBufferSize, 2);
                    } else if (i18 == 3) {
                        c16 = a.d(bArr, this.f67486d, bArr2, minBufferSize);
                    } else if (i18 == 4) {
                        c16 = a.f(bArr, this.f67486d, bArr2, minBufferSize, 4);
                    } else if (i18 != 5) {
                        c16 = Math.min(bArr.length - this.f67486d, minBufferSize);
                        if (!AudioDecoder.this.f67484d.f312512e) {
                            audioTrack.write(bArr, this.f67486d, c16);
                        }
                        z16 = true;
                        if (!AudioDecoder.this.f67484d.f312512e && !z16) {
                            audioTrack.write(bArr2, 0, minBufferSize);
                        }
                        this.f67486d += c16;
                        if (this.f67486d >= bArr.length) {
                            b bVar = AudioDecoder.this.f67484d;
                            if (bVar.f312510c) {
                                if (bVar.f312511d != 3) {
                                    synchronized (this) {
                                        if (!this.G) {
                                            LockMethodProxy.wait(this);
                                            this.G = false;
                                            if (QLog.isColorLevel()) {
                                                QLog.d("AudioDecoder", 1, "audio repeat, video finish and notify");
                                            }
                                        }
                                    }
                                }
                                this.f67486d = 0;
                                if (QLog.isColorLevel()) {
                                    QLog.d("AudioDecoder", 1, "audio repeat");
                                }
                            }
                        }
                        if (!this.E) {
                            try {
                                synchronized (this.F) {
                                    LockMethodProxy.wait(this.F);
                                }
                            } catch (InterruptedException e16) {
                                e16.printStackTrace();
                                this.I = true;
                            }
                        }
                    } else {
                        c16 = a.e(bArr, this.f67486d, bArr2, minBufferSize);
                    }
                    z16 = false;
                    if (!AudioDecoder.this.f67484d.f312512e) {
                        audioTrack.write(bArr2, 0, minBufferSize);
                    }
                    this.f67486d += c16;
                    if (this.f67486d >= bArr.length) {
                    }
                    if (!this.E) {
                    }
                }
                audioTrack.stop();
            } catch (Throwable th6) {
                th = th6;
                try {
                    QLog.e("AudioDecoder", 4, "AudioTrack Playback Failed");
                    th.printStackTrace();
                } finally {
                    if (audioTrack != null) {
                        audioTrack.release();
                    }
                }
            }
        }

        public void j() {
            if (AudioDecoder.this.f67484d.f312511d != 3) {
                try {
                    LockMethodProxy.sleep(200L);
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
                synchronized (this) {
                    try {
                        this.G = true;
                        notifyAll();
                    } catch (Exception e17) {
                        e17.printStackTrace();
                    }
                }
            }
            this.f67486d = 0;
            this.f67487e = 0;
        }

        public void l(long j3, long j16) {
            b bVar = AudioDecoder.this.f67484d;
            if (bVar != null) {
                float f16 = ((float) j3) / ((float) j16);
                float f17 = this.f67488f;
                if (f16 >= f17) {
                    float f18 = this.f67489h;
                    if (f16 <= f18) {
                        if (bVar.f312511d == 5) {
                            this.H = f18 - (f16 - f17);
                        } else {
                            this.H = f16;
                        }
                        QLog.d("AudioDecoder", 1, "seekToPercent: ", Float.valueOf(this.H));
                        return;
                    }
                }
                QLog.w("AudioDecoder", 1, "seek error, timePercent=" + f16);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            byte[] e16;
            if (this.J && !TextUtils.isEmpty(AudioDecoder.this.f67484d.f312516i)) {
                try {
                    e16 = FileUtils.fileToBytes(new File(AudioDecoder.this.f67484d.f312516i));
                } catch (Exception unused) {
                    QLog.e("AudioDecoder", 1, "bgm music get error");
                    e16 = null;
                }
            } else if (MimeHelper.validateVideoType(MimeTypesTools.getMimeType(BaseApplication.getContext(), AudioDecoder.this.f67484d.f312508a))) {
                b bVar = AudioDecoder.this.f67484d;
                e16 = f(bVar.f312508a, bVar.f312511d != 5);
            } else {
                e16 = e();
            }
            if (e16 != null) {
                i(e16);
            }
        }

        public void h() {
            this.E = true;
        }

        public void k() {
            this.E = false;
            synchronized (this.F) {
                this.F.notifyAll();
            }
        }

        private AudioTrack g() {
            ReportAudioTrack reportAudioTrack;
            Throwable th5;
            try {
                AudioEncoder.a aVar = AudioDecoder.this.f67484d.f312509b;
                int i3 = aVar.f288232g == 1 ? 4 : 12;
                int i16 = aVar.f288229d == 16 ? 2 : 3;
                reportAudioTrack = new ReportAudioTrack(3, AudioDecoder.this.f67484d.f312509b.f288231f, i3, i16, AudioTrack.getMinBufferSize(aVar.f288231f, i3, i16), 1);
            } catch (Throwable th6) {
                reportAudioTrack = null;
                th5 = th6;
            }
            try {
                float f16 = AudioDecoder.this.f67484d.f312509b.f288233h;
                reportAudioTrack.setStereoVolume(f16, f16);
                reportAudioTrack.play();
            } catch (Throwable th7) {
                th5 = th7;
                QLog.e("AudioDecoder", 4, "AudioTrack init fail");
                th5.printStackTrace();
                return reportAudioTrack;
            }
            return reportAudioTrack;
        }

        /* JADX WARN: Code restructure failed: missing block: B:153:0x03cc, code lost:
        
            com.tencent.qphone.base.util.QLog.d("AudioDecoder", 1, "getAudioDataFromMp4 time cost=" + (java.lang.System.currentTimeMillis() - r2));
         */
        /* JADX WARN: Code restructure failed: missing block: B:154:0x03ea, code lost:
        
            if (r11 != null) goto L184;
         */
        /* JADX WARN: Code restructure failed: missing block: B:155:0x03ec, code lost:
        
            r8 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:157:0x03f2, code lost:
        
            r4.stop();
            r4.release();
            r5.release();
         */
        /* JADX WARN: Code restructure failed: missing block: B:158:0x03fb, code lost:
        
            if (r7 == null) goto L191;
         */
        /* JADX WARN: Code restructure failed: missing block: B:159:0x03fd, code lost:
        
            r7.stop();
            r7.release();
         */
        /* JADX WARN: Code restructure failed: missing block: B:162:0x0404, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:163:0x0405, code lost:
        
            com.tencent.qphone.base.util.QLog.e("AudioDecoder", 1, r0, new java.lang.Object[0]);
         */
        /* JADX WARN: Code restructure failed: missing block: B:164:0x03ee, code lost:
        
            r8 = r11.toByteArray();
         */
        /* JADX WARN: Code restructure failed: missing block: B:204:0x0212, code lost:
        
            com.tencent.qphone.base.util.QLog.e("AudioDecoder", 1, "find no data");
         */
        /* JADX WARN: Code restructure failed: missing block: B:207:0x021c, code lost:
        
            r4.stop();
            r4.release();
            r5.release();
            r7 = r24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:208:0x0227, code lost:
        
            if (r7 == null) goto L287;
         */
        /* JADX WARN: Code restructure failed: missing block: B:209:0x0229, code lost:
        
            r7.stop();
            r7.release();
         */
        /* JADX WARN: Code restructure failed: missing block: B:210:0x022f, code lost:
        
            return null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:212:?, code lost:
        
            return null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:213:0x0231, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:214:0x0232, code lost:
        
            com.tencent.qphone.base.util.QLog.e("AudioDecoder", 1, r0, new java.lang.Object[0]);
         */
        /* JADX WARN: Code restructure failed: missing block: B:215:?, code lost:
        
            return null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:270:0x00c5, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:271:0x00c6, code lost:
        
            r0.printStackTrace();
         */
        /* JADX WARN: Code restructure failed: missing block: B:272:0x0118, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:273:0x011c, code lost:
        
            r0.printStackTrace();
         */
        /* JADX WARN: Code restructure failed: missing block: B:275:0x011a, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:276:0x011b, code lost:
        
            r4 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0054, code lost:
        
            r5.selectTrack(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0059, code lost:
        
            if (r7 <= 0) goto L262;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x005b, code lost:
        
            r5.seekTo(r7, 0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x005f, code lost:
        
            r4 = android.media.MediaCodec.createDecoderByType(r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x0067, code lost:
        
            if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L249;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x0069, code lost:
        
            com.tencent.qphone.base.util.QLog.d("AudioDecoder", 4, "config before b=" + r28.this$0.f67484d.f312509b.f288230e + " c=" + r28.this$0.f67484d.f312509b.f288232g + " sc=" + r28.this$0.f67484d.f312509b.f288231f);
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00ac, code lost:
        
            r28.this$0.f67484d.f312509b.f288232g = com.tencent.biz.qqstory.utils.a.a(r6, r29);
            r28.this$0.f67484d.f312509b.f288231f = com.tencent.biz.qqstory.utils.a.b(r6);
         */
        /* JADX WARN: Removed duplicated region for block: B:109:0x0334  */
        /* JADX WARN: Removed duplicated region for block: B:131:0x039d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:151:0x03bd A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:165:0x037b A[Catch: all -> 0x0410, Exception -> 0x0414, TryCatch #15 {Exception -> 0x0414, blocks: (B:107:0x026f, B:110:0x0336, B:112:0x033f, B:124:0x035e, B:125:0x035f, B:127:0x036c, B:129:0x0399, B:132:0x039d, B:133:0x039f, B:145:0x03a9, B:149:0x03ab, B:153:0x03cc, B:164:0x03ee, B:165:0x037b, B:167:0x037f, B:169:0x038f, B:192:0x0279, B:219:0x02c0, B:221:0x02c6, B:222:0x02d1, B:224:0x02e1, B:225:0x02ff, B:227:0x030d, B:228:0x0317), top: B:106:0x026f }] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0460 A[Catch: Exception -> 0x0459, TRY_LEAVE, TryCatch #7 {Exception -> 0x0459, blocks: (B:30:0x0452, B:18:0x045b, B:20:0x0460), top: B:29:0x0452 }] */
        /* JADX WARN: Removed duplicated region for block: B:234:0x0328  */
        /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0452 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0487 A[Catch: Exception -> 0x0480, TRY_LEAVE, TryCatch #16 {Exception -> 0x0480, blocks: (B:46:0x0479, B:35:0x0482, B:37:0x0487), top: B:45:0x0479 }] */
        /* JADX WARN: Removed duplicated region for block: B:44:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0479 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:69:0x012d A[Catch: all -> 0x0152, Exception -> 0x0158, TRY_LEAVE, TryCatch #25 {Exception -> 0x0158, all -> 0x0152, blocks: (B:69:0x012d, B:82:0x0160, B:84:0x016f, B:255:0x0177, B:260:0x0419, B:273:0x011c, B:12:0x0122), top: B:11:0x0122 }] */
        /* JADX WARN: Removed duplicated region for block: B:80:0x015d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:92:0x01d7  */
        /* JADX WARN: Type inference failed for: r4v15, types: [boolean] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private byte[] f(String str, boolean z16) {
            Throwable th5;
            AudioTrack audioTrack;
            MediaCodec mediaCodec;
            MediaCodec mediaCodec2;
            MediaCodec mediaCodec3;
            ByteArrayOutputStream byteArrayOutputStream;
            AudioTrack audioTrack2;
            byte[] byteArray;
            ByteBuffer[] byteBufferArr;
            ByteBuffer[] byteBufferArr2;
            MediaCodec.BufferInfo bufferInfo;
            boolean z17;
            MediaFormat trackFormat;
            long j3;
            long j16;
            QLog.d("AudioDecoder", 4, "getAudioDataFromMp4 begin");
            long currentTimeMillis = System.currentTimeMillis();
            MediaExtractor mediaExtractor = new MediaExtractor();
            try {
                mediaExtractor.setDataSource(str);
                long j17 = 0;
                long j18 = 0;
                int i3 = 0;
                while (true) {
                    if (i3 >= mediaExtractor.getTrackCount()) {
                        mediaCodec3 = null;
                        break;
                    }
                    trackFormat = mediaExtractor.getTrackFormat(i3);
                    String string = trackFormat.getString("mime");
                    long j19 = trackFormat.getLong("durationUs");
                    this.C = j19;
                    j3 = this.f67488f * ((float) j19);
                    j16 = this.f67489h * ((float) j19);
                    if (j16 == 0) {
                        j16 = j19;
                    }
                    ?? startsWith = string.startsWith("audio/");
                    if (startsWith != 0) {
                        break;
                    }
                    try {
                        i3++;
                        j17 = j16;
                        j18 = j3;
                    } catch (Exception e16) {
                        e = e16;
                        mediaCodec2 = startsWith;
                        audioTrack = null;
                        try {
                            QLog.e("AudioDecoder", 1, e, new Object[0]);
                            if (mediaCodec2 != null) {
                            }
                            mediaExtractor.release();
                            if (audioTrack == null) {
                            }
                        } catch (Throwable th6) {
                            th5 = th6;
                            mediaCodec = mediaCodec2;
                            if (mediaCodec != null) {
                                try {
                                    mediaCodec.stop();
                                    mediaCodec.release();
                                } catch (Exception e17) {
                                    QLog.e("AudioDecoder", 1, e17, new Object[0]);
                                    throw th5;
                                }
                            }
                            mediaExtractor.release();
                            if (audioTrack == null) {
                                audioTrack.stop();
                                audioTrack.release();
                                throw th5;
                            }
                            throw th5;
                        }
                    } catch (Throwable th7) {
                        th5 = th7;
                        mediaCodec = startsWith;
                        audioTrack = null;
                        if (mediaCodec != null) {
                        }
                        mediaExtractor.release();
                        if (audioTrack == null) {
                        }
                    }
                }
                if (mediaCodec3 == null) {
                    QLog.e("AudioDecoder", 2, "Can't find video info!");
                    if (mediaCodec3 != null) {
                        try {
                            mediaCodec3.stop();
                            mediaCodec3.release();
                        } catch (Exception e18) {
                            QLog.e("AudioDecoder", 1, e18, new Object[0]);
                            return null;
                        }
                    }
                    mediaExtractor.release();
                    return null;
                }
                try {
                    mediaCodec3.start();
                    ByteBuffer[] inputBuffers = mediaCodec3.getInputBuffers();
                    ByteBuffer[] outputBuffers = mediaCodec3.getOutputBuffers();
                    MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
                    if (z16) {
                        audioTrack2 = g();
                        byteArrayOutputStream = null;
                    } else {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        audioTrack2 = null;
                    }
                    boolean z18 = false;
                    boolean z19 = false;
                    boolean z26 = false;
                    while (true) {
                        if (z18) {
                            audioTrack = audioTrack2;
                            break;
                        }
                        if (!z19) {
                            try {
                                int dequeueInputBuffer = mediaCodec3.dequeueInputBuffer(10000L);
                                if (dequeueInputBuffer >= 0) {
                                    int readSampleData = mediaExtractor.readSampleData(inputBuffers[dequeueInputBuffer], 0);
                                    long sampleTime = mediaExtractor.getSampleTime();
                                    if (readSampleData >= 0 && (j17 <= 0 || sampleTime < j17)) {
                                        mediaCodec3.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, sampleTime, 0);
                                        mediaExtractor.advance();
                                        if (z26) {
                                            byteBufferArr = outputBuffers;
                                            byteBufferArr2 = inputBuffers;
                                            bufferInfo = bufferInfo2;
                                            audioTrack = audioTrack2;
                                        } else {
                                            try {
                                                try {
                                                    int dequeueOutputBuffer = mediaCodec3.dequeueOutputBuffer(bufferInfo2, 10000L);
                                                    if (dequeueOutputBuffer == -3) {
                                                        byteBufferArr2 = inputBuffers;
                                                        bufferInfo = bufferInfo2;
                                                        audioTrack = audioTrack2;
                                                        if (QLog.isColorLevel()) {
                                                            QLog.d("AudioDecoder", 2, "INFO_OUTPUT_BUFFERS_CHANGED");
                                                        }
                                                        byteBufferArr = mediaCodec3.getOutputBuffers();
                                                    } else if (dequeueOutputBuffer == -2) {
                                                        byteBufferArr = outputBuffers;
                                                        byteBufferArr2 = inputBuffers;
                                                        bufferInfo = bufferInfo2;
                                                        audioTrack = audioTrack2;
                                                        if (QLog.isColorLevel()) {
                                                            QLog.d("AudioDecoder", 2, "New format " + mediaCodec3.getOutputFormat());
                                                        }
                                                    } else if (dequeueOutputBuffer != -1) {
                                                        if ((bufferInfo2.flags & 4) != 0) {
                                                            if (QLog.isColorLevel()) {
                                                                byteBufferArr2 = inputBuffers;
                                                                QLog.d("AudioDecoder", 2, "output EOS");
                                                            } else {
                                                                byteBufferArr2 = inputBuffers;
                                                            }
                                                            byteBufferArr = outputBuffers;
                                                            bufferInfo = bufferInfo2;
                                                            audioTrack = audioTrack2;
                                                            z17 = false;
                                                            z26 = true;
                                                        } else {
                                                            byteBufferArr2 = inputBuffers;
                                                            try {
                                                                ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                                                                if (byteBuffer == null) {
                                                                    break;
                                                                }
                                                                audioTrack = audioTrack2;
                                                                try {
                                                                    if (bufferInfo2.size != 0) {
                                                                        byteBuffer.position(bufferInfo2.offset);
                                                                        byteBufferArr = outputBuffers;
                                                                        byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
                                                                    } else {
                                                                        byteBufferArr = outputBuffers;
                                                                    }
                                                                    int remaining = byteBuffer.remaining();
                                                                    byte[] bArr = new byte[remaining];
                                                                    bufferInfo = bufferInfo2;
                                                                    byteBuffer.get(bArr, 0, remaining);
                                                                    if (z16) {
                                                                        AudioDecoder.this.c(audioTrack, bArr, remaining);
                                                                        z17 = false;
                                                                    } else {
                                                                        z17 = false;
                                                                        byteArrayOutputStream.write(bArr, 0, remaining);
                                                                    }
                                                                } catch (Exception e19) {
                                                                    e = e19;
                                                                    QLog.e("AudioDecoder", 1, "" + e.toString());
                                                                    try {
                                                                        mediaCodec3.stop();
                                                                        mediaCodec3.release();
                                                                        mediaExtractor.release();
                                                                        if (audioTrack == null) {
                                                                            return null;
                                                                        }
                                                                        audioTrack.stop();
                                                                        audioTrack.release();
                                                                        return null;
                                                                    } catch (Exception e26) {
                                                                        QLog.e("AudioDecoder", 1, e26, new Object[0]);
                                                                        return null;
                                                                    }
                                                                }
                                                            } catch (Exception e27) {
                                                                e = e27;
                                                                audioTrack = audioTrack2;
                                                            }
                                                        }
                                                        try {
                                                            try {
                                                                mediaCodec3.releaseOutputBuffer(dequeueOutputBuffer, z17);
                                                            } catch (Throwable th8) {
                                                                th = th8;
                                                                th5 = th;
                                                                mediaCodec = mediaCodec3;
                                                                if (mediaCodec != null) {
                                                                }
                                                                mediaExtractor.release();
                                                                if (audioTrack == null) {
                                                                }
                                                            }
                                                        } catch (Exception e28) {
                                                            e = e28;
                                                            mediaCodec2 = mediaCodec3;
                                                            QLog.e("AudioDecoder", 1, e, new Object[0]);
                                                            if (mediaCodec2 != null) {
                                                                try {
                                                                    mediaCodec2.stop();
                                                                    mediaCodec2.release();
                                                                } catch (Exception e29) {
                                                                    QLog.e("AudioDecoder", 1, e29, new Object[0]);
                                                                    return null;
                                                                }
                                                            }
                                                            mediaExtractor.release();
                                                            if (audioTrack == null) {
                                                                return null;
                                                            }
                                                            audioTrack.stop();
                                                            audioTrack.release();
                                                            return null;
                                                        }
                                                    } else {
                                                        byteBufferArr = outputBuffers;
                                                        byteBufferArr2 = inputBuffers;
                                                        bufferInfo = bufferInfo2;
                                                        audioTrack = audioTrack2;
                                                        if (QLog.isColorLevel()) {
                                                            QLog.d("AudioDecoder", 2, "dequeueOutputBuffer timed out!");
                                                        }
                                                    }
                                                } catch (Throwable th9) {
                                                    th = th9;
                                                    audioTrack = audioTrack2;
                                                }
                                            } catch (Exception e36) {
                                                e = e36;
                                                audioTrack = audioTrack2;
                                            }
                                        }
                                        if (z26) {
                                            if (!z16) {
                                                break;
                                            }
                                            if (AudioDecoder.this.f67484d.f312511d != 3) {
                                                synchronized (this) {
                                                    if (!this.G) {
                                                        LockMethodProxy.wait(this);
                                                        this.G = false;
                                                        if (QLog.isColorLevel()) {
                                                            QLog.d("AudioDecoder", 1, "audio repeat, video finish and notify");
                                                        }
                                                    }
                                                }
                                            }
                                            mediaCodec3.flush();
                                            mediaExtractor.seekTo(j18, 0);
                                            if (QLog.isColorLevel()) {
                                                QLog.d("AudioDecoder", 1, "audio repeat, audio finish");
                                            }
                                            z19 = false;
                                            z26 = false;
                                        } else if (this.f67487e == 0) {
                                            this.f67487e = -1;
                                            mediaCodec3.flush();
                                            mediaExtractor.seekTo(j18, 0);
                                            if (QLog.isColorLevel()) {
                                                QLog.d("AudioDecoder", 1, "audio repeat, video finish");
                                            }
                                        }
                                        if (this.E) {
                                            try {
                                                synchronized (this.F) {
                                                    LockMethodProxy.wait(this.F);
                                                }
                                            } catch (InterruptedException e37) {
                                                e37.printStackTrace();
                                                audioTrack2 = audioTrack;
                                                inputBuffers = byteBufferArr2;
                                                outputBuffers = byteBufferArr;
                                                bufferInfo2 = bufferInfo;
                                                z18 = true;
                                            }
                                        }
                                        audioTrack2 = audioTrack;
                                        inputBuffers = byteBufferArr2;
                                        outputBuffers = byteBufferArr;
                                        bufferInfo2 = bufferInfo;
                                    }
                                    mediaCodec3.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                                    z19 = true;
                                    if (z26) {
                                    }
                                    if (z26) {
                                    }
                                    if (this.E) {
                                    }
                                    audioTrack2 = audioTrack;
                                    inputBuffers = byteBufferArr2;
                                    outputBuffers = byteBufferArr;
                                    bufferInfo2 = bufferInfo;
                                }
                            } catch (Exception e38) {
                                e = e38;
                                mediaCodec2 = mediaCodec3;
                                audioTrack = audioTrack2;
                                QLog.e("AudioDecoder", 1, e, new Object[0]);
                                if (mediaCodec2 != null) {
                                }
                                mediaExtractor.release();
                                if (audioTrack == null) {
                                }
                            } catch (Throwable th10) {
                                th5 = th10;
                                mediaCodec = mediaCodec3;
                                audioTrack = audioTrack2;
                                if (mediaCodec != null) {
                                }
                                mediaExtractor.release();
                                if (audioTrack == null) {
                                }
                            }
                        }
                        if (z26) {
                        }
                        if (z26) {
                        }
                        if (this.E) {
                        }
                        audioTrack2 = audioTrack;
                        inputBuffers = byteBufferArr2;
                        outputBuffers = byteBufferArr;
                        bufferInfo2 = bufferInfo;
                    }
                } catch (Throwable th11) {
                    th11.printStackTrace();
                    QLog.e("AudioDecoder", 2, "decode start error", th11);
                    try {
                        mediaCodec3.stop();
                        mediaCodec3.release();
                        mediaExtractor.release();
                        return null;
                    } catch (Exception e39) {
                        QLog.e("AudioDecoder", 1, e39, new Object[0]);
                        return null;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("AudioDecoder", 4, "config after b=" + AudioDecoder.this.f67484d.f312509b.f288230e + " c=" + AudioDecoder.this.f67484d.f312509b.f288232g + " sc=" + AudioDecoder.this.f67484d.f312509b.f288231f);
                }
                mediaCodec3.configure(trackFormat, (Surface) null, (MediaCrypto) null, 0);
                j17 = j16;
                j18 = j3;
                if (mediaCodec3 == null) {
                }
                return byteArray;
            } catch (Exception e46) {
                e = e46;
                audioTrack = null;
                mediaCodec2 = null;
            } catch (Throwable th12) {
                th5 = th12;
                audioTrack = null;
                mediaCodec = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class BgmAudioPlayRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        MediaPlayer f67492d;

        /* renamed from: e, reason: collision with root package name */
        Timer f67493e;

        /* renamed from: f, reason: collision with root package name */
        long f67494f;

        /* renamed from: h, reason: collision with root package name */
        TimerTask f67495h;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes32.dex */
        public class a implements MediaPlayer.OnPreparedListener {
            a() {
            }

            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                BgmAudioPlayRunnable.this.f();
            }
        }

        public BgmAudioPlayRunnable() {
            b bVar = AudioDecoder.this.f67484d;
            if (bVar != null) {
                this.f67494f = bVar.f312515h;
            }
        }

        private void g(String str) {
            try {
                ReportMediaPlayer reportMediaPlayer = new ReportMediaPlayer();
                this.f67492d = reportMediaPlayer;
                reportMediaPlayer.setDataSource(str);
                this.f67492d.setAudioStreamType(3);
                this.f67492d.prepareAsync();
                this.f67492d.setOnPreparedListener(new a());
            } catch (FileNotFoundException e16) {
                QLog.e("AudioDecoder", 1, e16, new Object[0]);
            } catch (IOException e17) {
                QLog.e("AudioDecoder", 1, e17, new Object[0]);
            }
        }

        public void e() {
            MediaPlayer mediaPlayer = this.f67492d;
            if (mediaPlayer != null) {
                mediaPlayer.pause();
            }
        }

        public void f() {
            if (this.f67492d != null) {
                if (this.f67493e == null) {
                    this.f67493e = new BaseTimer();
                }
                this.f67492d.start();
                if (AudioDecoder.this.f67484d != null) {
                    TimerTask timerTask = this.f67495h;
                    if (timerTask != null) {
                        timerTask.cancel();
                    }
                    TimerTask timerTask2 = new TimerTask() { // from class: com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.AudioDecoder.BgmAudioPlayRunnable.2
                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            MediaPlayer mediaPlayer = BgmAudioPlayRunnable.this.f67492d;
                            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                                return;
                            }
                            BgmAudioPlayRunnable.this.f67492d.pause();
                        }
                    };
                    this.f67495h = timerTask2;
                    this.f67493e.schedule(timerTask2, this.f67494f);
                }
            }
        }

        public void h() {
            MediaPlayer mediaPlayer = this.f67492d;
            if (mediaPlayer != null) {
                mediaPlayer.seekTo(0);
                f();
            }
        }

        public void i() {
            if (this.f67492d != null) {
                f();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(AudioDecoder.this.f67484d.f312516i)) {
                return;
            }
            g(AudioDecoder.this.f67484d.f312516i);
        }

        public void stop() {
            MediaPlayer mediaPlayer = this.f67492d;
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                this.f67492d.release();
                this.f67492d = null;
                Timer timer = this.f67493e;
                if (timer != null) {
                    timer.cancel();
                    this.f67493e.purge();
                    this.f67493e = null;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AudioTrack audioTrack, byte[] bArr, int i3) {
        int length;
        byte[] bArr2;
        byte[] bArr3;
        b bVar = this.f67484d;
        int i16 = bVar.f312511d;
        boolean z16 = true;
        if (i16 == 1) {
            length = bArr.length / 2;
            bArr2 = new byte[length];
            a.c(bArr, 0, bArr2, length);
        } else if (i16 == 2) {
            length = bArr.length * 2;
            bArr2 = new byte[length];
            a.f(bArr, 0, bArr2, length, 2);
        } else if (i16 == 3) {
            length = (bArr.length * 2) / 3;
            bArr2 = new byte[length];
            a.d(bArr, 0, bArr2, length);
        } else {
            if (i16 != 4) {
                if (!bVar.f312512e) {
                    audioTrack.write(bArr, 0, i3);
                }
                bArr3 = null;
                length = 0;
                if (!this.f67484d.f312512e || z16 || bArr3 == null) {
                    return;
                }
                audioTrack.write(bArr3, 0, length);
                return;
            }
            length = bArr.length * 4;
            bArr2 = new byte[length];
            a.f(bArr, 0, bArr2, length, 4);
        }
        bArr3 = bArr2;
        z16 = false;
        if (this.f67484d.f312512e) {
        }
    }

    public void b() {
        AudioPlayRunnable audioPlayRunnable = this.f67481a;
        if (audioPlayRunnable != null) {
            audioPlayRunnable.h();
            QLog.d("AudioDecoder", 4, QZoneJsConstants.METHOD_RECORDER_PAUSE_PLAY);
        }
        BgmAudioPlayRunnable bgmAudioPlayRunnable = this.f67482b;
        if (bgmAudioPlayRunnable != null) {
            bgmAudioPlayRunnable.e();
            QLog.d("AudioDecoder", 4, "bgm pausePlay");
        }
    }

    public void d() {
        AudioPlayRunnable audioPlayRunnable = this.f67481a;
        if (audioPlayRunnable != null) {
            audioPlayRunnable.j();
            QLog.d("AudioDecoder", 4, "repeat");
        }
        BgmAudioPlayRunnable bgmAudioPlayRunnable = this.f67482b;
        if (bgmAudioPlayRunnable != null) {
            bgmAudioPlayRunnable.h();
            QLog.d("AudioDecoder", 4, " bgm repeat");
        }
    }

    public void e() {
        AudioPlayRunnable audioPlayRunnable = this.f67481a;
        if (audioPlayRunnable != null) {
            audioPlayRunnable.k();
            QLog.d("AudioDecoder", 4, "resumePlay");
        }
        BgmAudioPlayRunnable bgmAudioPlayRunnable = this.f67482b;
        if (bgmAudioPlayRunnable != null) {
            bgmAudioPlayRunnable.i();
            QLog.d("AudioDecoder", 4, "bgm resumePlay");
        }
    }

    public void f(long j3) {
        AudioPlayRunnable audioPlayRunnable = this.f67481a;
        if (audioPlayRunnable != null) {
            audioPlayRunnable.l(j3, this.f67484d.f312515h);
            QLog.d("AudioDecoder", 1, "seekTo: ", Long.valueOf(j3));
        } else {
            QLog.d("AudioDecoder", 4, "seekTo failed: " + j3);
        }
    }

    public void g(boolean z16) {
        if (this.f67484d == null) {
            return;
        }
        QLog.d("AudioDecoder", 1, "setMuteAudio: " + z16);
        this.f67484d.f312512e = z16;
    }

    public void h(long j3, long j16) {
        b bVar = this.f67484d;
        if (bVar == null) {
            QLog.w("AudioDecoder", 4, "you must start play first");
            return;
        }
        if (j3 == bVar.f312513f && j16 == bVar.f312514g) {
            c.v("AudioDecoder", "segment not changed, setPlayRange ignore, startTimeMs=%d, endTimeMs=%d", Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        QLog.d("AudioDecoder", 4, "setPlayRange begin startTimeMs=" + j3 + " endTimeMs=" + j16);
        b bVar2 = this.f67484d;
        bVar2.f312513f = j3;
        bVar2.f312514g = j16;
        j(bVar2);
    }

    public void i(int i3) {
        b bVar = this.f67484d;
        if (bVar != null) {
            bVar.f312511d = i3;
            QLog.d("AudioDecoder", 4, "setSpeedType:" + i3);
        }
    }

    public synchronized void j(b bVar) {
        QLog.d("AudioDecoder", 4, "startPlay " + bVar.toString());
        b();
        k();
        if (this.f67484d == null) {
            this.f67484d = new b();
        }
        this.f67484d.a(bVar);
        b bVar2 = this.f67484d;
        if (bVar2.f312514g == 0) {
            bVar2.f312514g = bVar2.f312515h;
        }
        float f16 = (float) bVar2.f312513f;
        long j3 = bVar2.f312515h;
        float f17 = f16 / ((float) j3);
        float f18 = ((float) bVar2.f312514g) / ((float) j3);
        if (f17 < 0.0f) {
            f17 = 0.0f;
        }
        if (f18 == 0.0f || f18 > 1.0f) {
            f18 = 1.0f;
        }
        AudioPlayRunnable audioPlayRunnable = new AudioPlayRunnable(f17, f18);
        this.f67481a = audioPlayRunnable;
        Thread newFreeThread = ThreadManagerV2.newFreeThread(audioPlayRunnable, "AudioPlay", 8);
        this.f67483c = newFreeThread;
        newFreeThread.start();
        if (!TextUtils.isEmpty(bVar.f312516i)) {
            BgmAudioPlayRunnable bgmAudioPlayRunnable = new BgmAudioPlayRunnable();
            this.f67482b = bgmAudioPlayRunnable;
            Thread newFreeThread2 = ThreadManagerV2.newFreeThread(bgmAudioPlayRunnable, "BgmPlay", 8);
            this.f67485e = newFreeThread2;
            newFreeThread2.start();
        }
    }

    public void k() {
        Thread thread = this.f67483c;
        if (thread != null) {
            thread.interrupt();
            this.f67483c = null;
            this.f67481a.I = true;
            QLog.d("AudioDecoder", 4, "stopAudio");
        }
        Thread thread2 = this.f67485e;
        if (thread2 != null) {
            thread2.interrupt();
            this.f67485e = null;
            BgmAudioPlayRunnable bgmAudioPlayRunnable = this.f67482b;
            if (bgmAudioPlayRunnable != null) {
                bgmAudioPlayRunnable.stop();
            }
            QLog.d("AudioDecoder", 4, "bgm stopAudio");
        }
    }
}
