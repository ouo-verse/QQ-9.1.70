package com.tencent.freesia;

import android.os.SystemClock;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.cache.api.Business;
import com.tencent.freesia.SoLoader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 u2\u00020\u0001:\u0001uB?\u0012\u0006\u0010j\u001a\u00020i\u0012\u0016\u0010l\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u001cj\b\u0012\u0004\u0012\u00020\u0005`\u001d\u0012\u0006\u0010n\u001a\u00020m\u0012\u0006\u0010p\u001a\u00020o\u0012\u0006\u0010r\u001a\u00020q\u00a2\u0006\u0004\bs\u0010tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ'\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\b\u0010\fJ\u001f\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\rj\b\u0012\u0004\u0012\u00020\u0005`\u000eH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001a\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u0011\u00a2\u0006\u0004\b\u001a\u0010\u001bJ9\u0010\u001f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00052\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u001cj\b\u0012\u0004\u0012\u00020\u0005`\u001d2\b\b\u0002\u0010\u0019\u001a\u00020\u0011H\u0007\u00a2\u0006\u0004\b\u001f\u0010 J9\u0010!\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00052\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u001cj\b\u0012\u0004\u0012\u00020\u0005`\u001d2\b\b\u0002\u0010\u0019\u001a\u00020\u0011H\u0007\u00a2\u0006\u0004\b!\u0010 J\u0019\u0010\"\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u0011H\u0007\u00a2\u0006\u0004\b\"\u0010#J\u001f\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\u0004\b%\u0010&J\u001f\u0010'\u001a\u0004\u0018\u00010$2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\u0004\b'\u0010&J%\u0010*\u001a\u00020(2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010)\u001a\u00020(\u00a2\u0006\u0004\b*\u0010+J%\u0010,\u001a\u00020(2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010)\u001a\u00020(\u00a2\u0006\u0004\b,\u0010+J%\u0010-\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0011\u00a2\u0006\u0004\b-\u0010.J-\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u001cj\b\u0012\u0004\u0012\u00020\u0005`\u001d2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0005\u00a2\u0006\u0004\b0\u00101J\u0015\u00103\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u0011\u00a2\u0006\u0004\b3\u0010#J\u001f\u00104\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\u0004\b4\u0010\tJ\u001d\u00105\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\u0004\b5\u0010\u0015J\r\u00106\u001a\u00020\u0002\u00a2\u0006\u0004\b6\u0010\u0004J\u001d\u00107\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\u0004\b7\u00108J\r\u0010:\u001a\u000209\u00a2\u0006\u0004\b:\u0010;J\u0015\u0010>\u001a\u00020\u00112\u0006\u0010=\u001a\u00020<\u00a2\u0006\u0004\b>\u0010?J\u001d\u0010@\u001a\u0002092\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\u0004\b@\u0010AJ\r\u0010B\u001a\u00020\u0002\u00a2\u0006\u0004\bB\u0010\u0004J\r\u0010C\u001a\u00020\u0002\u00a2\u0006\u0004\bC\u0010\u0004J\u0015\u0010E\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u0011\u00a2\u0006\u0004\bE\u0010#J\u0015\u0010F\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0005\u00a2\u0006\u0004\bF\u0010GJ\u0015\u0010I\u001a\u00020\u00022\u0006\u0010H\u001a\u000209\u00a2\u0006\u0004\bI\u0010JJ\u0017\u0010M\u001a\u00020\u00022\u0006\u0010K\u001a\u00020\u0011H\u0000\u00a2\u0006\u0004\bL\u0010#J\u001f\u0010O\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\bN\u0010\u0015R\u0014\u0010Q\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010RR \u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020(0S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR \u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010UR \u0010X\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002090W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010Z\u001a\u00020<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010\\\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010^\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010]R\u0016\u0010_\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R$\u0010a\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010\u0018\"\u0004\bd\u0010eR\u0016\u0010g\u001a\u0004\u0018\u00010f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0014\u0010j\u001a\u00020i8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bj\u0010k\u00a8\u0006v"}, d2 = {"Lcom/tencent/freesia/UnitedConfig;", "", "", "invalidateCache", "()V", "", "prefix", "suffix", "genKey", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "uin", VipFunCallConstants.KEY_GROUP, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getKeysNoLogin", "()Ljava/util/HashSet;", "", "isAccountIsolate", "()Z", "reportLoad", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/tencent/freesia/ReportBridge;", "getReportBridge", "()Lcom/tencent/freesia/ReportBridge;", "callBackIfNotUpdate", "fetchAll", "(Ljava/lang/String;Z)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "groups", "fetch", "(Ljava/lang/String;Ljava/util/ArrayList;Z)V", "fetchSwitch", "fetchNoLogin", "(Z)V", "Lcom/tencent/freesia/IConfigData;", "loadConfig", "(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/freesia/IConfigData;", "loadLargeConfig", "", AdMetricTag.FALLBACK, "loadRawConfig", "(Ljava/lang/String;Ljava/lang/String;[B)[B", "loadLargeRawConfig", "isSwitchOn", "(Ljava/lang/String;Ljava/lang/String;Z)Z", "businessId", "getGroups", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList;", "test", "setEnv", "getResourcePath", "removeLocal", "clearInvalidData", "isCdn", "(Ljava/lang/String;Ljava/lang/String;)Z", "", "getUpdateInterval", "()I", "", "current", "isFetchMute", "(J)Z", "getConfigVersion", "(Ljava/lang/String;Ljava/lang/String;)I", "evictCache", "onAppForeground", "enable", "setIncFetch", "isIncFetchEnable", "(Ljava/lang/String;)Z", "rate", "setLoadReportRate", "(I)V", "hasRemove", "updateCacheTime$unitedconfig_android_release", "updateCacheTime", "removeCache$unitedconfig_android_release", "removeCache", "Lcom/tencent/freesia/ConfigParserBridgeImpl;", "parserBridge", "Lcom/tencent/freesia/ConfigParserBridgeImpl;", "Lcom/tencent/cache/api/collection/a;", "cache", "Lcom/tencent/cache/api/collection/a;", "switchCache", "Ljava/util/concurrent/ConcurrentHashMap;", "versionCache", "Ljava/util/concurrent/ConcurrentHashMap;", "cacheInvalidateTime", "J", "accountIsolate", "Z", "reported", "loadReportRate", "I", "REPORT_BRIDGE", "Lcom/tencent/freesia/ReportBridge;", "getREPORT_BRIDGE", "setREPORT_BRIDGE", "(Lcom/tencent/freesia/ReportBridge;)V", "Lcom/tencent/freesia/UnitedConfigBridge;", "bridge", "Lcom/tencent/freesia/UnitedConfigBridge;", "Lcom/tencent/freesia/UpperBridgesImpl;", "bridges", "Lcom/tencent/freesia/UpperBridgesImpl;", "projectIds", "Lcom/tencent/freesia/CommandType;", "commandType", "Lcom/tencent/freesia/Extend;", QFSEdgeItem.KEY_EXTEND, "Lcom/tencent/freesia/ExtraInitInfo;", "extra", "<init>", "(Lcom/tencent/freesia/UpperBridgesImpl;Ljava/util/ArrayList;Lcom/tencent/freesia/CommandType;Lcom/tencent/freesia/Extend;Lcom/tencent/freesia/ExtraInitInfo;)V", "Companion", "unitedconfig-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class UnitedConfig {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final String DEFAULT_UIN = "000";
    private static volatile UnitedConfig INSTANCE = null;
    private static final String KEY_SWITCH = "key_switch";
    private static final int LOAD_REPORT_RATE_DEFAULT = 20000;

    @Nullable
    private static ILogger LOGGER = null;

    @NotNull
    public static final String OLD_MMKV_UIN = "-1";
    private static final String SEPARATOR = "_";
    private static final String TAG = "Freesia";

    @Nullable
    private volatile ReportBridge REPORT_BRIDGE;
    private volatile boolean accountIsolate;
    private final UnitedConfigBridge bridge;
    private final UpperBridgesImpl bridges;
    private final com.tencent.cache.api.collection.a<String, byte[]> cache;
    private volatile long cacheInvalidateTime;
    private int loadReportRate;
    private final ConfigParserBridgeImpl parserBridge;
    private boolean reported;
    private final com.tencent.cache.api.collection.a<String, Boolean> switchCache;
    private final ConcurrentHashMap<String, Integer> versionCache;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&JE\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00058\u0002@\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00058\u0002@\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001bR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u00058\u0006@\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001bR\u0016\u0010#\u001a\u00020\u00058\u0002@\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b#\u0010\u001bR\u0016\u0010$\u001a\u00020\u00058\u0002@\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b$\u0010\u001b\u00a8\u0006'"}, d2 = {"Lcom/tencent/freesia/UnitedConfig$Companion;", "", "Lcom/tencent/freesia/UpperBridgesImpl;", "bridges", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "projectIds", "Lcom/tencent/freesia/CommandType;", "commandType", "Lcom/tencent/freesia/Extend;", QFSEdgeItem.KEY_EXTEND, "Lcom/tencent/freesia/ExtraInitInfo;", "extra", "Lcom/tencent/freesia/UnitedConfig;", "getInstance", "(Lcom/tencent/freesia/UpperBridgesImpl;Ljava/util/ArrayList;Lcom/tencent/freesia/CommandType;Lcom/tencent/freesia/Extend;Lcom/tencent/freesia/ExtraInitInfo;)Lcom/tencent/freesia/UnitedConfig;", "getOrNull", "()Lcom/tencent/freesia/UnitedConfig;", "Lcom/tencent/freesia/ILogger;", "LOGGER", "Lcom/tencent/freesia/ILogger;", "getLOGGER", "()Lcom/tencent/freesia/ILogger;", "setLOGGER", "(Lcom/tencent/freesia/ILogger;)V", "DEFAULT_UIN", "Ljava/lang/String;", "INSTANCE", "Lcom/tencent/freesia/UnitedConfig;", "KEY_SWITCH", "", "LOAD_REPORT_RATE_DEFAULT", "I", "OLD_MMKV_UIN", "SEPARATOR", "TAG", "<init>", "()V", "unitedconfig-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @NotNull
        public final UnitedConfig getInstance(@NotNull UpperBridgesImpl bridges, @NotNull ArrayList<String> projectIds, @NotNull CommandType commandType, @NotNull Extend extend, @NotNull ExtraInitInfo extra) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (UnitedConfig) iPatchRedirector.redirect((short) 5, this, bridges, projectIds, commandType, extend, extra);
            }
            Intrinsics.checkNotNullParameter(bridges, "bridges");
            Intrinsics.checkNotNullParameter(projectIds, "projectIds");
            Intrinsics.checkNotNullParameter(commandType, "commandType");
            Intrinsics.checkNotNullParameter(extend, "extend");
            Intrinsics.checkNotNullParameter(extra, "extra");
            UnitedConfig unitedConfig = UnitedConfig.INSTANCE;
            if (unitedConfig == null) {
                synchronized (this) {
                    unitedConfig = UnitedConfig.INSTANCE;
                    if (unitedConfig == null) {
                        unitedConfig = new UnitedConfig(bridges, projectIds, commandType, extend, extra);
                        UnitedConfig.INSTANCE = unitedConfig;
                    }
                }
            }
            return unitedConfig;
        }

        @Nullable
        public final ILogger getLOGGER() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return UnitedConfig.LOGGER;
            }
            return (ILogger) iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @Nullable
        public final UnitedConfig getOrNull() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return UnitedConfig.INSTANCE;
            }
            return (UnitedConfig) iPatchRedirector.redirect((short) 6, (Object) this);
        }

        public final void setLOGGER(@Nullable ILogger iLogger) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                UnitedConfig.LOGGER = iLogger;
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) iLogger);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        String stackTraceToString;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10249);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        INSTANCE = new Companion(null);
        try {
            SoLoader.Companion companion = SoLoader.INSTANCE;
            companion.load("c++_shared");
            companion.load("unitedconfig");
        } catch (UnsatisfiedLinkError e16) {
            ILogger iLogger = LOGGER;
            if (iLogger != null) {
                stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
                iLogger.e(TAG, stackTraceToString);
            }
        }
    }

    public UnitedConfig(@NotNull UpperBridgesImpl bridges, @NotNull ArrayList<String> projectIds, @NotNull CommandType commandType, @NotNull Extend extend, @NotNull ExtraInitInfo extra) {
        UnitedConfigBridge unitedConfigBridge;
        String stackTraceToString;
        Intrinsics.checkNotNullParameter(bridges, "bridges");
        Intrinsics.checkNotNullParameter(projectIds, "projectIds");
        Intrinsics.checkNotNullParameter(commandType, "commandType");
        Intrinsics.checkNotNullParameter(extend, "extend");
        Intrinsics.checkNotNullParameter(extra, "extra");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bridges, projectIds, commandType, extend, extra);
            return;
        }
        this.bridges = bridges;
        ConfigParserBridge parserBridge = bridges.getParserBridge();
        if (parserBridge != null) {
            this.parserBridge = (ConfigParserBridgeImpl) parserBridge;
            Business business = Business.Default;
            this.cache = new com.tencent.cache.api.collection.a<>(business, "freesia_content", 256);
            this.switchCache = new com.tencent.cache.api.collection.a<>(business, "freesia_switch", 256);
            this.versionCache = new ConcurrentHashMap<>();
            this.cacheInvalidateTime = SystemClock.elapsedRealtime();
            this.loadReportRate = 20000;
            LOGGER = bridges.getLogger();
            try {
                unitedConfigBridge = e.a(bridges, projectIds, commandType, extend, extra);
                Intrinsics.checkNotNull(unitedConfigBridge);
            } catch (UnsatisfiedLinkError e16) {
                ILogger iLogger = LOGGER;
                if (iLogger != null) {
                    stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
                    iLogger.e(TAG, stackTraceToString);
                }
                unitedConfigBridge = null;
            }
            this.bridge = unitedConfigBridge;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.freesia.ConfigParserBridgeImpl");
    }

    public static /* synthetic */ void fetch$default(UnitedConfig unitedConfig, String str, ArrayList arrayList, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        unitedConfig.fetch(str, arrayList, z16);
    }

    public static /* synthetic */ void fetchAll$default(UnitedConfig unitedConfig, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        unitedConfig.fetchAll(str, z16);
    }

    public static /* synthetic */ void fetchNoLogin$default(UnitedConfig unitedConfig, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        unitedConfig.fetchNoLogin(z16);
    }

    public static /* synthetic */ void fetchSwitch$default(UnitedConfig unitedConfig, String str, ArrayList arrayList, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        unitedConfig.fetchSwitch(str, arrayList, z16);
    }

    private final String genKey(String prefix, String suffix) {
        return prefix + "_" + suffix;
    }

    private final HashSet<String> getKeysNoLogin() {
        String str;
        UpperBridgesImpl upperBridgesImpl = this.bridges;
        if (isAccountIsolate()) {
            str = "000";
        } else {
            str = "-1";
        }
        return upperBridgesImpl.getKVBridge(str).getKeysNoLogin();
    }

    private final ReportBridge getReportBridge() {
        ReportBridge reportBridge = this.REPORT_BRIDGE;
        if (reportBridge == null) {
            synchronized (this) {
                reportBridge = this.REPORT_BRIDGE;
                if (reportBridge == null) {
                    reportBridge = c.a();
                    this.REPORT_BRIDGE = reportBridge;
                }
            }
        }
        return reportBridge;
    }

    private final void invalidateCache() {
        this.cacheInvalidateTime = SystemClock.elapsedRealtime();
        this.versionCache.clear();
        this.cache.d();
        this.switchCache.d();
        ILogger iLogger = LOGGER;
        if (iLogger != null) {
            iLogger.d(TAG, "evict all cache");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000d, code lost:
    
        if (r0.isAccountIsolate() == true) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean isAccountIsolate() {
        boolean z16;
        if (!this.accountIsolate) {
            UnitedConfigBridge unitedConfigBridge = this.bridge;
            if (unitedConfigBridge != null) {
                z16 = true;
            }
            z16 = false;
            this.accountIsolate = z16;
        }
        return this.accountIsolate;
    }

    private final void reportLoad(String uin, String group) {
        ReportBridge reportBridge;
        if (Random.INSTANCE.nextInt(this.loadReportRate) == 0 && (reportBridge = getReportBridge()) != null) {
            reportBridge.reportConfigLoad(group, getConfigVersion(uin, group));
        }
    }

    public final void clearInvalidData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        UnitedConfigBridge unitedConfigBridge = this.bridge;
        if (unitedConfigBridge != null) {
            unitedConfigBridge.clearInvalidData();
        }
    }

    public final void evictCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        invalidateCache();
        UnitedConfigBridge unitedConfigBridge = this.bridge;
        if (unitedConfigBridge != null) {
            unitedConfigBridge.evictCache();
        }
    }

    @JvmOverloads
    public final void fetch(@NotNull String str, @NotNull ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            fetch$default(this, str, arrayList, false, 4, null);
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) arrayList);
        }
    }

    public final void fetchAll(@NotNull String uin, boolean callBackIfNotUpdate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, uin, Boolean.valueOf(callBackIfNotUpdate));
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        UnitedConfigBridge unitedConfigBridge = this.bridge;
        if (unitedConfigBridge != null) {
            unitedConfigBridge.fetchAll(uin, callBackIfNotUpdate);
        }
    }

    @JvmOverloads
    public final void fetchNoLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            fetchNoLogin$default(this, false, 1, null);
        } else {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    @JvmOverloads
    public final void fetchSwitch(@NotNull String str, @NotNull ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            fetchSwitch$default(this, str, arrayList, false, 4, null);
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) arrayList);
        }
    }

    public final int getConfigVersion(@NotNull String uin, @NotNull String group) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this, (Object) uin, (Object) group)).intValue();
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(group, "group");
        if (this.bridge == null) {
            return 0;
        }
        String genKey = genKey(uin, group, "");
        Integer num = this.versionCache.get(genKey);
        if (num == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Integer valueOf = Integer.valueOf(this.bridge.getConfigVersion(uin, group));
            if (this.cacheInvalidateTime < elapsedRealtime) {
                this.versionCache.put(genKey, valueOf);
            }
            num = valueOf;
        }
        return num.intValue();
    }

    @NotNull
    public final ArrayList<String> getGroups(@NotNull String uin, @NotNull String businessId) {
        ArrayList<String> groups;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (ArrayList) iPatchRedirector.redirect((short) 17, (Object) this, (Object) uin, (Object) businessId);
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(businessId, "businessId");
        UnitedConfigBridge unitedConfigBridge = this.bridge;
        if (unitedConfigBridge == null || (groups = unitedConfigBridge.getGroups(uin, businessId)) == null) {
            return new ArrayList<>();
        }
        return groups;
    }

    @Nullable
    public final ReportBridge getREPORT_BRIDGE() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ReportBridge) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.REPORT_BRIDGE;
    }

    @Nullable
    public final String getResourcePath(@NotNull String uin, @NotNull String group) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this, (Object) uin, (Object) group);
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(group, "group");
        UnitedConfigBridge unitedConfigBridge = this.bridge;
        if (unitedConfigBridge != null) {
            return unitedConfigBridge.getResourcePath(uin, group);
        }
        return null;
    }

    public final int getUpdateInterval() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        UnitedConfigBridge unitedConfigBridge = this.bridge;
        if (unitedConfigBridge != null) {
            return unitedConfigBridge.getUpdateInterval();
        }
        return 360;
    }

    public final boolean isCdn(@NotNull String uin, @NotNull String group) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, (Object) uin, (Object) group)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(group, "group");
        UnitedConfigBridge unitedConfigBridge = this.bridge;
        if (unitedConfigBridge != null) {
            return unitedConfigBridge.isCdn(uin, group);
        }
        return false;
    }

    public final boolean isFetchMute(long current) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, current)).booleanValue();
        }
        UnitedConfigBridge unitedConfigBridge = this.bridge;
        if (unitedConfigBridge != null) {
            return unitedConfigBridge.isFetchMute(current);
        }
        return false;
    }

    public final boolean isIncFetchEnable(@NotNull String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this, (Object) uin)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        UnitedConfigBridge unitedConfigBridge = this.bridge;
        if (unitedConfigBridge != null) {
            return unitedConfigBridge.isIncFetchEnable(uin);
        }
        return false;
    }

    public final boolean isSwitchOn(@NotNull String uin, @NotNull String group, boolean fallback) {
        String str;
        KVBridgeWrapper kVBridge;
        String genKey;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, this, uin, group, Boolean.valueOf(fallback))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(group, "group");
        ConfigParser configParser = this.parserBridge.get(group);
        if (!getKeysNoLogin().contains(group) && (configParser == null || configParser.isAccountRelated())) {
            str = uin;
        } else {
            str = "000";
        }
        String genKey2 = genKey(String.valueOf(fallback), genKey(str, group, ""));
        Boolean e16 = this.switchCache.e(genKey2);
        if (e16 == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (isAccountIsolate()) {
                kVBridge = this.bridges.getKVBridge(str);
                genKey = genKey(group, KEY_SWITCH);
            } else {
                kVBridge = this.bridges.getKVBridge("-1");
                genKey = genKey(str, group, KEY_SWITCH);
            }
            Boolean valueOf = Boolean.valueOf(kVBridge.decodeBool(genKey, fallback));
            if (this.cacheInvalidateTime < elapsedRealtime) {
                this.switchCache.f(genKey2, valueOf);
            }
            e16 = valueOf;
        } else {
            reportLoad(uin, group);
        }
        return e16.booleanValue();
    }

    @Nullable
    public final IConfigData loadConfig(@NotNull String uin, @NotNull String group) {
        HashMap<String, String> hashMapOf;
        String stackTraceToString;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (IConfigData) iPatchRedirector.redirect((short) 12, (Object) this, (Object) uin, (Object) group);
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(group, "group");
        try {
            UnitedConfigBridge unitedConfigBridge = this.bridge;
            if (unitedConfigBridge != null) {
                return unitedConfigBridge.loadConfig(uin, group);
            }
            return null;
        } catch (RuntimeException e16) {
            ConfigParser configParser = this.parserBridge.get(group);
            if (configParser != null) {
                ILogger iLogger = LOGGER;
                if (iLogger != null) {
                    stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
                    iLogger.e(TAG, stackTraceToString);
                }
                if (!this.reported) {
                    this.reported = true;
                    BeaconBridge beaconBridge = this.bridges.getBeaconBridge();
                    hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("fun", "loadConfig"), TuplesKt.to("msg", e16.getMessage()));
                    beaconBridge.report("freesia_err", hashMapOf);
                }
                return configParser.defaultConfig();
            }
            throw e16;
        }
    }

    @Nullable
    public final IConfigData loadLargeConfig(@NotNull String uin, @NotNull String group) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (IConfigData) iPatchRedirector.redirect((short) 13, (Object) this, (Object) uin, (Object) group);
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(group, "group");
        UnitedConfigBridge unitedConfigBridge = this.bridge;
        if (unitedConfigBridge != null) {
            return unitedConfigBridge.loadLargeConfig(uin, group);
        }
        return null;
    }

    @NotNull
    public final byte[] loadLargeRawConfig(@NotNull String uin, @NotNull String group, @NotNull byte[] fallback) {
        byte[] loadLargeRawConfig;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (byte[]) iPatchRedirector.redirect((short) 15, this, uin, group, fallback);
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        UnitedConfigBridge unitedConfigBridge = this.bridge;
        if (unitedConfigBridge != null && (loadLargeRawConfig = unitedConfigBridge.loadLargeRawConfig(uin, group, fallback)) != null) {
            return loadLargeRawConfig;
        }
        return fallback;
    }

    @NotNull
    public final byte[] loadRawConfig(@NotNull String uin, @NotNull String group, @NotNull byte[] fallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (byte[]) iPatchRedirector.redirect((short) 14, this, uin, group, fallback);
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        if (this.bridge == null) {
            return fallback;
        }
        String genKey = genKey(uin, group, "");
        byte[] e16 = this.cache.e(genKey);
        if (e16 == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            byte[] loadRawConfig = this.bridge.loadRawConfig(uin, group, fallback);
            if (!Arrays.equals(loadRawConfig, fallback) && this.cacheInvalidateTime < elapsedRealtime) {
                this.cache.f(genKey, loadRawConfig);
            }
            return loadRawConfig;
        }
        reportLoad(uin, group);
        return e16;
    }

    public final void onAppForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        UnitedConfigBridge unitedConfigBridge = this.bridge;
        if (unitedConfigBridge != null) {
            unitedConfigBridge.onAppForeground();
        }
    }

    public final void removeCache$unitedconfig_android_release(@NotNull String uin, @NotNull String group) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) uin, (Object) group);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(group, "group");
        ConfigParser configParser = this.parserBridge.get(group);
        if (!getKeysNoLogin().contains(group) && (configParser == null || configParser.isAccountRelated())) {
            str = uin;
        } else {
            str = "000";
        }
        this.versionCache.remove(genKey(uin, group, ""));
        this.cache.g(genKey(uin, group, ""));
        this.switchCache.g(genKey("true", genKey(str, group, "")));
        this.switchCache.g(genKey("false", genKey(str, group, "")));
    }

    public final void removeLocal(@NotNull String uin, @NotNull String group) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) uin, (Object) group);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(group, "group");
        removeCache$unitedconfig_android_release(uin, group);
        UnitedConfigBridge unitedConfigBridge = this.bridge;
        if (unitedConfigBridge != null) {
            unitedConfigBridge.removeLocal(uin, group);
        }
    }

    public final void setEnv(boolean test) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, test);
            return;
        }
        UnitedConfigBridge unitedConfigBridge = this.bridge;
        if (unitedConfigBridge != null) {
            unitedConfigBridge.setEnv(test);
        }
    }

    public final void setIncFetch(boolean enable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, enable);
            return;
        }
        UnitedConfigBridge unitedConfigBridge = this.bridge;
        if (unitedConfigBridge != null) {
            unitedConfigBridge.setIncFetch(enable);
        }
    }

    public final void setLoadReportRate(int rate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, rate);
            return;
        }
        this.loadReportRate = rate;
        ReportBridge reportBridge = getReportBridge();
        if (reportBridge != null) {
            reportBridge.setLoadReportRate(rate);
        }
    }

    public final void setREPORT_BRIDGE(@Nullable ReportBridge reportBridge) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) reportBridge);
        } else {
            this.REPORT_BRIDGE = reportBridge;
        }
    }

    public final void updateCacheTime$unitedconfig_android_release(boolean hasRemove) {
        ILogger iLogger;
        StringBuilder sb5;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, hasRemove);
            return;
        }
        if (hasRemove) {
            iLogger = LOGGER;
            if (iLogger != null) {
                sb5 = new StringBuilder();
                str = "After removeCache versionCache:";
            } else {
                return;
            }
        } else {
            this.cacheInvalidateTime = SystemClock.elapsedRealtime();
            iLogger = LOGGER;
            if (iLogger != null) {
                sb5 = new StringBuilder();
                str = "Before removeCache versionCache:";
            } else {
                return;
            }
        }
        sb5.append(str);
        sb5.append(this.versionCache.size());
        sb5.append(", cacheSize:");
        sb5.append(this.cache.h());
        sb5.append(", switchCache:");
        sb5.append(this.switchCache.h());
        iLogger.d(TAG, sb5.toString());
    }

    private final String genKey(String uin, String group, String suffix) {
        return uin + "_" + group + "_" + suffix;
    }

    @JvmOverloads
    public final void fetch(@NotNull String uin, @NotNull ArrayList<String> groups, boolean callBackIfNotUpdate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, uin, groups, Boolean.valueOf(callBackIfNotUpdate));
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(groups, "groups");
        UnitedConfigBridge unitedConfigBridge = this.bridge;
        if (unitedConfigBridge != null) {
            unitedConfigBridge.fetchConfig(uin, groups, callBackIfNotUpdate);
        }
    }

    @JvmOverloads
    public final void fetchNoLogin(boolean callBackIfNotUpdate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, callBackIfNotUpdate);
            return;
        }
        UnitedConfigBridge unitedConfigBridge = this.bridge;
        if (unitedConfigBridge != null) {
            unitedConfigBridge.fetchNoLogin(callBackIfNotUpdate);
        }
    }

    @JvmOverloads
    public final void fetchSwitch(@NotNull String uin, @NotNull ArrayList<String> groups, boolean callBackIfNotUpdate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, uin, groups, Boolean.valueOf(callBackIfNotUpdate));
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(groups, "groups");
        UnitedConfigBridge unitedConfigBridge = this.bridge;
        if (unitedConfigBridge != null) {
            unitedConfigBridge.fetchSwitch(uin, groups, callBackIfNotUpdate);
        }
    }
}
