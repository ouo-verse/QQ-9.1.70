package com.tencent.mobileqq.guild.api;

import android.widget.ImageView;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.mobileqq.guild.q;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\"\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006H&J \u0010\u0010\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/api/IGuildContactApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "jumpGuildTabDiscoverPage", "Landroid/widget/ImageView;", "avatarView", "", PhotoCategorySummaryInfo.AVATAR_URL, "guildName", "updateGuildAvatar", "guildId", "jumpGuildOnFullStandalone", "", "isSetTop", "Lcom/tencent/mobileqq/guild/q;", "iChangeTopCallback", "changeGuildTop", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGuildContactApi extends QRouteApi {
    void changeGuildTop(@NotNull String guildId, boolean isSetTop, @NotNull q iChangeTopCallback);

    void jumpGuildOnFullStandalone(@NotNull String guildId);

    void jumpGuildTabDiscoverPage();

    void updateGuildAvatar(@NotNull ImageView avatarView, @NotNull String avatarUrl, @NotNull String guildName);
}
