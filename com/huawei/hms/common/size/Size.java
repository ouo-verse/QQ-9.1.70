package com.huawei.hms.common.size;

import com.huawei.hms.common.internal.Objects;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Size {

    /* renamed from: a, reason: collision with root package name */
    private final int f36893a;

    /* renamed from: b, reason: collision with root package name */
    private final int f36894b;

    public Size(int i3, int i16) {
        this.f36893a = i3;
        this.f36894b = i16;
    }

    public static Size parseSize(String str) {
        try {
            int indexOf = str.indexOf(HippyTKDListViewAdapter.X);
            if (indexOf < 0) {
                indexOf = str.indexOf("*");
            }
            return new Size(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
        } catch (Exception unused) {
            throw new IllegalArgumentException("Size parses failed");
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        if (this.f36893a != size.f36893a || this.f36894b != size.f36894b) {
            return false;
        }
        return true;
    }

    public final int getHeight() {
        return this.f36894b;
    }

    public final int getWidth() {
        return this.f36893a;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(getWidth()), Integer.valueOf(getHeight()));
    }

    public final String toString() {
        return "Width is " + this.f36893a + " Height is " + this.f36894b;
    }
}
