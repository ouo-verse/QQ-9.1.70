package com.tencent.mobileqq.qqguildsdk.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J*\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH&J\b\u0010\r\u001a\u00020\u000eH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/api/IQQGuildUtilApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getAvatarUrl", "", "guildId", "avatarSeq", "", "type", "", "getCoverUrl", "coverSeq", "width", "height", "isUserOnLine", "", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IQQGuildUtilApi extends QRouteApi {
    @NotNull
    String getAvatarUrl(@Nullable String guildId, long avatarSeq, int type);

    @NotNull
    String getCoverUrl(@Nullable String guildId, long coverSeq, int width, int height);

    boolean isUserOnLine();
}
