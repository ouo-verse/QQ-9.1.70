package com.tencent.luggage.wxa.k9;

import android.media.AudioTrack;
import com.tencent.luggage.wxa.c9.d;
import com.tencent.luggage.wxa.j9.f;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends a {

    /* renamed from: r, reason: collision with root package name */
    public Thread f131799r;

    public b(int i3, int i16, d dVar, f fVar) {
        super(i3, i16, dVar, fVar);
    }

    @Override // com.tencent.luggage.wxa.k9.a
    public void a(byte[] bArr) {
        int i3;
        if (this.f131787a == null) {
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioPcmStaticPlayComponent", "create AudioTrack before");
            if (!h()) {
                f fVar = this.f131795i;
                if (fVar != null) {
                    fVar.b(707);
                }
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmStaticPlayComponent", "create AudioTrack fail");
                return;
            }
            try {
                AudioTrack audioTrack = this.f131787a;
                if (audioTrack != null) {
                    float f16 = this.f131798l;
                    audioTrack.setStereoVolume(f16, f16);
                }
            } catch (IllegalStateException e16) {
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmStaticPlayComponent", e16, "setStereoVolume", new Object[0]);
            }
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioPcmStaticPlayComponent", "create AudioTrack after and success!");
        }
        if (this.f131788b == null) {
            d dVar = this.f131794h;
            if (dVar != null) {
                i3 = dVar.m() * 3536;
            } else {
                i3 = 3536;
            }
            if (i3 == 0) {
                i3 = 3536;
            }
            if (bArr.length == 3536) {
                i3++;
            }
            this.f131788b = new byte[i3];
        }
        int i16 = this.f131790d;
        int length = bArr.length + i16;
        byte[] bArr2 = this.f131788b;
        if (length <= bArr2.length) {
            System.arraycopy(bArr, 0, bArr2, i16, bArr.length);
            this.f131790d += bArr.length;
        }
    }

    @Override // com.tencent.luggage.wxa.k9.a
    public void b() {
        AudioTrack audioTrack = this.f131787a;
        if (audioTrack != null) {
            int state = audioTrack.getState();
            int playState = audioTrack.getPlayState();
            if (state == 1 && playState == 3) {
                try {
                    audioTrack.pause();
                    int playbackHeadPosition = audioTrack.getPlaybackHeadPosition();
                    this.f131796j = playbackHeadPosition;
                    com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioPcmStaticPlayComponent", "pause startPos :%d", Integer.valueOf(playbackHeadPosition));
                    Thread thread = this.f131799r;
                    if (thread != null) {
                        thread.interrupt();
                    }
                } catch (Exception e16) {
                    com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmStaticPlayComponent", e16, "pause", new Object[0]);
                }
            }
        }
    }

    @Override // com.tencent.luggage.wxa.k9.a
    public void c() {
        long j3;
        long j16;
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioPcmStaticPlayComponent", "playFlush play_count:%d, fail_count:%d", Integer.valueOf(a.f131785p.get()), Integer.valueOf(a.f131784o.get()));
        if (this.f131787a != null) {
            f fVar = this.f131795i;
            if (fVar != null) {
                fVar.h();
            }
            AudioTrack audioTrack = this.f131787a;
            if (audioTrack.getState() == 2) {
                byte[] bArr = this.f131788b;
                if (audioTrack.write(bArr, 0, bArr.length) <= 0) {
                    com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmStaticPlayComponent", "AudioTrack write fail, should write length:%d", Integer.valueOf(this.f131788b.length));
                    this.f131795i.b(TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_HOOK);
                    return;
                }
            }
            if (audioTrack.getState() == 1) {
                audioTrack.reloadStaticData();
                b(this.f131793g);
                audioTrack.play();
                this.f131799r = Thread.currentThread();
                try {
                    long f16 = this.f131794h.f();
                    if (f16 <= 0) {
                        j16 = 2000;
                    } else {
                        if (f16 < 1000) {
                            j3 = a.f131783n;
                        } else {
                            j3 = a.f131782m;
                        }
                        j16 = f16 + j3;
                    }
                    LockMethodProxy.sleep(j16);
                } catch (Exception unused) {
                    com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmStaticPlayComponent", "play Thread.sleep");
                }
            }
        }
    }

    @Override // com.tencent.luggage.wxa.k9.a
    public void f() {
        super.f();
        e();
        this.f131799r = null;
    }

    @Override // com.tencent.luggage.wxa.k9.a
    public void g() {
        long j3;
        long j16;
        AudioTrack audioTrack = this.f131787a;
        if (audioTrack != null && audioTrack.getState() == 1) {
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioPcmStaticPlayComponent", "resume");
            f fVar = this.f131795i;
            if (fVar != null) {
                fVar.h();
            }
            try {
                float f16 = this.f131798l;
                audioTrack.setStereoVolume(f16, f16);
            } catch (IllegalStateException e16) {
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmStaticPlayComponent", e16, "setStereoVolume", new Object[0]);
            }
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioPcmStaticPlayComponent", "play startPos:%d", Integer.valueOf(this.f131796j));
            audioTrack.setPlaybackHeadPosition(this.f131796j);
            audioTrack.play();
            try {
                long f17 = this.f131794h.f();
                if (f17 <= 0) {
                    j16 = 2000;
                } else {
                    if (f17 < 1000) {
                        j3 = a.f131783n;
                    } else {
                        j3 = a.f131782m;
                    }
                    j16 = f17 + j3;
                }
                LockMethodProxy.sleep(j16);
            } catch (Exception unused) {
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmStaticPlayComponent", "play Thread.sleep");
            }
        }
    }

    public boolean h() {
        int i3;
        if (this.f131789c > 1) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmStaticPlayComponent", "createAudioTrack fail count reach MAX COUNT");
            return false;
        }
        if (this.f131792f == 1) {
            i3 = 4;
        } else {
            i3 = 12;
        }
        int i16 = i3;
        int minBufferSize = AudioTrack.getMinBufferSize(this.f131791e, i16, 2);
        d dVar = this.f131794h;
        if (dVar != null && dVar.m() > 0) {
            minBufferSize = this.f131794h.m() * 3536;
        }
        if (this.f131793g > 1.0d) {
            minBufferSize *= 2;
        }
        int i17 = minBufferSize;
        if (this.f131787a == null) {
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioPcmStaticPlayComponent", "new AudioTrack");
            System.currentTimeMillis();
            this.f131787a = new AudioTrack(3, this.f131791e, i16, 2, i17, 0);
            this.f131789c++;
            a.f131785p.incrementAndGet();
        }
        if (this.f131787a != null && this.f131787a.getState() == 2) {
            a.f131786q.incrementAndGet();
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioPcmStaticPlayComponent", "audioTrackCount:%d", Integer.valueOf(a.f131786q.get()));
            return true;
        }
        com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmStaticPlayComponent", "audio track not initialized");
        a.f131784o.incrementAndGet();
        if (this.f131787a != null) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmStaticPlayComponent", "AudioTrack getState:%d", Integer.valueOf(this.f131787a.getState()));
            try {
                this.f131787a.release();
                this.f131787a = null;
            } catch (Exception e16) {
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmStaticPlayComponent", e16, "AudioTrack release", new Object[0]);
            }
        }
        return false;
    }
}
