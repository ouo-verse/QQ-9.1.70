package com.tencent.kuikly.core.base.attr;

import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J0\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/kuikly/core/base/attr/c;", "", "", "top", "left", "bottom", "right", "margin", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public interface c {
    c margin(float top, float left, float bottom, float right);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class a {
        public static /* synthetic */ c a(c cVar, float f16, float f17, float f18, float f19, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
                    f16 = Float.NaN;
                }
                if ((i3 & 2) != 0) {
                    FloatCompanionObject floatCompanionObject2 = FloatCompanionObject.INSTANCE;
                    f17 = Float.NaN;
                }
                if ((i3 & 4) != 0) {
                    FloatCompanionObject floatCompanionObject3 = FloatCompanionObject.INSTANCE;
                    f18 = Float.NaN;
                }
                if ((i3 & 8) != 0) {
                    FloatCompanionObject floatCompanionObject4 = FloatCompanionObject.INSTANCE;
                    f19 = Float.NaN;
                }
                return cVar.margin(f16, f17, f18, f19);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: margin");
        }
    }
}
