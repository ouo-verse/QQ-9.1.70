package com.tencent.hippy.qq.view.tkd.listview;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyTKDUISize {
    public int mHeight;
    public int mWidth;

    public HippyTKDUISize() {
        this.mWidth = 0;
        this.mHeight = 0;
    }

    public void add(HippyTKDUISize hippyTKDUISize) {
        if (hippyTKDUISize == null) {
            return;
        }
        this.mWidth += hippyTKDUISize.mWidth;
        this.mHeight += hippyTKDUISize.mHeight;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HippyTKDUISize)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        HippyTKDUISize hippyTKDUISize = (HippyTKDUISize) obj;
        if (hippyTKDUISize.mHeight != this.mHeight || hippyTKDUISize.mWidth != this.mWidth) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ("" + this.mWidth + HippyTKDListViewAdapter.X + this.mHeight).hashCode();
    }

    public void add(short s16, short s17) {
        this.mWidth += s16;
        this.mHeight += s17;
    }

    public HippyTKDUISize(int i3, int i16) {
        this.mWidth = i3;
        this.mHeight = i16;
    }
}
