package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/vas/VipNtMMKV;", "", "()V", "Companion", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VipNtMMKV {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0014\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\b\u0010\b\u001a\u00020\u0004H\u0007J\b\u0010\t\u001a\u00020\u0004H\u0007J\b\u0010\n\u001a\u00020\u0004H\u0007J\u001c\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00072\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0007J\b\u0010\u000e\u001a\u00020\u0004H\u0007J\b\u0010\u000f\u001a\u00020\u0004H\u0007J\b\u0010\u0010\u001a\u00020\u0004H\u0007J\b\u0010\u0011\u001a\u00020\u0004H\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/vas/VipNtMMKV$Companion;", "", "()V", "getBubbleTextColorInfo", "Lcom/tencent/mobileqq/vas/VasMMKVProxy;", "getCommon", "uin", "", "getConfigBackup", "getDiyBubbleConfig", "getFeature", "getMMKVProxy", "id", "getReportControl", "getSafeUnzip", "getShowColorName", "getTroopVipEffect", "getVipDataNeedRequest", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ VasMMKVProxy getCommon$default(Companion companion, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = "";
            }
            return companion.getCommon(str);
        }

        private final VasMMKVProxy getMMKVProxy(String id5, String uin) {
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

        static /* synthetic */ VasMMKVProxy getMMKVProxy$default(Companion companion, String str, String str2, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                str2 = "";
            }
            return companion.getMMKVProxy(str, str2);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getBubbleTextColorInfo() {
            return getMMKVProxy$default(this, "bubble_text_color_info", null, 2, null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final VasMMKVProxy getCommon() {
            return getCommon$default(this, null, 1, null);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getConfigBackup() {
            return getMMKVProxy$default(this, "config_backup", null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getDiyBubbleConfig() {
            return getMMKVProxy$default(this, "config_diy_bubble", null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getFeature() {
            return getMMKVProxy$default(this, "vas_feature", null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getReportControl() {
            return getMMKVProxy$default(this, "vas_report", null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getSafeUnzip() {
            return getMMKVProxy$default(this, "safe_unzip", null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getShowColorName() {
            return getMMKVProxy$default(this, "vas_show_vip_red_name", null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getTroopVipEffect() {
            return getMMKVProxy$default(this, "troop_vip_effect", null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final VasMMKVProxy getVipDataNeedRequest() {
            return getMMKVProxy$default(this, "vas_data_need_request", null, 2, null);
        }

        Companion() {
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final VasMMKVProxy getCommon(@Nullable String uin) {
            return getMMKVProxy("common", uin);
        }
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getBubbleTextColorInfo() {
        return INSTANCE.getBubbleTextColorInfo();
    }

    @JvmStatic
    @JvmOverloads
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
    public static final VasMMKVProxy getDiyBubbleConfig() {
        return INSTANCE.getDiyBubbleConfig();
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getFeature() {
        return INSTANCE.getFeature();
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getReportControl() {
        return INSTANCE.getReportControl();
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getSafeUnzip() {
        return INSTANCE.getSafeUnzip();
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getShowColorName() {
        return INSTANCE.getShowColorName();
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getTroopVipEffect() {
        return INSTANCE.getTroopVipEffect();
    }

    @JvmStatic
    @NotNull
    public static final VasMMKVProxy getVipDataNeedRequest() {
        return INSTANCE.getVipDataNeedRequest();
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final VasMMKVProxy getCommon(@Nullable String str) {
        return INSTANCE.getCommon(str);
    }
}
