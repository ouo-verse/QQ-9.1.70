package com.tencent.qqnt.ntrelation.onlinestatusinfo.manager;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.b;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J&\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\n0\u0005J&\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\n0\u0005J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nR,\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0012R,\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00140\u000f0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/manager/a;", "", "", "uid", "trace", "Lhx3/b;", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/a;", "iQueryGeneralDataCallback", "", "a", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/c;", "b", "d", "ntOnlineStatusSimpleInfo", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/b;", "Ljava/util/concurrent/ConcurrentHashMap;", "onlineStatusDetailInfoCallbackHashMap", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/e;", "onlineStatusSimpleInfoCallbackHashMap", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f360174a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, ConcurrentHashMap<Integer, b>> onlineStatusDetailInfoCallbackHashMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, ConcurrentHashMap<Integer, e>> onlineStatusSimpleInfoCallbackHashMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37426);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f360174a = new a();
        onlineStatusDetailInfoCallbackHashMap = new ConcurrentHashMap<>();
        onlineStatusSimpleInfoCallbackHashMap = new ConcurrentHashMap<>();
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull String uid, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, uid, trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        ConcurrentHashMap<String, ConcurrentHashMap<Integer, b>> concurrentHashMap = onlineStatusDetailInfoCallbackHashMap;
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

    public final void b(@NotNull String uid, @Nullable String trace, @NotNull hx3.b<c> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, uid, trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        ConcurrentHashMap<String, ConcurrentHashMap<Integer, e>> concurrentHashMap = onlineStatusSimpleInfoCallbackHashMap;
        ConcurrentHashMap<Integer, e> concurrentHashMap2 = concurrentHashMap.get(uid);
        if (concurrentHashMap2 == null) {
            concurrentHashMap2 = new ConcurrentHashMap<>();
        }
        int hashCode = iQueryGeneralDataCallback.hashCode();
        if (concurrentHashMap2.contains(Integer.valueOf(hashCode))) {
            return;
        }
        concurrentHashMap2.put(Integer.valueOf(hashCode), new e(uid, trace, new WeakReference(iQueryGeneralDataCallback)));
        concurrentHashMap.put(uid, concurrentHashMap2);
    }

    public final void c(@NotNull c ntOnlineStatusSimpleInfo) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) ntOnlineStatusSimpleInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(ntOnlineStatusSimpleInfo, "ntOnlineStatusSimpleInfo");
        ArrayList<c> arrayList = new ArrayList<>();
        arrayList.add(ntOnlineStatusSimpleInfo);
        ConcurrentHashMap<Integer, e> concurrentHashMap = onlineStatusSimpleInfoCallbackHashMap.get(ntOnlineStatusSimpleInfo.getUid());
        boolean z17 = false;
        if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.e<c> eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e<>();
        eVar.e(arrayList);
        Iterator<Map.Entry<Integer, e>> it = concurrentHashMap.entrySet().iterator();
        while (it.hasNext()) {
            e value = it.next().getValue();
            if (value.a().get() == null) {
                it.remove();
            } else {
                value.b(eVar);
                z17 = true;
            }
        }
        if (z17) {
            com.tencent.qqnt.ntrelation.friendsinfo.util.a.f360077a.f("FriendOnlineStatusInfoManager", arrayList);
        }
    }

    public final void d(@NotNull String uid, @Nullable String trace, @NotNull hx3.b<c> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, uid, trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        ConcurrentHashMap<Integer, e> concurrentHashMap = onlineStatusSimpleInfoCallbackHashMap.get(uid);
        if (concurrentHashMap == null) {
            return;
        }
        concurrentHashMap.remove(Integer.valueOf(iQueryGeneralDataCallback.hashCode()));
    }
}
