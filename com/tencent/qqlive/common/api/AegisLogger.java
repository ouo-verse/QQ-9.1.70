package com.tencent.qqlive.common.api;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.report.constant.QQLiveQualityReportData;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqlive/common/api/AegisLogger;", "", "()V", "Companion", "qq-live-common-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes22.dex */
public final class AegisLogger {

    @NotNull
    public static final String AUDIENCE = "Audience";

    @NotNull
    public static final String BOTTOM_BAR = "Bottom_Bar";

    @NotNull
    public static final String CHAT_MESSAGE = "Chat_Message";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String FLOAT_BANNER = "Float_Banner";

    @NotNull
    public static final String GIFT = "Gift";

    @NotNull
    public static final String INPUT = "Input";

    @NotNull
    public static final String INTERACTIVE = "Interactive";

    @NotNull
    public static final String LIKE_BIZ = "Like_Biz";

    @NotNull
    public static final String LOGIN = "Login";

    @NotNull
    public static final String MEDAL = "Medal_Info";

    @NotNull
    public static final String OPEN_LIVE = "Open_Live";

    @NotNull
    public static final String PENDANT = "Pendant";

    @NotNull
    public static final String PK_BIZ = "PK_Biz";

    @NotNull
    public static final String PUSH = "Push";

    @NotNull
    private static final String QQLIVE = "QQLiveBiz";

    @NotNull
    public static final String QQLIVE_PLAYER = "QQLive_Player";

    @NotNull
    public static final String RECV_GIFT_MONITOR = "Recv_Gift_Monitor";

    @NotNull
    public static final String ROOM_INFO = "room_info";

    @NotNull
    public static final String SEND_GIFT_MONITOR = "Send_Gift_Monitor";

    @NotNull
    public static final String SHARE = "Share";

    @NotNull
    public static final String TAG_SPLITTER = "|";

    @NotNull
    public static final String UNKNOWN = "unknown";

    @NotNull
    public static final String VSREQUEST = "VSRequest";

    @NotNull
    private static final Set<String> modulesSet;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0003J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0004H\u0003J\u0010\u0010!\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u0004H\u0003J\u0018\u0010#\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H\u0007J \u0010#\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0007J \u0010%\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0007J*\u0010%\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010&\u001a\u00020'H\u0007J(\u0010%\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010(\u001a\u00020)H\u0007J\u0018\u0010*\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H\u0007J \u0010*\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0007J*\u0010*\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010&\u001a\u00020'H\u0007J\b\u0010+\u001a\u00020'H\u0007J\b\u0010,\u001a\u00020'H\u0007J \u0010&\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0003J\u0018\u0010-\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H\u0007J \u0010-\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/tencent/qqlive/common/api/AegisLogger$Companion;", "", "()V", "AUDIENCE", "", "BOTTOM_BAR", "CHAT_MESSAGE", "FLOAT_BANNER", "GIFT", "INPUT", "INTERACTIVE", "LIKE_BIZ", "LOGIN", "MEDAL", "OPEN_LIVE", "PENDANT", "PK_BIZ", "PUSH", "QQLIVE", "QQLIVE_PLAYER", "RECV_GIFT_MONITOR", "ROOM_INFO", "SEND_GIFT_MONITOR", "SHARE", "TAG_SPLITTER", "UNKNOWN", "VSREQUEST", "modulesSet", "", "buildInfo", "info", "buildTag", "tag", "checkModule", "", "d", "action", "e", "reportToEagle", "", "th", "", "i", "isColorLevel", "isDevelopLevel", "w", "qq-live-common-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes22.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String buildTag(String tag) {
            return "QQLiveBiz|" + tag;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void checkModule(String tag) {
            boolean contains$default;
            List split$default;
            if (QLog.isDevelopLevel()) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) tag, (CharSequence) "|", false, 2, (Object) null);
                if (contains$default) {
                    split$default = StringsKt__StringsKt.split$default((CharSequence) tag, new String[]{"|"}, false, 0, 6, (Object) null);
                    tag = (String) split$default.get(0);
                }
                if (AegisLogger.modulesSet.contains(tag)) {
                    return;
                }
                throw new IllegalArgumentException(tag + " not in modules");
            }
        }

        public static /* synthetic */ void e$default(Companion companion, String str, String str2, String str3, boolean z16, int i3, Object obj) {
            if ((i3 & 8) != 0) {
                z16 = false;
            }
            companion.e(str, str2, str3, z16);
        }

        public static /* synthetic */ void i$default(Companion companion, String str, String str2, String str3, boolean z16, int i3, Object obj) {
            if ((i3 & 8) != 0) {
                z16 = false;
            }
            companion.i(str, str2, str3, z16);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void reportToEagle(String tag, String action, String info) {
            ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).qualityReport(new QQLiveQualityReportData.Builder(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null).traceId("").eventId(QQLiveReportConstants.Event.E_MONITOR_LOG_REPORT).ext6(tag).ext7(action).ext8(info));
        }

        @JvmStatic
        public final void d(@NotNull String tag, @NotNull String action) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(action, "action");
            checkModule(tag);
            if (isColorLevel()) {
                ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).d(buildTag(tag), buildInfo('[' + action + ']'));
            }
        }

        @JvmStatic
        public final void e(@NotNull String tag, @NotNull String action, @NotNull String info) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(info, "info");
            checkModule(tag);
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).e(buildTag(tag), buildInfo('[' + action + "]: " + info));
        }

        @JvmStatic
        public final void i(@NotNull String tag, @NotNull String action) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(action, "action");
            checkModule(tag);
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i(buildTag(tag), buildInfo('[' + action + ']'));
        }

        @JvmStatic
        public final boolean isColorLevel() {
            return QLog.isColorLevel();
        }

        @JvmStatic
        public final boolean isDevelopLevel() {
            return QLog.isDevelopLevel();
        }

        @JvmStatic
        public final void w(@NotNull String tag, @NotNull String action) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(action, "action");
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).w(buildTag(tag), buildInfo('[' + action + ']'));
        }

        Companion() {
        }

        @JvmStatic
        public final void w(@NotNull String tag, @NotNull String action, @NotNull String info) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(info, "info");
            checkModule(tag);
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).w(buildTag(tag), buildInfo('[' + action + "]: " + info));
        }

        @JvmStatic
        public final void e(@NotNull String tag, @NotNull String action, @NotNull String info, boolean reportToEagle) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(info, "info");
            if (reportToEagle) {
                reportToEagle(tag, action, info);
            }
            e(tag, action, info);
        }

        @JvmStatic
        public final void i(@NotNull String tag, @NotNull String action, @NotNull String info) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(info, "info");
            checkModule(tag);
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i(buildTag(tag), buildInfo('[' + action + "]: " + info));
        }

        @JvmStatic
        public final void d(@NotNull String tag, @NotNull String action, @NotNull String info) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(info, "info");
            checkModule(tag);
            if (isColorLevel()) {
                ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).d(buildTag(tag), buildInfo('[' + action + "]: " + info));
            }
        }

        @JvmStatic
        public final void e(@NotNull String tag, @NotNull String action, @NotNull String info, @NotNull Throwable th5) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(th5, "th");
            checkModule(tag);
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).e(buildTag(tag), buildInfo('[' + action + "]: " + info), th5);
        }

        @JvmStatic
        public final void i(@NotNull String tag, @NotNull String action, @NotNull String info, boolean reportToEagle) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(info, "info");
            if (reportToEagle) {
                reportToEagle(tag, action, info);
            }
            i(tag, action, info);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String buildInfo(String info) {
            return info;
        }
    }

    static {
        Set<String> of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new String[]{"unknown", LOGIN, GIFT, VSREQUEST, OPEN_LIVE, AUDIENCE, SHARE, ROOM_INFO, PUSH, PENDANT, INTERACTIVE, PK_BIZ, CHAT_MESSAGE, QQLIVE_PLAYER, LIKE_BIZ, INPUT, FLOAT_BANNER, SEND_GIFT_MONITOR, RECV_GIFT_MONITOR, BOTTOM_BAR, MEDAL});
        modulesSet = of5;
    }

    @JvmStatic
    private static final String buildInfo(String str) {
        return INSTANCE.buildInfo(str);
    }

    @JvmStatic
    private static final String buildTag(String str) {
        return INSTANCE.buildTag(str);
    }

    @JvmStatic
    private static final void checkModule(String str) {
        INSTANCE.checkModule(str);
    }

    @JvmStatic
    public static final void d(@NotNull String str, @NotNull String str2) {
        INSTANCE.d(str, str2);
    }

    @JvmStatic
    public static final void e(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        INSTANCE.e(str, str2, str3);
    }

    @JvmStatic
    public static final void i(@NotNull String str, @NotNull String str2) {
        INSTANCE.i(str, str2);
    }

    @JvmStatic
    public static final boolean isColorLevel() {
        return INSTANCE.isColorLevel();
    }

    @JvmStatic
    public static final boolean isDevelopLevel() {
        return INSTANCE.isDevelopLevel();
    }

    @JvmStatic
    private static final void reportToEagle(String str, String str2, String str3) {
        INSTANCE.reportToEagle(str, str2, str3);
    }

    @JvmStatic
    public static final void w(@NotNull String str, @NotNull String str2) {
        INSTANCE.w(str, str2);
    }

    @JvmStatic
    public static final void d(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        INSTANCE.d(str, str2, str3);
    }

    @JvmStatic
    public static final void e(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Throwable th5) {
        INSTANCE.e(str, str2, str3, th5);
    }

    @JvmStatic
    public static final void i(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        INSTANCE.i(str, str2, str3);
    }

    @JvmStatic
    public static final void w(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        INSTANCE.w(str, str2, str3);
    }

    @JvmStatic
    public static final void e(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z16) {
        INSTANCE.e(str, str2, str3, z16);
    }

    @JvmStatic
    public static final void i(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z16) {
        INSTANCE.i(str, str2, str3, z16);
    }
}
