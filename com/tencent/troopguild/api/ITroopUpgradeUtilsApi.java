package com.tencent.troopguild.api;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.fragment.app.FragmentManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00022\u00020\u00022\u00020\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/troopguild/api/ITroopUpgradeUtilsApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "troop-guild-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes7.dex */
public interface ITroopUpgradeUtilsApi extends QRouteApi {
    @Nullable
    /* synthetic */ Object createTroopGuildUpgradeHelper(@NotNull Object obj);

    @NotNull
    /* synthetic */ Object createTroopSettingUpgradeRedDotProcessor(@Nullable BaseQQAppInterface baseQQAppInterface, @Nullable String str);

    @Nullable
    /* synthetic */ <T extends Parcelable> T decodeUpgradeDialogUIData(@NotNull String str, @NotNull Class<T> cls);

    /* synthetic */ boolean didUserConfirmUpgrade(@NotNull String str);

    /* synthetic */ void encodeUpgradeDialogUIData(@NotNull String str, @Nullable Parcelable parcelable);

    /* synthetic */ void encodeUpgradeDialogUIData(@NotNull String str, @NotNull String[] strArr);

    @Nullable
    /* synthetic */ String[] getImageUrlsFromUIDataOf(@NotNull String str);

    /* synthetic */ boolean hasCacheUpgradeDialogUIData(@NotNull String str);

    /* synthetic */ boolean hasDialogShownEver(@NotNull String str);

    /* synthetic */ boolean hasTouchRedDotOfTroopUpgrade(@NotNull String str);

    /* synthetic */ boolean hasUseRecentCacheToShowDialogPassively(@NotNull String str);

    /* synthetic */ long lastTimeOfRequestServerForDialog(@NotNull String str);

    /* synthetic */ void loadImageByGuildPicLoader(@NotNull String str, @NotNull ImageView imageView, @Nullable Pair<Integer, Integer> pair, @Nullable String str2);

    /* synthetic */ void noteDialogHasShown(@NotNull String str, boolean z16);

    /* synthetic */ void noteHasTouchRedDotOfTroopUpgrade(@NotNull String str, boolean z16);

    /* synthetic */ void noteLastTimeOfRequestServerForDialog(@NotNull String str, long j3);

    /* synthetic */ void noteUseRecentCacheToShowDialogPassively(@NotNull String str);

    /* synthetic */ void noteUserConfirmUpgrade(@NotNull String str);

    /* synthetic */ void preDownloadImage(@NotNull String[] strArr, @NotNull Runnable runnable);

    @MainThread
    /* synthetic */ void restartAIOToTroopGuildIfNeeded(@Nullable AppInterface appInterface, @Nullable Activity activity, @Nullable Object obj, @Nullable String str, @NotNull String str2);

    /* synthetic */ void restartAIOToTroopGuildIfNeeded(@Nullable AppInterface appInterface, @Nullable Activity activity, @Nullable String str, @NotNull String str2);

    /* synthetic */ boolean shouldShowTroopUpgradeSetting(@Nullable AppInterface appInterface, @Nullable String str);

    /* synthetic */ void showUpgradeGuideDialog(@NotNull String str, @NotNull FragmentManager fragmentManager, @Nullable DialogInterface.OnClickListener onClickListener, @Nullable DialogInterface.OnDismissListener onDismissListener, @Nullable View view);

    /* synthetic */ void showUpgradeGuideDialogInAIO(@NotNull String str, @NotNull FragmentManager fragmentManager, @Nullable DialogInterface.OnClickListener onClickListener, @Nullable DialogInterface.OnDismissListener onDismissListener, @Nullable View view);
}
