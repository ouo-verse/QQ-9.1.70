package com.tencent.luggage.wxa.zg;

import android.net.Uri;
import com.tencent.luggage.wxa.l0.g;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import java.io.InputStream;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class d implements l {

    /* renamed from: a, reason: collision with root package name */
    public static final d f146629a = new d();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.mg.i f146630a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Uri f146631b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(com.tencent.luggage.wxa.mg.i iVar, Uri uri) {
            super(1);
            this.f146630a = iVar;
            this.f146631b = uri;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InputStream invoke(String it) {
            com.tencent.luggage.wxa.l0.g createDataSource;
            g.a n3;
            Intrinsics.checkNotNullParameter(it, "it");
            if (c.b()) {
                com.tencent.luggage.wxa.mg.i iVar = this.f146630a;
                if (iVar != null && (n3 = iVar.n()) != null) {
                    createDataSource = n3.createDataSource();
                } else {
                    createDataSource = null;
                }
                if (createDataSource == null) {
                    return null;
                }
            } else {
                createDataSource = k.a(z.c()).createDataSource();
            }
            com.tencent.luggage.wxa.l0.g dataSource = createDataSource;
            if (com.tencent.luggage.wxa.xg.f.b()) {
                Intrinsics.checkNotNullExpressionValue(dataSource, "dataSource");
                return new com.tencent.luggage.wxa.yg.a(dataSource, this.f146631b, null, 4, null);
            }
            return new com.tencent.luggage.wxa.l0.i(dataSource, new com.tencent.luggage.wxa.l0.j(this.f146631b));
        }
    }

    @Override // com.tencent.luggage.wxa.zg.l
    public int a(com.tencent.luggage.wxa.mg.i iVar, Uri uri) {
        w.d("MicroMsg.ExoContentTypeInferer", "infer#ContentContentTypeInferer3, uri: " + uri);
        int i3 = 3;
        if (uri == null) {
            return 3;
        }
        com.tencent.luggage.wxa.xg.c cVar = new com.tencent.luggage.wxa.xg.c(new a(iVar, uri));
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
        if (cVar.a(uri2)) {
            i3 = 2;
        }
        w.d("MicroMsg.ExoContentTypeInferer", "infer#ContentContentTypeInferer3, type: " + i3);
        return i3;
    }
}
