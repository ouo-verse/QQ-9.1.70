package com.tencent.sqshow.zootopia.friendsdressup.filament;

import com.tencent.filament.zplan.animation.FilamentAnimation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/filament/zplan/animation/FilamentAnimation;", "", "a", "superqqshow-portal-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class f {
    public static final String a(FilamentAnimation filamentAnimation) {
        Intrinsics.checkNotNullParameter(filamentAnimation, "<this>");
        return "index:" + filamentAnimation.getIndex() + ", duration:" + filamentAnimation.getDuration() + ", path:" + filamentAnimation.getPath();
    }
}
