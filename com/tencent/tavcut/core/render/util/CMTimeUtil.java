package com.tencent.tavcut.core.render.util;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/tavcut/core/render/util/CMTimeUtil;", "", "()V", "DEFAULT_TIME_SCALE", "", "genCMTimeFromUs", "Lcom/tencent/tav/coremedia/CMTime;", "timeUs", "", "genCMTimeRangeFromUs", "Lcom/tencent/tav/coremedia/CMTimeRange;", "start", "duration", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class CMTimeUtil {
    private static final int DEFAULT_TIME_SCALE = 1000000;
    public static final CMTimeUtil INSTANCE = new CMTimeUtil();

    CMTimeUtil() {
    }

    @NotNull
    public final CMTime genCMTimeFromUs(long timeUs) {
        return new CMTime(timeUs, 1000000);
    }

    @NotNull
    public final CMTimeRange genCMTimeRangeFromUs(long start, long duration) {
        return new CMTimeRange(genCMTimeFromUs(start), genCMTimeFromUs(duration));
    }
}
