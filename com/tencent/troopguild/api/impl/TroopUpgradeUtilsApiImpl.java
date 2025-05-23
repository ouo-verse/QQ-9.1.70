package com.tencent.troopguild.api.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.guild.temp.api.ITroopGuildTempApi;
import com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.troopguild.api.ITroopUpgradeUtilsApi;
import com.tencent.troopguild.dialog.TroopUpgradeGuideDialogFragment;
import com.tencent.troopguild.dialog.data.TroopUpdateGuideDialogUIData;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 P2\u00020\u00012\u00020\u0002:\u0001QB\u0007\u00a2\u0006\u0004\bN\u0010OJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\bH\u0002J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0002J>\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0096\u0001J\u001d\u0010\u001e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0001J9\u0010%\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010!\u001a\u00020 2\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\"2\b\u0010$\u001a\u0004\u0018\u00010\u0003H\u0096\u0001J(\u0010*\u001a\u00020\u000b2\u000e\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030&2\u0006\u0010)\u001a\u00020(H\u0096\u0001\u00a2\u0006\u0004\b*\u0010+J9\u00100\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010,2\b\u0010.\u001a\u0004\u0018\u00010-2\b\u0010/\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010$\u001a\u00020\u0003H\u0097\u0001J/\u00100\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010,2\b\u0010.\u001a\u0004\u0018\u00010-2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010$\u001a\u00020\u0003H\u0096\u0001J6\u00101\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J6\u00102\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u001c\u00103\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010,2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J!\u00104\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010&2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b4\u00105J\u0010\u00107\u001a\u0002062\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u00109\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u00108\u001a\u000206H\u0016J\u0010\u0010:\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010<\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\bH\u0016J\u0010\u0010=\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010?\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\bH\u0016J\u0010\u0010@\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010A\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001a\u0010D\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010C\u001a\u0004\u0018\u00010BH\u0016J%\u0010D\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00030&H\u0016\u00a2\u0006\u0004\bD\u0010EJ1\u0010I\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010F*\u00020B2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000GH\u0016\u00a2\u0006\u0004\bI\u0010JJ\u0010\u0010K\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010L\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010M\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a8\u0006R"}, d2 = {"Lcom/tencent/troopguild/api/impl/TroopUpgradeUtilsApiImpl;", "Lcom/tencent/troopguild/api/ITroopUpgradeUtilsApi;", "", "", "troopUin", "", "getStateFlag", "flagMask", "", "hasStateFlag", "set", "", "setStateFlag", "key", "keyOf", "Landroidx/fragment/app/FragmentManager;", "fm", "Landroid/os/Bundle;", "args", "Landroid/content/DialogInterface$OnClickListener;", "clickListener", "Landroid/content/DialogInterface$OnDismissListener;", "dismissListener", "Landroid/view/View;", "logicParent", "showUpgradeGuideDialogInternal", "aioContext", "createTroopGuildUpgradeHelper", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "createTroopSettingUpgradeRedDotProcessor", "url", "Landroid/widget/ImageView;", "imageView", "Lkotlin/Pair;", "referSize", "logTag", "loadImageByGuildPicLoader", "", CoverDBCacheData.URLS, "Ljava/lang/Runnable;", "onFinish", "preDownloadImage", "([Ljava/lang/String;Ljava/lang/Runnable;)V", "Lcom/tencent/common/app/AppInterface;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "chatPie", "restartAIOToTroopGuildIfNeeded", "showUpgradeGuideDialog", "showUpgradeGuideDialogInAIO", "shouldShowTroopUpgradeSetting", "getImageUrlsFromUIDataOf", "(Ljava/lang/String;)[Ljava/lang/String;", "", "lastTimeOfRequestServerForDialog", "timestamp", "noteLastTimeOfRequestServerForDialog", "hasDialogShownEver", "hasShown", "noteDialogHasShown", "hasTouchRedDotOfTroopUpgrade", "hasTouch", "noteHasTouchRedDotOfTroopUpgrade", "noteUserConfirmUpgrade", "didUserConfirmUpgrade", "Landroid/os/Parcelable;", "uiData", "encodeUpgradeDialogUIData", "(Ljava/lang/String;[Ljava/lang/String;)V", "T", "Ljava/lang/Class;", "clazz", "decodeUpgradeDialogUIData", "(Ljava/lang/String;Ljava/lang/Class;)Landroid/os/Parcelable;", "hasUseRecentCacheToShowDialogPassively", "noteUseRecentCacheToShowDialogPassively", "hasCacheUpgradeDialogUIData", "<init>", "()V", "Companion", "a", "troop-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class TroopUpgradeUtilsApiImpl implements ITroopUpgradeUtilsApi {

    @NotNull
    public static final String TAG = "TroopUpgradeUtilsApiImpl";
    private final /* synthetic */ ITroopGuildTempApi $$delegate_0 = (ITroopGuildTempApi) QRoute.api(ITroopGuildTempApi.class);

    private final int getStateFlag(String troopUin) {
        IQQGuildSPUtilsApi iQQGuildSPUtilsApi = (IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class);
        String uinKeyOf = iQQGuildSPUtilsApi.uinKeyOf("troop_upgrade_state_flag");
        Intrinsics.checkNotNullExpressionValue(uinKeyOf, "it.uinKeyOf(MMKVKey.STATE_FLAG)");
        return iQQGuildSPUtilsApi.decodeInt(keyOf(troopUin, uinKeyOf), 0);
    }

    private final boolean hasStateFlag(String troopUin, int flagMask) {
        if ((getStateFlag(troopUin) & flagMask) != 0) {
            return true;
        }
        return false;
    }

    private final String keyOf(String troopUin, String key) {
        return troopUin + "_" + key;
    }

    private final void setStateFlag(String troopUin, int flagMask, boolean set) {
        int i3;
        IQQGuildSPUtilsApi iQQGuildSPUtilsApi = (IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class);
        String uinKeyOf = iQQGuildSPUtilsApi.uinKeyOf("troop_upgrade_state_flag");
        Intrinsics.checkNotNullExpressionValue(uinKeyOf, "uinKeyOf(MMKVKey.STATE_FLAG)");
        String keyOf = keyOf(troopUin, uinKeyOf);
        int decodeInt = iQQGuildSPUtilsApi.decodeInt(keyOf, 0);
        if (set) {
            i3 = flagMask | decodeInt;
        } else {
            i3 = (~flagMask) & decodeInt;
        }
        iQQGuildSPUtilsApi.encodeInt(keyOf, i3);
    }

    private final void showUpgradeGuideDialogInternal(String troopUin, FragmentManager fm5, Bundle args, DialogInterface.OnClickListener clickListener, DialogInterface.OnDismissListener dismissListener, View logicParent) {
        TroopUpdateGuideDialogUIData troopUpdateGuideDialogUIData = (TroopUpdateGuideDialogUIData) decodeUpgradeDialogUIData(troopUin, TroopUpdateGuideDialogUIData.class);
        FragmentTransaction beginTransaction = fm5.beginTransaction();
        TroopUpgradeGuideDialogFragment troopUpgradeGuideDialogFragment = new TroopUpgradeGuideDialogFragment();
        troopUpgradeGuideDialogFragment.Ih(clickListener, dismissListener);
        troopUpgradeGuideDialogFragment.Jh(logicParent);
        args.putParcelable("ui_data", troopUpdateGuideDialogUIData);
        troopUpgradeGuideDialogFragment.setArguments(args);
        beginTransaction.add(troopUpgradeGuideDialogFragment, "TroopUpdateGuideDialogFragment").commitAllowingStateLoss();
    }

    @Override // com.tencent.troopguild.api.ITroopUpgradeUtilsApi
    @Nullable
    public Object createTroopGuildUpgradeHelper(@NotNull Object aioContext) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        return this.$$delegate_0.createTroopGuildUpgradeHelper(aioContext);
    }

    @Override // com.tencent.troopguild.api.ITroopUpgradeUtilsApi
    @NotNull
    public Object createTroopSettingUpgradeRedDotProcessor(@Nullable BaseQQAppInterface app, @Nullable String troopUin) {
        return this.$$delegate_0.createTroopSettingUpgradeRedDotProcessor(app, troopUin);
    }

    @Override // com.tencent.troopguild.api.ITroopUpgradeUtilsApi
    @Nullable
    public <T extends Parcelable> T decodeUpgradeDialogUIData(@NotNull String troopUin, @NotNull Class<T> clazz) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        IQQGuildSPUtilsApi iQQGuildSPUtilsApi = (IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class);
        String uinKeyOf = iQQGuildSPUtilsApi.uinKeyOf("troop_upgrade_dialog_ui_data");
        Intrinsics.checkNotNullExpressionValue(uinKeyOf, "it.uinKeyOf(\n           \u2026LOG_UI_DATA\n            )");
        return (T) iQQGuildSPUtilsApi.decodeParcelable(keyOf(troopUin, uinKeyOf), clazz, null);
    }

    @Override // com.tencent.troopguild.api.ITroopUpgradeUtilsApi
    public boolean didUserConfirmUpgrade(@NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        return hasStateFlag(troopUin, 4);
    }

    @Override // com.tencent.troopguild.api.ITroopUpgradeUtilsApi
    public void encodeUpgradeDialogUIData(@NotNull String troopUin, @Nullable Parcelable uiData) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        IQQGuildSPUtilsApi iQQGuildSPUtilsApi = (IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class);
        String uinKeyOf = iQQGuildSPUtilsApi.uinKeyOf("troop_upgrade_dialog_ui_data");
        Intrinsics.checkNotNullExpressionValue(uinKeyOf, "uinKeyOf(\n              \u2026LOG_UI_DATA\n            )");
        iQQGuildSPUtilsApi.encodeParcelable(keyOf(troopUin, uinKeyOf), uiData);
    }

    @Override // com.tencent.troopguild.api.ITroopUpgradeUtilsApi
    @Nullable
    public String[] getImageUrlsFromUIDataOf(@NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        TroopUpdateGuideDialogUIData troopUpdateGuideDialogUIData = (TroopUpdateGuideDialogUIData) decodeUpgradeDialogUIData(troopUin, TroopUpdateGuideDialogUIData.class);
        if (troopUpdateGuideDialogUIData != null) {
            return new String[]{troopUpdateGuideDialogUIData.getImageUrl(), troopUpdateGuideDialogUIData.getCom.tencent.hippy.qq.view.tkd.image.HippyTKDGifImageViewController.PROPS_GIFURL java.lang.String()};
        }
        return null;
    }

    @Override // com.tencent.troopguild.api.ITroopUpgradeUtilsApi
    public boolean hasCacheUpgradeDialogUIData(@NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        IQQGuildSPUtilsApi iQQGuildSPUtilsApi = (IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class);
        String uinKeyOf = iQQGuildSPUtilsApi.uinKeyOf("troop_upgrade_dialog_ui_data");
        Intrinsics.checkNotNullExpressionValue(uinKeyOf, "it.uinKeyOf(MMKVKey.DIALOG_UI_DATA)");
        return iQQGuildSPUtilsApi.containsKey(keyOf(troopUin, uinKeyOf));
    }

    @Override // com.tencent.troopguild.api.ITroopUpgradeUtilsApi
    public boolean hasDialogShownEver(@NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        return hasStateFlag(troopUin, 2);
    }

    @Override // com.tencent.troopguild.api.ITroopUpgradeUtilsApi
    public boolean hasTouchRedDotOfTroopUpgrade(@NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        return hasStateFlag(troopUin, 1);
    }

    @Override // com.tencent.troopguild.api.ITroopUpgradeUtilsApi
    public boolean hasUseRecentCacheToShowDialogPassively(@NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        TroopUpdateGuideDialogUIData troopUpdateGuideDialogUIData = (TroopUpdateGuideDialogUIData) decodeUpgradeDialogUIData(troopUin, TroopUpdateGuideDialogUIData.class);
        if (troopUpdateGuideDialogUIData == null || troopUpdateGuideDialogUIData.getIsUsed() == 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.troopguild.api.ITroopUpgradeUtilsApi
    public long lastTimeOfRequestServerForDialog(@NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        IQQGuildSPUtilsApi iQQGuildSPUtilsApi = (IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class);
        String uinKeyOf = iQQGuildSPUtilsApi.uinKeyOf("troop_upgrade_request_dialog_last_time");
        Intrinsics.checkNotNullExpressionValue(uinKeyOf, "it.uinKeyOf(\n           \u2026REQUEST_DIALOG_LAST_TIME)");
        return iQQGuildSPUtilsApi.decodeLong(keyOf(troopUin, uinKeyOf), 0L);
    }

    @Override // com.tencent.troopguild.api.ITroopUpgradeUtilsApi
    public void loadImageByGuildPicLoader(@NotNull String url, @NotNull ImageView imageView, @Nullable Pair<Integer, Integer> referSize, @Nullable String logTag) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        this.$$delegate_0.loadImageByGuildPicLoader(url, imageView, referSize, logTag);
    }

    @Override // com.tencent.troopguild.api.ITroopUpgradeUtilsApi
    public void noteDialogHasShown(@NotNull String troopUin, boolean hasShown) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        setStateFlag(troopUin, 2, hasShown);
    }

    @Override // com.tencent.troopguild.api.ITroopUpgradeUtilsApi
    public void noteHasTouchRedDotOfTroopUpgrade(@NotNull String troopUin, boolean hasTouch) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        setStateFlag(troopUin, 1, hasTouch);
    }

    @Override // com.tencent.troopguild.api.ITroopUpgradeUtilsApi
    public void noteLastTimeOfRequestServerForDialog(@NotNull String troopUin, long timestamp) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        IQQGuildSPUtilsApi iQQGuildSPUtilsApi = (IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class);
        String uinKeyOf = iQQGuildSPUtilsApi.uinKeyOf("troop_upgrade_request_dialog_last_time");
        Intrinsics.checkNotNullExpressionValue(uinKeyOf, "uinKeyOf(\n              \u2026G_LAST_TIME\n            )");
        iQQGuildSPUtilsApi.encodeLong(keyOf(troopUin, uinKeyOf), timestamp);
    }

    @Override // com.tencent.troopguild.api.ITroopUpgradeUtilsApi
    public void noteUseRecentCacheToShowDialogPassively(@NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        TroopUpdateGuideDialogUIData troopUpdateGuideDialogUIData = (TroopUpdateGuideDialogUIData) decodeUpgradeDialogUIData(troopUin, TroopUpdateGuideDialogUIData.class);
        if (troopUpdateGuideDialogUIData != null) {
            troopUpdateGuideDialogUIData.m(Integer.MAX_VALUE);
            encodeUpgradeDialogUIData(troopUin, troopUpdateGuideDialogUIData);
        }
    }

    @Override // com.tencent.troopguild.api.ITroopUpgradeUtilsApi
    public void noteUserConfirmUpgrade(@NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        setStateFlag(troopUin, 4, true);
    }

    @Override // com.tencent.troopguild.api.ITroopUpgradeUtilsApi
    public void preDownloadImage(@NotNull String[] urls, @NotNull Runnable onFinish) {
        Intrinsics.checkNotNullParameter(urls, "urls");
        Intrinsics.checkNotNullParameter(onFinish, "onFinish");
        this.$$delegate_0.preDownloadImage(urls, onFinish);
    }

    @Override // com.tencent.troopguild.api.ITroopUpgradeUtilsApi
    @MainThread
    public void restartAIOToTroopGuildIfNeeded(@Nullable AppInterface app, @Nullable Activity activity, @Nullable Object chatPie, @Nullable String troopUin, @NotNull String logTag) {
        Intrinsics.checkNotNullParameter(logTag, "logTag");
        this.$$delegate_0.restartAIOToTroopGuildIfNeeded(app, activity, chatPie, troopUin, logTag);
    }

    @Override // com.tencent.troopguild.api.ITroopUpgradeUtilsApi
    public boolean shouldShowTroopUpgradeSetting(@Nullable AppInterface app, @Nullable String troopUin) {
        if (app == null || troopUin == null) {
            return false;
        }
        if (!hasDialogShownEver(troopUin)) {
            QLog.d(TAG, 1, "shouldShowTroopUpgradeSetting | dialog has ever showed");
            return false;
        }
        TroopInfo findTroopInfo = ((ITroopInfoService) app.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(troopUin);
        if (findTroopInfo == null) {
            return false;
        }
        if (!findTroopInfo.isOwnerOrAdmin(app.getCurrentAccountUin())) {
            QLog.d(TAG, 1, "shouldShowTroopUpgradeSetting | isn't owner or admin");
            return false;
        }
        if (!findTroopInfo.isTroopGuild()) {
            return true;
        }
        QLog.d(TAG, 1, "shouldShowTroopUpgradeSetting | already is troop guild");
        return false;
    }

    @Override // com.tencent.troopguild.api.ITroopUpgradeUtilsApi
    public void showUpgradeGuideDialog(@NotNull String troopUin, @NotNull FragmentManager fm5, @Nullable DialogInterface.OnClickListener clickListener, @Nullable DialogInterface.OnDismissListener dismissListener, @Nullable View logicParent) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(fm5, "fm");
        showUpgradeGuideDialogInternal(troopUin, fm5, new Bundle(), clickListener, dismissListener, logicParent);
    }

    @Override // com.tencent.troopguild.api.ITroopUpgradeUtilsApi
    public void showUpgradeGuideDialogInAIO(@NotNull String troopUin, @NotNull FragmentManager fm5, @Nullable DialogInterface.OnClickListener clickListener, @Nullable DialogInterface.OnDismissListener dismissListener, @Nullable View logicParent) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(fm5, "fm");
        Bundle bundle = new Bundle();
        bundle.putBoolean("open_from_aio", true);
        Unit unit = Unit.INSTANCE;
        showUpgradeGuideDialogInternal(troopUin, fm5, bundle, clickListener, dismissListener, logicParent);
    }

    @Override // com.tencent.troopguild.api.ITroopUpgradeUtilsApi
    public void restartAIOToTroopGuildIfNeeded(@Nullable AppInterface app, @Nullable Activity activity, @Nullable String troopUin, @NotNull String logTag) {
        Intrinsics.checkNotNullParameter(logTag, "logTag");
        this.$$delegate_0.restartAIOToTroopGuildIfNeeded(app, activity, troopUin, logTag);
    }

    @Override // com.tencent.troopguild.api.ITroopUpgradeUtilsApi
    public void encodeUpgradeDialogUIData(@NotNull String troopUin, @NotNull String[] uiData) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(uiData, "uiData");
        TroopUpdateGuideDialogUIData troopUpdateGuideDialogUIData = new TroopUpdateGuideDialogUIData();
        troopUpdateGuideDialogUIData.l(uiData[0]);
        troopUpdateGuideDialogUIData.k(uiData[1]);
        troopUpdateGuideDialogUIData.j(uiData[2]);
        troopUpdateGuideDialogUIData.f(uiData[3]);
        troopUpdateGuideDialogUIData.g(uiData[4]);
        Unit unit = Unit.INSTANCE;
        encodeUpgradeDialogUIData(troopUin, troopUpdateGuideDialogUIData);
    }
}
