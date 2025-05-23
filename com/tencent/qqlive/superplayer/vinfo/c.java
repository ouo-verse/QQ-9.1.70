package com.tencent.qqlive.superplayer.vinfo;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqlive.superplayer.player.TVKMediaSource;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private Context f345585a;

    /* renamed from: b, reason: collision with root package name */
    private TVKMediaSource f345586b;

    /* renamed from: c, reason: collision with root package name */
    private TVKUserInfo f345587c;

    /* renamed from: d, reason: collision with root package name */
    private TVKPlayerVideoInfo f345588d;

    /* renamed from: e, reason: collision with root package name */
    private String f345589e;

    /* renamed from: f, reason: collision with root package name */
    private long f345590f;

    /* renamed from: g, reason: collision with root package name */
    private long f345591g;

    /* renamed from: h, reason: collision with root package name */
    private float f345592h;

    /* renamed from: i, reason: collision with root package name */
    private String f345593i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f345594j;

    /* renamed from: k, reason: collision with root package name */
    private float f345595k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f345596l;

    /* renamed from: m, reason: collision with root package name */
    private long f345597m;

    public c() {
        f();
    }

    private void f() {
        this.f345587c = null;
        this.f345588d = null;
        this.f345590f = 0L;
        this.f345591g = 0L;
        this.f345592h = 1.0f;
        this.f345593i = "";
        this.f345594j = false;
        this.f345595k = 1.0f;
        this.f345596l = false;
        this.f345597m = 0L;
    }

    public Context a() {
        return this.f345585a;
    }

    public void b(Context context) {
        this.f345585a = context;
    }

    public String c() {
        return this.f345593i;
    }

    public void d(String str) {
        if (str == null) {
            str = "";
        }
        this.f345593i = str;
    }

    public String e() {
        return this.f345589e;
    }

    public long g() {
        return this.f345597m;
    }

    public void h(@NonNull TVKMediaSource tVKMediaSource) {
        this.f345586b = tVKMediaSource;
        TVKUserInfo tVKUserInfo = this.f345587c;
        if (tVKUserInfo != null) {
            tVKMediaSource.a(tVKUserInfo.getCdnHttpHeader());
        }
    }

    public TVKUserInfo i() {
        return this.f345587c;
    }

    public void j(TVKUserInfo tVKUserInfo) {
        if (tVKUserInfo == null) {
            tVKUserInfo = new TVKUserInfo();
        }
        this.f345587c = tVKUserInfo;
        TVKMediaSource tVKMediaSource = this.f345586b;
        if (tVKMediaSource != null) {
            tVKMediaSource.a(tVKUserInfo.getCdnHttpHeader());
        }
    }

    public TVKPlayerVideoInfo k() {
        return this.f345588d;
    }

    public void l(TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        if (tVKPlayerVideoInfo == null) {
            tVKPlayerVideoInfo = new TVKPlayerVideoInfo();
        }
        this.f345588d = tVKPlayerVideoInfo;
        if (TextUtils.isEmpty(tVKPlayerVideoInfo.getCid())) {
            TVKPlayerVideoInfo tVKPlayerVideoInfo2 = this.f345588d;
            tVKPlayerVideoInfo2.setCid(tVKPlayerVideoInfo2.getVid());
        }
    }
}
