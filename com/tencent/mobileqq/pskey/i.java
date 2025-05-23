package com.tencent.mobileqq.pskey;

import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.utils.ds;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ'\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ:\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005J\u001a\u0010\u000e\u001a\u00020\r2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005J\"\u0010\u0011\u001a\u00020\r2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0010\u001a\u00020\u000fJ\"\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00032\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005J\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016R\u0014\u0010\u001a\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/pskey/i;", "", "", "", "domains", "", "Lcom/tencent/mobileqq/pskey/a;", "a", "([Ljava/lang/String;)Ljava/util/Map;", "fromLocal", "fromRequest", "d", "map", "", "b", "", "keyType", "c", "uin", "domainToPskeyMap", "", "e", "", "list", "f", "I", "samplingRate", "randomNumber", "Z", "hitSampling", "<init>", "()V", "pskey-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f261182a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int samplingRate;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final int randomNumber;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final boolean hitSampling;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35648);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        f261182a = new i();
        samplingRate = 200;
        boolean z16 = false;
        int d16 = ds.d(0, 200);
        randomNumber = d16;
        if (d16 <= 0) {
            z16 = true;
        }
        hitSampling = z16;
    }

    i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final Map<String, a> a(@NotNull String[] domains) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Map) iPatchRedirector.redirect((short) 2, (Object) this, (Object) domains);
        }
        Intrinsics.checkNotNullParameter(domains, "domains");
        HashMap hashMap = new HashMap();
        for (String str : domains) {
            hashMap.put(str, new a("", "", 0));
        }
        return hashMap;
    }

    public final boolean b(@NotNull Map<String, a> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) map)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(map, "map");
        Iterator<Map.Entry<String, a>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            a value = it.next().getValue();
            if ((Intrinsics.areEqual(value.b(), "") && Intrinsics.areEqual(value.c(), "")) || value.a() == 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean c(@NotNull Map<String, a> map, int keyType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) map, keyType)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(map, "map");
        if (keyType == 0) {
            Iterator<Map.Entry<String, a>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                a value = it.next().getValue();
                if (Intrinsics.areEqual(value.b(), "") || value.a() == 0) {
                    return false;
                }
            }
            return true;
        }
        Iterator<Map.Entry<String, a>> it5 = map.entrySet().iterator();
        while (it5.hasNext()) {
            a value2 = it5.next().getValue();
            if (Intrinsics.areEqual(value2.c(), "") || value2.a() == 0) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public final Map<String, a> d(@NotNull Map<String, a> fromLocal, @NotNull Map<String, a> fromRequest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Map) iPatchRedirector.redirect((short) 3, (Object) this, (Object) fromLocal, (Object) fromRequest);
        }
        Intrinsics.checkNotNullParameter(fromLocal, "fromLocal");
        Intrinsics.checkNotNullParameter(fromRequest, "fromRequest");
        HashMap hashMap = new HashMap(fromLocal);
        for (Map.Entry<String, a> entry : fromRequest.entrySet()) {
            String key = entry.getKey();
            a value = entry.getValue();
            a aVar = (a) hashMap.get(key);
            if (aVar != null && !Intrinsics.areEqual(aVar.b(), "")) {
                hashMap.put(key, new a(value.b(), value.c(), aVar.a()));
            } else if (Intrinsics.areEqual(value.b(), "")) {
                hashMap.put(key, new a(value.b(), value.c(), 4));
            } else {
                hashMap.put(key, new a(value.b(), value.c(), 3));
            }
        }
        return hashMap;
    }

    public final void e(@NotNull String uin, @NotNull Map<String, a> domainToPskeyMap) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) uin, (Object) domainToPskeyMap);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(domainToPskeyMap, "domainToPskeyMap");
        if (QLog.isDevelopLevel()) {
            QLog.i("PskeyUtil", 4, "reportQQBeaconGetPskey randomNumber = " + randomNumber);
        }
        if (!hitSampling) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        for (Map.Entry<String, a> entry : domainToPskeyMap.entrySet()) {
            String key = entry.getKey();
            a value = entry.getValue();
            if (Intrinsics.areEqual(value.b(), "") || value.a() == 0) {
                sb5.append("    domain = " + key + ", not support!\n");
                value.d(4);
            }
            TreeMap treeMap = new TreeMap();
            treeMap.put(StartupReportKey.USER_UIN, uin);
            treeMap.put("from_type", "1");
            treeMap.put("domain", key);
            treeMap.put("cache_hit_type", String.valueOf(value.a()));
            sb5.append("    " + treeMap + "\n");
            QQBeaconReport.report(uin, "pskey_get_pskey", treeMap);
        }
        if (sb5.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.d("PskeyUtil", 2, sb5.toString());
        }
    }

    @NotNull
    public final List<String> f(@NotNull List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this, (Object) list);
        }
        Intrinsics.checkNotNullParameter(list, "list");
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!arrayList.contains(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
