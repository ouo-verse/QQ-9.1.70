package com.tencent.zplan.meme;

import com.tencent.zplan.meme.action.ActionStatus;
import com.tencent.zplan.meme.action.MemeAction;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/zplan/meme/d;", "Lcom/tencent/zplan/meme/b;", "Lcom/tencent/zplan/meme/action/MemeAction;", "action", "", "recordKey", "Lcom/tencent/zplan/meme/action/ActionStatus;", "status", "", "kg", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public interface d extends b {
    void kg(@NotNull MemeAction action, @NotNull String recordKey, @NotNull ActionStatus status);
}
