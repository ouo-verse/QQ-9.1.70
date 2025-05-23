package com.tencent.kuikly.core.render.android.expand.component.text;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/text/m;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "index", "c", "start", "end", "<init>", "(III)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final /* data */ class m {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int index;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int start;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int end;

    public m(int i3, int i16, int i17) {
        this.index = i3;
        this.start = i16;
        this.end = i17;
    }

    /* renamed from: a, reason: from getter */
    public final int getEnd() {
        return this.end;
    }

    /* renamed from: b, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* renamed from: c, reason: from getter */
    public final int getStart() {
        return this.start;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof m) {
                m mVar = (m) other;
                if (this.index != mVar.index || this.start != mVar.start || this.end != mVar.end) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((this.index * 31) + this.start) * 31) + this.end;
    }

    @NotNull
    public String toString() {
        return '{' + this.index + ", " + this.start + ", " + this.end + '}';
    }
}
