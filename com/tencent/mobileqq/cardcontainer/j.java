package com.tencent.mobileqq.cardcontainer;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.cardcontainer.data.ContainerData;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004H&J$\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004H&J\"\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/j;", "", "", "elementId", "", "params", "", "b", "c", "Lcom/tencent/mobileqq/cardcontainer/data/ContainerData;", "cardData", "", AdMetricTag.Report.TYPE, "customData", "a", "cardcontainer_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public interface j {
    void a(@NotNull ContainerData cardData, int reportType, @Nullable String customData);

    void b(@NotNull String elementId, @NotNull Map<String, ? extends Object> params);

    void c(@NotNull String elementId, @NotNull Map<String, ? extends Object> params);
}
