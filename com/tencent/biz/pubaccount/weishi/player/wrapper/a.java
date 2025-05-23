package com.tencent.biz.pubaccount.weishi.player.wrapper;

import com.tencent.biz.pubaccount.weishi.player.WSVideoPreDownloadManager;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public String f81192a;

    /* renamed from: b, reason: collision with root package name */
    public int f81193b;

    /* renamed from: c, reason: collision with root package name */
    public int f81194c;

    /* renamed from: d, reason: collision with root package name */
    public int f81195d;

    /* renamed from: e, reason: collision with root package name */
    public long f81196e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f81197f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f81198g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f81199h;

    public void a(com.tencent.biz.pubaccount.weishi.player.l lVar, int i3, boolean z16) {
        this.f81192a = lVar.f81171f;
        this.f81193b = lVar.f81179n;
        this.f81196e = lVar.f81170e;
        this.f81195d = lVar.f81169d;
        this.f81198g = lVar.f81187v;
        this.f81199h = lVar.f81188w;
        this.f81197f = z16;
        this.f81194c = i3;
    }

    public void b(WSVideoPreDownloadManager.c cVar, int i3) {
        this.f81192a = cVar.f81111b;
        this.f81196e = cVar.f81113d;
        this.f81195d = cVar.f81114e;
        this.f81198g = cVar.f81116g;
        this.f81199h = cVar.f81117h;
        this.f81194c = i3;
    }

    public abstract <V> V c();

    public abstract <V> V d();
}
