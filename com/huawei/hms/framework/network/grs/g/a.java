package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.net.Uri;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    protected d f36962a;

    /* renamed from: b, reason: collision with root package name */
    private final String f36963b;

    /* renamed from: c, reason: collision with root package name */
    private final c f36964c;

    /* renamed from: d, reason: collision with root package name */
    private final int f36965d;

    /* renamed from: e, reason: collision with root package name */
    private final Context f36966e;

    /* renamed from: f, reason: collision with root package name */
    private final String f36967f;

    /* renamed from: g, reason: collision with root package name */
    private final GrsBaseInfo f36968g;

    /* renamed from: h, reason: collision with root package name */
    private final com.huawei.hms.framework.network.grs.e.c f36969h;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.huawei.hms.framework.network.grs.g.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public enum EnumC0260a {
        GRSPOST,
        GRSGET,
        GRSDEFAULT
    }

    public a(String str, int i3, c cVar, Context context, String str2, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.c cVar2) {
        this.f36963b = str;
        this.f36964c = cVar;
        this.f36965d = i3;
        this.f36966e = context;
        this.f36967f = str2;
        this.f36968g = grsBaseInfo;
        this.f36969h = cVar2;
    }

    private EnumC0260a h() {
        if (this.f36963b.isEmpty()) {
            return EnumC0260a.GRSDEFAULT;
        }
        String a16 = a(this.f36963b);
        if (a16.contains("1.0")) {
            return EnumC0260a.GRSGET;
        }
        if (a16.contains(SemanticAttributes.HttpFlavorValues.HTTP_2_0)) {
            return EnumC0260a.GRSPOST;
        }
        return EnumC0260a.GRSDEFAULT;
    }

    public Context a() {
        return this.f36966e;
    }

    public c b() {
        return this.f36964c;
    }

    public String c() {
        return this.f36963b;
    }

    public int d() {
        return this.f36965d;
    }

    public String e() {
        return this.f36967f;
    }

    public com.huawei.hms.framework.network.grs.e.c f() {
        return this.f36969h;
    }

    public Callable<d> g() {
        if (EnumC0260a.GRSDEFAULT.equals(h())) {
            return null;
        }
        if (EnumC0260a.GRSGET.equals(h())) {
            return new f(this.f36963b, this.f36965d, this.f36964c, this.f36966e, this.f36967f, this.f36968g);
        }
        return new g(this.f36963b, this.f36965d, this.f36964c, this.f36966e, this.f36967f, this.f36968g, this.f36969h);
    }

    private String a(String str) {
        return Uri.parse(str).getPath();
    }
}
