package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    protected long f266686a;

    /* renamed from: b, reason: collision with root package name */
    protected int f266687b;

    /* renamed from: g, reason: collision with root package name */
    protected long f266692g;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f266695j;

    /* renamed from: p, reason: collision with root package name */
    protected int f266701p;

    /* renamed from: c, reason: collision with root package name */
    protected String f266688c = "";

    /* renamed from: d, reason: collision with root package name */
    protected ep f266689d = new ep();

    /* renamed from: e, reason: collision with root package name */
    protected String f266690e = "";

    /* renamed from: f, reason: collision with root package name */
    protected String f266691f = "";

    /* renamed from: h, reason: collision with root package name */
    protected String f266693h = "";

    /* renamed from: i, reason: collision with root package name */
    protected byte[] f266694i = new byte[0];

    /* renamed from: k, reason: collision with root package name */
    protected ArrayList<da> f266696k = new ArrayList<>();

    /* renamed from: l, reason: collision with root package name */
    protected ay f266697l = new ay();

    /* renamed from: m, reason: collision with root package name */
    protected y f266698m = new y();

    /* renamed from: n, reason: collision with root package name */
    protected ArrayList<cz> f266699n = new ArrayList<>();

    /* renamed from: o, reason: collision with root package name */
    protected ArrayList<Long> f266700o = new ArrayList<>();

    public long a() {
        return this.f266692g;
    }

    public y b() {
        return this.f266698m;
    }

    public byte[] c() {
        return this.f266694i;
    }

    public long d() {
        return this.f266686a;
    }

    public ay e() {
        return this.f266697l;
    }

    public ArrayList<Long> f() {
        return this.f266700o;
    }

    public String g() {
        return this.f266690e;
    }

    public ArrayList<cz> h() {
        return this.f266699n;
    }

    public String i() {
        return this.f266691f;
    }

    public String j() {
        return this.f266688c;
    }

    public ArrayList<da> k() {
        return this.f266696k;
    }

    public int l() {
        return this.f266701p;
    }

    public boolean m() {
        return this.f266695j;
    }

    public int n() {
        return this.f266687b;
    }

    public ep o() {
        return this.f266689d;
    }

    public String p() {
        return this.f266693h;
    }

    public void q(long j3) {
        this.f266686a = j3;
    }

    public void r(ArrayList<Long> arrayList) {
        this.f266700o = arrayList;
    }

    public void s(ep epVar) {
        this.f266689d = epVar;
    }

    public String toString() {
        Object valueOf;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("GWGProCmd0xf67ReqBody{mGuildId=");
        sb5.append(this.f266686a);
        sb5.append("mSrcId=");
        sb5.append(this.f266687b);
        sb5.append("mJoinGuildSig=");
        sb5.append(this.f266688c);
        sb5.append("mSrcInfo=");
        sb5.append(this.f266689d);
        sb5.append("mJoinGuildAnswerPlaintext=");
        sb5.append(this.f266690e);
        sb5.append("mJoinGuildComment=");
        sb5.append(this.f266691f);
        sb5.append("mApplicantUin=");
        sb5.append(this.f266692g);
        sb5.append("mStrUuid=");
        sb5.append(this.f266693h);
        sb5.append("mExtData.length=");
        byte[] bArr = this.f266694i;
        if (bArr == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(bArr.length);
        }
        sb5.append(valueOf);
        sb5.append("mNotSendSystemNotice=");
        sb5.append(this.f266695j);
        sb5.append("mJoinGuildsList=");
        sb5.append(this.f266696k);
        sb5.append("mGuildInfoFilter=");
        sb5.append(this.f266697l);
        sb5.append("mChannelInfoFilter=");
        sb5.append(this.f266698m);
        sb5.append("mJoinGuildAnswers=");
        sb5.append(this.f266699n);
        sb5.append("mInvitedUinList=");
        sb5.append(this.f266700o);
        sb5.append("mNotSendBasicNotice=");
        sb5.append(this.f266701p);
        sb5.append("}");
        return sb5.toString();
    }
}
