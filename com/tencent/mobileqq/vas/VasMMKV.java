package com.tencent.mobileqq.vas;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/vas/VasMMKV;", "", "()V", "Companion", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasMMKV {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String MIGRATE_FLAG = "_migrate_flag_";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010\t\u001a\u00020\u0006H\u0007J\b\u0010\n\u001a\u00020\u0006H\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J\b\u0010\u0010\u001a\u00020\u0006H\u0007J\u0012\u0010\u0010\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010\u0011\u001a\u00020\u0006H\u0007J\b\u0010\u0012\u001a\u00020\u0006H\u0007J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0018\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J\u0012\u0010\u0017\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010\u0018\u001a\u00020\u0006H\u0007J\u0012\u0010\u0019\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007J\u0018\u0010\u001a\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J\u001c\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\u001d\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J\u0018\u0010\u001e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u0004H\u0002J \u0010\u001e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0004H\u0002J\u001a\u0010!\u001a\n \"*\u0004\u0018\u00010\f0\f2\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010#\u001a\u00020\u0006H\u0007J\u0018\u0010$\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J\b\u0010%\u001a\u00020\u0006H\u0007J\u0018\u0010&\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J\u0012\u0010'\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010(\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010)\u001a\u00020\u0006H\u0007J\b\u0010*\u001a\u00020\u0006H\u0007J\b\u0010+\u001a\u00020\u0006H\u0007J\b\u0010,\u001a\u00020\u0006H\u0007J\u0018\u0010-\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u0004H\u0007J\u0012\u0010/\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/vas/VasMMKV$Companion;", "", "()V", "MIGRATE_FLAG", "", "getAIOLeftRedTime", "Lcom/tencent/mobileqq/vas/VasMMKVProxy;", "getAccountInfo", "uin", "getAppIcon", "getBubbleTextColorInfo", "getChatBg", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "originName", "getCommon", "getFileDir", "getFontReport", "getFontSo", "getFunCall", "getGiftAIOAnim", "getGiftPanel", "getGiftPanelCountDown", "getIpcData", "getKingCard", "getListenTogether", "getMMKV", "id", "getMagicFont", "getMigratedSP", "originSpName", "newSpName", "getOldVipGift", "kotlin.jvm.PlatformType", "getPagView", "getQuickUpdateDb", "getQuickUpdateSystem", "getTianShu", "getTroopBirthGift", "getTroopGift", "getVipData", "getVipDataPb", "getVipDataRandomKey", "getVipDataTimeStamp", "getVipInfo", "spKey", "getVipNamePlate", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final VasMMKVProxy getMMKV(String id5, String uin) {
            boolean z16;
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_VAS)");
            if (uin != null && uin.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                id5 = id5 + "_" + uin;
            }
            return new VasMMKVProxy(from, id5);
        }

        static /* synthetic */ VasMMKVProxy getMMKV$default(Companion companion, String str, String str2, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                str2 = "";
            }
            return companion.getMMKV(str, str2);
        }

        private final SharedPreferences getMigratedSP(Context context, String originSpName, String newSpName) {
            SharedPreferences newSp = QMMKV.fromSpAdapter(MobileQQ.sMobileQQ, newSpName, "vas_mmkv_configurations");
            if (!newSp.getBoolean("_migrate_flag_", false)) {
                QMMKV.migrateToSpAdapter(context, originSpName, "vas_mmkv_configurations");
                newSp.edit().putBoolean("_migrate_flag_", true).apply();
            }
            Intrinsics.checkNotNullExpressionValue(newSp, "newSp");
            return newSp;
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getAIOLeftRedTime() {
            return getMMKV$default(this, "vas_aio_left_red_time", null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getAccountInfo(@Nullable String uin) {
            return getMMKV("account_info", uin);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getAppIcon() {
            return getMMKV$default(this, MiniConst.WxMiniAppInfoConst.EXTRA_ICON, null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getBubbleTextColorInfo() {
            return getMMKV$default(this, "bubble_text_color_info", null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final SharedPreferences getChatBg(@NotNull Context context, @NotNull String originName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(originName, "originName");
            return getMigratedSP(context, originName);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getCommon() {
            return getMMKV$default(this, "common", null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getFileDir() {
            return getMMKV$default(this, "new_vas_file_dir", null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getFontReport() {
            return getMMKV$default(this, "font_report", null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final SharedPreferences getFontSo(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return getMigratedSP(context, "early_qq.android.native.vipfont.v5");
        }

        @JvmStatic
        @NotNull
        public final SharedPreferences getFunCall(@NotNull Context context, @NotNull String originName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(originName, "originName");
            return getMigratedSP(context, originName, "fun_call_" + originName);
        }

        @JvmStatic
        @NotNull
        public final SharedPreferences getGiftAIOAnim(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return getMigratedSP(context, "AIOAnimationControlManager_limit_key");
        }

        @JvmStatic
        @NotNull
        public final SharedPreferences getGiftPanel(@NotNull Context context, @NotNull String originName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(originName, "originName");
            return getMigratedSP(context, originName, "gift_panel_" + originName);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getGiftPanelCountDown(@Nullable String uin) {
            return getMMKV("gift_panel_count_down", uin);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getIpcData() {
            return getMMKV$default(this, "ipc_data", null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getKingCard(@Nullable String uin) {
            return getMMKV("kingcard", uin);
        }

        @JvmStatic
        @NotNull
        public final SharedPreferences getListenTogether(@NotNull Context context, @NotNull String originName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(originName, "originName");
            return getMigratedSP(context, originName, "listen_together_" + originName);
        }

        @JvmStatic
        @NotNull
        public final SharedPreferences getMagicFont(@NotNull Context context, @NotNull String originName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(originName, "originName");
            return getMigratedSP(context, originName, "magic_font_" + originName);
        }

        @JvmStatic
        public final SharedPreferences getOldVipGift(@Nullable String uin) {
            return QMMKV.fromSpAdapter(MobileQQ.sMobileQQ, "old_vip_gift_" + uin, "vas_mmkv_configurations");
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getPagView() {
            return getMMKV$default(this, "pagview", null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final SharedPreferences getQuickUpdateDb(@NotNull Context context, @NotNull String originName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(originName, "originName");
            return getMigratedSP(context, originName, "update_" + originName);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getQuickUpdateSystem() {
            return getMMKV$default(this, "quick_update_system", null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final SharedPreferences getTianShu(@NotNull Context context, @NotNull String originName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(originName, "originName");
            return getMigratedSP(context, originName, "tian_shu_" + originName);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getTroopBirthGift(@Nullable String uin) {
            return getMMKV("troop_birth_gift", uin);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getTroopGift(@Nullable String uin) {
            return getMMKV("troopGift", uin);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getVipData() {
            return getMMKV$default(this, "vipdata", null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getVipDataPb() {
            return getMMKV$default(this, "vipdata_pb", null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getVipDataRandomKey() {
            return getMMKV$default(this, "vipdata_key", null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getVipDataTimeStamp() {
            return getMMKV$default(this, "vipdata_ts", null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final SharedPreferences getVipInfo(@NotNull Context context, @NotNull String spKey) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(spKey, "spKey");
            return getMigratedSP(context, spKey);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getVipNamePlate(@Nullable String uin) {
            return getMMKV("vip_name_plate", uin);
        }

        Companion() {
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getCommon(@Nullable String uin) {
            return getMMKV("common", uin);
        }

        private final SharedPreferences getMigratedSP(Context context, String originSpName) {
            SharedPreferences newSp = QMMKV.fromSpAdapter(MobileQQ.sMobileQQ, originSpName, "vas_mmkv_configurations");
            if (!newSp.getBoolean("_migrate_flag_", false)) {
                QMMKV.migrateToSpAdapter(context, originSpName, "vas_mmkv_configurations");
                newSp.edit().putBoolean("_migrate_flag_", true).apply();
            }
            Intrinsics.checkNotNullExpressionValue(newSp, "newSp");
            return newSp;
        }
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getAIOLeftRedTime() {
        return INSTANCE.getAIOLeftRedTime();
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getAccountInfo(@Nullable String str) {
        return INSTANCE.getAccountInfo(str);
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getAppIcon() {
        return INSTANCE.getAppIcon();
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getBubbleTextColorInfo() {
        return INSTANCE.getBubbleTextColorInfo();
    }

    @JvmStatic
    @NotNull
    public static final SharedPreferences getChatBg(@NotNull Context context, @NotNull String str) {
        return INSTANCE.getChatBg(context, str);
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getCommon() {
        return INSTANCE.getCommon();
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getFileDir() {
        return INSTANCE.getFileDir();
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getFontReport() {
        return INSTANCE.getFontReport();
    }

    @JvmStatic
    @NotNull
    public static final SharedPreferences getFontSo(@NotNull Context context) {
        return INSTANCE.getFontSo(context);
    }

    @JvmStatic
    @NotNull
    public static final SharedPreferences getFunCall(@NotNull Context context, @NotNull String str) {
        return INSTANCE.getFunCall(context, str);
    }

    @JvmStatic
    @NotNull
    public static final SharedPreferences getGiftAIOAnim(@NotNull Context context) {
        return INSTANCE.getGiftAIOAnim(context);
    }

    @JvmStatic
    @NotNull
    public static final SharedPreferences getGiftPanel(@NotNull Context context, @NotNull String str) {
        return INSTANCE.getGiftPanel(context, str);
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getGiftPanelCountDown(@Nullable String str) {
        return INSTANCE.getGiftPanelCountDown(str);
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getIpcData() {
        return INSTANCE.getIpcData();
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getKingCard(@Nullable String str) {
        return INSTANCE.getKingCard(str);
    }

    @JvmStatic
    @NotNull
    public static final SharedPreferences getListenTogether(@NotNull Context context, @NotNull String str) {
        return INSTANCE.getListenTogether(context, str);
    }

    @JvmStatic
    @NotNull
    public static final SharedPreferences getMagicFont(@NotNull Context context, @NotNull String str) {
        return INSTANCE.getMagicFont(context, str);
    }

    @JvmStatic
    public static final SharedPreferences getOldVipGift(@Nullable String str) {
        return INSTANCE.getOldVipGift(str);
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getPagView() {
        return INSTANCE.getPagView();
    }

    @JvmStatic
    @NotNull
    public static final SharedPreferences getQuickUpdateDb(@NotNull Context context, @NotNull String str) {
        return INSTANCE.getQuickUpdateDb(context, str);
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getQuickUpdateSystem() {
        return INSTANCE.getQuickUpdateSystem();
    }

    @JvmStatic
    @NotNull
    public static final SharedPreferences getTianShu(@NotNull Context context, @NotNull String str) {
        return INSTANCE.getTianShu(context, str);
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getTroopBirthGift(@Nullable String str) {
        return INSTANCE.getTroopBirthGift(str);
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getTroopGift(@Nullable String str) {
        return INSTANCE.getTroopGift(str);
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getVipData() {
        return INSTANCE.getVipData();
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getVipDataPb() {
        return INSTANCE.getVipDataPb();
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getVipDataRandomKey() {
        return INSTANCE.getVipDataRandomKey();
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getVipDataTimeStamp() {
        return INSTANCE.getVipDataTimeStamp();
    }

    @JvmStatic
    @NotNull
    public static final SharedPreferences getVipInfo(@NotNull Context context, @NotNull String str) {
        return INSTANCE.getVipInfo(context, str);
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getVipNamePlate(@Nullable String str) {
        return INSTANCE.getVipNamePlate(str);
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getCommon(@Nullable String str) {
        return INSTANCE.getCommon(str);
    }
}
