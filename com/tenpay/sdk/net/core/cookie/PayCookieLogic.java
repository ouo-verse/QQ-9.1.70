package com.tenpay.sdk.net.core.cookie;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tenpay.sdk.net.core.log.DLog;
import com.tenpay.sdk.net.core.log.ILogAgent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Cookie;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0010\u001a\u00020\u0004J\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u00042\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0014J\b\u0010\u0015\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R6\u0010\u0005\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007`\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tenpay/sdk/net/core/cookie/PayCookieLogic;", "", "()V", "TAG", "", "cacheCookies", "Ljava/util/HashMap;", "", "Lokhttp3/Cookie;", "Lkotlin/collections/HashMap;", "checkExpireTime", "", "cookie", "getCurrentTimeMillis", "", "loadForRequest", "host", "saveFromResponse", "", "saveCookies", "", "supportCookieName", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PayCookieLogic {

    @NotNull
    public static final String TAG = "MemoryCookieLogic";

    @NotNull
    public static final PayCookieLogic INSTANCE = new PayCookieLogic();

    @NotNull
    private static final HashMap<String, List<Cookie>> cacheCookies = new HashMap<>();

    PayCookieLogic() {
    }

    private final boolean checkExpireTime(Cookie cookie) {
        if (cookie.expiresAt() > getCurrentTimeMillis()) {
            return true;
        }
        return false;
    }

    private final long getCurrentTimeMillis() {
        return NetConnInfoCenter.getServerTimeMillis();
    }

    private final String supportCookieName() {
        return "qpay";
    }

    @NotNull
    public final List<Cookie> loadForRequest(@NotNull String host) {
        Intrinsics.checkNotNullParameter(host, "host");
        List<Cookie> list = cacheCookies.get(host);
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!INSTANCE.checkExpireTime((Cookie) obj)) {
                arrayList.add(obj);
            }
        }
        list.removeAll(arrayList);
        ILogAgent.DefaultImpls.d$default(DLog.INSTANCE, TAG, "loadCookies " + list, null, 4, null);
        return list;
    }

    public final void saveFromResponse(@NotNull String host, @Nullable List<Cookie> saveCookies) {
        boolean contains$default;
        Object obj;
        List mutableList;
        boolean contains$default2;
        Intrinsics.checkNotNullParameter(host, "host");
        if (saveCookies == null) {
            return;
        }
        List<Cookie> list = cacheCookies.get(host);
        String supportCookieName = supportCookieName();
        if (list == null) {
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) saveCookies);
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : mutableList) {
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) ((Cookie) obj2).name(), (CharSequence) supportCookieName, false, 2, (Object) null);
                if (contains$default2) {
                    arrayList.add(obj2);
                }
            }
            list = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
            cacheCookies.put(host, list);
        } else {
            for (Cookie cookie : saveCookies) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) cookie.name(), (CharSequence) supportCookieName, false, 2, (Object) null);
                if (contains$default) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj = it.next();
                            if (Intrinsics.areEqual(((Cookie) obj).name(), cookie.name())) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    Cookie cookie2 = (Cookie) obj;
                    if (cookie2 != null) {
                        list.remove(cookie2);
                    }
                    list.add(cookie);
                }
            }
        }
        ILogAgent.DefaultImpls.d$default(DLog.INSTANCE, TAG, "saveCookies " + list, null, 4, null);
    }
}
