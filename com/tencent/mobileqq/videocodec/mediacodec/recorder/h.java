package com.tencent.mobileqq.videocodec.mediacodec.recorder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
@TargetApi(18)
/* loaded from: classes20.dex */
public class h implements g {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public final MediaMuxer f312652b;

    /* renamed from: c, reason: collision with root package name */
    private final com.tencent.mobileqq.videocodec.mediacodec.a f312653c;

    /* renamed from: d, reason: collision with root package name */
    private final List<a> f312654d;

    /* renamed from: e, reason: collision with root package name */
    private final c f312655e;

    /* renamed from: f, reason: collision with root package name */
    private final String f312656f;

    /* renamed from: g, reason: collision with root package name */
    private MediaFormat f312657g;

    /* renamed from: h, reason: collision with root package name */
    private MediaFormat f312658h;

    /* renamed from: i, reason: collision with root package name */
    private MediaFormat f312659i;

    /* renamed from: j, reason: collision with root package name */
    private int f312660j;

    /* renamed from: k, reason: collision with root package name */
    private int f312661k;

    /* renamed from: l, reason: collision with root package name */
    private int f312662l;

    /* renamed from: m, reason: collision with root package name */
    private int f312663m;

    /* renamed from: n, reason: collision with root package name */
    private ByteBuffer f312664n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f312665o;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final int f312666a;

        /* renamed from: b, reason: collision with root package name */
        public final int f312667b;

        /* renamed from: c, reason: collision with root package name */
        private final long f312668c;

        /* renamed from: d, reason: collision with root package name */
        private final int f312669d;

        public a(int i3, int i16, MediaCodec.BufferInfo bufferInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), bufferInfo);
                return;
            }
            this.f312666a = i3;
            this.f312667b = i16;
            this.f312668c = bufferInfo.presentationTimeUs;
            this.f312669d = bufferInfo.flags;
        }

        public void a(MediaCodec.BufferInfo bufferInfo, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bufferInfo, i3);
            } else {
                bufferInfo.set(i3, this.f312667b, this.f312668c, this.f312669d);
            }
        }
    }

    public h(com.tencent.mobileqq.videocodec.mediacodec.a aVar, String str, c cVar) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aVar, str, cVar);
            return;
        }
        this.f312660j = 1;
        this.f312654d = new ArrayList();
        this.f312653c = aVar;
        this.f312655e = cVar;
        this.f312656f = str;
        this.f312652b = new MediaMuxer(str, 0);
    }

    private int c(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    return this.f312663m;
                }
                throw new AssertionError();
            }
            return this.f312662l;
        }
        return this.f312661k;
    }

    private void d() {
        MediaFormat mediaFormat = this.f312657g;
        if (mediaFormat == null) {
            return;
        }
        if (this.f312658h == null && this.f312660j > 0) {
            return;
        }
        if (this.f312660j == 2 && this.f312659i == null) {
            return;
        }
        this.f312661k = this.f312652b.addTrack(mediaFormat);
        QLog.d("MediaMuxerWrapper", 1, "Added track #" + this.f312661k + " with " + this.f312657g.getString("mime") + " to muxer");
        MediaFormat mediaFormat2 = this.f312658h;
        if (mediaFormat2 != null) {
            this.f312662l = this.f312652b.addTrack(mediaFormat2);
            QLog.d("MediaMuxerWrapper", 1, "Added track #" + this.f312662l + " with " + this.f312658h.getString("mime") + " to muxer");
        }
        int i3 = 0;
        if (this.f312659i != null) {
            this.f312663m = this.f312652b.addTrack(this.f312658h);
            QLog.d("MediaMuxerWrapper", 1, "Added second audiotrack #", Integer.valueOf(this.f312662l), " with ", this.f312659i.getString("mime"), " to muxer");
        }
        this.f312652b.start();
        this.f312665o = true;
        if (this.f312664n == null) {
            this.f312664n = ByteBuffer.allocate(0);
        }
        this.f312664n.flip();
        QLog.d("MediaMuxerWrapper", 1, "Output format determined, writing " + this.f312654d.size() + " samples / " + this.f312664n.limit() + " bytes to muxer.");
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        for (a aVar : this.f312654d) {
            aVar.a(bufferInfo, i3);
            this.f312652b.writeSampleData(c(aVar.f312666a), this.f312664n, bufferInfo);
            i3 += aVar.f312667b;
        }
        this.f312654d.clear();
        this.f312664n = null;
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.g
    @NonNull
    public MediaMuxer a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MediaMuxer) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f312652b;
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.g
    public void b(int i3, MediaFormat mediaFormat) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) mediaFormat);
            return;
        }
        QLog.d("MediaMuxerWrapper", 1, "setOutputFormat " + i3);
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    this.f312659i = mediaFormat;
                } else {
                    throw new AssertionError();
                }
            } else {
                this.f312658h = mediaFormat;
            }
        } else {
            this.f312657g = mediaFormat;
        }
        d();
    }

    public void e(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.f312660j = i3;
        }
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.g
    public synchronized void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QLog.d("MediaMuxerWrapper", 1, "release");
        if (this.f312653c.c()) {
            QLog.d("MediaMuxerWrapper", 1, "release indeed");
            if (this.f312665o) {
                this.f312665o = false;
                this.f312652b.stop();
            }
            this.f312652b.release();
            c cVar = this.f312655e;
            if (cVar != null) {
                cVar.onEncodeFinish(this.f312656f);
            }
        }
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.g
    public void writeSampleData(int i3, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), byteBuffer, bufferInfo);
            return;
        }
        try {
            if (this.f312665o) {
                this.f312652b.writeSampleData(c(i3), byteBuffer, bufferInfo);
                return;
            }
            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
            byteBuffer.position(bufferInfo.offset);
            if (this.f312664n == null) {
                this.f312664n = ByteBuffer.allocateDirect(65536).order(ByteOrder.nativeOrder());
            }
            this.f312664n.put(byteBuffer);
            this.f312654d.add(new a(i3, bufferInfo.size, bufferInfo));
        } catch (Exception e16) {
            QLog.e("MediaMuxerWrapper", 1, "writeSampleData error, ", e16);
        }
    }
}
