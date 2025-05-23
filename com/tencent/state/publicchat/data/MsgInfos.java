package com.tencent.state.publicchat.data;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import zr4.d;
import zr4.e;
import zr4.f;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012B\u0013\b\u0016\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0011\u0010\u0015J\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u00c6\u0003J\u0019\u0010\u0006\u001a\u00020\u00002\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u00c6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/state/publicchat/data/MsgInfos;", "", "", "", "component1", "msgIds", "copy", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/List;", "getMsgIds", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "Lzr4/f;", "pb", "(Lzr4/f;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class MsgInfos {
    private final List<Long> msgIds;

    public MsgInfos(List<Long> msgIds) {
        Intrinsics.checkNotNullParameter(msgIds, "msgIds");
        this.msgIds = msgIds;
    }

    public final List<Long> component1() {
        return this.msgIds;
    }

    public final MsgInfos copy(List<Long> msgIds) {
        Intrinsics.checkNotNullParameter(msgIds, "msgIds");
        return new MsgInfos(msgIds);
    }

    public final List<Long> getMsgIds() {
        return this.msgIds;
    }

    public int hashCode() {
        List<Long> list = this.msgIds;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "MsgInfos(msgIds=" + this.msgIds + ")";
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002a, code lost:
    
        if (r6 != null) goto L18;
     */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MsgInfos(f fVar) {
        this((List<Long>) r6);
        List emptyList;
        e[] eVarArr;
        d dVar;
        if (fVar != null && (eVarArr = fVar.f453107a) != null) {
            ArrayList arrayList = new ArrayList(eVarArr.length);
            int length = eVarArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                e eVar = eVarArr[i3];
                arrayList.add((eVar == null || (dVar = eVar.f453103a) == null) ? null : Long.valueOf(dVar.f453094e));
            }
            emptyList = CollectionsKt___CollectionsKt.filterNotNull(arrayList);
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof MsgInfos) && Intrinsics.areEqual(this.msgIds, ((MsgInfos) other).msgIds);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MsgInfos copy$default(MsgInfos msgInfos, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = msgInfos.msgIds;
        }
        return msgInfos.copy(list);
    }
}
