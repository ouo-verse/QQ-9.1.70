package com.tencent.mobileqq.qmmkv;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J4\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u0005H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qmmkv/e;", "", "", AdMetricTag.EVENT_NAME, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "param", "", "report", "qqestablish_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public interface e {
    void report(@NotNull String eventName, @NotNull HashMap<String, String> param);
}
