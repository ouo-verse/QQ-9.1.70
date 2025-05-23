package com.tencent.aio.monitor.trace;

import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J4\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u0005H&J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH&\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/aio/monitor/trace/a;", "", "", "tag", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "", "a", "", "interestedIn", "()[Ljava/lang/String;", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface a {
    void a(@NotNull String tag, @NotNull HashMap<String, String> params);

    @NotNull
    String[] interestedIn();
}
