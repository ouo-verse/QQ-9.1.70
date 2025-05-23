package com.tencent.luggage.wxa.t1;

import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.tencent.luggage.wxa.i.d;
import com.tencent.luggage.wxa.rc.l;
import com.tencent.luggage.wxa.rc.r;
import com.tencent.luggage.wxa.t1.d;
import com.tencent.luggage.wxa.tk.i;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.R;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends d {

    /* renamed from: a, reason: collision with root package name */
    public final r f140828a;

    /* renamed from: b, reason: collision with root package name */
    public final String f140829b;

    public a(d.b bVar) {
        super(bVar);
        this.f140829b = bVar.b();
        this.f140828a = bVar.getFileSystem();
    }

    @Override // com.tencent.luggage.wxa.i.d
    public String a() {
        return "appbrand_file";
    }

    @Override // com.tencent.luggage.wxa.i.d
    public boolean accept(Object obj) {
        return true;
    }

    @Override // com.tencent.luggage.wxa.i.d
    public d.a a(Object obj, ImageDecodeConfig imageDecodeConfig) {
        d.a aVar = new d.a();
        String str = (String) obj;
        if (this.f140828a == null) {
            w.b("MicroMsg.AppBrandFileSystemImageStreamFetcher", "fetch %s, appId[%s] fs NULL", str, this.f140829b);
            aVar.f129190b = z.c().getString(R.string.z36);
            return aVar;
        }
        i iVar = new i();
        l readFile = this.f140828a.readFile(str, iVar);
        if (readFile == l.OK && iVar.f141499a != null) {
            aVar.f129189a = new com.tencent.luggage.wxa.h6.a((ByteBuffer) iVar.f141499a);
        } else {
            w.b("MicroMsg.AppBrandFileSystemImageStreamFetcher", "fetch %s, ret %s, appId[%s]", str, readFile.name(), this.f140829b);
            aVar.f129190b = String.format(z.c().getString(R.string.f170394z35), readFile.name());
        }
        return aVar;
    }
}
