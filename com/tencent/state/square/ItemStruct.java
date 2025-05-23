package com.tencent.state.square;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.state.map.MapItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0007\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\t\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/square/ItemStruct;", "", "index", "", "data", "Lcom/tencent/state/map/MapItem;", "(ILcom/tencent/state/map/MapItem;)V", GdtGetUserInfoHandler.KEY_AREA, "getArea", "()I", "getData", "()Lcom/tencent/state/map/MapItem;", "getIndex", "setIndex", "(I)V", "rank", "getRank", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ItemStruct {
    private final MapItem data;
    private int index;

    public ItemStruct(int i3, MapItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.index = i3;
        this.data = data;
    }

    public final int getArea() {
        return this.data.getLocation().getArea();
    }

    public final MapItem getData() {
        return this.data;
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getRank() {
        return this.data.getLocation().getRank();
    }

    public final void setIndex(int i3) {
        this.index = i3;
    }

    public String toString() {
        return "ItemStruct(index:" + this.index + ", area:" + getArea() + ",rank:" + getRank() + ",type:" + this.data.getType() + ",uin:" + this.data.getUin() + ",fixed:" + this.data.isFixed();
    }
}
