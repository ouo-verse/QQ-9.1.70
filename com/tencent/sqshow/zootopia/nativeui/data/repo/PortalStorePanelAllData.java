package com.tencent.sqshow.zootopia.nativeui.data.repo;

import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.sqshow.zootopia.nativeui.data.sort.PanelSortData;
import com.tencent.sqshow.zootopia.nativeui.view.PortalStoreGroupPanelPageData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uv4.ak;
import uv4.at;
import uv4.au;
import uv4.av;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010%\u001a\u0004\u0018\u00010 \u0012\b\u0010*\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040\t\u0012\b\u00100\u001a\u0004\u0018\u00010-\u0012\u0006\u00103\u001a\u00020\u0007\u0012\u0006\u00108\u001a\u000204\u0012\b\b\u0002\u0010:\u001a\u00020\u0007\u0012\b\b\u0002\u0010<\u001a\u00020\u0007\u00a2\u0006\u0004\b=\u0010>J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000b\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0016\u0010\u001eR\u0019\u0010%\u001a\u0004\u0018\u00010 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010*\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\f\u001a\u0004\b+\u0010\u000eR\u0019\u00100\u001a\u0004\u0018\u00010-8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010.\u001a\u0004\b\u001c\u0010/R\u0017\u00103\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b+\u00101\u001a\u0004\b\u0011\u00102R\u0017\u00108\u001a\u0002048\u0006\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b&\u00107R\u0017\u0010:\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b9\u00101\u001a\u0004\b!\u00102R\u0017\u0010<\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b;\u00101\u001a\u0004\b5\u00102\u00a8\u0006?"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/repo/m;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/sqshow/zootopia/nativeui/view/PortalStoreGroupPanelPageData;", "a", "Ljava/util/List;", "g", "()Ljava/util/List;", "groupData", "Luv4/ak;", "b", "Luv4/ak;", "()Luv4/ak;", "avatarData", "Lcom/tencent/sqshow/zootopia/nativeui/data/sort/b;", "c", "Lcom/tencent/sqshow/zootopia/nativeui/data/sort/b;", tl.h.F, "()Lcom/tencent/sqshow/zootopia/nativeui/data/sort/b;", "panelSortData", "Luv4/at;", "d", "Luv4/at;", "()Luv4/at;", "commonCfg", "Luv4/au;", "e", "Luv4/au;", "getColorConfigData", "()Luv4/au;", "colorConfigData", "f", "Ljava/lang/Integer;", "getGenderRedDotId", "()Ljava/lang/Integer;", "genderRedDotId", "i", "redDotList", "Luv4/av;", "Luv4/av;", "()Luv4/av;", "faceEditorCfg", "Z", "()Z", "clearDressHistory", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "j", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "()Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "gender", "k", "fromCache", "l", "refreshCurrentDress", "<init>", "(Ljava/util/List;Luv4/ak;Lcom/tencent/sqshow/zootopia/nativeui/data/sort/b;Luv4/at;Luv4/au;Ljava/lang/Integer;Ljava/util/List;Luv4/av;ZLcom/tencent/mobileqq/zootopia/api/UEAvatarGender;ZZ)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.nativeui.data.repo.m, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class PortalStorePanelAllData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<PortalStoreGroupPanelPageData> groupData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final ak avatarData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final PanelSortData panelSortData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final at commonCfg;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final au colorConfigData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final Integer genderRedDotId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<Integer> redDotList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final av faceEditorCfg;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean clearDressHistory;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private final UEAvatarGender gender;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean fromCache;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean refreshCurrentDress;

    public PortalStorePanelAllData(List<PortalStoreGroupPanelPageData> groupData, ak avatarData, PanelSortData panelSortData, at atVar, au auVar, Integer num, List<Integer> redDotList, av avVar, boolean z16, UEAvatarGender gender, boolean z17, boolean z18) {
        Intrinsics.checkNotNullParameter(groupData, "groupData");
        Intrinsics.checkNotNullParameter(avatarData, "avatarData");
        Intrinsics.checkNotNullParameter(panelSortData, "panelSortData");
        Intrinsics.checkNotNullParameter(redDotList, "redDotList");
        Intrinsics.checkNotNullParameter(gender, "gender");
        this.groupData = groupData;
        this.avatarData = avatarData;
        this.panelSortData = panelSortData;
        this.commonCfg = atVar;
        this.colorConfigData = auVar;
        this.genderRedDotId = num;
        this.redDotList = redDotList;
        this.faceEditorCfg = avVar;
        this.clearDressHistory = z16;
        this.gender = gender;
        this.fromCache = z17;
        this.refreshCurrentDress = z18;
    }

    /* renamed from: a, reason: from getter */
    public final ak getAvatarData() {
        return this.avatarData;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getClearDressHistory() {
        return this.clearDressHistory;
    }

    /* renamed from: c, reason: from getter */
    public final at getCommonCfg() {
        return this.commonCfg;
    }

    /* renamed from: d, reason: from getter */
    public final av getFaceEditorCfg() {
        return this.faceEditorCfg;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getFromCache() {
        return this.fromCache;
    }

    /* renamed from: f, reason: from getter */
    public final UEAvatarGender getGender() {
        return this.gender;
    }

    public final List<PortalStoreGroupPanelPageData> g() {
        return this.groupData;
    }

    /* renamed from: h, reason: from getter */
    public final PanelSortData getPanelSortData() {
        return this.panelSortData;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.groupData.hashCode() * 31) + this.avatarData.hashCode()) * 31) + this.panelSortData.hashCode()) * 31;
        at atVar = this.commonCfg;
        int hashCode2 = (hashCode + (atVar == null ? 0 : atVar.hashCode())) * 31;
        au auVar = this.colorConfigData;
        int hashCode3 = (hashCode2 + (auVar == null ? 0 : auVar.hashCode())) * 31;
        Integer num = this.genderRedDotId;
        int hashCode4 = (((hashCode3 + (num == null ? 0 : num.hashCode())) * 31) + this.redDotList.hashCode()) * 31;
        av avVar = this.faceEditorCfg;
        int hashCode5 = (hashCode4 + (avVar != null ? avVar.hashCode() : 0)) * 31;
        boolean z16 = this.clearDressHistory;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int hashCode6 = (((hashCode5 + i3) * 31) + this.gender.hashCode()) * 31;
        boolean z17 = this.fromCache;
        int i16 = z17;
        if (z17 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode6 + i16) * 31;
        boolean z18 = this.refreshCurrentDress;
        return i17 + (z18 ? 1 : z18 ? 1 : 0);
    }

    public final List<Integer> i() {
        return this.redDotList;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getRefreshCurrentDress() {
        return this.refreshCurrentDress;
    }

    public String toString() {
        return "PortalStorePanelAllData(groupData=" + this.groupData + ", avatarData=" + this.avatarData + ", panelSortData=" + this.panelSortData + ", commonCfg=" + this.commonCfg + ", colorConfigData=" + this.colorConfigData + ", genderRedDotId=" + this.genderRedDotId + ", redDotList=" + this.redDotList + ", faceEditorCfg=" + this.faceEditorCfg + ", clearDressHistory=" + this.clearDressHistory + ", gender=" + this.gender + ", fromCache=" + this.fromCache + ", refreshCurrentDress=" + this.refreshCurrentDress + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PortalStorePanelAllData)) {
            return false;
        }
        PortalStorePanelAllData portalStorePanelAllData = (PortalStorePanelAllData) other;
        return Intrinsics.areEqual(this.groupData, portalStorePanelAllData.groupData) && Intrinsics.areEqual(this.avatarData, portalStorePanelAllData.avatarData) && Intrinsics.areEqual(this.panelSortData, portalStorePanelAllData.panelSortData) && Intrinsics.areEqual(this.commonCfg, portalStorePanelAllData.commonCfg) && Intrinsics.areEqual(this.colorConfigData, portalStorePanelAllData.colorConfigData) && Intrinsics.areEqual(this.genderRedDotId, portalStorePanelAllData.genderRedDotId) && Intrinsics.areEqual(this.redDotList, portalStorePanelAllData.redDotList) && Intrinsics.areEqual(this.faceEditorCfg, portalStorePanelAllData.faceEditorCfg) && this.clearDressHistory == portalStorePanelAllData.clearDressHistory && this.gender == portalStorePanelAllData.gender && this.fromCache == portalStorePanelAllData.fromCache && this.refreshCurrentDress == portalStorePanelAllData.refreshCurrentDress;
    }
}
