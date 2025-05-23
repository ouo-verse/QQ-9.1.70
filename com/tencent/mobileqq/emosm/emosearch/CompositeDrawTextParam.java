package com.tencent.mobileqq.emosm.emosearch;

import android.graphics.Paint;
import android.graphics.PointF;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\t\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\n\u0010\u0017R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/emosm/emosearch/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "[Ljava/lang/String;", "d", "()[Ljava/lang/String;", "textArray", "Landroid/graphics/PointF;", "b", "[Landroid/graphics/PointF;", "()[Landroid/graphics/PointF;", "pointFArray", "Landroid/graphics/Paint;", "c", "Landroid/graphics/Paint;", "()Landroid/graphics/Paint;", "paint", "strokePaint", "<init>", "([Ljava/lang/String;[Landroid/graphics/PointF;Landroid/graphics/Paint;Landroid/graphics/Paint;)V", "qqemoticonpanel-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.emosm.emosearch.a, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class CompositeDrawTextParam {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String[] textArray;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final PointF[] pointFArray;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Paint paint;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Paint strokePaint;

    public CompositeDrawTextParam(@NotNull String[] textArray, @NotNull PointF[] pointFArray, @NotNull Paint paint, @Nullable Paint paint2) {
        Intrinsics.checkNotNullParameter(textArray, "textArray");
        Intrinsics.checkNotNullParameter(pointFArray, "pointFArray");
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.textArray = textArray;
        this.pointFArray = pointFArray;
        this.paint = paint;
        this.strokePaint = paint2;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final Paint getPaint() {
        return this.paint;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final PointF[] getPointFArray() {
        return this.pointFArray;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final Paint getStrokePaint() {
        return this.strokePaint;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String[] getTextArray() {
        return this.textArray;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CompositeDrawTextParam)) {
            return false;
        }
        CompositeDrawTextParam compositeDrawTextParam = (CompositeDrawTextParam) other;
        if (Intrinsics.areEqual(this.textArray, compositeDrawTextParam.textArray) && Intrinsics.areEqual(this.pointFArray, compositeDrawTextParam.pointFArray) && Intrinsics.areEqual(this.paint, compositeDrawTextParam.paint) && Intrinsics.areEqual(this.strokePaint, compositeDrawTextParam.strokePaint)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((Arrays.hashCode(this.textArray) * 31) + Arrays.hashCode(this.pointFArray)) * 31) + this.paint.hashCode()) * 31;
        Paint paint = this.strokePaint;
        if (paint == null) {
            hashCode = 0;
        } else {
            hashCode = paint.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        return "CompositeDrawTextParam(textArray=" + Arrays.toString(this.textArray) + ", pointFArray=" + Arrays.toString(this.pointFArray) + ", paint=" + this.paint + ", strokePaint=" + this.strokePaint + ')';
    }
}
