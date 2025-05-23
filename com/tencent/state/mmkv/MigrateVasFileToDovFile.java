package com.tencent.state.mmkv;

import android.app.Application;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.state.mmkv.SKey;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.mmkv.SMMKV;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ,\u0010\u000b\u001a\u00020\n2\u0010\u0010\f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u00042\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\nH\u0002J\b\u0010\u0012\u001a\u00020\nH\u0002R\u0018\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/mmkv/MigrateVasFileToDovFile;", "", "()V", "itemInVasFile", "", "Lcom/tencent/state/mmkv/MigrateItem;", "itemInVasFileWithUin", "resultCount", "Lcom/tencent/state/mmkv/MigrateResultCount;", "migrate", "", "migrateKeys", "list", "from", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "to", "Lcom/tencent/state/square/mmkv/SMMKV;", "migrateVasFile", "migrateVasFileWithUin", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
final class MigrateVasFileToDovFile {
    private final List<MigrateItem<?>> itemInVasFile;
    private final List<MigrateItem<?>> itemInVasFileWithUin;
    private final MigrateResultCount resultCount = new MigrateResultCount();

    private final void migrateKeys(List<? extends MigrateItem<?>> list, MMKVOptionEntity from, SMMKV to5) {
        int migrateValue;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            MigrateItem migrateItem = (MigrateItem) it.next();
            migrateValue = MMKVMigrate.INSTANCE.migrateValue(from, to5, migrateItem.getSourceKey(), migrateItem.getTargetKey(), migrateItem.getDefaultValue(), (r20 & 32) != 0 ? "" : migrateItem.getPostFix(), (r20 & 64) != 0 ? false : migrateItem.getIgnoreFillUin(), (r20 & 128) != 0);
            if (migrateValue == -4) {
                MigrateResultCount migrateResultCount = this.resultCount;
                migrateResultCount.setErrorCount(migrateResultCount.getErrorCount() + 1);
            } else if (migrateValue == -3) {
                MigrateResultCount migrateResultCount2 = this.resultCount;
                migrateResultCount2.setTargetExistCount(migrateResultCount2.getTargetExistCount() + 1);
            } else if (migrateValue == -2) {
                MigrateResultCount migrateResultCount3 = this.resultCount;
                migrateResultCount3.setUnSupportTypeCount(migrateResultCount3.getUnSupportTypeCount() + 1);
            } else if (migrateValue != -1) {
                MigrateResultCount migrateResultCount4 = this.resultCount;
                migrateResultCount4.setSuccessItemCount(migrateResultCount4.getSuccessItemCount() + 1);
            } else {
                MigrateResultCount migrateResultCount5 = this.resultCount;
                migrateResultCount5.setSourceNotExistCount(migrateResultCount5.getSourceNotExistCount() + 1);
            }
            MigrateResultCount migrateResultCount6 = this.resultCount;
            migrateResultCount6.setTotalItemCount(migrateResultCount6.getTotalItemCount() + 1);
            if (SquareBaseKt.getSquareLog().isColorLevel()) {
                SquareBaseKt.getSquareLog().d(MMKVMigrate.TAG, "migrateValue, key:" + migrateItem.getSourceKey() + ", result:" + migrateValue);
            }
        }
    }

    private final void migrateVasFile() {
        MMKVOptionEntity from;
        Application app = SquareBase.INSTANCE.getApp();
        if (app == null || (from = QMMKV.from(app, "vas_mmkv_configurations")) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(from, "QMMKV.from(app, VasFilePrefix.FILE_VAS) ?: return");
        migrateKeys$default(this, this.itemInVasFile, from, null, 4, null);
    }

    private final void migrateVasFileWithUin() {
        MMKVOptionEntity from;
        Application app = SquareBase.INSTANCE.getApp();
        if (app == null || (from = QMMKV.from(app, VasFilePrefix.INSTANCE.fileWithUin())) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(from, "QMMKV.from(app, VasFileP\u2026.fileWithUin()) ?: return");
        migrateKeys$default(this, this.itemInVasFileWithUin, from, null, 4, null);
    }

    public final void migrate() {
        migrateVasFileWithUin();
        migrateVasFile();
        SquareBaseKt.getSquareLog().i(MMKVMigrate.TAG, "migrate, result=" + this.resultCount);
    }

    public MigrateVasFileToDovFile() {
        List<MigrateItem<?>> listOf;
        List<MigrateItem<?>> listOf2;
        Boolean bool = Boolean.FALSE;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new MigrateItem[]{new MigrateItem(SKey.Guide.HAS_CHECKED_CREATE_ROLE_GUIDE, null, bool, null, false, 26, null), new MigrateItem(SKey.Guide.SHOW_CREATE_ROLE_GUIDE_COUNT, null, 0L, null, false, 26, null), new MigrateItem(SKey.Guide.SHOW_PUBLISH_STATUS_GUIDE_COUNT, null, 0L, null, false, 26, null), new MigrateItem(SKey.DetailMe.HAS_CLICK_PUBLISH_BTN, null, bool, null, false, 26, null), new MigrateItem(SKey.DetailMe.HAS_CLICK_DETAIL_ME_DRESS_GUIDE, null, bool, null, false, 26, null), new MigrateItem(SKey.DetailMe.HAS_SHOW_DETAIL_ME_DRESS_RED_DOT, null, bool, null, false, 26, null)});
        this.itemInVasFileWithUin = listOf;
        Boolean bool2 = Boolean.TRUE;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new MigrateItem[]{new MigrateItem(SKey.Library.HAS_SHOW_LIBRARY_WELCOME_TIPS, null, bool, null, false, 26, null), new MigrateItem(SKey.Library.HAS_SHOW_SINGLE_START_FOCUS_TIPS, null, bool, null, false, 26, null), new MigrateItem(SKey.Library.HAS_SHOW_GROUP_START_FOCUS_TIPS, null, bool, null, false, 26, null), new MigrateItem(SKey.Library.HAS_SHOW_SHARE_GROUP_TIPS, null, bool, null, false, 26, null), new MigrateItem(SKey.Library.HAS_SHOW_LIBRARY_CALLBACK_TIPS, null, bool, null, false, 26, null), new MigrateItem(SKey.Library.HAS_SHOW_LIBRARY_CALENDAR_TIPS, null, bool, null, false, 26, null), new MigrateItem(SKey.Library.CAN_SHOW_LIBRARY_SWITCH_TABLE_TIPS, null, bool2, null, false, 26, null), new MigrateItem("key_stranger_dialog_show_time_" + SquareBaseKt.getSquareCommon().getCurrentAccountUin(), SKey.Library.KEY_STRANGER_DIALOG_SHOW_TIME, 0L, null, false, 24, null), new MigrateItem("key_stranger_invisible_" + SquareBaseKt.getSquareCommon().getCurrentAccountUin(), SKey.Privacy.KEY_STRANGER_INVISIBLE, -1, null, false, 24, null), new MigrateItem(SKey.Privacy.QZONE_PRIVACY_DIALOG_SHOW_TIME, null, 0L, null, false, 26, null), new MigrateItem("interaction_guide_time_" + SquareBaseKt.getSquareCommon().getCurrentAccountUin(), SKey.Interaction.INTERACTION_GUIDE_TIME, 0L, null, false, 24, null), new MigrateItem("key_had_show_friend_pick_tips_" + SquareBaseKt.getSquareCommon().getCurrentAccountUin(), SKey.FriendPick.KEY_HAD_SHOW_FRIEND_PICK_TIPS, bool, null, false, 24, null), new MigrateItem(SKey.Temple.HAS_SHOW_TEMPLE_WELCOME_TIPS, null, bool, null, false, 26, null), new MigrateItem(SKey.Temple.HAS_SHOW_START_PRAY_TIPS_DIALOG, null, bool, null, false, 26, null), new MigrateItem(SKey.Temple.DISABLE_SWITCH_SEAT_CONFIRM, null, bool, null, false, 26, null), new MigrateItem(SKey.DetailMe.KEY_PUBLISH_WITHOUT_TIP, null, bool, null, false, 26, null), new MigrateItem(SKey.DetailMe.VAS_SOCIAL_STATUS_DRAFT_SP_KEY + SquareBaseKt.getSquareCommon().getCurrentAccountUin(), SKey.DetailMe.VAS_SOCIAL_STATUS_DRAFT_SP_KEY, "", null, false, 24, null), new MigrateItem(SKey.DetailMe.DIALOG_KEY_MUSIC_STATUS, null, bool, null, false, 26, null), new MigrateItem(SKey.DetailMe.KEY_SHOW_BATTERY_STATUS_DIALOG, null, bool, null, false, 26, null), new MigrateItem(SKey.Calendar.KEY_CALENDAR_RED_DOT_HAS_SHOWN, null, bool, null, false, 26, null), new MigrateItem(SKey.Calendar.HAS_SHOW_LIBRARY_CALENDAR_GUIDE, null, bool, null, false, 26, null), new MigrateItem(SKey.Calendar.ENABLE_SHOW_LIBRARY_CALENDAR_GUIDE, null, bool, null, false, 26, null), new MigrateItem(SKey.Calendar.HAS_SHOW_LIBRARY_CALENDAR, null, bool, null, false, 26, null), new MigrateItem("vas_library_calendar_guide_key_prefix_\u592a\u68d2\u5566\uff01\u4eca\u65e5\u4efb\u52a1\u5df2\u5b8c\u6210", null, 0L, null, false, 26, null), new MigrateItem("vas_library_calendar_guide_key_prefix_\u5b8c\u621010\u5206\u949f\u4e13\u6ce8\u540e\u5373\u53ef\u9886\u53d6\u5956\u52b1", null, 0L, null, false, 26, null), new MigrateItem("vas_library_calendar_guide_key_prefix_\u9a6c\u4e0a\u843d\u5ea7\uff0c\u8ba9\u5927\u5bb6\u56f4\u89c2\u4f60\u7684\u9ad8\u7ea7\u5b66\u9738\u52a8\u4f5c", null, 0L, null, false, 26, null), new MigrateItem("vas_library_calendar_guide_key_prefix_\u5feb\u6765\u9886\u53d6\u6d3b\u52a8\u9650\u5b9a\u52a8\u4f5c", null, 0L, null, false, 26, null), new MigrateItem("vas_library_calendar_guide_key_prefix_\u9001\u4f60\u590d\u539f\u5361\uff0c\u53ea\u9650\u4eca\u65e5", null, 0L, null, false, 26, null), new MigrateItem("vas_library_calendar_guide_key_prefix_\u5b8c\u6210\u4efb\u52a1\uff0c\u7acb\u5373\u9886\u5956\u52b1", null, 0L, null, false, 26, null), new MigrateItem("vas_library_calendar_guide_key_prefix_\u8fd8\u5dee\u4e00\u70b9\u5b8c\u6210\u4eca\u65e5\u4efb\u52a1", null, 0L, null, false, 26, null), new MigrateItem(SKey.SettingTips.CLOSE_TO_ME_KEY, null, bool, null, false, 26, null), new MigrateItem(SquareBaseKt.getSquareCommon().getCurrentAccountUin() + "_isCloseToMeTroop", SKey.SettingTips.TROOP_CLOSE_TO_ME_KEY, bool, null, false, 24, null), new MigrateItem(SKey.SettingTips.FIXED_KEY, null, bool, null, false, 26, null), new MigrateItem(SquareBaseKt.getSquareCommon().getCurrentAccountUin() + "_isHideTroop", SKey.SettingTips.TROOP_HIDE_KEY, bool, null, false, 24, null), new MigrateItem(SquareBaseKt.getSquareCommon().getCurrentAccountUin() + "_hasAddTroop", SKey.SettingTips.KEY_HAS_ADD_TROOP, bool, null, false, 24, null), new MigrateItem(SquareBaseKt.getSquareCommon().getCurrentAccountUin() + "_firstGoToSquare", SKey.SettingTips.IS_FIRST_GOTO_SQUARE_KEY, bool2, null, false, 24, null), new MigrateItem(SquareBaseKt.getSquareCommon().getCurrentAccountUin() + "_showTroopDialog", SKey.SettingTips.KEY_SHOW_ADD_TROOP_DIALOG_COUNT, 0, null, false, 24, null), new MigrateItem(SquareBaseKt.getSquareCommon().getCurrentAccountUin() + "_lastTroopShowTime", SKey.SettingTips.KEY_LAST_SHOW_ADD_TROOP_DIALOG_TIME, 0L, null, false, 24, null), new MigrateItem(SKey.Location.LOCATION_GUIDE_FLAG, null, bool2, null, false, 26, null), new MigrateItem("vas_pray_keep_scene_time_tips_dialog_0", null, bool, null, false, 26, null), new MigrateItem("vas_pray_keep_scene_time_tips_dialog_1", null, bool, null, false, 26, null), new MigrateItem("vas_pray_keep_scene_time_tips_dialog_2", null, bool, null, false, 26, null), new MigrateItem("vas_pray_keep_scene_time_tips_dialog_3", null, bool, null, false, 26, null), new MigrateItem("vas_pray_keep_scene_time_tips_dialog_4", null, bool, null, false, 26, null), new MigrateItem("vas_pray_keep_scene_time_tips_dialog_999", null, bool, null, false, 26, null)});
        this.itemInVasFile = listOf2;
    }

    static /* synthetic */ void migrateKeys$default(MigrateVasFileToDovFile migrateVasFileToDovFile, List list, MMKVOptionEntity mMKVOptionEntity, SMMKV smmkv, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            smmkv = SquareBaseKt.getSquareMMKV();
        }
        migrateVasFileToDovFile.migrateKeys(list, mMKVOptionEntity, smmkv);
    }
}
