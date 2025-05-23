package com.tencent.state.square;

import com.tencent.state.data.SquareJSConst;
import com.tencent.state.map.MapItem;
import com.tencent.state.square.api.SquareMiniAioMultiSelectedRecord;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\tH\u00c6\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/state/square/MoveItem;", "", "uin", "", SquareJSConst.Params.PARAMS_UNIT_TYPE, "", "isMale", "", "moveData", "Lcom/tencent/state/map/MapItem;", "(Ljava/lang/String;IZLcom/tencent/state/map/MapItem;)V", "()Z", "getMoveData", "()Lcom/tencent/state/map/MapItem;", "getUin", "()Ljava/lang/String;", "getUnitType", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class MoveItem {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "MoveItem";
    private final boolean isMale;
    private final MapItem moveData;
    private final String uin;
    private final int unitType;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/state/square/MoveItem$Companion;", "", "()V", "TAG", "", "covertFromSelectedInfo", "Lcom/tencent/state/square/MoveItem;", "info", "Lcom/tencent/state/square/api/SquareMiniAioMultiSelectedRecord;", "covertFromSelectedInfoList", "", "list", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public final MoveItem covertFromSelectedInfo(SquareMiniAioMultiSelectedRecord info) {
            Intrinsics.checkNotNullParameter(info, "info");
            return new MoveItem(info.getUin(), info.getType(), false, null, 12, null);
        }

        public final List<MoveItem> covertFromSelectedInfoList(List<SquareMiniAioMultiSelectedRecord> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            String currentAccountUin = SquareBaseKt.getSquareCommon().getCurrentAccountUin();
            ArrayList arrayList = new ArrayList();
            for (SquareMiniAioMultiSelectedRecord squareMiniAioMultiSelectedRecord : list) {
                if (Intrinsics.areEqual(squareMiniAioMultiSelectedRecord.getUin(), currentAccountUin)) {
                    SquareBaseKt.getSquareLog().i(MoveItem.TAG, "covertFromSelectedInfoList, remove self");
                } else {
                    arrayList.add(covertFromSelectedInfo(squareMiniAioMultiSelectedRecord));
                }
            }
            return arrayList;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public MoveItem(String uin, int i3, boolean z16, MapItem mapItem) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.uin = uin;
        this.unitType = i3;
        this.isMale = z16;
        this.moveData = mapItem;
    }

    /* renamed from: component1, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    /* renamed from: component2, reason: from getter */
    public final int getUnitType() {
        return this.unitType;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsMale() {
        return this.isMale;
    }

    /* renamed from: component4, reason: from getter */
    public final MapItem getMoveData() {
        return this.moveData;
    }

    public final MoveItem copy(String uin, int unitType, boolean isMale, MapItem moveData) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return new MoveItem(uin, unitType, isMale, moveData);
    }

    public final MapItem getMoveData() {
        return this.moveData;
    }

    public final String getUin() {
        return this.uin;
    }

    public final int getUnitType() {
        return this.unitType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.uin;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.unitType) * 31;
        boolean z16 = this.isMale;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode + i3) * 31;
        MapItem mapItem = this.moveData;
        return i16 + (mapItem != null ? mapItem.hashCode() : 0);
    }

    public final boolean isMale() {
        return this.isMale;
    }

    public String toString() {
        return "MoveItem(uin=" + this.uin + ", unitType=" + this.unitType + ", isMale=" + this.isMale + ", moveData=" + this.moveData + ")";
    }

    public /* synthetic */ MoveItem(String str, int i3, boolean z16, MapItem mapItem, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, (i16 & 4) != 0 ? true : z16, (i16 & 8) != 0 ? null : mapItem);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MoveItem)) {
            return false;
        }
        MoveItem moveItem = (MoveItem) other;
        return Intrinsics.areEqual(this.uin, moveItem.uin) && this.unitType == moveItem.unitType && this.isMale == moveItem.isMale && Intrinsics.areEqual(this.moveData, moveItem.moveData);
    }

    public static /* synthetic */ MoveItem copy$default(MoveItem moveItem, String str, int i3, boolean z16, MapItem mapItem, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = moveItem.uin;
        }
        if ((i16 & 2) != 0) {
            i3 = moveItem.unitType;
        }
        if ((i16 & 4) != 0) {
            z16 = moveItem.isMale;
        }
        if ((i16 & 8) != 0) {
            mapItem = moveItem.moveData;
        }
        return moveItem.copy(str, i3, z16, mapItem);
    }
}
