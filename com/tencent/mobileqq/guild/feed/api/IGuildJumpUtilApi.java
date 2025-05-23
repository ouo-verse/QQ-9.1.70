package com.tencent.mobileqq.guild.feed.api;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/IGuildJumpUtilApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "openGuildBatchManagePage", "", "context", "Landroid/content/Context;", "guildId", "", "openUrlOrSchema", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "url", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes13.dex */
public interface IGuildJumpUtilApi extends QRouteApi {
    void openGuildBatchManagePage(@NotNull Context context, @NotNull String guildId);

    void openUrlOrSchema(@Nullable Activity activity, @Nullable String url);
}
