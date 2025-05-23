package com.tencent.state.square.media;

import java.io.Serializable;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/state/square/media/Size;", "Ljava/io/Serializable;", "width", "", "height", "(II)V", "getHeight", "()I", "setHeight", "(I)V", "getWidth", "setWidth", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class Size implements Serializable {
    private int height;
    private int width;

    public Size(int i3, int i16) {
        this.width = i3;
        this.height = i16;
    }

    /* renamed from: component1, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component2, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    public final Size copy(int width, int height) {
        return new Size(width, height);
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (this.width * 31) + this.height;
    }

    public final void setHeight(int i3) {
        this.height = i3;
    }

    public final void setWidth(int i3) {
        this.width = i3;
    }

    public String toString() {
        return "Size(width=" + this.width + ", height=" + this.height + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Size)) {
            return false;
        }
        Size size = (Size) other;
        return this.width == size.width && this.height == size.height;
    }

    public static /* synthetic */ Size copy$default(Size size, int i3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = size.width;
        }
        if ((i17 & 2) != 0) {
            i16 = size.height;
        }
        return size.copy(i3, i16);
    }
}
