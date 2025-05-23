package com.tencent.mobileqq.shortvideo;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class k extends q {

    /* renamed from: b, reason: collision with root package name */
    public String f288039b;

    /* renamed from: e, reason: collision with root package name */
    public String f288042e;

    /* renamed from: f, reason: collision with root package name */
    public String f288043f;

    /* renamed from: g, reason: collision with root package name */
    public String f288044g;

    /* renamed from: h, reason: collision with root package name */
    public long f288045h;

    /* renamed from: j, reason: collision with root package name */
    public String f288047j;

    /* renamed from: k, reason: collision with root package name */
    public String f288048k;

    /* renamed from: l, reason: collision with root package name */
    public String f288049l;

    /* renamed from: c, reason: collision with root package name */
    public int f288040c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f288041d = -1;

    /* renamed from: i, reason: collision with root package name */
    public boolean f288046i = false;

    /* renamed from: m, reason: collision with root package name */
    public int f288050m = -1;

    public boolean b() {
        if (this.f288040c == -1) {
            a("ShortVideoBaseInfo.check", "reqBusiType invalid, reqBusiType:" + this.f288040c);
            return false;
        }
        if (this.f288041d == -1) {
            a("ShortVideoBaseInfo.check", "uinType invalid,uinType:" + this.f288041d);
            return false;
        }
        if (this.f288043f == null) {
            a("ShortVideoBaseInfo.check", "peerUin invalid,peerUin:" + this.f288043f);
            return false;
        }
        return true;
    }

    public String toString() {
        return "\nShortVideoBaseInfo\n |-localUUID:" + this.f288039b + "\n |-uniseq:" + this.f288045h + "\n |-reqBusiType:" + this.f288040c + "\n |-selfUin:" + this.f288042e + "\n |-peerUin:" + this.f288043f + "\n |-secondId:" + this.f288044g + "\n |-md5:" + this.f288047j + "\n |-thumbMD5:" + this.f288049l + "\n |-errInfo:" + this.f288214a;
    }
}
