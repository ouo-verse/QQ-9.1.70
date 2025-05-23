package com.tencent.sqshow.zootopia.data;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import uv4.az;
import uv4.bc;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u000bB/\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0004\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0010\u001a\u0004\b\u000b\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0011R\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0011\u00a8\u0006 "}, d2 = {"Lcom/tencent/sqshow/zootopia/data/p;", "", "", "c", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "b", "()J", "itemId", "Ljava/lang/String;", "()Ljava/lang/String;", "coinIcon", "I", "getCoinCount", "()I", "coinCount", "d", "getItemIcon", "itemIcon", "e", "getLogoIcon", "logoIcon", "<init>", "(JLjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "f", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.data.p, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZootopiaPortalGiftData {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long itemId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String coinIcon;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int coinCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String itemIcon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final String logoIcon;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\t\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/p$a;", "", "Luv4/az;", "storeItem", "", "goldCoinIcon", "Lcom/tencent/sqshow/zootopia/data/p;", "a", "MATE_INFO", "Ljava/lang/String;", "MATE_INFO_COIN_ICON", "MATE_INFO_GIFT_IMG", "MATE_INFO_LOGO_ICON", "MATE_INFO_PRICE", "TAG", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.data.p$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZootopiaPortalGiftData a(az storeItem, String goldCoinIcon) {
            Intrinsics.checkNotNullParameter(storeItem, "storeItem");
            Intrinsics.checkNotNullParameter(goldCoinIcon, "goldCoinIcon");
            long j3 = storeItem.f440274a;
            bc bcVar = storeItem.f440287n;
            Intrinsics.checkNotNullExpressionValue(bcVar, "storeItem.price");
            int e16 = com.tencent.mobileqq.zootopia.utils.g.e(bcVar);
            String str = storeItem.f440279f;
            Intrinsics.checkNotNullExpressionValue(str, "storeItem.icon");
            String str2 = storeItem.f440282i;
            Intrinsics.checkNotNullExpressionValue(str2, "storeItem.brandLabel");
            return new ZootopiaPortalGiftData(j3, goldCoinIcon, e16, str, str2);
        }

        Companion() {
        }
    }

    public ZootopiaPortalGiftData(long j3, String coinIcon, int i3, String itemIcon, String logoIcon) {
        Intrinsics.checkNotNullParameter(coinIcon, "coinIcon");
        Intrinsics.checkNotNullParameter(itemIcon, "itemIcon");
        Intrinsics.checkNotNullParameter(logoIcon, "logoIcon");
        this.itemId = j3;
        this.coinIcon = coinIcon;
        this.coinCount = i3;
        this.itemIcon = itemIcon;
        this.logoIcon = logoIcon;
    }

    /* renamed from: a, reason: from getter */
    public final String getCoinIcon() {
        return this.coinIcon;
    }

    /* renamed from: b, reason: from getter */
    public final long getItemId() {
        return this.itemId;
    }

    public final String c() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("price", this.coinCount);
            jSONObject2.put("logo_icon", this.logoIcon);
            jSONObject2.put("coin_icon", this.coinIcon);
            jSONObject2.put("gift_img", this.itemIcon);
            jSONObject.put("info", jSONObject2);
            String jSONObject3 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "meta.toString()");
            return jSONObject3;
        } catch (Throwable th5) {
            QLog.e("ZootopiaPortalGiftData", 2, "getMeta throw t:" + th5.getMessage());
            return "";
        }
    }

    public int hashCode() {
        return (((((((com.tencent.mobileqq.vas.banner.c.a(this.itemId) * 31) + this.coinIcon.hashCode()) * 31) + this.coinCount) * 31) + this.itemIcon.hashCode()) * 31) + this.logoIcon.hashCode();
    }

    public String toString() {
        return "ZootopiaPortalGiftData(itemId=" + this.itemId + ", coinIcon=" + this.coinIcon + ", coinCount=" + this.coinCount + ", itemIcon=" + this.itemIcon + ", logoIcon=" + this.logoIcon + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaPortalGiftData)) {
            return false;
        }
        ZootopiaPortalGiftData zootopiaPortalGiftData = (ZootopiaPortalGiftData) other;
        return this.itemId == zootopiaPortalGiftData.itemId && Intrinsics.areEqual(this.coinIcon, zootopiaPortalGiftData.coinIcon) && this.coinCount == zootopiaPortalGiftData.coinCount && Intrinsics.areEqual(this.itemIcon, zootopiaPortalGiftData.itemIcon) && Intrinsics.areEqual(this.logoIcon, zootopiaPortalGiftData.logoIcon);
    }
}
