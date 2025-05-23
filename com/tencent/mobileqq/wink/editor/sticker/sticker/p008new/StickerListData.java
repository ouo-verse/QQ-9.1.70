package com.tencent.mobileqq.wink.editor.sticker.sticker.p008new;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0010\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002JQ\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\b2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\rH\u00c6\u0001J\t\u0010\u0017\u001a\u00020\u0004H\u00d6\u0001R\u0017\u0010\u000f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u00108\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010\u0015\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010%\u001a\u0004\b*\u0010'\"\u0004\b+\u0010)\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/a;", "", "", "position", "", "e", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "f", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "recentCate", "a", "hashCode", "other", "", "equals", "tabType", "", "stickersList", "bottomCategories", "selectCateIndex", "selectCateNeedAffectContent", "selected", "b", "toString", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "k", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "Ljava/util/List;", "j", "()Ljava/util/List;", "c", "d", "I", "g", "()I", "l", "(I)V", "Z", h.F, "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Z)V", "i", DomainData.DOMAIN_NAME, "<init>", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;Ljava/util/List;Ljava/util/List;IZZ)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.editor.sticker.sticker.new.a, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class StickerListData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final MetaCategory tabType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<MetaCategory> stickersList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<MetaCategory> bottomCategories;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int selectCateIndex;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean selectCateNeedAffectContent;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean selected;

    public StickerListData(@NotNull MetaCategory tabType, @NotNull List<MetaCategory> stickersList, @NotNull List<MetaCategory> bottomCategories, int i3, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(tabType, "tabType");
        Intrinsics.checkNotNullParameter(stickersList, "stickersList");
        Intrinsics.checkNotNullParameter(bottomCategories, "bottomCategories");
        this.tabType = tabType;
        this.stickersList = stickersList;
        this.bottomCategories = bottomCategories;
        this.selectCateIndex = i3;
        this.selectCateNeedAffectContent = z16;
        this.selected = z17;
    }

    public static /* synthetic */ StickerListData c(StickerListData stickerListData, MetaCategory metaCategory, List list, List list2, int i3, boolean z16, boolean z17, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            metaCategory = stickerListData.tabType;
        }
        if ((i16 & 2) != 0) {
            list = stickerListData.stickersList;
        }
        List list3 = list;
        if ((i16 & 4) != 0) {
            list2 = stickerListData.bottomCategories;
        }
        List list4 = list2;
        if ((i16 & 8) != 0) {
            i3 = stickerListData.selectCateIndex;
        }
        int i17 = i3;
        if ((i16 & 16) != 0) {
            z16 = stickerListData.selectCateNeedAffectContent;
        }
        boolean z18 = z16;
        if ((i16 & 32) != 0) {
            z17 = stickerListData.selected;
        }
        return stickerListData.b(metaCategory, list3, list4, i17, z18, z17);
    }

    @NotNull
    public final StickerListData a(@NotNull MetaCategory recentCate) {
        boolean z16;
        Intrinsics.checkNotNullParameter(recentCate, "recentCate");
        List<MetaCategory> list = this.stickersList;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((MetaCategory) it.next()).f30532id, "100020815")) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        ArrayList arrayList = new ArrayList(this.stickersList);
        if (z16) {
            arrayList.set(0, recentCate);
        } else {
            arrayList.add(0, recentCate);
        }
        Unit unit = Unit.INSTANCE;
        ArrayList arrayList2 = new ArrayList(this.bottomCategories);
        if (z16) {
            arrayList2.set(0, recentCate);
        } else {
            arrayList2.add(0, recentCate);
        }
        int i3 = this.selectCateIndex;
        if (!z16) {
            i3++;
        }
        return c(this, null, arrayList, arrayList2, i3, false, false, 33, null);
    }

    @NotNull
    public final StickerListData b(@NotNull MetaCategory tabType, @NotNull List<MetaCategory> stickersList, @NotNull List<MetaCategory> bottomCategories, int selectCateIndex, boolean selectCateNeedAffectContent, boolean selected) {
        Intrinsics.checkNotNullParameter(tabType, "tabType");
        Intrinsics.checkNotNullParameter(stickersList, "stickersList");
        Intrinsics.checkNotNullParameter(bottomCategories, "bottomCategories");
        return new StickerListData(tabType, stickersList, bottomCategories, selectCateIndex, selectCateNeedAffectContent, selected);
    }

    @NotNull
    public final List<MetaCategory> d() {
        return this.bottomCategories;
    }

    @Nullable
    public final String e(int position) {
        return ac.b(this.stickersList, position);
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(StickerListData.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.sticker.sticker.new.StickerListData");
        StickerListData stickerListData = (StickerListData) other;
        if (!Intrinsics.areEqual(this.tabType.f30532id, stickerListData.tabType.f30532id) || this.stickersList.size() != stickerListData.stickersList.size()) {
            return false;
        }
        int i3 = 0;
        for (MetaCategory metaCategory : this.stickersList) {
            int i16 = i3 + 1;
            if (!Intrinsics.areEqual(metaCategory.f30532id, stickerListData.stickersList.get(i3).f30532id)) {
                return false;
            }
            ArrayList<MetaMaterial> arrayList = stickerListData.stickersList.get(i3).materials;
            if (metaCategory.materials.size() != arrayList.size()) {
                return false;
            }
            Iterator<MetaMaterial> it = metaCategory.materials.iterator();
            int i17 = 0;
            while (it.hasNext()) {
                int i18 = i17 + 1;
                if (!Intrinsics.areEqual(it.next().f30533id, arrayList.get(i17).f30533id)) {
                    return false;
                }
                i17 = i18;
            }
            i3 = i16;
        }
        if (this.bottomCategories.size() != stickerListData.bottomCategories.size()) {
            return false;
        }
        Iterator<MetaCategory> it5 = this.bottomCategories.iterator();
        int i19 = 0;
        while (it5.hasNext()) {
            int i26 = i19 + 1;
            if (!Intrinsics.areEqual(it5.next().f30532id, stickerListData.bottomCategories.get(i19).f30532id)) {
                return false;
            }
            i19 = i26;
        }
        return true;
    }

    @Nullable
    public final MetaMaterial f(int position) {
        return ac.e(this.stickersList, position);
    }

    /* renamed from: g, reason: from getter */
    public final int getSelectCateIndex() {
        return this.selectCateIndex;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getSelectCateNeedAffectContent() {
        return this.selectCateNeedAffectContent;
    }

    public int hashCode() {
        int hashCode = this.tabType.f30532id.hashCode();
        for (MetaCategory metaCategory : this.stickersList) {
            hashCode = (hashCode * 31) + metaCategory.f30532id.hashCode();
            Iterator<MetaMaterial> it = metaCategory.materials.iterator();
            while (it.hasNext()) {
                hashCode = (hashCode * 31) + it.next().f30533id.hashCode();
            }
        }
        Iterator<MetaCategory> it5 = this.bottomCategories.iterator();
        while (it5.hasNext()) {
            hashCode = (hashCode * 31) + it5.next().f30532id.hashCode();
        }
        return hashCode;
    }

    /* renamed from: i, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    @NotNull
    public final List<MetaCategory> j() {
        return this.stickersList;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final MetaCategory getTabType() {
        return this.tabType;
    }

    public final void l(int i3) {
        this.selectCateIndex = i3;
    }

    public final void m(boolean z16) {
        this.selectCateNeedAffectContent = z16;
    }

    public final void n(boolean z16) {
        this.selected = z16;
    }

    @NotNull
    public String toString() {
        return "StickerListData(tabType=" + this.tabType + ", stickersList=" + this.stickersList + ", bottomCategories=" + this.bottomCategories + ", selectCateIndex=" + this.selectCateIndex + ", selectCateNeedAffectContent=" + this.selectCateNeedAffectContent + ", selected=" + this.selected + ")";
    }

    public /* synthetic */ StickerListData(MetaCategory metaCategory, List list, List list2, int i3, boolean z16, boolean z17, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(metaCategory, list, list2, (i16 & 8) != 0 ? -1 : i3, (i16 & 16) != 0 ? false : z16, (i16 & 32) != 0 ? false : z17);
    }
}
