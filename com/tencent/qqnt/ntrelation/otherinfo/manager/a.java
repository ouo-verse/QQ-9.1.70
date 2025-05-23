package com.tencent.qqnt.ntrelation.otherinfo.manager;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.e;
import com.tencent.qqnt.ntrelation.otherinfo.bean.b;
import com.tencent.qqnt.ntrelation.otherinfo.bean.c;
import com.tencent.qqnt.ntrelation.otherinfo.bean.d;
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
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J&\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\n0\u0005J\u0016\u0010\u000e\u001a\u00020\b2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fJ\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\nR,\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00110\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0014R,\u0010\u0017\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00160\u00110\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/ntrelation/otherinfo/manager/a;", "", "", "uid", "trace", "Lhx3/b;", "Lcom/tencent/qqnt/ntrelation/otherinfo/bean/a;", "iQueryGeneralDataCallback", "", "a", "Lcom/tencent/qqnt/ntrelation/otherinfo/bean/c;", "b", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", WebViewPlugin.KEY_RESPONSE, "c", "ntOtherSimpleInfo", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/qqnt/ntrelation/otherinfo/bean/b;", "Ljava/util/concurrent/ConcurrentHashMap;", "otherDetailInfoCallbackHashMap", "Lcom/tencent/qqnt/ntrelation/otherinfo/bean/d;", "otherSimpleInfoCallbackHashMap", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f360224a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, ConcurrentHashMap<Integer, b>> otherDetailInfoCallbackHashMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, ConcurrentHashMap<Integer, d>> otherSimpleInfoCallbackHashMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37570);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        f360224a = new a();
        otherDetailInfoCallbackHashMap = new ConcurrentHashMap<>();
        otherSimpleInfoCallbackHashMap = new ConcurrentHashMap<>();
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull String uid, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.otherinfo.bean.a> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, uid, trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        ConcurrentHashMap<String, ConcurrentHashMap<Integer, b>> concurrentHashMap = otherDetailInfoCallbackHashMap;
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
        ConcurrentHashMap<String, ConcurrentHashMap<Integer, d>> concurrentHashMap = otherSimpleInfoCallbackHashMap;
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

    public final void c(@Nullable e<com.tencent.qqnt.ntrelation.otherinfo.bean.a> responseData) {
        ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.a> arrayList;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) responseData);
            return;
        }
        if (responseData != null) {
            arrayList = responseData.b();
        } else {
            arrayList = null;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        Iterator<com.tencent.qqnt.ntrelation.otherinfo.bean.a> it = arrayList.iterator();
        while (it.hasNext()) {
            com.tencent.qqnt.ntrelation.otherinfo.bean.a next = it.next();
            ConcurrentHashMap<Integer, b> concurrentHashMap = otherDetailInfoCallbackHashMap.get(next.getUid());
            if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.a> arrayList2 = new ArrayList<>();
                arrayList2.add(next);
                e<com.tencent.qqnt.ntrelation.otherinfo.bean.a> eVar = new e<>();
                eVar.e(arrayList2);
                Iterator<Map.Entry<Integer, b>> it5 = concurrentHashMap.entrySet().iterator();
                while (it5.hasNext()) {
                    b value = it5.next().getValue();
                    if (value.a().get() == null) {
                        it5.remove();
                    } else {
                        value.b(eVar);
                    }
                }
            }
        }
    }

    public final void d(@NotNull c ntOtherSimpleInfo) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) ntOtherSimpleInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(ntOtherSimpleInfo, "ntOtherSimpleInfo");
        ArrayList<c> arrayList = new ArrayList<>();
        arrayList.add(ntOtherSimpleInfo);
        ConcurrentHashMap<Integer, d> concurrentHashMap = otherSimpleInfoCallbackHashMap.get(ntOtherSimpleInfo.getUid());
        if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        e<c> eVar = new e<>();
        eVar.e(arrayList);
        Iterator<Map.Entry<Integer, d>> it = concurrentHashMap.entrySet().iterator();
        while (it.hasNext()) {
            d value = it.next().getValue();
            if (value.a().get() == null) {
                it.remove();
            } else {
                value.b(eVar);
            }
        }
    }
}
