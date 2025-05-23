package com.tencent.mobileqq.shortvideo;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes18.dex */
public class n extends k {

    /* renamed from: n, reason: collision with root package name */
    public int f288190n;

    /* renamed from: o, reason: collision with root package name */
    public int f288191o;

    /* renamed from: p, reason: collision with root package name */
    public long f288192p;

    /* renamed from: q, reason: collision with root package name */
    public String f288193q;

    /* renamed from: r, reason: collision with root package name */
    public String f288194r;

    /* renamed from: s, reason: collision with root package name */
    public int f288195s;

    /* renamed from: t, reason: collision with root package name */
    public int f288196t;

    /* renamed from: u, reason: collision with root package name */
    public int f288197u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f288198v = false;

    /* renamed from: w, reason: collision with root package name */
    public int f288199w;

    @Override // com.tencent.mobileqq.shortvideo.k
    public boolean b() {
        if (TextUtils.isEmpty(this.f288039b)) {
            a("ShortVideoDownloadInfo.check", "uuid invaid:" + this.f288039b);
            return false;
        }
        if (this.f288042e == null) {
            a("ShortVideoDownloadInfo", "selfUin invalid,selfUin:" + this.f288042e);
            return false;
        }
        return super.b();
    }

    public void c(int i3, int i16) {
        if (i16 == 0) {
            if (i3 != 0 && i3 != 1008) {
                if (i3 == 3000) {
                    this.f288195s = 1005;
                    return;
                } else if (i3 == 1) {
                    this.f288195s = 1003;
                    return;
                } else {
                    if (i3 == 10014) {
                        this.f288195s = 1007;
                        return;
                    }
                    return;
                }
            }
            this.f288195s = 1001;
            return;
        }
        if (1 == i16) {
            if (i3 != 0 && i3 != 1008) {
                if (i3 == 3000) {
                    this.f288195s = 1006;
                    return;
                } else if (i3 == 1) {
                    this.f288195s = 1004;
                    return;
                } else {
                    if (i3 == 10014) {
                        this.f288195s = 1008;
                        return;
                    }
                    return;
                }
            }
            this.f288195s = 1002;
        }
    }

    public String d() {
        return "\nShortVideoDownloadInfo\n |-md5:" + this.f288047j + "\n |-uuid:" + this.f288039b + "\n |-fileType:" + this.f288195s + "\n |-format:" + this.f288191o + "\n |-mRequestType:" + this.f288196t + "\n |-mSceneType:" + this.f288197u + "\n |-mTargetVideoCodecFormat:" + this.f288199w + "\n |-mSourceVideoCodecFormat:" + this.f288050m;
    }

    @Override // com.tencent.mobileqq.shortvideo.k
    public String toString() {
        return d() + super.toString();
    }
}
