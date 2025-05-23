package com.google.android.filament.utils;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u00a2\u0006\u0004\b\u0013\u0010\u0014B\u0011\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\t\u00a2\u0006\u0004\b\u0013\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/google/android/filament/utils/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "()F", "setX", "(F)V", HippyTKDListViewAdapter.X, "b", "setY", "y", "<init>", "(FF)V", "v", "filament-utils-android_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.google.android.filament.utils.a, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class Float2 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private float x;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private float y;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Float2() {
        this(r2, r2, 3, null);
        float f16 = 0.0f;
    }

    /* renamed from: a, reason: from getter */
    public final float getX() {
        return this.x;
    }

    /* renamed from: b, reason: from getter */
    public final float getY() {
        return this.y;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof Float2) {
                Float2 float2 = (Float2) other;
                if (Float.compare(this.x, float2.x) != 0 || Float.compare(this.y, float2.y) != 0) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.x) * 31) + Float.floatToIntBits(this.y);
    }

    @NotNull
    public String toString() {
        return "Float2(x=" + this.x + ", y=" + this.y + ")";
    }

    public Float2(float f16, float f17) {
        this.x = f16;
        this.y = f17;
    }

    public /* synthetic */ Float2(float f16, float f17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0.0f : f16, (i3 & 2) != 0 ? 0.0f : f17);
    }

    public Float2(float f16) {
        this(f16, f16);
    }
}
