package com.tencent.mobileqq.widget.search;

import java.util.Objects;

/* loaded from: classes20.dex */
public class SearchAnimProp {
    public int height;
    public boolean isVisible;
    public int vId;
    public int width;

    /* renamed from: x, reason: collision with root package name */
    public int f317275x;

    /* renamed from: y, reason: collision with root package name */
    public int f317276y;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && this.vId == ((SearchAnimProp) obj).vId) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.vId));
    }

    public SearchAnimProp setHeight(int i3) {
        this.height = i3;
        return this;
    }

    public SearchAnimProp setId(int i3) {
        this.vId = i3;
        return this;
    }

    public SearchAnimProp setVisible(boolean z16) {
        this.isVisible = z16;
        return this;
    }

    public SearchAnimProp setWidth(int i3) {
        this.width = i3;
        return this;
    }

    public SearchAnimProp setX(int i3) {
        this.f317275x = i3;
        return this;
    }

    public SearchAnimProp setY(int i3) {
        this.f317276y = i3;
        return this;
    }
}
