package com.tencent.sqshow.zootopia.data;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import qv4.bq;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010&\u001a\u00020\u0004\u0012\b\b\u0002\u0010)\u001a\u00020\u0004\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000102\u00a2\u0006\u0004\b9\u0010:J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0018\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010&\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b\u001a\u0010#\"\u0004\b$\u0010%R\"\u0010)\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\"\u001a\u0004\b\u000b\u0010#\"\u0004\b(\u0010%R$\u00101\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00108\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b!\u00105\"\u0004\b6\u00107\u00a8\u0006;"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/k;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/sqshow/zootopia/data/c;", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "setCardList", "(Ljava/util/List;)V", "cardList", "Lcom/tencent/sqshow/zootopia/data/r;", "Lcom/tencent/sqshow/zootopia/data/r;", "getTabConfig", "()Lcom/tencent/sqshow/zootopia/data/r;", "setTabConfig", "(Lcom/tencent/sqshow/zootopia/data/r;)V", "tabConfig", "Lcom/tencent/sqshow/zootopia/data/i;", "c", "Lcom/tencent/sqshow/zootopia/data/i;", "getFaceAdListData", "()Lcom/tencent/sqshow/zootopia/data/i;", "setFaceAdListData", "(Lcom/tencent/sqshow/zootopia/data/i;)V", "faceAdListData", "d", "I", "()I", "setMailReddotId", "(I)V", "mailReddotId", "e", "setBagReddotId", "bagReddotId", "Lcom/tencent/sqshow/zootopia/data/j;", "f", "Lcom/tencent/sqshow/zootopia/data/j;", "getGuideListData", "()Lcom/tencent/sqshow/zootopia/data/j;", "setGuideListData", "(Lcom/tencent/sqshow/zootopia/data/j;)V", "guideListData", "Lqv4/bq;", "g", "Lqv4/bq;", "()Lqv4/bq;", "setUgcEnterInfo", "(Lqv4/bq;)V", "ugcEnterInfo", "<init>", "(Ljava/util/List;Lcom/tencent/sqshow/zootopia/data/r;Lcom/tencent/sqshow/zootopia/data/i;IILcom/tencent/sqshow/zootopia/data/j;Lqv4/bq;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.data.k, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZootopiaMainRecommendListData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private List<ZootopiaCardData> cardList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private ZootopiaTabConfigData tabConfig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private ZootopiaFaceAdListData faceAdListData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int mailReddotId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private int bagReddotId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private ZootopiaGuideListData guideListData;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private bq ugcEnterInfo;

    public ZootopiaMainRecommendListData() {
        this(null, null, null, 0, 0, null, null, 127, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getBagReddotId() {
        return this.bagReddotId;
    }

    public final List<ZootopiaCardData> b() {
        return this.cardList;
    }

    /* renamed from: c, reason: from getter */
    public final int getMailReddotId() {
        return this.mailReddotId;
    }

    /* renamed from: d, reason: from getter */
    public final bq getUgcEnterInfo() {
        return this.ugcEnterInfo;
    }

    public int hashCode() {
        int hashCode = this.cardList.hashCode() * 31;
        ZootopiaTabConfigData zootopiaTabConfigData = this.tabConfig;
        int hashCode2 = (hashCode + (zootopiaTabConfigData == null ? 0 : zootopiaTabConfigData.hashCode())) * 31;
        ZootopiaFaceAdListData zootopiaFaceAdListData = this.faceAdListData;
        int hashCode3 = (((((hashCode2 + (zootopiaFaceAdListData == null ? 0 : zootopiaFaceAdListData.hashCode())) * 31) + this.mailReddotId) * 31) + this.bagReddotId) * 31;
        ZootopiaGuideListData zootopiaGuideListData = this.guideListData;
        int hashCode4 = (hashCode3 + (zootopiaGuideListData == null ? 0 : zootopiaGuideListData.hashCode())) * 31;
        bq bqVar = this.ugcEnterInfo;
        return hashCode4 + (bqVar != null ? bqVar.hashCode() : 0);
    }

    public String toString() {
        return "ZootopiaMainRecommendListData(cardList=" + this.cardList + ", tabConfig=" + this.tabConfig + ", faceAdListData=" + this.faceAdListData + ", mailReddotId=" + this.mailReddotId + ", bagReddotId=" + this.bagReddotId + ", guideListData=" + this.guideListData + ", ugcEnterInfo=" + this.ugcEnterInfo + ")";
    }

    public ZootopiaMainRecommendListData(List<ZootopiaCardData> cardList, ZootopiaTabConfigData zootopiaTabConfigData, ZootopiaFaceAdListData zootopiaFaceAdListData, int i3, int i16, ZootopiaGuideListData zootopiaGuideListData, bq bqVar) {
        Intrinsics.checkNotNullParameter(cardList, "cardList");
        this.cardList = cardList;
        this.tabConfig = zootopiaTabConfigData;
        this.faceAdListData = zootopiaFaceAdListData;
        this.mailReddotId = i3;
        this.bagReddotId = i16;
        this.guideListData = zootopiaGuideListData;
        this.ugcEnterInfo = bqVar;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaMainRecommendListData)) {
            return false;
        }
        ZootopiaMainRecommendListData zootopiaMainRecommendListData = (ZootopiaMainRecommendListData) other;
        return Intrinsics.areEqual(this.cardList, zootopiaMainRecommendListData.cardList) && Intrinsics.areEqual(this.tabConfig, zootopiaMainRecommendListData.tabConfig) && Intrinsics.areEqual(this.faceAdListData, zootopiaMainRecommendListData.faceAdListData) && this.mailReddotId == zootopiaMainRecommendListData.mailReddotId && this.bagReddotId == zootopiaMainRecommendListData.bagReddotId && Intrinsics.areEqual(this.guideListData, zootopiaMainRecommendListData.guideListData) && Intrinsics.areEqual(this.ugcEnterInfo, zootopiaMainRecommendListData.ugcEnterInfo);
    }

    public /* synthetic */ ZootopiaMainRecommendListData(List list, ZootopiaTabConfigData zootopiaTabConfigData, ZootopiaFaceAdListData zootopiaFaceAdListData, int i3, int i16, ZootopiaGuideListData zootopiaGuideListData, bq bqVar, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? new ArrayList() : list, (i17 & 2) != 0 ? null : zootopiaTabConfigData, (i17 & 4) != 0 ? null : zootopiaFaceAdListData, (i17 & 8) != 0 ? 0 : i3, (i17 & 16) != 0 ? 0 : i16, (i17 & 32) != 0 ? null : zootopiaGuideListData, (i17 & 64) == 0 ? bqVar : null);
    }
}
