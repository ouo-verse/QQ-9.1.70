package com.tencent.qqnt.avatar.util;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/avatar/util/c;", "", "", "name", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "isSwitchOn", VipFunCallConstants.KEY_GROUP, AdMetricTag.FALLBACK, "loadAsString", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface c {
    boolean isSwitchOn(@NotNull String name, boolean defaultValue);

    @NotNull
    String loadAsString(@NotNull String group, @NotNull String fallback);
}
