package com.tencent.qqlive.playerinterface;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QAdVideoItem {

    /* renamed from: a, reason: collision with root package name */
    private String f345348a;

    /* renamed from: b, reason: collision with root package name */
    private String f345349b;

    /* renamed from: c, reason: collision with root package name */
    private long f345350c;

    /* renamed from: d, reason: collision with root package name */
    private String f345351d;

    /* renamed from: e, reason: collision with root package name */
    private String f345352e;

    /* renamed from: f, reason: collision with root package name */
    private String f345353f;

    /* renamed from: g, reason: collision with root package name */
    private int f345354g;

    /* renamed from: h, reason: collision with root package name */
    private String f345355h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f345356i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f345357j;

    /* renamed from: k, reason: collision with root package name */
    private int f345358k;

    /* renamed from: l, reason: collision with root package name */
    private String f345359l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f345360m;

    /* renamed from: n, reason: collision with root package name */
    private String f345361n;

    /* renamed from: o, reason: collision with root package name */
    private long f345362o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f345363p = false;

    /* renamed from: q, reason: collision with root package name */
    private String f345364q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f345365r;

    /* renamed from: s, reason: collision with root package name */
    private String f345366s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f345367t;

    /* renamed from: u, reason: collision with root package name */
    private String f345368u;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes22.dex */
    public @interface PCdnChargeId {
        public static final String INSIDE_VIDEO = "pcdn_qqlive_inplayer_android_ad";
        public static final String SPLASH = "pcdn_qqlive_splash_android_ad";
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes22.dex */
    public @interface SceneId {
        public static final String FEED = "QADFeed";
        public static final String INSIDE_VIDEO = "QADVideo";
        public static final String SPLASH = "QADSplash";
    }

    public long a() {
        return this.f345350c;
    }

    public int b() {
        return this.f345354g;
    }

    public String c() {
        return this.f345355h;
    }

    public String d() {
        return this.f345348a;
    }

    public boolean e() {
        return this.f345356i;
    }

    public boolean f() {
        return this.f345363p;
    }

    public void g(String str) {
        this.f345352e = str;
    }

    public void h(boolean z16) {
        this.f345356i = z16;
    }

    public void i(String str) {
        this.f345349b = str;
    }

    public void j(String str) {
        this.f345353f = str;
    }

    public void k(long j3) {
        this.f345350c = j3;
    }

    public void l(String str) {
        this.f345351d = str;
    }

    public void m(String str) {
        this.f345368u = str;
    }

    public void n(int i3) {
        this.f345354g = i3;
    }

    public void o(long j3) {
        this.f345362o = j3;
    }

    public void p(String str) {
        this.f345361n = str;
    }

    public void q(boolean z16) {
        this.f345363p = z16;
    }

    public void r(String str) {
        this.f345355h = str;
    }

    public void s(String str) {
        this.f345348a = str;
    }

    public String toString() {
        return "QAdVideoItem{mVid='" + this.f345348a + "', mCid='" + this.f345349b + "', mDuration=" + this.f345350c + ", mEncodeFormat='" + this.f345351d + "', mCachePath='" + this.f345352e + "', mDefinition='" + this.f345353f + "', mFileSize=" + this.f345354g + ", mPlayUrl='" + this.f345355h + "', mIsCached=" + this.f345356i + ", mIsMaxView=" + this.f345357j + ", mMaxViewDuration=" + this.f345358k + ", mVideoWithAlpha=" + this.f345360m + ", mPlayId='" + this.f345359l + "', mImageUrl='" + this.f345361n + "', mImageDurationMs='" + this.f345362o + "', mIsImage='" + this.f345363p + "', mSceneId='" + this.f345364q + "', mCacheCopyFirst='" + this.f345365r + "', mPCdnChargeId='" + this.f345366s + "', mUseP2P='" + this.f345367t + "', mFileMd5='" + this.f345368u + "'}";
    }
}
