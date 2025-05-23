package com.tencent.luggage.wxa.m6;

import android.net.Uri;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tenpay.sdk.Cgi;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f134210a = new ConcurrentHashMap();

    public final a a(String reqUrl, int i3) {
        Intrinsics.checkNotNullParameter(reqUrl, "reqUrl");
        e b16 = b(reqUrl, i3);
        if (!this.f134210a.contains(b16)) {
            ConcurrentHashMap concurrentHashMap = this.f134210a;
            Object newInstance = b16.b().newInstance();
            Intrinsics.checkNotNullExpressionValue(newInstance, "type.cgiInstanceClazz.newInstance()");
            concurrentHashMap.put(b16, newInstance);
        }
        Object obj = this.f134210a.get(b16);
        Intrinsics.checkNotNull(obj);
        return (a) obj;
    }

    public final e b(String str, int i3) {
        boolean isBlank;
        ArrayList arrayListOf;
        boolean contains$default;
        boolean contains$default2;
        boolean contains$default3;
        boolean contains$default4;
        boolean contains$default5;
        if (i3 != 5) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            boolean z16 = true;
            if (!isBlank) {
                Uri parse = Uri.parse(str);
                String host = parse.getHost();
                String str2 = "";
                if (host == null) {
                    host = "";
                }
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
                String lowerCase = host.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                String fragment = parse.getFragment();
                if (fragment != null && fragment.length() != 0) {
                    z16 = false;
                }
                if (!z16) {
                    str2 = '#' + fragment;
                }
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("open.weixin.qq.com", "mp.weixin.qq.com", "mp.weixinbridge.com");
                if (!arrayListOf.contains(lowerCase)) {
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) "wechat_pay", false, 2, (Object) null);
                    if (!contains$default) {
                        contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) QQWinkConstants.VALID_HOST, false, 2, (Object) null);
                        if (!contains$default2 && !Intrinsics.areEqual(lowerCase, "qq.com")) {
                            contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) ".wechat.com", false, 2, (Object) null);
                            if (!contains$default3 && !Intrinsics.areEqual(lowerCase, "wechat.com")) {
                                contains$default4 = StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) ".tenpay.com", false, 2, (Object) null);
                                if (!contains$default4 && !Intrinsics.areEqual(lowerCase, Cgi.TENPAY_DOMAIN)) {
                                    contains$default5 = StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) ".url.cn", false, 2, (Object) null);
                                    if (!contains$default5 && !Intrinsics.areEqual(lowerCase, "url.com") && !a(str)) {
                                        return e.THREE_RD;
                                    }
                                }
                            }
                        }
                        return e.MAIN;
                    }
                    return e.PAY;
                }
                return e.MP;
            }
            return e.MAIN;
        }
        return e.MINOR;
    }

    public final boolean a(String str) {
        boolean startsWith$default;
        boolean startsWith$default2;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "http://", false, 2, null);
        if (startsWith$default) {
            return false;
        }
        startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(str, "https://", false, 2, null);
        return !startsWith$default2;
    }
}
