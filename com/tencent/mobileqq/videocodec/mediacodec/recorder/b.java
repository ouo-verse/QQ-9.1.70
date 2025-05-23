package com.tencent.mobileqq.videocodec.mediacodec.recorder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
@TargetApi(18)
/* loaded from: classes20.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name */
    static final /* synthetic */ boolean f312607l;

    /* renamed from: a, reason: collision with root package name */
    private final h f312608a;

    /* renamed from: b, reason: collision with root package name */
    private final DecodeConfig f312609b;

    /* renamed from: c, reason: collision with root package name */
    private MediaExtractor f312610c;

    /* renamed from: d, reason: collision with root package name */
    private a f312611d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f312612e;

    /* renamed from: f, reason: collision with root package name */
    private final MediaCodec.BufferInfo f312613f;

    /* renamed from: g, reason: collision with root package name */
    private int f312614g;

    /* renamed from: h, reason: collision with root package name */
    private ByteBuffer f312615h;

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f312616i;

    /* renamed from: j, reason: collision with root package name */
    private volatile boolean f312617j;

    /* renamed from: k, reason: collision with root package name */
    private long f312618k;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f312619a;

        /* renamed from: b, reason: collision with root package name */
        public String f312620b;

        /* renamed from: c, reason: collision with root package name */
        public MediaFormat f312621c;

        /* renamed from: d, reason: collision with root package name */
        public int f312622d;

        /* renamed from: e, reason: collision with root package name */
        public String f312623e;

        /* renamed from: f, reason: collision with root package name */
        public MediaFormat f312624f;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f312619a = -1;
                this.f312622d = -1;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44081);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f312607l = true;
        }
    }

    public b(DecodeConfig decodeConfig, h hVar) {
        int integer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) decodeConfig, (Object) hVar);
            return;
        }
        this.f312613f = new MediaCodec.BufferInfo();
        this.f312614g = 1024;
        this.f312608a = hVar;
        this.f312609b = decodeConfig;
        this.f312618k = decodeConfig.endTimeMillSecond * 1000;
        try {
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.f312610c = mediaExtractor;
            mediaExtractor.setDataSource(decodeConfig.inputFilePath);
            a a16 = a(this.f312610c);
            this.f312611d = a16;
            if (a16.f312619a >= 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("HWAudioRecoder", 1, "audio track normal");
                }
                hVar.b(1, this.f312611d.f312621c);
                this.f312610c.selectTrack(this.f312611d.f312619a);
                if (this.f312611d.f312621c.containsKey("max-input-size")) {
                    this.f312614g = this.f312611d.f312621c.getInteger("max-input-size");
                }
                if (this.f312611d.f312622d >= 0) {
                    hVar.e(2);
                    hVar.b(2, this.f312611d.f312624f);
                    this.f312610c.selectTrack(this.f312611d.f312622d);
                    if (this.f312611d.f312624f.containsKey("max-input-size") && (integer = this.f312611d.f312624f.getInteger("max-input-size")) > this.f312614g) {
                        this.f312614g = integer;
                    }
                }
            } else {
                hVar.e(0);
                hVar.b(1, null);
                if (QLog.isColorLevel()) {
                    QLog.d("HWAudioRecoder", 1, "no audio track");
                }
            }
            this.f312615h = ByteBuffer.allocateDirect(this.f312614g).order(ByteOrder.nativeOrder());
            this.f312610c.seekTo(decodeConfig.startTimeMillSecond * 1000, 0);
        } catch (Exception e16) {
            QLog.e("HWAudioRecoder", 1, "getAudioTrack,", e16);
        }
    }

    public a a(MediaExtractor mediaExtractor) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) mediaExtractor);
        }
        a aVar = new a();
        int trackCount = mediaExtractor.getTrackCount();
        long j3 = 0;
        for (int i3 = 0; i3 < trackCount; i3++) {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i3);
            String string = trackFormat.getString("mime");
            if (aVar.f312619a < 0 && string.startsWith("audio/")) {
                j3++;
                if (j3 == 1) {
                    aVar.f312619a = i3;
                    aVar.f312620b = string;
                    aVar.f312621c = trackFormat;
                } else if (j3 == 2) {
                    aVar.f312622d = i3;
                    aVar.f312623e = string;
                    aVar.f312624f = trackFormat;
                }
                if (j3 >= 2) {
                    break;
                }
            }
        }
        int i16 = aVar.f312619a;
        if (i16 >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f312612e = z16;
        QLog.d("HWAudioRecoder", 1, "getAudioTrack, ", Integer.valueOf(i16), " ", Integer.valueOf(aVar.f312622d));
        return aVar;
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (!this.f312612e) {
            return true;
        }
        if (this.f312611d.f312622d < 0) {
            return this.f312616i;
        }
        if (this.f312616i && this.f312617j) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x005d, code lost:
    
        if (r0 == r4.f312622d) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.f312612e && !b()) {
            int sampleTrackIndex = this.f312610c.getSampleTrackIndex();
            int i16 = 2;
            if (sampleTrackIndex < 0) {
                this.f312615h.clear();
                this.f312613f.set(0, 0, 0L, 4);
                this.f312608a.writeSampleData(1, this.f312615h, this.f312613f);
                this.f312608a.writeSampleData(2, this.f312615h, this.f312613f);
                this.f312616i = true;
                this.f312617j = true;
                return true;
            }
            a aVar = this.f312611d;
            if (sampleTrackIndex == aVar.f312619a) {
                i16 = 1;
            }
            this.f312615h.clear();
            int readSampleData = this.f312610c.readSampleData(this.f312615h, 0);
            long sampleTime = this.f312610c.getSampleTime();
            if (!f312607l && readSampleData > this.f312614g) {
                throw new AssertionError();
            }
            if (readSampleData >= 0) {
                long j3 = this.f312618k;
                if (j3 <= 0 || sampleTime <= j3) {
                    if ((this.f312610c.getSampleFlags() & 1) != 0) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    this.f312613f.set(0, readSampleData, this.f312610c.getSampleTime(), i3);
                    this.f312608a.writeSampleData(i16, this.f312615h, this.f312613f);
                    this.f312610c.advance();
                    return true;
                }
            }
            this.f312615h.clear();
            this.f312613f.set(0, 0, 0L, 4);
            this.f312608a.writeSampleData(i16, this.f312615h, this.f312613f);
            if (sampleTrackIndex == this.f312611d.f312619a) {
                this.f312616i = true;
            } else {
                this.f312617j = true;
            }
            return true;
        }
        return false;
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QLog.d("HWAudioRecoder", 1, "stopRecording audio");
        while (!b() && c()) {
        }
        QLog.d("HWAudioRecoder", 1, "stopRecording audio, indeed");
        this.f312608a.release();
        MediaExtractor mediaExtractor = this.f312610c;
        if (mediaExtractor != null) {
            mediaExtractor.release();
            this.f312610c = null;
        }
    }
}
