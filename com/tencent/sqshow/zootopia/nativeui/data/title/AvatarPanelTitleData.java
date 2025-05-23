package com.tencent.sqshow.zootopia.nativeui.data.title;

import com.tencent.sqshow.zootopia.widget.tab.BaseZPlanTabTitleData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uv4.an;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B?\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0016\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/title/AvatarPanelTitleData;", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseZPlanTabTitleData;", "", "toString", "", "selfIndex", "I", "getSelfIndex", "()I", "parentIndex", "getParentIndex", "itemId", "Ljava/lang/String;", "getItemId", "()Ljava/lang/String;", "", "Lcom/tencent/sqshow/zootopia/nativeui/data/title/AvatarPanelSubTitleData;", "subTitleList", "Ljava/util/List;", "getSubTitleList", "()Ljava/util/List;", "Luv4/an;", "categoryCfg", "Luv4/an;", "getCategoryCfg", "()Luv4/an;", "<init>", "(IILjava/lang/String;Ljava/util/List;Luv4/an;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AvatarPanelTitleData extends BaseZPlanTabTitleData<String> {
    private final an categoryCfg;
    private final String itemId;
    private final int parentIndex;
    private final int selfIndex;
    private final List<AvatarPanelSubTitleData> subTitleList;

    public AvatarPanelTitleData() {
        this(0, 0, null, null, null, 31, null);
    }

    public final an getCategoryCfg() {
        return this.categoryCfg;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final int getParentIndex() {
        return this.parentIndex;
    }

    public final int getSelfIndex() {
        return this.selfIndex;
    }

    public final List<AvatarPanelSubTitleData> getSubTitleList() {
        return this.subTitleList;
    }

    public String toString() {
        return "AvatarPanelTitleData parentIndex:" + this.parentIndex + ", selfIndex:" + this.selfIndex;
    }

    public /* synthetic */ AvatarPanelTitleData(int i3, int i16, String str, List list, an anVar, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) == 0 ? i16 : 0, (i17 & 4) != 0 ? "" : str, (i17 & 8) != 0 ? new ArrayList() : list, (i17 & 16) != 0 ? new an() : anVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarPanelTitleData(int i3, int i16, String itemId, List<AvatarPanelSubTitleData> subTitleList, an categoryCfg) {
        super(i3 + "-" + itemId, "");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(subTitleList, "subTitleList");
        Intrinsics.checkNotNullParameter(categoryCfg, "categoryCfg");
        this.selfIndex = i3;
        this.parentIndex = i16;
        this.itemId = itemId;
        this.subTitleList = subTitleList;
        this.categoryCfg = categoryCfg;
    }
}
