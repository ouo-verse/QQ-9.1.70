package com.tencent.sqshow.zootopia.data;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u0000 W2\u00020\u0001:\u0001\nB\u00f3\u0001\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0%\u0012\b\b\u0002\u00100\u001a\u00020\u0004\u0012\b\b\u0002\u00102\u001a\u00020\t\u0012\b\b\u0002\u00105\u001a\u00020\t\u0012\u0012\b\u0002\u00109\u001a\f\u0012\u0006\u0012\u0004\u0018\u000106\u0018\u00010%\u0012\b\b\u0002\u0010=\u001a\u00020\t\u0012\b\b\u0002\u0010?\u001a\u00020\u0004\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0002\u0012\u0012\b\u0002\u0010J\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010G\u0018\u00010%\u0012\u0010\b\u0002\u0010M\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010%\u0012\u0010\b\u0002\u0010Q\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010%\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\bU\u0010VJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010!\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR$\u0010$\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0019\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR*\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00100\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b.\u0010\u0014\"\u0004\b/\u0010\u0016R\"\u00102\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b1\u0010\u000fR\"\u00105\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b4\u0010\u000fR,\u00109\u001a\f\u0012\u0006\u0012\u0004\u0018\u000106\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010(\u001a\u0004\b7\u0010*\"\u0004\b8\u0010,R\"\u0010=\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010\u000b\u001a\u0004\b;\u0010\r\"\u0004\b<\u0010\u000fR\"\u0010?\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\u0012\u001a\u0004\b:\u0010\u0014\"\u0004\b>\u0010\u0016R$\u0010B\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010\u0019\u001a\u0004\b@\u0010\u001b\"\u0004\bA\u0010\u001dR$\u0010F\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010\u0019\u001a\u0004\bD\u0010\u001b\"\u0004\bE\u0010\u001dR,\u0010J\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010G\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010(\u001a\u0004\b3\u0010*\"\u0004\bI\u0010,R*\u0010M\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010(\u001a\u0004\b'\u0010*\"\u0004\bL\u0010,R*\u0010Q\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010(\u001a\u0004\bO\u0010*\"\u0004\bP\u0010,R$\u0010T\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010\u0019\u001a\u0004\bC\u0010\u001b\"\u0004\bS\u0010\u001d\u00a8\u0006X"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/s;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "getBlindId", "()J", "setBlindId", "(J)V", "blindId", "b", "I", "e", "()I", "setBlindStatus", "(I)V", "blindStatus", "c", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setBlindDesc", "(Ljava/lang/String;)V", "blindDesc", "g", "setIconDefault", "iconDefault", tl.h.F, "setIconOpen", "iconOpen", "", "Lcom/tencent/sqshow/zootopia/data/w;", "f", "Ljava/util/List;", "l", "()Ljava/util/List;", "setRewardList", "(Ljava/util/List;)V", "rewardList", "j", "setQuestAmount", "questAmount", "setBlindBoxStartTime", "blindBoxStartTime", "i", "setBlindBoxEndTime", "blindBoxEndTime", "Lxv4/f;", "getDropReward", "setDropReward", "dropReward", "k", "getUin", "setUin", "uin", "setQuestCurrentCnt", "questCurrentCnt", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setRuleDesc", "ruleDesc", DomainData.DOMAIN_NAME, "getJumpTitle", "setJumpTitle", "jumpTitle", "Lxv4/ab;", "o", "setMaterialList", "materialList", "p", "setBoxMaterialList", "boxMaterialList", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "getSpMaterialList", "setSpMaterialList", "spMaterialList", "r", "setToastMsg", "toastMsg", "<init>", "(JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;IJJLjava/util/List;JILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", ReportConstant.COSTREPORT_PREFIX, "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.data.s, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZootopiaTaskBlindBoxData {

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: t, reason: collision with root package name */
    private static ZootopiaTaskBlindBoxData f370396t = new ZootopiaTaskBlindBoxData(0, 0, null, null, null, null, 0, 0, 0, null, 0, 0, null, null, null, null, null, null, 262143, null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private long blindId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int blindStatus;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private String blindDesc;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private String iconDefault;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private String iconOpen;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private List<ZootopiaTaskRewardInfo> rewardList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private int questAmount;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private long blindBoxStartTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private long blindBoxEndTime;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private List<xv4.f> dropReward;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private long uin;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private int questCurrentCnt;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private String ruleDesc;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    private String jumpTitle;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    private List<xv4.ab> materialList;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata and from toString */
    private List<xv4.ab> boxMaterialList;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata and from toString */
    private List<xv4.ab> spMaterialList;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata and from toString */
    private String toastMsg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J \u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tR\"\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/s$a;", "", "Lxv4/a;", "info", "Lcom/tencent/sqshow/zootopia/data/s;", "a", "Lxv4/n;", "rsp", "c", "", "Lxv4/ab;", "spMaterialList", "b", "DEFAULT_DATA", "Lcom/tencent/sqshow/zootopia/data/s;", "d", "()Lcom/tencent/sqshow/zootopia/data/s;", "setDEFAULT_DATA", "(Lcom/tencent/sqshow/zootopia/data/s;)V", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.data.s$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZootopiaTaskBlindBoxData d() {
            return ZootopiaTaskBlindBoxData.f370396t;
        }

        Companion() {
        }

        public final ZootopiaTaskBlindBoxData a(xv4.a info) {
            List<xv4.ab> emptyList;
            if (info != null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return b(info, emptyList);
            }
            return d();
        }

        public final ZootopiaTaskBlindBoxData c(xv4.n rsp) {
            List<xv4.ab> asList;
            if (rsp == null) {
                return d();
            }
            xv4.a aVar = rsp.f448812a;
            xv4.ab[] abVarArr = rsp.f448813b;
            Intrinsics.checkNotNullExpressionValue(abVarArr, "rsp.getBlindSpMaterial");
            asList = ArraysKt___ArraysJvmKt.asList(abVarArr);
            return b(aVar, asList);
        }

        public final ZootopiaTaskBlindBoxData b(xv4.a info, List<xv4.ab> spMaterialList) {
            List asList;
            List asList2;
            List asList3;
            if (info == null) {
                return d();
            }
            long j3 = info.f448747a;
            int i3 = info.f448748b;
            String str = info.f448749c;
            String str2 = info.f448750d;
            String str3 = info.f448751e;
            xv4.z[] zVarArr = info.f448752f;
            Intrinsics.checkNotNullExpressionValue(zVarArr, "info.rewardList");
            ArrayList arrayList = new ArrayList(zVarArr.length);
            for (xv4.z zVar : zVarArr) {
                arrayList.add(ZootopiaTaskRewardInfo.INSTANCE.a(zVar));
            }
            int i16 = info.f448753g;
            long j16 = info.f448754h;
            long j17 = info.f448755i;
            xv4.f[] fVarArr = info.f448756j;
            Intrinsics.checkNotNullExpressionValue(fVarArr, "info.dropReward");
            asList = ArraysKt___ArraysJvmKt.asList(fVarArr);
            long j18 = info.f448757k;
            int i17 = info.f448758l;
            String str4 = info.f448760n;
            String str5 = info.f448759m;
            xv4.ab[] abVarArr = info.f448761o;
            Intrinsics.checkNotNullExpressionValue(abVarArr, "info.spMaterial");
            asList2 = ArraysKt___ArraysJvmKt.asList(abVarArr);
            xv4.ab[] abVarArr2 = info.f448762p;
            Intrinsics.checkNotNullExpressionValue(abVarArr2, "info.boxMaterial");
            asList3 = ArraysKt___ArraysJvmKt.asList(abVarArr2);
            return new ZootopiaTaskBlindBoxData(j3, i3, str, str2, str3, arrayList, i16, j16, j17, asList, j18, i17, str4, str5, asList2, asList3, spMaterialList, info.f448763q);
        }
    }

    public ZootopiaTaskBlindBoxData() {
        this(0L, 0, null, null, null, null, 0, 0L, 0L, null, 0L, 0, null, null, null, null, null, null, 262143, null);
    }

    /* renamed from: b, reason: from getter */
    public final long getBlindBoxEndTime() {
        return this.blindBoxEndTime;
    }

    /* renamed from: c, reason: from getter */
    public final long getBlindBoxStartTime() {
        return this.blindBoxStartTime;
    }

    /* renamed from: d, reason: from getter */
    public final String getBlindDesc() {
        return this.blindDesc;
    }

    /* renamed from: e, reason: from getter */
    public final int getBlindStatus() {
        return this.blindStatus;
    }

    public final List<xv4.ab> f() {
        return this.boxMaterialList;
    }

    /* renamed from: g, reason: from getter */
    public final String getIconDefault() {
        return this.iconDefault;
    }

    /* renamed from: h, reason: from getter */
    public final String getIconOpen() {
        return this.iconOpen;
    }

    public int hashCode() {
        int a16 = ((com.tencent.mobileqq.vas.banner.c.a(this.blindId) * 31) + this.blindStatus) * 31;
        String str = this.blindDesc;
        int hashCode = (a16 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.iconDefault;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.iconOpen;
        int hashCode3 = (((((((((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.rewardList.hashCode()) * 31) + this.questAmount) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.blindBoxStartTime)) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.blindBoxEndTime)) * 31;
        List<xv4.f> list = this.dropReward;
        int hashCode4 = (((((hashCode3 + (list == null ? 0 : list.hashCode())) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.uin)) * 31) + this.questCurrentCnt) * 31;
        String str4 = this.ruleDesc;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.jumpTitle;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        List<xv4.ab> list2 = this.materialList;
        int hashCode7 = (hashCode6 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<xv4.ab> list3 = this.boxMaterialList;
        int hashCode8 = (hashCode7 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<xv4.ab> list4 = this.spMaterialList;
        int hashCode9 = (hashCode8 + (list4 == null ? 0 : list4.hashCode())) * 31;
        String str6 = this.toastMsg;
        return hashCode9 + (str6 != null ? str6.hashCode() : 0);
    }

    public final List<xv4.ab> i() {
        return this.materialList;
    }

    /* renamed from: j, reason: from getter */
    public final int getQuestAmount() {
        return this.questAmount;
    }

    /* renamed from: k, reason: from getter */
    public final int getQuestCurrentCnt() {
        return this.questCurrentCnt;
    }

    public final List<ZootopiaTaskRewardInfo> l() {
        return this.rewardList;
    }

    /* renamed from: m, reason: from getter */
    public final String getRuleDesc() {
        return this.ruleDesc;
    }

    /* renamed from: n, reason: from getter */
    public final String getToastMsg() {
        return this.toastMsg;
    }

    public ZootopiaTaskBlindBoxData(long j3, int i3, String str, String str2, String str3, List<ZootopiaTaskRewardInfo> rewardList, int i16, long j16, long j17, List<xv4.f> list, long j18, int i17, String str4, String str5, List<xv4.ab> list2, List<xv4.ab> list3, List<xv4.ab> list4, String str6) {
        Intrinsics.checkNotNullParameter(rewardList, "rewardList");
        this.blindId = j3;
        this.blindStatus = i3;
        this.blindDesc = str;
        this.iconDefault = str2;
        this.iconOpen = str3;
        this.rewardList = rewardList;
        this.questAmount = i16;
        this.blindBoxStartTime = j16;
        this.blindBoxEndTime = j17;
        this.dropReward = list;
        this.uin = j18;
        this.questCurrentCnt = i17;
        this.ruleDesc = str4;
        this.jumpTitle = str5;
        this.materialList = list2;
        this.boxMaterialList = list3;
        this.spMaterialList = list4;
        this.toastMsg = str6;
    }

    public String toString() {
        return "ZootopiaTaskBlindBoxData(blindId=" + this.blindId + ", blindStatus=" + this.blindStatus + ", blindDesc=" + this.blindDesc + ", iconDefault=" + this.iconDefault + ", iconOpen=" + this.iconOpen + ", rewardList=" + this.rewardList + ", questAmount=" + this.questAmount + ", blindBoxStartTime=" + this.blindBoxStartTime + ", blindBoxEndTime=" + this.blindBoxEndTime + ", dropReward=" + this.dropReward + ", uin=" + this.uin + ", questCurrentCnt=" + this.questCurrentCnt + ", ruleDesc=" + this.ruleDesc + ", jumpTitle=" + this.jumpTitle + ", materialList=" + this.materialList + ", boxMaterialList=" + this.boxMaterialList + ", spMaterialList=" + this.spMaterialList + ", toastMsg=" + this.toastMsg + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaTaskBlindBoxData)) {
            return false;
        }
        ZootopiaTaskBlindBoxData zootopiaTaskBlindBoxData = (ZootopiaTaskBlindBoxData) other;
        return this.blindId == zootopiaTaskBlindBoxData.blindId && this.blindStatus == zootopiaTaskBlindBoxData.blindStatus && Intrinsics.areEqual(this.blindDesc, zootopiaTaskBlindBoxData.blindDesc) && Intrinsics.areEqual(this.iconDefault, zootopiaTaskBlindBoxData.iconDefault) && Intrinsics.areEqual(this.iconOpen, zootopiaTaskBlindBoxData.iconOpen) && Intrinsics.areEqual(this.rewardList, zootopiaTaskBlindBoxData.rewardList) && this.questAmount == zootopiaTaskBlindBoxData.questAmount && this.blindBoxStartTime == zootopiaTaskBlindBoxData.blindBoxStartTime && this.blindBoxEndTime == zootopiaTaskBlindBoxData.blindBoxEndTime && Intrinsics.areEqual(this.dropReward, zootopiaTaskBlindBoxData.dropReward) && this.uin == zootopiaTaskBlindBoxData.uin && this.questCurrentCnt == zootopiaTaskBlindBoxData.questCurrentCnt && Intrinsics.areEqual(this.ruleDesc, zootopiaTaskBlindBoxData.ruleDesc) && Intrinsics.areEqual(this.jumpTitle, zootopiaTaskBlindBoxData.jumpTitle) && Intrinsics.areEqual(this.materialList, zootopiaTaskBlindBoxData.materialList) && Intrinsics.areEqual(this.boxMaterialList, zootopiaTaskBlindBoxData.boxMaterialList) && Intrinsics.areEqual(this.spMaterialList, zootopiaTaskBlindBoxData.spMaterialList) && Intrinsics.areEqual(this.toastMsg, zootopiaTaskBlindBoxData.toastMsg);
    }

    public /* synthetic */ ZootopiaTaskBlindBoxData(long j3, int i3, String str, String str2, String str3, List list, int i16, long j16, long j17, List list2, long j18, int i17, String str4, String str5, List list3, List list4, List list5, String str6, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? 0L : j3, (i18 & 2) != 0 ? 0 : i3, (i18 & 4) != 0 ? null : str, (i18 & 8) != 0 ? null : str2, (i18 & 16) != 0 ? null : str3, (i18 & 32) != 0 ? new ArrayList() : list, (i18 & 64) != 0 ? 0 : i16, (i18 & 128) != 0 ? 0L : j16, (i18 & 256) != 0 ? 0L : j17, (i18 & 512) != 0 ? new ArrayList() : list2, (i18 & 1024) != 0 ? 0L : j18, (i18 & 2048) == 0 ? i17 : 0, (i18 & 4096) != 0 ? null : str4, (i18 & 8192) != 0 ? null : str5, (i18 & 16384) != 0 ? null : list3, (i18 & 32768) != 0 ? null : list4, (i18 & 65536) != 0 ? null : list5, (i18 & 131072) != 0 ? null : str6);
    }
}
