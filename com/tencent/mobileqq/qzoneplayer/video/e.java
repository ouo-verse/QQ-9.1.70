package com.tencent.mobileqq.qzoneplayer.video;

import android.util.Pair;
import com.tencent.oskplayer.model.SegmentVideoInfo;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes35.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    private BaseVideo f279982b;

    /* renamed from: c, reason: collision with root package name */
    public WeakReference<BaseVideo> f279983c;

    /* renamed from: d, reason: collision with root package name */
    public VideoPlayInfoHolder f279984d;

    /* renamed from: e, reason: collision with root package name */
    public volatile String f279985e;

    /* renamed from: g, reason: collision with root package name */
    public boolean f279987g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f279988h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f279989i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f279990j;

    /* renamed from: k, reason: collision with root package name */
    public SegmentVideoInfo.StreamInfo f279991k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f279992l;

    /* renamed from: m, reason: collision with root package name */
    public volatile boolean f279993m;

    /* renamed from: n, reason: collision with root package name */
    public int f279994n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f279995o;

    /* renamed from: p, reason: collision with root package name */
    long f279996p;

    /* renamed from: q, reason: collision with root package name */
    public int f279997q;

    /* renamed from: r, reason: collision with root package name */
    public long f279998r;

    /* renamed from: a, reason: collision with root package name */
    String f279981a = "ManagerState";

    /* renamed from: f, reason: collision with root package name */
    public int f279986f = 0;

    public BaseVideo a() {
        return this.f279982b;
    }

    public String b() {
        return this.f279985e;
    }

    public synchronized Pair<String, VideoPlayInfoHolder> c() {
        return new Pair<>(this.f279985e, VideoPlayInfoHolder.shallowCopy(this.f279984d));
    }

    public void d(BaseVideo baseVideo) {
        this.f279982b = baseVideo;
    }
}
