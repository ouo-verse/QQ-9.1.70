package com.tencent.mobileqq.qzoneplayer.video;

import com.tencent.oskplayer.proxy.VideoManager;
import com.tencent.oskplayer.util.PlayerUtils;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes35.dex */
public class r {

    /* renamed from: g, reason: collision with root package name */
    private static final String f280021g = "r";

    /* renamed from: h, reason: collision with root package name */
    private static volatile r f280022h;

    /* renamed from: i, reason: collision with root package name */
    private static ConcurrentLinkedQueue<Object> f280023i = new ConcurrentLinkedQueue<>();

    /* renamed from: a, reason: collision with root package name */
    private long f280024a = 2097152;

    /* renamed from: b, reason: collision with root package name */
    private int f280025b = 1;

    /* renamed from: c, reason: collision with root package name */
    private long f280026c = 0;

    /* renamed from: d, reason: collision with root package name */
    private long f280027d = 5000;

    /* renamed from: e, reason: collision with root package name */
    private boolean f280028e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f280029f = false;

    r() {
    }

    public static r b() {
        if (f280022h == null) {
            synchronized (r.class) {
                if (f280022h == null) {
                    f280022h = new r();
                }
            }
        }
        return f280022h;
    }

    public void a(boolean z16) {
        if (this.f280028e && this.f280029f) {
            PlayerUtils.log(4, f280021g, "cancel all preload video");
            this.f280029f = false;
            VideoManager.getInstance().getVideoRequestManager().cancelAllPreloadRequestAsync(z16);
        }
    }

    public void c(boolean z16, int i3, int i16) {
        this.f280028e = z16;
        this.f280025b = i3;
        this.f280027d = i16;
    }
}
