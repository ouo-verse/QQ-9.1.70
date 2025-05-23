package com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data;

import com.tencent.qqlive.ona.protocol.jce.AdTempletItem;
import com.tencent.qqlive.ona.protocol.jce.InsideVideoSkipAdInfo;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<AdTempletItem> f303581a;

    /* renamed from: b, reason: collision with root package name */
    private vu2.a f303582b;

    /* renamed from: c, reason: collision with root package name */
    private InsideVideoSkipAdInfo f303583c;

    /* renamed from: d, reason: collision with root package name */
    private int f303584d = 0;

    /* renamed from: e, reason: collision with root package name */
    private boolean f303585e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f303586f = false;

    public a(ArrayList<AdTempletItem> arrayList, vu2.a aVar, InsideVideoSkipAdInfo insideVideoSkipAdInfo) {
        this.f303581a = arrayList;
        this.f303582b = aVar;
        this.f303583c = insideVideoSkipAdInfo;
    }

    public vu2.a a() {
        return this.f303582b;
    }

    public ArrayList<AdTempletItem> b() {
        return this.f303581a;
    }

    public InsideVideoSkipAdInfo c() {
        return this.f303583c;
    }
}
