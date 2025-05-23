package com.tencent.state.publicchat.data;

import com.tencent.mobileqq.vas.banner.c;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import xs4.d;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010$\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\n\u0012\u0006\u0010\u0016\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\f\u0012\u0006\u0010\u0018\u001a\u00020\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0011\u00a2\u0006\u0004\b5\u00106B\u0013\b\u0016\u0012\b\u00108\u001a\u0004\u0018\u000107\u00a2\u0006\u0004\b5\u00109J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\t\u001a\u00020\bH\u00c6\u0003J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\u00c6\u0003J\t\u0010\r\u001a\u00020\fH\u00c6\u0003J\t\u0010\u000e\u001a\u00020\fH\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u000fH\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0011H\u00c6\u0003JU\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\b2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\u000f2\b\b\u0002\u0010\u0019\u001a\u00020\u0011H\u00c6\u0001J\t\u0010\u001b\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u001c\u001a\u00020\fH\u00d6\u0001J\u0013\u0010\u001e\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0017\u0010\u0013\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\u0014\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010%\u001a\u0004\b&\u0010'R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\n8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010\u0016\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010+\u001a\u0004\b,\u0010-R\u0017\u0010\u0017\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010+\u001a\u0004\b.\u0010-R\u0017\u0010\u0018\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010/\u001a\u0004\b0\u00101R\u0017\u0010\u0019\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0019\u00102\u001a\u0004\b3\u00104\u00a8\u0006:"}, d2 = {"Lcom/tencent/state/publicchat/data/PublicChatConfInfo;", "", "", "templateId", "Lcom/tencent/state/publicchat/data/MsgConfInfo;", "findMsgConf", "", "component1", "Lcom/tencent/state/publicchat/data/SendPrivilegeType;", "component2", "", "component3", "", "component4", "component5", "", "component6", "Lcom/tencent/state/publicchat/data/UserInfo;", "component7", "show", "privilegeType", "confInfos", "showCount", "sendIntervalSecond", "unBlockTs", QCircleAlphaUserReporter.KEY_USER, "copy", "toString", "hashCode", "other", "equals", "", "msgConfMap", "Ljava/util/Map;", "Z", "getShow", "()Z", "Lcom/tencent/state/publicchat/data/SendPrivilegeType;", "getPrivilegeType", "()Lcom/tencent/state/publicchat/data/SendPrivilegeType;", "Ljava/util/List;", "getConfInfos", "()Ljava/util/List;", "I", "getShowCount", "()I", "getSendIntervalSecond", "J", "getUnBlockTs", "()J", "Lcom/tencent/state/publicchat/data/UserInfo;", "getUser", "()Lcom/tencent/state/publicchat/data/UserInfo;", "<init>", "(ZLcom/tencent/state/publicchat/data/SendPrivilegeType;Ljava/util/List;IIJLcom/tencent/state/publicchat/data/UserInfo;)V", "Lxs4/d;", "pb", "(Lxs4/d;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class PublicChatConfInfo {
    private final List<MsgConfInfo> confInfos;
    private final Map<String, MsgConfInfo> msgConfMap;
    private final SendPrivilegeType privilegeType;
    private final int sendIntervalSecond;
    private final boolean show;
    private final int showCount;
    private final long unBlockTs;
    private final UserInfo user;

    public PublicChatConfInfo(boolean z16, SendPrivilegeType privilegeType, List<MsgConfInfo> confInfos, int i3, int i16, long j3, UserInfo user) {
        Intrinsics.checkNotNullParameter(privilegeType, "privilegeType");
        Intrinsics.checkNotNullParameter(confInfos, "confInfos");
        Intrinsics.checkNotNullParameter(user, "user");
        this.show = z16;
        this.privilegeType = privilegeType;
        this.confInfos = confInfos;
        this.showCount = i3;
        this.sendIntervalSecond = i16;
        this.unBlockTs = j3;
        this.user = user;
        this.msgConfMap = new LinkedHashMap();
        for (MsgConfInfo msgConfInfo : confInfos) {
            this.msgConfMap.put(msgConfInfo.getTemplateId(), msgConfInfo);
        }
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getShow() {
        return this.show;
    }

    /* renamed from: component2, reason: from getter */
    public final SendPrivilegeType getPrivilegeType() {
        return this.privilegeType;
    }

    public final List<MsgConfInfo> component3() {
        return this.confInfos;
    }

    /* renamed from: component4, reason: from getter */
    public final int getShowCount() {
        return this.showCount;
    }

    /* renamed from: component5, reason: from getter */
    public final int getSendIntervalSecond() {
        return this.sendIntervalSecond;
    }

    /* renamed from: component6, reason: from getter */
    public final long getUnBlockTs() {
        return this.unBlockTs;
    }

    /* renamed from: component7, reason: from getter */
    public final UserInfo getUser() {
        return this.user;
    }

    public final PublicChatConfInfo copy(boolean show, SendPrivilegeType privilegeType, List<MsgConfInfo> confInfos, int showCount, int sendIntervalSecond, long unBlockTs, UserInfo user) {
        Intrinsics.checkNotNullParameter(privilegeType, "privilegeType");
        Intrinsics.checkNotNullParameter(confInfos, "confInfos");
        Intrinsics.checkNotNullParameter(user, "user");
        return new PublicChatConfInfo(show, privilegeType, confInfos, showCount, sendIntervalSecond, unBlockTs, user);
    }

    public final List<MsgConfInfo> getConfInfos() {
        return this.confInfos;
    }

    public final SendPrivilegeType getPrivilegeType() {
        return this.privilegeType;
    }

    public final int getSendIntervalSecond() {
        return this.sendIntervalSecond;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final int getShowCount() {
        return this.showCount;
    }

    public final long getUnBlockTs() {
        return this.unBlockTs;
    }

    public final UserInfo getUser() {
        return this.user;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    public int hashCode() {
        boolean z16 = this.show;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        SendPrivilegeType sendPrivilegeType = this.privilegeType;
        int hashCode = (i3 + (sendPrivilegeType != null ? sendPrivilegeType.hashCode() : 0)) * 31;
        List<MsgConfInfo> list = this.confInfos;
        int hashCode2 = (((((((hashCode + (list != null ? list.hashCode() : 0)) * 31) + this.showCount) * 31) + this.sendIntervalSecond) * 31) + c.a(this.unBlockTs)) * 31;
        UserInfo userInfo = this.user;
        return hashCode2 + (userInfo != null ? userInfo.hashCode() : 0);
    }

    public String toString() {
        return "PublicChatConfInfo(show=" + this.show + ", privilegeType=" + this.privilegeType + ", confInfos=" + this.confInfos + ", showCount=" + this.showCount + ", sendIntervalSecond=" + this.sendIntervalSecond + ", unBlockTs=" + this.unBlockTs + ", user=" + this.user + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PublicChatConfInfo)) {
            return false;
        }
        PublicChatConfInfo publicChatConfInfo = (PublicChatConfInfo) other;
        return this.show == publicChatConfInfo.show && Intrinsics.areEqual(this.privilegeType, publicChatConfInfo.privilegeType) && Intrinsics.areEqual(this.confInfos, publicChatConfInfo.confInfos) && this.showCount == publicChatConfInfo.showCount && this.sendIntervalSecond == publicChatConfInfo.sendIntervalSecond && this.unBlockTs == publicChatConfInfo.unBlockTs && Intrinsics.areEqual(this.user, publicChatConfInfo.user);
    }

    public final MsgConfInfo findMsgConf(String templateId) {
        if (templateId != null) {
            return this.msgConfMap.get(templateId);
        }
        return null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PublicChatConfInfo(d dVar) {
        this(r3, r4, r5, dVar != null ? dVar.f448479d : 0, dVar != null ? dVar.f448480e : 0, dVar != null ? dVar.f448481f : 0L, new UserInfo(dVar != null ? dVar.f448482g : null));
        List emptyList;
        List list;
        zr4.c[] cVarArr;
        boolean z16 = dVar != null ? dVar.f448476a : false;
        SendPrivilegeType parse = SendPrivilegeType.INSTANCE.parse(dVar != null ? Integer.valueOf(dVar.f448477b) : null);
        if (dVar == null || (cVarArr = dVar.f448478c) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list = emptyList;
        } else {
            list = new ArrayList(cVarArr.length);
            for (zr4.c cVar : cVarArr) {
                list.add(new MsgConfInfo(cVar));
            }
        }
    }
}
