package com.tencent.ntcompose.animation;

import com.tencent.kuikly.core.base.TimingFuncType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a>\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007\u001aZ\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007\u00a8\u0006\u0012"}, d2 = {"T", "", "durationMillis", "delayMillis", "Lcom/tencent/ntcompose/animation/h;", "easing", "Lcom/tencent/kuikly/core/base/TimingFuncType;", "timingFuncType", "Lcom/tencent/ntcompose/animation/m;", "c", "", "dampingRatio", "stiffness", "velocity", "", "repeatForever", "Lcom/tencent/ntcompose/animation/l;", "a", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class b {
    public static final <T> l<T> a(float f16, float f17, int i3, float f18, h easing, int i16, boolean z16) {
        Intrinsics.checkNotNullParameter(easing, "easing");
        return new l<>(f16, f17, i3, f18, easing, i16, z16);
    }

    public static final <T> m<T> c(int i3, int i16, h easing, TimingFuncType timingFuncType) {
        Intrinsics.checkNotNullParameter(easing, "easing");
        return new m<>(i3, i16, easing, false, timingFuncType, 8, null);
    }

    public static /* synthetic */ m d(int i3, int i16, h hVar, TimingFuncType timingFuncType, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = 300;
        }
        if ((i17 & 2) != 0) {
            i16 = 0;
        }
        if ((i17 & 4) != 0) {
            hVar = i.b();
        }
        if ((i17 & 8) != 0) {
            timingFuncType = null;
        }
        return c(i3, i16, hVar, timingFuncType);
    }

    public static /* synthetic */ l b(float f16, float f17, int i3, float f18, h hVar, int i16, boolean z16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            f16 = 1.0f;
        }
        if ((i17 & 2) != 0) {
            f17 = 1500.0f;
        }
        if ((i17 & 4) != 0) {
            i3 = 300;
        }
        if ((i17 & 8) != 0) {
            f18 = 1.0f;
        }
        if ((i17 & 16) != 0) {
            hVar = i.b();
        }
        if ((i17 & 32) != 0) {
            i16 = 0;
        }
        if ((i17 & 64) != 0) {
            z16 = false;
        }
        return a(f16, f17, i3, f18, hVar, i16, z16);
    }
}
