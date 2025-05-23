package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.c;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@TargetApi(16)
/* loaded from: classes5.dex */
public class d extends c {

    /* renamed from: r, reason: collision with root package name */
    private Surface f94204r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f94205s;

    public d(e eVar, boolean z16, int i3, c.b bVar, Surface surface, boolean z17) throws IOException {
        super(eVar, z16, i3, bVar);
        this.f94204r = surface;
        this.f94205s = z17;
        o();
    }

    @TargetApi(16)
    private long y(long j3, e eVar, MediaCodec mediaCodec) throws IOException {
        mediaCodec.flush();
        eVar.l(j3, 0);
        if (eVar.c() == j3) {
            Log.d(this.f94182a, "skip fastseek, already there");
            return j3;
        }
        x();
        n(false);
        eVar.l(j3, 0);
        long j16 = Long.MAX_VALUE;
        int i3 = 0;
        long j17 = 0;
        while (eVar.a() && i3 < 20) {
            long c16 = j3 - eVar.c();
            if (c16 >= 0 && c16 < j16) {
                j17 = eVar.c();
                j16 = c16;
            }
            if (c16 < 0) {
                i3++;
            }
        }
        eVar.l(j17, 0);
        while (eVar.c() != j17) {
            eVar.a();
        }
        Log.d(this.f94182a, "exact fastseek match:       " + eVar.c());
        return j17;
    }

    public int A() {
        MediaFormat i3 = i();
        if (i3 != null) {
            return (int) (i3.getInteger("height") * i3.getFloat("mpx-dar"));
        }
        return 0;
    }

    public void B(c.a aVar, boolean z16) {
        g().releaseOutputBuffer(aVar.f94199a, z16);
        r(aVar);
    }

    public void C(Surface surface) {
        if (surface != null) {
            this.f94204r = surface;
            o();
            return;
        }
        throw new RuntimeException("surface must not be null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.playvideo.player.mediaplayer.c
    public void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        mediaCodec.configure(mediaFormat, this.f94204r, (MediaCrypto) null, 0);
    }

    @Override // com.tencent.biz.qqstory.playvideo.player.mediaplayer.c
    @SuppressLint({"NewApi"})
    public void t(c.a aVar, long j3) {
        B(aVar, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.playvideo.player.mediaplayer.c
    public c.a u(MediaPlayer.c cVar, long j3, e eVar, MediaCodec mediaCodec) throws IOException {
        long j16 = j3 / 1000;
        c.a u16 = super.u(cVar, j3, eVar, mediaCodec);
        if (u16 == null) {
            return null;
        }
        long j17 = -1;
        if (cVar.b() != 3 && cVar.b() != 2 && cVar.b() != 0 && cVar.b() != 1) {
            if (cVar.b() == 6) {
                B(u16, false);
                y(j3, eVar, mediaCodec);
                c.a b16 = b(true, true);
                if (b16 == null) {
                    return null;
                }
                Log.d(this.f94182a, "fast_exact seek to " + j3 + " arrived at " + b16.f94201c);
                if (b16.f94201c < j3) {
                    Log.d(this.f94182a, "presentation is behind...");
                }
                return b16;
            }
            if (cVar.b() == 4 || cVar.b() == 5) {
                long j18 = u16.f94201c / 1000;
                int i3 = 0;
                while (j18 < j16) {
                    if (i3 == 0) {
                        Log.d(this.f94182a, "skipping frames...");
                    }
                    i3++;
                    if (k()) {
                        j16 = u16.f94201c / 1000;
                    }
                    if (u16.f94202d) {
                        Log.d(this.f94182a, "end of stream reached, seeking to last frame");
                        B(u16, false);
                        return u(cVar, j17, eVar, mediaCodec);
                    }
                    j17 = u16.f94201c;
                    B(u16, false);
                    u16 = b(true, true);
                    if (u16 == null) {
                        return null;
                    }
                    j18 = u16.f94201c / 1000;
                }
                String str = this.f94182a;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("frame new position:         ");
                long j19 = j18;
                sb5.append(u16.f94201c);
                Log.d(str, sb5.toString());
                Log.d(this.f94182a, "seeking finished, skipped " + i3 + " frames");
                if (cVar.b() == 5 && j18 > j16) {
                    if (i3 == 0) {
                        Log.w(this.f94182a, "this should never happen");
                    } else {
                        Log.d(this.f94182a, "exact seek: repeat seek for previous frame at " + j17);
                        B(u16, false);
                        return u(cVar, j17, eVar, mediaCodec);
                    }
                }
                j17 = j19;
            }
        } else {
            Log.d(this.f94182a, "fast seek to " + j3 + " arrived at " + u16.f94201c);
        }
        if (j17 == j16) {
            Log.d(this.f94182a, "exact seek match!");
        }
        return u16;
    }

    public int z() {
        MediaFormat i3 = i();
        if (i3 != null) {
            return i3.getInteger("height");
        }
        return 0;
    }
}
