package com.tencent.qqmini.minigame.yungame.va;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqmini/minigame/yungame/va/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getWidth", "()I", "width", "b", "getHeight", "height", "c", "top", "d", "getRight", "right", "e", "bottom", "f", "left", "<init>", "(IIIIII)V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* renamed from: com.tencent.qqmini.minigame.yungame.va.b, reason: from toString */
/* loaded from: classes23.dex */
public final /* data */ class MenuButtonRect {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int width;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int height;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int top;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int right;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int bottom;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int left;

    public MenuButtonRect(int i3, int i16, int i17, int i18, int i19, int i26) {
        this.width = i3;
        this.height = i16;
        this.top = i17;
        this.right = i18;
        this.bottom = i19;
        this.left = i26;
    }

    /* renamed from: a, reason: from getter */
    public final int getBottom() {
        return this.bottom;
    }

    /* renamed from: b, reason: from getter */
    public final int getLeft() {
        return this.left;
    }

    /* renamed from: c, reason: from getter */
    public final int getTop() {
        return this.top;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof MenuButtonRect) {
                MenuButtonRect menuButtonRect = (MenuButtonRect) other;
                if (this.width != menuButtonRect.width || this.height != menuButtonRect.height || this.top != menuButtonRect.top || this.right != menuButtonRect.right || this.bottom != menuButtonRect.bottom || this.left != menuButtonRect.left) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((((((this.width * 31) + this.height) * 31) + this.top) * 31) + this.right) * 31) + this.bottom) * 31) + this.left;
    }

    @NotNull
    public String toString() {
        return "MenuButtonRect(width=" + this.width + ", height=" + this.height + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ", left=" + this.left + ")";
    }
}
