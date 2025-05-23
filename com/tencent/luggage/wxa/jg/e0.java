package com.tencent.luggage.wxa.jg;

import com.tencent.luggage.wxa.uk.n0;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e0 implements c0 {

    /* renamed from: b, reason: collision with root package name */
    public static final a f131075b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f131076a = "windowInfo";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void a(com.tencent.luggage.wxa.ic.d component, Map outRes) {
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(outRes, "outRes");
    }

    public String a() {
        return this.f131076a;
    }

    @Override // com.tencent.luggage.wxa.jg.f
    public Map a(String type, com.tencent.luggage.wxa.ic.d component) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(component, "component");
        HashMap hashMap = new HashMap();
        hashMap.put("pixelRatio", Float.valueOf(com.tencent.luggage.wxa.tk.g.a(component.getContext())));
        int[] a16 = n0.a((com.tencent.luggage.wxa.xd.i) component);
        int i3 = a16[0];
        int i16 = a16[1];
        hashMap.put("screenWidth", Integer.valueOf(com.tencent.luggage.wxa.tk.g.a(component.getContext(), i3)));
        hashMap.put("screenHeight", Integer.valueOf(com.tencent.luggage.wxa.tk.g.a(component.getContext(), i16)));
        o.a(hashMap, component, i3, i16);
        hashMap.put("statusBarHeight", Integer.valueOf(com.tencent.luggage.wxa.tk.g.a(component.getContext(), o.b(component))));
        int[] b16 = n0.b(component);
        int i17 = b16[0];
        int i18 = b16[1];
        hashMap.put("windowWidth", Integer.valueOf(com.tencent.luggage.wxa.tk.g.a(component.getContext(), i17)));
        hashMap.put("windowHeight", Integer.valueOf(com.tencent.luggage.wxa.tk.g.a(component.getContext(), i18)));
        hashMap.put("screenTop", Integer.valueOf(com.tencent.luggage.wxa.tk.g.a(component.getContext(), n0.c((com.tencent.luggage.wxa.xd.i) component))));
        a(component, hashMap);
        return hashMap;
    }
}
