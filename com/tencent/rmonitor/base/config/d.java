package com.tencent.rmonitor.base.config;

import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0017\u0003\u0006\t\r\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$B-\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u0082\u0001\u0017%&'()*+,-./0123456789:;\u00a8\u0006<"}, d2 = {"Lcom/tencent/rmonitor/base/config/d;", "", "", "a", "Ljava/lang/String;", "pluginName", "b", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "Lcom/tencent/rmonitor/base/config/data/m;", "c", "Lcom/tencent/rmonitor/base/config/data/m;", DownloadInfo.spKey_Config, "", "d", "I", "curReportNum", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/rmonitor/base/config/data/m;I)V", "e", "f", "g", tl.h.F, "i", "j", "k", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "o", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", ReportConstant.COSTREPORT_PREFIX, "t", "u", "v", "w", "Lcom/tencent/rmonitor/base/config/d$m;", "Lcom/tencent/rmonitor/base/config/d$n;", "Lcom/tencent/rmonitor/base/config/d$w;", "Lcom/tencent/rmonitor/base/config/d$g;", "Lcom/tencent/rmonitor/base/config/d$j;", "Lcom/tencent/rmonitor/base/config/d$l;", "Lcom/tencent/rmonitor/base/config/d$f;", "Lcom/tencent/rmonitor/base/config/d$s;", "Lcom/tencent/rmonitor/base/config/d$h;", "Lcom/tencent/rmonitor/base/config/d$o;", "Lcom/tencent/rmonitor/base/config/d$t;", "Lcom/tencent/rmonitor/base/config/d$e;", "Lcom/tencent/rmonitor/base/config/d$i;", "Lcom/tencent/rmonitor/base/config/d$p;", "Lcom/tencent/rmonitor/base/config/d$a;", "Lcom/tencent/rmonitor/base/config/d$k;", "Lcom/tencent/rmonitor/base/config/d$v;", "Lcom/tencent/rmonitor/base/config/d$u;", "Lcom/tencent/rmonitor/base/config/d$q;", "Lcom/tencent/rmonitor/base/config/d$d;", "Lcom/tencent/rmonitor/base/config/d$b;", "Lcom/tencent/rmonitor/base/config/d$c;", "Lcom/tencent/rmonitor/base/config/d$r;", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public final String pluginName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public final String entrance;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public com.tencent.rmonitor.base.config.data.m config;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public int curReportNum;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/rmonitor/base/config/d$a;", "Lcom/tencent/rmonitor/base/config/d;", "", "pluginName", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class a extends d {
        public /* synthetic */ a(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? BuglyMonitorName.ASAN : str, (i3 & 2) != 0 ? "com.tencent.rmonitor.asan.AddressSanitizer" : str2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull String pluginName, @NotNull String entrance) {
            super(pluginName, entrance, null, 0, 12, null);
            Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
            Intrinsics.checkParameterIsNotNull(entrance, "entrance");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/rmonitor/base/config/d$b;", "Lcom/tencent/rmonitor/base/config/d;", "", "pluginName", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class b extends d {
        public /* synthetic */ b(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? BuglyMonitorName.BATTERY_ELEMENT_METRIC : str, (i3 & 2) != 0 ? "com.tencent.bugly.battery.plugins.BatteryElementMetricPlugin" : str2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull String pluginName, @NotNull String entrance) {
            super(pluginName, entrance, null, 0, 12, null);
            Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
            Intrinsics.checkParameterIsNotNull(entrance, "entrance");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/rmonitor/base/config/d$c;", "Lcom/tencent/rmonitor/base/config/d;", "", "pluginName", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class c extends d {
        public /* synthetic */ c(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? BuglyMonitorName.BATTERY_ELEMENT : str, (i3 & 2) != 0 ? "com.tencent.bugly.battery.plugins.BatteryElementPlugin" : str2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull String pluginName, @NotNull String entrance) {
            super(pluginName, entrance, null, 0, 12, null);
            Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
            Intrinsics.checkParameterIsNotNull(entrance, "entrance");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/rmonitor/base/config/d$d;", "Lcom/tencent/rmonitor/base/config/d;", "", "pluginName", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.rmonitor.base.config.d$d, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C9744d extends d {
        public /* synthetic */ C9744d(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? BuglyMonitorName.BATTERY_METRIC : str, (i3 & 2) != 0 ? "com.tencent.bugly.battery.plugins.BatteryMetricPlugin" : str2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C9744d(@NotNull String pluginName, @NotNull String entrance) {
            super(pluginName, entrance, null, 0, 12, null);
            Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
            Intrinsics.checkParameterIsNotNull(entrance, "entrance");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/rmonitor/base/config/d$e;", "Lcom/tencent/rmonitor/base/config/d;", "", "pluginName", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class e extends d {
        public /* synthetic */ e(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? BuglyMonitorName.MEMORY_BIG_BITMAP : str, (i3 & 2) != 0 ? "com.tencent.rmonitor.bigbitmap.BigBitmapMonitor" : str2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@NotNull String pluginName, @NotNull String entrance) {
            super(pluginName, entrance, null, 0, 12, null);
            Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
            Intrinsics.checkParameterIsNotNull(entrance, "entrance");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/rmonitor/base/config/d$f;", "Lcom/tencent/rmonitor/base/config/d;", "", "pluginName", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class f extends d {
        public /* synthetic */ f(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? BuglyMonitorName.MEMORY_JAVA_CEILING : str, (i3 & 2) != 0 ? "com.tencent.rmonitor.memory.ceil.MemoryCeilingMonitor" : str2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(@NotNull String pluginName, @NotNull String entrance) {
            super(pluginName, entrance, null, 0, 12, null);
            Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
            Intrinsics.checkParameterIsNotNull(entrance, "entrance");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/rmonitor/base/config/d$g;", "Lcom/tencent/rmonitor/base/config/d;", "", "pluginName", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class g extends d {
        public /* synthetic */ g(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? TVKNetVideoInfo.AUDIO_TRACK_DOLBY : str, (i3 & 2) != 0 ? "com.tencent.rmonitor.db.SQLiteLintCore" : str2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(@NotNull String pluginName, @NotNull String entrance) {
            super(pluginName, entrance, null, 0, 12, null);
            Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
            Intrinsics.checkParameterIsNotNull(entrance, "entrance");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/rmonitor/base/config/d$h;", "Lcom/tencent/rmonitor/base/config/d;", "", "pluginName", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class h extends d {
        public /* synthetic */ h(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "device" : str, (i3 & 2) != 0 ? "com.tencent.rmonitor.device.DeviceInfoMonitor" : str2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(@NotNull String pluginName, @NotNull String entrance) {
            super(pluginName, entrance, null, 0, 12, null);
            Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
            Intrinsics.checkParameterIsNotNull(entrance, "entrance");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/rmonitor/base/config/d$i;", "Lcom/tencent/rmonitor/base/config/d;", "", "pluginName", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class i extends d {
        public /* synthetic */ i(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? BuglyMonitorName.FD_ANALYZE : str, (i3 & 2) != 0 ? "com.tencent.rmonitor.fd.FdLeakMonitor" : str2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(@NotNull String pluginName, @NotNull String entrance) {
            super(pluginName, entrance, null, 0, 12, null);
            Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
            Intrinsics.checkParameterIsNotNull(entrance, "entrance");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/rmonitor/base/config/d$j;", "Lcom/tencent/rmonitor/base/config/d;", "", "pluginName", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class j extends d {
        public /* synthetic */ j(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "io" : str, (i3 & 2) != 0 ? "com.tencent.rmonitor.io.IoCanaryCore" : str2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(@NotNull String pluginName, @NotNull String entrance) {
            super(pluginName, entrance, null, 0, 12, null);
            Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
            Intrinsics.checkParameterIsNotNull(entrance, "entrance");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/rmonitor/base/config/d$k;", "Lcom/tencent/rmonitor/base/config/d;", "", "pluginName", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class k extends d {
        public /* synthetic */ k(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? BuglyMonitorName.LAUNCH : str, (i3 & 2) != 0 ? "" : str2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(@NotNull String pluginName, @NotNull String entrance) {
            super(pluginName, entrance, null, 0, 12, null);
            Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
            Intrinsics.checkParameterIsNotNull(entrance, "entrance");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/rmonitor/base/config/d$l;", "Lcom/tencent/rmonitor/base/config/d;", "", "pluginName", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class l extends d {
        public /* synthetic */ l(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? BuglyMonitorName.MEMORY_JAVA_LEAK : str, (i3 & 2) != 0 ? "com.tencent.rmonitor.memory.leakdetect.MemoryLeakMonitor" : str2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(@NotNull String pluginName, @NotNull String entrance) {
            super(pluginName, entrance, null, 0, 12, null);
            Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
            Intrinsics.checkParameterIsNotNull(entrance, "entrance");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/rmonitor/base/config/d$m;", "Lcom/tencent/rmonitor/base/config/d;", "", "pluginName", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class m extends d {
        public /* synthetic */ m(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? BuglyMonitorName.LOOPER_STACK : str, (i3 & 2) != 0 ? "com.tencent.rmonitor.looper.LooperMonitor" : str2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(@NotNull String pluginName, @NotNull String entrance) {
            super(pluginName, entrance, null, 0, 12, null);
            Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
            Intrinsics.checkParameterIsNotNull(entrance, "entrance");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/rmonitor/base/config/d$n;", "Lcom/tencent/rmonitor/base/config/d;", "", "pluginName", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class n extends d {
        public /* synthetic */ n(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? BuglyMonitorName.FLUENCY_METRIC : str, (i3 & 2) != 0 ? "com.tencent.rmonitor.metrics.looper.DropFrameMonitor" : str2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(@NotNull String pluginName, @NotNull String entrance) {
            super(pluginName, entrance, null, 0, 12, null);
            Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
            Intrinsics.checkParameterIsNotNull(entrance, "entrance");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/rmonitor/base/config/d$o;", "Lcom/tencent/rmonitor/base/config/d;", "", "pluginName", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class o extends d {
        public /* synthetic */ o(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? BuglyMonitorName.MEMORY_METRIC : str, (i3 & 2) != 0 ? "com.tencent.rmonitor.metrics.MemoryQuantileMonitor" : str2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(@NotNull String pluginName, @NotNull String entrance) {
            super(pluginName, entrance, null, 0, 12, null);
            Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
            Intrinsics.checkParameterIsNotNull(entrance, "entrance");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/rmonitor/base/config/d$p;", "Lcom/tencent/rmonitor/base/config/d;", "", "pluginName", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class p extends d {
        public /* synthetic */ p(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? BuglyMonitorName.NATIVE_MEMORY_ANALYZE : str, (i3 & 2) != 0 ? "com.tencent.rmonitor.natmem.NatMemMonitor" : str2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(@NotNull String pluginName, @NotNull String entrance) {
            super(pluginName, entrance, null, 0, 12, null);
            Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
            Intrinsics.checkParameterIsNotNull(entrance, "entrance");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/rmonitor/base/config/d$q;", "Lcom/tencent/rmonitor/base/config/d;", "", "pluginName", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class q extends d {
        public /* synthetic */ q(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? BuglyMonitorName.NET_QUALITY : str, (i3 & 2) != 0 ? "com.tencent.bugly.network.NetQualityMonitor" : str2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(@NotNull String pluginName, @NotNull String entrance) {
            super(pluginName, entrance, null, 0, 12, null);
            Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
            Intrinsics.checkParameterIsNotNull(entrance, "entrance");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/rmonitor/base/config/d$r;", "Lcom/tencent/rmonitor/base/config/d;", "", "pluginName", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class r extends d {
        public /* synthetic */ r(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? BuglyMonitorName.PAGE_LAUNCH : str, (i3 & 2) != 0 ? "com.tencent.rmonitor.pagelaunch.PageLaunchPlugin" : str2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(@NotNull String pluginName, @NotNull String entrance) {
            super(pluginName, entrance, null, 0, 12, null);
            Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
            Intrinsics.checkParameterIsNotNull(entrance, "entrance");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/rmonitor/base/config/d$s;", "Lcom/tencent/rmonitor/base/config/d;", "", "pluginName", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class s extends d {
        public /* synthetic */ s(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "battery" : str, (i3 & 2) != 0 ? "com.tencent.rmonitor.qqbattery.QQBatteryMonitor" : str2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(@NotNull String pluginName, @NotNull String entrance) {
            super(pluginName, entrance, null, 0, 12, null);
            Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
            Intrinsics.checkParameterIsNotNull(entrance, "entrance");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/rmonitor/base/config/d$t;", "Lcom/tencent/rmonitor/base/config/d;", "", "pluginName", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class t extends d {
        public /* synthetic */ t(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? BuglyMonitorName.MEMORY_METRIC_OF_SUB_PROCESS : str, (i3 & 2) != 0 ? "com.tencent.rmonitor.metrics.MemoryQuantileMonitor" : str2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(@NotNull String pluginName, @NotNull String entrance) {
            super(pluginName, entrance, null, 0, 12, null);
            Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
            Intrinsics.checkParameterIsNotNull(entrance, "entrance");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/rmonitor/base/config/d$u;", "Lcom/tencent/rmonitor/base/config/d;", "", "pluginName", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class u extends d {
        public /* synthetic */ u(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? BuglyMonitorName.TRAFFIC_DETAIL : str, (i3 & 2) != 0 ? "com.tencent.bugly.traffic.TrafficDetailPlugin" : str2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(@NotNull String pluginName, @NotNull String entrance) {
            super(pluginName, entrance, null, 0, 12, null);
            Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
            Intrinsics.checkParameterIsNotNull(entrance, "entrance");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/rmonitor/base/config/d$v;", "Lcom/tencent/rmonitor/base/config/d;", "", "pluginName", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class v extends d {
        public /* synthetic */ v(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? BuglyMonitorName.TRAFFIC : str, (i3 & 2) != 0 ? "com.tencent.bugly.traffic.TrafficPlugin" : str2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(@NotNull String pluginName, @NotNull String entrance) {
            super(pluginName, entrance, null, 0, 12, null);
            Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
            Intrinsics.checkParameterIsNotNull(entrance, "entrance");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/rmonitor/base/config/d$w;", "Lcom/tencent/rmonitor/base/config/d;", "", "pluginName", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class w extends d {
        public /* synthetic */ w(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "work_thread_lag" : str, (i3 & 2) != 0 ? "com.tencent.rmonitor.looper.WorkThreadMonitor" : str2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(@NotNull String pluginName, @NotNull String entrance) {
            super(pluginName, entrance, null, 0, 12, null);
            Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
            Intrinsics.checkParameterIsNotNull(entrance, "entrance");
        }
    }

    d(String str, String str2, com.tencent.rmonitor.base.config.data.m mVar, int i3) {
        this.pluginName = str;
        this.entrance = str2;
        this.config = mVar;
        this.curReportNum = i3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    /* synthetic */ d(String str, String str2, com.tencent.rmonitor.base.config.data.m mVar, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, mVar, (i16 & 8) != 0 ? 0 : i3);
        if ((i16 & 4) != 0) {
            mVar = com.tencent.rmonitor.base.config.a.a(str);
            Intrinsics.checkExpressionValueIsNotNull(mVar, "ConfigCreatorWrapper.cre\u2026DefaultConfig(pluginName)");
        }
    }
}
