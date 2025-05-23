package com.tencent.mobileqq.guild.profile;

import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import kotlin.Metadata;
import lv1.c;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

@Service(process = {""})
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/IGuildProfileRuntimeService;", "Lmqq/app/api/IRuntimeService;", "", PhotoCategorySummaryInfo.AVATAR_URL, "nickName", "Llv1/c;", "callback", "", "setMyGuildProfile", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface IGuildProfileRuntimeService extends IRuntimeService {
    void setMyGuildProfile(@NotNull String avatarUrl, @NotNull String nickName, @NotNull c callback);
}
