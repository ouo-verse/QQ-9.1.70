package com.tencent.luggage.wxa.kj;

import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0003B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0003\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/luggage/wxa/kj/t;", "Lcom/tencent/luggage/wxa/xd/l;", "Lcom/tencent/luggage/wxa/rc/q;", "a", "Lcom/tencent/luggage/wxa/rc/q;", "libFileProvider", "Lcom/tencent/luggage/wxa/mc/m;", "b", "Lcom/tencent/luggage/wxa/mc/m;", "wxaPkgFileProvider", "", "c", "Lkotlin/Lazy;", "()Z", "useLazyCodeLoadingMode", "<init>", "(Lcom/tencent/luggage/wxa/rc/q;Lcom/tencent/luggage/wxa/mc/m;)V", "d", "luggage-wechat-full-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class t implements com.tencent.luggage.wxa.xd.l {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final com.tencent.luggage.wxa.rc.q libFileProvider;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final com.tencent.luggage.wxa.mc.m wxaPkgFileProvider;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Lazy useLazyCodeLoadingMode;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.kj.t$a, reason: from kotlin metadata */
    /* loaded from: classes8.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(com.tencent.luggage.wxa.rc.q qVar) {
            boolean z16;
            Intrinsics.checkNotNullParameter(qVar, "<this>");
            String[] strArr = {"lazyCodeLoading", "lazyCodeLoading2"};
            for (int i3 = 0; i3 < 2; i3++) {
                String h16 = qVar.h(strArr[i3]);
                if (h16 != null && h16.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function0 {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            boolean endsWith$default;
            if (!t.INSTANCE.a(t.this.libFileProvider)) {
                com.tencent.luggage.wxa.tn.w.d("Luggage.WXA.FULL.AppBrandPageScriptInjectConfig", "useLazyCodeLoadingMode return false, lib.version=[" + t.this.libFileProvider.u() + ']');
                return Boolean.FALSE;
            }
            if (t.this.wxaPkgFileProvider.d("common.app.js")) {
                com.tencent.luggage.wxa.tn.w.d("Luggage.WXA.FULL.AppBrandPageScriptInjectConfig", "useLazyCodeLoadingMode return true, by common.app.js");
                return Boolean.TRUE;
            }
            for (ModulePkgInfo modulePkgInfo : t.this.wxaPkgFileProvider.a()) {
                if (modulePkgInfo.independent) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(modulePkgInfo.name);
                    String str = modulePkgInfo.name;
                    Intrinsics.checkNotNullExpressionValue(str, "m.name");
                    String str2 = "/";
                    endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str, "/", false, 2, null);
                    if (endsWith$default) {
                        str2 = "";
                    }
                    sb5.append(str2);
                    sb5.append("common.app.js");
                    String sb6 = sb5.toString();
                    if (t.this.wxaPkgFileProvider.d(sb6)) {
                        com.tencent.luggage.wxa.tn.w.d("Luggage.WXA.FULL.AppBrandPageScriptInjectConfig", "useLazyCodeLoadingMode return true, by independent " + sb6);
                        return Boolean.TRUE;
                    }
                }
            }
            com.tencent.luggage.wxa.tn.w.d("Luggage.WXA.FULL.AppBrandPageScriptInjectConfig", "useLazyCodeLoadingMode return false");
            return Boolean.FALSE;
        }
    }

    public t(com.tencent.luggage.wxa.rc.q libFileProvider, com.tencent.luggage.wxa.mc.m wxaPkgFileProvider) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(libFileProvider, "libFileProvider");
        Intrinsics.checkNotNullParameter(wxaPkgFileProvider, "wxaPkgFileProvider");
        this.libFileProvider = libFileProvider;
        this.wxaPkgFileProvider = wxaPkgFileProvider;
        lazy = LazyKt__LazyJVMKt.lazy(new b());
        this.useLazyCodeLoadingMode = lazy;
    }

    public final boolean a() {
        return ((Boolean) this.useLazyCodeLoadingMode.getValue()).booleanValue();
    }
}
