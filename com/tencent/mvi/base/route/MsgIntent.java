package com.tencent.mvi.base.route;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mvi/base/route/MsgIntent;", "Lcom/tencent/mvi/base/route/i;", "", "isSticky", "mvi_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes21.dex */
public interface MsgIntent extends i {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes21.dex */
    public static final class a {
        public static boolean a(@NotNull MsgIntent msgIntent) {
            return false;
        }
    }

    boolean isSticky();
}
