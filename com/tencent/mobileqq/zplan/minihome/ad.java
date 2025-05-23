package com.tencent.mobileqq.zplan.minihome;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/MapMode;", "", "a", "zplan_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ad {
    public static final int a(@Nullable MapMode mapMode) {
        if (mapMode == null) {
            return -1;
        }
        return mapMode.getValue() + 1;
    }
}
