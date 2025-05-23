package com.tencent.tav.coremedia;

import android.graphics.PointF;
import android.support.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes26.dex */
public class CGRect implements Cloneable {

    @NonNull
    public final PointF origin;

    @NonNull
    public final CGSize size;

    public CGRect(float f16, float f17, float f18, float f19) {
        this(new PointF(f16, f17), new CGSize(f18, f19));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CGRect cGRect = (CGRect) obj;
        if (this.origin.equals(cGRect.origin) && this.size.equals(cGRect.size)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "[" + this.origin + "," + this.size + "]";
    }

    public CGRect(@NonNull PointF pointF, @NonNull CGSize cGSize) {
        Utils.checkNotNull(pointF);
        Utils.checkNotNull(cGSize);
        pointF = pointF == null ? new PointF() : pointF;
        cGSize = cGSize == null ? new CGSize() : cGSize;
        this.origin = pointF;
        this.size = cGSize;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public CGRect m257clone() {
        PointF pointF = this.origin;
        float f16 = pointF.x;
        float f17 = pointF.y;
        CGSize cGSize = this.size;
        return new CGRect(f16, f17, cGSize.width, cGSize.height);
    }

    public CGRect() {
        this.origin = new PointF();
        this.size = new CGSize();
    }
}
