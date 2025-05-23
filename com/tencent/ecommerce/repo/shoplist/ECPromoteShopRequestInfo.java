package com.tencent.ecommerce.repo.shoplist;

import com.tencent.ecommerce.base.list.f;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/repo/shoplist/b;", "Lcom/tencent/ecommerce/base/list/f;", "", "toString", "", "hashCode", "", "other", "", "equals", "c", "I", WadlProxyConsts.CHANNEL, "d", "scene", "", "e", "J", "ownerId", "<init>", "(IIJ)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.shoplist.b, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECPromoteShopRequestInfo extends f {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final int channel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final int scene;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final long ownerId;

    public ECPromoteShopRequestInfo(int i3, int i16, long j3) {
        this.channel = i3;
        this.scene = i16;
        this.ownerId = j3;
    }

    public int hashCode() {
        return (((this.channel * 31) + this.scene) * 31) + com.tencent.ecommerce.biz.commission.forecast.b.a(this.ownerId);
    }

    public String toString() {
        return "ECPromoteShopRequestInfo(channel=" + this.channel + ", scene=" + this.scene + ", ownerId=" + this.ownerId + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECPromoteShopRequestInfo)) {
            return false;
        }
        ECPromoteShopRequestInfo eCPromoteShopRequestInfo = (ECPromoteShopRequestInfo) other;
        return this.channel == eCPromoteShopRequestInfo.channel && this.scene == eCPromoteShopRequestInfo.scene && this.ownerId == eCPromoteShopRequestInfo.ownerId;
    }
}
