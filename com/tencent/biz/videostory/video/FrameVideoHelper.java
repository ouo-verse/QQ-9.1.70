package com.tencent.biz.videostory.video;

import android.graphics.Bitmap;
import com.tencent.aelight.camera.util.api.IVSConfigManager;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class FrameVideoHelper {

    /* renamed from: a, reason: collision with root package name */
    private MediaCodecGLFrameFetcher f97129a;

    /* renamed from: c, reason: collision with root package name */
    private final String f97131c;

    /* renamed from: d, reason: collision with root package name */
    private final long f97132d;

    /* renamed from: e, reason: collision with root package name */
    private final long f97133e;

    /* renamed from: f, reason: collision with root package name */
    private long f97134f;

    /* renamed from: g, reason: collision with root package name */
    private long f97135g;

    /* renamed from: l, reason: collision with root package name */
    private long f97140l;

    /* renamed from: n, reason: collision with root package name */
    private long f97142n;

    /* renamed from: o, reason: collision with root package name */
    private volatile boolean f97143o;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<FrameBuffer> f97130b = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    private long f97136h = ((Long) VSConfigManager.c().e(IVSConfigManager.SMART_CUT_PIC_WIDTH, 224L)).longValue();

    /* renamed from: i, reason: collision with root package name */
    private long f97137i = ((Long) VSConfigManager.c().e(IVSConfigManager.SMART_CUT_PIC_COUNT, 10L)).longValue();

    /* renamed from: j, reason: collision with root package name */
    private long f97138j = ((Long) VSConfigManager.c().e(IVSConfigManager.SMART_CUT_PIC_QUALITY_AND, 80L)).longValue();

    /* renamed from: k, reason: collision with root package name */
    private long f97139k = ((Long) VSConfigManager.c().e(IVSConfigManager.SMART_CUT_PIC_MAX_BYTE, 90000L)).longValue();

    /* renamed from: m, reason: collision with root package name */
    private long f97141m = 0;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class FrameBuffer implements Serializable {
        private static final long serialVersionUID = 739662983371469000L;
        private final byte[] mData;

        public FrameBuffer(byte[] bArr) {
            this.mData = bArr;
        }

        public byte[] getData() {
            return this.mData;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z16, ArrayList<FrameBuffer> arrayList, long j3);
    }

    public FrameVideoHelper(String str, int i3, int i16, long j3) {
        this.f97131c = str;
        this.f97134f = i3;
        this.f97135g = i16;
        this.f97132d = j3;
        this.f97133e = j3 > 60000 ? 60000L : j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long u(long j3) {
        long min = Math.min(j3 + this.f97133e, this.f97132d);
        long j16 = this.f97137i;
        long j17 = min / j16;
        if (j17 > 1000) {
            return (min - 1000) / j16;
        }
        return j17;
    }

    public long v() {
        return this.f97141m;
    }

    public long w() {
        return this.f97142n / 1000;
    }

    public void x(final long j3, final a aVar) {
        ms.a.f("AEEditorMusicHelper", "FrameVideoHelper.start(), BEGIN");
        ms.a.f("AEEditorMusicHelper", "FrameVideoHelper.start(), videoStart=" + j3 + ", videoDuration=" + this.f97132d);
        if (this.f97143o) {
            return;
        }
        this.f97141m = 0L;
        this.f97142n = 0L;
        this.f97140l = System.currentTimeMillis();
        this.f97143o = true;
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.biz.videostory.video.FrameVideoHelper.1
            @Override // java.lang.Runnable
            public void run() {
                if (FrameVideoHelper.this.f97136h != -1) {
                    FrameVideoHelper frameVideoHelper = FrameVideoHelper.this;
                    frameVideoHelper.f97134f = frameVideoHelper.f97136h;
                    FrameVideoHelper frameVideoHelper2 = FrameVideoHelper.this;
                    frameVideoHelper2.f97135g = frameVideoHelper2.f97136h;
                }
                FrameVideoHelper frameVideoHelper3 = FrameVideoHelper.this;
                frameVideoHelper3.f97129a = new MediaCodecGLFrameFetcher(frameVideoHelper3.f97134f, FrameVideoHelper.this.f97135g);
                long u16 = FrameVideoHelper.this.u(j3);
                long j16 = j3 + u16;
                try {
                    FrameVideoHelper.this.f97129a.x(FrameVideoHelper.this.f97131c);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    long j17 = 0;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= FrameVideoHelper.this.f97137i || j16 >= FrameVideoHelper.this.f97132d) {
                            break;
                        }
                        Bitmap n3 = FrameVideoHelper.this.f97129a.n(j16);
                        j16 += u16;
                        if (n3 != null) {
                            n3.compress(Bitmap.CompressFormat.JPEG, (int) FrameVideoHelper.this.f97138j, byteArrayOutputStream);
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            j17 += byteArray.length;
                            if (j17 >= FrameVideoHelper.this.f97139k) {
                                QLog.i("FrameVideoHelper", 2, "extract Frame out of limit readBytes:" + j17 + " | frameCount:" + i3);
                                break;
                            }
                            FrameVideoHelper.this.f97142n += byteArray.length;
                            FrameVideoHelper.this.f97130b.add(new FrameBuffer(byteArray));
                            byteArrayOutputStream.reset();
                        }
                        i3++;
                    }
                    FrameVideoHelper.this.f97141m = System.currentTimeMillis() - FrameVideoHelper.this.f97140l;
                    byteArrayOutputStream.close();
                    QLog.i("FrameVideoHelper", 2, "extract Frame cost time:" + FrameVideoHelper.this.f97141m);
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(true, FrameVideoHelper.this.f97130b, FrameVideoHelper.this.f97142n);
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                    aVar.a(false, FrameVideoHelper.this.f97130b, FrameVideoHelper.this.f97142n);
                }
                FrameVideoHelper.this.f97143o = false;
            }
        });
        ms.a.f("AEEditorMusicHelper", "FrameVideoHelper.start(), END");
    }

    public void y(a aVar) {
        x(0L, aVar);
    }

    public void z() {
        MediaCodecGLFrameFetcher mediaCodecGLFrameFetcher = this.f97129a;
        if (mediaCodecGLFrameFetcher != null) {
            mediaCodecGLFrameFetcher.v();
        }
        ArrayList<FrameBuffer> arrayList = this.f97130b;
        if (arrayList != null) {
            arrayList.clear();
        }
    }
}
