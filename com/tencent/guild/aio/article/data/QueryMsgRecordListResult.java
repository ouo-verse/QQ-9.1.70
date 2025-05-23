package com.tencent.guild.aio.article.data;

import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R'\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00148\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u000e\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/guild/aio/article/data/j;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "c", "()Z", "isSuccess", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "errorMsg", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "msgRecordList", "<init>", "(ZLjava/lang/String;Ljava/util/ArrayList;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.guild.aio.article.data.j, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class QueryMsgRecordListResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSuccess;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String errorMsg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ArrayList<MsgRecord> msgRecordList;

    public QueryMsgRecordListResult(boolean z16, @NotNull String errorMsg, @NotNull ArrayList<MsgRecord> msgRecordList) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        Intrinsics.checkNotNullParameter(msgRecordList, "msgRecordList");
        this.isSuccess = z16;
        this.errorMsg = errorMsg;
        this.msgRecordList = msgRecordList;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    @NotNull
    public final ArrayList<MsgRecord> b() {
        return this.msgRecordList;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QueryMsgRecordListResult)) {
            return false;
        }
        QueryMsgRecordListResult queryMsgRecordListResult = (QueryMsgRecordListResult) other;
        if (this.isSuccess == queryMsgRecordListResult.isSuccess && Intrinsics.areEqual(this.errorMsg, queryMsgRecordListResult.errorMsg) && Intrinsics.areEqual(this.msgRecordList, queryMsgRecordListResult.msgRecordList)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.isSuccess;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((r06 * 31) + this.errorMsg.hashCode()) * 31) + this.msgRecordList.hashCode();
    }

    @NotNull
    public String toString() {
        return "QueryMsgRecordListResult(isSuccess=" + this.isSuccess + ", errorMsg=" + this.errorMsg + ", msgRecordList=" + this.msgRecordList + ")";
    }
}
