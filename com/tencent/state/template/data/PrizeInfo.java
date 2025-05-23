package com.tencent.state.template.data;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.vas.banner.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0002\u0010\u0010J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003J\t\u0010#\u001a\u00020\u0005H\u00c6\u0003J\t\u0010$\u001a\u00020\u0005H\u00c6\u0003J\t\u0010%\u001a\u00020\bH\u00c6\u0003J\t\u0010&\u001a\u00020\u0005H\u00c6\u0003J\t\u0010'\u001a\u00020\u0005H\u00c6\u0003J\t\u0010(\u001a\u00020\u0005H\u00c6\u0003J\t\u0010)\u001a\u00020\u0005H\u00c6\u0003J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003Jo\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00c6\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010/\u001a\u000200H\u00d6\u0001J\t\u00101\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0012\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0012\u00a8\u00062"}, d2 = {"Lcom/tencent/state/template/data/PrizeInfo;", "", "uin", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "prizeId", "type", "Lcom/tencent/state/template/data/PrizeType;", "title", "name", "url", "desc", "expireAt", "extra", "Lcom/tencent/state/template/data/BasePrizeExtra;", "(JLjava/lang/String;Ljava/lang/String;Lcom/tencent/state/template/data/PrizeType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLcom/tencent/state/template/data/BasePrizeExtra;)V", "getDesc", "()Ljava/lang/String;", "getExpireAt", "()J", "getExtra", "()Lcom/tencent/state/template/data/BasePrizeExtra;", "getName", "getPrizeId", "getTaskId", "getTitle", "setTitle", "(Ljava/lang/String;)V", "getType", "()Lcom/tencent/state/template/data/PrizeType;", "getUin", "getUrl", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class PrizeInfo {
    private final String desc;
    private final long expireAt;
    private final BasePrizeExtra extra;
    private final String name;
    private final String prizeId;
    private final String taskId;
    private String title;
    private final PrizeType type;
    private final long uin;
    private final String url;

    public PrizeInfo(long j3, String taskId, String prizeId, PrizeType type, String title, String name, String url, String desc, long j16, BasePrizeExtra basePrizeExtra) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(prizeId, "prizeId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.uin = j3;
        this.taskId = taskId;
        this.prizeId = prizeId;
        this.type = type;
        this.title = title;
        this.name = name;
        this.url = url;
        this.desc = desc;
        this.expireAt = j16;
        this.extra = basePrizeExtra;
    }

    /* renamed from: component1, reason: from getter */
    public final long getUin() {
        return this.uin;
    }

    /* renamed from: component10, reason: from getter */
    public final BasePrizeExtra getExtra() {
        return this.extra;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPrizeId() {
        return this.prizeId;
    }

    /* renamed from: component4, reason: from getter */
    public final PrizeType getType() {
        return this.type;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component6, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component7, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component8, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    /* renamed from: component9, reason: from getter */
    public final long getExpireAt() {
        return this.expireAt;
    }

    public final PrizeInfo copy(long uin, String taskId, String prizeId, PrizeType type, String title, String name, String url, String desc, long expireAt, BasePrizeExtra extra) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(prizeId, "prizeId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(desc, "desc");
        return new PrizeInfo(uin, taskId, prizeId, type, title, name, url, desc, expireAt, extra);
    }

    public final String getDesc() {
        return this.desc;
    }

    public final long getExpireAt() {
        return this.expireAt;
    }

    public final BasePrizeExtra getExtra() {
        return this.extra;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPrizeId() {
        return this.prizeId;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final PrizeType getType() {
        return this.type;
    }

    public final long getUin() {
        return this.uin;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int a16 = c.a(this.uin) * 31;
        String str = this.taskId;
        int hashCode = (a16 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.prizeId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        PrizeType prizeType = this.type;
        int hashCode3 = (hashCode2 + (prizeType != null ? prizeType.hashCode() : 0)) * 31;
        String str3 = this.title;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.name;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.url;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.desc;
        int hashCode7 = (((hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31) + c.a(this.expireAt)) * 31;
        BasePrizeExtra basePrizeExtra = this.extra;
        return hashCode7 + (basePrizeExtra != null ? basePrizeExtra.hashCode() : 0);
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public String toString() {
        return "PrizeInfo(uin=" + this.uin + ", taskId=" + this.taskId + ", prizeId=" + this.prizeId + ", type=" + this.type + ", title=" + this.title + ", name=" + this.name + ", url=" + this.url + ", desc=" + this.desc + ", expireAt=" + this.expireAt + ", extra=" + this.extra + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PrizeInfo)) {
            return false;
        }
        PrizeInfo prizeInfo = (PrizeInfo) other;
        return this.uin == prizeInfo.uin && Intrinsics.areEqual(this.taskId, prizeInfo.taskId) && Intrinsics.areEqual(this.prizeId, prizeInfo.prizeId) && Intrinsics.areEqual(this.type, prizeInfo.type) && Intrinsics.areEqual(this.title, prizeInfo.title) && Intrinsics.areEqual(this.name, prizeInfo.name) && Intrinsics.areEqual(this.url, prizeInfo.url) && Intrinsics.areEqual(this.desc, prizeInfo.desc) && this.expireAt == prizeInfo.expireAt && Intrinsics.areEqual(this.extra, prizeInfo.extra);
    }
}
