package com.tencent.biz.pubaccount.weishi.verticalvideo.data;

import UserGrowth.stCollection;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaGdtAdInfo;

/* compiled from: P */
/* loaded from: classes32.dex */
public class j implements lz.a {

    /* renamed from: a, reason: collision with root package name */
    private stSimpleMetaFeed f82012a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f82013b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f82014c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f82015d;

    /* renamed from: e, reason: collision with root package name */
    private stSimpleMetaGdtAdInfo f82016e;

    /* renamed from: f, reason: collision with root package name */
    private ez.a f82017f;

    /* renamed from: g, reason: collision with root package name */
    private g f82018g;

    /* renamed from: h, reason: collision with root package name */
    private stCollection f82019h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f82020i;

    /* renamed from: j, reason: collision with root package name */
    private float f82021j = 1.0f;

    public stSimpleMetaGdtAdInfo a() {
        return this.f82016e;
    }

    public stCollection b() {
        return this.f82019h;
    }

    public boolean c() {
        return this.f82014c;
    }

    public g d() {
        return this.f82018g;
    }

    public stSimpleMetaFeed e() {
        return this.f82012a;
    }

    public ez.a f() {
        return this.f82017f;
    }

    public float g() {
        return this.f82021j;
    }

    public boolean h() {
        return this.f82013b;
    }

    public boolean i() {
        return this.f82016e != null;
    }

    @Override // lz.a
    public boolean isChecked() {
        return this.f82020i;
    }

    public boolean j() {
        return this.f82015d;
    }

    public void k(stSimpleMetaGdtAdInfo stsimplemetagdtadinfo) {
        this.f82016e = stsimplemetagdtadinfo;
    }

    public void l(stCollection stcollection) {
        this.f82019h = stcollection;
    }

    public void m(boolean z16) {
        this.f82014c = z16;
    }

    public void n(g gVar) {
        this.f82018g = gVar;
    }

    public void o(boolean z16) {
        this.f82013b = z16;
    }

    public void p(stSimpleMetaFeed stsimplemetafeed) {
        this.f82012a = stsimplemetafeed;
    }

    public void q(boolean z16) {
        this.f82015d = z16;
    }

    public void r(ez.a aVar) {
        this.f82017f = aVar;
    }

    public void s(float f16) {
        this.f82021j = f16;
    }

    @Override // lz.a
    public void setChecked(boolean z16) {
        this.f82020i = z16;
    }
}
