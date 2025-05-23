package com.qzone.reborn.feedx.video;

import android.text.TextUtils;
import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;
import java.util.concurrent.atomic.AtomicInteger;
import lh.j;

/* compiled from: P */
/* loaded from: classes37.dex */
public class c {

    /* renamed from: y, reason: collision with root package name */
    public static final AtomicInteger f55809y = new AtomicInteger(90000);

    /* renamed from: b, reason: collision with root package name */
    private String f55811b;

    /* renamed from: c, reason: collision with root package name */
    private String f55812c;

    /* renamed from: d, reason: collision with root package name */
    private long f55813d;

    /* renamed from: e, reason: collision with root package name */
    private int f55814e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f55815f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f55816g;

    /* renamed from: k, reason: collision with root package name */
    private int f55820k;

    /* renamed from: l, reason: collision with root package name */
    private String f55821l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f55822m;

    /* renamed from: n, reason: collision with root package name */
    private String f55823n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f55824o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f55825p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f55826q;

    /* renamed from: r, reason: collision with root package name */
    private String f55827r;

    /* renamed from: s, reason: collision with root package name */
    private QZoneVideoUrlBean f55828s;

    /* renamed from: u, reason: collision with root package name */
    private boolean f55830u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f55831v;

    /* renamed from: w, reason: collision with root package name */
    private int f55832w;

    /* renamed from: x, reason: collision with root package name */
    private String f55833x;

    /* renamed from: h, reason: collision with root package name */
    private boolean f55817h = true;

    /* renamed from: t, reason: collision with root package name */
    private int f55829t = ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID;

    /* renamed from: a, reason: collision with root package name */
    private final int f55810a = f55809y.getAndIncrement();

    /* renamed from: i, reason: collision with root package name */
    private j f55818i = new j();

    /* renamed from: j, reason: collision with root package name */
    private com.qzone.reborn.feedx.video.a f55819j = new a();

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a extends com.qzone.reborn.feedx.video.a {
        a() {
        }

        @Override // com.qzone.reborn.feedx.video.a
        public boolean a() {
            return true;
        }
    }

    c() {
    }

    public static c l() {
        return new c();
    }

    public String a() {
        if (!TextUtils.isEmpty(this.f55812c)) {
            return this.f55812c;
        }
        if (!TextUtils.isEmpty(this.f55833x)) {
            return this.f55833x;
        }
        return "";
    }

    public j b() {
        return this.f55818i;
    }

    public String c() {
        if (TextUtils.isEmpty(this.f55811b)) {
            return "";
        }
        return this.f55811b;
    }

    public String d() {
        if (TextUtils.isEmpty(this.f55833x)) {
            return "";
        }
        return this.f55833x;
    }

    public String e() {
        QZoneVideoUrlBean qZoneVideoUrlBean = this.f55828s;
        if (qZoneVideoUrlBean != null) {
            return qZoneVideoUrlBean.f55802e;
        }
        if (TextUtils.isEmpty(this.f55827r)) {
            return c();
        }
        return this.f55827r;
    }

    public int f() {
        return this.f55832w;
    }

    public int g() {
        return this.f55814e;
    }

    public long h() {
        return this.f55813d;
    }

    public boolean i() {
        return this.f55822m;
    }

    public boolean j() {
        return this.f55826q;
    }

    public boolean k() {
        return this.f55819j.a();
    }

    public c m(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.f55812c = str;
        return this;
    }

    public c n(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.f55811b = str;
        return this;
    }

    public c o(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.f55833x = str;
        return this;
    }

    public c p(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.f55827r = str;
        return this;
    }

    public c q(int i3) {
        this.f55814e = i3;
        return this;
    }

    public c r(long j3) {
        this.f55813d = j3;
        return this;
    }

    public String s() {
        return "QZone_PLAYER_" + this.f55820k + "_" + this.f55810a;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("QZonePlayerOptions{");
        stringBuffer.append("mSeq=");
        stringBuffer.append(this.f55810a);
        stringBuffer.append(", mPlayUrl='");
        stringBuffer.append(this.f55811b);
        stringBuffer.append('\'');
        stringBuffer.append(", mFileId='");
        stringBuffer.append(this.f55812c);
        stringBuffer.append('\'');
        stringBuffer.append(", mStartOffset=");
        stringBuffer.append(this.f55814e);
        stringBuffer.append(", mNeedToExchangeUrl=");
        stringBuffer.append(this.f55815f);
        stringBuffer.append(", mNeedToDownLevelUrl=");
        stringBuffer.append(this.f55816g);
        stringBuffer.append(", mFromType=");
        stringBuffer.append(this.f55820k);
        stringBuffer.append(", mPreDownloadTag='");
        stringBuffer.append(this.f55821l);
        stringBuffer.append('\'');
        stringBuffer.append(", mHasPreLoadPlayer=");
        stringBuffer.append(this.f55822m);
        stringBuffer.append(", mPreLoadPlayerTag='");
        stringBuffer.append(this.f55823n);
        stringBuffer.append('\'');
        stringBuffer.append(", mHasExchangeUrl=");
        stringBuffer.append(this.f55824o);
        stringBuffer.append(", mHasDownLevel=");
        stringBuffer.append(this.f55825p);
        stringBuffer.append(", mIsLocalVideo=");
        stringBuffer.append(this.f55826q);
        stringBuffer.append(", mRealPlayUrl='");
        stringBuffer.append(this.f55827r);
        stringBuffer.append('\'');
        stringBuffer.append(", mPlayVid='");
        stringBuffer.append(this.f55833x);
        stringBuffer.append('\'');
        stringBuffer.append(", mPredictSpeed=");
        stringBuffer.append(this.f55829t);
        stringBuffer.append('\'');
        stringBuffer.append(", mSelectUrlHitCache=");
        stringBuffer.append(this.f55830u);
        stringBuffer.append('\'');
        stringBuffer.append(", mHitPreloadCache=");
        stringBuffer.append(this.f55831v);
        stringBuffer.append('\'');
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
