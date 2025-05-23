package com.tencent.state.map;

import com.tencent.state.data.Image;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B/\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u00a2\u0006\u0002\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\t\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0010\"\u0004\b\u0013\u0010\u0012\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/state/map/MapData;", "", "dataList", "", "Lcom/tencent/state/map/MapItem;", "background", "Lcom/tencent/state/data/Image;", "isReenter", "", "fromCache", "(Ljava/util/List;Lcom/tencent/state/data/Image;ZZ)V", "getBackground", "()Lcom/tencent/state/data/Image;", "getDataList", "()Ljava/util/List;", "getFromCache", "()Z", "setFromCache", "(Z)V", "setReenter", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class MapData {
    private final Image background;
    private final List<MapItem> dataList;
    private boolean fromCache;
    private boolean isReenter;

    /* JADX WARN: Multi-variable type inference failed */
    public MapData(List<? extends MapItem> dataList, Image background, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Intrinsics.checkNotNullParameter(background, "background");
        this.dataList = dataList;
        this.background = background;
        this.isReenter = z16;
        this.fromCache = z17;
    }

    public final Image getBackground() {
        return this.background;
    }

    public final List<MapItem> getDataList() {
        return this.dataList;
    }

    public final boolean getFromCache() {
        return this.fromCache;
    }

    /* renamed from: isReenter, reason: from getter */
    public final boolean getIsReenter() {
        return this.isReenter;
    }

    public final void setFromCache(boolean z16) {
        this.fromCache = z16;
    }

    public final void setReenter(boolean z16) {
        this.isReenter = z16;
    }

    public /* synthetic */ MapData(List list, Image image, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, image, (i3 & 4) != 0 ? false : z16, (i3 & 8) != 0 ? false : z17);
    }
}
