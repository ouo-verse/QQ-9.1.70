package com.tencent.mobileqq.zplan.aigc.render;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJ\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005H\u00c6\u0003JT\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010#\u001a\u00020\bH\u00d6\u0001J\t\u0010$\u001a\u00020\u0003H\u00d6\u0001R\u001e\u0010\t\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/render/EditTexture;", "", WadlProxyConsts.KEY_MATERIAL, "", "position", "", "", "width", "", "height", "positions", "Lcom/tencent/mobileqq/zplan/aigc/render/Positions;", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)V", "getHeight", "()Ljava/lang/Integer;", "setHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMaterial", "()Ljava/lang/String;", "getPosition", "()Ljava/util/List;", "getPositions", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)Lcom/tencent/mobileqq/zplan/aigc/render/EditTexture;", "equals", "", "other", "hashCode", "toString", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final /* data */ class EditTexture {
    private Integer height;
    private final String material;
    private final List<Double> position;
    private final List<Positions> positions;
    private Integer width;

    public EditTexture(String material, List<Double> list, Integer num, Integer num2, List<Positions> list2) {
        Intrinsics.checkNotNullParameter(material, "material");
        this.material = material;
        this.position = list;
        this.width = num;
        this.height = num2;
        this.positions = list2;
    }

    /* renamed from: component1, reason: from getter */
    public final String getMaterial() {
        return this.material;
    }

    public final List<Double> component2() {
        return this.position;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getWidth() {
        return this.width;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getHeight() {
        return this.height;
    }

    public final List<Positions> component5() {
        return this.positions;
    }

    public final EditTexture copy(String material, List<Double> position, Integer width, Integer height, List<Positions> positions) {
        Intrinsics.checkNotNullParameter(material, "material");
        return new EditTexture(material, position, width, height, positions);
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final String getMaterial() {
        return this.material;
    }

    public final List<Double> getPosition() {
        return this.position;
    }

    public final List<Positions> getPositions() {
        return this.positions;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public int hashCode() {
        int hashCode = this.material.hashCode() * 31;
        List<Double> list = this.position;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        Integer num = this.width;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.height;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        List<Positions> list2 = this.positions;
        return hashCode4 + (list2 != null ? list2.hashCode() : 0);
    }

    public final void setHeight(Integer num) {
        this.height = num;
    }

    public final void setWidth(Integer num) {
        this.width = num;
    }

    public String toString() {
        return "EditTexture(material=" + this.material + ", position=" + this.position + ", width=" + this.width + ", height=" + this.height + ", positions=" + this.positions + ")";
    }

    public static /* synthetic */ EditTexture copy$default(EditTexture editTexture, String str, List list, Integer num, Integer num2, List list2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = editTexture.material;
        }
        if ((i3 & 2) != 0) {
            list = editTexture.position;
        }
        List list3 = list;
        if ((i3 & 4) != 0) {
            num = editTexture.width;
        }
        Integer num3 = num;
        if ((i3 & 8) != 0) {
            num2 = editTexture.height;
        }
        Integer num4 = num2;
        if ((i3 & 16) != 0) {
            list2 = editTexture.positions;
        }
        return editTexture.copy(str, list3, num3, num4, list2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EditTexture)) {
            return false;
        }
        EditTexture editTexture = (EditTexture) other;
        return Intrinsics.areEqual(this.material, editTexture.material) && Intrinsics.areEqual(this.position, editTexture.position) && Intrinsics.areEqual(this.width, editTexture.width) && Intrinsics.areEqual(this.height, editTexture.height) && Intrinsics.areEqual(this.positions, editTexture.positions);
    }

    public /* synthetic */ EditTexture(String str, List list, Integer num, Integer num2, List list2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : list, (i3 & 4) != 0 ? null : num, (i3 & 8) != 0 ? null : num2, (i3 & 16) != 0 ? null : list2);
    }
}
