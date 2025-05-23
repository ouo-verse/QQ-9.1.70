package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.net.Uri;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private MediaExtractor f94206a;

    public e() {
        k();
    }

    public boolean a() {
        return this.f94206a.advance();
    }

    public long b() {
        return this.f94206a.getCachedDuration();
    }

    public long c() {
        return this.f94206a.getSampleTime();
    }

    public int d() {
        return this.f94206a.getSampleTrackIndex();
    }

    public final int e() {
        return this.f94206a.getTrackCount();
    }

    @TargetApi(16)
    public MediaFormat f(int i3) {
        MediaFormat trackFormat = this.f94206a.getTrackFormat(i3);
        if (trackFormat.getString("mime").startsWith("video/")) {
            trackFormat.setFloat("mpx-dar", trackFormat.getInteger("width") / trackFormat.getInteger("height"));
        }
        return trackFormat;
    }

    public boolean g() {
        return this.f94206a.hasCacheReachedEndOfStream();
    }

    public boolean h() {
        return false;
    }

    public int i(ByteBuffer byteBuffer, int i3) {
        return this.f94206a.readSampleData(byteBuffer, i3);
    }

    public void j() {
        this.f94206a.release();
    }

    @TargetApi(16)
    protected void k() {
        MediaExtractor mediaExtractor = this.f94206a;
        if (mediaExtractor != null) {
            mediaExtractor.release();
        }
        this.f94206a = new MediaExtractor();
    }

    public void l(long j3, int i3) throws IOException {
        this.f94206a.seekTo(j3, i3);
    }

    public void m(int i3) {
        this.f94206a.selectTrack(i3);
    }

    public final void n(Context context, Uri uri, Map<String, String> map) throws IOException {
        this.f94206a.setDataSource(context, uri, map);
    }
}
