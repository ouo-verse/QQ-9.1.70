package com.tencent.state.square.interaction;

import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import pt4.l;
import pt4.o;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0014\u0010\u0015B\u0011\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\t\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\n\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/square/interaction/InteractionUnreadInfo;", "", "", "component1", "", "component2", "unReadNum", "unReadIcon", "copy", "toString", "hashCode", "other", "", "equals", "I", "getUnReadNum", "()I", "Ljava/lang/String;", "getUnReadIcon", "()Ljava/lang/String;", "<init>", "(ILjava/lang/String;)V", "Lpt4/l;", "pb", "(Lpt4/l;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class InteractionUnreadInfo {
    private final String unReadIcon;
    private final int unReadNum;

    public InteractionUnreadInfo() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: component1, reason: from getter */
    public final int getUnReadNum() {
        return this.unReadNum;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUnReadIcon() {
        return this.unReadIcon;
    }

    public final InteractionUnreadInfo copy(int unReadNum, String unReadIcon) {
        Intrinsics.checkNotNullParameter(unReadIcon, "unReadIcon");
        return new InteractionUnreadInfo(unReadNum, unReadIcon);
    }

    public final String getUnReadIcon() {
        return this.unReadIcon;
    }

    public final int getUnReadNum() {
        return this.unReadNum;
    }

    public int hashCode() {
        int i3 = this.unReadNum * 31;
        String str = this.unReadIcon;
        return i3 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "InteractionUnreadInfo(unReadNum=" + this.unReadNum + ", unReadIcon=" + this.unReadIcon + ")";
    }

    public InteractionUnreadInfo(int i3, String unReadIcon) {
        Intrinsics.checkNotNullParameter(unReadIcon, "unReadIcon");
        this.unReadNum = i3;
        this.unReadIcon = unReadIcon;
    }

    public /* synthetic */ InteractionUnreadInfo(int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? "" : str);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InteractionUnreadInfo)) {
            return false;
        }
        InteractionUnreadInfo interactionUnreadInfo = (InteractionUnreadInfo) other;
        return this.unReadNum == interactionUnreadInfo.unReadNum && Intrinsics.areEqual(this.unReadIcon, interactionUnreadInfo.unReadIcon);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public InteractionUnreadInfo(l pb5) {
        this(r0, (r3 == null || (r3 = r3.f427202j) == null) ? "" : r3);
        Object firstOrNull;
        String str;
        Intrinsics.checkNotNullParameter(pb5, "pb");
        int i3 = pb5.f427179a;
        o[] oVarArr = pb5.f427180b;
        Intrinsics.checkNotNullExpressionValue(oVarArr, "pb.recentlyInteractions");
        firstOrNull = ArraysKt___ArraysKt.firstOrNull(oVarArr);
        o oVar = (o) firstOrNull;
    }

    public static /* synthetic */ InteractionUnreadInfo copy$default(InteractionUnreadInfo interactionUnreadInfo, int i3, String str, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = interactionUnreadInfo.unReadNum;
        }
        if ((i16 & 2) != 0) {
            str = interactionUnreadInfo.unReadIcon;
        }
        return interactionUnreadInfo.copy(i3, str);
    }
}
