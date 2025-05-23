package com.tencent.mobileqq.zplan.minihome;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0014\u0010\b\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH&J8\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/ab;", "", "Lcom/tencent/mobileqq/zplan/minihome/MiniHomeProfileCardType;", "type", "", "a", "", "timeStatJSONString", "e", "", "hasPausedBeforeFirstFrame", "", "duration", "c", "durationFromStart", "durationFromLoad", "b", "roomLoaded", "avatarLoaded", "firstFramed", "timeStatCallbacked", "d", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface ab {
    void a(@NotNull MiniHomeProfileCardType type);

    void b(boolean hasPausedBeforeFirstFrame, long durationFromStart, long durationFromLoad);

    void c(boolean hasPausedBeforeFirstFrame, long duration);

    void d(boolean roomLoaded, boolean avatarLoaded, boolean firstFramed, boolean timeStatCallbacked, boolean hasPausedBeforeFirstFrame, long duration);

    void e(@Nullable String timeStatJSONString);
}
