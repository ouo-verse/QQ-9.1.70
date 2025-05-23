package com.tencent.zplan.meme;

import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.zplan.meme.a;
import com.tencent.zplan.meme.action.MemeAction;
import com.tencent.zplan.meme.model.MemeFrame;
import com.tencent.zplan.meme.model.MemeResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/zplan/meme/b;", "Lcom/tencent/zplan/meme/a;", "Lcom/tencent/zplan/meme/model/c;", AIInput.KEY_FRAME, "", "Z1", "", "success", "Lcom/tencent/zplan/meme/model/MemeResult;", "cover", "ad", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public interface b extends com.tencent.zplan.meme.a {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a {
        public static void a(@NotNull b bVar, @NotNull MemeAction action, float f16) {
            Intrinsics.checkNotNullParameter(action, "action");
            a.C10066a.a(bVar, action, f16);
        }

        public static void b(@NotNull b bVar, @NotNull MemeFrame frame) {
            Intrinsics.checkNotNullParameter(frame, "frame");
        }
    }

    void Z1(@NotNull MemeFrame frame);

    void ad(boolean success, @NotNull MemeResult cover);
}
