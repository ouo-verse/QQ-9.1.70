package com.tencent.luggage.wxa.yg;

import android.net.Uri;
import com.tencent.luggage.wxa.l0.g;
import com.tencent.luggage.wxa.l0.i;
import com.tencent.luggage.wxa.l0.j;
import java.io.FilterInputStream;
import java.io.InputStream;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class a extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    public static final C6956a f145780a = new C6956a(null);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.yg.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C6956a {
        public C6956a() {
        }

        public /* synthetic */ C6956a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(Uri uri) {
            String scheme = uri.getScheme();
            return Intrinsics.areEqual("http", scheme) || Intrinsics.areEqual("https", scheme);
        }
    }

    public /* synthetic */ a(g gVar, Uri uri, InputStream inputStream, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(gVar, uri, (i3 & 4) != 0 ? f145780a.a(uri) ? new b(gVar, uri) : new i(gVar, new j(uri)) : inputStream);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(g dataSource, Uri uri, InputStream realInputStream) {
        super(realInputStream);
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(realInputStream, "realInputStream");
    }
}
