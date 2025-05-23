package com.tencent.biz.richframework.monitor.sample;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/biz/richframework/monitor/sample/IRFWSampleMeetStrategy;", "", "getSampleSize", "", "key", "", "isTargetType", "", "monitor_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IRFWSampleMeetStrategy {
    float getSampleSize(@Nullable String key);

    boolean isTargetType();
}
