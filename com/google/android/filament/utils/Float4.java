package com.google.android.filament.utils;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\t\u00a2\u0006\u0004\b\u0019\u0010\u001aB\u001b\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\t\u00a2\u0006\u0004\b\u0019\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0018\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\n\u0010\r\"\u0004\b\u0017\u0010\u000f\u00a8\u0006\u001e"}, d2 = {"Lcom/google/android/filament/utils/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "b", "()F", "setX", "(F)V", HippyTKDListViewAdapter.X, "c", "setY", "y", "d", "setZ", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "setW", "w", "<init>", "(FFFF)V", "Lcom/google/android/filament/utils/b;", "v", "(Lcom/google/android/filament/utils/b;F)V", "filament-utils-android_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.google.android.filament.utils.c, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class Float4 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private float x;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private float y;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private float z;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private float w;

    public Float4() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final float getW() {
        return this.w;
    }

    /* renamed from: b, reason: from getter */
    public final float getX() {
        return this.x;
    }

    /* renamed from: c, reason: from getter */
    public final float getY() {
        return this.y;
    }

    /* renamed from: d, reason: from getter */
    public final float getZ() {
        return this.z;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof Float4) {
                Float4 float4 = (Float4) other;
                if (Float.compare(this.x, float4.x) != 0 || Float.compare(this.y, float4.y) != 0 || Float.compare(this.z, float4.z) != 0 || Float.compare(this.w, float4.w) != 0) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.x) * 31) + Float.floatToIntBits(this.y)) * 31) + Float.floatToIntBits(this.z)) * 31) + Float.floatToIntBits(this.w);
    }

    @NotNull
    public String toString() {
        return "Float4(x=" + this.x + ", y=" + this.y + ", z=" + this.z + ", w=" + this.w + ")";
    }

    public Float4(float f16, float f17, float f18, float f19) {
        this.x = f16;
        this.y = f17;
        this.z = f18;
        this.w = f19;
    }

    public /* synthetic */ Float4(float f16, float f17, float f18, float f19, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0.0f : f16, (i3 & 2) != 0 ? 0.0f : f17, (i3 & 4) != 0 ? 0.0f : f18, (i3 & 8) != 0 ? 0.0f : f19);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Float4(@NotNull Float3 v3, float f16) {
        this(v3.getX(), v3.getY(), v3.getZ(), f16);
        Intrinsics.checkNotNullParameter(v3, "v");
    }
}
