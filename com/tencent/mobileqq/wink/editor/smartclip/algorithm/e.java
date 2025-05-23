package com.tencent.mobileqq.wink.editor.smartclip.algorithm;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J.\u0010\n\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&J0\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/e;", "", "", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/MusicTimePoint;", "musicTimePoints", "", "musicDurationInMillis", "sourceTotalDuration", "", "sourceCount", "b", "totalDuration", "count", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface e {
    @Nullable
    long[] a(long totalDuration, int count, @NotNull List<MusicTimePoint> musicTimePoints, long musicDurationInMillis);

    long b(@NotNull List<MusicTimePoint> musicTimePoints, long musicDurationInMillis, long sourceTotalDuration, int sourceCount);
}
