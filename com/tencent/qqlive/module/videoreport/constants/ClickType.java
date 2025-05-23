package com.tencent.qqlive.module.videoreport.constants;

/* compiled from: P */
/* loaded from: classes22.dex */
public enum ClickType {
    VIEW_CLICK(0),
    VIEW_LONG_CLICK(1);

    private final int mClickType;

    ClickType(int i3) {
        this.mClickType = i3;
    }

    public int getType() {
        return this.mClickType;
    }
}
