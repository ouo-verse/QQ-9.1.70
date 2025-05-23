package com.tencent.mobileqq.guild.temp.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H&J\b\u0010\r\u001a\u00020\u000bH&J\b\u0010\u000e\u001a\u00020\u000bH&J\b\u0010\u000f\u001a\u00020\u000bH&J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/temp/api/IGuildAIOChatBackgroundApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "aioCreate", "Landroid/view/View;", "context", "Landroid/content/Context;", "curFriendUin", "", "uinType", "", "aioDelayLoad", "", "selfUin", "aioDestroy", "aioPause", "aioResume", "getCurrentChatBackgroundBg", "getCurrentChatBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "qqguild-df-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildAIOChatBackgroundApi extends QRouteApi {
    @Nullable
    View aioCreate(@Nullable Context context, @NotNull String curFriendUin, int uinType);

    void aioDelayLoad(@NotNull String selfUin);

    void aioDestroy();

    void aioPause();

    void aioResume();

    @Nullable
    String getCurrentChatBackgroundBg(@NotNull String curFriendUin, int uinType);

    @Nullable
    Drawable getCurrentChatBackgroundDrawable(@NotNull String curFriendUin, int uinType);
}
