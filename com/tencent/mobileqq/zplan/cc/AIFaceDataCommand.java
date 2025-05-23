package com.tencent.mobileqq.zplan.cc;

import fg3.FaceItemData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\tB'\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\r\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/zplan/cc/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "setAction", "(I)V", "action", "Ljava/util/ArrayList;", "Lfg3/l;", "b", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "setFaceData", "(Ljava/util/ArrayList;)V", "faceData", "c", "d", "updateIndex", "<init>", "(ILjava/util/ArrayList;I)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.cc.b, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class AIFaceDataCommand {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int action;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private ArrayList<FaceItemData> faceData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int updateIndex;

    public AIFaceDataCommand(int i3, ArrayList<FaceItemData> faceData, int i16) {
        Intrinsics.checkNotNullParameter(faceData, "faceData");
        this.action = i3;
        this.faceData = faceData;
        this.updateIndex = i16;
    }

    /* renamed from: a, reason: from getter */
    public final int getAction() {
        return this.action;
    }

    public final ArrayList<FaceItemData> b() {
        return this.faceData;
    }

    /* renamed from: c, reason: from getter */
    public final int getUpdateIndex() {
        return this.updateIndex;
    }

    public final void d(int i3) {
        this.updateIndex = i3;
    }

    public int hashCode() {
        return (((this.action * 31) + this.faceData.hashCode()) * 31) + this.updateIndex;
    }

    public String toString() {
        return "AIFaceDataCommand(action=" + this.action + ", faceData=" + this.faceData + ", updateIndex=" + this.updateIndex + ")";
    }

    public /* synthetic */ AIFaceDataCommand(int i3, ArrayList arrayList, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, arrayList, (i17 & 4) != 0 ? -1 : i16);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AIFaceDataCommand)) {
            return false;
        }
        AIFaceDataCommand aIFaceDataCommand = (AIFaceDataCommand) other;
        return this.action == aIFaceDataCommand.action && Intrinsics.areEqual(this.faceData, aIFaceDataCommand.faceData) && this.updateIndex == aIFaceDataCommand.updateIndex;
    }
}
