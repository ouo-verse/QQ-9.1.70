package com.tencent.luggage.wxa.l1;

import android.content.Context;
import android.graphics.Point;
import android.view.Surface;
import com.tencent.luggage.wxa.k.q;
import com.tencent.luggage.wxa.l1.d;
import com.tencent.luggage.wxa.m1.c;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h extends e {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements c.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.InterfaceC6416d f132948a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ByteBuffer f132949b;

        public a(d.InterfaceC6416d interfaceC6416d, ByteBuffer byteBuffer) {
            this.f132948a = interfaceC6416d;
            this.f132949b = byteBuffer;
        }

        @Override // com.tencent.luggage.wxa.m1.c.a
        public ByteBuffer a() {
            return this.f132949b;
        }

        @Override // com.tencent.luggage.wxa.m1.c.a
        public void b() {
            d.InterfaceC6416d interfaceC6416d = this.f132948a;
            if (interfaceC6416d != null) {
                interfaceC6416d.a();
            }
        }
    }

    public h(Context context, Surface surface, int i3, int i16) {
        this.f132924a = new com.tencent.luggage.wxa.k.h(context, surface, i3, i16);
        m();
    }

    @Override // com.tencent.luggage.wxa.l1.e, com.tencent.luggage.wxa.l1.d
    public void a(ByteBuffer byteBuffer, d.InterfaceC6416d interfaceC6416d) {
        if (interfaceC6416d == null && byteBuffer == null) {
            i iVar = this.f132938o;
            if (iVar != null) {
                iVar.a();
                this.f132938o = null;
                return;
            }
            return;
        }
        if (this.f132938o == null) {
            this.f132938o = new com.tencent.luggage.wxa.m1.a();
            q previewSize = this.f132924a.getPreviewSize();
            Point e16 = e();
            ((com.tencent.luggage.wxa.m1.a) this.f132938o).a(previewSize.b(), previewSize.a(), a(), e16.x, e16.y);
            ((com.tencent.luggage.wxa.m1.a) this.f132938o).a(new a(interfaceC6416d, byteBuffer));
            ((com.tencent.luggage.wxa.m1.a) this.f132938o).a(this.f132924a.getEglContext());
        }
    }

    @Override // com.tencent.luggage.wxa.l1.e
    public void o() {
        super.o();
        q previewSize = this.f132924a.getPreviewSize();
        Point e16 = e();
        i iVar = this.f132938o;
        if (iVar instanceof com.tencent.luggage.wxa.m1.a) {
            ((com.tencent.luggage.wxa.m1.a) iVar).a(previewSize.b(), previewSize.a(), com.tencent.luggage.wxa.l.b.a(a()), e16.x, e16.y);
        }
    }

    @Override // com.tencent.luggage.wxa.l1.e
    public void a(com.tencent.luggage.wxa.k.h hVar, byte[] bArr, int i3, int i16, int i17) {
        i iVar = this.f132938o;
        if (iVar instanceof com.tencent.luggage.wxa.m1.a) {
            ((com.tencent.luggage.wxa.m1.a) iVar).a(bArr, i17);
        }
        d.a aVar = this.f132935l;
        if (aVar != null) {
            aVar.a(bArr, i3, i16);
        }
    }
}
