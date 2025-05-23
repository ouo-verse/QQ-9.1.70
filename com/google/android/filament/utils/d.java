package com.google.android.filament.utils;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\b\u0018\u0000 \u00032\u00020\u0001:\u0001\u000eB/\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0017\u001a\u00020\r\u0012\b\b\u0002\u0010\u001a\u001a\u00020\r\u0012\b\b\u0002\u0010\u001c\u001a\u00020\r\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0011\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0017\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\"\u0010\u001a\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\"\u0010\u001c\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011\"\u0004\b\u001b\u0010\u0013\u00a8\u0006\u001f"}, d2 = {"Lcom/google/android/filament/utils/d;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "e", "", "f", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/google/android/filament/utils/c;", "a", "Lcom/google/android/filament/utils/c;", "b", "()Lcom/google/android/filament/utils/c;", "setX", "(Lcom/google/android/filament/utils/c;)V", HippyTKDListViewAdapter.X, "c", "setY", "y", "d", "setZ", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "setW", "w", "<init>", "(Lcom/google/android/filament/utils/c;Lcom/google/android/filament/utils/c;Lcom/google/android/filament/utils/c;Lcom/google/android/filament/utils/c;)V", "filament-utils-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Float4 x;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Float4 y;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Float4 z;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Float4 w;

    public d() {
        this(null, null, null, null, 15, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final Float4 getW() {
        return this.w;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final Float4 getX() {
        return this.x;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final Float4 getY() {
        return this.y;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final Float4 getZ() {
        return this.z;
    }

    @NotNull
    public final d e(@NotNull d m3) {
        Intrinsics.checkNotNullParameter(m3, "m");
        return new d(new Float4((this.x.getX() * m3.x.getX()) + (this.y.getX() * m3.x.getY()) + (this.z.getX() * m3.x.getZ()) + (this.w.getX() * m3.x.getW()), (this.x.getY() * m3.x.getX()) + (this.y.getY() * m3.x.getY()) + (this.z.getY() * m3.x.getZ()) + (this.w.getY() * m3.x.getW()), (this.x.getZ() * m3.x.getX()) + (this.y.getZ() * m3.x.getY()) + (this.z.getZ() * m3.x.getZ()) + (this.w.getZ() * m3.x.getW()), (this.x.getW() * m3.x.getX()) + (this.y.getW() * m3.x.getY()) + (this.z.getW() * m3.x.getZ()) + (this.w.getW() * m3.x.getW())), new Float4((this.x.getX() * m3.y.getX()) + (this.y.getX() * m3.y.getY()) + (this.z.getX() * m3.y.getZ()) + (this.w.getX() * m3.y.getW()), (this.x.getY() * m3.y.getX()) + (this.y.getY() * m3.y.getY()) + (this.z.getY() * m3.y.getZ()) + (this.w.getY() * m3.y.getW()), (this.x.getZ() * m3.y.getX()) + (this.y.getZ() * m3.y.getY()) + (this.z.getZ() * m3.y.getZ()) + (this.w.getZ() * m3.y.getW()), (this.x.getW() * m3.y.getX()) + (this.y.getW() * m3.y.getY()) + (this.z.getW() * m3.y.getZ()) + (this.w.getW() * m3.y.getW())), new Float4((this.x.getX() * m3.z.getX()) + (this.y.getX() * m3.z.getY()) + (this.z.getX() * m3.z.getZ()) + (this.w.getX() * m3.z.getW()), (this.x.getY() * m3.z.getX()) + (this.y.getY() * m3.z.getY()) + (this.z.getY() * m3.z.getZ()) + (this.w.getY() * m3.z.getW()), (this.x.getZ() * m3.z.getX()) + (this.y.getZ() * m3.z.getY()) + (this.z.getZ() * m3.z.getZ()) + (this.w.getZ() * m3.z.getW()), (this.x.getW() * m3.z.getX()) + (this.y.getW() * m3.z.getY()) + (this.z.getW() * m3.z.getZ()) + (this.w.getW() * m3.z.getW())), new Float4((this.x.getX() * m3.w.getX()) + (this.y.getX() * m3.w.getY()) + (this.z.getX() * m3.w.getZ()) + (this.w.getX() * m3.w.getW()), (this.x.getY() * m3.w.getX()) + (this.y.getY() * m3.w.getY()) + (this.z.getY() * m3.w.getZ()) + (this.w.getY() * m3.w.getW()), (this.x.getZ() * m3.w.getX()) + (this.y.getZ() * m3.w.getY()) + (this.z.getZ() * m3.w.getZ()) + (this.w.getZ() * m3.w.getW()), (this.x.getW() * m3.w.getX()) + (this.y.getW() * m3.w.getY()) + (this.z.getW() * m3.w.getZ()) + (this.w.getW() * m3.w.getW())));
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof d) {
                d dVar = (d) other;
                if (!Intrinsics.areEqual(this.x, dVar.x) || !Intrinsics.areEqual(this.y, dVar.y) || !Intrinsics.areEqual(this.z, dVar.z) || !Intrinsics.areEqual(this.w, dVar.w)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final float[] f() {
        return new float[]{this.x.getX(), this.y.getX(), this.z.getX(), this.w.getX(), this.x.getY(), this.y.getY(), this.z.getY(), this.w.getY(), this.x.getZ(), this.y.getZ(), this.z.getZ(), this.w.getZ(), this.x.getW(), this.y.getW(), this.z.getW(), this.w.getW()};
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        Float4 float4 = this.x;
        int i18 = 0;
        if (float4 != null) {
            i3 = float4.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = i3 * 31;
        Float4 float42 = this.y;
        if (float42 != null) {
            i16 = float42.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        Float4 float43 = this.z;
        if (float43 != null) {
            i17 = float43.hashCode();
        } else {
            i17 = 0;
        }
        int i27 = (i26 + i17) * 31;
        Float4 float44 = this.w;
        if (float44 != null) {
            i18 = float44.hashCode();
        }
        return i27 + i18;
    }

    @NotNull
    public String toString() {
        String trimIndent;
        trimIndent = StringsKt__IndentKt.trimIndent("\n            |" + this.x.getX() + TokenParser.SP + this.y.getX() + TokenParser.SP + this.z.getX() + TokenParser.SP + this.w.getX() + "|\n            |" + this.x.getY() + TokenParser.SP + this.y.getY() + TokenParser.SP + this.z.getY() + TokenParser.SP + this.w.getY() + "|\n            |" + this.x.getZ() + TokenParser.SP + this.y.getZ() + TokenParser.SP + this.z.getZ() + TokenParser.SP + this.w.getZ() + "|\n            |" + this.x.getW() + TokenParser.SP + this.y.getW() + TokenParser.SP + this.z.getW() + TokenParser.SP + this.w.getW() + "|\n            ");
        return trimIndent;
    }

    public d(@NotNull Float4 x16, @NotNull Float4 y16, @NotNull Float4 z16, @NotNull Float4 w3) {
        Intrinsics.checkNotNullParameter(x16, "x");
        Intrinsics.checkNotNullParameter(y16, "y");
        Intrinsics.checkNotNullParameter(z16, "z");
        Intrinsics.checkNotNullParameter(w3, "w");
        this.x = x16;
        this.y = y16;
        this.z = z16;
        this.w = w3;
    }

    public /* synthetic */ d(Float4 float4, Float4 float42, Float4 float43, Float4 float44, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new Float4(1.0f, 0.0f, 0.0f, 0.0f, 14, null) : float4, (i3 & 2) != 0 ? new Float4(0.0f, 1.0f, 0.0f, 0.0f, 13, null) : float42, (i3 & 4) != 0 ? new Float4(0.0f, 0.0f, 1.0f, 0.0f, 11, null) : float43, (i3 & 8) != 0 ? new Float4(0.0f, 0.0f, 0.0f, 1.0f, 7, null) : float44);
    }
}
