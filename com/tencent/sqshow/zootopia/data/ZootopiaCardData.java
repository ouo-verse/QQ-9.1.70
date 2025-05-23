package com.tencent.sqshow.zootopia.data;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u0000 E2\u00020\u0001:\u0001\tB\u00bd\u0001\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001b\u0012\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 \u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010&\u0012\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010 \u0012\u0010\b\u0002\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010 \u0012\b\b\u0002\u00103\u001a\u00020\u0004\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000104\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u000109\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010>\u00a2\u0006\u0004\bC\u0010DJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\fR\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0019R\u0017\u0010\u001f\u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001f\u0010%\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b\u0010\u0010$R\u0019\u0010+\u001a\u0004\u0018\u00010&8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0019\u0010-\u001a\u0004\u0018\u00010&8\u0006\u00a2\u0006\f\n\u0004\b,\u0010(\u001a\u0004\b'\u0010*R\u001f\u00100\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010 8\u0006\u00a2\u0006\f\n\u0004\b/\u0010#\u001a\u0004\b\u0017\u0010$R\u001f\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010 8\u0006\u00a2\u0006\f\n\u0004\b)\u0010#\u001a\u0004\b\"\u0010$R\u0017\u00103\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\n\u001a\u0004\b\t\u0010\fR\u0019\u00108\u001a\u0004\u0018\u0001048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u00105\u001a\u0004\b6\u00107R\u0019\u0010=\u001a\u0004\u0018\u0001098\u0006\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b/\u0010<R\u0019\u0010B\u001a\u0004\u0018\u00010>8\u0006\u00a2\u0006\f\n\u0004\b?\u0010@\u001a\u0004\b,\u0010A\u00a8\u0006F"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "cardId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "type", "c", "getOriginalDataIndex", "originalDataIndex", "d", "f", "inGroupSubIndex", "Lcom/tencent/sqshow/zootopia/data/d;", "e", "Lcom/tencent/sqshow/zootopia/data/d;", "()Lcom/tencent/sqshow/zootopia/data/d;", "groupData", "Lcom/tencent/sqshow/zootopia/data/e;", "Lcom/tencent/sqshow/zootopia/data/e;", "l", "()Lcom/tencent/sqshow/zootopia/data/e;", "titleData", "", "Lpv4/s;", "g", "Ljava/util/List;", "()Ljava/util/List;", "detailList", "Lcom/tencent/sqshow/zootopia/data/r;", tl.h.F, "Lcom/tencent/sqshow/zootopia/data/r;", "k", "()Lcom/tencent/sqshow/zootopia/data/r;", "tabConfig", "i", "parentListTabConfig", "Lpv4/f;", "j", "guideStatusList", "Lpv4/o;", "menuList", "autoTurnInterval", "Lpu4/n;", "Lpu4/n;", "getDressSquareInfo", "()Lpu4/n;", "dressSquareInfo", "Lpv4/x;", DomainData.DOMAIN_NAME, "Lpv4/x;", "()Lpv4/x;", "smallHomeData", "Lcom/tencent/sqshow/zootopia/data/o;", "o", "Lcom/tencent/sqshow/zootopia/data/o;", "()Lcom/tencent/sqshow/zootopia/data/o;", "partyRoomData", "<init>", "(IIIILcom/tencent/sqshow/zootopia/data/d;Lcom/tencent/sqshow/zootopia/data/e;Ljava/util/List;Lcom/tencent/sqshow/zootopia/data/r;Lcom/tencent/sqshow/zootopia/data/r;Ljava/util/List;Ljava/util/List;ILpu4/n;Lpv4/x;Lcom/tencent/sqshow/zootopia/data/o;)V", "p", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.data.c, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZootopiaCardData {

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int cardId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int originalDataIndex;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int inGroupSubIndex;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final ZootopiaCardGroupData groupData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final ZootopiaCardTitleData titleData;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<pv4.s> detailList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final ZootopiaTabConfigData tabConfig;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final ZootopiaTabConfigData parentListTabConfig;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<pv4.f> guideStatusList;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<pv4.o> menuList;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private final int autoTurnInterval;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private final pu4.n dressSquareInfo;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    private final pv4.x smallHomeData;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    private final ZootopiaPartyRoomData partyRoomData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ6\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/c$a;", "", "Lpv4/r;", "sceneIndexModule", "Lcom/tencent/sqshow/zootopia/data/r;", "parentListTabConfig", "", "originalDataIndex", "inGroupSubIndex", "Lcom/tencent/sqshow/zootopia/data/d;", "groupData", "Lcom/tencent/sqshow/zootopia/data/c;", "a", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.data.c$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        public final ZootopiaCardData a(pv4.r sceneIndexModule, ZootopiaTabConfigData parentListTabConfig, int originalDataIndex, int inGroupSubIndex, ZootopiaCardGroupData groupData) {
            Intrinsics.checkNotNullParameter(sceneIndexModule, "sceneIndexModule");
            int i3 = sceneIndexModule.f427661e;
            int a16 = k84.b.INSTANCE.a(sceneIndexModule.f427657a);
            ZootopiaCardTitleData zootopiaCardTitleData = new ZootopiaCardTitleData(sceneIndexModule.f427659c, sceneIndexModule.f427660d);
            pv4.s[] sVarArr = sceneIndexModule.f427671o;
            Intrinsics.checkNotNullExpressionValue(sVarArr, "sceneIndexModule.detailList");
            List list = ArraysKt.toList(sVarArr);
            String str = sceneIndexModule.f427662f;
            Intrinsics.checkNotNullExpressionValue(str, "sceneIndexModule.tabConfig");
            ZootopiaTabConfigData zootopiaTabConfigData = new ZootopiaTabConfigData(str);
            pv4.f[] fVarArr = sceneIndexModule.f427663g;
            List list2 = fVarArr != null ? ArraysKt.toList(fVarArr) : null;
            pv4.o[] oVarArr = sceneIndexModule.f427665i;
            Intrinsics.checkNotNullExpressionValue(oVarArr, "sceneIndexModule.menuList");
            List list3 = ArraysKt.toList(oVarArr);
            int i16 = sceneIndexModule.f427664h;
            pu4.n nVar = sceneIndexModule.f427672p;
            pv4.x xVar = sceneIndexModule.f427674r;
            int i17 = sceneIndexModule.f427661e;
            int i18 = sceneIndexModule.f427667k;
            pv4.h[] hVarArr = sceneIndexModule.f427675s;
            Intrinsics.checkNotNullExpressionValue(hVarArr, "sceneIndexModule.partyRoomList");
            return new ZootopiaCardData(i3, a16, originalDataIndex, inGroupSubIndex, groupData, zootopiaCardTitleData, list, zootopiaTabConfigData, parentListTabConfig, list2, list3, i16, nVar, xVar, new ZootopiaPartyRoomData(i17, i18, ArraysKt.toList(hVarArr), sceneIndexModule.f427669m, sceneIndexModule.f427670n));
        }

        public static /* synthetic */ ZootopiaCardData b(Companion companion, pv4.r rVar, ZootopiaTabConfigData zootopiaTabConfigData, int i3, int i16, ZootopiaCardGroupData zootopiaCardGroupData, int i17, Object obj) {
            if ((i17 & 8) != 0) {
                i16 = 0;
            }
            int i18 = i16;
            if ((i17 & 16) != 0) {
                zootopiaCardGroupData = null;
            }
            return companion.a(rVar, zootopiaTabConfigData, i3, i18, zootopiaCardGroupData);
        }
    }

    public ZootopiaCardData(int i3, int i16, int i17, int i18, ZootopiaCardGroupData zootopiaCardGroupData, ZootopiaCardTitleData titleData, List<pv4.s> list, ZootopiaTabConfigData zootopiaTabConfigData, ZootopiaTabConfigData zootopiaTabConfigData2, List<pv4.f> list2, List<pv4.o> list3, int i19, pu4.n nVar, pv4.x xVar, ZootopiaPartyRoomData zootopiaPartyRoomData) {
        Intrinsics.checkNotNullParameter(titleData, "titleData");
        this.cardId = i3;
        this.type = i16;
        this.originalDataIndex = i17;
        this.inGroupSubIndex = i18;
        this.groupData = zootopiaCardGroupData;
        this.titleData = titleData;
        this.detailList = list;
        this.tabConfig = zootopiaTabConfigData;
        this.parentListTabConfig = zootopiaTabConfigData2;
        this.guideStatusList = list2;
        this.menuList = list3;
        this.autoTurnInterval = i19;
        this.dressSquareInfo = nVar;
        this.smallHomeData = xVar;
        this.partyRoomData = zootopiaPartyRoomData;
    }

    /* renamed from: a, reason: from getter */
    public final int getAutoTurnInterval() {
        return this.autoTurnInterval;
    }

    /* renamed from: b, reason: from getter */
    public final int getCardId() {
        return this.cardId;
    }

    public final List<pv4.s> c() {
        return this.detailList;
    }

    /* renamed from: d, reason: from getter */
    public final ZootopiaCardGroupData getGroupData() {
        return this.groupData;
    }

    public final List<pv4.f> e() {
        return this.guideStatusList;
    }

    /* renamed from: f, reason: from getter */
    public final int getInGroupSubIndex() {
        return this.inGroupSubIndex;
    }

    public final List<pv4.o> g() {
        return this.menuList;
    }

    /* renamed from: h, reason: from getter */
    public final ZootopiaTabConfigData getParentListTabConfig() {
        return this.parentListTabConfig;
    }

    public int hashCode() {
        int i3 = ((((((this.cardId * 31) + this.type) * 31) + this.originalDataIndex) * 31) + this.inGroupSubIndex) * 31;
        ZootopiaCardGroupData zootopiaCardGroupData = this.groupData;
        int hashCode = (((i3 + (zootopiaCardGroupData == null ? 0 : zootopiaCardGroupData.hashCode())) * 31) + this.titleData.hashCode()) * 31;
        List<pv4.s> list = this.detailList;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        ZootopiaTabConfigData zootopiaTabConfigData = this.tabConfig;
        int hashCode3 = (hashCode2 + (zootopiaTabConfigData == null ? 0 : zootopiaTabConfigData.hashCode())) * 31;
        ZootopiaTabConfigData zootopiaTabConfigData2 = this.parentListTabConfig;
        int hashCode4 = (hashCode3 + (zootopiaTabConfigData2 == null ? 0 : zootopiaTabConfigData2.hashCode())) * 31;
        List<pv4.f> list2 = this.guideStatusList;
        int hashCode5 = (hashCode4 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<pv4.o> list3 = this.menuList;
        int hashCode6 = (((hashCode5 + (list3 == null ? 0 : list3.hashCode())) * 31) + this.autoTurnInterval) * 31;
        pu4.n nVar = this.dressSquareInfo;
        int hashCode7 = (hashCode6 + (nVar == null ? 0 : nVar.hashCode())) * 31;
        pv4.x xVar = this.smallHomeData;
        int hashCode8 = (hashCode7 + (xVar == null ? 0 : xVar.hashCode())) * 31;
        ZootopiaPartyRoomData zootopiaPartyRoomData = this.partyRoomData;
        return hashCode8 + (zootopiaPartyRoomData != null ? zootopiaPartyRoomData.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final ZootopiaPartyRoomData getPartyRoomData() {
        return this.partyRoomData;
    }

    /* renamed from: j, reason: from getter */
    public final pv4.x getSmallHomeData() {
        return this.smallHomeData;
    }

    /* renamed from: k, reason: from getter */
    public final ZootopiaTabConfigData getTabConfig() {
        return this.tabConfig;
    }

    /* renamed from: l, reason: from getter */
    public final ZootopiaCardTitleData getTitleData() {
        return this.titleData;
    }

    /* renamed from: m, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public String toString() {
        return "ZootopiaCardData(cardId=" + this.cardId + ", type=" + this.type + ", originalDataIndex=" + this.originalDataIndex + ", inGroupSubIndex=" + this.inGroupSubIndex + ", groupData=" + this.groupData + ", titleData=" + this.titleData + ", detailList=" + this.detailList + ", tabConfig=" + this.tabConfig + ", parentListTabConfig=" + this.parentListTabConfig + ", guideStatusList=" + this.guideStatusList + ", menuList=" + this.menuList + ", autoTurnInterval=" + this.autoTurnInterval + ", dressSquareInfo=" + this.dressSquareInfo + ", smallHomeData=" + this.smallHomeData + ", partyRoomData=" + this.partyRoomData + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaCardData)) {
            return false;
        }
        ZootopiaCardData zootopiaCardData = (ZootopiaCardData) other;
        return this.cardId == zootopiaCardData.cardId && this.type == zootopiaCardData.type && this.originalDataIndex == zootopiaCardData.originalDataIndex && this.inGroupSubIndex == zootopiaCardData.inGroupSubIndex && Intrinsics.areEqual(this.groupData, zootopiaCardData.groupData) && Intrinsics.areEqual(this.titleData, zootopiaCardData.titleData) && Intrinsics.areEqual(this.detailList, zootopiaCardData.detailList) && Intrinsics.areEqual(this.tabConfig, zootopiaCardData.tabConfig) && Intrinsics.areEqual(this.parentListTabConfig, zootopiaCardData.parentListTabConfig) && Intrinsics.areEqual(this.guideStatusList, zootopiaCardData.guideStatusList) && Intrinsics.areEqual(this.menuList, zootopiaCardData.menuList) && this.autoTurnInterval == zootopiaCardData.autoTurnInterval && Intrinsics.areEqual(this.dressSquareInfo, zootopiaCardData.dressSquareInfo) && Intrinsics.areEqual(this.smallHomeData, zootopiaCardData.smallHomeData) && Intrinsics.areEqual(this.partyRoomData, zootopiaCardData.partyRoomData);
    }

    public /* synthetic */ ZootopiaCardData(int i3, int i16, int i17, int i18, ZootopiaCardGroupData zootopiaCardGroupData, ZootopiaCardTitleData zootopiaCardTitleData, List list, ZootopiaTabConfigData zootopiaTabConfigData, ZootopiaTabConfigData zootopiaTabConfigData2, List list2, List list3, int i19, pu4.n nVar, pv4.x xVar, ZootopiaPartyRoomData zootopiaPartyRoomData, int i26, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i16, (i26 & 4) != 0 ? 0 : i17, (i26 & 8) != 0 ? 0 : i18, (i26 & 16) != 0 ? null : zootopiaCardGroupData, (i26 & 32) != 0 ? new ZootopiaCardTitleData(new pv4.u(), new pv4.u()) : zootopiaCardTitleData, (i26 & 64) != 0 ? null : list, (i26 & 128) != 0 ? null : zootopiaTabConfigData, (i26 & 256) != 0 ? null : zootopiaTabConfigData2, (i26 & 512) != 0 ? null : list2, (i26 & 1024) != 0 ? null : list3, (i26 & 2048) != 0 ? 0 : i19, (i26 & 4096) != 0 ? null : nVar, (i26 & 8192) != 0 ? null : xVar, (i26 & 16384) != 0 ? null : zootopiaPartyRoomData);
    }
}
