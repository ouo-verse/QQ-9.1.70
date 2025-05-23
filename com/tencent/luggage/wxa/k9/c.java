package com.tencent.luggage.wxa.k9;

import android.media.AudioTrack;
import com.tencent.luggage.wxa.c9.d;
import com.tencent.luggage.wxa.j9.f;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends a {
    public c(int i3, int i16, d dVar, f fVar) {
        super(i3, i16, dVar, fVar);
    }

    @Override // com.tencent.luggage.wxa.k9.a
    public void a(byte[] bArr) {
        if (this.f131787a == null) {
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioPcmStreamPlayComponent", "create AudioTrack before");
            if (!h()) {
                f fVar = this.f131795i;
                if (fVar != null) {
                    fVar.b(707);
                }
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmStreamPlayComponent", "create AudioTrack fail");
                return;
            }
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioPcmStreamPlayComponent", "create AudioTrack success");
            try {
                b(this.f131793g);
                this.f131787a.play();
                AudioTrack audioTrack = this.f131787a;
                float f16 = this.f131798l;
                audioTrack.setStereoVolume(f16, f16);
            } catch (IllegalStateException e16) {
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmStreamPlayComponent", e16, "setStereoVolume", new Object[0]);
            }
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioPcmStreamPlayComponent", "create AudioTrack after");
        }
        f fVar2 = this.f131795i;
        if (fVar2 != null) {
            fVar2.h();
        }
        AudioTrack audioTrack2 = this.f131787a;
        float f17 = this.f131798l;
        audioTrack2.setStereoVolume(f17, f17);
        this.f131787a.write(bArr, 0, bArr.length);
    }

    @Override // com.tencent.luggage.wxa.k9.a
    public void c() {
        super.c();
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioPcmStreamPlayComponent", "playFlush");
    }

    public boolean h() {
        int i3;
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioPcmStreamPlayComponent", "createAudioTrack");
        if (this.f131789c > 1) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmStreamPlayComponent", "createAudioTrack fail count reach MAX COUNT");
            return false;
        }
        if (this.f131792f == 1) {
            i3 = 4;
        } else {
            i3 = 12;
        }
        int i16 = i3;
        int minBufferSize = AudioTrack.getMinBufferSize(this.f131791e, i16, 2);
        if (minBufferSize <= 0) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmStreamPlayComponent", "createAudioTrack miniBufferSize %d is illegal", Integer.valueOf(minBufferSize));
            return false;
        }
        if (this.f131793g > 1.0d) {
            minBufferSize *= 2;
        }
        int i17 = minBufferSize;
        if (this.f131787a == null) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmStreamPlayComponent", "new AudioTrack");
            System.currentTimeMillis();
            this.f131787a = new AudioTrack(3, this.f131791e, i16, 2, i17, 1);
            this.f131789c++;
            a.f131785p.incrementAndGet();
        }
        if (this.f131787a != null && this.f131787a.getState() == 1) {
            a.f131786q.incrementAndGet();
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioPcmStreamPlayComponent", "audioTrackCount:%d", Integer.valueOf(a.f131786q.get()));
            return true;
        }
        a.f131784o.incrementAndGet();
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioPcmStreamPlayComponent", "play_count:%d, fail_count:%d", Integer.valueOf(a.f131785p.get()), Integer.valueOf(a.f131784o.get()));
        com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmStreamPlayComponent", "audio track not initialized");
        if (this.f131787a != null) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmStreamPlayComponent", "AudioTrack getState:%d", Integer.valueOf(this.f131787a.getState()));
            try {
                this.f131787a.release();
                this.f131787a = null;
            } catch (Exception e16) {
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmStreamPlayComponent", e16, "AudioTrack release", new Object[0]);
            }
        }
        return false;
    }
}
