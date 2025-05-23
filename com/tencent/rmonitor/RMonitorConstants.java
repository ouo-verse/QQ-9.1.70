package com.tencent.rmonitor;

import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.rmonitor.common.logger.LogState;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface RMonitorConstants {

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    public static final int f365231a = b.a(BuglyMonitorName.MEMORY_JAVA_LEAK);

    /* renamed from: b, reason: collision with root package name */
    @Deprecated
    public static final int f365232b = b.a("io");

    /* renamed from: c, reason: collision with root package name */
    @Deprecated
    public static final int f365233c = b.a(TVKNetVideoInfo.AUDIO_TRACK_DOLBY);

    /* renamed from: d, reason: collision with root package name */
    @Deprecated
    public static final int f365234d = b.a(BuglyMonitorName.LOOPER_STACK);

    /* renamed from: e, reason: collision with root package name */
    @Deprecated
    public static final int f365235e = b.a(BuglyMonitorName.FLUENCY_METRIC);

    /* renamed from: f, reason: collision with root package name */
    @Deprecated
    public static final int f365236f = b.a(BuglyMonitorName.FLUENCY_METRIC);

    /* renamed from: g, reason: collision with root package name */
    @Deprecated
    public static final int f365237g = b.a(BuglyMonitorName.FD_ANALYZE);

    /* renamed from: h, reason: collision with root package name */
    @Deprecated
    public static final int f365238h = b.a(BuglyMonitorName.NATIVE_MEMORY_ANALYZE);

    /* renamed from: i, reason: collision with root package name */
    @Deprecated
    public static final int f365239i = b.a(BuglyMonitorName.MEMORY_BIG_BITMAP);

    /* renamed from: j, reason: collision with root package name */
    @Deprecated
    public static final int f365240j = b.a("work_thread_lag");

    /* renamed from: k, reason: collision with root package name */
    @Deprecated
    public static final int f365241k = b.a(BuglyMonitorName.TRAFFIC);

    /* renamed from: l, reason: collision with root package name */
    @Deprecated
    public static final int f365242l = b.a(BuglyMonitorName.TRAFFIC_DETAIL);

    /* renamed from: m, reason: collision with root package name */
    public static final int f365243m = LogState.OFF.getValue();

    /* renamed from: n, reason: collision with root package name */
    public static final int f365244n = LogState.ERROR.getValue();

    /* renamed from: o, reason: collision with root package name */
    public static final int f365245o = LogState.WARN.getValue();

    /* renamed from: p, reason: collision with root package name */
    public static final int f365246p = LogState.INFO.getValue();

    /* renamed from: q, reason: collision with root package name */
    public static final int f365247q = LogState.DEBUG.getValue();

    /* renamed from: r, reason: collision with root package name */
    public static final int f365248r = LogState.VERBOS.getValue();

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes25.dex */
    public @interface PropertyKeyObjectValue {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes25.dex */
    public @interface PropertyKeyStringValue {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes25.dex */
    public @interface PropertyKeyUpdater {
    }
}
