package com.tencent.mobileqq.zplan.avatar;

import com.tencent.zplan.record.model.Source;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u0014R\u0017\u0010\u0019\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0012\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "d", "()Z", "isSuccess", "b", "I", "()I", "actionId", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "recordPath", "Lcom/tencent/zplan/record/model/Source;", "Lcom/tencent/zplan/record/model/Source;", "()Lcom/tencent/zplan/record/model/Source;", "source", "<init>", "(ZILjava/lang/String;Lcom/tencent/zplan/record/model/Source;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.avatar.c, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class RecordResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSuccess;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int actionId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String recordPath;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Source source;

    public RecordResult(boolean z16, int i3, @Nullable String str, @NotNull Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.isSuccess = z16;
        this.actionId = i3;
        this.recordPath = str;
        this.source = source;
    }

    /* renamed from: a, reason: from getter */
    public final int getActionId() {
        return this.actionId;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getRecordPath() {
        return this.recordPath;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final Source getSource() {
        return this.source;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecordResult)) {
            return false;
        }
        RecordResult recordResult = (RecordResult) other;
        if (this.isSuccess == recordResult.isSuccess && this.actionId == recordResult.actionId && Intrinsics.areEqual(this.recordPath, recordResult.recordPath) && this.source == recordResult.source) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        int hashCode;
        boolean z16 = this.isSuccess;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = ((r06 * 31) + this.actionId) * 31;
        String str = this.recordPath;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return ((i3 + hashCode) * 31) + this.source.hashCode();
    }

    @NotNull
    public String toString() {
        return "RecordResult(isSuccess=" + this.isSuccess + ", actionId=" + this.actionId + ", recordPath=" + this.recordPath + ", source=" + this.source + ')';
    }
}
