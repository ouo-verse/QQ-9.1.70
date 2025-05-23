package com.tencent.mobileqq.wink.mosaic.model;

import java.io.Serializable;

/* loaded from: classes21.dex */
public class PointAction implements Serializable {
    public static int LINETO = 2;
    public static int MOVETO = 1;
    public static int QUADTO = 3;
    private static final long serialVersionUID = 599123213464337757L;
    public int mode;

    /* renamed from: x, reason: collision with root package name */
    public float f324010x;

    /* renamed from: x2, reason: collision with root package name */
    public float f324011x2;

    /* renamed from: y, reason: collision with root package name */
    public float f324012y;

    /* renamed from: y2, reason: collision with root package name */
    public float f324013y2;

    public PointAction() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PointAction pointAction = (PointAction) obj;
        if (this.mode == pointAction.mode && Float.compare(pointAction.f324010x, this.f324010x) == 0 && Float.compare(pointAction.f324012y, this.f324012y) == 0 && Float.compare(pointAction.f324011x2, this.f324011x2) == 0 && Float.compare(pointAction.f324013y2, this.f324013y2) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18 = this.mode * 31;
        float f16 = this.f324010x;
        int i19 = 0;
        if (f16 != 0.0f) {
            i3 = Float.floatToIntBits(f16);
        } else {
            i3 = 0;
        }
        int i26 = (i18 + i3) * 31;
        float f17 = this.f324012y;
        if (f17 != 0.0f) {
            i16 = Float.floatToIntBits(f17);
        } else {
            i16 = 0;
        }
        int i27 = (i26 + i16) * 31;
        float f18 = this.f324011x2;
        if (f18 != 0.0f) {
            i17 = Float.floatToIntBits(f18);
        } else {
            i17 = 0;
        }
        int i28 = (i27 + i17) * 31;
        float f19 = this.f324013y2;
        if (f19 != 0.0f) {
            i19 = Float.floatToIntBits(f19);
        }
        return i28 + i19;
    }

    public PointAction(int i3, float f16, float f17) {
        this.mode = i3;
        this.f324010x = f16;
        this.f324012y = f17;
    }

    public PointAction(int i3, float f16, float f17, float f18, float f19) {
        this.mode = i3;
        this.f324010x = f16;
        this.f324012y = f17;
        this.f324011x2 = f18;
        this.f324013y2 = f19;
    }
}
