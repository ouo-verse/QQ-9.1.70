package com.tencent.zplan.cloud.record.api;

import com.tencent.zplan.meme.action.MemeZPlanBaseAction;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J<\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/zplan/cloud/record/api/a;", "", "Lcom/tencent/zplan/meme/action/MemeZPlanBaseAction;", "action", "Lgx4/a;", "avatarCharacter", "", "maxWaitDuration", "recordScene", "Lcom/tencent/zplan/cloud/record/api/Priority;", "priority", "Lcom/tencent/zplan/cloud/record/api/b;", "cloudRecordListener", "", "a", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public interface a {
    void a(@NotNull MemeZPlanBaseAction action, @Nullable gx4.a avatarCharacter, int maxWaitDuration, int recordScene, @NotNull Priority priority, @Nullable b cloudRecordListener);
}
