package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.profilecard.bussiness.accountlevel.report.ProfileVipReport;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/vas/VasLogNtReporter;", "", "()V", "Companion", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasLogNtReporter {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\b\u0010\b\u001a\u00020\u0004H\u0007J\b\u0010\t\u001a\u00020\u0004H\u0007J\b\u0010\n\u001a\u00020\u0004H\u0007J\b\u0010\u000b\u001a\u00020\u0004H\u0007J\b\u0010\f\u001a\u00020\u0004H\u0007J\b\u0010\r\u001a\u00020\u0004H\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/VasLogNtReporter$Companion;", "", "()V", "getAIODraw", "Lcom/tencent/mobileqq/vas/VasLogReportProxy;", "getFrequency", "getMutualMark", "getRecentDraw", "getTroopKeyword", "getVasUpdateKeyWord", "getVipColorName", "getVipData", "getVipIcon", "getVipNumber", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final VasLogReportProxy getAIODraw() {
            return new VasLogReportProxy("aio_draw");
        }

        @JvmStatic
        @NotNull
        public final VasLogReportProxy getFrequency() {
            return new VasLogReportProxy("vas_frequency");
        }

        @JvmStatic
        @NotNull
        public final VasLogReportProxy getMutualMark() {
            return new VasLogReportProxy("mutual_mark");
        }

        @JvmStatic
        @NotNull
        public final VasLogReportProxy getRecentDraw() {
            return new VasLogReportProxy("recent_draw");
        }

        @JvmStatic
        @NotNull
        public final VasLogReportProxy getTroopKeyword() {
            return new VasLogReportProxy("troop_keyword");
        }

        @JvmStatic
        @NotNull
        public final VasLogReportProxy getVasUpdateKeyWord() {
            return new VasLogReportProxy("vas_update_manager");
        }

        @JvmStatic
        @NotNull
        public final VasLogReportProxy getVipColorName() {
            return new VasLogReportProxy("color_name");
        }

        @JvmStatic
        @NotNull
        public final VasLogReportProxy getVipData() {
            return new VasLogReportProxy("vip_data");
        }

        @JvmStatic
        @NotNull
        public final VasLogReportProxy getVipIcon() {
            return new VasLogReportProxy(ProfileVipReport.VIP_ICON_MODULE_ID);
        }

        @JvmStatic
        @NotNull
        public final VasLogReportProxy getVipNumber() {
            return new VasLogReportProxy("vip_number");
        }

        Companion() {
        }
    }

    @JvmStatic
    @NotNull
    public static final VasLogReportProxy getAIODraw() {
        return INSTANCE.getAIODraw();
    }

    @JvmStatic
    @NotNull
    public static final VasLogReportProxy getFrequency() {
        return INSTANCE.getFrequency();
    }

    @JvmStatic
    @NotNull
    public static final VasLogReportProxy getMutualMark() {
        return INSTANCE.getMutualMark();
    }

    @JvmStatic
    @NotNull
    public static final VasLogReportProxy getRecentDraw() {
        return INSTANCE.getRecentDraw();
    }

    @JvmStatic
    @NotNull
    public static final VasLogReportProxy getTroopKeyword() {
        return INSTANCE.getTroopKeyword();
    }

    @JvmStatic
    @NotNull
    public static final VasLogReportProxy getVasUpdateKeyWord() {
        return INSTANCE.getVasUpdateKeyWord();
    }

    @JvmStatic
    @NotNull
    public static final VasLogReportProxy getVipColorName() {
        return INSTANCE.getVipColorName();
    }

    @JvmStatic
    @NotNull
    public static final VasLogReportProxy getVipData() {
        return INSTANCE.getVipData();
    }

    @JvmStatic
    @NotNull
    public static final VasLogReportProxy getVipIcon() {
        return INSTANCE.getVipIcon();
    }

    @JvmStatic
    @NotNull
    public static final VasLogReportProxy getVipNumber() {
        return INSTANCE.getVipNumber();
    }
}
