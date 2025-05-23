package com.tencent.mobileqq.stt.util;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d extends MediaCodec.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f290868a;

    /* renamed from: b, reason: collision with root package name */
    private OutputStream f290869b;

    /* renamed from: c, reason: collision with root package name */
    private a f290870c;

    /* renamed from: d, reason: collision with root package name */
    private FileInputStream f290871d;

    /* renamed from: e, reason: collision with root package name */
    private MediaExtractor f290872e;

    /* renamed from: f, reason: collision with root package name */
    private MediaFormat f290873f;

    /* renamed from: g, reason: collision with root package name */
    private MediaCodec f290874g;

    /* renamed from: h, reason: collision with root package name */
    private byte[] f290875h;

    /* renamed from: i, reason: collision with root package name */
    private int f290876i;

    /* renamed from: j, reason: collision with root package name */
    private int f290877j;

    /* renamed from: k, reason: collision with root package name */
    private int f290878k;

    /* renamed from: l, reason: collision with root package name */
    private int f290879l;

    /* renamed from: m, reason: collision with root package name */
    MediaFormat f290880m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        void onComplete(int i3);
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f290876i = 0;
        this.f290877j = 0;
        this.f290878k = 2;
        this.f290879l = 0;
    }

    private void a() {
        MediaCodec mediaCodec = this.f290874g;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.f290874g.release();
            this.f290874g = null;
        }
        MediaExtractor mediaExtractor = this.f290872e;
        if (mediaExtractor != null) {
            mediaExtractor.release();
            this.f290872e = null;
        }
        b(this.f290871d);
        b(this.f290869b);
    }

    private static void b(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e16) {
            l("close EXCEPTION:" + e16);
        }
    }

    private static MediaCodec c(MediaFormat mediaFormat) {
        try {
            MediaCodec createDecoderByType = MediaCodec.createDecoderByType(mediaFormat.getString("mime"));
            createDecoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 0);
            return createDecoderByType;
        } catch (IOException e16) {
            l("fail to create codec, format=" + mediaFormat + ", e=" + e16);
            return null;
        }
    }

    private static MediaExtractor d(FileDescriptor fileDescriptor) {
        try {
            MediaExtractor mediaExtractor = new MediaExtractor();
            mediaExtractor.setDataSource(fileDescriptor);
            return mediaExtractor;
        } catch (IOException e16) {
            l("fail to create media extractor, " + e16);
            return null;
        }
    }

    private void e(int i3) {
        a();
        this.f290870c.onComplete(i3);
    }

    private void f() {
        a();
        this.f290870c.onComplete(0);
    }

    private byte[] i(int i3) {
        byte[] bArr = this.f290875h;
        if (bArr == null || bArr.length < i3) {
            this.f290875h = new byte[i3];
        }
        return this.f290875h;
    }

    private FileDescriptor j(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            this.f290871d = fileInputStream;
            return fileInputStream.getFD();
        } catch (IOException unused) {
            l("failed to get fd, path is " + str);
            return null;
        }
    }

    private static void l(String str) {
        QLog.i("AudioExtractor", 1, str);
    }

    private static MediaFormat m(MediaExtractor mediaExtractor) {
        String string;
        int trackCount = mediaExtractor.getTrackCount();
        for (int i3 = 0; i3 < trackCount; i3++) {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i3);
            if (trackFormat != null && (string = trackFormat.getString("mime")) != null && string.startsWith("audio/")) {
                mediaExtractor.selectTrack(i3);
                return trackFormat;
            }
        }
        return null;
    }

    public MediaFormat g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (MediaFormat) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f290873f;
    }

    public int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        MediaFormat mediaFormat = this.f290873f;
        if (mediaFormat != null) {
            long j3 = mediaFormat.getLong("durationUs");
            if (j3 != 0) {
                return (int) (j3 / 1000);
            }
        }
        return (this.f290879l * 1000) / (this.f290877j * 2);
    }

    public int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f290877j;
    }

    public void n(@NonNull String str, @NonNull OutputStream outputStream, @NonNull a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, outputStream, aVar);
            return;
        }
        this.f290868a = str;
        this.f290869b = outputStream;
        this.f290870c = aVar;
        if (!TextUtils.isEmpty(str) && new File(this.f290868a).exists()) {
            FileDescriptor j3 = j(this.f290868a);
            if (j3 == null) {
                e(2);
                return;
            }
            MediaExtractor d16 = d(j3);
            this.f290872e = d16;
            if (d16 == null) {
                l("fail to create media extractor, path is " + this.f290868a);
                e(3);
                return;
            }
            MediaFormat m3 = m(d16);
            this.f290873f = m3;
            if (m3 == null) {
                l("fail to select audio track, path is " + this.f290868a);
                e(4);
                return;
            }
            MediaCodec c16 = c(m3);
            this.f290874g = c16;
            if (c16 == null) {
                l("fail to create codec, path is " + this.f290868a);
                e(5);
                return;
            }
            c16.setCallback(this);
            this.f290874g.start();
            return;
        }
        l("file not exist, path is " + this.f290868a);
        e(1);
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(@NonNull MediaCodec mediaCodec, @NonNull MediaCodec.CodecException codecException) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) mediaCodec, (Object) codecException);
            return;
        }
        l("onError, " + codecException);
        e(6);
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(@NonNull MediaCodec mediaCodec, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) mediaCodec, i3);
            return;
        }
        int readSampleData = this.f290872e.readSampleData(mediaCodec.getInputBuffer(i3), 0);
        if (readSampleData < 0) {
            mediaCodec.queueInputBuffer(i3, 0, 0, 0L, 4);
        } else {
            mediaCodec.queueInputBuffer(i3, 0, readSampleData, this.f290872e.getSampleTime(), 0);
            this.f290872e.advance();
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(@NonNull MediaCodec mediaCodec, int i3, @NonNull MediaCodec.BufferInfo bufferInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, mediaCodec, Integer.valueOf(i3), bufferInfo);
            return;
        }
        ByteBuffer outputBuffer = mediaCodec.getOutputBuffer(i3);
        byte[] i16 = i(bufferInfo.size);
        outputBuffer.get(i16, 0, bufferInfo.size);
        int i17 = 0;
        int i18 = 0;
        while (i17 < bufferInfo.size) {
            int i19 = i18 + 1;
            i16[i18] = i16[i17];
            i18 = i19 + 1;
            i16[i19] = i16[i17 + 1];
            i17 += this.f290876i * 2;
        }
        mediaCodec.releaseOutputBuffer(i3, false);
        try {
            this.f290879l += i18;
            this.f290869b.write(i16, 0, i18);
            if ((bufferInfo.flags & 4) != 0) {
                f();
            }
        } catch (IOException e16) {
            l("onOutputBufferAvailable, write EXCEPTION=" + e16);
            e(6);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(@NonNull MediaCodec mediaCodec, @NonNull MediaFormat mediaFormat) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) mediaCodec, (Object) mediaFormat);
            return;
        }
        this.f290880m = mediaFormat;
        this.f290876i = mediaFormat.getInteger("channel-count");
        this.f290877j = mediaFormat.getInteger("sample-rate");
        if (mediaFormat.containsKey("pcm-encoding")) {
            if (Build.VERSION.SDK_INT >= 24) {
                this.f290878k = mediaFormat.getInteger("pcm-encoding");
            }
        } else {
            this.f290878k = 2;
        }
        l("onOutputFormatChanged, audio-format=" + this.f290873f + "output-format=" + mediaFormat);
    }
}
