package com.tencent.mobileqq.util.conversationtitlebutton;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/util/conversationtitlebutton/l;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "()Z", "hasRedTouch", "b", "isTipsShowing", "<init>", "(ZZ)V", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.util.conversationtitlebutton.l, reason: from toString */
/* loaded from: classes20.dex */
public final /* data */ class TitleButtonState {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean hasRedTouch;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isTipsShowing;

    public TitleButtonState(boolean z16, boolean z17) {
        this.hasRedTouch = z16;
        this.isTipsShowing = z17;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getHasRedTouch() {
        return this.hasRedTouch;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsTipsShowing() {
        return this.isTipsShowing;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TitleButtonState)) {
            return false;
        }
        TitleButtonState titleButtonState = (TitleButtonState) other;
        if (this.hasRedTouch == titleButtonState.hasRedTouch && this.isTipsShowing == titleButtonState.isTipsShowing) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z16 = this.hasRedTouch;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        boolean z17 = this.isTipsShowing;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "TitleButtonState(hasRedTouch=" + this.hasRedTouch + ", isTipsShowing=" + this.isTipsShowing + ")";
    }
}
