package com.tencent.mobileqq.app.friendlist;

import com.tencent.mobileqq.app.msgcache.CacheConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.trace.NTTraceManager;
import com.tencent.qqnt.trace.l;
import com.tencent.qqnt.trace.m;
import com.tencent.qqnt.trace.n;
import com.tencent.qqnt.trace.o;
import com.tencent.qqnt.trace.q;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J,\u0010\u0007\u001a\u00020\u00062\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0003H\u0002J*\u0010\u000b\u001a\u00020\u00062\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004R\u0016\u0010\r\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\fR$\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/app/friendlist/c;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "param", "", "c", "key", "", "a", "b", "Z", "hasInitSample", "isSampled", "Ljava/util/HashSet;", "Lcom/tencent/qqnt/trace/q;", "Lkotlin/collections/HashSet;", "d", "Ljava/util/HashSet;", "allReport", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f195635a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean hasInitSample;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isSampled;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashSet<q> allReport;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54119);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f195635a = new c();
        HashSet<q> hashSet = new HashSet<>();
        allReport = hashSet;
        hashSet.add(new o());
        hashSet.add(new m());
        hashSet.add(new n());
        hashSet.add(new l());
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean a(String key) {
        boolean z16;
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        long decodeLong = from.decodeLong("KEY_FRIEND_LIST_REPORT_TIME_" + key, -1L);
        long currentTimeMillis = System.currentTimeMillis();
        if (decodeLong > 0) {
            if (currentTimeMillis - decodeLong > CacheConstants.REPORT_OPEN_AIO_INTENAL) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return false;
            }
        }
        from.encodeLong("KEY_FRIEND_LIST_REPORT_TIME_" + key, currentTimeMillis);
        return true;
    }

    private final void c(HashMap<String, String> param) {
        Object obj;
        Object first;
        String str;
        int mapCapacity;
        Object first2;
        boolean z16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        long longAccountUin = peekAppRuntime.getLongAccountUin();
        if (longAccountUin <= 0) {
            return;
        }
        Iterator<T> it = allReport.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((q) obj).isTargetType()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        q qVar = (q) obj;
        if (qVar == null) {
            return;
        }
        if (!hasInitSample) {
            if (NTTraceManager.f362318a.f() % qVar.a() == longAccountUin % qVar.a()) {
                z16 = true;
            } else {
                z16 = false;
            }
            isSampled = z16;
            hasInitSample = true;
        }
        if (param.keySet().contains("source")) {
            str = param.get("source");
        } else {
            Set<String> keySet = param.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "param.keys");
            first = CollectionsKt___CollectionsKt.first(keySet);
            str = (String) first;
        }
        if (!isSampled) {
            QLog.w("FriendListTraceManager", 1, "isNotSampled,key=" + str);
            return;
        }
        if (str == null) {
            str = "";
        }
        if (!a(str)) {
            Set<String> keySet2 = param.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet2, "param.keys");
            first2 = CollectionsKt___CollectionsKt.first(keySet2);
            QLog.w("FriendListTraceManager", 1, "can't Report,time limit,key=" + first2);
            return;
        }
        HashMap hashMap = new HashMap();
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(param.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        Iterator<T> it5 = param.entrySet().iterator();
        while (it5.hasNext()) {
            Map.Entry entry = (Map.Entry) it5.next();
            linkedHashMap.put(entry.getKey(), (String) entry.getValue());
        }
        hashMap.putAll(linkedHashMap);
        hashMap.put("app_type", String.valueOf(qVar.getBuildType().getValue()));
        QQBeaconReport.reportWithAppKey("0AND05CMPBA8DUEM", String.valueOf(longAccountUin), "qq_part_performance_report", hashMap);
    }

    public final void b(@NotNull HashMap<String, String> param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        try {
            c(param);
        } catch (Exception e16) {
            QLog.e("FriendListTraceManager", 1, e16.getMessage());
        }
    }
}
