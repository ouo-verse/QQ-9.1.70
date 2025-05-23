package com.tencent.state.square.interaction;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pt4.f;
import pt4.o;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0016\u0010\u0017B\u0011\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u0016\u0010\u001aJ\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003J#\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\b\u001a\u00020\u0005H\u00c6\u0001J\t\u0010\n\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\b\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/state/square/interaction/InteractionRecordList;", "", "", "Lcom/tencent/state/square/interaction/InteractionRecordInfo;", "component1", "", "component2", "records", "cursorId", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/List;", "getRecords", "()Ljava/util/List;", "Ljava/lang/String;", "getCursorId", "()Ljava/lang/String;", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "Lpt4/f;", "pb", "(Lpt4/f;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class InteractionRecordList {
    private final String cursorId;
    private final List<InteractionRecordInfo> records;

    public InteractionRecordList(List<InteractionRecordInfo> records, String cursorId) {
        Intrinsics.checkNotNullParameter(records, "records");
        Intrinsics.checkNotNullParameter(cursorId, "cursorId");
        this.records = records;
        this.cursorId = cursorId;
    }

    public final List<InteractionRecordInfo> component1() {
        return this.records;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCursorId() {
        return this.cursorId;
    }

    public final InteractionRecordList copy(List<InteractionRecordInfo> records, String cursorId) {
        Intrinsics.checkNotNullParameter(records, "records");
        Intrinsics.checkNotNullParameter(cursorId, "cursorId");
        return new InteractionRecordList(records, cursorId);
    }

    public final String getCursorId() {
        return this.cursorId;
    }

    public final List<InteractionRecordInfo> getRecords() {
        return this.records;
    }

    public int hashCode() {
        List<InteractionRecordInfo> list = this.records;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.cursorId;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "InteractionRecordList(records=" + this.records + ", cursorId=" + this.cursorId + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public InteractionRecordList(f pb5) {
        this(r1, r8);
        Intrinsics.checkNotNullParameter(pb5, "pb");
        o[] oVarArr = pb5.f427167a;
        Intrinsics.checkNotNullExpressionValue(oVarArr, "pb.interactions");
        ArrayList arrayList = new ArrayList(oVarArr.length);
        for (o it : oVarArr) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(new InteractionRecordInfo(it));
        }
        String str = pb5.f427168b;
        Intrinsics.checkNotNullExpressionValue(str, "pb.cursorId");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InteractionRecordList)) {
            return false;
        }
        InteractionRecordList interactionRecordList = (InteractionRecordList) other;
        return Intrinsics.areEqual(this.records, interactionRecordList.records) && Intrinsics.areEqual(this.cursorId, interactionRecordList.cursorId);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InteractionRecordList copy$default(InteractionRecordList interactionRecordList, List list, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = interactionRecordList.records;
        }
        if ((i3 & 2) != 0) {
            str = interactionRecordList.cursorId;
        }
        return interactionRecordList.copy(list, str);
    }
}
