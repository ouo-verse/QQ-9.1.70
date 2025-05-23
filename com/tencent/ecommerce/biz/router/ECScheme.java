package com.tencent.ecommerce.biz.router;

import android.net.Uri;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.ecommerce.base.ECHandleSchemeResult;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.fragment.d;
import com.tencent.ecommerce.base.opentelemtry.api.IECSpanStatus;
import com.tencent.ecommerce.base.router.api.IECScheme;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import ug0.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c0\u0002\u0018\u00002\u00020\u0001:\u0001$B\t\b\u0002\u00a2\u0006\u0004\b/\u00100J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J*\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007H\u0007J6\u0010\r\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007H\u0007J>\u0010\u0010\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007H\u0002J0\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH\u0002J:\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007H\u0002J:\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007H\u0002JF\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00072\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J(\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00022\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007H\u0002J(\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00022\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007H\u0002J$\u0010 \u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007H\u0002J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0002H\u0002J\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u0018\u001a\u00020\u0002R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010(Rx\u0010.\u001af\u0012\u0004\u0012\u00020\u0005\u0012\\\u0012Z\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007\u00a2\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\t0*0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/ecommerce/biz/router/ECScheme;", "", "Landroid/net/Uri;", "Lcom/tencent/ecommerce/biz/router/ECScheme$a;", "k", "", "url", "", "extraUserData", "", "e", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "callback", "c", "", "isCheckChannel", "d", "target", "arguments", "b", "spanNum", "result", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, LayoutAttrDefine.CLICK_URI, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "extUserData", "i", "data", DomainData.DOMAIN_NAME, "o", h.F, "j", "p", "Lcom/tencent/ecommerce/base/router/api/IECScheme;", "a", "Lcom/tencent/ecommerce/base/router/api/IECScheme;", "schemeProxy", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "schemeSpanNum", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "Ljava/util/Map;", "pathHandlerMap", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECScheme {

    /* renamed from: a, reason: from kotlin metadata */
    private static final IECScheme schemeProxy;

    /* renamed from: b, reason: from kotlin metadata */
    private static final AtomicInteger schemeSpanNum;

    /* renamed from: c, reason: from kotlin metadata */
    private static final Map<String, Function4<Integer, Map<String, String>, Map<Object, ? extends Object>, IECSchemeCallback, Integer>> pathHandlerMap;

    /* renamed from: d */
    public static final ECScheme f104135d;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/biz/router/ECScheme$a;", "", "<init>", "()V", "a", "b", "c", "Lcom/tencent/ecommerce/biz/router/ECScheme$a$a;", "Lcom/tencent/ecommerce/biz/router/ECScheme$a$b;", "Lcom/tencent/ecommerce/biz/router/ECScheme$a$c;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static abstract class a {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/router/ECScheme$a$a;", "Lcom/tencent/ecommerce/biz/router/ECScheme$a;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* renamed from: com.tencent.ecommerce.biz.router.ECScheme$a$a */
        /* loaded from: classes31.dex */
        public static final class C1089a extends a {

            /* renamed from: a */
            public static final C1089a f104136a = new C1089a();

            C1089a() {
                super(null);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/router/ECScheme$a$b;", "Lcom/tencent/ecommerce/biz/router/ECScheme$a;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class b extends a {

            /* renamed from: a */
            public static final b f104137a = new b();

            b() {
                super(null);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/router/ECScheme$a$c;", "Lcom/tencent/ecommerce/biz/router/ECScheme$a;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class c extends a {

            /* renamed from: a */
            public static final c f104138a = new c();

            c() {
                super(null);
            }
        }

        a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Map<String, Function4<Integer, Map<String, String>, Map<Object, ? extends Object>, IECSchemeCallback, Integer>> mapOf;
        ECScheme eCScheme = new ECScheme();
        f104135d = eCScheme;
        schemeProxy = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getScheme();
        schemeSpanNum = new AtomicInteger(1);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("/open", new ECScheme$pathHandlerMap$1(eCScheme)));
        pathHandlerMap = mapOf;
    }

    ECScheme() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x005f, code lost:
    
        r10 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r10);
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final int b(int target, Map<String, String> arguments, IECSchemeCallback callback) {
        Map<String, String> mapOf;
        Integer intOrNull;
        cg0.a.b("ECScheme", "[ECScheme] target = " + target + " arguments = " + arguments);
        if (target <= 0) {
            return -1;
        }
        String str = arguments.get("source_from");
        if (str == null) {
            str = "-1";
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(arguments);
        if (!Intrinsics.areEqual(str, "-1")) {
            b.f438933d.j(str);
        } else {
            linkedHashMap.put("source_from", b.f438933d.g());
        }
        String str2 = (String) linkedHashMap.get(WadlProxyConsts.CHANNEL);
        int intValue = (str2 == null || intOrNull == null) ? -1 : intOrNull.intValue();
        if (intValue == -1) {
            if (!wg0.a.b()) {
                cg0.a.a("ECScheme", "scheme(target, arguments)", "scheme has not contains channel parameter. target = " + target + " parameter = " + linkedHashMap);
            } else {
                throw new IllegalArgumentException("channel is unknown!");
            }
        }
        b.f438933d.i(linkedHashMap);
        int andIncrement = schemeSpanNum.getAndIncrement();
        d dVar = d.f100713c;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("ECHandleScheme_");
        ECScheme eCScheme = f104135d;
        sb5.append(eCScheme.hashCode() + andIncrement);
        dVar.f(sb5.toString(), "ECSchemeWithArguments", dVar.d());
        String str3 = "ECHandleScheme_" + (eCScheme.hashCode() + andIncrement);
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("scheme.target", String.valueOf(target)), TuplesKt.to("scheme.arguments", linkedHashMap.toString()));
        dVar.e(str3, mapOf);
        eCScheme.q(andIncrement, eCScheme.i(target, linkedHashMap, null, callback));
        return 2;
    }

    @JvmStatic
    public static final int c(String url, IECSchemeCallback callback, Map<Object, ? extends Object> extraUserData) {
        return f104135d.d(url, callback, false, extraUserData);
    }

    private final int d(String url, IECSchemeCallback callback, boolean isCheckChannel, Map<Object, ? extends Object> extraUserData) {
        Uri parse;
        Map<String, String> mapOf;
        cg0.a.b("ECScheme", "[ECScheme] url = " + url);
        if ((url == null || url.length() == 0) || (parse = Uri.parse(url)) == null) {
            return -1;
        }
        int andIncrement = schemeSpanNum.getAndIncrement();
        d dVar = d.f100713c;
        dVar.f("ECHandleScheme_" + (hashCode() + andIncrement), "ECScheme", dVar.d());
        String str = "ECHandleScheme_" + (hashCode() + andIncrement);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("scheme.url", url));
        dVar.e(str, mapOf);
        q(andIncrement, m(parse, callback, isCheckChannel, extraUserData));
        return 2;
    }

    private final int h(int i3, Map<String, String> map) {
        return schemeProxy.handleCommonPage(i3, map);
    }

    public final int i(int target, Map<String, String> arguments, Map<Object, ? extends Object> extUserData, IECSchemeCallback callback) {
        cg0.a.b("ECScheme", "process target " + target);
        Uri parse = Uri.parse(String.valueOf(target));
        if (yi0.a.v(parse, arguments)) {
            cg0.a.b("ECScheme", "process sdk inner target " + target);
            if (yi0.a.s(parse, arguments, extUserData, callback)) {
                return ECHandleSchemeResult.SCHEME_RESULT_OK.ordinal();
            }
            return ECHandleSchemeResult.SCHEME_RESULT_ERROR.ordinal();
        }
        h(target, arguments);
        cg0.a.b("ECScheme", "process sdk outter target " + target);
        return ECHandleSchemeResult.SCHEME_RESULT_ERROR.ordinal();
    }

    private final int j(Uri r36) {
        cg0.a.b("ECScheme", "handleOtherScheme uri = " + r36);
        return schemeProxy.handleOtherScheme(r36.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:?, code lost:
    
        return com.tencent.ecommerce.biz.router.ECScheme.a.c.f104138a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final a k(Uri uri) {
        String scheme = uri.getScheme();
        if (scheme != null) {
            int hashCode = scheme.hashCode();
            if (hashCode != -1730530292) {
                if (hashCode != 3213448) {
                }
            } else if (scheme.equals("mqqwebview")) {
                return a.b.f104137a;
            }
        }
        return a.C1089a.f104136a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x006d, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b5, code lost:
    
        r9 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int l(Uri r75, IECSchemeCallback callback, boolean isCheckChannel, Map<Object, ? extends Object> extraUserData) {
        Integer intOrNull;
        Integer intOrNull2;
        if (!Intrinsics.areEqual(r75.getHost(), "ecommerce")) {
            cg0.a.b("ECScheme", "host is not ecommerce, url = " + r75);
            return j(r75);
        }
        Map<String, String> l3 = yi0.a.f450402c.l(r75);
        String str = l3.get("source_from");
        if (str == null) {
            str = "-1";
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(l3);
        if (!Intrinsics.areEqual(str, "-1")) {
            b.f438933d.j(str);
        } else {
            linkedHashMap.put("source_from", b.f438933d.g());
        }
        String str2 = (String) linkedHashMap.get(WadlProxyConsts.CHANNEL);
        int i3 = -1;
        int intValue = (str2 == null || intOrNull2 == null) ? -1 : intOrNull2.intValue();
        if (intValue == -1) {
            if (isCheckChannel && wg0.a.b()) {
                throw new IllegalArgumentException("channel is unknown!");
            }
            cg0.a.a("ECScheme", "processCustomScheme", "scheme has not contains channel parameter, uri = " + r75);
        }
        b.f438933d.i(linkedHashMap);
        String str3 = (String) linkedHashMap.get("target");
        if (str3 != null && intOrNull != null) {
            i3 = intOrNull.intValue();
        }
        Function4<Integer, Map<String, String>, Map<Object, ? extends Object>, IECSchemeCallback, Integer> function4 = pathHandlerMap.get(r75.getPath());
        if (function4 != null) {
            return function4.invoke(Integer.valueOf(i3), linkedHashMap, extraUserData, callback).intValue();
        }
        cg0.a.a("ECScheme", "processCustomScheme", "path is not in pathHandlerMap");
        return ECHandleSchemeResult.SCHEME_RESULT_ERROR.ordinal();
    }

    private final int m(Uri uri, IECSchemeCallback iECSchemeCallback, boolean z16, Map<Object, ? extends Object> map) {
        a k3 = k(uri);
        if (Intrinsics.areEqual(k3, a.C1089a.f104136a)) {
            return l(uri, iECSchemeCallback, z16, map);
        }
        if (Intrinsics.areEqual(k3, a.c.f104138a)) {
            return n(uri, map);
        }
        if (Intrinsics.areEqual(k3, a.b.f104137a)) {
            return o(uri, map);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final int n(Uri uri, Map<Object, ? extends Object> map) {
        String str;
        cg0.a.b("ECScheme", "processWebLink uri = " + uri + ", userData = " + map);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (map != null) {
            for (Object obj : map.keySet()) {
                String obj2 = obj.toString();
                Object obj3 = map.get(obj);
                if (obj3 == null || (str = obj3.toString()) == null) {
                    str = "";
                }
                linkedHashMap.put(obj2, str);
            }
        }
        return schemeProxy.handleWebScheme(uri.toString(), linkedHashMap);
    }

    private final int o(Uri r56, Map<Object, ? extends Object> data) {
        String str;
        cg0.a.b("ECScheme", "processWebScheme uri = " + r56 + ", h5 = " + r56.getHost() + ", data=" + data);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (data != null) {
            for (Object obj : data.keySet()) {
                String obj2 = obj.toString();
                Object obj3 = data.get(obj);
                if (obj3 == null || (str = obj3.toString()) == null) {
                    str = "";
                }
                linkedHashMap.put(obj2, str);
            }
        }
        return schemeProxy.handleWebScheme(r56.getHost(), linkedHashMap);
    }

    private final void q(int i3, int i16) {
        int ordinal;
        if (i16 == ECHandleSchemeResult.SCHEME_RESULT_OK.ordinal()) {
            ordinal = IECSpanStatus.ECSpanStatusOK.ordinal();
        } else {
            ordinal = IECSpanStatus.ECSpanStatusError.ordinal();
        }
        d.f100713c.g("ECHandleScheme_" + (hashCode() + i3), ordinal);
    }

    public final Map<String, String> p(Uri r26) {
        return yi0.a.f450402c.l(r26);
    }

    @JvmStatic
    public static final int e(String url, Map<Object, ? extends Object> extraUserData) {
        return c(url, null, extraUserData);
    }

    public static /* synthetic */ int g(String str, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = null;
        }
        return e(str, map);
    }

    public static /* synthetic */ int f(String str, IECSchemeCallback iECSchemeCallback, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            iECSchemeCallback = null;
        }
        if ((i3 & 4) != 0) {
            map = null;
        }
        return c(str, iECSchemeCallback, map);
    }
}
