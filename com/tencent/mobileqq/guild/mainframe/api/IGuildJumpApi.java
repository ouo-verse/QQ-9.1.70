package com.tencent.mobileqq.guild.mainframe.api;

import android.app.Activity;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qr1.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J@\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\b\u0010\u000e\u001a\u00020\u0006H&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/api/IGuildJumpApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/app/Activity;", "context", "", "url", "", "needRegister", PhotoCategorySummaryInfo.AVATAR_URL, "nickName", "Lqr1/c;", "callback", "", "registerAndJumpGuild", "isGuildUser", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes14.dex */
public interface IGuildJumpApi extends QRouteApi {
    boolean isGuildUser();

    void registerAndJumpGuild(@NotNull Activity context, @Nullable String url, boolean needRegister, @Nullable String avatarUrl, @Nullable String nickName, @Nullable c callback);
}
