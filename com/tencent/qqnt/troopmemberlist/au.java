package com.tencent.qqnt.troopmemberlist;

import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J,\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00052\u0018\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00070\u0002J\u000e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003J\u0006\u0010\r\u001a\u00020\fR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/troopmemberlist/au;", "", "Ljava/util/ArrayList;", "", "uidList", "", "d", "Lkotlin/Pair;", "uin2UidList", "b", "uid", "c", "", "a", "", "Ljava/util/Map;", "noFriendRemarkCache", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class au {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final au f362840a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, String> noFriendRemarkCache;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63508);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f362840a = new au();
            noFriendRemarkCache = new LinkedHashMap();
        }
    }

    au() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Map<String, String> d(ArrayList<String> uidList) {
        Map<String, String> emptyMap;
        Map<String, String> emptyMap2;
        com.tencent.qqnt.kernel.api.m b16 = com.tencent.qqnt.msg.f.b();
        if (b16 == null || !(!uidList.isEmpty())) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
        Map<String, String> buddyRemark = b16.getBuddyRemark(uidList);
        if (buddyRemark == null) {
            emptyMap2 = MapsKt__MapsKt.emptyMap();
            return emptyMap2;
        }
        return buddyRemark;
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            noFriendRemarkCache.clear();
        }
    }

    @NotNull
    public final Map<String, String> b(@NotNull ArrayList<Pair<String, String>> uin2UidList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Map) iPatchRedirector.redirect((short) 2, (Object) this, (Object) uin2UidList);
        }
        Intrinsics.checkNotNullParameter(uin2UidList, "uin2UidList");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<Pair<String, String>> it = uin2UidList.iterator();
        while (it.hasNext()) {
            Pair<String, String> next = it.next();
            Friends friendFromMemoryCache = ((IFriendDataService) peekAppRuntime.getRuntimeService(IFriendDataService.class, "")).getFriendFromMemoryCache(next.getFirst());
            if (friendFromMemoryCache == null || !friendFromMemoryCache.isFriend()) {
                arrayList.add(next.getSecond());
            }
        }
        Map<String, String> d16 = d(arrayList);
        noFriendRemarkCache.putAll(d16);
        return d16;
    }

    @NotNull
    public final String c(@NotNull String uid) {
        ArrayList<String> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) uid);
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        String str = noFriendRemarkCache.get(uid);
        if (str == null) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(uid);
            String str2 = d(arrayListOf).get(uid);
            if (str2 == null) {
                return "";
            }
            return str2;
        }
        return str;
    }
}
