package com.tencent.mobileqq.qmmkv;

import android.os.Handler;
import android.os.Message;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.guardinterface.GuardManagerCallbackDispatcher;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.MMKVConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\t\b\u0002\u00a2\u0006\u0004\bM\u0010NJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\u0006\u0010\u0014\u001a\u00020\u0004J1\u0010\u001a\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001c\u0010\u001c\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010!\u001a\u00020\u0004H\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u001fH\u0016J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%H\u0016J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%H\u0016J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%H\u0016R\u0016\u0010+\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010*R\u0016\u0010-\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010,R\u0016\u0010.\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010*R\u0016\u0010/\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010*R\u0016\u00101\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010*R\u0016\u00103\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010*R\u0016\u00105\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010*R\u0016\u00108\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R&\u0010=\u001a\u0012\u0012\u0004\u0012\u00020\u001609j\b\u0012\u0004\u0012\u00020\u0016`:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R&\u0010?\u001a\u0012\u0012\u0004\u0012\u00020\u001609j\b\u0012\u0004\u0012\u00020\u0016`:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010<R&\u0010A\u001a\u0012\u0012\u0004\u0012\u00020\u001609j\b\u0012\u0004\u0012\u00020\u0016`:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010<R\u0016\u0010B\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010*R\u0016\u0010D\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010CR\"\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00070E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010K\u00a8\u0006O"}, d2 = {"Lcom/tencent/mobileqq/qmmkv/c;", "Lcom/tencent/mobileqq/qmmkv/j;", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "Landroid/os/Handler$Callback;", "", "i", "b", "", "countSize", "Lkotlin/Pair;", tl.h.F, "count", "size", "f", "g", "totalCount", "writeCount", "e", "a", "d", "c", "T", "", "mmapId", "key", "value", "onEncode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "onDecode", "Landroid/os/Message;", "msg", "", "handleMessage", "onApplicationForeground", "onApplicationBackground", "isEnabled", "onScreensStateChanged", "", "tick", "onBackgroundTimeTick", "onLiteTimeTick", "onBackgroundUnguardTimeTick", "I", AdMetricTag.Report.TYPE, "J", "gapTime", "countLimit", "avgSizeLimit", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "reportIgnoreSizeLimit", BdhLogUtil.LogTag.Tag_Conn, "timesSinceForeground", "D", "timesSinceStart", "E", "Z", "matchAll", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", UserInfo.SEX_FEMALE, "Ljava/util/HashSet;", "matchExactly", "G", "matchStart", "H", "matchEnd", "remainCheckTimes", "Ljava/lang/String;", "procName", "Ljava/util/concurrent/ConcurrentHashMap;", "K", "Ljava/util/concurrent/ConcurrentHashMap;", "map", "Landroid/os/Handler;", "L", "Landroid/os/Handler;", "handler", "<init>", "()V", "qq-injector-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c implements j, IGuardInterface, Handler.Callback {

    /* renamed from: C, reason: from kotlin metadata */
    private static int timesSinceForeground;

    /* renamed from: D, reason: from kotlin metadata */
    private static int timesSinceStart;

    /* renamed from: E, reason: from kotlin metadata */
    private static boolean matchAll;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private static HashSet<String> matchExactly;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private static HashSet<String> matchStart;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private static HashSet<String> matchEnd;

    /* renamed from: I, reason: from kotlin metadata */
    private static volatile int remainCheckTimes;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private static String procName;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private static ConcurrentHashMap<String, Integer> map;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private static final Handler handler;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final c f262004d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int reportType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static long gapTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static int countLimit;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static int avgSizeLimit;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static int reportIgnoreSizeLimit;

    static {
        c cVar = new c();
        f262004d = cVar;
        matchExactly = new HashSet<>();
        matchStart = new HashSet<>();
        matchEnd = new HashSet<>();
        procName = "";
        map = new ConcurrentHashMap<>();
        handler = new Handler(ThreadManagerV2.getQQCommonThreadLooper(), cVar);
    }

    c() {
    }

    private final void a() {
        List split$default;
        boolean z16;
        List split$default2;
        boolean z17;
        HashMap hashMap = new HashMap();
        try {
            hashMap.putAll(map);
            map = new ConcurrentHashMap<>();
        } catch (Throwable unused) {
        }
        remainCheckTimes--;
        if (QLog.isDevelopLevel()) {
            QLog.d("MMKVReport_FBW", 2, "doFbwCheck mapSize:" + hashMap.size() + " remainTimes:" + remainCheckTimes);
        }
        int i3 = 0;
        if (remainCheckTimes > 0) {
            handler.sendEmptyMessageDelayed(0, gapTime);
        } else {
            b();
        }
        int i16 = reportType;
        int i17 = 1;
        if (i16 == 2) {
            for (Map.Entry entry : hashMap.entrySet()) {
                int intValue = ((Number) entry.getValue()).intValue();
                c cVar = f262004d;
                Pair<Integer, Integer> h16 = cVar.h(intValue);
                int intValue2 = h16.component1().intValue();
                int intValue3 = h16.component2().intValue();
                if (intValue2 >= countLimit && intValue3 >= avgSizeLimit) {
                    try {
                        HashMap<String, String> hashMap2 = new HashMap<>();
                        split$default2 = StringsKt__StringsKt.split$default((CharSequence) entry.getKey(), new String[]{":"}, false, 0, 6, (Object) null);
                        String str = (String) split$default2.get(i3);
                        String str2 = (String) split$default2.get(i17);
                        hashMap2.put("mmapId", str);
                        hashMap2.put("key", str2);
                        hashMap2.put("count", String.valueOf(intValue2));
                        hashMap2.put("avgSize", String.valueOf(intValue3));
                        hashMap2.put("gapTime", String.valueOf(gapTime / 1000));
                        if (procName.length() == 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17) {
                            cVar.d();
                        }
                        hashMap2.put("proc", procName);
                        if (QLog.isDevelopLevel()) {
                            QLog.i("MMKVReport_FBW", 2, "actMMKVFBWReport:" + hashMap2 + " ");
                        }
                        n.f262021a.report("actMMKVFBWReport", hashMap2);
                    } catch (Throwable unused2) {
                    }
                }
                i3 = 0;
                i17 = 1;
            }
            return;
        }
        if (i16 == 1) {
            for (Map.Entry entry2 : hashMap.entrySet()) {
                int intValue4 = ((Number) entry2.getValue()).intValue();
                c cVar2 = f262004d;
                Pair<Integer, Integer> g16 = cVar2.g(intValue4);
                int intValue5 = g16.component1().intValue();
                int intValue6 = g16.component2().intValue();
                if (intValue5 >= countLimit) {
                    try {
                        HashMap<String, String> hashMap3 = new HashMap<>();
                        split$default = StringsKt__StringsKt.split$default((CharSequence) entry2.getKey(), new String[]{":"}, false, 0, 6, (Object) null);
                        String str3 = (String) split$default.get(0);
                        String str4 = (String) split$default.get(1);
                        hashMap3.put("mmapId", str3);
                        hashMap3.put("key", str4);
                        hashMap3.put("count", String.valueOf(intValue5));
                        hashMap3.put("writeCount", String.valueOf(intValue6));
                        try {
                            hashMap3.put("gapTime", String.valueOf(gapTime / 1000));
                            if (procName.length() == 0) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (z16) {
                                cVar2.d();
                            }
                            hashMap3.put("proc", procName);
                            if (QLog.isDevelopLevel()) {
                                try {
                                    QLog.i("MMKVReport_FBW", 2, "actMMKVFreqAccessReport:" + hashMap3 + " ");
                                } catch (Throwable unused3) {
                                }
                            }
                            n.f262021a.report("actMMKVFreqAccessReport", hashMap3);
                        } catch (Throwable unused4) {
                        }
                    } catch (Throwable unused5) {
                    }
                }
            }
        }
    }

    private final void b() {
        remainCheckTimes = 0;
        if (QLog.isDevelopLevel()) {
            QLog.d("MMKVReport_FBW", 2, "endMonitor");
        }
        QMMKV.encodeMonitorOn = false;
        QMMKV.decodeMonitorOn = false;
        handler.removeMessages(0);
        y.INSTANCE.m(null);
    }

    private final void d() {
        String suffix;
        String suffix2;
        String suffix3 = MobileQQ.processName;
        Intrinsics.checkNotNullExpressionValue(suffix3, "suffix");
        boolean z16 = true;
        suffix = StringsKt__StringsJVMKt.replace(suffix3, "com.tencent.mobileqq", "", true);
        Intrinsics.checkNotNullExpressionValue(suffix, "suffix");
        suffix2 = StringsKt__StringsJVMKt.replace$default(suffix, ":", "", false, 4, (Object) null);
        Intrinsics.checkNotNullExpressionValue(suffix2, "suffix");
        if (suffix2.length() != 0) {
            z16 = false;
        }
        if (z16) {
            suffix2 = "QQ";
        }
        Intrinsics.checkNotNullExpressionValue(suffix2, "suffix");
        procName = suffix2;
    }

    private final int e(int totalCount, int writeCount) {
        return (totalCount << 16) | (writeCount & 65535);
    }

    private final int f(int count, int size) {
        return (count << 24) | (size & 16777215);
    }

    private final Pair<Integer, Integer> g(int count) {
        return new Pair<>(Integer.valueOf((count >>> 16) & 65535), Integer.valueOf(count & 65535));
    }

    private final Pair<Integer, Integer> h(int countSize) {
        return new Pair<>(Integer.valueOf((countSize >>> 24) & 255), Integer.valueOf(countSize & 16777215));
    }

    private final void i() {
        if (QLog.isDevelopLevel()) {
            QLog.d("MMKVReport_FBW", 2, "startMonitor");
        }
        if (reportType == 1) {
            QMMKV.encodeMonitorOn = true;
            QMMKV.decodeMonitorOn = true;
        } else {
            QMMKV.encodeMonitorOn = true;
        }
        y.INSTANCE.m(this);
        Handler handler2 = handler;
        if (!handler2.hasMessages(0)) {
            handler2.sendEmptyMessageDelayed(0, gapTime);
        }
    }

    public final void c() {
        int i3;
        MMKVConfig.b freqBigDataConfig;
        boolean startsWith$default;
        boolean endsWith$default;
        MMKVConfig a16 = MMKVConfig.INSTANCE.a();
        if (a16.getFreqAccessSwitchOn()) {
            i3 = 1;
        } else if (a16.getFreqWriteBigDataSwitchOn()) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        reportType = i3;
        if (i3 == 0) {
            QLog.d("MMKVReport_FBW", 1, "init reportType no need to report return.");
            return;
        }
        if (a16.getFreqAccessSwitchOn()) {
            freqBigDataConfig = a16.getFreqAccessConfig();
        } else {
            freqBigDataConfig = a16.getFreqBigDataConfig();
        }
        gapTime = freqBigDataConfig.getTimeGap() * 1000;
        countLimit = freqBigDataConfig.getReportCountLimit();
        avgSizeLimit = freqBigDataConfig.getReportAvgSizeLimit();
        reportIgnoreSizeLimit = freqBigDataConfig.getReportIgnoreSizeLimit();
        timesSinceForeground = freqBigDataConfig.getTimesSinceForeground();
        timesSinceStart = freqBigDataConfig.getTimesSinceStart();
        if (gapTime > 0 && countLimit > 0) {
            if (freqBigDataConfig.c().isEmpty()) {
                matchAll = true;
            } else {
                for (String str : freqBigDataConfig.c()) {
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "*", false, 2, null);
                    if (!startsWith$default) {
                        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str, "*", false, 2, null);
                        if (endsWith$default) {
                            HashSet<String> hashSet = matchStart;
                            String substring = str.substring(0, str.length() - 1);
                            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                            hashSet.add(substring);
                        } else {
                            matchExactly.add(str);
                        }
                    } else {
                        HashSet<String> hashSet2 = matchEnd;
                        String substring2 = str.substring(1);
                        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                        hashSet2.add(substring2);
                    }
                }
            }
            QLog.d("MMKVReport_FBW", 1, "init reportType:" + reportType + " matchExactly:" + matchExactly + " matchStart:" + matchStart + " matchEnd:" + matchEnd);
            int i16 = timesSinceStart;
            if (i16 > 0) {
                remainCheckTimes = i16;
                i();
            }
            if (timesSinceForeground > 0) {
                GuardManagerCallbackDispatcher.registerCallBack(this);
                return;
            }
            return;
        }
        QLog.d("MMKVReport_FBW", 1, "init invalid gapTime|countLimit return.");
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.what == 0) {
            a();
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationBackground() {
        if (remainCheckTimes > 0) {
            if (QLog.isDevelopLevel()) {
                QLog.d("MMKVReport_FBW", 2, "onApplicationBackground " + remainCheckTimes);
            }
            b();
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationForeground() {
        if (timesSinceForeground > remainCheckTimes) {
            if (QLog.isDevelopLevel()) {
                QLog.d("MMKVReport_FBW", 2, "onApplicationForeground " + timesSinceForeground + " > " + remainCheckTimes);
            }
            remainCheckTimes = timesSinceForeground;
            i();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0085, code lost:
    
        if (r2 != false) goto L7;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00ae A[Catch: all -> 0x00e1, TryCatch #0 {all -> 0x00e1, blocks: (B:11:0x00a4, B:13:0x00ae, B:14:0x00dc, B:17:0x00b7), top: B:10:0x00a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00b7 A[Catch: all -> 0x00e1, TryCatch #0 {all -> 0x00e1, blocks: (B:11:0x00a4, B:13:0x00ae, B:14:0x00dc, B:17:0x00b7), top: B:10:0x00a4 }] */
    @Override // com.tencent.mobileqq.qmmkv.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onDecode(@Nullable String mmapId, @Nullable String key) {
        boolean z16;
        boolean startsWith$default;
        boolean z17;
        boolean endsWith$default;
        boolean z18;
        boolean z19;
        Integer num;
        Integer valueOf;
        if (mmapId != null) {
            if (!matchAll) {
                HashSet<String> hashSet = matchExactly;
                if (!(hashSet instanceof Collection) || !hashSet.isEmpty()) {
                    Iterator<T> it = hashSet.iterator();
                    while (it.hasNext()) {
                        if (Intrinsics.areEqual((String) it.next(), mmapId)) {
                            z16 = true;
                            break;
                        }
                    }
                }
                z16 = false;
                if (!z16) {
                    HashSet<String> hashSet2 = matchStart;
                    if (!(hashSet2 instanceof Collection) || !hashSet2.isEmpty()) {
                        Iterator<T> it5 = hashSet2.iterator();
                        while (it5.hasNext()) {
                            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(mmapId, (String) it5.next(), false, 2, null);
                            if (startsWith$default) {
                                z17 = true;
                                break;
                            }
                        }
                    }
                    z17 = false;
                    if (!z17) {
                        HashSet<String> hashSet3 = matchEnd;
                        if (!(hashSet3 instanceof Collection) || !hashSet3.isEmpty()) {
                            Iterator<T> it6 = hashSet3.iterator();
                            while (it6.hasNext()) {
                                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(mmapId, (String) it6.next(), false, 2, null);
                                if (endsWith$default) {
                                    z18 = true;
                                    break;
                                }
                            }
                        }
                        z18 = false;
                    }
                }
            }
            z19 = true;
            if (!z19 && reportType == 1) {
                String str = mmapId + ":" + key;
                try {
                    num = map.get(str);
                    if (num != null) {
                        valueOf = Integer.valueOf(e(1, 0));
                    } else {
                        Pair<Integer, Integer> g16 = g(num.intValue());
                        valueOf = Integer.valueOf(e(g16.component1().intValue() + 1, g16.component2().intValue()));
                    }
                    map.put(str, valueOf);
                } catch (Throwable unused) {
                    return;
                }
            }
            return;
        }
        z19 = false;
        if (!z19) {
            return;
        }
        String str2 = mmapId + ":" + key;
        num = map.get(str2);
        if (num != null) {
        }
        map.put(str2, valueOf);
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0085, code lost:
    
        if (r3 != false) goto L7;
     */
    /* JADX WARN: Removed duplicated region for block: B:5:0x008a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x008b  */
    @Override // com.tencent.mobileqq.qmmkv.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> void onEncode(@Nullable String mmapId, @Nullable String key, T value) {
        boolean z16;
        boolean startsWith$default;
        boolean z17;
        boolean endsWith$default;
        boolean z18;
        boolean z19;
        Integer valueOf;
        int b16;
        Integer valueOf2;
        if (mmapId != null) {
            if (!matchAll) {
                HashSet<String> hashSet = matchExactly;
                if (!(hashSet instanceof Collection) || !hashSet.isEmpty()) {
                    Iterator<T> it = hashSet.iterator();
                    while (it.hasNext()) {
                        if (Intrinsics.areEqual((String) it.next(), mmapId)) {
                            z16 = true;
                            break;
                        }
                    }
                }
                z16 = false;
                if (!z16) {
                    HashSet<String> hashSet2 = matchStart;
                    if (!(hashSet2 instanceof Collection) || !hashSet2.isEmpty()) {
                        Iterator<T> it5 = hashSet2.iterator();
                        while (it5.hasNext()) {
                            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(mmapId, (String) it5.next(), false, 2, null);
                            if (startsWith$default) {
                                z17 = true;
                                break;
                            }
                        }
                    }
                    z17 = false;
                    if (!z17) {
                        HashSet<String> hashSet3 = matchEnd;
                        if (!(hashSet3 instanceof Collection) || !hashSet3.isEmpty()) {
                            Iterator<T> it6 = hashSet3.iterator();
                            while (it6.hasNext()) {
                                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(mmapId, (String) it6.next(), false, 2, null);
                                if (endsWith$default) {
                                    z18 = true;
                                    break;
                                }
                            }
                        }
                        z18 = false;
                    }
                }
            }
            z19 = true;
            if (z19) {
                return;
            }
            int i3 = reportType;
            try {
                if (i3 == 2) {
                    if (value == null || (b16 = y.INSTANCE.b(value)) < reportIgnoreSizeLimit) {
                        return;
                    }
                    String str = mmapId + ":" + key;
                    Integer num = map.get(str);
                    if (num == null) {
                        valueOf2 = Integer.valueOf(f(1, b16));
                    } else {
                        Pair<Integer, Integer> h16 = h(num.intValue());
                        int intValue = h16.component1().intValue();
                        int i16 = intValue + 1;
                        valueOf2 = Integer.valueOf(f(i16, ((h16.component2().intValue() * intValue) + b16) / i16));
                    }
                    map.put(str, valueOf2);
                    return;
                }
                if (i3 == 1) {
                    String str2 = mmapId + ":" + key;
                    Integer num2 = map.get(str2);
                    if (num2 == null) {
                        valueOf = Integer.valueOf(e(0, 1));
                    } else {
                        Pair<Integer, Integer> g16 = g(num2.intValue());
                        valueOf = Integer.valueOf(e(g16.component1().intValue() + 1, g16.component2().intValue() + 1));
                    }
                    map.put(str2, valueOf);
                    return;
                }
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        z19 = false;
        if (z19) {
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundTimeTick(long tick) {
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundUnguardTimeTick(long tick) {
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onLiteTimeTick(long tick) {
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onScreensStateChanged(boolean isEnabled) {
    }
}
