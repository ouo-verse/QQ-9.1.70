package com.tencent.gamecenter.wadl.sdk.common.c.b;

import android.text.TextUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f107069a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f107070b;

    /* renamed from: c, reason: collision with root package name */
    private int f107071c;

    /* renamed from: d, reason: collision with root package name */
    private URL f107072d;

    /* renamed from: e, reason: collision with root package name */
    private String f107073e;

    /* renamed from: f, reason: collision with root package name */
    private int f107074f;

    public b(URL url, String str) {
        boolean z16;
        if (com.tencent.gamecenter.wadl.sdk.common.b.g.a("direct_access_use_schedule", 0, 1, 1) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f107069a = z16;
        this.f107070b = com.tencent.gamecenter.wadl.sdk.common.b.g.a("direct_https_use_sche", 0, 1, 1) == 1;
        this.f107071c = com.tencent.gamecenter.wadl.sdk.common.b.g.a("direct_access_domain_try_times", 1, 8, 2);
        this.f107072d = url;
        this.f107073e = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(com.tencent.gamecenter.wadl.sdk.common.b.a aVar) {
        StringBuilder sb5;
        int i3;
        String file;
        String ref;
        if (aVar.a()) {
            return this.f107073e;
        }
        if (!this.f107072d.getProtocol().startsWith("https")) {
            sb5 = new StringBuilder();
            sb5.append("http://");
            sb5.append(aVar.f106997a);
            sb5.append(":");
            i3 = aVar.f106998b;
        } else {
            if (this.f107074f == 0) {
                sb5 = new StringBuilder();
                sb5.append("https://");
                sb5.append(aVar.f106997a);
                sb5.append(":443");
                String sb6 = sb5.toString();
                file = this.f107072d.getFile();
                if (!TextUtils.isEmpty(file)) {
                    if (file.startsWith("/")) {
                        sb6 = sb6 + file;
                    } else {
                        sb6 = sb6 + "/" + file;
                    }
                }
                ref = this.f107072d.getRef();
                if (!TextUtils.isEmpty(ref)) {
                    return sb6;
                }
                return sb6 + "#" + ref;
            }
            sb5 = new StringBuilder();
            sb5.append("https://");
            sb5.append(aVar.f106997a);
            sb5.append(":");
            i3 = this.f107074f;
        }
        sb5.append(i3);
        String sb62 = sb5.toString();
        file = this.f107072d.getFile();
        if (!TextUtils.isEmpty(file)) {
        }
        ref = this.f107072d.getRef();
        if (!TextUtils.isEmpty(ref)) {
        }
    }

    public List<com.tencent.gamecenter.wadl.sdk.common.b.a> a(com.tencent.gamecenter.wadl.sdk.common.c.a aVar, boolean z16, boolean z17) {
        com.tencent.gamecenter.wadl.sdk.common.b.a aVar2 = new com.tencent.gamecenter.wadl.sdk.common.b.a(this.f107072d.getHost(), -1);
        aVar2.a((byte) 3);
        try {
            ArrayList arrayList = new ArrayList();
            if (!z16) {
                arrayList.add(aVar2);
                return arrayList;
            }
            if (!com.tencent.gamecenter.wadl.sdk.common.b.c.k() && this.f107069a && (!z17 || this.f107070b)) {
                com.tencent.gamecenter.wadl.sdk.common.b.k.c a16 = aVar.a(this.f107072d.getHost());
                List<com.tencent.gamecenter.wadl.sdk.common.b.a> list = a16.f107057c;
                this.f107074f = a16.f107058d;
                return list;
            }
            for (int i3 = 0; i3 < this.f107071c; i3++) {
                arrayList.add(aVar2);
            }
            com.tencent.gamecenter.wadl.sdk.common.b.c.k();
            return arrayList;
        } catch (Exception unused) {
            ArrayList arrayList2 = new ArrayList();
            for (int i16 = 0; i16 < this.f107071c; i16++) {
                arrayList2.add(aVar2);
            }
            return arrayList2;
        }
    }
}
