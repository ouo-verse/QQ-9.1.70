package com.tencent.mobileqq.zplan.aigc.data;

import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uv4.az;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u000f\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u0002\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010+\u0012\b\b\u0002\u00100\u001a\u00020\u0004\u0012\b\b\u0002\u00105\u001a\u00020\u0001\u00a2\u0006\u0004\b6\u00107J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018R\u0017\u0010 \u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001f\u0010\u0013R\u0017\u0010!\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0015\u0010\u0018R\u0017\u0010#\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u0016\u001a\u0004\b\u0010\u0010\u0018R\u0017\u0010%\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b$\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0019\u0010*\u001a\u0004\u0018\u00010&8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b$\u0010)R\u0019\u0010.\u001a\u0004\u0018\u00010+8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010,\u001a\u0004\b'\u0010-R\u0017\u00100\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b/\u0010\u000b\u001a\u0004\b\"\u0010\rR\u0017\u00105\u001a\u00020\u00018\u0006\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/data/c;", "Lcom/tencent/mobileqq/zplan/aigc/data/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "c", "I", "i", "()I", "index", "", "d", "J", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()J", "ugcId", "e", "Ljava/lang/String;", "getClothName", "()Ljava/lang/String;", "clothName", "f", tl.h.F, "desc", "g", "clothImgUrl", "getOwnNum", "ownNum", MessageForQQStory.KEY_AUTHOR_NAME, "j", "authorHeaderUrl", "k", "authorUin", "Lcom/tencent/mobileqq/zplan/aigc/data/j;", "l", "Lcom/tencent/mobileqq/zplan/aigc/data/j;", "()Lcom/tencent/mobileqq/zplan/aigc/data/j;", "likeData", "Luv4/az;", "Luv4/az;", "()Luv4/az;", "storeItemInfo", DomainData.DOMAIN_NAME, "itemId", "o", "Lcom/tencent/mobileqq/zplan/aigc/data/b;", "getBasicInfo", "()Lcom/tencent/mobileqq/zplan/aigc/data/b;", "basicInfo", "<init>", "(IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/zplan/aigc/data/j;Luv4/az;ILcom/tencent/mobileqq/zplan/aigc/data/b;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.aigc.data.c, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class AIGCFeedItemInfo2 extends b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int index;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final long ugcId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final String clothName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final String desc;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final String clothImgUrl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final long ownNum;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final String authorName;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private final String authorHeaderUrl;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private final String authorUin;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private final LikeData likeData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private final az storeItemInfo;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    private final int itemId;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    private final b basicInfo;

    public AIGCFeedItemInfo2() {
        this(0, 0L, null, null, null, 0L, null, null, null, null, null, 0, null, InitSkin.DRAWABLE_COUNT, null);
    }

    /* renamed from: d, reason: from getter */
    public final String getAuthorHeaderUrl() {
        return this.authorHeaderUrl;
    }

    /* renamed from: e, reason: from getter */
    public final String getAuthorName() {
        return this.authorName;
    }

    /* renamed from: f, reason: from getter */
    public final String getAuthorUin() {
        return this.authorUin;
    }

    /* renamed from: g, reason: from getter */
    public final String getClothImgUrl() {
        return this.clothImgUrl;
    }

    /* renamed from: h, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    public int hashCode() {
        int a16 = ((((((((((((((((this.index * 31) + com.tencent.mobileqq.vas.banner.c.a(this.ugcId)) * 31) + this.clothName.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.clothImgUrl.hashCode()) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.ownNum)) * 31) + this.authorName.hashCode()) * 31) + this.authorHeaderUrl.hashCode()) * 31) + this.authorUin.hashCode()) * 31;
        LikeData likeData = this.likeData;
        int hashCode = (a16 + (likeData == null ? 0 : likeData.hashCode())) * 31;
        az azVar = this.storeItemInfo;
        return ((((hashCode + (azVar != null ? azVar.hashCode() : 0)) * 31) + this.itemId) * 31) + this.basicInfo.hashCode();
    }

    /* renamed from: i, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* renamed from: j, reason: from getter */
    public final int getItemId() {
        return this.itemId;
    }

    /* renamed from: k, reason: from getter */
    public final LikeData getLikeData() {
        return this.likeData;
    }

    /* renamed from: l, reason: from getter */
    public final az getStoreItemInfo() {
        return this.storeItemInfo;
    }

    /* renamed from: m, reason: from getter */
    public final long getUgcId() {
        return this.ugcId;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ AIGCFeedItemInfo2(int i3, long j3, String str, String str2, String str3, long j16, String str4, String str5, String str6, LikeData likeData, az azVar, int i16, b bVar, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r6, r3, r9, r10, r4, r11, r12, r13, r14, r15, r33, r0);
        int i18;
        b bVar2;
        int i19 = (i17 & 1) != 0 ? 0 : i3;
        long j17 = (i17 & 2) != 0 ? 0L : j3;
        String str7 = (i17 & 4) != 0 ? "" : str;
        String str8 = (i17 & 8) != 0 ? "" : str2;
        String str9 = (i17 & 16) != 0 ? "" : str3;
        long j18 = (i17 & 32) == 0 ? j16 : 0L;
        String str10 = (i17 & 64) != 0 ? "" : str4;
        String str11 = (i17 & 128) != 0 ? "" : str5;
        String str12 = (i17 & 256) != 0 ? "" : str6;
        LikeData likeData2 = (i17 & 512) != 0 ? null : likeData;
        az azVar2 = (i17 & 1024) == 0 ? azVar : null;
        int i26 = (i17 & 2048) != 0 ? 0 : i16;
        if ((i17 & 4096) != 0) {
            i18 = i26;
            bVar2 = new b(1, "");
        } else {
            i18 = i26;
            bVar2 = bVar;
        }
    }

    public String toString() {
        return "AIGCFeedItemInfo2(index=" + this.index + ", ugcId=" + this.ugcId + ", clothName=" + this.clothName + ", desc=" + this.desc + ", clothImgUrl=" + this.clothImgUrl + ", ownNum=" + this.ownNum + ", authorName=" + this.authorName + ", authorHeaderUrl=" + this.authorHeaderUrl + ", authorUin=" + this.authorUin + ", likeData=" + this.likeData + ", storeItemInfo=" + this.storeItemInfo + ", itemId=" + this.itemId + ", basicInfo=" + this.basicInfo + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIGCFeedItemInfo2(int i3, long j3, String clothName, String desc, String clothImgUrl, long j16, String authorName, String authorHeaderUrl, String authorUin, LikeData likeData, az azVar, int i16, b basicInfo) {
        super(basicInfo.getType(), basicInfo.getExtra());
        Intrinsics.checkNotNullParameter(clothName, "clothName");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(clothImgUrl, "clothImgUrl");
        Intrinsics.checkNotNullParameter(authorName, "authorName");
        Intrinsics.checkNotNullParameter(authorHeaderUrl, "authorHeaderUrl");
        Intrinsics.checkNotNullParameter(authorUin, "authorUin");
        Intrinsics.checkNotNullParameter(basicInfo, "basicInfo");
        this.index = i3;
        this.ugcId = j3;
        this.clothName = clothName;
        this.desc = desc;
        this.clothImgUrl = clothImgUrl;
        this.ownNum = j16;
        this.authorName = authorName;
        this.authorHeaderUrl = authorHeaderUrl;
        this.authorUin = authorUin;
        this.likeData = likeData;
        this.storeItemInfo = azVar;
        this.itemId = i16;
        this.basicInfo = basicInfo;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AIGCFeedItemInfo2)) {
            return false;
        }
        AIGCFeedItemInfo2 aIGCFeedItemInfo2 = (AIGCFeedItemInfo2) other;
        return this.index == aIGCFeedItemInfo2.index && this.ugcId == aIGCFeedItemInfo2.ugcId && Intrinsics.areEqual(this.clothName, aIGCFeedItemInfo2.clothName) && Intrinsics.areEqual(this.desc, aIGCFeedItemInfo2.desc) && Intrinsics.areEqual(this.clothImgUrl, aIGCFeedItemInfo2.clothImgUrl) && this.ownNum == aIGCFeedItemInfo2.ownNum && Intrinsics.areEqual(this.authorName, aIGCFeedItemInfo2.authorName) && Intrinsics.areEqual(this.authorHeaderUrl, aIGCFeedItemInfo2.authorHeaderUrl) && Intrinsics.areEqual(this.authorUin, aIGCFeedItemInfo2.authorUin) && Intrinsics.areEqual(this.likeData, aIGCFeedItemInfo2.likeData) && Intrinsics.areEqual(this.storeItemInfo, aIGCFeedItemInfo2.storeItemInfo) && this.itemId == aIGCFeedItemInfo2.itemId && Intrinsics.areEqual(this.basicInfo, aIGCFeedItemInfo2.basicInfo);
    }
}
