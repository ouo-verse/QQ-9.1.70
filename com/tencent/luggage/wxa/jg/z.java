package com.tencent.luggage.wxa.jg;

import com.tencent.qqmini.sdk.core.MiniAppConst;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class z implements c0 {

    /* renamed from: b, reason: collision with root package name */
    public static final a f131146b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f131147a = "appBaseInfo";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public String a() {
        return this.f131147a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0060, code lost:
    
        if (r0.k() == true) goto L10;
     */
    @Override // com.tencent.luggage.wxa.jg.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Map a(String type, com.tencent.luggage.wxa.ic.d component) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(component, "component");
        HashMap hashMap = new HashMap();
        o.a(hashMap, component);
        String a16 = com.tencent.luggage.wxa.tn.u.a(component.getContext());
        Intrinsics.checkNotNullExpressionValue(a16, "getCurrentLanguage(component.context)");
        hashMap.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, a16);
        String b16 = com.tencent.luggage.wxa.tn.u.b(component.getContext());
        Intrinsics.checkNotNullExpressionValue(b16, "loadTranslateLanguageSet\u2026s(component.getContext())");
        hashMap.put("translateLanguage", b16);
        String a17 = com.tencent.luggage.wxa.tn.f.a(null, com.tencent.luggage.wxa.tn.e.f141563e);
        Intrinsics.checkNotNullExpressionValue(a17, "formatVersion(null, BuildInfo.CLIENT_VERSION_INT)");
        hashMap.put("version", a17);
        com.tencent.luggage.wxa.ic.g runtime = component.getRuntime();
        boolean z16 = (runtime == null || (r0 = runtime.E()) == null) ? false : true;
        if (z16) {
            hashMap.put("theme", com.tencent.luggage.wxa.h6.l.f126905a.a(component.getAppId()) ? MiniAppConst.MENU_STYLE_DARK : MiniAppConst.MENU_STYLE_LIGHT);
        }
        return hashMap;
    }
}
