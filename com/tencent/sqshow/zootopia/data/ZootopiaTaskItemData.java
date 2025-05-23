package com.tencent.sqshow.zootopia.data;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b2\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b#\b\u0086\b\u0018\u0000 _2\u00020\u0001:\u0001\nB\u00e9\u0001\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0004\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\t\u0012\b\b\u0002\u0010)\u001a\u00020\t\u0012\b\b\u0002\u0010-\u001a\u00020\u0004\u0012\b\b\u0002\u00100\u001a\u00020\u0004\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u00107\u001a\u00020\u0004\u0012\b\b\u0002\u0010;\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010C\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010=0<\u0012\b\b\u0002\u0010G\u001a\u00020\t\u0012\b\b\u0002\u0010K\u001a\u00020\t\u0012\b\b\u0002\u0010N\u001a\u00020\u0004\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010U\u001a\u00020\t\u0012\u0010\b\u0002\u0010Y\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010<\u0012\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b]\u0010^J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010%\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR\"\u0010)\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u000b\u001a\u0004\b'\u0010\r\"\u0004\b(\u0010\u000fR\"\u0010-\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\u0012\u001a\u0004\b+\u0010\u0014\"\u0004\b,\u0010\u0016R\"\u00100\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\u0012\u001a\u0004\b.\u0010\u0014\"\u0004\b/\u0010\u0016R$\u00102\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u001d\u001a\u0004\b*\u0010\u001f\"\u0004\b1\u0010!R$\u00104\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001d\u001a\u0004\b\u0018\u0010\u001f\"\u0004\b3\u0010!R\"\u00107\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010\u0012\u001a\u0004\b\n\u0010\u0014\"\u0004\b6\u0010\u0016R\"\u0010;\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010\u0012\u001a\u0004\b9\u0010\u0014\"\u0004\b:\u0010\u0016R*\u0010C\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010=0<8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b5\u0010@\"\u0004\bA\u0010BR\"\u0010G\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010\u000b\u001a\u0004\bE\u0010\r\"\u0004\bF\u0010\u000fR\"\u0010K\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010\u000b\u001a\u0004\bI\u0010\r\"\u0004\bJ\u0010\u000fR\"\u0010N\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010\u0012\u001a\u0004\b\u0011\u0010\u0014\"\u0004\bM\u0010\u0016R$\u0010Q\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010\u001d\u001a\u0004\b&\u0010\u001f\"\u0004\bP\u0010!R\"\u0010U\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010\u000b\u001a\u0004\bS\u0010\r\"\u0004\bT\u0010\u000fR*\u0010Y\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010<8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010?\u001a\u0004\bW\u0010@\"\u0004\bX\u0010BR$\u0010\\\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bZ\u0010\u001d\u001a\u0004\b\u001c\u0010\u001f\"\u0004\b[\u0010!\u00a8\u0006`"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/v;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "e", "()J", "setQuestId", "(J)V", "questId", "b", "I", "i", "()I", "setQuestStatus", "(I)V", "questStatus", "c", "getQuestType", "setQuestType", "questType", "d", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "setQuestTitle", "(Ljava/lang/String;)V", "questTitle", "getStartTime", "setStartTime", "startTime", "f", "getEndTime", "setEndTime", "endTime", "g", "getRefreshType", "setRefreshType", "refreshType", tl.h.F, "setQuestJumpType", "questJumpType", "setQuestJumpTitle", "questJumpTitle", "setQuestDesc", "questDesc", "k", "setQuestAmount", "questAmount", "l", "getQuestPriority", "setQuestPriority", "questPriority", "", "Lcom/tencent/sqshow/zootopia/data/w;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "()Ljava/util/List;", "setRewardList", "(Ljava/util/List;)V", "rewardList", DomainData.DOMAIN_NAME, "getUin", "setUin", "uin", "o", "getTaskId", "setTaskId", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "p", "setQuestCurrentCnt", "questCurrentCnt", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "setQuestJumpSchema", "questJumpSchema", "r", "getLastUpdateTime", "setLastUpdateTime", WadlProxyConsts.LAST_UPDATE_TIME, ReportConstant.COSTREPORT_PREFIX, "getExtParam", "setExtParam", "extParam", "t", "setQuestIcon", "questIcon", "<init>", "(JIILjava/lang/String;JJIILjava/lang/String;Ljava/lang/String;IILjava/util/List;JJILjava/lang/String;JLjava/util/List;Ljava/lang/String;)V", "u", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.data.v, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZootopiaTaskItemData {

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: v, reason: collision with root package name */
    private static final ZootopiaTaskItemData f370432v = new ZootopiaTaskItemData(0, 0, 0, null, 0, 0, 0, 0, null, null, 0, 0, null, 0, 0, 0, null, 0, null, null, 1048575, null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private long questId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int questStatus;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int questType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private String questTitle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private long startTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private long endTime;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private int refreshType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private int questJumpType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private String questJumpTitle;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private String questDesc;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private int questAmount;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private int questPriority;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private List<ZootopiaTaskRewardInfo> rewardList;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    private long uin;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    private long taskId;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata and from toString */
    private int questCurrentCnt;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata and from toString */
    private String questJumpSchema;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata and from toString */
    private long lastUpdateTime;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata and from toString */
    private List<String> extParam;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata and from toString */
    private String questIcon;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/v$a;", "", "Lxv4/w;", "info", "Lcom/tencent/sqshow/zootopia/data/v;", "a", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.data.v$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        public final ZootopiaTaskItemData a(xv4.w info) {
            List list;
            Intrinsics.checkNotNullParameter(info, "info");
            long j3 = info.f448832a;
            int i3 = info.f448833b;
            int i16 = info.f448834c;
            String str = info.f448835d;
            long j16 = info.f448836e;
            long j17 = info.f448837f;
            int i17 = info.f448838g;
            int i18 = info.f448839h;
            String str2 = info.f448840i;
            String str3 = info.f448841j;
            int i19 = info.f448842k;
            int i26 = info.f448843l;
            xv4.z[] zVarArr = info.f448844m;
            Intrinsics.checkNotNullExpressionValue(zVarArr, "info.rewardList");
            ArrayList arrayList = new ArrayList(zVarArr.length);
            int length = zVarArr.length;
            int i27 = 0;
            while (i27 < length) {
                arrayList.add(ZootopiaTaskRewardInfo.INSTANCE.a(zVarArr[i27]));
                i27++;
                length = length;
                zVarArr = zVarArr;
            }
            long j18 = info.f448845n;
            long j19 = info.f448846o;
            int i28 = info.f448847p;
            String str4 = info.f448848q;
            long j26 = info.f448849r;
            String[] strArr = info.f448850s;
            Intrinsics.checkNotNullExpressionValue(strArr, "info.extParam");
            list = ArraysKt___ArraysKt.toList(strArr);
            return new ZootopiaTaskItemData(j3, i3, i16, str, j16, j17, i17, i18, str2, str3, i19, i26, arrayList, j18, j19, i28, str4, j26, list instanceof ArrayList ? (ArrayList) list : null, info.f448851t);
        }
    }

    public ZootopiaTaskItemData() {
        this(0L, 0, 0, null, 0L, 0L, 0, 0, null, null, 0, 0, null, 0L, 0L, 0, null, 0L, null, null, 1048575, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getQuestAmount() {
        return this.questAmount;
    }

    /* renamed from: b, reason: from getter */
    public final int getQuestCurrentCnt() {
        return this.questCurrentCnt;
    }

    /* renamed from: c, reason: from getter */
    public final String getQuestDesc() {
        return this.questDesc;
    }

    /* renamed from: d, reason: from getter */
    public final String getQuestIcon() {
        return this.questIcon;
    }

    /* renamed from: e, reason: from getter */
    public final long getQuestId() {
        return this.questId;
    }

    /* renamed from: f, reason: from getter */
    public final String getQuestJumpSchema() {
        return this.questJumpSchema;
    }

    /* renamed from: g, reason: from getter */
    public final String getQuestJumpTitle() {
        return this.questJumpTitle;
    }

    /* renamed from: h, reason: from getter */
    public final int getQuestJumpType() {
        return this.questJumpType;
    }

    public int hashCode() {
        int a16 = ((((com.tencent.mobileqq.vas.banner.c.a(this.questId) * 31) + this.questStatus) * 31) + this.questType) * 31;
        String str = this.questTitle;
        int hashCode = (((((((((a16 + (str == null ? 0 : str.hashCode())) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.startTime)) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.endTime)) * 31) + this.refreshType) * 31) + this.questJumpType) * 31;
        String str2 = this.questJumpTitle;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.questDesc;
        int hashCode3 = (((((((((((((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.questAmount) * 31) + this.questPriority) * 31) + this.rewardList.hashCode()) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.uin)) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.taskId)) * 31) + this.questCurrentCnt) * 31;
        String str4 = this.questJumpSchema;
        int hashCode4 = (((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.lastUpdateTime)) * 31;
        List<String> list = this.extParam;
        int hashCode5 = (hashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        String str5 = this.questIcon;
        return hashCode5 + (str5 != null ? str5.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final int getQuestStatus() {
        return this.questStatus;
    }

    /* renamed from: j, reason: from getter */
    public final String getQuestTitle() {
        return this.questTitle;
    }

    public final List<ZootopiaTaskRewardInfo> k() {
        return this.rewardList;
    }

    public ZootopiaTaskItemData(long j3, int i3, int i16, String str, long j16, long j17, int i17, int i18, String str2, String str3, int i19, int i26, List<ZootopiaTaskRewardInfo> rewardList, long j18, long j19, int i27, String str4, long j26, List<String> list, String str5) {
        Intrinsics.checkNotNullParameter(rewardList, "rewardList");
        this.questId = j3;
        this.questStatus = i3;
        this.questType = i16;
        this.questTitle = str;
        this.startTime = j16;
        this.endTime = j17;
        this.refreshType = i17;
        this.questJumpType = i18;
        this.questJumpTitle = str2;
        this.questDesc = str3;
        this.questAmount = i19;
        this.questPriority = i26;
        this.rewardList = rewardList;
        this.uin = j18;
        this.taskId = j19;
        this.questCurrentCnt = i27;
        this.questJumpSchema = str4;
        this.lastUpdateTime = j26;
        this.extParam = list;
        this.questIcon = str5;
    }

    public String toString() {
        return "ZootopiaTaskItemData(questId=" + this.questId + ", questStatus=" + this.questStatus + ", questType=" + this.questType + ", questTitle=" + this.questTitle + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", refreshType=" + this.refreshType + ", questJumpType=" + this.questJumpType + ", questJumpTitle=" + this.questJumpTitle + ", questDesc=" + this.questDesc + ", questAmount=" + this.questAmount + ", questPriority=" + this.questPriority + ", rewardList=" + this.rewardList + ", uin=" + this.uin + ", taskId=" + this.taskId + ", questCurrentCnt=" + this.questCurrentCnt + ", questJumpSchema=" + this.questJumpSchema + ", lastUpdateTime=" + this.lastUpdateTime + ", extParam=" + this.extParam + ", questIcon=" + this.questIcon + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaTaskItemData)) {
            return false;
        }
        ZootopiaTaskItemData zootopiaTaskItemData = (ZootopiaTaskItemData) other;
        return this.questId == zootopiaTaskItemData.questId && this.questStatus == zootopiaTaskItemData.questStatus && this.questType == zootopiaTaskItemData.questType && Intrinsics.areEqual(this.questTitle, zootopiaTaskItemData.questTitle) && this.startTime == zootopiaTaskItemData.startTime && this.endTime == zootopiaTaskItemData.endTime && this.refreshType == zootopiaTaskItemData.refreshType && this.questJumpType == zootopiaTaskItemData.questJumpType && Intrinsics.areEqual(this.questJumpTitle, zootopiaTaskItemData.questJumpTitle) && Intrinsics.areEqual(this.questDesc, zootopiaTaskItemData.questDesc) && this.questAmount == zootopiaTaskItemData.questAmount && this.questPriority == zootopiaTaskItemData.questPriority && Intrinsics.areEqual(this.rewardList, zootopiaTaskItemData.rewardList) && this.uin == zootopiaTaskItemData.uin && this.taskId == zootopiaTaskItemData.taskId && this.questCurrentCnt == zootopiaTaskItemData.questCurrentCnt && Intrinsics.areEqual(this.questJumpSchema, zootopiaTaskItemData.questJumpSchema) && this.lastUpdateTime == zootopiaTaskItemData.lastUpdateTime && Intrinsics.areEqual(this.extParam, zootopiaTaskItemData.extParam) && Intrinsics.areEqual(this.questIcon, zootopiaTaskItemData.questIcon);
    }

    public /* synthetic */ ZootopiaTaskItemData(long j3, int i3, int i16, String str, long j16, long j17, int i17, int i18, String str2, String str3, int i19, int i26, List list, long j18, long j19, int i27, String str4, long j26, List list2, String str5, int i28, DefaultConstructorMarker defaultConstructorMarker) {
        this((i28 & 1) != 0 ? 0L : j3, (i28 & 2) != 0 ? 0 : i3, (i28 & 4) != 0 ? 0 : i16, (i28 & 8) != 0 ? null : str, (i28 & 16) != 0 ? 0L : j16, (i28 & 32) != 0 ? 0L : j17, (i28 & 64) != 0 ? 0 : i17, (i28 & 128) != 0 ? 0 : i18, (i28 & 256) != 0 ? null : str2, (i28 & 512) != 0 ? null : str3, (i28 & 1024) != 0 ? 0 : i19, (i28 & 2048) != 0 ? 0 : i26, (i28 & 4096) != 0 ? new ArrayList() : list, (i28 & 8192) != 0 ? 0L : j18, (i28 & 16384) != 0 ? 0L : j19, (32768 & i28) != 0 ? 0 : i27, (i28 & 65536) != 0 ? null : str4, (i28 & 131072) != 0 ? 0L : j26, (i28 & 262144) != 0 ? new ArrayList() : list2, (i28 & 524288) != 0 ? null : str5);
    }
}
