package com.tencent.qcircle.weseevideo.model.resource;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qcircle/weseevideo/model/resource/EditorPointF;", "Ljava/io/Serializable;", HippyTKDListViewAdapter.X, "", "y", "(FF)V", "getX", "()F", "getY", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final /* data */ class EditorPointF implements Serializable {
    private final float x;
    private final float y;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public EditorPointF() {
        this(r2, r2, 3, null);
        float f16 = 0.0f;
    }

    public static /* synthetic */ EditorPointF copy$default(EditorPointF editorPointF, float f16, float f17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = editorPointF.x;
        }
        if ((i3 & 2) != 0) {
            f17 = editorPointF.y;
        }
        return editorPointF.copy(f16, f17);
    }

    /* renamed from: component1, reason: from getter */
    public final float getX() {
        return this.x;
    }

    /* renamed from: component2, reason: from getter */
    public final float getY() {
        return this.y;
    }

    @NotNull
    public final EditorPointF copy(float x16, float y16) {
        return new EditorPointF(x16, y16);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof EditorPointF) {
                EditorPointF editorPointF = (EditorPointF) other;
                if (Float.compare(this.x, editorPointF.x) != 0 || Float.compare(this.y, editorPointF.y) != 0) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.x) * 31) + Float.floatToIntBits(this.y);
    }

    @NotNull
    public String toString() {
        return "EditorPointF(x=" + this.x + ", y=" + this.y + ")";
    }

    public EditorPointF(float f16, float f17) {
        this.x = f16;
        this.y = f17;
    }

    public /* synthetic */ EditorPointF(float f16, float f17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0.0f : f16, (i3 & 2) != 0 ? 0.0f : f17);
    }
}
