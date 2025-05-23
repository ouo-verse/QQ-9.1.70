package com.google.android.filament.utils;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\n\u0012\b\b\u0002\u0010\u0016\u001a\u00020\n\u00a2\u0006\u0004\b\u0017\u0010\u0018B\u0011\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\n\u00a2\u0006\u0004\b\u0017\u0010\u000fJ\t\u0010\u0002\u001a\u00020\u0000H\u0086\u0002J\t\u0010\u0004\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0016\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Lcom/google/android/filament/utils/b;", "", "d", "", "toString", "", "hashCode", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "()F", "setX", "(F)V", HippyTKDListViewAdapter.X, "b", "setY", "y", "c", "setZ", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "<init>", "(FFF)V", "v", "filament-utils-android_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.google.android.filament.utils.b, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class Float3 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private float x;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private float y;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private float z;

    public Float3() {
        this(0.0f, 0.0f, 0.0f, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final float getX() {
        return this.x;
    }

    /* renamed from: b, reason: from getter */
    public final float getY() {
        return this.y;
    }

    /* renamed from: c, reason: from getter */
    public final float getZ() {
        return this.z;
    }

    @NotNull
    public final Float3 d() {
        return new Float3(-this.x, -this.y, -this.z);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof Float3) {
                Float3 float3 = (Float3) other;
                if (Float.compare(this.x, float3.x) != 0 || Float.compare(this.y, float3.y) != 0 || Float.compare(this.z, float3.z) != 0) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.x) * 31) + Float.floatToIntBits(this.y)) * 31) + Float.floatToIntBits(this.z);
    }

    @NotNull
    public String toString() {
        return "Float3(x=" + this.x + ", y=" + this.y + ", z=" + this.z + ")";
    }

    public Float3(float f16, float f17, float f18) {
        this.x = f16;
        this.y = f17;
        this.z = f18;
    }

    public /* synthetic */ Float3(float f16, float f17, float f18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0.0f : f16, (i3 & 2) != 0 ? 0.0f : f17, (i3 & 4) != 0 ? 0.0f : f18);
    }

    public Float3(float f16) {
        this(f16, f16, f16);
    }
}
