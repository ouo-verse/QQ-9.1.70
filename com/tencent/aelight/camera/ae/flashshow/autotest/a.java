package com.tencent.aelight.camera.ae.flashshow.autotest;

import com.tencent.ttpic.openapi.config.BeautyRealConfig;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import hq.a;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private List<a.C10462a> f64137b;

    /* renamed from: d, reason: collision with root package name */
    private InterfaceC0552a f64139d;

    /* renamed from: a, reason: collision with root package name */
    private h f64136a = null;

    /* renamed from: c, reason: collision with root package name */
    private int f64138c = 0;

    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.ae.flashshow.autotest.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public interface InterfaceC0552a {
        void a(String str, int i3);

        VideoMaterial b(String str);

        void c(String str, int i3);

        void d(String str, int i3);

        void e(VideoMaterial videoMaterial, int i3);

        void f(String str);

        void g(String str, int i3, int i16);

        void h(BeautyRealConfig.TYPE type, int i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(List<a.C10462a> list) {
        this.f64137b = list;
    }

    public String a() {
        if (this.f64136a == null) {
            List<a.C10462a> list = this.f64137b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            int i3 = this.f64138c;
            if (size <= i3 || this.f64137b.get(i3) == null) {
                return null;
            }
            h hVar = new h(this.f64137b.get(this.f64138c));
            this.f64136a = hVar;
            hVar.m(this.f64139d);
        }
        return this.f64136a.a();
    }

    public boolean b() {
        h hVar = this.f64136a;
        return hVar != null && hVar.i();
    }

    public boolean c() {
        return this.f64136a == null;
    }

    public void d(InterfaceC0552a interfaceC0552a) {
        this.f64139d = interfaceC0552a;
    }

    public void e(int i3, int i16, int i17) {
        h hVar = this.f64136a;
        if (hVar == null) {
            return;
        }
        if (hVar.l()) {
            this.f64136a.m(null);
            this.f64136a = null;
            this.f64138c++;
        } else {
            this.f64136a.n();
            if (!this.f64136a.k() || this.f64136a.b() == null) {
                return;
            }
            c.f64158a.b(i3, i16, i17, this.f64136a.b());
        }
    }
}
