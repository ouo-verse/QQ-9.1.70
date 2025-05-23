package com.tencent.mobileqq.zplan.aigc.data;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0015\n\u0002\b\u000e\b\u0086\b\u0018\u0000 -2\u00020\u0001:\u0001\tBc\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b+\u0010,J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0014\u0010\u0017\"\u0004\b\u001b\u0010\u0019R$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\t\u0010\u0017\"\u0004\b\u001e\u0010\u0019R$\u0010%\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010!\u001a\u0004\b\u001d\u0010\"\"\u0004\b#\u0010$R$\u0010(\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u0015\u001a\u0004\b&\u0010\u0017\"\u0004\b'\u0010\u0019R$\u0010*\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u0015\u001a\u0004\b\u0010\u0010\u0017\"\u0004\b)\u0010\u0019\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/data/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "d", "()I", "setId", "(I)V", "id", "b", "getRandomId", "setRandomId", "randomId", "c", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "name", "setDescription", "description", "e", "setBackgroundUrl", "backgroundUrl", "", "[I", "()[I", "setItemIds", "([I)V", "itemIds", "g", tl.h.F, "selectItemID", "setColor", "color", "<init>", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;[ILjava/lang/String;Ljava/lang/String;)V", "i", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.aigc.data.i, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class Imagery {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int randomId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private String name;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private String description;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private String backgroundUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private int[] itemIds;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private String selectItemID;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private String color;

    public Imagery() {
        this(0, 0, null, null, null, null, null, null, 255, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getBackgroundUrl() {
        return this.backgroundUrl;
    }

    /* renamed from: b, reason: from getter */
    public final String getColor() {
        return this.color;
    }

    /* renamed from: c, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: d, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: e, reason: from getter */
    public final int[] getItemIds() {
        return this.itemIds;
    }

    /* renamed from: f, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: g, reason: from getter */
    public final String getSelectItemID() {
        return this.selectItemID;
    }

    public final void h(String str) {
        this.selectItemID = str;
    }

    public int hashCode() {
        int i3 = ((this.id * 31) + this.randomId) * 31;
        String str = this.name;
        int hashCode = (i3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.backgroundUrl;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        int[] iArr = this.itemIds;
        int hashCode4 = (hashCode3 + (iArr == null ? 0 : Arrays.hashCode(iArr))) * 31;
        String str4 = this.selectItemID;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.color;
        return hashCode5 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "Imagery(id=" + this.id + ", randomId=" + this.randomId + ", name=" + this.name + ", description=" + this.description + ", backgroundUrl=" + this.backgroundUrl + ", itemIds=" + Arrays.toString(this.itemIds) + ", selectItemID=" + this.selectItemID + ", color=" + this.color + ")";
    }

    public Imagery(int i3, int i16, String str, String str2, String str3, int[] iArr, String str4, String str5) {
        this.id = i3;
        this.randomId = i16;
        this.name = str;
        this.description = str2;
        this.backgroundUrl = str3;
        this.itemIds = iArr;
        this.selectItemID = str4;
        this.color = str5;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Imagery)) {
            return false;
        }
        Imagery imagery = (Imagery) other;
        return this.id == imagery.id && this.randomId == imagery.randomId && Intrinsics.areEqual(this.name, imagery.name) && Intrinsics.areEqual(this.description, imagery.description) && Intrinsics.areEqual(this.backgroundUrl, imagery.backgroundUrl) && Intrinsics.areEqual(this.itemIds, imagery.itemIds) && Intrinsics.areEqual(this.selectItemID, imagery.selectItemID) && Intrinsics.areEqual(this.color, imagery.color);
    }

    public /* synthetic */ Imagery(int i3, int i16, String str, String str2, String str3, int[] iArr, String str4, String str5, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) == 0 ? i16 : 0, (i17 & 4) != 0 ? null : str, (i17 & 8) != 0 ? null : str2, (i17 & 16) != 0 ? null : str3, (i17 & 32) != 0 ? null : iArr, (i17 & 64) != 0 ? null : str4, (i17 & 128) == 0 ? str5 : null);
    }
}
