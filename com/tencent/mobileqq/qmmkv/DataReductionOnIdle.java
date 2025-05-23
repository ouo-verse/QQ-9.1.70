package com.tencent.mobileqq.qmmkv;

import android.os.SystemClock;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.guardinterface.GuardManagerCallbackDispatcher;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mmkv.api.IMMKVPerfApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import cooperation.qzone.util.QZoneImageUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010!\n\u0002\b3\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bk\u0010lJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\b\u001a\u00020\u00022\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u0004H\u0002J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0002J4\u0010\u0013\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\tH\u0002J\u001e\u0010\u0017\u001a\u00020\u00162\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u001e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0002J\u0018\u0010\u001b\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J6\u0010$\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020!2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0002J\u0018\u0010'\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u001cH\u0002J\u0006\u0010(\u001a\u00020\u0002J\b\u0010)\u001a\u00020\u0002H\u0016J\b\u0010*\u001a\u00020\u0002H\u0016J\u0010\u0010,\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u0016H\u0016J\u0010\u0010-\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010.\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010/\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0016R)\u00103\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u00100\u001a\u0004\b1\u00102R\u001d\u00109\u001a\b\u0012\u0004\u0012\u00020\u0011048\u0006\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\"\u0010@\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010F\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010M\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010T\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010X\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010O\u001a\u0004\bV\u0010Q\"\u0004\bW\u0010SR\"\u0010\\\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u0010;\u001a\u0004\bZ\u0010=\"\u0004\b[\u0010?R\"\u0010`\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b]\u0010H\u001a\u0004\b^\u0010J\"\u0004\b_\u0010LR\"\u0010d\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\ba\u0010;\u001a\u0004\bb\u0010=\"\u0004\bc\u0010?R\u001b\u0010g\u001a\u00020\u00168FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\be\u0010f\u001a\u0004\b:\u0010=R\u001b\u0010j\u001a\u00020h8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bO\u0010f\u001a\u0004\b5\u0010i\u00a8\u0006m"}, d2 = {"Lcom/tencent/mobileqq/qmmkv/DataReductionOnIdle;", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "", "c", "", "", "", "map", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "matches", "Lkotlin/text/Regex;", "e", "mmapId", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "kv", "keyMatches", "Lcom/tencent/mobileqq/qmmkv/z;", "cbs", "d", "regexes", "key", "", DomainData.DOMAIN_NAME, "matchSet", "p", QZoneImageUtils.KEY_MATCH, "o", "", "tick", "r", "beforeSize", "afterSize", "", "deleteCount", "matchesToReduce", "t", "complete", QCircleWeakNetReporter.KEY_COST, "u", "l", "onApplicationForeground", "onApplicationBackground", "isEnabled", "onScreensStateChanged", "onBackgroundTimeTick", "onLiteTimeTick", "onBackgroundUnguardTimeTick", "Ljava/util/Map;", "getMatchMap", "()Ljava/util/Map;", "matchMap", "", "f", "Ljava/util/List;", "getCallbacks", "()Ljava/util/List;", "callbacks", tl.h.F, "Z", "i", "()Z", HippyTKDListViewAdapter.X, "(Z)V", "needSuicideWhenChange", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "w", "(Ljava/lang/String;)V", "keyPrefixForMark", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "J", "getDelayMs", "()J", "v", "(J)V", "delayMs", BdhLogUtil.LogTag.Tag_Conn, "I", "k", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(I)V", "timeStart", "D", "j", "y", "timeEnd", "E", "getCheckReducedCompletely", "setCheckReducedCompletely", "checkReducedCompletely", UserInfo.SEX_FEMALE, "getBackgroundTs", "setBackgroundTs", "backgroundTs", "G", "getHasChanged", "setHasChanged", "hasChanged", "H", "Lkotlin/Lazy;", "mmkvDataReduceOnIdleSwitch", "Ljava/util/Calendar;", "()Ljava/util/Calendar;", "calender", "<init>", "()V", "qq-injector-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class DataReductionOnIdle implements IGuardInterface {

    /* renamed from: E, reason: from kotlin metadata */
    private static volatile boolean checkReducedCompletely;

    /* renamed from: F, reason: from kotlin metadata */
    private static volatile long backgroundTs;

    /* renamed from: G, reason: from kotlin metadata */
    private static volatile boolean hasChanged;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private static final Lazy mmkvDataReduceOnIdleSwitch;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private static final Lazy calender;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static boolean needSuicideWhenChange;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static long delayMs;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final DataReductionOnIdle f261944d = new DataReductionOnIdle();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, Set<String>> matchMap = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<z> callbacks = new ArrayList();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String keyPrefixForMark = "mmkv_reduce_9015_${regex}_[${magic}]";

    /* renamed from: C, reason: from kotlin metadata */
    private static int timeStart = 3;

    /* renamed from: D, reason: from kotlin metadata */
    private static int timeEnd = 5;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.qmmkv.DataReductionOnIdle$mmkvDataReduceOnIdleSwitch$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                String replace$default;
                MMKVReduceConfig a16 = MMKVReduceConfig.INSTANCE.a();
                boolean switchOn = a16.getSwitchOn();
                DataReductionOnIdle dataReductionOnIdle = DataReductionOnIdle.f261944d;
                dataReductionOnIdle.x(a16.getNeedSuicide());
                dataReductionOnIdle.v(a16.getDelayMs());
                dataReductionOnIdle.z(a16.getTimeStart());
                dataReductionOnIdle.y(a16.getTimeEnd());
                replace$default = StringsKt__StringsJVMKt.replace$default("mmkv_reduce_9015_${regex}_[${magic}]", "${magic}", String.valueOf(a16.getMagicNumber()), false, 4, (Object) null);
                dataReductionOnIdle.w(replace$default);
                QLog.d("MMKVReduce_OnIdle", 1, "init switch:" + switchOn + " needSuicide:" + dataReductionOnIdle.i() + " time: [" + dataReductionOnIdle.k() + ", " + dataReductionOnIdle.j() + "] mark: " + dataReductionOnIdle.g());
                return Boolean.valueOf(switchOn);
            }
        });
        mmkvDataReduceOnIdleSwitch = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Calendar>() { // from class: com.tencent.mobileqq.qmmkv.DataReductionOnIdle$calender$2
            @Override // kotlin.jvm.functions.Function0
            public final Calendar invoke() {
                return Calendar.getInstance();
            }
        });
        calender = lazy2;
    }

    DataReductionOnIdle() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void c() {
        int mapCapacity;
        MMKVOptionEntity mMKVOptionEntity;
        Set mutableSet;
        QLog.d("MMKVReduce_OnIdle", 1, "checkAndReduce...");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        Map<String, Set<String>> map = matchMap;
        synchronized (map) {
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(map.size());
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(mapCapacity);
            for (Object obj : map.entrySet()) {
                Object key = ((Map.Entry) obj).getKey();
                mutableSet = CollectionsKt___CollectionsKt.toMutableSet((Iterable) ((Map.Entry) obj).getValue());
                linkedHashMap2.put(key, mutableSet);
            }
            linkedHashMap.putAll(linkedHashMap2);
            arrayList.addAll(callbacks);
        }
        try {
            q(linkedHashMap);
        } catch (Exception unused) {
        }
        for (Map.Entry<String, Set<String>> entry : linkedHashMap.entrySet()) {
            String key2 = entry.getKey();
            Set<String> value = entry.getValue();
            if (backgroundTs == 0) {
                QLog.w("MMKVReduce_OnIdle", 1, "checkAndReduce break, foreground now.");
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = value.iterator();
            while (true) {
                mMKVOptionEntity = null;
                if (!it.hasNext()) {
                    break;
                }
                String str = (String) it.next();
                if (!f261944d.o(key2, str)) {
                    mMKVOptionEntity = str;
                }
                if (mMKVOptionEntity != null) {
                    arrayList2.add(mMKVOptionEntity);
                }
            }
            if (arrayList2.isEmpty()) {
                QLog.i("MMKVReduce_OnIdle", 1, "checkAndReduce no keyMatches for [" + key2 + "] continue.");
            } else {
                try {
                    mMKVOptionEntity = QMMKV.from(MobileQQ.sMobileQQ, key2);
                } catch (Throwable unused2) {
                }
                if (mMKVOptionEntity != null) {
                    d(key2, mMKVOptionEntity, arrayList2, arrayList);
                }
            }
        }
    }

    private final void d(String mmapId, MMKVOptionEntity kv5, List<String> keyMatches, List<? extends z> cbs) {
        List<String> list;
        String[] allKeyArr;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        long j3 = kv5.totalSize();
        if (j3 >= MMKVReduceConfig.INSTANCE.a().getReduceFileSizeLimit()) {
            try {
                List<Regex> e16 = e(keyMatches);
                if ((!e16.isEmpty()) && (allKeyArr = kv5.allKeyArr()) != null) {
                    for (String key : allKeyArr) {
                        DataReductionOnIdle dataReductionOnIdle = f261944d;
                        Intrinsics.checkNotNullExpressionValue(key, "key");
                        if (dataReductionOnIdle.n(e16, key)) {
                            linkedHashSet.add(key);
                        }
                    }
                }
                if (linkedHashSet.size() > 0) {
                    hasChanged = true;
                    List<? extends z> list2 = cbs;
                    Iterator<T> it = list2.iterator();
                    while (it.hasNext()) {
                        try {
                            ((z) it.next()).a(mmapId, keyMatches);
                        } catch (Exception e17) {
                            QLog.w("MMKVReduce_OnIdle", 1, "onBeforeReduce exception for[" + mmapId + "] " + e17.getMessage() + " ", e17);
                        }
                    }
                    list = CollectionsKt___CollectionsKt.toList(linkedHashSet);
                    kv5.removeKeyList(list);
                    p(mmapId, keyMatches);
                    Iterator<T> it5 = list2.iterator();
                    while (it5.hasNext()) {
                        try {
                            ((z) it5.next()).b(mmapId, keyMatches);
                        } catch (Exception e18) {
                            QLog.w("MMKVReduce_OnIdle", 1, "onBeforeReduce exception for[" + mmapId + "] " + e18.getMessage() + " ", e18);
                        }
                    }
                    kv5.trim();
                    t(mmapId, j3, kv5.totalSize(), linkedHashSet.size(), keyMatches);
                }
            } catch (Exception e19) {
                QLog.w("MMKVReduce_OnIdle", 1, "isKeyMatch exception for[" + mmapId + "] " + e19.getMessage() + " ", e19);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("MMKVReduce_OnIdle", 1, "doReduce " + mmapId + " match:" + keyMatches + " removeKeyCount:" + linkedHashSet.size());
        }
    }

    private final List<Regex> e(List<String> matches) {
        String str;
        boolean z16;
        List mutableList;
        ArrayList arrayList;
        int collectionSizeOrDefault;
        String replace$default;
        List mutableList2;
        int collectionSizeOrDefault2;
        ArrayList arrayList2;
        String replace$default2;
        int collectionSizeOrDefault3;
        int collectionSizeOrDefault4;
        String replace$default3;
        String replace$default4;
        String replace$default5;
        int collectionSizeOrDefault5;
        String replace$default6;
        String replace$default7;
        String replace$default8;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str2 = null;
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getAccount();
        } else {
            str = null;
        }
        String str3 = "";
        if (str == null) {
            str = "";
        }
        AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime2 != null) {
            str2 = peekAppRuntime2.getCurrentUid();
        }
        if (str2 != null) {
            str3 = str2;
        }
        boolean z17 = true;
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) matches);
            CollectionsKt__MutableCollectionsKt.removeAll(mutableList, (Function1) new Function1<String, Boolean>() { // from class: com.tencent.mobileqq.qmmkv.DataReductionOnIdle$generateRegex$list$2
                /* JADX WARN: Code restructure failed: missing block: B:4:0x0019, code lost:
                
                    if (r5 != false) goto L6;
                 */
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Boolean invoke(@NotNull String it) {
                    boolean contains$default;
                    boolean contains$default2;
                    Intrinsics.checkNotNullParameter(it, "it");
                    boolean z18 = false;
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) it, (CharSequence) "${selfuin}", false, 2, (Object) null);
                    if (!contains$default) {
                        contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) it, (CharSequence) "${notselfuin}", false, 2, (Object) null);
                    }
                    z18 = true;
                    return Boolean.valueOf(z18);
                }
            });
            List list = mutableList;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                replace$default = StringsKt__StringsJVMKt.replace$default((String) it.next(), "${uin}", "\\d{5,11}", false, 4, (Object) null);
                arrayList.add(replace$default);
            }
        } else {
            List<String> list2 = matches;
            collectionSizeOrDefault5 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            arrayList = new ArrayList(collectionSizeOrDefault5);
            Iterator<T> it5 = list2.iterator();
            while (it5.hasNext()) {
                replace$default6 = StringsKt__StringsJVMKt.replace$default((String) it5.next(), "${selfuin}", str, false, 4, (Object) null);
                replace$default7 = StringsKt__StringsJVMKt.replace$default(replace$default6, "${notselfuin}", "(?:(?!" + str + ")\\d{5,11})", false, 4, (Object) null);
                replace$default8 = StringsKt__StringsJVMKt.replace$default(replace$default7, "${uin}", "\\d{5,11}", false, 4, (Object) null);
                arrayList.add(replace$default8);
            }
        }
        if (str3.length() <= 0) {
            z17 = false;
        }
        if (z17) {
            collectionSizeOrDefault4 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            arrayList2 = new ArrayList(collectionSizeOrDefault4);
            Iterator it6 = arrayList.iterator();
            while (it6.hasNext()) {
                replace$default3 = StringsKt__StringsJVMKt.replace$default((String) it6.next(), "${selfuid}", str3, false, 4, (Object) null);
                replace$default4 = StringsKt__StringsJVMKt.replace$default(replace$default3, "${notselfuid}", "(?:(?!" + str3 + ")u_([A-Za-z0-9_\\-]{22}))", false, 4, (Object) null);
                replace$default5 = StringsKt__StringsJVMKt.replace$default(replace$default4, "${uid}", "u_([A-Za-z0-9_\\\\-]{22})", false, 4, (Object) null);
                arrayList2.add(replace$default5);
            }
        } else {
            mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
            CollectionsKt__MutableCollectionsKt.removeAll(mutableList2, (Function1) new Function1<String, Boolean>() { // from class: com.tencent.mobileqq.qmmkv.DataReductionOnIdle$generateRegex$2
                /* JADX WARN: Code restructure failed: missing block: B:4:0x0019, code lost:
                
                    if (r5 != false) goto L6;
                 */
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Boolean invoke(@NotNull String it7) {
                    boolean contains$default;
                    boolean contains$default2;
                    Intrinsics.checkNotNullParameter(it7, "it");
                    boolean z18 = false;
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) it7, (CharSequence) "${selfuid}", false, 2, (Object) null);
                    if (!contains$default) {
                        contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) it7, (CharSequence) "${notselfuid}", false, 2, (Object) null);
                    }
                    z18 = true;
                    return Boolean.valueOf(z18);
                }
            });
            List list3 = mutableList2;
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
            Iterator it7 = list3.iterator();
            while (it7.hasNext()) {
                replace$default2 = StringsKt__StringsJVMKt.replace$default((String) it7.next(), "${uid}", "u_([A-Za-z0-9_\\\\-]{22})", false, 4, (Object) null);
                arrayList3.add(replace$default2);
            }
            arrayList2 = arrayList3;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MMKVReduce_OnIdle", 2, "generateRegex before: " + matches + " after: " + arrayList2);
        }
        collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault3);
        Iterator it8 = arrayList2.iterator();
        while (it8.hasNext()) {
            arrayList4.add(new Regex((String) it8.next()));
        }
        return arrayList4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(DataReductionOnIdle this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (f261944d.h()) {
            GuardManagerCallbackDispatcher.registerCallBack(this$0);
        }
    }

    private final boolean n(List<Regex> regexes, String key) {
        boolean z16 = true;
        try {
            List<Regex> list = regexes;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (((Regex) it.next()).matches(key)) {
                        break;
                    }
                }
            }
            z16 = false;
            return z16;
        } catch (Exception e16) {
            QLog.w("MMKVReduce_OnIdle", 1, "isKeyMatch exception for[" + key + "] " + e16.getMessage() + " ", e16);
            return false;
        }
    }

    private final boolean o(String mmapId, String match) {
        String replace$default;
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), mmapId);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.getContext(), mmapId)");
        replace$default = StringsKt__StringsJVMKt.replace$default(keyPrefixForMark, "${regex}", match, false, 4, (Object) null);
        return from.decodeBool(replace$default, false);
    }

    private final void p(String mmapId, List<String> matchSet) {
        String replace$default;
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), mmapId);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.getContext(), mmapId)");
        Iterator<T> it = matchSet.iterator();
        while (it.hasNext()) {
            replace$default = StringsKt__StringsJVMKt.replace$default(keyPrefixForMark, "${regex}", (String) it.next(), false, 4, (Object) null);
            from.encodeBool(replace$default, true);
        }
    }

    private final void q(Map<String, Set<String>> map) {
        Set set;
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            Set<String> value = entry.getValue();
            List<String> list = MMKVReduceConfig.INSTANCE.a().l().get(key);
            if (list != null) {
                set = CollectionsKt___CollectionsKt.toSet(list);
                value.retainAll(set);
            }
        }
        for (Map.Entry<String, List<String>> entry2 : MMKVReduceConfig.INSTANCE.a().c().entrySet()) {
            String key2 = entry2.getKey();
            List<String> value2 = entry2.getValue();
            Set<String> set2 = map.get(key2);
            if (set2 == null) {
                set2 = new LinkedHashSet<>();
                map.put(key2, set2);
            }
            set2.addAll(value2);
        }
        for (Map.Entry<String, Set<String>> entry3 : map.entrySet()) {
            String key3 = entry3.getKey();
            Set<String> value3 = entry3.getValue();
            if (QLog.isColorLevel()) {
                QLog.i("MMKVReduce_OnIdle", 1, "mergeKeyMapWithConfig [" + key3 + "] after matchSet:" + value3);
            }
        }
    }

    private final void r(long tick) {
        if (h() && !checkReducedCompletely && SystemClock.elapsedRealtime() - backgroundTs >= delayMs) {
            int i3 = f().get(11);
            if (QLog.isDevelopLevel()) {
                QLog.d("MMKVReduce_OnIdle", 4, "onBackgroundTimeTick tick:" + tick + " curHour:" + i3 + " [" + timeStart + ", " + timeEnd + "] switch:" + h());
            }
            if (i3 >= timeStart && i3 <= timeEnd) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qmmkv.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        DataReductionOnIdle.s();
                    }
                }, 16, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s() {
        boolean z16;
        boolean z17;
        if (backgroundTs > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("MMKVReduce_OnIdle", 1, "prepare to checkAndReduce stillInBackground:" + z16);
        if (backgroundTs == 0) {
            return;
        }
        Boolean isAVChatting = ((IMMKVPerfApi) QRoute.api(IMMKVPerfApi.class)).isAVChatting();
        Intrinsics.checkNotNullExpressionValue(isAVChatting, "api(IMMKVPerfApi::class.java).isAVChatting");
        if (isAVChatting.booleanValue()) {
            QLog.d("MMKVReduce_OnIdle", 1, "AV chatting return.");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        DataReductionOnIdle dataReductionOnIdle = f261944d;
        dataReductionOnIdle.c();
        if (backgroundTs > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        checkReducedCompletely = z17;
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        QLog.i("MMKVReduce_OnIdle", 1, "checkAndReduce cost:" + currentTimeMillis2 + " ms completed:" + checkReducedCompletely);
        if (checkReducedCompletely) {
            Map<String, Set<String>> map = matchMap;
            synchronized (map) {
                map.clear();
                callbacks.clear();
                Unit unit = Unit.INSTANCE;
            }
        }
        if (hasChanged) {
            dataReductionOnIdle.u(checkReducedCompletely, currentTimeMillis2);
        }
        if (checkReducedCompletely && needSuicideWhenChange && hasChanged) {
            QLog.w("MMKVReduce_OnIdle", 1, "suicide after reduce!!!");
            com.tencent.mobileqq.perf.process.util.b.f257946a.e();
            hasChanged = false;
        }
    }

    private final void t(String mmapId, long beforeSize, long afterSize, int deleteCount, List<String> matchesToReduce) {
        String joinToString$default;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("beforeSize", String.valueOf(beforeSize));
        hashMap.put("afterSize", String.valueOf(afterSize));
        hashMap.put("delCount", String.valueOf(deleteCount));
        hashMap.put("mmapId", mmapId);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(matchesToReduce, null, null, null, 0, null, null, 63, null);
        hashMap.put("matches", joinToString$default);
        hashMap.put("count", String.valueOf(matchesToReduce.size()));
        StatisticCollector.getInstance(BaseApplication.context).collectPerformance(null, "actMMKVReduceDataReport", true, 0L, 0L, hashMap, "");
    }

    private final void u(boolean complete, long cost) {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        if (complete) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("complete", str);
        hashMap.put(QCircleWeakNetReporter.KEY_COST, String.valueOf(cost));
        StatisticCollector.getInstance(BaseApplication.context).collectPerformance(null, "actMMKVReduceStateReport", true, 0L, 0L, hashMap, "");
    }

    @NotNull
    public final Calendar f() {
        Object value = calender.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-calender>(...)");
        return (Calendar) value;
    }

    @NotNull
    public final String g() {
        return keyPrefixForMark;
    }

    public final boolean h() {
        return ((Boolean) mmkvDataReduceOnIdleSwitch.getValue()).booleanValue();
    }

    public final boolean i() {
        return needSuicideWhenChange;
    }

    public final int j() {
        return timeEnd;
    }

    public final int k() {
        return timeStart;
    }

    public final void l() {
        if (MobileQQ.sProcessId != 1) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qmmkv.a
            @Override // java.lang.Runnable
            public final void run() {
                DataReductionOnIdle.m(DataReductionOnIdle.this);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationBackground() {
        if (QLog.isColorLevel()) {
            QLog.d("MMKVReduce_OnIdle", 2, "onApplicationBackground");
        }
        backgroundTs = SystemClock.elapsedRealtime();
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationForeground() {
        if (QLog.isColorLevel()) {
            QLog.d("MMKVReduce_OnIdle", 2, "onApplicationForeground");
        }
        checkReducedCompletely = false;
        backgroundTs = 0L;
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundTimeTick(long tick) {
        r(tick);
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundUnguardTimeTick(long tick) {
        r(tick);
    }

    public final void v(long j3) {
        delayMs = j3;
    }

    public final void w(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        keyPrefixForMark = str;
    }

    public final void x(boolean z16) {
        needSuicideWhenChange = z16;
    }

    public final void y(int i3) {
        timeEnd = i3;
    }

    public final void z(int i3) {
        timeStart = i3;
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onLiteTimeTick(long tick) {
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onScreensStateChanged(boolean isEnabled) {
    }
}
