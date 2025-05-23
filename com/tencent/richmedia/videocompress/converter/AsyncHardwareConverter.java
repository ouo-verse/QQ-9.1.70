package com.tencent.richmedia.videocompress.converter;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import android.os.Build;
import android.os.Handler;
import android.util.Pair;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.richmedia.videocompress.VideoConverter;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import com.tencent.richmedia.videocompress.VideoConverterConstant;
import com.tencent.richmedia.videocompress.mediacodec.InputSurface;
import com.tencent.richmedia.videocompress.mediacodec.MediaCodecUtil;
import com.tencent.richmedia.videocompress.mediacodec.OutputSurface;
import com.tencent.richmedia.videocompress.strategy.MediaCodecSupport;
import com.tencent.richmedia.videocompress.utils.ConvertLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
@RequiresApi(api = 21)
/* loaded from: classes25.dex */
public class AsyncHardwareConverter implements IHardwareConverter {

    /* renamed from: a0, reason: collision with root package name */
    private static boolean f365103a0 = false;
    private MediaCodec C;
    private MediaCodec D;
    private OutputSurface E;
    private InputSurface F;
    private Surface G;
    private MediaMuxer H;
    private boolean I;
    private final c J;
    private boolean L;
    private boolean M;
    private boolean N;
    private int P;
    private int Q;
    private final b X;
    private boolean Y;

    /* renamed from: f, reason: collision with root package name */
    private final VideoConverter.Processor f365106f;

    /* renamed from: h, reason: collision with root package name */
    private final String f365107h;

    /* renamed from: i, reason: collision with root package name */
    private MediaExtractor f365108i;

    /* renamed from: m, reason: collision with root package name */
    private MediaExtractor f365109m;

    /* renamed from: d, reason: collision with root package name */
    private String f365104d = MediaCodecSupport.AVC_CODEC_MIME;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f365105e = false;
    private final com.tencent.richmedia.videocompress.mediacodec.a K = new com.tencent.richmedia.videocompress.mediacodec.a();
    private int R = 3;
    private int S = 0;
    private long T = -1;
    private long U = 0;
    private boolean V = true;
    private boolean W = false;
    private final com.tencent.richmedia.videocompress.a Z = new com.tencent.richmedia.videocompress.a();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private long f365110a;

        /* renamed from: b, reason: collision with root package name */
        private long f365111b;

        /* renamed from: c, reason: collision with root package name */
        private long f365112c;

        /* renamed from: d, reason: collision with root package name */
        private int f365113d;

        /* renamed from: e, reason: collision with root package name */
        private int f365114e;

        /* renamed from: f, reason: collision with root package name */
        private MediaFormat f365115f;

        /* renamed from: g, reason: collision with root package name */
        private MediaFormat f365116g;

        /* renamed from: h, reason: collision with root package name */
        private long f365117h;

        /* renamed from: i, reason: collision with root package name */
        private int f365118i;

        /* renamed from: j, reason: collision with root package name */
        private int f365119j;

        b() {
            this.f365112c = -1L;
            this.f365113d = -1;
            this.f365114e = -1;
            this.f365117h = 0L;
            this.f365118i = 0;
            this.f365119j = 0;
        }

        static /* synthetic */ int p(b bVar) {
            int i3 = bVar.f365119j;
            bVar.f365119j = i3 + 1;
            return i3;
        }

        static /* synthetic */ long s(b bVar, long j3) {
            long j16 = bVar.f365117h + j3;
            bVar.f365117h = j16;
            return j16;
        }

        static /* synthetic */ int u(b bVar) {
            int i3 = bVar.f365118i;
            bVar.f365118i = i3 + 1;
            return i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class c extends MediaCodec.Callback {

        /* renamed from: a, reason: collision with root package name */
        private volatile Exception f365120a;

        c() {
        }

        public Exception a() {
            return this.f365120a;
        }

        public boolean b() {
            if (this.f365120a != null) {
                return true;
            }
            return false;
        }

        @Override // android.media.MediaCodec.Callback
        public void onError(@NonNull MediaCodec mediaCodec, @NonNull MediaCodec.CodecException codecException) {
            ConvertLog.e("AsyncHardwareConverter", 1, "Received media codec error : " + codecException.getMessage());
            this.f365120a = codecException;
        }

        @Override // android.media.MediaCodec.Callback
        public void onInputBufferAvailable(@NonNull MediaCodec mediaCodec, int i3) {
            if (ConvertLog.isDevLevel()) {
                ConvertLog.i("AsyncHardwareConverter", 3, "onInputBufferAvailable start. codec = ", mediaCodec.getName(), ", ", Thread.currentThread().getName());
            }
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputBufferAvailable(@NonNull MediaCodec mediaCodec, int i3, @NonNull MediaCodec.BufferInfo bufferInfo) {
            if (ConvertLog.isDevLevel()) {
                ConvertLog.i("AsyncHardwareConverter", 3, "onOutputBufferAvailable start. codec = ", mediaCodec.getName(), ", ", Thread.currentThread().getName());
            }
            synchronized (AsyncHardwareConverter.this.D) {
                if (!AsyncHardwareConverter.this.f365105e) {
                    AsyncHardwareConverter.this.h(i3, bufferInfo);
                }
            }
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputFormatChanged(@NonNull MediaCodec mediaCodec, @NonNull MediaFormat mediaFormat) {
            if (ConvertLog.isColorLevel()) {
                ConvertLog.d("AsyncHardwareConverter", 2, "Output format changed: " + mediaFormat.toString(), ",  codec = ", mediaCodec.getName());
            }
        }
    }

    public AsyncHardwareConverter(String str, VideoConverter.Processor processor) {
        this.J = new c();
        this.X = new b();
        this.f365107h = str;
        this.f365106f = processor;
    }

    private void e() {
        if (this.V) {
            b bVar = this.X;
            MediaExtractor mediaExtractor = this.f365109m;
            bVar.f365115f = mediaExtractor.getTrackFormat(mediaExtractor.getSampleTrackIndex());
            b bVar2 = this.X;
            bVar2.f365113d = this.H.addTrack(bVar2.f365115f);
            if (ConvertLog.isColorLevel()) {
                ConvertLog.d("AsyncHardwareConverter", 2, "muxer: adding audio track.");
            }
        }
        this.X.f365116g = this.D.getOutputFormat();
        b bVar3 = this.X;
        bVar3.f365114e = this.H.addTrack(bVar3.f365116g);
        if (ConvertLog.isColorLevel()) {
            ConvertLog.d("AsyncHardwareConverter", 2, "muxer: adding video track.");
        }
        this.H.start();
        this.I = true;
    }

    private Pair<Integer, Exception> f() {
        Pair<Integer, Exception> create;
        try {
            try {
                try {
                    this.f365106f.onProgress(0);
                    if (!o(this.f365107h, this.f365106f)) {
                        Exception exc = new Exception(VideoConverterConstant.KEY_NO_NEED_COMPRESS);
                        ConvertLog.e("AsyncHardwareConverter", 1, "Converter run error", exc);
                        Pair.create(2, exc);
                    }
                    i();
                    if (this.K.d()) {
                        create = Pair.create(2, this.K.a());
                    } else if (this.J.b()) {
                        create = Pair.create(2, this.J.a());
                    } else if (this.Y) {
                        this.Y = false;
                        create = Pair.create(1, null);
                    } else {
                        this.f365106f.onProgress(10000);
                        create = Pair.create(0, null);
                    }
                    t();
                } catch (Exception e16) {
                    ConvertLog.e("AsyncHardwareConverter", 1, "Converter run error", e16);
                    create = Pair.create(2, e16);
                    t();
                }
                return create;
            } catch (Throwable th5) {
                try {
                    t();
                } catch (Exception e17) {
                    ConvertLog.e("AsyncHardwareConverter", 1, "release Hw Resource error", e17);
                    Pair.create(2, e17);
                }
                throw th5;
            }
        } catch (Exception e18) {
            ConvertLog.e("AsyncHardwareConverter", 1, "release Hw Resource error", e18);
            return Pair.create(2, e18);
        }
    }

    private void g(int i3, MediaCodec.BufferInfo bufferInfo) {
        boolean z16;
        OutputSurface outputSurface;
        if ((bufferInfo.flags & 4) != 0) {
            this.M = true;
            this.D.signalEndOfInputStream();
        }
        if (bufferInfo.size > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.U > 0) {
            b.p(this.X);
            if (this.M || bufferInfo.presentationTimeUs >= this.X.f365117h) {
                long j3 = this.X.f365117h;
                long j16 = this.U;
                long j17 = j3 + j16;
                long j18 = bufferInfo.presentationTimeUs;
                if (j17 < j18) {
                    this.X.f365117h = j18 + j16;
                } else {
                    b.s(this.X, j16);
                }
            } else {
                b.u(this.X);
                z16 = false;
            }
            if (this.M && ConvertLog.isDevLevel()) {
                ConvertLog.d("AsyncHardwareConverter", 2, "video decoder: EOS, skip frame " + this.X.f365118i + "/" + this.X.f365119j);
            }
        }
        if (ConvertLog.isDevLevel()) {
            ConvertLog.i("AsyncHardwareConverter", 2, "[dequeueDecoderOutput] releaseOutputBuffer. doRender = ", Boolean.valueOf(z16), ", info.size = ", Integer.valueOf(bufferInfo.size));
        }
        this.C.releaseOutputBuffer(i3, z16);
        if (z16) {
            if (this.F != null && (outputSurface = this.E) != null) {
                outputSurface.awaitNewImage();
                this.E.drawImage();
                this.F.setPresentationTime(bufferInfo.presentationTimeUs * 1000);
                this.F.swapBuffers();
            }
            if (this.X.f365112c < 0) {
                this.X.f365112c = bufferInfo.presentationTimeUs;
            }
            if ((bufferInfo.flags & 2) == 0) {
                this.P++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i3, MediaCodec.BufferInfo bufferInfo) {
        if (!m() && !this.N) {
            if ((bufferInfo.flags & 4) != 0) {
                this.N = true;
            }
            if (bufferInfo.size > 0) {
                ByteBuffer outputBuffer = this.D.getOutputBuffer(i3);
                if (this.H != null) {
                    if (this.X.f365116g == null) {
                        e();
                    }
                    this.H.writeSampleData(this.X.f365114e, outputBuffer, bufferInfo);
                    this.X.f365111b = bufferInfo.presentationTimeUs;
                    this.f365106f.onProgress((int) ((((float) (bufferInfo.presentationTimeUs - this.X.f365112c)) / ((float) this.T)) * 10000.0f));
                }
                if ((bufferInfo.flags & 2) == 0) {
                    this.Q++;
                }
            }
            this.D.releaseOutputBuffer(i3, false);
            return;
        }
        if (ConvertLog.isDevLevel()) {
            ConvertLog.i("AsyncHardwareConverter", 3, "dequeueEncoderOutput return");
        }
    }

    private void i() throws Exception {
        boolean z16;
        boolean z17 = !this.V;
        ByteBuffer byteBuffer = null;
        while (true) {
            if (this.N && z17) {
                ConvertLog.d("AsyncHardwareConverter", 1, "Convert video completed!");
                return;
            }
            boolean interrupted = Thread.interrupted();
            this.Y = interrupted;
            if (interrupted) {
                ConvertLog.e("AsyncHardwareConverter", 1, "doExtractDecodeEditEncodeMux Interrupted");
                return;
            }
            if (m()) {
                ConvertLog.e("AsyncHardwareConverter", 1, "doExtractDecodeEditEncodeMux hasSeenError!");
                return;
            }
            if (this.V && !z17 && this.I) {
                if (byteBuffer == null) {
                    byteBuffer = ByteBuffer.allocate(262144);
                }
                z17 = s(byteBuffer);
            }
            if (this.X.f365111b - this.X.f365110a > 0 && !z17) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (ConvertLog.isDevLevel()) {
                ConvertLog.i("AsyncHardwareConverter", 3, "lastAudioWriteTimestamp:" + this.X.f365110a + " lastVideoWriteTimestamp:" + this.X.f365111b + " audioExtractorDone:" + z17 + " mCopyAudio:" + this.V + " processVideo:" + z16);
            }
            if (z16) {
                if (!this.L) {
                    if (ConvertLog.isDevLevel()) {
                        ConvertLog.i("AsyncHardwareConverter", 3, "do work. !mSawDecInputEOS = true");
                    }
                    Pair<Integer, MediaCodec.BufferInfo> c16 = this.K.c();
                    if (c16 != null) {
                        int intValue = ((Integer) c16.first).intValue();
                        MediaCodec.BufferInfo bufferInfo = (MediaCodec.BufferInfo) c16.second;
                        if (bufferInfo != null) {
                            g(intValue, bufferInfo);
                        } else {
                            k(intValue);
                        }
                    }
                    if (ConvertLog.isDevLevel()) {
                        ConvertLog.i("AsyncHardwareConverter", 2, "mDecOutputCount - mEncOutputCount = ", Integer.valueOf(this.P - this.Q));
                    }
                } else if (!this.M) {
                    if (ConvertLog.isDevLevel()) {
                        ConvertLog.i("AsyncHardwareConverter", 3, "queueEOS. !mSawDecOutputEOS = true");
                    }
                    Pair<Integer, MediaCodec.BufferInfo> b16 = this.K.b();
                    if (b16 != null) {
                        g(((Integer) b16.first).intValue(), (MediaCodec.BufferInfo) b16.second);
                    }
                    if (ConvertLog.isDevLevel()) {
                        ConvertLog.i("AsyncHardwareConverter", 2, "mDecOutputCount - mEncOutputCount = ", Integer.valueOf(this.P - this.Q));
                    }
                } else if (!this.N && ConvertLog.isDevLevel()) {
                    ConvertLog.i("AsyncHardwareConverter", 2, "waitForAllEncoderOutputs. !mSawEncOutputEOS = true");
                }
            }
        }
    }

    private void j(int i3) {
        if (!this.L) {
            this.C.queueInputBuffer(i3, 0, 0, 0L, 4);
            this.L = true;
            if (ConvertLog.isDevLevel()) {
                ConvertLog.d("AsyncHardwareConverter", 2, "Queued End of Stream");
            }
        }
    }

    private void k(int i3) {
        int i16;
        int i17 = 0;
        int readSampleData = this.f365108i.readSampleData(this.C.getInputBuffer(i3), 0);
        if (readSampleData < 0) {
            j(i3);
            return;
        }
        long sampleTime = this.f365108i.getSampleTime();
        int sampleFlags = this.f365108i.getSampleFlags();
        if ((sampleFlags & 1) != 0) {
            i17 = 1;
        }
        if ((sampleFlags & 4) != 0) {
            i17 |= 8;
        }
        if (!this.f365108i.advance()) {
            this.L = true;
            i16 = i17 | 4;
        } else {
            i16 = i17;
        }
        this.C.queueInputBuffer(i3, 0, readSampleData, sampleTime, i16);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long[] l(MediaFormat mediaFormat, String str) {
        String str2;
        int parseInt;
        int integer = mediaFormat.getInteger("width");
        int integer2 = mediaFormat.getInteger("height");
        long j3 = mediaFormat.getLong("durationUs");
        int integer3 = mediaFormat.getInteger("frame-rate");
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
            str2 = mediaMetadataRetriever.extractMetadata(24);
        } catch (IllegalArgumentException e16) {
            e16.printStackTrace();
            str2 = null;
        }
        String str3 = str2;
        if (str3 != null) {
            try {
                parseInt = Integer.parseInt(str3);
            } catch (NumberFormatException e17) {
                ConvertLog.e("AsyncHardwareConverter", 1, "Video rotation format error ", e17);
            }
            mediaMetadataRetriever.release();
            if (ConvertLog.isColorLevel()) {
                ConvertLog.d("AsyncHardwareConverter", 2, "Video size is ", Integer.valueOf(integer), HippyTKDListViewAdapter.X, Integer.valueOf(integer2), ", rotation: ", str3);
            }
            return new long[]{integer, integer2, parseInt, j3, integer3};
        }
        parseInt = 0;
        mediaMetadataRetriever.release();
        if (ConvertLog.isColorLevel()) {
        }
        return new long[]{integer, integer2, parseInt, j3, integer3};
    }

    private boolean m() {
        if (!this.K.d() && !this.J.b()) {
            return false;
        }
        return true;
    }

    private boolean n(int i3) {
        if (i3 == 0 && Build.VERSION.SDK_INT >= 27) {
            return false;
        }
        return true;
    }

    private boolean o(String str, VideoConverter.Processor processor) throws IOException {
        int i3;
        int i16;
        MediaCodecInfo selectCodec = MediaCodecUtil.selectCodec(this.f365104d);
        if (selectCodec == null) {
            if (ConvertLog.isColorLevel()) {
                ConvertLog.e("AsyncHardwareConverter", 2, "Unable to find an appropriate codec for " + this.f365104d);
            }
            throw new IOException("Unable to find an appropriate codec for " + this.f365104d);
        }
        if (ConvertLog.isColorLevel()) {
            ConvertLog.d("AsyncHardwareConverter", 2, "Found video codec: " + selectCodec.getName());
        }
        MediaFormat trackFormat = this.f365108i.getTrackFormat(p(str));
        long[] l3 = l(trackFormat, str);
        int i17 = (int) l3[0];
        int i18 = (int) l3[1];
        int i19 = (int) l3[2];
        this.T = l3[3];
        this.S = (int) l3[4];
        VideoConverterConfig encodeConfig = processor.getEncodeConfig(i17, i18);
        if (!encodeConfig.isNeedCompress) {
            if (ConvertLog.isColorLevel()) {
                ConvertLog.d("AsyncHardwareConverter", 2, "compressVideo error, isNeedCompress is false");
            }
            return false;
        }
        this.R = encodeConfig.maxBFrameCount;
        File file = new File(encodeConfig.output);
        if (file.exists()) {
            ConvertLog.i("AsyncHardwareConverter", 1, "compressVideo, output path exists, delete it, path is " + file.getAbsolutePath() + ", delete=" + file.delete());
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            ConvertLog.i("AsyncHardwareConverter", 1, "compressVideo, output directory doesn't exist, path is " + file.getAbsolutePath() + ", mkdir=" + parentFile.mkdirs());
        }
        if (encodeConfig.isMute) {
            this.V = false;
        }
        this.W = encodeConfig.enableRenderWithoutEGL;
        if (!f365103a0 && (i3 = encodeConfig.videoFrameRate) > 0 && (i16 = this.S) > 0 && i16 > i3) {
            this.U = (long) (1000000.0d / i3);
            ConvertLog.i("AsyncHardwareConverter", 1, "compressVideo, frame rate change.");
        }
        r(encodeConfig, i17, i18, i19);
        q(trackFormat);
        MediaMuxer mediaMuxer = new MediaMuxer(encodeConfig.output, 0);
        this.H = mediaMuxer;
        if (encodeConfig.setRotation) {
            mediaMuxer.setOrientationHint(i19);
        }
        return true;
    }

    private int p(String str) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        this.f365109m = mediaExtractor;
        mediaExtractor.setDataSource(str);
        if (MediaCodecUtil.getAndSelectAudioTrackIndex(this.f365109m) < 0) {
            this.V = false;
        }
        MediaExtractor mediaExtractor2 = new MediaExtractor();
        this.f365108i = mediaExtractor2;
        mediaExtractor2.setDataSource(str);
        int andSelectVideoTrackIndex = MediaCodecUtil.getAndSelectVideoTrackIndex(this.f365108i);
        if (andSelectVideoTrackIndex >= 0) {
            return andSelectVideoTrackIndex;
        }
        throw new IOException("No video track found in " + str);
    }

    private void q(MediaFormat mediaFormat) {
        List<MediaCodecInfo> decoderInfoList = MediaCodecUtil.getDecoderInfoList(mediaFormat.getString("mime"), false);
        if (!decoderInfoList.isEmpty()) {
            try {
                MediaCodec createByCodecName = MediaCodec.createByCodecName(decoderInfoList.get(0).getName());
                this.C = createByCodecName;
                createByCodecName.setCallback(this.K);
                if (this.F != null) {
                    OutputSurface outputSurface = new OutputSurface();
                    this.E = outputSurface;
                    this.C.configure(mediaFormat, outputSurface.getSurface(), (MediaCrypto) null, 0);
                } else {
                    this.C.configure(mediaFormat, this.G, (MediaCrypto) null, 0);
                }
                this.C.start();
            } catch (IOException e16) {
                ConvertLog.e("AsyncHardwareConverter", 1, "prepareVideoDecoder error!", e16);
            }
        }
    }

    private void r(VideoConverterConfig videoConverterConfig, int i3, int i16, int i17) {
        if (!videoConverterConfig.setRotation && (i17 == 90 || i17 == 270)) {
            i16 = i3;
            i3 = i16;
        }
        int round = Math.round((i3 * videoConverterConfig.scaleRate) / 16.0f) * 16;
        int round2 = Math.round((i16 * videoConverterConfig.scaleRate) / 16.0f) * 16;
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(this.f365104d, round, round2);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("bitrate", videoConverterConfig.videoBitRate);
        createVideoFormat.setFloat("frame-rate", videoConverterConfig.videoFrameRate);
        createVideoFormat.setInteger("i-frame-interval", videoConverterConfig.iFrameInterval);
        if (videoConverterConfig.setProfileLevel) {
            createVideoFormat.setInteger("profile", videoConverterConfig.profile);
            createVideoFormat.setInteger("level", videoConverterConfig.level);
        }
        videoConverterConfig.bitrateMode = 0;
        if (n(0)) {
            createVideoFormat.setInteger("bitrate-mode", videoConverterConfig.bitrateMode);
        }
        if (ConvertLog.isColorLevel()) {
            ConvertLog.d("AsyncHardwareConverter", 2, "video format: ", createVideoFormat);
        }
        try {
            this.D = MediaCodec.createEncoderByType(this.f365104d);
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("encoder_callback");
            baseHandlerThread.start();
            this.D.setCallback(this.J, new Handler(baseHandlerThread.getLooper()));
            this.D.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
            this.G = this.D.createInputSurface();
            this.D.start();
            if (this.W && round == i3 && round2 == i16) {
                ConvertLog.d("AsyncHardwareConverter", 1, "prepareVideoEncoder, enableRenderWithoutEGL and size not change. ");
                return;
            }
            AtomicReference atomicReference = new AtomicReference();
            atomicReference.set(this.G);
            InputSurface inputSurface = new InputSurface((Surface) atomicReference.get());
            this.F = inputSurface;
            inputSurface.makeCurrent();
        } catch (IOException e16) {
            ConvertLog.e("AsyncHardwareConverter", 1, "prepareVideoEncoder error!", e16);
        }
    }

    private boolean s(ByteBuffer byteBuffer) {
        boolean z16;
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        int readSampleData = this.f365109m.readSampleData(byteBuffer, 0);
        bufferInfo.size = readSampleData;
        if (readSampleData < 0) {
            z16 = true;
        } else {
            bufferInfo.presentationTimeUs = this.f365109m.getSampleTime();
            bufferInfo.flags = this.f365109m.getSampleFlags();
            this.H.writeSampleData(this.X.f365113d, byteBuffer, bufferInfo);
            z16 = !this.f365109m.advance();
            this.X.f365110a = bufferInfo.presentationTimeUs;
            if (ConvertLog.isDevLevel()) {
                ConvertLog.i("AsyncHardwareConverter", 3, "write audio " + this.X.f365110a + " offset" + (this.X.f365111b - this.X.f365110a));
            }
        }
        if (ConvertLog.isDevLevel()) {
            if (z16) {
                ConvertLog.d("AsyncHardwareConverter", 2, "audio extractor: EOS");
            } else {
                ConvertLog.d("AsyncHardwareConverter", 2, "Audio Frame  TrackIndex:" + this.f365109m.getSampleTrackIndex() + " PresentationTimeUs:" + bufferInfo.presentationTimeUs + " Flags:" + bufferInfo.flags + " Size(KB): " + (bufferInfo.size / 1024));
            }
        }
        return z16;
    }

    public static void u(boolean z16) {
        f365103a0 = z16;
    }

    @Override // java.lang.Runnable
    public void run() {
        Pair<Integer, Exception> f16 = f();
        if (f16 == null) {
            this.f365106f.onFail(new Exception("error, can not confirm compress state"));
            return;
        }
        if (((Integer) f16.first).intValue() == 0) {
            this.f365106f.onSuccess();
        } else if (((Integer) f16.first).intValue() == 1) {
            this.f365106f.onCancel();
        } else if (((Integer) f16.first).intValue() == 2) {
            this.f365106f.onFail((Throwable) f16.second);
        }
    }

    @Override // com.tencent.richmedia.videocompress.converter.IHardwareConverter
    public void setOutPutVideoCodecMIMEType(String str) {
        this.f365104d = str;
    }

    protected void t() {
        if (ConvertLog.isColorLevel()) {
            ConvertLog.d("AsyncHardwareConverter", 2, "shutting down encoder, decoder");
        }
        OutputSurface outputSurface = this.E;
        if (outputSurface != null) {
            outputSurface.release();
        }
        InputSurface inputSurface = this.F;
        if (inputSurface != null) {
            inputSurface.release();
        }
        MediaCodec mediaCodec = this.D;
        if (mediaCodec != null) {
            synchronized (mediaCodec) {
                this.D.stop();
                this.D.release();
                this.f365105e = true;
            }
        }
        MediaCodec mediaCodec2 = this.C;
        if (mediaCodec2 != null) {
            mediaCodec2.stop();
            this.C.release();
        }
        MediaMuxer mediaMuxer = this.H;
        if (mediaMuxer != null) {
            mediaMuxer.release();
            this.H = null;
        }
        MediaExtractor mediaExtractor = this.f365108i;
        if (mediaExtractor != null) {
            mediaExtractor.release();
            this.f365108i = null;
        }
        MediaExtractor mediaExtractor2 = this.f365109m;
        if (mediaExtractor2 != null) {
            mediaExtractor2.release();
            this.f365109m = null;
        }
    }
}
