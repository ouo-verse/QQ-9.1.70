package com.tencent.guild.aio.article.data;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014\u0012\u0006\u0010\u001a\u001a\u00020\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R'\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017R\u0017\u0010\u001a\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0019\u0010\fR\u0017\u0010\u001b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/guild/aio/article/data/l;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "e", "()Z", "isSuccess", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "errorMsg", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "c", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "msgSeqList", "d", "upIsFinish", "downIsFinish", "<init>", "(ZLjava/lang/String;Ljava/util/ArrayList;ZZ)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.guild.aio.article.data.l, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class QueryMsgSeqListResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSuccess;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String errorMsg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ArrayList<Long> msgSeqList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean upIsFinish;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean downIsFinish;

    public QueryMsgSeqListResult(boolean z16, @NotNull String errorMsg, @NotNull ArrayList<Long> msgSeqList, boolean z17, boolean z18) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        Intrinsics.checkNotNullParameter(msgSeqList, "msgSeqList");
        this.isSuccess = z16;
        this.errorMsg = errorMsg;
        this.msgSeqList = msgSeqList;
        this.upIsFinish = z17;
        this.downIsFinish = z18;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getDownIsFinish() {
        return this.downIsFinish;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    @NotNull
    public final ArrayList<Long> c() {
        return this.msgSeqList;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getUpIsFinish() {
        return this.upIsFinish;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QueryMsgSeqListResult)) {
            return false;
        }
        QueryMsgSeqListResult queryMsgSeqListResult = (QueryMsgSeqListResult) other;
        if (this.isSuccess == queryMsgSeqListResult.isSuccess && Intrinsics.areEqual(this.errorMsg, queryMsgSeqListResult.errorMsg) && Intrinsics.areEqual(this.msgSeqList, queryMsgSeqListResult.msgSeqList) && this.upIsFinish == queryMsgSeqListResult.upIsFinish && this.downIsFinish == queryMsgSeqListResult.downIsFinish) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    public int hashCode() {
        boolean z16 = this.isSuccess;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int hashCode = ((((r06 * 31) + this.errorMsg.hashCode()) * 31) + this.msgSeqList.hashCode()) * 31;
        ?? r26 = this.upIsFinish;
        int i16 = r26;
        if (r26 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode + i16) * 31;
        boolean z17 = this.downIsFinish;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return i17 + i3;
    }

    @NotNull
    public String toString() {
        return "QueryMsgSeqListResult(isSuccess=" + this.isSuccess + ", errorMsg=" + this.errorMsg + ", msgSeqList=" + this.msgSeqList + ", upIsFinish=" + this.upIsFinish + ", downIsFinish=" + this.downIsFinish + ")";
    }
}
