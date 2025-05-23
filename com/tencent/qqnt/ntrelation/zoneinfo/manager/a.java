package com.tencent.qqnt.ntrelation.zoneinfo.manager;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.ntrelation.zoneinfo.bean.b;
import com.tencent.qqnt.ntrelation.zoneinfo.bean.c;
import com.tencent.qqnt.ntrelation.zoneinfo.bean.d;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J&\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\n0\u0005R,\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000fR,\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00110\f0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/ntrelation/zoneinfo/manager/a;", "", "", "uid", "trace", "Lhx3/b;", "Lcom/tencent/qqnt/ntrelation/zoneinfo/bean/a;", "iQueryGeneralDataCallback", "", "a", "Lcom/tencent/qqnt/ntrelation/zoneinfo/bean/c;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/qqnt/ntrelation/zoneinfo/bean/b;", "Ljava/util/concurrent/ConcurrentHashMap;", "zoneDetailInfoCallbackHashMap", "Lcom/tencent/qqnt/ntrelation/zoneinfo/bean/d;", "c", "zoneSimpleInfoCallbackHashMap", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f360320a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, ConcurrentHashMap<Integer, b>> zoneDetailInfoCallbackHashMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, ConcurrentHashMap<Integer, d>> zoneSimpleInfoCallbackHashMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37870);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        f360320a = new a();
        zoneDetailInfoCallbackHashMap = new ConcurrentHashMap<>();
        zoneSimpleInfoCallbackHashMap = new ConcurrentHashMap<>();
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull String uid, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, uid, trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        ConcurrentHashMap<String, ConcurrentHashMap<Integer, b>> concurrentHashMap = zoneDetailInfoCallbackHashMap;
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
        ConcurrentHashMap<String, ConcurrentHashMap<Integer, d>> concurrentHashMap = zoneSimpleInfoCallbackHashMap;
        ConcurrentHashMap<Integer, d> concurrentHashMap2 = concurrentHashMap.get(uid);
        if (concurrentHashMap2 == null) {
            concurrentHashMap2 = new ConcurrentHashMap<>();
        }
        int hashCode = iQueryGeneralDataCallback.hashCode();
        if (concurrentHashMap2.contains(Integer.valueOf(hashCode))) {
            return;
        }
        concurrentHashMap2.put(Integer.valueOf(hashCode), new d(uid, trace, new WeakReference(iQueryGeneralDataCallback)));
        concurrentHashMap.put(uid, concurrentHashMap2);
    }
}
