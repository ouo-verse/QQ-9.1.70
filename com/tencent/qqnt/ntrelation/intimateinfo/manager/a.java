package com.tencent.qqnt.ntrelation.intimateinfo.manager;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.e;
import com.tencent.qqnt.ntrelation.intimateinfo.bean.b;
import com.tencent.qqnt.ntrelation.intimateinfo.manager.cache.MutualMarkCacheEntityManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u001e\u0010\r\u001a\u00020\b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\nj\b\u0012\u0004\u0012\u00020\u0006`\u000bR,\u0010\u0012\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/ntrelation/intimateinfo/manager/a;", "", "", "uid", "trace", "Lhx3/b;", "Lcom/tencent/qqnt/ntrelation/intimateinfo/bean/a;", "iQueryGeneralDataCallback", "", "a", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "ntIntimateSimpleInfos", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/qqnt/ntrelation/intimateinfo/bean/b;", "Ljava/util/concurrent/ConcurrentHashMap;", "intimateSimpleInfoCallbackHashMap", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f360090a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, ConcurrentHashMap<Integer, b>> intimateSimpleInfoCallbackHashMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37071);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f360090a = new a();
            intimateSimpleInfoCallbackHashMap = new ConcurrentHashMap<>();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull String uid, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, uid, trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        ConcurrentHashMap<String, ConcurrentHashMap<Integer, b>> concurrentHashMap = intimateSimpleInfoCallbackHashMap;
        ConcurrentHashMap<Integer, b> concurrentHashMap2 = concurrentHashMap.get(uid);
        if (concurrentHashMap2 == null) {
            concurrentHashMap2 = new ConcurrentHashMap<>();
        }
        int hashCode = iQueryGeneralDataCallback.hashCode();
        if (concurrentHashMap2.contains(Integer.valueOf(hashCode))) {
            return;
        }
        concurrentHashMap2.put(Integer.valueOf(hashCode), new b(uid, trace, new WeakReference(iQueryGeneralDataCallback)));
        concurrentHashMap.put(uid, concurrentHashMap2);
    }

    public final void b(@NotNull ArrayList<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> ntIntimateSimpleInfos) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) ntIntimateSimpleInfos);
            return;
        }
        Intrinsics.checkNotNullParameter(ntIntimateSimpleInfos, "ntIntimateSimpleInfos");
        MutualMarkCacheEntityManager.f360092a.p(ntIntimateSimpleInfos);
        for (com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar : ntIntimateSimpleInfos) {
            ConcurrentHashMap<Integer, b> concurrentHashMap = intimateSimpleInfoCallbackHashMap.get(aVar.getUid());
            if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return;
            }
            e<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> eVar = new e<>();
            eVar.e(new ArrayList<>(Collections.singletonList(aVar)));
            Iterator<Map.Entry<Integer, b>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                b value = it.next().getValue();
                if (value.a().get() == null) {
                    it.remove();
                } else {
                    value.b(eVar);
                }
            }
        }
    }
}
