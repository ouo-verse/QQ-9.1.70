package com.tencent.sqshow.zootopia.nativeui.data.title;

import com.tencent.sqshow.zootopia.widget.tab.BaseZPlanTabTitleData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uv4.ao;
import uv4.ay;
import uv4.bg;
import uv4.bj;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001+Bk\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010'\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u0012\b\b\u0002\u0010#\u001a\u00020\"\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0019\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001e\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010#\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\u00a8\u0006,"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/title/PortalStorePanelTypeData;", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseZPlanTabTitleData;", "", "toString", "", "selfIndex", "I", "getSelfIndex", "()I", "parentIndex", "getParentIndex", "grandIndex", "getGrandIndex", "greatGrandIndex", "getGreatGrandIndex", "itemId", "Ljava/lang/String;", "getItemId", "()Ljava/lang/String;", "Luv4/bj;", "storeTypeCfg", "Luv4/bj;", "getStoreTypeCfg", "()Luv4/bj;", "Luv4/ao;", "categoryCfg", "Luv4/ao;", "getCategoryCfg", "()Luv4/ao;", "Luv4/bg;", "sectionCfgV1", "Luv4/bg;", "getSectionCfgV1", "()Luv4/bg;", "Luv4/ay;", "categoryGroup", "Luv4/ay;", "getCategoryGroup", "()Luv4/ay;", "title", "<init>", "(IIIILjava/lang/String;Ljava/lang/String;Luv4/bj;Luv4/ao;Luv4/bg;Luv4/ay;)V", "Companion", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PortalStorePanelTypeData extends BaseZPlanTabTitleData<String> {

    /* renamed from: d, reason: collision with root package name */
    private static final PortalStorePanelTypeData f371176d = new PortalStorePanelTypeData(0, 0, 0, 0, null, null, null, null, null, null, 1023, null);
    private final ao categoryCfg;
    private final ay categoryGroup;
    private final int grandIndex;
    private final int greatGrandIndex;
    private final String itemId;
    private final int parentIndex;
    private final bg sectionCfgV1;
    private final int selfIndex;
    private final bj storeTypeCfg;

    public PortalStorePanelTypeData() {
        this(0, 0, 0, 0, null, null, null, null, null, null, 1023, null);
    }

    public final ao getCategoryCfg() {
        return this.categoryCfg;
    }

    public final ay getCategoryGroup() {
        return this.categoryGroup;
    }

    public final int getGrandIndex() {
        return this.grandIndex;
    }

    public final int getGreatGrandIndex() {
        return this.greatGrandIndex;
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

    public final bj getStoreTypeCfg() {
        return this.storeTypeCfg;
    }

    public String toString() {
        return "PortalStorePanelThirdTitleData-greatGrandIndex:" + this.greatGrandIndex + " grandIndex:" + this.grandIndex + ", parentIndex:" + this.parentIndex + ", selfIndex:" + this.selfIndex + " ";
    }

    public /* synthetic */ PortalStorePanelTypeData(int i3, int i16, int i17, int i18, String str, String str2, bj bjVar, ao aoVar, bg bgVar, ay ayVar, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? 0 : i3, (i19 & 2) != 0 ? 0 : i16, (i19 & 4) != 0 ? 0 : i17, (i19 & 8) == 0 ? i18 : 0, (i19 & 16) != 0 ? "" : str, (i19 & 32) == 0 ? str2 : "", (i19 & 64) != 0 ? new bj() : bjVar, (i19 & 128) != 0 ? new ao() : aoVar, (i19 & 256) != 0 ? new bg() : bgVar, (i19 & 512) != 0 ? new ay() : ayVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalStorePanelTypeData(int i3, int i16, int i17, int i18, String itemId, String title, bj storeTypeCfg, ao categoryCfg, bg sectionCfgV1, ay categoryGroup) {
        super(i3 + "-" + itemId, title);
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(storeTypeCfg, "storeTypeCfg");
        Intrinsics.checkNotNullParameter(categoryCfg, "categoryCfg");
        Intrinsics.checkNotNullParameter(sectionCfgV1, "sectionCfgV1");
        Intrinsics.checkNotNullParameter(categoryGroup, "categoryGroup");
        this.selfIndex = i3;
        this.parentIndex = i16;
        this.grandIndex = i17;
        this.greatGrandIndex = i18;
        this.itemId = itemId;
        this.storeTypeCfg = storeTypeCfg;
        this.categoryCfg = categoryCfg;
        this.sectionCfgV1 = sectionCfgV1;
        this.categoryGroup = categoryGroup;
    }
}
