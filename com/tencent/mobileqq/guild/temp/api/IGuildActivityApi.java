package com.tencent.mobileqq.guild.temp.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\f\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H&J\f\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H&J\f\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/temp/api/IGuildActivityApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getAIOSingleActivityClass", "Ljava/lang/Class;", "getGuildChatActivityClass", "getGuildChatFragmentClass", "isGuildAIOSingleTaskActivity", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "isGuildChatActivity", "isSplashActivity", "launchGuildChatPieInSplitMode", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "qqguild-df-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildActivityApi extends QRouteApi {
    @NotNull
    Class<?> getAIOSingleActivityClass();

    @NotNull
    Class<?> getGuildChatActivityClass();

    @NotNull
    Class<?> getGuildChatFragmentClass();

    boolean isGuildAIOSingleTaskActivity(@NotNull Activity activity);

    boolean isGuildChatActivity(@NotNull Activity activity);

    boolean isSplashActivity(@NotNull Activity activity);

    void launchGuildChatPieInSplitMode(@NotNull Context context, @NotNull Intent intent);
}
