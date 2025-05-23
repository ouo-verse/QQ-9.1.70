package com.tencent.mtt.hippy.modules.nativemodules.animation;

import com.tencent.mtt.hippy.common.HippyArray;

/* compiled from: P */
/* loaded from: classes20.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    protected final HippyArray f337475a;

    /* renamed from: b, reason: collision with root package name */
    protected final HippyArray f337476b;

    public f(HippyArray hippyArray, HippyArray hippyArray2) {
        this.f337475a = hippyArray;
        this.f337476b = hippyArray2;
    }

    public Object a(Number number) {
        int size;
        HippyArray hippyArray = this.f337475a;
        if (hippyArray == null || this.f337476b == null || (size = hippyArray.size()) != this.f337476b.size() || size == 0) {
            return null;
        }
        double doubleValue = number.doubleValue();
        int i3 = 0;
        double d16 = -1.0d;
        for (int i16 = 0; i16 < size; i16++) {
            Object obj = this.f337475a.get(i16);
            if (!(obj instanceof Number)) {
                return null;
            }
            double doubleValue2 = ((Number) obj).doubleValue();
            if (doubleValue2 <= doubleValue) {
                double abs = Math.abs(doubleValue - doubleValue2);
                if (abs < d16 || d16 == -1.0d) {
                    i3 = i16;
                    d16 = abs;
                }
            }
        }
        return this.f337476b.get(i3);
    }
}
