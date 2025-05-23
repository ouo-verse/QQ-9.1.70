package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.c;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes5.dex */
public class b extends c {

    /* renamed from: r, reason: collision with root package name */
    private AudioPlayback f94181r;

    public b(e eVar, boolean z16, int i3, c.b bVar, AudioPlayback audioPlayback) throws IOException {
        super(eVar, z16, i3, bVar);
        this.f94181r = audioPlayback;
        o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.playvideo.player.mediaplayer.c
    public void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        super.a(mediaCodec, mediaFormat);
        this.f94181r.i(mediaFormat);
    }

    @Override // com.tencent.biz.qqstory.playvideo.player.mediaplayer.c
    protected void m(MediaFormat mediaFormat) {
        this.f94181r.i(mediaFormat);
    }

    @Override // com.tencent.biz.qqstory.playvideo.player.mediaplayer.c
    public void t(c.a aVar, long j3) {
        this.f94181r.t(aVar.f94200b, aVar.f94201c);
        q(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.playvideo.player.mediaplayer.c
    public boolean w() {
        if (!l()) {
            if (this.f94181r.h() < 200000) {
                return true;
            }
            return false;
        }
        return super.w();
    }
}
