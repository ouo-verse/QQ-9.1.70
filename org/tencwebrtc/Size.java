package org.tencwebrtc;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Size {
    public int height;
    public int width;

    public Size(int i3, int i16) {
        this.width = i3;
        this.height = i16;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        if (this.width != size.width || this.height != size.height) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.width * 65537) + 1 + this.height;
    }

    public String toString() {
        return this.width + HippyTKDListViewAdapter.X + this.height;
    }
}
