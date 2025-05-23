package com.tencent.sqshow.zootopia.data;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0011\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "goldCoin", "b", "GoldCoinRet", "c", "silverCoin", "d", "SilverCoinRet", "<init>", "(IIII)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final /* data */ class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int goldCoin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int GoldCoinRet;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int silverCoin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int SilverCoinRet;

    public f(int i3, int i16, int i17, int i18) {
        this.goldCoin = i3;
        this.GoldCoinRet = i16;
        this.silverCoin = i17;
        this.SilverCoinRet = i18;
    }

    /* renamed from: a, reason: from getter */
    public final int getGoldCoin() {
        return this.goldCoin;
    }

    /* renamed from: b, reason: from getter */
    public final int getGoldCoinRet() {
        return this.GoldCoinRet;
    }

    /* renamed from: c, reason: from getter */
    public final int getSilverCoin() {
        return this.silverCoin;
    }

    /* renamed from: d, reason: from getter */
    public final int getSilverCoinRet() {
        return this.SilverCoinRet;
    }

    public int hashCode() {
        return (((((this.goldCoin * 31) + this.GoldCoinRet) * 31) + this.silverCoin) * 31) + this.SilverCoinRet;
    }

    public String toString() {
        return "goldCoin: " + this.goldCoin + ", goldCoinRet " + this.GoldCoinRet + ", silverCoin " + this.silverCoin + ", silverCoinRet: " + this.SilverCoinRet + "  ";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof f)) {
            return false;
        }
        f fVar = (f) other;
        return this.goldCoin == fVar.goldCoin && this.GoldCoinRet == fVar.GoldCoinRet && this.silverCoin == fVar.silverCoin && this.SilverCoinRet == fVar.SilverCoinRet;
    }
}
