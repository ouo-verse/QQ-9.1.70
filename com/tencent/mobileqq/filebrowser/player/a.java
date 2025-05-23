package com.tencent.mobileqq.filebrowser.player;

import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private AudioTrack f205941a;

    /* renamed from: b, reason: collision with root package name */
    private MediaCodec f205942b;

    /* renamed from: c, reason: collision with root package name */
    private MediaExtractor f205943c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f205944d;

    /* renamed from: e, reason: collision with root package name */
    private long f205945e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f205946f;

    /* renamed from: g, reason: collision with root package name */
    private b f205947g;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filebrowser.player.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    class C7519a extends MediaCodec.Callback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private boolean f205948a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f205949b;

        C7519a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            } else {
                this.f205948a = false;
                this.f205949b = false;
            }
        }

        @Override // android.media.MediaCodec.Callback
        public void onError(@NonNull MediaCodec mediaCodec, @NonNull MediaCodec.CodecException codecException) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) mediaCodec, (Object) codecException);
            } else {
                QLog.e("M4APlayer", 1, "mediacodec callback onError: ", codecException.getMessage());
                a.this.i(-1002, codecException.getMessage());
            }
        }

        @Override // android.media.MediaCodec.Callback
        public void onInputBufferAvailable(@NonNull MediaCodec mediaCodec, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) mediaCodec, i3);
                return;
            }
            if (a.this.f205946f) {
                return;
            }
            if (!a.this.f205944d) {
                QLog.d("M4APlayer", 1, "onInputBufferAvailable in pause");
                return;
            }
            if (!this.f205948a && !this.f205949b) {
                ByteBuffer inputBuffer = mediaCodec.getInputBuffer(i3);
                if (inputBuffer == null) {
                    QLog.d("M4APlayer", 1, "onInputBufferAvailable inputBuffer is null");
                    return;
                }
                int readSampleData = a.this.f205943c.readSampleData(inputBuffer, 0);
                if (readSampleData >= 0) {
                    mediaCodec.queueInputBuffer(i3, 0, readSampleData, a.this.f205943c.getSampleTime(), 0);
                    a.this.f205943c.advance();
                    return;
                } else {
                    mediaCodec.queueInputBuffer(i3, 0, 0, -1L, 4);
                    this.f205949b = true;
                    return;
                }
            }
            QLog.d("M4APlayer", 1, "onInputBufferAvailable EOS");
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputBufferAvailable(@NonNull MediaCodec mediaCodec, int i3, @NonNull MediaCodec.BufferInfo bufferInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, mediaCodec, Integer.valueOf(i3), bufferInfo);
                return;
            }
            if (a.this.f205946f) {
                return;
            }
            if (!a.this.f205944d) {
                QLog.d("M4APlayer", 1, "onOutputBufferAvailable in pause");
                return;
            }
            ByteBuffer outputBuffer = mediaCodec.getOutputBuffer(i3);
            if (outputBuffer != null) {
                outputBuffer.rewind();
                outputBuffer.order(ByteOrder.LITTLE_ENDIAN);
                a.this.f205941a.write(outputBuffer, outputBuffer.remaining(), 0);
            }
            a.this.f205945e = bufferInfo.presentationTimeUs / 1000;
            boolean z17 = this.f205948a;
            if ((bufferInfo.flags & 4) == 0) {
                z16 = false;
            }
            this.f205948a = z17 | z16;
            mediaCodec.releaseOutputBuffer(i3, false);
            if (this.f205948a) {
                a.this.h();
                this.f205949b = false;
                this.f205948a = false;
            }
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputFormatChanged(@NonNull MediaCodec mediaCodec, @NonNull MediaFormat mediaFormat) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) mediaCodec, (Object) mediaFormat);
            } else {
                QLog.d("M4APlayer", 1, "onOutputFormatChanged: ", mediaFormat.toString());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface b {
        void onComplete();

        void onError(int i3, String str);

        void onPrepared();
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f205944d = false;
            this.f205946f = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.f205944d = false;
        this.f205942b.flush();
        b bVar = this.f205947g;
        if (bVar != null) {
            bVar.onComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i3, String str) {
        this.f205944d = false;
        n();
        b bVar = this.f205947g;
        if (bVar != null) {
            bVar.onError(i3, str);
        }
    }

    private void n() {
        AudioTrack audioTrack = this.f205941a;
        if (audioTrack != null) {
            audioTrack.stop();
            this.f205941a.release();
            this.f205941a = null;
        }
        MediaCodec mediaCodec = this.f205942b;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.f205942b.release();
            this.f205942b = null;
        }
        MediaExtractor mediaExtractor = this.f205943c;
        if (mediaExtractor != null) {
            mediaExtractor.release();
            this.f205943c = null;
        }
    }

    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return (int) this.f205945e;
    }

    public void k(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        try {
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.f205943c = mediaExtractor;
            mediaExtractor.setDataSource(str);
            int i3 = 0;
            MediaFormat mediaFormat = null;
            while (true) {
                if (i3 < this.f205943c.getTrackCount()) {
                    mediaFormat = this.f205943c.getTrackFormat(i3);
                    String string = mediaFormat.getString("mime");
                    if (string != null && string.startsWith("audio/")) {
                        this.f205943c.selectTrack(i3);
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
            if (mediaFormat == null) {
                QLog.e("M4APlayer", 1, "Audio Track Not Found");
                i(-1001, "Audio Track Not Found");
                return;
            }
            int integer = mediaFormat.getInteger("sample-rate");
            this.f205941a = new ReportAudioTrack(3, integer, 12, 2, AudioTrack.getMinBufferSize(integer, 12, 2) * 8, 1);
            MediaCodec createDecoderByType = MediaCodec.createDecoderByType(mediaFormat.getString("mime"));
            this.f205942b = createDecoderByType;
            createDecoderByType.setCallback(new C7519a());
            this.f205942b.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 0);
            b bVar = this.f205947g;
            if (bVar != null) {
                bVar.onPrepared();
            }
        } catch (IOException e16) {
            QLog.e("M4APlayer", 1, "init failed ", e16);
            i(-1003, e16.getMessage());
        }
    }

    public boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.f205944d;
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QLog.d("M4APlayer", 1, "pause ");
        AudioTrack audioTrack = this.f205941a;
        if (audioTrack != null && this.f205944d) {
            this.f205944d = false;
            audioTrack.pause();
            this.f205942b.flush();
        }
    }

    public void o(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Double.valueOf(d16));
            return;
        }
        this.f205946f = true;
        long j3 = (long) (d16 * 1000.0d);
        QLog.d("M4APlayer", 1, "seekToPos " + j3);
        this.f205943c.seekTo(j3, 2);
        this.f205946f = false;
    }

    public void p(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
        } else {
            this.f205947g = bVar;
        }
    }

    public void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        QLog.d("M4APlayer", 1, "start ");
        if (this.f205941a != null && !this.f205944d) {
            this.f205944d = true;
            this.f205942b.start();
            this.f205941a.play();
        }
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        QLog.d("M4APlayer", 1, "stop ");
        this.f205944d = false;
        n();
    }
}
