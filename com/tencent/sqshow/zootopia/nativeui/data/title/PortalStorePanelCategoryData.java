package com.tencent.sqshow.zootopia.nativeui.data.title;

import com.tencent.sqshow.zootopia.widget.tab.BaseZPlanTabTitleData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uv4.ao;
import uv4.ay;
import uv4.bg;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Bg\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010'\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u0012\b\b\u0002\u0010#\u001a\u00020\"\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0004\u001a\u00020\u0002R\u0017\u0010\u0006\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\tR\u0017\u0010\f\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\tR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0019\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001e\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010#\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/title/PortalStorePanelCategoryData;", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseZPlanTabTitleData;", "", "toString", "getIndex", "", "selfIndex", "I", "getSelfIndex", "()I", "parentIndex", "getParentIndex", "grandIndex", "getGrandIndex", "itemId", "Ljava/lang/String;", "getItemId", "()Ljava/lang/String;", "", "Lcom/tencent/sqshow/zootopia/nativeui/data/title/PortalStorePanelTypeData;", "typeList", "Ljava/util/List;", "getTypeList", "()Ljava/util/List;", "Luv4/ao;", "categoryCfg", "Luv4/ao;", "getCategoryCfg", "()Luv4/ao;", "Luv4/bg;", "sectionCfgV1", "Luv4/bg;", "getSectionCfgV1", "()Luv4/bg;", "Luv4/ay;", "groupCfgV1", "Luv4/ay;", "getGroupCfgV1", "()Luv4/ay;", "title", "<init>", "(IIILjava/lang/String;Ljava/lang/String;Ljava/util/List;Luv4/ao;Luv4/bg;Luv4/ay;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PortalStorePanelCategoryData extends BaseZPlanTabTitleData<String> {
    private final ao categoryCfg;
    private final int grandIndex;
    private final ay groupCfgV1;
    private final String itemId;
    private final int parentIndex;
    private final bg sectionCfgV1;
    private final int selfIndex;
    private final List<PortalStorePanelTypeData> typeList;

    public PortalStorePanelCategoryData() {
        this(0, 0, 0, null, null, null, null, null, null, 511, null);
    }

    public final ao getCategoryCfg() {
        return this.categoryCfg;
    }

    public final int getGrandIndex() {
        return this.grandIndex;
    }

    public final ay getGroupCfgV1() {
        return this.groupCfgV1;
    }

    public final String getIndex() {
        return "grand=" + this.grandIndex + " parent=" + this.parentIndex + " self=" + this.selfIndex;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final int getParentIndex() {
        return this.parentIndex;
    }

    public final bg getSectionCfgV1() {
        return this.sectionCfgV1;
    }

    public final int getSelfIndex() {
        return this.selfIndex;
    }

    public final List<PortalStorePanelTypeData> getTypeList() {
        return this.typeList;
    }

    public String toString() {
        return "PortalStorePanelSubTitleData grandIndex:" + this.grandIndex + " parentIndex:" + this.parentIndex + ", selfIndex:" + this.selfIndex;
    }

    public /* synthetic */ PortalStorePanelCategoryData(int i3, int i16, int i17, String str, String str2, List list, ao aoVar, bg bgVar, ay ayVar, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? 0 : i3, (i18 & 2) != 0 ? 0 : i16, (i18 & 4) == 0 ? i17 : 0, (i18 & 8) != 0 ? "" : str, (i18 & 16) == 0 ? str2 : "", (i18 & 32) != 0 ? new ArrayList() : list, (i18 & 64) != 0 ? new ao() : aoVar, (i18 & 128) != 0 ? new bg() : bgVar, (i18 & 256) != 0 ? new ay() : ayVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalStorePanelCategoryData(int i3, int i16, int i17, String itemId, String title, List<PortalStorePanelTypeData> typeList, ao categoryCfg, bg sectionCfgV1, ay groupCfgV1) {
        super(i3 + "-" + itemId, "");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(typeList, "typeList");
        Intrinsics.checkNotNullParameter(categoryCfg, "categoryCfg");
        Intrinsics.checkNotNullParameter(sectionCfgV1, "sectionCfgV1");
        Intrinsics.checkNotNullParameter(groupCfgV1, "groupCfgV1");
        this.selfIndex = i3;
        this.parentIndex = i16;
        this.grandIndex = i17;
        this.itemId = itemId;
        this.typeList = typeList;
        this.categoryCfg = categoryCfg;
        this.sectionCfgV1 = sectionCfgV1;
        this.groupCfgV1 = groupCfgV1;
    }
}
