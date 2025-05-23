package com.tencent.biz.qqcircle.tedgers2.datapool;

/* loaded from: classes5.dex */
public class DataPoolConfig {

    /* renamed from: a, reason: collision with root package name */
    public boolean f92464a = true;

    /* renamed from: b, reason: collision with root package name */
    public int f92465b = 30;

    /* renamed from: c, reason: collision with root package name */
    public int f92466c = 50;

    /* renamed from: d, reason: collision with root package name */
    public int f92467d = 12;

    /* renamed from: e, reason: collision with root package name */
    public int f92468e = 18;

    /* renamed from: f, reason: collision with root package name */
    public DetailType f92469f = DetailType.DETAIL_UPPER_DISABLE;

    /* renamed from: g, reason: collision with root package name */
    public long f92470g = 43200000;

    /* renamed from: h, reason: collision with root package name */
    public int f92471h = 30;

    /* renamed from: i, reason: collision with root package name */
    public int f92472i = 6;

    /* renamed from: j, reason: collision with root package name */
    public String f92473j;

    /* loaded from: classes5.dex */
    public enum DetailType {
        DETAIL_UPPER_DISABLE,
        DETAIL_UPPER_ENABLE
    }

    public String toString() {
        return "DataPoolConfig{mEnableRequestIndexAndDetail=" + this.f92464a + ", mItemIndexPoolLowLimit=" + this.f92465b + ", mItemIndexPoolUpperLimit=" + this.f92466c + ", mItemDetailPoolLowLimit=" + this.f92467d + ", mItemDetailPoolUpperLimit=" + this.f92468e + ", mDetailPoolUpperType=" + this.f92469f + ", mItemEffectiveTime=" + this.f92470g + ", mItemIndexRequestNum=" + this.f92471h + ", mItemDetailRequestNum=" + this.f92472i + ", mEdgeReRankAlgId='" + this.f92473j + "'}";
    }
}
