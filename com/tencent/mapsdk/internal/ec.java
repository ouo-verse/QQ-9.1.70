package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetResponse;
import java.io.File;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ec extends eb {

    /* renamed from: a, reason: collision with root package name */
    private String f148143a;

    /* renamed from: b, reason: collision with root package name */
    private String f148144b;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a extends NetResponse {

        /* renamed from: a, reason: collision with root package name */
        private File f148145a;

        public a(NetResponse netResponse, String str, String str2) {
            clone(netResponse);
            if (netResponse.available()) {
                this.f148145a = new File(str, str2);
                File file = new File(str, str2 + ".tmp");
                kt.b(file);
                if (kt.a(file) && kt.a(file, netResponse.data) && kt.a(file, this.f148145a)) {
                    kt.b(file);
                }
            }
        }

        private File a() {
            return this.f148145a;
        }

        @Override // com.tencent.map.tools.net.NetResponse
        public final boolean available() {
            File file;
            if (super.available() && (file = this.f148145a) != null && file.exists()) {
                return true;
            }
            return false;
        }
    }

    public ec(String str) {
        this.f148143a = str;
    }

    private a b(NetResponse netResponse) {
        return new a(netResponse, this.f148144b, this.f148143a);
    }

    @Override // com.tencent.mapsdk.internal.eb, com.tencent.mapsdk.internal.ef
    public final Object[] a(int[] iArr, Object[] objArr) {
        if (objArr != null && iArr != null && iArr.length == 1 && objArr.length > 0) {
            Object obj = objArr[iArr[0]];
            if (obj instanceof String) {
                this.f148144b = String.valueOf(obj);
            }
        }
        return super.a(iArr, objArr);
    }

    @Override // com.tencent.mapsdk.internal.eb, com.tencent.mapsdk.internal.ef
    public final /* synthetic */ NetResponse a(NetResponse netResponse) {
        return new a(netResponse, this.f148144b, this.f148143a);
    }
}
