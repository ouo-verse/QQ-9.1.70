package com.tencent.sqshow.zootopia.nativeui.data.repo;

import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.sqshow.zootopia.nativeui.data.sort.PanelSortData;
import com.tencent.sqshow.zootopia.nativeui.view.AvatarPanelViewData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uv4.ak;
import uv4.at;
import uv4.au;
import uv4.av;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010 \u001a\u0004\u0018\u00010\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u000b\u0010\u001fR\u0019\u0010&\u001a\u0004\u0018\u00010!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0019\u0010*\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b\u0017\u0010)R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0006\u00a2\u0006\f\n\u0004\b+\u0010\f\u001a\u0004\b,\u0010\u000eR\u0019\u00102\u001a\u0004\u0018\u00010.8\u0006\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b\u0011\u00101R\u0017\u00107\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0017\u0010=\u001a\u0002088\u0006\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0017\u0010@\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b>\u00104\u001a\u0004\b?\u00106\u00a8\u0006A"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/repo/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/sqshow/zootopia/nativeui/view/AvatarPanelViewData;", "a", "Ljava/util/List;", "getGroupData", "()Ljava/util/List;", "groupData", "Luv4/ak;", "b", "Luv4/ak;", "getAvatarData", "()Luv4/ak;", "avatarData", "Lcom/tencent/sqshow/zootopia/nativeui/data/sort/b;", "c", "Lcom/tencent/sqshow/zootopia/nativeui/data/sort/b;", "getPanelSortData", "()Lcom/tencent/sqshow/zootopia/nativeui/data/sort/b;", "panelSortData", "Luv4/at;", "d", "Luv4/at;", "()Luv4/at;", "commonCfg", "Luv4/au;", "e", "Luv4/au;", "getColorConfigData", "()Luv4/au;", "colorConfigData", "f", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "genderRedDotId", "g", "getRedDotList", "redDotList", "Luv4/av;", tl.h.F, "Luv4/av;", "()Luv4/av;", "faceEditorCfg", "i", "Z", "getClearDressHistory", "()Z", "clearDressHistory", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "j", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "getGender", "()Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "gender", "k", "getFromCache", "fromCache", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.nativeui.data.repo.e, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class AvatarPanelAllData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<AvatarPanelViewData> groupData;

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

    /* renamed from: a, reason: from getter */
    public final at getCommonCfg() {
        return this.commonCfg;
    }

    /* renamed from: b, reason: from getter */
    public final av getFaceEditorCfg() {
        return this.faceEditorCfg;
    }

    /* renamed from: c, reason: from getter */
    public final Integer getGenderRedDotId() {
        return this.genderRedDotId;
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
        return hashCode6 + (z17 ? 1 : z17 ? 1 : 0);
    }

    public String toString() {
        return "AvatarPanelAllData(groupData=" + this.groupData + ", avatarData=" + this.avatarData + ", panelSortData=" + this.panelSortData + ", commonCfg=" + this.commonCfg + ", colorConfigData=" + this.colorConfigData + ", genderRedDotId=" + this.genderRedDotId + ", redDotList=" + this.redDotList + ", faceEditorCfg=" + this.faceEditorCfg + ", clearDressHistory=" + this.clearDressHistory + ", gender=" + this.gender + ", fromCache=" + this.fromCache + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AvatarPanelAllData)) {
            return false;
        }
        AvatarPanelAllData avatarPanelAllData = (AvatarPanelAllData) other;
        return Intrinsics.areEqual(this.groupData, avatarPanelAllData.groupData) && Intrinsics.areEqual(this.avatarData, avatarPanelAllData.avatarData) && Intrinsics.areEqual(this.panelSortData, avatarPanelAllData.panelSortData) && Intrinsics.areEqual(this.commonCfg, avatarPanelAllData.commonCfg) && Intrinsics.areEqual(this.colorConfigData, avatarPanelAllData.colorConfigData) && Intrinsics.areEqual(this.genderRedDotId, avatarPanelAllData.genderRedDotId) && Intrinsics.areEqual(this.redDotList, avatarPanelAllData.redDotList) && Intrinsics.areEqual(this.faceEditorCfg, avatarPanelAllData.faceEditorCfg) && this.clearDressHistory == avatarPanelAllData.clearDressHistory && this.gender == avatarPanelAllData.gender && this.fromCache == avatarPanelAllData.fromCache;
    }
}
