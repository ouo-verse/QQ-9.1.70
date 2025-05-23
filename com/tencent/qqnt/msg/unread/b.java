package com.tencent.qqnt.msg.unread;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UnreadCnt;
import com.tencent.qqnt.kernel.nativeinterface.UnreadCntInfo;
import cooperation.qzone.report.QZonePushReporter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J6\u0010\n\u001a\u00020\t2.\u0010\b\u001a*\u0012\u0004\u0012\u00020\u0003\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u00070\u0002J\u0006\u0010\u000b\u001a\u00020\tJJ\u0010\u000e\u001a\u00020\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00022.\u0010\r\u001a*\u0012\u0004\u0012\u00020\u0003\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u00070\u0002J\u001a\u0010\u0011\u001a\u00020\u00032\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u000fJ\u0010\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0003J\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u000fR'\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001bR'\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u0016j\b\u0012\u0004\u0012\u00020\u001d`\u00188\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001e\u0010\u001bR\"\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010 \u00a8\u0006#"}, d2 = {"Lcom/tencent/qqnt/msg/unread/b;", "", "", "", "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/UnreadCntInfo;", "Lkotlin/collections/HashMap;", "newUnreadCntMap", "", "i", h.F, "cur", QZonePushReporter.EVENT_CODE_TYPE2_PUSH_ARRIVE, "g", "", "curUnreadInfo", "a", "uid", "f", "d", "e", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/msg/unread/c;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "interceptors", "Lcom/tencent/qqnt/msg/unread/a;", "c", "observers", "Ljava/util/Map;", "<init>", "()V", "msg_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f359711a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayList<c> interceptors;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayList<a> observers;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Map<String, UnreadCntInfo> curUnreadInfo;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40492);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        f359711a = new b();
        interceptors = new ArrayList<>();
        observers = new ArrayList<>();
        curUnreadInfo = new ConcurrentHashMap();
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final int a(@NotNull Map<String, UnreadCntInfo> curUnreadInfo2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) curUnreadInfo2)).intValue();
        }
        Intrinsics.checkNotNullParameter(curUnreadInfo2, "curUnreadInfo");
        int i3 = 0;
        for (Map.Entry<String, UnreadCntInfo> entry : curUnreadInfo2.entrySet()) {
            Iterator<T> it = interceptors.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((c) it.next()).a(entry.getKey())) {
                        break;
                    }
                } else {
                    i3 += entry.getValue().showUnreadCnt.cnt;
                    break;
                }
            }
        }
        return i3;
    }

    @NotNull
    public final ArrayList<c> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return interceptors;
    }

    @NotNull
    public final ArrayList<a> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return observers;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return a(curUnreadInfo);
    }

    @NotNull
    public final Map<String, UnreadCntInfo> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Map) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return curUnreadInfo;
    }

    public final int f(@NotNull String uid) {
        UnreadCnt unreadCnt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) uid)).intValue();
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        if (TextUtils.isEmpty(uid)) {
            return a(curUnreadInfo);
        }
        UnreadCntInfo unreadCntInfo = curUnreadInfo.get(uid);
        if (unreadCntInfo != null && (unreadCnt = unreadCntInfo.showUnreadCnt) != null) {
            return unreadCnt.cnt;
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g(@NotNull Map<String, UnreadCntInfo> cur, @NotNull Map<Integer, HashMap<String, UnreadCntInfo>> arrive) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) cur, (Object) arrive);
            return;
        }
        Intrinsics.checkNotNullParameter(cur, "cur");
        Intrinsics.checkNotNullParameter(arrive, "arrive");
        ArrayList<Map.Entry> arrayList = new ArrayList();
        Iterator<Map.Entry<Integer, HashMap<String, UnreadCntInfo>>> it = arrive.entrySet().iterator();
        while (it.hasNext()) {
            Set<Map.Entry<String, UnreadCntInfo>> entrySet = it.next().getValue().entrySet();
            Intrinsics.checkNotNullExpressionValue(entrySet, "it.value.entries");
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, entrySet);
        }
        for (Map.Entry entry : arrayList) {
            Object key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "it.key");
            Object value = entry.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "it.value");
            cur.put(key, value);
        }
    }

    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        int a16 = a(curUnreadInfo);
        Iterator<T> it = observers.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(a16, new HashMap<>(curUnreadInfo));
        }
        QLog.d("UnreadCountHelper", 1, "notifyCurUnreadInfo count: " + a16);
    }

    public final void i(@NotNull Map<Integer, HashMap<String, UnreadCntInfo>> newUnreadCntMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) newUnreadCntMap);
            return;
        }
        Intrinsics.checkNotNullParameter(newUnreadCntMap, "newUnreadCntMap");
        g(curUnreadInfo, newUnreadCntMap);
        h();
    }
}
