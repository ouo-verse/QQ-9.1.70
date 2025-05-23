package com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl;

import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.b.f;
import com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.c.d;
import com.qq.e.comm.util.GDTLogger;
import nt.e;
import nt.h;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final String f40043a;

    /* renamed from: b, reason: collision with root package name */
    private final String f40044b;

    /* renamed from: c, reason: collision with root package name */
    private final LoadAdParams f40045c;

    public c(String str, String str2, LoadAdParams loadAdParams) {
        this.f40043a = str;
        this.f40044b = str2;
        this.f40045c = loadAdParams;
    }

    private e b() {
        f fVar = new f();
        fVar.b(this.f40043a);
        fVar.a(this.f40044b);
        fVar.a(com.qq.e.comm.plugin.tangramsplash.d.a.a(this.f40045c));
        fVar.a(this.f40045c);
        return fVar;
    }

    public void a() {
        h p16 = com.tencent.ams.fusion.service.b.b().p();
        if (p16 == null) {
            GDTLogger.e("FusionAd: \u9884\u52a0\u8f7d\u5931\u8d25\uff0c\u672a\u6ce8\u518cpreloadService");
            return;
        }
        com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.c.a d16 = d.a().d();
        if (d16 == null) {
            GDTLogger.d("FusionAd: \u586b\u5145\u9884\u52a0\u8f7d\u53c2\u6570\u5931\u8d25");
            return;
        }
        d16.a(this.f40043a, this.f40044b, this.f40045c);
        GDTLogger.d("FusionAd: \u5f00\u59cb\u9884\u52a0\u8f7d");
        com.qq.e.comm.plugin.tangramsplash.c.e.a().a(GDTADManager.getInstance().getAppContext(), this.f40044b);
        p16.b(b());
    }
}
