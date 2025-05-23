package com.tencent.luggage.wxa.ba;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.ParcelFileDescriptor;
import com.tencent.luggage.wxa.cp.x;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final MediaExtractor f122388a = new MediaExtractor();

    public final void a(String str, Map map) {
        if (x.b(str, false) != null) {
            try {
                this.f122388a.setDataSource(str, map);
                return;
            } catch (IOException e16) {
                com.tencent.luggage.wxa.yp.b.e("MicroMsg.VFSMediaExtractor", "Cannot open by path: " + str + ", " + e16.getMessage());
            }
        }
        try {
            ParcelFileDescriptor c16 = x.c(str, "r");
            try {
                this.f122388a.setDataSource(c16.getFileDescriptor());
                c16.close();
            } finally {
            }
        } catch (IOException e17) {
            com.tencent.luggage.wxa.yp.b.e("MicroMsg.VFSMediaExtractor", "Cannot open by fd: " + str + ", " + e17.getMessage());
            this.f122388a.setDataSource(str, map);
        }
    }

    public void b(int i3) {
        this.f122388a.selectTrack(i3);
    }

    public final int c() {
        return this.f122388a.getTrackCount();
    }

    public final void d() {
        this.f122388a.release();
    }

    public long b() {
        return this.f122388a.getSampleTime();
    }

    public final void a(String str) {
        a(str, (Map) null);
    }

    public MediaFormat a(int i3) {
        return this.f122388a.getTrackFormat(i3);
    }

    public void a(long j3, int i3) {
        this.f122388a.seekTo(j3, i3);
    }

    public boolean a() {
        return this.f122388a.advance();
    }

    public int a(ByteBuffer byteBuffer, int i3) {
        return this.f122388a.readSampleData(byteBuffer, i3);
    }
}
