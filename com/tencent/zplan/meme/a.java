package com.tencent.zplan.meme;

import com.tencent.zplan.meme.action.MemeAction;
import com.tencent.zplan.meme.model.MemeResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/zplan/meme/a;", "", "", "success", "Lcom/tencent/zplan/meme/model/MemeResult;", "result", "", "l9", "Lcom/tencent/zplan/meme/action/MemeAction;", "action", "", "currProgress", "d3", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public interface a {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.meme.a$a, reason: collision with other inner class name */
    /* loaded from: classes27.dex */
    public static final class C10066a {
        public static void a(@NotNull a aVar, @NotNull MemeAction action, float f16) {
            Intrinsics.checkNotNullParameter(action, "action");
        }

        public static void b(@NotNull a aVar, boolean z16, @NotNull MemeResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
        }
    }

    void d3(@NotNull MemeAction action, float currProgress);

    void l9(boolean success, @NotNull MemeResult result);
}
