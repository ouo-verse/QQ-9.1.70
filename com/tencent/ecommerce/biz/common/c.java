package com.tencent.ecommerce.biz.common;

import android.net.Uri;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/biz/common/c;", "", "Landroid/net/Uri;", LayoutAttrDefine.CLICK_URI, "", "", "a", WadlProxyConsts.KEY_JUMP_URL, "", "c", "e", "d", "b", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f101553a = new c();

    c() {
    }

    private final Map<String, String> a(Uri uri) {
        Object last;
        HashMap hashMap = new HashMap();
        for (String str : uri.getQueryParameterNames()) {
            List<String> queryParameters = uri.getQueryParameters(str);
            if (!queryParameters.isEmpty()) {
                last = CollectionsKt___CollectionsKt.last((List<? extends Object>) queryParameters);
                hashMap.put(str, last);
            } else {
                hashMap.put(str, "");
            }
        }
        return hashMap;
    }

    public final void b() {
        try {
            hg0.a.f404850b.b("ECProductBuyClick", "\u8d2d\u4e70\u6309\u94ae\u70b9\u51fb");
        } catch (Throwable th5) {
            cg0.a.a("ECDetailMetric", "productBuyClick", "productBuyClick error, e: " + th5);
        }
    }

    public final void d() {
        try {
            hg0.a.f404850b.b("ECProductFromRelatedClick", "\u5ba2\u6001\u8be6\u60c5\u9875\u76f8\u5173\u63a8\u8350\u70b9\u51fb\u8fdb\u5165");
        } catch (Throwable th5) {
            cg0.a.a("ECDetailMetric", "productFromRelatedClick", "productFromRelatedClick error, e: " + th5);
        }
    }

    public final void e() {
        try {
            hg0.a.f404850b.b("ECProductFromWindowClick", "\u5ba2\u6001\u6a71\u7a97\u70b9\u51fb\u8fdb\u5165");
        } catch (Throwable th5) {
            cg0.a.a("ECDetailMetric", "productFromWindowClick", "productFromWindowClick error, e: " + th5);
        }
    }

    public final void c(String jumpUrl) {
        if (jumpUrl == null) {
            return;
        }
        try {
            Uri parse = Uri.parse(jumpUrl);
            if (parse != null) {
                Map<String, String> a16 = a(parse);
                String str = a16.get("target");
                String str2 = a16.get("is_host");
                if (Intrinsics.areEqual(str, String.valueOf(9)) && Intrinsics.areEqual(str2, "0")) {
                    hg0.a.f404850b.b("ECProductFromCardClick", "\u5ba2\u6001\u5546\u5361\u70b9\u51fb");
                }
            }
        } catch (Throwable th5) {
            cg0.a.a("ECDetailMetric", "productFromCardClick", "productFromCardClick error, e: " + th5);
        }
    }
}
