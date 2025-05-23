package com.tencent.mobileqq.guild.setting.group;

import com.heytap.databaseengine.apiv3.data.Element;
import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0014\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/d;", "Lcom/tencent/mobileqq/guild/setting/group/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "b", UserInfo.SEX_FEMALE, "e", "()F", Element.ELEMENT_NAME_DISTANCE, "c", "I", "d", "()I", "type", "<init>", "(FI)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.setting.group.d, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class BindGroupSpaceData extends a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final float distance;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int type;

    public /* synthetic */ BindGroupSpaceData(float f16, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(f16, (i16 & 2) != 0 ? 3 : i3);
    }

    @Override // com.tencent.mobileqq.guild.setting.group.a
    /* renamed from: d, reason: from getter */
    public int getType() {
        return this.type;
    }

    /* renamed from: e, reason: from getter */
    public final float getDistance() {
        return this.distance;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BindGroupSpaceData)) {
            return false;
        }
        BindGroupSpaceData bindGroupSpaceData = (BindGroupSpaceData) other;
        if (Float.compare(this.distance, bindGroupSpaceData.distance) == 0 && getType() == bindGroupSpaceData.getType()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.distance) * 31) + getType();
    }

    @NotNull
    public String toString() {
        return "BindGroupSpaceData(distance=" + this.distance + ", type=" + getType() + ")";
    }

    public BindGroupSpaceData(float f16, int i3) {
        this.distance = f16;
        this.type = i3;
    }
}
