package com.tencent.aelight.camera.aioeditor.takevideo.localmedia.demos;

import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeoutException;
import org.junit.Assert;

/* compiled from: P */
/* loaded from: classes32.dex */
public class MediaCodecThumbnailGenerator {

    /* renamed from: a, reason: collision with root package name */
    public CodecHandler f68716a;

    /* renamed from: b, reason: collision with root package name */
    public Handler f68717b;

    /* renamed from: c, reason: collision with root package name */
    public HandlerThread f68718c = new BaseHandlerThread("MediaCodecThumbnailGenerator");

    /* renamed from: d, reason: collision with root package name */
    private long f68719d = 0;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f68728a;

        /* renamed from: b, reason: collision with root package name */
        public String f68729b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f68730c = false;

        /* renamed from: d, reason: collision with root package name */
        public int f68731d;

        /* renamed from: e, reason: collision with root package name */
        public int f68732e;

        /* renamed from: f, reason: collision with root package name */
        public int f68733f;

        /* renamed from: g, reason: collision with root package name */
        public int f68734g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f68735h;

        /* renamed from: i, reason: collision with root package name */
        public bs.a<Boolean, b> f68736i;

        /* renamed from: j, reason: collision with root package name */
        public bs.a<Boolean, c> f68737j;
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f68738a;

        /* renamed from: b, reason: collision with root package name */
        public Bitmap f68739b;

        /* renamed from: c, reason: collision with root package name */
        public String f68740c;

        /* renamed from: d, reason: collision with root package name */
        public long f68741d = -1;
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public List<String> f68742a;

        /* renamed from: b, reason: collision with root package name */
        public List<Bitmap> f68743b;

        /* renamed from: c, reason: collision with root package name */
        public int f68744c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f68745d = false;
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public int f68746a;

        /* renamed from: b, reason: collision with root package name */
        public MediaCodec f68747b;

        /* renamed from: c, reason: collision with root package name */
        public ds.a f68748c;

        /* renamed from: d, reason: collision with root package name */
        public MediaExtractor f68749d;

        /* renamed from: f, reason: collision with root package name */
        public int f68751f;

        /* renamed from: g, reason: collision with root package name */
        public int f68752g;

        /* renamed from: i, reason: collision with root package name */
        public long[] f68754i;

        /* renamed from: j, reason: collision with root package name */
        public long[] f68755j;

        /* renamed from: k, reason: collision with root package name */
        public a f68756k;

        /* renamed from: e, reason: collision with root package name */
        public int f68750e = 0;

        /* renamed from: h, reason: collision with root package name */
        public long f68753h = 0;

        /* renamed from: l, reason: collision with root package name */
        public long f68757l = 0;

        /* renamed from: m, reason: collision with root package name */
        public boolean f68758m = false;

        /* renamed from: n, reason: collision with root package name */
        public ArrayList<String> f68759n = new ArrayList<>();

        /* renamed from: o, reason: collision with root package name */
        public ArrayList<Bitmap> f68760o = new ArrayList<>();
    }

    public static float c(Bitmap bitmap) {
        int height = bitmap.getHeight() / 16;
        int width = bitmap.getWidth() / 9;
        int i3 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < bitmap.getHeight(); i17 += height) {
            for (int i18 = 0; i18 < bitmap.getWidth(); i18 += width) {
                int pixel = bitmap.getPixel(i18, i17);
                int i19 = (pixel >> 16) & 255;
                int i26 = (pixel >> 8) & 255;
                int i27 = pixel & 255;
                if (i19 >= 10 || i26 >= 10 || i27 >= 10) {
                    i16++;
                } else {
                    i3++;
                }
            }
        }
        float f16 = i3 / (i16 + i3);
        hd0.c.k("MediaCodecThumbnailGen", "whitePixelCount = " + i16 + " blackPixelCount = " + i3);
        return f16;
    }

    public void b(String str, String str2, boolean z16, int i3, int i16, int i17, int i18, boolean z17, bs.a<Boolean, c> aVar, bs.a<Boolean, b> aVar2) {
        a aVar3 = new a();
        aVar3.f68728a = str;
        aVar3.f68729b = str2;
        aVar3.f68730c = z16;
        aVar3.f68731d = i3;
        aVar3.f68732e = i16;
        aVar3.f68733f = i17;
        aVar3.f68734g = i18;
        aVar3.f68735h = z17;
        aVar3.f68737j = aVar;
        aVar3.f68736i = aVar2;
        this.f68719d = System.currentTimeMillis();
        Message.obtain(this.f68716a, 1, aVar3).sendToTarget();
    }

    public void d(Looper looper) {
        this.f68718c.start();
        this.f68716a = new CodecHandler(this.f68718c.getLooper());
        if (looper == null) {
            looper = Looper.myLooper();
        }
        this.f68717b = new Handler(looper);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class CodecHandler extends Handler {
        public CodecHandler(Looper looper) {
            super(looper);
        }

        private void b(final d dVar, boolean z16) {
            float f16;
            BufferedOutputStream bufferedOutputStream;
            ds.a aVar = dVar.f68748c;
            a aVar2 = dVar.f68756k;
            int i3 = dVar.f68752g;
            ArrayList<String> arrayList = dVar.f68759n;
            ArrayList<Bitmap> arrayList2 = dVar.f68760o;
            try {
                aVar.a();
                aVar.j();
                aVar.c(false);
                final b bVar = new b();
                Bitmap e16 = aVar.e();
                if (e16 != null) {
                    int i16 = dVar.f68750e;
                    if ((i16 % 180 > 0 && e16.getWidth() < e16.getHeight()) || (dVar.f68750e % 180 == 0 && e16.getWidth() > e16.getHeight())) {
                        i16 += 90;
                    }
                    if (i16 > 0) {
                        Bitmap p16 = UIUtils.p(e16, i16);
                        e16.recycle();
                        e16 = p16;
                    }
                    arrayList2.add(e16);
                    if (z16) {
                        File file = new File(aVar2.f68729b, String.format(Locale.getDefault(), d(i3), new Object[0]));
                        BufferedOutputStream bufferedOutputStream2 = null;
                        try {
                            try {
                                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                            } catch (Throwable th5) {
                                th = th5;
                            }
                            try {
                                e16.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream);
                                bufferedOutputStream.close();
                                arrayList.add(file.getAbsolutePath());
                                bVar.f68740c = file.getAbsolutePath();
                                hd0.c.k("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() add: " + file.getPath());
                            } catch (Throwable th6) {
                                th = th6;
                                bufferedOutputStream2 = bufferedOutputStream;
                                if (bufferedOutputStream2 != null) {
                                    bufferedOutputStream2.close();
                                }
                                throw th;
                            }
                        } catch (IOException e17) {
                            hd0.c.h("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() error ", e17);
                        }
                    }
                }
                int i17 = dVar.f68752g;
                bVar.f68738a = i17;
                bVar.f68739b = e16;
                if (aVar2.f68735h && i17 == 0) {
                    f16 = MediaCodecThumbnailGenerator.c(e16);
                    hd0.c.k("MediaCodecThumbnailGen", "blackRegionPrecent = " + f16);
                    bVar.f68741d = dVar.f68755j[dVar.f68752g];
                } else {
                    f16 = 0.0f;
                }
                if (f16 >= 0.9f) {
                    long j3 = bVar.f68741d;
                    if (j3 <= 500000 && j3 + JsonGrayBusiId.UI_RESERVE_100000_110000 <= dVar.f68757l) {
                        long[] jArr = dVar.f68755j;
                        int i18 = dVar.f68752g;
                        jArr[i18] = jArr[i18] + 50000;
                        obtainMessage(2, dVar).sendToTarget();
                        return;
                    }
                }
                arrayList.add(bVar.f68740c);
                arrayList2.add(e16);
                dVar.f68758m = f16 < 0.9f;
                MediaCodecThumbnailGenerator.this.f68717b.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.localmedia.demos.MediaCodecThumbnailGenerator.CodecHandler.2
                    @Override // java.lang.Runnable
                    public void run() {
                        bs.a<Boolean, b> aVar3 = dVar.f68756k.f68736i;
                        if (aVar3 != null) {
                            aVar3.call(Boolean.TRUE, bVar);
                        }
                    }
                });
                dVar.f68752g++;
                obtainMessage(2, dVar).sendToTarget();
            } catch (TimeoutException unused) {
                sendMessageDelayed(obtainMessage(3, dVar), 100L);
                Log.e("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() timeout delay 100ms");
            }
        }

        private void c(final d dVar) {
            Log.e("MediaCodecThumbnailGen", "finishCapture");
            final boolean z16 = dVar.f68746a == 0;
            ds.a aVar = dVar.f68748c;
            if (aVar != null) {
                aVar.h();
                dVar.f68748c = null;
            }
            MediaCodec mediaCodec = dVar.f68747b;
            if (mediaCodec != null) {
                mediaCodec.stop();
                dVar.f68747b.release();
                dVar.f68747b = null;
            }
            MediaExtractor mediaExtractor = dVar.f68749d;
            if (mediaExtractor != null) {
                mediaExtractor.release();
                dVar.f68749d = null;
            }
            final c cVar = new c();
            cVar.f68742a = Collections.unmodifiableList(dVar.f68759n);
            cVar.f68743b = Collections.unmodifiableList(dVar.f68760o);
            cVar.f68744c = dVar.f68746a;
            if (z16) {
                cVar.f68745d = true ^ dVar.f68758m;
                hd0.c.k("MediaCodecThumbnailGen", "hasBlackThumbnail = " + cVar.f68745d);
                id0.a.r("actBlackThumbnailVideo", cVar.f68745d, System.currentTimeMillis() - MediaCodecThumbnailGenerator.this.f68719d, new String[0]);
            }
            MediaCodecThumbnailGenerator.this.f68717b.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.localmedia.demos.MediaCodecThumbnailGenerator.CodecHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    bs.a<Boolean, c> aVar2 = dVar.f68756k.f68737j;
                    if (aVar2 != null) {
                        aVar2.call(Boolean.valueOf(z16), cVar);
                    }
                }
            });
        }

        private void e(a aVar) {
            d dVar = new d();
            dVar.f68756k = aVar;
            dVar.f68757l = nr.a.e(aVar.f68728a) * 1000;
            try {
                File file = new File(aVar.f68728a);
                if (file.canRead()) {
                    MediaExtractor mediaExtractor = new MediaExtractor();
                    mediaExtractor.setDataSource(file.toString());
                    int a16 = cs.a.a(mediaExtractor);
                    if (a16 >= 0) {
                        mediaExtractor.selectTrack(a16);
                        int i3 = aVar.f68732e;
                        int i16 = aVar.f68734g;
                        long[] jArr = new long[i16];
                        long[] jArr2 = new long[i16];
                        for (int i17 = 0; i17 < aVar.f68734g; i17++) {
                            long j3 = i3 * 1000;
                            mediaExtractor.seekTo(j3, 0);
                            jArr2[i17] = j3;
                            jArr[i17] = mediaExtractor.getSampleTime();
                            i3 += aVar.f68733f;
                        }
                        mediaExtractor.seekTo(jArr[0], 0);
                        MediaFormat trackFormat = mediaExtractor.getTrackFormat(a16);
                        if (trackFormat.containsKey("rotation-degrees")) {
                            try {
                                dVar.f68750e = trackFormat.getInteger("rotation-degrees");
                            } catch (NullPointerException unused) {
                            }
                        } else {
                            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                            mediaMetadataRetriever.setDataSource(dVar.f68756k.f68728a);
                            try {
                                dVar.f68750e = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
                            } catch (NumberFormatException unused2) {
                            }
                            mediaMetadataRetriever.release();
                        }
                        int integer = trackFormat.getInteger("height");
                        int integer2 = trackFormat.getInteger("width");
                        Log.d("MediaCodecThumbnailGen", "Video size is " + integer2 + HippyTKDListViewAdapter.X + integer);
                        float max = (((float) aVar.f68731d) * 1.0f) / ((float) Math.max(integer, integer2));
                        ds.a aVar2 = new ds.a((int) (((float) integer2) * max), (int) (((float) integer) * max));
                        MediaCodec createDecoderByType = MediaCodec.createDecoderByType(trackFormat.getString("mime"));
                        createDecoderByType.configure(trackFormat, aVar2.f(), (MediaCrypto) null, 0);
                        createDecoderByType.start();
                        dVar.f68749d = mediaExtractor;
                        dVar.f68748c = aVar2;
                        dVar.f68747b = createDecoderByType;
                        dVar.f68751f = a16;
                        dVar.f68746a = 0;
                        dVar.f68752g = 0;
                        dVar.f68754i = jArr;
                        dVar.f68755j = jArr2;
                        obtainMessage(2, dVar).sendToTarget();
                        return;
                    }
                    throw new RuntimeException("No video track found in " + file);
                }
                throw new FileNotFoundException("Unable to read " + file);
            } catch (Exception e16) {
                Log.e("MediaCodecThumbnailGen", "startCaptureThumbnails Error!", e16);
                if (e16 instanceof IllegalArgumentException) {
                    dVar.f68746a = 100;
                } else if (e16 instanceof RuntimeException) {
                    dVar.f68746a = 101;
                } else {
                    dVar.f68746a = -1;
                }
                hd0.c.h("MediaCodecThumbnailGen", "Error when generate thumbnail", e16);
                obtainMessage(4, dVar).sendToTarget();
            }
        }

        public String d(int i3) {
            return String.format(Locale.getDefault(), "thumbnail-%d.jpg", Integer.valueOf(i3));
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 1) {
                a aVar = (a) message.obj;
                hd0.c.k("MediaCodecThumbnailGen", "startCaptureThumbnails");
                e(aVar);
            } else if (i3 == 2) {
                d dVar = (d) message.obj;
                hd0.c.k("MediaCodecThumbnailGen", "decodeThumbnails");
                a(dVar);
            } else if (i3 == 3) {
                d dVar2 = (d) message.obj;
                hd0.c.k("MediaCodecThumbnailGen", "dumpThumbnailSurfaces");
                b(dVar2, false);
            } else if (i3 == 4) {
                d dVar3 = (d) message.obj;
                hd0.c.k("MediaCodecThumbnailGen", "finishCapture");
                c(dVar3);
            }
            super.handleMessage(message);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0155 A[Catch: IllegalStateException -> 0x0225, TryCatch #0 {IllegalStateException -> 0x0225, blocks: (B:3:0x0007, B:5:0x002b, B:7:0x002f, B:11:0x003b, B:13:0x0066, B:15:0x006e, B:17:0x0077, B:20:0x0155, B:22:0x015e, B:27:0x0169, B:31:0x0174, B:34:0x0190, B:36:0x01a6, B:38:0x01d2, B:39:0x01da, B:42:0x01e4, B:45:0x01e9, B:47:0x0213, B:50:0x021c, B:55:0x00a5, B:57:0x00b8, B:58:0x00da, B:59:0x012f), top: B:2:0x0007 }] */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0200 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void a(d dVar) {
            boolean z16;
            MediaCodec.BufferInfo bufferInfo;
            int i3;
            int i16;
            long[] jArr;
            a aVar;
            MediaCodec.BufferInfo bufferInfo2;
            boolean z17;
            int i17;
            try {
                MediaExtractor mediaExtractor = dVar.f68749d;
                MediaCodec mediaCodec = dVar.f68747b;
                a aVar2 = dVar.f68756k;
                long[] jArr2 = dVar.f68754i;
                long[] jArr3 = dVar.f68755j;
                int i18 = dVar.f68751f;
                int i19 = dVar.f68752g;
                long sampleTime = mediaExtractor.getSampleTime();
                ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
                MediaCodec.BufferInfo bufferInfo3 = new MediaCodec.BufferInfo();
                long j3 = sampleTime;
                int i26 = 0;
                boolean z18 = false;
                boolean z19 = false;
                while (!z18 && i19 < aVar2.f68734g) {
                    long j16 = dVar.f68753h;
                    long j17 = jArr2[i19];
                    if (j16 == j17 || j3 >= j17) {
                        bufferInfo = bufferInfo3;
                    } else {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("SeekTo: ");
                        bufferInfo = bufferInfo3;
                        sb5.append(jArr2[i19]);
                        Log.e("MediaCodecThumbnailGen", sb5.toString());
                        mediaExtractor.seekTo(jArr2[i19], 0);
                        dVar.f68753h = jArr2[i19];
                        mediaCodec.flush();
                    }
                    if (z19) {
                        i3 = i26;
                        i16 = i18;
                        jArr = jArr3;
                        aVar = aVar2;
                        bufferInfo2 = bufferInfo;
                        z17 = false;
                        i17 = i19;
                    } else {
                        int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(-1L);
                        if (dequeueInputBuffer >= 0) {
                            int readSampleData = mediaExtractor.readSampleData(inputBuffers[dequeueInputBuffer], 0);
                            if (readSampleData < 0) {
                                z17 = false;
                                MediaCodec.BufferInfo bufferInfo4 = bufferInfo;
                                i17 = i19;
                                jArr = jArr3;
                                mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                                Log.d("MediaCodecThumbnailGen", "sent input EOS");
                                i26 = i26;
                                i16 = i18;
                                z19 = true;
                                aVar = aVar2;
                                bufferInfo2 = bufferInfo4;
                            } else {
                                int i27 = i26;
                                z17 = false;
                                int i28 = i18;
                                jArr = jArr3;
                                MediaCodec.BufferInfo bufferInfo5 = bufferInfo;
                                i17 = i19;
                                if (mediaExtractor.getSampleTrackIndex() != i28) {
                                    Log.w("MediaCodecThumbnailGen", "WEIRD: got sample from track " + mediaExtractor.getSampleTrackIndex() + ", expected " + i28);
                                }
                                i16 = i28;
                                aVar = aVar2;
                                bufferInfo2 = bufferInfo5;
                                mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, mediaExtractor.getSampleTime(), 0);
                                Log.d("MediaCodecThumbnailGen", "submitted frame " + i27 + " to dec, size=" + readSampleData);
                                i26 = i27 + 1;
                                long sampleTime2 = mediaExtractor.getSampleTime();
                                Log.d("MediaCodecThumbnailGen", "extractor sample time = " + sampleTime2);
                                mediaExtractor.advance();
                                j3 = sampleTime2;
                            }
                            long j18 = j3;
                            if (!z18) {
                                int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo2, 10000L);
                                if (dequeueOutputBuffer == -1) {
                                    Log.d("MediaCodecThumbnailGen", "no output from decoder available");
                                } else if (dequeueOutputBuffer == -3) {
                                    Log.d("MediaCodecThumbnailGen", "decoder output buffers changed");
                                } else if (dequeueOutputBuffer == -2) {
                                    Log.d("MediaCodecThumbnailGen", "decoder output format changed: " + mediaCodec.getOutputFormat());
                                } else if (dequeueOutputBuffer < 0) {
                                    Assert.fail("unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                                } else {
                                    Log.d("MediaCodecThumbnailGen", "surface decoder given buffer " + dequeueOutputBuffer + " (size=" + bufferInfo2.size + ")");
                                    if ((bufferInfo2.flags & 4) != 0) {
                                        Log.d("MediaCodecThumbnailGen", "output EOS");
                                        z18 = true;
                                    }
                                    boolean z26 = j18 > jArr[i17] ? true : z17;
                                    mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, z26);
                                    if (z26) {
                                        Log.d("MediaCodecThumbnailGen", "awaiting decode of time: " + j18);
                                        z16 = true;
                                        break;
                                    }
                                }
                            }
                            j3 = j18;
                            bufferInfo3 = bufferInfo2;
                            i19 = i17;
                            jArr3 = jArr;
                            i18 = i16;
                            aVar2 = aVar;
                        } else {
                            i3 = i26;
                            i16 = i18;
                            jArr = jArr3;
                            aVar = aVar2;
                            bufferInfo2 = bufferInfo;
                            z17 = false;
                            i17 = i19;
                            Log.d("MediaCodecThumbnailGen", "input buffer not available");
                        }
                    }
                    i26 = i3;
                    long j182 = j3;
                    if (!z18) {
                    }
                    j3 = j182;
                    bufferInfo3 = bufferInfo2;
                    i19 = i17;
                    jArr3 = jArr;
                    i18 = i16;
                    aVar2 = aVar;
                }
                z16 = false;
                if (!z16) {
                    obtainMessage(4, dVar).sendToTarget();
                } else {
                    obtainMessage(3, dVar).sendToTarget();
                }
            } catch (IllegalStateException e16) {
                QLog.e("MediaCodecThumbnailGen", 1, "decodeThumbnails fail", e16);
                obtainMessage(4, dVar).sendToTarget();
            }
        }
    }
}
