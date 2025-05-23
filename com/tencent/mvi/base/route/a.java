package com.tencent.mvi.base.route;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mvi/base/route/a;", "", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "", "sticky", "mvi_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes21.dex */
public interface a {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.tencent.mvi.base.route.a$a, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static final class C9235a {
        public static boolean a(@NotNull a aVar) {
            return false;
        }
    }

    void call(@NotNull MsgIntent i3);

    boolean sticky();
}
