package com.tencent.mobileqq.vas;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/vas/VipMMKV;", "", "()V", "Companion", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VipMMKV {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\b\u0010\b\u001a\u00020\u0004H\u0007J\b\u0010\t\u001a\u00020\u0004H\u0007J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u001c\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J3\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014H\u0002\u00a2\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0004H\u0007J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\b\u0010\u0018\u001a\u00020\u0004H\u0007J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\b\u0010\u001b\u001a\u00020\u0004H\u0007J\u0018\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0006H\u0007J\b\u0010\u001e\u001a\u00020\u0004H\u0007J\u0018\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0006H\u0007J\b\u0010 \u001a\u00020\u0004H\u0007J\b\u0010!\u001a\u00020\u0004H\u0007J\u001a\u0010\"\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\b\u0010#\u001a\u00020\u0004H\u0007J\u0010\u0010$\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010%\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u000e\u0010&\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/vas/VipMMKV$Companion;", "", "()V", "getCommon", "Lcom/tencent/mobileqq/vas/VasMMKVProxy;", "uin", "", "getConfigBackup", "getEnterEffectConfig", "getLiangNamePlate", "getLoveZone", "getMMKV", "id", "getMigratedSP", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "originSpName", "getMigratedSPFromCommon", "originKeys", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/content/SharedPreferences;", "getPendant", "getPraise", "getPreloadCenter", "getQQValue", "getQzoneVipData", "getReportControl", "getSVipQQSettingMe", "originName", "getSafeUnzip", "getTheme", "getTianShuExpose", "getTofuColor", "getTroopVipIcon", "getVipDataNeedRequest", "getVipGray", "getVipTittle", "getWebSo", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final VasMMKVProxy getMMKV(String id5, String uin) {
            boolean z16;
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQVIP);
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQVIP)");
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

        private final SharedPreferences getMigratedSP(Context context, String originSpName) {
            SharedPreferences newSp = QMMKV.fromSpAdapter(MobileQQ.sMobileQQ, originSpName, QMMKVFile.FILE_QQVIP);
            if (!newSp.getBoolean("_migrate_flag_", false)) {
                QMMKV.migrateToSpAdapter(context, originSpName, QMMKVFile.FILE_QQVIP);
                newSp.edit().putBoolean("_migrate_flag_", true).apply();
            }
            Intrinsics.checkNotNullExpressionValue(newSp, "newSp");
            return newSp;
        }

        private final SharedPreferences getMigratedSPFromCommon(Context context, String id5, String uin, String[] originKeys) {
            boolean contains;
            Object value;
            SharedPreferences newSp = QMMKV.fromSpAdapter(MobileQQ.sMobileQQ, id5 + "_" + uin, QMMKVFile.FILE_QQVIP);
            if (!newSp.getBoolean("_migrate_flag_", false)) {
                SharedPreferences.Editor edit = newSp.edit();
                for (Map.Entry<String, ?> entry : context.getSharedPreferences(uin, 0).getAll().entrySet()) {
                    String key = entry.getKey();
                    contains = ArraysKt___ArraysKt.contains(originKeys, key);
                    if (contains && (value = entry.getValue()) != null) {
                        if (value instanceof Boolean) {
                            edit.putBoolean(key, ((Boolean) value).booleanValue());
                        } else if (value instanceof Integer) {
                            edit.putInt(key, ((Number) value).intValue());
                        } else if (value instanceof Long) {
                            edit.putLong(key, ((Number) value).longValue());
                        } else if (value instanceof Float) {
                            edit.putFloat(key, ((Number) value).floatValue());
                        } else if (value instanceof String) {
                            edit.putString(key, (String) value);
                        }
                    }
                }
                edit.putBoolean("_migrate_flag_", true).apply();
            }
            Intrinsics.checkNotNullExpressionValue(newSp, "newSp");
            return newSp;
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getCommon() {
            return getMMKV$default(this, "common", null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getConfigBackup() {
            return getMMKV$default(this, "config_backup", null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getEnterEffectConfig() {
            return getMMKV$default(this, "req_troop_effect_config", null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getLiangNamePlate() {
            return getMMKV$default(this, "vas_liang_nameplate", null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getLoveZone(@Nullable String uin) {
            return getMMKV("love_zone", uin);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getPendant() {
            return getMMKV$default(this, IndividuationUrlHelper.UrlId.PENDANT_HOME, null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final SharedPreferences getPraise(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return getMigratedSP(context, "VipPersonalLike");
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getPreloadCenter() {
            return getMMKV$default(this, "vas_preload_res", null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final SharedPreferences getQQValue(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return getMigratedSP(context, "sp_vip_qqvalue_info");
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getQzoneVipData(@Nullable String uin) {
            return getMMKV("qzone_vip_data", uin);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getReportControl() {
            return getMMKV$default(this, "vas_report", null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final SharedPreferences getSVipQQSettingMe(@NotNull Context context, @NotNull String originName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(originName, "originName");
            return getMigratedSP(context, originName);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getSafeUnzip() {
            return getMMKV$default(this, "safe_unzip", null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final SharedPreferences getTheme(@NotNull Context context, @NotNull String originName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(originName, "originName");
            return getMigratedSP(context, originName);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getTianShuExpose() {
            return getMMKV$default(this, "qzone_tianshu_widget_expose", null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getTofuColor() {
            return getMMKV$default(this, "tofu_color", null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final SharedPreferences getTroopVipIcon(@NotNull Context context, @Nullable String uin) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (uin == null) {
                uin = "";
            }
            return getMigratedSPFromCommon(context, "troop_vip_icon", uin, new String[]{"show_troop_big_club"});
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getVipDataNeedRequest() {
            return getMMKV$default(this, "vipdata_need_request", null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final SharedPreferences getVipGray(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return getMigratedSP(context, "vipGrayConfigSp");
        }

        @JvmStatic
        @NotNull
        public final SharedPreferences getVipTittle(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return getMigratedSP(context, "vipTitleSpFile");
        }

        @NotNull
        public final SharedPreferences getWebSo(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return getMigratedSP(context, "wns_html_etags");
        }

        Companion() {
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getCommon(@Nullable String uin) {
            return getMMKV("common", uin);
        }
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getCommon() {
        return INSTANCE.getCommon();
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getConfigBackup() {
        return INSTANCE.getConfigBackup();
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getEnterEffectConfig() {
        return INSTANCE.getEnterEffectConfig();
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getLiangNamePlate() {
        return INSTANCE.getLiangNamePlate();
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getLoveZone(@Nullable String str) {
        return INSTANCE.getLoveZone(str);
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getPendant() {
        return INSTANCE.getPendant();
    }

    @JvmStatic
    @NotNull
    public static final SharedPreferences getPraise(@NotNull Context context) {
        return INSTANCE.getPraise(context);
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getPreloadCenter() {
        return INSTANCE.getPreloadCenter();
    }

    @JvmStatic
    @NotNull
    public static final SharedPreferences getQQValue(@NotNull Context context) {
        return INSTANCE.getQQValue(context);
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getQzoneVipData(@Nullable String str) {
        return INSTANCE.getQzoneVipData(str);
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getReportControl() {
        return INSTANCE.getReportControl();
    }

    @JvmStatic
    @NotNull
    public static final SharedPreferences getSVipQQSettingMe(@NotNull Context context, @NotNull String str) {
        return INSTANCE.getSVipQQSettingMe(context, str);
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getSafeUnzip() {
        return INSTANCE.getSafeUnzip();
    }

    @JvmStatic
    @NotNull
    public static final SharedPreferences getTheme(@NotNull Context context, @NotNull String str) {
        return INSTANCE.getTheme(context, str);
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getTianShuExpose() {
        return INSTANCE.getTianShuExpose();
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getTofuColor() {
        return INSTANCE.getTofuColor();
    }

    @JvmStatic
    @NotNull
    public static final SharedPreferences getTroopVipIcon(@NotNull Context context, @Nullable String str) {
        return INSTANCE.getTroopVipIcon(context, str);
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getVipDataNeedRequest() {
        return INSTANCE.getVipDataNeedRequest();
    }

    @JvmStatic
    @NotNull
    public static final SharedPreferences getVipGray(@NotNull Context context) {
        return INSTANCE.getVipGray(context);
    }

    @JvmStatic
    @NotNull
    public static final SharedPreferences getVipTittle(@NotNull Context context) {
        return INSTANCE.getVipTittle(context);
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getCommon(@Nullable String str) {
        return INSTANCE.getCommon(str);
    }
}
