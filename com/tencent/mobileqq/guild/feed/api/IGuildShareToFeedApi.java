package com.tencent.mobileqq.guild.feed.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J4\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/IGuildShareToFeedApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "guildId", "Lcom/tencent/mobileqq/guild/feed/api/SharePublishGuildFeedParam;", "shareParam", "", "sharePageSource", "Lcom/tencent/mobileqq/guild/feed/api/g;", "shareResultListener", "", "shareToFeedPostAwareForbidden", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes13.dex */
public interface IGuildShareToFeedApi extends QRouteApi {
    void shareToFeedPostAwareForbidden(@NotNull Activity activity, @NotNull String guildId, @NotNull SharePublishGuildFeedParam shareParam, int sharePageSource, @Nullable g shareResultListener);
}
