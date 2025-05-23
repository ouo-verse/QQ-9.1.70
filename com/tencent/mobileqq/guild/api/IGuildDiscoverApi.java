package com.tencent.mobileqq.guild.api;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0007H&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0003H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/api/IGuildDiscoverApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "fetchAbTest", "", "fetchSceneId", "", "bizId", "", "source", "guildTabLoadingFinishData", "Landroidx/lifecycle/LiveData;", "", "isGuildPublicAccount", "uin", "openDiscoverFromPublicAccount", "context", "Landroid/content/Context;", "pubAccountParams", "Lcom/tencent/mobileqq/guild/api/GuildPublicAccountParams;", "postGuildTabLoadingFinished", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGuildDiscoverApi extends QRouteApi {
    void fetchAbTest(int fetchSceneId, @NotNull String bizId, @NotNull String source);

    @NotNull
    LiveData<Boolean> guildTabLoadingFinishData();

    boolean isGuildPublicAccount(@NotNull String uin);

    void openDiscoverFromPublicAccount(@NotNull Context context, @NotNull GuildPublicAccountParams pubAccountParams);

    void postGuildTabLoadingFinished();
}
