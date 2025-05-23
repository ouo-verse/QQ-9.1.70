package com.tencent.biz.richframework.animation.transition;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TransitionRect implements Serializable {
    int bottom;
    int left;
    int right;
    int top;

    public TransitionRect(int i3, int i16, int i17, int i18) {
        this.left = i3;
        this.top = i16;
        this.right = i17;
        this.bottom = i18;
    }

    public int getBottom() {
        return this.bottom;
    }

    public int getHeight() {
        return this.bottom - this.top;
    }

    public int getLeft() {
        return this.left;
    }

    public int getRight() {
        return this.right;
    }

    public int getTop() {
        return this.top;
    }

    public int getWidth() {
        return this.right - this.left;
    }

    public void setBottom(int i3) {
        this.bottom = i3;
    }

    public void setLeft(int i3) {
        this.left = i3;
    }

    public void setRight(int i3) {
        this.right = i3;
    }

    public void setTop(int i3) {
        this.top = i3;
    }

    public String toString() {
        return "SourceRect{left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + '}';
    }
}
