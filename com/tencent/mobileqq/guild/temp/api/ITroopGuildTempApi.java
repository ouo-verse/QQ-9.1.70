package com.tencent.mobileqq.guild.temp.api;

import android.app.Activity;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.UnreadCntInfo;
import kotlin.Metadata;
import kotlin.Pair;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0005H&J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/temp/api/ITroopGuildTempApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "", "isTroopAssistantInitData", "", "troopUin", "isInTroopAssistantList", "Lmqq/app/AppRuntime;", "appRuntime", "", "addTroopToTroopAssistantList", "Lcom/tencent/qqnt/kernel/nativeinterface/UnreadCntInfo;", "unreadCntInfo", "updateTroopAssistantNewMsgSet", "Lcom/tencent/mobileqq/data/RecentUser;", "recentUser", "shouldShowInRecentList", "tryToShowTroopAssistantForTroopGuild", "qqguild-df-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface ITroopGuildTempApi extends QRouteApi {
    void addTroopToTroopAssistantList(@NotNull AppRuntime appRuntime, @NotNull String troopUin);

    @Nullable
    /* synthetic */ Object createTroopGuildUpgradeHelper(@NotNull Object obj);

    @NotNull
    /* synthetic */ Object createTroopSettingUpgradeRedDotProcessor(@Nullable BaseQQAppInterface baseQQAppInterface, @Nullable String str);

    boolean isInTroopAssistantList(@NotNull String troopUin);

    boolean isTroopAssistantInitData();

    /* synthetic */ void loadImageByGuildPicLoader(@NotNull String str, @NotNull ImageView imageView, @Nullable Pair<Integer, Integer> pair, @Nullable String str2);

    /* synthetic */ void preDownloadImage(@NotNull String[] strArr, @NotNull Runnable runnable);

    @MainThread
    /* synthetic */ void restartAIOToTroopGuildIfNeeded(@Nullable AppInterface appInterface, @Nullable Activity activity, @Nullable Object obj, @Nullable String str, @NotNull String str2);

    /* synthetic */ void restartAIOToTroopGuildIfNeeded(@Nullable AppInterface appInterface, @Nullable Activity activity, @Nullable String str, @NotNull String str2);

    boolean shouldShowInRecentList(@NotNull AppRuntime appRuntime, @NotNull RecentUser recentUser);

    boolean tryToShowTroopAssistantForTroopGuild(@NotNull AppRuntime appRuntime, @NotNull String troopUin);

    boolean updateTroopAssistantNewMsgSet(@NotNull AppRuntime appRuntime, @NotNull UnreadCntInfo unreadCntInfo, @NotNull String troopUin);
}
